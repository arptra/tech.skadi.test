package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableBiFunction;
import org.apache.commons.lang3.function.FailableFunction;

public final /* synthetic */ class y implements FailableBiFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableBiFunction f7278a;
    public final /* synthetic */ FailableFunction b;

    public /* synthetic */ y(FailableBiFunction failableBiFunction, FailableFunction failableFunction) {
        this.f7278a = failableBiFunction;
        this.b = failableFunction;
    }

    public final Object apply(Object obj, Object obj2) {
        return this.f7278a.lambda$andThen$1(this.b, obj, obj2);
    }
}
