package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleSource;

public interface HasUpstreamSingleSource<T> {
    @NonNull
    SingleSource<T> source();
}
