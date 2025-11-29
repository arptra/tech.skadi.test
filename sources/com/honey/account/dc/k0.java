package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableDoublePredicate;

public final /* synthetic */ class k0 implements FailableDoublePredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableDoublePredicate f7254a;
    public final /* synthetic */ FailableDoublePredicate b;

    public /* synthetic */ k0(FailableDoublePredicate failableDoublePredicate, FailableDoublePredicate failableDoublePredicate2) {
        this.f7254a = failableDoublePredicate;
        this.b = failableDoublePredicate2;
    }

    public final boolean test(double d) {
        return this.f7254a.lambda$and$2(this.b, d);
    }
}
