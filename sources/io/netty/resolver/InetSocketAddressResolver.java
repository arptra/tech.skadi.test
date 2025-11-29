package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class InetSocketAddressResolver extends AbstractAddressResolver<InetSocketAddress> {
    final NameResolver<InetAddress> nameResolver;

    public InetSocketAddressResolver(EventExecutor eventExecutor, NameResolver<InetAddress> nameResolver2) {
        super(eventExecutor, InetSocketAddress.class);
        this.nameResolver = nameResolver2;
    }

    public void close() {
        this.nameResolver.close();
    }

    public boolean doIsResolved(InetSocketAddress inetSocketAddress) {
        return !inetSocketAddress.isUnresolved();
    }

    public void doResolve(final InetSocketAddress inetSocketAddress, final Promise<InetSocketAddress> promise) throws Exception {
        this.nameResolver.resolve(inetSocketAddress.getHostName()).addListener(new FutureListener<InetAddress>() {
            public void operationComplete(Future<InetAddress> future) throws Exception {
                if (future.isSuccess()) {
                    promise.setSuccess(new InetSocketAddress(future.getNow(), inetSocketAddress.getPort()));
                } else {
                    promise.setFailure(future.cause());
                }
            }
        });
    }

    public void doResolveAll(final InetSocketAddress inetSocketAddress, final Promise<List<InetSocketAddress>> promise) throws Exception {
        this.nameResolver.resolveAll(inetSocketAddress.getHostName()).addListener(new FutureListener<List<InetAddress>>() {
            public void operationComplete(Future<List<InetAddress>> future) throws Exception {
                if (future.isSuccess()) {
                    List<InetAddress> now = future.getNow();
                    ArrayList arrayList = new ArrayList(now.size());
                    for (InetAddress inetSocketAddress : now) {
                        arrayList.add(new InetSocketAddress(inetSocketAddress, inetSocketAddress.getPort()));
                    }
                    promise.setSuccess(arrayList);
                    return;
                }
                promise.setFailure(future.cause());
            }
        });
    }
}
