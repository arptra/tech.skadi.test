package com.honey.account.dc;

import java.util.function.Function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableFunction;

public final /* synthetic */ class n implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableFunction f7259a;

    public /* synthetic */ n(FailableFunction failableFunction) {
        this.f7259a = failableFunction;
    }

    public final Object apply(Object obj) {
        return Failable.apply(this.f7259a, obj);
    }
}
