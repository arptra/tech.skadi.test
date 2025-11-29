package org.apache.commons.lang3.function;

import com.honey.account.dc.g0;
import com.honey.account.dc.h0;
import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
public interface FailableDoubleConsumer<E extends Throwable> {
    public static final FailableDoubleConsumer NOP = new g0();

    /* access modifiers changed from: private */
    /* synthetic */ void lambda$andThen$1(FailableDoubleConsumer failableDoubleConsumer, double d) throws Throwable {
        accept(d);
        failableDoubleConsumer.accept(d);
    }

    /* access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(double d) throws Throwable {
    }

    static <E extends Throwable> FailableDoubleConsumer<E> nop() {
        return NOP;
    }

    void accept(double d) throws Throwable;

    FailableDoubleConsumer<E> andThen(FailableDoubleConsumer<E> failableDoubleConsumer) {
        Objects.requireNonNull(failableDoubleConsumer);
        return new h0(this, failableDoubleConsumer);
    }
}
