package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableBiPredicate;

public final /* synthetic */ class z implements FailableBiPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableBiPredicate f7280a;

    public /* synthetic */ z(FailableBiPredicate failableBiPredicate) {
        this.f7280a = failableBiPredicate;
    }

    public final boolean test(Object obj, Object obj2) {
        return this.f7280a.lambda$negate$3(obj, obj2);
    }
}
