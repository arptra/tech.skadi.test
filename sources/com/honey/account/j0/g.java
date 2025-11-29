package com.honey.account.j0;

import androidx.work.impl.WorkerWrapper;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper f3064a;
    public final /* synthetic */ ListenableFuture b;

    public /* synthetic */ g(WorkerWrapper workerWrapper, ListenableFuture listenableFuture) {
        this.f3064a = workerWrapper;
        this.b = listenableFuture;
    }

    public final void run() {
        this.f3064a.i(this.b);
    }
}
