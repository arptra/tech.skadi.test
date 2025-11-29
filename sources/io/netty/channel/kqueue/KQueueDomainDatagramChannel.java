package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import io.netty.channel.unix.DomainDatagramChannel;
import io.netty.channel.unix.DomainDatagramPacket;
import io.netty.channel.unix.DomainSocketAddress;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.net.SocketAddress;
import kotlin.text.Typography;

public final class KQueueDomainDatagramChannel extends AbstractKQueueDatagramChannel implements DomainDatagramChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String EXPECTED_TYPES;
    private final KQueueDomainDatagramChannelConfig config;
    private volatile boolean connected;
    private volatile DomainSocketAddress local;
    private volatile DomainSocketAddress remote;

    public final class KQueueDomainDatagramChannelUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public KQueueDomainDatagramChannelUnsafe() {
            super();
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x00df A[SYNTHETIC, Splitter:B:34:0x00df] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00ed A[Catch:{ all -> 0x00e3 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle r12) {
            /*
                r11 = this;
                io.netty.channel.kqueue.KQueueDomainDatagramChannel r0 = io.netty.channel.kqueue.KQueueDomainDatagramChannel.this
                io.netty.channel.kqueue.KQueueDomainDatagramChannelConfig r0 = r0.config()
                io.netty.channel.kqueue.KQueueDomainDatagramChannel r1 = io.netty.channel.kqueue.KQueueDomainDatagramChannel.this
                boolean r1 = r1.shouldBreakReadReady(r0)
                if (r1 == 0) goto L_0x0012
                r11.clearReadFilter0()
                return
            L_0x0012:
                io.netty.channel.kqueue.KQueueDomainDatagramChannel r1 = io.netty.channel.kqueue.KQueueDomainDatagramChannel.this
                io.netty.channel.ChannelPipeline r1 = r1.pipeline()
                io.netty.buffer.ByteBufAllocator r2 = r0.getAllocator()
                r12.reset(r0)
                r11.readReadyBefore()
                r3 = 0
                io.netty.channel.kqueue.KQueueDomainDatagramChannel r4 = io.netty.channel.kqueue.KQueueDomainDatagramChannel.this     // Catch:{ all -> 0x00d9 }
                boolean r4 = r4.isConnected()     // Catch:{ all -> 0x00d9 }
            L_0x0029:
                io.netty.buffer.ByteBuf r5 = r12.allocate(r2)     // Catch:{ all -> 0x00d9 }
                int r6 = r5.writableBytes()     // Catch:{ all -> 0x004a }
                r12.attemptedBytesRead(r6)     // Catch:{ all -> 0x004a }
                if (r4 == 0) goto L_0x0060
                io.netty.channel.kqueue.KQueueDomainDatagramChannel r6 = io.netty.channel.kqueue.KQueueDomainDatagramChannel.this     // Catch:{ all -> 0x004a }
                int r6 = r6.doReadBytes(r5)     // Catch:{ all -> 0x004a }
                r12.lastBytesRead(r6)     // Catch:{ all -> 0x004a }
                int r6 = r12.lastBytesRead()     // Catch:{ all -> 0x004a }
                if (r6 > 0) goto L_0x004e
                r5.release()     // Catch:{ all -> 0x004a }
                goto L_0x00e5
            L_0x004a:
                r2 = move-exception
            L_0x004b:
                r3 = r2
                goto L_0x00dd
            L_0x004e:
                io.netty.channel.unix.DomainDatagramPacket r6 = new io.netty.channel.unix.DomainDatagramPacket     // Catch:{ all -> 0x004a }
                java.net.SocketAddress r7 = r11.localAddress()     // Catch:{ all -> 0x004a }
                io.netty.channel.unix.DomainSocketAddress r7 = (io.netty.channel.unix.DomainSocketAddress) r7     // Catch:{ all -> 0x004a }
                java.net.SocketAddress r8 = r11.remoteAddress()     // Catch:{ all -> 0x004a }
                io.netty.channel.unix.DomainSocketAddress r8 = (io.netty.channel.unix.DomainSocketAddress) r8     // Catch:{ all -> 0x004a }
                r6.<init>(r5, r7, r8)     // Catch:{ all -> 0x004a }
                goto L_0x00c6
            L_0x0060:
                boolean r6 = r5.hasMemoryAddress()     // Catch:{ all -> 0x004a }
                if (r6 == 0) goto L_0x007b
                io.netty.channel.kqueue.KQueueDomainDatagramChannel r6 = io.netty.channel.kqueue.KQueueDomainDatagramChannel.this     // Catch:{ all -> 0x004a }
                io.netty.channel.kqueue.BsdSocket r6 = r6.socket     // Catch:{ all -> 0x004a }
                long r7 = r5.memoryAddress()     // Catch:{ all -> 0x004a }
                int r9 = r5.writerIndex()     // Catch:{ all -> 0x004a }
                int r10 = r5.capacity()     // Catch:{ all -> 0x004a }
                io.netty.channel.unix.DomainDatagramSocketAddress r6 = r6.recvFromAddressDomainSocket(r7, r9, r10)     // Catch:{ all -> 0x004a }
                goto L_0x0097
            L_0x007b:
                int r6 = r5.writerIndex()     // Catch:{ all -> 0x004a }
                int r7 = r5.writableBytes()     // Catch:{ all -> 0x004a }
                java.nio.ByteBuffer r6 = r5.internalNioBuffer(r6, r7)     // Catch:{ all -> 0x004a }
                io.netty.channel.kqueue.KQueueDomainDatagramChannel r7 = io.netty.channel.kqueue.KQueueDomainDatagramChannel.this     // Catch:{ all -> 0x004a }
                io.netty.channel.kqueue.BsdSocket r7 = r7.socket     // Catch:{ all -> 0x004a }
                int r8 = r6.position()     // Catch:{ all -> 0x004a }
                int r9 = r6.limit()     // Catch:{ all -> 0x004a }
                io.netty.channel.unix.DomainDatagramSocketAddress r6 = r7.recvFromDomainSocket(r6, r8, r9)     // Catch:{ all -> 0x004a }
            L_0x0097:
                if (r6 != 0) goto L_0x00a1
                r2 = -1
                r12.lastBytesRead(r2)     // Catch:{ all -> 0x004a }
                r5.release()     // Catch:{ all -> 0x004a }
                goto L_0x00e5
            L_0x00a1:
                io.netty.channel.unix.DomainDatagramSocketAddress r7 = r6.localAddress()     // Catch:{ all -> 0x004a }
                if (r7 != 0) goto L_0x00ad
                java.net.SocketAddress r7 = r11.localAddress()     // Catch:{ all -> 0x004a }
                io.netty.channel.unix.DomainSocketAddress r7 = (io.netty.channel.unix.DomainSocketAddress) r7     // Catch:{ all -> 0x004a }
            L_0x00ad:
                int r8 = r6.receivedAmount()     // Catch:{ all -> 0x004a }
                r12.lastBytesRead(r8)     // Catch:{ all -> 0x004a }
                int r8 = r5.writerIndex()     // Catch:{ all -> 0x004a }
                int r9 = r12.lastBytesRead()     // Catch:{ all -> 0x004a }
                int r8 = r8 + r9
                r5.writerIndex(r8)     // Catch:{ all -> 0x004a }
                io.netty.channel.unix.DomainDatagramPacket r8 = new io.netty.channel.unix.DomainDatagramPacket     // Catch:{ all -> 0x004a }
                r8.<init>(r5, r7, r6)     // Catch:{ all -> 0x004a }
                r6 = r8
            L_0x00c6:
                r7 = 1
                r12.incMessagesRead(r7)     // Catch:{ all -> 0x004a }
                r7 = 0
                r11.readPending = r7     // Catch:{ all -> 0x004a }
                r1.fireChannelRead(r6)     // Catch:{ all -> 0x004a }
                io.netty.util.UncheckedBooleanSupplier r5 = io.netty.util.UncheckedBooleanSupplier.TRUE_SUPPLIER     // Catch:{ all -> 0x00d9 }
                boolean r5 = r12.continueReading(r5)     // Catch:{ all -> 0x00d9 }
                if (r5 != 0) goto L_0x0029
                goto L_0x00e5
            L_0x00d9:
                r2 = move-exception
                r5 = r3
                goto L_0x004b
            L_0x00dd:
                if (r5 == 0) goto L_0x00e5
                r5.release()     // Catch:{ all -> 0x00e3 }
                goto L_0x00e5
            L_0x00e3:
                r12 = move-exception
                goto L_0x00f4
            L_0x00e5:
                r12.readComplete()     // Catch:{ all -> 0x00e3 }
                r1.fireChannelReadComplete()     // Catch:{ all -> 0x00e3 }
                if (r3 == 0) goto L_0x00f0
                r1.fireExceptionCaught(r3)     // Catch:{ all -> 0x00e3 }
            L_0x00f0:
                r11.readReadyFinally(r0)
                return
            L_0x00f4:
                r11.readReadyFinally(r0)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.KQueueDomainDatagramChannel.KQueueDomainDatagramChannelUnsafe.readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle):void");
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(" (expected: ");
        sb.append(StringUtil.simpleClassName((Class<?>) DomainDatagramPacket.class));
        sb.append(", ");
        sb.append(StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class));
        sb.append(Typography.less);
        Class<ByteBuf> cls = ByteBuf.class;
        sb.append(StringUtil.simpleClassName((Class<?>) cls));
        sb.append(", ");
        sb.append(StringUtil.simpleClassName((Class<?>) DomainSocketAddress.class));
        sb.append(">, ");
        sb.append(StringUtil.simpleClassName((Class<?>) cls));
        sb.append(')');
        EXPECTED_TYPES = sb.toString();
    }

    public KQueueDomainDatagramChannel() {
        this(BsdSocket.newSocketDomainDgram(), false);
    }

    public void doBind(SocketAddress socketAddress) throws Exception {
        super.doBind(socketAddress);
        this.local = (DomainSocketAddress) socketAddress;
        this.active = true;
    }

    public void doClose() throws Exception {
        super.doClose();
        this.active = false;
        this.connected = false;
        this.local = null;
        this.remote = null;
    }

    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (!super.doConnect(socketAddress, socketAddress2)) {
            return false;
        }
        if (socketAddress2 != null) {
            this.local = (DomainSocketAddress) socketAddress2;
        }
        this.remote = (DomainSocketAddress) socketAddress;
        this.connected = true;
        return true;
    }

    public void doDisconnect() throws Exception {
        doClose();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean doWriteMessage(java.lang.Object r11) throws java.lang.Exception {
        /*
            r10 = this;
            boolean r0 = r11 instanceof io.netty.channel.AddressedEnvelope
            if (r0 == 0) goto L_0x0013
            io.netty.channel.AddressedEnvelope r11 = (io.netty.channel.AddressedEnvelope) r11
            java.lang.Object r0 = r11.content()
            io.netty.buffer.ByteBuf r0 = (io.netty.buffer.ByteBuf) r0
            java.net.SocketAddress r11 = r11.recipient()
            io.netty.channel.unix.DomainSocketAddress r11 = (io.netty.channel.unix.DomainSocketAddress) r11
            goto L_0x0017
        L_0x0013:
            r0 = r11
            io.netty.buffer.ByteBuf r0 = (io.netty.buffer.ByteBuf) r0
            r11 = 0
        L_0x0017:
            int r1 = r0.readableBytes()
            r2 = 1
            if (r1 != 0) goto L_0x001f
            return r2
        L_0x001f:
            boolean r1 = r0.hasMemoryAddress()
            r3 = 0
            if (r1 == 0) goto L_0x0055
            long r5 = r0.memoryAddress()
            if (r11 != 0) goto L_0x003c
            io.netty.channel.kqueue.BsdSocket r10 = r10.socket
            int r11 = r0.readerIndex()
            int r0 = r0.writerIndex()
            int r10 = r10.writeAddress(r5, r11, r0)
            goto L_0x00b2
        L_0x003c:
            io.netty.channel.kqueue.BsdSocket r4 = r10.socket
            int r7 = r0.readerIndex()
            int r8 = r0.writerIndex()
            java.lang.String r10 = r11.path()
            java.nio.charset.Charset r11 = io.netty.util.CharsetUtil.UTF_8
            byte[] r9 = r10.getBytes(r11)
            int r10 = r4.sendToAddressDomainSocket(r5, r7, r8, r9)
            goto L_0x00b2
        L_0x0055:
            int r1 = r0.nioBufferCount()
            if (r1 <= r2) goto L_0x0096
            io.netty.channel.EventLoop r1 = r10.eventLoop()
            io.netty.channel.kqueue.KQueueEventLoop r1 = (io.netty.channel.kqueue.KQueueEventLoop) r1
            io.netty.channel.unix.IovArray r1 = r1.cleanArray()
            int r4 = r0.readerIndex()
            int r5 = r0.readableBytes()
            r1.add((io.netty.buffer.ByteBuf) r0, (int) r4, (int) r5)
            int r0 = r1.count()
            if (r11 != 0) goto L_0x0081
            io.netty.channel.kqueue.BsdSocket r10 = r10.socket
            long r4 = r1.memoryAddress(r3)
            long r10 = r10.writevAddresses(r4, r0)
            goto L_0x00cd
        L_0x0081:
            io.netty.channel.kqueue.BsdSocket r10 = r10.socket
            long r4 = r1.memoryAddress(r3)
            java.lang.String r11 = r11.path()
            java.nio.charset.Charset r1 = io.netty.util.CharsetUtil.UTF_8
            byte[] r11 = r11.getBytes(r1)
            int r10 = r10.sendToAddressesDomainSocket(r4, r0, r11)
            goto L_0x00b2
        L_0x0096:
            int r1 = r0.readerIndex()
            int r4 = r0.readableBytes()
            java.nio.ByteBuffer r0 = r0.internalNioBuffer(r1, r4)
            if (r11 != 0) goto L_0x00b4
            io.netty.channel.kqueue.BsdSocket r10 = r10.socket
            int r11 = r0.position()
            int r1 = r0.limit()
            int r10 = r10.write(r0, r11, r1)
        L_0x00b2:
            long r10 = (long) r10
            goto L_0x00cd
        L_0x00b4:
            io.netty.channel.kqueue.BsdSocket r10 = r10.socket
            int r1 = r0.position()
            int r4 = r0.limit()
            java.lang.String r11 = r11.path()
            java.nio.charset.Charset r5 = io.netty.util.CharsetUtil.UTF_8
            byte[] r11 = r11.getBytes(r5)
            int r10 = r10.sendToDomainSocket(r0, r1, r4, r11)
            goto L_0x00b2
        L_0x00cd:
            r0 = 0
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 <= 0) goto L_0x00d4
            goto L_0x00d5
        L_0x00d4:
            r2 = r3
        L_0x00d5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.KQueueDomainDatagramChannel.doWriteMessage(java.lang.Object):boolean");
    }

    public Object filterOutboundMessage(Object obj) {
        if (obj instanceof DomainDatagramPacket) {
            DomainDatagramPacket domainDatagramPacket = (DomainDatagramPacket) obj;
            ByteBuf byteBuf = (ByteBuf) domainDatagramPacket.content();
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf) ? new DomainDatagramPacket(newDirectBuffer(domainDatagramPacket, byteBuf), (DomainSocketAddress) domainDatagramPacket.recipient()) : obj;
        } else if (obj instanceof ByteBuf) {
            ByteBuf byteBuf2 = (ByteBuf) obj;
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf2) ? newDirectBuffer(byteBuf2) : byteBuf2;
        } else {
            if (obj instanceof AddressedEnvelope) {
                AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
                if ((addressedEnvelope.content() instanceof ByteBuf) && (addressedEnvelope.recipient() == null || (addressedEnvelope.recipient() instanceof DomainSocketAddress))) {
                    ByteBuf byteBuf3 = (ByteBuf) addressedEnvelope.content();
                    return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf3) ? new DefaultAddressedEnvelope(newDirectBuffer(addressedEnvelope, byteBuf3), (DomainSocketAddress) addressedEnvelope.recipient()) : addressedEnvelope;
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

    public /* bridge */ /* synthetic */ ChannelMetadata metadata() {
        return super.metadata();
    }

    public PeerCredentials peerCredentials() throws IOException {
        return this.socket.getPeerCredentials();
    }

    public KQueueDomainDatagramChannel(int i) {
        this(new BsdSocket(i), true);
    }

    public DomainSocketAddress localAddress() {
        return (DomainSocketAddress) super.localAddress();
    }

    public DomainSocketAddress localAddress0() {
        return this.local;
    }

    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueDomainDatagramChannelUnsafe();
    }

    public DomainSocketAddress remoteAddress() {
        return (DomainSocketAddress) super.remoteAddress();
    }

    public DomainSocketAddress remoteAddress0() {
        return this.remote;
    }

    private KQueueDomainDatagramChannel(BsdSocket bsdSocket, boolean z) {
        super((Channel) null, bsdSocket, z);
        this.config = new KQueueDomainDatagramChannelConfig(this);
    }

    public KQueueDomainDatagramChannelConfig config() {
        return this.config;
    }
}
