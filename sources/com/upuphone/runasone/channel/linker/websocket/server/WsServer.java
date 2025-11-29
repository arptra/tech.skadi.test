package com.upuphone.runasone.channel.linker.websocket.server;

import com.honey.account.t5.a;
import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.StreamReq;
import com.upuphone.runasone.channel.bean.auth.AuthParameter;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.channel.linker.ILinker;
import com.upuphone.runasone.channel.linker.starrystack.XdpNetStackManager;
import com.upuphone.runasone.channel.linker.starrystack.XdpOioServerSocketChannel;
import com.upuphone.runasone.channel.linker.websocket.IWsCtrlOps;
import com.upuphone.runasone.channel.linker.websocket.WsHandlerOps;
import com.upuphone.runasone.device.DeviceManagerImpl;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.utils.CommonThreadPool;
import com.upuphone.runasone.utils.LogUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class WsServer implements WsHandlerOps.OnEvent, IWsCtrlOps {
    private static final String TAG = "WsServer";
    private static boolean bInit = false;
    private static WsServer mInstance = new WsServer();
    private ConcurrentHashMap<String, CountDownLatch> latchMap = new ConcurrentHashMap<>();
    private EnumLinker linkerType;
    private AuthParameter mAuthParameter;
    private Channel mChannel;
    private int mPort;
    private String selfId;
    private ConcurrentHashMap<String, WsServerHandler> serverHandlerMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, DeviceState> stateMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, ILinker.LinkerStreamObserver> streamObserverMap = new ConcurrentHashMap<>();
    private CountDownLatch tearDownLatch;

    public enum DeviceState {
        STATE_WAITING_LINK,
        STATE_LINK_UP,
        STATE_LINK_DOWN
    }

    private WsServer() {
    }

    public static WsServer getInstance() {
        return mInstance;
    }

    private void initInner(int i) {
        if (!bInit) {
            LogUtil.e("init WsServer port:" + i);
            initWebSocketServer(i);
            return;
        }
        boolean isXdpAvailable = XdpNetStackManager.getInstance().isXdpAvailable(XdpNetStackManager.SOURCE_WS_SERVER_INIT_AGAIN, (byte) 1);
        LogUtil.e("WsServer has already init, mPort:" + this.mPort + " port:" + i + " isXdpLinkEnable:" + isXdpAvailable);
        if (this.mPort != i || isXdpAvailable) {
            LogUtil.e("WsServer 端口改变，服务需重建");
            Channel channel = this.mChannel;
            if (channel != null) {
                channel.close();
                this.mChannel = null;
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                String str = TAG;
                LogUtil.e(str, (Object) "init fail: " + e);
            }
            initWebSocketServer(i);
        }
    }

    private void initWebSocketServer(int i) {
        CommonThreadPool.execute(new a(this, i));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initWebSocketServer$0(int i) {
        Class cls;
        EventLoopGroup eventLoopGroup;
        EventLoopGroup eventLoopGroup2;
        LogUtil.d("initWebSocketServer start with port:" + i);
        this.mPort = i;
        bInit = true;
        new NioEventLoopGroup(1);
        new NioEventLoopGroup();
        if (XdpNetStackManager.getInstance().isXdpAvailable(XdpNetStackManager.SOURCE_WS_SERVER_INIT_WEBSOCKET_SERVER, (byte) 1)) {
            eventLoopGroup = new OioEventLoopGroup(1);
            eventLoopGroup2 = new OioEventLoopGroup();
            cls = XdpOioServerSocketChannel.class;
        } else {
            eventLoopGroup = new NioEventLoopGroup(1);
            eventLoopGroup2 = new NioEventLoopGroup();
            cls = NioServerSocketChannel.class;
        }
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            ((ServerBootstrap) ((ServerBootstrap) serverBootstrap.group(eventLoopGroup, eventLoopGroup2).channel(cls)).handler(new LoggingHandler(LogLevel.INFO))).childHandler(new WsServerInitializer(this));
            Channel channel = serverBootstrap.bind(i).sync().channel();
            this.mChannel = channel;
            channel.closeFuture().sync();
        } catch (Exception e) {
            LogUtil.d("initWebSocketServer 异常");
            e.printStackTrace();
        } catch (Throwable th) {
            eventLoopGroup.shutdownGracefully();
            eventLoopGroup2.shutdownGracefully();
            throw th;
        }
        eventLoopGroup.shutdownGracefully();
        eventLoopGroup2.shutdownGracefully();
        LogUtil.d("initWebSocketServer end");
    }

    public AuthParameter getAuthParameter() {
        return this.mAuthParameter;
    }

    public String getSelfId() {
        return this.selfId;
    }

    public void init(int i) {
        initInner(i);
    }

    public synchronized void link(String str, String str2, EnumLinker enumLinker, ILinker.LinkerStreamObserver linkerStreamObserver, AuthParameter authParameter) {
        try {
            LogUtil.d("link start");
            this.selfId = str;
            this.linkerType = enumLinker;
            this.mAuthParameter = authParameter;
            if (this.stateMap.containsKey(str2)) {
                LogUtil.e("stateMap has id:" + str2 + " state:" + this.stateMap.get(str2));
            }
            this.stateMap.put(str2, DeviceState.STATE_WAITING_LINK);
            this.streamObserverMap.put(str2, linkerStreamObserver);
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean notifyTearDownSync(String str, StreamReq streamReq) {
        if (!this.serverHandlerMap.containsKey(str)) {
            return false;
        }
        this.tearDownLatch = new CountDownLatch(1);
        this.serverHandlerMap.get(str).notifyTearDown(str, streamReq);
        try {
            if (!this.tearDownLatch.await(300, TimeUnit.MILLISECONDS)) {
                LogUtil.e("TEARDOWN_ACK not complete in time. ");
                return false;
            }
            LogUtil.d("TEARDOWN_ACK in time");
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            String str2 = TAG;
            LogUtil.e(str2, (Object) "teardown latch: " + e);
            return false;
        }
    }

    public void onAck(String str, long j) {
        CountDownLatch countDownLatch = this.latchMap.get(str);
        if (countDownLatch != null) {
            countDownLatch.countDown();
        } else {
            LogUtil.e("latch maybe timeout");
        }
    }

    public boolean onAuth(String str, AuthParameter authParameter, SimpleChannelInboundHandler simpleChannelInboundHandler) {
        if (!this.stateMap.containsKey(str) || !this.streamObserverMap.containsKey(str)) {
            LogUtil.e("WsServer onAuth id:" + str + " is not exist !!! stateMap:" + this.stateMap.containsKey(str) + " streamObserverMap:" + this.streamObserverMap.containsKey(str));
            return false;
        }
        LogUtil.d("onAuth stateMap id:" + str + "  linkup");
        this.stateMap.put(str, DeviceState.STATE_LINK_UP);
        this.serverHandlerMap.put(str, (WsServerHandler) simpleChannelInboundHandler);
        this.streamObserverMap.get(str).onStreamOpen(this.linkerType, authParameter);
        return true;
    }

    public void onClose(String str) {
    }

    public void onConnected(String str, String str2) {
        StarryDevice findConnectDevice = DeviceManagerImpl.getInstance().findConnectDevice(str);
        if (findConnectDevice != null) {
            findConnectDevice.setAddress(str2);
            return;
        }
        LogUtil.d("onConnected not find <" + str + ">");
    }

    public void onError(String str, int i) {
        if (this.streamObserverMap.containsKey(str)) {
            LogUtil.e("WsServer onStreamError");
            ILinker.LinkerStreamObserver linkerStreamObserver = this.streamObserverMap.get(str);
            if (linkerStreamObserver != null) {
                linkerStreamObserver.onStreamError(this.linkerType, i);
            }
        } else {
            LogUtil.e("streamObserverMap id:" + str + " is not exist !!!");
        }
        if (this.stateMap.containsKey(str)) {
            this.stateMap.put(str, DeviceState.STATE_LINK_DOWN);
            return;
        }
        LogUtil.e("stateMap id:" + str + " is not exist !!!");
    }

    public void onMessageArrived(String str, ChannelMessage channelMessage) {
        if (!this.stateMap.containsKey(str)) {
            LogUtil.e("input fail, stateMap id:" + str + " is not exist !!!");
        } else if (DeviceState.STATE_LINK_UP != this.stateMap.get(str) || !this.serverHandlerMap.containsKey(str) || !this.streamObserverMap.containsKey(str)) {
            LogUtil.e("input fail, state:" + this.stateMap.get(str) + " serverMap:" + this.serverHandlerMap.containsKey(str) + " mStreamObserver:" + this.streamObserverMap.containsKey(str));
        } else {
            this.streamObserverMap.get(str).input(this.linkerType, channelMessage);
        }
    }

    public void onRetransmission(String str, long j, long j2) {
        if (this.streamObserverMap.containsKey(str)) {
            this.streamObserverMap.get(str).onRetransmission(this.linkerType, j, j2);
            return;
        }
        LogUtil.e("onUpdateQos fail, streamObserverMap id:" + str + " is not exist !!!");
    }

    public void onTearDown(String str) {
        if (this.streamObserverMap.containsKey(str)) {
            this.streamObserverMap.get(str).onStreamTearDown(this.linkerType);
            return;
        }
        LogUtil.e("onStreamTearDown fail, streamObserverMap id:" + str + " is not exist !!!");
    }

    public void onTearDownAck(String str) {
        CountDownLatch countDownLatch = this.tearDownLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public boolean onUpdateQos(String str, int i) {
        if (this.streamObserverMap.containsKey(str)) {
            this.streamObserverMap.get(str).onUpdateQos(this.linkerType, i);
            return true;
        }
        LogUtil.e("onUpdateQos fail, streamObserverMap id:" + str + " is not exist !!!");
        return false;
    }

    public boolean output(String str, StreamReq streamReq) {
        if (this.stateMap.containsKey(str)) {
            if (DeviceState.STATE_LINK_UP != this.stateMap.get(str) || !this.serverHandlerMap.containsKey(str)) {
                LogUtil.e("output fail, state:" + this.stateMap.get(str) + " serverMap:" + this.serverHandlerMap.containsKey(str));
            } else {
                boolean output = this.serverHandlerMap.get(str).output(str, streamReq);
                if (!output) {
                    LogUtil.e("output <" + str + "> fail !!!");
                    return false;
                }
                if (QosLevel.QOS_2 == streamReq.getQos()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.latchMap.contains(str)) {
                        this.latchMap.remove(str);
                    }
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    this.latchMap.put(str, countDownLatch);
                    try {
                        output = countDownLatch.await(3000, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        String str2 = TAG;
                        LogUtil.e(str2, (Object) "ack latch: " + e);
                    }
                    this.latchMap.remove(str);
                    String str3 = TAG;
                    LogUtil.dPrimary(str3, "ACK await:" + output + " cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                }
                return output;
            }
        }
        return false;
    }

    public void setSession(String str, String str2) {
        if (this.serverHandlerMap.containsKey(str)) {
            this.serverHandlerMap.get(str).setSession(str, str2);
        }
    }

    public void stop() {
    }

    public boolean trigger(String str, StreamReq streamReq) {
        if (this.serverHandlerMap.containsKey(str)) {
            return this.serverHandlerMap.get(str).sendStream(str, streamReq);
        }
        return false;
    }

    public synchronized void unlink(String str) {
        try {
            if (!this.stateMap.containsKey(str)) {
                LogUtil.e("stateMap id:" + str + " is not exist !!!");
            } else {
                this.stateMap.remove(str);
            }
            if (!this.streamObserverMap.containsKey(str)) {
                LogUtil.e("streamObserverMap id:" + str + " is not exist !!!");
            } else {
                this.streamObserverMap.remove(str);
            }
            if (!this.serverHandlerMap.containsKey(str)) {
                LogUtil.e("serverHandlerMap id:" + str + " is not exist !!!");
            } else {
                this.serverHandlerMap.get(str).close();
                this.serverHandlerMap.remove(str);
            }
            if (this.latchMap.containsKey(str)) {
                LogUtil.d("remove id:" + str + " latch");
                this.latchMap.get(str).countDown();
                this.latchMap.remove(str);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
