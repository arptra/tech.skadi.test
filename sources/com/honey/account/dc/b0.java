package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableBiPredicate;

public final /* synthetic */ class b0 implements FailableBiPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableBiPredicate f7235a;
    public final /* synthetic */ FailableBiPredicate b;

    public /* synthetic */ b0(FailableBiPredicate failableBiPredicate, FailableBiPredicate failableBiPredicate2) {
        this.f7235a = failableBiPredicate;
        this.b = failableBiPredicate2;
    }

    public final boolean test(Object obj, Object obj2) {
        return this.f7235a.lambda$or$4(this.b, obj, obj2);
    }
}
