package com.honey.account.z5;

import com.upuphone.runasone.core.api.device.IDeviceConnectCallbackAdapter;
import com.upuphone.runasone.device.StarryDevice;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDeviceConnectCallbackAdapter f5342a;
    public final /* synthetic */ StarryDevice b;

    public /* synthetic */ d(IDeviceConnectCallbackAdapter iDeviceConnectCallbackAdapter, StarryDevice starryDevice) {
        this.f5342a = iDeviceConnectCallbackAdapter;
        this.b = starryDevice;
    }

    public final void run() {
        this.f5342a.lambda$adapt$3(this.b);
    }
}
