package io.netty.util.concurrent;

public final class SucceededFuture<V> extends CompleteFuture<V> {
    private final V result;

    public SucceededFuture(EventExecutor eventExecutor, V v) {
        super(eventExecutor);
        this.result = v;
    }

    public Throwable cause() {
        return null;
    }

    public V getNow() {
        return this.result;
    }

    public boolean isSuccess() {
        return true;
    }
}
