package com.honey.account.xb;

import java.util.function.Supplier;
import org.apache.commons.lang3.Functions;

public final /* synthetic */ class o implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailableSupplier f7704a;

    public /* synthetic */ o(Functions.FailableSupplier failableSupplier) {
        this.f7704a = failableSupplier;
    }

    public final Object get() {
        return Functions.get(this.f7704a);
    }
}
