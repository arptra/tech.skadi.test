package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public final class HttpServerCodec extends CombinedChannelDuplexHandler<HttpRequestDecoder, HttpResponseEncoder> implements HttpServerUpgradeHandler.SourceCodec {
    /* access modifiers changed from: private */
    public final Queue<HttpMethod> queue;

    public final class HttpServerResponseEncoder extends HttpResponseEncoder {
        private HttpMethod method;

        private HttpServerResponseEncoder() {
        }

        public boolean isContentAlwaysEmpty(HttpResponse httpResponse) {
            HttpMethod httpMethod = (HttpMethod) HttpServerCodec.this.queue.poll();
            this.method = httpMethod;
            return HttpMethod.HEAD.equals(httpMethod) || super.isContentAlwaysEmpty(httpResponse);
        }

        public void sanitizeHeadersBeforeEncode(HttpResponse httpResponse, boolean z) {
            if (z || !HttpMethod.CONNECT.equals(this.method) || httpResponse.status().codeClass() != HttpStatusClass.SUCCESS) {
                super.sanitizeHeadersBeforeEncode(httpResponse, z);
            } else {
                httpResponse.headers().remove((CharSequence) HttpHeaderNames.TRANSFER_ENCODING);
            }
        }
    }

    public HttpServerCodec() {
        this(4096, 8192, 8192);
    }

    public void upgradeFrom(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove((ChannelHandler) this);
    }

    public final class HttpServerRequestDecoder extends HttpRequestDecoder {
        public HttpServerRequestDecoder(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            super.decode(channelHandlerContext, byteBuf, list);
            int size = list.size();
            for (int size2 = list.size(); size2 < size; size2++) {
                Object obj = list.get(size2);
                if (obj instanceof HttpRequest) {
                    HttpServerCodec.this.queue.add(((HttpRequest) obj).method());
                }
            }
        }

        public HttpServerRequestDecoder(int i, int i2, int i3, boolean z) {
            super(i, i2, i3, z);
        }

        public HttpServerRequestDecoder(int i, int i2, int i3, boolean z, int i4) {
            super(i, i2, i3, z, i4);
        }

        public HttpServerRequestDecoder(int i, int i2, int i3, boolean z, int i4, boolean z2) {
            super(i, i2, i3, z, i4, z2);
        }

        public HttpServerRequestDecoder(int i, int i2, int i3, boolean z, int i4, boolean z2, boolean z3) {
            super(i, i2, i3, z, i4, z2, z3);
        }
    }

    public HttpServerCodec(int i, int i2, int i3) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i, i2, i3), new HttpServerResponseEncoder());
    }

    public HttpServerCodec(int i, int i2, int i3, boolean z) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i, i2, i3, z), new HttpServerResponseEncoder());
    }

    public HttpServerCodec(int i, int i2, int i3, boolean z, int i4) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i, i2, i3, z, i4), new HttpServerResponseEncoder());
    }

    public HttpServerCodec(int i, int i2, int i3, boolean z, int i4, boolean z2) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i, i2, i3, z, i4, z2), new HttpServerResponseEncoder());
    }

    public HttpServerCodec(int i, int i2, int i3, boolean z, int i4, boolean z2, boolean z3) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i, i2, i3, z, i4, z2, z3), new HttpServerResponseEncoder());
    }
}
