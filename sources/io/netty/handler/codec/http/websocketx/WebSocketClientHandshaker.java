package io.netty.handler.codec.http.websocketx;

import com.meizu.common.widget.MzContactsContract;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentDecompressor;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.NetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import java.net.URI;
import java.nio.channels.ClosedChannelException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class WebSocketClientHandshaker {
    protected static final int DEFAULT_FORCE_CLOSE_TIMEOUT_MILLIS = 10000;
    /* access modifiers changed from: private */
    public static final AtomicIntegerFieldUpdater<WebSocketClientHandshaker> FORCE_CLOSE_INIT_UPDATER = AtomicIntegerFieldUpdater.newUpdater(WebSocketClientHandshaker.class, "forceCloseInit");
    private static final String HTTPS_SCHEME_PREFIX = (HttpScheme.HTTPS + "://");
    private static final String HTTP_SCHEME_PREFIX = (HttpScheme.HTTP + "://");
    private final boolean absoluteUpgradeUrl;
    private volatile String actualSubprotocol;
    protected final HttpHeaders customHeaders;
    private final String expectedSubprotocol;
    /* access modifiers changed from: private */
    public volatile boolean forceCloseComplete;
    private volatile int forceCloseInit;
    private volatile long forceCloseTimeoutMillis;
    private volatile boolean handshakeComplete;
    private final int maxFramePayloadLength;
    private final URI uri;
    private final WebSocketVersion version;

    public WebSocketClientHandshaker(URI uri2, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i) {
        this(uri2, webSocketVersion, str, httpHeaders, i, 10000);
    }

    private ChannelFuture close0(ChannelOutboundInvoker channelOutboundInvoker, Channel channel, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        channelOutboundInvoker.writeAndFlush(closeWebSocketFrame, channelPromise);
        final long j = this.forceCloseTimeoutMillis;
        if (j > 0 && channel.isActive() && this.forceCloseInit == 0) {
            final Channel channel2 = channel;
            final ChannelOutboundInvoker channelOutboundInvoker2 = channelOutboundInvoker;
            channelPromise.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) {
                    if (channelFuture.isSuccess() && channel2.isActive() && WebSocketClientHandshaker.FORCE_CLOSE_INIT_UPDATER.compareAndSet(this, 0, 1)) {
                        final ScheduledFuture<?> schedule = channel2.eventLoop().schedule((Runnable) new Runnable() {
                            public void run() {
                                if (channel2.isActive()) {
                                    channelOutboundInvoker2.close();
                                    boolean unused = WebSocketClientHandshaker.this.forceCloseComplete = true;
                                }
                            }
                        }, j, TimeUnit.MILLISECONDS);
                        channel2.closeFuture().addListener(new ChannelFutureListener() {
                            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                schedule.cancel(false);
                            }
                        });
                    }
                }
            });
        }
        return channelPromise;
    }

    private void setActualSubprotocol(String str) {
        this.actualSubprotocol = str;
    }

    private void setHandshakeComplete() {
        this.handshakeComplete = true;
    }

    public static CharSequence websocketHostValue(URI uri2) {
        int port = uri2.getPort();
        if (port == -1) {
            return uri2.getHost();
        }
        String host = uri2.getHost();
        String scheme = uri2.getScheme();
        HttpScheme httpScheme = HttpScheme.HTTP;
        if (port == httpScheme.port()) {
            return (httpScheme.name().contentEquals(scheme) || WebSocketScheme.WS.name().contentEquals(scheme)) ? host : NetUtil.toSocketAddressString(host, port);
        }
        HttpScheme httpScheme2 = HttpScheme.HTTPS;
        return port == httpScheme2.port() ? (httpScheme2.name().contentEquals(scheme) || WebSocketScheme.WSS.name().contentEquals(scheme)) ? host : NetUtil.toSocketAddressString(host, port) : NetUtil.toSocketAddressString(host, port);
    }

    public static CharSequence websocketOriginValue(URI uri2) {
        int i;
        String str;
        String scheme = uri2.getScheme();
        int port = uri2.getPort();
        WebSocketScheme webSocketScheme = WebSocketScheme.WSS;
        if (webSocketScheme.name().contentEquals(scheme) || HttpScheme.HTTPS.name().contentEquals(scheme) || (scheme == null && port == webSocketScheme.port())) {
            str = HTTPS_SCHEME_PREFIX;
            i = webSocketScheme.port();
        } else {
            str = HTTP_SCHEME_PREFIX;
            i = WebSocketScheme.WS.port();
        }
        String lowerCase = uri2.getHost().toLowerCase(Locale.US);
        if (port == i || port == -1) {
            return str + lowerCase;
        }
        return str + NetUtil.toSocketAddressString(lowerCase, port);
    }

    public String actualSubprotocol() {
        return this.actualSubprotocol;
    }

    public ChannelFuture close(Channel channel, CloseWebSocketFrame closeWebSocketFrame) {
        ObjectUtil.checkNotNull(channel, "channel");
        return close(channel, closeWebSocketFrame, channel.newPromise());
    }

    public String expectedSubprotocol() {
        return this.expectedSubprotocol;
    }

    public final void finishHandshake(Channel channel, FullHttpResponse fullHttpResponse) {
        verify(fullHttpResponse);
        String str = fullHttpResponse.headers().get((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL);
        String trim = str != null ? str.trim() : null;
        String str2 = this.expectedSubprotocol;
        if (str2 == null) {
            str2 = "";
        }
        if (!str2.isEmpty() || trim != null) {
            if (!str2.isEmpty() && trim != null && !trim.isEmpty()) {
                String[] split = str2.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                int length = split.length;
                int i = 0;
                while (i < length) {
                    if (split[i].trim().equals(trim)) {
                        setActualSubprotocol(trim);
                    } else {
                        i++;
                    }
                }
            }
            throw new WebSocketClientHandshakeException(String.format("Invalid subprotocol. Actual: %s. Expected one of: %s", new Object[]{trim, this.expectedSubprotocol}), fullHttpResponse);
        }
        setActualSubprotocol(this.expectedSubprotocol);
        setHandshakeComplete();
        final ChannelPipeline pipeline = channel.pipeline();
        HttpContentDecompressor httpContentDecompressor = (HttpContentDecompressor) pipeline.get(HttpContentDecompressor.class);
        if (httpContentDecompressor != null) {
            pipeline.remove((ChannelHandler) httpContentDecompressor);
        }
        HttpObjectAggregator httpObjectAggregator = (HttpObjectAggregator) pipeline.get(HttpObjectAggregator.class);
        if (httpObjectAggregator != null) {
            pipeline.remove((ChannelHandler) httpObjectAggregator);
        }
        final ChannelHandlerContext context = pipeline.context((Class<? extends ChannelHandler>) HttpResponseDecoder.class);
        if (context == null) {
            ChannelHandlerContext context2 = pipeline.context((Class<? extends ChannelHandler>) HttpClientCodec.class);
            if (context2 != null) {
                final HttpClientCodec httpClientCodec = (HttpClientCodec) context2.handler();
                httpClientCodec.removeOutboundHandler();
                pipeline.addAfter(context2.name(), "ws-decoder", newWebsocketDecoder());
                channel.eventLoop().execute(new Runnable() {
                    public void run() {
                        pipeline.remove((ChannelHandler) httpClientCodec);
                    }
                });
                return;
            }
            throw new IllegalStateException("ChannelPipeline does not contain an HttpRequestEncoder or HttpClientCodec");
        }
        Class cls = HttpRequestEncoder.class;
        if (pipeline.get(cls) != null) {
            pipeline.remove(cls);
        }
        pipeline.addAfter(context.name(), "ws-decoder", newWebsocketDecoder());
        channel.eventLoop().execute(new Runnable() {
            public void run() {
                pipeline.remove(context.handler());
            }
        });
    }

    public long forceCloseTimeoutMillis() {
        return this.forceCloseTimeoutMillis;
    }

    public ChannelFuture handshake(Channel channel) {
        ObjectUtil.checkNotNull(channel, "channel");
        return handshake(channel, channel.newPromise());
    }

    public boolean isForceCloseComplete() {
        return this.forceCloseComplete;
    }

    public boolean isHandshakeComplete() {
        return this.handshakeComplete;
    }

    public int maxFramePayloadLength() {
        return this.maxFramePayloadLength;
    }

    public abstract FullHttpRequest newHandshakeRequest();

    public abstract WebSocketFrameEncoder newWebSocketEncoder();

    public abstract WebSocketFrameDecoder newWebsocketDecoder();

    public final ChannelFuture processHandshake(Channel channel, HttpResponse httpResponse) {
        return processHandshake(channel, httpResponse, channel.newPromise());
    }

    public WebSocketClientHandshaker setForceCloseTimeoutMillis(long j) {
        this.forceCloseTimeoutMillis = j;
        return this;
    }

    public String upgradeUrl(URI uri2) {
        if (this.absoluteUpgradeUrl) {
            return uri2.toString();
        }
        String rawPath = uri2.getRawPath();
        if (rawPath == null || rawPath.isEmpty()) {
            rawPath = "/";
        }
        String rawQuery = uri2.getRawQuery();
        if (rawQuery == null || rawQuery.isEmpty()) {
            return rawPath;
        }
        return rawPath + '?' + rawQuery;
    }

    public URI uri() {
        return this.uri;
    }

    public abstract void verify(FullHttpResponse fullHttpResponse);

    public WebSocketVersion version() {
        return this.version;
    }

    public WebSocketClientHandshaker(URI uri2, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i, long j) {
        this(uri2, webSocketVersion, str, httpHeaders, i, j, false);
    }

    public final ChannelFuture processHandshake(final Channel channel, HttpResponse httpResponse, final ChannelPromise channelPromise) {
        if (httpResponse instanceof FullHttpResponse) {
            try {
                finishHandshake(channel, (FullHttpResponse) httpResponse);
                channelPromise.setSuccess();
            } catch (Throwable th) {
                channelPromise.setFailure(th);
            }
        } else {
            ChannelPipeline pipeline = channel.pipeline();
            ChannelHandlerContext context = pipeline.context((Class<? extends ChannelHandler>) HttpResponseDecoder.class);
            if (context == null && (context = pipeline.context((Class<? extends ChannelHandler>) HttpClientCodec.class)) == null) {
                return channelPromise.setFailure(new IllegalStateException("ChannelPipeline does not contain an HttpResponseDecoder or HttpClientCodec"));
            }
            String name = context.name();
            if (this.version == WebSocketVersion.V00) {
                pipeline.addAfter(context.name(), "httpAggregator", new HttpObjectAggregator(8192));
                name = "httpAggregator";
            }
            pipeline.addAfter(name, "handshaker", new ChannelInboundHandlerAdapter() {
                static final /* synthetic */ boolean $assertionsDisabled = false;
                private FullHttpResponse fullHttpResponse;

                private void handleHandshakeResponse(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) {
                    if (httpObject instanceof FullHttpResponse) {
                        channelHandlerContext.pipeline().remove((ChannelHandler) this);
                        tryFinishHandshake((FullHttpResponse) httpObject);
                    } else if (httpObject instanceof LastHttpContent) {
                        FullHttpResponse fullHttpResponse2 = this.fullHttpResponse;
                        this.fullHttpResponse = null;
                        try {
                            channelHandlerContext.pipeline().remove((ChannelHandler) this);
                            tryFinishHandshake(fullHttpResponse2);
                        } finally {
                            fullHttpResponse2.release();
                        }
                    } else if (httpObject instanceof HttpResponse) {
                        HttpResponse httpResponse = (HttpResponse) httpObject;
                        this.fullHttpResponse = new DefaultFullHttpResponse(httpResponse.protocolVersion(), httpResponse.status(), Unpooled.EMPTY_BUFFER, httpResponse.headers(), (HttpHeaders) EmptyHttpHeaders.INSTANCE);
                        if (httpResponse.decoderResult().isFailure()) {
                            this.fullHttpResponse.setDecoderResult(httpResponse.decoderResult());
                        }
                    }
                }

                private void releaseFullHttpResponse() {
                    FullHttpResponse fullHttpResponse2 = this.fullHttpResponse;
                    if (fullHttpResponse2 != null) {
                        fullHttpResponse2.release();
                        this.fullHttpResponse = null;
                    }
                }

                private void tryFinishHandshake(FullHttpResponse fullHttpResponse2) {
                    try {
                        WebSocketClientHandshaker.this.finishHandshake(channel, fullHttpResponse2);
                        channelPromise.setSuccess();
                    } catch (Throwable th) {
                        channelPromise.setFailure(th);
                    }
                }

                public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
                    try {
                        if (!channelPromise.isDone()) {
                            channelPromise.tryFailure(new ClosedChannelException());
                        }
                        channelHandlerContext.fireChannelInactive();
                        releaseFullHttpResponse();
                    } catch (Throwable th) {
                        releaseFullHttpResponse();
                        throw th;
                    }
                }

                public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
                    if (obj instanceof HttpObject) {
                        try {
                            handleHandshakeResponse(channelHandlerContext, (HttpObject) obj);
                        } finally {
                            ReferenceCountUtil.release(obj);
                        }
                    } else {
                        super.channelRead(channelHandlerContext, obj);
                    }
                }

                public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
                    channelHandlerContext.pipeline().remove((ChannelHandler) this);
                    channelPromise.setFailure(th);
                }

                public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
                    releaseFullHttpResponse();
                }
            });
            try {
                context.fireChannelRead(ReferenceCountUtil.retain(httpResponse));
            } catch (Throwable th2) {
                channelPromise.setFailure(th2);
            }
        }
        return channelPromise;
    }

    public WebSocketClientHandshaker(URI uri2, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i, long j, boolean z) {
        this.forceCloseTimeoutMillis = 10000;
        this.uri = uri2;
        this.version = webSocketVersion;
        this.expectedSubprotocol = str;
        this.customHeaders = httpHeaders;
        this.maxFramePayloadLength = i;
        this.forceCloseTimeoutMillis = j;
        this.absoluteUpgradeUrl = z;
    }

    public ChannelFuture close(Channel channel, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(channel, "channel");
        return close0(channel, channel, closeWebSocketFrame, channelPromise);
    }

    public final ChannelFuture handshake(Channel channel, final ChannelPromise channelPromise) {
        ChannelPipeline pipeline = channel.pipeline();
        if (((HttpResponseDecoder) pipeline.get(HttpResponseDecoder.class)) == null && ((HttpClientCodec) pipeline.get(HttpClientCodec.class)) == null) {
            channelPromise.setFailure(new IllegalStateException("ChannelPipeline does not contain an HttpResponseDecoder or HttpClientCodec"));
            return channelPromise;
        }
        channel.writeAndFlush(newHandshakeRequest()).addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) {
                if (channelFuture.isSuccess()) {
                    ChannelPipeline pipeline = channelFuture.channel().pipeline();
                    ChannelHandlerContext context = pipeline.context((Class<? extends ChannelHandler>) HttpRequestEncoder.class);
                    if (context == null) {
                        context = pipeline.context((Class<? extends ChannelHandler>) HttpClientCodec.class);
                    }
                    if (context == null) {
                        channelPromise.setFailure(new IllegalStateException("ChannelPipeline does not contain an HttpRequestEncoder or HttpClientCodec"));
                        return;
                    }
                    pipeline.addAfter(context.name(), "ws-encoder", WebSocketClientHandshaker.this.newWebSocketEncoder());
                    channelPromise.setSuccess();
                    return;
                }
                channelPromise.setFailure(channelFuture.cause());
            }
        });
        return channelPromise;
    }

    public ChannelFuture close(ChannelHandlerContext channelHandlerContext, CloseWebSocketFrame closeWebSocketFrame) {
        ObjectUtil.checkNotNull(channelHandlerContext, "ctx");
        return close(channelHandlerContext, closeWebSocketFrame, channelHandlerContext.newPromise());
    }

    public ChannelFuture close(ChannelHandlerContext channelHandlerContext, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(channelHandlerContext, "ctx");
        return close0(channelHandlerContext, channelHandlerContext.channel(), closeWebSocketFrame, channelPromise);
    }
}
