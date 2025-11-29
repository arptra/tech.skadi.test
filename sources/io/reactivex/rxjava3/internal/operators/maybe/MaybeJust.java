package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;

public final class MaybeJust<T> extends Maybe<T> implements ScalarSupplier<T> {
    final T value;

    public MaybeJust(T t) {
        this.value = t;
    }

    public T get() {
        return this.value;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposable.disposed());
        maybeObserver.onSuccess(this.value);
    }
}
