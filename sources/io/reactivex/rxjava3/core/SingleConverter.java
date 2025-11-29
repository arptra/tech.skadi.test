package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface SingleConverter<T, R> {
    R apply(@NonNull Single<T> single);
}
