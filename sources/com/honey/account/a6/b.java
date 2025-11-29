package com.honey.account.a6;

import android.os.Bundle;
import com.upuphone.runasone.core.api.discovery.IDiscoveryCallbackAdapter;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDiscoveryCallbackAdapter f4155a;
    public final /* synthetic */ StarryDevice b;
    public final /* synthetic */ byte[] c;
    public final /* synthetic */ Bundle d;
    public final /* synthetic */ DiscoveryFilter e;

    public /* synthetic */ b(IDiscoveryCallbackAdapter iDiscoveryCallbackAdapter, StarryDevice starryDevice, byte[] bArr, Bundle bundle, DiscoveryFilter discoveryFilter) {
        this.f4155a = iDiscoveryCallbackAdapter;
        this.b = starryDevice;
        this.c = bArr;
        this.d = bundle;
        this.e = discoveryFilter;
    }

    public final void run() {
        this.f4155a.lambda$adapt$1(this.b, this.c, this.d, this.e);
    }
}
