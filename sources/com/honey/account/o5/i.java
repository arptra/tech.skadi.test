package com.honey.account.o5;

import com.upuphone.runasone.ble.BleAbility;
import com.upuphone.runasone.ble.InitSessionCallback;
import com.upuphone.runasone.ble.SessionConfig;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleAbility f5002a;
    public final /* synthetic */ String b;
    public final /* synthetic */ SessionConfig c;
    public final /* synthetic */ InitSessionCallback d;

    public /* synthetic */ i(BleAbility bleAbility, String str, SessionConfig sessionConfig, InitSessionCallback initSessionCallback) {
        this.f5002a = bleAbility;
        this.b = str;
        this.c = sessionConfig;
        this.d = initSessionCallback;
    }

    public final void run() {
        this.f5002a.lambda$initSession$7(this.b, this.c, this.d);
    }
}
