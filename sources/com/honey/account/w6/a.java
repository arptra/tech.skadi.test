package com.honey.account.w6;

import com.upuphone.starrynet.core.ble.manager.BleDataDispatcher;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleDataDispatcher f5293a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;
    public final /* synthetic */ byte[] d;

    public /* synthetic */ a(BleDataDispatcher bleDataDispatcher, boolean z, int i, byte[] bArr) {
        this.f5293a = bleDataDispatcher;
        this.b = z;
        this.c = i;
        this.d = bArr;
    }

    public final void run() {
        this.f5293a.lambda$stickyDoneWithData$0(this.b, this.c, this.d);
    }
}
