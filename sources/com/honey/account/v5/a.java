package com.honey.account.v5;

import com.upuphone.runasone.channel.proxy.client.UDPHandler;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UDPHandler f5281a;
    public final /* synthetic */ DatagramChannel b;
    public final /* synthetic */ ByteBuffer c;
    public final /* synthetic */ InetSocketAddress d;

    public /* synthetic */ a(UDPHandler uDPHandler, DatagramChannel datagramChannel, ByteBuffer byteBuffer, InetSocketAddress inetSocketAddress) {
        this.f5281a = uDPHandler;
        this.b = datagramChannel;
        this.c = byteBuffer;
        this.d = inetSocketAddress;
    }

    public final void run() {
        this.f5281a.lambda$sendToRemote$0(this.b, this.c, this.d);
    }
}
