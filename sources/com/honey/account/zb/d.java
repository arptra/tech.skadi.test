package com.honey.account.zb;

import java.util.function.Predicate;
import org.apache.commons.lang3.compare.ComparableUtils;

public final /* synthetic */ class d implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparable f7732a;
    public final /* synthetic */ Comparable b;

    public /* synthetic */ d(Comparable comparable, Comparable comparable2) {
        this.f7732a = comparable;
        this.b = comparable2;
    }

    public final boolean test(Object obj) {
        return ComparableUtils.is((Comparable) obj).betweenExclusive(this.f7732a, this.b);
    }
}
