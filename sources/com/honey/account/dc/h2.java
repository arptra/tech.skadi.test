package com.honey.account.dc;

import org.apache.commons.lang3.function.FailablePredicate;

public final /* synthetic */ class h2 implements FailablePredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailablePredicate f7248a;

    public /* synthetic */ h2(FailablePredicate failablePredicate) {
        this.f7248a = failablePredicate;
    }

    public final boolean test(Object obj) {
        return this.f7248a.lambda$negate$3(obj);
    }
}
