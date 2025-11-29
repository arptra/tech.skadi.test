package com.upuphone.starrynet.core.ble.channel;

import com.upuphone.starrynet.core.ble.channel.Channel;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Channel f6527a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ Channel.WriteCallback c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ a(Channel channel, byte[] bArr, Channel.WriteCallback writeCallback, boolean z) {
        this.f6527a = channel;
        this.b = bArr;
        this.c = writeCallback;
        this.d = z;
    }

    public final void run() {
        this.f6527a.lambda$performWrite$0(this.b, this.c, this.d);
    }
}
