package com.upuphone.runasone.channel.linker.websocket.server;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.reflect.TypeToken;
import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.StreamReq;
import com.upuphone.runasone.StreamType;
import com.upuphone.runasone.channel.linker.websocket.TextMessage;
import com.upuphone.runasone.channel.linker.websocket.WsHandlerOps;
import com.upuphone.runasone.channel.linker.websocket.WsUtil;
import com.upuphone.runasone.connection.LanDirectConnector;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.JsonUtil;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.starrynet.api.StErrorTips;
import com.upuphone.starrynet.api.bean.StDevice;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class WsServerHandler extends SimpleChannelInboundHandler<Object> implements WsHandlerOps {
    /* access modifiers changed from: private */
    public static final String TAG = "WsServerHandler";
    private static Map<String, ChannelGroup> mChannelGroupMap = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public WsHandlerOps.OnEvent handlerListener;
    private HandlerThread handlerThread = new HandlerThread("HeartbeatTimeOutHandler");
    private Channel mChannel;
    /* access modifiers changed from: private */
    public String mDeviceId;
    private WebSocketServerHandshaker mHandShaker;
    private String mSession;
    /* access modifiers changed from: private */
    public Handler timeOutHandler;
    /* access modifiers changed from: private */
    public Map<String, Long> timeoutCheck = new ConcurrentHashMap();

    /* renamed from: com.upuphone.runasone.channel.linker.websocket.server.WsServerHandler$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$upuphone$runasone$StreamType;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
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
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.AUTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.AUTH_SUCCESS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.ACTION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.BRIDGE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.BYPASS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.CLOSE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.HEARTBEAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.ACK     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.TEARDOWN     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.TEARDOWN_ACK     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.RETRANSMISSION     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$upuphone$runasone$StreamType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.RETRANSMISSION_ACK     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.linker.websocket.server.WsServerHandler.AnonymousClass5.<clinit>():void");
        }
    }

    public class ServerHeartBeat extends ChannelInboundHandlerAdapter {
        private ServerHeartBeat() {
        }

        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            if (obj instanceof IdleStateEvent) {
                IdleStateEvent idleStateEvent = (IdleStateEvent) obj;
                if (idleStateEvent.state() == IdleState.READER_IDLE) {
                    String access$200 = WsServerHandler.TAG;
                    LogUtil.e(access$200, (Object) "ServerHeartBeat " + WsServerHandler.this.getChannelId(channelHandlerContext) + " READER_IDLE");
                    WsServerHandler.this.closeChannelByCtx(channelHandlerContext, Constants.ChannelErrorCode.ERROR_RPC_ALIVE_TIMEOUT);
                    channelHandlerContext.channel().close();
                } else if (idleStateEvent.state() == IdleState.WRITER_IDLE) {
                    String access$2002 = WsServerHandler.TAG;
                    LogUtil.e(access$2002, (Object) "ServerHeartBeat " + WsServerHandler.this.getChannelId(channelHandlerContext) + " WRITER_IDLE");
                } else if (idleStateEvent.state() == IdleState.ALL_IDLE) {
                    String access$2003 = WsServerHandler.TAG;
                    LogUtil.e(access$2003, (Object) "ServerHeartBeat " + WsServerHandler.this.getChannelId(channelHandlerContext) + " ALL_IDLE");
                }
            }
            super.userEventTriggered(channelHandlerContext, obj);
        }
    }

    public WsServerHandler(SocketChannel socketChannel) {
        LogUtil.d("WsServerHandler init <" + socketChannel.remoteAddress() + ">");
        this.handlerThread.start();
        AnonymousClass1 r3 = new Handler(this.handlerThread.getLooper()) {
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                Iterator it = WsServerHandler.this.timeoutCheck.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    long elapsedRealtime = SystemClock.elapsedRealtime() - ((Long) entry.getValue()).longValue();
                    if (elapsedRealtime > 12000) {
                        LogUtil.d("Heartbeat Packet TimeOut : " + ((String) entry.getKey()));
                        StErrorTips.showErrorTips(StErrorTips.ErrorTips.P2P_HEARTBEAT_TIMEOUT);
                        if (WsServerHandler.this.handlerListener != null) {
                            WsServerHandler.this.handlerListener.onError((String) entry.getKey(), Constants.ChannelErrorCode.ERROR_RPC_ALIVE_TIMEOUT);
                        }
                        it.remove();
                    }
                    String access$200 = WsServerHandler.TAG;
                    LogUtil.dPrimary(access$200, "timeoutCheck = " + elapsedRealtime + " " + WsServerHandler.this.mDeviceId + " " + ((String) entry.getKey()));
                }
                WsServerHandler.this.timeOutHandler.sendMessageDelayed(Message.obtain(), 3000);
            }
        };
        this.timeOutHandler = r3;
        r3.sendMessage(Message.obtain());
    }

    /* access modifiers changed from: private */
    public void closeChannelByCtx(ChannelHandlerContext channelHandlerContext, int i) {
        String hostAddress = ((InetSocketAddress) channelHandlerContext.channel().remoteAddress()).getAddress().getHostAddress();
        String channelId = getChannelId(channelHandlerContext);
        String str = TAG;
        LogUtil.d(str, (Object) "closeChannelByCtx ip:" + hostAddress + " channelId:" + channelId + " deviceId:" + this.mDeviceId);
        close();
        this.handlerListener.onError(this.mDeviceId, i);
    }

    private void dispatch(ChannelHandlerContext channelHandlerContext, BinaryWebSocketFrame binaryWebSocketFrame) {
        try {
            handlerServerStream(StreamReq.parseFrom(ByteBufUtil.getBytes(binaryWebSocketFrame.content())), channelHandlerContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public String getChannelId(ChannelHandlerContext channelHandlerContext) {
        return channelHandlerContext.channel().id().asShortText();
    }

    private synchronized String getSession(String str) {
        if (TextUtils.isEmpty(this.mSession) || !TextUtils.equals(this.mDeviceId, str)) {
            return Constants.INVALID_SESSION;
        }
        return this.mSession;
    }

    private static String getWebSocketLocation(FullHttpRequest fullHttpRequest) {
        return "ws://" + (fullHttpRequest.headers().get((CharSequence) HttpHeaderNames.HOST) + WsUtil.WEB_SOCKET_PATH);
    }

    private void handlerHttpRequest(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) {
        ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
        FullHttpRequest fullHttpRequest2 = fullHttpRequest;
        String str = TAG;
        LogUtil.d(str, (Object) "handlerHttpRequest");
        String channelId = getChannelId(channelHandlerContext);
        InetSocketAddress inetSocketAddress = (InetSocketAddress) channelHandlerContext.channel().remoteAddress();
        String hostAddress = inetSocketAddress.getAddress().getHostAddress();
        int port = inetSocketAddress.getPort();
        if (!fullHttpRequest.decoderResult().isSuccess()) {
            if (fullHttpRequest.decoderResult().cause() != null) {
                LogUtil.d(str, (Object) "handlerHttpRequest :" + fullHttpRequest.decoderResult().cause().getMessage());
                fullHttpRequest.decoderResult().cause().printStackTrace();
            }
            sendHttpResponse(channelHandlerContext2, fullHttpRequest2, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
        } else if (fullHttpRequest.method() != HttpMethod.GET) {
            sendHttpResponse(channelHandlerContext2, fullHttpRequest2, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FORBIDDEN));
        } else if ("/favicon.ico".equals(fullHttpRequest.uri()) || "/".equals(fullHttpRequest.uri())) {
            sendHttpResponse(channelHandlerContext2, fullHttpRequest2, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND));
        } else {
            Map<String, List<String>> parameters = new QueryStringDecoder(fullHttpRequest.uri()).parameters();
            if (parameters.size() == 0 || !parameters.containsKey(WsUtil.HTTP_REQUEST_GROUP) || !parameters.containsKey(WsUtil.HTTP_REQUEST_DEVICE)) {
                LogUtil.e(str, (Object) "拒绝握手，参数不可缺省");
                sendHttpResponse(channelHandlerContext2, fullHttpRequest2, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND));
                return;
            }
            LogUtil.d(str, (Object) "parser ----- ");
            String str2 = (String) parameters.get(WsUtil.HTTP_REQUEST_DEVICE).get(0);
            LogUtil.d(str, (Object) "分组:" + ((String) parameters.get(WsUtil.HTTP_REQUEST_GROUP).get(0)) + " 设备:" + str2);
            if (this.handlerListener != null) {
                LogUtil.d("remote devices <" + str2 + "> ip=" + hostAddress + " port=" + port);
                this.handlerListener.onConnected(str2, hostAddress);
            }
            synchronized (this) {
                try {
                    WebSocketServerHandshaker newHandshaker = new WebSocketServerHandshakerFactory(getWebSocketLocation(fullHttpRequest), (String) null, true, 10000000).newHandshaker(fullHttpRequest2);
                    this.mHandShaker = newHandshaker;
                    if (newHandshaker == null) {
                        WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(channelHandlerContext.channel());
                        return;
                    }
                    if (newHandshaker.handshake(channelHandlerContext.channel(), fullHttpRequest2).isSuccess()) {
                        LogUtil.d("握手成功 <" + str2 + "> ");
                    }
                    Channel channel = channelHandlerContext.channel();
                    LogUtil.d("Create Client deviceId <" + str2 + ">, channelId <" + channelId + ">");
                    this.mChannel = channel;
                    this.mDeviceId = str2;
                    channelHandlerContext.pipeline().addLast(new IdleStateHandler(0, 30, 0, TimeUnit.SECONDS));
                    channelHandlerContext.pipeline().addLast(new ServerHeartBeat());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private void handlerMessageArrived(String str, long j, String str2, AbilityMessage abilityMessage, boolean z, QosLevel qosLevel, String str3, StreamType streamType, String str4, String str5) {
        this.handlerListener.onMessageArrived(str, ChannelMessage.newBuilder().setId(str).setAbilityMessage(abilityMessage).setCategory(str2).setRequestId(j).setRetransmission(z).setLinkStrategy(EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE).setQos(qosLevel).setSession(str3).setMessageType(streamType).setDstId(str4).setSrcId(str5).build());
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x02c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handlerServerStream(com.upuphone.runasone.StreamReq r18, io.netty.channel.ChannelHandlerContext r19) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = r18.getDeviceId()
            com.upuphone.runasone.StreamType r10 = r18.getType()
            java.lang.String r0 = r18.getTimeStamp()
            java.lang.String r5 = r18.getCategory()
            long r3 = r18.getReqId()
            long r6 = r18.getRetransmissionLen()
            boolean r8 = r18.getIsRetransmission()
            com.upuphone.runasone.QosLevel r9 = r18.getQos()
            if (r9 != 0) goto L_0x0027
            com.upuphone.runasone.QosLevel r9 = com.upuphone.runasone.QosLevel.QOS_0
            goto L_0x002b
        L_0x0027:
            com.upuphone.runasone.QosLevel r9 = r18.getQos()
        L_0x002b:
            java.lang.String r11 = r18.getSession()
            java.lang.String r11 = com.upuphone.runasone.utils.Utils.parserSession(r11)
            java.lang.String r12 = r18.getDstId()
            java.lang.String r13 = r18.getSrcId()
            java.lang.String r14 = TAG
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r19 = r13
            java.lang.String r13 = " 收到 [Id: "
            r15.append(r13)
            r15.append(r2)
            java.lang.String r13 = "] handlerServerStream getAction:"
            r15.append(r13)
            r15.append(r10)
            java.lang.String r13 = " getReqId:"
            r15.append(r13)
            r15.append(r3)
            java.lang.String r13 = " getTimeStamp:"
            r15.append(r13)
            r15.append(r0)
            java.lang.String r13 = " qosLevel:"
            r15.append(r13)
            r15.append(r9)
            java.lang.String r13 = " session:"
            r15.append(r13)
            r15.append(r11)
            java.lang.String r13 = " dstId:"
            r15.append(r13)
            r15.append(r12)
            java.lang.String r13 = r15.toString()
            com.upuphone.runasone.utils.LogUtil.dPrimary(r14, r13)
            if (r2 != 0) goto L_0x008b
            java.lang.String r0 = "id is null"
            com.upuphone.runasone.utils.LogUtil.e((java.lang.String) r14, (java.lang.Object) r0)
            return
        L_0x008b:
            com.upuphone.runasone.channel.linker.websocket.WsHandlerOps$OnEvent r13 = r1.handlerListener
            if (r13 != 0) goto L_0x0095
            java.lang.String r0 = "handlerListener is null"
            com.upuphone.runasone.utils.LogUtil.e((java.lang.String) r14, (java.lang.Object) r0)
            return
        L_0x0095:
            int[] r13 = com.upuphone.runasone.channel.linker.websocket.server.WsServerHandler.AnonymousClass5.$SwitchMap$com$upuphone$runasone$StreamType
            int r15 = r10.ordinal()
            r13 = r13[r15]
            java.lang.String r15 = "<"
            r16 = r12
            java.lang.String r12 = ">"
            switch(r13) {
                case 1: goto L_0x020b;
                case 2: goto L_0x01f2;
                case 3: goto L_0x01c8;
                case 4: goto L_0x01c8;
                case 5: goto L_0x01c8;
                case 6: goto L_0x01c1;
                case 7: goto L_0x017b;
                case 8: goto L_0x0158;
                case 9: goto L_0x0112;
                case 10: goto L_0x00f4;
                case 11: goto L_0x00d5;
                case 12: goto L_0x00bc;
                default: goto L_0x00a6;
            }
        L_0x00a6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handlerServerStream un-catch: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            com.upuphone.runasone.utils.LogUtil.e((java.lang.String) r14, (java.lang.Object) r0)
            goto L_0x0321
        L_0x00bc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "rev RETRANSMISSION_ACK from <"
            r0.append(r1)
            r0.append(r2)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.upuphone.runasone.utils.LogUtil.d((java.lang.String) r14, (java.lang.Object) r0)
            goto L_0x0321
        L_0x00d5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "rev RETRANSMISSION from <"
            r0.append(r5)
            r0.append(r2)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.upuphone.runasone.utils.LogUtil.d((java.lang.String) r14, (java.lang.Object) r0)
            com.upuphone.runasone.channel.linker.websocket.WsHandlerOps$OnEvent r1 = r1.handlerListener
            r5 = r6
            r1.onRetransmission(r2, r3, r5)
            goto L_0x0321
        L_0x00f4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "rev TEARDOWN_ACK from <"
            r0.append(r3)
            r0.append(r2)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.upuphone.runasone.utils.LogUtil.d((java.lang.String) r14, (java.lang.Object) r0)
            com.upuphone.runasone.channel.linker.websocket.WsHandlerOps$OnEvent r0 = r1.handlerListener
            r0.onTearDownAck(r2)
            goto L_0x0321
        L_0x0112:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "send TEARDOWN_ACK to <"
            r0.append(r3)
            r0.append(r2)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.upuphone.runasone.utils.LogUtil.d(r0)
            com.upuphone.runasone.channel.linker.websocket.WsHandlerOps$OnEvent r0 = r1.handlerListener
            java.lang.String r0 = r0.getSelfId()
            java.lang.String r3 = r1.getSession(r2)
            com.upuphone.runasone.StreamReq r0 = com.upuphone.runasone.channel.bean.stream.StreamBuilder.genTearDownAck(r0, r3)
            r1.sendStreamReq(r2, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "rev TEARDOWN from <"
            r0.append(r3)
            r0.append(r2)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.upuphone.runasone.utils.LogUtil.d((java.lang.String) r14, (java.lang.Object) r0)
            com.upuphone.runasone.channel.linker.websocket.WsHandlerOps$OnEvent r0 = r1.handlerListener
            r0.onTearDown(r2)
            goto L_0x0321
        L_0x0158:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "rev ACK: "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r0 = " reqId:"
            r5.append(r0)
            r5.append(r3)
            java.lang.String r0 = r5.toString()
            com.upuphone.runasone.utils.LogUtil.dPrimary(r14, r0)
            com.upuphone.runasone.channel.linker.websocket.WsHandlerOps$OnEvent r0 = r1.handlerListener
            r0.onAck(r2, r3)
            goto L_0x0321
        L_0x017b:
            java.lang.String r0 = r18.getReqInfo()
            com.google.gson.Gson r3 = new com.google.gson.Gson
            r3.<init>()
            java.lang.Class<com.upuphone.runasone.channel.bean.stream.QosBean> r4 = com.upuphone.runasone.channel.bean.stream.QosBean.class
            java.lang.Object r0 = r3.fromJson((java.lang.String) r0, r4)
            com.upuphone.runasone.channel.bean.stream.QosBean r0 = (com.upuphone.runasone.channel.bean.stream.QosBean) r0
            com.upuphone.runasone.channel.linker.websocket.WsHandlerOps$OnEvent r3 = r1.handlerListener
            int r0 = r0.getQos()
            boolean r0 = r3.onUpdateQos(r2, r0)
            java.util.Map<java.lang.String, java.lang.Long> r3 = r1.timeoutCheck
            long r4 = android.os.SystemClock.elapsedRealtime()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r3.put(r2, r4)
            if (r0 != 0) goto L_0x0321
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r15)
            r0.append(r2)
            java.lang.String r2 = "> invalid, so close this socket"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.upuphone.runasone.utils.LogUtil.d(r0)
            r17.close()
            goto L_0x0321
        L_0x01c1:
            java.lang.String r0 = "WsServer receive CLOSE"
            com.upuphone.runasone.utils.LogUtil.d((java.lang.String) r14, (java.lang.Object) r0)
            goto L_0x0321
        L_0x01c8:
            com.google.protobuf.Any r0 = r18.getAbilityMsg()
            if (r0 == 0) goto L_0x01eb
            if (r5 == 0) goto L_0x01eb
            com.upuphone.runasone.host.core.api.AbilityMessage r6 = new com.upuphone.runasone.host.core.api.AbilityMessage
            com.google.protobuf.ByteString r0 = r18.getBypass()
            byte[] r0 = r0.toByteArray()
            r6.<init>(r0)
            r1 = r17
            r7 = r8
            r8 = r9
            r9 = r11
            r11 = r16
            r12 = r19
            r1.handlerMessageArrived(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12)
            goto L_0x0321
        L_0x01eb:
            java.lang.String r0 = "BYPASS ability msg is null"
            com.upuphone.runasone.utils.LogUtil.e((java.lang.String) r14, (java.lang.Object) r0)
            goto L_0x0321
        L_0x01f2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r15)
            r0.append(r2)
            java.lang.String r1 = "> reply AUTH_SUCCESS"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.upuphone.runasone.utils.LogUtil.d(r0)
            goto L_0x0321
        L_0x020b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "WsServerHandler receive AUTH Request, id <"
            r0.append(r3)
            r0.append(r2)
            java.lang.String r3 = "> getProtocolVersion:"
            r0.append(r3)
            java.lang.String r3 = r18.getProtocolVersion()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.upuphone.runasone.utils.LogUtil.d((java.lang.String) r14, (java.lang.Object) r0)
            java.lang.String r0 = r18.getReqInfo()
            if (r0 == 0) goto L_0x02f7
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x02f7
            com.upuphone.runasone.channel.linker.websocket.WsHandlerOps$OnEvent r3 = r1.handlerListener
            if (r3 == 0) goto L_0x02f7
            com.upuphone.runasone.channel.bean.auth.AuthParameter r3 = r3.getAuthParameter()
            if (r3 != 0) goto L_0x0243
            goto L_0x02f7
        L_0x0243:
            java.lang.String r3 = r18.getIpAddress()
            int r4 = r18.getTcpPort()
            int r5 = r18.getUdpPort()
            com.upuphone.runasone.channel.bean.auth.VpnParameter r6 = new com.upuphone.runasone.channel.bean.auth.VpnParameter
            r6.<init>()
            r6.setIp(r3)
            r6.setTcpPort(r4)
            r6.setUdpPort(r5)
            java.lang.String r3 = "Ws 通道收到客户端请求，鉴权通过"
            com.upuphone.runasone.utils.LogUtil.d((java.lang.String) r14, (java.lang.Object) r3)
            com.upuphone.runasone.channel.linker.websocket.WsHandlerOps$OnEvent r3 = r1.handlerListener
            java.lang.String r3 = r3.getSelfId()
            com.upuphone.runasone.channel.linker.websocket.WsHandlerOps$OnEvent r4 = r1.handlerListener
            com.upuphone.runasone.channel.bean.auth.AuthParameter r4 = r4.getAuthParameter()
            java.lang.String r4 = r4.getAuthInfo()
            com.upuphone.runasone.StreamReq r3 = com.upuphone.runasone.channel.bean.stream.StreamBuilder.genAuth(r3, r4)
            r1.sendStreamReq(r2, r3)
            com.upuphone.runasone.channel.bean.auth.AuthParameter r3 = new com.upuphone.runasone.channel.bean.auth.AuthParameter
            r3.<init>()
            r4 = 0
            r3.setRemoteServer(r4)
            r3.setAuthInfo(r0)
            r3.setVpnParameter(r6)
            java.lang.String r0 = "onAuth Start"
            com.upuphone.runasone.utils.LogUtil.i(r0)
            long r5 = java.lang.System.currentTimeMillis()
        L_0x0291:
            com.upuphone.runasone.channel.linker.websocket.WsHandlerOps$OnEvent r0 = r1.handlerListener
            boolean r0 = r0.onAuth(r2, r3, r1)
            if (r0 != 0) goto L_0x02c1
            r7 = 10
            if (r4 >= r7) goto L_0x02c1
            int r4 = r4 + 1
            java.lang.String r0 = TAG
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "onAuth 对端设备不存在 index="
            r7.append(r8)
            r7.append(r4)
            java.lang.String r7 = r7.toString()
            com.upuphone.runasone.utils.LogUtil.i((java.lang.String) r0, (java.lang.Object) r7)
            r7 = 200(0xc8, double:9.9E-322)
            java.lang.Thread.sleep(r7)     // Catch:{ InterruptedException -> 0x02bb }
            goto L_0x0291
        L_0x02bb:
            r0 = move-exception
            r7 = r0
            r7.printStackTrace()
            goto L_0x0291
        L_0x02c1:
            if (r0 != 0) goto L_0x02cb
            com.upuphone.runasone.channel.linker.websocket.WsHandlerOps$OnEvent r1 = r1.handlerListener
            r3 = 204008(0x31ce8, float:2.85876E-40)
            r1.onError(r2, r3)
        L_0x02cb:
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "onAuth isPassAuth="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " index="
            r2.append(r0)
            r2.append(r4)
            java.lang.String r0 = " time="
            r2.append(r0)
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r5
            r2.append(r3)
            java.lang.String r0 = r2.toString()
            com.upuphone.runasone.utils.LogUtil.i((java.lang.String) r1, (java.lang.Object) r0)
            goto L_0x0321
        L_0x02f7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Ws 通道收到客户端请求，鉴权失败 AUTH FAIL, info:"
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " mAuthParameter:"
            r3.append(r0)
            com.upuphone.runasone.channel.linker.websocket.WsHandlerOps$OnEvent r0 = r1.handlerListener
            com.upuphone.runasone.channel.bean.auth.AuthParameter r0 = r0.getAuthParameter()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.upuphone.runasone.utils.LogUtil.e(r0)
            com.upuphone.runasone.channel.linker.websocket.WsHandlerOps$OnEvent r0 = r1.handlerListener
            r1 = 204004(0x31ce4, float:2.8587E-40)
            r0.onError(r2, r1)
        L_0x0321:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.linker.websocket.server.WsServerHandler.handlerServerStream(com.upuphone.runasone.StreamReq, io.netty.channel.ChannelHandlerContext):void");
    }

    private void handlerTextMessage(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) {
        StDevice stDevice;
        String str = TAG;
        LogUtil.dPrimary(str, " 收到Text信息 channel id:" + getChannelId(channelHandlerContext) + " source:" + channelHandlerContext.channel().remoteAddress());
        TextMessage textMessage = (TextMessage) JsonUtil.json2object(textWebSocketFrame.text(), new TypeToken<TextMessage>() {
        });
        if (textMessage != null) {
            if (textMessage.getType() != 1) {
                LogUtil.dPrimary(str, " 收到Text信息 无法识别");
            } else if (StarrynetApiImpl.getInstance().getOwnDevice().getTerminalType() == 7 && (stDevice = (StDevice) JsonUtil.json2object(textMessage.getMessage(), new TypeToken<StDevice>() {
            })) != null && !LanDirectConnector.getInstance().finishConnectGo(channelHandlerContext.channel(), stDevice)) {
                LogUtil.i("无法finishConnectGo，关闭掉");
                channelHandlerContext.channel().close();
            }
        }
    }

    private void handlerWebSocketFrame(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame) {
        if (webSocketFrame instanceof CloseWebSocketFrame) {
            LogUtil.e(TAG, (Object) "CloseWebSocketFrame");
            this.mHandShaker.close(channelHandlerContext.channel(), (CloseWebSocketFrame) webSocketFrame.retain());
        } else if (webSocketFrame instanceof PingWebSocketFrame) {
            String str = TAG;
            LogUtil.d(str, (Object) "PingWebSocketFrame channel id:" + getChannelId(channelHandlerContext) + " source:" + channelHandlerContext.channel().remoteAddress());
            channelHandlerContext.channel().write(new PongWebSocketFrame(webSocketFrame.content().retain()));
        } else if (webSocketFrame instanceof BinaryWebSocketFrame) {
            String str2 = TAG;
            LogUtil.dPrimary(str2, " 收到二进制消息 channel id:" + getChannelId(channelHandlerContext) + " source:" + channelHandlerContext.channel().remoteAddress() + " readableBytes:" + webSocketFrame.content().readableBytes());
            dispatch(channelHandlerContext, (BinaryWebSocketFrame) webSocketFrame);
        } else {
            boolean z = webSocketFrame instanceof TextWebSocketFrame;
            if (z) {
                handlerTextMessage(channelHandlerContext, (TextWebSocketFrame) webSocketFrame);
            }
            if (!z) {
                throw new UnsupportedOperationException(String.format("%s frame types not supported", new Object[]{webSocketFrame.getClass().getName()}));
            }
        }
    }

    private static void sendHttpResponse(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest, FullHttpResponse fullHttpResponse) {
        if (fullHttpResponse.status().code() != 200) {
            ByteBuf copiedBuffer = Unpooled.copiedBuffer((CharSequence) fullHttpResponse.status().toString(), CharsetUtil.UTF_8);
            fullHttpResponse.content().writeBytes(copiedBuffer);
            copiedBuffer.release();
            HttpUtil.setContentLength(fullHttpResponse, (long) fullHttpResponse.content().readableBytes());
        }
        ChannelFuture writeAndFlush = channelHandlerContext.channel().writeAndFlush(fullHttpResponse);
        if (!HttpUtil.isKeepAlive(fullHttpRequest) || fullHttpResponse.status().code() != 200) {
            writeAndFlush.addListener(ChannelFutureListener.CLOSE);
        }
    }

    private void sendStreamReq(String str, final StreamReq streamReq) {
        Channel channel;
        synchronized (this) {
            channel = this.mChannel;
        }
        if (channel != null) {
            byte[] byteArray = streamReq.toByteArray();
            String str2 = TAG;
            LogUtil.dPrimary(str2, " 发送 [Id: " + str + "] binary message, length:" + byteArray.length + " Bytes");
            ByteBuf ioBuffer = ByteBufAllocator.DEFAULT.ioBuffer();
            ioBuffer.writeBytes(byteArray);
            channel.writeAndFlush(new BinaryWebSocketFrame(ioBuffer)).addListeners(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        String access$200 = WsServerHandler.TAG;
                        LogUtil.dPrimary(access$200, "WsServerHandler send success " + streamReq.getTimeStamp());
                        return;
                    }
                    String access$2002 = WsServerHandler.TAG;
                    LogUtil.e(access$2002, (Object) "WsServerHandler send failed " + streamReq.getTimeStamp() + " cause:" + channelFuture.cause().getMessage());
                }
            });
        }
    }

    public void channelRead0(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj instanceof FullHttpRequest) {
            handlerHttpRequest(channelHandlerContext, (FullHttpRequest) obj);
        } else if (obj instanceof WebSocketFrame) {
            handlerWebSocketFrame(channelHandlerContext, (WebSocketFrame) obj);
        }
    }

    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.flush();
    }

    public void close() {
        Channel channel;
        synchronized (this) {
            channel = this.mChannel;
        }
        if (channel != null && channel.isActive()) {
            channel.close();
        }
        this.timeoutCheck.clear();
        this.timeOutHandler.removeCallbacksAndMessages((Object) null);
        this.handlerThread.quitSafely();
        String str = TAG;
        LogUtil.i(str, (Object) "Device Channel <" + this.mDeviceId + "> close!!!");
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        th.printStackTrace();
        String str = TAG;
        LogUtil.e(str, (Object) "exceptionCaught Channel Id:" + getChannelId(channelHandlerContext) + " cause:" + th);
        channelHandlerContext.close();
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        String str = TAG;
        LogUtil.d(str, (Object) " 收到 [" + channelHandlerContext.channel().remoteAddress() + "] 握手请求");
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        LogUtil.d(TAG, (Object) "handlerRemoved");
        closeChannelByCtx(channelHandlerContext, Constants.ChannelErrorCode.ERROR_RPC_LINK_ERROR);
    }

    public boolean notifyTearDown(String str, StreamReq streamReq) {
        if (this.handlerListener != null) {
            sendStreamReq(str, streamReq);
            return true;
        }
        LogUtil.e(TAG, (Object) "handlerListener is null");
        return false;
    }

    public boolean output(String str, StreamReq streamReq) {
        Channel channel;
        synchronized (this) {
            channel = this.mChannel;
        }
        if (channel != null) {
            String str2 = TAG;
            LogUtil.dPrimary(str2, "output timestamp :" + streamReq.getTimeStamp() + " reqId:" + streamReq.getReqId());
            sendStreamReq(str, streamReq);
            return true;
        }
        LogUtil.e("output fail <" + str + "> !!!");
        return false;
    }

    public boolean sendStream(String str, StreamReq streamReq) {
        if (this.handlerListener != null) {
            sendStreamReq(str, streamReq);
            return true;
        }
        LogUtil.e(TAG, (Object) "handlerListener is null");
        return false;
    }

    public void setOnEventListener(WsHandlerOps.OnEvent onEvent) {
        this.handlerListener = onEvent;
    }

    public synchronized void setSession(String str, String str2) {
        try {
            if (TextUtils.equals(this.mDeviceId, str)) {
                this.mSession = str2;
            } else {
                LogUtil.e("WsServerHandler Set Session Error: " + this.mDeviceId + " " + str);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
