package com.honey.account.nb;

import android.view.Choreographer;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.android.HandlerDispatcherKt;

public final /* synthetic */ class b implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f3680a;

    public /* synthetic */ b(CancellableContinuation cancellableContinuation) {
        this.f3680a = cancellableContinuation;
    }

    public final void doFrame(long j) {
        HandlerDispatcherKt.postFrameCallback$lambda$6(this.f3680a, j);
    }
}
