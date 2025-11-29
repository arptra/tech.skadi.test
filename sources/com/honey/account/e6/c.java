package com.honey.account.e6;

import com.upuphone.runasone.relay.api.RelayCallbackAdapter;
import java.util.List;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RelayCallbackAdapter f4353a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;

    public /* synthetic */ c(RelayCallbackAdapter relayCallbackAdapter, String str, List list) {
        this.f4353a = relayCallbackAdapter;
        this.b = str;
        this.c = list;
    }

    public final void run() {
        this.f4353a.lambda$adapt$1(this.b, this.c);
    }
}
