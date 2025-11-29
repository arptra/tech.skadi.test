package com.honey.account.qb;

import java.util.Objects;
import java.util.function.IntFunction;

public final /* synthetic */ class a implements IntFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object[] f7515a;

    public /* synthetic */ a(Object[] objArr) {
        this.f7515a = objArr;
    }

    public final Object apply(int i) {
        return Objects.toString(this.f7515a[i], (String) null);
    }
}
