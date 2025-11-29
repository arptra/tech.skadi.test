package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.http.HttpClientUpgradeHandler;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public final class HttpClientCodec extends CombinedChannelDuplexHandler<HttpResponseDecoder, HttpRequestEncoder> implements HttpClientUpgradeHandler.SourceCodec {
    public static final boolean DEFAULT_FAIL_ON_MISSING_RESPONSE = false;
    public static final boolean DEFAULT_PARSE_HTTP_AFTER_CONNECT_REQUEST = false;
    /* access modifiers changed from: private */
    public boolean done;
    /* access modifiers changed from: private */
    public final boolean failOnMissingResponse;
    /* access modifiers changed from: private */
    public final boolean parseHttpAfterConnectRequest;
    /* access modifiers changed from: private */
    public final Queue<HttpMethod> queue;
    /* access modifiers changed from: private */
    public final AtomicLong requestResponseCounter;

    public final class Encoder extends HttpRequestEncoder {
        boolean upgraded;

        private Encoder() {
        }

        public void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
            if (this.upgraded) {
                list.add(ReferenceCountUtil.retain(obj));
                return;
            }
            if (obj instanceof HttpRequest) {
                HttpClientCodec.this.queue.offer(((HttpRequest) obj).method());
            }
            super.encode(channelHandlerContext, obj, list);
            if (HttpClientCodec.this.failOnMissingResponse && !HttpClientCodec.this.done && (obj instanceof LastHttpContent)) {
                HttpClientCodec.this.requestResponseCounter.incrementAndGet();
            }
        }
    }

    public HttpClientCodec() {
        this(4096, 8192, 8192, false);
    }

    public boolean isSingleDecode() {
        return ((HttpResponseDecoder) inboundHandler()).isSingleDecode();
    }

    public void prepareUpgradeFrom(ChannelHandlerContext channelHandlerContext) {
        ((Encoder) outboundHandler()).upgraded = true;
    }

    public void setSingleDecode(boolean z) {
        ((HttpResponseDecoder) inboundHandler()).setSingleDecode(z);
    }

    public void upgradeFrom(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove((ChannelHandler) this);
    }

    public final class Decoder extends HttpResponseDecoder {
        public Decoder(int i, int i2, int i3, boolean z) {
            super(i, i2, i3, z);
        }

        private void decrement(Object obj) {
            if (obj != null && (obj instanceof LastHttpContent)) {
                HttpClientCodec.this.requestResponseCounter.decrementAndGet();
            }
        }

        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            super.channelInactive(channelHandlerContext);
            if (HttpClientCodec.this.failOnMissingResponse) {
                long j = HttpClientCodec.this.requestResponseCounter.get();
                if (j > 0) {
                    channelHandlerContext.fireExceptionCaught(new PrematureChannelClosureException("channel gone inactive with " + j + " missing response(s)"));
                }
            }
        }

        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            if (HttpClientCodec.this.done) {
                int actualReadableBytes = actualReadableBytes();
                if (actualReadableBytes != 0) {
                    list.add(byteBuf.readBytes(actualReadableBytes));
                    return;
                }
                return;
            }
            super.decode(channelHandlerContext, byteBuf, list);
            if (HttpClientCodec.this.failOnMissingResponse) {
                int size = list.size();
                for (int size2 = list.size(); size2 < size; size2++) {
                    decrement(list.get(size2));
                }
            }
        }

        public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
            HttpMethod httpMethod = (HttpMethod) HttpClientCodec.this.queue.poll();
            int code = ((HttpResponse) httpMessage).status().code();
            if (code >= 100 && code < 200) {
                return super.isContentAlwaysEmpty(httpMessage);
            }
            if (httpMethod != null) {
                char charAt = httpMethod.name().charAt(0);
                if (charAt != 'C') {
                    if (charAt == 'H' && HttpMethod.HEAD.equals(httpMethod)) {
                        return true;
                    }
                } else if (code == 200 && HttpMethod.CONNECT.equals(httpMethod)) {
                    if (!HttpClientCodec.this.parseHttpAfterConnectRequest) {
                        boolean unused = HttpClientCodec.this.done = true;
                        HttpClientCodec.this.queue.clear();
                    }
                    return true;
                }
            }
            return super.isContentAlwaysEmpty(httpMessage);
        }

        public Decoder(int i, int i2, int i3, boolean z, int i4, boolean z2, boolean z3) {
            super(i, i2, i3, z, i4, z2, z3);
        }
    }

    public HttpClientCodec(int i, int i2, int i3) {
        this(i, i2, i3, false);
    }

    public HttpClientCodec(int i, int i2, int i3, boolean z) {
        this(i, i2, i3, z, true);
    }

    public HttpClientCodec(int i, int i2, int i3, boolean z, boolean z2) {
        this(i, i2, i3, z, z2, false);
    }

    public HttpClientCodec(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.queue = new ArrayDeque();
        this.requestResponseCounter = new AtomicLong();
        init(new Decoder(i, i2, i3, z2), new Encoder());
        this.failOnMissingResponse = z;
        this.parseHttpAfterConnectRequest = z3;
    }

    public HttpClientCodec(int i, int i2, int i3, boolean z, boolean z2, int i4) {
        this(i, i2, i3, z, z2, i4, false);
    }

    public HttpClientCodec(int i, int i2, int i3, boolean z, boolean z2, int i4, boolean z3) {
        this(i, i2, i3, z, z2, i4, z3, false);
    }

    public HttpClientCodec(int i, int i2, int i3, boolean z, boolean z2, int i4, boolean z3, boolean z4) {
        this(i, i2, i3, z, z2, i4, z3, z4, true);
    }

    public HttpClientCodec(int i, int i2, int i3, boolean z, boolean z2, int i4, boolean z3, boolean z4, boolean z5) {
        this.queue = new ArrayDeque();
        this.requestResponseCounter = new AtomicLong();
        init(new Decoder(i, i2, i3, z2, i4, z4, z5), new Encoder());
        this.parseHttpAfterConnectRequest = z3;
        this.failOnMissingResponse = z;
    }
}
