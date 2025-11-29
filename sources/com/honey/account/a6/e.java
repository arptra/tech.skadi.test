package com.honey.account.a6;

import com.upuphone.runasone.core.api.discovery.IDiscoveryCallbackAdapter;
import com.upuphone.runasone.device.StarryDevice;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDiscoveryCallbackAdapter f4158a;
    public final /* synthetic */ StarryDevice b;
    public final /* synthetic */ byte[] c;

    public /* synthetic */ e(IDiscoveryCallbackAdapter iDiscoveryCallbackAdapter, StarryDevice starryDevice, byte[] bArr) {
        this.f4158a = iDiscoveryCallbackAdapter;
        this.b = starryDevice;
        this.c = bArr;
    }

    public final void run() {
        this.f4158a.lambda$adapt$4(this.b, this.c);
    }
}
