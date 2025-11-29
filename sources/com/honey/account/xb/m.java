package com.honey.account.xb;

import org.apache.commons.lang3.Functions;

public final /* synthetic */ class m implements Functions.FailableSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailableFunction f7702a;
    public final /* synthetic */ Object b;

    public /* synthetic */ m(Functions.FailableFunction failableFunction, Object obj) {
        this.f7702a = failableFunction;
        this.b = obj;
    }

    public final Object get() {
        return this.f7702a.apply(this.b);
    }
}
