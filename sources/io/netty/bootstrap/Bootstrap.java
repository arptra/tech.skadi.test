package io.netty.bootstrap;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.AddressResolverGroup;
import io.netty.resolver.DefaultAddressResolverGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class Bootstrap extends AbstractBootstrap<Bootstrap, Channel> {
    private static final AddressResolverGroup<?> DEFAULT_RESOLVER = DefaultAddressResolverGroup.INSTANCE;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Bootstrap.class);
    private final BootstrapConfig config = new BootstrapConfig(this);
    private volatile SocketAddress remoteAddress;
    private volatile AddressResolverGroup<SocketAddress> resolver = DEFAULT_RESOLVER;

    public Bootstrap() {
    }

    /* access modifiers changed from: private */
    public static void doConnect(final SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelPromise channelPromise) {
        final Channel channel = channelPromise.channel();
        channel.eventLoop().execute(new Runnable() {
            public void run() {
                SocketAddress socketAddress = socketAddress2;
                if (socketAddress == null) {
                    channel.connect(socketAddress, channelPromise);
                } else {
                    channel.connect(socketAddress, socketAddress, channelPromise);
                }
                channelPromise.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            }
        });
    }

    private ChannelFuture doResolveAndConnect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        ChannelFuture initAndRegister = initAndRegister();
        final Channel channel = initAndRegister.channel();
        if (initAndRegister.isDone()) {
            return !initAndRegister.isSuccess() ? initAndRegister : doResolveAndConnect0(channel, socketAddress, socketAddress2, channel.newPromise());
        }
        AbstractBootstrap.PendingRegistrationPromise pendingRegistrationPromise = new AbstractBootstrap.PendingRegistrationPromise(channel);
        final AbstractBootstrap.PendingRegistrationPromise pendingRegistrationPromise2 = pendingRegistrationPromise;
        final SocketAddress socketAddress3 = socketAddress;
        final SocketAddress socketAddress4 = socketAddress2;
        initAndRegister.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                Throwable cause = channelFuture.cause();
                if (cause != null) {
                    pendingRegistrationPromise2.setFailure(cause);
                    return;
                }
                pendingRegistrationPromise2.registered();
                ChannelFuture unused = Bootstrap.this.doResolveAndConnect0(channel, socketAddress3, socketAddress4, pendingRegistrationPromise2);
            }
        });
        return pendingRegistrationPromise;
    }

    /* access modifiers changed from: private */
    public ChannelFuture doResolveAndConnect0(final Channel channel, SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelPromise channelPromise) {
        try {
            AddressResolver<SocketAddress> resolver2 = this.resolver.getResolver(channel.eventLoop());
            if (resolver2.isSupported(socketAddress)) {
                if (!resolver2.isResolved(socketAddress)) {
                    Future<SocketAddress> resolve = resolver2.resolve(socketAddress);
                    if (resolve.isDone()) {
                        Throwable cause = resolve.cause();
                        if (cause != null) {
                            channel.close();
                            channelPromise.setFailure(cause);
                        } else {
                            doConnect(resolve.getNow(), socketAddress2, channelPromise);
                        }
                        return channelPromise;
                    }
                    resolve.addListener(new FutureListener<SocketAddress>() {
                        public void operationComplete(Future<SocketAddress> future) throws Exception {
                            if (future.cause() != null) {
                                channel.close();
                                channelPromise.setFailure(future.cause());
                                return;
                            }
                            Bootstrap.doConnect(future.getNow(), socketAddress2, channelPromise);
                        }
                    });
                    return channelPromise;
                }
            }
            doConnect(socketAddress, socketAddress2, channelPromise);
            return channelPromise;
        } catch (Throwable th) {
            channelPromise.tryFailure(th);
        }
    }

    public ChannelFuture connect() {
        validate();
        SocketAddress socketAddress = this.remoteAddress;
        if (socketAddress != null) {
            return doResolveAndConnect(socketAddress, this.config.localAddress());
        }
        throw new IllegalStateException("remoteAddress not set");
    }

    public void init(Channel channel) {
        channel.pipeline().addLast(this.config.handler());
        AbstractBootstrap.setChannelOptions(channel, newOptionsArray(), logger);
        AbstractBootstrap.setAttributes(channel, newAttributesArray());
    }

    public Bootstrap remoteAddress(SocketAddress socketAddress) {
        this.remoteAddress = socketAddress;
        return this;
    }

    public Bootstrap resolver(AddressResolverGroup<?> addressResolverGroup) {
        if (addressResolverGroup == null) {
            addressResolverGroup = DEFAULT_RESOLVER;
        }
        this.resolver = addressResolverGroup;
        return this;
    }

    public final BootstrapConfig config() {
        return this.config;
    }

    public Bootstrap remoteAddress(String str, int i) {
        this.remoteAddress = InetSocketAddress.createUnresolved(str, i);
        return this;
    }

    public final AddressResolverGroup<?> resolver() {
        return this.resolver;
    }

    public Bootstrap validate() {
        super.validate();
        if (this.config.handler() != null) {
            return this;
        }
        throw new IllegalStateException("handler not set");
    }

    public Bootstrap clone() {
        return new Bootstrap(this);
    }

    public Bootstrap remoteAddress(InetAddress inetAddress, int i) {
        this.remoteAddress = new InetSocketAddress(inetAddress, i);
        return this;
    }

    private Bootstrap(Bootstrap bootstrap) {
        super(bootstrap);
        this.resolver = bootstrap.resolver;
        this.remoteAddress = bootstrap.remoteAddress;
    }

    public Bootstrap clone(EventLoopGroup eventLoopGroup) {
        Bootstrap bootstrap = new Bootstrap(this);
        bootstrap.group = eventLoopGroup;
        return bootstrap;
    }

    public final SocketAddress remoteAddress() {
        return this.remoteAddress;
    }

    public ChannelFuture connect(String str, int i) {
        return connect(InetSocketAddress.createUnresolved(str, i));
    }

    public ChannelFuture connect(InetAddress inetAddress, int i) {
        return connect(new InetSocketAddress(inetAddress, i));
    }

    public ChannelFuture connect(SocketAddress socketAddress) {
        ObjectUtil.checkNotNull(socketAddress, "remoteAddress");
        validate();
        return doResolveAndConnect(socketAddress, this.config.localAddress());
    }

    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        ObjectUtil.checkNotNull(socketAddress, "remoteAddress");
        validate();
        return doResolveAndConnect(socketAddress, socketAddress2);
    }
}
