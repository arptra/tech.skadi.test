package org.apache.commons.lang3.function;

import com.honey.account.dc.n2;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableToLongFunction<T, E extends Throwable> {
    public static final FailableToLongFunction NOP = new n2();

    /* access modifiers changed from: private */
    static /* synthetic */ long lambda$static$0(Object obj) throws Throwable {
        return 0;
    }

    static <T, E extends Throwable> FailableToLongFunction<T, E> nop() {
        return NOP;
    }

    long applyAsLong(T t) throws Throwable;
}
