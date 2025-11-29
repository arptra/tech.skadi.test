package com.upuphone.xr.interconnect.outer;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.xr.interconnect.api.StarryNetDeviceOperator;
import com.upuphone.xr.interconnect.common.IDeviceManager;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceBondStateListener;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.listener.P2pAcquireCallback;
import com.upuphone.xr.interconnect.listener.P2pStateListener;
import com.upuphone.xr.interconnect.listener.RequestCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0003\n\r\u0010\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u0018H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0012\u0010)\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0013H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010/\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020%H\u0016J\u0010\u00100\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020'H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u00061"}, d2 = {"Lcom/upuphone/xr/interconnect/outer/DeviceOperatorImpl;", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceOperator;", "Lcom/upuphone/xr/interconnect/outer/BaseOperatorImpl;", "Lcom/upuphone/xr/interconnect/common/IDeviceManager;", "appId", "", "deviceManagerGetter", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "coreDeviceBondStateListener", "com/upuphone/xr/interconnect/outer/DeviceOperatorImpl$coreDeviceBondStateListener$1", "Lcom/upuphone/xr/interconnect/outer/DeviceOperatorImpl$coreDeviceBondStateListener$1;", "coreDeviceConnectionListener", "com/upuphone/xr/interconnect/outer/DeviceOperatorImpl$coreDeviceConnectionListener$1", "Lcom/upuphone/xr/interconnect/outer/DeviceOperatorImpl$coreDeviceConnectionListener$1;", "coreP2pStateListener", "com/upuphone/xr/interconnect/outer/DeviceOperatorImpl$coreP2pStateListener$1", "Lcom/upuphone/xr/interconnect/outer/DeviceOperatorImpl$coreP2pStateListener$1;", "acquireEnhanceConnection", "", "deviceId", "callback", "Lcom/upuphone/xr/interconnect/listener/RequestCallback;", "getBondedDevices", "", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "getConnectedDevice", "getDeviceBondState", "", "getP2pState", "getSelfDevice", "onServiceConnected", "onServiceDied", "registerDeviceBondStateListener", "listener", "Lcom/upuphone/xr/interconnect/listener/DeviceBondStateListener;", "registerDeviceConnectionListener", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "registerP2pStateListener", "Lcom/upuphone/xr/interconnect/listener/P2pStateListener;", "releaseEnhanceConnection", "tryAcquireP2p", "Lcom/upuphone/xr/interconnect/listener/P2pAcquireCallback;", "tryReleaseP2p", "unBondDevice", "", "unregisterDeviceBondStateListener", "unregisterDeviceConnectionListener", "unregisterP2pSateListener", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeviceOperatorImpl extends BaseOperatorImpl<IDeviceManager> implements StarryNetDeviceOperator {
    /* access modifiers changed from: private */
    @NotNull
    public final String appId;
    @NotNull
    private final DeviceOperatorImpl$coreDeviceBondStateListener$1 coreDeviceBondStateListener = new DeviceOperatorImpl$coreDeviceBondStateListener$1(getTag(), new DeviceOperatorImpl$coreDeviceBondStateListener$2(this), new DeviceOperatorImpl$coreDeviceBondStateListener$3(this), DeviceOperatorImpl$coreDeviceBondStateListener$4.INSTANCE, DeviceOperatorImpl$coreDeviceBondStateListener$5.INSTANCE);
    @NotNull
    private final DeviceOperatorImpl$coreDeviceConnectionListener$1 coreDeviceConnectionListener = new DeviceOperatorImpl$coreDeviceConnectionListener$1(getTag(), new DeviceOperatorImpl$coreDeviceConnectionListener$2(this), new DeviceOperatorImpl$coreDeviceConnectionListener$3(this), DeviceOperatorImpl$coreDeviceConnectionListener$4.INSTANCE, DeviceOperatorImpl$coreDeviceConnectionListener$5.INSTANCE);
    @NotNull
    private final DeviceOperatorImpl$coreP2pStateListener$1 coreP2pStateListener = new DeviceOperatorImpl$coreP2pStateListener$1(getTag(), new DeviceOperatorImpl$coreP2pStateListener$2(this), new DeviceOperatorImpl$coreP2pStateListener$3(this), DeviceOperatorImpl$coreP2pStateListener$4.INSTANCE, DeviceOperatorImpl$coreP2pStateListener$5.INSTANCE);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceOperatorImpl(@NotNull String str, @NotNull Function0<? extends IDeviceManager> function0) {
        super(function0);
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(function0, "deviceManagerGetter");
        this.appId = str;
    }

    public void acquireEnhanceConnection(@NotNull String str, @Nullable RequestCallback requestCallback) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        fallbackRemoteProxyCall(Unit.INSTANCE, new DeviceOperatorImpl$acquireEnhanceConnection$1(this, str, requestCallback));
    }

    @Nullable
    public List<StarryNetDevice> getBondedDevices() {
        return (List) safeRemoteProxyCall(DeviceOperatorImpl$getBondedDevices$1.INSTANCE);
    }

    @Nullable
    public StarryNetDevice getConnectedDevice() {
        return (StarryNetDevice) safeRemoteProxyCall(DeviceOperatorImpl$getConnectedDevice$1.INSTANCE);
    }

    public int getDeviceBondState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        return ((Number) fallbackRemoteProxyCall(0, new DeviceOperatorImpl$getDeviceBondState$1(str))).intValue();
    }

    public int getP2pState() {
        return ((Number) fallbackRemoteProxyCall(0, DeviceOperatorImpl$getP2pState$1.INSTANCE)).intValue();
    }

    @Nullable
    public StarryNetDevice getSelfDevice() {
        return (StarryNetDevice) safeRemoteProxyCall(DeviceOperatorImpl$getSelfDevice$1.INSTANCE);
    }

    public void onServiceConnected() {
        super.onServiceConnected();
        this.coreDeviceConnectionListener.onServiceUp();
        this.coreP2pStateListener.onServiceUp();
        this.coreDeviceBondStateListener.onServiceUp();
    }

    public void onServiceDied() {
        super.onServiceDied();
        this.coreDeviceConnectionListener.onServiceDown();
        this.coreP2pStateListener.onServiceDown();
        this.coreDeviceBondStateListener.onServiceDown();
    }

    public void registerDeviceBondStateListener(@NotNull DeviceBondStateListener deviceBondStateListener) {
        Intrinsics.checkNotNullParameter(deviceBondStateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.coreDeviceBondStateListener.addListener(deviceBondStateListener);
    }

    public void registerDeviceConnectionListener(@NotNull DeviceConnectionListener deviceConnectionListener) {
        Intrinsics.checkNotNullParameter(deviceConnectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.coreDeviceConnectionListener.addListener(deviceConnectionListener);
    }

    public void registerP2pStateListener(@NotNull P2pStateListener p2pStateListener) {
        Intrinsics.checkNotNullParameter(p2pStateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.coreP2pStateListener.addListener(p2pStateListener);
    }

    public void releaseEnhanceConnection(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        fallbackRemoteProxyCall(Unit.INSTANCE, new DeviceOperatorImpl$releaseEnhanceConnection$1(this, str));
    }

    public void tryAcquireP2p(@Nullable P2pAcquireCallback p2pAcquireCallback) {
        fallbackRemoteProxyCall(Unit.INSTANCE, new DeviceOperatorImpl$tryAcquireP2p$1(p2pAcquireCallback));
    }

    public void tryReleaseP2p() {
        fallbackRemoteProxyCall(Unit.INSTANCE, DeviceOperatorImpl$tryReleaseP2p$1.INSTANCE);
    }

    public boolean unBondDevice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        return ((Boolean) fallbackRemoteProxyCall(Boolean.FALSE, new DeviceOperatorImpl$unBondDevice$1(str))).booleanValue();
    }

    public void unregisterDeviceBondStateListener(@NotNull DeviceBondStateListener deviceBondStateListener) {
        Intrinsics.checkNotNullParameter(deviceBondStateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.coreDeviceBondStateListener.removeListener(deviceBondStateListener);
    }

    public void unregisterDeviceConnectionListener(@NotNull DeviceConnectionListener deviceConnectionListener) {
        Intrinsics.checkNotNullParameter(deviceConnectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.coreDeviceConnectionListener.removeListener(deviceConnectionListener);
    }

    public void unregisterP2pSateListener(@NotNull P2pStateListener p2pStateListener) {
        Intrinsics.checkNotNullParameter(p2pStateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.coreP2pStateListener.removeListener(p2pStateListener);
    }
}
