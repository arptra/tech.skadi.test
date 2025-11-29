package org.apache.commons.lang3.function;

import com.honey.account.dc.i0;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableDoubleFunction<R, E extends Throwable> {
    public static final FailableDoubleFunction NOP = new i0();

    /* access modifiers changed from: private */
    static /* synthetic */ Object lambda$static$0(double d) throws Throwable {
        return null;
    }

    static <R, E extends Throwable> FailableDoubleFunction<R, E> nop() {
        return NOP;
    }

    R apply(double d) throws Throwable;
}
