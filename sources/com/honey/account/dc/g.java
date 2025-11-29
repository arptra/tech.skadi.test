package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableBiPredicate;
import org.apache.commons.lang3.function.FailableBooleanSupplier;

public final /* synthetic */ class g implements FailableBooleanSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableBiPredicate f7245a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ g(FailableBiPredicate failableBiPredicate, Object obj, Object obj2) {
        this.f7245a = failableBiPredicate;
        this.b = obj;
        this.c = obj2;
    }

    public final boolean getAsBoolean() {
        return this.f7245a.test(this.b, this.c);
    }
}
