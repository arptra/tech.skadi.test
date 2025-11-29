package io.netty.handler.codec.http2;

import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http2.Http2HeadersEncoder;

public final class HttpToHttp2ConnectionHandlerBuilder extends AbstractHttp2ConnectionHandlerBuilder<HttpToHttp2ConnectionHandler, HttpToHttp2ConnectionHandlerBuilder> {
    private HttpScheme httpScheme;

    public HttpToHttp2ConnectionHandlerBuilder httpScheme(HttpScheme httpScheme2) {
        this.httpScheme = httpScheme2;
        return (HttpToHttp2ConnectionHandlerBuilder) self();
    }

    public HttpToHttp2ConnectionHandlerBuilder codec(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder) {
        return (HttpToHttp2ConnectionHandlerBuilder) super.codec(http2ConnectionDecoder, http2ConnectionEncoder);
    }

    public HttpToHttp2ConnectionHandlerBuilder connection(Http2Connection http2Connection) {
        return (HttpToHttp2ConnectionHandlerBuilder) super.connection(http2Connection);
    }

    public HttpToHttp2ConnectionHandlerBuilder decoupleCloseAndGoAway(boolean z) {
        return (HttpToHttp2ConnectionHandlerBuilder) super.decoupleCloseAndGoAway(z);
    }

    public HttpToHttp2ConnectionHandlerBuilder encoderEnforceMaxConcurrentStreams(boolean z) {
        return (HttpToHttp2ConnectionHandlerBuilder) super.encoderEnforceMaxConcurrentStreams(z);
    }

    public HttpToHttp2ConnectionHandlerBuilder flushPreface(boolean z) {
        return (HttpToHttp2ConnectionHandlerBuilder) super.flushPreface(z);
    }

    public HttpToHttp2ConnectionHandlerBuilder frameListener(Http2FrameListener http2FrameListener) {
        return (HttpToHttp2ConnectionHandlerBuilder) super.frameListener(http2FrameListener);
    }

    public HttpToHttp2ConnectionHandlerBuilder frameLogger(Http2FrameLogger http2FrameLogger) {
        return (HttpToHttp2ConnectionHandlerBuilder) super.frameLogger(http2FrameLogger);
    }

    public HttpToHttp2ConnectionHandlerBuilder gracefulShutdownTimeoutMillis(long j) {
        return (HttpToHttp2ConnectionHandlerBuilder) super.gracefulShutdownTimeoutMillis(j);
    }

    public HttpToHttp2ConnectionHandlerBuilder headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        return (HttpToHttp2ConnectionHandlerBuilder) super.headerSensitivityDetector(sensitivityDetector);
    }

    @Deprecated
    public HttpToHttp2ConnectionHandlerBuilder initialHuffmanDecodeCapacity(int i) {
        return (HttpToHttp2ConnectionHandlerBuilder) super.initialHuffmanDecodeCapacity(i);
    }

    public HttpToHttp2ConnectionHandlerBuilder initialSettings(Http2Settings http2Settings) {
        return (HttpToHttp2ConnectionHandlerBuilder) super.initialSettings(http2Settings);
    }

    public HttpToHttp2ConnectionHandlerBuilder server(boolean z) {
        return (HttpToHttp2ConnectionHandlerBuilder) super.server(z);
    }

    public HttpToHttp2ConnectionHandlerBuilder validateHeaders(boolean z) {
        return (HttpToHttp2ConnectionHandlerBuilder) super.validateHeaders(z);
    }

    public HttpToHttp2ConnectionHandler build() {
        return (HttpToHttp2ConnectionHandler) super.build();
    }

    public HttpToHttp2ConnectionHandler build(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) {
        return new HttpToHttp2ConnectionHandler(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, isValidateHeaders(), decoupleCloseAndGoAway(), flushPreface(), this.httpScheme);
    }
}
