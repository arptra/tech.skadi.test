package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableIntUnaryOperator;

public final /* synthetic */ class k1 implements FailableIntUnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableIntUnaryOperator f7255a;
    public final /* synthetic */ FailableIntUnaryOperator b;

    public /* synthetic */ k1(FailableIntUnaryOperator failableIntUnaryOperator, FailableIntUnaryOperator failableIntUnaryOperator2) {
        this.f7255a = failableIntUnaryOperator;
        this.b = failableIntUnaryOperator2;
    }

    public final int applyAsInt(int i) {
        return this.f7255a.lambda$andThen$2(this.b, i);
    }
}
