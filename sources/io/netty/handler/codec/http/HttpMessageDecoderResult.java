package io.netty.handler.codec.http;

import io.netty.handler.codec.DecoderResult;

public final class HttpMessageDecoderResult extends DecoderResult {
    private final int headerSize;
    private final int initialLineLength;

    public HttpMessageDecoderResult(int i, int i2) {
        super(DecoderResult.SIGNAL_SUCCESS);
        this.initialLineLength = i;
        this.headerSize = i2;
    }

    public int headerSize() {
        return this.headerSize;
    }

    public int initialLineLength() {
        return this.initialLineLength;
    }

    public int totalSize() {
        return this.initialLineLength + this.headerSize;
    }
}
