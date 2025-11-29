package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class DisposeOnCancel implements Future<Object> {
    final Disposable upstream;

    public DisposeOnCancel(Disposable disposable) {
        this.upstream = disposable;
    }

    public boolean cancel(boolean z) {
        this.upstream.dispose();
        return false;
    }

    public Object get() {
        return null;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    public Object get(long j, @NonNull TimeUnit timeUnit) {
        return null;
    }
}
