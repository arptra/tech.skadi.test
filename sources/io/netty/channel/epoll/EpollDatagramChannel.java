package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.epoll.NativeDatagramPacketArray;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.SegmentedDatagramPacket;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import kotlin.text.Typography;

public final class EpollDatagramChannel extends AbstractEpollChannel implements DatagramChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String EXPECTED_TYPES;
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private final EpollDatagramChannelConfig config;
    private volatile boolean connected;

    public final class EpollDatagramChannelUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public EpollDatagramChannelUnsafe() {
            super();
        }

        public void epollInReady() {
            boolean isConnected;
            boolean z;
            EpollDatagramChannelConfig config = EpollDatagramChannel.this.config();
            if (EpollDatagramChannel.this.shouldBreakEpollInReady(config)) {
                clearEpollIn0();
                return;
            }
            EpollRecvByteAllocatorHandle recvBufAllocHandle = recvBufAllocHandle();
            recvBufAllocHandle.edgeTriggered(EpollDatagramChannel.this.isFlagSet(Native.EPOLLET));
            ChannelPipeline pipeline = EpollDatagramChannel.this.pipeline();
            ByteBufAllocator allocator = config.getAllocator();
            recvBufAllocHandle.reset(config);
            epollInBefore();
            try {
                isConnected = EpollDatagramChannel.this.isConnected();
                do {
                    int maxDatagramPayloadSize = EpollDatagramChannel.this.config().getMaxDatagramPayloadSize();
                    ByteBuf allocate = recvBufAllocHandle.allocate(allocator);
                    int writableBytes = Native.IS_SUPPORTING_RECVMMSG ? maxDatagramPayloadSize == 0 ? 1 : allocate.writableBytes() / maxDatagramPayloadSize : 0;
                    if (writableBytes <= 1) {
                        if (isConnected) {
                            if (!config.isUdpGro()) {
                                z = EpollDatagramChannel.this.connectedRead(recvBufAllocHandle, allocate, maxDatagramPayloadSize);
                            }
                        }
                        EpollDatagramChannel epollDatagramChannel = EpollDatagramChannel.this;
                        z = epollDatagramChannel.recvmsg(recvBufAllocHandle, epollDatagramChannel.cleanDatagramPacketArray(), allocate);
                    } else {
                        EpollDatagramChannel epollDatagramChannel2 = EpollDatagramChannel.this;
                        z = epollDatagramChannel2.scatteringRead(recvBufAllocHandle, epollDatagramChannel2.cleanDatagramPacketArray(), allocate, maxDatagramPayloadSize, writableBytes);
                    }
                    if (!z) {
                        break;
                    }
                    this.readPending = false;
                } while (recvBufAllocHandle.continueReading(UncheckedBooleanSupplier.TRUE_SUPPLIER));
                th = null;
            } catch (Errors.NativeIoException e) {
                if (isConnected) {
                    throw EpollDatagramChannel.this.translateForConnected(e);
                }
                throw e;
            } catch (Throwable th) {
                th = th;
            }
            try {
                recvBufAllocHandle.readComplete();
                pipeline.fireChannelReadComplete();
                if (th != null) {
                    pipeline.fireExceptionCaught(th);
                }
            } finally {
                epollInFinally(config);
            }
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(" (expected: ");
        sb.append(StringUtil.simpleClassName((Class<?>) DatagramPacket.class));
        sb.append(", ");
        sb.append(StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class));
        sb.append(Typography.less);
        Class<ByteBuf> cls = ByteBuf.class;
        sb.append(StringUtil.simpleClassName((Class<?>) cls));
        sb.append(", ");
        sb.append(StringUtil.simpleClassName((Class<?>) InetSocketAddress.class));
        sb.append(">, ");
        sb.append(StringUtil.simpleClassName((Class<?>) cls));
        sb.append(')');
        EXPECTED_TYPES = sb.toString();
    }

    public EpollDatagramChannel() {
        this((InternetProtocolFamily) null);
    }

    private static void addDatagramPacketToOut(DatagramPacket datagramPacket, RecyclableArrayList recyclableArrayList) {
        if (datagramPacket instanceof SegmentedDatagramPacket) {
            SegmentedDatagramPacket segmentedDatagramPacket = (SegmentedDatagramPacket) datagramPacket;
            ByteBuf byteBuf = (ByteBuf) segmentedDatagramPacket.content();
            InetSocketAddress inetSocketAddress = (InetSocketAddress) segmentedDatagramPacket.recipient();
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) segmentedDatagramPacket.sender();
            int segmentSize = segmentedDatagramPacket.segmentSize();
            do {
                recyclableArrayList.add(new DatagramPacket(byteBuf.readRetainedSlice(Math.min(byteBuf.readableBytes(), segmentSize)), inetSocketAddress, inetSocketAddress2));
            } while (byteBuf.isReadable());
            segmentedDatagramPacket.release();
            return;
        }
        recyclableArrayList.add(datagramPacket);
    }

    /* access modifiers changed from: private */
    public NativeDatagramPacketArray cleanDatagramPacketArray() {
        return ((EpollEventLoop) eventLoop()).cleanDatagramPacketArray();
    }

    /* access modifiers changed from: private */
    public boolean connectedRead(EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle, ByteBuf byteBuf, int i) throws Exception {
        int i2;
        int i3;
        if (i != 0) {
            try {
                i2 = Math.min(byteBuf.writableBytes(), i);
            } catch (Throwable th) {
                if (byteBuf != null) {
                    byteBuf.release();
                }
                throw th;
            }
        } else {
            i2 = byteBuf.writableBytes();
        }
        epollRecvByteAllocatorHandle.attemptedBytesRead(i2);
        int writerIndex = byteBuf.writerIndex();
        if (byteBuf.hasMemoryAddress()) {
            i3 = this.socket.recvAddress(byteBuf.memoryAddress(), writerIndex, writerIndex + i2);
        } else {
            ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(writerIndex, i2);
            i3 = this.socket.recv(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit());
        }
        if (i3 <= 0) {
            epollRecvByteAllocatorHandle.lastBytesRead(i3);
            byteBuf.release();
            return false;
        }
        byteBuf.writerIndex(writerIndex + i3);
        if (i <= 0) {
            i2 = i3;
        }
        epollRecvByteAllocatorHandle.lastBytesRead(i2);
        DatagramPacket datagramPacket = new DatagramPacket(byteBuf, localAddress(), remoteAddress());
        epollRecvByteAllocatorHandle.incMessagesRead(1);
        pipeline().fireChannelRead(datagramPacket);
        return true;
    }

    private boolean doWriteMessage(Object obj) throws Exception {
        InetSocketAddress inetSocketAddress;
        ByteBuf byteBuf;
        if (obj instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            byteBuf = (ByteBuf) addressedEnvelope.content();
            inetSocketAddress = (InetSocketAddress) addressedEnvelope.recipient();
        } else {
            byteBuf = (ByteBuf) obj;
            inetSocketAddress = null;
        }
        return byteBuf.readableBytes() == 0 || doWriteOrSendBytes(byteBuf, inetSocketAddress, false) > 0;
    }

    public static boolean isSegmentedDatagramPacketSupported() {
        return Epoll.isAvailable() && Native.IS_SUPPORTING_SENDMMSG && Native.IS_SUPPORTING_UDP_SEGMENT;
    }

    /* access modifiers changed from: private */
    public void joinGroup0(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        try {
            this.socket.joinGroup(inetAddress, networkInterface, inetAddress2);
            channelPromise.setSuccess();
        } catch (IOException e) {
            channelPromise.setFailure(e);
        }
    }

    /* access modifiers changed from: private */
    public void leaveGroup0(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        try {
            this.socket.leaveGroup(inetAddress, networkInterface, inetAddress2);
            channelPromise.setSuccess();
        } catch (IOException e) {
            channelPromise.setFailure(e);
        }
    }

    private static void processPacket(ChannelPipeline channelPipeline, EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle, int i, DatagramPacket datagramPacket) {
        epollRecvByteAllocatorHandle.lastBytesRead(Math.max(1, i));
        epollRecvByteAllocatorHandle.incMessagesRead(1);
        channelPipeline.fireChannelRead(datagramPacket);
    }

    private static void processPacketList(ChannelPipeline channelPipeline, EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle, int i, RecyclableArrayList recyclableArrayList) {
        int size = recyclableArrayList.size();
        epollRecvByteAllocatorHandle.lastBytesRead(Math.max(1, i));
        epollRecvByteAllocatorHandle.incMessagesRead(size);
        for (int i2 = 0; i2 < size; i2++) {
            channelPipeline.fireChannelRead(recyclableArrayList.set(i2, Unpooled.EMPTY_BUFFER));
        }
    }

    /* access modifiers changed from: private */
    public boolean recvmsg(EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle, NativeDatagramPacketArray nativeDatagramPacketArray, ByteBuf byteBuf) throws IOException {
        RecyclableArrayList recyclableArrayList = null;
        try {
            int writableBytes = byteBuf.writableBytes();
            nativeDatagramPacketArray.addWritable(byteBuf, byteBuf.writerIndex(), writableBytes);
            epollRecvByteAllocatorHandle.attemptedBytesRead(writableBytes);
            NativeDatagramPacketArray.NativeDatagramPacket nativeDatagramPacket = nativeDatagramPacketArray.packets()[0];
            int recvmsg = this.socket.recvmsg(nativeDatagramPacket);
            if (!nativeDatagramPacket.hasSender()) {
                epollRecvByteAllocatorHandle.lastBytesRead(-1);
                releaseAndRecycle(byteBuf, (RecyclableArrayList) null);
                return false;
            }
            byteBuf.writerIndex(recvmsg);
            DatagramPacket newDatagramPacket = nativeDatagramPacket.newDatagramPacket(byteBuf, localAddress());
            if (!(newDatagramPacket instanceof SegmentedDatagramPacket)) {
                processPacket(pipeline(), epollRecvByteAllocatorHandle, recvmsg, newDatagramPacket);
            } else {
                RecyclableArrayList newInstance = RecyclableArrayList.newInstance();
                try {
                    addDatagramPacketToOut(newDatagramPacket, newInstance);
                } catch (Throwable th) {
                    th = th;
                    recyclableArrayList = newInstance;
                    releaseAndRecycle(byteBuf, recyclableArrayList);
                    throw th;
                }
                try {
                    processPacketList(pipeline(), epollRecvByteAllocatorHandle, recvmsg, newInstance);
                    newInstance.recycle();
                } catch (Throwable th2) {
                    th = th2;
                    byteBuf = null;
                    recyclableArrayList = newInstance;
                    releaseAndRecycle(byteBuf, recyclableArrayList);
                    throw th;
                }
            }
            releaseAndRecycle((ByteBuf) null, (RecyclableArrayList) null);
            return true;
        } catch (Throwable th3) {
            th = th3;
            releaseAndRecycle(byteBuf, recyclableArrayList);
            throw th;
        }
    }

    private static void releaseAndRecycle(ByteBuf byteBuf, RecyclableArrayList recyclableArrayList) {
        if (byteBuf != null) {
            byteBuf.release();
        }
        if (recyclableArrayList != null) {
            for (int i = 0; i < recyclableArrayList.size(); i++) {
                ReferenceCountUtil.release(recyclableArrayList.get(i));
            }
            recyclableArrayList.recycle();
        }
    }

    /* access modifiers changed from: private */
    public boolean scatteringRead(EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle, NativeDatagramPacketArray nativeDatagramPacketArray, ByteBuf byteBuf, int i, int i2) throws IOException {
        RecyclableArrayList recyclableArrayList = null;
        try {
            int writerIndex = byteBuf.writerIndex();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= i2) {
                    break;
                } else if (!nativeDatagramPacketArray.addWritable(byteBuf, writerIndex, i)) {
                    break;
                } else {
                    i4++;
                    writerIndex += i;
                }
            }
            epollRecvByteAllocatorHandle.attemptedBytesRead(writerIndex - byteBuf.writerIndex());
            NativeDatagramPacketArray.NativeDatagramPacket[] packets = nativeDatagramPacketArray.packets();
            int recvmmsg = this.socket.recvmmsg(packets, 0, nativeDatagramPacketArray.count());
            if (recvmmsg == 0) {
                epollRecvByteAllocatorHandle.lastBytesRead(-1);
                releaseAndRecycle(byteBuf, (RecyclableArrayList) null);
                return false;
            }
            int i5 = recvmmsg * i;
            byteBuf.writerIndex(i5);
            InetSocketAddress localAddress = localAddress();
            if (recvmmsg == 1) {
                DatagramPacket newDatagramPacket = packets[0].newDatagramPacket(byteBuf, localAddress);
                if (!(newDatagramPacket instanceof SegmentedDatagramPacket)) {
                    processPacket(pipeline(), epollRecvByteAllocatorHandle, i, newDatagramPacket);
                    releaseAndRecycle((ByteBuf) null, (RecyclableArrayList) null);
                    return true;
                }
            }
            RecyclableArrayList newInstance = RecyclableArrayList.newInstance();
            while (i3 < recvmmsg) {
                try {
                    addDatagramPacketToOut(packets[i3].newDatagramPacket(byteBuf.readRetainedSlice(i), localAddress), newInstance);
                    i3++;
                } catch (Throwable th) {
                    th = th;
                    recyclableArrayList = newInstance;
                    releaseAndRecycle(byteBuf, recyclableArrayList);
                    throw th;
                }
            }
            byteBuf.release();
            try {
                processPacketList(pipeline(), epollRecvByteAllocatorHandle, i5, newInstance);
                newInstance.recycle();
                releaseAndRecycle((ByteBuf) null, (RecyclableArrayList) null);
                return true;
            } catch (Throwable th2) {
                th = th2;
                byteBuf = null;
                recyclableArrayList = newInstance;
                releaseAndRecycle(byteBuf, recyclableArrayList);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            releaseAndRecycle(byteBuf, recyclableArrayList);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public IOException translateForConnected(Errors.NativeIoException nativeIoException) {
        if (nativeIoException.expectedErr() != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return nativeIoException;
        }
        PortUnreachableException portUnreachableException = new PortUnreachableException(nativeIoException.getMessage());
        portUnreachableException.initCause(nativeIoException);
        return portUnreachableException;
    }

    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return block(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    public void doBind(SocketAddress socketAddress) throws Exception {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            if (inetSocketAddress.getAddress().isAnyLocalAddress() && (inetSocketAddress.getAddress() instanceof Inet4Address) && this.socket.family() == InternetProtocolFamily.IPv6) {
                socketAddress = new InetSocketAddress(LinuxSocket.INET6_ANY, inetSocketAddress.getPort());
            }
        }
        super.doBind(socketAddress);
        this.active = true;
    }

    public void doClose() throws Exception {
        super.doClose();
        this.connected = false;
    }

    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (!super.doConnect(socketAddress, socketAddress2)) {
            return false;
        }
        this.connected = true;
        return true;
    }

    public void doDisconnect() throws Exception {
        this.socket.disconnect();
        this.active = false;
        this.connected = false;
        resetCachedAddresses();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        if ((r6.current() instanceof io.netty.channel.unix.SegmentedDatagramPacket) != false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doWrite(io.netty.channel.ChannelOutboundBuffer r6) throws java.lang.Exception {
        /*
            r5 = this;
            int r0 = r5.maxMessagesPerWrite()
        L_0x0004:
            if (r0 <= 0) goto L_0x006b
            java.lang.Object r1 = r6.current()
            if (r1 != 0) goto L_0x000d
            goto L_0x006b
        L_0x000d:
            boolean r2 = io.netty.channel.epoll.Native.IS_SUPPORTING_SENDMMSG     // Catch:{ IOException -> 0x0019 }
            r3 = 1
            if (r2 == 0) goto L_0x001b
            int r2 = r6.size()     // Catch:{ IOException -> 0x0019 }
            if (r2 > r3) goto L_0x0023
            goto L_0x001b
        L_0x0019:
            r1 = move-exception
            goto L_0x0065
        L_0x001b:
            java.lang.Object r2 = r6.current()     // Catch:{ IOException -> 0x0019 }
            boolean r2 = r2 instanceof io.netty.channel.unix.SegmentedDatagramPacket     // Catch:{ IOException -> 0x0019 }
            if (r2 == 0) goto L_0x004c
        L_0x0023:
            io.netty.channel.epoll.NativeDatagramPacketArray r2 = r5.cleanDatagramPacketArray()     // Catch:{ IOException -> 0x0019 }
            boolean r4 = r5.isConnected()     // Catch:{ IOException -> 0x0019 }
            r2.add(r6, r4, r0)     // Catch:{ IOException -> 0x0019 }
            int r4 = r2.count()     // Catch:{ IOException -> 0x0019 }
            if (r4 < r3) goto L_0x004c
            io.netty.channel.epoll.NativeDatagramPacketArray$NativeDatagramPacket[] r1 = r2.packets()     // Catch:{ IOException -> 0x0019 }
            io.netty.channel.epoll.LinuxSocket r2 = r5.socket     // Catch:{ IOException -> 0x0019 }
            r3 = 0
            int r1 = r2.sendmmsg(r1, r3, r4)     // Catch:{ IOException -> 0x0019 }
            if (r1 != 0) goto L_0x0042
            goto L_0x006b
        L_0x0042:
            if (r3 >= r1) goto L_0x004a
            r6.remove()     // Catch:{ IOException -> 0x0019 }
            int r3 = r3 + 1
            goto L_0x0042
        L_0x004a:
            int r0 = r0 - r1
            goto L_0x0004
        L_0x004c:
            io.netty.channel.epoll.EpollDatagramChannelConfig r2 = r5.config()     // Catch:{ IOException -> 0x0019 }
            int r2 = r2.getWriteSpinCount()     // Catch:{ IOException -> 0x0019 }
        L_0x0054:
            if (r2 <= 0) goto L_0x006b
            boolean r3 = r5.doWriteMessage(r1)     // Catch:{ IOException -> 0x0019 }
            if (r3 == 0) goto L_0x0062
            r6.remove()     // Catch:{ IOException -> 0x0019 }
            int r0 = r0 + -1
            goto L_0x0004
        L_0x0062:
            int r2 = r2 + -1
            goto L_0x0054
        L_0x0065:
            int r0 = r0 + -1
            r6.remove(r1)
            goto L_0x0004
        L_0x006b:
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0077
            int r6 = io.netty.channel.epoll.Native.EPOLLOUT
            r5.clearFlag(r6)
            goto L_0x007c
        L_0x0077:
            int r6 = io.netty.channel.epoll.Native.EPOLLOUT
            r5.setFlag(r6)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.EpollDatagramChannel.doWrite(io.netty.channel.ChannelOutboundBuffer):void");
    }

    public Object filterOutboundMessage(Object obj) {
        if (obj instanceof SegmentedDatagramPacket) {
            if (Native.IS_SUPPORTING_UDP_SEGMENT) {
                SegmentedDatagramPacket segmentedDatagramPacket = (SegmentedDatagramPacket) obj;
                ByteBuf byteBuf = (ByteBuf) segmentedDatagramPacket.content();
                return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf) ? segmentedDatagramPacket.replace(newDirectBuffer(segmentedDatagramPacket, byteBuf)) : obj;
            }
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
        } else if (obj instanceof DatagramPacket) {
            DatagramPacket datagramPacket = (DatagramPacket) obj;
            ByteBuf byteBuf2 = (ByteBuf) datagramPacket.content();
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf2) ? new DatagramPacket(newDirectBuffer(datagramPacket, byteBuf2), (InetSocketAddress) datagramPacket.recipient()) : obj;
        } else if (obj instanceof ByteBuf) {
            ByteBuf byteBuf3 = (ByteBuf) obj;
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf3) ? newDirectBuffer(byteBuf3) : byteBuf3;
        } else {
            if (obj instanceof AddressedEnvelope) {
                AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
                if ((addressedEnvelope.content() instanceof ByteBuf) && (addressedEnvelope.recipient() == null || (addressedEnvelope.recipient() instanceof InetSocketAddress))) {
                    ByteBuf byteBuf4 = (ByteBuf) addressedEnvelope.content();
                    return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf4) ? new DefaultAddressedEnvelope(newDirectBuffer(addressedEnvelope, byteBuf4), (InetSocketAddress) addressedEnvelope.recipient()) : addressedEnvelope;
                }
            }
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
        }
    }

    public boolean isActive() {
        return this.socket.isOpen() && ((this.config.getActiveOnOpen() && isRegistered()) || this.active);
    }

    public boolean isConnected() {
        return this.connected;
    }

    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    public ChannelFuture joinGroup(InetAddress inetAddress) {
        return joinGroup(inetAddress, newPromise());
    }

    public ChannelFuture leaveGroup(InetAddress inetAddress) {
        return leaveGroup(inetAddress, newPromise());
    }

    public ChannelMetadata metadata() {
        return METADATA;
    }

    public EpollDatagramChannel(InternetProtocolFamily internetProtocolFamily) {
        this(LinuxSocket.newSocketDgram(internetProtocolFamily), false);
    }

    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(inetAddress, "multicastAddress");
        ObjectUtil.checkNotNull(inetAddress2, "sourceToBlock");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        channelPromise.setFailure(new UnsupportedOperationException("Multicast block not supported"));
        return channelPromise;
    }

    public ChannelFuture joinGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            NetworkInterface networkInterface = config().getNetworkInterface();
            if (networkInterface == null) {
                networkInterface = NetworkInterface.getByInetAddress(localAddress().getAddress());
            }
            return joinGroup(inetAddress, networkInterface, (InetAddress) null, channelPromise);
        } catch (IOException e) {
            channelPromise.setFailure(e);
            return channelPromise;
        }
    }

    public ChannelFuture leaveGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            return leaveGroup(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), (InetAddress) null, channelPromise);
        } catch (IOException e) {
            channelPromise.setFailure(e);
            return channelPromise;
        }
    }

    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollDatagramChannelUnsafe();
    }

    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public EpollDatagramChannel(int i) {
        this(new LinuxSocket(i), true);
    }

    private EpollDatagramChannel(LinuxSocket linuxSocket, boolean z) {
        super((Channel) null, linuxSocket, z);
        this.config = new EpollDatagramChannelConfig(this);
    }

    public EpollDatagramChannelConfig config() {
        return this.config;
    }

    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return leaveGroup(inetSocketAddress, networkInterface, newPromise());
    }

    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2) {
        return block(inetAddress, inetAddress2, newPromise());
    }

    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return joinGroup(inetSocketAddress, networkInterface, newPromise());
    }

    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        return leaveGroup(inetSocketAddress.getAddress(), networkInterface, (InetAddress) null, channelPromise);
    }

    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2, ChannelPromise channelPromise) {
        try {
            return block(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), inetAddress2, channelPromise);
        } catch (Throwable th) {
            channelPromise.setFailure(th);
            return channelPromise;
        }
    }

    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        return joinGroup(inetSocketAddress.getAddress(), networkInterface, (InetAddress) null, channelPromise);
    }

    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return leaveGroup(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return joinGroup(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(inetAddress, "multicastAddress");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        if (eventLoop().inEventLoop()) {
            leaveGroup0(inetAddress, networkInterface, inetAddress2, channelPromise);
        } else {
            final InetAddress inetAddress3 = inetAddress;
            final NetworkInterface networkInterface2 = networkInterface;
            final InetAddress inetAddress4 = inetAddress2;
            final ChannelPromise channelPromise2 = channelPromise;
            eventLoop().execute(new Runnable() {
                public void run() {
                    EpollDatagramChannel.this.leaveGroup0(inetAddress3, networkInterface2, inetAddress4, channelPromise2);
                }
            });
        }
        return channelPromise;
    }

    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(inetAddress, "multicastAddress");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        if (eventLoop().inEventLoop()) {
            joinGroup0(inetAddress, networkInterface, inetAddress2, channelPromise);
        } else {
            final InetAddress inetAddress3 = inetAddress;
            final NetworkInterface networkInterface2 = networkInterface;
            final InetAddress inetAddress4 = inetAddress2;
            final ChannelPromise channelPromise2 = channelPromise;
            eventLoop().execute(new Runnable() {
                public void run() {
                    EpollDatagramChannel.this.joinGroup0(inetAddress3, networkInterface2, inetAddress4, channelPromise2);
                }
            });
        }
        return channelPromise;
    }
}
