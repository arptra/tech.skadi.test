package io.netty.channel;

import io.netty.channel.ChannelFlushPromiseNotifier;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;

public class DefaultChannelPromise extends DefaultPromise<Void> implements ChannelPromise, ChannelFlushPromiseNotifier.FlushCheckpoint {
    private final Channel channel;
    private long checkpoint;

    public DefaultChannelPromise(Channel channel2) {
        this.channel = (Channel) ObjectUtil.checkNotNull(channel2, "channel");
    }

    public Channel channel() {
        return this.channel;
    }

    public void checkDeadLock() {
        if (channel().isRegistered()) {
            super.checkDeadLock();
        }
    }

    public EventExecutor executor() {
        EventExecutor executor = super.executor();
        return executor == null ? channel().eventLoop() : executor;
    }

    public long flushCheckpoint() {
        return this.checkpoint;
    }

    public boolean isVoid() {
        return false;
    }

    public ChannelPromise promise() {
        return this;
    }

    public boolean trySuccess() {
        return trySuccess(null);
    }

    public ChannelPromise unvoid() {
        return this;
    }

    public void flushCheckpoint(long j) {
        this.checkpoint = j;
    }

    public ChannelPromise setFailure(Throwable th) {
        super.setFailure(th);
        return this;
    }

    public ChannelPromise setSuccess() {
        return setSuccess((Void) null);
    }

    public DefaultChannelPromise(Channel channel2, EventExecutor eventExecutor) {
        super(eventExecutor);
        this.channel = (Channel) ObjectUtil.checkNotNull(channel2, "channel");
    }

    public ChannelPromise setSuccess(Void voidR) {
        super.setSuccess(voidR);
        return this;
    }

    public ChannelPromise addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.addListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    public ChannelPromise addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.addListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    public ChannelPromise await() throws InterruptedException {
        super.await();
        return this;
    }

    public ChannelPromise awaitUninterruptibly() {
        super.awaitUninterruptibly();
        return this;
    }

    public ChannelPromise removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.removeListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    public ChannelPromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.removeListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    public ChannelPromise sync() throws InterruptedException {
        super.sync();
        return this;
    }

    public ChannelPromise syncUninterruptibly() {
        super.syncUninterruptibly();
        return this;
    }
}
