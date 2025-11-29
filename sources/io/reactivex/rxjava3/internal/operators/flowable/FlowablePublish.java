package io.reactivex.rxjava3.internal.operators.flowable;

import com.honey.account.x.c;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
    final int bufferSize;
    final AtomicReference<PublishConnection<T>> current = new AtomicReference<>();
    final Publisher<T> source;

    public static final class InnerSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 2845000326761540265L;
        final Subscriber<? super T> downstream;
        long emitted;
        final PublishConnection<T> parent;

        public InnerSubscription(Subscriber<? super T> subscriber, PublishConnection<T> publishConnection) {
            this.downstream = subscriber;
            this.parent = publishConnection;
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.drain();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                this.parent.drain();
            }
        }
    }

    public static final class PublishConnection<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] EMPTY = new InnerSubscription[0];
        static final InnerSubscription[] TERMINATED = new InnerSubscription[0];
        private static final long serialVersionUID = -1672047311619175801L;
        final int bufferSize;
        final AtomicBoolean connect = new AtomicBoolean();
        int consumed;
        final AtomicReference<PublishConnection<T>> current;
        volatile boolean done;
        Throwable error;
        volatile SimpleQueue<T> queue;
        int sourceMode;
        final AtomicReference<InnerSubscription<T>[]> subscribers;
        final AtomicReference<Subscription> upstream = new AtomicReference<>();

        public PublishConnection(AtomicReference<PublishConnection<T>> atomicReference, int i) {
            this.current = atomicReference;
            this.bufferSize = i;
            this.subscribers = new AtomicReference<>(EMPTY);
        }

        public boolean add(InnerSubscription<T> innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.subscribers.get();
                if (innerSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[(length + 1)];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!c.a(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        public boolean checkTerminated(boolean z, boolean z2) {
            if (!z || !z2) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                signalError(th);
                return true;
            }
            for (InnerSubscription innerSubscription : (InnerSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                if (!innerSubscription.isCancelled()) {
                    innerSubscription.downstream.onComplete();
                }
            }
            return true;
        }

        public void dispose() {
            this.subscribers.getAndSet(TERMINATED);
            c.a(this.current, this, (Object) null);
            SubscriptionHelper.cancel(this.upstream);
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.queue;
                int i = this.consumed;
                int i2 = this.bufferSize;
                int i3 = i2 - (i2 >> 2);
                boolean z = this.sourceMode != 1;
                int i4 = 1;
                int i5 = i;
                SimpleQueue<T> simpleQueue2 = simpleQueue;
                int i6 = i5;
                while (true) {
                    if (simpleQueue2 != null) {
                        InnerSubscription<T>[] innerSubscriptionArr = (InnerSubscription[]) this.subscribers.get();
                        long j = LongCompanionObject.MAX_VALUE;
                        boolean z2 = false;
                        for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                            long j2 = innerSubscription.get();
                            if (j2 != Long.MIN_VALUE) {
                                j = Math.min(j2 - innerSubscription.emitted, j);
                                z2 = true;
                            }
                        }
                        long j3 = 0;
                        if (!z2) {
                            j = 0;
                        }
                        while (true) {
                            if (j == j3) {
                                break;
                            }
                            boolean z3 = this.done;
                            try {
                                T poll = simpleQueue2.poll();
                                boolean z4 = poll == null;
                                if (!checkTerminated(z3, z4)) {
                                    if (z4) {
                                        break;
                                    }
                                    for (InnerSubscription<T> innerSubscription2 : innerSubscriptionArr) {
                                        if (!innerSubscription2.isCancelled()) {
                                            innerSubscription2.downstream.onNext(poll);
                                            innerSubscription2.emitted++;
                                        }
                                    }
                                    if (z && (i6 = i6 + 1) == i3) {
                                        this.upstream.get().request((long) i3);
                                        i6 = 0;
                                    }
                                    j--;
                                    if (innerSubscriptionArr != this.subscribers.get()) {
                                        break;
                                    }
                                    j3 = 0;
                                } else {
                                    return;
                                }
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                Exceptions.throwIfFatal(th2);
                                this.upstream.get().cancel();
                                simpleQueue2.clear();
                                this.done = true;
                                signalError(th2);
                                return;
                            }
                        }
                        if (checkTerminated(this.done, simpleQueue2.isEmpty())) {
                            return;
                        }
                    }
                    this.consumed = i6;
                    i4 = addAndGet(-i4);
                    if (i4 != 0) {
                        if (simpleQueue2 == null) {
                            simpleQueue2 = this.queue;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                drain();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request((long) this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                subscription.request((long) this.bufferSize);
            }
        }

        public void remove(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length != 0) {
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        } else if (innerSubscriptionArr[i] == innerSubscription) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerSubscriptionArr2 = EMPTY;
                        } else {
                            InnerSubscription[] innerSubscriptionArr3 = new InnerSubscription[(length - 1)];
                            System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i);
                            System.arraycopy(innerSubscriptionArr, i + 1, innerSubscriptionArr3, i, (length - i) - 1);
                            innerSubscriptionArr2 = innerSubscriptionArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!c.a(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
        }

        public void signalError(Throwable th) {
            for (InnerSubscription innerSubscription : (InnerSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                if (!innerSubscription.isCancelled()) {
                    innerSubscription.downstream.onError(th);
                }
            }
        }
    }

    public FlowablePublish(Publisher<T> publisher, int i) {
        this.source = publisher;
        this.bufferSize = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.rxjava3.functions.Consumer<? super io.reactivex.rxjava3.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r0 = r4.current
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish.PublishConnection) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0023
        L_0x0010:
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection r1 = new io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r2 = r4.current
            int r3 = r4.bufferSize
            r1.<init>(r2, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r2 = r4.current
            boolean r0 = com.honey.account.x.c.a(r2, r0, r1)
            if (r0 != 0) goto L_0x0022
            goto L_0x0000
        L_0x0022:
            r0 = r1
        L_0x0023:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.connect
            boolean r1 = r1.get()
            r2 = 0
            if (r1 != 0) goto L_0x0036
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.connect
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0036
            r2 = r3
        L_0x0036:
            r5.accept(r0)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0040
            org.reactivestreams.Publisher<T> r4 = r4.source
            r4.subscribe(r0)
        L_0x0040:
            return
        L_0x0041:
            r4 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
            java.lang.RuntimeException r4 = io.reactivex.rxjava3.internal.util.ExceptionHelper.wrapOrThrow(r4)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish.connect(io.reactivex.rxjava3.functions.Consumer):void");
    }

    public void reset() {
        PublishConnection publishConnection = this.current.get();
        if (publishConnection != null && publishConnection.isDisposed()) {
            c.a(this.current, publishConnection, (Object) null);
        }
    }

    public Publisher<T> source() {
        return this.source;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r0 = r4.current
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish.PublishConnection) r0
            if (r0 != 0) goto L_0x001d
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection r1 = new io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r2 = r4.current
            int r3 = r4.bufferSize
            r1.<init>(r2, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r2 = r4.current
            boolean r0 = com.honey.account.x.c.a(r2, r0, r1)
            if (r0 != 0) goto L_0x001c
            goto L_0x0000
        L_0x001c:
            r0 = r1
        L_0x001d:
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$InnerSubscription r4 = new io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$InnerSubscription
            r4.<init>(r5, r0)
            r5.onSubscribe(r4)
            boolean r5 = r0.add(r4)
            if (r5 == 0) goto L_0x0039
            boolean r5 = r4.isCancelled()
            if (r5 == 0) goto L_0x0035
            r0.remove(r4)
            goto L_0x0038
        L_0x0035:
            r0.drain()
        L_0x0038:
            return
        L_0x0039:
            java.lang.Throwable r5 = r0.error
            if (r5 == 0) goto L_0x0043
            org.reactivestreams.Subscriber<? super T> r4 = r4.downstream
            r4.onError(r5)
            goto L_0x0048
        L_0x0043:
            org.reactivestreams.Subscriber<? super T> r4 = r4.downstream
            r4.onComplete()
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish.subscribeActual(org.reactivestreams.Subscriber):void");
    }
}
