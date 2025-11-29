package com.honey.account.e6;

import com.upuphone.runasone.relay.api.SendRelayMessageCallBackAdapter;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SendRelayMessageCallBackAdapter f4358a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public /* synthetic */ h(SendRelayMessageCallBackAdapter sendRelayMessageCallBackAdapter, int i, String str) {
        this.f4358a = sendRelayMessageCallBackAdapter;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        this.f4358a.lambda$adapt$1(this.b, this.c);
    }
}
