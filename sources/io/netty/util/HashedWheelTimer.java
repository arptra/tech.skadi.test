package io.netty.util;

import io.netty.util.concurrent.ImmediateExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;

public class HashedWheelTimer implements Timer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final AtomicInteger INSTANCE_COUNTER = new AtomicInteger();
    private static final int INSTANCE_COUNT_LIMIT = 64;
    private static final long MILLISECOND_NANOS = TimeUnit.MILLISECONDS.toNanos(1);
    private static final AtomicBoolean WARNED_TOO_MANY_INSTANCES = new AtomicBoolean();
    public static final int WORKER_STATE_INIT = 0;
    public static final int WORKER_STATE_SHUTDOWN = 2;
    public static final int WORKER_STATE_STARTED = 1;
    /* access modifiers changed from: private */
    public static final AtomicIntegerFieldUpdater<HashedWheelTimer> WORKER_STATE_UPDATER;
    private static final ResourceLeakDetector<HashedWheelTimer> leakDetector;
    static final InternalLogger logger;
    /* access modifiers changed from: private */
    public final Queue<HashedWheelTimeout> cancelledTimeouts;
    private final ResourceLeakTracker<HashedWheelTimer> leak;
    /* access modifiers changed from: private */
    public final int mask;
    private final long maxPendingTimeouts;
    /* access modifiers changed from: private */
    public final AtomicLong pendingTimeouts;
    /* access modifiers changed from: private */
    public volatile long startTime;
    /* access modifiers changed from: private */
    public final CountDownLatch startTimeInitialized;
    /* access modifiers changed from: private */
    public final Executor taskExecutor;
    /* access modifiers changed from: private */
    public final long tickDuration;
    /* access modifiers changed from: private */
    public final Queue<HashedWheelTimeout> timeouts;
    /* access modifiers changed from: private */
    public final HashedWheelBucket[] wheel;
    private final Worker worker;
    private volatile int workerState;
    private final Thread workerThread;

    public static final class HashedWheelBucket {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private HashedWheelTimeout head;
        private HashedWheelTimeout tail;

        private HashedWheelBucket() {
        }

        private HashedWheelTimeout pollTimeout() {
            HashedWheelTimeout hashedWheelTimeout = this.head;
            if (hashedWheelTimeout == null) {
                return null;
            }
            HashedWheelTimeout hashedWheelTimeout2 = hashedWheelTimeout.next;
            if (hashedWheelTimeout2 == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = hashedWheelTimeout2;
                hashedWheelTimeout2.prev = null;
            }
            hashedWheelTimeout.next = null;
            hashedWheelTimeout.prev = null;
            hashedWheelTimeout.bucket = null;
            return hashedWheelTimeout;
        }

        public void addTimeout(HashedWheelTimeout hashedWheelTimeout) {
            hashedWheelTimeout.bucket = this;
            if (this.head == null) {
                this.tail = hashedWheelTimeout;
                this.head = hashedWheelTimeout;
                return;
            }
            HashedWheelTimeout hashedWheelTimeout2 = this.tail;
            hashedWheelTimeout2.next = hashedWheelTimeout;
            hashedWheelTimeout.prev = hashedWheelTimeout2;
            this.tail = hashedWheelTimeout;
        }

        public void clearTimeouts(Set<Timeout> set) {
            while (true) {
                HashedWheelTimeout pollTimeout = pollTimeout();
                if (pollTimeout != null) {
                    if (!pollTimeout.isExpired() && !pollTimeout.isCancelled()) {
                        set.add(pollTimeout);
                    }
                } else {
                    return;
                }
            }
        }

        public void expireTimeouts(long j) {
            HashedWheelTimeout hashedWheelTimeout = this.head;
            while (hashedWheelTimeout != null) {
                HashedWheelTimeout hashedWheelTimeout2 = hashedWheelTimeout.next;
                if (hashedWheelTimeout.remainingRounds <= 0) {
                    hashedWheelTimeout2 = remove(hashedWheelTimeout);
                    if (hashedWheelTimeout.deadline <= j) {
                        hashedWheelTimeout.expire();
                    } else {
                        throw new IllegalStateException(String.format("timeout.deadline (%d) > deadline (%d)", new Object[]{Long.valueOf(hashedWheelTimeout.deadline), Long.valueOf(j)}));
                    }
                } else if (hashedWheelTimeout.isCancelled()) {
                    hashedWheelTimeout = remove(hashedWheelTimeout);
                } else {
                    hashedWheelTimeout.remainingRounds--;
                }
                hashedWheelTimeout = hashedWheelTimeout2;
            }
        }

        public HashedWheelTimeout remove(HashedWheelTimeout hashedWheelTimeout) {
            HashedWheelTimeout hashedWheelTimeout2 = hashedWheelTimeout.next;
            HashedWheelTimeout hashedWheelTimeout3 = hashedWheelTimeout.prev;
            if (hashedWheelTimeout3 != null) {
                hashedWheelTimeout3.next = hashedWheelTimeout2;
            }
            HashedWheelTimeout hashedWheelTimeout4 = hashedWheelTimeout.next;
            if (hashedWheelTimeout4 != null) {
                hashedWheelTimeout4.prev = hashedWheelTimeout3;
            }
            if (hashedWheelTimeout == this.head) {
                if (hashedWheelTimeout == this.tail) {
                    this.tail = null;
                    this.head = null;
                } else {
                    this.head = hashedWheelTimeout2;
                }
            } else if (hashedWheelTimeout == this.tail) {
                this.tail = hashedWheelTimeout.prev;
            }
            hashedWheelTimeout.prev = null;
            hashedWheelTimeout.next = null;
            hashedWheelTimeout.bucket = null;
            hashedWheelTimeout.timer.pendingTimeouts.decrementAndGet();
            return hashedWheelTimeout2;
        }
    }

    public static final class HashedWheelTimeout implements Timeout, Runnable {
        private static final AtomicIntegerFieldUpdater<HashedWheelTimeout> STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimeout.class, "state");
        private static final int ST_CANCELLED = 1;
        private static final int ST_EXPIRED = 2;
        private static final int ST_INIT = 0;
        HashedWheelBucket bucket;
        /* access modifiers changed from: private */
        public final long deadline;
        HashedWheelTimeout next;
        HashedWheelTimeout prev;
        long remainingRounds;
        private volatile int state = 0;
        private final TimerTask task;
        /* access modifiers changed from: private */
        public final HashedWheelTimer timer;

        public HashedWheelTimeout(HashedWheelTimer hashedWheelTimer, TimerTask timerTask, long j) {
            this.timer = hashedWheelTimer;
            this.task = timerTask;
            this.deadline = j;
        }

        public boolean cancel() {
            if (!compareAndSetState(0, 1)) {
                return false;
            }
            this.timer.cancelledTimeouts.add(this);
            return true;
        }

        public boolean compareAndSetState(int i, int i2) {
            return STATE_UPDATER.compareAndSet(this, i, i2);
        }

        public void expire() {
            if (compareAndSetState(0, 2)) {
                try {
                    this.timer.taskExecutor.execute(this);
                } catch (Throwable th) {
                    InternalLogger internalLogger = HashedWheelTimer.logger;
                    if (internalLogger.isWarnEnabled()) {
                        internalLogger.warn("An exception was thrown while submit " + TimerTask.class.getSimpleName() + " for execution.", th);
                    }
                }
            }
        }

        public boolean isCancelled() {
            return state() == 1;
        }

        public boolean isExpired() {
            return state() == 2;
        }

        public void remove() {
            HashedWheelBucket hashedWheelBucket = this.bucket;
            if (hashedWheelBucket != null) {
                hashedWheelBucket.remove(this);
            } else {
                this.timer.pendingTimeouts.decrementAndGet();
            }
        }

        public void run() {
            try {
                this.task.run(this);
            } catch (Throwable th) {
                InternalLogger internalLogger = HashedWheelTimer.logger;
                if (internalLogger.isWarnEnabled()) {
                    internalLogger.warn("An exception was thrown by " + TimerTask.class.getSimpleName() + '.', th);
                }
            }
        }

        public int state() {
            return this.state;
        }

        public TimerTask task() {
            return this.task;
        }

        public Timer timer() {
            return this.timer;
        }

        public String toString() {
            long nanoTime = (this.deadline - System.nanoTime()) + this.timer.startTime;
            StringBuilder sb = new StringBuilder(192);
            sb.append(StringUtil.simpleClassName((Object) this));
            sb.append('(');
            sb.append("deadline: ");
            int i = (nanoTime > 0 ? 1 : (nanoTime == 0 ? 0 : -1));
            if (i > 0) {
                sb.append(nanoTime);
                sb.append(" ns later");
            } else if (i < 0) {
                sb.append(-nanoTime);
                sb.append(" ns ago");
            } else {
                sb.append("now");
            }
            if (isCancelled()) {
                sb.append(", cancelled");
            }
            sb.append(", task: ");
            sb.append(task());
            sb.append(')');
            return sb.toString();
        }
    }

    public final class Worker implements Runnable {
        private long tick;
        private final Set<Timeout> unprocessedTimeouts;

        private Worker() {
            this.unprocessedTimeouts = new HashSet();
        }

        private void processCancelledTasks() {
            while (true) {
                HashedWheelTimeout hashedWheelTimeout = (HashedWheelTimeout) HashedWheelTimer.this.cancelledTimeouts.poll();
                if (hashedWheelTimeout != null) {
                    try {
                        hashedWheelTimeout.remove();
                    } catch (Throwable th) {
                        if (HashedWheelTimer.logger.isWarnEnabled()) {
                            HashedWheelTimer.logger.warn("An exception was thrown while process a cancellation task", th);
                        }
                    }
                } else {
                    return;
                }
            }
        }

        private void transferTimeoutsToBuckets() {
            HashedWheelTimeout hashedWheelTimeout;
            for (int i = 0; i < 100000 && (hashedWheelTimeout = (HashedWheelTimeout) HashedWheelTimer.this.timeouts.poll()) != null; i++) {
                if (hashedWheelTimeout.state() != 1) {
                    long access$800 = hashedWheelTimeout.deadline / HashedWheelTimer.this.tickDuration;
                    hashedWheelTimeout.remainingRounds = (access$800 - this.tick) / ((long) HashedWheelTimer.this.wheel.length);
                    HashedWheelTimer.this.wheel[(int) (Math.max(access$800, this.tick) & ((long) HashedWheelTimer.this.mask))].addTimeout(hashedWheelTimeout);
                }
            }
        }

        private long waitForNextTick() {
            long access$900 = HashedWheelTimer.this.tickDuration * (this.tick + 1);
            while (true) {
                long nanoTime = System.nanoTime() - HashedWheelTimer.this.startTime;
                long j = ((access$900 - nanoTime) + 999999) / 1000000;
                if (j > 0) {
                    if (PlatformDependent.isWindows()) {
                        j = (j / 10) * 10;
                        if (j == 0) {
                            j = 1;
                        }
                    }
                    try {
                        Thread.sleep(j);
                    } catch (InterruptedException unused) {
                        if (HashedWheelTimer.WORKER_STATE_UPDATER.get(HashedWheelTimer.this) == 2) {
                            return Long.MIN_VALUE;
                        }
                    }
                } else if (nanoTime == Long.MIN_VALUE) {
                    return -9223372036854775807L;
                } else {
                    return nanoTime;
                }
            }
        }

        public void run() {
            long unused = HashedWheelTimer.this.startTime = System.nanoTime();
            if (HashedWheelTimer.this.startTime == 0) {
                long unused2 = HashedWheelTimer.this.startTime = 1;
            }
            HashedWheelTimer.this.startTimeInitialized.countDown();
            do {
                long waitForNextTick = waitForNextTick();
                if (waitForNextTick > 0) {
                    processCancelledTasks();
                    HashedWheelBucket hashedWheelBucket = HashedWheelTimer.this.wheel[(int) (this.tick & ((long) HashedWheelTimer.this.mask))];
                    transferTimeoutsToBuckets();
                    hashedWheelBucket.expireTimeouts(waitForNextTick);
                    this.tick++;
                }
            } while (HashedWheelTimer.WORKER_STATE_UPDATER.get(HashedWheelTimer.this) == 1);
            for (HashedWheelBucket clearTimeouts : HashedWheelTimer.this.wheel) {
                clearTimeouts.clearTimeouts(this.unprocessedTimeouts);
            }
            while (true) {
                HashedWheelTimeout hashedWheelTimeout = (HashedWheelTimeout) HashedWheelTimer.this.timeouts.poll();
                if (hashedWheelTimeout == null) {
                    processCancelledTasks();
                    return;
                } else if (!hashedWheelTimeout.isCancelled()) {
                    this.unprocessedTimeouts.add(hashedWheelTimeout);
                }
            }
        }

        public Set<Timeout> unprocessedTimeouts() {
            return Collections.unmodifiableSet(this.unprocessedTimeouts);
        }
    }

    static {
        Class<HashedWheelTimer> cls = HashedWheelTimer.class;
        logger = InternalLoggerFactory.getInstance((Class<?>) cls);
        leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(cls, 1);
        WORKER_STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(cls, "workerState");
    }

    public HashedWheelTimer() {
        this(Executors.defaultThreadFactory());
    }

    private static HashedWheelBucket[] createWheel(int i) {
        ObjectUtil.checkInRange(i, 1, 1073741824, "ticksPerWheel");
        int normalizeTicksPerWheel = normalizeTicksPerWheel(i);
        HashedWheelBucket[] hashedWheelBucketArr = new HashedWheelBucket[normalizeTicksPerWheel];
        for (int i2 = 0; i2 < normalizeTicksPerWheel; i2++) {
            hashedWheelBucketArr[i2] = new HashedWheelBucket();
        }
        return hashedWheelBucketArr;
    }

    private static int normalizeTicksPerWheel(int i) {
        int i2 = 1;
        while (i2 < i) {
            i2 <<= 1;
        }
        return i2;
    }

    private static void reportTooManyInstances() {
        InternalLogger internalLogger = logger;
        if (internalLogger.isErrorEnabled()) {
            String simpleClassName = StringUtil.simpleClassName((Class<?>) HashedWheelTimer.class);
            internalLogger.error("You are creating too many " + simpleClassName + " instances. " + simpleClassName + " is a shared resource that must be reused across the JVM, so that only a few instances are created.");
        }
    }

    public void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            if (WORKER_STATE_UPDATER.getAndSet(this, 2) != 2) {
                INSTANCE_COUNTER.decrementAndGet();
            }
        }
    }

    public Timeout newTimeout(TimerTask timerTask, long j, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(timerTask, "task");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        long incrementAndGet = this.pendingTimeouts.incrementAndGet();
        long j2 = this.maxPendingTimeouts;
        if (j2 <= 0 || incrementAndGet <= j2) {
            start();
            long nanoTime = (System.nanoTime() + timeUnit.toNanos(j)) - this.startTime;
            if (j > 0 && nanoTime < 0) {
                nanoTime = LongCompanionObject.MAX_VALUE;
            }
            HashedWheelTimeout hashedWheelTimeout = new HashedWheelTimeout(this, timerTask, nanoTime);
            this.timeouts.add(hashedWheelTimeout);
            return hashedWheelTimeout;
        }
        this.pendingTimeouts.decrementAndGet();
        throw new RejectedExecutionException("Number of pending timeouts (" + incrementAndGet + ") is greater than or equal to maximum allowed pending timeouts (" + this.maxPendingTimeouts + ")");
    }

    public long pendingTimeouts() {
        return this.pendingTimeouts.get();
    }

    public void start() {
        AtomicIntegerFieldUpdater<HashedWheelTimer> atomicIntegerFieldUpdater = WORKER_STATE_UPDATER;
        int i = atomicIntegerFieldUpdater.get(this);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    throw new Error("Invalid WorkerState");
                }
                throw new IllegalStateException("cannot be started once stopped");
            }
        } else if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
            this.workerThread.start();
        }
        while (this.startTime == 0) {
            try {
                this.startTimeInitialized.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public Set<Timeout> stop() {
        if (Thread.currentThread() != this.workerThread) {
            AtomicIntegerFieldUpdater<HashedWheelTimer> atomicIntegerFieldUpdater = WORKER_STATE_UPDATER;
            if (!atomicIntegerFieldUpdater.compareAndSet(this, 1, 2)) {
                if (atomicIntegerFieldUpdater.getAndSet(this, 2) != 2) {
                    INSTANCE_COUNTER.decrementAndGet();
                    ResourceLeakTracker<HashedWheelTimer> resourceLeakTracker = this.leak;
                    if (resourceLeakTracker != null) {
                        resourceLeakTracker.close(this);
                    }
                }
                return Collections.emptySet();
            }
            boolean z = false;
            while (this.workerThread.isAlive()) {
                try {
                    this.workerThread.interrupt();
                    try {
                        this.workerThread.join(100);
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                } finally {
                    INSTANCE_COUNTER.decrementAndGet();
                    ResourceLeakTracker<HashedWheelTimer> resourceLeakTracker2 = this.leak;
                    if (resourceLeakTracker2 != null) {
                        resourceLeakTracker2.close(this);
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return this.worker.unprocessedTimeouts();
        }
        throw new IllegalStateException(HashedWheelTimer.class.getSimpleName() + ".stop() cannot be called from " + TimerTask.class.getSimpleName());
    }

    public HashedWheelTimer(long j, TimeUnit timeUnit) {
        this(Executors.defaultThreadFactory(), j, timeUnit);
    }

    public HashedWheelTimer(long j, TimeUnit timeUnit, int i) {
        this(Executors.defaultThreadFactory(), j, timeUnit, i);
    }

    public HashedWheelTimer(ThreadFactory threadFactory) {
        this(threadFactory, 100, TimeUnit.MILLISECONDS);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
        this(threadFactory, j, timeUnit, 512);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j, TimeUnit timeUnit, int i) {
        this(threadFactory, j, timeUnit, i, true);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j, TimeUnit timeUnit, int i, boolean z) {
        this(threadFactory, j, timeUnit, i, z, -1);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j, TimeUnit timeUnit, int i, boolean z, long j2) {
        this(threadFactory, j, timeUnit, i, z, j2, ImmediateExecutor.INSTANCE);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j, TimeUnit timeUnit, int i, boolean z, long j2, Executor executor) {
        ThreadFactory threadFactory2 = threadFactory;
        long j3 = j;
        TimeUnit timeUnit2 = timeUnit;
        ResourceLeakTracker<HashedWheelTimer> resourceLeakTracker = null;
        Worker worker2 = new Worker();
        this.worker = worker2;
        this.startTimeInitialized = new CountDownLatch(1);
        this.timeouts = PlatformDependent.newMpscQueue();
        this.cancelledTimeouts = PlatformDependent.newMpscQueue();
        this.pendingTimeouts = new AtomicLong(0);
        ObjectUtil.checkNotNull(threadFactory2, "threadFactory");
        ObjectUtil.checkNotNull(timeUnit2, "unit");
        ObjectUtil.checkPositive(j3, "tickDuration");
        ObjectUtil.checkPositive(i, "ticksPerWheel");
        this.taskExecutor = (Executor) ObjectUtil.checkNotNull(executor, "taskExecutor");
        HashedWheelBucket[] createWheel = createWheel(i);
        this.wheel = createWheel;
        this.mask = createWheel.length - 1;
        long nanos = timeUnit2.toNanos(j3);
        if (nanos < LongCompanionObject.MAX_VALUE / ((long) createWheel.length)) {
            long j4 = MILLISECOND_NANOS;
            if (nanos < j4) {
                logger.warn("Configured tickDuration {} smaller than {}, using 1ms.", Long.valueOf(j), Long.valueOf(j4));
                this.tickDuration = j4;
            } else {
                this.tickDuration = nanos;
            }
            Thread newThread = threadFactory2.newThread(worker2);
            this.workerThread = newThread;
            this.leak = (z || !newThread.isDaemon()) ? leakDetector.track(this) : resourceLeakTracker;
            this.maxPendingTimeouts = j2;
            if (INSTANCE_COUNTER.incrementAndGet() > 64 && WARNED_TOO_MANY_INSTANCES.compareAndSet(false, true)) {
                reportTooManyInstances();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("tickDuration: %d (expected: 0 < tickDuration in nanos < %d", new Object[]{Long.valueOf(j), Long.valueOf(LongCompanionObject.MAX_VALUE / ((long) createWheel.length))}));
    }
}
