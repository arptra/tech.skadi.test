package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import net.jpountz.xxhash.XXHash32;
import net.jpountz.xxhash.XXHashFactory;

public final class Lz4XXHash32 extends ByteBufChecksum {
    private static final XXHash32 XXHASH32 = XXHashFactory.fastestInstance().hash32();
    private final int seed;
    private boolean used;
    private int value;

    public Lz4XXHash32(int i) {
        this.seed = i;
    }

    public long getValue() {
        if (this.used) {
            return ((long) this.value) & 268435455;
        }
        throw new IllegalStateException();
    }

    public void reset() {
        this.used = false;
    }

    public void update(int i) {
        throw new UnsupportedOperationException();
    }

    public void update(byte[] bArr, int i, int i2) {
        if (!this.used) {
            this.value = XXHASH32.hash(bArr, i, i2, this.seed);
            this.used = true;
            return;
        }
        throw new IllegalStateException();
    }

    public void update(ByteBuf byteBuf, int i, int i2) {
        if (!this.used) {
            if (byteBuf.hasArray()) {
                this.value = XXHASH32.hash(byteBuf.array(), byteBuf.arrayOffset() + i, i2, this.seed);
            } else {
                this.value = XXHASH32.hash(CompressionUtil.safeNioBuffer(byteBuf, i, i2), this.seed);
            }
            this.used = true;
            return;
        }
        throw new IllegalStateException();
    }
}
