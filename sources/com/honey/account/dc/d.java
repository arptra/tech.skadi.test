package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableBooleanSupplier;
import org.apache.commons.lang3.function.FailablePredicate;

public final /* synthetic */ class d implements FailableBooleanSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailablePredicate f7238a;
    public final /* synthetic */ Object b;

    public /* synthetic */ d(FailablePredicate failablePredicate, Object obj) {
        this.f7238a = failablePredicate;
        this.b = obj;
    }

    public final boolean getAsBoolean() {
        return this.f7238a.test(this.b);
    }
}
