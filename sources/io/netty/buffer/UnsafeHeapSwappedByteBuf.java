package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

final class UnsafeHeapSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    public UnsafeHeapSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    private static int idx(ByteBuf byteBuf, int i) {
        return byteBuf.arrayOffset() + i;
    }

    public int _getInt(AbstractByteBuf abstractByteBuf, int i) {
        return PlatformDependent.getInt(abstractByteBuf.array(), idx(abstractByteBuf, i));
    }

    public long _getLong(AbstractByteBuf abstractByteBuf, int i) {
        return PlatformDependent.getLong(abstractByteBuf.array(), idx(abstractByteBuf, i));
    }

    public short _getShort(AbstractByteBuf abstractByteBuf, int i) {
        return PlatformDependent.getShort(abstractByteBuf.array(), idx(abstractByteBuf, i));
    }

    public void _setInt(AbstractByteBuf abstractByteBuf, int i, int i2) {
        PlatformDependent.putInt(abstractByteBuf.array(), idx(abstractByteBuf, i), i2);
    }

    public void _setLong(AbstractByteBuf abstractByteBuf, int i, long j) {
        PlatformDependent.putLong(abstractByteBuf.array(), idx(abstractByteBuf, i), j);
    }

    public void _setShort(AbstractByteBuf abstractByteBuf, int i, short s) {
        PlatformDependent.putShort(abstractByteBuf.array(), idx(abstractByteBuf, i), s);
    }
}
