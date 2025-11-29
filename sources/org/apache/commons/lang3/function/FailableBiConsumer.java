package org.apache.commons.lang3.function;

import com.honey.account.dc.v;
import com.honey.account.dc.w;
import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
public interface FailableBiConsumer<T, U, E extends Throwable> {
    public static final FailableBiConsumer NOP = new v();

    /* access modifiers changed from: private */
    /* synthetic */ void lambda$andThen$1(FailableBiConsumer failableBiConsumer, Object obj, Object obj2) throws Throwable {
        accept(obj, obj2);
        failableBiConsumer.accept(obj, obj2);
    }

    /* access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(Object obj, Object obj2) throws Throwable {
    }

    static <T, U, E extends Throwable> FailableBiConsumer<T, U, E> nop() {
        return NOP;
    }

    void accept(T t, U u) throws Throwable;

    FailableBiConsumer<T, U, E> andThen(FailableBiConsumer<? super T, ? super U, E> failableBiConsumer) {
        Objects.requireNonNull(failableBiConsumer);
        return new w(this, failableBiConsumer);
    }
}
