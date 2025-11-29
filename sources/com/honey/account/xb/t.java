package com.honey.account.xb;

import org.apache.commons.lang3.Functions;

public final /* synthetic */ class t implements Functions.FailableSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailableBiFunction f7708a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ t(Functions.FailableBiFunction failableBiFunction, Object obj, Object obj2) {
        this.f7708a = failableBiFunction;
        this.b = obj;
        this.c = obj2;
    }

    public final Object get() {
        return this.f7708a.apply(this.b, this.c);
    }
}
