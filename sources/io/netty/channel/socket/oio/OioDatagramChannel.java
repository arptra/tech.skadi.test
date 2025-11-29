package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.oio.AbstractOioMessageChannel;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.channels.NotYetConnectedException;
import java.util.List;
import java.util.Locale;
import kotlin.text.Typography;

@Deprecated
public class OioDatagramChannel extends AbstractOioMessageChannel implements DatagramChannel {
    private static final String EXPECTED_TYPES;
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) OioDatagramChannel.class);
    private final OioDatagramChannelConfig config;
    private final MulticastSocket socket;
    private final DatagramPacket tmpPacket;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(" (expected: ");
        sb.append(StringUtil.simpleClassName((Class<?>) io.netty.channel.socket.DatagramPacket.class));
        sb.append(", ");
        sb.append(StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class));
        sb.append(Typography.less);
        Class<ByteBuf> cls = ByteBuf.class;
        sb.append(StringUtil.simpleClassName((Class<?>) cls));
        sb.append(", ");
        sb.append(StringUtil.simpleClassName((Class<?>) SocketAddress.class));
        sb.append(">, ");
        sb.append(StringUtil.simpleClassName((Class<?>) cls));
        sb.append(')');
        EXPECTED_TYPES = sb.toString();
    }

    public OioDatagramChannel() {
        this(newSocket());
    }

    private void ensureBound() {
        if (!isActive()) {
            throw new IllegalStateException(DatagramChannel.class.getName() + " must be bound to join a group.");
        }
    }

    private static MulticastSocket newSocket() {
        try {
            return new MulticastSocket((SocketAddress) null);
        } catch (Exception e) {
            throw new ChannelException("failed to create a new socket", e);
        }
    }

    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    public void doBind(SocketAddress socketAddress) throws Exception {
        this.socket.bind(socketAddress);
    }

    public void doClose() throws Exception {
        this.socket.close();
    }

    public void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 != null) {
            this.socket.bind(socketAddress2);
        }
        try {
            this.socket.connect(socketAddress);
            return;
        } catch (Throwable th) {
            logger.warn("Failed to close a socket.", th);
        }
        throw th;
    }

    public void doDisconnect() throws Exception {
        this.socket.disconnect();
    }

    public int doReadMessages(List<Object> list) throws Exception {
        DatagramChannelConfig config2 = config();
        RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
        ByteBuf heapBuffer = config2.getAllocator().heapBuffer(recvBufAllocHandle.guess());
        try {
            this.tmpPacket.setAddress((InetAddress) null);
            this.tmpPacket.setData(heapBuffer.array(), heapBuffer.arrayOffset(), heapBuffer.capacity());
            this.socket.receive(this.tmpPacket);
            recvBufAllocHandle.lastBytesRead(this.tmpPacket.getLength());
            list.add(new io.netty.channel.socket.DatagramPacket(heapBuffer.writerIndex(recvBufAllocHandle.lastBytesRead()), localAddress(), (InetSocketAddress) this.tmpPacket.getSocketAddress()));
            return 1;
        } catch (SocketTimeoutException unused) {
            heapBuffer.release();
            return 0;
        } catch (SocketException e) {
            if (e.getMessage().toLowerCase(Locale.US).contains("socket closed")) {
                heapBuffer.release();
                return -1;
            }
            throw e;
        } catch (Throwable th) {
            heapBuffer.release();
            throw th;
        }
    }

    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        SocketAddress socketAddress;
        ByteBuf byteBuf;
        while (true) {
            Object current = channelOutboundBuffer.current();
            if (current != null) {
                if (current instanceof AddressedEnvelope) {
                    AddressedEnvelope addressedEnvelope = (AddressedEnvelope) current;
                    socketAddress = addressedEnvelope.recipient();
                    byteBuf = (ByteBuf) addressedEnvelope.content();
                } else {
                    byteBuf = (ByteBuf) current;
                    socketAddress = null;
                }
                int readableBytes = byteBuf.readableBytes();
                if (socketAddress != null) {
                    try {
                        this.tmpPacket.setSocketAddress(socketAddress);
                    } catch (Exception e) {
                        channelOutboundBuffer.remove(e);
                    }
                } else if (isConnected()) {
                    this.tmpPacket.setAddress((InetAddress) null);
                } else {
                    throw new NotYetConnectedException();
                }
                if (byteBuf.hasArray()) {
                    this.tmpPacket.setData(byteBuf.array(), byteBuf.arrayOffset() + byteBuf.readerIndex(), readableBytes);
                } else {
                    this.tmpPacket.setData(ByteBufUtil.getBytes(byteBuf, byteBuf.readerIndex(), readableBytes));
                }
                this.socket.send(this.tmpPacket);
                channelOutboundBuffer.remove();
            } else {
                return;
            }
        }
    }

    public Object filterOutboundMessage(Object obj) {
        if ((obj instanceof io.netty.channel.socket.DatagramPacket) || (obj instanceof ByteBuf)) {
            return obj;
        }
        if ((obj instanceof AddressedEnvelope) && (((AddressedEnvelope) obj).content() instanceof ByteBuf)) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    public boolean isActive() {
        return isOpen() && ((((Boolean) this.config.getOption(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION)).booleanValue() && isRegistered()) || this.socket.isBound());
    }

    public boolean isConnected() {
        return this.socket.isConnected();
    }

    public boolean isOpen() {
        return !this.socket.isClosed();
    }

    public ChannelFuture joinGroup(InetAddress inetAddress) {
        return joinGroup(inetAddress, newPromise());
    }

    public ChannelFuture leaveGroup(InetAddress inetAddress) {
        return leaveGroup(inetAddress, newPromise());
    }

    public SocketAddress localAddress0() {
        return this.socket.getLocalSocketAddress();
    }

    public ChannelMetadata metadata() {
        return METADATA;
    }

    public SocketAddress remoteAddress0() {
        return this.socket.getRemoteSocketAddress();
    }

    public OioDatagramChannel(MulticastSocket multicastSocket) {
        super((Channel) null);
        this.tmpPacket = new DatagramPacket(EmptyArrays.EMPTY_BYTES, 0);
        try {
            multicastSocket.setSoTimeout(1000);
            multicastSocket.setBroadcast(false);
            this.socket = multicastSocket;
            this.config = new DefaultOioDatagramChannelConfig(this, multicastSocket);
        } catch (SocketException e) {
            throw new ChannelException("Failed to configure the datagram socket timeout.", e);
        } catch (Throwable th) {
            multicastSocket.close();
            throw th;
        }
    }

    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        channelPromise.setFailure(new UnsupportedOperationException());
        return channelPromise;
    }

    public DatagramChannelConfig config() {
        return this.config;
    }

    public ChannelFuture joinGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        ensureBound();
        try {
            this.socket.joinGroup(inetAddress);
            channelPromise.setSuccess();
        } catch (IOException e) {
            channelPromise.setFailure(e);
        }
        return channelPromise;
    }

    public ChannelFuture leaveGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            this.socket.leaveGroup(inetAddress);
            channelPromise.setSuccess();
        } catch (IOException e) {
            channelPromise.setFailure(e);
        }
        return channelPromise;
    }

    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2, ChannelPromise channelPromise) {
        channelPromise.setFailure(new UnsupportedOperationException());
        return channelPromise;
    }

    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return leaveGroup(inetSocketAddress, networkInterface, newPromise());
    }

    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return joinGroup(inetSocketAddress, networkInterface, newPromise());
    }

    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        try {
            this.socket.leaveGroup(inetSocketAddress, networkInterface);
            channelPromise.setSuccess();
        } catch (IOException e) {
            channelPromise.setFailure(e);
        }
        return channelPromise;
    }

    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        ensureBound();
        try {
            this.socket.joinGroup(inetSocketAddress, networkInterface);
            channelPromise.setSuccess();
        } catch (IOException e) {
            channelPromise.setFailure(e);
        }
        return channelPromise;
    }

    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        channelPromise.setFailure(new UnsupportedOperationException());
        return channelPromise;
    }

    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        channelPromise.setFailure(new UnsupportedOperationException());
        return channelPromise;
    }
}
