package org.apache.commons.lang3.function;

import com.honey.account.dc.i2;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableToDoubleBiFunction<T, U, E extends Throwable> {
    public static final FailableToDoubleBiFunction NOP = new i2();

    /* access modifiers changed from: private */
    static /* synthetic */ double lambda$static$0(Object obj, Object obj2) throws Throwable {
        return 0.0d;
    }

    static <T, U, E extends Throwable> FailableToDoubleBiFunction<T, U, E> nop() {
        return NOP;
    }

    double applyAsDouble(T t, U u) throws Throwable;
}
