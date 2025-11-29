package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoop;
import io.netty.channel.oio.OioByteStreamChannel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;

@Deprecated
public class OioSocketChannel extends OioByteStreamChannel implements SocketChannel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) OioSocketChannel.class);
    private final OioSocketChannelConfig config;
    private final Socket socket;

    public OioSocketChannel() {
        this(new Socket());
    }

    /* access modifiers changed from: private */
    public static void shutdownDone(ChannelFuture channelFuture, ChannelFuture channelFuture2, ChannelPromise channelPromise) {
        Throwable cause = channelFuture.cause();
        Throwable cause2 = channelFuture2.cause();
        if (cause != null) {
            if (cause2 != null) {
                logger.debug("Exception suppressed because a previous exception occurred.", cause2);
            }
            channelPromise.setFailure(cause);
        } else if (cause2 != null) {
            channelPromise.setFailure(cause2);
        } else {
            channelPromise.setSuccess();
        }
    }

    /* access modifiers changed from: private */
    public void shutdownInput0(ChannelPromise channelPromise) {
        try {
            this.socket.shutdownInput();
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    /* access modifiers changed from: private */
    public void shutdownOutput0(ChannelPromise channelPromise) {
        try {
            shutdownOutput0();
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    /* access modifiers changed from: private */
    public void shutdownOutputDone(final ChannelFuture channelFuture, final ChannelPromise channelPromise) {
        ChannelFuture shutdownInput = shutdownInput();
        if (shutdownInput.isDone()) {
            shutdownDone(channelFuture, shutdownInput, channelPromise);
        } else {
            shutdownInput.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    OioSocketChannel.shutdownDone(channelFuture, channelFuture, channelPromise);
                }
            });
        }
    }

    public boolean checkInputShutdown() {
        if (!isInputShutdown()) {
            return false;
        }
        try {
            Thread.sleep((long) config().getSoTimeout());
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public final void clearReadPending0() {
        clearReadPending();
    }

    public void doBind(SocketAddress socketAddress) throws Exception {
        SocketUtils.bind(this.socket, socketAddress);
    }

    public void doClose() throws Exception {
        this.socket.close();
    }

    public void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 != null) {
            SocketUtils.bind(this.socket, socketAddress2);
        }
        try {
            SocketUtils.connect(this.socket, socketAddress, config().getConnectTimeoutMillis());
            activate(this.socket.getInputStream(), this.socket.getOutputStream());
        } catch (SocketTimeoutException e) {
            ConnectTimeoutException connectTimeoutException = new ConnectTimeoutException("connection timed out: " + socketAddress);
            connectTimeoutException.setStackTrace(e.getStackTrace());
            throw connectTimeoutException;
        } catch (Throwable th) {
            doClose();
            throw th;
        }
    }

    public void doDisconnect() throws Exception {
        doClose();
    }

    public int doReadBytes(ByteBuf byteBuf) throws Exception {
        if (this.socket.isClosed()) {
            return -1;
        }
        try {
            return super.doReadBytes(byteBuf);
        } catch (SocketTimeoutException unused) {
            return 0;
        }
    }

    public final void doShutdownOutput() throws Exception {
        shutdownOutput0();
    }

    public boolean isActive() {
        return !this.socket.isClosed() && this.socket.isConnected();
    }

    public boolean isInputShutdown() {
        return this.socket.isInputShutdown() || !isActive();
    }

    public boolean isOpen() {
        return !this.socket.isClosed();
    }

    public boolean isOutputShutdown() {
        return this.socket.isOutputShutdown() || !isActive();
    }

    public boolean isShutdown() {
        return (this.socket.isInputShutdown() && this.socket.isOutputShutdown()) || !isActive();
    }

    public SocketAddress localAddress0() {
        return this.socket.getLocalSocketAddress();
    }

    public SocketAddress remoteAddress0() {
        return this.socket.getRemoteSocketAddress();
    }

    @Deprecated
    public void setReadPending(boolean z) {
        super.setReadPending(z);
    }

    public ChannelFuture shutdown() {
        return shutdown(newPromise());
    }

    public ChannelFuture shutdownInput() {
        return shutdownInput(newPromise());
    }

    public ChannelFuture shutdownOutput() {
        return shutdownOutput(newPromise());
    }

    public OioSocketChannel(Socket socket2) {
        this((Channel) null, socket2);
    }

    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    public ServerSocketChannel parent() {
        return (ServerSocketChannel) super.parent();
    }

    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public ChannelFuture shutdown(final ChannelPromise channelPromise) {
        ChannelFuture shutdownOutput = shutdownOutput();
        if (shutdownOutput.isDone()) {
            shutdownOutputDone(shutdownOutput, channelPromise);
        } else {
            shutdownOutput.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    OioSocketChannel.this.shutdownOutputDone(channelFuture, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    public ChannelFuture shutdownInput(final ChannelPromise channelPromise) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            shutdownInput0(channelPromise);
        } else {
            eventLoop.execute(new Runnable() {
                public void run() {
                    OioSocketChannel.this.shutdownInput0(channelPromise);
                }
            });
        }
        return channelPromise;
    }

    public ChannelFuture shutdownOutput(final ChannelPromise channelPromise) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            shutdownOutput0(channelPromise);
        } else {
            eventLoop.execute(new Runnable() {
                public void run() {
                    OioSocketChannel.this.shutdownOutput0(channelPromise);
                }
            });
        }
        return channelPromise;
    }

    public OioSocketChannel(Channel channel, Socket socket2) {
        super(channel);
        this.socket = socket2;
        this.config = new DefaultOioSocketChannelConfig(this, socket2);
        try {
            if (socket2.isConnected()) {
                activate(socket2.getInputStream(), socket2.getOutputStream());
            }
            socket2.setSoTimeout(1000);
        } catch (Exception e) {
            throw new ChannelException("failed to initialize a socket", e);
        } catch (Throwable th) {
            try {
                socket2.close();
            } catch (IOException e2) {
                logger.warn("Failed to close a socket.", (Throwable) e2);
            }
            throw th;
        }
    }

    public OioSocketChannelConfig config() {
        return this.config;
    }

    private void shutdownOutput0() throws IOException {
        this.socket.shutdownOutput();
    }
}
