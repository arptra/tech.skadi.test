package com.honey.account.zb;

import java.util.function.Predicate;
import org.apache.commons.lang3.compare.ComparableUtils;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparable f7730a;

    public /* synthetic */ b(Comparable comparable) {
        this.f7730a = comparable;
    }

    public final boolean test(Object obj) {
        return ComparableUtils.is((Comparable) obj).greaterThan(this.f7730a);
    }
}
