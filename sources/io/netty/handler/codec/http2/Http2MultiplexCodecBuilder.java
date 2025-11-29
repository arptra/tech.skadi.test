package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.internal.ObjectUtil;

@Deprecated
public class Http2MultiplexCodecBuilder extends AbstractHttp2ConnectionHandlerBuilder<Http2MultiplexCodec, Http2MultiplexCodecBuilder> {
    final ChannelHandler childHandler;
    private Http2FrameWriter frameWriter;
    private ChannelHandler upgradeStreamHandler;

    public Http2MultiplexCodecBuilder(boolean z, ChannelHandler channelHandler) {
        server(z);
        this.childHandler = checkSharable((ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "childHandler"));
        gracefulShutdownTimeoutMillis(0);
    }

    private static ChannelHandler checkSharable(ChannelHandler channelHandler) {
        if (!(channelHandler instanceof ChannelHandlerAdapter) || ((ChannelHandlerAdapter) channelHandler).isSharable() || channelHandler.getClass().isAnnotationPresent(ChannelHandler.Sharable.class)) {
            return channelHandler;
        }
        throw new IllegalArgumentException("The handler must be Sharable");
    }

    public static Http2MultiplexCodecBuilder forClient(ChannelHandler channelHandler) {
        return new Http2MultiplexCodecBuilder(false, channelHandler);
    }

    public static Http2MultiplexCodecBuilder forServer(ChannelHandler channelHandler) {
        return new Http2MultiplexCodecBuilder(true, channelHandler);
    }

    public Http2MultiplexCodecBuilder frameWriter(Http2FrameWriter http2FrameWriter) {
        this.frameWriter = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "frameWriter");
        return this;
    }

    public boolean isServer() {
        return super.isServer();
    }

    public boolean isValidateHeaders() {
        return super.isValidateHeaders();
    }

    public Http2MultiplexCodecBuilder withUpgradeStreamHandler(ChannelHandler channelHandler) {
        if (!isServer()) {
            this.upgradeStreamHandler = channelHandler;
            return this;
        }
        throw new IllegalArgumentException("Server codecs don't use an extra handler for the upgrade stream");
    }

    public Http2MultiplexCodecBuilder autoAckPingFrame(boolean z) {
        return (Http2MultiplexCodecBuilder) super.autoAckPingFrame(z);
    }

    public Http2MultiplexCodecBuilder autoAckSettingsFrame(boolean z) {
        return (Http2MultiplexCodecBuilder) super.autoAckSettingsFrame(z);
    }

    public int decoderEnforceMaxConsecutiveEmptyDataFrames() {
        return super.decoderEnforceMaxConsecutiveEmptyDataFrames();
    }

    public Http2MultiplexCodecBuilder decoupleCloseAndGoAway(boolean z) {
        return (Http2MultiplexCodecBuilder) super.decoupleCloseAndGoAway(z);
    }

    public boolean encoderEnforceMaxConcurrentStreams() {
        return super.encoderEnforceMaxConcurrentStreams();
    }

    public int encoderEnforceMaxQueuedControlFrames() {
        return super.encoderEnforceMaxQueuedControlFrames();
    }

    public Http2MultiplexCodecBuilder encoderIgnoreMaxHeaderListSize(boolean z) {
        return (Http2MultiplexCodecBuilder) super.encoderIgnoreMaxHeaderListSize(z);
    }

    public Http2MultiplexCodecBuilder flushPreface(boolean z) {
        return (Http2MultiplexCodecBuilder) super.flushPreface(z);
    }

    public Http2FrameLogger frameLogger() {
        return super.frameLogger();
    }

    public long gracefulShutdownTimeoutMillis() {
        return super.gracefulShutdownTimeoutMillis();
    }

    public Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector() {
        return super.headerSensitivityDetector();
    }

    @Deprecated
    public Http2MultiplexCodecBuilder initialHuffmanDecodeCapacity(int i) {
        return (Http2MultiplexCodecBuilder) super.initialHuffmanDecodeCapacity(i);
    }

    public Http2Settings initialSettings() {
        return super.initialSettings();
    }

    public int maxReservedStreams() {
        return super.maxReservedStreams();
    }

    public Http2MultiplexCodecBuilder validateHeaders(boolean z) {
        return (Http2MultiplexCodecBuilder) super.validateHeaders(z);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [io.netty.handler.codec.http2.Http2EmptyDataFrameConnectionDecoder] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.netty.handler.codec.http2.Http2MultiplexCodec build() {
        /*
            r9 = this;
            io.netty.handler.codec.http2.Http2FrameWriter r0 = r9.frameWriter
            if (r0 == 0) goto L_0x008e
            io.netty.handler.codec.http2.DefaultHttp2Connection r2 = new io.netty.handler.codec.http2.DefaultHttp2Connection
            boolean r1 = r9.isServer()
            int r3 = r9.maxReservedStreams()
            r2.<init>(r1, r3)
            io.netty.handler.codec.http2.Http2Settings r1 = r9.initialSettings()
            java.lang.Long r1 = r1.maxHeaderListSize()
            io.netty.handler.codec.http2.DefaultHttp2FrameReader r3 = new io.netty.handler.codec.http2.DefaultHttp2FrameReader
            if (r1 != 0) goto L_0x0027
            io.netty.handler.codec.http2.DefaultHttp2HeadersDecoder r1 = new io.netty.handler.codec.http2.DefaultHttp2HeadersDecoder
            boolean r4 = r9.isValidateHeaders()
            r1.<init>(r4)
            goto L_0x0035
        L_0x0027:
            io.netty.handler.codec.http2.DefaultHttp2HeadersDecoder r4 = new io.netty.handler.codec.http2.DefaultHttp2HeadersDecoder
            boolean r5 = r9.isValidateHeaders()
            long r6 = r1.longValue()
            r4.<init>((boolean) r5, (long) r6)
            r1 = r4
        L_0x0035:
            r3.<init>((io.netty.handler.codec.http2.Http2HeadersDecoder) r1)
            io.netty.handler.codec.http2.Http2FrameLogger r1 = r9.frameLogger()
            if (r1 == 0) goto L_0x0053
            io.netty.handler.codec.http2.Http2OutboundFrameLogger r1 = new io.netty.handler.codec.http2.Http2OutboundFrameLogger
            io.netty.handler.codec.http2.Http2FrameLogger r4 = r9.frameLogger()
            r1.<init>(r0, r4)
            io.netty.handler.codec.http2.Http2InboundFrameLogger r0 = new io.netty.handler.codec.http2.Http2InboundFrameLogger
            io.netty.handler.codec.http2.Http2FrameLogger r4 = r9.frameLogger()
            r0.<init>(r3, r4)
            r4 = r0
            r0 = r1
            goto L_0x0054
        L_0x0053:
            r4 = r3
        L_0x0054:
            io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder r1 = new io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder
            r1.<init>(r2, r0)
            boolean r0 = r9.encoderEnforceMaxConcurrentStreams()
            if (r0 == 0) goto L_0x0065
            io.netty.handler.codec.http2.StreamBufferingEncoder r0 = new io.netty.handler.codec.http2.StreamBufferingEncoder
            r0.<init>(r1)
            goto L_0x0066
        L_0x0065:
            r0 = r1
        L_0x0066:
            io.netty.handler.codec.http2.DefaultHttp2ConnectionDecoder r8 = new io.netty.handler.codec.http2.DefaultHttp2ConnectionDecoder
            io.netty.handler.codec.http2.Http2PromisedRequestVerifier r5 = r9.promisedRequestVerifier()
            boolean r6 = r9.isAutoAckSettingsFrame()
            boolean r7 = r9.isAutoAckPingFrame()
            r1 = r8
            r3 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            int r1 = r9.decoderEnforceMaxConsecutiveEmptyDataFrames()
            if (r1 <= 0) goto L_0x0085
            io.netty.handler.codec.http2.Http2EmptyDataFrameConnectionDecoder r2 = new io.netty.handler.codec.http2.Http2EmptyDataFrameConnectionDecoder
            r2.<init>(r8, r1)
            r8 = r2
        L_0x0085:
            io.netty.handler.codec.http2.Http2Settings r1 = r9.initialSettings()
            io.netty.handler.codec.http2.Http2MultiplexCodec r9 = r9.build((io.netty.handler.codec.http2.Http2ConnectionDecoder) r8, (io.netty.handler.codec.http2.Http2ConnectionEncoder) r0, (io.netty.handler.codec.http2.Http2Settings) r1)
            return r9
        L_0x008e:
            io.netty.handler.codec.http2.Http2ConnectionHandler r9 = super.build()
            io.netty.handler.codec.http2.Http2MultiplexCodec r9 = (io.netty.handler.codec.http2.Http2MultiplexCodec) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.Http2MultiplexCodecBuilder.build():io.netty.handler.codec.http2.Http2MultiplexCodec");
    }

    public Http2MultiplexCodecBuilder decoderEnforceMaxConsecutiveEmptyDataFrames(int i) {
        return (Http2MultiplexCodecBuilder) super.decoderEnforceMaxConsecutiveEmptyDataFrames(i);
    }

    public Http2MultiplexCodecBuilder encoderEnforceMaxConcurrentStreams(boolean z) {
        return (Http2MultiplexCodecBuilder) super.encoderEnforceMaxConcurrentStreams(z);
    }

    public Http2MultiplexCodecBuilder encoderEnforceMaxQueuedControlFrames(int i) {
        return (Http2MultiplexCodecBuilder) super.encoderEnforceMaxQueuedControlFrames(i);
    }

    public Http2MultiplexCodecBuilder frameLogger(Http2FrameLogger http2FrameLogger) {
        return (Http2MultiplexCodecBuilder) super.frameLogger(http2FrameLogger);
    }

    public Http2MultiplexCodecBuilder gracefulShutdownTimeoutMillis(long j) {
        return (Http2MultiplexCodecBuilder) super.gracefulShutdownTimeoutMillis(j);
    }

    public Http2MultiplexCodecBuilder headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        return (Http2MultiplexCodecBuilder) super.headerSensitivityDetector(sensitivityDetector);
    }

    public Http2MultiplexCodecBuilder initialSettings(Http2Settings http2Settings) {
        return (Http2MultiplexCodecBuilder) super.initialSettings(http2Settings);
    }

    public Http2MultiplexCodecBuilder maxReservedStreams(int i) {
        return (Http2MultiplexCodecBuilder) super.maxReservedStreams(i);
    }

    public Http2MultiplexCodec build(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) {
        Http2MultiplexCodec http2MultiplexCodec = new Http2MultiplexCodec(http2ConnectionEncoder, http2ConnectionDecoder, http2Settings, this.childHandler, this.upgradeStreamHandler, decoupleCloseAndGoAway(), flushPreface());
        http2MultiplexCodec.gracefulShutdownTimeoutMillis(gracefulShutdownTimeoutMillis());
        return http2MultiplexCodec;
    }
}
