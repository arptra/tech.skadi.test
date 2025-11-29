package com.honey.account.z5;

import com.upuphone.runasone.core.api.device.IDeviceConnectCallbackAdapter;
import com.upuphone.runasone.device.StarryDevice;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDeviceConnectCallbackAdapter f5340a;
    public final /* synthetic */ StarryDevice b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ b(IDeviceConnectCallbackAdapter iDeviceConnectCallbackAdapter, StarryDevice starryDevice, boolean z) {
        this.f5340a = iDeviceConnectCallbackAdapter;
        this.b = starryDevice;
        this.c = z;
    }

    public final void run() {
        this.f5340a.lambda$adapt$1(this.b, this.c);
    }
}
