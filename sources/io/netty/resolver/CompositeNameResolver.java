package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.List;

public final class CompositeNameResolver<T> extends SimpleNameResolver<T> {
    private final NameResolver<T>[] resolvers;

    public CompositeNameResolver(EventExecutor eventExecutor, NameResolver<T>... nameResolverArr) {
        super(eventExecutor);
        ObjectUtil.checkNotNull(nameResolverArr, "resolvers");
        for (int i = 0; i < nameResolverArr.length; i++) {
            NameResolver<T> nameResolver = nameResolverArr[i];
            ObjectUtil.checkNotNull(nameResolver, "resolvers[" + i + ']');
        }
        if (nameResolverArr.length >= 2) {
            this.resolvers = (NameResolver[]) nameResolverArr.clone();
            return;
        }
        throw new IllegalArgumentException("resolvers: " + Arrays.asList(nameResolverArr) + " (expected: at least 2 resolvers)");
    }

    /* access modifiers changed from: private */
    public void doResolveAllRec(final String str, final Promise<List<T>> promise, final int i, Throwable th) throws Exception {
        NameResolver<T>[] nameResolverArr = this.resolvers;
        if (i >= nameResolverArr.length) {
            promise.setFailure(th);
        } else {
            nameResolverArr[i].resolveAll(str).addListener(new FutureListener<List<T>>() {
                public void operationComplete(Future<List<T>> future) throws Exception {
                    if (future.isSuccess()) {
                        promise.setSuccess(future.getNow());
                    } else {
                        CompositeNameResolver.this.doResolveAllRec(str, promise, i + 1, future.cause());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void doResolveRec(final String str, final Promise<T> promise, final int i, Throwable th) throws Exception {
        NameResolver<T>[] nameResolverArr = this.resolvers;
        if (i >= nameResolverArr.length) {
            promise.setFailure(th);
        } else {
            nameResolverArr[i].resolve(str).addListener(new FutureListener<T>() {
                public void operationComplete(Future<T> future) throws Exception {
                    if (future.isSuccess()) {
                        promise.setSuccess(future.getNow());
                    } else {
                        CompositeNameResolver.this.doResolveRec(str, promise, i + 1, future.cause());
                    }
                }
            });
        }
    }

    public void doResolve(String str, Promise<T> promise) throws Exception {
        doResolveRec(str, promise, 0, (Throwable) null);
    }

    public void doResolveAll(String str, Promise<List<T>> promise) throws Exception {
        doResolveAllRec(str, promise, 0, (Throwable) null);
    }
}
