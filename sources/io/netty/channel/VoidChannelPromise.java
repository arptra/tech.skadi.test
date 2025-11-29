package io.netty.channel;

import io.netty.util.concurrent.AbstractFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

public final class VoidChannelPromise extends AbstractFuture<Void> implements ChannelPromise {
    private final Channel channel;
    private final ChannelFutureListener fireExceptionListener;

    public VoidChannelPromise(Channel channel2, boolean z) {
        ObjectUtil.checkNotNull(channel2, "channel");
        this.channel = channel2;
        if (z) {
            this.fireExceptionListener = new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    Throwable cause = channelFuture.cause();
                    if (cause != null) {
                        VoidChannelPromise.this.fireException0(cause);
                    }
                }
            };
        } else {
            this.fireExceptionListener = null;
        }
    }

    private static void fail() {
        throw new IllegalStateException("void future");
    }

    /* access modifiers changed from: private */
    public void fireException0(Throwable th) {
        if (this.fireExceptionListener != null && this.channel.isRegistered()) {
            this.channel.pipeline().fireExceptionCaught(th);
        }
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public Throwable cause() {
        return null;
    }

    public Channel channel() {
        return this.channel;
    }

    public Void getNow() {
        return null;
    }

    public boolean isCancellable() {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    public boolean isSuccess() {
        return false;
    }

    public boolean isVoid() {
        return true;
    }

    public VoidChannelPromise removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        return this;
    }

    public VoidChannelPromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        return this;
    }

    public VoidChannelPromise setSuccess() {
        return this;
    }

    public boolean setUncancellable() {
        return true;
    }

    public boolean tryFailure(Throwable th) {
        fireException0(th);
        return false;
    }

    public boolean trySuccess() {
        return false;
    }

    public ChannelPromise unvoid() {
        DefaultChannelPromise defaultChannelPromise = new DefaultChannelPromise(this.channel);
        ChannelFutureListener channelFutureListener = this.fireExceptionListener;
        if (channelFutureListener != null) {
            defaultChannelPromise.addListener(channelFutureListener);
        }
        return defaultChannelPromise;
    }

    public VoidChannelPromise setSuccess(Void voidR) {
        return this;
    }

    public boolean trySuccess(Void voidR) {
        return false;
    }

    public VoidChannelPromise setFailure(Throwable th) {
        fireException0(th);
        return this;
    }

    public VoidChannelPromise addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        fail();
        return this;
    }

    public VoidChannelPromise addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        fail();
        return this;
    }

    public VoidChannelPromise await() throws InterruptedException {
        if (!Thread.interrupted()) {
            return this;
        }
        throw new InterruptedException();
    }

    public VoidChannelPromise awaitUninterruptibly() {
        fail();
        return this;
    }

    public VoidChannelPromise sync() {
        fail();
        return this;
    }

    public VoidChannelPromise syncUninterruptibly() {
        fail();
        return this;
    }

    public boolean awaitUninterruptibly(long j, TimeUnit timeUnit) {
        fail();
        return false;
    }

    public boolean await(long j, TimeUnit timeUnit) {
        fail();
        return false;
    }

    public boolean awaitUninterruptibly(long j) {
        fail();
        return false;
    }

    public boolean await(long j) {
        fail();
        return false;
    }
}
