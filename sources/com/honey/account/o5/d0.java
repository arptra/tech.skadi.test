package com.honey.account.o5;

import com.upuphone.runasone.ble.WriteCallbackAdapter;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WriteCallbackAdapter f4997a;
    public final /* synthetic */ int b;

    public /* synthetic */ d0(WriteCallbackAdapter writeCallbackAdapter, int i) {
        this.f4997a = writeCallbackAdapter;
        this.b = i;
    }

    public final void run() {
        this.f4997a.lambda$adapt$0(this.b);
    }
}
