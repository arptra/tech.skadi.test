package com.honey.account.xb;

import java.util.function.Function;
import org.apache.commons.lang3.Functions;

public final /* synthetic */ class u implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailableFunction f7709a;

    public /* synthetic */ u(Functions.FailableFunction failableFunction) {
        this.f7709a = failableFunction;
    }

    public final Object apply(Object obj) {
        return Functions.apply(this.f7709a, obj);
    }
}
