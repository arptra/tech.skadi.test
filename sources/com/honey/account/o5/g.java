package com.honey.account.o5;

import com.upuphone.runasone.ble.BleAbility;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleAbility f5000a;
    public final /* synthetic */ String b;

    public /* synthetic */ g(BleAbility bleAbility, String str) {
        this.f5000a = bleAbility;
        this.b = str;
    }

    public final void run() {
        this.f5000a.lambda$unregisterDeviceCallback$1(this.b);
    }
}
