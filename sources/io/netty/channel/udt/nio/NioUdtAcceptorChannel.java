package io.netty.channel.udt.nio;

import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.ServerSocketChannelUDT;
import com.barchart.udt.nio.SocketChannelUDT;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.udt.DefaultUdtServerChannelConfig;
import io.netty.channel.udt.UdtChannel;
import io.netty.channel.udt.UdtServerChannel;
import io.netty.channel.udt.UdtServerChannelConfig;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;

@Deprecated
public abstract class NioUdtAcceptorChannel extends AbstractNioMessageChannel implements UdtServerChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    protected static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioUdtAcceptorChannel.class);
    private final UdtServerChannelConfig config;

    public NioUdtAcceptorChannel(ServerSocketChannelUDT serverSocketChannelUDT) {
        super((Channel) null, serverSocketChannelUDT, 16);
        try {
            serverSocketChannelUDT.configureBlocking(false);
            this.config = new DefaultUdtServerChannelConfig(this, serverSocketChannelUDT, true);
        } catch (Exception e) {
            try {
                serverSocketChannelUDT.close();
            } catch (Exception e2) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Failed to close channel.", (Throwable) e2);
                }
            }
            throw new ChannelException("Failed to configure channel.", e);
        }
    }

    public void doBind(SocketAddress socketAddress) throws Exception {
        javaChannel().socket().bind(socketAddress, this.config.getBacklog());
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
        SocketChannelUDT accept = SocketUtils.accept(javaChannel());
        if (accept == null) {
            return 0;
        }
        list.add(newConnectorChannel(accept));
        return 1;
    }

    public boolean doWriteMessage(Object obj, ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    public final Object filterOutboundMessage(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    public boolean isActive() {
        return javaChannel().socket().isBound();
    }

    public SocketAddress localAddress0() {
        return SocketUtils.localSocketAddress(javaChannel().socket());
    }

    public ChannelMetadata metadata() {
        return METADATA;
    }

    public abstract UdtChannel newConnectorChannel(SocketChannelUDT socketChannelUDT);

    public InetSocketAddress remoteAddress() {
        return null;
    }

    public SocketAddress remoteAddress0() {
        return null;
    }

    public ServerSocketChannelUDT javaChannel() {
        return super.javaChannel();
    }

    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    public UdtServerChannelConfig config() {
        return this.config;
    }

    public NioUdtAcceptorChannel(TypeUDT typeUDT) {
        this(NioUdtProvider.newAcceptorChannelUDT(typeUDT));
    }
}
