package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

class Bzip2BitReader {
    private static final int MAX_COUNT_OF_READABLE_BYTES = 268435455;
    private long bitBuffer;
    private int bitCount;
    private ByteBuf in;

    public boolean hasReadableBits(int i) {
        if (i >= 0) {
            return this.bitCount >= i || ((this.in.readableBytes() << 3) & Integer.MAX_VALUE) >= i - this.bitCount;
        }
        throw new IllegalArgumentException("count: " + i + " (expected value greater than 0)");
    }

    public boolean hasReadableBytes(int i) {
        if (i >= 0 && i <= MAX_COUNT_OF_READABLE_BYTES) {
            return hasReadableBits(i << 3);
        }
        throw new IllegalArgumentException("count: " + i + " (expected: 0-" + MAX_COUNT_OF_READABLE_BYTES + ')');
    }

    public boolean isReadable() {
        return this.bitCount > 0 || this.in.isReadable();
    }

    public int readBits(int i) {
        int i2;
        long j;
        if (i < 0 || i > 32) {
            throw new IllegalArgumentException("count: " + i + " (expected: 0-32 )");
        }
        int i3 = this.bitCount;
        long j2 = this.bitBuffer;
        if (i3 < i) {
            int readableBytes = this.in.readableBytes();
            if (readableBytes == 1) {
                j = (long) this.in.readUnsignedByte();
                i2 = 8;
            } else if (readableBytes == 2) {
                j = (long) this.in.readUnsignedShort();
                i2 = 16;
            } else if (readableBytes != 3) {
                j = this.in.readUnsignedInt();
                i2 = 32;
            } else {
                j = (long) this.in.readUnsignedMedium();
                i2 = 24;
            }
            j2 = (j2 << i2) | j;
            i3 += i2;
            this.bitBuffer = j2;
        }
        int i4 = i3 - i;
        this.bitCount = i4;
        return (int) ((i != 32 ? (long) ((1 << i) - 1) : 4294967295L) & (j2 >>> i4));
    }

    public boolean readBoolean() {
        return readBits(1) != 0;
    }

    public int readInt() {
        return readBits(32);
    }

    public void refill() {
        this.bitBuffer = (this.bitBuffer << 8) | ((long) this.in.readUnsignedByte());
        this.bitCount += 8;
    }

    public void setByteBuf(ByteBuf byteBuf) {
        this.in = byteBuf;
    }
}
