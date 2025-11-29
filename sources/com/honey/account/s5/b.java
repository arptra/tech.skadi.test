package com.honey.account.s5;

import com.upuphone.runasone.channel.linker.websocket.client.WsClient;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WsClient f5127a;

    public /* synthetic */ b(WsClient wsClient) {
        this.f5127a = wsClient;
    }

    public final void run() {
        this.f5127a.lambda$startQosTask$3();
    }
}
