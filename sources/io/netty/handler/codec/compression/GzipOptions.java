package io.netty.handler.codec.compression;

public final class GzipOptions extends DeflateOptions {
    static final GzipOptions DEFAULT = new GzipOptions(6, 15, 8);

    public GzipOptions(int i, int i2, int i3) {
        super(i, i2, i3);
    }
}
