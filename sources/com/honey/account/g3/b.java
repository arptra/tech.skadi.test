package com.honey.account.g3;

import com.ucar.protocol.channel.socket.SocketChannel;
import java.util.Map;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SocketChannel f9193a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;

    public /* synthetic */ b(SocketChannel socketChannel, Map map, String str, int i) {
        this.f9193a = socketChannel;
        this.b = map;
        this.c = str;
        this.d = i;
    }

    public final Object call() {
        return this.f9193a.B0(this.b, this.c, this.d);
    }
}
