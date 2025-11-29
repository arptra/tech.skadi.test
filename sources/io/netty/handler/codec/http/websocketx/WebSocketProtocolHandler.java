package io.netty.handler.codec.http.websocketx;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.PromiseNotifier;
import io.netty.util.concurrent.ScheduledFuture;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.List;
import java.util.concurrent.TimeUnit;

abstract class WebSocketProtocolHandler extends MessageToMessageDecoder<WebSocketFrame> implements ChannelOutboundHandler {
    /* access modifiers changed from: private */
    public ChannelPromise closeSent;
    private final WebSocketCloseStatus closeStatus;
    private final boolean dropPongFrames;
    private final long forceCloseTimeoutMillis;

    public WebSocketProtocolHandler() {
        this(true);
    }

    private void applyCloseSentTimeout(ChannelHandlerContext channelHandlerContext) {
        if (!this.closeSent.isDone() && this.forceCloseTimeoutMillis >= 0) {
            final ScheduledFuture<?> schedule = channelHandlerContext.executor().schedule((Runnable) new Runnable() {
                public void run() {
                    if (!WebSocketProtocolHandler.this.closeSent.isDone()) {
                        WebSocketProtocolHandler.this.closeSent.tryFailure(WebSocketProtocolHandler.this.buildHandshakeException("send close frame timed out"));
                    }
                }
            }, this.forceCloseTimeoutMillis, TimeUnit.MILLISECONDS);
            this.closeSent.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) {
                    schedule.cancel(false);
                }
            });
        }
    }

    private static void readIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (!channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
    }

    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    public WebSocketHandshakeException buildHandshakeException(String str) {
        return new WebSocketHandshakeException(str);
    }

    public void close(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) throws Exception {
        if (this.closeStatus == null || !channelHandlerContext.channel().isActive()) {
            channelHandlerContext.close(channelPromise);
            return;
        }
        if (this.closeSent == null) {
            write(channelHandlerContext, new CloseWebSocketFrame(this.closeStatus), channelHandlerContext.newPromise());
        }
        flush(channelHandlerContext);
        applyCloseSentTimeout(channelHandlerContext);
        this.closeSent.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) {
                channelHandlerContext.close(channelPromise);
            }
        });
    }

    public void closeSent(ChannelPromise channelPromise) {
        this.closeSent = channelPromise;
    }

    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.disconnect(channelPromise);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        channelHandlerContext.fireExceptionCaught(th);
        channelHandlerContext.close();
    }

    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.flush();
    }

    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.read();
    }

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (this.closeSent != null) {
            ReferenceCountUtil.release(obj);
            channelPromise.setFailure(new ClosedChannelException());
        } else if (obj instanceof CloseWebSocketFrame) {
            closeSent(channelPromise.unvoid());
            channelHandlerContext.write(obj).addListener(new PromiseNotifier(false, this.closeSent));
        } else {
            channelHandlerContext.write(obj, channelPromise);
        }
    }

    public WebSocketProtocolHandler(boolean z) {
        this(z, (WebSocketCloseStatus) null, 0);
    }

    public void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        if (webSocketFrame instanceof PingWebSocketFrame) {
            webSocketFrame.content().retain();
            channelHandlerContext.writeAndFlush(new PongWebSocketFrame(webSocketFrame.content()));
            readIfNeeded(channelHandlerContext);
        } else if (!(webSocketFrame instanceof PongWebSocketFrame) || !this.dropPongFrames) {
            list.add(webSocketFrame.retain());
        } else {
            readIfNeeded(channelHandlerContext);
        }
    }

    public WebSocketProtocolHandler(boolean z, WebSocketCloseStatus webSocketCloseStatus, long j) {
        this.dropPongFrames = z;
        this.closeStatus = webSocketCloseStatus;
        this.forceCloseTimeoutMillis = j;
    }
}
