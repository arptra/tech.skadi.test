package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Http2ConnectionHandler extends ByteToMessageDecoder implements Http2LifecycleManager, ChannelOutboundHandler {
    private static final Http2Headers HEADERS_TOO_LARGE_HEADERS = ReadOnlyHttp2Headers.serverHeaders(false, HttpResponseStatus.REQUEST_HEADER_FIELDS_TOO_LARGE.codeAsText(), new AsciiString[0]);
    /* access modifiers changed from: private */
    public static final ByteBuf HTTP_1_X_BUF = Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(new byte[]{72, 84, 84, 80, 47, 49, 46})).asReadOnly();
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Http2ConnectionHandler.class);
    /* access modifiers changed from: private */
    public BaseDecoder byteDecoder;
    private ChannelFutureListener closeListener;
    /* access modifiers changed from: private */
    public final Http2ConnectionDecoder decoder;
    private final boolean decoupleCloseAndGoAway;
    /* access modifiers changed from: private */
    public final Http2ConnectionEncoder encoder;
    /* access modifiers changed from: private */
    public final boolean flushPreface;
    private long gracefulShutdownTimeoutMillis;
    /* access modifiers changed from: private */
    public final Http2Settings initialSettings;

    /* renamed from: io.netty.handler.codec.http2.Http2ConnectionHandler$6  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.netty.handler.codec.http2.Http2Stream$State[] r0 = io.netty.handler.codec.http2.Http2Stream.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = r0
                io.netty.handler.codec.http2.Http2Stream$State r1 = io.netty.handler.codec.http2.Http2Stream.State.HALF_CLOSED_LOCAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.http2.Http2Stream$State r1 = io.netty.handler.codec.http2.Http2Stream.State.OPEN     // Catch:{ NoSuchFieldError -> 0x001d }
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
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.Http2ConnectionHandler.AnonymousClass6.<clinit>():void");
        }
    }

    public abstract class BaseDecoder {
        private BaseDecoder() {
        }

        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            Http2ConnectionHandler.this.encoder().close();
            Http2ConnectionHandler.this.decoder().close();
            Http2ConnectionHandler.this.connection().close(channelHandlerContext.voidPromise());
        }

        public abstract void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception;

        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        public boolean prefaceSent() {
            return true;
        }
    }

    public static final class ClosingChannelFutureListener implements ChannelFutureListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean closed;
        private final ChannelHandlerContext ctx;
        private final ChannelPromise promise;
        private final Future<?> timeoutTask;

        public ClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.ctx = channelHandlerContext;
            this.promise = channelPromise;
            this.timeoutTask = null;
        }

        /* access modifiers changed from: private */
        public void doClose() {
            if (!this.closed) {
                this.closed = true;
                ChannelPromise channelPromise = this.promise;
                if (channelPromise == null) {
                    this.ctx.close();
                } else {
                    this.ctx.close(channelPromise);
                }
            }
        }

        public void operationComplete(ChannelFuture channelFuture) {
            Future<?> future = this.timeoutTask;
            if (future != null) {
                future.cancel(false);
            }
            doClose();
        }

        public ClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise, long j, TimeUnit timeUnit) {
            this.ctx = channelHandlerContext;
            this.promise = channelPromise;
            this.timeoutTask = channelHandlerContext.executor().schedule((Runnable) new Runnable() {
                public void run() {
                    ClosingChannelFutureListener.this.doClose();
                }
            }, j, timeUnit);
        }
    }

    public final class FrameDecoder extends BaseDecoder {
        private FrameDecoder() {
            super();
        }

        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            try {
                Http2ConnectionHandler.this.decoder.decodeFrame(channelHandlerContext, byteBuf, list);
            } catch (Throwable th) {
                Http2ConnectionHandler.this.onError(channelHandlerContext, false, th);
            }
        }
    }

    public final class PrefaceDecoder extends BaseDecoder {
        private ByteBuf clientPrefaceString;
        private boolean prefaceSent;

        public PrefaceDecoder(ChannelHandlerContext channelHandlerContext) throws Exception {
            super();
            this.clientPrefaceString = Http2ConnectionHandler.clientPrefaceString(Http2ConnectionHandler.this.encoder.connection());
            sendPreface(channelHandlerContext);
        }

        private void cleanup() {
            ByteBuf byteBuf = this.clientPrefaceString;
            if (byteBuf != null) {
                byteBuf.release();
                this.clientPrefaceString = null;
            }
        }

        private boolean readClientPrefaceString(ByteBuf byteBuf) throws Http2Exception {
            ByteBuf byteBuf2 = this.clientPrefaceString;
            if (byteBuf2 == null) {
                return true;
            }
            int min = Math.min(byteBuf.readableBytes(), byteBuf2.readableBytes());
            if (min != 0) {
                int readerIndex = byteBuf.readerIndex();
                ByteBuf byteBuf3 = this.clientPrefaceString;
                if (ByteBufUtil.equals(byteBuf, readerIndex, byteBuf3, byteBuf3.readerIndex(), min)) {
                    byteBuf.skipBytes(min);
                    this.clientPrefaceString.skipBytes(min);
                    if (this.clientPrefaceString.isReadable()) {
                        return false;
                    }
                    this.clientPrefaceString.release();
                    this.clientPrefaceString = null;
                    return true;
                }
            }
            int indexOf = ByteBufUtil.indexOf(Http2ConnectionHandler.HTTP_1_X_BUF, byteBuf.slice(byteBuf.readerIndex(), Math.min(byteBuf.readableBytes(), 1024)));
            if (indexOf != -1) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Unexpected HTTP/1.x request: %s", byteBuf.toString(byteBuf.readerIndex(), indexOf - byteBuf.readerIndex(), CharsetUtil.US_ASCII));
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP/2 client preface string missing or corrupt. Hex dump for received bytes: %s", ByteBufUtil.hexDump(byteBuf, byteBuf.readerIndex(), Math.min(byteBuf.readableBytes(), this.clientPrefaceString.readableBytes())));
        }

        private void sendPreface(ChannelHandlerContext channelHandlerContext) throws Exception {
            if (!this.prefaceSent && channelHandlerContext.channel().isActive()) {
                this.prefaceSent = true;
                boolean isServer = true ^ Http2ConnectionHandler.this.connection().isServer();
                if (isServer) {
                    channelHandlerContext.write(Http2CodecUtil.connectionPrefaceBuf()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
                }
                Http2ConnectionHandler.this.encoder.writeSettings(channelHandlerContext, Http2ConnectionHandler.this.initialSettings, channelHandlerContext.newPromise()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
                if (isServer) {
                    Http2ConnectionHandler.this.userEventTriggered(channelHandlerContext, Http2ConnectionPrefaceAndSettingsFrameWrittenEvent.INSTANCE);
                }
            }
        }

        private boolean verifyFirstFrameIsSettings(ByteBuf byteBuf) throws Http2Exception {
            if (byteBuf.readableBytes() < 5) {
                return false;
            }
            short unsignedByte = byteBuf.getUnsignedByte(byteBuf.readerIndex() + 3);
            short unsignedByte2 = byteBuf.getUnsignedByte(byteBuf.readerIndex() + 4);
            if (unsignedByte == 4 && (unsignedByte2 & 1) == 0) {
                return true;
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "First received frame was not SETTINGS. Hex dump for first 5 bytes: %s", ByteBufUtil.hexDump(byteBuf, byteBuf.readerIndex(), 5));
        }

        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
            sendPreface(channelHandlerContext);
            if (Http2ConnectionHandler.this.flushPreface) {
                channelHandlerContext.flush();
            }
        }

        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            cleanup();
            super.channelInactive(channelHandlerContext);
        }

        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            try {
                if (channelHandlerContext.channel().isActive() && readClientPrefaceString(byteBuf) && verifyFirstFrameIsSettings(byteBuf)) {
                    Http2ConnectionHandler http2ConnectionHandler = Http2ConnectionHandler.this;
                    BaseDecoder unused = http2ConnectionHandler.byteDecoder = new FrameDecoder();
                    Http2ConnectionHandler.this.byteDecoder.decode(channelHandlerContext, byteBuf, list);
                }
            } catch (Throwable th) {
                Http2ConnectionHandler.this.onError(channelHandlerContext, false, th);
            }
        }

        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
            cleanup();
        }

        public boolean prefaceSent() {
            return this.prefaceSent;
        }
    }

    public Http2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) {
        this(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, false);
    }

    /* access modifiers changed from: private */
    public void checkCloseConnection(ChannelFuture channelFuture) {
        if (this.closeListener != null && isGracefulShutdownComplete()) {
            ChannelFutureListener channelFutureListener = this.closeListener;
            this.closeListener = null;
            try {
                channelFutureListener.operationComplete(channelFuture);
            } catch (Exception e) {
                throw new IllegalStateException("Close listener threw an unexpected exception", e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static ByteBuf clientPrefaceString(Http2Connection http2Connection) {
        if (http2Connection.isServer()) {
            return Http2CodecUtil.connectionPrefaceBuf();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void closeConnectionOnError(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture) {
        if (!channelFuture.isSuccess()) {
            onConnectionError(channelHandlerContext, true, channelFuture.cause(), (Http2Exception) null);
        }
    }

    private void doGracefulShutdown(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture, ChannelPromise channelPromise) {
        final ChannelFutureListener newClosingChannelFutureListener = newClosingChannelFutureListener(channelHandlerContext, channelPromise);
        if (isGracefulShutdownComplete()) {
            channelFuture.addListener(newClosingChannelFutureListener);
            return;
        }
        final ChannelFutureListener channelFutureListener = this.closeListener;
        if (channelFutureListener == null) {
            this.closeListener = newClosingChannelFutureListener;
        } else if (channelPromise != null) {
            this.closeListener = new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    try {
                        channelFutureListener.operationComplete(channelFuture);
                    } finally {
                        newClosingChannelFutureListener.operationComplete(channelFuture);
                    }
                }
            };
        }
    }

    private ChannelFutureListener newClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        long j = this.gracefulShutdownTimeoutMillis;
        if (j < 0) {
            return new ClosingChannelFutureListener(channelHandlerContext, channelPromise);
        }
        return new ClosingChannelFutureListener(channelHandlerContext, channelPromise, j, TimeUnit.MILLISECONDS);
    }

    private boolean prefaceSent() {
        BaseDecoder baseDecoder = this.byteDecoder;
        return baseDecoder != null && baseDecoder.prefaceSent();
    }

    /* access modifiers changed from: private */
    public static void processGoAwayWriteResult(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf, ChannelFuture channelFuture) {
        try {
            if (!channelFuture.isSuccess()) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("{} Sending GOAWAY failed: lastStreamId '{}', errorCode '{}', debugData '{}'. Forcing shutdown of the connection.", channelHandlerContext.channel(), Integer.valueOf(i), Long.valueOf(j), byteBuf.toString(CharsetUtil.UTF_8), channelFuture.cause());
                }
                channelHandlerContext.close();
            } else if (j != Http2Error.NO_ERROR.code()) {
                InternalLogger internalLogger2 = logger;
                if (internalLogger2.isDebugEnabled()) {
                    internalLogger2.debug("{} Sent GOAWAY: lastStreamId '{}', errorCode '{}', debugData '{}'. Forcing shutdown of the connection.", channelHandlerContext.channel(), Integer.valueOf(i), Long.valueOf(j), byteBuf.toString(CharsetUtil.UTF_8), channelFuture.cause());
                }
                channelHandlerContext.close();
            }
        } finally {
            byteBuf.release();
        }
    }

    /* access modifiers changed from: private */
    public void processRstStreamWriteResult(ChannelHandlerContext channelHandlerContext, Http2Stream http2Stream, ChannelFuture channelFuture) {
        if (channelFuture.isSuccess()) {
            closeStream(http2Stream, channelFuture);
        } else {
            onConnectionError(channelHandlerContext, true, channelFuture.cause(), (Http2Exception) null);
        }
    }

    private ChannelFuture resetUnknownStream(final ChannelHandlerContext channelHandlerContext, int i, long j, ChannelPromise channelPromise) {
        ChannelFuture writeRstStream = frameWriter().writeRstStream(channelHandlerContext, i, j, channelPromise);
        if (writeRstStream.isDone()) {
            closeConnectionOnError(channelHandlerContext, writeRstStream);
        } else {
            writeRstStream.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    Http2ConnectionHandler.this.closeConnectionOnError(channelHandlerContext, channelFuture);
                }
            });
        }
        return writeRstStream;
    }

    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.byteDecoder == null) {
            this.byteDecoder = new PrefaceDecoder(channelHandlerContext);
        }
        this.byteDecoder.channelActive(channelHandlerContext);
        super.channelActive(channelHandlerContext);
    }

    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelInactive(channelHandlerContext);
        BaseDecoder baseDecoder = this.byteDecoder;
        if (baseDecoder != null) {
            baseDecoder.channelInactive(channelHandlerContext);
            this.byteDecoder = null;
        }
    }

    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            channelReadComplete0(channelHandlerContext);
        } finally {
            flush(channelHandlerContext);
        }
    }

    public final void channelReadComplete0(ChannelHandlerContext channelHandlerContext) {
        discardSomeReadBytes();
        if (!channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
        channelHandlerContext.fireChannelReadComplete();
    }

    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            if (channelHandlerContext.channel().isWritable()) {
                flush(channelHandlerContext);
            }
            this.encoder.flowController().channelWritabilityChanged();
            super.channelWritabilityChanged(channelHandlerContext);
        } catch (Throwable th) {
            super.channelWritabilityChanged(channelHandlerContext);
            throw th;
        }
    }

    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        if (this.decoupleCloseAndGoAway) {
            channelHandlerContext.close(channelPromise);
            return;
        }
        ChannelPromise unvoid = channelPromise.unvoid();
        if (!channelHandlerContext.channel().isActive() || !prefaceSent()) {
            channelHandlerContext.close(unvoid);
            return;
        }
        ChannelFuture write = connection().goAwaySent() ? channelHandlerContext.write(Unpooled.EMPTY_BUFFER) : goAway(channelHandlerContext, (Http2Exception) null, channelHandlerContext.newPromise());
        channelHandlerContext.flush();
        doGracefulShutdown(channelHandlerContext, write, unvoid);
    }

    public void closeStream(Http2Stream http2Stream, ChannelFuture channelFuture) {
        http2Stream.close();
        if (channelFuture.isDone()) {
            checkCloseConnection(channelFuture);
        } else {
            channelFuture.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    Http2ConnectionHandler.this.checkCloseConnection(channelFuture);
                }
            });
        }
    }

    public void closeStreamLocal(Http2Stream http2Stream, ChannelFuture channelFuture) {
        int i = AnonymousClass6.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2Stream.state().ordinal()];
        if (i == 1 || i == 2) {
            http2Stream.closeLocalSide();
        } else {
            closeStream(http2Stream, channelFuture);
        }
    }

    public void closeStreamRemote(Http2Stream http2Stream, ChannelFuture channelFuture) {
        int i = AnonymousClass6.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2Stream.state().ordinal()];
        if (i == 2 || i == 3) {
            http2Stream.closeRemoteSide();
        } else {
            closeStream(http2Stream, channelFuture);
        }
    }

    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    public Http2Connection connection() {
        return this.encoder.connection();
    }

    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        this.byteDecoder.decode(channelHandlerContext, byteBuf, list);
    }

    public Http2ConnectionDecoder decoder() {
        return this.decoder;
    }

    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.disconnect(channelPromise);
    }

    public Http2ConnectionEncoder encoder() {
        return this.encoder;
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (Http2CodecUtil.getEmbeddedHttp2Exception(th) != null) {
            onError(channelHandlerContext, false, th);
        } else {
            super.exceptionCaught(channelHandlerContext, th);
        }
    }

    public void flush(ChannelHandlerContext channelHandlerContext) {
        try {
            this.encoder.flowController().writePendingBytes();
            channelHandlerContext.flush();
        } catch (Http2Exception e) {
            onError(channelHandlerContext, true, e);
        } catch (Throwable th) {
            onError(channelHandlerContext, true, Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th, "Error flushing", new Object[0]));
        }
    }

    public Http2FrameWriter frameWriter() {
        return encoder().frameWriter();
    }

    public ChannelFuture goAway(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf, ChannelPromise channelPromise) {
        ChannelPromise unvoid = channelPromise.unvoid();
        try {
            if (!connection().goAwaySent(i, j, byteBuf)) {
                byteBuf.release();
                unvoid.trySuccess();
                return unvoid;
            }
            byteBuf.retain();
            ChannelFuture writeGoAway = frameWriter().writeGoAway(channelHandlerContext, i, j, byteBuf, unvoid);
            if (writeGoAway.isDone()) {
                processGoAwayWriteResult(channelHandlerContext, i, j, byteBuf, writeGoAway);
            } else {
                final ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
                final int i2 = i;
                final long j2 = j;
                final ByteBuf byteBuf2 = byteBuf;
                writeGoAway.addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        Http2ConnectionHandler.processGoAwayWriteResult(channelHandlerContext2, i2, j2, byteBuf2, channelFuture);
                    }
                });
            }
            return writeGoAway;
        } catch (Throwable th) {
            byteBuf.release();
            unvoid.tryFailure(th);
            return unvoid;
        }
    }

    public long gracefulShutdownTimeoutMillis() {
        return this.gracefulShutdownTimeoutMillis;
    }

    public void handleServerHeaderDecodeSizeError(ChannelHandlerContext channelHandlerContext, Http2Stream http2Stream) {
        encoder().writeHeaders(channelHandlerContext, http2Stream.id(), HEADERS_TOO_LARGE_HEADERS, 0, true, channelHandlerContext.newPromise());
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.encoder.lifecycleManager(this);
        this.decoder.lifecycleManager(this);
        this.encoder.flowController().channelHandlerContext(channelHandlerContext);
        this.decoder.flowController().channelHandlerContext(channelHandlerContext);
        this.byteDecoder = new PrefaceDecoder(channelHandlerContext);
    }

    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        BaseDecoder baseDecoder = this.byteDecoder;
        if (baseDecoder != null) {
            baseDecoder.handlerRemoved(channelHandlerContext);
            this.byteDecoder = null;
        }
    }

    public boolean isGracefulShutdownComplete() {
        return connection().numActiveStreams() == 0;
    }

    public void onConnectionError(ChannelHandlerContext channelHandlerContext, boolean z, Throwable th, Http2Exception http2Exception) {
        if (http2Exception == null) {
            http2Exception = new Http2Exception(Http2Error.INTERNAL_ERROR, th.getMessage(), th);
        }
        ChannelPromise newPromise = channelHandlerContext.newPromise();
        ChannelFuture goAway = goAway(channelHandlerContext, http2Exception, channelHandlerContext.newPromise());
        if (http2Exception.shutdownHint() == Http2Exception.ShutdownHint.GRACEFUL_SHUTDOWN) {
            doGracefulShutdown(channelHandlerContext, goAway, newPromise);
        } else {
            goAway.addListener(newClosingChannelFutureListener(channelHandlerContext, newPromise));
        }
    }

    public void onError(ChannelHandlerContext channelHandlerContext, boolean z, Throwable th) {
        Http2Exception embeddedHttp2Exception = Http2CodecUtil.getEmbeddedHttp2Exception(th);
        if (Http2Exception.isStreamError(embeddedHttp2Exception)) {
            onStreamError(channelHandlerContext, z, th, (Http2Exception.StreamException) embeddedHttp2Exception);
        } else if (embeddedHttp2Exception instanceof Http2Exception.CompositeStreamException) {
            Iterator<Http2Exception.StreamException> it = ((Http2Exception.CompositeStreamException) embeddedHttp2Exception).iterator();
            while (it.hasNext()) {
                onStreamError(channelHandlerContext, z, th, it.next());
            }
        } else {
            onConnectionError(channelHandlerContext, z, th, embeddedHttp2Exception);
        }
        channelHandlerContext.flush();
    }

    public void onHttpClientUpgrade() throws Http2Exception {
        if (connection().isServer()) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Client-side HTTP upgrade requested for a server", new Object[0]);
        } else if (!prefaceSent()) {
            throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "HTTP upgrade must occur after preface was sent", new Object[0]);
        } else if (!this.decoder.prefaceReceived()) {
            connection().local().createStream(1, true);
        } else {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP upgrade must occur before HTTP/2 preface is received", new Object[0]);
        }
    }

    public void onHttpServerUpgrade(Http2Settings http2Settings) throws Http2Exception {
        if (!connection().isServer()) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server-side HTTP upgrade requested for a client", new Object[0]);
        } else if (!prefaceSent()) {
            throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "HTTP upgrade must occur after preface was sent", new Object[0]);
        } else if (!this.decoder.prefaceReceived()) {
            this.encoder.remoteSettings(http2Settings);
            connection().remote().createStream(1, true);
        } else {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP upgrade must occur before HTTP/2 preface is received", new Object[0]);
        }
    }

    public void onStreamError(ChannelHandlerContext channelHandlerContext, boolean z, Throwable th, Http2Exception.StreamException streamException) {
        int streamId = streamException.streamId();
        Http2Stream stream = connection().stream(streamId);
        if ((streamException instanceof Http2Exception.HeaderListSizeException) && ((Http2Exception.HeaderListSizeException) streamException).duringDecode() && connection().isServer()) {
            if (stream == null) {
                try {
                    stream = this.encoder.connection().remote().createStream(streamId, true);
                } catch (Http2Exception unused) {
                    resetUnknownStream(channelHandlerContext, streamId, streamException.error().code(), channelHandlerContext.newPromise());
                    return;
                }
            }
            if (stream != null && !stream.isHeadersSent()) {
                try {
                    handleServerHeaderDecodeSizeError(channelHandlerContext, stream);
                } catch (Throwable th2) {
                    onError(channelHandlerContext, z, Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th2, "Error DecodeSizeError", new Object[0]));
                }
            }
        }
        Http2Stream http2Stream = stream;
        if (http2Stream != null) {
            resetStream(channelHandlerContext, http2Stream, streamException.error().code(), channelHandlerContext.newPromise());
        } else if (!z || connection().local().mayHaveCreatedStream(streamId)) {
            resetUnknownStream(channelHandlerContext, streamId, streamException.error().code(), channelHandlerContext.newPromise());
        }
    }

    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.read();
    }

    public ChannelFuture resetStream(ChannelHandlerContext channelHandlerContext, int i, long j, ChannelPromise channelPromise) {
        Http2Stream stream = connection().stream(i);
        if (stream != null) {
            return resetStream(channelHandlerContext, stream, j, channelPromise);
        }
        return resetUnknownStream(channelHandlerContext, i, j, channelPromise.unvoid());
    }

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.write(obj, channelPromise);
    }

    public Http2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z) {
        this(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, z, true);
    }

    public void gracefulShutdownTimeoutMillis(long j) {
        if (j >= -1) {
            this.gracefulShutdownTimeoutMillis = j;
            return;
        }
        throw new IllegalArgumentException("gracefulShutdownTimeoutMillis: " + j + " (expected: -1 for indefinite or >= 0)");
    }

    public Http2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z, boolean z2) {
        this.initialSettings = (Http2Settings) ObjectUtil.checkNotNull(http2Settings, "initialSettings");
        this.decoder = (Http2ConnectionDecoder) ObjectUtil.checkNotNull(http2ConnectionDecoder, "decoder");
        this.encoder = (Http2ConnectionEncoder) ObjectUtil.checkNotNull(http2ConnectionEncoder, "encoder");
        this.decoupleCloseAndGoAway = z;
        this.flushPreface = z2;
        if (http2ConnectionEncoder.connection() != http2ConnectionDecoder.connection()) {
            throw new IllegalArgumentException("Encoder and Decoder do not share the same connection object");
        }
    }

    private ChannelFuture resetStream(final ChannelHandlerContext channelHandlerContext, final Http2Stream http2Stream, long j, ChannelPromise channelPromise) {
        ChannelFuture channelFuture;
        ChannelPromise unvoid = channelPromise.unvoid();
        if (http2Stream.isResetSent()) {
            return unvoid.setSuccess();
        }
        http2Stream.resetSent();
        if (http2Stream.state() == Http2Stream.State.IDLE || (connection().local().created(http2Stream) && !http2Stream.isHeadersSent() && !http2Stream.isPushPromiseSent())) {
            channelFuture = unvoid.setSuccess();
        } else {
            channelFuture = frameWriter().writeRstStream(channelHandlerContext, http2Stream.id(), j, unvoid);
        }
        if (channelFuture.isDone()) {
            processRstStreamWriteResult(channelHandlerContext, http2Stream, channelFuture);
        } else {
            channelFuture.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    Http2ConnectionHandler.this.processRstStreamWriteResult(channelHandlerContext, http2Stream, channelFuture);
                }
            });
        }
        return channelFuture;
    }

    private ChannelFuture goAway(ChannelHandlerContext channelHandlerContext, Http2Exception http2Exception, ChannelPromise channelPromise) {
        int lastStreamCreated;
        long code = (http2Exception != null ? http2Exception.error() : Http2Error.NO_ERROR).code();
        if (http2Exception == null || http2Exception.shutdownHint() != Http2Exception.ShutdownHint.HARD_SHUTDOWN) {
            lastStreamCreated = connection().remote().lastStreamCreated();
        } else {
            lastStreamCreated = Integer.MAX_VALUE;
        }
        return goAway(channelHandlerContext, lastStreamCreated, code, Http2CodecUtil.toByteBuf(channelHandlerContext, http2Exception), channelPromise);
    }
}
