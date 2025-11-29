package com.honey.account.xb;

import org.apache.commons.lang3.Functions;

public final /* synthetic */ class k implements Functions.FailableSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailableCallable f7700a;

    public /* synthetic */ k(Functions.FailableCallable failableCallable) {
        this.f7700a = failableCallable;
    }

    public final Object get() {
        return this.f7700a.call();
    }
}
