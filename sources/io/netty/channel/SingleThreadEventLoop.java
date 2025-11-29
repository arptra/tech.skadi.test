package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.RejectedExecutionHandlers;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public abstract class SingleThreadEventLoop extends SingleThreadEventExecutor implements EventLoop {
    protected static final int DEFAULT_MAX_PENDING_TASKS = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventLoop.maxPendingTasks", Integer.MAX_VALUE));
    private final Queue<Runnable> tailTasks;

    public static final class ChannelsReadOnlyIterator<T extends Channel> implements Iterator<Channel> {
        private static final Iterator<Object> EMPTY = new Iterator<Object>() {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        };
        private final Iterator<T> channelIterator;

        public ChannelsReadOnlyIterator(Iterable<T> iterable) {
            this.channelIterator = ((Iterable) ObjectUtil.checkNotNull(iterable, "channelIterable")).iterator();
        }

        public static <T> Iterator<T> empty() {
            return EMPTY;
        }

        public boolean hasNext() {
            return this.channelIterator.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        public Channel next() {
            return (Channel) this.channelIterator.next();
        }
    }

    public SingleThreadEventLoop(EventLoopGroup eventLoopGroup, ThreadFactory threadFactory, boolean z) {
        this(eventLoopGroup, threadFactory, z, DEFAULT_MAX_PENDING_TASKS, RejectedExecutionHandlers.reject());
    }

    public void afterRunningAllTasks() {
        runAllTasksFrom(this.tailTasks);
    }

    public final void executeAfterEventLoopIteration(Runnable runnable) {
        ObjectUtil.checkNotNull(runnable, "task");
        if (isShutdown()) {
            SingleThreadEventExecutor.reject();
        }
        if (!this.tailTasks.offer(runnable)) {
            reject(runnable);
        }
        if (!(runnable instanceof AbstractEventExecutor.LazyRunnable) && wakesUpForTask(runnable)) {
            wakeup(inEventLoop());
        }
    }

    public boolean hasTasks() {
        return super.hasTasks() || !this.tailTasks.isEmpty();
    }

    public int pendingTasks() {
        return super.pendingTasks() + this.tailTasks.size();
    }

    public ChannelFuture register(Channel channel) {
        return register((ChannelPromise) new DefaultChannelPromise(channel, this));
    }

    public int registeredChannels() {
        return -1;
    }

    public Iterator<Channel> registeredChannelsIterator() {
        throw new UnsupportedOperationException("registeredChannelsIterator");
    }

    public final boolean removeAfterEventLoopIterationTask(Runnable runnable) {
        return this.tailTasks.remove(ObjectUtil.checkNotNull(runnable, "task"));
    }

    public SingleThreadEventLoop(EventLoopGroup eventLoopGroup, Executor executor, boolean z) {
        this(eventLoopGroup, executor, z, DEFAULT_MAX_PENDING_TASKS, RejectedExecutionHandlers.reject());
    }

    public EventLoop next() {
        return (EventLoop) super.next();
    }

    public EventLoopGroup parent() {
        return (EventLoopGroup) super.parent();
    }

    public ChannelFuture register(ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(channelPromise, "promise");
        channelPromise.channel().unsafe().register(this, channelPromise);
        return channelPromise;
    }

    public SingleThreadEventLoop(EventLoopGroup eventLoopGroup, ThreadFactory threadFactory, boolean z, int i, RejectedExecutionHandler rejectedExecutionHandler) {
        super((EventExecutorGroup) eventLoopGroup, threadFactory, z, i, rejectedExecutionHandler);
        this.tailTasks = newTaskQueue(i);
    }

    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(channelPromise, "promise");
        ObjectUtil.checkNotNull(channel, "channel");
        channel.unsafe().register(this, channelPromise);
        return channelPromise;
    }

    public SingleThreadEventLoop(EventLoopGroup eventLoopGroup, Executor executor, boolean z, int i, RejectedExecutionHandler rejectedExecutionHandler) {
        super((EventExecutorGroup) eventLoopGroup, executor, z, i, rejectedExecutionHandler);
        this.tailTasks = newTaskQueue(i);
    }

    public SingleThreadEventLoop(EventLoopGroup eventLoopGroup, Executor executor, boolean z, Queue<Runnable> queue, Queue<Runnable> queue2, RejectedExecutionHandler rejectedExecutionHandler) {
        super((EventExecutorGroup) eventLoopGroup, executor, z, queue, rejectedExecutionHandler);
        this.tailTasks = (Queue) ObjectUtil.checkNotNull(queue2, "tailTaskQueue");
    }
}
