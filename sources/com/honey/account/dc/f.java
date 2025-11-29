package com.honey.account.dc;

import java.util.function.Supplier;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableSupplier;

public final /* synthetic */ class f implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableSupplier f7242a;

    public /* synthetic */ f(FailableSupplier failableSupplier) {
        this.f7242a = failableSupplier;
    }

    public final Object get() {
        return Failable.get(this.f7242a);
    }
}
