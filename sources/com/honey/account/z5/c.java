package com.honey.account.z5;

import com.upuphone.runasone.core.api.device.IDeviceConnectCallbackAdapter;
import com.upuphone.runasone.device.StarryDevice;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDeviceConnectCallbackAdapter f5341a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ StarryDevice d;

    public /* synthetic */ c(IDeviceConnectCallbackAdapter iDeviceConnectCallbackAdapter, int i, int i2, StarryDevice starryDevice) {
        this.f5341a = iDeviceConnectCallbackAdapter;
        this.b = i;
        this.c = i2;
        this.d = starryDevice;
    }

    public final void run() {
        this.f5341a.lambda$adapt$2(this.b, this.c, this.d);
    }
}
