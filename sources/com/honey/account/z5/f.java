package com.honey.account.z5;

import com.upuphone.runasone.core.api.device.IDeviceConnectCallbackAdapter;
import com.upuphone.runasone.device.StarryDevice;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDeviceConnectCallbackAdapter f5344a;
    public final /* synthetic */ int b;
    public final /* synthetic */ StarryDevice c;
    public final /* synthetic */ int d;

    public /* synthetic */ f(IDeviceConnectCallbackAdapter iDeviceConnectCallbackAdapter, int i, StarryDevice starryDevice, int i2) {
        this.f5344a = iDeviceConnectCallbackAdapter;
        this.b = i;
        this.c = starryDevice;
        this.d = i2;
    }

    public final void run() {
        this.f5344a.lambda$adapt$5(this.b, this.c, this.d);
    }
}
