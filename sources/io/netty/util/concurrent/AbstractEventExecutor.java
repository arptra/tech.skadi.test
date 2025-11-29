package io.netty.util.concurrent;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.Async;

public abstract class AbstractEventExecutor extends AbstractExecutorService implements EventExecutor {
    static final long DEFAULT_SHUTDOWN_QUIET_PERIOD = 2;
    static final long DEFAULT_SHUTDOWN_TIMEOUT = 15;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractEventExecutor.class);
    private final EventExecutorGroup parent;
    private final Collection<EventExecutor> selfCollection;

    public interface LazyRunnable extends Runnable {
    }

    public AbstractEventExecutor() {
        this((EventExecutorGroup) null);
    }

    private void lazyExecute0(@Async.Schedule Runnable runnable) {
        execute(runnable);
    }

    public static void runTask(@Async.Execute Runnable runnable) {
        runnable.run();
    }

    public static void safeExecute(Runnable runnable) {
        try {
            runTask(runnable);
        } catch (Throwable th) {
            logger.warn("A task raised an exception. Task: {}", runnable, th);
        }
    }

    public boolean inEventLoop() {
        return inEventLoop(Thread.currentThread());
    }

    public Iterator<EventExecutor> iterator() {
        return this.selfCollection.iterator();
    }

    public void lazyExecute(Runnable runnable) {
        lazyExecute0(runnable);
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

    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new PromiseTask(this, runnable, t);
    }

    public EventExecutor next() {
        return this;
    }

    public EventExecutorGroup parent() {
        return this.parent;
    }

    @Deprecated
    public abstract void shutdown();

    public Future<?> shutdownGracefully() {
        return shutdownGracefully(2, 15, TimeUnit.SECONDS);
    }

    @Deprecated
    public List<Runnable> shutdownNow() {
        shutdown();
        return Collections.emptyList();
    }

    public AbstractEventExecutor(EventExecutorGroup eventExecutorGroup) {
        this.selfCollection = Collections.singleton(this);
        this.parent = eventExecutorGroup;
    }

    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new PromiseTask((EventExecutor) this, callable);
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public Future<?> submit(Runnable runnable) {
        return (Future) super.submit(runnable);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return (Future) super.submit(runnable, t);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return (Future) super.submit(callable);
    }
}
