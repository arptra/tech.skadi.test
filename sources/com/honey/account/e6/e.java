package com.honey.account.e6;

import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.RelayCallbackAdapter;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RelayCallbackAdapter f4355a;
    public final /* synthetic */ StarryTag b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ StarryParam e;

    public /* synthetic */ e(RelayCallbackAdapter relayCallbackAdapter, StarryTag starryTag, int i, String str, StarryParam starryParam) {
        this.f4355a = relayCallbackAdapter;
        this.b = starryTag;
        this.c = i;
        this.d = str;
        this.e = starryParam;
    }

    public final void run() {
        this.f4355a.lambda$adapt$3(this.b, this.c, this.d, this.e);
    }
}
