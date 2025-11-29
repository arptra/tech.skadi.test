package com.honey.account.xb;

import java.util.function.Supplier;

public final /* synthetic */ class i0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7697a;
    public final /* synthetic */ Object[] b;

    public /* synthetic */ i0(String str, Object[] objArr) {
        this.f7697a = str;
        this.b = objArr;
    }

    public final Object get() {
        return String.format(this.f7697a, this.b);
    }
}
