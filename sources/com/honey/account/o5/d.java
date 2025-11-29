package com.honey.account.o5;

import com.upuphone.runasone.ble.BleAbility;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleAbility f4996a;
    public final /* synthetic */ String b;

    public /* synthetic */ d(BleAbility bleAbility, String str) {
        this.f4996a = bleAbility;
        this.b = str;
    }

    public final void run() {
        this.f4996a.lambda$unregisterSessionCallback$4(this.b);
    }
}
