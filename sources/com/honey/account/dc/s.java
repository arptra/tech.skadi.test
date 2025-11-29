package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.function.FailableSupplier;

public final /* synthetic */ class s implements FailableSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableFunction f7269a;
    public final /* synthetic */ Object b;

    public /* synthetic */ s(FailableFunction failableFunction, Object obj) {
        this.f7269a = failableFunction;
        this.b = obj;
    }

    public final Object get() {
        return this.f7269a.apply(this.b);
    }
}
