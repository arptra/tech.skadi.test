package io.netty.bootstrap;

import com.upuphone.runasone.relay.api.IntentKey;
import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBootstrap<B extends AbstractBootstrap<B, C>, C extends Channel> implements Cloneable {
    private static final Map.Entry<AttributeKey<?>, Object>[] EMPTY_ATTRIBUTE_ARRAY = new Map.Entry[0];
    private static final Map.Entry<ChannelOption<?>, Object>[] EMPTY_OPTION_ARRAY = new Map.Entry[0];
    private final Map<AttributeKey<?>, Object> attrs;
    private volatile ChannelFactory<? extends C> channelFactory;
    volatile EventLoopGroup group;
    private volatile ChannelHandler handler;
    private volatile SocketAddress localAddress;
    private final Map<ChannelOption<?>, Object> options;

    public static final class PendingRegistrationPromise extends DefaultChannelPromise {
        private volatile boolean registered;

        public PendingRegistrationPromise(Channel channel) {
            super(channel);
        }

        public EventExecutor executor() {
            return this.registered ? super.executor() : GlobalEventExecutor.INSTANCE;
        }

        public void registered() {
            this.registered = true;
        }
    }

    public AbstractBootstrap() {
        this.options = new LinkedHashMap();
        this.attrs = new ConcurrentHashMap();
    }

    public static <K, V> Map<K, V> copiedMap(Map<K, V> map) {
        return map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(map));
    }

    private ChannelFuture doBind(SocketAddress socketAddress) {
        ChannelFuture initAndRegister = initAndRegister();
        final Channel channel = initAndRegister.channel();
        if (initAndRegister.cause() != null) {
            return initAndRegister;
        }
        if (initAndRegister.isDone()) {
            ChannelPromise newPromise = channel.newPromise();
            doBind0(initAndRegister, channel, socketAddress, newPromise);
            return newPromise;
        }
        PendingRegistrationPromise pendingRegistrationPromise = new PendingRegistrationPromise(channel);
        final PendingRegistrationPromise pendingRegistrationPromise2 = pendingRegistrationPromise;
        final ChannelFuture channelFuture = initAndRegister;
        final SocketAddress socketAddress2 = socketAddress;
        initAndRegister.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                Throwable cause = channelFuture.cause();
                if (cause != null) {
                    pendingRegistrationPromise2.setFailure(cause);
                    return;
                }
                pendingRegistrationPromise2.registered();
                AbstractBootstrap.doBind0(channelFuture, channel, socketAddress2, pendingRegistrationPromise2);
            }
        });
        return pendingRegistrationPromise;
    }

    /* access modifiers changed from: private */
    public static void doBind0(final ChannelFuture channelFuture, final Channel channel, final SocketAddress socketAddress, final ChannelPromise channelPromise) {
        channel.eventLoop().execute(new Runnable() {
            public void run() {
                if (channelFuture.isSuccess()) {
                    channel.bind(socketAddress, channelPromise).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
                } else {
                    channelPromise.setFailure(channelFuture.cause());
                }
            }
        });
    }

    private B self() {
        return this;
    }

    public static void setAttributes(Channel channel, Map.Entry<AttributeKey<?>, Object>[] entryArr) {
        for (Map.Entry<AttributeKey<?>, Object> entry : entryArr) {
            channel.attr(entry.getKey()).set(entry.getValue());
        }
    }

    private static void setChannelOption(Channel channel, ChannelOption<?> channelOption, Object obj, InternalLogger internalLogger) {
        try {
            if (!channel.config().setOption(channelOption, obj)) {
                internalLogger.warn("Unknown channel option '{}' for channel '{}'", channelOption, channel);
            }
        } catch (Throwable th) {
            internalLogger.warn("Failed to set channel option '{}' with value '{}' for channel '{}'", channelOption, obj, channel, th);
        }
    }

    public static void setChannelOptions(Channel channel, Map.Entry<ChannelOption<?>, Object>[] entryArr, InternalLogger internalLogger) {
        for (Map.Entry<ChannelOption<?>, Object> entry : entryArr) {
            setChannelOption(channel, entry.getKey(), entry.getValue(), internalLogger);
        }
    }

    public <T> B attr(AttributeKey<T> attributeKey, T t) {
        ObjectUtil.checkNotNull(attributeKey, IntentKey.ACTIVITY.ACTION_KEY);
        if (t == null) {
            this.attrs.remove(attributeKey);
        } else {
            this.attrs.put(attributeKey, t);
        }
        return self();
    }

    public final Map<AttributeKey<?>, Object> attrs() {
        return copiedMap(this.attrs);
    }

    public final Map<AttributeKey<?>, Object> attrs0() {
        return this.attrs;
    }

    public ChannelFuture bind() {
        validate();
        SocketAddress socketAddress = this.localAddress;
        if (socketAddress != null) {
            return doBind(socketAddress);
        }
        throw new IllegalStateException("localAddress not set");
    }

    public B channel(Class<? extends C> cls) {
        return channelFactory(new ReflectiveChannelFactory((Class) ObjectUtil.checkNotNull(cls, "channelClass")));
    }

    @Deprecated
    public B channelFactory(ChannelFactory<? extends C> channelFactory2) {
        ObjectUtil.checkNotNull(channelFactory2, "channelFactory");
        if (this.channelFactory == null) {
            this.channelFactory = channelFactory2;
            return self();
        }
        throw new IllegalStateException("channelFactory set already");
    }

    public abstract B clone();

    public abstract AbstractBootstrapConfig<B, C> config();

    public B group(EventLoopGroup eventLoopGroup) {
        ObjectUtil.checkNotNull(eventLoopGroup, "group");
        if (this.group == null) {
            this.group = eventLoopGroup;
            return self();
        }
        throw new IllegalStateException("group set already");
    }

    public B handler(ChannelHandler channelHandler) {
        this.handler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "handler");
        return self();
    }

    public abstract void init(Channel channel) throws Exception;

    public final ChannelFuture initAndRegister() {
        Channel channel = null;
        try {
            channel = this.channelFactory.newChannel();
            init(channel);
            ChannelFuture register = config().group().register(channel);
            if (register.cause() != null) {
                if (channel.isRegistered()) {
                    channel.close();
                } else {
                    channel.unsafe().closeForcibly();
                }
            }
            return register;
        } catch (Throwable th) {
            if (channel == null) {
                return new DefaultChannelPromise(new FailedChannel(), GlobalEventExecutor.INSTANCE).setFailure(th);
            }
            channel.unsafe().closeForcibly();
            return new DefaultChannelPromise(channel, GlobalEventExecutor.INSTANCE).setFailure(th);
        }
    }

    public B localAddress(SocketAddress socketAddress) {
        this.localAddress = socketAddress;
        return self();
    }

    public final Map.Entry<AttributeKey<?>, Object>[] newAttributesArray() {
        return newAttributesArray(attrs0());
    }

    public final Map.Entry<ChannelOption<?>, Object>[] newOptionsArray() {
        return newOptionsArray(this.options);
    }

    public <T> B option(ChannelOption<T> channelOption, T t) {
        ObjectUtil.checkNotNull(channelOption, "option");
        synchronized (this.options) {
            if (t == null) {
                try {
                    this.options.remove(channelOption);
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            } else {
                this.options.put(channelOption, t);
            }
        }
        return self();
    }

    public final Map<ChannelOption<?>, Object> options() {
        Map<ChannelOption<?>, Object> copiedMap;
        synchronized (this.options) {
            copiedMap = copiedMap(this.options);
        }
        return copiedMap;
    }

    public final Map<ChannelOption<?>, Object> options0() {
        return this.options;
    }

    public ChannelFuture register() {
        validate();
        return initAndRegister();
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '(' + config() + ')';
    }

    public B validate() {
        if (this.group == null) {
            throw new IllegalStateException("group not set");
        } else if (this.channelFactory != null) {
            return self();
        } else {
            throw new IllegalStateException("channel or channelFactory not set");
        }
    }

    public static Map.Entry<AttributeKey<?>, Object>[] newAttributesArray(Map<AttributeKey<?>, Object> map) {
        return (Map.Entry[]) map.entrySet().toArray(EMPTY_ATTRIBUTE_ARRAY);
    }

    public static Map.Entry<ChannelOption<?>, Object>[] newOptionsArray(Map<ChannelOption<?>, Object> map) {
        Map.Entry<ChannelOption<?>, Object>[] entryArr;
        synchronized (map) {
            entryArr = (Map.Entry[]) new LinkedHashMap(map).entrySet().toArray(EMPTY_OPTION_ARRAY);
        }
        return entryArr;
    }

    public final ChannelHandler handler() {
        return this.handler;
    }

    public B localAddress(int i) {
        return localAddress((SocketAddress) new InetSocketAddress(i));
    }

    public AbstractBootstrap(AbstractBootstrap<B, C> abstractBootstrap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.options = linkedHashMap;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.attrs = concurrentHashMap;
        this.group = abstractBootstrap.group;
        this.channelFactory = abstractBootstrap.channelFactory;
        this.handler = abstractBootstrap.handler;
        this.localAddress = abstractBootstrap.localAddress;
        synchronized (abstractBootstrap.options) {
            linkedHashMap.putAll(abstractBootstrap.options);
        }
        concurrentHashMap.putAll(abstractBootstrap.attrs);
    }

    public B localAddress(String str, int i) {
        return localAddress((SocketAddress) SocketUtils.socketAddress(str, i));
    }

    public ChannelFuture bind(int i) {
        return bind((SocketAddress) new InetSocketAddress(i));
    }

    public B localAddress(InetAddress inetAddress, int i) {
        return localAddress((SocketAddress) new InetSocketAddress(inetAddress, i));
    }

    public ChannelFuture bind(String str, int i) {
        return bind((SocketAddress) SocketUtils.socketAddress(str, i));
    }

    public B channelFactory(ChannelFactory<? extends C> channelFactory2) {
        return channelFactory(channelFactory2);
    }

    @Deprecated
    public final EventLoopGroup group() {
        return this.group;
    }

    public final SocketAddress localAddress() {
        return this.localAddress;
    }

    public ChannelFuture bind(InetAddress inetAddress, int i) {
        return bind((SocketAddress) new InetSocketAddress(inetAddress, i));
    }

    public final ChannelFactory<? extends C> channelFactory() {
        return this.channelFactory;
    }

    public ChannelFuture bind(SocketAddress socketAddress) {
        validate();
        return doBind((SocketAddress) ObjectUtil.checkNotNull(socketAddress, "localAddress"));
    }
}
