package org.apache.commons.io.function;

import com.honey.account.ub.a;
import com.honey.account.ub.b;
import java.io.IOException;
import java.util.Objects;

@FunctionalInterface
public interface IOConsumer<T> {
    public static final IOConsumer<?> NOOP_IO_CONSUMER = new b();

    /* access modifiers changed from: private */
    /* synthetic */ void lambda$andThen$1(IOConsumer iOConsumer, Object obj) throws IOException {
        accept(obj);
        iOConsumer.accept(obj);
    }

    /* access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(Object obj) throws IOException {
    }

    static <T> IOConsumer<T> noop() {
        return NOOP_IO_CONSUMER;
    }

    void accept(T t) throws IOException;

    IOConsumer<T> andThen(IOConsumer<? super T> iOConsumer) {
        Objects.requireNonNull(iOConsumer, "after");
        return new a(this, iOConsumer);
    }
}
