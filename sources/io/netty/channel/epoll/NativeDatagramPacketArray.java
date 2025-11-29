package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.Limits;
import io.netty.channel.unix.NativeInetAddress;
import io.netty.channel.unix.SegmentedDatagramPacket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

final class NativeDatagramPacketArray {
    private int count;
    private final IovArray iovArray = new IovArray();
    /* access modifiers changed from: private */
    public final byte[] ipv4Bytes = new byte[4];
    private final NativeDatagramPacket[] packets = new NativeDatagramPacket[Limits.UIO_MAX_IOV];
    private final MyMessageProcessor processor = new MyMessageProcessor();

    public final class MyMessageProcessor implements ChannelOutboundBuffer.MessageProcessor {
        /* access modifiers changed from: private */
        public boolean connected;
        /* access modifiers changed from: private */
        public int maxMessagesPerWrite;

        private MyMessageProcessor() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
            r0 = ((io.netty.channel.unix.SegmentedDatagramPacket) r9).segmentSize();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean processMessage(java.lang.Object r9) {
            /*
                r8 = this;
                boolean r0 = r9 instanceof io.netty.channel.socket.DatagramPacket
                r1 = 0
                if (r0 == 0) goto L_0x0038
                io.netty.channel.socket.DatagramPacket r9 = (io.netty.channel.socket.DatagramPacket) r9
                java.lang.Object r0 = r9.content()
                r3 = r0
                io.netty.buffer.ByteBuf r3 = (io.netty.buffer.ByteBuf) r3
                boolean r0 = r9 instanceof io.netty.channel.unix.SegmentedDatagramPacket
                if (r0 == 0) goto L_0x0021
                r0 = r9
                io.netty.channel.unix.SegmentedDatagramPacket r0 = (io.netty.channel.unix.SegmentedDatagramPacket) r0
                int r0 = r0.segmentSize()
                int r2 = r3.readableBytes()
                if (r2 <= r0) goto L_0x0021
                r6 = r0
                goto L_0x0022
            L_0x0021:
                r6 = r1
            L_0x0022:
                io.netty.channel.epoll.NativeDatagramPacketArray r2 = io.netty.channel.epoll.NativeDatagramPacketArray.this
                int r4 = r3.readerIndex()
                int r5 = r3.readableBytes()
                java.net.SocketAddress r9 = r9.recipient()
                r7 = r9
                java.net.InetSocketAddress r7 = (java.net.InetSocketAddress) r7
                boolean r9 = r2.add0(r3, r4, r5, r6, r7)
                goto L_0x0055
            L_0x0038:
                boolean r0 = r9 instanceof io.netty.buffer.ByteBuf
                if (r0 == 0) goto L_0x0054
                boolean r0 = r8.connected
                if (r0 == 0) goto L_0x0054
                r3 = r9
                io.netty.buffer.ByteBuf r3 = (io.netty.buffer.ByteBuf) r3
                io.netty.channel.epoll.NativeDatagramPacketArray r2 = io.netty.channel.epoll.NativeDatagramPacketArray.this
                int r4 = r3.readerIndex()
                int r5 = r3.readableBytes()
                r6 = 0
                r7 = 0
                boolean r9 = r2.add0(r3, r4, r5, r6, r7)
                goto L_0x0055
            L_0x0054:
                r9 = r1
            L_0x0055:
                if (r9 == 0) goto L_0x0060
                int r9 = r8.maxMessagesPerWrite
                r0 = 1
                int r9 = r9 - r0
                r8.maxMessagesPerWrite = r9
                if (r9 <= 0) goto L_0x0060
                r1 = r0
            L_0x0060:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.NativeDatagramPacketArray.MyMessageProcessor.processMessage(java.lang.Object):boolean");
        }
    }

    public final class NativeDatagramPacket {
        private int count;
        private long memoryAddress;
        private final byte[] recipientAddr = new byte[16];
        private int recipientAddrLen;
        private int recipientPort;
        private int recipientScopeId;
        private int segmentSize;
        private final byte[] senderAddr = new byte[16];
        private int senderAddrLen;
        private int senderPort;
        private int senderScopeId;

        public NativeDatagramPacket() {
        }

        /* access modifiers changed from: private */
        public void init(long j, int i, int i2, InetSocketAddress inetSocketAddress) {
            this.memoryAddress = j;
            this.count = i;
            this.segmentSize = i2;
            this.senderScopeId = 0;
            this.senderPort = 0;
            this.senderAddrLen = 0;
            if (inetSocketAddress == null) {
                this.recipientScopeId = 0;
                this.recipientPort = 0;
                this.recipientAddrLen = 0;
                return;
            }
            InetAddress address = inetSocketAddress.getAddress();
            if (address instanceof Inet6Address) {
                byte[] address2 = address.getAddress();
                byte[] bArr = this.recipientAddr;
                System.arraycopy(address2, 0, bArr, 0, bArr.length);
                this.recipientScopeId = ((Inet6Address) address).getScopeId();
            } else {
                NativeInetAddress.copyIpv4MappedIpv6Address(address.getAddress(), this.recipientAddr);
                this.recipientScopeId = 0;
            }
            this.recipientAddrLen = this.recipientAddr.length;
            this.recipientPort = inetSocketAddress.getPort();
        }

        public boolean hasSender() {
            return this.senderPort > 0;
        }

        public DatagramPacket newDatagramPacket(ByteBuf byteBuf, InetSocketAddress inetSocketAddress) throws UnknownHostException {
            InetSocketAddress access$600 = NativeDatagramPacketArray.newAddress(this.senderAddr, this.senderAddrLen, this.senderPort, this.senderScopeId, NativeDatagramPacketArray.this.ipv4Bytes);
            int i = this.recipientAddrLen;
            if (i != 0) {
                inetSocketAddress = NativeDatagramPacketArray.newAddress(this.recipientAddr, i, this.recipientPort, this.recipientScopeId, NativeDatagramPacketArray.this.ipv4Bytes);
            }
            int i2 = this.segmentSize;
            return i2 > 0 ? new SegmentedDatagramPacket(byteBuf, i2, inetSocketAddress, access$600) : new DatagramPacket(byteBuf, inetSocketAddress, access$600);
        }
    }

    public NativeDatagramPacketArray() {
        int i = 0;
        while (true) {
            NativeDatagramPacket[] nativeDatagramPacketArr = this.packets;
            if (i < nativeDatagramPacketArr.length) {
                nativeDatagramPacketArr[i] = new NativeDatagramPacket();
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean add0(ByteBuf byteBuf, int i, int i2, int i3, InetSocketAddress inetSocketAddress) {
        if (this.count == this.packets.length) {
            return false;
        }
        if (i2 == 0) {
            return true;
        }
        int count2 = this.iovArray.count();
        if (count2 == Limits.IOV_MAX || !this.iovArray.add(byteBuf, i, i2)) {
            return false;
        }
        this.packets[this.count].init(this.iovArray.memoryAddress(count2), this.iovArray.count() - count2, i3, inetSocketAddress);
        this.count++;
        return true;
    }

    /* access modifiers changed from: private */
    public static InetSocketAddress newAddress(byte[] bArr, int i, int i2, int i3, byte[] bArr2) throws UnknownHostException {
        InetAddress inetAddress;
        if (i == bArr2.length) {
            System.arraycopy(bArr, 0, bArr2, 0, i);
            inetAddress = InetAddress.getByAddress(bArr2);
        } else {
            inetAddress = Inet6Address.getByAddress((String) null, bArr, i3);
        }
        return new InetSocketAddress(inetAddress, i2);
    }

    public void add(ChannelOutboundBuffer channelOutboundBuffer, boolean z, int i) throws Exception {
        boolean unused = this.processor.connected = z;
        int unused2 = this.processor.maxMessagesPerWrite = i;
        channelOutboundBuffer.forEachFlushedMessage(this.processor);
    }

    public boolean addWritable(ByteBuf byteBuf, int i, int i2) {
        return add0(byteBuf, i, i2, 0, (InetSocketAddress) null);
    }

    public void clear() {
        this.count = 0;
        this.iovArray.clear();
    }

    public int count() {
        return this.count;
    }

    public NativeDatagramPacket[] packets() {
        return this.packets;
    }

    public void release() {
        this.iovArray.release();
    }
}
