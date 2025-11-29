package com.honey.account.o5;

import com.upuphone.runasone.ble.GattCallback;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GattCallback f5012a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ s(GattCallback gattCallback, int i, int i2) {
        this.f5012a = gattCallback;
        this.b = i;
        this.c = i2;
    }

    public final void run() {
        this.f5012a.lambda$onMtuChanged$5(this.b, this.c);
    }
}
