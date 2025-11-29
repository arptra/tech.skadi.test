package com.upuphone.runasone.channel;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.here.posclient.PositionEstimate;
import com.honey.account.p5.a;
import com.honey.account.p5.b;
import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.StreamType;
import com.upuphone.runasone.ability.AbilityRouterImpl;
import com.upuphone.runasone.ability.EnumAbility;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.bean.auth.AbilityAttributes;
import com.upuphone.runasone.channel.bean.auth.AuthBean;
import com.upuphone.runasone.channel.bean.auth.AuthParameter;
import com.upuphone.runasone.channel.bean.auth.VpnParameter;
import com.upuphone.runasone.channel.bean.stream.AckArg;
import com.upuphone.runasone.channel.bean.stream.LinkerStatus;
import com.upuphone.runasone.channel.bean.stream.RetransmissionArg;
import com.upuphone.runasone.channel.bean.virtual.ChannelType;
import com.upuphone.runasone.channel.core.InputCore;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.channel.linker.ILinker;
import com.upuphone.runasone.channel.linker.LinkerFactory;
import com.upuphone.runasone.channel.proxy.config.VpnConfigUtils;
import com.upuphone.runasone.channel.virtual.IVirtualChannel;
import com.upuphone.runasone.channel.virtual.VirtualDeviceNotify;
import com.upuphone.runasone.connection.LanDirectConnector;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.DeviceManagerImpl;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.message.ChannelMessageCache;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.CommonThreadPool;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.TrackHelper;
import com.upuphone.runasone.utils.Utils;
import com.upuphone.starrynet.api.IPublisher;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.time.DurationKt;

public class ChannelImpl implements IChannel, ILinker.LinkerStreamObserver {
    private static final int AUTH_TIMEOUT = 5000;
    private static final int AUTH_TIMEOUT_WHAT = 1;
    private static final int EVENT_ACK = 8195;
    private static final int EVENT_CACHE_CLEANER = 8193;
    private static final int EVENT_CHANGE_CHANNEL = 8209;
    private static final int EVENT_RETRANSMISSION = 8194;
    private static final int INPUT_LOST_EXPIRED_TIME = 10000;
    private static final int MAX_BT_PACKET = 100000;
    private static final int MAX_CACHE_LENGTH = 64;
    /* access modifiers changed from: private */
    public static final String TAG = "ChannelImpl";
    private static final int THRESHOLD_SCAN_CACHE = 2000;
    private CopyOnWriteArrayList<String> activeAbilityList;
    private CopyOnWriteArrayList<EnumAbility> activeEnumAbilityList;
    private boolean bCacheCleaner = false;
    private boolean bEnableRetransmission = true;
    private boolean bHighIoStrategy = false;
    /* access modifiers changed from: private */
    public ChannelMessage changeChannelMessage = null;
    private String coreCommit = Constants.INVALID_STR;
    private long deltaSysTime = 0;
    private Handler handlerTimeout = new Handler(Looper.getMainLooper()) {
        public void handleMessage(@NonNull Message message) {
            int i;
            super.handleMessage(message);
            if (message.what == EnumLinker.TYPE_LINK_BT.ordinal()) {
                i = 1;
            } else if (message.what == EnumLinker.TYPE_LINK_WS.ordinal()) {
                i = 2;
            } else {
                return;
            }
            Long l = (Long) ChannelImpl.this.startTimeMap.remove((EnumLinker) message.obj);
            if (l != null) {
                TrackHelper.recordConnectTime(String.valueOf(i), SystemClock.elapsedRealtime() - l.longValue(), 2);
            }
        }
    };
    private long inputTotalSize;
    private boolean isSendTlv;
    private long lastReceiveRequestId = 0;
    private ConcurrentHashMap<EnumLinker, LinkerStatus> linkingLinker = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<EnumLinker, LinkerStatus> linkupLinker = new ConcurrentHashMap<>();
    private CopyOnWriteArrayList<String> localAbilityList;
    private AuthBean localAuthBean;
    private AuthParameter localAuthPara;
    private String localSession;
    private int localWeight = 0;
    private IChannel.BiObserver mBiObserver;
    private ChannelActor mChannelActor;
    private ChannelActor mChannelSyncActor;
    private String mCreateTime;
    private StarryDevice mDevice;
    /* access modifiers changed from: private */
    public String mDeviceId;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<EnumLinker, ILinker> mLinkerMap = new ConcurrentHashMap<>();
    private IChannel.LinkerStateObserver mLinkerStateObserver;
    private final Random mLocalWeightRandom = new SecureRandom();
    private Map<Long, Long> mLostInputBuffer = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public ChannelMessageCache mOutputBuffer = new ChannelMessageCache("Output", 64, PositionEstimate.Value.WLAN_AP_COUNT, 20000);
    private long outputTotalSize;
    private long packetInput;
    private long packetLoss;
    private long packetOutput;
    private long packetRetransmission;
    private CopyOnWriteArrayList<String> remoteAbilityList;
    private AuthBean remoteAuthBean;
    private AuthParameter remoteAuthPara;
    private long sendRequestId = 0;
    private String session;
    /* access modifiers changed from: private */
    public Map<EnumLinker, Long> startTimeMap = new EnumMap(EnumLinker.class);
    private String version = Constants.INVALID_STR;
    private Handler workHandler;

    public ChannelImpl(StarryDevice starryDevice) {
        this.mDevice = starryDevice;
        this.mDeviceId = starryDevice.getId();
        ArrayList<EnumLinker> arrayList = new ArrayList<>();
        arrayList.add(EnumLinker.TYPE_LINK_BT);
        arrayList.add(EnumLinker.TYPE_LINK_WS);
        arrayList.add(EnumLinker.TYPE_LINK_SIMPLIFIED);
        arrayList.add(EnumLinker.TYPE_LINK_SPP);
        for (EnumLinker enumLinker : arrayList) {
            ILinker instance = LinkerFactory.getInstance(enumLinker);
            if (instance != null) {
                instance.startup(getDeviceId(), this);
                this.mLinkerMap.put(enumLinker, instance);
                String str = TAG;
                LogUtil.d(str, (Object) "Linker <" + enumLinker + "> alloc success");
            } else {
                String str2 = TAG;
                LogUtil.e(str2, (Object) "Linker <" + enumLinker + "> alloc fail !!!");
            }
        }
        this.mCreateTime = DateFormat.getDateTimeInstance().format(new Date());
        setLocalAuthPara();
        ChannelActor channelActor = new ChannelActor();
        this.mChannelActor = channelActor;
        channelActor.installInputPort(new IChannelActor() {
            public boolean output(ChannelMessage channelMessage) {
                return ChannelImpl.this.outputToRemote(channelMessage, false);
            }
        }, this.mDeviceId);
        ChannelActor channelActor2 = new ChannelActor();
        this.mChannelSyncActor = channelActor2;
        AnonymousClass3 r0 = new IChannelActor() {
            public boolean output(ChannelMessage channelMessage) {
                return ChannelImpl.this.outputToRemoteSync(channelMessage);
            }
        };
        channelActor2.installInputPort(r0, this.mDeviceId + "-Sync");
        startCacheCleaner();
    }

    private void closeLinker(EnumLinker enumLinker) {
        if (this.linkingLinker.containsKey(enumLinker) || this.linkupLinker.containsKey(enumLinker)) {
            this.linkingLinker.remove(enumLinker);
            if (getDevice().isConnectByMdns() && getDevice().getStarryDevice() != null && enumLinker == EnumLinker.TYPE_LINK_WS) {
                LanDirectConnector.getInstance().finishDisConnect(getDevice().getStarryDevice());
            }
        }
        if (this.linkupLinker.containsKey(enumLinker)) {
            this.linkupLinker.remove(enumLinker);
            notifyDeviceDown(enumLinker);
        }
        if (this.mLinkerMap.containsKey(enumLinker)) {
            this.mLinkerMap.get(enumLinker).close();
        }
    }

    private void commitToLostInputCache(long j, long j2) {
        for (long j3 = 0; j3 < j2; j3++) {
            this.mLostInputBuffer.put(Long.valueOf(j + j3), Long.valueOf(System.currentTimeMillis()));
        }
    }

    private void commitToOutputCache(ChannelMessage channelMessage) {
        ChannelMessageCache channelMessageCache = this.mOutputBuffer;
        if (channelMessageCache != null && channelMessage != null) {
            channelMessageCache.put(Long.valueOf(channelMessage.getRequestId()), channelMessage);
        }
    }

    /* access modifiers changed from: private */
    public void deleteFromCache(ChannelMessageCache channelMessageCache) {
        if (channelMessageCache != null) {
            channelMessageCache.clearExpiredMessage();
        }
    }

    /* access modifiers changed from: private */
    public void deleteFromLostCache() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Iterator<Map.Entry<Long, Long>> it = this.mLostInputBuffer.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                Long l = (Long) next.getValue();
                if (l != null && currentTimeMillis - l.longValue() > 10000) {
                    it.remove();
                    LogUtil.e("ChannelMessageCache", (Object) "清理丢失包缓存reqId=" + next.getKey());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean filterInput(ChannelMessage channelMessage, EnumLinker enumLinker) {
        if (StreamType.ACTION == channelMessage.getMessageType() || StreamType.BRIDGE == channelMessage.getMessageType()) {
            return InputCore.getInstance().filterInput(channelMessage, this);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public ChannelMessage findMessageByReqId(ChannelMessageCache channelMessageCache, long j) {
        if (channelMessageCache.isEmpty()) {
            return null;
        }
        return (ChannelMessage) channelMessageCache.get(Long.valueOf(j));
    }

    private void generalEnumAbilityList() {
        this.activeEnumAbilityList.clear();
        for (int i = 0; i < this.activeAbilityList.size(); i++) {
            String str = this.activeAbilityList.get(i);
            EnumAbility enumType = getEnumType(str);
            if (enumType != null) {
                this.activeEnumAbilityList.add(enumType);
            } else {
                LogUtil.e("unknown key:" + str);
            }
        }
    }

    private String generalSessionByStr(String str) {
        return str.substring(str.length() - 4);
    }

    private String getDeviceId() {
        return this.mDeviceId;
    }

    private EnumAbility getEnumType(String str) {
        EnumAbility[] values = EnumAbility.values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].getName().equals(str)) {
                return values[i];
            }
        }
        return null;
    }

    private EnumLinker getLinker() {
        return (!isHighIoStrategy() || !isLinkerLinkUp(Utils.getHighPerformanceLinker())) ? isLinkerLinkUp(Utils.getBalanceLinker()) ? Utils.getBalanceLinker() : Utils.getDefaultLinker() : Utils.getHighPerformanceLinker();
    }

    private String getSelfId() {
        return DeviceManagerImpl.getInstance().getSelfDevice().getSelfId();
    }

    private String getSelfName() {
        return DeviceManagerImpl.getInstance().getSelfDevice().getName();
    }

    private boolean isHighIoStrategy() {
        return this.bHighIoStrategy;
    }

    private boolean isLinkerLinkUp(EnumLinker enumLinker) {
        return this.linkupLinker.containsKey(enumLinker);
    }

    private boolean isRemoteServer(EnumLinker enumLinker) {
        if (this.linkupLinker.containsKey(enumLinker)) {
            return this.linkupLinker.get(enumLinker).isRemoteServer();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyDeviceDown$0(EnumLinker enumLinker, String str, IChannel iChannel) {
        if (iChannel != null && iChannel.getChannelType() == ChannelType.VIRTUAL) {
            String str2 = TAG;
            LogUtil.d(str2, (Object) "Clear Virtual, Channel  <" + iChannel.getDevice() + ">");
            if (iChannel instanceof IVirtualChannel) {
                EnumLinker enumLinker2 = EnumLinker.TYPE_LINK_BT;
                if (enumLinker == enumLinker2) {
                    StarrynetApiImpl.getBridgeConnectImpl().onBleBridgeDisconnected(iChannel.getDevice());
                    ((IVirtualChannel) iChannel).linkDown(iChannel.getDevice(), enumLinker2);
                    return;
                }
                EnumLinker enumLinker3 = EnumLinker.TYPE_LINK_WS;
                if (enumLinker == enumLinker3) {
                    StarrynetApiImpl.getBridgeConnectImpl().onP2PBridgeDisconnected(iChannel.getDevice());
                    ((IVirtualChannel) iChannel).linkDown(iChannel.getDevice(), enumLinker3);
                    return;
                }
                LogUtil.e(str2, (Object) "清除虚拟通道时linker 有异常");
                return;
            }
            LogUtil.e(str2, (Object) "Channell类型异常-----" + iChannel.getChannelType());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startCacheCleaner$1() {
        LogUtil.d("startCacheCleaner Looper: " + Looper.myLooper());
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        AnonymousClass4 r0 = new Handler(Looper.myLooper()) {
            public void handleMessage(@NonNull Message message) {
                int i = message.what;
                if (i != ChannelImpl.EVENT_CHANGE_CHANNEL) {
                    switch (i) {
                        case ChannelImpl.EVENT_CACHE_CLEANER /*8193*/:
                            ChannelImpl channelImpl = ChannelImpl.this;
                            channelImpl.deleteFromCache(channelImpl.mOutputBuffer);
                            ChannelImpl.this.deleteFromLostCache();
                            sendEmptyMessageDelayed(ChannelImpl.EVENT_CACHE_CLEANER, AssistantConstants.TIMEOUT_VAD_MUTE);
                            return;
                        case ChannelImpl.EVENT_RETRANSMISSION /*8194*/:
                            RetransmissionArg retransmissionArg = (RetransmissionArg) message.obj;
                            long length = retransmissionArg.getLength();
                            long start = retransmissionArg.getStart();
                            for (long j = 0; j < length; j++) {
                                long j2 = start + j;
                                ChannelImpl channelImpl2 = ChannelImpl.this;
                                ChannelMessage access$600 = channelImpl2.findMessageByReqId(channelImpl2.mOutputBuffer, j2);
                                if (access$600 != null) {
                                    LogUtil.d("ChannelMessageCache", (Object) "启动重传 reqId:" + j2);
                                    LogUtil.d("ChannelMessageCache", (Object) "重传message=" + access$600);
                                    boolean unused = ChannelImpl.this.outputToRemote(access$600, true);
                                } else {
                                    LogUtil.e("ChannelMessageCache", (Object) "重传包未命中 reqId:" + j2);
                                }
                            }
                            return;
                        case ChannelImpl.EVENT_ACK /*8195*/:
                            String access$700 = ChannelImpl.TAG;
                            LogUtil.dPrimary(access$700, "ACK to <" + ChannelImpl.this.mDeviceId + ">");
                            AckArg ackArg = (AckArg) message.obj;
                            EnumLinker linker = ackArg.getLinker();
                            long reqId = ackArg.getReqId();
                            if (ChannelImpl.this.linkupLinker.containsKey(linker)) {
                                ((ILinker) ChannelImpl.this.mLinkerMap.get(linker)).triggerAck(reqId);
                                return;
                            }
                            return;
                        default:
                            LogUtil.e("un-catch " + message.what);
                            return;
                    }
                } else {
                    LogUtil.dPrimary(ChannelImpl.TAG, "channel changed send last message");
                    boolean unused2 = ChannelImpl.this.sendChangeChannelMessage();
                    ChannelMessage unused3 = ChannelImpl.this.changeChannelMessage = null;
                }
            }
        };
        this.workHandler = r0;
        r0.sendEmptyMessage(EVENT_CACHE_CLEANER);
        Looper.loop();
        LogUtil.d(TAG, (Object) "CacheCleaner is end");
    }

    private void notifyDeviceDown(EnumLinker enumLinker) {
        EnumLinker enumLinker2 = EnumLinker.TYPE_LINK_WS;
        if (enumLinker == enumLinker2) {
            LogUtil.i("device <" + getDeviceId() + "> ws channel close!!!!");
            IPublisher.IHandler starryNetHandler = StarrynetApiImpl.getStarryNetHandler();
            if (starryNetHandler != null) {
                starryNetHandler.onDeviceStateChanged(getDeviceId(), 2);
            } else {
                LogUtil.d("IPublisher.IHandler <" + getDeviceId() + "> is NULL");
            }
            VpnConfigUtils.update(false, getDevice(), (VpnParameter) null);
        }
        if (Utils.isSelfCenterDevice()) {
            String str = TAG;
            LogUtil.d(str, (Object) "Send Broadcast For Down, Channel <" + getDeviceId() + ">");
            VirtualDeviceNotify.getInstance().sendBroadCast(getDeviceId(), getDevice(), 2, enumLinker == enumLinker2 ? 2 : 1);
        } else if (Utils.isSubDevice()) {
            Map<String, IChannel> findAllChannel = ChannelManagerImpl.getInstance().findAllChannel();
            String str2 = TAG;
            LogUtil.d(str2, (Object) "Clear Virtual, Channel Size <" + findAllChannel.size() + ">");
            findAllChannel.forEach(new b(enumLinker));
        }
    }

    private void notifyDeviceUp(EnumLinker enumLinker, VpnParameter vpnParameter) {
        EnumLinker enumLinker2 = EnumLinker.TYPE_LINK_WS;
        if (enumLinker == enumLinker2) {
            IPublisher.IHandler starryNetHandler = StarrynetApiImpl.getStarryNetHandler();
            if (starryNetHandler != null) {
                starryNetHandler.onDeviceStateChanged(getDeviceId(), 1);
                LogUtil.d("Device <" + getDeviceId() + "> had up!!!!!!");
            }
            VpnConfigUtils.update(true, getDevice(), vpnParameter);
        }
        if (Utils.isSelfCenterDevice()) {
            LogUtil.d("Center Device---Start Send Broadcast For Up");
            VirtualDeviceNotify.getInstance().sendBroadCast(getDeviceId(), getDevice(), 1, enumLinker == enumLinker2 ? 2 : 1);
            return;
        }
        LogUtil.d("No Center Device---Do Nothing");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0190, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean outputToRemote(com.upuphone.runasone.message.ChannelMessage r9, boolean r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.isSendTlv     // Catch:{ all -> 0x0014 }
            r9.setSendTlv(r0)     // Catch:{ all -> 0x0014 }
            boolean r0 = r8.isLinkUp()     // Catch:{ all -> 0x0014 }
            r1 = 0
            if (r0 != 0) goto L_0x0017
            java.lang.String r9 = "outputToRemote, There's no valid linker"
            com.upuphone.runasone.utils.LogUtil.e(r9)     // Catch:{ all -> 0x0014 }
            goto L_0x018f
        L_0x0014:
            r9 = move-exception
            goto L_0x01b3
        L_0x0017:
            com.upuphone.runasone.channel.linker.EnumLinker r0 = r8.getLinker()     // Catch:{ all -> 0x0014 }
            boolean r2 = r8.isSendTlv     // Catch:{ all -> 0x0014 }
            if (r2 != 0) goto L_0x0191
            com.upuphone.runasone.QosLevel r2 = r9.getQos()     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.QosLevel r3 = com.upuphone.runasone.QosLevel.QOS_3     // Catch:{ all -> 0x0014 }
            if (r2 == r3) goto L_0x0191
            r2 = 1
            if (r10 != 0) goto L_0x0054
            long r4 = r8.sendRequestId     // Catch:{ all -> 0x0014 }
            long r4 = r4 + r2
            r8.sendRequestId = r4     // Catch:{ all -> 0x0014 }
            r6 = 0
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x0044
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0014 }
            java.lang.String r5 = "Reset output index"
            com.upuphone.runasone.utils.LogUtil.e((java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ all -> 0x0014 }
            r8.sendRequestId = r2     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.message.ChannelMessageCache r4 = r8.mOutputBuffer     // Catch:{ all -> 0x0014 }
            r4.clear()     // Catch:{ all -> 0x0014 }
        L_0x0044:
            long r4 = r8.sendRequestId     // Catch:{ all -> 0x0014 }
            r9.setRequestId(r4)     // Catch:{ all -> 0x0014 }
            r9.setRetransmission(r1)     // Catch:{ all -> 0x0014 }
            boolean r4 = r8.bEnableRetransmission     // Catch:{ all -> 0x0014 }
            if (r4 == 0) goto L_0x005d
            r8.commitToOutputCache(r9)     // Catch:{ all -> 0x0014 }
            goto L_0x005d
        L_0x0054:
            long r4 = r8.packetRetransmission     // Catch:{ all -> 0x0014 }
            long r4 = r4 + r2
            r8.packetRetransmission = r4     // Catch:{ all -> 0x0014 }
            r4 = 1
            r9.setRetransmission(r4)     // Catch:{ all -> 0x0014 }
        L_0x005d:
            java.lang.String r4 = r8.session     // Catch:{ all -> 0x0014 }
            r9.setSession(r4)     // Catch:{ all -> 0x0014 }
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0014 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0014 }
            r5.<init>()     // Catch:{ all -> 0x0014 }
            java.lang.String r6 = "outputToRemote, linker: "
            r5.append(r6)     // Catch:{ all -> 0x0014 }
            r5.append(r0)     // Catch:{ all -> 0x0014 }
            java.lang.String r6 = " isHighIoStrategy:"
            r5.append(r6)     // Catch:{ all -> 0x0014 }
            boolean r6 = r8.isHighIoStrategy()     // Catch:{ all -> 0x0014 }
            r5.append(r6)     // Catch:{ all -> 0x0014 }
            java.lang.String r6 = " requestId:"
            r5.append(r6)     // Catch:{ all -> 0x0014 }
            long r6 = r9.getRequestId()     // Catch:{ all -> 0x0014 }
            r5.append(r6)     // Catch:{ all -> 0x0014 }
            java.lang.String r6 = " bRetransmission:"
            r5.append(r6)     // Catch:{ all -> 0x0014 }
            r5.append(r10)     // Catch:{ all -> 0x0014 }
            java.lang.String r10 = " session:"
            r5.append(r10)     // Catch:{ all -> 0x0014 }
            java.lang.String r10 = r8.session     // Catch:{ all -> 0x0014 }
            r5.append(r10)     // Catch:{ all -> 0x0014 }
            java.lang.String r10 = r5.toString()     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.utils.LogUtil.dPrimary(r4, r10)     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.host.core.api.AbilityMessage r10 = r9.getAbilityMessage()     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.host.core.api.AbilityMessage$MessageType r10 = r10.getMessageType()     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.host.core.api.AbilityMessage$MessageType r4 = com.upuphone.runasone.host.core.api.AbilityMessage.MessageType.SIMPLIFIED     // Catch:{ all -> 0x0014 }
            if (r10 != r4) goto L_0x00be
            java.util.concurrent.ConcurrentHashMap<com.upuphone.runasone.channel.linker.EnumLinker, com.upuphone.runasone.channel.linker.ILinker> r10 = r8.mLinkerMap     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.channel.linker.EnumLinker r0 = com.upuphone.runasone.channel.linker.EnumLinker.TYPE_LINK_SIMPLIFIED     // Catch:{ all -> 0x0014 }
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.channel.linker.ILinker r10 = (com.upuphone.runasone.channel.linker.ILinker) r10     // Catch:{ all -> 0x0014 }
            boolean r9 = r10.output(r9)     // Catch:{ all -> 0x0014 }
            monitor-exit(r8)
            return r9
        L_0x00be:
            r8.changeChannelMessage = r9     // Catch:{ all -> 0x0014 }
            java.util.concurrent.ConcurrentHashMap<com.upuphone.runasone.channel.linker.EnumLinker, com.upuphone.runasone.channel.linker.ILinker> r10 = r8.mLinkerMap     // Catch:{ all -> 0x0014 }
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.channel.linker.ILinker r10 = (com.upuphone.runasone.channel.linker.ILinker) r10     // Catch:{ all -> 0x0014 }
            boolean r10 = r10.output(r9)     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.channel.linker.EnumLinker r4 = com.upuphone.runasone.utils.Utils.getHighPerformanceLinker()     // Catch:{ all -> 0x0014 }
            if (r4 != r0) goto L_0x013a
            if (r10 != 0) goto L_0x013a
            com.upuphone.runasone.host.core.api.AbilityMessage r4 = r9.getAbilityMessage()     // Catch:{ all -> 0x0014 }
            byte[] r4 = r4.getBypass()     // Catch:{ all -> 0x0014 }
            int r4 = r4.length     // Catch:{ all -> 0x0014 }
            r5 = 100000(0x186a0, float:1.4013E-40)
            if (r5 >= r4) goto L_0x0102
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0014 }
            r9.<init>()     // Catch:{ all -> 0x0014 }
            java.lang.String r10 = "消息大小超出BT单包门限 Channel <"
            r9.append(r10)     // Catch:{ all -> 0x0014 }
            java.lang.String r10 = r8.getDeviceId()     // Catch:{ all -> 0x0014 }
            r9.append(r10)     // Catch:{ all -> 0x0014 }
            java.lang.String r10 = "> 无法切换链路重传！！！"
            r9.append(r10)     // Catch:{ all -> 0x0014 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.utils.LogUtil.e(r9)     // Catch:{ all -> 0x0014 }
            monitor-exit(r8)
            return r1
        L_0x0102:
            com.upuphone.runasone.channel.linker.EnumLinker r1 = com.upuphone.runasone.utils.Utils.getDefaultLinker()     // Catch:{ all -> 0x0014 }
            boolean r1 = r8.isLinkerLinkUp(r1)     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x013c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0014 }
            r10.<init>()     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = "切换链路重传 Channel <"
            r10.append(r1)     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = r8.getDeviceId()     // Catch:{ all -> 0x0014 }
            r10.append(r1)     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = "> Retransmission ！！！"
            r10.append(r1)     // Catch:{ all -> 0x0014 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.utils.LogUtil.e(r10)     // Catch:{ all -> 0x0014 }
            java.util.concurrent.ConcurrentHashMap<com.upuphone.runasone.channel.linker.EnumLinker, com.upuphone.runasone.channel.linker.ILinker> r10 = r8.mLinkerMap     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.channel.linker.EnumLinker r1 = com.upuphone.runasone.utils.Utils.getDefaultLinker()     // Catch:{ all -> 0x0014 }
            java.lang.Object r10 = r10.get(r1)     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.channel.linker.ILinker r10 = (com.upuphone.runasone.channel.linker.ILinker) r10     // Catch:{ all -> 0x0014 }
            boolean r10 = r10.output(r9)     // Catch:{ all -> 0x0014 }
        L_0x013a:
            r1 = r10
            goto L_0x015b
        L_0x013c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0014 }
            r1.<init>()     // Catch:{ all -> 0x0014 }
            java.lang.String r4 = "无可用链路重传 Channel <"
            r1.append(r4)     // Catch:{ all -> 0x0014 }
            java.lang.String r4 = r8.getDeviceId()     // Catch:{ all -> 0x0014 }
            r1.append(r4)     // Catch:{ all -> 0x0014 }
            java.lang.String r4 = "> has no linker for Retransmission"
            r1.append(r4)     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.utils.LogUtil.e(r1)     // Catch:{ all -> 0x0014 }
            goto L_0x013a
        L_0x015b:
            long r4 = r8.packetOutput     // Catch:{ all -> 0x0014 }
            long r4 = r4 + r2
            r8.packetOutput = r4     // Catch:{ all -> 0x0014 }
            java.util.concurrent.ConcurrentHashMap<com.upuphone.runasone.channel.linker.EnumLinker, com.upuphone.runasone.channel.bean.stream.LinkerStatus> r10 = r8.linkupLinker     // Catch:{ all -> 0x0014 }
            boolean r10 = r10.containsKey(r0)     // Catch:{ all -> 0x0014 }
            if (r10 == 0) goto L_0x018f
            com.upuphone.runasone.host.core.api.AbilityMessage r9 = r9.getAbilityMessage()     // Catch:{ all -> 0x0014 }
            byte[] r9 = r9.getBypass()     // Catch:{ all -> 0x0014 }
            int r9 = r9.length     // Catch:{ all -> 0x0014 }
            long r9 = (long) r9     // Catch:{ all -> 0x0014 }
            long r2 = r8.outputTotalSize     // Catch:{ all -> 0x0014 }
            long r2 = r2 + r9
            r8.outputTotalSize = r2     // Catch:{ all -> 0x0014 }
            java.util.concurrent.ConcurrentHashMap<com.upuphone.runasone.channel.linker.EnumLinker, com.upuphone.runasone.channel.bean.stream.LinkerStatus> r2 = r8.linkupLinker     // Catch:{ all -> 0x0014 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.channel.bean.stream.LinkerStatus r2 = (com.upuphone.runasone.channel.bean.stream.LinkerStatus) r2     // Catch:{ all -> 0x0014 }
            long r2 = r2.getOutputSize()     // Catch:{ all -> 0x0014 }
            long r2 = r2 + r9
            java.util.concurrent.ConcurrentHashMap<com.upuphone.runasone.channel.linker.EnumLinker, com.upuphone.runasone.channel.bean.stream.LinkerStatus> r9 = r8.linkupLinker     // Catch:{ all -> 0x0014 }
            java.lang.Object r9 = r9.get(r0)     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.channel.bean.stream.LinkerStatus r9 = (com.upuphone.runasone.channel.bean.stream.LinkerStatus) r9     // Catch:{ all -> 0x0014 }
            r9.setOutputSize(r2)     // Catch:{ all -> 0x0014 }
        L_0x018f:
            monitor-exit(r8)
            return r1
        L_0x0191:
            boolean r10 = r8.isSendTlv     // Catch:{ all -> 0x0014 }
            if (r10 == 0) goto L_0x01a3
            java.util.concurrent.ConcurrentHashMap<com.upuphone.runasone.channel.linker.EnumLinker, com.upuphone.runasone.channel.linker.ILinker> r10 = r8.mLinkerMap     // Catch:{ all -> 0x0014 }
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.channel.linker.ILinker r10 = (com.upuphone.runasone.channel.linker.ILinker) r10     // Catch:{ all -> 0x0014 }
            boolean r9 = r10.output(r9)     // Catch:{ all -> 0x0014 }
            monitor-exit(r8)
            return r9
        L_0x01a3:
            java.util.concurrent.ConcurrentHashMap<com.upuphone.runasone.channel.linker.EnumLinker, com.upuphone.runasone.channel.linker.ILinker> r10 = r8.mLinkerMap     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.channel.linker.EnumLinker r0 = com.upuphone.runasone.channel.linker.EnumLinker.TYPE_LINK_BT     // Catch:{ all -> 0x0014 }
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0014 }
            com.upuphone.runasone.channel.linker.ILinker r10 = (com.upuphone.runasone.channel.linker.ILinker) r10     // Catch:{ all -> 0x0014 }
            boolean r9 = r10.output(r9)     // Catch:{ all -> 0x0014 }
            monitor-exit(r8)
            return r9
        L_0x01b3:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.ChannelImpl.outputToRemote(com.upuphone.runasone.message.ChannelMessage, boolean):boolean");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x010b, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e3 A[Catch:{ all -> 0x000f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean outputToRemoteSync(com.upuphone.runasone.message.ChannelMessage r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.isLinkUp()     // Catch:{ all -> 0x000f }
            r1 = 0
            if (r0 != 0) goto L_0x0012
            java.lang.String r7 = "outputToRemoteSync, There's no valid linker"
            com.upuphone.runasone.utils.LogUtil.e(r7)     // Catch:{ all -> 0x000f }
            goto L_0x010a
        L_0x000f:
            r7 = move-exception
            goto L_0x010c
        L_0x0012:
            com.upuphone.runasone.channel.linker.EnumLinker r0 = r6.getLinker()     // Catch:{ all -> 0x000f }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x000f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x000f }
            r3.<init>()     // Catch:{ all -> 0x000f }
            java.lang.String r4 = "outputToRemoteSync, linker: "
            r3.append(r4)     // Catch:{ all -> 0x000f }
            r3.append(r0)     // Catch:{ all -> 0x000f }
            java.lang.String r4 = " isHighIoStrategy:"
            r3.append(r4)     // Catch:{ all -> 0x000f }
            boolean r4 = r6.isHighIoStrategy()     // Catch:{ all -> 0x000f }
            r3.append(r4)     // Catch:{ all -> 0x000f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x000f }
            com.upuphone.runasone.utils.LogUtil.dPrimary(r2, r3)     // Catch:{ all -> 0x000f }
            r6.changeChannelMessage = r7     // Catch:{ all -> 0x000f }
            java.util.concurrent.ConcurrentHashMap<com.upuphone.runasone.channel.linker.EnumLinker, com.upuphone.runasone.channel.linker.ILinker> r2 = r6.mLinkerMap     // Catch:{ all -> 0x000f }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x000f }
            com.upuphone.runasone.channel.linker.ILinker r2 = (com.upuphone.runasone.channel.linker.ILinker) r2     // Catch:{ all -> 0x000f }
            boolean r2 = r2.output(r7)     // Catch:{ all -> 0x000f }
            com.upuphone.runasone.channel.linker.EnumLinker r3 = com.upuphone.runasone.utils.Utils.getHighPerformanceLinker()     // Catch:{ all -> 0x000f }
            if (r3 != r0) goto L_0x00d3
            if (r2 != 0) goto L_0x00d3
            com.upuphone.runasone.host.core.api.AbilityMessage r3 = r7.getAbilityMessage()     // Catch:{ all -> 0x000f }
            byte[] r3 = r3.getBypass()     // Catch:{ all -> 0x000f }
            int r3 = r3.length     // Catch:{ all -> 0x000f }
            r4 = 100000(0x186a0, float:1.4013E-40)
            if (r4 >= r3) goto L_0x007c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x000f }
            r7.<init>()     // Catch:{ all -> 0x000f }
            java.lang.String r0 = "消息大小超出BT单包门限 Channel <"
            r7.append(r0)     // Catch:{ all -> 0x000f }
            java.lang.String r0 = r6.getDeviceId()     // Catch:{ all -> 0x000f }
            r7.append(r0)     // Catch:{ all -> 0x000f }
            java.lang.String r0 = "> 无法切换链路重传！！！"
            r7.append(r0)     // Catch:{ all -> 0x000f }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x000f }
            com.upuphone.runasone.utils.LogUtil.e(r7)     // Catch:{ all -> 0x000f }
            monitor-exit(r6)
            return r1
        L_0x007c:
            com.upuphone.runasone.channel.linker.EnumLinker r1 = com.upuphone.runasone.utils.Utils.getDefaultLinker()     // Catch:{ all -> 0x000f }
            boolean r1 = r6.isLinkerLinkUp(r1)     // Catch:{ all -> 0x000f }
            if (r1 == 0) goto L_0x00b5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x000f }
            r1.<init>()     // Catch:{ all -> 0x000f }
            java.lang.String r2 = "切换链路重传 Channel <"
            r1.append(r2)     // Catch:{ all -> 0x000f }
            java.lang.String r2 = r6.getDeviceId()     // Catch:{ all -> 0x000f }
            r1.append(r2)     // Catch:{ all -> 0x000f }
            java.lang.String r2 = "> Retransmission ！！！"
            r1.append(r2)     // Catch:{ all -> 0x000f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x000f }
            com.upuphone.runasone.utils.LogUtil.e(r1)     // Catch:{ all -> 0x000f }
            java.util.concurrent.ConcurrentHashMap<com.upuphone.runasone.channel.linker.EnumLinker, com.upuphone.runasone.channel.linker.ILinker> r1 = r6.mLinkerMap     // Catch:{ all -> 0x000f }
            com.upuphone.runasone.channel.linker.EnumLinker r2 = com.upuphone.runasone.utils.Utils.getDefaultLinker()     // Catch:{ all -> 0x000f }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x000f }
            com.upuphone.runasone.channel.linker.ILinker r1 = (com.upuphone.runasone.channel.linker.ILinker) r1     // Catch:{ all -> 0x000f }
            boolean r1 = r1.output(r7)     // Catch:{ all -> 0x000f }
            goto L_0x00d4
        L_0x00b5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x000f }
            r1.<init>()     // Catch:{ all -> 0x000f }
            java.lang.String r3 = "无可用链路重传 Channel <"
            r1.append(r3)     // Catch:{ all -> 0x000f }
            java.lang.String r3 = r6.getDeviceId()     // Catch:{ all -> 0x000f }
            r1.append(r3)     // Catch:{ all -> 0x000f }
            java.lang.String r3 = "> has no linker for Retransmission"
            r1.append(r3)     // Catch:{ all -> 0x000f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x000f }
            com.upuphone.runasone.utils.LogUtil.e(r1)     // Catch:{ all -> 0x000f }
        L_0x00d3:
            r1 = r2
        L_0x00d4:
            long r2 = r6.packetOutput     // Catch:{ all -> 0x000f }
            r4 = 1
            long r2 = r2 + r4
            r6.packetOutput = r2     // Catch:{ all -> 0x000f }
            java.util.concurrent.ConcurrentHashMap<com.upuphone.runasone.channel.linker.EnumLinker, com.upuphone.runasone.channel.bean.stream.LinkerStatus> r2 = r6.linkupLinker     // Catch:{ all -> 0x000f }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x000f }
            if (r2 == 0) goto L_0x010a
            com.upuphone.runasone.host.core.api.AbilityMessage r7 = r7.getAbilityMessage()     // Catch:{ all -> 0x000f }
            byte[] r7 = r7.getBypass()     // Catch:{ all -> 0x000f }
            int r7 = r7.length     // Catch:{ all -> 0x000f }
            long r2 = (long) r7     // Catch:{ all -> 0x000f }
            long r4 = r6.outputTotalSize     // Catch:{ all -> 0x000f }
            long r4 = r4 + r2
            r6.outputTotalSize = r4     // Catch:{ all -> 0x000f }
            java.util.concurrent.ConcurrentHashMap<com.upuphone.runasone.channel.linker.EnumLinker, com.upuphone.runasone.channel.bean.stream.LinkerStatus> r7 = r6.linkupLinker     // Catch:{ all -> 0x000f }
            java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x000f }
            com.upuphone.runasone.channel.bean.stream.LinkerStatus r7 = (com.upuphone.runasone.channel.bean.stream.LinkerStatus) r7     // Catch:{ all -> 0x000f }
            long r4 = r7.getOutputSize()     // Catch:{ all -> 0x000f }
            long r4 = r4 + r2
            java.util.concurrent.ConcurrentHashMap<com.upuphone.runasone.channel.linker.EnumLinker, com.upuphone.runasone.channel.bean.stream.LinkerStatus> r7 = r6.linkupLinker     // Catch:{ all -> 0x000f }
            java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x000f }
            com.upuphone.runasone.channel.bean.stream.LinkerStatus r7 = (com.upuphone.runasone.channel.bean.stream.LinkerStatus) r7     // Catch:{ all -> 0x000f }
            r7.setOutputSize(r4)     // Catch:{ all -> 0x000f }
        L_0x010a:
            monitor-exit(r6)
            return r1
        L_0x010c:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.ChannelImpl.outputToRemoteSync(com.upuphone.runasone.message.ChannelMessage):boolean");
    }

    /* access modifiers changed from: private */
    public synchronized boolean sendChangeChannelMessage() {
        ChannelMessage channelMessage = this.changeChannelMessage;
        if (channelMessage == null) {
            return false;
        }
        if (100000 < channelMessage.getAbilityMessage().getBypass().length) {
            LogUtil.e("消息大小超出BT单包门限 Channel <" + getDeviceId() + "> 无法切换链路重传！！！");
            return false;
        } else if (isLinkerLinkUp(Utils.getDefaultLinker())) {
            LogUtil.e("切换链路重传 sendChangeChannelMessage Channel <" + getDeviceId() + "> Retransmission !!!");
            return this.mLinkerMap.get(Utils.getDefaultLinker()).output(this.changeChannelMessage);
        } else {
            LogUtil.e("无可用链路重传 Channel <" + getDeviceId() + "> has no linker for Retransmission");
            return false;
        }
    }

    private void setIoStrategy(boolean z) {
        LogUtil.d("Channel <" + getDeviceId() + "> setIoStrategy:" + z);
        this.bHighIoStrategy = z;
    }

    private void setLocalAuthPara() {
        this.localAuthPara = new AuthParameter();
        AuthBean authBean = new AuthBean();
        String selfName = getSelfName();
        authBean.setDeviceId(getSelfId());
        authBean.setDeviceName(selfName);
        AbilityAttributes abilityAttributes = new AbilityAttributes();
        abilityAttributes.setAbilityAttributes(AbilityRouterImpl.getInstance().getLocalAbilityAttr());
        authBean.setAbilityAttributes(abilityAttributes);
        CopyOnWriteArrayList<String> localAbilityList2 = AbilityRouterImpl.getInstance().getLocalAbilityList();
        this.localAbilityList = localAbilityList2;
        authBean.setAbility(localAbilityList2);
        authBean.setVersion(Utils.getVersionName());
        authBean.setSupportTlv(true);
        this.localWeight = this.mLocalWeightRandom.nextInt(DurationKt.NANOS_IN_MILLIS);
        LogUtil.d("general weight:" + this.localWeight);
        authBean.setWeight(this.localWeight);
        String valueOf = String.valueOf(System.currentTimeMillis());
        this.localSession = valueOf.substring(valueOf.length() + -4);
        LogUtil.d("general session 生成会话ID:" + this.localSession);
        authBean.setSession(this.localSession);
        this.localAuthBean = authBean;
        String json = new Gson().toJson((Object) authBean);
        String str = TAG;
        LogUtil.d(str, (Object) "setLocalAuthPara: " + json);
        this.localAuthPara.setAuthInfo(json);
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.activeAbilityList = copyOnWriteArrayList;
        copyOnWriteArrayList.addAll(this.localAbilityList);
        this.activeEnumAbilityList = new CopyOnWriteArrayList<>();
    }

    private void startCacheCleaner() {
        LogUtil.d("Channel <" + this.mDeviceId + "> startCacheCleaner");
        if (this.workHandler == null) {
            CommonThreadPool.execute(new a(this));
        }
    }

    private void stopCacheCleaner() {
        LogUtil.d("Channel <" + this.mDeviceId + "> stopCacheCleaner");
        Handler handler = this.workHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.workHandler.getLooper().quitSafely();
            this.workHandler = null;
        }
    }

    public List<String> getActiveAbilityList() {
        return this.activeAbilityList;
    }

    public List<EnumAbility> getActiveEnumAbilityList() {
        return this.activeEnumAbilityList;
    }

    public ChannelType getChannelType() {
        return ChannelType.NORMAL;
    }

    public String getCoreCommit() {
        return this.coreCommit;
    }

    public String getCreateTime() {
        return this.mCreateTime;
    }

    public long getDeltaSysTime() {
        return this.deltaSysTime;
    }

    public StarryDevice getDevice() {
        return this.mDevice;
    }

    public long getInputTotalSize() {
        return this.inputTotalSize;
    }

    public final HashMap<EnumLinker, LinkerStatus> getLinkerStatus() {
        HashMap<EnumLinker, LinkerStatus> hashMap = new HashMap<>();
        if (this.linkupLinker.size() == 0) {
            return null;
        }
        hashMap.putAll(this.linkupLinker);
        return hashMap;
    }

    public List<String> getLocalAbilityList() {
        return this.localAbilityList;
    }

    public AuthBean getLocalAuthBean() {
        return this.localAuthBean;
    }

    public long getOutputTotalSize() {
        return this.outputTotalSize;
    }

    public long getPacketInput() {
        return this.packetInput;
    }

    public long getPacketLoss() {
        return this.packetLoss;
    }

    public long getPacketOutput() {
        return this.packetOutput;
    }

    public long getPacketRetransmission() {
        return this.packetRetransmission;
    }

    public List<String> getRemoteAbilityList() {
        return this.remoteAbilityList;
    }

    public AuthBean getRemoteAuthBean() {
        return this.remoteAuthBean;
    }

    public String getVersion() {
        return this.version;
    }

    public void input(EnumLinker enumLinker, ChannelMessage channelMessage) {
        EnumLinker enumLinker2 = enumLinker;
        ChannelMessage channelMessage2 = channelMessage;
        if (enumLinker2 == EnumLinker.TYPE_LINK_SIMPLIFIED) {
            IChannel.BiObserver biObserver = this.mBiObserver;
            if (biObserver != null) {
                biObserver.input(channelMessage2);
            }
        } else if (this.isSendTlv || channelMessage.getQos() == QosLevel.QOS_3) {
            this.mBiObserver.input(channelMessage2);
        } else {
            long requestId = channelMessage.getRequestId();
            boolean isRetransmission = channelMessage.isRetransmission();
            LogUtil.dPrimary(TAG, "input, linker: " + enumLinker2 + " currentReqId:" + requestId + " lastReceiveRequestId:" + this.lastReceiveRequestId + " isRetransmission:" + isRetransmission + " session:" + channelMessage.getSession() + " qos:" + channelMessage.getQos());
            QosLevel qosLevel = QosLevel.QOS_2;
            if (qosLevel == channelMessage.getQos()) {
                Message message = new Message();
                message.what = EVENT_ACK;
                message.obj = new AckArg(enumLinker2, requestId);
                this.workHandler.sendMessage(message);
            } else if (this.bEnableRetransmission) {
                if (0 < this.lastReceiveRequestId && 1 == requestId) {
                    LogUtil.e("reqId 复位 !!!");
                    this.lastReceiveRequestId = 0;
                    this.mLostInputBuffer.clear();
                }
                long j = requestId - this.lastReceiveRequestId;
                if (this.mLostInputBuffer.containsKey(Long.valueOf(requestId))) {
                    this.mLostInputBuffer.remove(Long.valueOf(requestId));
                    LogUtil.d("ChannelMessageCache", (Object) "收到重传包 reqId: " + requestId + " dValue:" + j);
                } else if (j > 64) {
                    LogUtil.e("丢包太多了，不需要重传啦 dValue:" + j);
                } else if (j > 1) {
                    long j2 = j - 1;
                    this.packetLoss += j2;
                    long j3 = this.lastReceiveRequestId + 1;
                    LogUtil.e("ChannelMessageCache", (Object) "丢包了，丢包了，丢包了，大概" + j2 + "个包吧，总计丢包" + this.packetLoss);
                    LogUtil.e("ChannelMessageCache", (Object) "发送重传请求 triggerRetransmission startReqId:" + j3 + " loss:" + j2);
                    commitToLostInputCache(j3, j2);
                    this.mLinkerMap.get(enumLinker2).triggerRetransmission(j3, j2);
                } else if (j <= 0) {
                    LogUtil.d("ChannelMessageCache", (Object) "收到异常包 reqId: " + requestId + " dValue:" + j);
                }
            }
            this.packetInput++;
            if (this.mBiObserver != null) {
                if (this.linkupLinker.containsKey(enumLinker2)) {
                    long length = (long) channelMessage.getAbilityMessage().getBypass().length;
                    this.inputTotalSize += length;
                    this.linkupLinker.get(enumLinker2).setInputSize(this.linkupLinker.get(enumLinker2).getInputSize() + length);
                }
                if (!filterInput(channelMessage2, enumLinker2)) {
                    this.mBiObserver.input(channelMessage2);
                }
                if (qosLevel != channelMessage.getQos() && requestId > this.lastReceiveRequestId) {
                    this.lastReceiveRequestId = requestId;
                }
            }
        }
    }

    public boolean isAuthTransition() {
        boolean z = false;
        for (Map.Entry<EnumLinker, ILinker> key : this.mLinkerMap.entrySet()) {
            EnumLinker enumLinker = (EnumLinker) key.getKey();
            if (this.mLinkerMap.get(enumLinker) != null) {
                z = this.mLinkerMap.get(enumLinker).isAuthTransition();
            }
            LogUtil.d("check <" + enumLinker + "> isAuthTransition:" + z);
        }
        return z;
    }

    public boolean isLinkUp() {
        return !this.linkupLinker.isEmpty();
    }

    public synchronized boolean link(EnumLinkStrategy enumLinkStrategy, boolean z) {
        EnumLinker mapLinker = Utils.mapLinker(enumLinkStrategy);
        if (!this.mLinkerMap.containsKey(mapLinker)) {
            LogUtil.e("link fail, mLinkerMap <" + mapLinker + "> is un-valid");
            return false;
        } else if (!isLinkerLinkUp(mapLinker)) {
            LogUtil.d("device:" + getDeviceId() + " link: " + mapLinker + " bServer: " + z);
            this.startTimeMap.put(mapLinker, Long.valueOf(SystemClock.elapsedRealtime()));
            this.handlerTimeout.sendEmptyMessageDelayed(mapLinker.ordinal(), 5000);
            LinkerStatus linkerStatus = new LinkerStatus();
            linkerStatus.setLinkerName(mapLinker.toString());
            this.linkingLinker.put(mapLinker, linkerStatus);
            return this.mLinkerMap.get(mapLinker).open(z, this.localAuthPara);
        } else {
            this.linkingLinker.remove(mapLinker);
            LogUtil.d("device:" + getDeviceId() + " link: " + mapLinker + " bServer: " + z + " is available already");
            return true;
        }
    }

    public int mapType(EnumLinker enumLinker) {
        if (enumLinker.ordinal() == EnumLinker.TYPE_LINK_BT.ordinal()) {
            return 1;
        }
        return enumLinker.ordinal() == EnumLinker.TYPE_LINK_WS.ordinal() ? 2 : -1;
    }

    public void onRetransmission(EnumLinker enumLinker, long j, long j2) {
        LogUtil.d("ChannelMessageCache", (Object) "收到重传请求 onRetransmission, linker: " + enumLinker + " startReqId:" + j + " length:" + j2);
        if (this.workHandler != null) {
            Message message = new Message();
            message.what = EVENT_RETRANSMISSION;
            message.obj = new RetransmissionArg(j, j2);
            this.workHandler.sendMessage(message);
        }
    }

    public void onStreamClose(EnumLinker enumLinker) {
        if (this.mLinkerStateObserver != null) {
            if (Utils.getHighPerformanceLinker() == enumLinker) {
                setIoStrategy(false);
            }
            String str = TAG;
            LogUtil.d(str, (Object) "onStreamClose, Channel <" + getDeviceId() + ">linker: " + enumLinker + " linkupLinker.size:" + this.linkupLinker.size());
            this.mLinkerStateObserver.onLinkDown(getDevice(), enumLinker);
            closeLinker(enumLinker);
        }
    }

    public void onStreamError(EnumLinker enumLinker, int i) {
        int mapType;
        this.handlerTimeout.removeMessages(enumLinker.ordinal());
        Long remove = this.startTimeMap.remove(enumLinker);
        if (remove != null && (mapType = mapType(enumLinker)) > 0) {
            TrackHelper.recordConnectTime(String.valueOf(mapType), SystemClock.elapsedRealtime() - remove.longValue(), -1);
        }
        if (this.mLinkerStateObserver != null) {
            if (Utils.getHighPerformanceLinker() == enumLinker) {
                setIoStrategy(false);
            }
            String str = TAG;
            LogUtil.e(str, (Object) "onStreamError, linker: " + enumLinker + " errorCode:" + i);
            this.mLinkerStateObserver.onLinkError(getDevice(), enumLinker, i);
            closeLinker(enumLinker);
        }
    }

    public void onStreamOpen(EnumLinker enumLinker, AuthParameter authParameter) {
        int mapType;
        this.handlerTimeout.removeMessages(enumLinker.ordinal());
        Long remove = this.startTimeMap.remove(enumLinker);
        boolean z = true;
        if (remove != null && (mapType = mapType(enumLinker)) > 0) {
            TrackHelper.recordConnectTime(String.valueOf(mapType), SystemClock.elapsedRealtime() - remove.longValue(), 1);
        }
        ILinker iLinker = this.mLinkerMap.get(enumLinker);
        if (this.mLinkerStateObserver != null && iLinker != null) {
            String str = TAG;
            LogUtil.d(str, (Object) "onStreamOpen, linker: " + enumLinker);
            if (!isLinkerLinkUp(enumLinker)) {
                if (Utils.getHighPerformanceLinker() == enumLinker) {
                    setIoStrategy(true);
                } else {
                    this.deltaSysTime = authParameter.getDeltaSysTime();
                }
                this.linkingLinker.remove(enumLinker);
                LinkerStatus linkerStatus = new LinkerStatus();
                linkerStatus.setStartTime(DateFormat.getDateTimeInstance().format(new Date()));
                linkerStatus.setRemoteServer(authParameter.isRemoteServer());
                linkerStatus.setLinkerName(enumLinker.toString());
                this.linkupLinker.put(enumLinker, linkerStatus);
                if (!Utils.isHQ()) {
                    LogUtil.d("authParameter:" + authParameter.getAuthInfo());
                }
                this.remoteAuthPara = authParameter;
                AuthBean authBean = (AuthBean) new Gson().fromJson(this.remoteAuthPara.getAuthInfo(), AuthBean.class);
                this.remoteAuthBean = authBean;
                int weight = authBean.getWeight();
                String session2 = authBean.getSession();
                if (session2 == null) {
                    LogUtil.e("对端版本过低，remoteSession为空");
                    session2 = this.localSession;
                }
                LogUtil.d("localWeight:" + this.localWeight + " localSession:" + this.localSession + " remoteWeight:" + weight + " remoteSession:" + session2);
                int i = this.localWeight;
                if (i > weight) {
                    this.session = this.localSession;
                } else if (i < weight) {
                    this.session = session2;
                } else {
                    LogUtil.e("权重相等，使用备用方案");
                    this.session = generalSessionByStr(String.valueOf(this.localWeight));
                }
                LogUtil.d("now set session:" + this.session);
                iLinker.setSession(this.session);
                this.localAuthBean.setSession(this.session);
                this.remoteAuthBean.setSession(this.session);
                if (!authBean.isSupportTlv() || authBean.getAgreementType() != 1) {
                    z = false;
                }
                this.isSendTlv = z;
                CopyOnWriteArrayList<String> ability = authBean.getAbility();
                this.remoteAbilityList = ability;
                this.activeAbilityList.retainAll(ability);
                LogUtil.d("activeAbilityList: " + this.activeAbilityList);
                generalEnumAbilityList();
                if (authBean.getVersion() != null) {
                    this.version = authBean.getVersion();
                }
                if (authBean.getCoreCommit() != null) {
                    this.coreCommit = authBean.getCoreCommit();
                }
            } else {
                LogUtil.e(str, (Object) "onStreamOpen ... maybe something wrong");
            }
            this.mLinkerStateObserver.onLinkUp(getDevice(), enumLinker);
            notifyDeviceUp(enumLinker, authParameter != null ? authParameter.getVpnParameter() : null);
        } else if (iLinker == null) {
            LogUtil.e(TAG, (Object) "onStreamOpen ... channel has released!");
        }
    }

    public void onStreamTearDown(EnumLinker enumLinker) {
        String str = TAG;
        LogUtil.e(str, (Object) "onStreamTearDown ... Channel <" + getDeviceId() + "> linker: " + enumLinker);
        setIoStrategy(false);
    }

    public void onUpdateQos(EnumLinker enumLinker, int i) {
        if (this.linkupLinker.containsKey(enumLinker)) {
            LogUtil.d("Channel <" + getDeviceId() + "> onUpdateQos: " + i + "ms");
            this.linkupLinker.get(enumLinker).setQos(i);
        }
    }

    public int output(ChannelMessage channelMessage) {
        ChannelActor channelActor;
        if (this.mChannelActor == null || this.mChannelSyncActor == null) {
            channelActor = null;
        } else {
            int length = channelMessage.getAbilityMessage().getBypass().length;
            if (100000 >= length || (isHighIoStrategy() && isLinkerLinkUp(Utils.getHighPerformanceLinker()))) {
                channelMessage.setSession(this.session);
                channelActor = QosLevel.QOS_2 == channelMessage.getQos() ? this.mChannelSyncActor : this.mChannelActor;
            } else {
                LogUtil.e("output fail, 高性能连接失效 + 消息长度超限:" + length + " Channel <" + getDeviceId() + ">  ！！！");
                return Constants.ChannelErrorCode.ERROR_SLICE_OVER_LIMIT;
            }
        }
        if (channelActor == null) {
            return 0;
        }
        channelActor.injection(channelMessage);
        return 0;
    }

    public synchronized void release() {
        try {
            LogUtil.e("release Channel <" + getDeviceId() + ">");
            this.mOutputBuffer.clear();
            this.mLostInputBuffer.clear();
            stopCacheCleaner();
            ChannelActor channelActor = this.mChannelActor;
            if (channelActor != null) {
                channelActor.clearInputPort();
                this.mChannelActor.uninstallInputPort();
                this.mChannelActor = null;
            }
            ChannelActor channelActor2 = this.mChannelSyncActor;
            if (channelActor2 != null) {
                channelActor2.clearInputPort();
                this.mChannelSyncActor.uninstallInputPort();
                this.mChannelSyncActor = null;
            }
            for (Map.Entry<EnumLinker, ILinker> key : this.mLinkerMap.entrySet()) {
                EnumLinker enumLinker = (EnumLinker) key.getKey();
                unlink(Utils.mapLinkStrategy(enumLinker));
                this.mLinkerMap.get(enumLinker).shutdown();
                this.mLinkerMap.remove(enumLinker);
            }
            AbilityRouterImpl.getInstance().unbindChannel(this, EnumLinkStrategy.STRATEGY_DEFAULT);
            AbilityRouterImpl.getInstance().unbindChannel(this, EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE);
            AbilityRouterImpl.getInstance().unbindChannel(this, EnumLinkStrategy.STRATEGY_SIMPLIFIED);
            AbilityRouterImpl.getInstance().unbindChannel(this, EnumLinkStrategy.STRATEGY_BALANCE);
            String str = TAG;
            LogUtil.d(str, (Object) "release all Linker from <" + getDeviceId() + ">");
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setIoObserver(IChannel.BiObserver biObserver) {
        this.mBiObserver = biObserver;
    }

    public void setLinkerStateObserver(IChannel.LinkerStateObserver linkerStateObserver) {
        this.mLinkerStateObserver = linkerStateObserver;
    }

    public void teardown(EnumLinkStrategy enumLinkStrategy) {
        EnumLinker mapLinker = Utils.mapLinker(enumLinkStrategy);
        if (isLinkerLinkUp(mapLinker)) {
            if (Utils.getHighPerformanceLinker() == mapLinker) {
                setIoStrategy(false);
            }
            LogUtil.d("Channel <" + getDeviceId() + "> notifyTearDownSync");
            this.mLinkerMap.get(mapLinker).notifyTearDownSync();
            return;
        }
        LogUtil.e("Channel <" + getDeviceId() + "> strategy: " + enumLinkStrategy + " 通道已经关闭");
    }

    public synchronized void unlink(EnumLinkStrategy enumLinkStrategy) {
        EnumLinker mapLinker = Utils.mapLinker(enumLinkStrategy);
        String str = TAG;
        LogUtil.d(str, (Object) "device:" + getDeviceId() + " unlink: " + mapLinker + " linkupLinker.size:" + this.linkupLinker.size());
        closeLinker(mapLinker);
    }

    public boolean isLinkUp(EnumLinkStrategy enumLinkStrategy) {
        return isLinkerLinkUp(Utils.mapLinker(enumLinkStrategy));
    }
}
