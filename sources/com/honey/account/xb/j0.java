package com.honey.account.xb;

import java.util.function.Supplier;

public final /* synthetic */ class j0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7699a;
    public final /* synthetic */ Object[] b;

    public /* synthetic */ j0(String str, Object[] objArr) {
        this.f7699a = str;
        this.b = objArr;
    }

    public final Object get() {
        return String.format(this.f7699a, this.b);
    }
}
