package com.honey.account.i0;

import androidx.work.CoroutineWorker;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineWorker f3056a;

    public /* synthetic */ a(CoroutineWorker coroutineWorker) {
        this.f3056a = coroutineWorker;
    }

    public final void run() {
        CoroutineWorker.q(this.f3056a);
    }
}
