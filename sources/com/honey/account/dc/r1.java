package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableLongPredicate;

public final /* synthetic */ class r1 implements FailableLongPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableLongPredicate f7268a;
    public final /* synthetic */ FailableLongPredicate b;

    public /* synthetic */ r1(FailableLongPredicate failableLongPredicate, FailableLongPredicate failableLongPredicate2) {
        this.f7268a = failableLongPredicate;
        this.b = failableLongPredicate2;
    }

    public final boolean test(long j) {
        return this.f7268a.lambda$or$4(this.b, j);
    }
}
