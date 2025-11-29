package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableSource;

public interface HasUpstreamCompletableSource {
    @NonNull
    CompletableSource source();
}
