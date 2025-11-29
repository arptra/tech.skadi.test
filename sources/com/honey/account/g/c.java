package com.honey.account.g;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class c implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f3053a;

    public /* synthetic */ c(Runnable runnable) {
        this.f3053a = runnable;
    }

    public final void onBackInvoked() {
        this.f3053a.run();
    }
}
