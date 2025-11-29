package org.apache.commons.lang3.function;

import com.honey.account.dc.y0;
import com.honey.account.dc.z0;
import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
public interface FailableIntConsumer<E extends Throwable> {
    public static final FailableIntConsumer NOP = new z0();

    /* access modifiers changed from: private */
    /* synthetic */ void lambda$andThen$1(FailableIntConsumer failableIntConsumer, int i) throws Throwable {
        accept(i);
        failableIntConsumer.accept(i);
    }

    /* access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(int i) throws Throwable {
    }

    static <E extends Throwable> FailableIntConsumer<E> nop() {
        return NOP;
    }

    void accept(int i) throws Throwable;

    FailableIntConsumer<E> andThen(FailableIntConsumer<E> failableIntConsumer) {
        Objects.requireNonNull(failableIntConsumer);
        return new y0(this, failableIntConsumer);
    }
}
