package com.honey.account.p6;

import com.upuphone.runasone.uupcast.api.IVirtualDeviceEventListenerAdapter;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IVirtualDeviceEventListenerAdapter f5102a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public /* synthetic */ p(IVirtualDeviceEventListenerAdapter iVirtualDeviceEventListenerAdapter, int i, String str) {
        this.f5102a = iVirtualDeviceEventListenerAdapter;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        this.f5102a.lambda$adapt$1(this.b, this.c);
    }
}
