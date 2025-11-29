package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableCallable;
import org.apache.commons.lang3.function.FailableSupplier;

public final /* synthetic */ class m implements FailableSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableCallable f7258a;

    public /* synthetic */ m(FailableCallable failableCallable) {
        this.f7258a = failableCallable;
    }

    public final Object get() {
        return this.f7258a.call();
    }
}
