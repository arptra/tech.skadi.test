package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import java.net.InetSocketAddress;

@Deprecated
public final class SegmentedDatagramPacket extends io.netty.channel.unix.SegmentedDatagramPacket {
    public SegmentedDatagramPacket(ByteBuf byteBuf, int i, InetSocketAddress inetSocketAddress) {
        super(byteBuf, i, inetSocketAddress);
        checkIsSupported();
    }

    private static void checkIsSupported() {
        if (!isSupported()) {
            throw new IllegalStateException();
        }
    }

    public static boolean isSupported() {
        return Epoll.isAvailable() && Native.IS_SUPPORTING_SENDMMSG && Native.IS_SUPPORTING_UDP_SEGMENT;
    }

    public SegmentedDatagramPacket(ByteBuf byteBuf, int i, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        super(byteBuf, i, inetSocketAddress, inetSocketAddress2);
        checkIsSupported();
    }

    public SegmentedDatagramPacket copy() {
        return new SegmentedDatagramPacket(((ByteBuf) content()).copy(), segmentSize(), (InetSocketAddress) recipient(), (InetSocketAddress) sender());
    }

    public SegmentedDatagramPacket duplicate() {
        return new SegmentedDatagramPacket(((ByteBuf) content()).duplicate(), segmentSize(), (InetSocketAddress) recipient(), (InetSocketAddress) sender());
    }

    public SegmentedDatagramPacket replace(ByteBuf byteBuf) {
        return new SegmentedDatagramPacket(byteBuf, segmentSize(), (InetSocketAddress) recipient(), (InetSocketAddress) sender());
    }

    public SegmentedDatagramPacket retainedDuplicate() {
        return new SegmentedDatagramPacket(((ByteBuf) content()).retainedDuplicate(), segmentSize(), (InetSocketAddress) recipient(), (InetSocketAddress) sender());
    }

    public SegmentedDatagramPacket retain() {
        super.retain();
        return this;
    }

    public SegmentedDatagramPacket touch() {
        super.touch();
        return this;
    }

    public SegmentedDatagramPacket retain(int i) {
        super.retain(i);
        return this;
    }

    public SegmentedDatagramPacket touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
