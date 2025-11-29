package org.apache.commons.lang3.function;

import com.honey.account.dc.c2;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableObjLongConsumer<T, E extends Throwable> {
    public static final FailableObjLongConsumer NOP = new c2();

    /* access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(Object obj, long j) throws Throwable {
    }

    static <T, E extends Throwable> FailableObjLongConsumer<T, E> nop() {
        return NOP;
    }

    void accept(T t, long j) throws Throwable;
}
