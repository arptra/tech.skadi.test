package org.apache.commons.lang3.function;

import com.honey.account.dc.v1;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableLongToIntFunction<E extends Throwable> {
    public static final FailableLongToIntFunction NOP = new v1();

    /* access modifiers changed from: private */
    static /* synthetic */ int lambda$static$0(long j) throws Throwable {
        return 0;
    }

    static <E extends Throwable> FailableLongToIntFunction<E> nop() {
        return NOP;
    }

    int applyAsInt(long j) throws Throwable;
}
