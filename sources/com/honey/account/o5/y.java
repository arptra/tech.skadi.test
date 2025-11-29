package com.honey.account.o5;

import com.upuphone.runasone.ble.InitSessionCallbackAdapter;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InitSessionCallbackAdapter f5018a;
    public final /* synthetic */ int b;

    public /* synthetic */ y(InitSessionCallbackAdapter initSessionCallbackAdapter, int i) {
        this.f5018a = initSessionCallbackAdapter;
        this.b = i;
    }

    public final void run() {
        this.f5018a.lambda$adapt$0(this.b);
    }
}
