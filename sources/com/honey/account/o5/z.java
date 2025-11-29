package com.honey.account.o5;

import com.upuphone.runasone.ble.MtuCallbackAdapter;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MtuCallbackAdapter f5019a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ z(MtuCallbackAdapter mtuCallbackAdapter, int i, int i2) {
        this.f5019a = mtuCallbackAdapter;
        this.b = i;
        this.c = i2;
    }

    public final void run() {
        this.f5019a.lambda$adapt$0(this.b, this.c);
    }
}
