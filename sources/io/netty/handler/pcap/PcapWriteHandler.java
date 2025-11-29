package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.pcap.TCPPacket;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetSocketAddress;

public final class PcapWriteHandler extends ChannelDuplexHandler implements Closeable {
    private final boolean captureZeroByte;
    private ChannelType channelType;
    private InetSocketAddress handlerAddr;
    private boolean initialized;
    private InetSocketAddress initiatiorAddr;
    private boolean isClosed;
    private boolean isServerPipeline;
    private final InternalLogger logger;
    private final OutputStream outputStream;
    private PcapWriter pCapWriter;
    private int receiveSegmentNumber;
    private int sendSegmentNumber;
    private final boolean writePcapGlobalHeader;

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean captureZeroByte;
        /* access modifiers changed from: private */
        public ChannelType channelType;
        /* access modifiers changed from: private */
        public InetSocketAddress handlerAddr;
        /* access modifiers changed from: private */
        public InetSocketAddress initiatiorAddr;
        /* access modifiers changed from: private */
        public boolean isServerPipeline;
        /* access modifiers changed from: private */
        public boolean writePcapGlobalHeader;

        public PcapWriteHandler build(OutputStream outputStream) {
            ObjectUtil.checkNotNull(outputStream, "outputStream");
            return new PcapWriteHandler(this, outputStream);
        }

        public Builder captureZeroByte(boolean z) {
            this.captureZeroByte = z;
            return this;
        }

        public Builder forceTcpChannel(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, boolean z) {
            this.channelType = ChannelType.TCP;
            this.handlerAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress, "serverAddress");
            this.initiatiorAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress2, "clientAddress");
            this.isServerPipeline = z;
            return this;
        }

        public Builder forceUdpChannel(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
            this.channelType = ChannelType.UDP;
            this.handlerAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress2, "remoteAddress");
            this.initiatiorAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress, "localAddress");
            return this;
        }

        public Builder writePcapGlobalHeader(boolean z) {
            this.writePcapGlobalHeader = z;
            return this;
        }

        private Builder() {
            this.writePcapGlobalHeader = true;
        }
    }

    public enum ChannelType {
        TCP,
        UDP
    }

    public static Builder builder() {
        return new Builder();
    }

    private void completeTCPWrite(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, ChannelHandlerContext channelHandlerContext) {
        ByteBuf buffer = byteBufAllocator.buffer();
        ByteBuf buffer2 = byteBufAllocator.buffer();
        ByteBuf buffer3 = byteBufAllocator.buffer();
        try {
            if ((inetSocketAddress.getAddress() instanceof Inet4Address) && (inetSocketAddress2.getAddress() instanceof Inet4Address)) {
                IPPacket.writeTCPv4(buffer, byteBuf, NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress.getAddress()), NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress2.getAddress()));
                EthernetPacket.writeIPv4(buffer2, buffer);
            } else if (!(inetSocketAddress.getAddress() instanceof Inet6Address) || !(inetSocketAddress2.getAddress() instanceof Inet6Address)) {
                this.logger.error("Source and Destination IP Address versions are not same. Source Address: {}, Destination Address: {}", inetSocketAddress.getAddress(), inetSocketAddress2.getAddress());
                buffer.release();
                buffer2.release();
                buffer3.release();
                return;
            } else {
                IPPacket.writeTCPv6(buffer, byteBuf, inetSocketAddress.getAddress().getAddress(), inetSocketAddress2.getAddress().getAddress());
                EthernetPacket.writeIPv6(buffer2, buffer);
            }
            this.pCapWriter.writePacket(buffer3, buffer2);
        } catch (IOException e) {
            this.logger.error("Caught Exception While Writing Packet into Pcap", (Throwable) e);
            channelHandlerContext.fireExceptionCaught(e);
        } catch (Throwable th) {
            buffer.release();
            buffer2.release();
            buffer3.release();
            throw th;
        }
        buffer.release();
        buffer2.release();
        buffer3.release();
    }

    private void completeUDPWrite(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, ChannelHandlerContext channelHandlerContext) {
        ByteBuf buffer = byteBufAllocator.buffer();
        ByteBuf buffer2 = byteBufAllocator.buffer();
        ByteBuf buffer3 = byteBufAllocator.buffer();
        try {
            if ((inetSocketAddress.getAddress() instanceof Inet4Address) && (inetSocketAddress2.getAddress() instanceof Inet4Address)) {
                IPPacket.writeUDPv4(buffer, byteBuf, NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress.getAddress()), NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress2.getAddress()));
                EthernetPacket.writeIPv4(buffer2, buffer);
            } else if (!(inetSocketAddress.getAddress() instanceof Inet6Address) || !(inetSocketAddress2.getAddress() instanceof Inet6Address)) {
                this.logger.error("Source and Destination IP Address versions are not same. Source Address: {}, Destination Address: {}", inetSocketAddress.getAddress(), inetSocketAddress2.getAddress());
                buffer.release();
                buffer2.release();
                buffer3.release();
                return;
            } else {
                IPPacket.writeUDPv6(buffer, byteBuf, inetSocketAddress.getAddress().getAddress(), inetSocketAddress2.getAddress().getAddress());
                EthernetPacket.writeIPv6(buffer2, buffer);
            }
            this.pCapWriter.writePacket(buffer3, buffer2);
        } catch (IOException e) {
            this.logger.error("Caught Exception While Writing Packet into Pcap", (Throwable) e);
            channelHandlerContext.fireExceptionCaught(e);
        } catch (Throwable th) {
            buffer.release();
            buffer2.release();
            buffer3.release();
            throw th;
        }
        buffer.release();
        buffer2.release();
        buffer3.release();
    }

    private void handleTCP(ChannelHandlerContext channelHandlerContext, Object obj, boolean z) {
        InetSocketAddress inetSocketAddress;
        InetSocketAddress inetSocketAddress2;
        InetSocketAddress inetSocketAddress3;
        InetSocketAddress inetSocketAddress4;
        Object obj2 = obj;
        if (obj2 instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj2;
            if (byteBuf.readableBytes() != 0 || this.captureZeroByte) {
                ByteBufAllocator alloc = channelHandlerContext.alloc();
                ByteBuf duplicate = byteBuf.duplicate();
                ByteBuf buffer = alloc.buffer();
                int readableBytes = duplicate.readableBytes();
                if (z) {
                    try {
                        if (this.isServerPipeline) {
                            inetSocketAddress3 = this.handlerAddr;
                            inetSocketAddress4 = this.initiatiorAddr;
                        } else {
                            inetSocketAddress3 = this.initiatiorAddr;
                            inetSocketAddress4 = this.handlerAddr;
                        }
                        InetSocketAddress inetSocketAddress5 = inetSocketAddress3;
                        InetSocketAddress inetSocketAddress6 = inetSocketAddress4;
                        int i = this.sendSegmentNumber;
                        int i2 = this.receiveSegmentNumber;
                        int port = inetSocketAddress5.getPort();
                        int port2 = inetSocketAddress6.getPort();
                        TCPPacket.TCPFlag tCPFlag = TCPPacket.TCPFlag.ACK;
                        TCPPacket.writePacket(buffer, duplicate, i, i2, port, port2, tCPFlag);
                        completeTCPWrite(inetSocketAddress5, inetSocketAddress6, buffer, alloc, channelHandlerContext);
                        logTCP(true, readableBytes, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress5, inetSocketAddress6, false);
                        int i3 = this.sendSegmentNumber + readableBytes;
                        this.sendSegmentNumber = i3;
                        TCPPacket.TCPFlag[] tCPFlagArr = {tCPFlag};
                        TCPPacket.writePacket(buffer, (ByteBuf) null, this.receiveSegmentNumber, i3, inetSocketAddress6.getPort(), inetSocketAddress5.getPort(), tCPFlagArr);
                        completeTCPWrite(inetSocketAddress6, inetSocketAddress5, buffer, alloc, channelHandlerContext);
                        logTCP(true, readableBytes, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress6, inetSocketAddress5, true);
                    } finally {
                        buffer.release();
                    }
                } else {
                    if (this.isServerPipeline) {
                        inetSocketAddress = this.initiatiorAddr;
                        inetSocketAddress2 = this.handlerAddr;
                    } else {
                        inetSocketAddress = this.handlerAddr;
                        inetSocketAddress2 = this.initiatiorAddr;
                    }
                    InetSocketAddress inetSocketAddress7 = inetSocketAddress;
                    InetSocketAddress inetSocketAddress8 = inetSocketAddress2;
                    int i4 = this.receiveSegmentNumber;
                    int i5 = this.sendSegmentNumber;
                    int port3 = inetSocketAddress7.getPort();
                    int port4 = inetSocketAddress8.getPort();
                    TCPPacket.TCPFlag tCPFlag2 = TCPPacket.TCPFlag.ACK;
                    TCPPacket.writePacket(buffer, duplicate, i4, i5, port3, port4, tCPFlag2);
                    completeTCPWrite(inetSocketAddress7, inetSocketAddress8, buffer, alloc, channelHandlerContext);
                    logTCP(false, readableBytes, this.receiveSegmentNumber, this.sendSegmentNumber, inetSocketAddress7, inetSocketAddress8, false);
                    int i6 = this.receiveSegmentNumber + readableBytes;
                    this.receiveSegmentNumber = i6;
                    TCPPacket.TCPFlag[] tCPFlagArr2 = {tCPFlag2};
                    TCPPacket.writePacket(buffer, (ByteBuf) null, this.sendSegmentNumber, i6, inetSocketAddress8.getPort(), inetSocketAddress7.getPort(), tCPFlagArr2);
                    completeTCPWrite(inetSocketAddress8, inetSocketAddress7, buffer, alloc, channelHandlerContext);
                    logTCP(false, readableBytes, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress8, inetSocketAddress7, true);
                }
                return;
            }
            this.logger.debug("Discarding Zero Byte TCP Packet. isWriteOperation {}", (Object) Boolean.valueOf(z));
            return;
        }
        this.logger.debug("Discarding Pcap Write for TCP Object: {}", obj2);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x00b0=Splitter:B:33:0x00b0, B:15:0x002f=Splitter:B:15:0x002f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleUDP(io.netty.channel.ChannelHandlerContext r8, java.lang.Object r9) {
        /*
            r7 = this;
            io.netty.buffer.ByteBufAllocator r0 = r8.alloc()
            io.netty.buffer.ByteBuf r0 = r0.buffer()
            boolean r1 = r9 instanceof io.netty.channel.socket.DatagramPacket     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "Writing UDP Data of {} Bytes, Src Addr {}, Dst Addr {}"
            java.lang.String r3 = "Discarding Zero Byte UDP Packet"
            if (r1 == 0) goto L_0x0082
            r1 = r9
            io.netty.channel.socket.DatagramPacket r1 = (io.netty.channel.socket.DatagramPacket) r1     // Catch:{ all -> 0x002c }
            java.lang.Object r1 = r1.content()     // Catch:{ all -> 0x002c }
            io.netty.buffer.ByteBuf r1 = (io.netty.buffer.ByteBuf) r1     // Catch:{ all -> 0x002c }
            int r1 = r1.readableBytes()     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x002f
            boolean r1 = r7.captureZeroByte     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x002f
            io.netty.util.internal.logging.InternalLogger r7 = r7.logger     // Catch:{ all -> 0x002c }
            r7.debug((java.lang.String) r3)     // Catch:{ all -> 0x002c }
            r0.release()
            return
        L_0x002c:
            r7 = move-exception
            goto L_0x00f4
        L_0x002f:
            io.netty.channel.socket.DatagramPacket r9 = (io.netty.channel.socket.DatagramPacket) r9     // Catch:{ all -> 0x002c }
            io.netty.channel.socket.DatagramPacket r9 = r9.duplicate()     // Catch:{ all -> 0x002c }
            java.net.SocketAddress r1 = r9.sender()     // Catch:{ all -> 0x002c }
            java.net.InetSocketAddress r1 = (java.net.InetSocketAddress) r1     // Catch:{ all -> 0x002c }
            java.net.SocketAddress r3 = r9.recipient()     // Catch:{ all -> 0x002c }
            java.net.InetSocketAddress r3 = (java.net.InetSocketAddress) r3     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x004d
            io.netty.channel.Channel r1 = r8.channel()     // Catch:{ all -> 0x002c }
            java.net.SocketAddress r1 = r1.localAddress()     // Catch:{ all -> 0x002c }
            java.net.InetSocketAddress r1 = (java.net.InetSocketAddress) r1     // Catch:{ all -> 0x002c }
        L_0x004d:
            r4 = r1
            io.netty.util.internal.logging.InternalLogger r1 = r7.logger     // Catch:{ all -> 0x002c }
            java.lang.Object r5 = r9.content()     // Catch:{ all -> 0x002c }
            io.netty.buffer.ByteBuf r5 = (io.netty.buffer.ByteBuf) r5     // Catch:{ all -> 0x002c }
            int r5 = r5.readableBytes()     // Catch:{ all -> 0x002c }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x002c }
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r4, r3}     // Catch:{ all -> 0x002c }
            r1.debug((java.lang.String) r2, (java.lang.Object[]) r5)     // Catch:{ all -> 0x002c }
            java.lang.Object r9 = r9.content()     // Catch:{ all -> 0x002c }
            io.netty.buffer.ByteBuf r9 = (io.netty.buffer.ByteBuf) r9     // Catch:{ all -> 0x002c }
            int r1 = r4.getPort()     // Catch:{ all -> 0x002c }
            int r2 = r3.getPort()     // Catch:{ all -> 0x002c }
            io.netty.handler.pcap.UDPPacket.writePacket(r0, r9, r1, r2)     // Catch:{ all -> 0x002c }
            io.netty.buffer.ByteBufAllocator r5 = r8.alloc()     // Catch:{ all -> 0x002c }
            r1 = r7
            r2 = r4
            r4 = r0
            r6 = r8
            r1.completeUDPWrite(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x002c }
            goto L_0x00f0
        L_0x0082:
            boolean r1 = r9 instanceof io.netty.buffer.ByteBuf     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x00e9
            io.netty.channel.Channel r1 = r8.channel()     // Catch:{ all -> 0x002c }
            boolean r1 = r1 instanceof io.netty.channel.socket.DatagramChannel     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x009a
            io.netty.channel.Channel r1 = r8.channel()     // Catch:{ all -> 0x002c }
            io.netty.channel.socket.DatagramChannel r1 = (io.netty.channel.socket.DatagramChannel) r1     // Catch:{ all -> 0x002c }
            boolean r1 = r1.isConnected()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x00e9
        L_0x009a:
            r1 = r9
            io.netty.buffer.ByteBuf r1 = (io.netty.buffer.ByteBuf) r1     // Catch:{ all -> 0x002c }
            int r1 = r1.readableBytes()     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x00b0
            boolean r1 = r7.captureZeroByte     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x00b0
            io.netty.util.internal.logging.InternalLogger r7 = r7.logger     // Catch:{ all -> 0x002c }
            r7.debug((java.lang.String) r3)     // Catch:{ all -> 0x002c }
            r0.release()
            return
        L_0x00b0:
            io.netty.buffer.ByteBuf r9 = (io.netty.buffer.ByteBuf) r9     // Catch:{ all -> 0x002c }
            io.netty.buffer.ByteBuf r9 = r9.duplicate()     // Catch:{ all -> 0x002c }
            io.netty.util.internal.logging.InternalLogger r1 = r7.logger     // Catch:{ all -> 0x002c }
            int r3 = r9.readableBytes()     // Catch:{ all -> 0x002c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x002c }
            java.net.InetSocketAddress r4 = r7.initiatiorAddr     // Catch:{ all -> 0x002c }
            java.net.InetSocketAddress r5 = r7.handlerAddr     // Catch:{ all -> 0x002c }
            java.lang.Object[] r3 = new java.lang.Object[]{r3, r4, r5}     // Catch:{ all -> 0x002c }
            r1.debug((java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x002c }
            java.net.InetSocketAddress r1 = r7.initiatiorAddr     // Catch:{ all -> 0x002c }
            int r1 = r1.getPort()     // Catch:{ all -> 0x002c }
            java.net.InetSocketAddress r2 = r7.handlerAddr     // Catch:{ all -> 0x002c }
            int r2 = r2.getPort()     // Catch:{ all -> 0x002c }
            io.netty.handler.pcap.UDPPacket.writePacket(r0, r9, r1, r2)     // Catch:{ all -> 0x002c }
            java.net.InetSocketAddress r2 = r7.initiatiorAddr     // Catch:{ all -> 0x002c }
            java.net.InetSocketAddress r3 = r7.handlerAddr     // Catch:{ all -> 0x002c }
            io.netty.buffer.ByteBufAllocator r5 = r8.alloc()     // Catch:{ all -> 0x002c }
            r1 = r7
            r4 = r0
            r6 = r8
            r1.completeUDPWrite(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x002c }
            goto L_0x00f0
        L_0x00e9:
            io.netty.util.internal.logging.InternalLogger r7 = r7.logger     // Catch:{ all -> 0x002c }
            java.lang.String r8 = "Discarding Pcap Write for UDP Object: {}"
            r7.debug((java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x002c }
        L_0x00f0:
            r0.release()
            return
        L_0x00f4:
            r0.release()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.pcap.PcapWriteHandler.handleUDP(io.netty.channel.ChannelHandlerContext, java.lang.Object):void");
    }

    /* JADX INFO: finally extract failed */
    private void initializeIfNecessary(ChannelHandlerContext channelHandlerContext) {
        if (!this.initialized) {
            ByteBufAllocator alloc = channelHandlerContext.alloc();
            if (this.writePcapGlobalHeader) {
                ByteBuf buffer = alloc.buffer();
                try {
                    this.pCapWriter = new PcapWriter(this.outputStream, buffer);
                    buffer.release();
                    ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
                } catch (IOException e) {
                    channelHandlerContext.channel().close();
                    channelHandlerContext.fireExceptionCaught(e);
                    this.logger.error("Caught Exception While Initializing PcapWriter, Closing Channel.", (Throwable) e);
                    buffer.release();
                } catch (Throwable th) {
                    buffer.release();
                    throw th;
                }
            } else {
                ChannelHandlerContext channelHandlerContext3 = channelHandlerContext;
                this.pCapWriter = new PcapWriter(this.outputStream);
            }
            if (this.channelType == null) {
                if (channelHandlerContext.channel() instanceof SocketChannel) {
                    this.channelType = ChannelType.TCP;
                    if (channelHandlerContext.channel().parent() instanceof ServerSocketChannel) {
                        this.isServerPipeline = true;
                        this.initiatiorAddr = (InetSocketAddress) channelHandlerContext.channel().remoteAddress();
                        this.handlerAddr = (InetSocketAddress) channelHandlerContext.channel().localAddress();
                    } else {
                        this.isServerPipeline = false;
                        this.initiatiorAddr = (InetSocketAddress) channelHandlerContext.channel().localAddress();
                        this.handlerAddr = (InetSocketAddress) channelHandlerContext.channel().remoteAddress();
                    }
                } else if (channelHandlerContext.channel() instanceof DatagramChannel) {
                    this.channelType = ChannelType.UDP;
                    if (((DatagramChannel) channelHandlerContext.channel()).isConnected()) {
                        this.initiatiorAddr = (InetSocketAddress) channelHandlerContext.channel().localAddress();
                        this.handlerAddr = (InetSocketAddress) channelHandlerContext.channel().remoteAddress();
                    }
                }
            }
            if (this.channelType == ChannelType.TCP) {
                this.logger.debug("Initiating Fake TCP 3-Way Handshake");
                ByteBuf buffer2 = alloc.buffer();
                try {
                    int port = this.initiatiorAddr.getPort();
                    int port2 = this.handlerAddr.getPort();
                    TCPPacket.TCPFlag tCPFlag = TCPPacket.TCPFlag.SYN;
                    TCPPacket.writePacket(buffer2, (ByteBuf) null, 0, 0, port, port2, tCPFlag);
                    completeTCPWrite(this.initiatiorAddr, this.handlerAddr, buffer2, alloc, channelHandlerContext);
                    int port3 = this.handlerAddr.getPort();
                    int port4 = this.initiatiorAddr.getPort();
                    TCPPacket.TCPFlag tCPFlag2 = TCPPacket.TCPFlag.ACK;
                    TCPPacket.writePacket(buffer2, (ByteBuf) null, 0, 1, port3, port4, tCPFlag, tCPFlag2);
                    completeTCPWrite(this.handlerAddr, this.initiatiorAddr, buffer2, alloc, channelHandlerContext);
                    ByteBuf byteBuf = buffer2;
                    TCPPacket.writePacket(byteBuf, (ByteBuf) null, 1, 1, this.initiatiorAddr.getPort(), this.handlerAddr.getPort(), tCPFlag2);
                    completeTCPWrite(this.initiatiorAddr, this.handlerAddr, buffer2, alloc, channelHandlerContext);
                    buffer2.release();
                    this.logger.debug("Finished Fake TCP 3-Way Handshake");
                } catch (Throwable th2) {
                    buffer2.release();
                    throw th2;
                }
            }
            this.initialized = true;
        }
    }

    private void logDiscard() {
        this.logger.warn("Discarding pcap write because channel type is unknown. The channel this handler is registered on is not a SocketChannel or DatagramChannel, so the inference does not work. Please call forceTcpChannel or forceUdpChannel before registering the handler.");
    }

    private void logTCP(boolean z, int i, int i2, int i3, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, boolean z2) {
        if (!this.logger.isDebugEnabled()) {
            return;
        }
        if (z2) {
            this.logger.debug("Writing TCP ACK, isWriteOperation {}, Segment Number {}, Ack Number {}, Src Addr {}, Dst Addr {}", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), inetSocketAddress2, inetSocketAddress);
        } else {
            this.logger.debug("Writing TCP Data of {} Bytes, isWriteOperation {}, Segment Number {}, Ack Number {}, Src Addr {}, Dst Addr {}", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), inetSocketAddress, inetSocketAddress2);
        }
    }

    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        initializeIfNecessary(channelHandlerContext);
        super.channelActive(channelHandlerContext);
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (!this.isClosed) {
            initializeIfNecessary(channelHandlerContext);
            ChannelType channelType2 = this.channelType;
            if (channelType2 == ChannelType.TCP) {
                handleTCP(channelHandlerContext, obj, false);
            } else if (channelType2 == ChannelType.UDP) {
                handleUDP(channelHandlerContext, obj);
            } else {
                logDiscard();
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    public void close() throws IOException {
        if (this.isClosed) {
            this.logger.debug("PcapWriterHandler is already closed");
            return;
        }
        this.isClosed = true;
        this.pCapWriter.close();
        this.logger.debug("PcapWriterHandler is now closed");
    }

    /* JADX INFO: finally extract failed */
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (this.channelType == ChannelType.TCP) {
            ByteBuf buffer = channelHandlerContext.alloc().buffer();
            try {
                TCPPacket.writePacket(buffer, (ByteBuf) null, this.sendSegmentNumber, this.receiveSegmentNumber, this.initiatiorAddr.getPort(), this.handlerAddr.getPort(), TCPPacket.TCPFlag.RST, TCPPacket.TCPFlag.ACK);
                completeTCPWrite(this.initiatiorAddr, this.handlerAddr, buffer, channelHandlerContext.alloc(), channelHandlerContext);
                buffer.release();
                this.logger.debug("Sent Fake TCP RST to close connection");
            } catch (Throwable th2) {
                buffer.release();
                throw th2;
            }
        }
        close();
        channelHandlerContext.fireExceptionCaught(th);
    }

    /* JADX INFO: finally extract failed */
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.channelType == ChannelType.TCP) {
            this.logger.debug("Starting Fake TCP FIN+ACK Flow to close connection");
            ByteBufAllocator alloc = channelHandlerContext.alloc();
            ByteBuf buffer = alloc.buffer();
            try {
                int i = this.sendSegmentNumber;
                int i2 = this.receiveSegmentNumber;
                int port = this.initiatiorAddr.getPort();
                int port2 = this.handlerAddr.getPort();
                TCPPacket.TCPFlag tCPFlag = TCPPacket.TCPFlag.FIN;
                TCPPacket.TCPFlag tCPFlag2 = TCPPacket.TCPFlag.ACK;
                TCPPacket.writePacket(buffer, (ByteBuf) null, i, i2, port, port2, tCPFlag, tCPFlag2);
                completeTCPWrite(this.initiatiorAddr, this.handlerAddr, buffer, alloc, channelHandlerContext);
                TCPPacket.writePacket(buffer, (ByteBuf) null, this.receiveSegmentNumber, this.sendSegmentNumber, this.handlerAddr.getPort(), this.initiatiorAddr.getPort(), tCPFlag, tCPFlag2);
                completeTCPWrite(this.handlerAddr, this.initiatiorAddr, buffer, alloc, channelHandlerContext);
                TCPPacket.writePacket(buffer, (ByteBuf) null, this.sendSegmentNumber + 1, this.receiveSegmentNumber + 1, this.initiatiorAddr.getPort(), this.handlerAddr.getPort(), tCPFlag2);
                completeTCPWrite(this.initiatiorAddr, this.handlerAddr, buffer, alloc, channelHandlerContext);
                buffer.release();
                this.logger.debug("Finished Fake TCP FIN+ACK Flow to close connection");
            } catch (Throwable th) {
                buffer.release();
                throw th;
            }
        }
        close();
        super.handlerRemoved(channelHandlerContext);
    }

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (!this.isClosed) {
            initializeIfNecessary(channelHandlerContext);
            ChannelType channelType2 = this.channelType;
            if (channelType2 == ChannelType.TCP) {
                handleTCP(channelHandlerContext, obj, true);
            } else if (channelType2 == ChannelType.UDP) {
                handleUDP(channelHandlerContext, obj);
            } else {
                logDiscard();
            }
        }
        super.write(channelHandlerContext, obj, channelPromise);
    }

    @Deprecated
    public PcapWriteHandler(OutputStream outputStream2) {
        this(outputStream2, false, true);
    }

    @Deprecated
    public PcapWriteHandler(OutputStream outputStream2, boolean z, boolean z2) {
        this.logger = InternalLoggerFactory.getInstance((Class<?>) PcapWriteHandler.class);
        this.sendSegmentNumber = 1;
        this.receiveSegmentNumber = 1;
        this.outputStream = (OutputStream) ObjectUtil.checkNotNull(outputStream2, "OutputStream");
        this.captureZeroByte = z;
        this.writePcapGlobalHeader = z2;
    }

    private PcapWriteHandler(Builder builder, OutputStream outputStream2) {
        this.logger = InternalLoggerFactory.getInstance((Class<?>) PcapWriteHandler.class);
        this.sendSegmentNumber = 1;
        this.receiveSegmentNumber = 1;
        this.outputStream = outputStream2;
        this.captureZeroByte = builder.captureZeroByte;
        this.writePcapGlobalHeader = builder.writePcapGlobalHeader;
        this.channelType = builder.channelType;
        this.handlerAddr = builder.handlerAddr;
        this.initiatiorAddr = builder.initiatiorAddr;
        this.isServerPipeline = builder.isServerPipeline;
    }
}
