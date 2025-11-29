package com.honey.account.g3;

import com.ucar.protocol.channel.socket.SocketChannel;
import java.util.Map;
import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SocketChannel f9195a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Map d;

    public /* synthetic */ d(SocketChannel socketChannel, String str, int i, Map map) {
        this.f9195a = socketChannel;
        this.b = str;
        this.c = i;
        this.d = map;
    }

    public final Object call() {
        return this.f9195a.F0(this.b, this.c, this.d);
    }
}
