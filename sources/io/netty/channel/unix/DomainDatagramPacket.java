package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.DefaultAddressedEnvelope;

public final class DomainDatagramPacket extends DefaultAddressedEnvelope<ByteBuf, DomainSocketAddress> implements ByteBufHolder {
    public DomainDatagramPacket(ByteBuf byteBuf, DomainSocketAddress domainSocketAddress) {
        super(byteBuf, domainSocketAddress);
    }

    public /* bridge */ /* synthetic */ ByteBuf content() {
        return (ByteBuf) super.content();
    }

    public DomainDatagramPacket(ByteBuf byteBuf, DomainSocketAddress domainSocketAddress, DomainSocketAddress domainSocketAddress2) {
        super(byteBuf, domainSocketAddress, domainSocketAddress2);
    }

    public DomainDatagramPacket copy() {
        return replace(((ByteBuf) content()).copy());
    }

    public DomainDatagramPacket duplicate() {
        return replace(((ByteBuf) content()).duplicate());
    }

    public DomainDatagramPacket replace(ByteBuf byteBuf) {
        return new DomainDatagramPacket(byteBuf, (DomainSocketAddress) recipient(), (DomainSocketAddress) sender());
    }

    public DomainDatagramPacket retainedDuplicate() {
        return replace(((ByteBuf) content()).retainedDuplicate());
    }

    public DomainDatagramPacket retain() {
        super.retain();
        return this;
    }

    public DomainDatagramPacket touch() {
        super.touch();
        return this;
    }

    public DomainDatagramPacket retain(int i) {
        super.retain(i);
        return this;
    }

    public DomainDatagramPacket touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
