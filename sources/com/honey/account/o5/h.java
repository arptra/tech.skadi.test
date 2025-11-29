package com.honey.account.o5;

import com.upuphone.runasone.ble.BleAbility;
import com.upuphone.runasone.ble.WriteCallback;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleAbility f5001a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ byte[] d;
    public final /* synthetic */ WriteCallback e;

    public /* synthetic */ h(BleAbility bleAbility, String str, String str2, byte[] bArr, WriteCallback writeCallback) {
        this.f5001a = bleAbility;
        this.b = str;
        this.c = str2;
        this.d = bArr;
        this.e = writeCallback;
    }

    public final void run() {
        this.f5001a.lambda$write$8(this.b, this.c, this.d, this.e);
    }
}
