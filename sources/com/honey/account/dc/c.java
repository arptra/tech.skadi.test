package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableDoubleConsumer;
import org.apache.commons.lang3.function.FailableRunnable;

public final /* synthetic */ class c implements FailableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableDoubleConsumer f7237a;
    public final /* synthetic */ double b;

    public /* synthetic */ c(FailableDoubleConsumer failableDoubleConsumer, double d) {
        this.f7237a = failableDoubleConsumer;
        this.b = d;
    }

    public final void run() {
        this.f7237a.accept(this.b);
    }
}
