package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableDoublePredicate;

public final /* synthetic */ class j0 implements FailableDoublePredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableDoublePredicate f7251a;
    public final /* synthetic */ FailableDoublePredicate b;

    public /* synthetic */ j0(FailableDoublePredicate failableDoublePredicate, FailableDoublePredicate failableDoublePredicate2) {
        this.f7251a = failableDoublePredicate;
        this.b = failableDoublePredicate2;
    }

    public final boolean test(double d) {
        return this.f7251a.lambda$or$4(this.b, d);
    }
}
