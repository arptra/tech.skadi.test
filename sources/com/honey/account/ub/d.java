package com.honey.account.ub;

import java.util.function.Function;
import org.apache.commons.io.function.IOFunction;

public final /* synthetic */ class d implements IOFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOFunction f7629a;
    public final /* synthetic */ Function b;

    public /* synthetic */ d(IOFunction iOFunction, Function function) {
        this.f7629a = iOFunction;
        this.b = function;
    }

    public final Object apply(Object obj) {
        return this.f7629a.lambda$compose$1(this.b, obj);
    }
}
