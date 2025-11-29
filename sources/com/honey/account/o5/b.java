package com.honey.account.o5;

import com.upuphone.runasone.ble.BleAbility;
import com.upuphone.runasone.ble.MtuCallback;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleAbility f4992a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ MtuCallback d;

    public /* synthetic */ b(BleAbility bleAbility, String str, int i, MtuCallback mtuCallback) {
        this.f4992a = bleAbility;
        this.b = str;
        this.c = i;
        this.d = mtuCallback;
    }

    public final void run() {
        this.f4992a.lambda$setMtu$11(this.b, this.c, this.d);
    }
}
