package com.honey.account.o5;

import com.upuphone.runasone.ble.BleRawSession;
import com.upuphone.runasone.ble.DeviceCallbackAdapter;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceCallbackAdapter f5009a;
    public final /* synthetic */ BleRawSession b;

    public /* synthetic */ p(DeviceCallbackAdapter deviceCallbackAdapter, BleRawSession bleRawSession) {
        this.f5009a = deviceCallbackAdapter;
        this.b = bleRawSession;
    }

    public final void run() {
        this.f5009a.lambda$adapt$1(this.b);
    }
}
