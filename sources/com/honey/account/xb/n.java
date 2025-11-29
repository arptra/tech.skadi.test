package com.honey.account.xb;

import java.util.function.BiFunction;
import org.apache.commons.lang3.Functions;

public final /* synthetic */ class n implements BiFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailableBiFunction f7703a;

    public /* synthetic */ n(Functions.FailableBiFunction failableBiFunction) {
        this.f7703a = failableBiFunction;
    }

    public final Object apply(Object obj, Object obj2) {
        return Functions.apply(this.f7703a, obj, obj2);
    }
}
