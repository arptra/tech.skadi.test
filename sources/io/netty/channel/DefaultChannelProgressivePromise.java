package io.netty.channel;

import io.netty.channel.ChannelFlushPromiseNotifier;
import io.netty.util.concurrent.DefaultProgressivePromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class DefaultChannelProgressivePromise extends DefaultProgressivePromise<Void> implements ChannelProgressivePromise, ChannelFlushPromiseNotifier.FlushCheckpoint {
    private final Channel channel;
    private long checkpoint;

    public DefaultChannelProgressivePromise(Channel channel2) {
        this.channel = channel2;
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

    public ChannelProgressivePromise promise() {
        return this;
    }

    public boolean trySuccess() {
        return trySuccess(null);
    }

    public ChannelProgressivePromise unvoid() {
        return this;
    }

    public void flushCheckpoint(long j) {
        this.checkpoint = j;
    }

    public ChannelProgressivePromise setProgress(long j, long j2) {
        super.setProgress(j, j2);
        return this;
    }

    public DefaultChannelProgressivePromise(Channel channel2, EventExecutor eventExecutor) {
        super(eventExecutor);
        this.channel = channel2;
    }

    public ChannelProgressivePromise setFailure(Throwable th) {
        super.setFailure(th);
        return this;
    }

    public ChannelProgressivePromise setSuccess() {
        return setSuccess((Void) null);
    }

    public ChannelProgressivePromise setSuccess(Void voidR) {
        super.setSuccess(voidR);
        return this;
    }

    public ChannelProgressivePromise addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.addListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    public ChannelProgressivePromise addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.addListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    public ChannelProgressivePromise await() throws InterruptedException {
        super.await();
        return this;
    }

    public ChannelProgressivePromise awaitUninterruptibly() {
        super.awaitUninterruptibly();
        return this;
    }

    public ChannelProgressivePromise removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.removeListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    public ChannelProgressivePromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.removeListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    public ChannelProgressivePromise sync() throws InterruptedException {
        super.sync();
        return this;
    }

    public ChannelProgressivePromise syncUninterruptibly() {
        super.syncUninterruptibly();
        return this;
    }
}
