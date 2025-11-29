package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableIntPredicate;

public final /* synthetic */ class b1 implements FailableIntPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableIntPredicate f7236a;
    public final /* synthetic */ FailableIntPredicate b;

    public /* synthetic */ b1(FailableIntPredicate failableIntPredicate, FailableIntPredicate failableIntPredicate2) {
        this.f7236a = failableIntPredicate;
        this.b = failableIntPredicate2;
    }

    public final boolean test(int i) {
        return this.f7236a.lambda$and$2(this.b, i);
    }
}
