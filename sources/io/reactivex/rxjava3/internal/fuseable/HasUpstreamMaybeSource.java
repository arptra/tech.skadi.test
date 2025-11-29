package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.MaybeSource;

public interface HasUpstreamMaybeSource<T> {
    @NonNull
    MaybeSource<T> source();
}
