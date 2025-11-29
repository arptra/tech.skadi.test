package com.upuphone.runasone.channel.linker.starrystack;

import com.upuphone.runasone.utils.LogUtil;
import com.xjsd.iot.starrynetstack.jni.IStarrySocketListener;
import com.xjsd.iot.starrynetstack.jni.StarrySocketProxy;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.oio.OioByteStreamChannel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.oio.DefaultOioSocketChannelConfig;
import io.netty.channel.socket.oio.OioSocketChannelConfig;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class XdpOioSocketChannel extends OioByteStreamChannel implements SocketChannel, IStarrySocketListener {
    private static final int DEFAULT_BACKLOG = 100;
    private static final String TAG = "StarrySocketChannel_";
    private static byte[] byteContainerArray = new byte[3000];
    private StarrySocketProxy clientIoSocket;
    private final OioSocketChannelConfig config;
    private LinkedBlockingDeque<byte[]> mClientRecDataQueue;
    private int mClientSocketFd;
    private LinkedBlockingDeque<byte[]> mSessionRecDataQueue;
    private SOCK_STATUS mSockStatus;
    private StarrySocketProxy serverIoSocket;

    public enum SOCK_STATUS {
        close,
        connecting,
        connected
    }

    public XdpOioSocketChannel() {
        this(new Socket());
    }

    /* access modifiers changed from: private */
    public static void shutdownDone(ChannelFuture channelFuture, ChannelFuture channelFuture2, ChannelPromise channelPromise) {
        Throwable cause = channelFuture.cause();
        Throwable cause2 = channelFuture2.cause();
        if (cause != null) {
            if (cause2 != null) {
                LogUtil.d("StarrySocketChannel_Exception suppressed because a previous exception occurred.", (Object) cause2);
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
            if (parent() != null) {
                LogUtil.i("StarrySocketChannel_Server端的ClientSocket关闭shutdownInput0");
            } else {
                LogUtil.i("StarrySocketChannel_Client端的Socket关闭shutdownInput0");
            }
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    private void shutdownOutput0() throws IOException {
    }

    /* access modifiers changed from: private */
    public void shutdownOutputDone(final ChannelFuture channelFuture, final ChannelPromise channelPromise) {
        ChannelFuture shutdownInput = shutdownInput();
        if (shutdownInput.isDone()) {
            shutdownDone(channelFuture, shutdownInput, channelPromise);
        } else {
            shutdownInput.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    XdpOioSocketChannel.shutdownDone(channelFuture, channelFuture, channelPromise);
                }
            });
        }
    }

    private void socketBindAddress(SocketAddress socketAddress) {
        if (socketAddress instanceof InetSocketAddress) {
            String p2PIpAddress = NetworkUtils.getP2PIpAddress();
            int port = ((InetSocketAddress) socketAddress).getPort();
            LogUtil.d("StarrySocketChannel_私有协议栈bind ip: " + p2PIpAddress + ", port: " + port);
            this.clientIoSocket.bind(p2PIpAddress, port);
            this.mSockStatus = SOCK_STATUS.connecting;
            return;
        }
        LogUtil.d("StarrySocketChannel_私有协议栈call socketBindAddress, but localAddress not instanceof InetSocketAddress");
    }

    public int available() {
        return this.mSockStatus == SOCK_STATUS.connected ? 1 : 0;
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
        socketBindAddress(socketAddress);
    }

    public void doClose() throws Exception {
        if (parent() != null) {
            LogUtil.i("StarrySocketChannel_Server端的ClientSocket关闭doClose mClientSocketFd:" + this.mClientSocketFd);
            if (parent() instanceof XdpOioServerSocketChannel) {
                ((XdpOioServerSocketChannel) parent()).closeSocket(this.mClientSocketFd);
            }
            this.mSockStatus = SOCK_STATUS.close;
        } else {
            LogUtil.i("StarrySocketChannel_Client端的Socket是否关闭doClose");
        }
        StarrySocketProxy starrySocketProxy = this.clientIoSocket;
        if (starrySocketProxy != null) {
            starrySocketProxy.close();
            this.clientIoSocket.release();
            this.clientIoSocket = null;
            this.mSockStatus = SOCK_STATUS.close;
        }
    }

    public void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 != null) {
            socketBindAddress(socketAddress2);
        }
        try {
            if (socketAddress instanceof InetSocketAddress) {
                String hostString = ((InetSocketAddress) socketAddress).getHostString();
                int port = ((InetSocketAddress) socketAddress).getPort();
                int connect = this.clientIoSocket.connect(hostString, port);
                LogUtil.d("StarrySocketChannel_Client端连接对端 connect host: " + hostString + ", port: " + port + ", ret: " + connect);
            } else {
                LogUtil.d("StarrySocketChannel_Server端 call doConnect, but remoteAddress not instanceof InetSocketAddress");
            }
            this.mSockStatus = SOCK_STATUS.connected;
        } catch (Exception e) {
            ConnectTimeoutException connectTimeoutException = new ConnectTimeoutException("connection timed out: " + socketAddress);
            connectTimeoutException.setStackTrace(e.getStackTrace());
            throw connectTimeoutException;
        } catch (Throwable th) {
            if (0 == 0) {
                doClose();
            }
            throw th;
        }
    }

    public void doDisconnect() throws Exception {
        doClose();
    }

    public int doReadBytes(ByteBuf byteBuf) throws Exception {
        if (parent() != null) {
            LogUtil.d("StarrySocketChannel_Server端doReadBytes读数据:" + hashCode() + ", mClientSocketFd: " + this.mClientSocketFd);
        } else {
            LogUtil.d("StarrySocketChannel_Client端doReadBytes读数据:" + hashCode() + ",  ");
        }
        if (parent() != null) {
            try {
                byte[] poll = this.mSessionRecDataQueue.poll(500, TimeUnit.MILLISECONDS);
                if (poll == null) {
                    return 0;
                }
                int length = poll.length;
                RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
                int max = Math.max(1, Math.min(length, byteBuf.maxWritableBytes()));
                LogUtil.d("StarrySocketChannel_Server端sessionSocket 设置读取操作将（或已尝试）读取的字节数:" + max + ",接收到的数据：" + length);
                recvBufAllocHandle.attemptedBytesRead(max);
                byteBuf.writeBytes(poll);
                return length;
            } catch (Exception e) {
                LogUtil.e("StarrySocketChannel_Failed to client read bytes:" + e.getMessage());
                return 0;
            }
        } else {
            try {
                byte[] poll2 = this.mClientRecDataQueue.poll(500, TimeUnit.MILLISECONDS);
                if (poll2 == null) {
                    return 0;
                }
                int length2 = poll2.length;
                RecvByteBufAllocator.Handle recvBufAllocHandle2 = unsafe().recvBufAllocHandle();
                int max2 = Math.max(1, Math.min(length2, byteBuf.maxWritableBytes()));
                LogUtil.d("StarrySocketChannel_clientSocket 设置读取操作将（或已尝试）读取的字节数:" + max2 + ",接收到的数据：" + length2);
                recvBufAllocHandle2.attemptedBytesRead(max2);
                byteBuf.writeBytes(poll2);
                return length2;
            } catch (Exception e2) {
                LogUtil.e("StarrySocketChannel_Failed to client read bytes:" + e2.getMessage());
                return 0;
            }
        }
    }

    public final void doShutdownOutput() throws Exception {
        if (parent() != null) {
            LogUtil.i("StarrySocketChannel_Server端的ClientSocket关闭doShutdownOutput.");
        } else {
            LogUtil.i("StarrySocketChannel_Client端的Socket是否关闭doShutdownOutput");
        }
        shutdownOutput0();
    }

    public void doWriteBytes(ByteBuf byteBuf) throws Exception {
        if (byteBuf == null) {
            LogUtil.e("StarrySocketChannel_doWriteBytes写数据不能为null");
        }
        if (parent() != null) {
            LogUtil.d("StarrySocketChannel_Server端sessionSocket mClientSocketFd: " + this.mClientSocketFd + " doWriteBytes");
        } else {
            LogUtil.d("StarrySocketChannel_Client端clientSocket doWriteBytes");
        }
        if (this.clientIoSocket != null) {
            LogUtil.i("StarrySocketChannel_Client端发送数据长度 clientIoSocket send length:" + byteBuf.array().length + " buf current readableBytes:" + byteBuf.readableBytes());
            this.clientIoSocket.send(byteBuf.array(), 0, byteBuf.readableBytes());
        }
        if (!(this.serverIoSocket == null || this.mClientSocketFd == -1)) {
            LogUtil.i("StarrySocketChannel_Server端发送数据长度 serverIoSocket send length:" + byteBuf.array().length + " buf current readableBytes: " + byteBuf.readableBytes());
            this.serverIoSocket.sendTo(this.mClientSocketFd, byteBuf.array(), 0, byteBuf.readableBytes());
        }
        byteBuf.clear();
    }

    public void finalize() throws Throwable {
        StarrySocketProxy starrySocketProxy = this.clientIoSocket;
        if (starrySocketProxy != null) {
            starrySocketProxy.close();
            this.clientIoSocket.release();
        }
    }

    public byte[] getContainer(int i) {
        LogUtil.d("StarrySocketChannel_获取收发数据字节数组 jni level call getContainer, needed size: " + i);
        return Arrays.copyOf(byteContainerArray, i);
    }

    public boolean isActive() {
        return this.mSockStatus == SOCK_STATUS.connected;
    }

    public boolean isInputShutdown() {
        return !isActive();
    }

    public boolean isOpen() {
        return this.mSockStatus != SOCK_STATUS.close;
    }

    public boolean isOutputShutdown() {
        return !isActive();
    }

    public boolean isShutdown() {
        StringBuilder sb = new StringBuilder();
        sb.append("StarrySocketChannel_isShutdown :");
        sb.append(!isActive());
        LogUtil.i(sb.toString());
        return !isActive();
    }

    public SocketAddress localAddress0() {
        return null;
    }

    public void onAccept(int i, String str) {
        LogUtil.d("StarrySocketChannel_接受对端连接 onAccept remoteSocketFd:" + i + ", remoteIp:" + str);
    }

    public void onConnect() {
        LogUtil.d("StarrySocketChannel_收到连接回调onConnect");
    }

    public void onData(int i, byte[] bArr, int i2) {
        if (parent() != null) {
            LogUtil.d("StarrySocketChannel_私有协议栈Server端Client收到 onData socketFd：" + i + ", size: " + i2 + ", Server端收到数据: " + new String(bArr));
        } else {
            LogUtil.d("StarrySocketChannel_私有协议栈Client端收到onData socketFd：" + i + ", size: " + i2 + ", Client端收到数据: " + new String(bArr));
        }
        if (this.mClientRecDataQueue != null) {
            LogUtil.d("StarrySocketChannel_Client端收到Server端数据 receive data from server, offer data into mClientRecDataQueue");
            this.mClientRecDataQueue.offer(bArr);
            return;
        }
        LogUtil.w("StarrySocketChannel_Client端数据接收队列为空 mClientRecDataQueue null");
    }

    public void onError(int i) {
        try {
            doClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtil.d("StarrySocketChannel_收到错误码 onError errorCode:" + i);
    }

    public void onEvent(int i) {
        LogUtil.d("StarrySocketChannel_私有协议栈Client端onEvent event：" + i);
    }

    public void onMessage(int i, byte[] bArr, int i2) {
    }

    public SocketAddress remoteAddress0() {
        return null;
    }

    @Deprecated
    public void setReadPending(boolean z) {
        super.setReadPending(z);
    }

    public ChannelFuture shutdown() {
        if (parent() != null) {
            LogUtil.i("StarrySocketChannel_Server端的ClientSocket关闭shutdown");
        } else {
            LogUtil.i("StarrySocketChannel_Client端的Socket是否关闭shutdown");
        }
        return shutdown(newPromise());
    }

    public ChannelFuture shutdownInput() {
        if (parent() != null) {
            LogUtil.i("StarrySocketChannel_Server端的ClientSocket关闭shutdownInput");
        } else {
            LogUtil.i("StarrySocketChannel_Client端的Socket是否关闭shutdownInput");
        }
        return shutdownInput(newPromise());
    }

    public ChannelFuture shutdownOutput() {
        if (parent() != null) {
            LogUtil.i("StarrySocketChannel_Server端的ClientSocket关闭shutdownOutput");
        } else {
            LogUtil.i("StarrySocketChannel_Client端的Socket是否关闭shutdownOutput");
        }
        return shutdownOutput(newPromise());
    }

    public XdpOioSocketChannel(Socket socket) {
        this((Channel) null, socket, (StarrySocketProxy) null, -1, (LinkedBlockingDeque<byte[]>) null);
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

    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    public ServerSocketChannel parent() {
        return (ServerSocketChannel) super.parent();
    }

    public InetSocketAddress remoteAddress() {
        if (parent() != null) {
            InetSocketAddress reomoteSockAddr = this.serverIoSocket.getReomoteSockAddr(this.mClientSocketFd);
            LogUtil.d("StarrySocketChannel_Server端 remoteAddress :" + reomoteSockAddr);
            return reomoteSockAddr;
        }
        LogUtil.d("StarrySocketChannel_Client端 remoteAddress");
        return this.clientIoSocket.getReomoteSockAddr(-1);
    }

    public XdpOioSocketChannel(Channel channel, Socket socket, StarrySocketProxy starrySocketProxy, int i, LinkedBlockingDeque<byte[]> linkedBlockingDeque) {
        super(channel);
        this.mClientSocketFd = -1;
        this.mSockStatus = SOCK_STATUS.close;
        this.serverIoSocket = starrySocketProxy;
        this.mClientSocketFd = i;
        this.mSessionRecDataQueue = linkedBlockingDeque;
        this.config = new DefaultOioSocketChannelConfig((SocketChannel) this, socket);
        if (channel == null) {
            try {
                LogUtil.d("StarrySocketChannel_Client端实例化私有协议栈Socket client device create client StarrySocketProxy");
                StarrySocketProxy starrySocketProxy2 = new StarrySocketProxy(false, 100, 6);
                this.clientIoSocket = starrySocketProxy2;
                ObjectUtil.checkNotNull(starrySocketProxy2, "StarrySocketProxy");
                this.clientIoSocket.setListener(this);
                this.clientIoSocket.open(2, 0, 2, 0);
                this.mSockStatus = SOCK_STATUS.connecting;
                String p2PIpAddress = NetworkUtils.getP2PIpAddress();
                LogUtil.i("StarrySocketChannel_Client端私有协议栈Socket绑定bind:" + p2PIpAddress + ", 端口:" + 0);
                this.clientIoSocket.bind(p2PIpAddress, 0);
                this.mClientRecDataQueue = new LinkedBlockingDeque<>();
            } catch (Exception e) {
                throw new ChannelException("实例化私有协议栈socket失败 failed to initialize a socket", e);
            } catch (Throwable th) {
                try {
                    StarrySocketProxy starrySocketProxy3 = this.clientIoSocket;
                    if (starrySocketProxy3 != null) {
                        starrySocketProxy3.close();
                        this.clientIoSocket.release();
                    }
                    this.mSockStatus = SOCK_STATUS.close;
                    if (starrySocketProxy != null) {
                        starrySocketProxy.close();
                        starrySocketProxy.release();
                    }
                    this.clientIoSocket = null;
                } catch (Exception e2) {
                    LogUtil.d("StarrySocketChannel_关闭socket失败 Failed to close a socket.", (Object) e2);
                }
                throw th;
            }
        } else {
            this.mSockStatus = SOCK_STATUS.connected;
            LogUtil.d("StarrySocketChannel_Server端收到client端连接 server device detect connection, create session StarrySocketProxy, clientFd: " + this.mClientSocketFd);
        }
    }

    public OioSocketChannelConfig config() {
        return this.config;
    }

    public ChannelFuture shutdown(final ChannelPromise channelPromise) {
        ChannelFuture shutdownOutput = shutdownOutput();
        if (shutdownOutput.isDone()) {
            shutdownOutputDone(shutdownOutput, channelPromise);
        } else {
            shutdownOutput.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    XdpOioSocketChannel.this.shutdownOutputDone(channelFuture, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    public ChannelFuture shutdownInput(final ChannelPromise channelPromise) {
        if (parent() != null) {
            LogUtil.i("StarrySocketChannel_Server端的ClientSocket关闭shutdownInput");
        } else {
            LogUtil.i("StarrySocketChannel_Client端的Socket关闭shutdownInput");
        }
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            shutdownInput0(channelPromise);
        } else {
            eventLoop.execute(new Runnable() {
                public void run() {
                    XdpOioSocketChannel.this.shutdownInput0(channelPromise);
                }
            });
        }
        return channelPromise;
    }

    public ChannelFuture shutdownOutput(final ChannelPromise channelPromise) {
        EventLoop eventLoop = eventLoop();
        if (parent() != null) {
            LogUtil.i("StarrySocketChannel_Server端的ClientSocket关闭shutdownOutput");
        } else {
            LogUtil.i("StarrySocketChannel_Client端的Socket关闭shutdownOutput");
        }
        if (eventLoop.inEventLoop()) {
            shutdownOutput0(channelPromise);
        } else {
            eventLoop.execute(new Runnable() {
                public void run() {
                    XdpOioSocketChannel.this.shutdownOutput0(channelPromise);
                }
            });
        }
        return channelPromise;
    }
}
