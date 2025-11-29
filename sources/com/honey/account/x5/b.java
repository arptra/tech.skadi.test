package com.honey.account.x5;

import com.upuphone.runasone.channel.proxy.server.Socks5Server;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public final /* synthetic */ class b implements GenericFutureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Socks5Server f5308a;

    public /* synthetic */ b(Socks5Server socks5Server) {
        this.f5308a = socks5Server;
    }

    public final void operationComplete(Future future) {
        this.f5308a.lambda$start$1(future);
    }
}
