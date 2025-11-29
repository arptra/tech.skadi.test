package com.honey.account.g3;

import com.ucar.protocol.channel.socket.SocketChannel;
import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class h implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SocketChannel f9199a;

    public /* synthetic */ h(SocketChannel socketChannel) {
        this.f9199a = socketChannel;
    }

    public final Thread newThread(Runnable runnable) {
        return this.f9199a.E0(runnable);
    }
}
