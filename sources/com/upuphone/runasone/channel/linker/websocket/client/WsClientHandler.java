package com.upuphone.runasone.channel.linker.websocket.client;

import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.StreamReq;
import com.upuphone.runasone.StreamType;
import com.upuphone.runasone.channel.bean.auth.AuthParameter;
import com.upuphone.runasone.channel.bean.auth.VpnParameter;
import com.upuphone.runasone.channel.linker.websocket.WsHandlerOps;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketHandshakeException;
import io.netty.util.CharsetUtil;

public class WsClientHandler extends SimpleChannelInboundHandler<Object> implements WsHandlerOps {
    private static final String TAG = "WsClientHandler";
    private WsHandlerOps.OnEvent handlerListener;
    private ChannelPromise handshakeFuture;
    private String mDeviceId;
    private WebSocketClientHandshaker mHandShaker;

    /* renamed from: com.upuphone.runasone.channel.linker.websocket.client.WsClientHandler$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$upuphone$runasone$StreamType;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.upuphone.runasone.StreamType[] r0 = com.upuphone.runasone.StreamType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$upuphone$runasone$StreamType = r0
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.ACTION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.BRIDGE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.BYPASS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.AUTH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.CLOSE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.HEARTBEAT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.ACK     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.TEARDOWN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.TEARDOWN_ACK     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.RETRANSMISSION     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.linker.websocket.client.WsClientHandler.AnonymousClass1.<clinit>():void");
        }
    }

    public WsClientHandler(String str, WebSocketClientHandshaker webSocketClientHandshaker) {
        this.mDeviceId = str;
        this.mHandShaker = webSocketClientHandshaker;
    }

    private void dispatch(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame) {
        if ((webSocketFrame instanceof BinaryWebSocketFrame) && this.handlerListener != null) {
            int capacity = webSocketFrame.content().capacity();
            if (capacity > 0) {
                String str = TAG;
                LogUtil.dPrimary(str, "接收到二进制消息，消息长度:" + capacity);
                try {
                    handlerClientStream(channelHandlerContext, StreamReq.parseFrom(ByteBufUtil.getBytes(webSocketFrame.content())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                LogUtil.e(TAG, (Object) "dispatch len error ...");
            }
        }
    }

    private void handlerClientStream(ChannelHandlerContext channelHandlerContext, StreamReq streamReq) {
        String deviceId = streamReq.getDeviceId();
        StreamType type = streamReq.getType();
        String reqInfo = streamReq.getReqInfo();
        String timeStamp = streamReq.getTimeStamp();
        String category = streamReq.getCategory();
        long reqId = streamReq.getReqId();
        long retransmissionLen = streamReq.getRetransmissionLen();
        boolean isRetransmission = streamReq.getIsRetransmission();
        QosLevel qos = streamReq.getQos() == null ? QosLevel.QOS_0 : streamReq.getQos();
        String parserSession = Utils.parserSession(streamReq.getSession());
        String dstId = streamReq.getDstId();
        String srcId = streamReq.getSrcId();
        String str = TAG;
        String str2 = srcId;
        StringBuilder sb = new StringBuilder();
        boolean z = isRetransmission;
        sb.append(" 收到 [Id: ");
        sb.append(deviceId);
        sb.append("] handlerClientStream getAction:");
        sb.append(type);
        sb.append(" getReqId:");
        sb.append(reqId);
        sb.append(" getTimeStamp:");
        sb.append(timeStamp);
        sb.append(" qosLevel:");
        sb.append(qos);
        sb.append(" session:");
        sb.append(parserSession);
        sb.append(" dstId:");
        sb.append(dstId);
        LogUtil.dPrimary(str, sb.toString());
        if (this.handlerListener != null) {
            switch (AnonymousClass1.$SwitchMap$com$upuphone$runasone$StreamType[type.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    if (streamReq.getAbilityMsg() == null || category == null) {
                        LogUtil.e(str, (Object) "BYPASS ability msg is null");
                        return;
                    }
                    handlerMessageArrived(this.mDeviceId, reqId, category, new AbilityMessage(streamReq.getBypass().toByteArray()), z, qos, parserSession, type, dstId, str2);
                    return;
                case 4:
                    LogUtil.d(str, (Object) "WsClient Auth:" + reqInfo + " getProtocolVersion:" + streamReq.getProtocolVersion());
                    if (reqInfo == null || reqInfo.isEmpty()) {
                        LogUtil.e("Ws 通道鉴权失败 AUTH FAIL, info is null");
                        return;
                    }
                    LogUtil.d("Ws 通道鉴权通过，服务端 <" + deviceId + ">");
                    String ipAddress = streamReq.getIpAddress();
                    int tcpPort = streamReq.getTcpPort();
                    int udpPort = streamReq.getUdpPort();
                    VpnParameter vpnParameter = new VpnParameter();
                    vpnParameter.setIp(ipAddress);
                    vpnParameter.setTcpPort(tcpPort);
                    vpnParameter.setUdpPort(udpPort);
                    AuthParameter authParameter = new AuthParameter();
                    authParameter.setRemoteServer(true);
                    authParameter.setAuthInfo(reqInfo);
                    authParameter.setVpnParameter(vpnParameter);
                    this.handlerListener.onAuth(this.mDeviceId, authParameter, this);
                    return;
                case 5:
                    LogUtil.d(str, (Object) "WsClient receive Close");
                    return;
                case 6:
                    return;
                case 7:
                    LogUtil.dPrimary(str, "rev ACK:" + timeStamp + " reqId:" + reqId);
                    this.handlerListener.onAck(this.mDeviceId, reqId);
                    return;
                case 8:
                    LogUtil.d(str, (Object) "rev TEARDOWN: " + timeStamp);
                    this.handlerListener.onTearDown(this.mDeviceId);
                    return;
                case 9:
                    LogUtil.d(str, (Object) "rev TEARDOWN_ACK: " + timeStamp);
                    this.handlerListener.onTearDownAck(this.mDeviceId);
                    return;
                case 10:
                    LogUtil.d(str, (Object) "rev RETRANSMISSION: " + timeStamp);
                    this.handlerListener.onRetransmission(this.mDeviceId, reqId, retransmissionLen);
                    return;
                default:
                    LogUtil.e(str, (Object) "WsClient un-catch: " + type);
                    return;
            }
        } else {
            LogUtil.e("handlerClientStream is null");
        }
    }

    private void handlerMessageArrived(String str, long j, String str2, AbilityMessage abilityMessage, boolean z, QosLevel qosLevel, String str3, StreamType streamType, String str4, String str5) {
        this.handlerListener.onMessageArrived(str, ChannelMessage.newBuilder().setId(str).setAbilityMessage(abilityMessage).setCategory(str2).setRequestId(j).setRetransmission(z).setLinkStrategy(EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE).setQos(qosLevel).setSession(str3).setMessageType(streamType).setDstId(str4).setSrcId(str5).build());
    }

    private void handlerWebSocketFrame(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame) {
        if (webSocketFrame instanceof CloseWebSocketFrame) {
            LogUtil.e(TAG, (Object) "CloseWebSocketFrame");
        } else if (webSocketFrame instanceof PingWebSocketFrame) {
            String str = TAG;
            LogUtil.d(str, (Object) "PingWebSocketFrame: " + getChannelId(channelHandlerContext));
            channelHandlerContext.channel().write(new PongWebSocketFrame(webSocketFrame.content().retain()));
        } else if (webSocketFrame instanceof BinaryWebSocketFrame) {
            dispatch(channelHandlerContext, webSocketFrame);
        } else if (webSocketFrame instanceof PongWebSocketFrame) {
            String str2 = TAG;
            LogUtil.d(str2, (Object) "PongWebSocketFrame: " + getChannelId(channelHandlerContext));
        } else if (!(webSocketFrame instanceof TextWebSocketFrame)) {
            throw new UnsupportedOperationException(String.format("%s frame types not supported", new Object[]{webSocketFrame.getClass().getName()}));
        }
    }

    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.mHandShaker.handshake(channelHandlerContext.channel());
    }

    public void channelRead0(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        String str = TAG;
        LogUtil.dPrimary(str, "channelRead0 isHandshakeComplete:" + this.mHandShaker.isHandshakeComplete());
        Channel channel = channelHandlerContext.channel();
        LogUtil.dPrimary(str, " 收到二进制消息 channel id:" + getChannelId(channelHandlerContext) + " source:" + channelHandlerContext.channel().remoteAddress());
        if (!this.mHandShaker.isHandshakeComplete()) {
            try {
                FullHttpResponse fullHttpResponse = (FullHttpResponse) obj;
                this.mHandShaker.finishHandshake(channel, fullHttpResponse);
                this.handshakeFuture.setSuccess();
                LogUtil.d("WebSocket Client connected! response headers[sec-websocket-extensions]:{}" + fullHttpResponse.headers());
            } catch (WebSocketHandshakeException unused) {
                FullHttpResponse fullHttpResponse2 = (FullHttpResponse) obj;
                this.handshakeFuture.setFailure(new Exception(String.format("WebSocket Client failed to connect,status:%s,reason:%s", new Object[]{fullHttpResponse2.status(), fullHttpResponse2.content().toString(CharsetUtil.UTF_8)})));
            }
        } else if (!(obj instanceof FullHttpResponse)) {
            handlerWebSocketFrame(channelHandlerContext, (WebSocketFrame) obj);
        } else {
            FullHttpResponse fullHttpResponse3 = (FullHttpResponse) obj;
            throw new IllegalStateException("Unexpected FullHttpResponse (getStatus=" + fullHttpResponse3.status() + ", content=" + fullHttpResponse3.content().toString(CharsetUtil.UTF_8) + ')');
        }
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        th.printStackTrace();
        String str = TAG;
        LogUtil.e(str, (Object) "exceptionCaught Channel Id:" + getChannelId(channelHandlerContext) + " cause:" + th);
        if (!this.handshakeFuture.isDone()) {
            this.handshakeFuture.setFailure(th);
        }
        channelHandlerContext.close();
    }

    public String getChannelId(ChannelHandlerContext channelHandlerContext) {
        return channelHandlerContext.channel().id().asShortText();
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        this.handshakeFuture = channelHandlerContext.newPromise();
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        String str = TAG;
        LogUtil.d(str, (Object) "handlerRemoved: the channel <" + channelHandlerContext.channel() + "> is already remove");
        WsHandlerOps.OnEvent onEvent = this.handlerListener;
        if (onEvent != null) {
            onEvent.onError(this.mDeviceId, Constants.ChannelErrorCode.ERROR_RPC_LINK_ERROR);
        }
        super.handlerRemoved(channelHandlerContext);
    }

    public ChannelFuture handshakeFuture() {
        return this.handshakeFuture;
    }

    public void setOnEventListener(WsHandlerOps.OnEvent onEvent) {
        this.handlerListener = onEvent;
    }
}
