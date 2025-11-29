package org.apache.commons.lang3.function;

import com.honey.account.dc.o1;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableLongFunction<R, E extends Throwable> {
    public static final FailableLongFunction NOP = new o1();

    /* access modifiers changed from: private */
    static /* synthetic */ Object lambda$static$0(long j) throws Throwable {
        return null;
    }

    static <R, E extends Throwable> FailableLongFunction<R, E> nop() {
        return NOP;
    }

    R apply(long j) throws Throwable;
}
