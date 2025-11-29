package com.honey.account.e6;

import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.RelayCallbackAdapter;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RelayCallbackAdapter f4354a;
    public final /* synthetic */ StarryTag b;
    public final /* synthetic */ StarryParam c;

    public /* synthetic */ d(RelayCallbackAdapter relayCallbackAdapter, StarryTag starryTag, StarryParam starryParam) {
        this.f4354a = relayCallbackAdapter;
        this.b = starryTag;
        this.c = starryParam;
    }

    public final void run() {
        this.f4354a.lambda$adapt$2(this.b, this.c);
    }
}
