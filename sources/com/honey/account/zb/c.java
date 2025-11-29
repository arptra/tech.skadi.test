package com.honey.account.zb;

import java.util.function.Predicate;
import org.apache.commons.lang3.compare.ComparableUtils;

public final /* synthetic */ class c implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparable f7731a;
    public final /* synthetic */ Comparable b;

    public /* synthetic */ c(Comparable comparable, Comparable comparable2) {
        this.f7731a = comparable;
        this.b = comparable2;
    }

    public final boolean test(Object obj) {
        return ComparableUtils.is((Comparable) obj).between(this.f7731a, this.b);
    }
}
