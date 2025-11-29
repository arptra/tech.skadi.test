package org.apache.commons.lang3.function;

import com.honey.account.dc.x;
import com.honey.account.dc.y;
import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
public interface FailableBiFunction<T, U, R, E extends Throwable> {
    public static final FailableBiFunction NOP = new x();

    /* access modifiers changed from: private */
    /* synthetic */ Object lambda$andThen$1(FailableFunction failableFunction, Object obj, Object obj2) throws Throwable {
        return failableFunction.apply(apply(obj, obj2));
    }

    /* access modifiers changed from: private */
    static /* synthetic */ Object lambda$static$0(Object obj, Object obj2) throws Throwable {
        return null;
    }

    static <T, U, R, E extends Throwable> FailableBiFunction<T, U, R, E> nop() {
        return NOP;
    }

    <V> FailableBiFunction<T, U, V, E> andThen(FailableFunction<? super R, ? extends V, E> failableFunction) {
        Objects.requireNonNull(failableFunction);
        return new y(this, failableFunction);
    }

    R apply(T t, U u) throws Throwable;
}
