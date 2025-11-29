package com.honey.account.j0;

import androidx.work.impl.Processor;
import androidx.work.impl.WorkerWrapper;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Processor f3059a;
    public final /* synthetic */ ListenableFuture b;
    public final /* synthetic */ WorkerWrapper c;

    public /* synthetic */ b(Processor processor, ListenableFuture listenableFuture, WorkerWrapper workerWrapper) {
        this.f3059a = processor;
        this.b = listenableFuture;
        this.c = workerWrapper;
    }

    public final void run() {
        this.f3059a.n(this.b, this.c);
    }
}
