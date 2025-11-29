package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletionStageConsumer<T> extends CompletableFuture<T> implements MaybeObserver<T>, SingleObserver<T>, CompletableObserver {
    final T defaultItem;
    final boolean hasDefault;
    final AtomicReference<Disposable> upstream = new AtomicReference<>();

    public CompletionStageConsumer(boolean z, T t) {
        this.hasDefault = z;
        this.defaultItem = t;
    }

    public boolean cancel(boolean z) {
        cancelUpstream();
        return super.cancel(z);
    }

    public void cancelUpstream() {
        DisposableHelper.dispose(this.upstream);
    }

    public void clear() {
        this.upstream.lazySet(DisposableHelper.DISPOSED);
    }

    public boolean complete(T t) {
        cancelUpstream();
        return super.complete(t);
    }

    public boolean completeExceptionally(Throwable th) {
        cancelUpstream();
        return super.completeExceptionally(th);
    }

    public void onComplete() {
        if (this.hasDefault) {
            complete(this.defaultItem);
        } else {
            completeExceptionally(new NoSuchElementException("The source was empty"));
        }
    }

    public void onError(Throwable th) {
        clear();
        if (!completeExceptionally(th)) {
            RxJavaPlugins.onError(th);
        }
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        DisposableHelper.setOnce(this.upstream, disposable);
    }

    public void onSuccess(@NonNull T t) {
        clear();
        complete(t);
    }
}
