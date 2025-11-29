package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.CancellableQueueFuseable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableFromRunnable<T> extends Flowable<T> implements Supplier<T> {
    final Runnable run;

    public FlowableFromRunnable(Runnable runnable) {
        this.run = runnable;
    }

    public T get() throws Throwable {
        this.run.run();
        return null;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        CancellableQueueFuseable cancellableQueueFuseable = new CancellableQueueFuseable();
        subscriber.onSubscribe(cancellableQueueFuseable);
        if (!cancellableQueueFuseable.isDisposed()) {
            try {
                this.run.run();
                if (!cancellableQueueFuseable.isDisposed()) {
                    subscriber.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!cancellableQueueFuseable.isDisposed()) {
                    subscriber.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
