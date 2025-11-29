package io.netty.handler.proxy;

import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.PendingWriteQueue;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.nio.channels.ConnectionPendingException;
import java.util.concurrent.TimeUnit;

public abstract class ProxyHandler extends ChannelDuplexHandler {
    static final String AUTH_NONE = "none";
    private static final long DEFAULT_CONNECT_TIMEOUT_MILLIS = 10000;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ProxyHandler.class);
    /* access modifiers changed from: private */
    public final LazyChannelPromise connectPromise = new LazyChannelPromise();
    private Future<?> connectTimeoutFuture;
    private volatile long connectTimeoutMillis = DEFAULT_CONNECT_TIMEOUT_MILLIS;
    /* access modifiers changed from: private */
    public volatile ChannelHandlerContext ctx;
    private volatile SocketAddress destinationAddress;
    private boolean finished;
    private boolean flushedPrematurely;
    private PendingWriteQueue pendingWrites;
    private final SocketAddress proxyAddress;
    private boolean suppressChannelReadComplete;
    private final ChannelFutureListener writeListener = new ChannelFutureListener() {
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (!channelFuture.isSuccess()) {
                ProxyHandler.this.setConnectFailure(channelFuture.cause());
            }
        }
    };

    public final class LazyChannelPromise extends DefaultPromise<Channel> {
        private LazyChannelPromise() {
        }

        public EventExecutor executor() {
            if (ProxyHandler.this.ctx != null) {
                return ProxyHandler.this.ctx.executor();
            }
            throw new IllegalStateException();
        }
    }

    public ProxyHandler(SocketAddress socketAddress) {
        this.proxyAddress = (SocketAddress) ObjectUtil.checkNotNull(socketAddress, "proxyAddress");
    }

    private void addPendingWrite(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        PendingWriteQueue pendingWriteQueue = this.pendingWrites;
        if (pendingWriteQueue == null) {
            pendingWriteQueue = new PendingWriteQueue(channelHandlerContext);
            this.pendingWrites = pendingWriteQueue;
        }
        pendingWriteQueue.add(obj, channelPromise);
    }

    private void cancelConnectTimeoutFuture() {
        Future<?> future = this.connectTimeoutFuture;
        if (future != null) {
            future.cancel(false);
            this.connectTimeoutFuture = null;
        }
    }

    private void failPendingWrites(Throwable th) {
        PendingWriteQueue pendingWriteQueue = this.pendingWrites;
        if (pendingWriteQueue != null) {
            pendingWriteQueue.removeAndFailAll(th);
            this.pendingWrites = null;
        }
    }

    private void failPendingWritesAndClose(Throwable th) {
        failPendingWrites(th);
        this.connectPromise.tryFailure(th);
        this.ctx.fireExceptionCaught(th);
        this.ctx.close();
    }

    private static void readIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (!channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
    }

    private boolean safeRemoveDecoder() {
        try {
            removeDecoder(this.ctx);
            return true;
        } catch (Exception e) {
            logger.warn("Failed to remove proxy decoders:", (Throwable) e);
            return false;
        }
    }

    private boolean safeRemoveEncoder() {
        try {
            removeEncoder(this.ctx);
            return true;
        } catch (Exception e) {
            logger.warn("Failed to remove proxy encoders:", (Throwable) e);
            return false;
        }
    }

    private void sendInitialMessage(ChannelHandlerContext channelHandlerContext) throws Exception {
        long j = this.connectTimeoutMillis;
        if (j > 0) {
            this.connectTimeoutFuture = channelHandlerContext.executor().schedule((Runnable) new Runnable() {
                public void run() {
                    if (!ProxyHandler.this.connectPromise.isDone()) {
                        ProxyHandler.this.setConnectFailure(new ProxyConnectException(ProxyHandler.this.exceptionMessage(RtspHeaders.Values.TIMEOUT)));
                    }
                }
            }, j, TimeUnit.MILLISECONDS);
        }
        Object newInitialMessage = newInitialMessage(channelHandlerContext);
        if (newInitialMessage != null) {
            sendToProxyServer(newInitialMessage);
        }
        readIfNeeded(channelHandlerContext);
    }

    /* access modifiers changed from: private */
    public void setConnectFailure(Throwable th) {
        this.finished = true;
        cancelConnectTimeoutFuture();
        if (!this.connectPromise.isDone()) {
            if (!(th instanceof ProxyConnectException)) {
                th = new ProxyConnectException(exceptionMessage(th.toString()), th);
            }
            safeRemoveDecoder();
            safeRemoveEncoder();
            failPendingWritesAndClose(th);
        }
    }

    private void setConnectSuccess() {
        this.finished = true;
        cancelConnectTimeoutFuture();
        if (!this.connectPromise.isDone()) {
            boolean safeRemoveEncoder = safeRemoveEncoder();
            this.ctx.fireUserEventTriggered(new ProxyConnectionEvent(protocol(), authScheme(), this.proxyAddress, this.destinationAddress));
            if (safeRemoveEncoder && safeRemoveDecoder()) {
                writePendingWrites();
                if (this.flushedPrematurely) {
                    this.ctx.flush();
                }
                this.connectPromise.trySuccess(this.ctx.channel());
                return;
            }
            failPendingWritesAndClose(new ProxyConnectException("failed to remove all codec handlers added by the proxy handler; bug?"));
        }
    }

    private void writePendingWrites() {
        PendingWriteQueue pendingWriteQueue = this.pendingWrites;
        if (pendingWriteQueue != null) {
            pendingWriteQueue.removeAndWriteAll();
            this.pendingWrites = null;
        }
    }

    public abstract void addCodec(ChannelHandlerContext channelHandlerContext) throws Exception;

    public abstract String authScheme();

    public final void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        sendInitialMessage(channelHandlerContext);
        channelHandlerContext.fireChannelActive();
    }

    public final void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.finished) {
            channelHandlerContext.fireChannelInactive();
        } else {
            setConnectFailure(new ProxyConnectException(exceptionMessage("disconnected")));
        }
    }

    public final void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (this.finished) {
            this.suppressChannelReadComplete = false;
            channelHandlerContext.fireChannelRead(obj);
            return;
        }
        this.suppressChannelReadComplete = true;
        try {
            if (handleResponse(channelHandlerContext, obj)) {
                setConnectSuccess();
            }
            ReferenceCountUtil.release(obj);
        } catch (Throwable th) {
            ReferenceCountUtil.release(obj);
            setConnectFailure(th);
        }
    }

    public final void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.suppressChannelReadComplete) {
            this.suppressChannelReadComplete = false;
            readIfNeeded(channelHandlerContext);
            return;
        }
        channelHandlerContext.fireChannelReadComplete();
    }

    public final void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        if (this.destinationAddress != null) {
            channelPromise.setFailure(new ConnectionPendingException());
            return;
        }
        this.destinationAddress = socketAddress;
        channelHandlerContext.connect(this.proxyAddress, socketAddress2, channelPromise);
    }

    public final Future<Channel> connectFuture() {
        return this.connectPromise;
    }

    public final long connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public final <T extends SocketAddress> T destinationAddress() {
        return this.destinationAddress;
    }

    public final void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (this.finished) {
            channelHandlerContext.fireExceptionCaught(th);
        } else {
            setConnectFailure(th);
        }
    }

    public final String exceptionMessage(String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 128);
        sb.append(protocol());
        sb.append(", ");
        sb.append(authScheme());
        sb.append(", ");
        sb.append(this.proxyAddress);
        sb.append(" => ");
        sb.append(this.destinationAddress);
        if (!str.isEmpty()) {
            sb.append(", ");
            sb.append(str);
        }
        return sb.toString();
    }

    public final void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.finished) {
            writePendingWrites();
            channelHandlerContext.flush();
            return;
        }
        this.flushedPrematurely = true;
    }

    public abstract boolean handleResponse(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception;

    public final void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        addCodec(channelHandlerContext);
        if (channelHandlerContext.channel().isActive()) {
            sendInitialMessage(channelHandlerContext);
        }
    }

    public final boolean isConnected() {
        return this.connectPromise.isSuccess();
    }

    public abstract Object newInitialMessage(ChannelHandlerContext channelHandlerContext) throws Exception;

    public abstract String protocol();

    public final <T extends SocketAddress> T proxyAddress() {
        return this.proxyAddress;
    }

    public abstract void removeDecoder(ChannelHandlerContext channelHandlerContext) throws Exception;

    public abstract void removeEncoder(ChannelHandlerContext channelHandlerContext) throws Exception;

    public final void sendToProxyServer(Object obj) {
        this.ctx.writeAndFlush(obj).addListener(this.writeListener);
    }

    public final void setConnectTimeoutMillis(long j) {
        if (j <= 0) {
            j = 0;
        }
        this.connectTimeoutMillis = j;
    }

    public final void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (this.finished) {
            writePendingWrites();
            channelHandlerContext.write(obj, channelPromise);
            return;
        }
        addPendingWrite(channelHandlerContext, obj, channelPromise);
    }
}
