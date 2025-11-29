package com.honey.account.dc;

import java.util.function.Predicate;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailablePredicate;

public final /* synthetic */ class q implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailablePredicate f7265a;

    public /* synthetic */ q(FailablePredicate failablePredicate) {
        this.f7265a = failablePredicate;
    }

    public final boolean test(Object obj) {
        return Failable.test(this.f7265a, obj);
    }
}
