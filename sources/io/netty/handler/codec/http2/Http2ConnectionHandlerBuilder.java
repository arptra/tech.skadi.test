package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2HeadersEncoder;

public final class Http2ConnectionHandlerBuilder extends AbstractHttp2ConnectionHandlerBuilder<Http2ConnectionHandler, Http2ConnectionHandlerBuilder> {
    public Http2ConnectionHandler build() {
        return super.build();
    }

    public Http2ConnectionHandler build(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) {
        return new Http2ConnectionHandler(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, decoupleCloseAndGoAway(), flushPreface());
    }

    public Http2ConnectionHandlerBuilder codec(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder) {
        return (Http2ConnectionHandlerBuilder) super.codec(http2ConnectionDecoder, http2ConnectionEncoder);
    }

    public Http2ConnectionHandlerBuilder connection(Http2Connection http2Connection) {
        return (Http2ConnectionHandlerBuilder) super.connection(http2Connection);
    }

    public Http2ConnectionHandlerBuilder decoupleCloseAndGoAway(boolean z) {
        return (Http2ConnectionHandlerBuilder) super.decoupleCloseAndGoAway(z);
    }

    public Http2ConnectionHandlerBuilder encoderEnforceMaxConcurrentStreams(boolean z) {
        return (Http2ConnectionHandlerBuilder) super.encoderEnforceMaxConcurrentStreams(z);
    }

    public Http2ConnectionHandlerBuilder encoderIgnoreMaxHeaderListSize(boolean z) {
        return (Http2ConnectionHandlerBuilder) super.encoderIgnoreMaxHeaderListSize(z);
    }

    public Http2ConnectionHandlerBuilder flushPreface(boolean z) {
        return (Http2ConnectionHandlerBuilder) super.flushPreface(z);
    }

    public Http2ConnectionHandlerBuilder frameListener(Http2FrameListener http2FrameListener) {
        return (Http2ConnectionHandlerBuilder) super.frameListener(http2FrameListener);
    }

    public Http2ConnectionHandlerBuilder frameLogger(Http2FrameLogger http2FrameLogger) {
        return (Http2ConnectionHandlerBuilder) super.frameLogger(http2FrameLogger);
    }

    public Http2ConnectionHandlerBuilder gracefulShutdownTimeoutMillis(long j) {
        return (Http2ConnectionHandlerBuilder) super.gracefulShutdownTimeoutMillis(j);
    }

    public Http2ConnectionHandlerBuilder headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        return (Http2ConnectionHandlerBuilder) super.headerSensitivityDetector(sensitivityDetector);
    }

    @Deprecated
    public Http2ConnectionHandlerBuilder initialHuffmanDecodeCapacity(int i) {
        return (Http2ConnectionHandlerBuilder) super.initialHuffmanDecodeCapacity(i);
    }

    public Http2ConnectionHandlerBuilder initialSettings(Http2Settings http2Settings) {
        return (Http2ConnectionHandlerBuilder) super.initialSettings(http2Settings);
    }

    public Http2ConnectionHandlerBuilder maxReservedStreams(int i) {
        return (Http2ConnectionHandlerBuilder) super.maxReservedStreams(i);
    }

    public Http2ConnectionHandlerBuilder server(boolean z) {
        return (Http2ConnectionHandlerBuilder) super.server(z);
    }

    public Http2ConnectionHandlerBuilder validateHeaders(boolean z) {
        return (Http2ConnectionHandlerBuilder) super.validateHeaders(z);
    }

    public Http2Settings initialSettings() {
        return super.initialSettings();
    }
}
