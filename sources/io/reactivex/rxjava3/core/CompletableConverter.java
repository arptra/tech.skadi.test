package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface CompletableConverter<R> {
    R apply(@NonNull Completable completable);
}
