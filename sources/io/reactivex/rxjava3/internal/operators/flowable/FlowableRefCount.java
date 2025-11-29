package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRefCount<T> extends Flowable<T> {
    RefConnection connection;
    final int n;
    final Scheduler scheduler;
    final ConnectableFlowable<T> source;
    final long timeout;
    final TimeUnit unit;

    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final FlowableRefCount<?> parent;
        long subscriberCount;
        Disposable timer;

        public RefConnection(FlowableRefCount<?> flowableRefCount) {
            this.parent = flowableRefCount;
        }

        public void run() {
            this.parent.timeout(this);
        }

        public void accept(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
            synchronized (this.parent) {
                try {
                    if (this.disconnectedEarly) {
                        this.parent.source.reset();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static final class RefCountSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final Subscriber<? super T> downstream;
        final FlowableRefCount<T> parent;
        Subscription upstream;

        public RefCountSubscriber(Subscriber<? super T> subscriber, FlowableRefCount<T> flowableRefCount, RefConnection refConnection) {
            this.downstream = subscriber;
            this.parent = flowableRefCount;
            this.connection = refConnection;
        }

        public void cancel() {
            this.upstream.cancel();
            if (compareAndSet(false, true)) {
                this.parent.cancel(this.connection);
            }
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public void request(long j) {
            this.upstream.request(j);
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable) {
        this(connectableFlowable, 1, 0, TimeUnit.NANOSECONDS, (Scheduler) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel(io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount.RefConnection r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount$RefConnection r0 = r4.connection     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x003f
            if (r0 == r5) goto L_0x0008
            goto L_0x003f
        L_0x0008:
            long r0 = r5.subscriberCount     // Catch:{ all -> 0x0025 }
            r2 = 1
            long r0 = r0 - r2
            r5.subscriberCount = r0     // Catch:{ all -> 0x0025 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x003d
            boolean r0 = r5.connected     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x001a
            goto L_0x003d
        L_0x001a:
            long r0 = r4.timeout     // Catch:{ all -> 0x0025 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0027
            r4.timeout(r5)     // Catch:{ all -> 0x0025 }
            monitor-exit(r4)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r5 = move-exception
            goto L_0x0041
        L_0x0027:
            io.reactivex.rxjava3.internal.disposables.SequentialDisposable r0 = new io.reactivex.rxjava3.internal.disposables.SequentialDisposable     // Catch:{ all -> 0x0025 }
            r0.<init>()     // Catch:{ all -> 0x0025 }
            r5.timer = r0     // Catch:{ all -> 0x0025 }
            monitor-exit(r4)     // Catch:{ all -> 0x0025 }
            io.reactivex.rxjava3.core.Scheduler r1 = r4.scheduler
            long r2 = r4.timeout
            java.util.concurrent.TimeUnit r4 = r4.unit
            io.reactivex.rxjava3.disposables.Disposable r4 = r1.scheduleDirect(r5, r2, r4)
            r0.replace(r4)
            return
        L_0x003d:
            monitor-exit(r4)     // Catch:{ all -> 0x0025 }
            return
        L_0x003f:
            monitor-exit(r4)     // Catch:{ all -> 0x0025 }
            return
        L_0x0041:
            monitor-exit(r4)     // Catch:{ all -> 0x0025 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount.cancel(io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount$RefConnection):void");
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        RefConnection refConnection;
        boolean z;
        Disposable disposable;
        synchronized (this) {
            try {
                refConnection = this.connection;
                if (refConnection == null) {
                    refConnection = new RefConnection(this);
                    this.connection = refConnection;
                }
                long j = refConnection.subscriberCount;
                if (j == 0 && (disposable = refConnection.timer) != null) {
                    disposable.dispose();
                }
                long j2 = j + 1;
                refConnection.subscriberCount = j2;
                if (refConnection.connected || j2 != ((long) this.n)) {
                    z = false;
                } else {
                    z = true;
                    refConnection.connected = true;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.source.subscribe(new RefCountSubscriber(subscriber, this, refConnection));
        if (z) {
            this.source.connect(refConnection);
        }
    }

    public void terminated(RefConnection refConnection) {
        synchronized (this) {
            try {
                if (this.connection == refConnection) {
                    Disposable disposable = refConnection.timer;
                    if (disposable != null) {
                        disposable.dispose();
                        refConnection.timer = null;
                    }
                    long j = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j;
                    if (j == 0) {
                        this.connection = null;
                        this.source.reset();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void timeout(RefConnection refConnection) {
        synchronized (this) {
            try {
                if (refConnection.subscriberCount == 0 && refConnection == this.connection) {
                    this.connection = null;
                    Disposable disposable = (Disposable) refConnection.get();
                    DisposableHelper.dispose(refConnection);
                    if (disposable == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        this.source.reset();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.source = connectableFlowable;
        this.n = i;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }
}
