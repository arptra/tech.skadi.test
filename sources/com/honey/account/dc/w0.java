package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableFunction;

public final /* synthetic */ class w0 implements FailableFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableFunction f7276a;
    public final /* synthetic */ FailableFunction b;

    public /* synthetic */ w0(FailableFunction failableFunction, FailableFunction failableFunction2) {
        this.f7276a = failableFunction;
        this.b = failableFunction2;
    }

    public final Object apply(Object obj) {
        return this.f7276a.lambda$andThen$2(this.b, obj);
    }
}
