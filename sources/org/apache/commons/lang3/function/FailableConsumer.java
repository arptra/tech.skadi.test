package org.apache.commons.lang3.function;

import com.honey.account.dc.e0;
import com.honey.account.dc.f0;
import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
public interface FailableConsumer<T, E extends Throwable> {
    public static final FailableConsumer NOP = new e0();

    /* access modifiers changed from: private */
    /* synthetic */ void lambda$andThen$1(FailableConsumer failableConsumer, Object obj) throws Throwable {
        accept(obj);
        failableConsumer.accept(obj);
    }

    /* access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(Object obj) throws Throwable {
    }

    static <T, E extends Throwable> FailableConsumer<T, E> nop() {
        return NOP;
    }

    void accept(T t) throws Throwable;

    FailableConsumer<T, E> andThen(FailableConsumer<? super T, E> failableConsumer) {
        Objects.requireNonNull(failableConsumer);
        return new f0(this, failableConsumer);
    }
}
