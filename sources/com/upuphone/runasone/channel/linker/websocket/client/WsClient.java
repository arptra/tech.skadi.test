package com.upuphone.runasone.channel.linker.websocket.client;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.s5.a;
import com.honey.account.s5.b;
import com.honey.account.s5.c;
import com.honey.account.s5.d;
import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.StreamReq;
import com.upuphone.runasone.channel.bean.auth.AuthParameter;
import com.upuphone.runasone.channel.bean.stream.QosBean;
import com.upuphone.runasone.channel.bean.stream.StreamBuilder;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.channel.linker.ILinker;
import com.upuphone.runasone.channel.linker.starrystack.XdpNetStackManager;
import com.upuphone.runasone.channel.linker.starrystack.XdpOioSocketChannel;
import com.upuphone.runasone.channel.linker.websocket.IWsCtrlOps;
import com.upuphone.runasone.channel.linker.websocket.TextMessage;
import com.upuphone.runasone.channel.linker.websocket.WsHandlerOps;
import com.upuphone.runasone.channel.linker.websocket.WsUtil;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.DeviceManagerImpl;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.CommonThreadPool;
import com.upuphone.runasone.utils.JsonUtil;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import com.upuphone.starrynet.api.bean.StDevice;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class WsClient implements WsHandlerOps.OnEvent, IWsCtrlOps {
    /* access modifiers changed from: private */
    public static final String TAG = "WsClient";
    private static final int THRESHOLD_DELAY_INIT_STREAM = 500;
    private CountDownLatch ackLatch;
    private boolean bAuthPass = false;
    private boolean bNeedDelayInitStream = false;
    private boolean bQosRunning;
    private CountDownLatch countDownLatch;
    private String deviceId;
    private EventLoopGroup eventLoopGroup;
    private ILinker.LinkerStreamObserver linkerStreamObserver;
    private EnumLinker linkerType;
    private AuthParameter mAuthParameter;
    private Bootstrap mBoot;
    private Channel mChannel;
    private WebSocketClientHandshaker mHandShaker;
    private String selfId;
    private String serverAddress;
    private int serverPort;
    private String session = Constants.INVALID_SESSION;
    private byte terminalType;
    private int unReachAbleCnt = 0;

    public WsClient(String str, String str2, byte b, String str3, int i, ILinker.LinkerStreamObserver linkerStreamObserver2, EnumLinker enumLinker, AuthParameter authParameter) {
        boolean z = false;
        this.terminalType = b;
        int i2 = 20;
        while (true) {
            if (i2 <= 0) {
                break;
            }
            z = isPeerWindowPadOrHud() ? true : WsUtil.pingServer(str3);
            LogUtil.d("pingServer ---> " + z);
            if (z) {
                String str4 = "ping success !!!";
                if (isPeerWindowPadOrHud() && !WsUtil.pingServer(str3)) {
                    str4 = "ping fail !!!";
                }
                LogUtil.d(str4);
            } else {
                i2--;
            }
        }
        if (i2 == 0) {
            LogUtil.e("ping timeout");
        } else {
            LogUtil.d("start initBitStream");
        }
        if (z) {
            initBitStream(str, str2, str3, i, linkerStreamObserver2, enumLinker, authParameter);
            return;
        }
        this.bNeedDelayInitStream = true;
        CommonThreadPool.execute(new a(this, str3, str, str2, i, linkerStreamObserver2, enumLinker, authParameter));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean handShake(java.net.URI r3) {
        /*
            r2 = this;
            java.lang.String r0 = "handShake ---> "
            com.upuphone.runasone.utils.LogUtil.d(r0)     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            io.netty.bootstrap.Bootstrap r0 = r2.mBoot     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            java.lang.String r1 = r3.getHost()     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            int r3 = r3.getPort()     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            io.netty.channel.ChannelFuture r3 = r0.connect((java.lang.String) r1, (int) r3)     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            io.netty.channel.ChannelFuture r3 = r3.sync()     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            io.netty.channel.Channel r3 = r3.channel()     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            r2.mChannel = r3     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            io.netty.channel.ChannelPipeline r3 = r3.pipeline()     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            java.lang.String r0 = "hookedHandler"
            io.netty.channel.ChannelHandler r3 = r3.get((java.lang.String) r0)     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            com.upuphone.runasone.channel.linker.websocket.client.WsClientHandler r3 = (com.upuphone.runasone.channel.linker.websocket.client.WsClientHandler) r3     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            r3.setOnEventListener(r2)     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            io.netty.channel.ChannelFuture r3 = r3.handshakeFuture()     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            com.upuphone.runasone.channel.linker.websocket.client.WsClient$1 r0 = new com.upuphone.runasone.channel.linker.websocket.client.WsClient$1     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            r0.<init>()     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            io.netty.channel.ChannelFuture r3 = r3.addListener(r0)     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            r3.sync()     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            r2.sendSelfInfoOrAuth()     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            java.lang.String r3 = "连接成功...."
            com.upuphone.runasone.utils.LogUtil.d(r3)     // Catch:{ InterruptedException -> 0x0049, Exception -> 0x0047 }
            r2 = 1
            return r2
        L_0x0047:
            r3 = move-exception
            goto L_0x004b
        L_0x0049:
            r3 = move-exception
            goto L_0x0055
        L_0x004b:
            r3.printStackTrace()
            java.lang.String r3 = "目标不可达...."
            com.upuphone.runasone.utils.LogUtil.d(r3)
            goto L_0x0076
        L_0x0055:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handShake fail: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            com.upuphone.runasone.utils.LogUtil.e(r3)
            java.lang.String r3 = "连接失败...."
            com.upuphone.runasone.utils.LogUtil.d(r3)
        L_0x0076:
            com.upuphone.runasone.channel.linker.ILinker$LinkerStreamObserver r3 = r2.linkerStreamObserver
            if (r3 == 0) goto L_0x008a
            java.lang.String r3 = "握手失败 !!!"
            com.upuphone.runasone.utils.LogUtil.e(r3)
            com.upuphone.runasone.channel.linker.ILinker$LinkerStreamObserver r3 = r2.linkerStreamObserver
            com.upuphone.runasone.channel.linker.EnumLinker r0 = r2.linkerType
            r1 = 204005(0x31ce5, float:2.85872E-40)
            r3.onStreamError(r0, r1)
        L_0x008a:
            r3 = 0
            r2.mChannel = r3
            r2.mBoot = r3
            io.netty.channel.EventLoopGroup r2 = r2.eventLoopGroup
            if (r2 == 0) goto L_0x0096
            r2.shutdownGracefully()
        L_0x0096:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.linker.websocket.client.WsClient.handShake(java.net.URI):boolean");
    }

    private void initBitStream(String str, String str2, String str3, int i, ILinker.LinkerStreamObserver linkerStreamObserver2, EnumLinker enumLinker, AuthParameter authParameter) {
        LogUtil.d("selfId:" + str + ", host:" + str3 + ", port:" + i);
        this.selfId = str;
        this.deviceId = str2;
        this.linkerStreamObserver = linkerStreamObserver2;
        this.linkerType = enumLinker;
        this.serverAddress = str3;
        this.serverPort = i;
        this.mAuthParameter = authParameter;
        String str4 = "ws://" + this.serverAddress + AccountConstantKt.CODE_SEPARTOR + this.serverPort + "/" + WsUtil.WEB_SOCKET_PATH + "/?" + WsUtil.HTTP_REQUEST_GROUP + "=" + WsUtil.GROUP_ID + "&" + WsUtil.HTTP_REQUEST_DEVICE + "=" + str;
        LogUtil.d("handshake:" + str4);
        try {
            URI uri = new URI(str4);
            initChannel(uri);
            handShake(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void initChannel(URI uri) {
        Class cls;
        URI uri2 = uri;
        this.mHandShaker = WebSocketClientHandshakerFactory.newHandshaker(uri2, WebSocketVersion.V13, (String) null, true, new DefaultHttpHeaders(), 10000000);
        if (!XdpNetStackManager.isP2pAddr(this.serverAddress) || !XdpNetStackManager.getInstance().isXdpAvailable(XdpNetStackManager.SOURCE_WS_CLIENT_INIT, (byte) 1)) {
            this.eventLoopGroup = new NioEventLoopGroup();
            cls = NioSocketChannel.class;
        } else {
            this.eventLoopGroup = new OioEventLoopGroup();
            cls = XdpOioSocketChannel.class;
        }
        Bootstrap bootstrap = new Bootstrap();
        this.mBoot = bootstrap;
        ChannelOption<Boolean> channelOption = ChannelOption.SO_KEEPALIVE;
        Boolean bool = Boolean.TRUE;
        ((Bootstrap) ((Bootstrap) ((Bootstrap) ((Bootstrap) ((Bootstrap) bootstrap.option(channelOption, bool)).option(ChannelOption.TCP_NODELAY, bool)).group(this.eventLoopGroup)).handler(new LoggingHandler(LogLevel.INFO))).channel(cls)).handler(new WsClientInitializer(this.deviceId, this.mHandShaker));
        LogUtil.d("initChannel...");
    }

    private boolean isPeerWindowPad() {
        return this.terminalType == 10;
    }

    private boolean isPeerWindowPadOrHud() {
        byte b = this.terminalType;
        return b == 10 || b == 7;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(String str, String str2, String str3, int i, ILinker.LinkerStreamObserver linkerStreamObserver2, EnumLinker enumLinker, AuthParameter authParameter) {
        SystemClock.sleep(500);
        LogUtil.d("WsClient Delay initBitStream, pingServer ---> " + WsUtil.pingServer(str));
        if (this.bNeedDelayInitStream) {
            this.bNeedDelayInitStream = false;
            initBitStream(str2, str3, str, i, linkerStreamObserver2, enumLinker, authParameter);
            return;
        }
        LogUtil.e("no need run Delay initBitStream");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$sendAuth$2() {
        try {
            Thread.sleep(50);
            if (!TextUtils.isEmpty(this.selfId)) {
                StreamReq genAuth = StreamBuilder.genAuth(this.selfId, this.mAuthParameter.getAuthInfo());
                LogUtil.d("sendAuth ----> " + genAuth.getTimeStamp());
                sendStreamReq(genAuth);
                Thread.sleep(5000);
                if (!this.bAuthPass && this.linkerStreamObserver != null) {
                    LogUtil.e("鉴权超时 Auth timeout !!!");
                    this.linkerStreamObserver.onStreamError(this.linkerType, Constants.ChannelErrorCode.ERROR_RPC_AUTH_TIMEOUT);
                }
            } else if (this.linkerStreamObserver != null) {
                LogUtil.e("鉴权参数异常，selfId=null");
                this.linkerStreamObserver.onStreamError(this.linkerType, Constants.ChannelErrorCode.ERROR_RPC_AUTH_PARAMETER_ERROR);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$sendSelfInfoOrAuth$1(String str) {
        LogUtil.d("send self", (Object) str);
        try {
            this.mChannel.writeAndFlush(new TextWebSocketFrame(str)).addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    LogUtil.d("send self info success");
                }
            }).sync();
            LogUtil.d("begin sendAuth");
            sendAuth();
        } catch (Throwable th) {
            th.printStackTrace();
            if (this.linkerStreamObserver != null) {
                LogUtil.e("建立局域网直连通道时，返回自身消息失败！！");
                this.linkerStreamObserver.onStreamError(this.linkerType, Constants.ChannelErrorCode.ERROR_RPC_LINK_ERROR);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startQosTask$3() {
        LogUtil.d("WsClient <" + this.selfId + "> QosTask <" + Thread.currentThread().getName() + "> start");
        int i = 0;
        while (true) {
            if (!this.bQosRunning) {
                break;
            }
            try {
                int detectLink = (!isPeerWindowPad() || !Utils.isE371MX()) ? WsUtil.detectLink(this.serverAddress) : 1;
                ILinker.LinkerStreamObserver linkerStreamObserver2 = this.linkerStreamObserver;
                if (linkerStreamObserver2 == null) {
                    LogUtil.e("WsClient linkerStreamObserver is null, quit QosTask");
                    break;
                }
                linkerStreamObserver2.onUpdateQos(this.linkerType, detectLink);
                if (-1 != detectLink) {
                    LogUtil.d("WsClient detectLink " + detectLink + " ms");
                    this.unReachAbleCnt = 0;
                } else {
                    LogUtil.e("WsClient 对端不可达");
                    int i2 = this.unReachAbleCnt + 1;
                    this.unReachAbleCnt = i2;
                    if (i2 >= 3) {
                        LogUtil.e("WsClient 不可达次数超出门限，触发链路断开");
                        this.linkerStreamObserver.onStreamError(this.linkerType, Constants.ChannelErrorCode.ERROR_RPC_UNREACHABLE_ERROR);
                    }
                }
                String str = Constants.STR_TIMESTAMP + System.currentTimeMillis();
                QosBean qosBean = new QosBean();
                qosBean.setTimeStamp(str);
                qosBean.setQos(detectLink);
                Gson gson = new Gson();
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("WsClient <");
                sb.append(this.selfId);
                sb.append("> send heartbeat ");
                sb.append(str);
                sb.append(" count:");
                i++;
                sb.append(i);
                LogUtil.d(str2, (Object) sb.toString());
                sendStreamReq(StreamBuilder.genHeartBeat(this.selfId, gson.toJson((Object) qosBean), this.session));
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LogUtil.d("WsClient <" + this.selfId + "> QosTask <" + Thread.currentThread().getName() + "> end");
    }

    private void sendAuth() {
        CommonThreadPool.execute(new c(this));
    }

    private void sendAuthSuccess() {
        sendStreamReq(StreamBuilder.genAuthSuccess(this.selfId, this.mAuthParameter.getAuthInfo(), 0));
    }

    private void sendSelfInfoOrAuth() {
        StDevice ownDevice = StarrynetApiImpl.getInstance().getOwnDevice();
        StarryDevice findConnectDevice = DeviceManagerImpl.getInstance().findConnectDevice(this.deviceId);
        if (findConnectDevice == null) {
            LogUtil.e("ERROR WsClient----Peer Device not exist???????");
            sendAuth();
            return;
        }
        if (ownDevice.getIdentifier() == null) {
            ownDevice.setIdentifier(Utils.hexString2Bytes(Utils.getTempSelfId()));
        }
        LogUtil.d("terminal_info", "self_terminal_type=%s peer_terminal_type=%s", String.valueOf(ownDevice.getTerminalType()), String.valueOf(findConnectDevice.getTerminalType()));
        if (ownDevice.getTerminalType() == 3 && (findConnectDevice.getTerminalType() == 7 || findConnectDevice.getTerminalType() == 10)) {
            TextMessage textMessage = new TextMessage();
            textMessage.setType(1);
            textMessage.setMessage(JsonUtil.object2json(ownDevice));
            CommonThreadPool.execute(new d(this, JsonUtil.object2json(textMessage)));
            return;
        }
        sendAuth();
    }

    private void sendStreamReq(final StreamReq streamReq) {
        try {
            if (this.mChannel != null) {
                byte[] byteArray = streamReq.toByteArray();
                ByteBuf ioBuffer = ByteBufAllocator.DEFAULT.ioBuffer();
                ioBuffer.writeBytes(byteArray);
                BinaryWebSocketFrame binaryWebSocketFrame = new BinaryWebSocketFrame(ioBuffer);
                String str = TAG;
                LogUtil.dPrimary(str, " 发送 [Id: " + this.deviceId + "] binary message, length:" + byteArray.length + " Bytes, " + streamReq.getType());
                this.mChannel.writeAndFlush(binaryWebSocketFrame).addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (channelFuture.isSuccess()) {
                            String access$000 = WsClient.TAG;
                            LogUtil.dPrimary(access$000, "WsClient send success " + streamReq.getTimeStamp());
                            return;
                        }
                        LogUtil.e("WsClient send failed " + streamReq.getTimeStamp() + " cause:" + channelFuture.cause().getMessage());
                    }
                });
                return;
            }
            LogUtil.e("请先连接...");
        } catch (Exception e) {
            LogUtil.e(e);
            e.printStackTrace();
        }
    }

    private void startQosTask() {
        LogUtil.d("WsClient <" + this.selfId + "> startQosTask");
        this.bQosRunning = true;
        CommonThreadPool.execute(new b(this));
    }

    private void stopQosTask() {
        LogUtil.d("WsClient <" + this.selfId + "> stopQosTask");
        this.bQosRunning = false;
    }

    public void close() {
        Channel channel;
        LogUtil.d(TAG, (Object) "----> stream close");
        this.bNeedDelayInitStream = false;
        synchronized (this) {
            channel = this.mChannel;
            this.mChannel = null;
        }
        if (channel != null) {
            ILinker.LinkerStreamObserver linkerStreamObserver2 = this.linkerStreamObserver;
            if (linkerStreamObserver2 != null) {
                linkerStreamObserver2.onStreamClose(this.linkerType);
                this.linkerStreamObserver = null;
            }
            stopQosTask();
            channel.close();
            this.mBoot = null;
        }
        EventLoopGroup eventLoopGroup2 = this.eventLoopGroup;
        if (eventLoopGroup2 != null) {
            eventLoopGroup2.shutdownGracefully();
        }
    }

    public AuthParameter getAuthParameter() {
        return this.mAuthParameter;
    }

    public String getSelfId() {
        return this.selfId;
    }

    public boolean notifyTearDownSync(String str, StreamReq streamReq) {
        if (this.mChannel != null) {
            this.countDownLatch = new CountDownLatch(1);
            sendStreamReq(streamReq);
            try {
                if (this.countDownLatch.await(300, TimeUnit.MILLISECONDS)) {
                    return true;
                }
                LogUtil.e(TAG, (Object) "TEARDOWN_ACK not complete in time. ");
                return false;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                String str2 = TAG;
                LogUtil.e(str2, (Object) "msg latch: " + e);
                return false;
            }
        } else {
            LogUtil.e("deviceId <" + str + "> mChannel is null");
            return false;
        }
    }

    public void onAck(String str, long j) {
        CountDownLatch countDownLatch2 = this.ackLatch;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        } else {
            LogUtil.e("latch maybe timeout");
        }
    }

    public boolean onAuth(String str, AuthParameter authParameter, SimpleChannelInboundHandler simpleChannelInboundHandler) {
        if (this.linkerStreamObserver == null) {
            return false;
        }
        sendAuthSuccess();
        this.bAuthPass = true;
        this.linkerStreamObserver.onStreamOpen(this.linkerType, authParameter);
        startQosTask();
        return false;
    }

    public void onClose(String str) {
    }

    public void onConnected(String str, String str2) {
    }

    public void onError(String str, int i) {
        ILinker.LinkerStreamObserver linkerStreamObserver2 = this.linkerStreamObserver;
        if (linkerStreamObserver2 != null) {
            linkerStreamObserver2.onStreamError(this.linkerType, i);
        }
    }

    public void onMessageArrived(String str, ChannelMessage channelMessage) {
        ILinker.LinkerStreamObserver linkerStreamObserver2 = this.linkerStreamObserver;
        if (linkerStreamObserver2 != null) {
            linkerStreamObserver2.input(this.linkerType, channelMessage);
        }
    }

    public void onRetransmission(String str, long j, long j2) {
        ILinker.LinkerStreamObserver linkerStreamObserver2 = this.linkerStreamObserver;
        if (linkerStreamObserver2 != null) {
            linkerStreamObserver2.onRetransmission(this.linkerType, j, j2);
        }
    }

    public void onTearDown(String str) {
        LogUtil.d("send TEARDOWN_ACK to deviceId:" + str);
        sendStreamReq(StreamBuilder.genTearDownAck(this.selfId, this.session));
        ILinker.LinkerStreamObserver linkerStreamObserver2 = this.linkerStreamObserver;
        if (linkerStreamObserver2 != null) {
            linkerStreamObserver2.onStreamTearDown(this.linkerType);
        }
    }

    public void onTearDownAck(String str) {
        CountDownLatch countDownLatch2 = this.countDownLatch;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        }
    }

    public boolean onUpdateQos(String str, int i) {
        return true;
    }

    public boolean output(StreamReq streamReq) {
        if (this.mChannel != null) {
            String str = TAG;
            LogUtil.dPrimary(str, "WsClient output timestamp :" + streamReq.getTimeStamp() + " reqId:" + streamReq.getReqId());
            sendStreamReq(streamReq);
            boolean z = true;
            if (QosLevel.QOS_2 == streamReq.getQos()) {
                long currentTimeMillis = System.currentTimeMillis();
                CountDownLatch countDownLatch2 = new CountDownLatch(1);
                this.ackLatch = countDownLatch2;
                try {
                    z = countDownLatch2.await(3000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    String str2 = TAG;
                    LogUtil.e(str2, (Object) "ack latch: " + e);
                }
                String str3 = TAG;
                LogUtil.dPrimary(str3, "ACK await:" + z + " cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                this.ackLatch = null;
            }
            return z;
        }
        LogUtil.e(TAG, (Object) "mChannel is null");
        return false;
    }

    public void setSession(String str, String str2) {
        this.session = str2;
    }

    public boolean trigger(String str, StreamReq streamReq) {
        if (this.mChannel != null) {
            sendStreamReq(streamReq);
            return true;
        }
        LogUtil.e("deviceId <" + str + "> mChannel is null");
        return false;
    }
}
