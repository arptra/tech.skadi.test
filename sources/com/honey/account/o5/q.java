package com.honey.account.o5;

import com.upuphone.runasone.ble.DeviceCallbackAdapter;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceCallbackAdapter f5010a;
    public final /* synthetic */ int b;

    public /* synthetic */ q(DeviceCallbackAdapter deviceCallbackAdapter, int i) {
        this.f5010a = deviceCallbackAdapter;
        this.b = i;
    }

    public final void run() {
        this.f5010a.lambda$adapt$2(this.b);
    }
}
