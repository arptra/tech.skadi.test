package io.netty.handler.codec.http2;

import com.google.common.net.HttpHeaders;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.handler.codec.http2.StreamByteDistributor;
import io.netty.handler.ssl.ApplicationProtocolNames;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutor;
import java.util.concurrent.TimeUnit;

public final class Http2CodecUtil {
    private static final ByteBuf CONNECTION_PREFACE = Unpooled.unreleasableBuffer(Unpooled.directBuffer(24).writeBytes("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n".getBytes(CharsetUtil.UTF_8))).asReadOnly();
    public static final int CONNECTION_STREAM_ID = 0;
    public static final int CONTINUATION_FRAME_HEADER_LENGTH = 10;
    public static final int DATA_FRAME_HEADER_LENGTH = 10;
    public static final long DEFAULT_GRACEFUL_SHUTDOWN_TIMEOUT_MILLIS = TimeUnit.MILLISECONDS.convert(30, TimeUnit.SECONDS);
    public static final long DEFAULT_HEADER_LIST_SIZE = 8192;
    public static final int DEFAULT_HEADER_TABLE_SIZE = 4096;
    public static final int DEFAULT_MAX_FRAME_SIZE = 16384;
    public static final int DEFAULT_MAX_QUEUED_CONTROL_FRAMES = 10000;
    static final int DEFAULT_MAX_RESERVED_STREAMS = 100;
    static final int DEFAULT_MIN_ALLOCATION_CHUNK = 1024;
    public static final short DEFAULT_PRIORITY_WEIGHT = 16;
    public static final int DEFAULT_WINDOW_SIZE = 65535;
    public static final int FRAME_HEADER_LENGTH = 9;
    public static final int GO_AWAY_FRAME_HEADER_LENGTH = 17;
    public static final int HEADERS_FRAME_HEADER_LENGTH = 15;
    public static final CharSequence HTTP_UPGRADE_PROTOCOL_NAME = "h2c";
    public static final CharSequence HTTP_UPGRADE_SETTINGS_HEADER = AsciiString.cached(HttpHeaders.HTTP2_SETTINGS);
    public static final int HTTP_UPGRADE_STREAM_ID = 1;
    public static final int INT_FIELD_LENGTH = 4;
    public static final long MAX_CONCURRENT_STREAMS = 4294967295L;
    public static final int MAX_FRAME_SIZE_LOWER_BOUND = 16384;
    public static final int MAX_FRAME_SIZE_UPPER_BOUND = 16777215;
    public static final long MAX_HEADER_LIST_SIZE = 4294967295L;
    public static final long MAX_HEADER_TABLE_SIZE = 4294967295L;
    public static final int MAX_INITIAL_WINDOW_SIZE = Integer.MAX_VALUE;
    public static final int MAX_PADDING = 256;
    private static final int MAX_PADDING_LENGTH_LENGTH = 1;
    public static final short MAX_UNSIGNED_BYTE = 255;
    public static final long MAX_UNSIGNED_INT = 4294967295L;
    public static final short MAX_WEIGHT = 256;
    public static final long MIN_CONCURRENT_STREAMS = 0;
    public static final long MIN_HEADER_LIST_SIZE = 0;
    public static final long MIN_HEADER_TABLE_SIZE = 0;
    public static final int MIN_INITIAL_WINDOW_SIZE = 0;
    public static final short MIN_WEIGHT = 1;
    public static final int NUM_STANDARD_SETTINGS = 6;
    public static final int PING_FRAME_PAYLOAD_LENGTH = 8;
    public static final int PRIORITY_ENTRY_LENGTH = 5;
    public static final int PRIORITY_FRAME_LENGTH = 14;
    public static final int PUSH_PROMISE_FRAME_HEADER_LENGTH = 14;
    public static final int RST_STREAM_FRAME_LENGTH = 13;
    public static final char SETTINGS_ENABLE_PUSH = '\u0002';
    public static final char SETTINGS_HEADER_TABLE_SIZE = '\u0001';
    public static final char SETTINGS_INITIAL_WINDOW_SIZE = '\u0004';
    public static final char SETTINGS_MAX_CONCURRENT_STREAMS = '\u0003';
    public static final char SETTINGS_MAX_FRAME_SIZE = '\u0005';
    public static final char SETTINGS_MAX_HEADER_LIST_SIZE = '\u0006';
    public static final int SETTING_ENTRY_LENGTH = 6;
    public static final int SMALLEST_MAX_CONCURRENT_STREAMS = 100;
    public static final CharSequence TLS_UPGRADE_PROTOCOL_NAME = ApplicationProtocolNames.HTTP_2;
    public static final int WINDOW_UPDATE_FRAME_LENGTH = 13;

    public static final class SimpleChannelPromiseAggregator extends DefaultChannelPromise {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Throwable aggregateFailure;
        private boolean doneAllocating;
        private int doneCount;
        private int expectedCount;
        private final ChannelPromise promise;

        public SimpleChannelPromiseAggregator(ChannelPromise channelPromise, Channel channel, EventExecutor eventExecutor) {
            super(channel, eventExecutor);
            this.promise = channelPromise;
        }

        private boolean allPromisesDone() {
            return this.doneCount == this.expectedCount && this.doneAllocating;
        }

        private boolean allowFailure() {
            return awaitingPromises() || this.expectedCount == 0;
        }

        private boolean awaitingPromises() {
            return this.doneCount < this.expectedCount;
        }

        private void setAggregateFailure(Throwable th) {
            if (this.aggregateFailure == null) {
                this.aggregateFailure = th;
            }
        }

        private ChannelPromise setPromise() {
            Throwable th = this.aggregateFailure;
            if (th == null) {
                this.promise.setSuccess();
                return super.setSuccess((Void) null);
            }
            this.promise.setFailure(th);
            return super.setFailure(this.aggregateFailure);
        }

        private boolean tryPromise() {
            Throwable th = this.aggregateFailure;
            if (th == null) {
                this.promise.trySuccess();
                return super.trySuccess(null);
            }
            this.promise.tryFailure(th);
            return super.tryFailure(this.aggregateFailure);
        }

        public ChannelPromise doneAllocatingPromises() {
            if (this.doneAllocating) {
                return this;
            }
            this.doneAllocating = true;
            int i = this.doneCount;
            int i2 = this.expectedCount;
            return (i == i2 || i2 == 0) ? setPromise() : this;
        }

        public ChannelPromise newPromise() {
            this.expectedCount++;
            return this;
        }

        public boolean tryFailure(Throwable th) {
            if (!allowFailure()) {
                return false;
            }
            this.doneCount++;
            setAggregateFailure(th);
            if (allPromisesDone()) {
                return tryPromise();
            }
            return true;
        }

        public ChannelPromise setFailure(Throwable th) {
            if (!allowFailure()) {
                return this;
            }
            this.doneCount++;
            setAggregateFailure(th);
            return allPromisesDone() ? setPromise() : this;
        }

        public ChannelPromise setSuccess(Void voidR) {
            if (awaitingPromises()) {
                this.doneCount++;
                if (allPromisesDone()) {
                    setPromise();
                }
            }
            return this;
        }

        public boolean trySuccess(Void voidR) {
            if (!awaitingPromises()) {
                return false;
            }
            this.doneCount++;
            if (allPromisesDone()) {
                return tryPromise();
            }
            return true;
        }
    }

    private Http2CodecUtil() {
    }

    public static long calculateMaxHeaderListSizeGoAway(long j) {
        return j + (j >>> 2);
    }

    public static ByteBuf connectionPrefaceBuf() {
        return CONNECTION_PREFACE.retainedDuplicate();
    }

    public static Http2Exception getEmbeddedHttp2Exception(Throwable th) {
        while (th != null) {
            if (th instanceof Http2Exception) {
                return (Http2Exception) th;
            }
            th = th.getCause();
        }
        return null;
    }

    public static void headerListSizeExceeded(int i, long j, boolean z) throws Http2Exception {
        throw Http2Exception.headerListSizeError(i, Http2Error.PROTOCOL_ERROR, z, "Header size exceeded max allowed size (%d)", Long.valueOf(j));
    }

    public static boolean isMaxFrameSizeValid(int i) {
        return i >= 16384 && i <= 16777215;
    }

    public static boolean isOutboundStream(boolean z, int i) {
        return i > 0 && z == ((i & 1) == 0);
    }

    public static boolean isStreamIdValid(int i) {
        return i >= 0;
    }

    public static int readUnsignedInt(ByteBuf byteBuf) {
        return byteBuf.readInt() & Integer.MAX_VALUE;
    }

    public static int streamableBytes(StreamByteDistributor.StreamState streamState) {
        return Math.max(0, (int) Math.min(streamState.pendingBytes(), (long) streamState.windowSize()));
    }

    public static ByteBuf toByteBuf(ChannelHandlerContext channelHandlerContext, Throwable th) {
        return (th == null || th.getMessage() == null) ? Unpooled.EMPTY_BUFFER : ByteBufUtil.writeUtf8(channelHandlerContext.alloc(), (CharSequence) th.getMessage());
    }

    public static void verifyPadding(int i) {
        if (i < 0 || i > 256) {
            throw new IllegalArgumentException(String.format("Invalid padding '%d'. Padding must be between 0 and %d (inclusive).", new Object[]{Integer.valueOf(i), 256}));
        }
    }

    public static void writeFrameHeader(ByteBuf byteBuf, int i, byte b, Http2Flags http2Flags, int i2) {
        byteBuf.ensureWritable(i + 9);
        writeFrameHeaderInternal(byteBuf, i, b, http2Flags, i2);
    }

    public static void writeFrameHeaderInternal(ByteBuf byteBuf, int i, byte b, Http2Flags http2Flags, int i2) {
        byteBuf.writeMedium(i);
        byteBuf.writeByte(b);
        byteBuf.writeByte(http2Flags.value());
        byteBuf.writeInt(i2);
    }

    public static boolean isStreamIdValid(int i, boolean z) {
        if (!isStreamIdValid(i)) {
            return false;
        }
        return z == ((i & 1) == 0);
    }

    public static void headerListSizeExceeded(long j) throws Http2Exception {
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header size exceeded max allowed size (%d)", Long.valueOf(j));
    }
}
