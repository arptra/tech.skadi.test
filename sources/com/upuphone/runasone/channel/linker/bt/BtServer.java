package com.upuphone.runasone.channel.linker.bt;

import com.google.protobuf.InvalidProtocolBufferException;
import com.honey.account.q5.a;
import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.StreamReq;
import com.upuphone.runasone.StreamType;
import com.upuphone.runasone.ability.Constant;
import com.upuphone.runasone.channel.bean.auth.AuthParameter;
import com.upuphone.runasone.channel.bean.stream.StreamBuilder;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.DeviceManagerImpl;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.host.core.api.myconst.TlvCodeConst;
import com.upuphone.runasone.host.core.api.util.TlvBox;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.CommonThreadPool;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.TrackHelper;
import com.upuphone.runasone.utils.Utils;
import com.upuphone.starrynet.api.bean.StMessage;
import com.upuphone.starrynet.api.message.IReceiveMessageListener;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class BtServer {
    private static final int INTERVAL_AUTH = 2000;
    private static final int MAX_TRY_AUTH = 2;
    private static final int MAX_WAIT_TIME_OUT = 3000;
    private static final String REGISTER_BLE_MESSAGE = "register_ble_message";
    private static final String REGISTER_SPP_MESSAGE = "register_spp_message";
    /* access modifiers changed from: private */
    public static final String TAG = "BtServer";
    private static final byte TAG_PB = 2;
    private static final byte TAG_TLV = 1;
    private static BtServer mBtInstance = new BtServer(EnumLinker.TYPE_LINK_BT);
    private static BtServer mSppInstance = new BtServer(EnumLinker.TYPE_LINK_SPP);
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, Boolean> authTransitionMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Boolean> bAuthRunningMap = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public boolean bServer = false;
    private boolean bStart = false;
    /* access modifiers changed from: private */
    public EnumLinker linker;
    private IReceiveMessageListener listener = new IReceiveMessageListener() {
        public void receiveMessage(StMessage stMessage) {
            if ((BtServer.this.linker == EnumLinker.TYPE_LINK_BT && stMessage.getTargetChannel() == 1) || (BtServer.this.linker == EnumLinker.TYPE_LINK_SPP && stMessage.getTargetChannel() == 32)) {
                byte[] content = stMessage.getContent();
                if (content == null) {
                    LogUtil.e("BUNDLE_KEY_DATA is null !");
                    return;
                }
                int characterCategory = stMessage.getCharacterCategory();
                boolean z = false;
                if (characterCategory != 0) {
                    byte b = content[0];
                    content = BtServer.this.parse(content);
                    if (characterCategory == 2) {
                        z = true;
                    }
                    if (b == 1) {
                        TlvBox tlvBox = new TlvBox(content);
                        String deviceId = stMessage.getDeviceId();
                        String access$100 = BtServer.this.mSelfId;
                        byte[] bytes = tlvBox.getBytes(Byte.valueOf(TlvCodeConst.payload));
                        String str = Constant.MAPPING_TO_ABILITY.get(tlvBox.getByte(Byte.valueOf(TlvCodeConst.category)));
                        if (str == null) {
                            LogUtil.ePrimary(BtServer.TAG, " receive category is null ");
                        }
                        QosLevel qosLevel = QosLevel.QOS_0;
                        if (stMessage.isUrgentMessage()) {
                            qosLevel = QosLevel.QOS_3;
                        }
                        ChannelMessage build = ChannelMessage.newBuilder().setId(deviceId).setAbilityMessage(new AbilityMessage(bytes, AbilityMessage.MessageType.AIR)).setLinkStrategy(BtServer.this.linker == EnumLinker.TYPE_LINK_SPP ? EnumLinkStrategy.STRATEGY_BALANCE : EnumLinkStrategy.STRATEGY_DEFAULT).setCategory(str).setDstId(access$100).setQos(qosLevel).build();
                        BtServerListener btServerListener = (BtServerListener) BtServer.this.mListenerHashMap.get(deviceId);
                        if (btServerListener != null) {
                            btServerListener.input(build);
                            return;
                        }
                        LogUtil.e(BtServer.TAG, (Object) "BtServerListener of senderId=< " + deviceId + "> is null");
                        return;
                    }
                }
                boolean z2 = z;
                try {
                    StreamReq parseFrom = StreamReq.parseFrom(content);
                    String deviceId2 = parseFrom.getDeviceId();
                    if (deviceId2 == null) {
                        LogUtil.e("get sender id error !");
                        return;
                    }
                    String category = parseFrom.getCategory();
                    StreamType type = parseFrom.getType();
                    String protocolVersion = parseFrom.getProtocolVersion();
                    String timeStamp = parseFrom.getTimeStamp();
                    byte[] byteArray = parseFrom.getBypass().toByteArray();
                    String reqInfo = parseFrom.getReqInfo();
                    long reqId = parseFrom.getReqId();
                    long retransmissionLen = parseFrom.getRetransmissionLen();
                    boolean isRetransmission = parseFrom.getIsRetransmission();
                    String parserSession = Utils.parserSession(parseFrom.getSession());
                    QosLevel qos = parseFrom.getQos() == null ? QosLevel.QOS_0 : parseFrom.getQos();
                    if (stMessage.isUrgentMessage()) {
                        qos = QosLevel.QOS_3;
                    }
                    boolean z3 = z2;
                    QosLevel qosLevel2 = qos;
                    String dstId = parseFrom.getDstId();
                    String str2 = protocolVersion;
                    if (dstId == null) {
                        dstId = BtServer.this.mSelfId;
                    }
                    String str3 = dstId;
                    String str4 = reqInfo;
                    String srcId = parseFrom.getSrcId();
                    StreamReq streamReq = parseFrom;
                    if (BtServer.this.mListenerHashMap.containsKey(deviceId2)) {
                        String access$200 = BtServer.TAG;
                        String str5 = srcId;
                        StringBuilder sb = new StringBuilder();
                        String str6 = str3;
                        sb.append("receiveMessage getDeviceId:");
                        sb.append(deviceId2);
                        sb.append(" timeStamp:");
                        sb.append(timeStamp);
                        sb.append(" getCategory:");
                        sb.append(category);
                        sb.append(" getType:");
                        sb.append(type);
                        sb.append(" session:");
                        sb.append(parserSession);
                        sb.append(" qosLevel:");
                        sb.append(qosLevel2);
                        LogUtil.dPrimary(access$200, sb.toString());
                        long j = 0;
                        switch (AnonymousClass2.$SwitchMap$com$upuphone$runasone$StreamType[type.ordinal()]) {
                            case 1:
                                StarryDevice findConnectDevice = DeviceManagerImpl.getInstance().findConnectDevice(deviceId2);
                                findConnectDevice.getStarryDevice().getIdentifier();
                                if (str4 == null || str4.isEmpty()) {
                                    LogUtil.e("BLE通道鉴权失败 AUTH FAIL <" + findConnectDevice.getId() + "> info is null");
                                    return;
                                } else if (BtServer.this.bServer) {
                                    BtServer btServer = BtServer.this;
                                    btServer.sendAuthRequest(deviceId2, btServer.mSelfId, findConnectDevice.getStarryDevice().getIdentifier());
                                    LogUtil.d("收到客户端握手请求 BT Server send Auth response >>>>> ");
                                    return;
                                } else {
                                    BtServer.this.stopAuth(deviceId2);
                                    Long l = (Long) BtServer.this.mAuthSysTimeMap.get(deviceId2);
                                    if (l != null) {
                                        j = l.longValue();
                                    }
                                    long currentTimeMillis = (System.currentTimeMillis() - ((System.currentTimeMillis() - j) / 2)) - Utils.getSysTime(timeStamp);
                                    LogUtil.d("对端系统时钟误差：" + currentTimeMillis + "ms");
                                    LogUtil.d("BT Client send Auth Success >>>>> ");
                                    BtServer btServer2 = BtServer.this;
                                    String str7 = deviceId2;
                                    btServer2.sendAuthSuccess(str7, btServer2.mSelfId, findConnectDevice.getStarryDevice().getIdentifier(), currentTimeMillis);
                                    BtServer.this.authTransitionMap.remove(deviceId2);
                                    BtServer.this.notifyAuthSuccess(str7, str4, currentTimeMillis, str2, z3);
                                    return;
                                }
                            case 2:
                                if (BtServer.this.bServer) {
                                    BtServer.this.authTransitionMap.remove(deviceId2);
                                    BtServer.this.notifyAuthSuccess(deviceId2, str4, 0 - streamReq.getDeltaSysTime(), str2, z3);
                                    return;
                                }
                                LogUtil.e("BT Client 无需处理 AUTH_SUCCESS");
                                return;
                            case 3:
                            case 4:
                            case 5:
                                ChannelMessage build2 = ChannelMessage.newBuilder().setId(deviceId2).setCategory(category).setAbilityMessage(new AbilityMessage(byteArray)).setRequestId(reqId).setRetransmission(isRetransmission).setQos(qosLevel2).setSession(parserSession).setLinkStrategy(BtServer.this.linker == EnumLinker.TYPE_LINK_SPP ? EnumLinkStrategy.STRATEGY_BALANCE : EnumLinkStrategy.STRATEGY_DEFAULT).setMessageType(type).setDstId(str6).setSrcId(str5).build();
                                BtServerListener btServerListener2 = (BtServerListener) BtServer.this.mListenerHashMap.get(deviceId2);
                                if (btServerListener2 != null) {
                                    btServerListener2.input(build2);
                                    return;
                                }
                                return;
                            case 6:
                                BtServerListener btServerListener3 = (BtServerListener) BtServer.this.mListenerHashMap.get(deviceId2);
                                if (btServerListener3 != null) {
                                    btServerListener3.onRetransmission(reqId, retransmissionLen);
                                    return;
                                }
                                LogUtil.e(BtServer.TAG, (Object) "device <" + deviceId2 + "> had unlink, so not onRetransmission");
                                return;
                            default:
                                LogUtil.e("un-catch type:" + type);
                                return;
                        }
                    } else {
                        LogUtil.e("the BT device <" + deviceId2 + "> requestId:" + reqId + "is un-valid, reject !!!");
                    }
                } catch (InvalidProtocolBufferException e) {
                    e.printStackTrace();
                }
            } else {
                LogUtil.d("receiveMessage linker=" + BtServer.this.linker + " stMessage.targetChannel=" + stMessage.getTargetChannel());
            }
        }
    };
    private ConcurrentHashMap<String, AuthParameter> mAuthParameterMap = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, Long> mAuthSysTimeMap = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, BtServerListener> mListenerHashMap = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public String mSelfId;
    private final Object mWaitLock = new Object();
    private ConcurrentHashMap<String, String> sessionMap = new ConcurrentHashMap<>();

    /* renamed from: com.upuphone.runasone.channel.linker.bt.BtServer$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$upuphone$runasone$StreamType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
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
                com.upuphone.runasone.StreamType r1 = com.upuphone.runasone.StreamType.RETRANSMISSION     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.linker.bt.BtServer.AnonymousClass2.<clinit>():void");
        }
    }

    private BtServer(EnumLinker enumLinker) {
        this.linker = enumLinker;
    }

    private void awaitAction() {
        synchronized (this.mWaitLock) {
            try {
                LogUtil.dPrimary(TAG, "awaitAction");
                this.mWaitLock.wait(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                String str = TAG;
                LogUtil.e(str, (Object) "waitLock: " + e);
            }
        }
    }

    public static BtServer getBtServer() {
        return mBtInstance;
    }

    public static BtServer getSppServer() {
        return mSppInstance;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startAuth$0(String str, byte[] bArr) {
        Boolean bool = this.bAuthRunningMap.get(str);
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        int i = 2;
        while (booleanValue) {
            try {
                this.mAuthSysTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
                sendAuthRequest(str, this.mSelfId, bArr);
                if (i > 0) {
                    i--;
                    this.authTransitionMap.remove(str);
                }
                Thread.sleep(AssistantConstants.TIMEOUT_VAD_MUTE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Boolean bool2 = this.bAuthRunningMap.get(str);
            booleanValue = bool2 == null ? false : bool2.booleanValue();
        }
    }

    private void notifyActionReady() {
        synchronized (this.mWaitLock) {
            this.mWaitLock.notifyAll();
            LogUtil.dPrimary(TAG, "notifyActionReady");
        }
    }

    /* access modifiers changed from: private */
    public void notifyAuthSuccess(String str, String str2, long j, String str3, boolean z) {
        LogUtil.d(this.linker + "通道鉴权通过，AUTH PASS --- <" + str + "> getProtocolVersion:" + str3 + " bServer:" + this.bServer);
        AuthParameter authParameter = new AuthParameter();
        authParameter.setRemoteServer(this.bServer ^ true);
        authParameter.setAuthInfo(str2);
        authParameter.setDeltaSysTime(j);
        authParameter.setTlv(z);
        BtServerListener btServerListener = this.mListenerHashMap.get(str);
        if (btServerListener != null) {
            btServerListener.onAuth(str, authParameter);
            return;
        }
        String str4 = TAG;
        LogUtil.e(str4, (Object) "device <" + str + "> had unlink, so not notifyAuthSuccess");
    }

    /* access modifiers changed from: private */
    public void sendAuthRequest(String str, String str2, byte[] bArr) {
        AuthParameter authParameter = this.mAuthParameterMap.get(str);
        if (authParameter == null) {
            stopAuth(str);
            String str3 = TAG;
            LogUtil.e(str3, (Object) "device <" + str + "> had unlink, so not sendAuthRequest");
            return;
        }
        boolean sendMsg = sendMsg(bArr, StreamBuilder.genAuth(str2, authParameter.getAuthInfo()).toByteArray(), (byte) 2, (String) null, false);
        byte terminalType = StarrynetApiImpl.getInstance().getOwnDevice().getTerminalType();
        if (terminalType == 1 || terminalType == 4) {
            TrackHelper.runAsOneAuthState(str2, authParameter.getAuthInfo(), (byte) 2, sendMsg);
        }
    }

    /* access modifiers changed from: private */
    public void sendAuthSuccess(String str, String str2, byte[] bArr, long j) {
        AuthParameter authParameter = this.mAuthParameterMap.get(str);
        if (authParameter == null) {
            stopAuth(str);
            String str3 = TAG;
            LogUtil.e(str3, (Object) "device <" + str + "> had unlink, so not sendAuthSuccess");
            return;
        }
        sendMsg(bArr, StreamBuilder.genAuthSuccess(str2, authParameter.getAuthInfo(), j).toByteArray(), (byte) 2, (String) null, false);
    }

    private boolean sendMsg(byte[] bArr, byte[] bArr2, byte b, String str, boolean z) {
        StMessage stMessage;
        if (StarrynetApiImpl.getInstance().getCharacterCategoryByIdt(bArr) == 0) {
            stMessage = new StMessage(bArr, (String) null, bArr2, z);
        } else {
            StMessage stMessage2 = new StMessage(bArr, (String) null, getResultArray(bArr2, b), z);
            stMessage2.setDeviceId(str);
            stMessage = stMessage2;
        }
        if (this.linker == EnumLinker.TYPE_LINK_BT) {
            stMessage.setTargetChannel(1);
        } else {
            stMessage.setTargetChannel(32);
        }
        int sendMessage = StarrynetApiImpl.getInstance().sendMessage(stMessage);
        if (sendMessage == 0) {
            LogUtil.iPrimary(TAG, "sendMsg Success");
        } else {
            LogUtil.ePrimary(TAG, "sendMsg Fail");
        }
        return sendMessage == 0;
    }

    private void startAuth(String str, byte[] bArr) {
        this.bAuthRunningMap.put(str, Boolean.TRUE);
        CommonThreadPool.execute(new a(this, str, bArr));
    }

    /* access modifiers changed from: private */
    public void stopAuth(String str) {
        this.bAuthRunningMap.remove(str);
    }

    public byte[] getResultArray(byte[] bArr, byte b) {
        byte[] bArr2 = new byte[(bArr.length + 1)];
        bArr2[0] = b;
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        return bArr2;
    }

    public String getSession(String str) {
        return this.sessionMap.containsKey(str) ? this.sessionMap.get(str) : Constants.INVALID_SESSION;
    }

    public boolean isAuthTransition(String str) {
        Boolean bool = this.authTransitionMap.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public synchronized void link(String str, String str2, byte[] bArr, boolean z, AuthParameter authParameter, BtServerListener btServerListener) throws IOException {
        try {
            String str3 = TAG;
            LogUtil.d(str3, (Object) "link ---- " + str + " bServer: " + z);
            if (!this.bStart) {
                startup();
                this.bStart = true;
                this.bServer = z;
                this.mSelfId = str2;
            }
            this.mAuthParameterMap.put(str, authParameter);
            this.mListenerHashMap.put(str, btServerListener);
            this.authTransitionMap.put(str, Boolean.TRUE);
            if (!this.bServer) {
                startAuth(str, bArr);
                LogUtil.d(this.linker + "通道发起鉴权 BT Client send Auth request >>>>> ");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean output(String str, String str2, byte[] bArr, byte[] bArr2, boolean z, boolean z2) {
        if (this.mListenerHashMap.containsKey(str2)) {
            return sendMsg(bArr, bArr2, z ? (byte) 1 : 2, str2, z2);
        }
        LogUtil.e("the BT device <" + str2 + "> is un-valid, reject !!!");
        return false;
    }

    public byte[] parse(byte[] bArr) {
        byte b = bArr[0];
        byte[] bArr2 = new byte[(bArr.length - 1)];
        System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
        return bArr2;
    }

    public void removeAuthTransition(String str) {
        this.authTransitionMap.remove(str);
    }

    public void setSession(String str, String str2) {
        this.sessionMap.put(str, str2);
    }

    public void startup() {
        if (this.linker == EnumLinker.TYPE_LINK_BT) {
            StarrynetApiImpl.getInstance().registerReceiveMessageListener(REGISTER_BLE_MESSAGE, this.listener);
        } else {
            StarrynetApiImpl.getInstance().registerReceiveMessageListener(REGISTER_SPP_MESSAGE, this.listener);
        }
    }

    public boolean triggerRetransmission(String str, String str2, byte[] bArr, long j, long j2) {
        return sendMsg(bArr, StreamBuilder.genRetransmission(str, j, j2, getSession(str2)).toByteArray(), (byte) 2, (String) null, false);
    }

    public synchronized void unlink(String str) {
        try {
            String str2 = TAG;
            LogUtil.d(str2, (Object) "unlink ---- " + str);
            this.authTransitionMap.remove(str);
            if (!this.bServer) {
                stopAuth(str);
            }
            this.bAuthRunningMap.remove(str);
            this.mAuthParameterMap.remove(str);
            this.mAuthSysTimeMap.remove(str);
            if (this.mListenerHashMap.containsKey(str)) {
                this.mListenerHashMap.get(str).onClose();
                this.mListenerHashMap.remove(str);
            }
            if (this.sessionMap.containsKey(str)) {
                this.sessionMap.remove(str);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void startup(StMessage stMessage) {
        if (this.linker == EnumLinker.TYPE_LINK_BT) {
            StarrynetApiImpl.getInstance().registerReceiveMessageListener(REGISTER_BLE_MESSAGE, this.listener);
        } else {
            StarrynetApiImpl.getInstance().registerReceiveMessageListener(REGISTER_SPP_MESSAGE, this.listener);
        }
        if (stMessage != null) {
            this.listener.receiveMessage(stMessage);
        }
    }
}
