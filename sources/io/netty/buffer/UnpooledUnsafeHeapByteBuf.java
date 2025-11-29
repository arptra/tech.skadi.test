package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

public class UnpooledUnsafeHeapByteBuf extends UnpooledHeapByteBuf {
    public UnpooledUnsafeHeapByteBuf(ByteBufAllocator byteBufAllocator, int i, int i2) {
        super(byteBufAllocator, i, i2);
    }

    public byte _getByte(int i) {
        return UnsafeByteBufUtil.getByte(this.array, i);
    }

    public int _getInt(int i) {
        return UnsafeByteBufUtil.getInt(this.array, i);
    }

    public int _getIntLE(int i) {
        return UnsafeByteBufUtil.getIntLE(this.array, i);
    }

    public long _getLong(int i) {
        return UnsafeByteBufUtil.getLong(this.array, i);
    }

    public long _getLongLE(int i) {
        return UnsafeByteBufUtil.getLongLE(this.array, i);
    }

    public short _getShort(int i) {
        return UnsafeByteBufUtil.getShort(this.array, i);
    }

    public short _getShortLE(int i) {
        return UnsafeByteBufUtil.getShortLE(this.array, i);
    }

    public int _getUnsignedMedium(int i) {
        return UnsafeByteBufUtil.getUnsignedMedium(this.array, i);
    }

    public int _getUnsignedMediumLE(int i) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(this.array, i);
    }

    public void _setByte(int i, int i2) {
        UnsafeByteBufUtil.setByte(this.array, i, i2);
    }

    public void _setInt(int i, int i2) {
        UnsafeByteBufUtil.setInt(this.array, i, i2);
    }

    public void _setIntLE(int i, int i2) {
        UnsafeByteBufUtil.setIntLE(this.array, i, i2);
    }

    public void _setLong(int i, long j) {
        UnsafeByteBufUtil.setLong(this.array, i, j);
    }

    public void _setLongLE(int i, long j) {
        UnsafeByteBufUtil.setLongLE(this.array, i, j);
    }

    public void _setMedium(int i, int i2) {
        UnsafeByteBufUtil.setMedium(this.array, i, i2);
    }

    public void _setMediumLE(int i, int i2) {
        UnsafeByteBufUtil.setMediumLE(this.array, i, i2);
    }

    public void _setShort(int i, int i2) {
        UnsafeByteBufUtil.setShort(this.array, i, i2);
    }

    public void _setShortLE(int i, int i2) {
        UnsafeByteBufUtil.setShortLE(this.array, i, i2);
    }

    public byte[] allocateArray(int i) {
        return PlatformDependent.allocateUninitializedArray(i);
    }

    public byte getByte(int i) {
        checkIndex(i);
        return _getByte(i);
    }

    public int getInt(int i) {
        checkIndex(i, 4);
        return _getInt(i);
    }

    public int getIntLE(int i) {
        checkIndex(i, 4);
        return _getIntLE(i);
    }

    public long getLong(int i) {
        checkIndex(i, 8);
        return _getLong(i);
    }

    public long getLongLE(int i) {
        checkIndex(i, 8);
        return _getLongLE(i);
    }

    public short getShort(int i) {
        checkIndex(i, 2);
        return _getShort(i);
    }

    public short getShortLE(int i) {
        checkIndex(i, 2);
        return _getShortLE(i);
    }

    public int getUnsignedMedium(int i) {
        checkIndex(i, 3);
        return _getUnsignedMedium(i);
    }

    public int getUnsignedMediumLE(int i) {
        checkIndex(i, 3);
        return _getUnsignedMediumLE(i);
    }

    @Deprecated
    public SwappedByteBuf newSwappedByteBuf() {
        return PlatformDependent.isUnaligned() ? new UnsafeHeapSwappedByteBuf(this) : super.newSwappedByteBuf();
    }

    public ByteBuf setByte(int i, int i2) {
        checkIndex(i);
        _setByte(i, i2);
        return this;
    }

    public ByteBuf setInt(int i, int i2) {
        checkIndex(i, 4);
        _setInt(i, i2);
        return this;
    }

    public ByteBuf setIntLE(int i, int i2) {
        checkIndex(i, 4);
        _setIntLE(i, i2);
        return this;
    }

    public ByteBuf setLong(int i, long j) {
        checkIndex(i, 8);
        _setLong(i, j);
        return this;
    }

    public ByteBuf setLongLE(int i, long j) {
        checkIndex(i, 8);
        _setLongLE(i, j);
        return this;
    }

    public ByteBuf setMedium(int i, int i2) {
        checkIndex(i, 3);
        _setMedium(i, i2);
        return this;
    }

    public ByteBuf setMediumLE(int i, int i2) {
        checkIndex(i, 3);
        _setMediumLE(i, i2);
        return this;
    }

    public ByteBuf setShort(int i, int i2) {
        checkIndex(i, 2);
        _setShort(i, i2);
        return this;
    }

    public ByteBuf setShortLE(int i, int i2) {
        checkIndex(i, 2);
        _setShortLE(i, i2);
        return this;
    }

    public ByteBuf setZero(int i, int i2) {
        if (PlatformDependent.javaVersion() < 7) {
            return super.setZero(i, i2);
        }
        checkIndex(i, i2);
        UnsafeByteBufUtil.setZero(this.array, i, i2);
        return this;
    }

    public ByteBuf writeZero(int i) {
        if (PlatformDependent.javaVersion() < 7) {
            return super.writeZero(i);
        }
        ensureWritable(i);
        int i2 = this.writerIndex;
        UnsafeByteBufUtil.setZero(this.array, i2, i);
        this.writerIndex = i2 + i;
        return this;
    }
}
