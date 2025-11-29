package io.netty.resolver.dns;

import io.netty.resolver.NameResolver;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

final class InflightNameResolver<T> implements NameResolver<T> {
    private final NameResolver<T> delegate;
    private final EventExecutor executor;
    private final ConcurrentMap<String, Promise<List<T>>> resolveAllsInProgress;
    private final ConcurrentMap<String, Promise<T>> resolvesInProgress;

    public InflightNameResolver(EventExecutor eventExecutor, NameResolver<T> nameResolver, ConcurrentMap<String, Promise<T>> concurrentMap, ConcurrentMap<String, Promise<List<T>>> concurrentMap2) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
        this.delegate = (NameResolver) ObjectUtil.checkNotNull(nameResolver, "delegate");
        this.resolvesInProgress = (ConcurrentMap) ObjectUtil.checkNotNull(concurrentMap, "resolvesInProgress");
        this.resolveAllsInProgress = (ConcurrentMap) ObjectUtil.checkNotNull(concurrentMap2, "resolveAllsInProgress");
    }

    /* access modifiers changed from: private */
    public static <T> void transferResult(Future<T> future, Promise<T> promise) {
        if (future.isSuccess()) {
            promise.trySuccess(future.getNow());
        } else {
            promise.tryFailure(future.cause());
        }
    }

    public void close() {
        this.delegate.close();
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '(' + this.delegate + ')';
    }

    public Future<T> resolve(String str) {
        return resolve(str, this.executor.newPromise());
    }

    public Future<List<T>> resolveAll(String str) {
        return resolveAll(str, this.executor.newPromise());
    }

    public Promise<T> resolve(String str, Promise<T> promise) {
        return resolve(this.resolvesInProgress, str, promise, false);
    }

    public Promise<List<T>> resolveAll(String str, Promise<List<T>> promise) {
        return resolve(this.resolveAllsInProgress, str, promise, true);
    }

    private <U> Promise<U> resolve(final ConcurrentMap<String, Promise<U>> concurrentMap, final String str, final Promise<U> promise, boolean z) {
        boolean isDone;
        Promise promise2 = (Promise) concurrentMap.putIfAbsent(str, promise);
        if (promise2 == null) {
            if (z) {
                try {
                    this.delegate.resolveAll(str, promise);
                } finally {
                    if (promise.isDone()) {
                        concurrentMap.remove(str);
                    } else {
                        promise.addListener(new FutureListener<U>() {
                            public void operationComplete(Future<U> future) throws Exception {
                                concurrentMap.remove(str);
                            }
                        });
                    }
                }
            } else {
                this.delegate.resolve(str, promise);
            }
            if (!isDone) {
                promise.addListener(new FutureListener<U>() {
                    public void operationComplete(Future<U> future) throws Exception {
                        concurrentMap.remove(str);
                    }
                });
            }
        } else if (promise2.isDone()) {
            transferResult(promise2, promise);
        } else {
            promise2.addListener(new FutureListener<U>() {
                public void operationComplete(Future<U> future) throws Exception {
                    InflightNameResolver.transferResult(future, promise);
                }
            });
        }
        return promise;
    }
}
