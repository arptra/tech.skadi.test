package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCombineLatest<T, R> extends Observable<R> {
    final int bufferSize;
    final Function<? super Object[], ? extends R> combiner;
    final boolean delayError;
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

    public static final class CombinerObserver<T, R> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final LatestCoordinator<T, R> parent;

        public CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.parent = latestCoordinator;
            this.index = i;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        public void onNext(T t) {
            this.parent.innerNext(this.index, t);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        volatile boolean cancelled;
        final Function<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        Object[] latest;
        final CombinerObserver<T, R>[] observers;
        final SpscLinkedArrayQueue<Object[]> queue;

        public LatestCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.downstream = observer;
            this.combiner = function;
            this.delayError = z;
            this.latest = new Object[i];
            CombinerObserver<T, R>[] combinerObserverArr = new CombinerObserver[i];
            for (int i3 = 0; i3 < i; i3++) {
                combinerObserverArr[i3] = new CombinerObserver<>(this, i3);
            }
            this.observers = combinerObserverArr;
            this.queue = new SpscLinkedArrayQueue<>(i2);
        }

        public void cancelSources() {
            for (CombinerObserver<T, R> dispose : this.observers) {
                dispose.dispose();
            }
        }

        public void clear(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            synchronized (this) {
                this.latest = null;
            }
            spscLinkedArrayQueue.clear();
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelSources();
                drain();
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object[]> spscLinkedArrayQueue = this.queue;
                Observer<? super R> observer = this.downstream;
                boolean z = this.delayError;
                int i = 1;
                while (!this.cancelled) {
                    if (z || this.errors.get() == null) {
                        boolean z2 = this.done;
                        Object[] poll = spscLinkedArrayQueue.poll();
                        boolean z3 = poll == null;
                        if (z2 && z3) {
                            clear(spscLinkedArrayQueue);
                            this.errors.tryTerminateConsumer((Observer<?>) observer);
                            return;
                        } else if (z3) {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        } else {
                            try {
                                Object apply = this.combiner.apply(poll);
                                Objects.requireNonNull(apply, "The combiner returned a null value");
                                observer.onNext(apply);
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.errors.tryAddThrowableOrReport(th);
                                cancelSources();
                                clear(spscLinkedArrayQueue);
                                this.errors.tryTerminateConsumer((Observer<?>) observer);
                                return;
                            }
                        }
                    } else {
                        cancelSources();
                        clear(spscLinkedArrayQueue);
                        this.errors.tryTerminateConsumer((Observer<?>) observer);
                        return;
                    }
                }
                clear(spscLinkedArrayQueue);
                this.errors.tryTerminateAndReport();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0019, code lost:
            if (r2 == r0.length) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
            if (r4 == false) goto L_0x0023;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0020, code lost:
            cancelSources();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void innerComplete(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.latest     // Catch:{ all -> 0x0007 }
                if (r0 != 0) goto L_0x0009
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r4 = move-exception
                goto L_0x0027
            L_0x0009:
                r4 = r0[r4]     // Catch:{ all -> 0x0007 }
                r1 = 1
                if (r4 != 0) goto L_0x0010
                r4 = r1
                goto L_0x0011
            L_0x0010:
                r4 = 0
            L_0x0011:
                if (r4 != 0) goto L_0x001b
                int r2 = r3.complete     // Catch:{ all -> 0x0007 }
                int r2 = r2 + r1
                r3.complete = r2     // Catch:{ all -> 0x0007 }
                int r0 = r0.length     // Catch:{ all -> 0x0007 }
                if (r2 != r0) goto L_0x001d
            L_0x001b:
                r3.done = r1     // Catch:{ all -> 0x0007 }
            L_0x001d:
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                if (r4 == 0) goto L_0x0023
                r3.cancelSources()
            L_0x0023:
                r3.drain()
                return
            L_0x0027:
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.innerComplete(int):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
            if (r1 == r4.length) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002a, code lost:
            r0 = r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void innerError(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r2.errors
                boolean r4 = r0.tryAddThrowableOrReport(r4)
                if (r4 == 0) goto L_0x0036
                boolean r4 = r2.delayError
                r0 = 1
                if (r4 == 0) goto L_0x002e
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.latest     // Catch:{ all -> 0x0014 }
                if (r4 != 0) goto L_0x0016
                monitor-exit(r2)     // Catch:{ all -> 0x0014 }
                return
            L_0x0014:
                r3 = move-exception
                goto L_0x002c
            L_0x0016:
                r3 = r4[r3]     // Catch:{ all -> 0x0014 }
                if (r3 != 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = 0
            L_0x001d:
                if (r3 != 0) goto L_0x0027
                int r1 = r2.complete     // Catch:{ all -> 0x0014 }
                int r1 = r1 + r0
                r2.complete = r1     // Catch:{ all -> 0x0014 }
                int r4 = r4.length     // Catch:{ all -> 0x0014 }
                if (r1 != r4) goto L_0x0029
            L_0x0027:
                r2.done = r0     // Catch:{ all -> 0x0014 }
            L_0x0029:
                monitor-exit(r2)     // Catch:{ all -> 0x0014 }
                r0 = r3
                goto L_0x002e
            L_0x002c:
                monitor-exit(r2)     // Catch:{ all -> 0x0014 }
                throw r3
            L_0x002e:
                if (r0 == 0) goto L_0x0033
                r2.cancelSources()
            L_0x0033:
                r2.drain()
            L_0x0036:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.innerError(int, java.lang.Throwable):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            if (r4 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void innerNext(int r4, T r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.latest     // Catch:{ all -> 0x0007 }
                if (r0 != 0) goto L_0x0009
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r4 = move-exception
                goto L_0x002b
            L_0x0009:
                r1 = r0[r4]     // Catch:{ all -> 0x0007 }
                int r2 = r3.active     // Catch:{ all -> 0x0007 }
                if (r1 != 0) goto L_0x0013
                int r2 = r2 + 1
                r3.active = r2     // Catch:{ all -> 0x0007 }
            L_0x0013:
                r0[r4] = r5     // Catch:{ all -> 0x0007 }
                int r4 = r0.length     // Catch:{ all -> 0x0007 }
                if (r2 != r4) goto L_0x0023
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<java.lang.Object[]> r4 = r3.queue     // Catch:{ all -> 0x0007 }
                java.lang.Object r5 = r0.clone()     // Catch:{ all -> 0x0007 }
                r4.offer(r5)     // Catch:{ all -> 0x0007 }
                r4 = 1
                goto L_0x0024
            L_0x0023:
                r4 = 0
            L_0x0024:
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                if (r4 == 0) goto L_0x002a
                r3.drain()
            L_0x002a:
                return
            L_0x002b:
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.innerNext(int, java.lang.Object):void");
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.observers;
            int length = combinerObserverArr.length;
            this.downstream.onSubscribe(this);
            for (int i = 0; i < length && !this.done && !this.cancelled; i++) {
                observableSourceArr[i].subscribe(combinerObserverArr[i]);
            }
        }
    }

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.sources = observableSourceArr;
        this.sourcesIterable = iterable;
        this.combiner = function;
        this.bufferSize = i;
        this.delayError = z;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int length;
        ObservableSource<? extends T>[] observableSourceArr = this.sources;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                length = 0;
                for (ObservableSource<? extends T> observableSource : this.sourcesIterable) {
                    if (length == observableSourceArr.length) {
                        ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((length >> 2) + length)];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                        observableSourceArr = observableSourceArr2;
                    }
                    int i = length + 1;
                    Objects.requireNonNull(observableSource, "The Iterator returned a null ObservableSource");
                    observableSourceArr[length] = observableSource;
                    length = i;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, (Observer<?>) observer);
                return;
            }
        } else {
            length = observableSourceArr.length;
        }
        int i2 = length;
        if (i2 == 0) {
            EmptyDisposable.complete((Observer<?>) observer);
            return;
        }
        new LatestCoordinator(observer, this.combiner, i2, this.bufferSize, this.delayError).subscribe(observableSourceArr);
    }
}
