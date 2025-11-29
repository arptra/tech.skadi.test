package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public interface FuseToObservable<T> {
    @NonNull
    Observable<T> fuseToObservable();
}
