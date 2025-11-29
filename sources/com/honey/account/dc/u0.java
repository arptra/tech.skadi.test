package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableFunction;

public final /* synthetic */ class u0 implements FailableFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableFunction f7274a;
    public final /* synthetic */ FailableFunction b;

    public /* synthetic */ u0(FailableFunction failableFunction, FailableFunction failableFunction2) {
        this.f7274a = failableFunction;
        this.b = failableFunction2;
    }

    public final Object apply(Object obj) {
        return this.f7274a.lambda$compose$3(this.b, obj);
    }
}
