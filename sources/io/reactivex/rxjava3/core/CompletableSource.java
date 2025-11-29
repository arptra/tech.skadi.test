package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface CompletableSource {
    void subscribe(@NonNull CompletableObserver completableObserver);
}
