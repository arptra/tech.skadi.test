package com.honey.account.a6;

import com.upuphone.runasone.core.api.discovery.IDiscoveryCallbackAdapter;
import com.upuphone.runasone.device.StarryDevice;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDiscoveryCallbackAdapter f4156a;
    public final /* synthetic */ StarryDevice b;

    public /* synthetic */ c(IDiscoveryCallbackAdapter iDiscoveryCallbackAdapter, StarryDevice starryDevice) {
        this.f4156a = iDiscoveryCallbackAdapter;
        this.b = starryDevice;
    }

    public final void run() {
        this.f4156a.lambda$adapt$2(this.b);
    }
}
