package com.honey.account.c;

import android.window.OnBackInvokedCallback;
import androidx.activity.OnBackPressedDispatcher;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class l implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f3021a;

    public /* synthetic */ l(Function0 function0) {
        this.f3021a = function0;
    }

    public final void onBackInvoked() {
        OnBackPressedDispatcher.Api33Impl.c(this.f3021a);
    }
}
