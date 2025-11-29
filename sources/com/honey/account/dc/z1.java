package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableLongUnaryOperator;

public final /* synthetic */ class z1 implements FailableLongUnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableLongUnaryOperator f7281a;
    public final /* synthetic */ FailableLongUnaryOperator b;

    public /* synthetic */ z1(FailableLongUnaryOperator failableLongUnaryOperator, FailableLongUnaryOperator failableLongUnaryOperator2) {
        this.f7281a = failableLongUnaryOperator;
        this.b = failableLongUnaryOperator2;
    }

    public final long applyAsLong(long j) {
        return this.f7281a.lambda$compose$3(this.b, j);
    }
}
