package com.honey.account.ob;

import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.rx3.SchedulerCoroutineDispatcher;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f3682a;
    public final /* synthetic */ SchedulerCoroutineDispatcher b;

    public /* synthetic */ b(CancellableContinuation cancellableContinuation, SchedulerCoroutineDispatcher schedulerCoroutineDispatcher) {
        this.f3682a = cancellableContinuation;
        this.b = schedulerCoroutineDispatcher;
    }

    public final void run() {
        SchedulerCoroutineDispatcher.q0(this.f3682a, this.b);
    }
}
