package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableBiFunction;
import org.apache.commons.lang3.function.FailableSupplier;

public final /* synthetic */ class u implements FailableSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableBiFunction f7273a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ u(FailableBiFunction failableBiFunction, Object obj, Object obj2) {
        this.f7273a = failableBiFunction;
        this.b = obj;
        this.c = obj2;
    }

    public final Object get() {
        return this.f7273a.apply(this.b, this.c);
    }
}
