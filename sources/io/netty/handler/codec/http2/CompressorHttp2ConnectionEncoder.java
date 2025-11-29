package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.Brotli;
import io.netty.handler.codec.compression.BrotliEncoder;
import io.netty.handler.codec.compression.BrotliOptions;
import io.netty.handler.codec.compression.CompressionOptions;
import io.netty.handler.codec.compression.DeflateOptions;
import io.netty.handler.codec.compression.GzipOptions;
import io.netty.handler.codec.compression.StandardCompressionOptions;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.compression.ZstdEncoder;
import io.netty.handler.codec.compression.ZstdOptions;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;

public class CompressorHttp2ConnectionEncoder extends DecoratingHttp2ConnectionEncoder {
    public static final int DEFAULT_COMPRESSION_LEVEL = 6;
    public static final int DEFAULT_MEM_LEVEL = 8;
    public static final int DEFAULT_WINDOW_BITS = 15;
    private BrotliOptions brotliOptions;
    private int compressionLevel;
    private DeflateOptions deflateOptions;
    private GzipOptions gzipCompressionOptions;
    private int memLevel;
    /* access modifiers changed from: private */
    public final Http2Connection.PropertyKey propertyKey;
    private final boolean supportsCompressionOptions;
    private int windowBits;
    private ZstdOptions zstdOptions;

    public CompressorHttp2ConnectionEncoder(Http2ConnectionEncoder http2ConnectionEncoder) {
        this(http2ConnectionEncoder, defaultCompressionOptions());
    }

    private void bindCompressorToStream(EmbeddedChannel embeddedChannel, int i) {
        Http2Stream stream;
        if (embeddedChannel != null && (stream = connection().stream(i)) != null) {
            stream.setProperty(this.propertyKey, embeddedChannel);
        }
    }

    private static CompressionOptions[] defaultCompressionOptions() {
        if (Brotli.isAvailable()) {
            return new CompressionOptions[]{StandardCompressionOptions.brotli(), StandardCompressionOptions.gzip(), StandardCompressionOptions.deflate()};
        }
        return new CompressionOptions[]{StandardCompressionOptions.gzip(), StandardCompressionOptions.deflate()};
    }

    private EmbeddedChannel newCompressionChannel(ChannelHandlerContext channelHandlerContext, ZlibWrapper zlibWrapper) {
        if (!this.supportsCompressionOptions) {
            return new EmbeddedChannel(channelHandlerContext.channel().id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), ZlibCodecFactory.newZlibEncoder(zlibWrapper, this.compressionLevel, this.windowBits, this.memLevel));
        } else if (zlibWrapper == ZlibWrapper.GZIP && this.gzipCompressionOptions != null) {
            return new EmbeddedChannel(channelHandlerContext.channel().id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), ZlibCodecFactory.newZlibEncoder(zlibWrapper, this.gzipCompressionOptions.compressionLevel(), this.gzipCompressionOptions.windowBits(), this.gzipCompressionOptions.memLevel()));
        } else if (zlibWrapper != ZlibWrapper.ZLIB || this.deflateOptions == null) {
            throw new IllegalArgumentException("Unsupported ZlibWrapper: " + zlibWrapper);
        } else {
            return new EmbeddedChannel(channelHandlerContext.channel().id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), ZlibCodecFactory.newZlibEncoder(zlibWrapper, this.deflateOptions.compressionLevel(), this.deflateOptions.windowBits(), this.deflateOptions.memLevel()));
        }
    }

    private EmbeddedChannel newCompressor(ChannelHandlerContext channelHandlerContext, Http2Headers http2Headers, boolean z) throws Http2Exception {
        if (z) {
            return null;
        }
        AsciiString asciiString = HttpHeaderNames.CONTENT_ENCODING;
        CharSequence charSequence = (CharSequence) http2Headers.get(asciiString);
        if (charSequence == null) {
            charSequence = HttpHeaderValues.IDENTITY;
        }
        EmbeddedChannel newContentCompressor = newContentCompressor(channelHandlerContext, charSequence);
        if (newContentCompressor != null) {
            CharSequence targetContentEncoding = getTargetContentEncoding(charSequence);
            if (HttpHeaderValues.IDENTITY.contentEqualsIgnoreCase(targetContentEncoding)) {
                http2Headers.remove(asciiString);
            } else {
                http2Headers.set(asciiString, targetContentEncoding);
            }
            http2Headers.remove(HttpHeaderNames.CONTENT_LENGTH);
        }
        return newContentCompressor;
    }

    private static ByteBuf nextReadableBuf(EmbeddedChannel embeddedChannel) {
        while (true) {
            ByteBuf byteBuf = (ByteBuf) embeddedChannel.readOutbound();
            if (byteBuf == null) {
                return null;
            }
            if (byteBuf.isReadable()) {
                return byteBuf;
            }
            byteBuf.release();
        }
    }

    public void cleanup(Http2Stream http2Stream, EmbeddedChannel embeddedChannel) {
        embeddedChannel.finishAndReleaseAll();
        http2Stream.removeProperty(this.propertyKey);
    }

    public CharSequence getTargetContentEncoding(CharSequence charSequence) throws Http2Exception {
        return charSequence;
    }

    public EmbeddedChannel newContentCompressor(ChannelHandlerContext channelHandlerContext, CharSequence charSequence) throws Http2Exception {
        if (HttpHeaderValues.GZIP.contentEqualsIgnoreCase(charSequence) || HttpHeaderValues.X_GZIP.contentEqualsIgnoreCase(charSequence)) {
            return newCompressionChannel(channelHandlerContext, ZlibWrapper.GZIP);
        }
        if (HttpHeaderValues.DEFLATE.contentEqualsIgnoreCase(charSequence) || HttpHeaderValues.X_DEFLATE.contentEqualsIgnoreCase(charSequence)) {
            return newCompressionChannel(channelHandlerContext, ZlibWrapper.ZLIB);
        }
        if (Brotli.isAvailable() && this.brotliOptions != null && HttpHeaderValues.BR.contentEqualsIgnoreCase(charSequence)) {
            return new EmbeddedChannel(channelHandlerContext.channel().id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), new BrotliEncoder(this.brotliOptions.parameters()));
        } else if (this.zstdOptions == null || !HttpHeaderValues.ZSTD.contentEqualsIgnoreCase(charSequence)) {
            return null;
        } else {
            return new EmbeddedChannel(channelHandlerContext.channel().id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), new ZstdEncoder(this.zstdOptions.compressionLevel(), this.zstdOptions.blockSize(), this.zstdOptions.maxEncodeSize()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a1, code lost:
        if (r20 != false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a3, code lost:
        cleanup(r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ad, code lost:
        if (r20 == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b0, code lost:
        return r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.netty.channel.ChannelFuture writeData(io.netty.channel.ChannelHandlerContext r16, int r17, io.netty.buffer.ByteBuf r18, int r19, boolean r20, io.netty.channel.ChannelPromise r21) {
        /*
            r15 = this;
            r8 = r15
            r9 = r21
            io.netty.handler.codec.http2.Http2Connection r0 = r15.connection()
            r10 = r17
            io.netty.handler.codec.http2.Http2Stream r11 = r0.stream(r10)
            if (r11 != 0) goto L_0x0012
            r0 = 0
        L_0x0010:
            r12 = r0
            goto L_0x001b
        L_0x0012:
            io.netty.handler.codec.http2.Http2Connection$PropertyKey r0 = r8.propertyKey
            java.lang.Object r0 = r11.getProperty(r0)
            io.netty.channel.embedded.EmbeddedChannel r0 = (io.netty.channel.embedded.EmbeddedChannel) r0
            goto L_0x0010
        L_0x001b:
            if (r12 != 0) goto L_0x0022
            io.netty.channel.ChannelFuture r0 = super.writeData(r16, r17, r18, r19, r20, r21)
            return r0
        L_0x0022:
            java.lang.Object[] r0 = new java.lang.Object[]{r18}     // Catch:{ all -> 0x003c }
            r12.writeOutbound(r0)     // Catch:{ all -> 0x003c }
            io.netty.buffer.ByteBuf r0 = nextReadableBuf(r12)     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x0061
            if (r20 == 0) goto L_0x0058
            boolean r1 = r12.finish()     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x003f
            io.netty.buffer.ByteBuf r0 = nextReadableBuf(r12)     // Catch:{ all -> 0x003c }
            goto L_0x003f
        L_0x003c:
            r0 = move-exception
            goto L_0x00aa
        L_0x003f:
            if (r0 != 0) goto L_0x0043
            io.netty.buffer.ByteBuf r0 = io.netty.buffer.Unpooled.EMPTY_BUFFER     // Catch:{ all -> 0x003c }
        L_0x0043:
            r4 = r0
            r6 = 1
            r1 = r15
            r2 = r16
            r3 = r17
            r5 = r19
            r7 = r21
            io.netty.channel.ChannelFuture r0 = super.writeData(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x003c }
            if (r20 == 0) goto L_0x0057
            r15.cleanup(r11, r12)
        L_0x0057:
            return r0
        L_0x0058:
            r21.setSuccess()     // Catch:{ all -> 0x003c }
            if (r20 == 0) goto L_0x0060
            r15.cleanup(r11, r12)
        L_0x0060:
            return r9
        L_0x0061:
            io.netty.util.concurrent.PromiseCombiner r13 = new io.netty.util.concurrent.PromiseCombiner     // Catch:{ all -> 0x003c }
            io.netty.util.concurrent.EventExecutor r1 = r16.executor()     // Catch:{ all -> 0x003c }
            r13.<init>(r1)     // Catch:{ all -> 0x003c }
            r5 = r19
            r4 = r0
        L_0x006d:
            io.netty.buffer.ByteBuf r0 = nextReadableBuf(r12)     // Catch:{ all -> 0x003c }
            r1 = 1
            r14 = 0
            if (r0 != 0) goto L_0x0079
            if (r20 == 0) goto L_0x0079
            r2 = r1
            goto L_0x007a
        L_0x0079:
            r2 = r14
        L_0x007a:
            if (r2 == 0) goto L_0x008c
            boolean r3 = r12.finish()     // Catch:{ all -> 0x003c }
            if (r3 == 0) goto L_0x008c
            io.netty.buffer.ByteBuf r0 = nextReadableBuf(r12)     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r1 = r14
        L_0x008a:
            r6 = r1
            goto L_0x008d
        L_0x008c:
            r6 = r2
        L_0x008d:
            io.netty.channel.ChannelPromise r7 = r16.newPromise()     // Catch:{ all -> 0x003c }
            r13.add((io.netty.util.concurrent.Promise) r7)     // Catch:{ all -> 0x003c }
            r1 = r15
            r2 = r16
            r3 = r17
            super.writeData(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x00a7
            r13.finish(r9)     // Catch:{ all -> 0x003c }
            if (r20 == 0) goto L_0x00b0
        L_0x00a3:
            r15.cleanup(r11, r12)
            goto L_0x00b0
        L_0x00a7:
            r4 = r0
            r5 = r14
            goto L_0x006d
        L_0x00aa:
            r9.tryFailure(r0)     // Catch:{ all -> 0x00b1 }
            if (r20 == 0) goto L_0x00b0
            goto L_0x00a3
        L_0x00b0:
            return r9
        L_0x00b1:
            r0 = move-exception
            r1 = r0
            if (r20 == 0) goto L_0x00b8
            r15.cleanup(r11, r12)
        L_0x00b8:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.CompressorHttp2ConnectionEncoder.writeData(io.netty.channel.ChannelHandlerContext, int, io.netty.buffer.ByteBuf, int, boolean, io.netty.channel.ChannelPromise):io.netty.channel.ChannelFuture");
    }

    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z, ChannelPromise channelPromise) {
        try {
            EmbeddedChannel newCompressor = newCompressor(channelHandlerContext, http2Headers, z);
            ChannelFuture writeHeaders = super.writeHeaders(channelHandlerContext, i, http2Headers, i2, z, channelPromise);
            bindCompressorToStream(newCompressor, i);
            return writeHeaders;
        } catch (Throwable th) {
            channelPromise.tryFailure(th);
            return channelPromise;
        }
    }

    @Deprecated
    public CompressorHttp2ConnectionEncoder(Http2ConnectionEncoder http2ConnectionEncoder, int i, int i2, int i3) {
        super(http2ConnectionEncoder);
        this.compressionLevel = ObjectUtil.checkInRange(i, 0, 9, "compressionLevel");
        this.windowBits = ObjectUtil.checkInRange(i2, 9, 15, "windowBits");
        this.memLevel = ObjectUtil.checkInRange(i3, 1, 9, "memLevel");
        this.propertyKey = connection().newKey();
        connection().addListener(new Http2ConnectionAdapter() {
            public void onStreamRemoved(Http2Stream http2Stream) {
                EmbeddedChannel embeddedChannel = (EmbeddedChannel) http2Stream.getProperty(CompressorHttp2ConnectionEncoder.this.propertyKey);
                if (embeddedChannel != null) {
                    CompressorHttp2ConnectionEncoder.this.cleanup(http2Stream, embeddedChannel);
                }
            }
        });
        this.supportsCompressionOptions = false;
    }

    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2, ChannelPromise channelPromise) {
        try {
            EmbeddedChannel newCompressor = newCompressor(channelHandlerContext, http2Headers, z2);
            ChannelFuture writeHeaders = super.writeHeaders(channelHandlerContext, i, http2Headers, i2, s, z, i3, z2, channelPromise);
            bindCompressorToStream(newCompressor, i);
            return writeHeaders;
        } catch (Throwable th) {
            channelPromise.tryFailure(th);
            return channelPromise;
        }
    }

    public CompressorHttp2ConnectionEncoder(Http2ConnectionEncoder http2ConnectionEncoder, CompressionOptions... compressionOptionsArr) {
        super(http2ConnectionEncoder);
        ObjectUtil.checkNotNull(compressionOptionsArr, "CompressionOptions");
        ObjectUtil.deepCheckNotNull("CompressionOptions", compressionOptionsArr);
        for (BrotliOptions brotliOptions2 : compressionOptionsArr) {
            if (Brotli.isAvailable() && (brotliOptions2 instanceof BrotliOptions)) {
                this.brotliOptions = brotliOptions2;
            } else if (brotliOptions2 instanceof GzipOptions) {
                this.gzipCompressionOptions = (GzipOptions) brotliOptions2;
            } else if (brotliOptions2 instanceof DeflateOptions) {
                this.deflateOptions = (DeflateOptions) brotliOptions2;
            } else if (brotliOptions2 instanceof ZstdOptions) {
                this.zstdOptions = (ZstdOptions) brotliOptions2;
            } else {
                throw new IllegalArgumentException("Unsupported " + CompressionOptions.class.getSimpleName() + ": " + brotliOptions2);
            }
        }
        this.supportsCompressionOptions = true;
        this.propertyKey = connection().newKey();
        connection().addListener(new Http2ConnectionAdapter() {
            public void onStreamRemoved(Http2Stream http2Stream) {
                EmbeddedChannel embeddedChannel = (EmbeddedChannel) http2Stream.getProperty(CompressorHttp2ConnectionEncoder.this.propertyKey);
                if (embeddedChannel != null) {
                    CompressorHttp2ConnectionEncoder.this.cleanup(http2Stream, embeddedChannel);
                }
            }
        });
    }
}
