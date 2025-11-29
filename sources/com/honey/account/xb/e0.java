package com.honey.account.xb;

import java.util.function.Supplier;

public final /* synthetic */ class e0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7689a;
    public final /* synthetic */ Object[] b;

    public /* synthetic */ e0(String str, Object[] objArr) {
        this.f7689a = str;
        this.b = objArr;
    }

    public final Object get() {
        return String.format(this.f7689a, this.b);
    }
}
