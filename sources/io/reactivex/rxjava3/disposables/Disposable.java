package io.reactivex.rxjava3.disposables;

import com.honey.account.lb.a;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Objects;
import java.util.concurrent.Future;
import org.reactivestreams.Subscription;

public interface Disposable {
    @NonNull
    static Disposable disposed() {
        return EmptyDisposable.INSTANCE;
    }

    @NonNull
    static Disposable empty() {
        return fromRunnable(Functions.EMPTY_RUNNABLE);
    }

    @NonNull
    static Disposable fromAction(@NonNull Action action) {
        Objects.requireNonNull(action, "action is null");
        return new ActionDisposable(action);
    }

    @NonNull
    static Disposable fromAutoCloseable(@NonNull AutoCloseable autoCloseable) {
        Objects.requireNonNull(autoCloseable, "autoCloseable is null");
        return new AutoCloseableDisposable(autoCloseable);
    }

    @NonNull
    static Disposable fromFuture(@NonNull Future<?> future) {
        Objects.requireNonNull(future, "future is null");
        return fromFuture(future, true);
    }

    @NonNull
    static Disposable fromRunnable(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    @NonNull
    static Disposable fromSubscription(@NonNull Subscription subscription) {
        Objects.requireNonNull(subscription, "subscription is null");
        return new SubscriptionDisposable(subscription);
    }

    @NonNull
    static AutoCloseable toAutoCloseable(@NonNull Disposable disposable) {
        Objects.requireNonNull(disposable, "disposable is null");
        return new a(disposable);
    }

    void dispose();

    boolean isDisposed();

    @NonNull
    static Disposable fromFuture(@NonNull Future<?> future, boolean z) {
        Objects.requireNonNull(future, "future is null");
        return new FutureDisposable(future, z);
    }
}
