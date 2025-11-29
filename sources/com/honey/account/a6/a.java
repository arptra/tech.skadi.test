package com.honey.account.a6;

import com.upuphone.runasone.core.api.discovery.IDiscoveryCallbackAdapter;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDiscoveryCallbackAdapter f4154a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(IDiscoveryCallbackAdapter iDiscoveryCallbackAdapter, int i) {
        this.f4154a = iDiscoveryCallbackAdapter;
        this.b = i;
    }

    public final void run() {
        this.f4154a.lambda$adapt$0(this.b);
    }
}
