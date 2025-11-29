package io.reactivex.rxjava3.subjects;

import com.honey.account.x.c;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class BehaviorSubject<T> extends Subject<T> {
    static final BehaviorDisposable[] EMPTY = new BehaviorDisposable[0];
    static final BehaviorDisposable[] TERMINATED = new BehaviorDisposable[0];
    long index;
    final ReadWriteLock lock;
    final AtomicReference<BehaviorDisposable<T>[]> observers = new AtomicReference<>(EMPTY);
    final Lock readLock;
    final AtomicReference<Throwable> terminalEvent;
    final AtomicReference<Object> value;
    final Lock writeLock;

    public static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        volatile boolean cancelled;
        final Observer<? super T> downstream;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        AppendOnlyLinkedArrayList<Object> queue;
        final BehaviorSubject<T> state;

        public BehaviorDisposable(Observer<? super T> observer, BehaviorSubject<T> behaviorSubject) {
            this.downstream = observer;
            this.state = behaviorSubject;
        }

        public void dispose() {
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
                io.reactivex.rxjava3.subjects.BehaviorSubject<T> r0 = r4.state     // Catch:{ all -> 0x000c }
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.subjects.BehaviorSubject.BehaviorDisposable.emitFirst():void");
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.subjects.BehaviorSubject.BehaviorDisposable.emitLoop():void");
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.subjects.BehaviorSubject.BehaviorDisposable.emitNext(java.lang.Object, long):void");
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public boolean test(Object obj) {
            return this.cancelled || NotificationLite.accept(obj, this.downstream);
        }
    }

    public BehaviorSubject(T t) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.lock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.value = new AtomicReference<>(t);
        this.terminalEvent = new AtomicReference<>();
    }

    @NonNull
    @CheckReturnValue
    public static <T> BehaviorSubject<T> create() {
        return new BehaviorSubject<>((Object) null);
    }

    @NonNull
    @CheckReturnValue
    public static <T> BehaviorSubject<T> createDefault(T t) {
        Objects.requireNonNull(t, "defaultValue is null");
        return new BehaviorSubject<>(t);
    }

    public boolean add(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.observers.get();
            if (behaviorDisposableArr == TERMINATED) {
                return false;
            }
            int length = behaviorDisposableArr.length;
            behaviorDisposableArr2 = new BehaviorDisposable[(length + 1)];
            System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
            behaviorDisposableArr2[length] = behaviorDisposable;
        } while (!c.a(this.observers, behaviorDisposableArr, behaviorDisposableArr2));
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
    public boolean hasObservers() {
        return ((BehaviorDisposable[]) this.observers.get()).length != 0;
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

    public void onComplete() {
        if (c.a(this.terminalEvent, (Object) null, ExceptionHelper.TERMINATED)) {
            Object complete = NotificationLite.complete();
            for (BehaviorDisposable emitNext : terminate(complete)) {
                emitNext.emitNext(complete, this.index);
            }
        }
    }

    public void onError(Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (!c.a(this.terminalEvent, (Object) null, th)) {
            RxJavaPlugins.onError(th);
            return;
        }
        Object error = NotificationLite.error(th);
        for (BehaviorDisposable emitNext : terminate(error)) {
            emitNext.emitNext(error, this.index);
        }
    }

    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.terminalEvent.get() == null) {
            Object next = NotificationLite.next(t);
            setCurrent(next);
            for (BehaviorDisposable emitNext : (BehaviorDisposable[]) this.observers.get()) {
                emitNext.emitNext(next, this.index);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.terminalEvent.get() != null) {
            disposable.dispose();
        }
    }

    public void remove(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.observers.get();
            int length = behaviorDisposableArr.length;
            if (length != 0) {
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (behaviorDisposableArr[i] == behaviorDisposable) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        behaviorDisposableArr2 = EMPTY;
                    } else {
                        BehaviorDisposable[] behaviorDisposableArr3 = new BehaviorDisposable[(length - 1)];
                        System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i);
                        System.arraycopy(behaviorDisposableArr, i + 1, behaviorDisposableArr3, i, (length - i) - 1);
                        behaviorDisposableArr2 = behaviorDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!c.a(this.observers, behaviorDisposableArr, behaviorDisposableArr2));
    }

    public void setCurrent(Object obj) {
        this.writeLock.lock();
        this.index++;
        this.value.lazySet(obj);
        this.writeLock.unlock();
    }

    public void subscribeActual(Observer<? super T> observer) {
        BehaviorDisposable behaviorDisposable = new BehaviorDisposable(observer, this);
        observer.onSubscribe(behaviorDisposable);
        if (!add(behaviorDisposable)) {
            Throwable th = this.terminalEvent.get();
            if (th == ExceptionHelper.TERMINATED) {
                observer.onComplete();
            } else {
                observer.onError(th);
            }
        } else if (behaviorDisposable.cancelled) {
            remove(behaviorDisposable);
        } else {
            behaviorDisposable.emitFirst();
        }
    }

    @CheckReturnValue
    public int subscriberCount() {
        return ((BehaviorDisposable[]) this.observers.get()).length;
    }

    public BehaviorDisposable<T>[] terminate(Object obj) {
        setCurrent(obj);
        return (BehaviorDisposable[]) this.observers.getAndSet(TERMINATED);
    }
}
