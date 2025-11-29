package org.apache.commons.lang3.function;

import com.honey.account.dc.g1;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableIntToDoubleFunction<E extends Throwable> {
    public static final FailableIntToDoubleFunction NOP = new g1();

    /* access modifiers changed from: private */
    static /* synthetic */ double lambda$static$0(int i) throws Throwable {
        return 0.0d;
    }

    static <E extends Throwable> FailableIntToDoubleFunction<E> nop() {
        return NOP;
    }

    double applyAsDouble(int i) throws Throwable;
}
