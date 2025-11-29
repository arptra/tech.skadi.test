package com.honey.account.xb;

import java.util.function.Supplier;

public final /* synthetic */ class g0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7693a;
    public final /* synthetic */ Object[] b;

    public /* synthetic */ g0(String str, Object[] objArr) {
        this.f7693a = str;
        this.b = objArr;
    }

    public final Object get() {
        return String.format(this.f7693a, this.b);
    }
}
