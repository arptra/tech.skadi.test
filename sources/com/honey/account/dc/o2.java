package com.honey.account.dc;

import java.util.function.Function;
import org.apache.commons.lang3.function.TriFunction;

public final /* synthetic */ class o2 implements TriFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TriFunction f7262a;
    public final /* synthetic */ Function b;

    public /* synthetic */ o2(TriFunction triFunction, Function function) {
        this.f7262a = triFunction;
        this.b = function;
    }

    public final Object apply(Object obj, Object obj2, Object obj3) {
        return this.f7262a.lambda$andThen$0(this.b, obj, obj2, obj3);
    }
}
