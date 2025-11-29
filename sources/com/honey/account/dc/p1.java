package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableLongPredicate;

public final /* synthetic */ class p1 implements FailableLongPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableLongPredicate f7264a;
    public final /* synthetic */ FailableLongPredicate b;

    public /* synthetic */ p1(FailableLongPredicate failableLongPredicate, FailableLongPredicate failableLongPredicate2) {
        this.f7264a = failableLongPredicate;
        this.b = failableLongPredicate2;
    }

    public final boolean test(long j) {
        return this.f7264a.lambda$and$2(this.b, j);
    }
}
