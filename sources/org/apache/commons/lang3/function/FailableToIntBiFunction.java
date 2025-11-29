package org.apache.commons.lang3.function;

import com.honey.account.dc.k2;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableToIntBiFunction<T, U, E extends Throwable> {
    public static final FailableToIntBiFunction NOP = new k2();

    /* access modifiers changed from: private */
    static /* synthetic */ int lambda$static$0(Object obj, Object obj2) throws Throwable {
        return 0;
    }

    static <T, U, E extends Throwable> FailableToIntBiFunction<T, U, E> nop() {
        return NOP;
    }

    int applyAsInt(T t, U u) throws Throwable;
}
