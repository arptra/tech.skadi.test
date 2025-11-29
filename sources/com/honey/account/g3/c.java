package com.honey.account.g3;

import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.channel.SendFutureCallback;
import com.ucar.protocol.channel.socket.SocketChannel;
import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SocketChannel f9194a;
    public final /* synthetic */ UCarMessage b;
    public final /* synthetic */ SendFutureCallback c;

    public /* synthetic */ c(SocketChannel socketChannel, UCarMessage uCarMessage, SendFutureCallback sendFutureCallback) {
        this.f9194a = socketChannel;
        this.b = uCarMessage;
        this.c = sendFutureCallback;
    }

    public final Object call() {
        return this.f9194a.A0(this.b, this.c);
    }
}
