package io.netty.buffer;

import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;

final class UnreleasableByteBuf extends WrappedByteBuf {
    private SwappedByteBuf swappedBuf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnreleasableByteBuf(ByteBuf byteBuf) {
        super(byteBuf instanceof UnreleasableByteBuf ? byteBuf.unwrap() : byteBuf);
    }

    public ByteBuf asReadOnly() {
        return this.buf.isReadOnly() ? this : new UnreleasableByteBuf(this.buf.asReadOnly());
    }

    public ByteBuf duplicate() {
        return new UnreleasableByteBuf(this.buf.duplicate());
    }

    public ByteBuf order(ByteOrder byteOrder) {
        if (ObjectUtil.checkNotNull(byteOrder, "endianness") == order()) {
            return this;
        }
        SwappedByteBuf swappedByteBuf = this.swappedBuf;
        if (swappedByteBuf != null) {
            return swappedByteBuf;
        }
        SwappedByteBuf swappedByteBuf2 = new SwappedByteBuf(this);
        this.swappedBuf = swappedByteBuf2;
        return swappedByteBuf2;
    }

    public ByteBuf readRetainedSlice(int i) {
        return readSlice(i);
    }

    public ByteBuf readSlice(int i) {
        return new UnreleasableByteBuf(this.buf.readSlice(i));
    }

    public boolean release() {
        return false;
    }

    public ByteBuf retain() {
        return this;
    }

    public ByteBuf retainedDuplicate() {
        return duplicate();
    }

    public ByteBuf retainedSlice() {
        return slice();
    }

    public ByteBuf slice() {
        return new UnreleasableByteBuf(this.buf.slice());
    }

    public ByteBuf touch() {
        return this;
    }

    public boolean release(int i) {
        return false;
    }

    public ByteBuf retain(int i) {
        return this;
    }

    public ByteBuf retainedSlice(int i, int i2) {
        return slice(i, i2);
    }

    public ByteBuf slice(int i, int i2) {
        return new UnreleasableByteBuf(this.buf.slice(i, i2));
    }

    public ByteBuf touch(Object obj) {
        return this;
    }
}
