package io.netty.channel.sctp.oio;

import com.sun.nio.sctp.SctpChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.oio.AbstractOioMessageChannel;
import io.netty.channel.sctp.DefaultSctpServerChannelConfig;
import io.netty.channel.sctp.SctpServerChannel;
import io.netty.channel.sctp.SctpServerChannelConfig;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Deprecated
public class OioSctpServerChannel extends AbstractOioMessageChannel implements SctpServerChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 1);
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) OioSctpServerChannel.class);
    private final SctpServerChannelConfig config;
    private final com.sun.nio.sctp.SctpServerChannel sch;
    private final Selector selector;

    public final class OioSctpServerChannelConfig extends DefaultSctpServerChannelConfig {
        public void autoReadCleared() {
            OioSctpServerChannel.this.clearReadPending();
        }

        private OioSctpServerChannelConfig(OioSctpServerChannel oioSctpServerChannel, com.sun.nio.sctp.SctpServerChannel sctpServerChannel) {
            super(oioSctpServerChannel, sctpServerChannel);
        }
    }

    public OioSctpServerChannel() {
        this(newServerSocket());
    }

    private static com.sun.nio.sctp.SctpServerChannel newServerSocket() {
        try {
            return com.sun.nio.sctp.SctpServerChannel.open();
        } catch (IOException e) {
            throw new ChannelException("failed to create a sctp server channel", e);
        }
    }

    public Set<InetSocketAddress> allLocalAddresses() {
        try {
            Set<SocketAddress> allLocalAddresses = this.sch.getAllLocalAddresses();
            LinkedHashSet linkedHashSet = new LinkedHashSet(allLocalAddresses.size());
            for (SocketAddress socketAddress : allLocalAddresses) {
                linkedHashSet.add((InetSocketAddress) socketAddress);
            }
            return linkedHashSet;
        } catch (Throwable unused) {
            return Collections.emptySet();
        }
    }

    public ChannelFuture bindAddress(InetAddress inetAddress) {
        return bindAddress(inetAddress, newPromise());
    }

    public void doBind(SocketAddress socketAddress) throws Exception {
        this.sch.bind(socketAddress, this.config.getBacklog());
    }

    public void doClose() throws Exception {
        try {
            this.selector.close();
        } catch (IOException e) {
            logger.warn("Failed to close a selector.", (Throwable) e);
        }
        this.sch.close();
    }

    public void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        throw new UnsupportedOperationException();
    }

    public void doDisconnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    public int doReadMessages(List<Object> list) throws Exception {
        SctpChannel accept;
        if (!isActive()) {
            return -1;
        }
        SctpChannel sctpChannel = null;
        int i = 0;
        try {
            if (this.selector.select(1000) > 0) {
                Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
                do {
                    it.remove();
                    if (it.next().isAcceptable() && (accept = this.sch.accept()) != null) {
                        list.add(new OioSctpChannel(this, accept));
                        i++;
                    }
                } while (it.hasNext());
                return i;
            }
        } catch (Throwable th) {
            logger.warn("Failed to close a sctp channel.", th);
        }
        return 0;
    }

    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    public Object filterOutboundMessage(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    public boolean isActive() {
        return isOpen() && localAddress0() != null;
    }

    public boolean isOpen() {
        return this.sch.isOpen();
    }

    public SocketAddress localAddress0() {
        try {
            Iterator it = this.sch.getAllLocalAddresses().iterator();
            if (it.hasNext()) {
                return (SocketAddress) it.next();
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
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

    public ChannelFuture unbindAddress(InetAddress inetAddress) {
        return unbindAddress(inetAddress, newPromise());
    }

    public OioSctpServerChannel(com.sun.nio.sctp.SctpServerChannel sctpServerChannel) {
        super((Channel) null);
        this.sch = (com.sun.nio.sctp.SctpServerChannel) ObjectUtil.checkNotNull(sctpServerChannel, "sctp server channel");
        try {
            sctpServerChannel.configureBlocking(false);
            Selector open = Selector.open();
            this.selector = open;
            sctpServerChannel.register(open, 16);
            this.config = new OioSctpServerChannelConfig(this, sctpServerChannel);
        } catch (Exception e) {
            throw new ChannelException("failed to initialize a sctp server channel", e);
        } catch (Throwable th) {
            try {
                sctpServerChannel.close();
            } catch (IOException e2) {
                logger.warn("Failed to close a sctp server channel.", (Throwable) e2);
            }
            throw th;
        }
    }

    public ChannelFuture bindAddress(final InetAddress inetAddress, final ChannelPromise channelPromise) {
        if (eventLoop().inEventLoop()) {
            try {
                this.sch.bindAddress(inetAddress);
                channelPromise.setSuccess();
            } catch (Throwable th) {
                channelPromise.setFailure(th);
            }
        } else {
            eventLoop().execute(new Runnable() {
                public void run() {
                    OioSctpServerChannel.this.bindAddress(inetAddress, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    public SctpServerChannelConfig config() {
        return this.config;
    }

    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    public ChannelFuture unbindAddress(final InetAddress inetAddress, final ChannelPromise channelPromise) {
        if (eventLoop().inEventLoop()) {
            try {
                this.sch.unbindAddress(inetAddress);
                channelPromise.setSuccess();
            } catch (Throwable th) {
                channelPromise.setFailure(th);
            }
        } else {
            eventLoop().execute(new Runnable() {
                public void run() {
                    OioSctpServerChannel.this.unbindAddress(inetAddress, channelPromise);
                }
            });
        }
        return channelPromise;
    }
}
