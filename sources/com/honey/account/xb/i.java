package com.honey.account.xb;

import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.FailableBooleanSupplier;

public final /* synthetic */ class i implements FailableBooleanSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailablePredicate f7696a;
    public final /* synthetic */ Object b;

    public /* synthetic */ i(Functions.FailablePredicate failablePredicate, Object obj) {
        this.f7696a = failablePredicate;
        this.b = obj;
    }

    public final boolean getAsBoolean() {
        return this.f7696a.test(this.b);
    }
}
