package com.honey.account.o5;

import com.upuphone.runasone.ble.OpenNotifyCallbackAdapter;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OpenNotifyCallbackAdapter f4991a;
    public final /* synthetic */ int b;

    public /* synthetic */ a0(OpenNotifyCallbackAdapter openNotifyCallbackAdapter, int i) {
        this.f4991a = openNotifyCallbackAdapter;
        this.b = i;
    }

    public final void run() {
        this.f4991a.lambda$adapt$0(this.b);
    }
}
