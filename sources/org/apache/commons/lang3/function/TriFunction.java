package org.apache.commons.lang3.function;

import com.honey.account.dc.o2;
import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    /* access modifiers changed from: private */
    /* synthetic */ Object lambda$andThen$0(Function function, Object obj, Object obj2, Object obj3) {
        return function.apply(apply(obj, obj2, obj3));
    }

    <W> TriFunction<T, U, V, W> andThen(Function<? super R, ? extends W> function) {
        Objects.requireNonNull(function);
        return new o2(this, function);
    }

    R apply(T t, U u, V v);
}
