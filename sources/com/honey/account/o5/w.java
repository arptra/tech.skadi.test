package com.honey.account.o5;

import com.upuphone.runasone.ble.GattCallback;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GattCallback f5016a;
    public final /* synthetic */ int b;

    public /* synthetic */ w(GattCallback gattCallback, int i) {
        this.f5016a = gattCallback;
        this.b = i;
    }

    public final void run() {
        this.f5016a.lambda$onCharacteristicWrite$2(this.b);
    }
}
