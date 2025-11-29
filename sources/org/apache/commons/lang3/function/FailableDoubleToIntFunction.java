package org.apache.commons.lang3.function;

import com.honey.account.dc.o0;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableDoubleToIntFunction<E extends Throwable> {
    public static final FailableDoubleToIntFunction NOP = new o0();

    /* access modifiers changed from: private */
    static /* synthetic */ int lambda$static$0(double d) throws Throwable {
        return 0;
    }

    static <E extends Throwable> FailableDoubleToIntFunction<E> nop() {
        return NOP;
    }

    int applyAsInt(double d) throws Throwable;
}
