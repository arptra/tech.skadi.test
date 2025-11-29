package com.upuphone.runasone.ability;

import com.google.gson.Gson;
import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.channel.ChannelManagerImpl;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.bean.auth.AbilityAttributes;
import com.upuphone.runasone.channel.bean.auth.AuthBean;
import com.upuphone.runasone.host.core.api.ComponentProperty;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import com.upuphone.runasone.host.core.api.IStarryNetStackCallback;
import com.upuphone.runasone.io.Port;
import com.upuphone.runasone.io.engine.DefaultActor;
import com.upuphone.runasone.io.engine.message.Message;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.utils.LogUtil;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ActorAgent {
    /* access modifiers changed from: private */
    public static final String TAG = "ActorAgent";
    private EnumAbility ability;
    private CopyOnWriteArrayList<IChannel> mChannelList = new CopyOnWriteArrayList<>();
    private Port mInputPort;
    private IStarryNetStackCallback mPriNetCallback;
    private IAbilitySlot mSlot;
    private EnumLinkStrategy mStrategy;

    public class InputQueue extends DefaultActor {
        public InputQueue() {
        }

        public void onStartup() {
            LogUtil.d("InputQueue onStartup，输入队列启动: " + getName());
        }

        public void receive(Message message) {
            String access$000 = ActorAgent.TAG;
            LogUtil.dPrimary(access$000, getName() + " receive...");
            ActorAgent.this.receiveToCategory((ChannelMessage) message.getData());
        }
    }

    public void bindChannel(IChannel iChannel, IAbilitySlot.SlotObserver slotObserver) {
        ComponentProperty componentProperty;
        AbilityAttributes abilityAttributes;
        Map<String, String> abilityAttributes2;
        if (this.mSlot == null) {
            return;
        }
        if (this.mChannelList.contains(iChannel)) {
            LogUtil.d("Channel <" + iChannel.getDevice().getId() + "> is already attach");
            return;
        }
        AuthBean remoteAuthBean = iChannel.getRemoteAuthBean();
        if (remoteAuthBean == null || (abilityAttributes = remoteAuthBean.getAbilityAttributes()) == null || (abilityAttributes2 = abilityAttributes.getAbilityAttributes()) == null) {
            componentProperty = null;
        } else {
            iChannel.getActiveEnumAbilityList();
            componentProperty = (ComponentProperty) new Gson().fromJson(abilityAttributes2.get(this.ability.getName()), ComponentProperty.class);
        }
        LogUtil.d("channel.getDevice() 1getName :" + this.ability.getName());
        if (EnumAbility.CAST.getName().equals(this.ability.getName())) {
            LogUtil.d("channel.getDevice() :" + iChannel.getDevice());
            LogUtil.d("channel.getDevice() getName :" + this.ability);
            this.mSlot.attach(iChannel.getDevice(), slotObserver, componentProperty, this.mPriNetCallback);
        } else {
            this.mSlot.attach(iChannel.getDevice(), slotObserver, componentProperty);
        }
        this.mChannelList.add(iChannel);
    }

    public void clearInputPort() {
        Port port = this.mInputPort;
        if (port != null) {
            port.clearAllMessage();
        }
    }

    public EnumLinkStrategy getStrategy() {
        return this.mStrategy;
    }

    public void injection(ChannelMessage channelMessage) {
        if (this.mInputPort == null) {
            return;
        }
        if (channelMessage.getQos() == QosLevel.QOS_3) {
            receiveToCategory(channelMessage);
        } else {
            this.mInputPort.write(channelMessage);
        }
    }

    public void installInputPort(EnumAbility enumAbility, IAbilitySlot iAbilitySlot, EnumLinkStrategy enumLinkStrategy) {
        Port port = new Port();
        this.mInputPort = port;
        port.open(new InputQueue(), enumAbility.getName());
        this.mSlot = iAbilitySlot;
        this.mStrategy = enumLinkStrategy;
        this.ability = enumAbility;
    }

    public boolean isBind(IChannel iChannel) {
        if (this.mSlot != null) {
            return this.mChannelList.contains(iChannel);
        }
        return false;
    }

    public void receiveToCategory(ChannelMessage channelMessage) {
        if (this.mSlot != null) {
            IChannel findChannelById = ChannelManagerImpl.getInstance().findChannelById(channelMessage.getId());
            if (findChannelById != null) {
                this.mSlot.input(findChannelById.getDevice(), channelMessage.getAbilityMessage());
                return;
            }
            LogUtil.e("findChannelById <" + channelMessage.getId() + "> is null....");
        }
    }

    public void unbindChannel(IChannel iChannel) {
        if (this.mSlot == null) {
            return;
        }
        if (this.mChannelList.contains(iChannel)) {
            this.mSlot.detach(iChannel.getDevice());
            this.mChannelList.remove(iChannel);
            return;
        }
        LogUtil.e("Channel <" + iChannel.getDevice().getId() + "> must bind at first");
    }

    public void uninstallInputPort() {
        Port port = this.mInputPort;
        if (port != null) {
            port.close();
            this.mInputPort = null;
            this.mSlot = null;
        }
    }
}
