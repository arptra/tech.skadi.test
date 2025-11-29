package com.honey.account.dc;

import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableRunnable;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableRunnable f7249a;

    public /* synthetic */ i(FailableRunnable failableRunnable) {
        this.f7249a = failableRunnable;
    }

    public final void run() {
        Failable.run(this.f7249a);
    }
}
