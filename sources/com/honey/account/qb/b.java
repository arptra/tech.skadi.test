package com.honey.account.qb;

import java.util.function.IntFunction;

public final /* synthetic */ class b implements IntFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Enum[] f7516a;

    public /* synthetic */ b(Enum[] enumArr) {
        this.f7516a = enumArr;
    }

    public final Object apply(int i) {
        return this.f7516a[i].name();
    }
}
