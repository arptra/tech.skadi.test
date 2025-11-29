package com.honey.account.o5;

import com.upuphone.runasone.ble.BleAbility;
import com.upuphone.runasone.ble.ReadCallback;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleAbility f4998a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ReadCallback d;

    public /* synthetic */ e(BleAbility bleAbility, String str, String str2, ReadCallback readCallback) {
        this.f4998a = bleAbility;
        this.b = str;
        this.c = str2;
        this.d = readCallback;
    }

    public final void run() {
        this.f4998a.lambda$read$9(this.b, this.c, this.d);
    }
}
