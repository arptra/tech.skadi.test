package com.honey.account.dc;

import java.util.function.BiFunction;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBiFunction;

public final /* synthetic */ class h implements BiFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableBiFunction f7246a;

    public /* synthetic */ h(FailableBiFunction failableBiFunction) {
        this.f7246a = failableBiFunction;
    }

    public final Object apply(Object obj, Object obj2) {
        return Failable.apply(this.f7246a, obj, obj2);
    }
}
