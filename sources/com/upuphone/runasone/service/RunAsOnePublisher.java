package com.upuphone.runasone.service;

import com.google.gson.Gson;
import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.StreamType;
import com.upuphone.runasone.channel.ChannelManagerImpl;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.core.OutputCore;
import com.upuphone.runasone.channel.core.bean.ActionBean;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.starrynet.api.IPublisher;
import java.util.Base64;

public class RunAsOnePublisher implements IPublisher {
    public static final String TAG = "RunAsOnePublisher";

    public boolean isCanPublish(String str) {
        IChannel findChannelById = ChannelManagerImpl.getInstance().findChannelById(str);
        boolean z = findChannelById != null && findChannelById.isLinkUp(EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE);
        LogUtil.d(TAG, (Object) "RunAsOnePublisher can publish=" + z);
        return z;
    }

    public boolean publish(String str, byte[] bArr) {
        ActionBean actionBean = new ActionBean();
        actionBean.setActionType(3);
        actionBean.setData(Base64.getEncoder().encodeToString(bArr));
        int sendTo = OutputCore.getInstance().sendTo(str, str, QosLevel.QOS_0, new AbilityMessage(new Gson().toJson((Object) actionBean).getBytes()), StreamType.ACTION);
        LogUtil.d(TAG, (Object) "Published! errorCode=" + sendTo);
        return sendTo == 0;
    }
}
