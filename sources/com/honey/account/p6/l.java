package com.honey.account.p6;

import com.upuphone.runasone.uupcast.api.ISinkListenerAdapter;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ISinkListenerAdapter f5098a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public /* synthetic */ l(ISinkListenerAdapter iSinkListenerAdapter, int i, String str) {
        this.f5098a = iSinkListenerAdapter;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        this.f5098a.lambda$adapt$3(this.b, this.c);
    }
}
