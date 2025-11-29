package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableDoubleUnaryOperator;

public final /* synthetic */ class s0 implements FailableDoubleUnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableDoubleUnaryOperator f7270a;
    public final /* synthetic */ FailableDoubleUnaryOperator b;

    public /* synthetic */ s0(FailableDoubleUnaryOperator failableDoubleUnaryOperator, FailableDoubleUnaryOperator failableDoubleUnaryOperator2) {
        this.f7270a = failableDoubleUnaryOperator;
        this.b = failableDoubleUnaryOperator2;
    }

    public final double applyAsDouble(double d) {
        return this.f7270a.lambda$compose$3(this.b, d);
    }
}
