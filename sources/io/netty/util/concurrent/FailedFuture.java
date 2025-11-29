package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

public final class FailedFuture<V> extends CompleteFuture<V> {
    private final Throwable cause;

    public FailedFuture(EventExecutor eventExecutor, Throwable th) {
        super(eventExecutor);
        this.cause = (Throwable) ObjectUtil.checkNotNull(th, "cause");
    }

    public Throwable cause() {
        return this.cause;
    }

    public V getNow() {
        return null;
    }

    public boolean isSuccess() {
        return false;
    }

    public Future<V> sync() {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    public Future<V> syncUninterruptibly() {
        PlatformDependent.throwException(this.cause);
        return this;
    }
}
