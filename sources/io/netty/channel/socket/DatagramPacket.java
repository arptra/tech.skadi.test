package io.netty.channel.socket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.DefaultAddressedEnvelope;
import java.net.InetSocketAddress;

public class DatagramPacket extends DefaultAddressedEnvelope<ByteBuf, InetSocketAddress> implements ByteBufHolder {
    public DatagramPacket(ByteBuf byteBuf, InetSocketAddress inetSocketAddress) {
        super(byteBuf, inetSocketAddress);
    }

    public /* bridge */ /* synthetic */ ByteBuf content() {
        return (ByteBuf) super.content();
    }

    public DatagramPacket(ByteBuf byteBuf, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        super(byteBuf, inetSocketAddress, inetSocketAddress2);
    }

    public DatagramPacket copy() {
        return replace(((ByteBuf) content()).copy());
    }

    public DatagramPacket duplicate() {
        return replace(((ByteBuf) content()).duplicate());
    }

    public DatagramPacket replace(ByteBuf byteBuf) {
        return new DatagramPacket(byteBuf, (InetSocketAddress) recipient(), (InetSocketAddress) sender());
    }

    public DatagramPacket retainedDuplicate() {
        return replace(((ByteBuf) content()).retainedDuplicate());
    }

    public DatagramPacket retain() {
        super.retain();
        return this;
    }

    public DatagramPacket touch() {
        super.touch();
        return this;
    }

    public DatagramPacket retain(int i) {
        super.retain(i);
        return this;
    }

    public DatagramPacket touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
