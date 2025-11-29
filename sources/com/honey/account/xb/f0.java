package com.honey.account.xb;

import java.util.function.Supplier;

public final /* synthetic */ class f0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7691a;
    public final /* synthetic */ Object[] b;

    public /* synthetic */ f0(String str, Object[] objArr) {
        this.f7691a = str;
        this.b = objArr;
    }

    public final Object get() {
        return String.format(this.f7691a, this.b);
    }
}
