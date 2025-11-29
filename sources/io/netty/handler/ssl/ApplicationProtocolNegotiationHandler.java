package io.netty.handler.ssl;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DecoderException;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import javax.net.ssl.SSLException;

public abstract class ApplicationProtocolNegotiationHandler extends ChannelInboundHandlerAdapter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ApplicationProtocolNegotiationHandler.class);
    private final RecyclableArrayList bufferedMessages = RecyclableArrayList.newInstance();
    private ChannelHandlerContext ctx;
    private final String fallbackProtocol;
    private boolean sslHandlerChecked;

    public ApplicationProtocolNegotiationHandler(String str) {
        this.fallbackProtocol = (String) ObjectUtil.checkNotNull(str, "fallbackProtocol");
    }

    private void fireBufferedMessages() {
        if (!this.bufferedMessages.isEmpty()) {
            for (int i = 0; i < this.bufferedMessages.size(); i++) {
                this.ctx.fireChannelRead(this.bufferedMessages.get(i));
            }
            this.ctx.fireChannelReadComplete();
            this.bufferedMessages.clear();
        }
    }

    private void removeSelfIfPresent(ChannelHandlerContext channelHandlerContext) {
        ChannelPipeline pipeline = channelHandlerContext.pipeline();
        if (!channelHandlerContext.isRemoved()) {
            pipeline.remove((ChannelHandler) this);
        }
    }

    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        fireBufferedMessages();
        super.channelInactive(channelHandlerContext);
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        this.bufferedMessages.add(obj);
        if (!this.sslHandlerChecked) {
            this.sslHandlerChecked = true;
            if (channelHandlerContext.pipeline().get(SslHandler.class) == null) {
                removeSelfIfPresent(channelHandlerContext);
            }
        }
    }

    public abstract void configurePipeline(ChannelHandlerContext channelHandlerContext, String str) throws Exception;

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (th instanceof DecoderException) {
            Throwable cause = th.getCause();
            if (cause instanceof SSLException) {
                try {
                    handshakeFailure(channelHandlerContext, cause);
                    return;
                } finally {
                    removeSelfIfPresent(channelHandlerContext);
                }
            }
        }
        logger.warn("{} Failed to select the application-level protocol:", channelHandlerContext.channel(), th);
        channelHandlerContext.fireExceptionCaught(th);
        channelHandlerContext.close();
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        super.handlerAdded(channelHandlerContext);
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        fireBufferedMessages();
        this.bufferedMessages.recycle();
        super.handlerRemoved(channelHandlerContext);
    }

    public void handshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        logger.warn("{} TLS handshake failed:", channelHandlerContext.channel(), th);
        channelHandlerContext.close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        if (r0.isSuccess() != false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        removeSelfIfPresent(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        if (r0.isSuccess() == false) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void userEventTriggered(io.netty.channel.ChannelHandlerContext r4, java.lang.Object r5) throws java.lang.Exception {
        /*
            r3 = this;
            boolean r0 = r5 instanceof io.netty.handler.ssl.SslHandshakeCompletionEvent
            if (r0 == 0) goto L_0x0051
            r0 = r5
            io.netty.handler.ssl.SslHandshakeCompletionEvent r0 = (io.netty.handler.ssl.SslHandshakeCompletionEvent) r0
            boolean r1 = r0.isSuccess()     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0032
            io.netty.channel.ChannelPipeline r1 = r4.pipeline()     // Catch:{ all -> 0x0028 }
            java.lang.Class<io.netty.handler.ssl.SslHandler> r2 = io.netty.handler.ssl.SslHandler.class
            io.netty.channel.ChannelHandler r1 = r1.get(r2)     // Catch:{ all -> 0x0028 }
            io.netty.handler.ssl.SslHandler r1 = (io.netty.handler.ssl.SslHandler) r1     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x002a
            java.lang.String r1 = r1.applicationProtocol()     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            java.lang.String r1 = r3.fallbackProtocol     // Catch:{ all -> 0x0028 }
        L_0x0024:
            r3.configurePipeline(r4, r1)     // Catch:{ all -> 0x0028 }
            goto L_0x0032
        L_0x0028:
            r1 = move-exception
            goto L_0x003c
        L_0x002a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = "cannot find an SslHandler in the pipeline (required for application-level protocol negotiation)"
            r1.<init>(r2)     // Catch:{ all -> 0x0028 }
            throw r1     // Catch:{ all -> 0x0028 }
        L_0x0032:
            boolean r0 = r0.isSuccess()
            if (r0 == 0) goto L_0x0051
        L_0x0038:
            r3.removeSelfIfPresent(r4)
            goto L_0x0051
        L_0x003c:
            r3.exceptionCaught(r4, r1)     // Catch:{ all -> 0x0046 }
            boolean r0 = r0.isSuccess()
            if (r0 == 0) goto L_0x0051
            goto L_0x0038
        L_0x0046:
            r5 = move-exception
            boolean r0 = r0.isSuccess()
            if (r0 == 0) goto L_0x0050
            r3.removeSelfIfPresent(r4)
        L_0x0050:
            throw r5
        L_0x0051:
            boolean r0 = r5 instanceof io.netty.channel.socket.ChannelInputShutdownEvent
            if (r0 == 0) goto L_0x0058
            r3.fireBufferedMessages()
        L_0x0058:
            r4.fireUserEventTriggered(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ApplicationProtocolNegotiationHandler.userEventTriggered(io.netty.channel.ChannelHandlerContext, java.lang.Object):void");
    }
}
