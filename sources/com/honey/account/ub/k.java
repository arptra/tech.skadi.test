package com.honey.account.ub;

import java.util.function.Supplier;
import org.apache.commons.io.function.IOFunction;
import org.apache.commons.io.function.IOSupplier;

public final /* synthetic */ class k implements IOSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOFunction f7635a;
    public final /* synthetic */ Supplier b;

    public /* synthetic */ k(IOFunction iOFunction, Supplier supplier) {
        this.f7635a = iOFunction;
        this.b = supplier;
    }

    public final Object get() {
        return this.f7635a.lambda$compose$3(this.b);
    }
}
