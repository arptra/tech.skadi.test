package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableLongPredicate;

public final /* synthetic */ class q1 implements FailableLongPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableLongPredicate f7266a;

    public /* synthetic */ q1(FailableLongPredicate failableLongPredicate) {
        this.f7266a = failableLongPredicate;
    }

    public final boolean test(long j) {
        return this.f7266a.lambda$negate$3(j);
    }
}
