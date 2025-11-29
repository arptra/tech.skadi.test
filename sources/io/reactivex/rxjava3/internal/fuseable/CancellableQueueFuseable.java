package io.reactivex.rxjava3.internal.fuseable;

public final class CancellableQueueFuseable<T> extends AbstractEmptyQueueFuseable<T> {
    volatile boolean disposed;

    public void cancel() {
        this.disposed = true;
    }

    public void dispose() {
        this.disposed = true;
    }

    public boolean isDisposed() {
        return this.disposed;
    }
}
