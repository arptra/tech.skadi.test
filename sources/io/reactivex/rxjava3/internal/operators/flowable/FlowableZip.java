package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZip<T, R> extends Flowable<R> {
    final int bufferSize;
    final boolean delayError;
    final Publisher<? extends T>[] sources;
    final Iterable<? extends Publisher<? extends T>> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2434867452883857743L;
        volatile boolean cancelled;
        final Object[] current;
        final boolean delayErrors;
        final Subscriber<? super R> downstream;
        final AtomicThrowable errors;
        final AtomicLong requested;
        final ZipSubscriber<T, R>[] subscribers;
        final Function<? super Object[], ? extends R> zipper;

        public ZipCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.downstream = subscriber;
            this.zipper = function;
            this.delayErrors = z;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                zipSubscriberArr[i3] = new ZipSubscriber<>(this, i2);
            }
            this.current = new Object[i];
            this.subscribers = zipSubscriberArr;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
            }
        }

        public void cancelAll() {
            for (ZipSubscriber<T, R> cancel : this.subscribers) {
                cancel.cancel();
            }
        }

        public void drain() {
            int i;
            T t;
            T t2;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.downstream;
                ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
                int length = zipSubscriberArr.length;
                Object[] objArr = this.current;
                int i2 = 1;
                do {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (!this.cancelled) {
                            if (this.delayErrors || this.errors.get() == null) {
                                boolean z = false;
                                for (int i3 = 0; i3 < length; i3++) {
                                    ZipSubscriber<T, R> zipSubscriber = zipSubscriberArr[i3];
                                    if (objArr[i3] == null) {
                                        boolean z2 = zipSubscriber.done;
                                        SimpleQueue<T> simpleQueue = zipSubscriber.queue;
                                        if (simpleQueue != null) {
                                            try {
                                                t2 = simpleQueue.poll();
                                            } catch (Throwable th) {
                                                Throwable th2 = th;
                                                Exceptions.throwIfFatal(th2);
                                                this.errors.tryAddThrowableOrReport(th2);
                                                if (!this.delayErrors) {
                                                    cancelAll();
                                                    this.errors.tryTerminateConsumer((Subscriber<?>) subscriber);
                                                    return;
                                                }
                                                t2 = null;
                                                z2 = true;
                                            }
                                        } else {
                                            t2 = null;
                                        }
                                        boolean z3 = t2 == null;
                                        if (z2 && z3) {
                                            cancelAll();
                                            this.errors.tryTerminateConsumer((Subscriber<?>) subscriber);
                                            return;
                                        } else if (!z3) {
                                            objArr[i3] = t2;
                                        } else {
                                            z = true;
                                        }
                                    }
                                }
                                if (z) {
                                    break;
                                }
                                try {
                                    Object apply = this.zipper.apply(objArr.clone());
                                    Objects.requireNonNull(apply, "The zipper returned a null value");
                                    subscriber.onNext(apply);
                                    j2++;
                                    Arrays.fill(objArr, (Object) null);
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    cancelAll();
                                    this.errors.tryAddThrowableOrReport(th3);
                                    this.errors.tryTerminateConsumer((Subscriber<?>) subscriber);
                                    return;
                                }
                            } else {
                                cancelAll();
                                this.errors.tryTerminateConsumer((Subscriber<?>) subscriber);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (i == 0) {
                        if (!this.cancelled) {
                            if (this.delayErrors || this.errors.get() == null) {
                                for (int i4 = 0; i4 < length; i4++) {
                                    ZipSubscriber<T, R> zipSubscriber2 = zipSubscriberArr[i4];
                                    if (objArr[i4] == null) {
                                        boolean z4 = zipSubscriber2.done;
                                        SimpleQueue<T> simpleQueue2 = zipSubscriber2.queue;
                                        if (simpleQueue2 != null) {
                                            try {
                                                t = simpleQueue2.poll();
                                            } catch (Throwable th4) {
                                                Throwable th5 = th4;
                                                Exceptions.throwIfFatal(th5);
                                                this.errors.tryAddThrowableOrReport(th5);
                                                if (!this.delayErrors) {
                                                    cancelAll();
                                                    this.errors.tryTerminateConsumer((Subscriber<?>) subscriber);
                                                    return;
                                                }
                                                t = null;
                                                z4 = true;
                                            }
                                        } else {
                                            t = null;
                                        }
                                        boolean z5 = t == null;
                                        if (z4 && z5) {
                                            cancelAll();
                                            this.errors.tryTerminateConsumer((Subscriber<?>) subscriber);
                                            return;
                                        } else if (!z5) {
                                            objArr[i4] = t;
                                        }
                                    }
                                }
                            } else {
                                cancelAll();
                                this.errors.tryTerminateConsumer((Subscriber<?>) subscriber);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (j2 != 0) {
                        for (ZipSubscriber<T, R> request : zipSubscriberArr) {
                            request.request(j2);
                        }
                        if (j != LongCompanionObject.MAX_VALUE) {
                            this.requested.addAndGet(-j2);
                        }
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        public void error(ZipSubscriber<T, R> zipSubscriber, Throwable th) {
            if (this.errors.tryAddThrowableOrReport(th)) {
                zipSubscriber.done = true;
                drain();
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void subscribe(Publisher<? extends T>[] publisherArr, int i) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            int i2 = 0;
            while (i2 < i && !this.cancelled) {
                if (this.delayErrors || this.errors.get() == null) {
                    publisherArr[i2].subscribe(zipSubscriberArr[i2]);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4627193790118206028L;
        volatile boolean done;
        final int limit;
        final ZipCoordinator<T, R> parent;
        final int prefetch;
        long produced;
        SimpleQueue<T> queue;
        int sourceMode;

        public ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.parent = zipCoordinator;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        public void onNext(T t) {
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            this.parent.drain();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                subscription.request((long) this.prefetch);
            }
        }

        public void request(long j) {
            if (this.sourceMode != 1) {
                long j2 = this.produced + j;
                if (j2 >= ((long) this.limit)) {
                    this.produced = 0;
                    ((Subscription) get()).request(j2);
                    return;
                }
                this.produced = j2;
            }
        }
    }

    public FlowableZip(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.sources = publisherArr;
        this.sourcesIterable = iterable;
        this.zipper = function;
        this.bufferSize = i;
        this.delayError = z;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.sources;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            length = 0;
            for (Publisher<? extends T> publisher : this.sourcesIterable) {
                if (length == publisherArr.length) {
                    Publisher<? extends T>[] publisherArr2 = new Publisher[((length >> 2) + length)];
                    System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                    publisherArr = publisherArr2;
                }
                publisherArr[length] = publisher;
                length++;
            }
        } else {
            length = publisherArr.length;
        }
        int i = length;
        if (i == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(subscriber, this.zipper, i, this.bufferSize, this.delayError);
        subscriber.onSubscribe(zipCoordinator);
        zipCoordinator.subscribe(publisherArr, i);
    }
}
