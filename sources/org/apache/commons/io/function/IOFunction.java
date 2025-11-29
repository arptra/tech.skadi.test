package org.apache.commons.io.function;

import com.honey.account.ub.c;
import com.honey.account.ub.d;
import com.honey.account.ub.e;
import com.honey.account.ub.f;
import com.honey.account.ub.g;
import com.honey.account.ub.h;
import com.honey.account.ub.i;
import com.honey.account.ub.j;
import com.honey.account.ub.k;
import java.io.IOException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
public interface IOFunction<T, R> {
    static <T> IOFunction<T, T> identity() {
        return new h();
    }

    /* access modifiers changed from: private */
    /* synthetic */ Object lambda$andThen$4(IOFunction iOFunction, Object obj) throws IOException {
        return iOFunction.apply(apply(obj));
    }

    /* access modifiers changed from: private */
    /* synthetic */ Object lambda$andThen$5(Function function, Object obj) throws IOException {
        return function.apply(apply(obj));
    }

    /* access modifiers changed from: private */
    /* synthetic */ void lambda$andThen$6(IOConsumer iOConsumer, Object obj) throws IOException {
        iOConsumer.accept(apply(obj));
    }

    /* access modifiers changed from: private */
    /* synthetic */ void lambda$andThen$7(Consumer consumer, Object obj) throws IOException {
        consumer.accept(apply(obj));
    }

    /* access modifiers changed from: private */
    /* synthetic */ Object lambda$compose$0(IOFunction iOFunction, Object obj) throws IOException {
        return apply(iOFunction.apply(obj));
    }

    /* access modifiers changed from: private */
    /* synthetic */ Object lambda$compose$1(Function function, Object obj) throws IOException {
        return apply(function.apply(obj));
    }

    /* access modifiers changed from: private */
    /* synthetic */ Object lambda$compose$2(IOSupplier iOSupplier) throws IOException {
        return apply(iOSupplier.get());
    }

    /* access modifiers changed from: private */
    /* synthetic */ Object lambda$compose$3(Supplier supplier) throws IOException {
        return apply(supplier.get());
    }

    /* access modifiers changed from: private */
    static /* synthetic */ Object lambda$identity$8(Object obj) throws IOException {
        return obj;
    }

    <V> IOFunction<T, V> andThen(IOFunction<? super R, ? extends V> iOFunction) {
        Objects.requireNonNull(iOFunction, "after");
        return new c(this, iOFunction);
    }

    R apply(T t) throws IOException;

    <V> IOFunction<V, R> compose(IOFunction<? super V, ? extends T> iOFunction) {
        Objects.requireNonNull(iOFunction, "before");
        return new j(this, iOFunction);
    }

    <V> IOFunction<T, V> andThen(Function<? super R, ? extends V> function) {
        Objects.requireNonNull(function, "after");
        return new f(this, function);
    }

    <V> IOFunction<V, R> compose(Function<? super V, ? extends T> function) {
        Objects.requireNonNull(function, "before");
        return new d(this, function);
    }

    IOConsumer<T> andThen(IOConsumer<? super R> iOConsumer) {
        Objects.requireNonNull(iOConsumer, "after");
        return new e(this, iOConsumer);
    }

    IOSupplier<R> compose(IOSupplier<? extends T> iOSupplier) {
        Objects.requireNonNull(iOSupplier, "before");
        return new i(this, iOSupplier);
    }

    IOConsumer<T> andThen(Consumer<? super R> consumer) {
        Objects.requireNonNull(consumer, "after");
        return new g(this, consumer);
    }

    IOSupplier<R> compose(Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier, "before");
        return new k(this, supplier);
    }
}
