package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.HttpConversionUtil;

public class HttpToHttp2ConnectionHandler extends Http2ConnectionHandler {
    private int currentStreamId;
    private HttpScheme httpScheme;
    private final boolean validateHeaders;

    public HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings);
        this.validateHeaders = z;
    }

    private int getStreamId(HttpHeaders httpHeaders) throws Exception {
        return httpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), connection().local().incrementAndGetNextStreamId());
    }

    private static void writeHeaders(ChannelHandlerContext channelHandlerContext, Http2ConnectionEncoder http2ConnectionEncoder, int i, HttpHeaders httpHeaders, Http2Headers http2Headers, boolean z, Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator) {
        HttpHeaders httpHeaders2 = httpHeaders;
        http2ConnectionEncoder.writeHeaders(channelHandlerContext, i, http2Headers, httpHeaders2.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_DEPENDENCY_ID.text(), 0), httpHeaders2.getShort(HttpConversionUtil.ExtensionHeaderNames.STREAM_WEIGHT.text(), 16), false, 0, z, simpleChannelPromiseAggregator.newPromise());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d8, code lost:
        if (r15 != false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00da, code lost:
        io.netty.util.ReferenceCountUtil.release(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00dd, code lost:
        r0.doneAllocatingPromises();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e7, code lost:
        if (r9 != false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ea, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(io.netty.channel.ChannelHandlerContext r13, java.lang.Object r14, io.netty.channel.ChannelPromise r15) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof io.netty.handler.codec.http.HttpMessage
            if (r0 != 0) goto L_0x000c
            boolean r0 = r14 instanceof io.netty.handler.codec.http.HttpContent
            if (r0 != 0) goto L_0x000c
            r13.write(r14, r15)
            return
        L_0x000c:
            io.netty.handler.codec.http2.Http2CodecUtil$SimpleChannelPromiseAggregator r0 = new io.netty.handler.codec.http2.Http2CodecUtil$SimpleChannelPromiseAggregator
            io.netty.channel.Channel r1 = r13.channel()
            io.netty.util.concurrent.EventExecutor r2 = r13.executor()
            r0.<init>(r15, r1, r2)
            r15 = 1
            io.netty.handler.codec.http2.Http2ConnectionEncoder r8 = r12.encoder()     // Catch:{ all -> 0x0056 }
            boolean r1 = r14 instanceof io.netty.handler.codec.http.HttpMessage     // Catch:{ all -> 0x0056 }
            r9 = 0
            if (r1 == 0) goto L_0x0082
            r1 = r14
            io.netty.handler.codec.http.HttpMessage r1 = (io.netty.handler.codec.http.HttpMessage) r1     // Catch:{ all -> 0x0056 }
            io.netty.handler.codec.http.HttpHeaders r2 = r1.headers()     // Catch:{ all -> 0x0056 }
            int r2 = r12.getStreamId(r2)     // Catch:{ all -> 0x0056 }
            r12.currentStreamId = r2     // Catch:{ all -> 0x0056 }
            io.netty.handler.codec.http.HttpScheme r2 = r12.httpScheme     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x005a
            io.netty.handler.codec.http.HttpHeaders r2 = r1.headers()     // Catch:{ all -> 0x0056 }
            io.netty.handler.codec.http2.HttpConversionUtil$ExtensionHeaderNames r3 = io.netty.handler.codec.http2.HttpConversionUtil.ExtensionHeaderNames.SCHEME     // Catch:{ all -> 0x0056 }
            io.netty.util.AsciiString r4 = r3.text()     // Catch:{ all -> 0x0056 }
            boolean r2 = r2.contains((java.lang.CharSequence) r4)     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x005a
            io.netty.handler.codec.http.HttpHeaders r2 = r1.headers()     // Catch:{ all -> 0x0056 }
            io.netty.util.AsciiString r3 = r3.text()     // Catch:{ all -> 0x0056 }
            io.netty.handler.codec.http.HttpScheme r4 = r12.httpScheme     // Catch:{ all -> 0x0056 }
            io.netty.util.AsciiString r4 = r4.name()     // Catch:{ all -> 0x0056 }
            r2.set((java.lang.CharSequence) r3, (java.lang.Object) r4)     // Catch:{ all -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r1 = move-exception
            r9 = r15
            goto L_0x00e1
        L_0x005a:
            boolean r2 = r12.validateHeaders     // Catch:{ all -> 0x0056 }
            io.netty.handler.codec.http2.Http2Headers r5 = io.netty.handler.codec.http2.HttpConversionUtil.toHttp2Headers((io.netty.handler.codec.http.HttpMessage) r1, (boolean) r2)     // Catch:{ all -> 0x0056 }
            boolean r2 = r14 instanceof io.netty.handler.codec.http.FullHttpMessage     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0073
            r2 = r14
            io.netty.handler.codec.http.FullHttpMessage r2 = (io.netty.handler.codec.http.FullHttpMessage) r2     // Catch:{ all -> 0x0056 }
            io.netty.buffer.ByteBuf r2 = r2.content()     // Catch:{ all -> 0x0056 }
            boolean r2 = r2.isReadable()     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x0073
            r10 = r15
            goto L_0x0074
        L_0x0073:
            r10 = r9
        L_0x0074:
            int r3 = r12.currentStreamId     // Catch:{ all -> 0x0056 }
            io.netty.handler.codec.http.HttpHeaders r4 = r1.headers()     // Catch:{ all -> 0x0056 }
            r1 = r13
            r2 = r8
            r6 = r10
            r7 = r0
            writeHeaders(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0056 }
            goto L_0x0083
        L_0x0082:
            r10 = r9
        L_0x0083:
            if (r10 != 0) goto L_0x00d8
            boolean r1 = r14 instanceof io.netty.handler.codec.http.HttpContent     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x00d8
            io.netty.handler.codec.http.EmptyHttpHeaders r1 = io.netty.handler.codec.http.EmptyHttpHeaders.INSTANCE     // Catch:{ all -> 0x0056 }
            io.netty.handler.codec.http2.EmptyHttp2Headers r2 = io.netty.handler.codec.http2.EmptyHttp2Headers.INSTANCE     // Catch:{ all -> 0x0056 }
            boolean r3 = r14 instanceof io.netty.handler.codec.http.LastHttpContent     // Catch:{ all -> 0x0056 }
            if (r3 == 0) goto L_0x00a2
            r1 = r14
            io.netty.handler.codec.http.LastHttpContent r1 = (io.netty.handler.codec.http.LastHttpContent) r1     // Catch:{ all -> 0x0056 }
            io.netty.handler.codec.http.HttpHeaders r1 = r1.trailingHeaders()     // Catch:{ all -> 0x0056 }
            boolean r2 = r12.validateHeaders     // Catch:{ all -> 0x0056 }
            io.netty.handler.codec.http2.Http2Headers r2 = io.netty.handler.codec.http2.HttpConversionUtil.toHttp2Headers((io.netty.handler.codec.http.HttpHeaders) r1, (boolean) r2)     // Catch:{ all -> 0x0056 }
            r10 = r1
            r11 = r2
            r1 = r15
            goto L_0x00a5
        L_0x00a2:
            r10 = r1
            r11 = r2
            r1 = r9
        L_0x00a5:
            r2 = r14
            io.netty.handler.codec.http.HttpContent r2 = (io.netty.handler.codec.http.HttpContent) r2     // Catch:{ all -> 0x0056 }
            io.netty.buffer.ByteBuf r4 = r2.content()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x00b6
            boolean r1 = r10.isEmpty()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x00b6
            r6 = r15
            goto L_0x00b7
        L_0x00b6:
            r6 = r9
        L_0x00b7:
            int r3 = r12.currentStreamId     // Catch:{ all -> 0x0056 }
            io.netty.channel.ChannelPromise r7 = r0.newPromise()     // Catch:{ all -> 0x0056 }
            r5 = 0
            r1 = r8
            r2 = r13
            r1.writeData(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0056 }
            boolean r1 = r10.isEmpty()     // Catch:{ all -> 0x00d5 }
            if (r1 != 0) goto L_0x00d7
            int r3 = r12.currentStreamId     // Catch:{ all -> 0x00d5 }
            r6 = 1
            r1 = r13
            r2 = r8
            r4 = r10
            r5 = r11
            r7 = r0
            writeHeaders(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00d5 }
            goto L_0x00d7
        L_0x00d5:
            r1 = move-exception
            goto L_0x00e1
        L_0x00d7:
            r15 = r9
        L_0x00d8:
            if (r15 == 0) goto L_0x00dd
        L_0x00da:
            io.netty.util.ReferenceCountUtil.release(r14)
        L_0x00dd:
            r0.doneAllocatingPromises()
            goto L_0x00ea
        L_0x00e1:
            r12.onError(r13, r15, r1)     // Catch:{ all -> 0x00eb }
            r0.setFailure((java.lang.Throwable) r1)     // Catch:{ all -> 0x00eb }
            if (r9 == 0) goto L_0x00dd
            goto L_0x00da
        L_0x00ea:
            return
        L_0x00eb:
            r12 = move-exception
            if (r9 == 0) goto L_0x00f1
            io.netty.util.ReferenceCountUtil.release(r14)
        L_0x00f1:
            r0.doneAllocatingPromises()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.HttpToHttp2ConnectionHandler.write(io.netty.channel.ChannelHandlerContext, java.lang.Object, io.netty.channel.ChannelPromise):void");
    }

    public HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z, boolean z2) {
        this(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, z, z2, (HttpScheme) null);
    }

    public HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z, boolean z2, HttpScheme httpScheme2) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, z2);
        this.validateHeaders = z;
        this.httpScheme = httpScheme2;
    }

    public HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z, boolean z2, boolean z3, HttpScheme httpScheme2) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, z2, z3);
        this.validateHeaders = z;
        this.httpScheme = httpScheme2;
    }
}
