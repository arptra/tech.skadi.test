package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.annotations.NonNull;
import org.reactivestreams.Publisher;

public interface HasUpstreamPublisher<T> {
    @NonNull
    Publisher<T> source();
}
