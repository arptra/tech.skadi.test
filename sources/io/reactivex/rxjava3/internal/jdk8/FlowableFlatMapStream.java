package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapStream<T, R> extends Flowable<R> {
    final Function<? super T, ? extends Stream<? extends R>> mapper;
    final int prefetch;
    final Flowable<T> source;

    public static final class FlatMapStreamSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5127032662980523968L;
        volatile boolean cancelled;
        int consumed;
        AutoCloseable currentCloseable;
        Iterator<? extends R> currentIterator;
        final Subscriber<? super R> downstream;
        long emitted;
        final AtomicThrowable error = new AtomicThrowable();
        final Function<? super T, ? extends Stream<? extends R>> mapper;
        final int prefetch;
        SimpleQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        int sourceMode;
        Subscription upstream;
        volatile boolean upstreamDone;

        public FlatMapStreamSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Stream<? extends R>> function, int i) {
            this.downstream = subscriber;
            this.mapper = function;
            this.prefetch = i;
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            drain();
        }

        public void clearCurrentRethrowCloseError() throws Throwable {
            this.currentIterator = null;
            AutoCloseable autoCloseable = this.currentCloseable;
            this.currentCloseable = null;
            if (autoCloseable != null) {
                autoCloseable.close();
            }
        }

        public void clearCurrentSuppressCloseError() {
            try {
                clearCurrentRethrowCloseError();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:61:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x00ea A[SYNTHETIC] */
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
                io.reactivex.rxjava3.internal.fuseable.SimpleQueue<T> r3 = r1.queue
                io.reactivex.rxjava3.internal.util.AtomicThrowable r4 = r1.error
                java.util.Iterator<? extends R> r0 = r1.currentIterator
                java.util.concurrent.atomic.AtomicLong r5 = r1.requested
                long r5 = r5.get()
                long r7 = r1.emitted
                int r9 = r1.prefetch
                int r10 = r9 >> 2
                int r9 = r9 - r10
                int r10 = r1.sourceMode
                r11 = 0
                r12 = 1
                if (r10 == r12) goto L_0x0026
                r10 = r12
                goto L_0x0027
            L_0x0026:
                r10 = r11
            L_0x0027:
                r13 = r7
                r8 = r12
                r6 = r5
                r5 = r0
            L_0x002b:
                boolean r0 = r1.cancelled
                if (r0 == 0) goto L_0x0037
                r3.clear()
                r17.clearCurrentSuppressCloseError()
                goto L_0x00e1
            L_0x0037:
                boolean r0 = r1.upstreamDone
                java.lang.Object r15 = r4.get()
                if (r15 == 0) goto L_0x004b
                java.lang.Object r0 = r4.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                r2.onError(r0)
                r1.cancelled = r12
                goto L_0x0094
            L_0x004b:
                if (r5 != 0) goto L_0x00a7
                java.lang.Object r15 = r3.poll()     // Catch:{ all -> 0x009e }
                if (r15 != 0) goto L_0x0056
                r16 = r12
                goto L_0x0058
            L_0x0056:
                r16 = r11
            L_0x0058:
                if (r0 == 0) goto L_0x0062
                if (r16 == 0) goto L_0x0062
                r2.onComplete()
                r1.cancelled = r12
                goto L_0x00a7
            L_0x0062:
                if (r16 != 0) goto L_0x00a7
                if (r10 == 0) goto L_0x0075
                int r0 = r1.consumed
                int r0 = r0 + r12
                r1.consumed = r0
                if (r0 != r9) goto L_0x0075
                r1.consumed = r11
                org.reactivestreams.Subscription r0 = r1.upstream
                long r11 = (long) r9
                r0.request(r11)
            L_0x0075:
                io.reactivex.rxjava3.functions.Function<? super T, ? extends java.util.stream.Stream<? extends R>> r0 = r1.mapper     // Catch:{ all -> 0x0091 }
                java.lang.Object r0 = r0.apply(r15)     // Catch:{ all -> 0x0091 }
                java.lang.String r11 = "The mapper returned a null Stream"
                java.util.Objects.requireNonNull(r0, r11)     // Catch:{ all -> 0x0091 }
                java.util.stream.Stream r0 = (java.util.stream.Stream) r0     // Catch:{ all -> 0x0091 }
                java.util.Iterator r5 = r0.iterator()     // Catch:{ all -> 0x0091 }
                boolean r11 = r5.hasNext()     // Catch:{ all -> 0x0091 }
                if (r11 == 0) goto L_0x0093
                r1.currentIterator = r5     // Catch:{ all -> 0x0091 }
                r1.currentCloseable = r0     // Catch:{ all -> 0x0091 }
                goto L_0x0094
            L_0x0091:
                r0 = move-exception
                goto L_0x0097
            L_0x0093:
                r5 = 0
            L_0x0094:
                r11 = 0
                r12 = 1
                goto L_0x002b
            L_0x0097:
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r1.trySignalError(r2, r0)
                goto L_0x0094
            L_0x009e:
                r0 = move-exception
                r11 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r11)
                r1.trySignalError(r2, r11)
                goto L_0x0094
            L_0x00a7:
                if (r5 == 0) goto L_0x00e1
                int r0 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
                if (r0 == 0) goto L_0x00e1
                java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x00d9 }
                java.lang.String r11 = "The Stream.Iterator returned a null value"
                java.util.Objects.requireNonNull(r0, r11)     // Catch:{ all -> 0x00d9 }
                boolean r11 = r1.cancelled
                if (r11 != 0) goto L_0x0094
                r2.onNext(r0)
                r11 = 1
                long r13 = r13 + r11
                boolean r0 = r1.cancelled
                if (r0 != 0) goto L_0x0094
                boolean r0 = r5.hasNext()     // Catch:{ all -> 0x00d1 }
                if (r0 != 0) goto L_0x0094
                r17.clearCurrentRethrowCloseError()     // Catch:{ all -> 0x00ce }
                goto L_0x0093
            L_0x00ce:
                r0 = move-exception
                r5 = 0
                goto L_0x00d2
            L_0x00d1:
                r0 = move-exception
            L_0x00d2:
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r1.trySignalError(r2, r0)
                goto L_0x0094
            L_0x00d9:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r1.trySignalError(r2, r0)
                goto L_0x0094
            L_0x00e1:
                r1.emitted = r13
                int r0 = -r8
                int r8 = r1.addAndGet(r0)
                if (r8 != 0) goto L_0x00eb
                return
            L_0x00eb:
                java.util.concurrent.atomic.AtomicLong r0 = r1.requested
                long r6 = r0.get()
                goto L_0x0094
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.FlowableFlatMapStream.FlatMapStreamSubscriber.drain():void");
        }

        public void onComplete() {
            this.upstreamDone = true;
            drain();
        }

        public void onError(Throwable th) {
            if (this.error.compareAndSet((Object) null, th)) {
                this.upstreamDone = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onNext(T t) {
            if (this.sourceMode == 2 || this.queue.offer(t)) {
                drain();
                return;
            }
            this.upstream.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        }

        public void onSubscribe(@NonNull Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.upstreamDone = true;
                        this.downstream.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.downstream.onSubscribe(this);
                        subscription.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                subscription.request((long) this.prefetch);
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void trySignalError(Subscriber<?> subscriber, Throwable th) {
            if (this.error.compareAndSet((Object) null, th)) {
                this.upstream.cancel();
                this.cancelled = true;
                subscriber.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }
    }

    public FlowableFlatMapStream(Flowable<T> flowable, Function<? super T, ? extends Stream<? extends R>> function, int i) {
        this.source = flowable;
        this.mapper = function;
        this.prefetch = i;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Stream<? extends R>> function, int i) {
        return new FlatMapStreamSubscriber(subscriber, function, i);
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        Stream stream;
        Flowable<T> flowable = this.source;
        if (flowable instanceof Supplier) {
            try {
                Object obj = ((Supplier) flowable).get();
                if (obj != null) {
                    Object apply = this.mapper.apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null Stream");
                    stream = (Stream) apply;
                } else {
                    stream = null;
                }
                if (stream != null) {
                    FlowableFromStream.subscribeStream(subscriber, stream);
                } else {
                    EmptySubscription.complete(subscriber);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
            }
        } else {
            flowable.subscribe(subscribe(subscriber, this.mapper, this.prefetch));
        }
    }
}
