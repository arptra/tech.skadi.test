package com.honey.account.z5;

import com.upuphone.runasone.core.api.device.IDeviceConnectCallbackAdapter;
import com.upuphone.runasone.device.StarryDevice;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDeviceConnectCallbackAdapter f5339a;
    public final /* synthetic */ StarryDevice b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ a(IDeviceConnectCallbackAdapter iDeviceConnectCallbackAdapter, StarryDevice starryDevice, int i, int i2) {
        this.f5339a = iDeviceConnectCallbackAdapter;
        this.b = starryDevice;
        this.c = i;
        this.d = i2;
    }

    public final void run() {
        this.f5339a.lambda$adapt$0(this.b, this.c, this.d);
    }
}
