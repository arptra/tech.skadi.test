package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableIntConsumer;
import org.apache.commons.lang3.function.FailableRunnable;

public final /* synthetic */ class p implements FailableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableIntConsumer f7263a;
    public final /* synthetic */ int b;

    public /* synthetic */ p(FailableIntConsumer failableIntConsumer, int i) {
        this.f7263a = failableIntConsumer;
        this.b = i;
    }

    public final void run() {
        this.f7263a.accept(this.b);
    }
}
