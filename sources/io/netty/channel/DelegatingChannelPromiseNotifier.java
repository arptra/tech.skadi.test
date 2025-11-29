package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class DelegatingChannelPromiseNotifier implements ChannelPromise, ChannelFutureListener {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DelegatingChannelPromiseNotifier.class);
    private final ChannelPromise delegate;
    private final boolean logNotifyFailure;

    public DelegatingChannelPromiseNotifier(ChannelPromise channelPromise) {
        this(channelPromise, !(channelPromise instanceof VoidChannelPromise));
    }

    public boolean cancel(boolean z) {
        return this.delegate.cancel(z);
    }

    public Throwable cause() {
        return this.delegate.cause();
    }

    public Channel channel() {
        return this.delegate.channel();
    }

    public boolean isCancellable() {
        return this.delegate.isCancellable();
    }

    public boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    public boolean isDone() {
        return this.delegate.isDone();
    }

    public boolean isSuccess() {
        return this.delegate.isSuccess();
    }

    public boolean isVoid() {
        return this.delegate.isVoid();
    }

    public boolean setUncancellable() {
        return this.delegate.setUncancellable();
    }

    public boolean tryFailure(Throwable th) {
        return this.delegate.tryFailure(th);
    }

    public ChannelPromise unvoid() {
        return isVoid() ? new DelegatingChannelPromiseNotifier(this.delegate.unvoid()) : this;
    }

    public DelegatingChannelPromiseNotifier(ChannelPromise channelPromise, boolean z) {
        this.delegate = (ChannelPromise) ObjectUtil.checkNotNull(channelPromise, "delegate");
        this.logNotifyFailure = z;
    }

    public Void getNow() {
        return (Void) this.delegate.getNow();
    }

    public void operationComplete(ChannelFuture channelFuture) throws Exception {
        InternalLogger internalLogger = this.logNotifyFailure ? logger : null;
        if (channelFuture.isSuccess()) {
            PromiseNotificationUtil.trySuccess(this.delegate, (Void) channelFuture.get(), internalLogger);
        } else if (channelFuture.isCancelled()) {
            PromiseNotificationUtil.tryCancel(this.delegate, internalLogger);
        } else {
            PromiseNotificationUtil.tryFailure(this.delegate, channelFuture.cause(), internalLogger);
        }
    }

    public ChannelPromise setFailure(Throwable th) {
        this.delegate.setFailure(th);
        return this;
    }

    public ChannelPromise setSuccess(Void voidR) {
        this.delegate.setSuccess(voidR);
        return this;
    }

    public boolean trySuccess() {
        return this.delegate.trySuccess();
    }

    public Void get() throws InterruptedException, ExecutionException {
        return (Void) this.delegate.get();
    }

    public ChannelPromise setSuccess() {
        this.delegate.setSuccess();
        return this;
    }

    public boolean trySuccess(Void voidR) {
        return this.delegate.trySuccess(voidR);
    }

    public ChannelPromise addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        this.delegate.addListener(genericFutureListener);
        return this;
    }

    public ChannelPromise addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        this.delegate.addListeners(genericFutureListenerArr);
        return this;
    }

    public ChannelPromise await() throws InterruptedException {
        this.delegate.await();
        return this;
    }

    public ChannelPromise awaitUninterruptibly() {
        this.delegate.awaitUninterruptibly();
        return this;
    }

    public Void get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (Void) this.delegate.get(j, timeUnit);
    }

    public ChannelPromise removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        this.delegate.removeListener(genericFutureListener);
        return this;
    }

    public ChannelPromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        this.delegate.removeListeners(genericFutureListenerArr);
        return this;
    }

    public ChannelPromise sync() throws InterruptedException {
        this.delegate.sync();
        return this;
    }

    public ChannelPromise syncUninterruptibly() {
        this.delegate.syncUninterruptibly();
        return this;
    }

    public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.await(j, timeUnit);
    }

    public boolean awaitUninterruptibly(long j, TimeUnit timeUnit) {
        return this.delegate.awaitUninterruptibly(j, timeUnit);
    }

    public boolean await(long j) throws InterruptedException {
        return this.delegate.await(j);
    }

    public boolean awaitUninterruptibly(long j) {
        return this.delegate.awaitUninterruptibly(j);
    }
}
