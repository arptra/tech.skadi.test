package com.honey.account.z5;

import com.upuphone.runasone.core.api.device.IDeviceConnectCallbackAdapter;
import com.upuphone.runasone.device.StarryDevice;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDeviceConnectCallbackAdapter f5343a;
    public final /* synthetic */ StarryDevice b;
    public final /* synthetic */ byte[] c;
    public final /* synthetic */ int d;

    public /* synthetic */ e(IDeviceConnectCallbackAdapter iDeviceConnectCallbackAdapter, StarryDevice starryDevice, byte[] bArr, int i) {
        this.f5343a = iDeviceConnectCallbackAdapter;
        this.b = starryDevice;
        this.c = bArr;
        this.d = i;
    }

    public final void run() {
        this.f5343a.lambda$adapt$4(this.b, this.c, this.d);
    }
}
