package com.honey.account.vb;

import java.util.Set;
import java.util.function.IntPredicate;

public final /* synthetic */ class d implements IntPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Set f7639a;

    public /* synthetic */ d(Set set) {
        this.f7639a = set;
    }

    public final boolean test(int i) {
        return this.f7639a.contains(Integer.valueOf(i));
    }
}
