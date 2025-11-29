package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.IdentityHashMap;
import java.util.Map;

public abstract class AddressResolverGroup<T extends SocketAddress> implements Closeable {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AddressResolverGroup.class);
    /* access modifiers changed from: private */
    public final Map<EventExecutor, GenericFutureListener<Future<Object>>> executorTerminationListeners = new IdentityHashMap();
    /* access modifiers changed from: private */
    public final Map<EventExecutor, AddressResolver<T>> resolvers = new IdentityHashMap();

    public void close() {
        int i;
        AddressResolver[] addressResolverArr;
        Map.Entry[] entryArr;
        synchronized (this.resolvers) {
            addressResolverArr = (AddressResolver[]) this.resolvers.values().toArray(new AddressResolver[0]);
            this.resolvers.clear();
            entryArr = (Map.Entry[]) this.executorTerminationListeners.entrySet().toArray(new Map.Entry[0]);
            this.executorTerminationListeners.clear();
        }
        for (Map.Entry entry : entryArr) {
            ((EventExecutor) entry.getKey()).terminationFuture().removeListener((GenericFutureListener) entry.getValue());
        }
        for (AddressResolver close : addressResolverArr) {
            try {
                close.close();
            } catch (Throwable th) {
                logger.warn("Failed to close a resolver:", th);
            }
        }
    }

    public AddressResolver<T> getResolver(final EventExecutor eventExecutor) {
        final AddressResolver<T> addressResolver;
        ObjectUtil.checkNotNull(eventExecutor, "executor");
        if (!eventExecutor.isShuttingDown()) {
            synchronized (this.resolvers) {
                try {
                    addressResolver = this.resolvers.get(eventExecutor);
                    if (addressResolver == null) {
                        addressResolver = newResolver(eventExecutor);
                        this.resolvers.put(eventExecutor, addressResolver);
                        AnonymousClass1 r2 = new FutureListener<Object>() {
                            public void operationComplete(Future<Object> future) {
                                synchronized (AddressResolverGroup.this.resolvers) {
                                    AddressResolverGroup.this.resolvers.remove(eventExecutor);
                                    AddressResolverGroup.this.executorTerminationListeners.remove(eventExecutor);
                                }
                                addressResolver.close();
                            }
                        };
                        this.executorTerminationListeners.put(eventExecutor, r2);
                        eventExecutor.terminationFuture().addListener(r2);
                    }
                } catch (Exception e) {
                    throw new IllegalStateException("failed to create a new resolver", e);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return addressResolver;
        }
        throw new IllegalStateException("executor not accepting a task");
    }

    public abstract AddressResolver<T> newResolver(EventExecutor eventExecutor) throws Exception;
}
