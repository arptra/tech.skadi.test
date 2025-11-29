package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableIntUnaryOperator;

public final /* synthetic */ class j1 implements FailableIntUnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableIntUnaryOperator f7252a;
    public final /* synthetic */ FailableIntUnaryOperator b;

    public /* synthetic */ j1(FailableIntUnaryOperator failableIntUnaryOperator, FailableIntUnaryOperator failableIntUnaryOperator2) {
        this.f7252a = failableIntUnaryOperator;
        this.b = failableIntUnaryOperator2;
    }

    public final int applyAsInt(int i) {
        return this.f7252a.lambda$compose$3(this.b, i);
    }
}
