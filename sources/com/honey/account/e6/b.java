package com.honey.account.e6;

import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.RelayCallbackAdapter;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RelayCallbackAdapter f4352a;
    public final /* synthetic */ StarryTag b;
    public final /* synthetic */ ArrayData c;
    public final /* synthetic */ StarryParam d;

    public /* synthetic */ b(RelayCallbackAdapter relayCallbackAdapter, StarryTag starryTag, ArrayData arrayData, StarryParam starryParam) {
        this.f4352a = relayCallbackAdapter;
        this.b = starryTag;
        this.c = arrayData;
        this.d = starryParam;
    }

    public final void run() {
        this.f4352a.lambda$adapt$0(this.b, this.c, this.d);
    }
}
