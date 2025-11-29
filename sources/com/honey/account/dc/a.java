package com.honey.account.dc;

import java.util.function.BiPredicate;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBiPredicate;

public final /* synthetic */ class a implements BiPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableBiPredicate f7232a;

    public /* synthetic */ a(FailableBiPredicate failableBiPredicate) {
        this.f7232a = failableBiPredicate;
    }

    public final boolean test(Object obj, Object obj2) {
        return Failable.test(this.f7232a, obj, obj2);
    }
}
