package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZipIterable<T, U, V> extends AbstractFlowableWithUpstream<T, V> {
    final Iterable<U> other;
    final BiFunction<? super T, ? super U, ? extends V> zipper;

    public static final class ZipIterableSubscriber<T, U, V> implements FlowableSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super V> downstream;
        final Iterator<U> iterator;
        Subscription upstream;
        final BiFunction<? super T, ? super U, ? extends V> zipper;

        public ZipIterableSubscriber(Subscriber<? super V> subscriber, Iterator<U> it, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.downstream = subscriber;
            this.iterator = it;
            this.zipper = biFunction;
        }

        public void cancel() {
            this.upstream.cancel();
        }

        public void fail(Throwable th) {
            Exceptions.throwIfFatal(th);
            this.done = true;
            this.upstream.cancel();
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    U next = this.iterator.next();
                    Objects.requireNonNull(next, "The iterator returned a null value");
                    try {
                        Object apply = this.zipper.apply(t, next);
                        Objects.requireNonNull(apply, "The zipper function returned a null value");
                        this.downstream.onNext(apply);
                        try {
                            if (!this.iterator.hasNext()) {
                                this.done = true;
                                this.upstream.cancel();
                                this.downstream.onComplete();
                            }
                        } catch (Throwable th) {
                            fail(th);
                        }
                    } catch (Throwable th2) {
                        fail(th2);
                    }
                } catch (Throwable th3) {
                    fail(th3);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public void request(long j) {
            this.upstream.request(j);
        }
    }

    public FlowableZipIterable(Flowable<T> flowable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        super(flowable);
        this.other = iterable;
        this.zipper = biFunction;
    }

    public void subscribeActual(Subscriber<? super V> subscriber) {
        try {
            Iterator<U> it = this.other.iterator();
            Objects.requireNonNull(it, "The iterator returned by other is null");
            Iterator it2 = it;
            try {
                if (!it2.hasNext()) {
                    EmptySubscription.complete(subscriber);
                } else {
                    this.source.subscribe(new ZipIterableSubscriber(subscriber, it2, this.zipper));
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
