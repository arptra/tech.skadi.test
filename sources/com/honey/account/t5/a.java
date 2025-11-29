package com.honey.account.t5;

import com.upuphone.runasone.channel.linker.websocket.server.WsServer;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WsServer f5149a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(WsServer wsServer, int i) {
        this.f5149a = wsServer;
        this.b = i;
    }

    public final void run() {
        this.f5149a.lambda$initWebSocketServer$0(this.b);
    }
}
