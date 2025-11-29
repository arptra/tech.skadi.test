package org.apache.commons.lang3.function;

import com.honey.account.dc.j2;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableToDoubleFunction<T, E extends Throwable> {
    public static final FailableToDoubleFunction NOP = new j2();

    /* access modifiers changed from: private */
    static /* synthetic */ double lambda$static$0(Object obj) throws Throwable {
        return 0.0d;
    }

    static <T, E extends Throwable> FailableToDoubleFunction<T, E> nop() {
        return NOP;
    }

    double applyAsDouble(T t) throws Throwable;
}
