package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableDoubleConsumer;

public final /* synthetic */ class h0 implements FailableDoubleConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableDoubleConsumer f7247a;
    public final /* synthetic */ FailableDoubleConsumer b;

    public /* synthetic */ h0(FailableDoubleConsumer failableDoubleConsumer, FailableDoubleConsumer failableDoubleConsumer2) {
        this.f7247a = failableDoubleConsumer;
        this.b = failableDoubleConsumer2;
    }

    public final void accept(double d) {
        this.f7247a.lambda$andThen$1(this.b, d);
    }
}
