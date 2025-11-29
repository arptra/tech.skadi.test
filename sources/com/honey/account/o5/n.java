package com.honey.account.o5;

import com.upuphone.runasone.ble.BleInternalDevice;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleInternalDevice f5007a;

    public /* synthetic */ n(BleInternalDevice bleInternalDevice) {
        this.f5007a = bleInternalDevice;
    }

    public final void run() {
        this.f5007a.lambda$onConnectFail$1();
    }
}
