package com.honey.account.o5;

import com.upuphone.runasone.ble.SessionCallbackAdapter;

public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SessionCallbackAdapter f4995a;
    public final /* synthetic */ String b;
    public final /* synthetic */ byte[] c;

    public /* synthetic */ c0(SessionCallbackAdapter sessionCallbackAdapter, String str, byte[] bArr) {
        this.f4995a = sessionCallbackAdapter;
        this.b = str;
        this.c = bArr;
    }

    public final void run() {
        this.f4995a.lambda$adapt$0(this.b, this.c);
    }
}
