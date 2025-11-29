package io.netty.handler.codec.http2;

import com.here.posclient.UpdateOptions;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2RemoteFlowController;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.handler.codec.http2.HttpConversionUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class Http2FrameCodec extends Http2ConnectionHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger LOG = InternalLoggerFactory.getInstance((Class<?>) Http2FrameCodec.class);
    ChannelHandlerContext ctx;
    /* access modifiers changed from: private */
    public final IntObjectMap<DefaultHttp2FrameStream> frameStreamToInitializeMap = new IntObjectHashMap(8);
    private final Integer initialFlowControlWindowSize;
    private int numBufferedStreams;
    protected final Http2Connection.PropertyKey streamKey;
    private final Http2Connection.PropertyKey upgradeKey;

    public final class ConnectionListener extends Http2ConnectionAdapter {
        private ConnectionListener() {
        }

        private void onHttp2StreamStateChanged0(Http2Stream http2Stream) {
            DefaultHttp2FrameStream defaultHttp2FrameStream = (DefaultHttp2FrameStream) http2Stream.getProperty(Http2FrameCodec.this.streamKey);
            if (defaultHttp2FrameStream != null) {
                Http2FrameCodec http2FrameCodec = Http2FrameCodec.this;
                http2FrameCodec.onHttp2StreamStateChanged(http2FrameCodec.ctx, defaultHttp2FrameStream);
            }
        }

        public void onStreamActive(Http2Stream http2Stream) {
            Http2FrameCodec.this.onStreamActive0(http2Stream);
        }

        public void onStreamAdded(Http2Stream http2Stream) {
            DefaultHttp2FrameStream defaultHttp2FrameStream = (DefaultHttp2FrameStream) Http2FrameCodec.this.frameStreamToInitializeMap.remove(http2Stream.id());
            if (defaultHttp2FrameStream != null) {
                defaultHttp2FrameStream.setStreamAndProperty(Http2FrameCodec.this.streamKey, http2Stream);
            }
        }

        public void onStreamClosed(Http2Stream http2Stream) {
            onHttp2StreamStateChanged0(http2Stream);
        }

        public void onStreamHalfClosed(Http2Stream http2Stream) {
            onHttp2StreamStateChanged0(http2Stream);
        }
    }

    public static class DefaultHttp2FrameStream implements Http2FrameStream {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        Channel attachment;
        /* access modifiers changed from: private */
        public volatile int id = -1;
        final Http2FrameStreamEvent stateChanged = Http2FrameStreamEvent.stateChanged(this);
        private volatile Http2Stream stream;
        final Http2FrameStreamEvent writabilityChanged = Http2FrameStreamEvent.writabilityChanged(this);

        public int id() {
            Http2Stream http2Stream = this.stream;
            return http2Stream == null ? this.id : http2Stream.id();
        }

        public DefaultHttp2FrameStream setStreamAndProperty(Http2Connection.PropertyKey propertyKey, Http2Stream http2Stream) {
            this.stream = http2Stream;
            http2Stream.setProperty(propertyKey, this);
            return this;
        }

        public Http2Stream.State state() {
            Http2Stream http2Stream = this.stream;
            return http2Stream == null ? Http2Stream.State.IDLE : http2Stream.state();
        }

        public String toString() {
            return String.valueOf(id());
        }
    }

    public final class FrameListener implements Http2FrameListener {
        private FrameListener() {
        }

        private Http2FrameStream requireStream(int i) {
            Http2FrameStream http2FrameStream = (Http2FrameStream) Http2FrameCodec.this.connection().stream(i).getProperty(Http2FrameCodec.this.streamKey);
            if (http2FrameStream != null) {
                return http2FrameStream;
            }
            throw new IllegalStateException("Stream object required for identifier: " + i);
        }

        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z) {
            Http2FrameCodec.this.onHttp2Frame(channelHandlerContext, new DefaultHttp2DataFrame(byteBuf, z, i2).stream(requireStream(i)).retain());
            return 0;
        }

        public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf) {
            Http2FrameCodec.this.onHttp2Frame(channelHandlerContext, new DefaultHttp2GoAwayFrame(i, j, byteBuf).retain());
        }

        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2) {
            onHeadersRead(channelHandlerContext, i, http2Headers, i3, z2);
        }

        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j) {
            Http2FrameCodec.this.onHttp2Frame(channelHandlerContext, new DefaultHttp2PingFrame(j, true));
        }

        public void onPingRead(ChannelHandlerContext channelHandlerContext, long j) {
            Http2FrameCodec.this.onHttp2Frame(channelHandlerContext, new DefaultHttp2PingFrame(j, false));
        }

        public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z) {
            if (Http2FrameCodec.this.connection().stream(i) != null) {
                Http2FrameCodec.this.onHttp2Frame(channelHandlerContext, new DefaultHttp2PriorityFrame(i2, s, z).stream(requireStream(i)));
            }
        }

        public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i3) {
            Http2FrameCodec http2FrameCodec = Http2FrameCodec.this;
            DefaultHttp2PushPromiseFrame defaultHttp2PushPromiseFrame = new DefaultHttp2PushPromiseFrame(http2Headers, i3, i2);
            DefaultHttp2FrameStream defaultHttp2FrameStream = new DefaultHttp2FrameStream();
            Http2FrameCodec http2FrameCodec2 = Http2FrameCodec.this;
            http2FrameCodec.onHttp2Frame(channelHandlerContext, defaultHttp2PushPromiseFrame.pushStream(defaultHttp2FrameStream.setStreamAndProperty(http2FrameCodec2.streamKey, http2FrameCodec2.connection().stream(i2))).stream(requireStream(i)));
        }

        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i, long j) {
            Http2FrameCodec.this.onHttp2Frame(channelHandlerContext, new DefaultHttp2ResetFrame(j).stream(requireStream(i)));
        }

        public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) {
            Http2FrameCodec.this.onHttp2Frame(channelHandlerContext, Http2SettingsAckFrame.INSTANCE);
        }

        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) {
            Http2FrameCodec.this.onHttp2Frame(channelHandlerContext, new DefaultHttp2SettingsFrame(http2Settings));
        }

        public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf) {
            if (i != 0) {
                Http2FrameCodec.this.onHttp2Frame(channelHandlerContext, new DefaultHttp2UnknownFrame(b, http2Flags, byteBuf).stream(requireStream(i)).retain());
            }
        }

        public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i, int i2) {
            if (i != 0) {
                Http2FrameCodec.this.onHttp2Frame(channelHandlerContext, new DefaultHttp2WindowUpdateFrame(i2).stream(requireStream(i)));
            }
        }

        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z) {
            Http2FrameCodec.this.onHttp2Frame(channelHandlerContext, new DefaultHttp2HeadersFrame(http2Headers, z, i2).stream(requireStream(i)));
        }
    }

    public final class Http2RemoteFlowControllerListener implements Http2RemoteFlowController.Listener {
        private Http2RemoteFlowControllerListener() {
        }

        public void writabilityChanged(Http2Stream http2Stream) {
            DefaultHttp2FrameStream defaultHttp2FrameStream = (DefaultHttp2FrameStream) http2Stream.getProperty(Http2FrameCodec.this.streamKey);
            if (defaultHttp2FrameStream != null) {
                Http2FrameCodec http2FrameCodec = Http2FrameCodec.this;
                http2FrameCodec.onHttp2StreamWritabilityChanged(http2FrameCodec.ctx, defaultHttp2FrameStream, http2FrameCodec.connection().remote().flowController().isWritable(http2Stream));
            }
        }
    }

    public Http2FrameCodec(Http2ConnectionEncoder http2ConnectionEncoder, Http2ConnectionDecoder http2ConnectionDecoder, Http2Settings http2Settings, boolean z, boolean z2) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, z, z2);
        http2ConnectionDecoder.frameListener(new FrameListener());
        connection().addListener(new ConnectionListener());
        connection().remote().flowController().listener(new Http2RemoteFlowControllerListener());
        this.streamKey = connection().newKey();
        this.upgradeKey = connection().newKey();
        this.initialFlowControlWindowSize = http2Settings.initialWindowSize();
    }

    public static /* synthetic */ int access$310(Http2FrameCodec http2FrameCodec) {
        int i = http2FrameCodec.numBufferedStreams;
        http2FrameCodec.numBufferedStreams = i - 1;
        return i;
    }

    /* access modifiers changed from: private */
    public void handleHeaderFuture(ChannelFuture channelFuture, int i) {
        if (!channelFuture.isSuccess()) {
            this.frameStreamToInitializeMap.remove(i);
        }
    }

    private void increaseInitialConnectionWindow(int i) throws Http2Exception {
        connection().local().flowController().incrementWindowSize(connection().connectionStream(), i);
    }

    private boolean initializeNewStream(ChannelHandlerContext channelHandlerContext, DefaultHttp2FrameStream defaultHttp2FrameStream, ChannelPromise channelPromise) {
        Http2Connection connection = connection();
        int incrementAndGetNextStreamId = connection.local().incrementAndGetNextStreamId();
        if (incrementAndGetNextStreamId < 0) {
            channelPromise.setFailure(new Http2NoMoreStreamIdsException());
            onHttp2Frame(channelHandlerContext, new DefaultHttp2GoAwayFrame(connection.isServer() ? Integer.MAX_VALUE : 2147483646, Http2Error.NO_ERROR.code(), ByteBufUtil.writeAscii(channelHandlerContext.alloc(), (CharSequence) "Stream IDs exhausted on local stream creation")));
            return false;
        }
        int unused = defaultHttp2FrameStream.id = incrementAndGetNextStreamId;
        this.frameStreamToInitializeMap.put(incrementAndGetNextStreamId, defaultHttp2FrameStream);
        return true;
    }

    /* access modifiers changed from: private */
    public void onHttp2StreamWritabilityChanged(ChannelHandlerContext channelHandlerContext, DefaultHttp2FrameStream defaultHttp2FrameStream, boolean z) {
        channelHandlerContext.fireUserEventTriggered(defaultHttp2FrameStream.writabilityChanged);
    }

    private static void onHttp2UnknownStreamError(ChannelHandlerContext channelHandlerContext, Throwable th, Http2Exception.StreamException streamException) {
        LOG.log(InternalLogLevel.DEBUG, "Stream exception thrown for unknown stream {}.", Integer.valueOf(streamException.streamId()), th);
    }

    /* access modifiers changed from: private */
    public void onStreamActive0(Http2Stream http2Stream) {
        if (http2Stream.id() == 1 || !connection().local().isValidStreamId(http2Stream.id())) {
            onHttp2StreamStateChanged(this.ctx, newStream().setStreamAndProperty(this.streamKey, http2Stream));
        }
    }

    private void onUpgradeEvent(ChannelHandlerContext channelHandlerContext, HttpServerUpgradeHandler.UpgradeEvent upgradeEvent) {
        channelHandlerContext.fireUserEventTriggered(upgradeEvent);
    }

    private void tryExpandConnectionFlowControlWindow(Http2Connection http2Connection) throws Http2Exception {
        if (this.initialFlowControlWindowSize != null) {
            Http2Stream connectionStream = http2Connection.connectionStream();
            Http2LocalFlowController flowController = http2Connection.local().flowController();
            int intValue = this.initialFlowControlWindowSize.intValue() - flowController.initialWindowSize(connectionStream);
            if (intValue > 0) {
                flowController.incrementWindowSize(connectionStream, Math.max(intValue << 1, intValue));
                flush(this.ctx);
            }
        }
    }

    private void writeGoAwayFrame(ChannelHandlerContext channelHandlerContext, Http2GoAwayFrame http2GoAwayFrame, ChannelPromise channelPromise) {
        if (http2GoAwayFrame.lastStreamId() <= -1) {
            long lastStreamCreated = ((long) connection().remote().lastStreamCreated()) + (((long) http2GoAwayFrame.extraStreamIds()) * 2);
            if (lastStreamCreated > UpdateOptions.SOURCE_ANY) {
                lastStreamCreated = 2147483647L;
            }
            goAway(channelHandlerContext, (int) lastStreamCreated, http2GoAwayFrame.errorCode(), http2GoAwayFrame.content(), channelPromise);
            return;
        }
        http2GoAwayFrame.release();
        throw new IllegalArgumentException("Last stream id must not be set on GOAWAY frame");
    }

    private void writeHeadersFrame(ChannelHandlerContext channelHandlerContext, Http2HeadersFrame http2HeadersFrame, ChannelPromise channelPromise) {
        if (Http2CodecUtil.isStreamIdValid(http2HeadersFrame.stream().id())) {
            encoder().writeHeaders(channelHandlerContext, http2HeadersFrame.stream().id(), http2HeadersFrame.headers(), http2HeadersFrame.padding(), http2HeadersFrame.isEndStream(), channelPromise);
        } else if (initializeNewStream(channelHandlerContext, (DefaultHttp2FrameStream) http2HeadersFrame.stream(), channelPromise)) {
            final int id = http2HeadersFrame.stream().id();
            encoder().writeHeaders(channelHandlerContext, id, http2HeadersFrame.headers(), http2HeadersFrame.padding(), http2HeadersFrame.isEndStream(), channelPromise);
            if (!channelPromise.isDone()) {
                this.numBufferedStreams++;
                channelPromise.addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture) {
                        Http2FrameCodec.access$310(Http2FrameCodec.this);
                        Http2FrameCodec.this.handleHeaderFuture(channelFuture, id);
                    }
                });
                return;
            }
            handleHeaderFuture(channelPromise, id);
        }
    }

    private void writePushPromise(ChannelHandlerContext channelHandlerContext, Http2PushPromiseFrame http2PushPromiseFrame, ChannelPromise channelPromise) {
        if (Http2CodecUtil.isStreamIdValid(http2PushPromiseFrame.pushStream().id())) {
            encoder().writePushPromise(channelHandlerContext, http2PushPromiseFrame.stream().id(), http2PushPromiseFrame.pushStream().id(), http2PushPromiseFrame.http2Headers(), http2PushPromiseFrame.padding(), channelPromise);
        } else if (initializeNewStream(channelHandlerContext, (DefaultHttp2FrameStream) http2PushPromiseFrame.pushStream(), channelPromise)) {
            final int id = http2PushPromiseFrame.stream().id();
            encoder().writePushPromise(channelHandlerContext, id, http2PushPromiseFrame.pushStream().id(), http2PushPromiseFrame.http2Headers(), http2PushPromiseFrame.padding(), channelPromise);
            if (channelPromise.isDone()) {
                handleHeaderFuture(channelPromise, id);
                return;
            }
            this.numBufferedStreams++;
            channelPromise.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) {
                    Http2FrameCodec.access$310(Http2FrameCodec.this);
                    Http2FrameCodec.this.handleHeaderFuture(channelFuture, id);
                }
            });
        }
    }

    public final boolean consumeBytes(int i, int i2) throws Http2Exception {
        Http2Stream stream = connection().stream(i);
        if (stream != null && i == 1) {
            if (Boolean.TRUE.equals((Boolean) stream.getProperty(this.upgradeKey))) {
                return false;
            }
        }
        return connection().local().flowController().consumeBytes(stream, i2);
    }

    public final void forEachActiveStream(final Http2FrameStreamVisitor http2FrameStreamVisitor) throws Http2Exception {
        if (connection().numActiveStreams() > 0) {
            connection().forEachActiveStream(new Http2StreamVisitor() {
                public boolean visit(Http2Stream http2Stream) {
                    try {
                        return http2FrameStreamVisitor.visit((Http2FrameStream) http2Stream.getProperty(Http2FrameCodec.this.streamKey));
                    } catch (Throwable th) {
                        Http2FrameCodec http2FrameCodec = Http2FrameCodec.this;
                        http2FrameCodec.onError(http2FrameCodec.ctx, false, th);
                        return false;
                    }
                }
            });
        }
    }

    public final void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        super.handlerAdded(channelHandlerContext);
        handlerAdded0(channelHandlerContext);
        Http2Connection connection = connection();
        if (connection.isServer()) {
            tryExpandConnectionFlowControlWindow(connection);
        }
    }

    public void handlerAdded0(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    public final boolean isGracefulShutdownComplete() {
        return super.isGracefulShutdownComplete() && this.numBufferedStreams == 0;
    }

    public DefaultHttp2FrameStream newStream() {
        return new DefaultHttp2FrameStream();
    }

    public int numInitializingStreams() {
        return this.frameStreamToInitializeMap.size();
    }

    public void onConnectionError(ChannelHandlerContext channelHandlerContext, boolean z, Throwable th, Http2Exception http2Exception) {
        if (!z) {
            channelHandlerContext.fireExceptionCaught(th);
        }
        super.onConnectionError(channelHandlerContext, z, th, http2Exception);
    }

    public void onHttp2Frame(ChannelHandlerContext channelHandlerContext, Http2Frame http2Frame) {
        channelHandlerContext.fireChannelRead(http2Frame);
    }

    public void onHttp2FrameStreamException(ChannelHandlerContext channelHandlerContext, Http2FrameStreamException http2FrameStreamException) {
        channelHandlerContext.fireExceptionCaught(http2FrameStreamException);
    }

    public void onHttp2StreamStateChanged(ChannelHandlerContext channelHandlerContext, DefaultHttp2FrameStream defaultHttp2FrameStream) {
        channelHandlerContext.fireUserEventTriggered(defaultHttp2FrameStream.stateChanged);
    }

    public final void onStreamError(ChannelHandlerContext channelHandlerContext, boolean z, Throwable th, Http2Exception.StreamException streamException) {
        Http2Stream stream = connection().stream(streamException.streamId());
        if (stream == null) {
            onHttp2UnknownStreamError(channelHandlerContext, th, streamException);
            super.onStreamError(channelHandlerContext, z, th, streamException);
            return;
        }
        Http2FrameStream http2FrameStream = (Http2FrameStream) stream.getProperty(this.streamKey);
        if (http2FrameStream == null) {
            LOG.warn("Stream exception thrown without stream object attached.", th);
            super.onStreamError(channelHandlerContext, z, th, streamException);
        } else if (!z) {
            onHttp2FrameStreamException(channelHandlerContext, new Http2FrameStreamException(http2FrameStream, streamException.error(), th));
        }
    }

    public final void userEventTriggered(final ChannelHandlerContext channelHandlerContext, final Object obj) throws Exception {
        if (obj == Http2ConnectionPrefaceAndSettingsFrameWrittenEvent.INSTANCE) {
            tryExpandConnectionFlowControlWindow(connection());
            channelHandlerContext.executor().execute(new Runnable() {
                public void run() {
                    channelHandlerContext.fireUserEventTriggered(obj);
                }
            });
        } else if (obj instanceof HttpServerUpgradeHandler.UpgradeEvent) {
            HttpServerUpgradeHandler.UpgradeEvent upgradeEvent = (HttpServerUpgradeHandler.UpgradeEvent) obj;
            try {
                onUpgradeEvent(channelHandlerContext, upgradeEvent.retain());
                Http2Stream stream = connection().stream(1);
                if (stream.getProperty(this.streamKey) == null) {
                    onStreamActive0(stream);
                }
                upgradeEvent.upgradeRequest().headers().setInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), 1);
                stream.setProperty(this.upgradeKey, Boolean.TRUE);
                InboundHttpToHttp2Adapter.handle(channelHandlerContext, connection(), decoder().frameListener(), upgradeEvent.upgradeRequest().retain());
                upgradeEvent.release();
            } catch (Throwable th) {
                upgradeEvent.release();
                throw th;
            }
        } else {
            channelHandlerContext.fireUserEventTriggered(obj);
        }
    }

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        if (obj instanceof Http2DataFrame) {
            Http2DataFrame http2DataFrame = (Http2DataFrame) obj;
            encoder().writeData(channelHandlerContext, http2DataFrame.stream().id(), http2DataFrame.content(), http2DataFrame.padding(), http2DataFrame.isEndStream(), channelPromise);
        } else if (obj instanceof Http2HeadersFrame) {
            writeHeadersFrame(channelHandlerContext, (Http2HeadersFrame) obj, channelPromise);
        } else if (obj instanceof Http2WindowUpdateFrame) {
            Http2WindowUpdateFrame http2WindowUpdateFrame = (Http2WindowUpdateFrame) obj;
            Http2FrameStream stream = http2WindowUpdateFrame.stream();
            if (stream == null) {
                try {
                    increaseInitialConnectionWindow(http2WindowUpdateFrame.windowSizeIncrement());
                } catch (Throwable th) {
                    channelPromise.setFailure(th);
                    return;
                }
            } else {
                consumeBytes(stream.id(), http2WindowUpdateFrame.windowSizeIncrement());
            }
            channelPromise.setSuccess();
        } else if (obj instanceof Http2ResetFrame) {
            Http2ResetFrame http2ResetFrame = (Http2ResetFrame) obj;
            if (connection().streamMayHaveExisted(http2ResetFrame.stream().id())) {
                encoder().writeRstStream(channelHandlerContext, http2ResetFrame.stream().id(), http2ResetFrame.errorCode(), channelPromise);
                return;
            }
            ReferenceCountUtil.release(http2ResetFrame);
            channelPromise.setFailure(Http2Exception.streamError(http2ResetFrame.stream().id(), Http2Error.PROTOCOL_ERROR, "Stream never existed", new Object[0]));
        } else if (obj instanceof Http2PingFrame) {
            Http2PingFrame http2PingFrame = (Http2PingFrame) obj;
            encoder().writePing(channelHandlerContext, http2PingFrame.ack(), http2PingFrame.content(), channelPromise);
        } else if (obj instanceof Http2SettingsFrame) {
            encoder().writeSettings(channelHandlerContext, ((Http2SettingsFrame) obj).settings(), channelPromise);
        } else if (obj instanceof Http2SettingsAckFrame) {
            encoder().writeSettingsAck(channelHandlerContext, channelPromise);
        } else if (obj instanceof Http2GoAwayFrame) {
            writeGoAwayFrame(channelHandlerContext, (Http2GoAwayFrame) obj, channelPromise);
        } else if (obj instanceof Http2PushPromiseFrame) {
            writePushPromise(channelHandlerContext, (Http2PushPromiseFrame) obj, channelPromise);
        } else if (obj instanceof Http2PriorityFrame) {
            Http2PriorityFrame http2PriorityFrame = (Http2PriorityFrame) obj;
            encoder().writePriority(channelHandlerContext, http2PriorityFrame.stream().id(), http2PriorityFrame.streamDependency(), http2PriorityFrame.weight(), http2PriorityFrame.exclusive(), channelPromise);
        } else if (obj instanceof Http2UnknownFrame) {
            Http2UnknownFrame http2UnknownFrame = (Http2UnknownFrame) obj;
            encoder().writeFrame(channelHandlerContext, http2UnknownFrame.frameType(), http2UnknownFrame.stream().id(), http2UnknownFrame.flags(), http2UnknownFrame.content(), channelPromise);
        } else if (!(obj instanceof Http2Frame)) {
            channelHandlerContext.write(obj, channelPromise);
        } else {
            ReferenceCountUtil.release(obj);
            throw new UnsupportedMessageTypeException(obj, (Class<?>[]) new Class[0]);
        }
    }
}
