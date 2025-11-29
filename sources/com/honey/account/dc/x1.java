package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableLongUnaryOperator;

public final /* synthetic */ class x1 implements FailableLongUnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableLongUnaryOperator f7277a;
    public final /* synthetic */ FailableLongUnaryOperator b;

    public /* synthetic */ x1(FailableLongUnaryOperator failableLongUnaryOperator, FailableLongUnaryOperator failableLongUnaryOperator2) {
        this.f7277a = failableLongUnaryOperator;
        this.b = failableLongUnaryOperator2;
    }

    public final long applyAsLong(long j) {
        return this.f7277a.lambda$andThen$2(this.b, j);
    }
}
