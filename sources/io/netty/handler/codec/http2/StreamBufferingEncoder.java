package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeMap;

public class StreamBufferingEncoder extends DecoratingHttp2ConnectionEncoder {
    private boolean closed;
    /* access modifiers changed from: private */
    public GoAwayDetail goAwayDetail;
    private int maxConcurrentStreams;
    private final TreeMap<Integer, PendingStream> pendingStreams;

    public final class DataFrame extends Frame {
        final ByteBuf data;
        final boolean endOfStream;
        final int padding;

        public DataFrame(ByteBuf byteBuf, int i, boolean z, ChannelPromise channelPromise) {
            super(channelPromise);
            this.data = byteBuf;
            this.padding = i;
            this.endOfStream = z;
        }

        public void release(Throwable th) {
            super.release(th);
            ReferenceCountUtil.safeRelease(this.data);
        }

        public void send(ChannelHandlerContext channelHandlerContext, int i) {
            StreamBufferingEncoder.this.writeData(channelHandlerContext, i, this.data, this.padding, this.endOfStream, this.promise);
        }
    }

    public static abstract class Frame {
        final ChannelPromise promise;

        public Frame(ChannelPromise channelPromise) {
            this.promise = channelPromise;
        }

        public void release(Throwable th) {
            if (th == null) {
                this.promise.setSuccess();
            } else {
                this.promise.setFailure(th);
            }
        }

        public abstract void send(ChannelHandlerContext channelHandlerContext, int i);
    }

    public static final class GoAwayDetail {
        /* access modifiers changed from: private */
        public final byte[] debugData;
        /* access modifiers changed from: private */
        public final long errorCode;
        /* access modifiers changed from: private */
        public final int lastStreamId;

        public GoAwayDetail(int i, long j, byte[] bArr) {
            this.lastStreamId = i;
            this.errorCode = j;
            this.debugData = (byte[]) bArr.clone();
        }
    }

    public final class HeadersFrame extends Frame {
        final boolean endOfStream;
        final boolean exclusive;
        final Http2Headers headers;
        final int padding;
        final int streamDependency;
        final short weight;

        public HeadersFrame(Http2Headers http2Headers, int i, short s, boolean z, int i2, boolean z2, ChannelPromise channelPromise) {
            super(channelPromise);
            this.headers = http2Headers;
            this.streamDependency = i;
            this.weight = s;
            this.exclusive = z;
            this.padding = i2;
            this.endOfStream = z2;
        }

        public void send(ChannelHandlerContext channelHandlerContext, int i) {
            StreamBufferingEncoder.this.writeHeaders(channelHandlerContext, i, this.headers, this.streamDependency, this.weight, this.exclusive, this.padding, this.endOfStream, this.promise);
        }
    }

    public static final class Http2ChannelClosedException extends Http2Exception {
        private static final long serialVersionUID = 4768543442094476971L;

        public Http2ChannelClosedException() {
            super(Http2Error.REFUSED_STREAM, "Connection closed");
        }
    }

    public static final class Http2GoAwayException extends Http2Exception {
        private static final long serialVersionUID = 1326785622777291198L;
        private final GoAwayDetail goAwayDetail;

        public Http2GoAwayException(int i, long j, byte[] bArr) {
            this(new GoAwayDetail(i, j, bArr));
        }

        public byte[] debugData() {
            return (byte[]) this.goAwayDetail.debugData.clone();
        }

        public long errorCode() {
            return this.goAwayDetail.errorCode;
        }

        public int lastStreamId() {
            return this.goAwayDetail.lastStreamId;
        }

        public Http2GoAwayException(GoAwayDetail goAwayDetail2) {
            super(Http2Error.STREAM_CLOSED);
            this.goAwayDetail = goAwayDetail2;
        }
    }

    public static final class PendingStream {
        final ChannelHandlerContext ctx;
        final Queue<Frame> frames = new ArrayDeque(2);
        final int streamId;

        public PendingStream(ChannelHandlerContext channelHandlerContext, int i) {
            this.ctx = channelHandlerContext;
            this.streamId = i;
        }

        public void close(Throwable th) {
            for (Frame release : this.frames) {
                release.release(th);
            }
        }

        public void sendFrames() {
            for (Frame send : this.frames) {
                send.send(this.ctx, this.streamId);
            }
        }
    }

    public StreamBufferingEncoder(Http2ConnectionEncoder http2ConnectionEncoder) {
        this(http2ConnectionEncoder, 100);
    }

    private boolean canCreateStream() {
        return connection().local().numActiveStreams() < this.maxConcurrentStreams;
    }

    /* access modifiers changed from: private */
    public void cancelGoAwayStreams(GoAwayDetail goAwayDetail2) {
        Iterator<PendingStream> it = this.pendingStreams.values().iterator();
        Http2GoAwayException http2GoAwayException = new Http2GoAwayException(goAwayDetail2);
        while (it.hasNext()) {
            PendingStream next = it.next();
            if (next.streamId > goAwayDetail2.lastStreamId) {
                it.remove();
                next.close(http2GoAwayException);
            }
        }
    }

    private boolean isExistingStream(int i) {
        return i <= connection().local().lastStreamCreated();
    }

    /* access modifiers changed from: private */
    public void tryCreatePendingStreams() {
        while (!this.pendingStreams.isEmpty() && canCreateStream()) {
            PendingStream value = this.pendingStreams.pollFirstEntry().getValue();
            try {
                value.sendFrames();
            } catch (Throwable th) {
                value.close(th);
            }
        }
    }

    public void close() {
        try {
            if (!this.closed) {
                this.closed = true;
                Http2ChannelClosedException http2ChannelClosedException = new Http2ChannelClosedException();
                while (!this.pendingStreams.isEmpty()) {
                    this.pendingStreams.pollFirstEntry().getValue().close(http2ChannelClosedException);
                }
            }
        } finally {
            super.close();
        }
    }

    public int numBufferedStreams() {
        return this.pendingStreams.size();
    }

    public void remoteSettings(Http2Settings http2Settings) throws Http2Exception {
        super.remoteSettings(http2Settings);
        this.maxConcurrentStreams = connection().local().maxActiveStreams();
        tryCreatePendingStreams();
    }

    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z, ChannelPromise channelPromise) {
        if (isExistingStream(i)) {
            return super.writeData(channelHandlerContext, i, byteBuf, i2, z, channelPromise);
        }
        PendingStream pendingStream = this.pendingStreams.get(Integer.valueOf(i));
        if (pendingStream != null) {
            pendingStream.frames.add(new DataFrame(byteBuf, i2, z, channelPromise));
        } else {
            ReferenceCountUtil.safeRelease(byteBuf);
            channelPromise.setFailure(Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream does not exist %d", Integer.valueOf(i)));
        }
        return channelPromise;
    }

    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z, ChannelPromise channelPromise) {
        return writeHeaders(channelHandlerContext, i, http2Headers, 0, 16, false, i2, z, channelPromise);
    }

    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i, long j, ChannelPromise channelPromise) {
        if (isExistingStream(i)) {
            return super.writeRstStream(channelHandlerContext, i, j, channelPromise);
        }
        PendingStream remove = this.pendingStreams.remove(Integer.valueOf(i));
        if (remove != null) {
            remove.close((Throwable) null);
            channelPromise.setSuccess();
        } else {
            channelPromise.setFailure(Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream does not exist %d", Integer.valueOf(i)));
        }
        return channelPromise;
    }

    public StreamBufferingEncoder(Http2ConnectionEncoder http2ConnectionEncoder, int i) {
        super(http2ConnectionEncoder);
        this.pendingStreams = new TreeMap<>();
        this.maxConcurrentStreams = i;
        connection().addListener(new Http2ConnectionAdapter() {
            public void onGoAwayReceived(int i, long j, ByteBuf byteBuf) {
                GoAwayDetail unused = StreamBufferingEncoder.this.goAwayDetail = new GoAwayDetail(i, j, ByteBufUtil.getBytes(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), false));
                StreamBufferingEncoder streamBufferingEncoder = StreamBufferingEncoder.this;
                streamBufferingEncoder.cancelGoAwayStreams(streamBufferingEncoder.goAwayDetail);
            }

            public void onStreamClosed(Http2Stream http2Stream) {
                StreamBufferingEncoder.this.tryCreatePendingStreams();
            }
        });
    }

    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2, ChannelPromise channelPromise) {
        int i4 = i;
        ChannelPromise channelPromise2 = channelPromise;
        if (this.closed) {
            return channelPromise2.setFailure(new Http2ChannelClosedException());
        }
        if (isExistingStream(i) || canCreateStream()) {
            ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
            return super.writeHeaders(channelHandlerContext, i, http2Headers, i2, s, z, i3, z2, channelPromise);
        } else if (this.goAwayDetail != null) {
            return channelPromise2.setFailure(new Http2GoAwayException(this.goAwayDetail));
        } else {
            PendingStream pendingStream = this.pendingStreams.get(Integer.valueOf(i));
            if (pendingStream == null) {
                ChannelHandlerContext channelHandlerContext3 = channelHandlerContext;
                pendingStream = new PendingStream(channelHandlerContext, i);
                this.pendingStreams.put(Integer.valueOf(i), pendingStream);
            }
            pendingStream.frames.add(new HeadersFrame(http2Headers, i2, s, z, i3, z2, channelPromise));
            return channelPromise2;
        }
    }
}
