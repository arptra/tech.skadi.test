package com.xjmz.myvu.account;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DebugLoginActivity f8228a;
    public final /* synthetic */ MzTokenResult b;

    public /* synthetic */ a(DebugLoginActivity debugLoginActivity, MzTokenResult mzTokenResult) {
        this.f8228a = debugLoginActivity;
        this.b = mzTokenResult;
    }

    public final void run() {
        DebugLoginActivity$onCreate$1$1.invokeSuspend$lambda$1(this.f8228a, this.b);
    }
}
