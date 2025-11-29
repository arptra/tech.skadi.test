package io.netty.util.concurrent;

import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class PromiseNotifier<V, F extends Future<V>> implements GenericFutureListener<F> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PromiseNotifier.class);
    private final boolean logNotifyFailure;
    private final Promise<? super V>[] promises;

    @SafeVarargs
    public PromiseNotifier(Promise<? super V>... promiseArr) {
        this(true, promiseArr);
    }

    public static <V, F extends Future<V>> F cascade(F f, Promise<? super V> promise) {
        return cascade(true, f, promise);
    }

    public void operationComplete(F f) throws Exception {
        InternalLogger internalLogger = this.logNotifyFailure ? logger : null;
        int i = 0;
        if (f.isSuccess()) {
            Object obj = f.get();
            Promise<? super V>[] promiseArr = this.promises;
            int length = promiseArr.length;
            while (i < length) {
                PromiseNotificationUtil.trySuccess(promiseArr[i], obj, internalLogger);
                i++;
            }
        } else if (f.isCancelled()) {
            Promise<? super V>[] promiseArr2 = this.promises;
            int length2 = promiseArr2.length;
            while (i < length2) {
                PromiseNotificationUtil.tryCancel(promiseArr2[i], internalLogger);
                i++;
            }
        } else {
            Throwable cause = f.cause();
            Promise<? super V>[] promiseArr3 = this.promises;
            int length3 = promiseArr3.length;
            while (i < length3) {
                PromiseNotificationUtil.tryFailure(promiseArr3[i], cause, internalLogger);
                i++;
            }
        }
    }

    @SafeVarargs
    public PromiseNotifier(boolean z, Promise<? super V>... promiseArr) {
        ObjectUtil.checkNotNull(promiseArr, "promises");
        for (Promise<? super V> checkNotNullWithIAE : promiseArr) {
            ObjectUtil.checkNotNullWithIAE(checkNotNullWithIAE, "promise");
        }
        this.promises = (Promise[]) promiseArr.clone();
        this.logNotifyFailure = z;
    }

    public static <V, F extends Future<V>> F cascade(boolean z, final F f, final Promise<? super V> promise) {
        promise.addListener(new FutureListener() {
            public void operationComplete(Future future) {
                if (future.isCancelled()) {
                    f.cancel(false);
                }
            }
        });
        f.addListener(new PromiseNotifier(z, new Promise[]{promise}) {
            public void operationComplete(Future future) throws Exception {
                if (!promise.isCancelled() || !future.isCancelled()) {
                    PromiseNotifier.super.operationComplete(f);
                }
            }
        });
        return f;
    }
}
