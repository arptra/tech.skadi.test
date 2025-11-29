package com.upuphone.xr.interconnect.entity;

import android.os.Build;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\f\u0010\n\u001a\u00020\u0007*\u00020\tH\u0007J\f\u0010\u000b\u001a\u00020\u0007*\u00020\tH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/StarryDeviceExt;", "", "()V", "isMz21", "", "()Z", "wrapForDiscovery", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "wrapForConnection", "wrapForSelf", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StarryDeviceExt {
    @NotNull
    public static final StarryDeviceExt INSTANCE = new StarryDeviceExt();
    private static final boolean isMz21;

    static {
        String str = Build.MODEL;
        isMz21 = str != null ? StringsKt.contains((CharSequence) str, (CharSequence) "MEIZU 21", true) : false;
    }

    private StarryDeviceExt() {
    }

    @JvmStatic
    @NotNull
    public static final StarryNetDevice wrapForConnection(@NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(starryDevice, "<this>");
        DevicesConnector devicesConnector = StarryNetAbilityManager.getInstance().getDevicesConnector();
        String id = starryDevice.getId();
        String str = null;
        String deviceInfo = devicesConnector != null ? devicesConnector.getDeviceInfo(id, 0) : null;
        String deviceInfo2 = devicesConnector != null ? devicesConnector.getDeviceInfo(id, 5) : null;
        String deviceInfo3 = devicesConnector != null ? devicesConnector.getDeviceInfo(id, 8) : null;
        if (devicesConnector != null) {
            str = devicesConnector.getDeviceInfo(id, 7);
        }
        StarryNetDevice starryNetDevice = new StarryNetDevice();
        starryNetDevice.setDeviceId(id);
        starryNetDevice.setDeviceName(deviceInfo);
        starryNetDevice.setModelId(deviceInfo2);
        starryNetDevice.setBrEdrMac(deviceInfo3);
        starryNetDevice.setBleMac(starryDevice.getStarryDevice().getBleMac());
        starryNetDevice.setWifiMac(str);
        starryNetDevice.setTerminalType(starryDevice.getTerminalType());
        starryNetDevice.setCategoryId(starryDevice.getStarryDevice().getCategoryID());
        starryNetDevice.setRegion(starryDevice.getStarryDevice().getRegion());
        starryNetDevice.setStatus(starryDevice.getStatus());
        return starryNetDevice;
    }

    @JvmStatic
    @NotNull
    public static final StarryNetDevice wrapForDiscovery(@NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        DevicesConnector devicesConnector = StarryNetAbilityManager.getInstance().getDevicesConnector();
        StarryNetDevice starryNetDevice = new StarryNetDevice();
        String id = starryDevice.getId();
        String str = null;
        String deviceInfo = devicesConnector != null ? devicesConnector.getDeviceInfo(id, 0) : null;
        String deviceInfo2 = devicesConnector != null ? devicesConnector.getDeviceInfo(id, 5) : null;
        String deviceInfo3 = devicesConnector != null ? devicesConnector.getDeviceInfo(id, 8) : null;
        if (devicesConnector != null) {
            str = devicesConnector.getDeviceInfo(id, 7);
        }
        starryNetDevice.setDeviceId(id);
        starryNetDevice.setDeviceName(deviceInfo);
        starryNetDevice.setModelId(deviceInfo2);
        starryNetDevice.setBrEdrMac(deviceInfo3);
        starryNetDevice.setCategoryId(starryDevice.getStarryDevice().getCategoryID());
        starryNetDevice.setBleMac(starryDevice.getStarryDevice().getBleMac());
        starryNetDevice.setWifiMac(str);
        starryNetDevice.setTerminalType(starryDevice.getTerminalType());
        starryNetDevice.setStatus(starryDevice.getStarryDevice().getStatus());
        starryNetDevice.setRegion(starryDevice.getStarryDevice().getRegion());
        return starryNetDevice;
    }

    @JvmStatic
    @NotNull
    public static final StarryNetDevice wrapForSelf(@NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(starryDevice, "<this>");
        StarryNetDevice wrapForConnection = wrapForConnection(starryDevice);
        if (Intrinsics.areEqual((Object) wrapForConnection.getModelId(), (Object) "3003") && isMz21) {
            wrapForConnection.setModelId("3004");
        }
        return wrapForConnection;
    }

    public final boolean isMz21() {
        return isMz21;
    }
}
