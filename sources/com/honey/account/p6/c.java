package com.honey.account.p6;

import com.upuphone.runasone.uupcast.api.IDisplayListenerAdapter;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDisplayListenerAdapter f5089a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public /* synthetic */ c(IDisplayListenerAdapter iDisplayListenerAdapter, int i, String str) {
        this.f5089a = iDisplayListenerAdapter;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        this.f5089a.lambda$adapt$2(this.b, this.c);
    }
}
