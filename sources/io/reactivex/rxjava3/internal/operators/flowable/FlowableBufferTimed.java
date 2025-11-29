package io.reactivex.rxjava3.internal.operators.flowable;

import com.honey.account.x.c;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
    final Supplier<U> bufferSupplier;
    final int maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        U buffer;
        final Supplier<U> bufferSupplier;
        long consumerIndex;
        final int maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;
        Disposable timer;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker w;

        public BufferExactBoundedSubscriber(Subscriber<? super U> subscriber, Supplier<U> supplier, long j, TimeUnit timeUnit, int i, boolean z, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.bufferSupplier = supplier;
            this.timespan = j;
            this.unit = timeUnit;
            this.maxSize = i;
            this.restartTimerOnMaxSize = z;
            this.w = worker;
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                dispose();
            }
        }

        public void dispose() {
            synchronized (this) {
                this.buffer = null;
            }
            this.upstream.cancel();
            this.w.dispose();
        }

        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.buffer;
                this.buffer = null;
            }
            if (u != null) {
                this.queue.offer(u);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this, this);
                }
                this.w.dispose();
            }
        }

        public void onError(Throwable th) {
            synchronized (this) {
                this.buffer = null;
            }
            this.downstream.onError(th);
            this.w.dispose();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r7.restartTimerOnMaxSize == false) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r7.timer.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
            fastPathOrderedEmitMax(r0, false, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8 = r7.bufferSupplier.get();
            java.util.Objects.requireNonNull(r8, "The supplied buffer is null");
            r8 = (java.util.Collection) r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r7.buffer = r8;
            r7.consumerIndex++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0046, code lost:
            if (r7.restartTimerOnMaxSize == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0048, code lost:
            r0 = r7.w;
            r4 = r7.timespan;
            r7.timer = r0.schedulePeriodically(r7, r4, r4, r7.unit);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005a, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r8);
            cancel();
            r7.downstream.onError(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0066, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                U r0 = r7.buffer     // Catch:{ all -> 0x0007 }
                if (r0 != 0) goto L_0x0009
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r8 = move-exception
                goto L_0x0067
            L_0x0009:
                r0.add(r8)     // Catch:{ all -> 0x0007 }
                int r8 = r0.size()     // Catch:{ all -> 0x0007 }
                int r1 = r7.maxSize     // Catch:{ all -> 0x0007 }
                if (r8 >= r1) goto L_0x0016
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                return
            L_0x0016:
                r8 = 0
                r7.buffer = r8     // Catch:{ all -> 0x0007 }
                long r1 = r7.producerIndex     // Catch:{ all -> 0x0007 }
                r3 = 1
                long r1 = r1 + r3
                r7.producerIndex = r1     // Catch:{ all -> 0x0007 }
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                boolean r8 = r7.restartTimerOnMaxSize
                if (r8 == 0) goto L_0x002a
                io.reactivex.rxjava3.disposables.Disposable r8 = r7.timer
                r8.dispose()
            L_0x002a:
                r8 = 0
                r7.fastPathOrderedEmitMax(r0, r8, r7)
                io.reactivex.rxjava3.functions.Supplier<U> r8 = r7.bufferSupplier     // Catch:{ all -> 0x005a }
                java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x005a }
                java.lang.String r0 = "The supplied buffer is null"
                java.util.Objects.requireNonNull(r8, r0)     // Catch:{ all -> 0x005a }
                java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x005a }
                monitor-enter(r7)
                r7.buffer = r8     // Catch:{ all -> 0x0057 }
                long r0 = r7.consumerIndex     // Catch:{ all -> 0x0057 }
                long r0 = r0 + r3
                r7.consumerIndex = r0     // Catch:{ all -> 0x0057 }
                monitor-exit(r7)     // Catch:{ all -> 0x0057 }
                boolean r8 = r7.restartTimerOnMaxSize
                if (r8 == 0) goto L_0x0056
                io.reactivex.rxjava3.core.Scheduler$Worker r0 = r7.w
                long r4 = r7.timespan
                java.util.concurrent.TimeUnit r6 = r7.unit
                r1 = r7
                r2 = r4
                io.reactivex.rxjava3.disposables.Disposable r8 = r0.schedulePeriodically(r1, r2, r4, r6)
                r7.timer = r8
            L_0x0056:
                return
            L_0x0057:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0057 }
                throw r8
            L_0x005a:
                r8 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r8)
                r7.cancel()
                org.reactivestreams.Subscriber<? super V> r7 = r7.downstream
                r7.onError(r8)
                return
            L_0x0067:
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferTimed.BufferExactBoundedSubscriber.onNext(java.lang.Object):void");
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                try {
                    U u = this.bufferSupplier.get();
                    Objects.requireNonNull(u, "The supplied buffer is null");
                    this.buffer = (Collection) u;
                    this.downstream.onSubscribe(this);
                    Scheduler.Worker worker = this.w;
                    long j = this.timespan;
                    this.timer = worker.schedulePeriodically(this, j, j, this.unit);
                    subscription.request(LongCompanionObject.MAX_VALUE);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.w.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.downstream);
                }
            }
        }

        public void request(long j) {
            requested(j);
        }

        public void run() {
            try {
                U u = this.bufferSupplier.get();
                Objects.requireNonNull(u, "The supplied buffer is null");
                U u2 = (Collection) u;
                synchronized (this) {
                    U u3 = this.buffer;
                    if (u3 != null) {
                        if (this.producerIndex == this.consumerIndex) {
                            this.buffer = u2;
                            fastPathOrderedEmitMax(u3, false, this);
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }
    }

    public static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        U buffer;
        final Supplier<U> bufferSupplier;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;

        public BufferExactUnboundedSubscriber(Subscriber<? super U> subscriber, Supplier<U> supplier, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            super(subscriber, new MpscLinkedQueue());
            this.bufferSupplier = supplier;
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            DisposableHelper.dispose(this.timer);
        }

        public void dispose() {
            cancel();
        }

        public boolean isDisposed() {
            return this.timer.get() == DisposableHelper.DISPOSED;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
            r4.queue.offer(r0);
            r4.done = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            if (enter() == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            io.reactivex.rxjava3.internal.util.QueueDrainHelper.drainMaxLoop(r4.queue, r4.downstream, false, (io.reactivex.rxjava3.disposables.Disposable) null, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r4 = this;
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.disposables.Disposable> r0 = r4.timer
                io.reactivex.rxjava3.internal.disposables.DisposableHelper.dispose(r0)
                monitor-enter(r4)
                U r0 = r4.buffer     // Catch:{ all -> 0x000c }
                if (r0 != 0) goto L_0x000e
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                return
            L_0x000c:
                r0 = move-exception
                goto L_0x0029
            L_0x000e:
                r1 = 0
                r4.buffer = r1     // Catch:{ all -> 0x000c }
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<U> r2 = r4.queue
                r2.offer(r0)
                r0 = 1
                r4.done = r0
                boolean r0 = r4.enter()
                if (r0 == 0) goto L_0x0028
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<U> r0 = r4.queue
                org.reactivestreams.Subscriber<? super V> r2 = r4.downstream
                r3 = 0
                io.reactivex.rxjava3.internal.util.QueueDrainHelper.drainMaxLoop(r0, r2, r3, r1, r4)
            L_0x0028:
                return
            L_0x0029:
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferTimed.BufferExactUnboundedSubscriber.onComplete():void");
        }

        public void onError(Throwable th) {
            DisposableHelper.dispose(this.timer);
            synchronized (this) {
                this.buffer = null;
            }
            this.downstream.onError(th);
        }

        public void onNext(T t) {
            synchronized (this) {
                try {
                    U u = this.buffer;
                    if (u != null) {
                        u.add(t);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                try {
                    U u = this.bufferSupplier.get();
                    Objects.requireNonNull(u, "The supplied buffer is null");
                    this.buffer = (Collection) u;
                    this.downstream.onSubscribe(this);
                    if (!this.cancelled) {
                        subscription.request(LongCompanionObject.MAX_VALUE);
                        Scheduler scheduler2 = this.scheduler;
                        long j = this.timespan;
                        Disposable schedulePeriodicallyDirect = scheduler2.schedulePeriodicallyDirect(this, j, j, this.unit);
                        if (!c.a(this.timer, (Object) null, schedulePeriodicallyDirect)) {
                            schedulePeriodicallyDirect.dispose();
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    EmptySubscription.error(th, this.downstream);
                }
            }
        }

        public void request(long j) {
            requested(j);
        }

        public void run() {
            try {
                U u = this.bufferSupplier.get();
                Objects.requireNonNull(u, "The supplied buffer is null");
                U u2 = (Collection) u;
                synchronized (this) {
                    try {
                        U u3 = this.buffer;
                        if (u3 != null) {
                            this.buffer = u2;
                            fastPathEmitMax(u3, false, this);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                this.downstream.onError(th2);
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U u) {
            this.downstream.onNext(u);
            return true;
        }
    }

    public static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {
        final Supplier<U> bufferSupplier;
        final List<U> buffers = new LinkedList();
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker w;

        public final class RemoveFromBuffer implements Runnable {
            private final U buffer;

            public RemoveFromBuffer(U u) {
                this.buffer = u;
            }

            public void run() {
                synchronized (BufferSkipBoundedSubscriber.this) {
                    BufferSkipBoundedSubscriber.this.buffers.remove(this.buffer);
                }
                BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = BufferSkipBoundedSubscriber.this;
                bufferSkipBoundedSubscriber.fastPathOrderedEmitMax(this.buffer, false, bufferSkipBoundedSubscriber.w);
            }
        }

        public BufferSkipBoundedSubscriber(Subscriber<? super U> subscriber, Supplier<U> supplier, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.bufferSupplier = supplier;
            this.timespan = j;
            this.timeskip = j2;
            this.unit = timeUnit;
            this.w = worker;
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.w.dispose();
            clear();
        }

        public void clear() {
            synchronized (this) {
                this.buffers.clear();
            }
        }

        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList<>(this.buffers);
                this.buffers.clear();
            }
            for (Collection offer : arrayList) {
                this.queue.offer(offer);
            }
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this.w, this);
            }
        }

        public void onError(Throwable th) {
            this.done = true;
            this.w.dispose();
            clear();
            this.downstream.onError(th);
        }

        public void onNext(T t) {
            synchronized (this) {
                try {
                    for (U add : this.buffers) {
                        add.add(t);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                try {
                    U u = this.bufferSupplier.get();
                    Objects.requireNonNull(u, "The supplied buffer is null");
                    Collection collection = (Collection) u;
                    this.buffers.add(collection);
                    this.downstream.onSubscribe(this);
                    subscription.request(LongCompanionObject.MAX_VALUE);
                    Scheduler.Worker worker = this.w;
                    long j = this.timeskip;
                    worker.schedulePeriodically(this, j, j, this.unit);
                    this.w.schedule(new RemoveFromBuffer(collection), this.timespan, this.unit);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.w.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.downstream);
                }
            }
        }

        public void request(long j) {
            requested(j);
        }

        public void run() {
            if (!this.cancelled) {
                try {
                    U u = this.bufferSupplier.get();
                    Objects.requireNonNull(u, "The supplied buffer is null");
                    Collection collection = (Collection) u;
                    synchronized (this) {
                        try {
                            if (!this.cancelled) {
                                this.buffers.add(collection);
                                this.w.schedule(new RemoveFromBuffer(collection), this.timespan, this.unit);
                            }
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    this.downstream.onError(th2);
                }
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }
    }

    public FlowableBufferTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler2, Supplier<U> supplier, int i, boolean z) {
        super(flowable);
        this.timespan = j;
        this.timeskip = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.bufferSupplier = supplier;
        this.maxSize = i;
        this.restartTimerOnMaxSize = z;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (this.timespan == this.timeskip && this.maxSize == Integer.MAX_VALUE) {
            this.source.subscribe(new BufferExactUnboundedSubscriber(new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.unit, this.scheduler));
            return;
        }
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        if (this.timespan == this.timeskip) {
            this.source.subscribe(new BufferExactBoundedSubscriber(new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.unit, this.maxSize, this.restartTimerOnMaxSize, createWorker));
        } else {
            this.source.subscribe(new BufferSkipBoundedSubscriber(new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.timeskip, this.unit, createWorker));
        }
    }
}
