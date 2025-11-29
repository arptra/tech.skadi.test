package com.honey.account.y9;

import java.util.concurrent.ExecutorService;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExecutorService f7715a;

    public /* synthetic */ a(ExecutorService executorService) {
        this.f7715a = executorService;
    }

    public final void run() {
        this.f7715a.shutdownNow();
    }
}
