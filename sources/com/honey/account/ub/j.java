package com.honey.account.ub;

import org.apache.commons.io.function.IOFunction;

public final /* synthetic */ class j implements IOFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOFunction f7634a;
    public final /* synthetic */ IOFunction b;

    public /* synthetic */ j(IOFunction iOFunction, IOFunction iOFunction2) {
        this.f7634a = iOFunction;
        this.b = iOFunction2;
    }

    public final Object apply(Object obj) {
        return this.f7634a.lambda$compose$0(this.b, obj);
    }
}
