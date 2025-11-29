package org.apache.commons.lang3.function;

import com.honey.account.dc.m1;
import com.honey.account.dc.n1;
import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
public interface FailableLongConsumer<E extends Throwable> {
    public static final FailableLongConsumer NOP = new m1();

    /* access modifiers changed from: private */
    /* synthetic */ void lambda$andThen$1(FailableLongConsumer failableLongConsumer, long j) throws Throwable {
        accept(j);
        failableLongConsumer.accept(j);
    }

    /* access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(long j) throws Throwable {
    }

    static <E extends Throwable> FailableLongConsumer<E> nop() {
        return NOP;
    }

    void accept(long j) throws Throwable;

    FailableLongConsumer<E> andThen(FailableLongConsumer<E> failableLongConsumer) {
        Objects.requireNonNull(failableLongConsumer);
        return new n1(this, failableLongConsumer);
    }
}
