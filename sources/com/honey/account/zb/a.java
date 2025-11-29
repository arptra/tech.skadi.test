package com.honey.account.zb;

import java.util.function.Predicate;
import org.apache.commons.lang3.compare.ComparableUtils;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparable f7729a;

    public /* synthetic */ a(Comparable comparable) {
        this.f7729a = comparable;
    }

    public final boolean test(Object obj) {
        return ComparableUtils.is((Comparable) obj).greaterThanOrEqualTo(this.f7729a);
    }
}
