package com.honey.account.xb;

import org.apache.commons.lang3.Functions;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailableRunnable f7706a;

    public /* synthetic */ q(Functions.FailableRunnable failableRunnable) {
        this.f7706a = failableRunnable;
    }

    public final void run() {
        Functions.run(this.f7706a);
    }
}
