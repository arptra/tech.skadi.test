package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int bufferSize;
    final Function<? super B, ? extends ObservableSource<V>> closingIndicator;
    final ObservableSource<B> open;

    public static final class WindowBoundaryMainObserver<T, B, V> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 8646217640096099753L;
        final int bufferSize;
        final Function<? super B, ? extends ObservableSource<V>> closingIndicator;
        final Observer<? super Observable<T>> downstream;
        final AtomicBoolean downstreamDisposed;
        long emitted;
        final AtomicThrowable error;
        final ObservableSource<B> open;
        volatile boolean openDone;
        final SimplePlainQueue<Object> queue = new MpscLinkedQueue();
        final AtomicLong requested;
        final CompositeDisposable resources;
        final WindowStartObserver<B> startObserver;
        Disposable upstream;
        volatile boolean upstreamCanceled;
        volatile boolean upstreamDone;
        final AtomicLong windowCount;
        final List<UnicastSubject<T>> windows;

        public static final class WindowEndObserverIntercept<T, V> extends Observable<T> implements Observer<V>, Disposable {
            final AtomicBoolean once = new AtomicBoolean();
            final WindowBoundaryMainObserver<T, ?, V> parent;
            final AtomicReference<Disposable> upstream = new AtomicReference<>();
            final UnicastSubject<T> window;

            public WindowEndObserverIntercept(WindowBoundaryMainObserver<T, ?, V> windowBoundaryMainObserver, UnicastSubject<T> unicastSubject) {
                this.parent = windowBoundaryMainObserver;
                this.window = unicastSubject;
            }

            public void dispose() {
                DisposableHelper.dispose(this.upstream);
            }

            public boolean isDisposed() {
                return this.upstream.get() == DisposableHelper.DISPOSED;
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
                if (DisposableHelper.dispose(this.upstream)) {
                    this.parent.close(this);
                }
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this.upstream, disposable);
            }

            public void subscribeActual(Observer<? super T> observer) {
                this.window.subscribe(observer);
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

        public static final class WindowStartObserver<B> extends AtomicReference<Disposable> implements Observer<B> {
            private static final long serialVersionUID = -3326496781427702834L;
            final WindowBoundaryMainObserver<?, B, ?> parent;

            public WindowStartObserver(WindowBoundaryMainObserver<?, B, ?> windowBoundaryMainObserver) {
                this.parent = windowBoundaryMainObserver;
            }

            public void dispose() {
                DisposableHelper.dispose(this);
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

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, ObservableSource<B> observableSource, Function<? super B, ? extends ObservableSource<V>> function, int i) {
            this.downstream = observer;
            this.open = observableSource;
            this.closingIndicator = function;
            this.bufferSize = i;
            this.resources = new CompositeDisposable();
            this.windows = new ArrayList();
            this.windowCount = new AtomicLong(1);
            this.downstreamDisposed = new AtomicBoolean();
            this.error = new AtomicThrowable();
            this.startObserver = new WindowStartObserver<>(this);
            this.requested = new AtomicLong();
        }

        public void close(WindowEndObserverIntercept<T, V> windowEndObserverIntercept) {
            this.queue.offer(windowEndObserverIntercept);
            drain();
        }

        public void closeError(Throwable th) {
            this.upstream.dispose();
            this.startObserver.dispose();
            this.resources.dispose();
            if (this.error.tryAddThrowableOrReport(th)) {
                this.upstreamDone = true;
                drain();
            }
        }

        public void dispose() {
            if (!this.downstreamDisposed.compareAndSet(false, true)) {
                return;
            }
            if (this.windowCount.decrementAndGet() == 0) {
                this.upstream.dispose();
                this.startObserver.dispose();
                this.resources.dispose();
                this.error.tryTerminateAndReport();
                this.upstreamCanceled = true;
                drain();
                return;
            }
            this.startObserver.dispose();
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                Observer<? super Observable<T>> observer = this.downstream;
                SimplePlainQueue<Object> simplePlainQueue = this.queue;
                List<UnicastSubject<T>> list = this.windows;
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
                            terminateDownstream(observer);
                            this.upstreamCanceled = true;
                        } else if (!z2) {
                            if (poll instanceof WindowStartItem) {
                                if (!this.downstreamDisposed.get()) {
                                    try {
                                        Object apply = this.closingIndicator.apply(((WindowStartItem) poll).item);
                                        Objects.requireNonNull(apply, "The closingIndicator returned a null ObservableSource");
                                        ObservableSource observableSource = (ObservableSource) apply;
                                        this.windowCount.getAndIncrement();
                                        UnicastSubject create = UnicastSubject.create(this.bufferSize, this);
                                        WindowEndObserverIntercept windowEndObserverIntercept = new WindowEndObserverIntercept(this, create);
                                        observer.onNext(windowEndObserverIntercept);
                                        if (windowEndObserverIntercept.tryAbandon()) {
                                            create.onComplete();
                                        } else {
                                            list.add(create);
                                            this.resources.add(windowEndObserverIntercept);
                                            observableSource.subscribe(windowEndObserverIntercept);
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.upstream.dispose();
                                        this.startObserver.dispose();
                                        this.resources.dispose();
                                        Exceptions.throwIfFatal(th);
                                        this.error.tryAddThrowableOrReport(th);
                                        this.upstreamDone = true;
                                    }
                                }
                            } else if (poll instanceof WindowEndObserverIntercept) {
                                UnicastSubject<T> unicastSubject = ((WindowEndObserverIntercept) poll).window;
                                list.remove(unicastSubject);
                                this.resources.delete((Disposable) poll);
                                unicastSubject.onComplete();
                            } else {
                                for (UnicastSubject<T> onNext : list) {
                                    onNext.onNext(poll);
                                }
                            }
                        } else if (this.openDone && list.size() == 0) {
                            this.upstream.dispose();
                            this.startObserver.dispose();
                            this.resources.dispose();
                            terminateDownstream(observer);
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

        public boolean isDisposed() {
            return this.downstreamDisposed.get();
        }

        public void onComplete() {
            this.startObserver.dispose();
            this.resources.dispose();
            this.upstreamDone = true;
            drain();
        }

        public void onError(Throwable th) {
            this.startObserver.dispose();
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

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                this.open.subscribe(this.startObserver);
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
            this.upstream.dispose();
            this.resources.dispose();
            if (this.error.tryAddThrowableOrReport(th)) {
                this.upstreamDone = true;
                drain();
            }
        }

        public void run() {
            if (this.windowCount.decrementAndGet() == 0) {
                this.upstream.dispose();
                this.startObserver.dispose();
                this.resources.dispose();
                this.error.tryTerminateAndReport();
                this.upstreamCanceled = true;
                drain();
            }
        }

        public void terminateDownstream(Observer<?> observer) {
            Throwable terminate = this.error.terminate();
            if (terminate == null) {
                for (UnicastSubject<T> onComplete : this.windows) {
                    onComplete.onComplete();
                }
                observer.onComplete();
            } else if (terminate != ExceptionHelper.TERMINATED) {
                for (UnicastSubject<T> onError : this.windows) {
                    onError.onError(terminate);
                }
                observer.onError(terminate);
            }
        }
    }

    public ObservableWindowBoundarySelector(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int i) {
        super(observableSource);
        this.open = observableSource2;
        this.closingIndicator = function;
        this.bufferSize = i;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.source.subscribe(new WindowBoundaryMainObserver(observer, this.open, this.closingIndicator, this.bufferSize));
    }
}
