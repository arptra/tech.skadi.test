package io.netty.channel.udt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;

@Deprecated
public final class UdtMessage extends DefaultByteBufHolder {
    public UdtMessage(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public UdtMessage copy() {
        return (UdtMessage) super.copy();
    }

    public UdtMessage duplicate() {
        return (UdtMessage) super.duplicate();
    }

    public UdtMessage replace(ByteBuf byteBuf) {
        return new UdtMessage(byteBuf);
    }

    public UdtMessage retainedDuplicate() {
        return (UdtMessage) super.retainedDuplicate();
    }

    public UdtMessage retain() {
        super.retain();
        return this;
    }

    public UdtMessage touch() {
        super.touch();
        return this;
    }

    public UdtMessage retain(int i) {
        super.retain(i);
        return this;
    }

    public UdtMessage touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
