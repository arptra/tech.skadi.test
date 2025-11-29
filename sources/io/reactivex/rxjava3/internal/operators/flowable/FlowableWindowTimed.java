package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public static abstract class AbstractWindowSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 5724293814035355511L;
        final int bufferSize;
        volatile boolean done;
        final Subscriber<? super Flowable<T>> downstream;
        final AtomicBoolean downstreamCancelled;
        long emitted;
        Throwable error;
        final SimplePlainQueue<Object> queue = new MpscLinkedQueue();
        final AtomicLong requested;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        volatile boolean upstreamCancelled;
        final AtomicInteger windowCount;

        public AbstractWindowSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, int i) {
            this.downstream = subscriber;
            this.timespan = j;
            this.unit = timeUnit;
            this.bufferSize = i;
            this.requested = new AtomicLong();
            this.downstreamCancelled = new AtomicBoolean();
            this.windowCount = new AtomicInteger(1);
        }

        public final void cancel() {
            if (this.downstreamCancelled.compareAndSet(false, true)) {
                windowDone();
            }
        }

        public abstract void cleanupResources();

        public abstract void createFirstWindow();

        public abstract void drain();

        public final void onComplete() {
            this.done = true;
            drain();
        }

        public final void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                createFirstWindow();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
            }
        }

        public final void windowDone() {
            if (this.windowCount.decrementAndGet() == 0) {
                cleanupResources();
                this.upstream.cancel();
                this.upstreamCancelled = true;
                drain();
            }
        }
    }

    public static final class WindowExactBoundedSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        private static final long serialVersionUID = -6130475889925953722L;
        long count;
        final long maxSize;
        final boolean restartTimerOnMaxSize;
        final Scheduler scheduler;
        final SequentialDisposable timer;
        UnicastProcessor<T> window;
        final Scheduler.Worker worker;

        public static final class WindowBoundaryRunnable implements Runnable {
            final long index;
            final WindowExactBoundedSubscriber<?> parent;

            public WindowBoundaryRunnable(WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber, long j) {
                this.parent = windowExactBoundedSubscriber;
                this.index = j;
            }

            public void run() {
                this.parent.boundary(this);
            }
        }

        public WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler2, int i, long j2, boolean z) {
            super(subscriber, j, timeUnit, i);
            this.scheduler = scheduler2;
            this.maxSize = j2;
            this.restartTimerOnMaxSize = z;
            if (z) {
                this.worker = scheduler2.createWorker();
            } else {
                this.worker = null;
            }
            this.timer = new SequentialDisposable();
        }

        public void boundary(WindowBoundaryRunnable windowBoundaryRunnable) {
            this.queue.offer(windowBoundaryRunnable);
            drain();
        }

        public void cleanupResources() {
            this.timer.dispose();
            Scheduler.Worker worker2 = this.worker;
            if (worker2 != null) {
                worker2.dispose();
            }
        }

        public void createFirstWindow() {
            if (this.downstreamCancelled.get()) {
                return;
            }
            if (this.requested.get() != 0) {
                this.emitted = 1;
                this.windowCount.getAndIncrement();
                this.window = UnicastProcessor.create(this.bufferSize, this);
                FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(this.window);
                this.downstream.onNext(flowableWindowSubscribeIntercept);
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, 1);
                if (this.restartTimerOnMaxSize) {
                    SequentialDisposable sequentialDisposable = this.timer;
                    Scheduler.Worker worker2 = this.worker;
                    long j = this.timespan;
                    sequentialDisposable.replace(worker2.schedulePeriodically(windowBoundaryRunnable, j, j, this.unit));
                } else {
                    SequentialDisposable sequentialDisposable2 = this.timer;
                    Scheduler scheduler2 = this.scheduler;
                    long j2 = this.timespan;
                    sequentialDisposable2.replace(scheduler2.schedulePeriodicallyDirect(windowBoundaryRunnable, j2, j2, this.unit));
                }
                if (flowableWindowSubscribeIntercept.tryAbandon()) {
                    this.window.onComplete();
                }
                this.upstream.request(LongCompanionObject.MAX_VALUE);
                return;
            }
            this.upstream.cancel();
            this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(this.emitted)));
            cleanupResources();
            this.upstreamCancelled = true;
        }

        public UnicastProcessor<T> createNewWindow(UnicastProcessor<T> unicastProcessor) {
            if (unicastProcessor != null) {
                unicastProcessor.onComplete();
                unicastProcessor = null;
            }
            if (this.downstreamCancelled.get()) {
                cleanupResources();
            } else {
                long j = this.emitted;
                if (this.requested.get() == j) {
                    this.upstream.cancel();
                    cleanupResources();
                    this.upstreamCancelled = true;
                    this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(j)));
                } else {
                    long j2 = j + 1;
                    this.emitted = j2;
                    this.windowCount.getAndIncrement();
                    unicastProcessor = UnicastProcessor.create(this.bufferSize, this);
                    this.window = unicastProcessor;
                    FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessor);
                    this.downstream.onNext(flowableWindowSubscribeIntercept);
                    if (this.restartTimerOnMaxSize) {
                        SequentialDisposable sequentialDisposable = this.timer;
                        Scheduler.Worker worker2 = this.worker;
                        WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, j2);
                        long j3 = this.timespan;
                        sequentialDisposable.update(worker2.schedulePeriodically(windowBoundaryRunnable, j3, j3, this.unit));
                    }
                    if (flowableWindowSubscribeIntercept.tryAbandon()) {
                        unicastProcessor.onComplete();
                    }
                }
            }
            return unicastProcessor;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.queue;
                Subscriber<? super Flowable<T>> subscriber = this.downstream;
                UnicastProcessor<T> unicastProcessor = this.window;
                int i = 1;
                while (true) {
                    if (this.upstreamCancelled) {
                        simplePlainQueue.clear();
                        unicastProcessor = null;
                        this.window = null;
                    } else {
                        boolean z = this.done;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onError(th);
                                }
                                subscriber.onError(th);
                            } else {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                            }
                            cleanupResources();
                            this.upstreamCancelled = true;
                        } else if (!z2) {
                            if (poll instanceof WindowBoundaryRunnable) {
                                if (((WindowBoundaryRunnable) poll).index == this.emitted || !this.restartTimerOnMaxSize) {
                                    this.count = 0;
                                    unicastProcessor = createNewWindow(unicastProcessor);
                                }
                            } else if (unicastProcessor != null) {
                                unicastProcessor.onNext(poll);
                                long j = this.count + 1;
                                if (j == this.maxSize) {
                                    this.count = 0;
                                    unicastProcessor = createNewWindow(unicastProcessor);
                                } else {
                                    this.count = j;
                                }
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        public void run() {
            windowDone();
        }
    }

    public static final class WindowExactUnboundedSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 1155822639622580836L;
        final Scheduler scheduler;
        final SequentialDisposable timer = new SequentialDisposable();
        UnicastProcessor<T> window;
        final Runnable windowRunnable = new WindowRunnable();

        public final class WindowRunnable implements Runnable {
            public WindowRunnable() {
            }

            public void run() {
                WindowExactUnboundedSubscriber.this.windowDone();
            }
        }

        public WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler2, int i) {
            super(subscriber, j, timeUnit, i);
            this.scheduler = scheduler2;
        }

        public void cleanupResources() {
            this.timer.dispose();
        }

        public void createFirstWindow() {
            if (this.downstreamCancelled.get()) {
                return;
            }
            if (this.requested.get() != 0) {
                this.windowCount.getAndIncrement();
                this.window = UnicastProcessor.create(this.bufferSize, this.windowRunnable);
                this.emitted = 1;
                FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(this.window);
                this.downstream.onNext(flowableWindowSubscribeIntercept);
                SequentialDisposable sequentialDisposable = this.timer;
                Scheduler scheduler2 = this.scheduler;
                long j = this.timespan;
                sequentialDisposable.replace(scheduler2.schedulePeriodicallyDirect(this, j, j, this.unit));
                if (flowableWindowSubscribeIntercept.tryAbandon()) {
                    this.window.onComplete();
                }
                this.upstream.request(LongCompanionObject.MAX_VALUE);
                return;
            }
            this.upstream.cancel();
            this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(this.emitted)));
            cleanupResources();
            this.upstreamCancelled = true;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.queue;
                Subscriber<? super Flowable<T>> subscriber = this.downstream;
                UnicastProcessor<T> unicastProcessor = this.window;
                int i = 1;
                while (true) {
                    if (this.upstreamCancelled) {
                        simplePlainQueue.clear();
                        this.window = null;
                        unicastProcessor = null;
                    } else {
                        boolean z = this.done;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onError(th);
                                }
                                subscriber.onError(th);
                            } else {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                            }
                            cleanupResources();
                            this.upstreamCancelled = true;
                        } else if (!z2) {
                            if (poll == NEXT_WINDOW) {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onComplete();
                                    this.window = null;
                                    unicastProcessor = null;
                                }
                                if (this.downstreamCancelled.get()) {
                                    this.timer.dispose();
                                } else {
                                    long j = this.requested.get();
                                    long j2 = this.emitted;
                                    if (j == j2) {
                                        this.upstream.cancel();
                                        cleanupResources();
                                        this.upstreamCancelled = true;
                                        subscriber.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(this.emitted)));
                                    } else {
                                        this.emitted = j2 + 1;
                                        this.windowCount.getAndIncrement();
                                        unicastProcessor = UnicastProcessor.create(this.bufferSize, this.windowRunnable);
                                        this.window = unicastProcessor;
                                        FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessor);
                                        subscriber.onNext(flowableWindowSubscribeIntercept);
                                        if (flowableWindowSubscribeIntercept.tryAbandon()) {
                                            unicastProcessor.onComplete();
                                        }
                                    }
                                }
                            } else if (unicastProcessor != null) {
                                unicastProcessor.onNext(poll);
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        public void run() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }
    }

    public static final class WindowSkipSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        static final Object WINDOW_CLOSE = new Object();
        static final Object WINDOW_OPEN = new Object();
        private static final long serialVersionUID = -7852870764194095894L;
        final long timeskip;
        final List<UnicastProcessor<T>> windows = new LinkedList();
        final Scheduler.Worker worker;

        public static final class WindowBoundaryRunnable implements Runnable {
            final boolean isOpen;
            final WindowSkipSubscriber<?> parent;

            public WindowBoundaryRunnable(WindowSkipSubscriber<?> windowSkipSubscriber, boolean z) {
                this.parent = windowSkipSubscriber;
                this.isOpen = z;
            }

            public void run() {
                this.parent.boundary(this.isOpen);
            }
        }

        public WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker2, int i) {
            super(subscriber, j, timeUnit, i);
            this.timeskip = j2;
            this.worker = worker2;
        }

        public void boundary(boolean z) {
            this.queue.offer(z ? WINDOW_OPEN : WINDOW_CLOSE);
            drain();
        }

        public void cleanupResources() {
            this.worker.dispose();
        }

        public void createFirstWindow() {
            if (this.downstreamCancelled.get()) {
                return;
            }
            if (this.requested.get() != 0) {
                this.emitted = 1;
                this.windowCount.getAndIncrement();
                UnicastProcessor create = UnicastProcessor.create(this.bufferSize, this);
                this.windows.add(create);
                FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(create);
                this.downstream.onNext(flowableWindowSubscribeIntercept);
                this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
                Scheduler.Worker worker2 = this.worker;
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, true);
                long j = this.timeskip;
                worker2.schedulePeriodically(windowBoundaryRunnable, j, j, this.unit);
                if (flowableWindowSubscribeIntercept.tryAbandon()) {
                    create.onComplete();
                    this.windows.remove(create);
                }
                this.upstream.request(LongCompanionObject.MAX_VALUE);
                return;
            }
            this.upstream.cancel();
            this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(this.emitted)));
            cleanupResources();
            this.upstreamCancelled = true;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.queue;
                Subscriber<? super Flowable<T>> subscriber = this.downstream;
                List<UnicastProcessor<T>> list = this.windows;
                int i = 1;
                while (true) {
                    if (this.upstreamCancelled) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z = this.done;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                for (UnicastProcessor<T> onError : list) {
                                    onError.onError(th);
                                }
                                subscriber.onError(th);
                            } else {
                                for (UnicastProcessor<T> onComplete : list) {
                                    onComplete.onComplete();
                                }
                                subscriber.onComplete();
                            }
                            cleanupResources();
                            this.upstreamCancelled = true;
                        } else if (!z2) {
                            if (poll == WINDOW_OPEN) {
                                if (!this.downstreamCancelled.get()) {
                                    long j = this.emitted;
                                    if (this.requested.get() != j) {
                                        this.emitted = j + 1;
                                        this.windowCount.getAndIncrement();
                                        UnicastProcessor create = UnicastProcessor.create(this.bufferSize, this);
                                        list.add(create);
                                        FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(create);
                                        subscriber.onNext(flowableWindowSubscribeIntercept);
                                        this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
                                        if (flowableWindowSubscribeIntercept.tryAbandon()) {
                                            create.onComplete();
                                        }
                                    } else {
                                        this.upstream.cancel();
                                        MissingBackpressureException missingBackpressureException = new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(j));
                                        for (UnicastProcessor<T> onError2 : list) {
                                            onError2.onError(missingBackpressureException);
                                        }
                                        subscriber.onError(missingBackpressureException);
                                        cleanupResources();
                                        this.upstreamCancelled = true;
                                    }
                                }
                            } else if (poll != WINDOW_CLOSE) {
                                for (UnicastProcessor<T> onNext : list) {
                                    onNext.onNext(poll);
                                }
                            } else if (!list.isEmpty()) {
                                list.remove(0).onComplete();
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        public void run() {
            windowDone();
        }
    }

    public FlowableWindowTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler2, long j3, int i, boolean z) {
        super(flowable);
        this.timespan = j;
        this.timeskip = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.maxSize = j3;
        this.bufferSize = i;
        this.restartTimerOnMaxSize = z;
    }

    public static String missingBackpressureMessage(long j) {
        return "Unable to emit the next window (#" + j + ") due to lack of requests. Please make sure the downstream is ready to consume windows.";
    }

    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        if (this.timespan != this.timeskip) {
            this.source.subscribe(new WindowSkipSubscriber(subscriber, this.timespan, this.timeskip, this.unit, this.scheduler.createWorker(), this.bufferSize));
        } else if (this.maxSize == LongCompanionObject.MAX_VALUE) {
            this.source.subscribe(new WindowExactUnboundedSubscriber(subscriber, this.timespan, this.unit, this.scheduler, this.bufferSize));
        } else {
            this.source.subscribe(new WindowExactBoundedSubscriber(subscriber, this.timespan, this.unit, this.scheduler, this.bufferSize, this.maxSize, this.restartTimerOnMaxSize));
        }
    }
}
