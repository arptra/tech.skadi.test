package com.upuphone.runasone.channel.core;

import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.StreamType;
import com.upuphone.runasone.channel.ChannelManagerImpl;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;

public final class OutputCore {
    private static final String CORE = "core";
    private static final String TAG = "OutputCore";
    private static OutputCore instance;

    private OutputCore() {
    }

    private static synchronized OutputCore createInstance() {
        OutputCore outputCore;
        synchronized (OutputCore.class) {
            try {
                if (instance == null) {
                    instance = new OutputCore();
                }
                outputCore = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return outputCore;
    }

    public static OutputCore getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    public int sendTo(String str, String str2, QosLevel qosLevel, AbilityMessage abilityMessage, StreamType streamType) {
        String selfId = Utils.getSelfId();
        IChannel findChannelById = ChannelManagerImpl.getInstance().findChannelById(str);
        if (findChannelById != null && findChannelById.isLinkUp()) {
            return findChannelById.output(ChannelMessage.newBuilder().setId(selfId).setQos(qosLevel).setAbilityMessage(abilityMessage).setDstId(str2).setSrcId(selfId).setMessageType(streamType).setCategory("core").build());
        }
        String str3 = TAG;
        LogUtil.e(str3, (Object) "channel <" + str + "> 不存在");
        return Constants.ChannelErrorCode.ERROR_CHANNEL_INVALID;
    }
}
