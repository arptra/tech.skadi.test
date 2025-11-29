package org.apache.commons.lang3.function;

import com.honey.account.dc.a1;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableIntFunction<R, E extends Throwable> {
    public static final FailableIntFunction NOP = new a1();

    /* access modifiers changed from: private */
    static /* synthetic */ Object lambda$static$0(int i) throws Throwable {
        return null;
    }

    static <R, E extends Throwable> FailableIntFunction<R, E> nop() {
        return NOP;
    }

    R apply(int i) throws Throwable;
}
