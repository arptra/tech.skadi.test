package io.netty.channel.udt.nio;

import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.SocketChannelUDT;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.udt.DefaultUdtChannelConfig;
import io.netty.channel.udt.UdtChannel;
import io.netty.channel.udt.UdtChannelConfig;
import io.netty.channel.udt.UdtMessage;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ScatteringByteChannel;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.List;

@Deprecated
public class NioUdtMessageConnectorChannel extends AbstractNioMessageChannel implements UdtChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioUdtMessageConnectorChannel.class);
    private final UdtChannelConfig config;

    /* renamed from: io.netty.channel.udt.nio.NioUdtMessageConnectorChannel$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$barchart$udt$StatusUDT;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.barchart.udt.StatusUDT[] r0 = com.barchart.udt.StatusUDT.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$barchart$udt$StatusUDT = r0
                com.barchart.udt.StatusUDT r1 = com.barchart.udt.StatusUDT.INIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$barchart$udt$StatusUDT     // Catch:{ NoSuchFieldError -> 0x001d }
                com.barchart.udt.StatusUDT r1 = com.barchart.udt.StatusUDT.OPENED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.udt.nio.NioUdtMessageConnectorChannel.AnonymousClass2.<clinit>():void");
        }
    }

    public NioUdtMessageConnectorChannel() {
        this(TypeUDT.DATAGRAM);
    }

    private static void privilegedBind(final SocketChannelUDT socketChannelUDT, final SocketAddress socketAddress) throws IOException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() {
                public Void run() throws IOException {
                    socketChannelUDT.bind(socketAddress);
                    return null;
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getCause());
        }
    }

    public void doBind(SocketAddress socketAddress) throws Exception {
        privilegedBind(javaChannel(), socketAddress);
    }

    public void doClose() throws Exception {
        javaChannel().close();
    }

    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 == null) {
            socketAddress2 = new InetSocketAddress(0);
        }
        doBind(socketAddress2);
        try {
            boolean connect = SocketUtils.connect(javaChannel(), socketAddress);
            if (!connect) {
                selectionKey().interestOps(selectionKey().interestOps() | 8);
            }
            return connect;
        } catch (Throwable th) {
            doClose();
            throw th;
        }
    }

    public void doDisconnect() throws Exception {
        doClose();
    }

    public void doFinishConnect() throws Exception {
        if (javaChannel().finishConnect()) {
            selectionKey().interestOps(selectionKey().interestOps() & -9);
            return;
        }
        throw new Error("Provider error: failed to finish connect. Provider library should be upgraded.");
    }

    public int doReadMessages(List<Object> list) throws Exception {
        int receiveBufferSize = this.config.getReceiveBufferSize();
        ByteBuf directBuffer = this.config.getAllocator().directBuffer(receiveBufferSize);
        int writeBytes = directBuffer.writeBytes((ScatteringByteChannel) javaChannel(), receiveBufferSize);
        if (writeBytes <= 0) {
            directBuffer.release();
            return 0;
        } else if (writeBytes < receiveBufferSize) {
            list.add(new UdtMessage(directBuffer));
            return 1;
        } else {
            javaChannel().close();
            throw new ChannelException("Invalid config : increase receive buffer size to avoid message truncation");
        }
    }

    public boolean doWriteMessage(Object obj, ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        ByteBuf content = ((UdtMessage) obj).content();
        int readableBytes = content.readableBytes();
        if (readableBytes == 0) {
            return true;
        }
        long write = content.nioBufferCount() == 1 ? (long) javaChannel().write(content.nioBuffer()) : javaChannel().write(content.nioBuffers());
        int i = (write > 0 ? 1 : (write == 0 ? 0 : -1));
        if (i <= 0 || write == ((long) readableBytes)) {
            return i > 0;
        }
        throw new Error("Provider error: failed to write message. Provider library should be upgraded.");
    }

    public boolean isActive() {
        SocketChannelUDT javaChannel = javaChannel();
        return javaChannel.isOpen() && javaChannel.isConnectFinished();
    }

    public SocketAddress localAddress0() {
        return javaChannel().socket().getLocalSocketAddress();
    }

    public ChannelMetadata metadata() {
        return METADATA;
    }

    public SocketAddress remoteAddress0() {
        return javaChannel().socket().getRemoteSocketAddress();
    }

    public NioUdtMessageConnectorChannel(Channel channel, SocketChannelUDT socketChannelUDT) {
        super(channel, socketChannelUDT, 1);
        try {
            socketChannelUDT.configureBlocking(false);
            int i = AnonymousClass2.$SwitchMap$com$barchart$udt$StatusUDT[socketChannelUDT.socketUDT().status().ordinal()];
            if (i == 1 || i == 2) {
                this.config = new DefaultUdtChannelConfig(this, socketChannelUDT, true);
            } else {
                this.config = new DefaultUdtChannelConfig(this, socketChannelUDT, false);
            }
        } catch (Exception e) {
            try {
                socketChannelUDT.close();
            } catch (Exception e2) {
                logger.warn("Failed to close channel.", (Throwable) e2);
            }
            throw new ChannelException("Failed to configure channel.", e);
        }
    }

    public UdtChannelConfig config() {
        return this.config;
    }

    public SocketChannelUDT javaChannel() {
        return super.javaChannel();
    }

    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public NioUdtMessageConnectorChannel(SocketChannelUDT socketChannelUDT) {
        this((Channel) null, socketChannelUDT);
    }

    public NioUdtMessageConnectorChannel(TypeUDT typeUDT) {
        this(NioUdtProvider.newConnectorChannelUDT(typeUDT));
    }
}
