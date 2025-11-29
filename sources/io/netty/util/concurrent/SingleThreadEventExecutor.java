package io.netty.util.concurrent;

import com.honey.account.i.a;
import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.PriorityQueue;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.Async;

public abstract class SingleThreadEventExecutor extends AbstractScheduledEventExecutor implements OrderedEventExecutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int DEFAULT_MAX_PENDING_EXECUTOR_TASKS = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventexecutor.maxPendingTasks", Integer.MAX_VALUE));
    private static final Runnable NOOP_TASK = new Runnable() {
        public void run() {
        }
    };
    private static final AtomicReferenceFieldUpdater<SingleThreadEventExecutor, ThreadProperties> PROPERTIES_UPDATER;
    private static final long SCHEDULE_PURGE_INTERVAL = TimeUnit.SECONDS.toNanos(1);
    /* access modifiers changed from: private */
    public static final AtomicIntegerFieldUpdater<SingleThreadEventExecutor> STATE_UPDATER;
    private static final int ST_NOT_STARTED = 1;
    private static final int ST_SHUTDOWN = 4;
    private static final int ST_SHUTTING_DOWN = 3;
    private static final int ST_STARTED = 2;
    private static final int ST_TERMINATED = 5;
    /* access modifiers changed from: private */
    public static final InternalLogger logger;
    private final boolean addTaskWakesUp;
    private final Executor executor;
    private volatile long gracefulShutdownQuietPeriod;
    /* access modifiers changed from: private */
    public long gracefulShutdownStartTime;
    private volatile long gracefulShutdownTimeout;
    /* access modifiers changed from: private */
    public volatile boolean interrupted;
    private long lastExecutionTime;
    private final int maxPendingTasks;
    private final RejectedExecutionHandler rejectedExecutionHandler;
    /* access modifiers changed from: private */
    public final Set<Runnable> shutdownHooks;
    /* access modifiers changed from: private */
    public volatile int state;
    private final Queue<Runnable> taskQueue;
    /* access modifiers changed from: private */
    public final Promise<?> terminationFuture;
    /* access modifiers changed from: private */
    public volatile Thread thread;
    /* access modifiers changed from: private */
    public final CountDownLatch threadLock;
    private volatile ThreadProperties threadProperties;

    public static final class DefaultThreadProperties implements ThreadProperties {
        private final Thread t;

        public DefaultThreadProperties(Thread thread) {
            this.t = thread;
        }

        public long id() {
            return this.t.getId();
        }

        public boolean isAlive() {
            return this.t.isAlive();
        }

        public boolean isDaemon() {
            return this.t.isDaemon();
        }

        public boolean isInterrupted() {
            return this.t.isInterrupted();
        }

        public String name() {
            return this.t.getName();
        }

        public int priority() {
            return this.t.getPriority();
        }

        public StackTraceElement[] stackTrace() {
            return this.t.getStackTrace();
        }

        public Thread.State state() {
            return this.t.getState();
        }
    }

    @Deprecated
    public interface NonWakeupRunnable extends AbstractEventExecutor.LazyRunnable {
    }

    static {
        Class<SingleThreadEventExecutor> cls = SingleThreadEventExecutor.class;
        logger = InternalLoggerFactory.getInstance((Class<?>) cls);
        STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(cls, "state");
        PROPERTIES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(cls, ThreadProperties.class, "threadProperties");
    }

    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, ThreadFactory threadFactory, boolean z) {
        this(eventExecutorGroup, (Executor) new ThreadPerTaskExecutor(threadFactory), z);
    }

    private void doStartThread() {
        this.executor.execute(new Runnable() {
            /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
                jadx.core.utils.exceptions.JadxOverflowException: 
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                */
            /* JADX WARNING: CFG modification limit reached, blocks count: 265 */
            public void run() {
                /*
                    r10 = this;
                    java.lang.String r0 = "An event executor terminated with non-empty task queue ("
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    java.lang.Thread r2 = java.lang.Thread.currentThread()
                    java.lang.Thread unused = r1.thread = r2
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    boolean r1 = r1.interrupted
                    if (r1 == 0) goto L_0x001c
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    java.lang.Thread r1 = r1.thread
                    r1.interrupt()
                L_0x001c:
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    r1.updateLastExecutionTime()
                    r1 = 4
                    r2 = 3
                    r3 = 0
                    r4 = 41
                    r5 = 5
                    io.netty.util.concurrent.SingleThreadEventExecutor r6 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x01e1 }
                    r6.run()     // Catch:{ all -> 0x01e1 }
                L_0x002c:
                    io.netty.util.concurrent.SingleThreadEventExecutor r6 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r6 = r6.state
                    if (r6 >= r2) goto L_0x0040
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r7 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r8 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    boolean r6 = r7.compareAndSet(r8, r6, r2)
                    if (r6 == 0) goto L_0x002c
                L_0x0040:
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    long r6 = r2.gracefulShutdownStartTime
                    r8 = 0
                    int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                    if (r2 != 0) goto L_0x0087
                    io.netty.util.internal.logging.InternalLogger r2 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    boolean r2 = r2.isErrorEnabled()
                    if (r2 == 0) goto L_0x0087
                    io.netty.util.internal.logging.InternalLogger r2 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    java.lang.String r7 = "Buggy "
                    r6.append(r7)
                    java.lang.Class<io.netty.util.concurrent.EventExecutor> r7 = io.netty.util.concurrent.EventExecutor.class
                    java.lang.String r7 = r7.getSimpleName()
                    r6.append(r7)
                    java.lang.String r7 = " implementation; "
                    r6.append(r7)
                    java.lang.Class<io.netty.util.concurrent.SingleThreadEventExecutor> r7 = io.netty.util.concurrent.SingleThreadEventExecutor.class
                    java.lang.String r7 = r7.getSimpleName()
                    r6.append(r7)
                    java.lang.String r7 = ".confirmShutdown() must be called before run() implementation terminates."
                    r6.append(r7)
                    java.lang.String r6 = r6.toString()
                    r2.error((java.lang.String) r6)
                L_0x0087:
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x00a4 }
                    boolean r2 = r2.confirmShutdown()     // Catch:{ all -> 0x00a4 }
                    if (r2 == 0) goto L_0x0087
                L_0x008f:
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x00a4 }
                    int r2 = r2.state     // Catch:{ all -> 0x00a4 }
                    if (r2 >= r1) goto L_0x00a7
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER     // Catch:{ all -> 0x00a4 }
                    io.netty.util.concurrent.SingleThreadEventExecutor r7 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x00a4 }
                    boolean r2 = r6.compareAndSet(r7, r2, r1)     // Catch:{ all -> 0x00a4 }
                    if (r2 == 0) goto L_0x008f
                    goto L_0x00a7
                L_0x00a4:
                    r1 = move-exception
                    goto L_0x0147
                L_0x00a7:
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x00a4 }
                    r1.confirmShutdown()     // Catch:{ all -> 0x00a4 }
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x00fc }
                    r1.cleanup()     // Catch:{ all -> 0x00fc }
                    io.netty.util.concurrent.FastThreadLocal.removeAll()
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    r1.set(r2, r5)
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    java.util.concurrent.CountDownLatch r1 = r1.threadLock
                    r1.countDown()
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r1 = r1.drainTasks()
                    if (r1 <= 0) goto L_0x00f1
                    io.netty.util.internal.logging.InternalLogger r2 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    boolean r2 = r2.isWarnEnabled()
                    if (r2 == 0) goto L_0x00f1
                    io.netty.util.internal.logging.InternalLogger r2 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                L_0x00e1:
                    r5.append(r0)
                    r5.append(r1)
                    r5.append(r4)
                    java.lang.String r0 = r5.toString()
                    r2.warn((java.lang.String) r0)
                L_0x00f1:
                    io.netty.util.concurrent.SingleThreadEventExecutor r10 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    io.netty.util.concurrent.Promise r10 = r10.terminationFuture
                    r10.setSuccess(r3)
                    goto L_0x025b
                L_0x00fc:
                    r1 = move-exception
                    io.netty.util.concurrent.FastThreadLocal.removeAll()
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r6 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    r2.set(r6, r5)
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    java.util.concurrent.CountDownLatch r2 = r2.threadLock
                    r2.countDown()
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r2 = r2.drainTasks()
                    if (r2 <= 0) goto L_0x013d
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    boolean r5 = r5.isWarnEnabled()
                    if (r5 == 0) goto L_0x013d
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r0)
                    r6.append(r2)
                    r6.append(r4)
                    java.lang.String r0 = r6.toString()
                    r5.warn((java.lang.String) r0)
                L_0x013d:
                    io.netty.util.concurrent.SingleThreadEventExecutor r10 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    io.netty.util.concurrent.Promise r10 = r10.terminationFuture
                    r10.setSuccess(r3)
                    throw r1
                L_0x0147:
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x0196 }
                    r2.cleanup()     // Catch:{ all -> 0x0196 }
                    io.netty.util.concurrent.FastThreadLocal.removeAll()
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r6 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    r2.set(r6, r5)
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    java.util.concurrent.CountDownLatch r2 = r2.threadLock
                    r2.countDown()
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r2 = r2.drainTasks()
                    if (r2 <= 0) goto L_0x018c
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    boolean r5 = r5.isWarnEnabled()
                    if (r5 == 0) goto L_0x018c
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r0)
                    r6.append(r2)
                    r6.append(r4)
                    java.lang.String r0 = r6.toString()
                    r5.warn((java.lang.String) r0)
                L_0x018c:
                    io.netty.util.concurrent.SingleThreadEventExecutor r10 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    io.netty.util.concurrent.Promise r10 = r10.terminationFuture
                    r10.setSuccess(r3)
                    throw r1
                L_0x0196:
                    r1 = move-exception
                    io.netty.util.concurrent.FastThreadLocal.removeAll()
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r6 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    r2.set(r6, r5)
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    java.util.concurrent.CountDownLatch r2 = r2.threadLock
                    r2.countDown()
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r2 = r2.drainTasks()
                    if (r2 <= 0) goto L_0x01d7
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    boolean r5 = r5.isWarnEnabled()
                    if (r5 == 0) goto L_0x01d7
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r0)
                    r6.append(r2)
                    r6.append(r4)
                    java.lang.String r0 = r6.toString()
                    r5.warn((java.lang.String) r0)
                L_0x01d7:
                    io.netty.util.concurrent.SingleThreadEventExecutor r10 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    io.netty.util.concurrent.Promise r10 = r10.terminationFuture
                    r10.setSuccess(r3)
                    throw r1
                L_0x01e1:
                    r6 = move-exception
                    io.netty.util.internal.logging.InternalLogger r7 = io.netty.util.concurrent.SingleThreadEventExecutor.logger     // Catch:{ all -> 0x0341 }
                    java.lang.String r8 = "Unexpected exception from an event executor: "
                    r7.warn((java.lang.String) r8, (java.lang.Throwable) r6)     // Catch:{ all -> 0x0341 }
                L_0x01eb:
                    io.netty.util.concurrent.SingleThreadEventExecutor r6 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r6 = r6.state
                    if (r6 >= r2) goto L_0x01ff
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r7 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r8 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    boolean r6 = r7.compareAndSet(r8, r6, r2)
                    if (r6 == 0) goto L_0x01eb
                L_0x01ff:
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x021c }
                    boolean r2 = r2.confirmShutdown()     // Catch:{ all -> 0x021c }
                    if (r2 == 0) goto L_0x01ff
                L_0x0207:
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x021c }
                    int r2 = r2.state     // Catch:{ all -> 0x021c }
                    if (r2 >= r1) goto L_0x021f
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER     // Catch:{ all -> 0x021c }
                    io.netty.util.concurrent.SingleThreadEventExecutor r7 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x021c }
                    boolean r2 = r6.compareAndSet(r7, r2, r1)     // Catch:{ all -> 0x021c }
                    if (r2 == 0) goto L_0x0207
                    goto L_0x021f
                L_0x021c:
                    r1 = move-exception
                    goto L_0x02a7
                L_0x021f:
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x021c }
                    r1.confirmShutdown()     // Catch:{ all -> 0x021c }
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x025c }
                    r1.cleanup()     // Catch:{ all -> 0x025c }
                    io.netty.util.concurrent.FastThreadLocal.removeAll()
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    r1.set(r2, r5)
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    java.util.concurrent.CountDownLatch r1 = r1.threadLock
                    r1.countDown()
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r1 = r1.drainTasks()
                    if (r1 <= 0) goto L_0x00f1
                    io.netty.util.internal.logging.InternalLogger r2 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    boolean r2 = r2.isWarnEnabled()
                    if (r2 == 0) goto L_0x00f1
                    io.netty.util.internal.logging.InternalLogger r2 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    goto L_0x00e1
                L_0x025b:
                    return
                L_0x025c:
                    r1 = move-exception
                    io.netty.util.concurrent.FastThreadLocal.removeAll()
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r6 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    r2.set(r6, r5)
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    java.util.concurrent.CountDownLatch r2 = r2.threadLock
                    r2.countDown()
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r2 = r2.drainTasks()
                    if (r2 <= 0) goto L_0x029d
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    boolean r5 = r5.isWarnEnabled()
                    if (r5 == 0) goto L_0x029d
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r0)
                    r6.append(r2)
                    r6.append(r4)
                    java.lang.String r0 = r6.toString()
                    r5.warn((java.lang.String) r0)
                L_0x029d:
                    io.netty.util.concurrent.SingleThreadEventExecutor r10 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    io.netty.util.concurrent.Promise r10 = r10.terminationFuture
                    r10.setSuccess(r3)
                    throw r1
                L_0x02a7:
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x02f6 }
                    r2.cleanup()     // Catch:{ all -> 0x02f6 }
                    io.netty.util.concurrent.FastThreadLocal.removeAll()
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r6 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    r2.set(r6, r5)
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    java.util.concurrent.CountDownLatch r2 = r2.threadLock
                    r2.countDown()
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r2 = r2.drainTasks()
                    if (r2 <= 0) goto L_0x02ec
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    boolean r5 = r5.isWarnEnabled()
                    if (r5 == 0) goto L_0x02ec
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r0)
                    r6.append(r2)
                    r6.append(r4)
                    java.lang.String r0 = r6.toString()
                    r5.warn((java.lang.String) r0)
                L_0x02ec:
                    io.netty.util.concurrent.SingleThreadEventExecutor r10 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    io.netty.util.concurrent.Promise r10 = r10.terminationFuture
                    r10.setSuccess(r3)
                    throw r1
                L_0x02f6:
                    r1 = move-exception
                    io.netty.util.concurrent.FastThreadLocal.removeAll()
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r6 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    r2.set(r6, r5)
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    java.util.concurrent.CountDownLatch r2 = r2.threadLock
                    r2.countDown()
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r2 = r2.drainTasks()
                    if (r2 <= 0) goto L_0x0337
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    boolean r5 = r5.isWarnEnabled()
                    if (r5 == 0) goto L_0x0337
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r0)
                    r6.append(r2)
                    r6.append(r4)
                    java.lang.String r0 = r6.toString()
                    r5.warn((java.lang.String) r0)
                L_0x0337:
                    io.netty.util.concurrent.SingleThreadEventExecutor r10 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    io.netty.util.concurrent.Promise r10 = r10.terminationFuture
                    r10.setSuccess(r3)
                    throw r1
                L_0x0341:
                    r6 = move-exception
                L_0x0342:
                    io.netty.util.concurrent.SingleThreadEventExecutor r7 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r7 = r7.state
                    if (r7 >= r2) goto L_0x0356
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r8 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r9 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    boolean r7 = r8.compareAndSet(r9, r7, r2)
                    if (r7 == 0) goto L_0x0342
                L_0x0356:
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x0373 }
                    boolean r2 = r2.confirmShutdown()     // Catch:{ all -> 0x0373 }
                    if (r2 == 0) goto L_0x0356
                L_0x035e:
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x0373 }
                    int r2 = r2.state     // Catch:{ all -> 0x0373 }
                    if (r2 >= r1) goto L_0x0376
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r7 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER     // Catch:{ all -> 0x0373 }
                    io.netty.util.concurrent.SingleThreadEventExecutor r8 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x0373 }
                    boolean r2 = r7.compareAndSet(r8, r2, r1)     // Catch:{ all -> 0x0373 }
                    if (r2 == 0) goto L_0x035e
                    goto L_0x0376
                L_0x0373:
                    r1 = move-exception
                    goto L_0x0415
                L_0x0376:
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x0373 }
                    r1.confirmShutdown()     // Catch:{ all -> 0x0373 }
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x03ca }
                    r1.cleanup()     // Catch:{ all -> 0x03ca }
                    io.netty.util.concurrent.FastThreadLocal.removeAll()
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    r1.set(r2, r5)
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    java.util.concurrent.CountDownLatch r1 = r1.threadLock
                    r1.countDown()
                    io.netty.util.concurrent.SingleThreadEventExecutor r1 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r1 = r1.drainTasks()
                    if (r1 <= 0) goto L_0x03c0
                    io.netty.util.internal.logging.InternalLogger r2 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    boolean r2 = r2.isWarnEnabled()
                    if (r2 == 0) goto L_0x03c0
                    io.netty.util.internal.logging.InternalLogger r2 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    r5.append(r0)
                    r5.append(r1)
                    r5.append(r4)
                    java.lang.String r0 = r5.toString()
                    r2.warn((java.lang.String) r0)
                L_0x03c0:
                    io.netty.util.concurrent.SingleThreadEventExecutor r10 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    io.netty.util.concurrent.Promise r10 = r10.terminationFuture
                    r10.setSuccess(r3)
                    throw r6
                L_0x03ca:
                    r1 = move-exception
                    io.netty.util.concurrent.FastThreadLocal.removeAll()
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r6 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    r2.set(r6, r5)
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    java.util.concurrent.CountDownLatch r2 = r2.threadLock
                    r2.countDown()
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r2 = r2.drainTasks()
                    if (r2 <= 0) goto L_0x040b
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    boolean r5 = r5.isWarnEnabled()
                    if (r5 == 0) goto L_0x040b
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r0)
                    r6.append(r2)
                    r6.append(r4)
                    java.lang.String r0 = r6.toString()
                    r5.warn((java.lang.String) r0)
                L_0x040b:
                    io.netty.util.concurrent.SingleThreadEventExecutor r10 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    io.netty.util.concurrent.Promise r10 = r10.terminationFuture
                    r10.setSuccess(r3)
                    throw r1
                L_0x0415:
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this     // Catch:{ all -> 0x0464 }
                    r2.cleanup()     // Catch:{ all -> 0x0464 }
                    io.netty.util.concurrent.FastThreadLocal.removeAll()
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r6 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    r2.set(r6, r5)
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    java.util.concurrent.CountDownLatch r2 = r2.threadLock
                    r2.countDown()
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r2 = r2.drainTasks()
                    if (r2 <= 0) goto L_0x045a
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    boolean r5 = r5.isWarnEnabled()
                    if (r5 == 0) goto L_0x045a
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r0)
                    r6.append(r2)
                    r6.append(r4)
                    java.lang.String r0 = r6.toString()
                    r5.warn((java.lang.String) r0)
                L_0x045a:
                    io.netty.util.concurrent.SingleThreadEventExecutor r10 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    io.netty.util.concurrent.Promise r10 = r10.terminationFuture
                    r10.setSuccess(r3)
                    throw r1
                L_0x0464:
                    r1 = move-exception
                    io.netty.util.concurrent.FastThreadLocal.removeAll()
                    java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = io.netty.util.concurrent.SingleThreadEventExecutor.STATE_UPDATER
                    io.netty.util.concurrent.SingleThreadEventExecutor r6 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    r2.set(r6, r5)
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    java.util.concurrent.CountDownLatch r2 = r2.threadLock
                    r2.countDown()
                    io.netty.util.concurrent.SingleThreadEventExecutor r2 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    int r2 = r2.drainTasks()
                    if (r2 <= 0) goto L_0x04a5
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    boolean r5 = r5.isWarnEnabled()
                    if (r5 == 0) goto L_0x04a5
                    io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.concurrent.SingleThreadEventExecutor.logger
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r0)
                    r6.append(r2)
                    r6.append(r4)
                    java.lang.String r0 = r6.toString()
                    r5.warn((java.lang.String) r0)
                L_0x04a5:
                    io.netty.util.concurrent.SingleThreadEventExecutor r10 = io.netty.util.concurrent.SingleThreadEventExecutor.this
                    io.netty.util.concurrent.Promise r10 = r10.terminationFuture
                    r10.setSuccess(r3)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.SingleThreadEventExecutor.AnonymousClass4.run():void");
            }
        });
    }

    private boolean ensureThreadStarted(int i) {
        if (i != 1) {
            return false;
        }
        try {
            doStartThread();
            return false;
        } catch (Throwable th) {
            STATE_UPDATER.set(this, 5);
            this.terminationFuture.tryFailure(th);
            if (!(th instanceof Exception)) {
                PlatformDependent.throwException(th);
            }
            return true;
        }
    }

    private void execute0(@Async.Schedule Runnable runnable) {
        ObjectUtil.checkNotNull(runnable, "task");
        execute(runnable, !(runnable instanceof AbstractEventExecutor.LazyRunnable) && wakesUpForTask(runnable));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r2 = getCurrentTimeNanos();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean executeExpiredScheduledTasks() {
        /*
            r4 = this;
            io.netty.util.internal.PriorityQueue<io.netty.util.concurrent.ScheduledFutureTask<?>> r0 = r4.scheduledTaskQueue
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x000c
            goto L_0x0022
        L_0x000c:
            long r2 = r4.getCurrentTimeNanos()
            java.lang.Runnable r0 = r4.pollScheduledTask(r2)
            if (r0 != 0) goto L_0x0017
            return r1
        L_0x0017:
            io.netty.util.concurrent.AbstractEventExecutor.safeExecute(r0)
            java.lang.Runnable r0 = r4.pollScheduledTask(r2)
            if (r0 != 0) goto L_0x0017
            r4 = 1
            return r4
        L_0x0022:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.SingleThreadEventExecutor.executeExpiredScheduledTasks():boolean");
    }

    private boolean fetchFromScheduledTaskQueue() {
        Runnable pollScheduledTask;
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (priorityQueue == null || priorityQueue.isEmpty()) {
            return true;
        }
        long currentTimeNanos = getCurrentTimeNanos();
        do {
            pollScheduledTask = pollScheduledTask(currentTimeNanos);
            if (pollScheduledTask == null) {
                return true;
            }
        } while (this.taskQueue.offer(pollScheduledTask));
        this.scheduledTaskQueue.add((ScheduledFutureTask) pollScheduledTask);
        return false;
    }

    private void lazyExecute0(@Async.Schedule Runnable runnable) {
        execute((Runnable) ObjectUtil.checkNotNull(runnable, "task"), false);
    }

    public static Runnable pollTaskFrom(Queue<Runnable> queue) {
        Runnable poll;
        do {
            poll = queue.poll();
        } while (poll == AbstractScheduledEventExecutor.WAKEUP_TASK);
        return poll;
    }

    public static void reject() {
        throw new RejectedExecutionException("event executor terminated");
    }

    private boolean runExistingTasksFrom(Queue<Runnable> queue) {
        Runnable poll;
        Runnable pollTaskFrom = pollTaskFrom(queue);
        if (pollTaskFrom == null) {
            return false;
        }
        int min = Math.min(this.maxPendingTasks, queue.size());
        AbstractEventExecutor.safeExecute(pollTaskFrom);
        while (true) {
            int i = min - 1;
            if (min <= 0 || (poll = queue.poll()) == null) {
                return true;
            }
            AbstractEventExecutor.safeExecute(poll);
            min = i;
        }
    }

    private boolean runShutdownHooks() {
        boolean z = false;
        while (!this.shutdownHooks.isEmpty()) {
            ArrayList<Runnable> arrayList = new ArrayList<>(this.shutdownHooks);
            this.shutdownHooks.clear();
            for (Runnable runTask : arrayList) {
                try {
                    AbstractEventExecutor.runTask(runTask);
                } catch (Throwable th) {
                    logger.warn("Shutdown hook raised an exception.", th);
                }
                z = true;
            }
        }
        if (z) {
            this.lastExecutionTime = getCurrentTimeNanos();
        }
        return z;
    }

    private void startThread() {
        if (this.state == 1 && STATE_UPDATER.compareAndSet(this, 1, 2)) {
            try {
                doStartThread();
            } catch (Throwable th) {
                STATE_UPDATER.compareAndSet(this, 2, 1);
                throw th;
            }
        }
    }

    private void throwIfInEventLoop(String str) {
        if (inEventLoop()) {
            throw new RejectedExecutionException("Calling " + str + " from within the EventLoop is not allowed");
        }
    }

    public void addShutdownHook(final Runnable runnable) {
        if (inEventLoop()) {
            this.shutdownHooks.add(runnable);
        } else {
            execute(new Runnable() {
                public void run() {
                    SingleThreadEventExecutor.this.shutdownHooks.add(runnable);
                }
            });
        }
    }

    public void addTask(Runnable runnable) {
        ObjectUtil.checkNotNull(runnable, "task");
        if (!offerTask(runnable)) {
            reject(runnable);
        }
    }

    public void afterRunningAllTasks() {
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (!inEventLoop()) {
            this.threadLock.await(j, timeUnit);
            return isTerminated();
        }
        throw new IllegalStateException("cannot await termination of the current thread");
    }

    public void cleanup() {
    }

    public boolean confirmShutdown() {
        if (!isShuttingDown()) {
            return false;
        }
        if (inEventLoop()) {
            cancelScheduledTasks();
            if (this.gracefulShutdownStartTime == 0) {
                this.gracefulShutdownStartTime = getCurrentTimeNanos();
            }
            if (!runAllTasks() && !runShutdownHooks()) {
                long currentTimeNanos = getCurrentTimeNanos();
                if (isShutdown() || currentTimeNanos - this.gracefulShutdownStartTime > this.gracefulShutdownTimeout || currentTimeNanos - this.lastExecutionTime > this.gracefulShutdownQuietPeriod) {
                    return true;
                }
                this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException unused) {
                }
                return false;
            } else if (isShutdown() || this.gracefulShutdownQuietPeriod == 0) {
                return true;
            } else {
                this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
                return false;
            }
        } else {
            throw new IllegalStateException("must be invoked from an event loop");
        }
    }

    public long deadlineNanos() {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        return peekScheduledTask == null ? getCurrentTimeNanos() + SCHEDULE_PURGE_INTERVAL : peekScheduledTask.deadlineNanos();
    }

    public long delayNanos(long j) {
        long initialNanoTime = j - AbstractScheduledEventExecutor.initialNanoTime();
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        return peekScheduledTask == null ? SCHEDULE_PURGE_INTERVAL : peekScheduledTask.delayNanos(initialNanoTime);
    }

    public final int drainTasks() {
        int i = 0;
        while (true) {
            Runnable poll = this.taskQueue.poll();
            if (poll == null) {
                return i;
            }
            if (AbstractScheduledEventExecutor.WAKEUP_TASK != poll) {
                i++;
            }
        }
    }

    public void execute(Runnable runnable) {
        execute0(runnable);
    }

    public boolean hasTasks() {
        return !this.taskQueue.isEmpty();
    }

    public boolean inEventLoop(Thread thread2) {
        return thread2 == this.thread;
    }

    public void interruptThread() {
        Thread thread2 = this.thread;
        if (thread2 == null) {
            this.interrupted = true;
        } else {
            thread2.interrupt();
        }
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        throwIfInEventLoop("invokeAll");
        return super.invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        throwIfInEventLoop("invokeAny");
        return super.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.state >= 4;
    }

    public boolean isShuttingDown() {
        return this.state >= 3;
    }

    public boolean isTerminated() {
        return this.state == 5;
    }

    public void lazyExecute(Runnable runnable) {
        lazyExecute0(runnable);
    }

    @Deprecated
    public Queue<Runnable> newTaskQueue() {
        return newTaskQueue(this.maxPendingTasks);
    }

    public final boolean offerTask(Runnable runnable) {
        if (isShutdown()) {
            reject();
        }
        return this.taskQueue.offer(runnable);
    }

    public Runnable peekTask() {
        return this.taskQueue.peek();
    }

    public int pendingTasks() {
        return this.taskQueue.size();
    }

    public Runnable pollTask() {
        return pollTaskFrom(this.taskQueue);
    }

    public void removeShutdownHook(final Runnable runnable) {
        if (inEventLoop()) {
            this.shutdownHooks.remove(runnable);
        } else {
            execute(new Runnable() {
                public void run() {
                    SingleThreadEventExecutor.this.shutdownHooks.remove(runnable);
                }
            });
        }
    }

    public boolean removeTask(Runnable runnable) {
        return this.taskQueue.remove(ObjectUtil.checkNotNull(runnable, "task"));
    }

    public abstract void run();

    public boolean runAllTasks() {
        boolean fetchFromScheduledTaskQueue;
        boolean z = false;
        do {
            fetchFromScheduledTaskQueue = fetchFromScheduledTaskQueue();
            if (runAllTasksFrom(this.taskQueue)) {
                z = true;
                continue;
            }
        } while (!fetchFromScheduledTaskQueue);
        if (z) {
            this.lastExecutionTime = getCurrentTimeNanos();
        }
        afterRunningAllTasks();
        return z;
    }

    public final boolean runAllTasksFrom(Queue<Runnable> queue) {
        Runnable pollTaskFrom = pollTaskFrom(queue);
        if (pollTaskFrom == null) {
            return false;
        }
        do {
            AbstractEventExecutor.safeExecute(pollTaskFrom);
            pollTaskFrom = pollTaskFrom(queue);
        } while (pollTaskFrom != null);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0002 A[LOOP:0: B:1:0x0002->B:4:0x0011, LOOP_START, PHI: r1 
      PHI: (r1v1 int) = (r1v0 int), (r1v3 int) binds: [B:0:0x0000, B:4:0x0011] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean runScheduledAndExecutorTasks(int r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.util.Queue<java.lang.Runnable> r2 = r4.taskQueue
            boolean r2 = r4.runExistingTasksFrom(r2)
            boolean r3 = r4.executeExpiredScheduledTasks()
            r2 = r2 | r3
            if (r2 == 0) goto L_0x0013
            int r1 = r1 + 1
            if (r1 < r5) goto L_0x0002
        L_0x0013:
            if (r1 <= 0) goto L_0x001b
            long r2 = r4.getCurrentTimeNanos()
            r4.lastExecutionTime = r2
        L_0x001b:
            r4.afterRunningAllTasks()
            if (r1 <= 0) goto L_0x0021
            r0 = 1
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.SingleThreadEventExecutor.runScheduledAndExecutorTasks(int):boolean");
    }

    @Deprecated
    public void shutdown() {
        if (!isShutdown()) {
            boolean inEventLoop = inEventLoop();
            while (!isShuttingDown()) {
                int i = this.state;
                int i2 = 4;
                boolean z = true;
                if (!(inEventLoop || i == 1 || i == 2 || i == 3)) {
                    z = false;
                    i2 = i;
                }
                if (STATE_UPDATER.compareAndSet(this, i, i2)) {
                    if (!ensureThreadStarted(i) && z) {
                        this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
                        if (!this.addTaskWakesUp) {
                            wakeup(inEventLoop);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        ObjectUtil.checkPositiveOrZero(j, "quietPeriod");
        if (j2 >= j) {
            ObjectUtil.checkNotNull(timeUnit, "unit");
            if (isShuttingDown()) {
                return terminationFuture();
            }
            boolean inEventLoop = inEventLoop();
            while (!isShuttingDown()) {
                int i = this.state;
                int i2 = 3;
                boolean z = true;
                if (!(inEventLoop || i == 1 || i == 2)) {
                    z = false;
                    i2 = i;
                }
                if (STATE_UPDATER.compareAndSet(this, i, i2)) {
                    this.gracefulShutdownQuietPeriod = timeUnit.toNanos(j);
                    this.gracefulShutdownTimeout = timeUnit.toNanos(j2);
                    if (ensureThreadStarted(i)) {
                        return this.terminationFuture;
                    }
                    if (z) {
                        this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
                        if (!this.addTaskWakesUp) {
                            wakeup(inEventLoop);
                        }
                    }
                    return terminationFuture();
                }
            }
            return terminationFuture();
        }
        throw new IllegalArgumentException("timeout: " + j2 + " (expected >= quietPeriod (" + j + "))");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Runnable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Runnable takeTask() {
        /*
            r7 = this;
            java.util.Queue<java.lang.Runnable> r0 = r7.taskQueue
            boolean r1 = r0 instanceof java.util.concurrent.BlockingQueue
            if (r1 == 0) goto L_0x0040
            java.util.concurrent.BlockingQueue r0 = (java.util.concurrent.BlockingQueue) r0
        L_0x0008:
            io.netty.util.concurrent.ScheduledFutureTask r1 = r7.peekScheduledTask()
            r2 = 0
            if (r1 != 0) goto L_0x001c
            java.lang.Object r7 = r0.take()     // Catch:{ InterruptedException -> 0x001b }
            java.lang.Runnable r7 = (java.lang.Runnable) r7     // Catch:{ InterruptedException -> 0x001b }
            java.lang.Runnable r0 = io.netty.util.concurrent.AbstractScheduledEventExecutor.WAKEUP_TASK     // Catch:{ InterruptedException -> 0x001a }
            if (r7 != r0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r2 = r7
        L_0x001b:
            return r2
        L_0x001c:
            long r3 = r1.delayNanos()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0031
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.Object r1 = r0.poll(r3, r1)     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ InterruptedException -> 0x0030 }
            r2 = r1
            goto L_0x0031
        L_0x0030:
            return r2
        L_0x0031:
            if (r2 != 0) goto L_0x003d
            r7.fetchFromScheduledTaskQueue()
            java.lang.Object r1 = r0.poll()
            r2 = r1
            java.lang.Runnable r2 = (java.lang.Runnable) r2
        L_0x003d:
            if (r2 == 0) goto L_0x0008
            return r2
        L_0x0040:
            java.lang.UnsupportedOperationException r7 = new java.lang.UnsupportedOperationException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.SingleThreadEventExecutor.takeTask():java.lang.Runnable");
    }

    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    public final ThreadProperties threadProperties() {
        ThreadProperties threadProperties2 = this.threadProperties;
        if (threadProperties2 != null) {
            return threadProperties2;
        }
        Thread thread2 = this.thread;
        if (thread2 == null) {
            submit(NOOP_TASK).syncUninterruptibly();
            thread2 = this.thread;
        }
        DefaultThreadProperties defaultThreadProperties = new DefaultThreadProperties(thread2);
        return !a.a(PROPERTIES_UPDATER, this, (Object) null, defaultThreadProperties) ? this.threadProperties : defaultThreadProperties;
    }

    public void updateLastExecutionTime() {
        this.lastExecutionTime = getCurrentTimeNanos();
    }

    public boolean wakesUpForTask(Runnable runnable) {
        return true;
    }

    public void wakeup(boolean z) {
        if (!z) {
            this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
        }
    }

    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, ThreadFactory threadFactory, boolean z, int i, RejectedExecutionHandler rejectedExecutionHandler2) {
        this(eventExecutorGroup, (Executor) new ThreadPerTaskExecutor(threadFactory), z, i, rejectedExecutionHandler2);
    }

    private void execute(Runnable runnable, boolean z) {
        boolean z2;
        boolean inEventLoop = inEventLoop();
        addTask(runnable);
        if (!inEventLoop) {
            startThread();
            if (isShutdown()) {
                try {
                    z2 = removeTask(runnable);
                } catch (UnsupportedOperationException unused) {
                    z2 = false;
                }
                if (z2) {
                    reject();
                }
            }
        }
        if (!this.addTaskWakesUp && z) {
            wakeup(inEventLoop);
        }
    }

    public Queue<Runnable> newTaskQueue(int i) {
        return new LinkedBlockingQueue(i);
    }

    public final void reject(Runnable runnable) {
        this.rejectedExecutionHandler.rejected(runnable, this);
    }

    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor2, boolean z) {
        this(eventExecutorGroup, executor2, z, DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        throwIfInEventLoop("invokeAll");
        return super.invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        throwIfInEventLoop("invokeAny");
        return super.invokeAny(collection, j, timeUnit);
    }

    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor2, boolean z, int i, RejectedExecutionHandler rejectedExecutionHandler2) {
        super(eventExecutorGroup);
        this.threadLock = new CountDownLatch(1);
        this.shutdownHooks = new LinkedHashSet();
        this.state = 1;
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.addTaskWakesUp = z;
        int max = Math.max(16, i);
        this.maxPendingTasks = max;
        this.executor = ThreadExecutorMap.apply(executor2, (EventExecutor) this);
        this.taskQueue = newTaskQueue(max);
        this.rejectedExecutionHandler = (RejectedExecutionHandler) ObjectUtil.checkNotNull(rejectedExecutionHandler2, "rejectedHandler");
    }

    public boolean runAllTasks(long j) {
        long j2;
        fetchFromScheduledTaskQueue();
        Runnable pollTask = pollTask();
        if (pollTask == null) {
            afterRunningAllTasks();
            return false;
        }
        long currentTimeNanos = j > 0 ? getCurrentTimeNanos() + j : 0;
        long j3 = 0;
        while (true) {
            AbstractEventExecutor.safeExecute(pollTask);
            j3++;
            if ((63 & j3) == 0) {
                j2 = getCurrentTimeNanos();
                if (j2 >= currentTimeNanos) {
                    break;
                }
            }
            pollTask = pollTask();
            if (pollTask == null) {
                j2 = getCurrentTimeNanos();
                break;
            }
        }
        afterRunningAllTasks();
        this.lastExecutionTime = j2;
        return true;
    }

    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor2, boolean z, Queue<Runnable> queue, RejectedExecutionHandler rejectedExecutionHandler2) {
        super(eventExecutorGroup);
        this.threadLock = new CountDownLatch(1);
        this.shutdownHooks = new LinkedHashSet();
        this.state = 1;
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.addTaskWakesUp = z;
        this.maxPendingTasks = DEFAULT_MAX_PENDING_EXECUTOR_TASKS;
        this.executor = ThreadExecutorMap.apply(executor2, (EventExecutor) this);
        this.taskQueue = (Queue) ObjectUtil.checkNotNull(queue, "taskQueue");
        this.rejectedExecutionHandler = (RejectedExecutionHandler) ObjectUtil.checkNotNull(rejectedExecutionHandler2, "rejectedHandler");
    }
}
