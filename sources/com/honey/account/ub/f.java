package com.honey.account.ub;

import java.util.function.Function;
import org.apache.commons.io.function.IOFunction;

public final /* synthetic */ class f implements IOFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOFunction f7631a;
    public final /* synthetic */ Function b;

    public /* synthetic */ f(IOFunction iOFunction, Function function) {
        this.f7631a = iOFunction;
        this.b = function;
    }

    public final Object apply(Object obj) {
        return this.f7631a.lambda$andThen$5(this.b, obj);
    }
}
