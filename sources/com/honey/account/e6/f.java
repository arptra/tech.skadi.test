package com.honey.account.e6;

import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.RelayCallbackAdapter;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RelayCallbackAdapter f4356a;
    public final /* synthetic */ StarryTag b;
    public final /* synthetic */ StarryParam c;

    public /* synthetic */ f(RelayCallbackAdapter relayCallbackAdapter, StarryTag starryTag, StarryParam starryParam) {
        this.f4356a = relayCallbackAdapter;
        this.b = starryTag;
        this.c = starryParam;
    }

    public final void run() {
        this.f4356a.lambda$adapt$4(this.b, this.c);
    }
}
