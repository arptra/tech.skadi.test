package io.netty.util.concurrent;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class UnorderedThreadPoolEventExecutor extends ScheduledThreadPoolExecutor implements EventExecutor {
    /* access modifiers changed from: private */
    public static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) UnorderedThreadPoolEventExecutor.class);
    private final Set<EventExecutor> executorSet;
    private final Promise<?> terminationFuture;

    public static final class NonNotifyRunnable implements Runnable {
        private final Runnable task;

        public NonNotifyRunnable(Runnable runnable) {
            this.task = runnable;
        }

        public void run() {
            this.task.run();
        }
    }

    public static final class RunnableScheduledFutureTask<V> extends PromiseTask<V> implements RunnableScheduledFuture<V>, ScheduledFuture<V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final RunnableScheduledFuture<V> future;
        private final boolean wasCallable;

        public RunnableScheduledFutureTask(EventExecutor eventExecutor, RunnableScheduledFuture<V> runnableScheduledFuture, boolean z) {
            super(eventExecutor, (Runnable) runnableScheduledFuture);
            this.future = runnableScheduledFuture;
            this.wasCallable = z;
        }

        public long getDelay(TimeUnit timeUnit) {
            return this.future.getDelay(timeUnit);
        }

        public boolean isPeriodic() {
            return this.future.isPeriodic();
        }

        public void run() {
            if (!isPeriodic()) {
                super.run();
            } else if (!isDone()) {
                try {
                    runTask();
                } catch (Throwable th) {
                    if (!tryFailureInternal(th)) {
                        UnorderedThreadPoolEventExecutor.logger.warn("Failure during execution of task", th);
                    }
                }
            }
        }

        public V runTask() throws Throwable {
            V runTask = super.runTask();
            if (runTask != null || !this.wasCallable) {
                return runTask;
            }
            try {
                return this.future.get();
            } catch (ExecutionException e) {
                throw e.getCause();
            }
        }

        public int compareTo(Delayed delayed) {
            return this.future.compareTo(delayed);
        }
    }

    public UnorderedThreadPoolEventExecutor(int i) {
        this(i, (ThreadFactory) new DefaultThreadFactory((Class<?>) UnorderedThreadPoolEventExecutor.class));
    }

    public <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        return runnable instanceof NonNotifyRunnable ? runnableScheduledFuture : new RunnableScheduledFutureTask(this, runnableScheduledFuture, false);
    }

    public void execute(Runnable runnable) {
        super.schedule(new NonNotifyRunnable(runnable), 0, TimeUnit.NANOSECONDS);
    }

    public boolean inEventLoop() {
        return false;
    }

    public boolean isShuttingDown() {
        return isShutdown();
    }

    public Iterator<EventExecutor> iterator() {
        return this.executorSet.iterator();
    }

    public <V> Future<V> newFailedFuture(Throwable th) {
        return new FailedFuture(this, th);
    }

    public <V> ProgressivePromise<V> newProgressivePromise() {
        return new DefaultProgressivePromise(this);
    }

    public <V> Promise<V> newPromise() {
        return new DefaultPromise(this);
    }

    public <V> Future<V> newSucceededFuture(V v) {
        return new SucceededFuture(this, v);
    }

    public EventExecutor next() {
        return this;
    }

    public EventExecutorGroup parent() {
        return this;
    }

    public void shutdown() {
        super.shutdown();
        this.terminationFuture.trySuccess(null);
    }

    public Future<?> shutdownGracefully() {
        return shutdownGracefully(2, 15, TimeUnit.SECONDS);
    }

    public List<Runnable> shutdownNow() {
        List<Runnable> shutdownNow = super.shutdownNow();
        this.terminationFuture.trySuccess(null);
        return shutdownNow;
    }

    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    public UnorderedThreadPoolEventExecutor(int i, ThreadFactory threadFactory) {
        super(i, threadFactory);
        this.terminationFuture = GlobalEventExecutor.INSTANCE.newPromise();
        this.executorSet = Collections.singleton(this);
    }

    public <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        return new RunnableScheduledFutureTask(this, runnableScheduledFuture, true);
    }

    public boolean inEventLoop(Thread thread) {
        return false;
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return (ScheduledFuture) super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return (ScheduledFuture) super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        shutdown();
        return terminationFuture();
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return (ScheduledFuture) super.schedule(runnable, j, timeUnit);
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return (ScheduledFuture) super.schedule(callable, j, timeUnit);
    }

    public Future<?> submit(Runnable runnable) {
        return (Future) super.submit(runnable);
    }

    public UnorderedThreadPoolEventExecutor(int i, RejectedExecutionHandler rejectedExecutionHandler) {
        this(i, new DefaultThreadFactory((Class<?>) UnorderedThreadPoolEventExecutor.class), rejectedExecutionHandler);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return (Future) super.submit(runnable, t);
    }

    public UnorderedThreadPoolEventExecutor(int i, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, threadFactory, rejectedExecutionHandler);
        this.terminationFuture = GlobalEventExecutor.INSTANCE.newPromise();
        this.executorSet = Collections.singleton(this);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return (Future) super.submit(callable);
    }
}
