package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;

public class SegmentedDatagramPacket extends DatagramPacket {
    private final int segmentSize;

    public SegmentedDatagramPacket(ByteBuf byteBuf, int i, InetSocketAddress inetSocketAddress) {
        super(byteBuf, inetSocketAddress);
        this.segmentSize = ObjectUtil.checkPositive(i, "segmentSize");
    }

    public int segmentSize() {
        return this.segmentSize;
    }

    public SegmentedDatagramPacket(ByteBuf byteBuf, int i, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        super(byteBuf, inetSocketAddress, inetSocketAddress2);
        this.segmentSize = ObjectUtil.checkPositive(i, "segmentSize");
    }

    public SegmentedDatagramPacket copy() {
        return new SegmentedDatagramPacket(((ByteBuf) content()).copy(), this.segmentSize, (InetSocketAddress) recipient(), (InetSocketAddress) sender());
    }

    public SegmentedDatagramPacket duplicate() {
        return new SegmentedDatagramPacket(((ByteBuf) content()).duplicate(), this.segmentSize, (InetSocketAddress) recipient(), (InetSocketAddress) sender());
    }

    public SegmentedDatagramPacket replace(ByteBuf byteBuf) {
        return new SegmentedDatagramPacket(byteBuf, this.segmentSize, (InetSocketAddress) recipient(), (InetSocketAddress) sender());
    }

    public SegmentedDatagramPacket retainedDuplicate() {
        return new SegmentedDatagramPacket(((ByteBuf) content()).retainedDuplicate(), this.segmentSize, (InetSocketAddress) recipient(), (InetSocketAddress) sender());
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
