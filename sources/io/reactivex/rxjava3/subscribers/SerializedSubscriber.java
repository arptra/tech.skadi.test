package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    static final int QUEUE_LINK_SIZE = 4;
    final boolean delayError;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    boolean emitting;
    AppendOnlyLinkedArrayList<Object> queue;
    Subscription upstream;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, false);
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void emitLoop() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.queue;
                    if (appendOnlyLinkedArrayList == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        } while (!appendOnlyLinkedArrayList.accept((Subscriber<? super U>) this.downstream));
    }

    public void onComplete() {
        if (!this.done) {
            synchronized (this) {
                try {
                    if (!this.done) {
                        if (this.emitting) {
                            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                                this.queue = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.add(NotificationLite.complete());
                            return;
                        }
                        this.done = true;
                        this.emitting = true;
                        this.downstream.onComplete();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        if (r1 == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0041, code lost:
        r2.downstream.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.done
            if (r0 == 0) goto L_0x0008
            io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.done     // Catch:{ all -> 0x0022 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x003a
        L_0x000f:
            boolean r0 = r2.emitting     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0035
            r2.done = r1     // Catch:{ all -> 0x0022 }
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.queue     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0024
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0022 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0022 }
            r2.queue = r0     // Catch:{ all -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            r3 = move-exception
            goto L_0x0047
        L_0x0024:
            java.lang.Object r3 = io.reactivex.rxjava3.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x0022 }
            boolean r1 = r2.delayError     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0030
            r0.add(r3)     // Catch:{ all -> 0x0022 }
            goto L_0x0033
        L_0x0030:
            r0.setFirst(r3)     // Catch:{ all -> 0x0022 }
        L_0x0033:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return
        L_0x0035:
            r2.done = r1     // Catch:{ all -> 0x0022 }
            r2.emitting = r1     // Catch:{ all -> 0x0022 }
            r1 = 0
        L_0x003a:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0041
            io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0041:
            org.reactivestreams.Subscriber<? super T> r2 = r2.downstream
            r2.onError(r3)
            return
        L_0x0047:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.subscribers.SerializedSubscriber.onError(java.lang.Throwable):void");
    }

    public void onNext(@NonNull T t) {
        if (!this.done) {
            if (t == null) {
                this.upstream.cancel();
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                return;
            }
            synchronized (this) {
                try {
                    if (!this.done) {
                        if (this.emitting) {
                            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                                this.queue = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                            return;
                        }
                        this.emitting = true;
                        this.downstream.onNext(t);
                        emitLoop();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    public void onSubscribe(@NonNull Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j) {
        this.upstream.request(j);
    }

    public SerializedSubscriber(@NonNull Subscriber<? super T> subscriber, boolean z) {
        this.downstream = subscriber;
        this.delayError = z;
    }
}
