package com.honey.account.xb;

import java.util.function.BiPredicate;
import org.apache.commons.lang3.Functions;

public final /* synthetic */ class f implements BiPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailableBiPredicate f7690a;

    public /* synthetic */ f(Functions.FailableBiPredicate failableBiPredicate) {
        this.f7690a = failableBiPredicate;
    }

    public final boolean test(Object obj, Object obj2) {
        return Functions.test(this.f7690a, obj, obj2);
    }
}
