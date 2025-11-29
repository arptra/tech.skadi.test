package io.netty.util.concurrent;

import com.here.posclient.UpdateOptions;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MultithreadEventExecutorGroup extends AbstractEventExecutorGroup {
    /* access modifiers changed from: private */
    public final EventExecutor[] children;
    private final EventExecutorChooserFactory.EventExecutorChooser chooser;
    private final Set<EventExecutor> readonlyChildren;
    /* access modifiers changed from: private */
    public final AtomicInteger terminatedChildren;
    /* access modifiers changed from: private */
    public final Promise<?> terminationFuture;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MultithreadEventExecutorGroup(int i, ThreadFactory threadFactory, Object... objArr) {
        this(i, (Executor) threadFactory == null ? null : new ThreadPerTaskExecutor(threadFactory), objArr);
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanoTime;
        long nanoTime2 = System.nanoTime() + timeUnit.toNanos(j);
        loop0:
        for (EventExecutor eventExecutor : this.children) {
            do {
                nanoTime = nanoTime2 - System.nanoTime();
                if (nanoTime <= 0) {
                    break loop0;
                }
            } while (!eventExecutor.awaitTermination(nanoTime, TimeUnit.NANOSECONDS));
        }
        return isTerminated();
    }

    public final int executorCount() {
        return this.children.length;
    }

    public boolean isShutdown() {
        for (EventExecutor isShutdown : this.children) {
            if (!isShutdown.isShutdown()) {
                return false;
            }
        }
        return true;
    }

    public boolean isShuttingDown() {
        for (EventExecutor isShuttingDown : this.children) {
            if (!isShuttingDown.isShuttingDown()) {
                return false;
            }
        }
        return true;
    }

    public boolean isTerminated() {
        for (EventExecutor isTerminated : this.children) {
            if (!isTerminated.isTerminated()) {
                return false;
            }
        }
        return true;
    }

    public Iterator<EventExecutor> iterator() {
        return this.readonlyChildren.iterator();
    }

    public abstract EventExecutor newChild(Executor executor, Object... objArr) throws Exception;

    public ThreadFactory newDefaultThreadFactory() {
        return new DefaultThreadFactory(getClass());
    }

    public EventExecutor next() {
        return this.chooser.next();
    }

    @Deprecated
    public void shutdown() {
        for (EventExecutor shutdown : this.children) {
            shutdown.shutdown();
        }
    }

    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        for (EventExecutor shutdownGracefully : this.children) {
            shutdownGracefully.shutdownGracefully(j, j2, timeUnit);
        }
        return terminationFuture();
    }

    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    public MultithreadEventExecutorGroup(int i, Executor executor, Object... objArr) {
        this(i, executor, DefaultEventExecutorChooserFactory.INSTANCE, objArr);
    }

    public MultithreadEventExecutorGroup(int i, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, Object... objArr) {
        this.terminatedChildren = new AtomicInteger();
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        ObjectUtil.checkPositive(i, "nThreads");
        executor = executor == null ? new ThreadPerTaskExecutor(newDefaultThreadFactory()) : executor;
        this.children = new EventExecutor[i];
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            try {
                this.children[i3] = newChild(executor, objArr);
                i3++;
            } catch (Exception e) {
                throw new IllegalStateException("failed to create a child event loop", e);
            } catch (Throwable th) {
                for (int i4 = 0; i4 < i3; i4++) {
                    this.children[i4].shutdownGracefully();
                }
                while (i2 < i3) {
                    EventExecutor eventExecutor = this.children[i2];
                    while (!eventExecutor.isTerminated()) {
                        try {
                            eventExecutor.awaitTermination(UpdateOptions.SOURCE_ANY, TimeUnit.SECONDS);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw th;
                        }
                    }
                    i2++;
                }
                throw th;
            }
        }
        this.chooser = eventExecutorChooserFactory.newChooser(this.children);
        AnonymousClass1 r5 = new FutureListener<Object>() {
            public void operationComplete(Future<Object> future) throws Exception {
                if (MultithreadEventExecutorGroup.this.terminatedChildren.incrementAndGet() == MultithreadEventExecutorGroup.this.children.length) {
                    MultithreadEventExecutorGroup.this.terminationFuture.setSuccess(null);
                }
            }
        };
        EventExecutor[] eventExecutorArr = this.children;
        int length = eventExecutorArr.length;
        while (i2 < length) {
            eventExecutorArr[i2].terminationFuture().addListener(r5);
            i2++;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.children.length);
        Collections.addAll(linkedHashSet, this.children);
        this.readonlyChildren = Collections.unmodifiableSet(linkedHashSet);
    }
}
