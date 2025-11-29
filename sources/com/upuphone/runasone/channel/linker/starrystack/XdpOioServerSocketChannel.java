package com.upuphone.runasone.channel.linker.starrystack;

import android.util.Pair;
import com.upuphone.runasone.channel.linker.starrystack.XdpOioSocketChannel;
import com.upuphone.runasone.utils.LogUtil;
import com.xjsd.iot.starrynetstack.jni.IStarrySocketListener;
import com.xjsd.iot.starrynetstack.jni.StarrySocketProxy;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.oio.AbstractOioMessageChannel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.oio.DefaultOioServerSocketChannelConfig;
import io.netty.channel.socket.oio.OioServerSocketChannelConfig;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class XdpOioServerSocketChannel extends AbstractOioMessageChannel implements ServerSocketChannel {
    private static final int DEFAULT_BACKLOG = 100;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 1);
    private static final String TAG = "StarryServerSocketChannel_";
    private static final AtomicInteger instanceCount;
    /* access modifiers changed from: private */
    public static final Map<Integer, LinkedBlockingDeque<byte[]>> mClientFdRecDataMap = new HashMap();
    /* access modifiers changed from: private */
    public static final LinkedBlockingDeque<Integer> mClientSocketFdQueue = new LinkedBlockingDeque<>();
    /* access modifiers changed from: private */
    public byte[] byteContainerArray;
    /* access modifiers changed from: private */
    public final Queue<Pair<Integer, byte[]>> clientRecDataCacheList;
    private final OioServerSocketChannelConfig config;
    private final Map<Integer, XdpOioSocketChannel> mClientSocketMap;
    /* access modifiers changed from: private */
    public StarrySocketProxy mServerSocket;
    /* access modifiers changed from: private */
    public XdpOioSocketChannel.SOCK_STATUS mSockStatus;
    private String mWifiP2pAddress;
    private int mWifiP2pPort;

    static {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        instanceCount = atomicInteger;
        LogUtil.i("StarryServerSocketChannel_静态代码块instanceCount:" + atomicInteger.getAndIncrement());
    }

    public XdpOioServerSocketChannel() {
        this(newServerSocket());
    }

    private IStarrySocketListener getStarrySocketListener() {
        LogUtil.i("StarryServerSocketChannel_实例化私有协议栈监听器 thisInstanceHashCode:" + hashCode());
        return new IStarrySocketListener() {
            public byte[] getContainer(int i) {
                LogUtil.d(XdpOioServerSocketChannel.TAG + XdpOioServerSocketChannel.this.hashCode() + "获取收发数据字节数组 jni level call getContainer, needed size: " + i);
                return Arrays.copyOf(XdpOioServerSocketChannel.this.byteContainerArray, i);
            }

            public void onAccept(int i, String str) {
                LogUtil.d(XdpOioServerSocketChannel.TAG + XdpOioServerSocketChannel.this.hashCode() + "接受对端连接 onAccept remoteSocketFd:" + i + ", remoteIp:" + str);
                XdpOioServerSocketChannel.mClientSocketFdQueue.offer(Integer.valueOf(i));
            }

            public void onConnect() {
                LogUtil.d(XdpOioServerSocketChannel.TAG + XdpOioServerSocketChannel.this.hashCode() + "收到连接回调onConnect");
            }

            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0096, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onData(int r4, byte[] r5, int r6) {
                /*
                    r3 = this;
                    java.util.Map r0 = com.upuphone.runasone.channel.linker.starrystack.XdpOioServerSocketChannel.mClientFdRecDataMap
                    monitor-enter(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
                    r1.<init>()     // Catch:{ all -> 0x0071 }
                    java.lang.String r2 = "StarryServerSocketChannel_"
                    r1.append(r2)     // Catch:{ all -> 0x0071 }
                    com.upuphone.runasone.channel.linker.starrystack.XdpOioServerSocketChannel r2 = com.upuphone.runasone.channel.linker.starrystack.XdpOioServerSocketChannel.this     // Catch:{ all -> 0x0071 }
                    int r2 = r2.hashCode()     // Catch:{ all -> 0x0071 }
                    r1.append(r2)     // Catch:{ all -> 0x0071 }
                    java.lang.String r2 = "私有协议栈读取到数据 onData socketFd："
                    r1.append(r2)     // Catch:{ all -> 0x0071 }
                    r1.append(r4)     // Catch:{ all -> 0x0071 }
                    java.lang.String r2 = ", size: "
                    r1.append(r2)     // Catch:{ all -> 0x0071 }
                    r1.append(r6)     // Catch:{ all -> 0x0071 }
                    java.lang.String r6 = ",收到的数据:"
                    r1.append(r6)     // Catch:{ all -> 0x0071 }
                    java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0071 }
                    r6.<init>(r5)     // Catch:{ all -> 0x0071 }
                    r1.append(r6)     // Catch:{ all -> 0x0071 }
                    java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x0071 }
                    com.upuphone.runasone.utils.LogUtil.d(r6)     // Catch:{ all -> 0x0071 }
                    java.util.Map r6 = com.upuphone.runasone.channel.linker.starrystack.XdpOioServerSocketChannel.mClientFdRecDataMap     // Catch:{ all -> 0x0071 }
                    java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0071 }
                    java.lang.Object r6 = r6.get(r1)     // Catch:{ all -> 0x0071 }
                    java.util.concurrent.LinkedBlockingDeque r6 = (java.util.concurrent.LinkedBlockingDeque) r6     // Catch:{ all -> 0x0071 }
                    if (r6 == 0) goto L_0x0073
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
                    r4.<init>()     // Catch:{ all -> 0x0071 }
                    java.lang.String r1 = "StarryServerSocketChannel_"
                    r4.append(r1)     // Catch:{ all -> 0x0071 }
                    com.upuphone.runasone.channel.linker.starrystack.XdpOioServerSocketChannel r3 = com.upuphone.runasone.channel.linker.starrystack.XdpOioServerSocketChannel.this     // Catch:{ all -> 0x0071 }
                    int r3 = r3.hashCode()     // Catch:{ all -> 0x0071 }
                    r4.append(r3)     // Catch:{ all -> 0x0071 }
                    java.lang.String r3 = "从客户端收到数据 receive data from client, offer data into recDataQueue"
                    r4.append(r3)     // Catch:{ all -> 0x0071 }
                    java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0071 }
                    com.upuphone.runasone.utils.LogUtil.d(r3)     // Catch:{ all -> 0x0071 }
                    r6.offer(r5)     // Catch:{ all -> 0x0071 }
                    goto L_0x0095
                L_0x0071:
                    r3 = move-exception
                    goto L_0x0097
                L_0x0073:
                    com.upuphone.runasone.channel.linker.starrystack.XdpOioServerSocketChannel r6 = com.upuphone.runasone.channel.linker.starrystack.XdpOioServerSocketChannel.this     // Catch:{ all -> 0x0071 }
                    com.upuphone.runasone.channel.linker.starrystack.XdpOioSocketChannel$SOCK_STATUS r6 = r6.mSockStatus     // Catch:{ all -> 0x0071 }
                    com.upuphone.runasone.channel.linker.starrystack.XdpOioSocketChannel$SOCK_STATUS r1 = com.upuphone.runasone.channel.linker.starrystack.XdpOioSocketChannel.SOCK_STATUS.close     // Catch:{ all -> 0x0071 }
                    if (r6 != r1) goto L_0x007f
                    monitor-exit(r0)     // Catch:{ all -> 0x0071 }
                    return
                L_0x007f:
                    java.lang.String r6 = "StarryServerSocketChannel_没有匹配的客户端数据接收队列,缓存收到的数据 no matched recDataQueue"
                    com.upuphone.runasone.utils.LogUtil.d(r6)     // Catch:{ all -> 0x0071 }
                    com.upuphone.runasone.channel.linker.starrystack.XdpOioServerSocketChannel r3 = com.upuphone.runasone.channel.linker.starrystack.XdpOioServerSocketChannel.this     // Catch:{ all -> 0x0071 }
                    java.util.Queue r3 = r3.clientRecDataCacheList     // Catch:{ all -> 0x0071 }
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0071 }
                    android.util.Pair r4 = android.util.Pair.create(r4, r5)     // Catch:{ all -> 0x0071 }
                    r3.offer(r4)     // Catch:{ all -> 0x0071 }
                L_0x0095:
                    monitor-exit(r0)     // Catch:{ all -> 0x0071 }
                    return
                L_0x0097:
                    monitor-exit(r0)     // Catch:{ all -> 0x0071 }
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.linker.starrystack.XdpOioServerSocketChannel.AnonymousClass1.onData(int, byte[], int):void");
            }

            public void onError(int i) {
                LogUtil.d("StarryServerSocketChannel_onError POST.");
                if (XdpOioServerSocketChannel.this.mServerSocket != null) {
                    XdpOioServerSocketChannel.this.mServerSocket.close();
                    XdpOioServerSocketChannel.this.mServerSocket.release();
                    StarrySocketProxy unused = XdpOioServerSocketChannel.this.mServerSocket = null;
                    XdpOioSocketChannel.SOCK_STATUS unused2 = XdpOioServerSocketChannel.this.mSockStatus = XdpOioSocketChannel.SOCK_STATUS.close;
                    LogUtil.d(XdpOioServerSocketChannel.TAG + XdpOioServerSocketChannel.this.hashCode() + "onError mServerSocket.close();");
                }
                LogUtil.d(XdpOioServerSocketChannel.TAG + XdpOioServerSocketChannel.this.hashCode() + "收到私有协议栈错误码 onError 1 errorCode:" + i);
            }

            public void onEvent(int i) {
                LogUtil.d(XdpOioServerSocketChannel.TAG + XdpOioServerSocketChannel.this.hashCode() + "私有协议栈收到onEvent event：" + i);
            }

            public void onMessage(int i, byte[] bArr, int i2) {
            }
        };
    }

    private static ServerSocket newServerSocket() {
        try {
            LogUtil.i("实例化ServerSocket thread:" + Thread.currentThread().getId());
            return new ServerSocket();
        } catch (IOException e) {
            throw new ChannelException("实例化ServerSocket失败failed to create a server socket", e);
        }
    }

    public void clearFdDataList(int i) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        Map<Integer, LinkedBlockingDeque<byte[]>> map = mClientFdRecDataMap;
        synchronized (map) {
            try {
                if (map.containsKey(Integer.valueOf(i))) {
                    map.remove(Integer.valueOf(i));
                }
                if (this.mClientSocketMap.containsKey(Integer.valueOf(i))) {
                    this.mClientSocketMap.remove(Integer.valueOf(i));
                }
                if (map.size() < 1) {
                    this.clientRecDataCacheList.clear();
                    return;
                }
                while (this.clientRecDataCacheList.peek() != null) {
                    Pair poll = this.clientRecDataCacheList.poll();
                    if (!(poll == null || ((Integer) poll.first).intValue() == i)) {
                        concurrentLinkedQueue.add(poll);
                    }
                }
                this.clientRecDataCacheList.addAll(concurrentLinkedQueue);
            } finally {
            }
        }
    }

    public final void clearReadPending0() {
        super.clearReadPending();
    }

    public void closeSocket(int i) {
        try {
            LogUtil.i("StarryServerSocketChannel_Server端closeSocket() thisHashCode:" + hashCode() + ", clientFd:" + i);
            XdpOioSocketChannel xdpOioSocketChannel = this.mClientSocketMap.get(Integer.valueOf(i));
            if (xdpOioSocketChannel != null) {
                LogUtil.i("StarryServerSocketChannel_shutdown关闭Client端SocketChannel:" + xdpOioSocketChannel.hashCode() + ", thisHashCode:" + hashCode());
                xdpOioSocketChannel.shutdown().sync();
                xdpOioSocketChannel.close().sync();
            }
            clearFdDataList(i);
        } catch (Exception e) {
            clearFdDataList(i);
            LogUtil.e("StarryServerSocketChannel_Server端closeSocket() 异常:", (Object) e);
        }
    }

    public void doBind(SocketAddress socketAddress) throws Exception {
        LogUtil.i("StarryServerSocketChannel_执行doBind thisHashCode:" + hashCode());
        if (socketAddress instanceof InetSocketAddress) {
            String p2PIpAddress = NetworkUtils.getP2PIpAddress();
            this.mWifiP2pAddress = p2PIpAddress;
            int port = ((InetSocketAddress) socketAddress).getPort();
            this.mWifiP2pPort = port;
            int bind = this.mServerSocket.bind(p2PIpAddress, port);
            this.mSockStatus = XdpOioSocketChannel.SOCK_STATUS.connected;
            LogUtil.d("StarryServerSocketChannel_私有协议栈socket绑定 doBind ip: " + p2PIpAddress + ", port: " + port + ", 绑定结果:" + bind);
            return;
        }
        LogUtil.d("StarryServerSocketChannel_ 调用doBind, but localAddress not instanceof InetSocketAddress");
    }

    public void doClose() throws Exception {
        closeSocket(-1);
    }

    public void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        throw new UnsupportedOperationException();
    }

    public void doDisconnect() throws Exception {
        StarrySocketProxy starrySocketProxy = this.mServerSocket;
        if (starrySocketProxy != null) {
            int close = starrySocketProxy.close();
            this.mServerSocket.release();
            this.mServerSocket = null;
            LogUtil.i(TAG + hashCode() + "doDisconnect GO端已移除 关闭私有协议栈socket ret:" + close);
        }
        this.mSockStatus = XdpOioSocketChannel.SOCK_STATUS.close;
        XdpNetStackManager.getInstance().unloadP2p0((String) null);
        throw new UnsupportedOperationException();
    }

    public int doReadMessages(List<Object> list) throws Exception {
        LinkedBlockingDeque linkedBlockingDeque;
        XdpOioSocketChannel xdpOioSocketChannel;
        LogUtil.i(TAG + hashCode() + "doReadMessages开始读消息");
        if (this.mSockStatus == XdpOioSocketChannel.SOCK_STATUS.close) {
            return -1;
        }
        try {
            Integer poll = mClientSocketFdQueue.poll(500, TimeUnit.MILLISECONDS);
            if (poll == null) {
                return 0;
            }
            LogUtil.d(TAG + hashCode() + "收到新的client连接new client connected, clientFd : " + poll);
            Map<Integer, LinkedBlockingDeque<byte[]>> map = mClientFdRecDataMap;
            synchronized (map) {
                linkedBlockingDeque = new LinkedBlockingDeque();
                map.put(poll, linkedBlockingDeque);
                xdpOioSocketChannel = new XdpOioSocketChannel(this, new Socket(), this.mServerSocket, poll.intValue(), linkedBlockingDeque);
            }
            try {
                this.mClientSocketMap.put(poll, xdpOioSocketChannel);
                list.add(xdpOioSocketChannel);
                synchronized (map) {
                    while (this.clientRecDataCacheList.peek() != null) {
                        Pair poll2 = this.clientRecDataCacheList.poll();
                        if (poll2 != null && poll2.first == poll) {
                            byte[] bArr = (byte[]) poll2.second;
                            LogUtil.i(TAG + hashCode() + "匹配到缓存接收到的客户端数据,clientFd:" + poll + ",缓存收到的数据：" + new String(bArr));
                            linkedBlockingDeque.offer(bArr);
                        }
                    }
                }
                return 1;
            } catch (Throwable th) {
                LogUtil.d("StarryServerSocketChannel_Failed to create a new channel from an accepted socket.", th);
                try {
                    xdpOioSocketChannel.close();
                    clearFdDataList(poll.intValue());
                } catch (Throwable th2) {
                    LogUtil.e("StarryServerSocketChannel_关闭私有协议栈Socket失败 Failed to close a socket.", th2);
                }
                return 0;
            }
        } catch (Exception e) {
            LogUtil.e("StarryServerSocketChannel_实例化new私有协议栈Socket失败 Failed to init starry socket channel.", (Object) e);
        }
    }

    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    public Object filterOutboundMessage(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    public void finalize() throws Throwable {
        StarrySocketProxy starrySocketProxy = this.mServerSocket;
        if (starrySocketProxy != null) {
            starrySocketProxy.close();
            this.mServerSocket.release();
        }
    }

    public boolean isActive() {
        return this.mSockStatus != XdpOioSocketChannel.SOCK_STATUS.close;
    }

    public boolean isOpen() {
        return this.mSockStatus != XdpOioSocketChannel.SOCK_STATUS.close;
    }

    public SocketAddress localAddress0() {
        return null;
    }

    public ChannelMetadata metadata() {
        return METADATA;
    }

    public InetSocketAddress remoteAddress() {
        return null;
    }

    public SocketAddress remoteAddress0() {
        return null;
    }

    @Deprecated
    public void setReadPending(boolean z) {
        super.setReadPending(z);
    }

    public XdpOioServerSocketChannel(ServerSocket serverSocket) {
        super((Channel) null);
        this.mClientSocketMap = new HashMap();
        this.clientRecDataCacheList = new ConcurrentLinkedQueue();
        this.byteContainerArray = new byte[3000];
        this.mSockStatus = XdpOioSocketChannel.SOCK_STATUS.close;
        StarrySocketProxy starrySocketProxy = new StarrySocketProxy(true, 100, 6);
        this.mServerSocket = starrySocketProxy;
        ObjectUtil.checkNotNull(starrySocketProxy, "StarrySocketProxy");
        IStarrySocketListener starrySocketListener = getStarrySocketListener();
        LogUtil.i("StarryServerSocketChannel_私有协议栈监听器：" + starrySocketListener.hashCode());
        this.mServerSocket.setListener(starrySocketListener);
        try {
            LogUtil.i("StarryServerSocketChannel_StarryServerSocketChannel调用open方法 thisHashCode:" + hashCode() + "，实例化次数：" + instanceCount.getAndIncrement());
            this.mServerSocket.open(2, 0, 2, 0);
            this.mSockStatus = XdpOioSocketChannel.SOCK_STATUS.connecting;
            this.config = new DefaultOioServerSocketChannelConfig((ServerSocketChannel) this, serverSocket);
        } catch (Exception e) {
            throw new ChannelException("Failed to open the server socket.", e);
        } catch (Throwable th) {
            try {
                this.mServerSocket.close();
                this.mServerSocket.release();
                this.mServerSocket = null;
                this.mSockStatus = XdpOioSocketChannel.SOCK_STATUS.close;
            } catch (Exception e2) {
                LogUtil.e("StarryServerSocketChannel_Failed to close a partially initialized socket.", (Object) e2);
            }
            throw th;
        }
    }

    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    public OioServerSocketChannelConfig config() {
        return this.config;
    }
}
