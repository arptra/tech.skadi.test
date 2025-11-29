package com.honey.account.g3;

import com.ucar.protocol.channel.socket.SocketChannel;
import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class g implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SocketChannel f9198a;

    public /* synthetic */ g(SocketChannel socketChannel) {
        this.f9198a = socketChannel;
    }

    public final Thread newThread(Runnable runnable) {
        return this.f9198a.D0(runnable);
    }
}
