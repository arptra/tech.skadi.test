package com.honey.account.o5;

import com.upuphone.runasone.ble.BleAbility;
import com.upuphone.runasone.ble.OpenNotifyCallback;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleAbility f4990a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ OpenNotifyCallback d;

    public /* synthetic */ a(BleAbility bleAbility, String str, String str2, OpenNotifyCallback openNotifyCallback) {
        this.f4990a = bleAbility;
        this.b = str;
        this.c = str2;
        this.d = openNotifyCallback;
    }

    public final void run() {
        this.f4990a.lambda$openNotify$10(this.b, this.c, this.d);
    }
}
