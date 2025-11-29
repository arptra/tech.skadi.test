package org.apache.commons.lang3.function;

import com.honey.account.dc.m2;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableToLongBiFunction<T, U, E extends Throwable> {
    public static final FailableToLongBiFunction NOP = new m2();

    /* access modifiers changed from: private */
    static /* synthetic */ long lambda$static$0(Object obj, Object obj2) throws Throwable {
        return 0;
    }

    static <T, U, E extends Throwable> FailableToLongBiFunction<T, U, E> nop() {
        return NOP;
    }

    long applyAsLong(T t, U u) throws Throwable;
}
