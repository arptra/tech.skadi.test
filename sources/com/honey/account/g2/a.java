package com.honey.account.g2;

import com.honey.account.utils.coroutine.DispatcherHelper$DispatchContext$interceptContinuation$1;
import kotlin.coroutines.Continuation;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Continuation f9191a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Continuation continuation, Object obj) {
        this.f9191a = continuation;
        this.b = obj;
    }

    public final void run() {
        DispatcherHelper$DispatchContext$interceptContinuation$1.resumeWith$lambda$0(this.f9191a, this.b);
    }
}
