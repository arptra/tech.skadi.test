package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

@Deprecated
public final class UnaryPromiseNotifier<T> implements FutureListener<T> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) UnaryPromiseNotifier.class);
    private final Promise<? super T> promise;

    public UnaryPromiseNotifier(Promise<? super T> promise2) {
        this.promise = (Promise) ObjectUtil.checkNotNull(promise2, "promise");
    }

    public static <X> void cascadeTo(Future<X> future, Promise<? super X> promise2) {
        if (future.isSuccess()) {
            if (!promise2.trySuccess(future.getNow())) {
                logger.warn("Failed to mark a promise as success because it is done already: {}", (Object) promise2);
            }
        } else if (future.isCancelled()) {
            if (!promise2.cancel(false)) {
                logger.warn("Failed to cancel a promise because it is done already: {}", (Object) promise2);
            }
        } else if (!promise2.tryFailure(future.cause())) {
            logger.warn("Failed to mark a promise as failure because it's done already: {}", promise2, future.cause());
        }
    }

    public void operationComplete(Future<T> future) throws Exception {
        cascadeTo(future, this.promise);
    }
}
