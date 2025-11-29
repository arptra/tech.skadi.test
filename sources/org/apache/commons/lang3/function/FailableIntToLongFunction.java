package org.apache.commons.lang3.function;

import com.honey.account.dc.h1;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableIntToLongFunction<E extends Throwable> {
    public static final FailableIntToLongFunction NOP = new h1();

    /* access modifiers changed from: private */
    static /* synthetic */ long lambda$static$0(int i) throws Throwable {
        return 0;
    }

    static <E extends Throwable> FailableIntToLongFunction<E> nop() {
        return NOP;
    }

    long applyAsLong(int i) throws Throwable;
}
