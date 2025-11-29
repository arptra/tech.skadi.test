package com.honey.account.dc;

import org.apache.commons.lang3.function.FailablePredicate;

public final /* synthetic */ class e2 implements FailablePredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailablePredicate f7241a;
    public final /* synthetic */ FailablePredicate b;

    public /* synthetic */ e2(FailablePredicate failablePredicate, FailablePredicate failablePredicate2) {
        this.f7241a = failablePredicate;
        this.b = failablePredicate2;
    }

    public final boolean test(Object obj) {
        return this.f7241a.lambda$and$2(this.b, obj);
    }
}
