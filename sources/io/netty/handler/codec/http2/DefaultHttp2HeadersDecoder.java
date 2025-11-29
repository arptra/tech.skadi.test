package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.Http2HeadersDecoder;
import io.netty.util.internal.ObjectUtil;

public class DefaultHttp2HeadersDecoder implements Http2HeadersDecoder, Http2HeadersDecoder.Configuration {
    private static final float HEADERS_COUNT_WEIGHT_HISTORICAL = 0.8f;
    private static final float HEADERS_COUNT_WEIGHT_NEW = 0.2f;
    private float headerArraySizeAccumulator;
    private final HpackDecoder hpackDecoder;
    private long maxHeaderListSizeGoAway;
    private final boolean validateHeaders;

    public DefaultHttp2HeadersDecoder() {
        this(true);
    }

    public Http2HeadersDecoder.Configuration configuration() {
        return this;
    }

    public Http2Headers decodeHeaders(int i, ByteBuf byteBuf) throws Http2Exception {
        try {
            Http2Headers newHeaders = newHeaders();
            this.hpackDecoder.decode(i, byteBuf, newHeaders, this.validateHeaders);
            this.headerArraySizeAccumulator = (((float) newHeaders.size()) * 0.2f) + (this.headerArraySizeAccumulator * HEADERS_COUNT_WEIGHT_HISTORICAL);
            return newHeaders;
        } catch (Http2Exception e) {
            throw e;
        } catch (Throwable th) {
            throw Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, th, "Error decoding headers: %s", th.getMessage());
        }
    }

    public void maxHeaderListSize(long j, long j2) throws Http2Exception {
        if (j2 < j || j2 < 0) {
            throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Header List Size GO_AWAY %d must be non-negative and >= %d", Long.valueOf(j2), Long.valueOf(j));
        }
        this.hpackDecoder.setMaxHeaderListSize(j);
        this.maxHeaderListSizeGoAway = j2;
    }

    public long maxHeaderListSizeGoAway() {
        return this.maxHeaderListSizeGoAway;
    }

    public void maxHeaderTableSize(long j) throws Http2Exception {
        this.hpackDecoder.setMaxHeaderTableSize(j);
    }

    public Http2Headers newHeaders() {
        return new DefaultHttp2Headers(this.validateHeaders, (int) this.headerArraySizeAccumulator);
    }

    public final int numberOfHeadersGuess() {
        return (int) this.headerArraySizeAccumulator;
    }

    public final boolean validateHeaders() {
        return this.validateHeaders;
    }

    public DefaultHttp2HeadersDecoder(boolean z) {
        this(z, 8192);
    }

    public long maxHeaderTableSize() {
        return this.hpackDecoder.getMaxHeaderTableSize();
    }

    public DefaultHttp2HeadersDecoder(boolean z, long j) {
        this(z, j, -1);
    }

    public DefaultHttp2HeadersDecoder(boolean z, long j, @Deprecated int i) {
        this(z, new HpackDecoder(j));
    }

    public DefaultHttp2HeadersDecoder(boolean z, HpackDecoder hpackDecoder2) {
        this.headerArraySizeAccumulator = 8.0f;
        this.hpackDecoder = (HpackDecoder) ObjectUtil.checkNotNull(hpackDecoder2, "hpackDecoder");
        this.validateHeaders = z;
        this.maxHeaderListSizeGoAway = Http2CodecUtil.calculateMaxHeaderListSizeGoAway(hpackDecoder2.getMaxHeaderListSize());
    }

    public long maxHeaderListSize() {
        return this.hpackDecoder.getMaxHeaderListSize();
    }
}
