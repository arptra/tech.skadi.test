package com.honey.account.xb;

import java.util.function.Supplier;

public final /* synthetic */ class h0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7695a;
    public final /* synthetic */ Object[] b;

    public /* synthetic */ h0(String str, Object[] objArr) {
        this.f7695a = str;
        this.b = objArr;
    }

    public final Object get() {
        return String.format(this.f7695a, this.b);
    }
}
