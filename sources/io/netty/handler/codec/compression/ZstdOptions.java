package io.netty.handler.codec.compression;

import com.here.posclient.PositionEstimate;
import io.netty.util.internal.ObjectUtil;

public class ZstdOptions implements CompressionOptions {
    static final ZstdOptions DEFAULT = new ZstdOptions(3, 65536, PositionEstimate.Value.GNSS_TIME);
    private final int blockSize;
    private final int compressionLevel;
    private final int maxEncodeSize;

    public ZstdOptions(int i, int i2, int i3) {
        if (Zstd.isAvailable()) {
            this.compressionLevel = ObjectUtil.checkInRange(i, 0, 22, "compressionLevel");
            this.blockSize = ObjectUtil.checkPositive(i2, "blockSize");
            this.maxEncodeSize = ObjectUtil.checkPositive(i3, "maxEncodeSize");
            return;
        }
        throw new IllegalStateException("zstd-jni is not available", Zstd.cause());
    }

    public int blockSize() {
        return this.blockSize;
    }

    public int compressionLevel() {
        return this.compressionLevel;
    }

    public int maxEncodeSize() {
        return this.maxEncodeSize;
    }
}
