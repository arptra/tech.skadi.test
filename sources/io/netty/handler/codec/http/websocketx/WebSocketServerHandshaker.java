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
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.channels.ClosedChannelException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class WebSocketServerHandshaker {
    public static final String SUB_PROTOCOL_WILDCARD = "*";
    protected static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) WebSocketServerHandshaker.class);
    private final WebSocketDecoderConfig decoderConfig;
    private String selectedSubprotocol;
    private final String[] subprotocols;
    private final String uri;
    private final WebSocketVersion version;

    public WebSocketServerHandshaker(WebSocketVersion webSocketVersion, String str, String str2, int i) {
        this(webSocketVersion, str, str2, WebSocketDecoderConfig.newBuilder().maxFramePayloadLength(i).build());
    }

    private ChannelFuture close0(ChannelOutboundInvoker channelOutboundInvoker, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        return channelOutboundInvoker.writeAndFlush(closeWebSocketFrame, channelPromise).addListener(ChannelFutureListener.CLOSE);
    }

    public ChannelFuture close(Channel channel, CloseWebSocketFrame closeWebSocketFrame) {
        ObjectUtil.checkNotNull(channel, "channel");
        return close(channel, closeWebSocketFrame, channel.newPromise());
    }

    public WebSocketDecoderConfig decoderConfig() {
        return this.decoderConfig;
    }

    public ChannelFuture handshake(Channel channel, FullHttpRequest fullHttpRequest) {
        return handshake(channel, fullHttpRequest, (HttpHeaders) null, channel.newPromise());
    }

    public int maxFramePayloadLength() {
        return this.decoderConfig.maxFramePayloadLength();
    }

    public abstract FullHttpResponse newHandshakeResponse(FullHttpRequest fullHttpRequest, HttpHeaders httpHeaders);

    public abstract WebSocketFrameEncoder newWebSocketEncoder();

    public abstract WebSocketFrameDecoder newWebsocketDecoder();

    public String selectSubprotocol(String str) {
        if (!(str == null || this.subprotocols.length == 0)) {
            for (String trim : str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA)) {
                String trim2 = trim.trim();
                for (String str2 : this.subprotocols) {
                    if ("*".equals(str2) || trim2.equals(str2)) {
                        this.selectedSubprotocol = trim2;
                        return trim2;
                    }
                }
            }
        }
        return null;
    }

    public String selectedSubprotocol() {
        return this.selectedSubprotocol;
    }

    public Set<String> subprotocols() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Collections.addAll(linkedHashSet, this.subprotocols);
        return linkedHashSet;
    }

    public String uri() {
        return this.uri;
    }

    public WebSocketVersion version() {
        return this.version;
    }

    public final ChannelFuture handshake(Channel channel, FullHttpRequest fullHttpRequest, HttpHeaders httpHeaders, final ChannelPromise channelPromise) {
        final String str;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} WebSocket version {} server handshake", channel, version());
        }
        FullHttpResponse newHandshakeResponse = newHandshakeResponse(fullHttpRequest, httpHeaders);
        ChannelPipeline pipeline = channel.pipeline();
        Class cls = HttpObjectAggregator.class;
        if (pipeline.get(cls) != null) {
            pipeline.remove(cls);
        }
        Class cls2 = HttpContentCompressor.class;
        if (pipeline.get(cls2) != null) {
            pipeline.remove(cls2);
        }
        ChannelHandlerContext context = pipeline.context((Class<? extends ChannelHandler>) HttpRequestDecoder.class);
        if (context == null) {
            ChannelHandlerContext context2 = pipeline.context((Class<? extends ChannelHandler>) HttpServerCodec.class);
            if (context2 == null) {
                channelPromise.setFailure(new IllegalStateException("No HttpDecoder and no HttpServerCodec in the pipeline"));
                return channelPromise;
            }
            pipeline.addBefore(context2.name(), "wsencoder", newWebSocketEncoder());
            pipeline.addBefore(context2.name(), "wsdecoder", newWebsocketDecoder());
            str = context2.name();
        } else {
            pipeline.replace(context.name(), "wsdecoder", (ChannelHandler) newWebsocketDecoder());
            String name = pipeline.context((Class<? extends ChannelHandler>) HttpResponseEncoder.class).name();
            pipeline.addBefore(name, "wsencoder", newWebSocketEncoder());
            str = name;
        }
        channel.writeAndFlush(newHandshakeResponse).addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    channelFuture.channel().pipeline().remove(str);
                    channelPromise.setSuccess();
                    return;
                }
                channelPromise.setFailure(channelFuture.cause());
            }
        });
        return channelPromise;
    }

    public ChannelFuture close(Channel channel, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        return close0(channel, closeWebSocketFrame, channelPromise);
    }

    public ChannelFuture close(ChannelHandlerContext channelHandlerContext, CloseWebSocketFrame closeWebSocketFrame) {
        ObjectUtil.checkNotNull(channelHandlerContext, "ctx");
        return close(channelHandlerContext, closeWebSocketFrame, channelHandlerContext.newPromise());
    }

    public WebSocketServerHandshaker(WebSocketVersion webSocketVersion, String str, String str2, WebSocketDecoderConfig webSocketDecoderConfig) {
        this.version = webSocketVersion;
        this.uri = str;
        if (str2 != null) {
            String[] split = str2.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].trim();
            }
            this.subprotocols = split;
        } else {
            this.subprotocols = EmptyArrays.EMPTY_STRINGS;
        }
        this.decoderConfig = (WebSocketDecoderConfig) ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig");
    }

    public ChannelFuture close(ChannelHandlerContext channelHandlerContext, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(channelHandlerContext, "ctx");
        return close0(channelHandlerContext, closeWebSocketFrame, channelPromise).addListener(ChannelFutureListener.CLOSE);
    }

    public ChannelFuture handshake(Channel channel, HttpRequest httpRequest) {
        return handshake(channel, httpRequest, (HttpHeaders) null, channel.newPromise());
    }

    public final ChannelFuture handshake(final Channel channel, HttpRequest httpRequest, final HttpHeaders httpHeaders, final ChannelPromise channelPromise) {
        if (httpRequest instanceof FullHttpRequest) {
            return handshake(channel, (FullHttpRequest) httpRequest, httpHeaders, channelPromise);
        }
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} WebSocket version {} server handshake", channel, version());
        }
        ChannelPipeline pipeline = channel.pipeline();
        ChannelHandlerContext context = pipeline.context((Class<? extends ChannelHandler>) HttpRequestDecoder.class);
        if (context == null && (context = pipeline.context((Class<? extends ChannelHandler>) HttpServerCodec.class)) == null) {
            channelPromise.setFailure(new IllegalStateException("No HttpDecoder and no HttpServerCodec in the pipeline"));
            return channelPromise;
        }
        String name = context.name();
        if (HttpUtil.isContentLengthSet(httpRequest) || HttpUtil.isTransferEncodingChunked(httpRequest) || this.version == WebSocketVersion.V00) {
            pipeline.addAfter(context.name(), "httpAggregator", new HttpObjectAggregator(8192));
            name = "httpAggregator";
        }
        pipeline.addAfter(name, "handshaker", new ChannelInboundHandlerAdapter() {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private FullHttpRequest fullHttpRequest;

            private void handleHandshakeRequest(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) {
                if (httpObject instanceof FullHttpRequest) {
                    channelHandlerContext.pipeline().remove((ChannelHandler) this);
                    WebSocketServerHandshaker.this.handshake(channel, (FullHttpRequest) httpObject, httpHeaders, channelPromise);
                } else if (httpObject instanceof LastHttpContent) {
                    FullHttpRequest fullHttpRequest2 = this.fullHttpRequest;
                    this.fullHttpRequest = null;
                    try {
                        channelHandlerContext.pipeline().remove((ChannelHandler) this);
                        WebSocketServerHandshaker.this.handshake(channel, fullHttpRequest2, httpHeaders, channelPromise);
                    } finally {
                        fullHttpRequest2.release();
                    }
                } else if (httpObject instanceof HttpRequest) {
                    HttpRequest httpRequest = (HttpRequest) httpObject;
                    this.fullHttpRequest = new DefaultFullHttpRequest(httpRequest.protocolVersion(), httpRequest.method(), httpRequest.uri(), Unpooled.EMPTY_BUFFER, httpRequest.headers(), EmptyHttpHeaders.INSTANCE);
                    if (httpRequest.decoderResult().isFailure()) {
                        this.fullHttpRequest.setDecoderResult(httpRequest.decoderResult());
                    }
                }
            }

            private void releaseFullHttpRequest() {
                FullHttpRequest fullHttpRequest2 = this.fullHttpRequest;
                if (fullHttpRequest2 != null) {
                    fullHttpRequest2.release();
                    this.fullHttpRequest = null;
                }
            }

            public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
                try {
                    if (!channelPromise.isDone()) {
                        channelPromise.tryFailure(new ClosedChannelException());
                    }
                    channelHandlerContext.fireChannelInactive();
                    releaseFullHttpRequest();
                } catch (Throwable th) {
                    releaseFullHttpRequest();
                    throw th;
                }
            }

            public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
                if (obj instanceof HttpObject) {
                    try {
                        handleHandshakeRequest(channelHandlerContext, (HttpObject) obj);
                    } finally {
                        ReferenceCountUtil.release(obj);
                    }
                } else {
                    super.channelRead(channelHandlerContext, obj);
                }
            }

            public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
                channelHandlerContext.pipeline().remove((ChannelHandler) this);
                channelPromise.tryFailure(th);
                channelHandlerContext.fireExceptionCaught(th);
            }

            public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
                releaseFullHttpRequest();
            }
        });
        try {
            context.fireChannelRead(ReferenceCountUtil.retain(httpRequest));
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
        return channelPromise;
    }
}
