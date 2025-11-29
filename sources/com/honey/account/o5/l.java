package com.honey.account.o5;

import com.upuphone.runasone.ble.BleAbility;
import com.upuphone.runasone.ble.SessionCallback;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleAbility f5005a;
    public final /* synthetic */ String b;
    public final /* synthetic */ SessionCallback c;

    public /* synthetic */ l(BleAbility bleAbility, String str, SessionCallback sessionCallback) {
        this.f5005a = bleAbility;
        this.b = str;
        this.c = sessionCallback;
    }

    public final void run() {
        this.f5005a.lambda$registerSessionCallback$3(this.b, this.c);
    }
}
