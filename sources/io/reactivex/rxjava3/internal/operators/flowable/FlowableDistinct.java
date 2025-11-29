package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableDistinct<T, K> extends AbstractFlowableWithUpstream<T, T> {
    final Supplier<? extends Collection<? super K>> collectionSupplier;
    final Function<? super T, K> keySelector;

    public static final class DistinctSubscriber<T, K> extends BasicFuseableSubscriber<T, T> {
        final Collection<? super K> collection;
        final Function<? super T, K> keySelector;

        public DistinctSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, Collection<? super K> collection2) {
            super(subscriber);
            this.keySelector = function;
            this.collection = collection2;
        }

        public void clear() {
            this.collection.clear();
            super.clear();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.collection.clear();
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.collection.clear();
            this.downstream.onError(th);
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode == 0) {
                    try {
                        K apply = this.keySelector.apply(t);
                        Objects.requireNonNull(apply, "The keySelector returned a null key");
                        if (this.collection.add(apply)) {
                            this.downstream.onNext(t);
                        } else {
                            this.upstream.request(1);
                        }
                    } catch (Throwable th) {
                        fail(th);
                    }
                } else {
                    this.downstream.onNext((Object) null);
                }
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll;
            while (true) {
                poll = this.qs.poll();
                if (poll == null) {
                    break;
                }
                Collection<? super K> collection2 = this.collection;
                K apply = this.keySelector.apply(poll);
                Objects.requireNonNull(apply, "The keySelector returned a null key");
                if (collection2.add(apply)) {
                    break;
                } else if (this.sourceMode == 2) {
                    this.upstream.request(1);
                }
            }
            return poll;
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public FlowableDistinct(Flowable<T> flowable, Function<? super T, K> function, Supplier<? extends Collection<? super K>> supplier) {
        super(flowable);
        this.keySelector = function;
        this.collectionSupplier = supplier;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            this.source.subscribe(new DistinctSubscriber(subscriber, this.keySelector, (Collection) ExceptionHelper.nullCheck(this.collectionSupplier.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
