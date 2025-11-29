package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public final class NonStickyEventExecutorGroup implements EventExecutorGroup {
    private final EventExecutorGroup group;
    private final int maxTaskExecutePerRun;

    public static final class NonStickyOrderedEventExecutor extends AbstractEventExecutor implements Runnable, OrderedEventExecutor {
        private static final int NONE = 0;
        private static final int RUNNING = 2;
        private static final int SUBMITTED = 1;
        private final EventExecutor executor;
        private final int maxTaskExecutePerRun;
        private final AtomicInteger state = new AtomicInteger();
        private final Queue<Runnable> tasks = PlatformDependent.newMpscQueue();

        public NonStickyOrderedEventExecutor(EventExecutor eventExecutor, int i) {
            super(eventExecutor);
            this.executor = eventExecutor;
            this.maxTaskExecutePerRun = i;
        }

        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.executor.awaitTermination(j, timeUnit);
        }

        public void execute(Runnable runnable) {
            if (!this.tasks.offer(runnable)) {
                throw new RejectedExecutionException();
            } else if (this.state.compareAndSet(0, 1)) {
                this.executor.execute(this);
            }
        }

        public boolean inEventLoop() {
            return false;
        }

        public boolean isShutdown() {
            return this.executor.isShutdown();
        }

        public boolean isShuttingDown() {
            return this.executor.isShutdown();
        }

        public boolean isTerminated() {
            return this.executor.isTerminated();
        }

        public void run() {
            if (this.state.compareAndSet(1, 2)) {
                while (true) {
                    int i = 0;
                    while (true) {
                        try {
                            if (i >= this.maxTaskExecutePerRun) {
                                break;
                            }
                            Runnable poll = this.tasks.poll();
                            if (poll == null) {
                                break;
                            }
                            AbstractEventExecutor.safeExecute(poll);
                            i++;
                        } catch (Throwable unused) {
                            this.state.set(2);
                            throw th;
                        }
                    }
                    if (i == this.maxTaskExecutePerRun) {
                        try {
                            this.state.set(1);
                            this.executor.execute(this);
                            return;
                        } catch (Throwable unused2) {
                            this.state.set(2);
                        }
                    } else {
                        this.state.set(0);
                        if (this.tasks.isEmpty() || !this.state.compareAndSet(0, 2)) {
                            return;
                        }
                    }
                }
            }
        }

        public void shutdown() {
            this.executor.shutdown();
        }

        public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
            return this.executor.shutdownGracefully(j, j2, timeUnit);
        }

        public Future<?> terminationFuture() {
            return this.executor.terminationFuture();
        }

        public boolean inEventLoop(Thread thread) {
            return false;
        }
    }

    public NonStickyEventExecutorGroup(EventExecutorGroup eventExecutorGroup) {
        this(eventExecutorGroup, 1024);
    }

    /* access modifiers changed from: private */
    public NonStickyOrderedEventExecutor newExecutor(EventExecutor eventExecutor) {
        return new NonStickyOrderedEventExecutor(eventExecutor, this.maxTaskExecutePerRun);
    }

    private static EventExecutorGroup verify(EventExecutorGroup eventExecutorGroup) {
        for (EventExecutor next : (EventExecutorGroup) ObjectUtil.checkNotNull(eventExecutorGroup, "group")) {
            if (next instanceof OrderedEventExecutor) {
                throw new IllegalArgumentException("EventExecutorGroup " + eventExecutorGroup + " contains OrderedEventExecutors: " + next);
            }
        }
        return eventExecutorGroup;
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.group.awaitTermination(j, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.group.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.group.invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.group.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.group.isShutdown();
    }

    public boolean isShuttingDown() {
        return this.group.isShuttingDown();
    }

    public boolean isTerminated() {
        return this.group.isTerminated();
    }

    public Iterator<EventExecutor> iterator() {
        final Iterator<EventExecutor> it = this.group.iterator();
        return new Iterator<EventExecutor>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public void remove() {
                it.remove();
            }

            public EventExecutor next() {
                return NonStickyEventExecutorGroup.this.newExecutor((EventExecutor) it.next());
            }
        };
    }

    public EventExecutor next() {
        return newExecutor(this.group.next());
    }

    public void shutdown() {
        this.group.shutdown();
    }

    public Future<?> shutdownGracefully() {
        return this.group.shutdownGracefully();
    }

    public List<Runnable> shutdownNow() {
        return this.group.shutdownNow();
    }

    public Future<?> terminationFuture() {
        return this.group.terminationFuture();
    }

    public NonStickyEventExecutorGroup(EventExecutorGroup eventExecutorGroup, int i) {
        this.group = verify(eventExecutorGroup);
        this.maxTaskExecutePerRun = ObjectUtil.checkPositive(i, "maxTaskExecutePerRun");
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.group.invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.group.invokeAny(collection, j, timeUnit);
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.group.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.group.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        return this.group.shutdownGracefully(j, j2, timeUnit);
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.group.schedule(runnable, j, timeUnit);
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return this.group.schedule(callable, j, timeUnit);
    }

    public Future<?> submit(Runnable runnable) {
        return this.group.submit(runnable);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.group.submit(runnable, t);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.group.submit(callable);
    }
}
