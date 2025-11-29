package io.netty.buffer;

class UnpooledSlicedByteBuf extends AbstractUnpooledSlicedByteBuf {
    public UnpooledSlicedByteBuf(AbstractByteBuf abstractByteBuf, int i, int i2) {
        super(abstractByteBuf, i, i2);
    }

    public byte _getByte(int i) {
        return unwrap()._getByte(idx(i));
    }

    public int _getInt(int i) {
        return unwrap()._getInt(idx(i));
    }

    public int _getIntLE(int i) {
        return unwrap()._getIntLE(idx(i));
    }

    public long _getLong(int i) {
        return unwrap()._getLong(idx(i));
    }

    public long _getLongLE(int i) {
        return unwrap()._getLongLE(idx(i));
    }

    public short _getShort(int i) {
        return unwrap()._getShort(idx(i));
    }

    public short _getShortLE(int i) {
        return unwrap()._getShortLE(idx(i));
    }

    public int _getUnsignedMedium(int i) {
        return unwrap()._getUnsignedMedium(idx(i));
    }

    public int _getUnsignedMediumLE(int i) {
        return unwrap()._getUnsignedMediumLE(idx(i));
    }

    public void _setByte(int i, int i2) {
        unwrap()._setByte(idx(i), i2);
    }

    public void _setInt(int i, int i2) {
        unwrap()._setInt(idx(i), i2);
    }

    public void _setIntLE(int i, int i2) {
        unwrap()._setIntLE(idx(i), i2);
    }

    public void _setLong(int i, long j) {
        unwrap()._setLong(idx(i), j);
    }

    public void _setLongLE(int i, long j) {
        unwrap()._setLongLE(idx(i), j);
    }

    public void _setMedium(int i, int i2) {
        unwrap()._setMedium(idx(i), i2);
    }

    public void _setMediumLE(int i, int i2) {
        unwrap()._setMediumLE(idx(i), i2);
    }

    public void _setShort(int i, int i2) {
        unwrap()._setShort(idx(i), i2);
    }

    public void _setShortLE(int i, int i2) {
        unwrap()._setShortLE(idx(i), i2);
    }

    public int capacity() {
        return maxCapacity();
    }

    public AbstractByteBuf unwrap() {
        return (AbstractByteBuf) super.unwrap();
    }
}
