package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface ObservableConverter<T, R> {
    R apply(@NonNull Observable<T> observable);
}
