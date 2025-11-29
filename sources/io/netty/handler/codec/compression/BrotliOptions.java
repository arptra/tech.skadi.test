package io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.encoder.Encoder;
import io.netty.util.internal.ObjectUtil;

public final class BrotliOptions implements CompressionOptions {
    static final BrotliOptions DEFAULT = new BrotliOptions(new Encoder.Parameters().setQuality(4).setMode(Encoder.Mode.TEXT));
    private final Encoder.Parameters parameters;

    public BrotliOptions(Encoder.Parameters parameters2) {
        if (Brotli.isAvailable()) {
            this.parameters = (Encoder.Parameters) ObjectUtil.checkNotNull(parameters2, "Parameters");
            return;
        }
        throw new IllegalStateException("Brotli is not available", Brotli.cause());
    }

    public Encoder.Parameters parameters() {
        return this.parameters;
    }
}
