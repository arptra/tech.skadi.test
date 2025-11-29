package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableIntPredicate;

public final /* synthetic */ class f1 implements FailableIntPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableIntPredicate f7244a;

    public /* synthetic */ f1(FailableIntPredicate failableIntPredicate) {
        this.f7244a = failableIntPredicate;
    }

    public final boolean test(int i) {
        return this.f7244a.lambda$negate$3(i);
    }
}
