package io.netty.handler.codec.compression;

import io.netty.util.internal.ObjectUtil;

public class DeflateOptions implements CompressionOptions {
    static final DeflateOptions DEFAULT = new DeflateOptions(6, 15, 8);
    private final int compressionLevel;
    private final int memLevel;
    private final int windowBits;

    public DeflateOptions(int i, int i2, int i3) {
        this.compressionLevel = ObjectUtil.checkInRange(i, 0, 9, "compressionLevel");
        this.windowBits = ObjectUtil.checkInRange(i2, 9, 15, "windowBits");
        this.memLevel = ObjectUtil.checkInRange(i3, 1, 9, "memLevel");
    }

    public int compressionLevel() {
        return this.compressionLevel;
    }

    public int memLevel() {
        return this.memLevel;
    }

    public int windowBits() {
        return this.windowBits;
    }
}
