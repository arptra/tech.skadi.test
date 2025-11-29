package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableConsumer;

public final /* synthetic */ class f0 implements FailableConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableConsumer f7243a;
    public final /* synthetic */ FailableConsumer b;

    public /* synthetic */ f0(FailableConsumer failableConsumer, FailableConsumer failableConsumer2) {
        this.f7243a = failableConsumer;
        this.b = failableConsumer2;
    }

    public final void accept(Object obj) {
        this.f7243a.lambda$andThen$1(this.b, obj);
    }
}
