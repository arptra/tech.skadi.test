package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.api.DataBinderSlice;
import com.upuphone.xr.interconnect.business.connect.ConnectionStateListener;
import com.upuphone.xr.interconnect.common.IP2pAcquireCallback;
import com.upuphone.xr.interconnect.common.IP2pStateListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020!J\u0010\u0010\"\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u0016J\u0010\u0010$\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/P2pConnectionManager;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateListener;", "()V", "infoSlice", "Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "getInfoSlice", "()Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "infoSlice$delegate", "Lkotlin/Lazy;", "isConnected", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "p2pAcquireCallbackList", "", "Lcom/upuphone/xr/interconnect/common/IP2pAcquireCallback;", "p2pAcquireCallbackListMap", "", "", "p2pAcquireSet", "p2pStateListeners", "Lcom/upuphone/xr/interconnect/common/IP2pStateListener;", "selectedDeviceId", "getState", "", "onPrimaryConnectionConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onStateChange", "connected", "deviceId", "Lcom/upuphone/runasone/device/StarryDevice;", "registerStateListener", "listener", "unregisterStateListener", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class P2pConnectionManager extends PetaStepSerializer implements ConnectionStateListener {
    @NotNull
    private final Lazy infoSlice$delegate = LazyKt.lazy(P2pConnectionManager$infoSlice$2.INSTANCE);
    /* access modifiers changed from: private */
    public boolean isConnected;
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineScope mainScope = CoroutineScopeKt.b();
    /* access modifiers changed from: private */
    @NotNull
    public final Set<IP2pAcquireCallback> p2pAcquireCallbackList = new HashSet();
    /* access modifiers changed from: private */
    @NotNull
    public final Map<String, Set<IP2pAcquireCallback>> p2pAcquireCallbackListMap = new HashMap();
    /* access modifiers changed from: private */
    @NotNull
    public final Set<String> p2pAcquireSet = new HashSet();
    /* access modifiers changed from: private */
    @NotNull
    public final Set<IP2pStateListener> p2pStateListeners = new HashSet();
    /* access modifiers changed from: private */
    @Nullable
    public String selectedDeviceId;

    public P2pConnectionManager() {
        super(AnonymousClass1.INSTANCE, (String) null, 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final DataBinderSlice getInfoSlice() {
        return (DataBinderSlice) this.infoSlice$delegate.getValue();
    }

    public final int getState() {
        return this.isConnected ? 1 : 0;
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
        ULog.Delegate delegate = ULog.f6446a;
        String deviceId = starryNetDevice.getDeviceId();
        byte terminalType = starryNetDevice.getTerminalType();
        delegate.c("PetaStepSerializer", "onPrimaryConnectionConnected device id = " + deviceId + ",type = " + terminalType + " ");
        if (XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsGlass(starryNetDevice.getTerminalType())) {
            delegate.c("PetaStepSerializer", "onPrimaryConnectionConnected checkDeviceTypeIsGlass is true");
            this.selectedDeviceId = starryNetDevice.getDeviceId();
        }
    }

    public void onPrimaryConnectionDisconnected(@NotNull StarryNetDevice starryNetDevice) {
        ConnectionStateListener.DefaultImpls.onPrimaryConnectionDisconnected(this, starryNetDevice);
    }

    public void onSecondaryConnectionConnected(@NotNull StarryNetDevice starryNetDevice) {
        ConnectionStateListener.DefaultImpls.onSecondaryConnectionConnected(this, starryNetDevice);
    }

    public void onSecondaryConnectionDisconnected(@NotNull StarryNetDevice starryNetDevice) {
        ConnectionStateListener.DefaultImpls.onSecondaryConnectionDisconnected(this, starryNetDevice);
    }

    public final void onStateChange(boolean z, @NotNull String str, @NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("handle device " + str + " connected becoming " + z, new P2pConnectionManager$onStateChange$1(str, this, z, starryDevice));
    }

    public final void registerStateListener(@Nullable IP2pStateListener iP2pStateListener) {
        String stringify = iP2pStateListener != null ? PrettyPrintExtKt.stringify(iP2pStateListener) : null;
        serialize("add state listener " + stringify, new P2pConnectionManager$registerStateListener$1(iP2pStateListener, this));
    }

    public final void unregisterStateListener(@Nullable IP2pStateListener iP2pStateListener) {
        String stringify = iP2pStateListener != null ? PrettyPrintExtKt.stringify(iP2pStateListener) : null;
        serialize("remove state listener " + stringify, new P2pConnectionManager$unregisterStateListener$1(iP2pStateListener, this));
    }
}
