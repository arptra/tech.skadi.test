package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableBiConsumer;

public final /* synthetic */ class w implements FailableBiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableBiConsumer f7275a;
    public final /* synthetic */ FailableBiConsumer b;

    public /* synthetic */ w(FailableBiConsumer failableBiConsumer, FailableBiConsumer failableBiConsumer2) {
        this.f7275a = failableBiConsumer;
        this.b = failableBiConsumer2;
    }

    public final void accept(Object obj, Object obj2) {
        this.f7275a.lambda$andThen$1(this.b, obj, obj2);
    }
}
