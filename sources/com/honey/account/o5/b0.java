package com.honey.account.o5;

import com.upuphone.runasone.ble.ReadCallbackAdapter;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReadCallbackAdapter f4993a;
    public final /* synthetic */ int b;
    public final /* synthetic */ byte[] c;

    public /* synthetic */ b0(ReadCallbackAdapter readCallbackAdapter, int i, byte[] bArr) {
        this.f4993a = readCallbackAdapter;
        this.b = i;
        this.c = bArr;
    }

    public final void run() {
        this.f4993a.lambda$adapt$0(this.b, this.c);
    }
}
