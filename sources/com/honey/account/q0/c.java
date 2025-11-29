package com.honey.account.q0;

import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConstraintTrackingWorker f3085a;
    public final /* synthetic */ ListenableFuture b;

    public /* synthetic */ c(ConstraintTrackingWorker constraintTrackingWorker, ListenableFuture listenableFuture) {
        this.f3085a = constraintTrackingWorker;
        this.b = listenableFuture;
    }

    public final void run() {
        ConstraintTrackingWorker.u(this.f3085a, this.b);
    }
}
