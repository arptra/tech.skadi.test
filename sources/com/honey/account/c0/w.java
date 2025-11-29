package com.honey.account.c0;

import androidx.room.TransactionExecutor;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f3044a;
    public final /* synthetic */ TransactionExecutor b;

    public /* synthetic */ w(Runnable runnable, TransactionExecutor transactionExecutor) {
        this.f3044a = runnable;
        this.b = transactionExecutor;
    }

    public final void run() {
        TransactionExecutor.b(this.f3044a, this.b);
    }
}
