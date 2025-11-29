package com.honey.account.dc;

import org.apache.commons.lang3.function.FailablePredicate;

public final /* synthetic */ class d2 implements FailablePredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailablePredicate f7239a;
    public final /* synthetic */ FailablePredicate b;

    public /* synthetic */ d2(FailablePredicate failablePredicate, FailablePredicate failablePredicate2) {
        this.f7239a = failablePredicate;
        this.b = failablePredicate2;
    }

    public final boolean test(Object obj) {
        return this.f7239a.lambda$or$4(this.b, obj);
    }
}
