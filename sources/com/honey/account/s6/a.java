package com.honey.account.s6;

import com.upuphone.starrynet.core.ble.channel.Channel;
import com.upuphone.starrynet.core.ble.channel.ChannelCallback;
import java.util.List;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Channel f5130a;
    public final /* synthetic */ List b;
    public final /* synthetic */ ChannelCallback c;

    public /* synthetic */ a(Channel channel, List list, ChannelCallback channelCallback) {
        this.f5130a = channel;
        this.b = list;
        this.c = channelCallback;
    }

    public final void run() {
        this.f5130a.lambda$performBatchWrite$1(this.b, this.c);
    }
}
