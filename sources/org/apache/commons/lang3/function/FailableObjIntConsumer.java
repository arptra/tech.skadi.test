package org.apache.commons.lang3.function;

import com.honey.account.dc.b2;
import java.lang.Throwable;

@FunctionalInterface
public interface FailableObjIntConsumer<T, E extends Throwable> {
    public static final FailableObjIntConsumer NOP = new b2();

    /* access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(Object obj, int i) throws Throwable {
    }

    static <T, E extends Throwable> FailableObjIntConsumer<T, E> nop() {
        return NOP;
    }

    void accept(T t, int i) throws Throwable;
}
