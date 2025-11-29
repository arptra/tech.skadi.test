package io.netty.util.concurrent;

import com.upuphone.starrynet.payload.PayloadConstant;
import io.netty.util.internal.ObjectUtil;

public class DefaultProgressivePromise<V> extends DefaultPromise<V> implements ProgressivePromise<V> {
    public DefaultProgressivePromise(EventExecutor eventExecutor) {
        super(eventExecutor);
    }

    public ProgressivePromise<V> setProgress(long j, long j2) {
        if (j2 < 0) {
            ObjectUtil.checkPositiveOrZero(j, PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS);
            j2 = -1;
        } else if (j < 0 || j > j2) {
            throw new IllegalArgumentException("progress: " + j + " (expected: 0 <= progress <= total (" + j2 + "))");
        }
        if (!isDone()) {
            notifyProgressiveListeners(j, j2);
            return this;
        }
        throw new IllegalStateException("complete already");
    }

    public boolean tryProgress(long j, long j2) {
        if (j2 < 0) {
            if (j < 0 || isDone()) {
                return false;
            }
            j2 = -1;
        } else if (j < 0 || j > j2 || isDone()) {
            return false;
        }
        notifyProgressiveListeners(j, j2);
        return true;
    }

    public DefaultProgressivePromise() {
    }

    public ProgressivePromise<V> setFailure(Throwable th) {
        super.setFailure(th);
        return this;
    }

    public ProgressivePromise<V> setSuccess(V v) {
        super.setSuccess(v);
        return this;
    }

    public ProgressivePromise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        super.addListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    public ProgressivePromise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        super.addListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    public ProgressivePromise<V> await() throws InterruptedException {
        super.await();
        return this;
    }

    public ProgressivePromise<V> awaitUninterruptibly() {
        super.awaitUninterruptibly();
        return this;
    }

    public ProgressivePromise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        super.removeListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    public ProgressivePromise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        super.removeListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    public ProgressivePromise<V> sync() throws InterruptedException {
        super.sync();
        return this;
    }

    public ProgressivePromise<V> syncUninterruptibly() {
        super.syncUninterruptibly();
        return this;
    }
}
