package io.netty.channel.socket.nio;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.socket.DefaultServerSocketChannelConfig;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.ServerSocketChannelConfig;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.List;
import java.util.Map;

public class NioServerSocketChannel extends AbstractNioMessageChannel implements ServerSocketChannel {
    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final Method OPEN_SERVER_SOCKET_CHANNEL_WITH_FAMILY = SelectorProviderUtil.findOpenMethod("openServerSocketChannel");
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioServerSocketChannel.class);
    private final ServerSocketChannelConfig config;

    public final class NioServerSocketChannelConfig extends DefaultServerSocketChannelConfig {
        private java.nio.channels.ServerSocketChannel jdkChannel() {
            return ((NioServerSocketChannel) this.channel).javaChannel();
        }

        public void autoReadCleared() {
            NioServerSocketChannel.this.clearReadPending();
        }

        public <T> T getOption(ChannelOption<T> channelOption) {
            return (PlatformDependent.javaVersion() < 7 || !(channelOption instanceof NioChannelOption)) ? super.getOption(channelOption) : NioChannelOption.getOption(jdkChannel(), (NioChannelOption) channelOption);
        }

        public Map<ChannelOption<?>, Object> getOptions() {
            return PlatformDependent.javaVersion() >= 7 ? getOptions(super.getOptions(), NioChannelOption.getOptions(jdkChannel())) : super.getOptions();
        }

        public <T> boolean setOption(ChannelOption<T> channelOption, T t) {
            return (PlatformDependent.javaVersion() < 7 || !(channelOption instanceof NioChannelOption)) ? super.setOption(channelOption, t) : NioChannelOption.setOption(jdkChannel(), (NioChannelOption) channelOption, t);
        }

        private NioServerSocketChannelConfig(NioServerSocketChannel nioServerSocketChannel, ServerSocket serverSocket) {
            super(nioServerSocketChannel, serverSocket);
        }
    }

    public NioServerSocketChannel() {
        this(DEFAULT_SELECTOR_PROVIDER);
    }

    private static java.nio.channels.ServerSocketChannel newChannel(SelectorProvider selectorProvider, InternetProtocolFamily internetProtocolFamily) {
        try {
            java.nio.channels.ServerSocketChannel serverSocketChannel = (java.nio.channels.ServerSocketChannel) SelectorProviderUtil.newChannel(OPEN_SERVER_SOCKET_CHANNEL_WITH_FAMILY, selectorProvider, internetProtocolFamily);
            return serverSocketChannel == null ? selectorProvider.openServerSocketChannel() : serverSocketChannel;
        } catch (IOException e) {
            throw new ChannelException("Failed to open a socket.", e);
        }
    }

    public boolean closeOnReadError(Throwable th) {
        return super.closeOnReadError(th);
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public void doBind(SocketAddress socketAddress) throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            javaChannel().bind(socketAddress, this.config.getBacklog());
        } else {
            javaChannel().socket().bind(socketAddress, this.config.getBacklog());
        }
    }

    public void doClose() throws Exception {
        javaChannel().close();
    }

    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        throw new UnsupportedOperationException();
    }

    public void doDisconnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    public void doFinishConnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    public int doReadMessages(List<Object> list) throws Exception {
        SocketChannel accept = SocketUtils.accept(javaChannel());
        if (accept == null) {
            return 0;
        }
        try {
            list.add(new NioSocketChannel((Channel) this, accept));
            return 1;
        } catch (Throwable th) {
            logger.warn("Failed to close a socket.", th);
            return 0;
        }
    }

    public boolean doWriteMessage(Object obj, ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    public final Object filterOutboundMessage(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    public boolean isActive() {
        return isOpen() && javaChannel().socket().isBound();
    }

    public SocketAddress localAddress0() {
        return SocketUtils.localSocketAddress(javaChannel().socket());
    }

    public ChannelMetadata metadata() {
        return METADATA;
    }

    public InetSocketAddress remoteAddress() {
        return null;
    }

    public SocketAddress remoteAddress0() {
        return null;
    }

    public NioServerSocketChannel(SelectorProvider selectorProvider) {
        this(selectorProvider, (InternetProtocolFamily) null);
    }

    public ServerSocketChannelConfig config() {
        return this.config;
    }

    public java.nio.channels.ServerSocketChannel javaChannel() {
        return (java.nio.channels.ServerSocketChannel) super.javaChannel();
    }

    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    public NioServerSocketChannel(SelectorProvider selectorProvider, InternetProtocolFamily internetProtocolFamily) {
        this(newChannel(selectorProvider, internetProtocolFamily));
    }

    public NioServerSocketChannel(java.nio.channels.ServerSocketChannel serverSocketChannel) {
        super((Channel) null, serverSocketChannel, 16);
        this.config = new NioServerSocketChannelConfig(this, javaChannel().socket());
    }
}
