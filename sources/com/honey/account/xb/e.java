package com.honey.account.xb;

import java.util.function.Predicate;
import org.apache.commons.lang3.Functions;

public final /* synthetic */ class e implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailablePredicate f7688a;

    public /* synthetic */ e(Functions.FailablePredicate failablePredicate) {
        this.f7688a = failablePredicate;
    }

    public final boolean test(Object obj) {
        return Functions.test(this.f7688a, obj);
    }
}
