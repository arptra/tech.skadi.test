package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableBiPredicate;

public final /* synthetic */ class a0 implements FailableBiPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableBiPredicate f7233a;
    public final /* synthetic */ FailableBiPredicate b;

    public /* synthetic */ a0(FailableBiPredicate failableBiPredicate, FailableBiPredicate failableBiPredicate2) {
        this.f7233a = failableBiPredicate;
        this.b = failableBiPredicate2;
    }

    public final boolean test(Object obj, Object obj2) {
        return this.f7233a.lambda$and$2(this.b, obj, obj2);
    }
}
