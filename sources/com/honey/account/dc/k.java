package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;

public final /* synthetic */ class k implements FailableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableConsumer f7253a;
    public final /* synthetic */ Object b;

    public /* synthetic */ k(FailableConsumer failableConsumer, Object obj) {
        this.f7253a = failableConsumer;
        this.b = obj;
    }

    public final void run() {
        this.f7253a.accept(this.b);
    }
}
