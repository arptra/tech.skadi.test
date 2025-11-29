package io.reactivex.rxjava3.processors;

import com.honey.account.x.c;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class BehaviorProcessor<T> extends FlowableProcessor<T> {
    static final BehaviorSubscription[] EMPTY = new BehaviorSubscription[0];
    static final Object[] EMPTY_ARRAY = new Object[0];
    static final BehaviorSubscription[] TERMINATED = new BehaviorSubscription[0];
    long index;
    final ReadWriteLock lock;
    final Lock readLock;
    final AtomicReference<BehaviorSubscription<T>[]> subscribers;
    final AtomicReference<Throwable> terminalEvent;
    final AtomicReference<Object> value;
    final Lock writeLock;

    public static final class BehaviorSubscription<T> extends AtomicLong implements Subscription, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        volatile boolean cancelled;
        final Subscriber<? super T> downstream;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        AppendOnlyLinkedArrayList<Object> queue;
        final BehaviorProcessor<T> state;

        public BehaviorSubscription(Subscriber<? super T> subscriber, BehaviorProcessor<T> behaviorProcessor) {
            this.downstream = subscriber;
            this.state = behaviorProcessor;
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.remove(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
            if (test(r0) == false) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x003c, code lost:
            emitLoop();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitFirst() {
            /*
                r4 = this;
                boolean r0 = r4.cancelled
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r4)
                boolean r0 = r4.cancelled     // Catch:{ all -> 0x000c }
                if (r0 == 0) goto L_0x000e
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                return
            L_0x000c:
                r0 = move-exception
                goto L_0x0040
            L_0x000e:
                boolean r0 = r4.next     // Catch:{ all -> 0x000c }
                if (r0 == 0) goto L_0x0014
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                return
            L_0x0014:
                io.reactivex.rxjava3.processors.BehaviorProcessor<T> r0 = r4.state     // Catch:{ all -> 0x000c }
                java.util.concurrent.locks.Lock r1 = r0.readLock     // Catch:{ all -> 0x000c }
                r1.lock()     // Catch:{ all -> 0x000c }
                long r2 = r0.index     // Catch:{ all -> 0x000c }
                r4.index = r2     // Catch:{ all -> 0x000c }
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r0.value     // Catch:{ all -> 0x000c }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x000c }
                r1.unlock()     // Catch:{ all -> 0x000c }
                r1 = 1
                if (r0 == 0) goto L_0x002d
                r2 = r1
                goto L_0x002e
            L_0x002d:
                r2 = 0
            L_0x002e:
                r4.emitting = r2     // Catch:{ all -> 0x000c }
                r4.next = r1     // Catch:{ all -> 0x000c }
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                if (r0 == 0) goto L_0x003f
                boolean r0 = r4.test(r0)
                if (r0 == 0) goto L_0x003c
                return
            L_0x003c:
                r4.emitLoop()
            L_0x003f:
                return
            L_0x0040:
                monitor-exit(r4)     // Catch:{ all -> 0x000c }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.processors.BehaviorProcessor.BehaviorSubscription.emitFirst():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0015, code lost:
            r0.forEachWhile(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitLoop() {
            /*
                r2 = this;
            L_0x0000:
                boolean r0 = r2.cancelled
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.queue     // Catch:{ all -> 0x000f }
                if (r0 != 0) goto L_0x0011
                r0 = 0
                r2.emitting = r0     // Catch:{ all -> 0x000f }
                monitor-exit(r2)     // Catch:{ all -> 0x000f }
                return
            L_0x000f:
                r0 = move-exception
                goto L_0x0019
            L_0x0011:
                r1 = 0
                r2.queue = r1     // Catch:{ all -> 0x000f }
                monitor-exit(r2)     // Catch:{ all -> 0x000f }
                r0.forEachWhile(r2)
                goto L_0x0000
            L_0x0019:
                monitor-exit(r2)     // Catch:{ all -> 0x000f }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.processors.BehaviorProcessor.BehaviorSubscription.emitLoop():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0033, code lost:
            r2.fastPath = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitNext(java.lang.Object r3, long r4) {
            /*
                r2 = this;
                boolean r0 = r2.cancelled
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r2.fastPath
                if (r0 != 0) goto L_0x0038
                monitor-enter(r2)
                boolean r0 = r2.cancelled     // Catch:{ all -> 0x0010 }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r2)     // Catch:{ all -> 0x0010 }
                return
            L_0x0010:
                r3 = move-exception
                goto L_0x0036
            L_0x0012:
                long r0 = r2.index     // Catch:{ all -> 0x0010 }
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 != 0) goto L_0x001a
                monitor-exit(r2)     // Catch:{ all -> 0x0010 }
                return
            L_0x001a:
                boolean r4 = r2.emitting     // Catch:{ all -> 0x0010 }
                if (r4 == 0) goto L_0x002f
                io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r4 = r2.queue     // Catch:{ all -> 0x0010 }
                if (r4 != 0) goto L_0x002a
                io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList r4 = new io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0010 }
                r5 = 4
                r4.<init>(r5)     // Catch:{ all -> 0x0010 }
                r2.queue = r4     // Catch:{ all -> 0x0010 }
            L_0x002a:
                r4.add(r3)     // Catch:{ all -> 0x0010 }
                monitor-exit(r2)     // Catch:{ all -> 0x0010 }
                return
            L_0x002f:
                r4 = 1
                r2.next = r4     // Catch:{ all -> 0x0010 }
                monitor-exit(r2)     // Catch:{ all -> 0x0010 }
                r2.fastPath = r4
                goto L_0x0038
            L_0x0036:
                monitor-exit(r2)     // Catch:{ all -> 0x0010 }
                throw r3
            L_0x0038:
                r2.test(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.processors.BehaviorProcessor.BehaviorSubscription.emitNext(java.lang.Object, long):void");
        }

        public boolean isFull() {
            return get() == 0;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
            }
        }

        public boolean test(Object obj) {
            if (this.cancelled) {
                return true;
            }
            if (NotificationLite.isComplete(obj)) {
                this.downstream.onComplete();
                return true;
            } else if (NotificationLite.isError(obj)) {
                this.downstream.onError(NotificationLite.getError(obj));
                return true;
            } else {
                long j = get();
                if (j != 0) {
                    this.downstream.onNext(NotificationLite.getValue(obj));
                    if (j == LongCompanionObject.MAX_VALUE) {
                        return false;
                    }
                    decrementAndGet();
                    return false;
                }
                cancel();
                this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
        }
    }

    public BehaviorProcessor() {
        this.value = new AtomicReference<>();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.lock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.subscribers = new AtomicReference<>(EMPTY);
        this.terminalEvent = new AtomicReference<>();
    }

    @NonNull
    @CheckReturnValue
    public static <T> BehaviorProcessor<T> create() {
        return new BehaviorProcessor<>();
    }

    @NonNull
    @CheckReturnValue
    public static <T> BehaviorProcessor<T> createDefault(T t) {
        Objects.requireNonNull(t, "defaultValue is null");
        return new BehaviorProcessor<>(t);
    }

    public boolean add(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.get();
            if (behaviorSubscriptionArr == TERMINATED) {
                return false;
            }
            int length = behaviorSubscriptionArr.length;
            behaviorSubscriptionArr2 = new BehaviorSubscription[(length + 1)];
            System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr2, 0, length);
            behaviorSubscriptionArr2[length] = behaviorSubscription;
        } while (!c.a(this.subscribers, behaviorSubscriptionArr, behaviorSubscriptionArr2));
        return true;
    }

    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        Object obj = this.value.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @CheckReturnValue
    @Nullable
    public T getValue() {
        Object obj = this.value.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return NotificationLite.getValue(obj);
    }

    @CheckReturnValue
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.value.get());
    }

    @CheckReturnValue
    public boolean hasSubscribers() {
        return ((BehaviorSubscription[]) this.subscribers.get()).length != 0;
    }

    @CheckReturnValue
    public boolean hasThrowable() {
        return NotificationLite.isError(this.value.get());
    }

    @CheckReturnValue
    public boolean hasValue() {
        Object obj = this.value.get();
        return obj != null && !NotificationLite.isComplete(obj) && !NotificationLite.isError(obj);
    }

    @CheckReturnValue
    public boolean offer(@NonNull T t) {
        ExceptionHelper.nullCheck(t, "offer called with a null value.");
        BehaviorSubscription[] behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.get();
        for (BehaviorSubscription isFull : behaviorSubscriptionArr) {
            if (isFull.isFull()) {
                return false;
            }
        }
        Object next = NotificationLite.next(t);
        setCurrent(next);
        for (BehaviorSubscription emitNext : behaviorSubscriptionArr) {
            emitNext.emitNext(next, this.index);
        }
        return true;
    }

    public void onComplete() {
        if (c.a(this.terminalEvent, (Object) null, ExceptionHelper.TERMINATED)) {
            Object complete = NotificationLite.complete();
            for (BehaviorSubscription emitNext : terminate(complete)) {
                emitNext.emitNext(complete, this.index);
            }
        }
    }

    public void onError(@NonNull Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (!c.a(this.terminalEvent, (Object) null, th)) {
            RxJavaPlugins.onError(th);
            return;
        }
        Object error = NotificationLite.error(th);
        for (BehaviorSubscription emitNext : terminate(error)) {
            emitNext.emitNext(error, this.index);
        }
    }

    public void onNext(@NonNull T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.terminalEvent.get() == null) {
            Object next = NotificationLite.next(t);
            setCurrent(next);
            for (BehaviorSubscription emitNext : (BehaviorSubscription[]) this.subscribers.get()) {
                emitNext.emitNext(next, this.index);
            }
        }
    }

    public void onSubscribe(@NonNull Subscription subscription) {
        if (this.terminalEvent.get() != null) {
            subscription.cancel();
        } else {
            subscription.request(LongCompanionObject.MAX_VALUE);
        }
    }

    public void remove(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.get();
            int length = behaviorSubscriptionArr.length;
            if (length != 0) {
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (behaviorSubscriptionArr[i] == behaviorSubscription) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        behaviorSubscriptionArr2 = EMPTY;
                    } else {
                        BehaviorSubscription[] behaviorSubscriptionArr3 = new BehaviorSubscription[(length - 1)];
                        System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr3, 0, i);
                        System.arraycopy(behaviorSubscriptionArr, i + 1, behaviorSubscriptionArr3, i, (length - i) - 1);
                        behaviorSubscriptionArr2 = behaviorSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!c.a(this.subscribers, behaviorSubscriptionArr, behaviorSubscriptionArr2));
    }

    public void setCurrent(Object obj) {
        Lock lock2 = this.writeLock;
        lock2.lock();
        this.index++;
        this.value.lazySet(obj);
        lock2.unlock();
    }

    public void subscribeActual(@NonNull Subscriber<? super T> subscriber) {
        BehaviorSubscription behaviorSubscription = new BehaviorSubscription(subscriber, this);
        subscriber.onSubscribe(behaviorSubscription);
        if (!add(behaviorSubscription)) {
            Throwable th = this.terminalEvent.get();
            if (th == ExceptionHelper.TERMINATED) {
                subscriber.onComplete();
            } else {
                subscriber.onError(th);
            }
        } else if (behaviorSubscription.cancelled) {
            remove(behaviorSubscription);
        } else {
            behaviorSubscription.emitFirst();
        }
    }

    @CheckReturnValue
    public int subscriberCount() {
        return ((BehaviorSubscription[]) this.subscribers.get()).length;
    }

    public BehaviorSubscription<T>[] terminate(Object obj) {
        setCurrent(obj);
        return (BehaviorSubscription[]) this.subscribers.getAndSet(TERMINATED);
    }

    public BehaviorProcessor(T t) {
        this();
        this.value.lazySet(t);
    }
}
