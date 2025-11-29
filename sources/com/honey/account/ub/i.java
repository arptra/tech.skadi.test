package com.honey.account.ub;

import org.apache.commons.io.function.IOFunction;
import org.apache.commons.io.function.IOSupplier;

public final /* synthetic */ class i implements IOSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOFunction f7633a;
    public final /* synthetic */ IOSupplier b;

    public /* synthetic */ i(IOFunction iOFunction, IOSupplier iOSupplier) {
        this.f7633a = iOFunction;
        this.b = iOSupplier;
    }

    public final Object get() {
        return this.f7633a.lambda$compose$2(this.b);
    }
}
