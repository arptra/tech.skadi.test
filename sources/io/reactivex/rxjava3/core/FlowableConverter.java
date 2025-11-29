package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface FlowableConverter<T, R> {
    R apply(@NonNull Flowable<T> flowable);
}
