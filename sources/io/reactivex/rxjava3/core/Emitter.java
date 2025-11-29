package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

public interface Emitter<T> {
    void onComplete();

    void onError(@NonNull Throwable th);

    void onNext(@NonNull T t);
}
