package com.upuphone.runasone.channel;

import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.io.Port;
import com.upuphone.runasone.io.engine.DefaultActor;
import com.upuphone.runasone.io.engine.message.Message;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.utils.LogUtil;

public class ChannelActor {
    /* access modifiers changed from: private */
    public IChannelActor mIActor;
    private String mId;
    private Port mInputPort;

    public class InputQueue extends DefaultActor {
        public InputQueue() {
        }

        public void onStartup() {
            LogUtil.d("InputQueue onStartup，输入队列启动: " + getName());
        }

        public void receive(Message message) {
            if (ChannelActor.this.mIActor != null) {
                ChannelMessage channelMessage = (ChannelMessage) message.getData();
                if (channelMessage != null) {
                    ChannelActor.this.mIActor.output(channelMessage);
                } else {
                    LogUtil.e("mIActor is null....");
                }
            }
        }
    }

    public void clearInputPort() {
        Port port = this.mInputPort;
        if (port != null) {
            port.clearAllMessage();
        }
    }

    public void injection(ChannelMessage channelMessage) {
        Port port = this.mInputPort;
        if (port == null) {
            return;
        }
        if (channelMessage.getQos() == QosLevel.QOS_3) {
            this.mIActor.output(channelMessage);
        } else {
            port.write(channelMessage);
        }
    }

    public void installInputPort(IChannelActor iChannelActor, String str) {
        this.mId = str;
        LogUtil.d("installInputPort for Channel <" + this.mId + ">");
        this.mIActor = iChannelActor;
        Port port = new Port();
        this.mInputPort = port;
        InputQueue inputQueue = new InputQueue();
        port.open(inputQueue, "channel-actor-" + this.mId);
    }

    public void uninstallInputPort() {
        if (this.mInputPort != null) {
            LogUtil.d("uninstallInputPort for Channel <" + this.mId + ">");
            this.mInputPort.close();
            this.mInputPort = null;
        }
    }
}
