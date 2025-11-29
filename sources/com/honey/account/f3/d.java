package com.honey.account.f3;

import com.ucar.protocol.ProtocolConfig;
import com.ucar.protocol.channel.ChannelType;
import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class d implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChannelType f9190a;

    public /* synthetic */ d(ChannelType channelType) {
        this.f9190a = channelType;
    }

    public final Thread newThread(Runnable runnable) {
        return ProtocolConfig.f(this.f9190a, runnable);
    }
}
