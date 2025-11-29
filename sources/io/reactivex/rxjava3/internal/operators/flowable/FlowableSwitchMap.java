package io.reactivex.rxjava3.internal.operators.flowable;

import com.honey.account.x.c;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;

    public static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long index;
        final SwitchMapSubscriber<T, R> parent;
        volatile SimpleQueue<R> queue;

        public SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> switchMapSubscriber, long j, int i) {
            this.parent = switchMapSubscriber;
            this.index = j;
            this.bufferSize = i;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique) {
                this.done = true;
                switchMapSubscriber.drain();
            }
        }

        public void onError(Throwable th) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index != switchMapSubscriber.unique || !switchMapSubscriber.errors.tryAddThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!switchMapSubscriber.delayErrors) {
                switchMapSubscriber.upstream.cancel();
                switchMapSubscriber.done = true;
            }
            this.done = true;
            switchMapSubscriber.drain();
        }

        public void onNext(R r) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index != switchMapSubscriber.unique) {
                return;
            }
            if (this.fusionMode != 0 || this.queue.offer(r)) {
                switchMapSubscriber.drain();
            } else {
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request((long) this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                subscription.request((long) this.bufferSize);
            }
        }

        public void request(long j) {
            if (this.fusionMode != 1) {
                ((Subscription) get()).request(j);
            }
        }
    }

    public static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final SwitchMapInnerSubscriber<Object, Object> CANCELLED;
        private static final long serialVersionUID = -3491074160481096299L;
        final AtomicReference<SwitchMapInnerSubscriber<T, R>> active = new AtomicReference<>();
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final AtomicThrowable errors;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final AtomicLong requested = new AtomicLong();
        volatile long unique;
        Subscription upstream;

        static {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = new SwitchMapInnerSubscriber<>((SwitchMapSubscriber) null, -1, 1);
            CANCELLED = switchMapInnerSubscriber;
            switchMapInnerSubscriber.cancel();
        }

        public SwitchMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
            this.downstream = subscriber;
            this.mapper = function;
            this.bufferSize = i;
            this.delayErrors = z;
            this.errors = new AtomicThrowable();
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                disposeInner();
                this.errors.tryTerminateAndReport();
            }
        }

        public void disposeInner() {
            AtomicReference<SwitchMapInnerSubscriber<T, R>> atomicReference = this.active;
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = CANCELLED;
            SwitchMapInnerSubscriber<Object, Object> andSet = atomicReference.getAndSet(switchMapInnerSubscriber);
            if (andSet != switchMapInnerSubscriber && andSet != null) {
                andSet.cancel();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0095, code lost:
            r15 = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
                r17 = this;
                r1 = r17
                int r0 = r17.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super R> r2 = r1.downstream
                r4 = 1
            L_0x000c:
                boolean r0 = r1.cancelled
                if (r0 == 0) goto L_0x0011
                return
            L_0x0011:
                boolean r0 = r1.done
                if (r0 == 0) goto L_0x0046
                boolean r0 = r1.delayErrors
                if (r0 == 0) goto L_0x0027
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                java.lang.Object r0 = r0.get()
                if (r0 != 0) goto L_0x0046
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
                r0.tryTerminateConsumer((org.reactivestreams.Subscriber<?>) r2)
                return
            L_0x0027:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x003a
                r17.disposeInner()
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
                r0.tryTerminateConsumer((org.reactivestreams.Subscriber<?>) r2)
                return
            L_0x003a:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                java.lang.Object r0 = r0.get()
                if (r0 != 0) goto L_0x0046
                r2.onComplete()
                return
            L_0x0046:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                java.lang.Object r0 = r0.get()
                r5 = r0
                io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap.SwitchMapInnerSubscriber) r5
                r6 = 0
                if (r5 == 0) goto L_0x0056
                io.reactivex.rxjava3.internal.fuseable.SimpleQueue<R> r0 = r5.queue
                r7 = r0
                goto L_0x0057
            L_0x0056:
                r7 = r6
            L_0x0057:
                if (r7 == 0) goto L_0x011d
                java.util.concurrent.atomic.AtomicLong r0 = r1.requested
                long r8 = r0.get()
                r10 = 0
                r12 = r10
            L_0x0062:
                int r14 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
                if (r14 == 0) goto L_0x00c7
                boolean r0 = r1.cancelled
                if (r0 == 0) goto L_0x006b
                return
            L_0x006b:
                boolean r0 = r5.done
                java.lang.Object r16 = r7.poll()     // Catch:{ all -> 0x0074 }
                r3 = r16
                goto L_0x0086
            L_0x0074:
                r0 = move-exception
                r16 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r16)
                r5.cancel()
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
                r3 = r16
                r0.tryAddThrowableOrReport(r3)
                r3 = r6
                r0 = 1
            L_0x0086:
                if (r3 != 0) goto L_0x008b
                r16 = 1
                goto L_0x008d
            L_0x008b:
                r16 = 0
            L_0x008d:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r15 = r1.active
                java.lang.Object r15 = r15.get()
                if (r5 == r15) goto L_0x0097
            L_0x0095:
                r15 = 1
                goto L_0x00c8
            L_0x0097:
                if (r0 == 0) goto L_0x00bd
                boolean r0 = r1.delayErrors
                if (r0 != 0) goto L_0x00b5
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x00ad
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
                r0.tryTerminateConsumer((org.reactivestreams.Subscriber<?>) r2)
                return
            L_0x00ad:
                if (r16 == 0) goto L_0x00bd
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                com.honey.account.x.c.a(r0, r5, r6)
                goto L_0x0095
            L_0x00b5:
                if (r16 == 0) goto L_0x00bd
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                com.honey.account.x.c.a(r0, r5, r6)
                goto L_0x0095
            L_0x00bd:
                if (r16 == 0) goto L_0x00c0
                goto L_0x00c7
            L_0x00c0:
                r2.onNext(r3)
                r14 = 1
                long r12 = r12 + r14
                goto L_0x0062
            L_0x00c7:
                r15 = 0
            L_0x00c8:
                if (r14 != 0) goto L_0x00ff
                boolean r0 = r5.done
                if (r0 == 0) goto L_0x00ff
                boolean r0 = r1.delayErrors
                if (r0 != 0) goto L_0x00f2
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x00e5
                r17.disposeInner()
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r1.errors
                r0.tryTerminateConsumer((org.reactivestreams.Subscriber<?>) r2)
                return
            L_0x00e5:
                boolean r0 = r7.isEmpty()
                if (r0 == 0) goto L_0x00ff
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                com.honey.account.x.c.a(r0, r5, r6)
                goto L_0x000c
            L_0x00f2:
                boolean r0 = r7.isEmpty()
                if (r0 == 0) goto L_0x00ff
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
                com.honey.account.x.c.a(r0, r5, r6)
                goto L_0x000c
            L_0x00ff:
                int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
                if (r0 == 0) goto L_0x0119
                boolean r0 = r1.cancelled
                if (r0 != 0) goto L_0x0119
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r0 == 0) goto L_0x0116
                java.util.concurrent.atomic.AtomicLong r0 = r1.requested
                long r6 = -r12
                r0.addAndGet(r6)
            L_0x0116:
                r5.request(r12)
            L_0x0119:
                if (r15 == 0) goto L_0x011d
                goto L_0x000c
            L_0x011d:
                int r0 = -r4
                int r4 = r1.addAndGet(r0)
                if (r4 != 0) goto L_0x000c
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap.SwitchMapSubscriber.drain():void");
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        public void onError(Throwable th) {
            if (this.done || !this.errors.tryAddThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
        }

        public void onNext(T t) {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber;
            if (!this.done) {
                long j = this.unique + 1;
                this.unique = j;
                SwitchMapInnerSubscriber switchMapInnerSubscriber2 = this.active.get();
                if (switchMapInnerSubscriber2 != null) {
                    switchMapInnerSubscriber2.cancel();
                }
                try {
                    Object apply = this.mapper.apply(t);
                    Objects.requireNonNull(apply, "The publisher returned is null");
                    Publisher publisher = (Publisher) apply;
                    SwitchMapInnerSubscriber switchMapInnerSubscriber3 = new SwitchMapInnerSubscriber(this, j, this.bufferSize);
                    do {
                        switchMapInnerSubscriber = this.active.get();
                        if (switchMapInnerSubscriber == CANCELLED) {
                            return;
                        }
                    } while (!c.a(this.active, switchMapInnerSubscriber, switchMapInnerSubscriber3));
                    publisher.subscribe(switchMapInnerSubscriber3);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    onError(th);
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
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                if (this.unique == 0) {
                    this.upstream.request(LongCompanionObject.MAX_VALUE);
                } else {
                    drain();
                }
            }
        }
    }

    public FlowableSwitchMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.mapper = function;
        this.bufferSize = i;
        this.delayErrors = z;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.mapper)) {
            this.source.subscribe(new SwitchMapSubscriber(subscriber, this.mapper, this.bufferSize, this.delayErrors));
        }
    }
}
