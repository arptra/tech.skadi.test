package com.upuphone.xr.interconnect.business.connect;

import com.google.protobuf.InvalidProtocolBufferException;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynetsdk.ability.relay.RelayAbility;
import com.upuphone.starrynetsdk.ability.relay.RelayListener;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.DataBinderSlice;
import com.upuphone.xr.interconnect.business.connect.ConnectionStateListener;
import com.upuphone.xr.interconnect.business.connect.primary.HostStartManager;
import com.upuphone.xr.interconnect.business.connect.primary.VersionSendListener;
import com.upuphone.xr.interconnect.business.connect.primary.VersionSendManager;
import com.upuphone.xr.interconnect.business.time.TimeManager;
import com.upuphone.xr.interconnect.entity.ConnectMessageOuterClass;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import org.aspectj.lang.JoinPoint;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\r\b\u0000\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001cB\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020%H\u0002J\u0018\u00101\u001a\u00020.2\u0006\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020%H\u0002J\u0018\u00102\u001a\u00020.2\u0006\u0010/\u001a\u00020$2\u0006\u00103\u001a\u00020\u001aH\u0002J\u0010\u00104\u001a\u00020.2\u0006\u0010/\u001a\u00020$H\u0002J\u0014\u00105\u001a\u0004\u0018\u00010$2\b\u0010/\u001a\u0004\u0018\u00010$H\u0002J\u0010\u00106\u001a\u0004\u0018\u00010\u001f2\u0006\u0010/\u001a\u00020$J\u0017\u00107\u001a\u0004\u0018\u00010\u001a2\u0006\u0010/\u001a\u00020$H\u0016¢\u0006\u0002\u00108J\u0018\u00109\u001a\u00020.2\u0010\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010<\u0018\u00010;Jj\u0010=\u001a\u00020.2\u0006\u0010/\u001a\u00020$2\b\u0010>\u001a\u0004\u0018\u00010$2\u0006\u0010?\u001a\u00020@2F\u0010A\u001aB\u0012\u0004\u0012\u00020\u001a\u00128\u00126\u0012\u0013\u0012\u00110@¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110$¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020.0Cj\u0002`G0BH\u0016J\u0010\u0010H\u001a\u00020.2\u0006\u0010/\u001a\u00020$H\u0002J\u0010\u0010I\u001a\u00020J2\b\u0010/\u001a\u0004\u0018\u00010$J\u0010\u0010K\u001a\u00020J2\u0006\u0010/\u001a\u00020$H\u0016J\u0010\u0010L\u001a\u00020J2\u0006\u0010/\u001a\u00020$H\u0016J\u000e\u0010M\u001a\u00020.2\u0006\u0010N\u001a\u00020OJ\u0010\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020.2\u0006\u0010Q\u001a\u00020RH\u0016J&\u0010T\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010$2\b\u0010>\u001a\u0004\u0018\u00010$2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J \u0010U\u001a\u00020.2\u0006\u0010>\u001a\u00020$2\u000e\u0010V\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010WH\u0016J$\u0010X\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010$2\b\u0010>\u001a\u0004\u0018\u00010$2\u0006\u0010Y\u001a\u00020\u001aH\u0016J\u001c\u0010Z\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010$2\b\u0010>\u001a\u0004\u0018\u00010$H\u0016J\u001c\u0010[\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010$2\b\u0010>\u001a\u0004\u0018\u00010$H\u0016J\u0018\u0010\\\u001a\u00020.2\u0006\u0010/\u001a\u00020$2\u0006\u00103\u001a\u00020\u001aH\u0016J\u0010\u0010]\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010^\u001a\u00020.2\u0006\u0010/\u001a\u00020$H\u0002J\u0010\u0010_\u001a\u00020.2\u0006\u0010/\u001a\u00020$H\u0002J\u0018\u0010`\u001a\u00020.2\u0006\u0010/\u001a\u00020$2\u0006\u00103\u001a\u00020\u001aH\u0002J \u0010a\u001a\u00020.2\u0006\u0010/\u001a\u00020$2\u0006\u0010b\u001a\u00020%2\u0006\u00100\u001a\u00020%H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dXD¢\u0006\u0002\n\u0000R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R*\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#j\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%`&X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001a0(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020$0,X\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager;", "Lcom/upuphone/starrynetsdk/ability/relay/RelayListener;", "Lcom/upuphone/xr/interconnect/business/connect/primary/VersionSendListener;", "Lcom/upuphone/xr/interconnect/business/connect/VersionNegotiationManager;", "Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateListener;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "listenerLinkingCollector", "Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;", "Lcom/upuphone/xr/interconnect/business/connect/PeerStateListener;", "(Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;)V", "checkVersionSendJob", "Lkotlinx/coroutines/Job;", "hostStatusManager", "Lcom/upuphone/xr/interconnect/business/connect/primary/HostStartManager;", "infoSlice", "Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "getInfoSlice", "()Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "infoSlice$delegate", "Lkotlin/Lazy;", "listeners", "", "getListeners", "()Ljava/util/Set;", "listeners$delegate", "mCurSendVersion", "", "mMaxSendCount", "mMaxSendVersionDuringTime", "", "negotiatedPeer", "Lcom/upuphone/xr/interconnect/business/connect/PeerInfo;", "getNegotiatedPeer", "()Lcom/upuphone/xr/interconnect/business/connect/PeerInfo;", "stateMap", "Ljava/util/HashMap;", "", "Lcom/upuphone/xr/interconnect/business/connect/PeerState;", "Lkotlin/collections/HashMap;", "versionMap", "", "versionSendManager", "Lcom/upuphone/xr/interconnect/business/connect/primary/VersionSendManager;", "versionSentDevices", "", "changeStateDown", "", "deviceId", "newState", "changeStateUp", "confirmVersionSent", "version", "downToFirstVersion", "filterDeviceById", "getPeerInfo", "getVersion", "(Ljava/lang/String;)Ljava/lang/Integer;", "handleDeviceListChange", "deviceList", "", "Lcom/upuphone/runasone/device/StarryDevice;", "handleMessage", "uniteCode", "data", "", "consumerMap", "", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "logTag", "Lcom/upuphone/xr/interconnect/business/messenger/MessageConsumer;", "initiateVersionSending", "isDeviceNegotiated", "", "isVersionReceived", "isVersionSent", "onAbilityReady", "relayAbility", "Lcom/upuphone/starrynetsdk/ability/relay/RelayAbility;", "onPrimaryConnectionConnected", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onPrimaryConnectionDisconnected", "onRelay", "onRelayDeviceListChanged", "list", "", "onRemoteError", "code", "onRemoteStarted", "onRemoteStopped", "onVersionSendSuccess", "parseConnectMessage", "resetDeviceStatus", "startCommunication", "startVersionSendJob", "updateState", "oldState", "Companion", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPeerDeviceStatusManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PeerDeviceStatusManager.kt\ncom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,441:1\n1#2:442\n1#2:457\n1855#3,2:443\n1855#3,2:445\n1603#3,9:447\n1855#3:456\n1856#3:458\n1612#3:459\n215#4,2:460\n215#4,2:469\n526#5:462\n511#5,6:463\n*S KotlinDebug\n*F\n+ 1 PeerDeviceStatusManager.kt\ncom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager\n*L\n235#1:457\n108#1:443,2\n221#1:445,2\n235#1:447,9\n235#1:456\n235#1:458\n235#1:459\n236#1:460,2\n240#1:469,2\n239#1:462\n239#1:463,6\n*E\n"})
public final class PeerDeviceStatusManager extends PetaStepSerializer implements RelayListener, VersionSendListener, VersionNegotiationManager, ConnectionStateListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int SELF_VERSION_FOR_AIR = 8;
    private static final int SELF_VERSION_FOR_AIR_PRO = 100;
    /* access modifiers changed from: private */
    @Nullable
    public Job checkVersionSendJob;
    /* access modifiers changed from: private */
    @NotNull
    public final HostStartManager hostStatusManager = new HostStartManager();
    @NotNull
    private final Lazy infoSlice$delegate;
    @NotNull
    private final Lazy listeners$delegate;
    /* access modifiers changed from: private */
    public volatile int mCurSendVersion;
    /* access modifiers changed from: private */
    public final int mMaxSendCount;
    /* access modifiers changed from: private */
    public final long mMaxSendVersionDuringTime;
    /* access modifiers changed from: private */
    @NotNull
    public final HashMap<String, PeerState> stateMap = new HashMap<>();
    /* access modifiers changed from: private */
    @NotNull
    public final Map<String, Integer> versionMap = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    @NotNull
    public final VersionSendManager versionSendManager = new VersionSendManager(this, getTag());
    /* access modifiers changed from: private */
    @NotNull
    public final Set<String> versionSentDevices = new ConcurrentHashSet();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager$Companion;", "", "()V", "SELF_VERSION_FOR_AIR", "", "SELF_VERSION_FOR_AIR_PRO", "getSelfVersion", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getSelfVersion() {
            boolean isAirPro = InterconnectManager.getInstance().getStarryNetDeviceInfoManager().isAirPro();
            ILog.w("getSelfVersion", "onRelay handleMessage isPro = " + isAirPro);
            if (isAirPro) {
                ILog.w("getSelfVersion", "SELF_VERSION_FOR_AIR_PRO = 100");
                return 100;
            }
            ILog.w("getSelfVersion", "SELF_VERSION_FOR_AIR = 8");
            return 8;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.upuphone.xr.interconnect.business.connect.PeerState[] r0 = com.upuphone.xr.interconnect.business.connect.PeerState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.upuphone.xr.interconnect.business.connect.PeerState r1 = com.upuphone.xr.interconnect.business.connect.PeerState.NEGOTIATED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.upuphone.xr.interconnect.business.connect.PeerState r1 = com.upuphone.xr.interconnect.business.connect.PeerState.MISSING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.upuphone.xr.interconnect.business.connect.PeerState r1 = com.upuphone.xr.interconnect.business.connect.PeerState.AVAILABLE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.upuphone.xr.interconnect.business.connect.PeerState r1 = com.upuphone.xr.interconnect.business.connect.PeerState.STARTED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.connect.PeerDeviceStatusManager.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeerDeviceStatusManager(@NotNull ListenerLinkingCollector<PeerStateListener> listenerLinkingCollector) {
        super(AnonymousClass1.INSTANCE, (String) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(listenerLinkingCollector, "listenerLinkingCollector");
        this.listeners$delegate = LazyKt.lazy(new PeerDeviceStatusManager$listeners$2(listenerLinkingCollector));
        this.infoSlice$delegate = LazyKt.lazy(PeerDeviceStatusManager$infoSlice$2.INSTANCE);
        this.mMaxSendVersionDuringTime = 1000;
        this.mMaxSendCount = 4;
    }

    /* access modifiers changed from: private */
    public final void changeStateDown(String str, PeerState peerState) {
        PeerState peerState2 = this.stateMap.get(str);
        if (peerState2 == null) {
            peerState2 = PeerState.MISSING;
        }
        Intrinsics.checkNotNull(peerState2);
        String tag = getTag();
        int numericalLevel = peerState2.getNumericalLevel();
        ILog.e(tag, "changeStateDown oldState numericalLevel = " + numericalLevel);
        if (peerState.getNumericalLevel() < peerState2.getNumericalLevel()) {
            String tag2 = getTag();
            int numericalLevel2 = peerState2.getNumericalLevel();
            ILog.e(tag2, "newState.numericalLevel < oldState.numericalLevel oldState = " + numericalLevel2);
            if (peerState2 == PeerState.NEGOTIATED) {
                ILog.e(getTag(), "changeStateDown unset");
                getInfoSlice().unset("peer", "version");
            }
            updateState(str, peerState2, peerState);
            return;
        }
        String tag3 = getTag();
        ILog.d(tag3, "Not informing listeners as #" + str + " state has hot changed.");
    }

    /* access modifiers changed from: private */
    public final void changeStateUp(String str, PeerState peerState) {
        PeerState peerState2 = this.stateMap.get(str);
        if (peerState2 == null) {
            peerState2 = PeerState.MISSING;
        }
        Intrinsics.checkNotNull(peerState2);
        String tag = getTag();
        int numericalLevel = peerState2.getNumericalLevel();
        ILog.e(tag, "changeStateUp oldState numericalLevel = " + numericalLevel);
        if (peerState.getNumericalLevel() > peerState2.getNumericalLevel()) {
            String tag2 = getTag();
            int numericalLevel2 = peerState2.getNumericalLevel();
            int numericalLevel3 = peerState.getNumericalLevel();
            ILog.e(tag2, "changeStateUp oldState numericalLevel = " + numericalLevel2 + ",newState numericalLevel = " + numericalLevel3);
            updateState(str, peerState2, peerState);
            return;
        }
        String tag3 = getTag();
        ILog.d(tag3, "Not informing listeners as #" + str + " state has hot changed.");
    }

    /* access modifiers changed from: private */
    public final void confirmVersionSent(String str, int i) {
        this.hostStatusManager.cancelHostStartJob(str);
        this.versionSendManager.cancelVersionSendJob(str);
        this.versionSentDevices.add(str);
        Integer num = this.versionMap.get(str);
        if (num != null && num.intValue() == i) {
            startCommunication(str);
        }
    }

    /* access modifiers changed from: private */
    public final void downToFirstVersion(String str) {
        String tag = getTag();
        ILog.w(tag, "downToFirstVersion " + str + " to 0 ");
        this.hostStatusManager.cancelHostStartJob(str);
        this.versionMap.put(str, 0);
        if (isVersionSent(str)) {
            startCommunication(str);
        }
    }

    private final String filterDeviceById(String str) {
        if (str != null) {
            return str;
        }
        ILog.w(getTag(), "Dropping device with invalid id!");
        return null;
    }

    private final DataBinderSlice getInfoSlice() {
        return (DataBinderSlice) this.infoSlice$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Set<PeerStateListener> getListeners() {
        return (Set) this.listeners$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void initiateVersionSending(String str) {
        int i;
        if (!isDeviceNegotiated(str)) {
            Integer num = this.versionMap.get(str);
            Companion companion = Companion;
            int selfVersion = companion.getSelfVersion();
            if ((num != null && num.intValue() == selfVersion) || num == null) {
                i = companion.getSelfVersion();
            } else if (num.intValue() < companion.getSelfVersion()) {
                i = num.intValue();
            } else if (!isVersionSent(str)) {
                i = companion.getSelfVersion();
            } else {
                ILog.d(getTag(), "Peer version is higher than ours, waiting for them to fall back.");
                return;
            }
            startVersionSendJob(str, i);
            return;
        }
        ILog.d(getTag(), "Peer already negotiated, no need to send version.");
    }

    /* access modifiers changed from: private */
    public final int parseConnectMessage(byte[] bArr) {
        String tag = getTag();
        int length = bArr.length;
        ILog.d(tag, "Parsing " + length + "B data as connect message.");
        try {
            return ConnectMessageOuterClass.ConnectMessage.parseFrom(bArr).getVersion();
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            String tag2 = getTag();
            int length2 = bArr.length;
            String localizedMessage = e.getLocalizedMessage();
            ILog.d(tag2, "Parsing as connect message failed for " + length2 + "B data: " + localizedMessage + ".");
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public final void resetDeviceStatus(String str) {
        this.hostStatusManager.cancelHostStartJob(str);
        this.versionSendManager.cancelVersionSendJob(str);
        this.versionMap.remove(str);
        this.versionSentDevices.remove(str);
    }

    /* access modifiers changed from: private */
    public final void startCommunication(String str) {
        changeStateUp(str, PeerState.NEGOTIATED);
        if (InterconnectManager.getInstance().isGlassPlatform()) {
            new TimeManager().sendTimeRequest(str);
        }
    }

    private final void startVersionSendJob(String str, int i) {
        serialize("startVersionSendJob send to " + str, new PeerDeviceStatusManager$startVersionSendJob$1(this, i, str));
    }

    private final void updateState(String str, PeerState peerState, PeerState peerState2) {
        String tag = getTag();
        ILog.d(tag, "#" + str + " has changed from " + peerState + " to " + peerState2 + ".");
        if (peerState2 != PeerState.MISSING) {
            this.stateMap.put(str, peerState2);
        } else {
            this.stateMap.remove(str);
        }
        for (PeerStateListener peerStateListener : getListeners()) {
            int i = WhenMappings.$EnumSwitchMapping$0[peerState2.ordinal()];
            if (i == 1) {
                Integer version = getVersion(str);
                Intrinsics.checkNotNull(version);
                getInfoSlice().set(new String[]{"peer", "version"}, version.intValue());
                peerStateListener.onPeerNegotiated(str);
            } else if (i == 2) {
                peerStateListener.onPeerUnavailable(str);
            } else if (i != 3) {
                if (i == 4) {
                    peerStateListener.onPeerStarted(str);
                }
            } else if (peerState == PeerState.MISSING) {
                peerStateListener.onPeerAvailable(str);
            } else {
                peerStateListener.onPeerStopped(str);
            }
        }
    }

    @Nullable
    public final PeerInfo getNegotiatedPeer() {
        String str;
        Iterator<Map.Entry<String, PeerState>> it = this.stateMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            Map.Entry next = it.next();
            str = (String) next.getKey();
            if (((PeerState) next.getValue()) != PeerState.NEGOTIATED) {
                str = null;
                continue;
            }
            if (str != null) {
                break;
            }
        }
        if (str == null) {
            return null;
        }
        Integer num = this.versionMap.get(str);
        Intrinsics.checkNotNull(num);
        return new PeerInfo(str, num.intValue());
    }

    @Nullable
    public final PeerInfo getPeerInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        PeerState peerState = this.stateMap.get(str);
        if ((peerState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[peerState.ordinal()]) != 1) {
            return null;
        }
        Integer num = this.versionMap.get(str);
        Intrinsics.checkNotNull(num);
        return new PeerInfo(str, num.intValue());
    }

    @Nullable
    public Integer getVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        return this.versionMap.get(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a5, code lost:
        if (r8 == null) goto L_0x00a7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleDeviceListChange(@org.jetbrains.annotations.Nullable java.util.List<? extends com.upuphone.runasone.device.StarryDevice> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "#"
            r1 = 0
            if (r8 == 0) goto L_0x007c
            java.util.Iterator r2 = r8.iterator()
        L_0x0009:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x007c
            java.lang.Object r3 = r2.next()
            com.upuphone.runasone.device.StarryDevice r3 = (com.upuphone.runasone.device.StarryDevice) r3
            java.lang.String r4 = r7.getTag()
            if (r3 == 0) goto L_0x0020
            java.lang.String r5 = r3.getId()
            goto L_0x0021
        L_0x0020:
            r5 = r1
        L_0x0021:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            r6.append(r5)
            java.lang.String r5 = " confirmed to have host available, handleDeviceListChange device = "
            r6.append(r5)
            r6.append(r3)
            java.lang.String r5 = r6.toString()
            com.upuphone.xr.interconnect.util.log.ILog.d(r4, r5)
            if (r3 == 0) goto L_0x0042
            java.lang.String r4 = r3.getId()
            goto L_0x0043
        L_0x0042:
            r4 = r1
        L_0x0043:
            java.lang.String r4 = r7.filterDeviceById(r4)
            if (r4 != 0) goto L_0x004a
            return
        L_0x004a:
            java.lang.String r5 = r7.getTag()
            java.lang.String r6 = "handleDeviceListChange start changeStateUp"
            com.upuphone.xr.interconnect.util.log.ILog.d(r5, r6)
            com.upuphone.xr.interconnect.business.connect.PeerState r5 = com.upuphone.xr.interconnect.business.connect.PeerState.AVAILABLE
            r7.changeStateUp(r4, r5)
            if (r3 == 0) goto L_0x0078
            com.upuphone.xr.interconnect.business.connect.behavior.DeviceTraits r3 = com.upuphone.xr.interconnect.business.connect.behavior.DeviceTraitsKt.getTraits((com.upuphone.runasone.device.StarryDevice) r3)
            if (r3 == 0) goto L_0x0078
            boolean r3 = r3.isHostAlwaysRunning()
            if (r3 != 0) goto L_0x0078
            java.lang.String r3 = r7.getTag()
            java.lang.String r5 = "device?.traits?.isHostAlwaysRunning == false"
            com.upuphone.xr.interconnect.util.log.ILog.d(r3, r5)
            com.upuphone.xr.interconnect.business.connect.primary.HostStartManager r3 = r7.hostStatusManager
            java.lang.String r5 = r7.getTag()
            r3.launchHostStartJob(r4, r5)
        L_0x0078:
            r7.initiateVersionSending(r4)
            goto L_0x0009
        L_0x007c:
            if (r8 == 0) goto L_0x00a7
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x0087:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x00a1
            java.lang.Object r3 = r8.next()
            com.upuphone.runasone.device.StarryDevice r3 = (com.upuphone.runasone.device.StarryDevice) r3
            if (r3 == 0) goto L_0x009a
            java.lang.String r3 = r3.getId()
            goto L_0x009b
        L_0x009a:
            r3 = r1
        L_0x009b:
            if (r3 == 0) goto L_0x0087
            r2.add(r3)
            goto L_0x0087
        L_0x00a1:
            java.util.Set r8 = kotlin.collections.CollectionsKt.toSet(r2)
            if (r8 != 0) goto L_0x00ab
        L_0x00a7:
            java.util.Set r8 = kotlin.collections.SetsKt.emptySet()
        L_0x00ab:
            java.util.HashMap<java.lang.String, com.upuphone.xr.interconnect.business.connect.PeerState> r1 = r7.stateMap
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x00b5:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00ea
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.String r3 = r7.getTag()
            java.lang.Object r4 = r2.getKey()
            java.lang.Object r2 = r2.getValue()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "stateValue key = "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = ",value = "
            r5.append(r4)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            com.upuphone.xr.interconnect.util.log.ILog.d(r3, r2)
            goto L_0x00b5
        L_0x00ea:
            java.util.HashMap<java.lang.String, com.upuphone.xr.interconnect.business.connect.PeerState> r1 = r7.stateMap
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x00f9:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0123
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getValue()
            com.upuphone.xr.interconnect.business.connect.PeerState r4 = (com.upuphone.xr.interconnect.business.connect.PeerState) r4
            int r4 = r4.getNumericalLevel()
            com.upuphone.xr.interconnect.business.connect.PeerState r5 = com.upuphone.xr.interconnect.business.connect.PeerState.AVAILABLE
            int r5 = r5.getNumericalLevel()
            if (r4 < r5) goto L_0x00f9
            java.lang.Object r4 = r3.getKey()
            java.lang.Object r3 = r3.getValue()
            r2.put(r4, r3)
            goto L_0x00f9
        L_0x0123:
            java.util.Set r1 = r2.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x012b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0167
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getKey()
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = r8.contains(r2)
            if (r3 != 0) goto L_0x012b
            java.lang.String r3 = r7.getTag()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r2)
            java.lang.String r5 = " confirmed to have host unavailable."
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.upuphone.xr.interconnect.util.log.ILog.d(r3, r4)
            com.upuphone.xr.interconnect.business.connect.PeerState r3 = com.upuphone.xr.interconnect.business.connect.PeerState.MISSING
            r7.changeStateDown(r2, r3)
            r7.resetDeviceStatus(r2)
            goto L_0x012b
        L_0x0167:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.connect.PeerDeviceStatusManager.handleDeviceListChange(java.util.List):void");
    }

    public void handleMessage(@NotNull String str, @Nullable String str2, @NotNull byte[] bArr, @NotNull Map<Integer, ? extends Function2<? super byte[], ? super String, Unit>> map) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(bArr, "data");
        Intrinsics.checkNotNullParameter(map, "consumerMap");
        serialize("message arrival", new PeerDeviceStatusManager$handleMessage$1(this, str, str2, bArr, map));
    }

    public final boolean isDeviceNegotiated(@Nullable String str) {
        return this.stateMap.get(str) == PeerState.NEGOTIATED;
    }

    public boolean isVersionReceived(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        return this.versionMap.containsKey(str);
    }

    public boolean isVersionSent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        return this.versionSentDevices.contains(str);
    }

    public final void onAbilityReady(@NotNull RelayAbility relayAbility) {
        Intrinsics.checkNotNullParameter(relayAbility, "relayAbility");
        serialize(JoinPoint.INITIALIZATION, new PeerDeviceStatusManager$onAbilityReady$1(this, relayAbility));
    }

    public void onConnectionBinding(@NotNull StarryNetDevice starryNetDevice) {
        ConnectionStateListener.DefaultImpls.onConnectionBinding(this, starryNetDevice);
    }

    public void onConnectionBound(@NotNull StarryNetDevice starryNetDevice) {
        ConnectionStateListener.DefaultImpls.onConnectionBound(this, starryNetDevice);
    }

    public void onConnectionConnecting(@NotNull StarryDevice starryDevice) {
        ConnectionStateListener.DefaultImpls.onConnectionConnecting(this, starryDevice);
    }

    public void onConnectionUnbound(@NotNull StarryNetDevice starryNetDevice) {
        ConnectionStateListener.DefaultImpls.onConnectionUnbound(this, starryNetDevice);
    }

    public void onPrimaryConnectionConnected(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        serialize("primary device connection", new PeerDeviceStatusManager$onPrimaryConnectionConnected$1(this, starryNetDevice));
    }

    public void onPrimaryConnectionDisconnected(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        serialize("primary device disconnection all version", new PeerDeviceStatusManager$onPrimaryConnectionDisconnected$1(this, starryNetDevice));
    }

    public void onRelay(@Nullable String str, @Nullable String str2, @Nullable byte[] bArr) {
    }

    public void onRelayDeviceListChanged(@NotNull String str, @Nullable List<StarryDevice> list) {
        Intrinsics.checkNotNullParameter(str, "uniteCode");
        String tag = getTag();
        ILog.d(tag, str + " changed on devices , new do nothing handleDeviceListChange");
        serialize("peer install state change", new PeerDeviceStatusManager$onRelayDeviceListChanged$1(this, str));
    }

    public void onRemoteError(@Nullable String str, @Nullable String str2, int i) {
        serialize("peer app error", new PeerDeviceStatusManager$onRemoteError$1(this, str, str2, i));
    }

    public void onRemoteStarted(@Nullable String str, @Nullable String str2) {
        serialize("peer app start", new PeerDeviceStatusManager$onRemoteStarted$1(this, str));
    }

    public void onRemoteStopped(@Nullable String str, @Nullable String str2) {
    }

    public void onSecondaryConnectionConnected(@NotNull StarryNetDevice starryNetDevice) {
        ConnectionStateListener.DefaultImpls.onSecondaryConnectionConnected(this, starryNetDevice);
    }

    public void onSecondaryConnectionDisconnected(@NotNull StarryNetDevice starryNetDevice) {
        ConnectionStateListener.DefaultImpls.onSecondaryConnectionDisconnected(this, starryNetDevice);
    }

    public void onVersionSendSuccess(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        serialize("version send success", new PeerDeviceStatusManager$onVersionSendSuccess$1(this, str, i));
    }
}
