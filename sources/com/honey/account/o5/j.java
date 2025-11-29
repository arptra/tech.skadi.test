package com.honey.account.o5;

import com.upuphone.runasone.ble.BleAbility;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleAbility f5003a;
    public final /* synthetic */ String b;

    public /* synthetic */ j(BleAbility bleAbility, String str) {
        this.f5003a = bleAbility;
        this.b = str;
    }

    public final void run() {
        this.f5003a.lambda$disconnect$6(this.b);
    }
}
