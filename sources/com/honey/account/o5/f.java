package com.honey.account.o5;

import com.upuphone.runasone.ble.BleAbility;
import com.upuphone.runasone.ble.ConnectConfig;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleAbility f4999a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ConnectConfig c;

    public /* synthetic */ f(BleAbility bleAbility, String str, ConnectConfig connectConfig) {
        this.f4999a = bleAbility;
        this.b = str;
        this.c = connectConfig;
    }

    public final void run() {
        this.f4999a.lambda$connect$5(this.b, this.c);
    }
}
