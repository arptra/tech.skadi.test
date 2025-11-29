package com.honey.account.m1;

import android.window.OnBackInvokedCallback;
import com.google.android.material.motion.MaterialBackHandler;

public final /* synthetic */ class b implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialBackHandler f9777a;

    public /* synthetic */ b(MaterialBackHandler materialBackHandler) {
        this.f9777a = materialBackHandler;
    }

    public final void onBackInvoked() {
        this.f9777a.handleBackInvoked();
    }
}
