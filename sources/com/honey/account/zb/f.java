package com.honey.account.zb;

import java.util.function.Predicate;
import org.apache.commons.lang3.compare.ComparableUtils;

public final /* synthetic */ class f implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparable f7734a;

    public /* synthetic */ f(Comparable comparable) {
        this.f7734a = comparable;
    }

    public final boolean test(Object obj) {
        return ComparableUtils.is((Comparable) obj).lessThanOrEqualTo(this.f7734a);
    }
}
