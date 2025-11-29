package com.honey.account.a6;

import com.upuphone.runasone.core.api.discovery.IDiscoveryCallbackAdapter;
import com.upuphone.runasone.device.StarryDevice;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDiscoveryCallbackAdapter f4159a;
    public final /* synthetic */ StarryDevice b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ f(IDiscoveryCallbackAdapter iDiscoveryCallbackAdapter, StarryDevice starryDevice, int i, int i2) {
        this.f4159a = iDiscoveryCallbackAdapter;
        this.b = starryDevice;
        this.c = i;
        this.d = i2;
    }

    public final void run() {
        this.f4159a.lambda$adapt$5(this.b, this.c, this.d);
    }
}
