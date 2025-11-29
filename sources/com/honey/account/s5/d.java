package com.honey.account.s5;

import com.upuphone.runasone.channel.linker.websocket.client.WsClient;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WsClient f5129a;
    public final /* synthetic */ String b;

    public /* synthetic */ d(WsClient wsClient, String str) {
        this.f5129a = wsClient;
        this.b = str;
    }

    public final void run() {
        this.f5129a.lambda$sendSelfInfoOrAuth$1(this.b);
    }
}
