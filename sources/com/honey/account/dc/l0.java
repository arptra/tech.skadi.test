package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableDoublePredicate;

public final /* synthetic */ class l0 implements FailableDoublePredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableDoublePredicate f7257a;

    public /* synthetic */ l0(FailableDoublePredicate failableDoublePredicate) {
        this.f7257a = failableDoublePredicate;
    }

    public final boolean test(double d) {
        return this.f7257a.lambda$negate$3(d);
    }
}
