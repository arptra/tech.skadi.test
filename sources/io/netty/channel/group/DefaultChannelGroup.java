package io.netty.channel.group;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelId;
import io.netty.channel.ServerChannel;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultChannelGroup extends AbstractSet<Channel> implements ChannelGroup {
    private static final AtomicInteger nextId = new AtomicInteger();
    private volatile boolean closed;
    private final EventExecutor executor;
    private final String name;
    private final ConcurrentMap<ChannelId, Channel> nonServerChannels;
    private final ChannelFutureListener remover;
    private final ConcurrentMap<ChannelId, Channel> serverChannels;
    private final boolean stayClosed;
    private final VoidChannelGroupFuture voidFuture;

    public DefaultChannelGroup(EventExecutor eventExecutor) {
        this(eventExecutor, false);
    }

    private static Object safeDuplicate(Object obj) {
        return obj instanceof ByteBuf ? ((ByteBuf) obj).retainedDuplicate() : obj instanceof ByteBufHolder ? ((ByteBufHolder) obj).retainedDuplicate() : ReferenceCountUtil.retain(obj);
    }

    public void clear() {
        this.nonServerChannels.clear();
        this.serverChannels.clear();
    }

    public ChannelGroupFuture close() {
        return close(ChannelMatchers.all());
    }

    public boolean contains(Object obj) {
        if (obj instanceof ServerChannel) {
            return this.serverChannels.containsValue(obj);
        }
        if (obj instanceof Channel) {
            return this.nonServerChannels.containsValue(obj);
        }
        return false;
    }

    public ChannelGroupFuture deregister() {
        return deregister(ChannelMatchers.all());
    }

    public ChannelGroupFuture disconnect() {
        return disconnect(ChannelMatchers.all());
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public Channel find(ChannelId channelId) {
        Channel channel = this.nonServerChannels.get(channelId);
        return channel != null ? channel : this.serverChannels.get(channelId);
    }

    public ChannelGroup flush() {
        return flush(ChannelMatchers.all());
    }

    public ChannelGroupFuture flushAndWrite(Object obj) {
        return writeAndFlush(obj);
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public boolean isEmpty() {
        return this.nonServerChannels.isEmpty() && this.serverChannels.isEmpty();
    }

    public Iterator<Channel> iterator() {
        return new CombinedIterator(this.serverChannels.values().iterator(), this.nonServerChannels.values().iterator());
    }

    public String name() {
        return this.name;
    }

    public ChannelGroupFuture newCloseFuture() {
        return newCloseFuture(ChannelMatchers.all());
    }

    public boolean remove(Object obj) {
        Channel channel;
        if (obj instanceof ChannelId) {
            channel = this.nonServerChannels.remove(obj);
            if (channel == null) {
                channel = this.serverChannels.remove(obj);
            }
        } else if (obj instanceof Channel) {
            Channel channel2 = (Channel) obj;
            channel = channel2 instanceof ServerChannel ? this.serverChannels.remove(channel2.id()) : this.nonServerChannels.remove(channel2.id());
        } else {
            channel = null;
        }
        if (channel == null) {
            return false;
        }
        channel.closeFuture().removeListener(this.remover);
        return true;
    }

    public int size() {
        return this.nonServerChannels.size() + this.serverChannels.size();
    }

    public Object[] toArray() {
        ArrayList arrayList = new ArrayList(size());
        arrayList.addAll(this.serverChannels.values());
        arrayList.addAll(this.nonServerChannels.values());
        return arrayList.toArray();
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + "(name: " + name() + ", size: " + size() + ')';
    }

    public ChannelGroupFuture write(Object obj) {
        return write(obj, ChannelMatchers.all());
    }

    public ChannelGroupFuture writeAndFlush(Object obj) {
        return writeAndFlush(obj, ChannelMatchers.all());
    }

    public DefaultChannelGroup(String str, EventExecutor eventExecutor) {
        this(str, eventExecutor, false);
    }

    public boolean add(Channel channel) {
        boolean z = (channel instanceof ServerChannel ? this.serverChannels : this.nonServerChannels).putIfAbsent(channel.id(), channel) == null;
        if (z) {
            channel.closeFuture().addListener(this.remover);
        }
        if (this.stayClosed && this.closed) {
            channel.close();
        }
        return z;
    }

    public ChannelGroupFuture close(ChannelMatcher channelMatcher) {
        ObjectUtil.checkNotNull(channelMatcher, "matcher");
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        if (this.stayClosed) {
            this.closed = true;
        }
        for (Channel next : this.serverChannels.values()) {
            if (channelMatcher.matches(next)) {
                linkedHashMap.put(next, next.close());
            }
        }
        for (Channel next2 : this.nonServerChannels.values()) {
            if (channelMatcher.matches(next2)) {
                linkedHashMap.put(next2, next2.close());
            }
        }
        return new DefaultChannelGroupFuture((ChannelGroup) this, (Map<Channel, ChannelFuture>) linkedHashMap, this.executor);
    }

    public int compareTo(ChannelGroup channelGroup) {
        int compareTo = name().compareTo(channelGroup.name());
        if (compareTo != 0) {
            return compareTo;
        }
        return System.identityHashCode(this) - System.identityHashCode(channelGroup);
    }

    public ChannelGroupFuture deregister(ChannelMatcher channelMatcher) {
        ObjectUtil.checkNotNull(channelMatcher, "matcher");
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        for (Channel next : this.serverChannels.values()) {
            if (channelMatcher.matches(next)) {
                linkedHashMap.put(next, next.deregister());
            }
        }
        for (Channel next2 : this.nonServerChannels.values()) {
            if (channelMatcher.matches(next2)) {
                linkedHashMap.put(next2, next2.deregister());
            }
        }
        return new DefaultChannelGroupFuture((ChannelGroup) this, (Map<Channel, ChannelFuture>) linkedHashMap, this.executor);
    }

    public ChannelGroupFuture disconnect(ChannelMatcher channelMatcher) {
        ObjectUtil.checkNotNull(channelMatcher, "matcher");
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        for (Channel next : this.serverChannels.values()) {
            if (channelMatcher.matches(next)) {
                linkedHashMap.put(next, next.disconnect());
            }
        }
        for (Channel next2 : this.nonServerChannels.values()) {
            if (channelMatcher.matches(next2)) {
                linkedHashMap.put(next2, next2.disconnect());
            }
        }
        return new DefaultChannelGroupFuture((ChannelGroup) this, (Map<Channel, ChannelFuture>) linkedHashMap, this.executor);
    }

    public ChannelGroup flush(ChannelMatcher channelMatcher) {
        for (Channel next : this.nonServerChannels.values()) {
            if (channelMatcher.matches(next)) {
                next.flush();
            }
        }
        return this;
    }

    public ChannelGroupFuture flushAndWrite(Object obj, ChannelMatcher channelMatcher) {
        return writeAndFlush(obj, channelMatcher);
    }

    public ChannelGroupFuture newCloseFuture(ChannelMatcher channelMatcher) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        for (Channel next : this.serverChannels.values()) {
            if (channelMatcher.matches(next)) {
                linkedHashMap.put(next, next.closeFuture());
            }
        }
        for (Channel next2 : this.nonServerChannels.values()) {
            if (channelMatcher.matches(next2)) {
                linkedHashMap.put(next2, next2.closeFuture());
            }
        }
        return new DefaultChannelGroupFuture((ChannelGroup) this, (Map<Channel, ChannelFuture>) linkedHashMap, this.executor);
    }

    public ChannelGroupFuture write(Object obj, ChannelMatcher channelMatcher) {
        return write(obj, channelMatcher, false);
    }

    public ChannelGroupFuture writeAndFlush(Object obj, ChannelMatcher channelMatcher) {
        return writeAndFlush(obj, channelMatcher, false);
    }

    public DefaultChannelGroup(EventExecutor eventExecutor, boolean z) {
        this("group-0x" + Integer.toHexString(nextId.incrementAndGet()), eventExecutor, z);
    }

    public ChannelGroupFuture write(Object obj, ChannelMatcher channelMatcher, boolean z) {
        ChannelGroupFuture channelGroupFuture;
        ObjectUtil.checkNotNull(obj, "message");
        ObjectUtil.checkNotNull(channelMatcher, "matcher");
        if (z) {
            for (Channel next : this.nonServerChannels.values()) {
                if (channelMatcher.matches(next)) {
                    next.write(safeDuplicate(obj), next.voidPromise());
                }
            }
            channelGroupFuture = this.voidFuture;
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.nonServerChannels.size());
            for (Channel next2 : this.nonServerChannels.values()) {
                if (channelMatcher.matches(next2)) {
                    linkedHashMap.put(next2, next2.write(safeDuplicate(obj)));
                }
            }
            channelGroupFuture = new DefaultChannelGroupFuture((ChannelGroup) this, (Map<Channel, ChannelFuture>) linkedHashMap, this.executor);
        }
        ReferenceCountUtil.release(obj);
        return channelGroupFuture;
    }

    public ChannelGroupFuture writeAndFlush(Object obj, ChannelMatcher channelMatcher, boolean z) {
        ChannelGroupFuture channelGroupFuture;
        ObjectUtil.checkNotNull(obj, "message");
        if (z) {
            for (Channel next : this.nonServerChannels.values()) {
                if (channelMatcher.matches(next)) {
                    next.writeAndFlush(safeDuplicate(obj), next.voidPromise());
                }
            }
            channelGroupFuture = this.voidFuture;
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.nonServerChannels.size());
            for (Channel next2 : this.nonServerChannels.values()) {
                if (channelMatcher.matches(next2)) {
                    linkedHashMap.put(next2, next2.writeAndFlush(safeDuplicate(obj)));
                }
            }
            channelGroupFuture = new DefaultChannelGroupFuture((ChannelGroup) this, (Map<Channel, ChannelFuture>) linkedHashMap, this.executor);
        }
        ReferenceCountUtil.release(obj);
        return channelGroupFuture;
    }

    public DefaultChannelGroup(String str, EventExecutor eventExecutor, boolean z) {
        this.serverChannels = PlatformDependent.newConcurrentHashMap();
        this.nonServerChannels = PlatformDependent.newConcurrentHashMap();
        this.remover = new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                DefaultChannelGroup.this.remove(channelFuture.channel());
            }
        };
        this.voidFuture = new VoidChannelGroupFuture(this);
        ObjectUtil.checkNotNull(str, "name");
        this.name = str;
        this.executor = eventExecutor;
        this.stayClosed = z;
    }

    public <T> T[] toArray(T[] tArr) {
        ArrayList arrayList = new ArrayList(size());
        arrayList.addAll(this.serverChannels.values());
        arrayList.addAll(this.nonServerChannels.values());
        return arrayList.toArray(tArr);
    }
}
