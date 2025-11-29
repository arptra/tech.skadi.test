package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super T, ? extends U> mapper;

    public static final class MapConditionalSubscriber<T, U> extends BasicFuseableConditionalSubscriber<T, U> {
        final Function<? super T, ? extends U> mapper;

        public MapConditionalSubscriber(ConditionalSubscriber<? super U> conditionalSubscriber, Function<? super T, ? extends U> function) {
            super(conditionalSubscriber);
            this.mapper = function;
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.downstream.onNext((Object) null);
                    return;
                }
                try {
                    Object apply = this.mapper.apply(t);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    this.downstream.onNext(apply);
                } catch (Throwable th) {
                    fail(th);
                }
            }
        }

        @Nullable
        public U poll() throws Throwable {
            T poll = this.qs.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.mapper.apply(poll);
            Objects.requireNonNull(apply, "The mapper function returned a null value.");
            return apply;
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            try {
                Object apply = this.mapper.apply(t);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                return this.downstream.tryOnNext(apply);
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }
    }

    public static final class MapSubscriber<T, U> extends BasicFuseableSubscriber<T, U> {
        final Function<? super T, ? extends U> mapper;

        public MapSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends U> function) {
            super(subscriber);
            this.mapper = function;
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.downstream.onNext((Object) null);
                    return;
                }
                try {
                    Object apply = this.mapper.apply(t);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    this.downstream.onNext(apply);
                } catch (Throwable th) {
                    fail(th);
                }
            }
        }

        @Nullable
        public U poll() throws Throwable {
            T poll = this.qs.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.mapper.apply(poll);
            Objects.requireNonNull(apply, "The mapper function returned a null value.");
            return apply;
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public FlowableMap(Flowable<T> flowable, Function<? super T, ? extends U> function) {
        super(flowable);
        this.mapper = function;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new MapConditionalSubscriber((ConditionalSubscriber) subscriber, this.mapper));
        } else {
            this.source.subscribe(new MapSubscriber(subscriber, this.mapper));
        }
    }
}
