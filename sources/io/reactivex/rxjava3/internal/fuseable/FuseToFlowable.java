package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;

public interface FuseToFlowable<T> {
    @NonNull
    Flowable<T> fuseToFlowable();
}
