package com.honey.account.z5;

import com.upuphone.runasone.core.api.device.IDeviceConnectCallbackAdapter;
import com.upuphone.runasone.device.StarryDevice;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDeviceConnectCallbackAdapter f5345a;
    public final /* synthetic */ StarryDevice b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ g(IDeviceConnectCallbackAdapter iDeviceConnectCallbackAdapter, StarryDevice starryDevice, boolean z) {
        this.f5345a = iDeviceConnectCallbackAdapter;
        this.b = starryDevice;
        this.c = z;
    }

    public final void run() {
        this.f5345a.lambda$adapt$6(this.b, this.c);
    }
}
