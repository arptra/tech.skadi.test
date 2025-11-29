package org.apache.commons.lang3.function;

import com.honey.account.dc.a2;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableObjDoubleConsumer<T, E extends Throwable> {
    public static final FailableObjDoubleConsumer NOP = new a2();

    /* access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(Object obj, double d) throws Throwable {
    }

    static <T, E extends Throwable> FailableObjDoubleConsumer<T, E> nop() {
        return NOP;
    }

    void accept(T t, double d) throws Throwable;
}
