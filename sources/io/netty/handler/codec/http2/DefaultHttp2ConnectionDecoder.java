package io.netty.handler.codec.http2;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.here.posclient.UpdateOptions;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2FrameReader;
import io.netty.handler.codec.http2.Http2HeadersDecoder;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.List;

public class DefaultHttp2ConnectionDecoder implements Http2ConnectionDecoder {
    /* access modifiers changed from: private */
    public static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultHttp2ConnectionDecoder.class);
    /* access modifiers changed from: private */
    public final boolean autoAckPing;
    /* access modifiers changed from: private */
    public final Http2Connection connection;
    /* access modifiers changed from: private */
    public final Http2Connection.PropertyKey contentLengthKey;
    /* access modifiers changed from: private */
    public final Http2ConnectionEncoder encoder;
    /* access modifiers changed from: private */
    public final Http2FrameReader frameReader;
    /* access modifiers changed from: private */
    public Http2FrameListener internalFrameListener;
    /* access modifiers changed from: private */
    public Http2LifecycleManager lifecycleManager;
    /* access modifiers changed from: private */
    public Http2FrameListener listener;
    /* access modifiers changed from: private */
    public final Http2PromisedRequestVerifier requestVerifier;
    /* access modifiers changed from: private */
    public final Http2SettingsReceivedConsumer settingsReceivedConsumer;

    /* renamed from: io.netty.handler.codec.http2.DefaultHttp2ConnectionDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.netty.handler.codec.http2.Http2Stream$State[] r0 = io.netty.handler.codec.http2.Http2Stream.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = r0
                io.netty.handler.codec.http2.Http2Stream$State r1 = io.netty.handler.codec.http2.Http2Stream.State.OPEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.http2.Http2Stream$State r1 = io.netty.handler.codec.http2.Http2Stream.State.HALF_CLOSED_LOCAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.http2.Http2Stream$State r1 = io.netty.handler.codec.http2.Http2Stream.State.HALF_CLOSED_REMOTE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.http2.Http2Stream$State r1 = io.netty.handler.codec.http2.Http2Stream.State.CLOSED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.http2.Http2Stream$State r1 = io.netty.handler.codec.http2.Http2Stream.State.RESERVED_REMOTE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.netty.handler.codec.http2.Http2Stream$State r1 = io.netty.handler.codec.http2.Http2Stream.State.IDLE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2ConnectionDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class ContentLength {
        private final long expected;
        private long seen;

        public ContentLength(long j) {
            this.expected = j;
        }

        public void increaseReceivedBytes(boolean z, int i, int i2, boolean z2) throws Http2Exception {
            long j = this.seen + ((long) i2);
            this.seen = j;
            if (j >= 0) {
                long j2 = this.expected;
                if (j > j2) {
                    throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Received amount of data %d does not match content-length header %d", Long.valueOf(j), Long.valueOf(this.expected));
                } else if (!z2) {
                } else {
                    if ((j != 0 || z) && j2 > j) {
                        throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Received amount of data %d does not match content-length header %d", Long.valueOf(j), Long.valueOf(this.expected));
                    }
                }
            } else {
                throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Received amount of data did overflow and so not match content-length header %d", Long.valueOf(this.expected));
            }
        }
    }

    public final class FrameReadListener implements Http2FrameListener {
        private FrameReadListener() {
        }

        private void applyLocalSettings(Http2Settings http2Settings) throws Http2Exception {
            Boolean pushEnabled = http2Settings.pushEnabled();
            Http2FrameReader.Configuration configuration = DefaultHttp2ConnectionDecoder.this.frameReader.configuration();
            Http2HeadersDecoder.Configuration headersConfiguration = configuration.headersConfiguration();
            Http2FrameSizePolicy frameSizePolicy = configuration.frameSizePolicy();
            if (pushEnabled != null) {
                if (!DefaultHttp2ConnectionDecoder.this.connection.isServer()) {
                    DefaultHttp2ConnectionDecoder.this.connection.local().allowPushTo(pushEnabled.booleanValue());
                } else {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server sending SETTINGS frame with ENABLE_PUSH specified", new Object[0]);
                }
            }
            Long maxConcurrentStreams = http2Settings.maxConcurrentStreams();
            if (maxConcurrentStreams != null) {
                DefaultHttp2ConnectionDecoder.this.connection.remote().maxActiveStreams((int) Math.min(maxConcurrentStreams.longValue(), UpdateOptions.SOURCE_ANY));
            }
            Long headerTableSize = http2Settings.headerTableSize();
            if (headerTableSize != null) {
                headersConfiguration.maxHeaderTableSize(headerTableSize.longValue());
            }
            Long maxHeaderListSize = http2Settings.maxHeaderListSize();
            if (maxHeaderListSize != null) {
                headersConfiguration.maxHeaderListSize(maxHeaderListSize.longValue(), DefaultHttp2ConnectionDecoder.this.calculateMaxHeaderListSizeGoAway(maxHeaderListSize.longValue()));
            }
            Integer maxFrameSize = http2Settings.maxFrameSize();
            if (maxFrameSize != null) {
                frameSizePolicy.maxFrameSize(maxFrameSize.intValue());
            }
            Integer initialWindowSize = http2Settings.initialWindowSize();
            if (initialWindowSize != null) {
                DefaultHttp2ConnectionDecoder.this.flowController().initialWindowSize(initialWindowSize.intValue());
            }
        }

        private boolean shouldIgnoreHeadersOrDataFrame(ChannelHandlerContext channelHandlerContext, int i, Http2Stream http2Stream, String str) throws Http2Exception {
            String str2;
            if (http2Stream == null) {
                if (streamCreatedAfterGoAwaySent(i)) {
                    DefaultHttp2ConnectionDecoder.logger.info("{} ignoring {} frame for stream {}. Stream sent after GOAWAY sent", channelHandlerContext.channel(), str, Integer.valueOf(i));
                    return true;
                }
                verifyStreamMayHaveExisted(i);
                throw Http2Exception.streamError(i, Http2Error.STREAM_CLOSED, "Received %s frame for an unknown stream %d", str, Integer.valueOf(i));
            } else if (!http2Stream.isResetSent() && !streamCreatedAfterGoAwaySent(i)) {
                return false;
            } else {
                if (DefaultHttp2ConnectionDecoder.logger.isInfoEnabled()) {
                    InternalLogger access$1200 = DefaultHttp2ConnectionDecoder.logger;
                    Channel channel = channelHandlerContext.channel();
                    if (http2Stream.isResetSent()) {
                        str2 = "RST_STREAM sent.";
                    } else {
                        str2 = "Stream created after GOAWAY sent. Last known stream by peer " + DefaultHttp2ConnectionDecoder.this.connection.remote().lastStreamKnownByPeer();
                    }
                    access$1200.info("{} ignoring {} frame for stream {}", channel, str, str2);
                }
                return true;
            }
        }

        private boolean streamCreatedAfterGoAwaySent(int i) {
            Http2Connection.Endpoint<Http2RemoteFlowController> remote = DefaultHttp2ConnectionDecoder.this.connection.remote();
            return DefaultHttp2ConnectionDecoder.this.connection.goAwaySent() && remote.isValidStreamId(i) && i > remote.lastStreamKnownByPeer();
        }

        private void verifyStreamMayHaveExisted(int i) throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.connection.streamMayHaveExisted(i)) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d does not exist", Integer.valueOf(i));
            }
        }

        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z) throws Http2Exception {
            int i3 = i;
            ByteBuf byteBuf2 = byteBuf;
            int i4 = i2;
            boolean z2 = z;
            Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i3);
            Http2LocalFlowController flowController = DefaultHttp2ConnectionDecoder.this.flowController();
            int readableBytes = byteBuf.readableBytes();
            int i5 = readableBytes + i4;
            try {
                if (shouldIgnoreHeadersOrDataFrame(channelHandlerContext, i3, stream, "DATA")) {
                    flowController.receiveFlowControlledFrame(stream, byteBuf2, i4, z2);
                    flowController.consumeBytes(stream, i5);
                    verifyStreamMayHaveExisted(i3);
                    return i5;
                }
                int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[stream.state().ordinal()];
                Http2Exception streamError = (i6 == 1 || i6 == 2) ? null : (i6 == 3 || i6 == 4) ? Http2Exception.streamError(stream.id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", Integer.valueOf(stream.id()), stream.state()) : Http2Exception.streamError(stream.id(), Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state: %s", Integer.valueOf(stream.id()), stream.state());
                int access$200 = DefaultHttp2ConnectionDecoder.this.unconsumedBytes(stream);
                try {
                    flowController.receiveFlowControlledFrame(stream, byteBuf2, i4, z2);
                    int access$2002 = DefaultHttp2ConnectionDecoder.this.unconsumedBytes(stream);
                    if (streamError == null) {
                        try {
                            DefaultHttp2ConnectionDecoder.this.verifyContentLength(stream, readableBytes, z2);
                            int onDataRead = DefaultHttp2ConnectionDecoder.this.listener.onDataRead(channelHandlerContext, i, byteBuf, i2, z);
                            if (z2) {
                                DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStreamRemote(stream, channelHandlerContext.newSucceededFuture());
                            }
                            flowController.consumeBytes(stream, onDataRead);
                            return onDataRead;
                        } catch (Http2Exception e) {
                            e = e;
                            access$200 = access$2002;
                        } catch (RuntimeException e2) {
                            e = e2;
                            access$200 = access$2002;
                            try {
                                int access$2003 = i5 - (access$200 - DefaultHttp2ConnectionDecoder.this.unconsumedBytes(stream));
                                throw e;
                            } catch (Throwable th) {
                                flowController.consumeBytes(stream, i5);
                                throw th;
                            }
                        }
                    } else {
                        throw streamError;
                    }
                } catch (Http2Exception e3) {
                    e = e3;
                    int access$2004 = i5 - (access$200 - DefaultHttp2ConnectionDecoder.this.unconsumedBytes(stream));
                    throw e;
                } catch (RuntimeException e4) {
                    e = e4;
                    int access$20032 = i5 - (access$200 - DefaultHttp2ConnectionDecoder.this.unconsumedBytes(stream));
                    throw e;
                }
            } catch (Http2Exception e5) {
                flowController.receiveFlowControlledFrame(stream, byteBuf2, i4, z2);
                flowController.consumeBytes(stream, i5);
                throw e5;
            } catch (Throwable th2) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th2, "Unhandled error on data stream id %d", Integer.valueOf(i));
            }
        }

        public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onGoAwayRead0(channelHandlerContext, i, j, byteBuf);
        }

        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z) throws Http2Exception {
            onHeadersRead(channelHandlerContext, i, http2Headers, 0, 16, false, i2, z);
        }

        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.listener.onPingAckRead(channelHandlerContext, j);
        }

        public void onPingRead(ChannelHandlerContext channelHandlerContext, long j) throws Http2Exception {
            if (DefaultHttp2ConnectionDecoder.this.autoAckPing) {
                DefaultHttp2ConnectionDecoder.this.encoder.writePing(channelHandlerContext, true, j, channelHandlerContext.newPromise());
            }
            DefaultHttp2ConnectionDecoder.this.listener.onPingRead(channelHandlerContext, j);
        }

        public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.encoder.flowController().updateDependencyTree(i, i2, s, z);
            DefaultHttp2ConnectionDecoder.this.listener.onPriorityRead(channelHandlerContext, i, i2, s, z);
        }

        public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i3) throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.connection().isServer()) {
                Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i);
                if (!shouldIgnoreHeadersOrDataFrame(channelHandlerContext, i, stream, "PUSH_PROMISE")) {
                    int i4 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[stream.state().ordinal()];
                    if (i4 != 1 && i4 != 2) {
                        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state for receiving push promise: %s", Integer.valueOf(stream.id()), stream.state());
                    } else if (!DefaultHttp2ConnectionDecoder.this.requestVerifier.isAuthoritative(channelHandlerContext, http2Headers)) {
                        throw Http2Exception.streamError(i2, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not authoritative", Integer.valueOf(i), Integer.valueOf(i2));
                    } else if (!DefaultHttp2ConnectionDecoder.this.requestVerifier.isCacheable(http2Headers)) {
                        throw Http2Exception.streamError(i2, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not known to be cacheable", Integer.valueOf(i), Integer.valueOf(i2));
                    } else if (DefaultHttp2ConnectionDecoder.this.requestVerifier.isSafe(http2Headers)) {
                        DefaultHttp2ConnectionDecoder.this.connection.remote().reservePushStream(i2, stream);
                        DefaultHttp2ConnectionDecoder.this.listener.onPushPromiseRead(channelHandlerContext, i, i2, http2Headers, i3);
                    } else {
                        throw Http2Exception.streamError(i2, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not known to be safe", Integer.valueOf(i), Integer.valueOf(i2));
                    }
                }
            } else {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A client cannot push.", new Object[0]);
            }
        }

        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i, long j) throws Http2Exception {
            Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i);
            if (stream == null) {
                verifyStreamMayHaveExisted(i);
                return;
            }
            int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[stream.state().ordinal()];
            if (i2 == 4) {
                return;
            }
            if (i2 != 6) {
                DefaultHttp2ConnectionDecoder.this.listener.onRstStreamRead(channelHandlerContext, i, j);
                DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStream(stream, channelHandlerContext.newSucceededFuture());
                return;
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "RST_STREAM received for IDLE stream %d", Integer.valueOf(i));
        }

        public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
            Http2Settings pollSentSettings = DefaultHttp2ConnectionDecoder.this.encoder.pollSentSettings();
            if (pollSentSettings != null) {
                applyLocalSettings(pollSentSettings);
            }
            DefaultHttp2ConnectionDecoder.this.listener.onSettingsAckRead(channelHandlerContext);
        }

        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
            if (DefaultHttp2ConnectionDecoder.this.settingsReceivedConsumer == null) {
                DefaultHttp2ConnectionDecoder.this.encoder.writeSettingsAck(channelHandlerContext, channelHandlerContext.newPromise());
                DefaultHttp2ConnectionDecoder.this.encoder.remoteSettings(http2Settings);
            } else {
                DefaultHttp2ConnectionDecoder.this.settingsReceivedConsumer.consumeReceivedSettings(http2Settings);
            }
            DefaultHttp2ConnectionDecoder.this.listener.onSettingsRead(channelHandlerContext, http2Settings);
        }

        public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onUnknownFrame0(channelHandlerContext, b, i, http2Flags, byteBuf);
        }

        public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i, int i2) throws Http2Exception {
            Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i);
            if (stream == null || stream.state() == Http2Stream.State.CLOSED || streamCreatedAfterGoAwaySent(i)) {
                verifyStreamMayHaveExisted(i);
                return;
            }
            DefaultHttp2ConnectionDecoder.this.encoder.flowController().incrementWindowSize(stream, i2);
            DefaultHttp2ConnectionDecoder.this.listener.onWindowUpdateRead(channelHandlerContext, i, i2);
        }

        public /* synthetic */ FrameReadListener(DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder, AnonymousClass1 r2) {
            this();
        }

        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2) throws Http2Exception {
            Http2Stream http2Stream;
            boolean z3;
            boolean z4;
            AsciiString asciiString;
            List all;
            int i4 = i;
            Http2Headers http2Headers2 = http2Headers;
            boolean z5 = z2;
            Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i4);
            if (stream == null && !DefaultHttp2ConnectionDecoder.this.connection.streamMayHaveExisted(i4)) {
                Http2Stream createStream = DefaultHttp2ConnectionDecoder.this.connection.remote().createStream(i4, z5);
                z3 = createStream.state() == Http2Stream.State.HALF_CLOSED_REMOTE;
                http2Stream = createStream;
                z4 = false;
            } else if (stream != null) {
                http2Stream = stream;
                z4 = stream.isHeadersReceived();
                z3 = false;
            } else {
                http2Stream = stream;
                z4 = false;
                z3 = false;
            }
            if (!shouldIgnoreHeadersOrDataFrame(channelHandlerContext, i4, http2Stream, "HEADERS")) {
                boolean z6 = !DefaultHttp2ConnectionDecoder.this.connection.isServer() && HttpStatusClass.valueOf(http2Headers.status()) == HttpStatusClass.INFORMATIONAL;
                if (((z6 || !z5) && http2Stream.isHeadersReceived()) || http2Stream.isTrailersReceived()) {
                    throw Http2Exception.streamError(i4, Http2Error.PROTOCOL_ERROR, "Stream %d received too many headers EOS: %s state: %s", Integer.valueOf(i), Boolean.valueOf(z2), http2Stream.state());
                }
                int i5 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2Stream.state().ordinal()];
                if (!(i5 == 1 || i5 == 2)) {
                    if (i5 != 3) {
                        if (i5 == 4) {
                            throw Http2Exception.streamError(http2Stream.id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", Integer.valueOf(http2Stream.id()), http2Stream.state());
                        } else if (i5 == 5) {
                            http2Stream.open(z5);
                        } else {
                            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state: %s", Integer.valueOf(http2Stream.id()), http2Stream.state());
                        }
                    } else if (!z3) {
                        throw Http2Exception.streamError(http2Stream.id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", Integer.valueOf(http2Stream.id()), http2Stream.state());
                    }
                }
                if (!z4 && (all = http2Headers2.getAll(asciiString)) != null && !all.isEmpty()) {
                    try {
                        long normalizeAndGetContentLength = HttpUtil.normalizeAndGetContentLength(all, false, true);
                        if (normalizeAndGetContentLength != -1) {
                            http2Headers2.setLong((asciiString = HttpHeaderNames.CONTENT_LENGTH), normalizeAndGetContentLength);
                            http2Stream.setProperty(DefaultHttp2ConnectionDecoder.this.contentLengthKey, new ContentLength(normalizeAndGetContentLength));
                        }
                    } catch (IllegalArgumentException e) {
                        throw Http2Exception.streamError(http2Stream.id(), Http2Error.PROTOCOL_ERROR, e, "Multiple content-length headers received", new Object[0]);
                    }
                }
                http2Stream.headersReceived(z6);
                DefaultHttp2ConnectionDecoder.this.verifyContentLength(http2Stream, 0, z5);
                int i6 = i2;
                short s2 = s;
                boolean z7 = z;
                DefaultHttp2ConnectionDecoder.this.encoder.flowController().updateDependencyTree(i4, i6, s2, z7);
                DefaultHttp2ConnectionDecoder.this.listener.onHeadersRead(channelHandlerContext, i, http2Headers, i6, s2, z7, i3, z2);
                if (z5) {
                    DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStreamRemote(http2Stream, channelHandlerContext.newSucceededFuture());
                }
            }
        }
    }

    public final class PrefaceFrameListener implements Http2FrameListener {
        private PrefaceFrameListener() {
        }

        private void verifyPrefaceReceived() throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.prefaceReceived()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received non-SETTINGS as first frame.", new Object[0]);
            }
        }

        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z) throws Http2Exception {
            verifyPrefaceReceived();
            return DefaultHttp2ConnectionDecoder.this.internalFrameListener.onDataRead(channelHandlerContext, i, byteBuf, i2, z);
        }

        public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onGoAwayRead0(channelHandlerContext, i, j, byteBuf);
        }

        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onHeadersRead(channelHandlerContext, i, http2Headers, i2, z);
        }

        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPingAckRead(channelHandlerContext, j);
        }

        public void onPingRead(ChannelHandlerContext channelHandlerContext, long j) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPingRead(channelHandlerContext, j);
        }

        public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPriorityRead(channelHandlerContext, i, i2, s, z);
        }

        public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i3) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPushPromiseRead(channelHandlerContext, i, i2, http2Headers, i3);
        }

        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i, long j) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onRstStreamRead(channelHandlerContext, i, j);
        }

        public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onSettingsAckRead(channelHandlerContext);
        }

        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.prefaceReceived()) {
                DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder = DefaultHttp2ConnectionDecoder.this;
                Http2FrameListener unused = defaultHttp2ConnectionDecoder.internalFrameListener = new FrameReadListener(defaultHttp2ConnectionDecoder, (AnonymousClass1) null);
            }
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onSettingsRead(channelHandlerContext, http2Settings);
        }

        public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onUnknownFrame0(channelHandlerContext, b, i, http2Flags, byteBuf);
        }

        public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i, int i2) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onWindowUpdateRead(channelHandlerContext, i, i2);
        }

        public /* synthetic */ PrefaceFrameListener(DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder, AnonymousClass1 r2) {
            this();
        }

        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onHeadersRead(channelHandlerContext, i, http2Headers, i2, s, z, i3, z2);
        }
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader) {
        this(http2Connection, http2ConnectionEncoder, http2FrameReader, Http2PromisedRequestVerifier.ALWAYS_VERIFY);
    }

    /* access modifiers changed from: private */
    public int unconsumedBytes(Http2Stream http2Stream) {
        return flowController().unconsumedBytes(http2Stream);
    }

    /* access modifiers changed from: private */
    public void verifyContentLength(Http2Stream http2Stream, int i, boolean z) throws Http2Exception {
        ContentLength contentLength = (ContentLength) http2Stream.getProperty(this.contentLengthKey);
        if (contentLength != null) {
            try {
                contentLength.increaseReceivedBytes(this.connection.isServer(), http2Stream.id(), i, z);
            } finally {
                if (z) {
                    http2Stream.removeProperty(this.contentLengthKey);
                }
            }
        }
    }

    public long calculateMaxHeaderListSizeGoAway(long j) {
        return Http2CodecUtil.calculateMaxHeaderListSizeGoAway(j);
    }

    public void close() {
        this.frameReader.close();
    }

    public Http2Connection connection() {
        return this.connection;
    }

    public void decodeFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Http2Exception {
        this.frameReader.readFrame(channelHandlerContext, byteBuf, this.internalFrameListener);
    }

    public final Http2LocalFlowController flowController() {
        return this.connection.local().flowController();
    }

    public void frameListener(Http2FrameListener http2FrameListener) {
        this.listener = (Http2FrameListener) ObjectUtil.checkNotNull(http2FrameListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.lifecycleManager = (Http2LifecycleManager) ObjectUtil.checkNotNull(http2LifecycleManager, "lifecycleManager");
    }

    public Http2Settings localSettings() {
        Http2Settings http2Settings = new Http2Settings();
        Http2FrameReader.Configuration configuration = this.frameReader.configuration();
        Http2HeadersDecoder.Configuration headersConfiguration = configuration.headersConfiguration();
        Http2FrameSizePolicy frameSizePolicy = configuration.frameSizePolicy();
        http2Settings.initialWindowSize(flowController().initialWindowSize());
        http2Settings.maxConcurrentStreams((long) this.connection.remote().maxActiveStreams());
        http2Settings.headerTableSize(headersConfiguration.maxHeaderTableSize());
        http2Settings.maxFrameSize(frameSizePolicy.maxFrameSize());
        http2Settings.maxHeaderListSize(headersConfiguration.maxHeaderListSize());
        if (!this.connection.isServer()) {
            http2Settings.pushEnabled(this.connection.local().allowPushTo());
        }
        return http2Settings;
    }

    public void onGoAwayRead0(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf) throws Http2Exception {
        this.listener.onGoAwayRead(channelHandlerContext, i, j, byteBuf);
        this.connection.goAwayReceived(i, j, byteBuf);
    }

    public void onUnknownFrame0(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
        this.listener.onUnknownFrame(channelHandlerContext, b, i, http2Flags, byteBuf);
    }

    public boolean prefaceReceived() {
        return FrameReadListener.class == this.internalFrameListener.getClass();
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader, Http2PromisedRequestVerifier http2PromisedRequestVerifier) {
        this(http2Connection, http2ConnectionEncoder, http2FrameReader, http2PromisedRequestVerifier, true);
    }

    public Http2FrameListener frameListener() {
        return this.listener;
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader, Http2PromisedRequestVerifier http2PromisedRequestVerifier, boolean z) {
        this(http2Connection, http2ConnectionEncoder, http2FrameReader, http2PromisedRequestVerifier, z, true);
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader, Http2PromisedRequestVerifier http2PromisedRequestVerifier, boolean z, boolean z2) {
        this.internalFrameListener = new PrefaceFrameListener(this, (AnonymousClass1) null);
        this.autoAckPing = z2;
        if (z) {
            this.settingsReceivedConsumer = null;
        } else if (http2ConnectionEncoder instanceof Http2SettingsReceivedConsumer) {
            this.settingsReceivedConsumer = (Http2SettingsReceivedConsumer) http2ConnectionEncoder;
        } else {
            throw new IllegalArgumentException("disabling autoAckSettings requires the encoder to be a " + Http2SettingsReceivedConsumer.class);
        }
        Http2Connection http2Connection2 = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        this.connection = http2Connection2;
        this.contentLengthKey = http2Connection2.newKey();
        this.frameReader = (Http2FrameReader) ObjectUtil.checkNotNull(http2FrameReader, "frameReader");
        this.encoder = (Http2ConnectionEncoder) ObjectUtil.checkNotNull(http2ConnectionEncoder, "encoder");
        this.requestVerifier = (Http2PromisedRequestVerifier) ObjectUtil.checkNotNull(http2PromisedRequestVerifier, "requestVerifier");
        if (http2Connection.local().flowController() == null) {
            http2Connection.local().flowController(new DefaultHttp2LocalFlowController(http2Connection));
        }
        http2Connection.local().flowController().frameWriter(http2ConnectionEncoder.frameWriter());
    }
}
