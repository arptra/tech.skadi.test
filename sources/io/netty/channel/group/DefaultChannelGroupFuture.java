package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.BlockingOperationException;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ImmediateEventExecutor;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

final class DefaultChannelGroupFuture extends DefaultPromise<Void> implements ChannelGroupFuture {
    private final ChannelFutureListener childListener = new ChannelFutureListener() {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            boolean z;
            boolean isSuccess = channelFuture.isSuccess();
            synchronized (DefaultChannelGroupFuture.this) {
                if (isSuccess) {
                    try {
                        DefaultChannelGroupFuture.access$008(DefaultChannelGroupFuture.this);
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                } else {
                    DefaultChannelGroupFuture.access$108(DefaultChannelGroupFuture.this);
                }
                z = DefaultChannelGroupFuture.this.successCount + DefaultChannelGroupFuture.this.failureCount == DefaultChannelGroupFuture.this.futures.size();
            }
            if (!z) {
                return;
            }
            if (DefaultChannelGroupFuture.this.failureCount > 0) {
                ArrayList arrayList = new ArrayList(DefaultChannelGroupFuture.this.failureCount);
                for (ChannelFuture channelFuture2 : DefaultChannelGroupFuture.this.futures.values()) {
                    if (!channelFuture2.isSuccess()) {
                        arrayList.add(new DefaultEntry(channelFuture2.channel(), channelFuture2.cause()));
                    }
                }
                DefaultChannelGroupFuture.this.setFailure0(new ChannelGroupException(arrayList));
                return;
            }
            DefaultChannelGroupFuture.this.setSuccess0();
        }
    };
    /* access modifiers changed from: private */
    public int failureCount;
    /* access modifiers changed from: private */
    public final Map<Channel, ChannelFuture> futures;
    private final ChannelGroup group;
    /* access modifiers changed from: private */
    public int successCount;

    public static final class DefaultEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private final V value;

        public DefaultEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("read-only");
        }
    }

    public DefaultChannelGroupFuture(ChannelGroup channelGroup, Collection<ChannelFuture> collection, EventExecutor eventExecutor) {
        super(eventExecutor);
        this.group = (ChannelGroup) ObjectUtil.checkNotNull(channelGroup, "group");
        ObjectUtil.checkNotNull(collection, "futures");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ChannelFuture next : collection) {
            linkedHashMap.put(next.channel(), next);
        }
        Map<Channel, ChannelFuture> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        this.futures = unmodifiableMap;
        for (ChannelFuture addListener : unmodifiableMap.values()) {
            addListener.addListener(this.childListener);
        }
        if (this.futures.isEmpty()) {
            setSuccess0();
        }
    }

    public static /* synthetic */ int access$008(DefaultChannelGroupFuture defaultChannelGroupFuture) {
        int i = defaultChannelGroupFuture.successCount;
        defaultChannelGroupFuture.successCount = i + 1;
        return i;
    }

    public static /* synthetic */ int access$108(DefaultChannelGroupFuture defaultChannelGroupFuture) {
        int i = defaultChannelGroupFuture.failureCount;
        defaultChannelGroupFuture.failureCount = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    public void setFailure0(ChannelGroupException channelGroupException) {
        super.setFailure(channelGroupException);
    }

    /* access modifiers changed from: private */
    public void setSuccess0() {
        super.setSuccess(null);
    }

    public void checkDeadLock() {
        EventExecutor executor = executor();
        if (executor != null && executor != ImmediateEventExecutor.INSTANCE && executor.inEventLoop()) {
            throw new BlockingOperationException();
        }
    }

    public ChannelFuture find(Channel channel) {
        return this.futures.get(channel);
    }

    public ChannelGroup group() {
        return this.group;
    }

    public synchronized boolean isPartialFailure() {
        int i;
        i = this.failureCount;
        return (i == 0 || i == this.futures.size()) ? false : true;
    }

    public synchronized boolean isPartialSuccess() {
        int i;
        i = this.successCount;
        return (i == 0 || i == this.futures.size()) ? false : true;
    }

    public Iterator<ChannelFuture> iterator() {
        return this.futures.values().iterator();
    }

    public boolean tryFailure(Throwable th) {
        throw new IllegalStateException();
    }

    public ChannelGroupException cause() {
        return (ChannelGroupException) super.cause();
    }

    public DefaultChannelGroupFuture setFailure(Throwable th) {
        throw new IllegalStateException();
    }

    public DefaultChannelGroupFuture setSuccess(Void voidR) {
        throw new IllegalStateException();
    }

    public boolean trySuccess(Void voidR) {
        throw new IllegalStateException();
    }

    public DefaultChannelGroupFuture addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.addListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    public DefaultChannelGroupFuture addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.addListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    public DefaultChannelGroupFuture await() throws InterruptedException {
        super.await();
        return this;
    }

    public DefaultChannelGroupFuture awaitUninterruptibly() {
        super.awaitUninterruptibly();
        return this;
    }

    public DefaultChannelGroupFuture removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.removeListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    public DefaultChannelGroupFuture removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.removeListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    public DefaultChannelGroupFuture sync() throws InterruptedException {
        super.sync();
        return this;
    }

    public DefaultChannelGroupFuture syncUninterruptibly() {
        super.syncUninterruptibly();
        return this;
    }

    public DefaultChannelGroupFuture(ChannelGroup channelGroup, Map<Channel, ChannelFuture> map, EventExecutor eventExecutor) {
        super(eventExecutor);
        this.group = channelGroup;
        Map<Channel, ChannelFuture> unmodifiableMap = Collections.unmodifiableMap(map);
        this.futures = unmodifiableMap;
        for (ChannelFuture addListener : unmodifiableMap.values()) {
            addListener.addListener(this.childListener);
        }
        if (this.futures.isEmpty()) {
            setSuccess0();
        }
    }
}
