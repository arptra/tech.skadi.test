package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableLongConsumer;

public final /* synthetic */ class n1 implements FailableLongConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableLongConsumer f7260a;
    public final /* synthetic */ FailableLongConsumer b;

    public /* synthetic */ n1(FailableLongConsumer failableLongConsumer, FailableLongConsumer failableLongConsumer2) {
        this.f7260a = failableLongConsumer;
        this.b = failableLongConsumer2;
    }

    public final void accept(long j) {
        this.f7260a.lambda$andThen$1(this.b, j);
    }
}
