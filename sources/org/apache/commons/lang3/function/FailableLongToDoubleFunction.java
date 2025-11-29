package org.apache.commons.lang3.function;

import com.honey.account.dc.u1;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableLongToDoubleFunction<E extends Throwable> {
    public static final FailableLongToDoubleFunction NOP = new u1();

    /* access modifiers changed from: private */
    static /* synthetic */ double lambda$static$0(long j) throws Throwable {
        return 0.0d;
    }

    static <E extends Throwable> FailableLongToDoubleFunction<E> nop() {
        return NOP;
    }

    double applyAsDouble(long j) throws Throwable;
}
