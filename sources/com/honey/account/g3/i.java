package com.honey.account.g3;

import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.channel.socket.RequestFuture;
import com.ucar.protocol.channel.socket.SocketChannel;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SocketChannel f9200a;
    public final /* synthetic */ UCarMessage b;
    public final /* synthetic */ RequestFuture c;
    public final /* synthetic */ long d;

    public /* synthetic */ i(SocketChannel socketChannel, UCarMessage uCarMessage, RequestFuture requestFuture, long j) {
        this.f9200a = socketChannel;
        this.b = uCarMessage;
        this.c = requestFuture;
        this.d = j;
    }

    public final void run() {
        this.f9200a.z0(this.b, this.c, this.d);
    }
}
