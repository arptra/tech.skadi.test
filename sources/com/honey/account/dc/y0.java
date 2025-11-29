package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableIntConsumer;

public final /* synthetic */ class y0 implements FailableIntConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableIntConsumer f7279a;
    public final /* synthetic */ FailableIntConsumer b;

    public /* synthetic */ y0(FailableIntConsumer failableIntConsumer, FailableIntConsumer failableIntConsumer2) {
        this.f7279a = failableIntConsumer;
        this.b = failableIntConsumer2;
    }

    public final void accept(int i) {
        this.f7279a.lambda$andThen$1(this.b, i);
    }
}
