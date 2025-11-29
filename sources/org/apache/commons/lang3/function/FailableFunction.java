package org.apache.commons.lang3.function;

import com.honey.account.dc.u0;
import com.honey.account.dc.v0;
import com.honey.account.dc.w0;
import com.honey.account.dc.x0;
import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
public interface FailableFunction<T, R, E extends Throwable> {
    public static final FailableFunction NOP = new v0();

    static <T, E extends Throwable> FailableFunction<T, T, E> identity() {
        return new x0();
    }

    /* access modifiers changed from: private */
    /* synthetic */ Object lambda$andThen$2(FailableFunction failableFunction, Object obj) throws Throwable {
        return failableFunction.apply(apply(obj));
    }

    /* access modifiers changed from: private */
    /* synthetic */ Object lambda$compose$3(FailableFunction failableFunction, Object obj) throws Throwable {
        return apply(failableFunction.apply(obj));
    }

    /* access modifiers changed from: private */
    static /* synthetic */ Object lambda$identity$1(Object obj) throws Throwable {
        return obj;
    }

    /* access modifiers changed from: private */
    static /* synthetic */ Object lambda$static$0(Object obj) throws Throwable {
        return null;
    }

    static <T, R, E extends Throwable> FailableFunction<T, R, E> nop() {
        return NOP;
    }

    <V> FailableFunction<T, V, E> andThen(FailableFunction<? super R, ? extends V, E> failableFunction) {
        Objects.requireNonNull(failableFunction);
        return new w0(this, failableFunction);
    }

    R apply(T t) throws Throwable;

    <V> FailableFunction<V, R, E> compose(FailableFunction<? super V, ? extends T, E> failableFunction) {
        Objects.requireNonNull(failableFunction);
        return new u0(this, failableFunction);
    }
}
