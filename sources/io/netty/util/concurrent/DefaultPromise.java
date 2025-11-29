package io.netty.util.concurrent;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.i.a;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class DefaultPromise<V> extends AbstractFuture<V> implements Promise<V> {
    private static final CauseHolder CANCELLATION_CAUSE_HOLDER;
    /* access modifiers changed from: private */
    public static final StackTraceElement[] CANCELLATION_STACK;
    private static final int MAX_LISTENER_STACK_DEPTH = Math.min(8, SystemPropertyUtil.getInt("io.netty.defaultPromise.maxListenerStackDepth", 8));
    private static final AtomicReferenceFieldUpdater<DefaultPromise, Object> RESULT_UPDATER;
    private static final Object SUCCESS = new Object();
    private static final Object UNCANCELLABLE = new Object();
    private static final InternalLogger logger;
    private static final InternalLogger rejectedExecutionLogger;
    private final EventExecutor executor;
    private Object listeners;
    private boolean notifyingListeners;
    private volatile Object result;
    private short waiters;

    public static final class CauseHolder {
        final Throwable cause;

        public CauseHolder(Throwable th) {
            this.cause = th;
        }
    }

    public static final class LeanCancellationException extends CancellationException {
        private static final long serialVersionUID = 2794674970981187807L;

        private LeanCancellationException() {
        }

        public Throwable fillInStackTrace() {
            setStackTrace(DefaultPromise.CANCELLATION_STACK);
            return this;
        }

        public String toString() {
            return CancellationException.class.getName();
        }
    }

    public static final class StacklessCancellationException extends CancellationException {
        private static final long serialVersionUID = -2974906711413716191L;

        private StacklessCancellationException() {
        }

        public static StacklessCancellationException newInstance(Class<?> cls, String str) {
            return (StacklessCancellationException) ThrowableUtil.unknownStackTrace(new StacklessCancellationException(), cls, str);
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    static {
        Class<DefaultPromise> cls = DefaultPromise.class;
        logger = InternalLoggerFactory.getInstance((Class<?>) cls);
        rejectedExecutionLogger = InternalLoggerFactory.getInstance(cls.getName() + ".rejectedExecution");
        RESULT_UPDATER = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "result");
        CauseHolder causeHolder = new CauseHolder(StacklessCancellationException.newInstance(cls, "cancel(...)"));
        CANCELLATION_CAUSE_HOLDER = causeHolder;
        CANCELLATION_STACK = causeHolder.cause.getStackTrace();
    }

    public DefaultPromise(EventExecutor eventExecutor) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
    }

    private void addListener0(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        Object obj = this.listeners;
        if (obj == null) {
            this.listeners = genericFutureListener;
        } else if (obj instanceof DefaultFutureListeners) {
            ((DefaultFutureListeners) obj).add(genericFutureListener);
        } else {
            this.listeners = new DefaultFutureListeners((GenericFutureListener) obj, genericFutureListener);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0088, code lost:
        return r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean await0(long r13, boolean r15) throws java.lang.InterruptedException {
        /*
            r12 = this;
            boolean r0 = r12.isDone()
            r1 = 1
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            r2 = 0
            int r0 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0013
            boolean r12 = r12.isDone()
            return r12
        L_0x0013:
            if (r15 == 0) goto L_0x0026
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 != 0) goto L_0x001c
            goto L_0x0026
        L_0x001c:
            java.lang.InterruptedException r13 = new java.lang.InterruptedException
            java.lang.String r12 = r12.toString()
            r13.<init>(r12)
            throw r13
        L_0x0026:
            r12.checkDeadLock()
            long r4 = java.lang.System.nanoTime()
            monitor-enter(r12)
            r0 = 0
            r6 = r13
        L_0x0030:
            boolean r8 = r12.isDone()     // Catch:{ all -> 0x004b }
            if (r8 != 0) goto L_0x007a
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x007a
            r12.incWaiters()     // Catch:{ all -> 0x004b }
            r8 = 1000000(0xf4240, double:4.940656E-318)
            long r10 = r6 / r8
            long r6 = r6 % r8
            int r6 = (int) r6     // Catch:{ InterruptedException -> 0x0050 }
            r12.wait(r10, r6)     // Catch:{ InterruptedException -> 0x0050 }
            r12.decWaiters()     // Catch:{ all -> 0x004b }
            goto L_0x0057
        L_0x004b:
            r13 = move-exception
            r1 = r0
            goto L_0x0089
        L_0x004e:
            r13 = move-exception
            goto L_0x0076
        L_0x0050:
            r6 = move-exception
            if (r15 != 0) goto L_0x0075
            r12.decWaiters()     // Catch:{ all -> 0x0073 }
            r0 = r1
        L_0x0057:
            boolean r6 = r12.isDone()     // Catch:{ all -> 0x004b }
            if (r6 == 0) goto L_0x006b
            if (r0 == 0) goto L_0x0069
            java.lang.Thread r13 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0067 }
            r13.interrupt()     // Catch:{ all -> 0x0067 }
            goto L_0x0069
        L_0x0067:
            r13 = move-exception
            goto L_0x0093
        L_0x0069:
            monitor-exit(r12)     // Catch:{ all -> 0x0067 }
            return r1
        L_0x006b:
            long r6 = java.lang.System.nanoTime()     // Catch:{ all -> 0x004b }
            long r6 = r6 - r4
            long r6 = r13 - r6
            goto L_0x0030
        L_0x0073:
            r13 = move-exception
            goto L_0x0089
        L_0x0075:
            throw r6     // Catch:{ all -> 0x004e }
        L_0x0076:
            r12.decWaiters()     // Catch:{ all -> 0x004b }
            throw r13     // Catch:{ all -> 0x004b }
        L_0x007a:
            boolean r13 = r12.isDone()     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0087
            java.lang.Thread r14 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0067 }
            r14.interrupt()     // Catch:{ all -> 0x0067 }
        L_0x0087:
            monitor-exit(r12)     // Catch:{ all -> 0x0067 }
            return r13
        L_0x0089:
            if (r1 == 0) goto L_0x0092
            java.lang.Thread r14 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0067 }
            r14.interrupt()     // Catch:{ all -> 0x0067 }
        L_0x0092:
            throw r13     // Catch:{ all -> 0x0067 }
        L_0x0093:
            monitor-exit(r12)     // Catch:{ all -> 0x0067 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.DefaultPromise.await0(long, boolean):boolean");
    }

    private Throwable cause0(Object obj) {
        if (!(obj instanceof CauseHolder)) {
            return null;
        }
        CauseHolder causeHolder = CANCELLATION_CAUSE_HOLDER;
        if (obj == causeHolder) {
            LeanCancellationException leanCancellationException = new LeanCancellationException();
            if (a.a(RESULT_UPDATER, this, causeHolder, new CauseHolder(leanCancellationException))) {
                return leanCancellationException;
            }
            obj = this.result;
        }
        return ((CauseHolder) obj).cause;
    }

    private synchronized boolean checkNotifyWaiters() {
        try {
            if (this.waiters > 0) {
                notifyAll();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.listeners != null;
    }

    private void decWaiters() {
        this.waiters = (short) (this.waiters - 1);
    }

    private void incWaiters() {
        short s = this.waiters;
        if (s != Short.MAX_VALUE) {
            this.waiters = (short) (s + 1);
            return;
        }
        throw new IllegalStateException("too many waiters: " + this);
    }

    private static boolean isCancelled0(Object obj) {
        return (obj instanceof CauseHolder) && (((CauseHolder) obj).cause instanceof CancellationException);
    }

    private static boolean isDone0(Object obj) {
        return (obj == null || obj == UNCANCELLABLE) ? false : true;
    }

    public static void notifyListener(EventExecutor eventExecutor, Future<?> future, GenericFutureListener<?> genericFutureListener) {
        notifyListenerWithStackOverFlowProtection((EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "eventExecutor"), (Future) ObjectUtil.checkNotNull(future, "future"), (GenericFutureListener) ObjectUtil.checkNotNull(genericFutureListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER));
    }

    /* access modifiers changed from: private */
    public static void notifyListener0(Future future, GenericFutureListener genericFutureListener) {
        try {
            genericFutureListener.operationComplete(future);
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                InternalLogger internalLogger = logger;
                internalLogger.warn("An exception was thrown by " + genericFutureListener.getClass().getName() + ".operationComplete()", th);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = io.netty.util.internal.InternalThreadLocalMap.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void notifyListenerWithStackOverFlowProtection(io.netty.util.concurrent.EventExecutor r3, final io.netty.util.concurrent.Future<?> r4, final io.netty.util.concurrent.GenericFutureListener<?> r5) {
        /*
            boolean r0 = r3.inEventLoop()
            if (r0 == 0) goto L_0x0023
            io.netty.util.internal.InternalThreadLocalMap r0 = io.netty.util.internal.InternalThreadLocalMap.get()
            int r1 = r0.futureListenerStackDepth()
            int r2 = MAX_LISTENER_STACK_DEPTH
            if (r1 >= r2) goto L_0x0023
            int r3 = r1 + 1
            r0.setFutureListenerStackDepth(r3)
            notifyListener0(r4, r5)     // Catch:{ all -> 0x001e }
            r0.setFutureListenerStackDepth(r1)
            return
        L_0x001e:
            r3 = move-exception
            r0.setFutureListenerStackDepth(r1)
            throw r3
        L_0x0023:
            io.netty.util.concurrent.DefaultPromise$2 r0 = new io.netty.util.concurrent.DefaultPromise$2
            r0.<init>(r4, r5)
            safeExecute(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.DefaultPromise.notifyListenerWithStackOverFlowProtection(io.netty.util.concurrent.EventExecutor, io.netty.util.concurrent.Future, io.netty.util.concurrent.GenericFutureListener):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = io.netty.util.internal.InternalThreadLocalMap.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void notifyListeners() {
        /*
            r4 = this;
            io.netty.util.concurrent.EventExecutor r0 = r4.executor()
            boolean r1 = r0.inEventLoop()
            if (r1 == 0) goto L_0x0027
            io.netty.util.internal.InternalThreadLocalMap r1 = io.netty.util.internal.InternalThreadLocalMap.get()
            int r2 = r1.futureListenerStackDepth()
            int r3 = MAX_LISTENER_STACK_DEPTH
            if (r2 >= r3) goto L_0x0027
            int r0 = r2 + 1
            r1.setFutureListenerStackDepth(r0)
            r4.notifyListenersNow()     // Catch:{ all -> 0x0022 }
            r1.setFutureListenerStackDepth(r2)
            return
        L_0x0022:
            r4 = move-exception
            r1.setFutureListenerStackDepth(r2)
            throw r4
        L_0x0027:
            io.netty.util.concurrent.DefaultPromise$1 r1 = new io.netty.util.concurrent.DefaultPromise$1
            r1.<init>()
            safeExecute(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.DefaultPromise.notifyListeners():void");
    }

    private void notifyListeners0(DefaultFutureListeners defaultFutureListeners) {
        GenericFutureListener[] listeners2 = defaultFutureListeners.listeners();
        int size = defaultFutureListeners.size();
        for (int i = 0; i < size; i++) {
            notifyListener0(this, listeners2[i]);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        if ((r0 instanceof io.netty.util.concurrent.DefaultFutureListeners) == false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        notifyListeners0((io.netty.util.concurrent.DefaultFutureListeners) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        notifyListener0(r3, (io.netty.util.concurrent.GenericFutureListener) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0 = r3.listeners;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        if (r0 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        r3.notifyingListeners = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
        r3.listeners = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0031, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifyListenersNow() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.notifyingListeners     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x0034
            java.lang.Object r0 = r3.listeners     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0034
        L_0x000a:
            r1 = 1
            r3.notifyingListeners = r1     // Catch:{ all -> 0x0032 }
            r1 = 0
            r3.listeners = r1     // Catch:{ all -> 0x0032 }
            monitor-exit(r3)     // Catch:{ all -> 0x0032 }
        L_0x0011:
            boolean r2 = r0 instanceof io.netty.util.concurrent.DefaultFutureListeners
            if (r2 == 0) goto L_0x001b
            io.netty.util.concurrent.DefaultFutureListeners r0 = (io.netty.util.concurrent.DefaultFutureListeners) r0
            r3.notifyListeners0(r0)
            goto L_0x0020
        L_0x001b:
            io.netty.util.concurrent.GenericFutureListener r0 = (io.netty.util.concurrent.GenericFutureListener) r0
            notifyListener0(r3, r0)
        L_0x0020:
            monitor-enter(r3)
            java.lang.Object r0 = r3.listeners     // Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x002c
            r0 = 0
            r3.notifyingListeners = r0     // Catch:{ all -> 0x002a }
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r0 = move-exception
            goto L_0x0030
        L_0x002c:
            r3.listeners = r1     // Catch:{ all -> 0x002a }
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            goto L_0x0011
        L_0x0030:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            throw r0
        L_0x0032:
            r0 = move-exception
            goto L_0x0036
        L_0x0034:
            monitor-exit(r3)     // Catch:{ all -> 0x0032 }
            return
        L_0x0036:
            monitor-exit(r3)     // Catch:{ all -> 0x0032 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.DefaultPromise.notifyListenersNow():void");
    }

    /* access modifiers changed from: private */
    public static void notifyProgressiveListener0(ProgressiveFuture progressiveFuture, GenericProgressiveFutureListener genericProgressiveFutureListener, long j, long j2) {
        try {
            genericProgressiveFutureListener.operationProgressed(progressiveFuture, j, j2);
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                InternalLogger internalLogger = logger;
                internalLogger.warn("An exception was thrown by " + genericProgressiveFutureListener.getClass().getName() + ".operationProgressed()", th);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void notifyProgressiveListeners0(ProgressiveFuture<?> progressiveFuture, GenericProgressiveFutureListener<?>[] genericProgressiveFutureListenerArr, long j, long j2) {
        int length = genericProgressiveFutureListenerArr.length;
        int i = 0;
        while (i < length) {
            GenericProgressiveFutureListener<?> genericProgressiveFutureListener = genericProgressiveFutureListenerArr[i];
            if (genericProgressiveFutureListener != null) {
                notifyProgressiveListener0(progressiveFuture, genericProgressiveFutureListener, j, j2);
                i++;
            } else {
                return;
            }
        }
    }

    private synchronized Object progressiveListeners() {
        Object obj = this.listeners;
        if (obj == null) {
            return null;
        }
        if (obj instanceof DefaultFutureListeners) {
            DefaultFutureListeners defaultFutureListeners = (DefaultFutureListeners) obj;
            int progressiveSize = defaultFutureListeners.progressiveSize();
            if (progressiveSize == 0) {
                return null;
            }
            int i = 0;
            if (progressiveSize != 1) {
                GenericFutureListener[] listeners2 = defaultFutureListeners.listeners();
                GenericProgressiveFutureListener[] genericProgressiveFutureListenerArr = new GenericProgressiveFutureListener[progressiveSize];
                int i2 = 0;
                while (i < progressiveSize) {
                    GenericFutureListener genericFutureListener = listeners2[i2];
                    if (genericFutureListener instanceof GenericProgressiveFutureListener) {
                        int i3 = i + 1;
                        genericProgressiveFutureListenerArr[i] = (GenericProgressiveFutureListener) genericFutureListener;
                        i = i3;
                    }
                    i2++;
                }
                return genericProgressiveFutureListenerArr;
            }
            GenericFutureListener[] listeners3 = defaultFutureListeners.listeners();
            int length = listeners3.length;
            while (i < length) {
                GenericFutureListener genericFutureListener2 = listeners3[i];
                if (genericFutureListener2 instanceof GenericProgressiveFutureListener) {
                    return genericFutureListener2;
                }
                i++;
            }
            return null;
        } else if (obj instanceof GenericProgressiveFutureListener) {
            return obj;
        } else {
            return null;
        }
    }

    private void removeListener0(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        Object obj = this.listeners;
        if (obj instanceof DefaultFutureListeners) {
            ((DefaultFutureListeners) obj).remove(genericFutureListener);
        } else if (obj == genericFutureListener) {
            this.listeners = null;
        }
    }

    private void rethrowIfFailed() {
        Throwable cause = cause();
        if (cause != null) {
            PlatformDependent.throwException(cause);
        }
    }

    private static void safeExecute(EventExecutor eventExecutor, Runnable runnable) {
        try {
            eventExecutor.execute(runnable);
        } catch (Throwable th) {
            rejectedExecutionLogger.error("Failed to submit a listener notification task. Event loop shut down?", th);
        }
    }

    private boolean setFailure0(Throwable th) {
        return setValue0(new CauseHolder((Throwable) ObjectUtil.checkNotNull(th, "cause")));
    }

    private boolean setSuccess0(V v) {
        if (v == null) {
            v = SUCCESS;
        }
        return setValue0(v);
    }

    private boolean setValue0(Object obj) {
        AtomicReferenceFieldUpdater<DefaultPromise, Object> atomicReferenceFieldUpdater = RESULT_UPDATER;
        if (!a.a(atomicReferenceFieldUpdater, this, (Object) null, obj) && !a.a(atomicReferenceFieldUpdater, this, UNCANCELLABLE, obj)) {
            return false;
        }
        if (!checkNotifyWaiters()) {
            return true;
        }
        notifyListeners();
        return true;
    }

    public boolean cancel(boolean z) {
        if (!a.a(RESULT_UPDATER, this, (Object) null, CANCELLATION_CAUSE_HOLDER)) {
            return false;
        }
        if (!checkNotifyWaiters()) {
            return true;
        }
        notifyListeners();
        return true;
    }

    public Throwable cause() {
        return cause0(this.result);
    }

    public void checkDeadLock() {
        EventExecutor executor2 = executor();
        if (executor2 != null && executor2.inEventLoop()) {
            throw new BlockingOperationException(toString());
        }
    }

    public EventExecutor executor() {
        return this.executor;
    }

    public V get() throws InterruptedException, ExecutionException {
        V v = this.result;
        if (!isDone0(v)) {
            await();
            v = this.result;
        }
        if (v == SUCCESS || v == UNCANCELLABLE) {
            return null;
        }
        Throwable cause0 = cause0(v);
        if (cause0 == null) {
            return v;
        }
        if (cause0 instanceof CancellationException) {
            throw ((CancellationException) cause0);
        }
        throw new ExecutionException(cause0);
    }

    public V getNow() {
        V v = this.result;
        if ((v instanceof CauseHolder) || v == SUCCESS || v == UNCANCELLABLE) {
            return null;
        }
        return v;
    }

    public boolean isCancellable() {
        return this.result == null;
    }

    public boolean isCancelled() {
        return isCancelled0(this.result);
    }

    public boolean isDone() {
        return isDone0(this.result);
    }

    public boolean isSuccess() {
        Object obj = this.result;
        return (obj == null || obj == UNCANCELLABLE || (obj instanceof CauseHolder)) ? false : true;
    }

    public void notifyProgressiveListeners(long j, long j2) {
        Object progressiveListeners = progressiveListeners();
        if (progressiveListeners != null) {
            final ProgressiveFuture progressiveFuture = (ProgressiveFuture) this;
            EventExecutor executor2 = executor();
            if (executor2.inEventLoop()) {
                if (progressiveListeners instanceof GenericProgressiveFutureListener[]) {
                    notifyProgressiveListeners0(progressiveFuture, (GenericProgressiveFutureListener[]) progressiveListeners, j, j2);
                    return;
                }
                notifyProgressiveListener0(progressiveFuture, (GenericProgressiveFutureListener) progressiveListeners, j, j2);
            } else if (progressiveListeners instanceof GenericProgressiveFutureListener[]) {
                final GenericProgressiveFutureListener[] genericProgressiveFutureListenerArr = (GenericProgressiveFutureListener[]) progressiveListeners;
                final long j3 = j;
                final long j4 = j2;
                safeExecute(executor2, new Runnable() {
                    public void run() {
                        DefaultPromise.notifyProgressiveListeners0(progressiveFuture, genericProgressiveFutureListenerArr, j3, j4);
                    }
                });
            } else {
                final GenericProgressiveFutureListener genericProgressiveFutureListener = (GenericProgressiveFutureListener) progressiveListeners;
                final long j5 = j;
                final long j6 = j2;
                safeExecute(executor2, new Runnable() {
                    public void run() {
                        DefaultPromise.notifyProgressiveListener0(progressiveFuture, genericProgressiveFutureListener, j5, j6);
                    }
                });
            }
        }
    }

    public Promise<V> setFailure(Throwable th) {
        if (setFailure0(th)) {
            return this;
        }
        throw new IllegalStateException("complete already: " + this, th);
    }

    public Promise<V> setSuccess(V v) {
        if (setSuccess0(v)) {
            return this;
        }
        throw new IllegalStateException("complete already: " + this);
    }

    public boolean setUncancellable() {
        if (a.a(RESULT_UPDATER, this, (Object) null, UNCANCELLABLE)) {
            return true;
        }
        Object obj = this.result;
        return !isDone0(obj) || !isCancelled0(obj);
    }

    public String toString() {
        return toStringBuilder().toString();
    }

    public StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName((Object) this));
        sb.append('@');
        sb.append(Integer.toHexString(hashCode()));
        Object obj = this.result;
        if (obj == SUCCESS) {
            sb.append("(success)");
        } else if (obj == UNCANCELLABLE) {
            sb.append("(uncancellable)");
        } else if (obj instanceof CauseHolder) {
            sb.append("(failure: ");
            sb.append(((CauseHolder) obj).cause);
            sb.append(')');
        } else if (obj != null) {
            sb.append("(success: ");
            sb.append(obj);
            sb.append(')');
        } else {
            sb.append("(incomplete)");
        }
        return sb;
    }

    public boolean tryFailure(Throwable th) {
        return setFailure0(th);
    }

    public boolean trySuccess(V v) {
        return setSuccess0(v);
    }

    public Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        ObjectUtil.checkNotNull(genericFutureListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this) {
            addListener0(genericFutureListener);
        }
        if (isDone()) {
            notifyListeners();
        }
        return this;
    }

    public Promise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        ObjectUtil.checkNotNull(genericFutureListenerArr, "listeners");
        synchronized (this) {
            try {
                int length = genericFutureListenerArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    GenericFutureListener<? extends Future<? super V>> genericFutureListener = genericFutureListenerArr[i];
                    if (genericFutureListener == null) {
                        break;
                    }
                    addListener0(genericFutureListener);
                    i++;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (isDone()) {
            notifyListeners();
        }
        return this;
    }

    public Promise<V> await() throws InterruptedException {
        if (isDone()) {
            return this;
        }
        if (!Thread.interrupted()) {
            checkDeadLock();
            synchronized (this) {
                while (!isDone()) {
                    try {
                        incWaiters();
                        wait();
                        decWaiters();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return this;
        }
        throw new InterruptedException(toString());
    }

    public Promise<V> awaitUninterruptibly() {
        boolean z;
        if (isDone()) {
            return this;
        }
        checkDeadLock();
        synchronized (this) {
            z = false;
            while (!isDone()) {
                try {
                    incWaiters();
                    wait();
                    decWaiters();
                } catch (InterruptedException unused) {
                    decWaiters();
                    z = true;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return this;
    }

    public Promise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        ObjectUtil.checkNotNull(genericFutureListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this) {
            removeListener0(genericFutureListener);
        }
        return this;
    }

    public Promise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        ObjectUtil.checkNotNull(genericFutureListenerArr, "listeners");
        synchronized (this) {
            try {
                int length = genericFutureListenerArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    GenericFutureListener<? extends Future<? super V>> genericFutureListener = genericFutureListenerArr[i];
                    if (genericFutureListener == null) {
                        break;
                    }
                    removeListener0(genericFutureListener);
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    public Promise<V> sync() throws InterruptedException {
        await();
        rethrowIfFailed();
        return this;
    }

    public Promise<V> syncUninterruptibly() {
        awaitUninterruptibly();
        rethrowIfFailed();
        return this;
    }

    public DefaultPromise() {
        this.executor = null;
    }

    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        V v = this.result;
        if (!isDone0(v)) {
            if (await(j, timeUnit)) {
                v = this.result;
            } else {
                throw new TimeoutException();
            }
        }
        if (v == SUCCESS || v == UNCANCELLABLE) {
            return null;
        }
        Throwable cause0 = cause0(v);
        if (cause0 == null) {
            return v;
        }
        if (cause0 instanceof CancellationException) {
            throw ((CancellationException) cause0);
        }
        throw new ExecutionException(cause0);
    }

    public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        return await0(timeUnit.toNanos(j), true);
    }

    public boolean await(long j) throws InterruptedException {
        return await0(TimeUnit.MILLISECONDS.toNanos(j), true);
    }

    public boolean awaitUninterruptibly(long j, TimeUnit timeUnit) {
        try {
            return await0(timeUnit.toNanos(j), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }

    public boolean awaitUninterruptibly(long j) {
        try {
            return await0(TimeUnit.MILLISECONDS.toNanos(j), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }
}
