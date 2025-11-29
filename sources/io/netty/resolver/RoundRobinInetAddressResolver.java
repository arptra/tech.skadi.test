package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.PlatformDependent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundRobinInetAddressResolver extends InetNameResolver {
    private final NameResolver<InetAddress> nameResolver;

    public RoundRobinInetAddressResolver(EventExecutor eventExecutor, NameResolver<InetAddress> nameResolver2) {
        super(eventExecutor);
        this.nameResolver = nameResolver2;
    }

    /* access modifiers changed from: private */
    public static int randomIndex(int i) {
        if (i == 1) {
            return 0;
        }
        return PlatformDependent.threadLocalRandom().nextInt(i);
    }

    public void close() {
        this.nameResolver.close();
    }

    public void doResolve(final String str, final Promise<InetAddress> promise) throws Exception {
        this.nameResolver.resolveAll(str).addListener(new FutureListener<List<InetAddress>>() {
            public void operationComplete(Future<List<InetAddress>> future) throws Exception {
                if (future.isSuccess()) {
                    List now = future.getNow();
                    int size = now.size();
                    if (size > 0) {
                        promise.setSuccess(now.get(RoundRobinInetAddressResolver.randomIndex(size)));
                    } else {
                        promise.setFailure(new UnknownHostException(str));
                    }
                } else {
                    promise.setFailure(future.cause());
                }
            }
        });
    }

    public void doResolveAll(String str, final Promise<List<InetAddress>> promise) throws Exception {
        this.nameResolver.resolveAll(str).addListener(new FutureListener<List<InetAddress>>() {
            public void operationComplete(Future<List<InetAddress>> future) throws Exception {
                if (future.isSuccess()) {
                    List now = future.getNow();
                    if (!now.isEmpty()) {
                        ArrayList arrayList = new ArrayList(now);
                        Collections.rotate(arrayList, RoundRobinInetAddressResolver.randomIndex(now.size()));
                        promise.setSuccess(arrayList);
                        return;
                    }
                    promise.setSuccess(now);
                    return;
                }
                promise.setFailure(future.cause());
            }
        });
    }
}
