package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelCollector<T, A, R> extends Flowable<R> {
    final Collector<T, A, R> collector;
    final ParallelFlowable<? extends T> source;

    public static final class ParallelCollectorInnerSubscriber<T, A, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        final BiConsumer<A, T> accumulator;
        final BinaryOperator<A> combiner;
        A container;
        boolean done;
        final ParallelCollectorSubscriber<T, A, R> parent;

        public ParallelCollectorInnerSubscriber(ParallelCollectorSubscriber<T, A, R> parallelCollectorSubscriber, A a2, BiConsumer<A, T> biConsumer, BinaryOperator<A> binaryOperator) {
            this.parent = parallelCollectorSubscriber;
            this.accumulator = biConsumer;
            this.combiner = binaryOperator;
            this.container = a2;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            if (!this.done) {
                A a2 = this.container;
                this.container = null;
                this.done = true;
                this.parent.innerComplete(a2, this.combiner);
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.container = null;
            this.done = true;
            this.parent.innerError(th);
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.accumulator.accept(this.container, t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    ((Subscription) get()).cancel();
                    onError(th);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LongCompanionObject.MAX_VALUE);
        }
    }

    public static final class ParallelCollectorSubscriber<T, A, R> extends DeferredScalarSubscription<R> {
        private static final long serialVersionUID = -5370107872170712765L;
        final AtomicReference<SlotPair<A>> current = new AtomicReference<>();
        final AtomicThrowable error = new AtomicThrowable();
        final Function<A, R> finisher;
        final AtomicInteger remaining = new AtomicInteger();
        final ParallelCollectorInnerSubscriber<T, A, R>[] subscribers;

        public ParallelCollectorSubscriber(Subscriber<? super R> subscriber, int i, Collector<T, A, R> collector) {
            super(subscriber);
            this.finisher = collector.finisher();
            ParallelCollectorInnerSubscriber<T, A, R>[] parallelCollectorInnerSubscriberArr = new ParallelCollectorInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                parallelCollectorInnerSubscriberArr[i2] = new ParallelCollectorInnerSubscriber<>(this, collector.supplier().get(), collector.accumulator(), collector.combiner());
            }
            this.subscribers = parallelCollectorInnerSubscriberArr;
            this.remaining.lazySet(i);
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [A, T] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.reactivex.rxjava3.internal.jdk8.ParallelCollector.SlotPair<A> addValue(A r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r0 = r3.current
                java.lang.Object r0 = r0.get()
                io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair r0 = (io.reactivex.rxjava3.internal.jdk8.ParallelCollector.SlotPair) r0
                r1 = 0
                if (r0 != 0) goto L_0x0019
                io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair r0 = new io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair
                r0.<init>()
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r2 = r3.current
                boolean r2 = com.honey.account.x.c.a(r2, r1, r0)
                if (r2 != 0) goto L_0x0019
                goto L_0x0000
            L_0x0019:
                int r2 = r0.tryAcquireSlot()
                if (r2 >= 0) goto L_0x0025
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r2 = r3.current
                com.honey.account.x.c.a(r2, r0, r1)
                goto L_0x0000
            L_0x0025:
                if (r2 != 0) goto L_0x002a
                r0.first = r4
                goto L_0x002c
            L_0x002a:
                r0.second = r4
            L_0x002c:
                boolean r4 = r0.releaseSlot()
                if (r4 == 0) goto L_0x0038
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair<A>> r3 = r3.current
                com.honey.account.x.c.a(r3, r0, r1)
                return r0
            L_0x0038:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ParallelCollector.ParallelCollectorSubscriber.addValue(java.lang.Object):io.reactivex.rxjava3.internal.jdk8.ParallelCollector$SlotPair");
        }

        public void cancel() {
            for (ParallelCollectorInnerSubscriber<T, A, R> cancel : this.subscribers) {
                cancel.cancel();
            }
        }

        public void innerComplete(A a2, BinaryOperator<A> binaryOperator) {
            while (true) {
                SlotPair addValue = addValue(a2);
                if (addValue == null) {
                    break;
                }
                try {
                    a2 = binaryOperator.apply(addValue.first, addValue.second);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    innerError(th);
                    return;
                }
            }
            if (this.remaining.decrementAndGet() == 0) {
                SlotPair slotPair = this.current.get();
                this.current.lazySet((Object) null);
                try {
                    R apply = this.finisher.apply(slotPair.first);
                    Objects.requireNonNull(apply, "The finisher returned a null value");
                    complete(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    innerError(th2);
                }
            }
        }

        public void innerError(Throwable th) {
            if (this.error.compareAndSet((Object) null, th)) {
                cancel();
                this.downstream.onError(th);
            } else if (th != this.error.get()) {
                RxJavaPlugins.onError(th);
            }
        }
    }

    public static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        T first;
        final AtomicInteger releaseIndex = new AtomicInteger();
        T second;

        public boolean releaseSlot() {
            return this.releaseIndex.incrementAndGet() == 2;
        }

        public int tryAcquireSlot() {
            int i;
            do {
                i = get();
                if (i >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i, i + 1));
            return i;
        }
    }

    public ParallelCollector(ParallelFlowable<? extends T> parallelFlowable, Collector<T, A, R> collector2) {
        this.source = parallelFlowable;
        this.collector = collector2;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            ParallelCollectorSubscriber parallelCollectorSubscriber = new ParallelCollectorSubscriber(subscriber, this.source.parallelism(), this.collector);
            subscriber.onSubscribe(parallelCollectorSubscriber);
            this.source.subscribe(parallelCollectorSubscriber.subscribers);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
