package com.honey.account.nb;

import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.android.HandlerContext;

public final /* synthetic */ class a implements DisposableHandle {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HandlerContext f3679a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ a(HandlerContext handlerContext, Runnable runnable) {
        this.f3679a = handlerContext;
        this.b = runnable;
    }

    public final void dispose() {
        HandlerContext.invokeOnTimeout$lambda$3(this.f3679a, this.b);
    }
}
