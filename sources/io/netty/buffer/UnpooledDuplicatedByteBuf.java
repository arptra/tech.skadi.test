package io.netty.buffer;

class UnpooledDuplicatedByteBuf extends DuplicatedByteBuf {
    public UnpooledDuplicatedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    public byte _getByte(int i) {
        return unwrap()._getByte(i);
    }

    public int _getInt(int i) {
        return unwrap()._getInt(i);
    }

    public int _getIntLE(int i) {
        return unwrap()._getIntLE(i);
    }

    public long _getLong(int i) {
        return unwrap()._getLong(i);
    }

    public long _getLongLE(int i) {
        return unwrap()._getLongLE(i);
    }

    public short _getShort(int i) {
        return unwrap()._getShort(i);
    }

    public short _getShortLE(int i) {
        return unwrap()._getShortLE(i);
    }

    public int _getUnsignedMedium(int i) {
        return unwrap()._getUnsignedMedium(i);
    }

    public int _getUnsignedMediumLE(int i) {
        return unwrap()._getUnsignedMediumLE(i);
    }

    public void _setByte(int i, int i2) {
        unwrap()._setByte(i, i2);
    }

    public void _setInt(int i, int i2) {
        unwrap()._setInt(i, i2);
    }

    public void _setIntLE(int i, int i2) {
        unwrap()._setIntLE(i, i2);
    }

    public void _setLong(int i, long j) {
        unwrap()._setLong(i, j);
    }

    public void _setLongLE(int i, long j) {
        unwrap()._setLongLE(i, j);
    }

    public void _setMedium(int i, int i2) {
        unwrap()._setMedium(i, i2);
    }

    public void _setMediumLE(int i, int i2) {
        unwrap()._setMediumLE(i, i2);
    }

    public void _setShort(int i, int i2) {
        unwrap()._setShort(i, i2);
    }

    public void _setShortLE(int i, int i2) {
        unwrap()._setShortLE(i, i2);
    }

    public AbstractByteBuf unwrap() {
        return (AbstractByteBuf) super.unwrap();
    }
}
