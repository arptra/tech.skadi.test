package com.honey.account.xb;

import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.FailableBooleanSupplier;

public final /* synthetic */ class g implements FailableBooleanSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailableBiPredicate f7692a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ g(Functions.FailableBiPredicate failableBiPredicate, Object obj, Object obj2) {
        this.f7692a = failableBiPredicate;
        this.b = obj;
        this.c = obj2;
    }

    public final boolean getAsBoolean() {
        return this.f7692a.test(this.b, this.c);
    }
}
