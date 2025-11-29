package com.honey.account.o5;

import com.upuphone.runasone.ble.DeviceCallbackAdapter;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceCallbackAdapter f5011a;
    public final /* synthetic */ int b;

    public /* synthetic */ r(DeviceCallbackAdapter deviceCallbackAdapter, int i) {
        this.f5011a = deviceCallbackAdapter;
        this.b = i;
    }

    public final void run() {
        this.f5011a.lambda$adapt$3(this.b);
    }
}
