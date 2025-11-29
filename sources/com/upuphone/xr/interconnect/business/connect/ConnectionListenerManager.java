package com.upuphone.xr.interconnect.business.connect;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.api.ConnectionListener;
import com.upuphone.xr.interconnect.api.StarryNetDeviceStateChangeListener;
import com.upuphone.xr.interconnect.common.IDeviceBondStateListener;
import com.upuphone.xr.interconnect.common.IDeviceConnectionListener;
import com.upuphone.xr.interconnect.entity.DeviceWrapper;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001fJ\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020$H\u0016J\u0016\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001fJ\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020*H\u0016J\u0010\u0010/\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020*H\u0016J\u0010\u00100\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020*H\u0016J\u0010\u00101\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020*H\u0016J\u0010\u00102\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020$H\u0016J\u0010\u00103\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020$H\u0016J\u0010\u00104\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020$H\u0016J\u0010\u00105\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020$H\u0016J\u0016\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u000fJ\u000e\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u0011J\u000e\u0010<\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u0011J\u000e\u0010=\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u0014J\u000e\u0010>\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\rJ\u000e\u0010?\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u000fJ\u000e\u0010@\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u0011J\u000e\u0010A\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u0011J\u000e\u0010B\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u0014J0\u0010C\u001a\u00020\u001d\"\u0004\b\u0000\u0010D*\u0002HD2\u0017\u0010E\u001a\u0013\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u00020\u001d0F¢\u0006\u0002\bGH\u0002¢\u0006\u0002\u0010HR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateListener;", "Lcom/upuphone/xr/interconnect/business/connect/PeerStateListener;", "bondStateManager", "Lcom/upuphone/xr/interconnect/business/connect/BondStateManager;", "connectionStateManager", "Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateManager;", "peerDeviceStatusManager", "Lcom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager;", "(Lcom/upuphone/xr/interconnect/business/connect/BondStateManager;Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateManager;Lcom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager;)V", "connectionListeners", "", "Lcom/upuphone/xr/interconnect/api/ConnectionListener;", "deviceBondStateListeners", "Lcom/upuphone/xr/interconnect/common/IDeviceBondStateListener;", "deviceConnectionListeners", "Lcom/upuphone/xr/interconnect/common/IDeviceConnectionListener;", "deviceConnectionPriorityListeners", "deviceStateChangeListeners", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceStateChangeListener;", "mainDeviceConnectionListener", "getMainDeviceConnectionListener", "()Lcom/upuphone/xr/interconnect/common/IDeviceConnectionListener;", "setMainDeviceConnectionListener", "(Lcom/upuphone/xr/interconnect/common/IDeviceConnectionListener;)V", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "onConnectFail", "", "type", "", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "code", "onConnectionBinding", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onConnectionBound", "onConnectionConnecting", "onConnectionUnbound", "onPairingKeyReceived", "deviceName", "", "pairingKey", "onPeerAvailable", "deviceId", "onPeerNegotiated", "onPeerStarted", "onPeerStopped", "onPeerUnavailable", "onPrimaryConnectionConnected", "onPrimaryConnectionDisconnected", "onSecondaryConnectionConnected", "onSecondaryConnectionDisconnected", "registerConnectionListener", "listener", "prewarm", "", "registerDeviceBondStateListener", "registerDeviceConnectionListener", "registerDeviceConnectionPriorityListener", "registerDeviceStateChangeListener", "unregisterConnectionListener", "unregisterDeviceBondStateListener", "unregisterDeviceConnectionListener", "unregisterDeviceConnectionPriorityListener", "unregisterDeviceStateChangeListener", "safeCallRemoteListener", "L", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConnectionListenerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,492:1\n1855#2,2:493\n1855#2,2:495\n*S KotlinDebug\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager\n*L\n87#1:493,2\n92#1:495,2\n*E\n"})
public final class ConnectionListenerManager extends PetaStepSerializer implements ConnectionStateListener, PeerStateListener {
    /* access modifiers changed from: private */
    @NotNull
    public final BondStateManager bondStateManager;
    /* access modifiers changed from: private */
    @NotNull
    public final Set<ConnectionListener> connectionListeners = new HashSet();
    /* access modifiers changed from: private */
    @NotNull
    public final ConnectionStateManager connectionStateManager;
    /* access modifiers changed from: private */
    @NotNull
    public final Set<IDeviceBondStateListener> deviceBondStateListeners = new HashSet();
    /* access modifiers changed from: private */
    @NotNull
    public final Set<IDeviceConnectionListener> deviceConnectionListeners = new HashSet();
    /* access modifiers changed from: private */
    @NotNull
    public final Set<IDeviceConnectionListener> deviceConnectionPriorityListeners = new HashSet();
    /* access modifiers changed from: private */
    @NotNull
    public final Set<StarryNetDeviceStateChangeListener> deviceStateChangeListeners = new HashSet();
    @Nullable
    private volatile IDeviceConnectionListener mainDeviceConnectionListener;
    @NotNull
    private final CoroutineScope mainScope = CoroutineScopeKt.b();
    /* access modifiers changed from: private */
    @NotNull
    public final PeerDeviceStatusManager peerDeviceStatusManager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager(@NotNull BondStateManager bondStateManager2, @NotNull ConnectionStateManager connectionStateManager2, @NotNull PeerDeviceStatusManager peerDeviceStatusManager2) {
        super(AnonymousClass1.INSTANCE, (String) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(bondStateManager2, "bondStateManager");
        Intrinsics.checkNotNullParameter(connectionStateManager2, "connectionStateManager");
        Intrinsics.checkNotNullParameter(peerDeviceStatusManager2, "peerDeviceStatusManager");
        this.bondStateManager = bondStateManager2;
        this.connectionStateManager = connectionStateManager2;
        this.peerDeviceStatusManager = peerDeviceStatusManager2;
    }

    /* access modifiers changed from: private */
    public final <L> void safeCallRemoteListener(L l, Function1<? super L, Unit> function1) {
        Job unused = BuildersKt__Builders_commonKt.d(this.mainScope, (CoroutineContext) null, (CoroutineStart) null, new ConnectionListenerManager$safeCallRemoteListener$1(function1, l, this, (Continuation<? super ConnectionListenerManager$safeCallRemoteListener$1>) null), 3, (Object) null);
    }

    @Nullable
    public final IDeviceConnectionListener getMainDeviceConnectionListener() {
        return this.mainDeviceConnectionListener;
    }

    public final void onConnectFail(int i, @NotNull StarryDevice starryDevice, int i2) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("connect fail event", new ConnectionListenerManager$onConnectFail$1(this, starryDevice, i, i2));
    }

    public void onConnectionBinding(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        serialize("binding event", new ConnectionListenerManager$onConnectionBinding$1(this, starryNetDevice));
    }

    public void onConnectionBound(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        serialize("bound event", new ConnectionListenerManager$onConnectionBound$1(this, starryNetDevice));
    }

    public void onConnectionConnecting(@NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("connecting event", new ConnectionListenerManager$onConnectionConnecting$1(this, starryDevice));
    }

    public void onConnectionUnbound(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        serialize("unbound event", new ConnectionListenerManager$onConnectionUnbound$1(this, starryNetDevice));
    }

    public final void onPairingKeyReceived(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "deviceName");
        serialize("pairing key receiving", new ConnectionListenerManager$onPairingKeyReceived$1(this, i, str));
    }

    public void onPeerAvailable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
    }

    public void onPeerNegotiated(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        serialize("peer negotiated", new ConnectionListenerManager$onPeerNegotiated$1(this, str));
    }

    public void onPeerStarted(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
    }

    public void onPeerStopped(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
    }

    public void onPeerUnavailable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
    }

    public void onPrimaryConnectionConnected(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        serialize("primary device connection", new ConnectionListenerManager$onPrimaryConnectionConnected$1(this, starryNetDevice));
    }

    public void onPrimaryConnectionDisconnected(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        serialize("primary device disconnection", new ConnectionListenerManager$onPrimaryConnectionDisconnected$1(this, starryNetDevice));
    }

    public void onSecondaryConnectionConnected(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        serialize("secondary device connection", new ConnectionListenerManager$onSecondaryConnectionConnected$1(this, starryNetDevice));
    }

    public void onSecondaryConnectionDisconnected(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        serialize("secondary device disconnection", new ConnectionListenerManager$onSecondaryConnectionDisconnected$1(this, starryNetDevice));
    }

    public final void registerConnectionListener(@NotNull ConnectionListener connectionListener, boolean z) {
        Intrinsics.checkNotNullParameter(connectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        serialize("connection listener registration", new ConnectionListenerManager$registerConnectionListener$1(this, connectionListener, z));
    }

    public final void registerDeviceBondStateListener(@NotNull IDeviceBondStateListener iDeviceBondStateListener) {
        Intrinsics.checkNotNullParameter(iDeviceBondStateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        serialize("bond state listener registration", new ConnectionListenerManager$registerDeviceBondStateListener$1(this, iDeviceBondStateListener));
    }

    public final void registerDeviceConnectionListener(@NotNull IDeviceConnectionListener iDeviceConnectionListener) {
        Intrinsics.checkNotNullParameter(iDeviceConnectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        serialize("device connection listener registration", new ConnectionListenerManager$registerDeviceConnectionListener$1(this, iDeviceConnectionListener));
    }

    public final void registerDeviceConnectionPriorityListener(@NotNull IDeviceConnectionListener iDeviceConnectionListener) {
        Intrinsics.checkNotNullParameter(iDeviceConnectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        String tag = getTag();
        int size = this.deviceConnectionPriorityListeners.size();
        String stringify = PrettyPrintExtKt.stringify(iDeviceConnectionListener);
        ILog.d(tag, "Adding to " + size + " conn Priority listeners: " + stringify + ".");
        if (this.deviceConnectionPriorityListeners.add(iDeviceConnectionListener)) {
            for (DeviceWrapper deviceWrapper : this.connectionStateManager.getConnectedPrimaryDevices()) {
                if (this.peerDeviceStatusManager.isDeviceNegotiated(deviceWrapper.getId())) {
                    safeCallRemoteListener(iDeviceConnectionListener, new ConnectionListenerManager$registerDeviceConnectionPriorityListener$1$1(deviceWrapper));
                }
            }
            for (DeviceWrapper connectionListenerManager$registerDeviceConnectionPriorityListener$2$1 : this.connectionStateManager.getConnectedSecondaryDevices()) {
                safeCallRemoteListener(iDeviceConnectionListener, new ConnectionListenerManager$registerDeviceConnectionPriorityListener$2$1(connectionListenerManager$registerDeviceConnectionPriorityListener$2$1));
            }
            StarryNetDevice connectedPrimaryRingStarryNetDevice = this.connectionStateManager.getConnectedPrimaryRingStarryNetDevice();
            if (connectedPrimaryRingStarryNetDevice != null) {
                ULog.f6446a.c("PetaStepSerializer", "onConnectStateChanged Priority for ring data");
                safeCallRemoteListener(iDeviceConnectionListener, new ConnectionListenerManager$registerDeviceConnectionPriorityListener$3$1(connectedPrimaryRingStarryNetDevice));
            }
        }
    }

    public final void registerDeviceStateChangeListener(@NotNull StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener) {
        Intrinsics.checkNotNullParameter(starryNetDeviceStateChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        serialize("state change listener registration", new ConnectionListenerManager$registerDeviceStateChangeListener$1(this, starryNetDeviceStateChangeListener));
    }

    public final void setMainDeviceConnectionListener(@Nullable IDeviceConnectionListener iDeviceConnectionListener) {
        this.mainDeviceConnectionListener = iDeviceConnectionListener;
    }

    public final void unregisterConnectionListener(@NotNull ConnectionListener connectionListener) {
        Intrinsics.checkNotNullParameter(connectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        serialize("connection listener removal", new ConnectionListenerManager$unregisterConnectionListener$1(this, connectionListener));
    }

    public final void unregisterDeviceBondStateListener(@NotNull IDeviceBondStateListener iDeviceBondStateListener) {
        Intrinsics.checkNotNullParameter(iDeviceBondStateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        serialize("bond state listener removal", new ConnectionListenerManager$unregisterDeviceBondStateListener$1(this, iDeviceBondStateListener));
    }

    public final void unregisterDeviceConnectionListener(@NotNull IDeviceConnectionListener iDeviceConnectionListener) {
        Intrinsics.checkNotNullParameter(iDeviceConnectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        serialize("device connection listener removal", new ConnectionListenerManager$unregisterDeviceConnectionListener$1(this, iDeviceConnectionListener));
    }

    public final void unregisterDeviceConnectionPriorityListener(@NotNull IDeviceConnectionListener iDeviceConnectionListener) {
        Intrinsics.checkNotNullParameter(iDeviceConnectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        String tag = getTag();
        int size = this.deviceConnectionPriorityListeners.size();
        String stringify = PrettyPrintExtKt.stringify(iDeviceConnectionListener);
        ILog.d(tag, "Removing from " + size + " conn Priority listeners: " + stringify + ".");
        this.deviceConnectionPriorityListeners.remove(iDeviceConnectionListener);
    }

    public final void unregisterDeviceStateChangeListener(@NotNull StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener) {
        Intrinsics.checkNotNullParameter(starryNetDeviceStateChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        serialize("state change listener removal", new ConnectionListenerManager$unregisterDeviceStateChangeListener$1(this, starryNetDeviceStateChangeListener));
    }
}
