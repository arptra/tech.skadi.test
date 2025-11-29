package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynetsdk.ability.relay.RelayAbility;
import com.upuphone.starrynetsdk.device.connection.ConnectionListener;
import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.starrynetsdk.device.discovery.DevicesDiscoverer;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.adapter.StarryNetSdkAdapterImpl;
import com.upuphone.xr.interconnect.api.DataBinderSlice;
import com.upuphone.xr.interconnect.business.messenger.MessageRxProcessor;
import com.upuphone.xr.interconnect.common.IP2pAcquireCallback;
import com.upuphone.xr.interconnect.entity.StarryDeviceExt;
import com.upuphone.xr.interconnect.ipc.IpcClientManager;
import com.upuphone.xr.interconnect.main.StarryNetAbilityInstallListener;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.remote.BinderClient;
import com.upuphone.xr.interconnect.remote.BinderClientDiedCallback;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00182\b\u00108\u001a\u0004\u0018\u000109J\u0018\u0010:\u001a\u0002062\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\u000e\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020\u0015J9\u0010A\u001a\u0002062\u0006\u0010B\u001a\u00020\u00182\u0017\u0010C\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u0002060D¢\u0006\u0002\bE2\u000e\b\u0002\u0010F\u001a\b\u0012\u0004\u0012\u0002060GH\u0007J\u001a\u0010H\u001a\u0002062\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010I\u001a\u00020>H\u0016J\u0012\u0010J\u001a\u0002062\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\"\u0010M\u001a\u0002062\u0006\u0010N\u001a\u00020>2\b\u0010O\u001a\u0004\u0018\u00010<2\u0006\u0010P\u001a\u00020>H\u0016J\u001a\u0010Q\u001a\u0002062\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010I\u001a\u00020>H\u0016J\u0016\u0010R\u001a\u0002062\u0006\u0010B\u001a\u00020\u00182\u0006\u0010S\u001a\u00020\u0018J\u0018\u0010T\u001a\u0002062\b\u0010U\u001a\u0004\u0018\u00010\u00182\u0006\u0010V\u001a\u00020>J\u0010\u0010W\u001a\u0002062\u0006\u0010X\u001a\u00020\u0015H\u0016J\u000e\u0010Y\u001a\u0002062\u0006\u00107\u001a\u00020\u0018J\u001a\u0010Z\u001a\u0002062\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010I\u001a\u00020>H\u0002J\u0017\u0010[\u001a\u0004\u0018\u0001062\b\u0010B\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\\J\u001c\u0010]\u001a\u000206*\u00020\u001c2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019`\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006^"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/ConnectManager;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "Lcom/upuphone/xr/interconnect/main/StarryNetAbilityManager$OnStarryAbilityStateListener;", "Lcom/upuphone/starrynetsdk/device/connection/ConnectionListener;", "Lcom/upuphone/xr/interconnect/remote/BinderClientDiedCallback;", "()V", "baseConnectionManager", "Lcom/upuphone/xr/interconnect/business/connect/BaseConnectionManager;", "bondStateManager", "Lcom/upuphone/xr/interconnect/business/connect/BondStateManager;", "getBondStateManager", "()Lcom/upuphone/xr/interconnect/business/connect/BondStateManager;", "connectionListenerManager", "Lcom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager;", "getConnectionListenerManager", "()Lcom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager;", "connectionStateManager", "Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateManager;", "getConnectionStateManager", "()Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateManager;", "curBleIsConnect", "", "deviceConnectionLevelManagers", "Ljava/util/HashMap;", "", "Lcom/upuphone/xr/interconnect/business/connect/DeviceConnectionLevelManager;", "Lkotlin/collections/HashMap;", "devicesConnector", "Lcom/upuphone/starrynetsdk/device/connection/DevicesConnector;", "devicesDiscoverer", "Lcom/upuphone/starrynetsdk/device/discovery/DevicesDiscoverer;", "infoSlice", "Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "getInfoSlice", "()Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "infoSlice$delegate", "Lkotlin/Lazy;", "messageRxProcessor", "Lcom/upuphone/xr/interconnect/business/messenger/MessageRxProcessor;", "p2pConnectionManager", "Lcom/upuphone/xr/interconnect/business/connect/P2pConnectionManager;", "getP2pConnectionManager", "()Lcom/upuphone/xr/interconnect/business/connect/P2pConnectionManager;", "peerAppRelayListener", "Lcom/upuphone/xr/interconnect/business/connect/PeerAppRelayListener;", "peerAppStatusManager", "Lcom/upuphone/xr/interconnect/business/connect/PeerAppStatusManager;", "getPeerAppStatusManager", "()Lcom/upuphone/xr/interconnect/business/connect/PeerAppStatusManager;", "peerDeviceStatusManager", "Lcom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager;", "getPeerDeviceStatusManager", "()Lcom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager;", "acquireP2p", "", "identifier", "callback", "Lcom/upuphone/xr/interconnect/common/IP2pAcquireCallback;", "handleRingConnectStateChange", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "state", "", "interceptConnectProcess", "intercept", "manageDeviceConnectionLevel", "deviceId", "manageAction", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "onDeviceNotConnected", "Lkotlin/Function0;", "onBondStateChange", "newState", "onClientDied", "client", "Lcom/upuphone/xr/interconnect/remote/BinderClient;", "onConnectFail", "type", "starryDevice", "code", "onConnectStateChange", "onDeviceRenamed", "newName", "onPairingKeyReceived", "deviceName", "pairingKey", "onStateChanged", "isEnable", "releaseP2p", "revertPeerStatus", "unbindDevice", "(Ljava/lang/String;)Lkotlin/Unit;", "handleGlassConnectStateChange", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConnectManager extends PetaStepSerializer implements StarryNetAbilityManager.OnStarryAbilityStateListener, ConnectionListener, BinderClientDiedCallback {
    /* access modifiers changed from: private */
    @NotNull
    public final BaseConnectionManager baseConnectionManager;
    @NotNull
    private final BondStateManager bondStateManager;
    @NotNull
    private final ConnectionListenerManager connectionListenerManager;
    @NotNull
    private final ConnectionStateManager connectionStateManager;
    private boolean curBleIsConnect = true;
    /* access modifiers changed from: private */
    @NotNull
    public final HashMap<String, DeviceConnectionLevelManager> deviceConnectionLevelManagers = new HashMap<>();
    /* access modifiers changed from: private */
    @Nullable
    public DevicesConnector devicesConnector;
    /* access modifiers changed from: private */
    @Nullable
    public DevicesDiscoverer devicesDiscoverer;
    @NotNull
    private final Lazy infoSlice$delegate = LazyKt.lazy(ConnectManager$infoSlice$2.INSTANCE);
    /* access modifiers changed from: private */
    @NotNull
    public final MessageRxProcessor messageRxProcessor;
    @NotNull
    private final P2pConnectionManager p2pConnectionManager;
    /* access modifiers changed from: private */
    @NotNull
    public final PeerAppRelayListener peerAppRelayListener;
    @NotNull
    private final PeerAppStatusManager peerAppStatusManager;
    @NotNull
    private final PeerDeviceStatusManager peerDeviceStatusManager;

    public ConnectManager() {
        super(AnonymousClass1.INSTANCE, (String) null, 2, (DefaultConstructorMarker) null);
        ListenerLinkingCollector listenerLinkingCollector = new ListenerLinkingCollector();
        ListenerLinkingCollector listenerLinkingCollector2 = new ListenerLinkingCollector();
        ListenerLinkingCollector listenerLinkingCollector3 = new ListenerLinkingCollector();
        ListenerLinkingCollector listenerLinkingCollector4 = new ListenerLinkingCollector();
        ListenerLinkingCollector listenerLinkingCollector5 = new ListenerLinkingCollector();
        BaseConnectionManager baseConnectionManager2 = new BaseConnectionManager(listenerLinkingCollector2);
        this.baseConnectionManager = baseConnectionManager2;
        StarryNetSdkAdapterImpl starryNetSdkAdapterImpl = StarryNetSdkAdapterImpl.INSTANCE;
        BondStateManager createBondStateManager = starryNetSdkAdapterImpl.createBondStateManager(listenerLinkingCollector3);
        this.bondStateManager = createBondStateManager;
        ConnectionStateManager createConnectionStateManager = starryNetSdkAdapterImpl.createConnectionStateManager(createBondStateManager, listenerLinkingCollector4, listenerLinkingCollector);
        this.connectionStateManager = createConnectionStateManager;
        P2pConnectionManager p2pConnectionManager2 = new P2pConnectionManager();
        this.p2pConnectionManager = p2pConnectionManager2;
        PeerAppStatusManager peerAppStatusManager2 = new PeerAppStatusManager(baseConnectionManager2);
        this.peerAppStatusManager = peerAppStatusManager2;
        PeerDeviceStatusManager peerDeviceStatusManager2 = new PeerDeviceStatusManager(listenerLinkingCollector5);
        this.peerDeviceStatusManager = peerDeviceStatusManager2;
        ConnectionListenerManager connectionListenerManager2 = new ConnectionListenerManager(createBondStateManager, createConnectionStateManager, peerDeviceStatusManager2);
        this.connectionListenerManager = connectionListenerManager2;
        this.messageRxProcessor = new MessageRxProcessor(peerDeviceStatusManager2);
        this.peerAppRelayListener = new PeerAppRelayListener();
        listenerLinkingCollector.setListeners(SetsKt.emptySet());
        listenerLinkingCollector2.setListeners(SetsKt.hashSetOf(createBondStateManager, createConnectionStateManager));
        listenerLinkingCollector3.setListeners(SetsKt.hashSetOf(createConnectionStateManager));
        listenerLinkingCollector4.setListeners(SetsKt.hashSetOf(connectionListenerManager2, peerDeviceStatusManager2, p2pConnectionManager2));
        listenerLinkingCollector5.setListeners(SetsKt.hashSetOf(connectionListenerManager2, peerAppStatusManager2));
        StarryNetAbilityManager.getInstance().registerOnStarryAbilityStateListener(this);
        IpcClientManager.INSTANCE.addListener(this);
    }

    private final DataBinderSlice getInfoSlice() {
        return (DataBinderSlice) this.infoSlice$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void handleGlassConnectStateChange(DevicesConnector devicesConnector2, StarryDevice starryDevice, int i) {
        boolean checkConnectionState = devicesConnector2.checkConnectionState(i, 1);
        boolean checkConnectionState2 = devicesConnector2.checkConnectionState(i, 8);
        boolean checkConnectionState3 = devicesConnector2.checkConnectionState(i, 2);
        String tag = getTag();
        String id = starryDevice.getId();
        ILog.i(tag, "#" + id + " connect state update: BLE(" + checkConnectionState + ") BR(" + checkConnectionState2 + ") P2P(" + checkConnectionState3 + ").");
        String id2 = starryDevice.getId();
        if (id2 != null) {
            if (checkConnectionState || checkConnectionState2 || checkConnectionState3) {
                HashMap<String, DeviceConnectionLevelManager> hashMap = this.deviceConnectionLevelManagers;
                DeviceConnectionLevelManager deviceConnectionLevelManager = new DeviceConnectionLevelManager(id2);
                StarryNetAbilityManager.getInstance().registerOnStarryAbilityStateListener(deviceConnectionLevelManager);
                Unit unit = Unit.INSTANCE;
                hashMap.putIfAbsent(id2, deviceConnectionLevelManager);
                DeviceConnectionLevelManager deviceConnectionLevelManager2 = this.deviceConnectionLevelManagers.get(id2);
                if (deviceConnectionLevelManager2 != null) {
                    deviceConnectionLevelManager2.onEnhanceStateChange(checkConnectionState3);
                }
            } else {
                DeviceConnectionLevelManager remove = this.deviceConnectionLevelManagers.remove(id2);
                if (remove != null) {
                    StarryNetAbilityManager.getInstance().unregisterOnStarryAbilityStateListener(remove);
                    remove.destroy();
                }
            }
        }
        this.baseConnectionManager.onConnectStateChangeForGlass(starryDevice, checkConnectionState, checkConnectionState2);
        P2pConnectionManager p2pConnectionManager2 = this.p2pConnectionManager;
        String id3 = starryDevice.getId();
        Intrinsics.checkNotNullExpressionValue(id3, "getId(...)");
        p2pConnectionManager2.onStateChange(checkConnectionState3, id3, starryDevice);
    }

    /* access modifiers changed from: private */
    public final void handleRingConnectStateChange(StarryDevice starryDevice, int i) {
        String tag = getTag();
        String id = starryDevice.getId();
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        ILog.e(tag, "handleRingConnectStateChange device id = " + id + ",state = " + i + ", connect = " + z);
        this.baseConnectionManager.onConnectStateChangeForRing(starryDevice, i);
    }

    public static /* synthetic */ void manageDeviceConnectionLevel$default(ConnectManager connectManager, String str, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = ConnectManager$manageDeviceConnectionLevel$1.INSTANCE;
        }
        connectManager.manageDeviceConnectionLevel(str, function1, function0);
    }

    /* access modifiers changed from: private */
    public final void revertPeerStatus(StarryDevice starryDevice, int i) {
        String tag = getTag();
        ILog.w(tag, "revertPeerStatus ,device = " + starryDevice + ",newState = " + i);
        DevicesConnector devicesConnector2 = this.devicesConnector;
        if (devicesConnector2 == null) {
            ILog.w(getTag(), "revertPeerStatus Receiving connect state change listener call when connector is not initialized.");
            return;
        }
        boolean checkConnectionState = devicesConnector2.checkConnectionState(i, 1);
        String tag2 = getTag();
        boolean z = this.curBleIsConnect;
        ILog.w(tag2, "revertPeerStatus isBleConnected = " + checkConnectionState + ",curBleIsConnect = " + z);
        if (checkConnectionState && !this.curBleIsConnect) {
            if (starryDevice != null) {
                String tag3 = getTag();
                ILog.w(tag3, "revertPeerStatus setBleConnectDevice starryDevice = " + starryDevice);
                this.connectionStateManager.setBleConnectDevice(starryDevice, StarryDeviceExt.wrapForConnection(starryDevice));
            }
            ILog.w(getTag(), "revertPeerStatus isBleConnected is true and handleDeviceListChange");
            RelayAbility relayAbility = StarryNetAbilityManager.getInstance().getRelayAbility();
            this.peerDeviceStatusManager.handleDeviceListChange(XrSdkBondDeviceUtil.INSTANCE.getGlassDevice(relayAbility != null ? relayAbility.getRelayDeviceList(InterconnectManager.getInstance().getPeerPackageName()) : null));
        }
        this.curBleIsConnect = checkConnectionState;
    }

    public final void acquireP2p(@NotNull String str, @Nullable IP2pAcquireCallback iP2pAcquireCallback) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        PeerInfo negotiatedPeer = this.peerDeviceStatusManager.getNegotiatedPeer();
        String deviceId = negotiatedPeer != null ? negotiatedPeer.getDeviceId() : null;
        if (deviceId != null) {
            manageDeviceConnectionLevel(deviceId, new ConnectManager$acquireP2p$1(str, iP2pAcquireCallback), new ConnectManager$acquireP2p$2(iP2pAcquireCallback));
        } else if (iP2pAcquireCallback != null) {
            iP2pAcquireCallback.onFail(-1);
        }
    }

    @NotNull
    public final BondStateManager getBondStateManager() {
        return this.bondStateManager;
    }

    @NotNull
    public final ConnectionListenerManager getConnectionListenerManager() {
        return this.connectionListenerManager;
    }

    @NotNull
    public final ConnectionStateManager getConnectionStateManager() {
        return this.connectionStateManager;
    }

    @NotNull
    public final P2pConnectionManager getP2pConnectionManager() {
        return this.p2pConnectionManager;
    }

    @NotNull
    public final PeerAppStatusManager getPeerAppStatusManager() {
        return this.peerAppStatusManager;
    }

    @NotNull
    public final PeerDeviceStatusManager getPeerDeviceStatusManager() {
        return this.peerDeviceStatusManager;
    }

    public final void interceptConnectProcess(boolean z) {
        StarryNetAbilityInstallListener.INSTANCE.useDevicesDiscoverer("conn interception", new ConnectManager$interceptConnectProcess$1(z));
    }

    @JvmOverloads
    public final void manageDeviceConnectionLevel(@NotNull String str, @NotNull Function1<? super DeviceConnectionLevelManager, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(function1, "manageAction");
        manageDeviceConnectionLevel$default(this, str, function1, (Function0) null, 4, (Object) null);
    }

    public void onBondStateChange(@Nullable StarryDevice starryDevice, int i) {
        String tag = getTag();
        String num = Integer.toString(i, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        Byte b = null;
        Byte valueOf = starryDevice != null ? Byte.valueOf(starryDevice.getTerminalType()) : null;
        ILog.d(tag, "Received bond state change of " + starryDevice + ": " + num + ".,terminalType = " + valueOf);
        String tag2 = getTag();
        if (starryDevice != null) {
            b = Byte.valueOf(starryDevice.getTerminalType());
        }
        ILog.d(tag2, "Received bond state change terminalType = " + b);
        if (starryDevice != null) {
            XrSdkBondDeviceUtil xrSdkBondDeviceUtil = XrSdkBondDeviceUtil.INSTANCE;
            if (xrSdkBondDeviceUtil.checkDeviceTypeIsGlass(starryDevice.getTerminalType())) {
                ILog.d(getTag(), "onBindStateChangeForGlass");
                this.baseConnectionManager.onBindStateChangeForGlass(starryDevice, i);
            }
            if (xrSdkBondDeviceUtil.checkDeviceTypeIsRing(starryDevice.getTerminalType())) {
                ILog.d(getTag(), "onBindStateChangeForRing");
                this.baseConnectionManager.onBindStateChangeForRing(starryDevice, i);
            }
        }
    }

    public void onClientDied(@Nullable BinderClient binderClient) {
        serialize("client death", new ConnectManager$onClientDied$1(this, binderClient));
    }

    public void onConnectFail(int i, @Nullable StarryDevice starryDevice, int i2) {
        String tag = getTag();
        String str = null;
        String id = starryDevice != null ? starryDevice.getId() : null;
        Byte valueOf = starryDevice != null ? Byte.valueOf(starryDevice.getTerminalType()) : null;
        ILog.d(tag, "onConnectFail Received type-" + i + " failure report of #" + id + ": " + i2 + ",terminalType = " + valueOf);
        String tag2 = getTag();
        Byte valueOf2 = starryDevice != null ? Byte.valueOf(starryDevice.getTerminalType()) : null;
        ILog.d(tag2, "onConnectFail terminalType = " + valueOf2);
        if (starryDevice != null) {
            str = starryDevice.getId();
        }
        if (str != null) {
            byte terminalType = starryDevice.getTerminalType();
            ULog.Delegate delegate = ULog.f6446a;
            String tag3 = getTag();
            delegate.o(tag3, "onConnectFail terminalType = " + terminalType);
            XrSdkBondDeviceUtil xrSdkBondDeviceUtil = XrSdkBondDeviceUtil.INSTANCE;
            if (xrSdkBondDeviceUtil.checkDeviceTypeIsGlass(terminalType)) {
                ILog.w(getTag(), "onConnectFail change listener received glass device. ");
                if (i2 == 112014) {
                    this.connectionStateManager.onIosConnecting(str, starryDevice);
                    this.bondStateManager.onIosBinding(str, starryDevice);
                    return;
                }
                this.connectionListenerManager.onConnectFail(i, starryDevice, i2);
            } else if (xrSdkBondDeviceUtil.checkDeviceTypeIsRing(terminalType)) {
                this.connectionListenerManager.onConnectFail(i, starryDevice, i2);
            }
        }
    }

    public void onConnectStateChange(@Nullable StarryDevice starryDevice, int i) {
        if (starryDevice == null) {
            ILog.w(getTag(), "Connect state change listener received null device.");
            return;
        }
        String tag = getTag();
        String id = starryDevice.getId();
        StDevice starryDevice2 = starryDevice.getStarryDevice();
        Integer valueOf = starryDevice2 != null ? Integer.valueOf(starryDevice2.getBondStatus()) : null;
        byte terminalType = starryDevice.getTerminalType();
        ILog.d(tag, "Connect state changedevice #" + id + ",bondStatus = " + valueOf + ".,device = " + starryDevice + ",terminalType = " + terminalType);
        XrSdkBondDeviceUtil xrSdkBondDeviceUtil = XrSdkBondDeviceUtil.INSTANCE;
        if (xrSdkBondDeviceUtil.checkDeviceTypeIsGlass(starryDevice.getTerminalType())) {
            serialize("connect state change for glass", new ConnectManager$onConnectStateChange$2(this, starryDevice, i));
        }
        if (xrSdkBondDeviceUtil.checkDeviceTypeIsRing(starryDevice.getTerminalType())) {
            serialize("connect state change for ring", new ConnectManager$onConnectStateChange$3(this, starryDevice, i));
        }
    }

    public final void onDeviceRenamed(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "newName");
        this.bondStateManager.onDeviceRenamed(str, str2);
        this.connectionStateManager.onDeviceRenamed(str, str2);
    }

    public final void onPairingKeyReceived(@Nullable String str, int i) {
        ConnectionListenerManager connectionListenerManager2 = this.connectionListenerManager;
        if (str == null) {
            str = "";
        }
        connectionListenerManager2.onPairingKeyReceived(str, i);
    }

    public void onStateChanged(boolean z) {
        serialize("ability update", new ConnectManager$onStateChanged$1(this, z));
    }

    public final void releaseP2p(@NotNull String str) {
        String deviceId;
        Intrinsics.checkNotNullParameter(str, "identifier");
        PeerInfo negotiatedPeer = this.peerDeviceStatusManager.getNegotiatedPeer();
        if (negotiatedPeer != null && (deviceId = negotiatedPeer.getDeviceId()) != null) {
            manageDeviceConnectionLevel$default(this, deviceId, new ConnectManager$releaseP2p$1(str), (Function0) null, 4, (Object) null);
        }
    }

    @Nullable
    public final Unit unbindDevice(@Nullable String str) {
        if (str == null) {
            return null;
        }
        StarryNetAbilityInstallListener.INSTANCE.useDevicesConnector("unbind", new ConnectManager$unbindDevice$1$1(str, this));
        return Unit.INSTANCE;
    }

    @JvmOverloads
    public final void manageDeviceConnectionLevel(@NotNull String str, @NotNull Function1<? super DeviceConnectionLevelManager, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(function1, "manageAction");
        Intrinsics.checkNotNullParameter(function0, "onDeviceNotConnected");
        serialize("device connection level managing", new ConnectManager$manageDeviceConnectionLevel$2(this, function1, str, function0));
    }
}
