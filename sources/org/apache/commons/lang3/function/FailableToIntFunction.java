package org.apache.commons.lang3.function;

import com.honey.account.dc.l2;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableToIntFunction<T, E extends Throwable> {
    public static final FailableToIntFunction NOP = new l2();

    /* access modifiers changed from: private */
    static /* synthetic */ int lambda$static$0(Object obj) throws Throwable {
        return 0;
    }

    static <T, E extends Throwable> FailableToIntFunction<T, E> nop() {
        return NOP;
    }

    int applyAsInt(T t) throws Throwable;
}
