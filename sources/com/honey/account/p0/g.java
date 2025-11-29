package com.honey.account.p0;

import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.futures.SettableFuture;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkForegroundRunnable f3075a;
    public final /* synthetic */ SettableFuture b;

    public /* synthetic */ g(WorkForegroundRunnable workForegroundRunnable, SettableFuture settableFuture) {
        this.f3075a = workForegroundRunnable;
        this.b = settableFuture;
    }

    public final void run() {
        this.f3075a.c(this.b);
    }
}
