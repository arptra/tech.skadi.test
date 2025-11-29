package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableDoubleUnaryOperator;

public final /* synthetic */ class t0 implements FailableDoubleUnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableDoubleUnaryOperator f7272a;
    public final /* synthetic */ FailableDoubleUnaryOperator b;

    public /* synthetic */ t0(FailableDoubleUnaryOperator failableDoubleUnaryOperator, FailableDoubleUnaryOperator failableDoubleUnaryOperator2) {
        this.f7272a = failableDoubleUnaryOperator;
        this.b = failableDoubleUnaryOperator2;
    }

    public final double applyAsDouble(double d) {
        return this.f7272a.lambda$andThen$2(this.b, d);
    }
}
