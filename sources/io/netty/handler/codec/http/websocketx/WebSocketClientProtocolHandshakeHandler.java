package io.netty.handler.codec.http.websocketx;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

class WebSocketClientProtocolHandshakeHandler extends ChannelInboundHandlerAdapter {
    private static final long DEFAULT_HANDSHAKE_TIMEOUT_MS = 10000;
    /* access modifiers changed from: private */
    public ChannelHandlerContext ctx;
    /* access modifiers changed from: private */
    public ChannelPromise handshakePromise;
    private final long handshakeTimeoutMillis;
    private final WebSocketClientHandshaker handshaker;

    public WebSocketClientProtocolHandshakeHandler(WebSocketClientHandshaker webSocketClientHandshaker) {
        this(webSocketClientHandshaker, DEFAULT_HANDSHAKE_TIMEOUT_MS);
    }

    private void applyHandshakeTimeout() {
        final ChannelPromise channelPromise = this.handshakePromise;
        if (this.handshakeTimeoutMillis > 0 && !channelPromise.isDone()) {
            final ScheduledFuture<?> schedule = this.ctx.executor().schedule((Runnable) new Runnable() {
                public void run() {
                    if (!channelPromise.isDone() && channelPromise.tryFailure(new WebSocketClientHandshakeException("handshake timed out"))) {
                        WebSocketClientProtocolHandshakeHandler.this.ctx.flush().fireUserEventTriggered(WebSocketClientProtocolHandler.ClientHandshakeStateEvent.HANDSHAKE_TIMEOUT).close();
                    }
                }
            }, this.handshakeTimeoutMillis, TimeUnit.MILLISECONDS);
            channelPromise.addListener(new FutureListener<Void>() {
                public void operationComplete(Future<Void> future) throws Exception {
                    schedule.cancel(false);
                }
            });
        }
    }

    public void channelActive(final ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelActive(channelHandlerContext);
        this.handshaker.handshake(channelHandlerContext.channel()).addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (!channelFuture.isSuccess()) {
                    WebSocketClientProtocolHandshakeHandler.this.handshakePromise.tryFailure(channelFuture.cause());
                    channelHandlerContext.fireExceptionCaught(channelFuture.cause());
                    return;
                }
                channelHandlerContext.fireUserEventTriggered(WebSocketClientProtocolHandler.ClientHandshakeStateEvent.HANDSHAKE_ISSUED);
            }
        });
        applyHandshakeTimeout();
    }

    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.handshakePromise.isDone()) {
            this.handshakePromise.tryFailure(new WebSocketClientHandshakeException("channel closed with handshake in progress"));
        }
        super.channelInactive(channelHandlerContext);
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (!(obj instanceof FullHttpResponse)) {
            channelHandlerContext.fireChannelRead(obj);
            return;
        }
        FullHttpResponse fullHttpResponse = (FullHttpResponse) obj;
        try {
            if (!this.handshaker.isHandshakeComplete()) {
                this.handshaker.finishHandshake(channelHandlerContext.channel(), fullHttpResponse);
                this.handshakePromise.trySuccess();
                channelHandlerContext.fireUserEventTriggered(WebSocketClientProtocolHandler.ClientHandshakeStateEvent.HANDSHAKE_COMPLETE);
                channelHandlerContext.pipeline().remove((ChannelHandler) this);
                return;
            }
            throw new IllegalStateException("WebSocketClientHandshaker should have been non finished yet");
        } finally {
            fullHttpResponse.release();
        }
    }

    public ChannelFuture getHandshakeFuture() {
        return this.handshakePromise;
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        this.handshakePromise = channelHandlerContext.newPromise();
    }

    public WebSocketClientProtocolHandshakeHandler(WebSocketClientHandshaker webSocketClientHandshaker, long j) {
        this.handshaker = webSocketClientHandshaker;
        this.handshakeTimeoutMillis = ObjectUtil.checkPositive(j, "handshakeTimeoutMillis");
    }
}
