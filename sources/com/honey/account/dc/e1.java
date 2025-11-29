package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableIntPredicate;

public final /* synthetic */ class e1 implements FailableIntPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableIntPredicate f7240a;
    public final /* synthetic */ FailableIntPredicate b;

    public /* synthetic */ e1(FailableIntPredicate failableIntPredicate, FailableIntPredicate failableIntPredicate2) {
        this.f7240a = failableIntPredicate;
        this.b = failableIntPredicate2;
    }

    public final boolean test(int i) {
        return this.f7240a.lambda$or$4(this.b, i);
    }
}
