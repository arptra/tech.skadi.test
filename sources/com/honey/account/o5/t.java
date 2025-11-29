package com.honey.account.o5;

import com.upuphone.runasone.ble.GattCallback;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GattCallback f5013a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ int c;

    public /* synthetic */ t(GattCallback gattCallback, byte[] bArr, int i) {
        this.f5013a = gattCallback;
        this.b = bArr;
        this.c = i;
    }

    public final void run() {
        this.f5013a.lambda$onCharacteristicRead$1(this.b, this.c);
    }
}
