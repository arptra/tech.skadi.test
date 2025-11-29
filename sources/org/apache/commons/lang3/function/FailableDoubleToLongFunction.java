package org.apache.commons.lang3.function;

import com.honey.account.dc.p0;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableDoubleToLongFunction<E extends Throwable> {
    public static final FailableDoubleToLongFunction NOP = new p0();

    /* access modifiers changed from: private */
    static /* synthetic */ int lambda$static$0(double d) throws Throwable {
        return 0;
    }

    static <E extends Throwable> FailableDoubleToLongFunction<E> nop() {
        return NOP;
    }

    int applyAsLong(double d) throws Throwable;
}
