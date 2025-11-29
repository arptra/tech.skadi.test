package com.honey.account.s5;

import com.upuphone.runasone.channel.linker.websocket.client.WsClient;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WsClient f5128a;

    public /* synthetic */ c(WsClient wsClient) {
        this.f5128a = wsClient;
    }

    public final void run() {
        this.f5128a.lambda$sendAuth$2();
    }
}
