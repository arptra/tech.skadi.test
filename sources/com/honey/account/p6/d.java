package com.honey.account.p6;

import com.upuphone.runasone.uupcast.api.IDisplayListenerAdapter;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDisplayListenerAdapter f5090a;
    public final /* synthetic */ String b;

    public /* synthetic */ d(IDisplayListenerAdapter iDisplayListenerAdapter, String str) {
        this.f5090a = iDisplayListenerAdapter;
        this.b = str;
    }

    public final void run() {
        this.f5090a.lambda$adapt$3(this.b);
    }
}
