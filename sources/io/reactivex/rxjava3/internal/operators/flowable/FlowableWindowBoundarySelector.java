package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundarySelector<T, B, V> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final Function<? super B, ? extends Publisher<V>> closingIndicator;
    final Publisher<B> open;

    public static final class WindowBoundaryMainSubscriber<T, B, V> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8646217640096099753L;
        final int bufferSize;
        final Function<? super B, ? extends Publisher<V>> closingIndicator;
        final Subscriber<? super Flowable<T>> downstream;
        final AtomicBoolean downstreamCancelled;
        long emitted;
        final AtomicThrowable error;
        final Publisher<B> open;
        volatile boolean openDone;
        final SimplePlainQueue<Object> queue = new MpscLinkedQueue();
        final AtomicLong requested;
        final CompositeDisposable resources;
        final WindowStartSubscriber<B> startSubscriber;
        Subscription upstream;
        volatile boolean upstreamCanceled;
        volatile boolean upstreamDone;
        final AtomicLong windowCount;
        final List<UnicastProcessor<T>> windows;

        public static final class WindowEndSubscriberIntercept<T, V> extends Flowable<T> implements FlowableSubscriber<V>, Disposable {
            final AtomicBoolean once = new AtomicBoolean();
            final WindowBoundaryMainSubscriber<T, ?, V> parent;
            final AtomicReference<Subscription> upstream = new AtomicReference<>();
            final UnicastProcessor<T> window;

            public WindowEndSubscriberIntercept(WindowBoundaryMainSubscriber<T, ?, V> windowBoundaryMainSubscriber, UnicastProcessor<T> unicastProcessor) {
                this.parent = windowBoundaryMainSubscriber;
                this.window = unicastProcessor;
            }

            public void dispose() {
                SubscriptionHelper.cancel(this.upstream);
            }

            public boolean isDisposed() {
                return this.upstream.get() == SubscriptionHelper.CANCELLED;
            }

            public void onComplete() {
                this.parent.close(this);
            }

            public void onError(Throwable th) {
                if (isDisposed()) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.parent.closeError(th);
                }
            }

            public void onNext(V v) {
                if (SubscriptionHelper.cancel(this.upstream)) {
                    this.parent.close(this);
                }
            }

            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                    subscription.request(LongCompanionObject.MAX_VALUE);
                }
            }

            public void subscribeActual(Subscriber<? super T> subscriber) {
                this.window.subscribe(subscriber);
                this.once.set(true);
            }

            public boolean tryAbandon() {
                return !this.once.get() && this.once.compareAndSet(false, true);
            }
        }

        public static final class WindowStartItem<B> {
            final B item;

            public WindowStartItem(B b) {
                this.item = b;
            }
        }

        public static final class WindowStartSubscriber<B> extends AtomicReference<Subscription> implements FlowableSubscriber<B> {
            private static final long serialVersionUID = -3326496781427702834L;
            final WindowBoundaryMainSubscriber<?, B, ?> parent;

            public WindowStartSubscriber(WindowBoundaryMainSubscriber<?, B, ?> windowBoundaryMainSubscriber) {
                this.parent = windowBoundaryMainSubscriber;
            }

            public void cancel() {
                SubscriptionHelper.cancel(this);
            }

            public void onComplete() {
                this.parent.openComplete();
            }

            public void onError(Throwable th) {
                this.parent.openError(th);
            }

            public void onNext(B b) {
                this.parent.open(b);
            }

            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(LongCompanionObject.MAX_VALUE);
                }
            }
        }

        public WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
            this.downstream = subscriber;
            this.open = publisher;
            this.closingIndicator = function;
            this.bufferSize = i;
            this.resources = new CompositeDisposable();
            this.windows = new ArrayList();
            this.windowCount = new AtomicLong(1);
            this.downstreamCancelled = new AtomicBoolean();
            this.error = new AtomicThrowable();
            this.startSubscriber = new WindowStartSubscriber<>(this);
            this.requested = new AtomicLong();
        }

        public void cancel() {
            if (!this.downstreamCancelled.compareAndSet(false, true)) {
                return;
            }
            if (this.windowCount.decrementAndGet() == 0) {
                this.upstream.cancel();
                this.startSubscriber.cancel();
                this.resources.dispose();
                this.error.tryTerminateAndReport();
                this.upstreamCanceled = true;
                drain();
                return;
            }
            this.startSubscriber.cancel();
        }

        public void close(WindowEndSubscriberIntercept<T, V> windowEndSubscriberIntercept) {
            this.queue.offer(windowEndSubscriberIntercept);
            drain();
        }

        public void closeError(Throwable th) {
            this.upstream.cancel();
            this.startSubscriber.cancel();
            this.resources.dispose();
            if (this.error.tryAddThrowableOrReport(th)) {
                this.upstreamDone = true;
                drain();
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                Subscriber<? super Flowable<T>> subscriber = this.downstream;
                SimplePlainQueue<Object> simplePlainQueue = this.queue;
                List<UnicastProcessor<T>> list = this.windows;
                int i = 1;
                while (true) {
                    if (this.upstreamCanceled) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z = this.upstreamDone;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && (z2 || this.error.get() != null)) {
                            terminateDownstream(subscriber);
                            this.upstreamCanceled = true;
                        } else if (!z2) {
                            if (poll instanceof WindowStartItem) {
                                if (!this.downstreamCancelled.get()) {
                                    long j = this.emitted;
                                    if (this.requested.get() != j) {
                                        this.emitted = j + 1;
                                        try {
                                            Object apply = this.closingIndicator.apply(((WindowStartItem) poll).item);
                                            Objects.requireNonNull(apply, "The closingIndicator returned a null Publisher");
                                            Publisher publisher = (Publisher) apply;
                                            this.windowCount.getAndIncrement();
                                            UnicastProcessor create = UnicastProcessor.create(this.bufferSize, this);
                                            WindowEndSubscriberIntercept windowEndSubscriberIntercept = new WindowEndSubscriberIntercept(this, create);
                                            subscriber.onNext(windowEndSubscriberIntercept);
                                            if (windowEndSubscriberIntercept.tryAbandon()) {
                                                create.onComplete();
                                            } else {
                                                list.add(create);
                                                this.resources.add(windowEndSubscriberIntercept);
                                                publisher.subscribe(windowEndSubscriberIntercept);
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            this.upstream.cancel();
                                            this.startSubscriber.cancel();
                                            this.resources.dispose();
                                            Exceptions.throwIfFatal(th);
                                            this.error.tryAddThrowableOrReport(th);
                                            this.upstreamDone = true;
                                        }
                                    } else {
                                        this.upstream.cancel();
                                        this.startSubscriber.cancel();
                                        this.resources.dispose();
                                        this.error.tryAddThrowableOrReport(new MissingBackpressureException(FlowableWindowTimed.missingBackpressureMessage(j)));
                                        this.upstreamDone = true;
                                    }
                                }
                            } else if (poll instanceof WindowEndSubscriberIntercept) {
                                UnicastProcessor<T> unicastProcessor = ((WindowEndSubscriberIntercept) poll).window;
                                list.remove(unicastProcessor);
                                this.resources.delete((Disposable) poll);
                                unicastProcessor.onComplete();
                            } else {
                                for (UnicastProcessor<T> onNext : list) {
                                    onNext.onNext(poll);
                                }
                            }
                        } else if (this.openDone && list.size() == 0) {
                            this.upstream.cancel();
                            this.startSubscriber.cancel();
                            this.resources.dispose();
                            terminateDownstream(subscriber);
                            this.upstreamCanceled = true;
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            this.startSubscriber.cancel();
            this.resources.dispose();
            this.upstreamDone = true;
            drain();
        }

        public void onError(Throwable th) {
            this.startSubscriber.cancel();
            this.resources.dispose();
            if (this.error.tryAddThrowableOrReport(th)) {
                this.upstreamDone = true;
                drain();
            }
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                this.open.subscribe(this.startSubscriber);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void open(B b) {
            this.queue.offer(new WindowStartItem(b));
            drain();
        }

        public void openComplete() {
            this.openDone = true;
            drain();
        }

        public void openError(Throwable th) {
            this.upstream.cancel();
            this.resources.dispose();
            if (this.error.tryAddThrowableOrReport(th)) {
                this.upstreamDone = true;
                drain();
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
            }
        }

        public void run() {
            if (this.windowCount.decrementAndGet() == 0) {
                this.upstream.cancel();
                this.startSubscriber.cancel();
                this.resources.dispose();
                this.error.tryTerminateAndReport();
                this.upstreamCanceled = true;
                drain();
            }
        }

        public void terminateDownstream(Subscriber<?> subscriber) {
            Throwable terminate = this.error.terminate();
            if (terminate == null) {
                for (UnicastProcessor<T> onComplete : this.windows) {
                    onComplete.onComplete();
                }
                subscriber.onComplete();
            } else if (terminate != ExceptionHelper.TERMINATED) {
                for (UnicastProcessor<T> onError : this.windows) {
                    onError.onError(terminate);
                }
                subscriber.onError(terminate);
            }
        }
    }

    public FlowableWindowBoundarySelector(Flowable<T> flowable, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
        super(flowable);
        this.open = publisher;
        this.closingIndicator = function;
        this.bufferSize = i;
    }

    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.source.subscribe(new WindowBoundaryMainSubscriber(subscriber, this.open, this.closingIndicator, this.bufferSize));
    }
}
