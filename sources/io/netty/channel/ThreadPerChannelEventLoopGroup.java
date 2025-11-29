package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutorGroup;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.ThreadPerTaskExecutor;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReadOnlyIterator;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@Deprecated
public class ThreadPerChannelEventLoopGroup extends AbstractEventExecutorGroup implements EventLoopGroup {
    final Set<EventLoop> activeChildren;
    private final Object[] childArgs;
    private final FutureListener<Object> childTerminationListener;
    final Executor executor;
    final Queue<EventLoop> idleChildren;
    private final int maxChannels;
    private volatile boolean shuttingDown;
    /* access modifiers changed from: private */
    public final Promise<?> terminationFuture;
    private final ChannelException tooManyChannels;

    public ThreadPerChannelEventLoopGroup() {
        this(0);
    }

    private EventLoop nextChild() throws Exception {
        if (!this.shuttingDown) {
            EventLoop poll = this.idleChildren.poll();
            if (poll == null) {
                if (this.maxChannels <= 0 || this.activeChildren.size() < this.maxChannels) {
                    poll = newChild(this.childArgs);
                    poll.terminationFuture().addListener(this.childTerminationListener);
                } else {
                    throw this.tooManyChannels;
                }
            }
            this.activeChildren.add(poll);
            return poll;
        }
        throw new RejectedExecutionException("shutting down");
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanoTime = System.nanoTime() + timeUnit.toNanos(j);
        for (EventLoop next : this.activeChildren) {
            while (true) {
                long nanoTime2 = nanoTime - System.nanoTime();
                if (nanoTime2 <= 0) {
                    return isTerminated();
                }
                if (next.awaitTermination(nanoTime2, TimeUnit.NANOSECONDS)) {
                }
            }
        }
        for (EventLoop next2 : this.idleChildren) {
            while (true) {
                long nanoTime3 = nanoTime - System.nanoTime();
                if (nanoTime3 <= 0) {
                    return isTerminated();
                }
                if (next2.awaitTermination(nanoTime3, TimeUnit.NANOSECONDS)) {
                }
            }
        }
        return isTerminated();
    }

    public boolean isShutdown() {
        for (EventLoop isShutdown : this.activeChildren) {
            if (!isShutdown.isShutdown()) {
                return false;
            }
        }
        for (EventLoop isShutdown2 : this.idleChildren) {
            if (!isShutdown2.isShutdown()) {
                return false;
            }
        }
        return true;
    }

    public boolean isShuttingDown() {
        for (EventLoop isShuttingDown : this.activeChildren) {
            if (!isShuttingDown.isShuttingDown()) {
                return false;
            }
        }
        for (EventLoop isShuttingDown2 : this.idleChildren) {
            if (!isShuttingDown2.isShuttingDown()) {
                return false;
            }
        }
        return true;
    }

    public boolean isTerminated() {
        for (EventLoop isTerminated : this.activeChildren) {
            if (!isTerminated.isTerminated()) {
                return false;
            }
        }
        for (EventLoop isTerminated2 : this.idleChildren) {
            if (!isTerminated2.isTerminated()) {
                return false;
            }
        }
        return true;
    }

    public Iterator<EventExecutor> iterator() {
        return new ReadOnlyIterator(this.activeChildren.iterator());
    }

    public EventLoop newChild(Object... objArr) throws Exception {
        return new ThreadPerChannelEventLoop(this);
    }

    public ChannelFuture register(Channel channel) {
        ObjectUtil.checkNotNull(channel, "channel");
        try {
            EventLoop nextChild = nextChild();
            return nextChild.register((ChannelPromise) new DefaultChannelPromise(channel, nextChild));
        } catch (Throwable th) {
            return new FailedChannelFuture(channel, GlobalEventExecutor.INSTANCE, th);
        }
    }

    @Deprecated
    public void shutdown() {
        this.shuttingDown = true;
        for (EventLoop shutdown : this.activeChildren) {
            shutdown.shutdown();
        }
        for (EventLoop shutdown2 : this.idleChildren) {
            shutdown2.shutdown();
        }
        if (isTerminated()) {
            this.terminationFuture.trySuccess(null);
        }
    }

    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        this.shuttingDown = true;
        for (EventLoop shutdownGracefully : this.activeChildren) {
            shutdownGracefully.shutdownGracefully(j, j2, timeUnit);
        }
        for (EventLoop shutdownGracefully2 : this.idleChildren) {
            shutdownGracefully2.shutdownGracefully(j, j2, timeUnit);
        }
        if (isTerminated()) {
            this.terminationFuture.trySuccess(null);
        }
        return terminationFuture();
    }

    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    public ThreadPerChannelEventLoopGroup(int i) {
        this(i, (ThreadFactory) null, new Object[0]);
    }

    public EventLoop next() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ThreadPerChannelEventLoopGroup(int i, ThreadFactory threadFactory, Object... objArr) {
        this(i, (Executor) threadFactory == null ? null : new ThreadPerTaskExecutor(threadFactory), objArr);
    }

    public ThreadPerChannelEventLoopGroup(int i, Executor executor2, Object... objArr) {
        this.activeChildren = Collections.newSetFromMap(PlatformDependent.newConcurrentHashMap());
        this.idleChildren = new ConcurrentLinkedQueue();
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.childTerminationListener = new FutureListener<Object>() {
            public void operationComplete(Future<Object> future) throws Exception {
                if (ThreadPerChannelEventLoopGroup.this.isTerminated()) {
                    ThreadPerChannelEventLoopGroup.this.terminationFuture.trySuccess(null);
                }
            }
        };
        ObjectUtil.checkPositiveOrZero(i, "maxChannels");
        executor2 = executor2 == null ? new ThreadPerTaskExecutor(new DefaultThreadFactory(getClass())) : executor2;
        if (objArr == null) {
            this.childArgs = EmptyArrays.EMPTY_OBJECTS;
        } else {
            this.childArgs = (Object[]) objArr.clone();
        }
        this.maxChannels = i;
        this.executor = executor2;
        this.tooManyChannels = ChannelException.newStatic("too many channels (max: " + i + ')', ThreadPerChannelEventLoopGroup.class, "nextChild()");
    }

    public ChannelFuture register(ChannelPromise channelPromise) {
        try {
            return nextChild().register(channelPromise);
        } catch (Throwable th) {
            channelPromise.setFailure(th);
            return channelPromise;
        }
    }

    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(channel, "channel");
        try {
            return nextChild().register(channel, channelPromise);
        } catch (Throwable th) {
            channelPromise.setFailure(th);
            return channelPromise;
        }
    }
}
