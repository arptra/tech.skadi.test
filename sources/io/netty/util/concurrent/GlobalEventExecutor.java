package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.Async;

public final class GlobalEventExecutor extends AbstractScheduledEventExecutor implements OrderedEventExecutor {
    public static final GlobalEventExecutor INSTANCE = new GlobalEventExecutor();
    private static final long SCHEDULE_QUIET_PERIOD_INTERVAL = TimeUnit.SECONDS.toNanos(1);
    /* access modifiers changed from: private */
    public static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) GlobalEventExecutor.class);
    final ScheduledFutureTask<Void> quietPeriodTask;
    /* access modifiers changed from: private */
    public final AtomicBoolean started;
    final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue();
    private final TaskRunner taskRunner;
    private final Future<?> terminationFuture;
    volatile Thread thread;
    final ThreadFactory threadFactory;

    public final class TaskRunner implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public TaskRunner() {
        }

        public void run() {
            while (true) {
                Runnable takeTask = GlobalEventExecutor.this.takeTask();
                if (takeTask != null) {
                    try {
                        AbstractEventExecutor.runTask(takeTask);
                    } catch (Throwable th) {
                        GlobalEventExecutor.logger.warn("Unexpected exception from the global event executor: ", th);
                    }
                    if (takeTask != GlobalEventExecutor.this.quietPeriodTask) {
                        continue;
                    }
                }
                GlobalEventExecutor globalEventExecutor = GlobalEventExecutor.this;
                PriorityQueue<ScheduledFutureTask<?>> priorityQueue = globalEventExecutor.scheduledTaskQueue;
                if (globalEventExecutor.taskQueue.isEmpty() && (priorityQueue == null || priorityQueue.size() == 1)) {
                    GlobalEventExecutor.this.started.compareAndSet(true, false);
                    if (GlobalEventExecutor.this.taskQueue.isEmpty() || !GlobalEventExecutor.this.started.compareAndSet(false, true)) {
                        return;
                    }
                }
            }
        }
    }

    private GlobalEventExecutor() {
        Callable callable = Executors.callable(new Runnable() {
            public void run() {
            }
        }, (Object) null);
        long currentTimeNanos = getCurrentTimeNanos();
        long j = SCHEDULE_QUIET_PERIOD_INTERVAL;
        ScheduledFutureTask scheduledFutureTask = new ScheduledFutureTask((AbstractScheduledEventExecutor) this, callable, AbstractScheduledEventExecutor.deadlineNanos(currentTimeNanos, j), -j);
        this.quietPeriodTask = scheduledFutureTask;
        this.taskRunner = new TaskRunner();
        this.started = new AtomicBoolean();
        this.terminationFuture = new FailedFuture(this, new UnsupportedOperationException());
        scheduledTaskQueue().add(scheduledFutureTask);
        this.threadFactory = ThreadExecutorMap.apply((ThreadFactory) new DefaultThreadFactory(DefaultThreadFactory.toPoolName(GlobalEventExecutor.class), false, 5, (ThreadGroup) null), (EventExecutor) this);
    }

    private void addTask(Runnable runnable) {
        this.taskQueue.add(ObjectUtil.checkNotNull(runnable, "task"));
    }

    private void execute0(@Async.Schedule Runnable runnable) {
        addTask((Runnable) ObjectUtil.checkNotNull(runnable, "task"));
        if (!inEventLoop()) {
            startThread();
        }
    }

    private void fetchFromScheduledTaskQueue() {
        long currentTimeNanos = getCurrentTimeNanos();
        Runnable pollScheduledTask = pollScheduledTask(currentTimeNanos);
        while (pollScheduledTask != null) {
            this.taskQueue.add(pollScheduledTask);
            pollScheduledTask = pollScheduledTask(currentTimeNanos);
        }
    }

    private void startThread() {
        if (this.started.compareAndSet(false, true)) {
            final Thread newThread = this.threadFactory.newThread(this.taskRunner);
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    newThread.setContextClassLoader((ClassLoader) null);
                    return null;
                }
            });
            this.thread = newThread;
            newThread.start();
        }
    }

    public boolean awaitInactivity(long j, TimeUnit timeUnit) throws InterruptedException {
        ObjectUtil.checkNotNull(timeUnit, "unit");
        Thread thread2 = this.thread;
        if (thread2 != null) {
            thread2.join(timeUnit.toMillis(j));
            return !thread2.isAlive();
        }
        throw new IllegalStateException("thread was not started");
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return false;
    }

    public void execute(Runnable runnable) {
        execute0(runnable);
    }

    public boolean inEventLoop(Thread thread2) {
        return thread2 == this.thread;
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isShuttingDown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public int pendingTasks() {
        return this.taskQueue.size();
    }

    @Deprecated
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        return terminationFuture();
    }

    public Runnable takeTask() {
        Runnable runnable;
        BlockingQueue<Runnable> blockingQueue = this.taskQueue;
        do {
            ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
            runnable = null;
            if (peekScheduledTask == null) {
                try {
                    return blockingQueue.take();
                } catch (InterruptedException unused) {
                    return null;
                }
            } else {
                long delayNanos = peekScheduledTask.delayNanos();
                if (delayNanos > 0) {
                    try {
                        runnable = blockingQueue.poll(delayNanos, TimeUnit.NANOSECONDS);
                    } catch (InterruptedException unused2) {
                        return null;
                    }
                }
                if (runnable == null) {
                    fetchFromScheduledTaskQueue();
                    runnable = blockingQueue.poll();
                    continue;
                }
            }
        } while (runnable == null);
        return runnable;
    }

    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }
}
