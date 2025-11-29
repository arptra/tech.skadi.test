package com.honey.account.ub;

import org.apache.commons.io.function.IOFunction;

public final /* synthetic */ class c implements IOFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOFunction f7628a;
    public final /* synthetic */ IOFunction b;

    public /* synthetic */ c(IOFunction iOFunction, IOFunction iOFunction2) {
        this.f7628a = iOFunction;
        this.b = iOFunction2;
    }

    public final Object apply(Object obj) {
        return this.f7628a.lambda$andThen$4(this.b, obj);
    }
}
