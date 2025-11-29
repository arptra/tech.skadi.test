package com.honey.account.zb;

import java.util.function.Predicate;
import org.apache.commons.lang3.compare.ComparableUtils;

public final /* synthetic */ class e implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparable f7733a;

    public /* synthetic */ e(Comparable comparable) {
        this.f7733a = comparable;
    }

    public final boolean test(Object obj) {
        return ComparableUtils.is((Comparable) obj).lessThan(this.f7733a);
    }
}
