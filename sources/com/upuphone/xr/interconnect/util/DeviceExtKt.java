package com.upuphone.xr.interconnect.util;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001\u001a\u0018\u0010\n\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\"\u001a\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006¨\u0006\f"}, d2 = {"dataBinderDeviceId", "", "getDataBinderDeviceId", "(Ljava/lang/String;)Ljava/lang/String;", "isSelfDevice", "", "(Ljava/lang/String;)Z", "copyNewValue", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "logTag", "sanitize", "Lcom/upuphone/runasone/device/StarryDevice;", "SharedImpl_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DeviceExtKt {
    @NotNull
    public static final StarryNetDevice copyNewValue(@NotNull StarryNetDevice starryNetDevice, @NotNull String str) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "<this>");
        Intrinsics.checkNotNullParameter(str, "logTag");
        StarryNetDevice starryNetDevice2 = new StarryNetDevice();
        starryNetDevice2.setDeviceId(starryNetDevice.getDeviceId());
        starryNetDevice2.setDeviceName(starryNetDevice.getDeviceName());
        starryNetDevice2.setCategoryId(starryNetDevice.getCategoryId());
        starryNetDevice2.setCategoryName(starryNetDevice.getCategoryName());
        starryNetDevice2.setCompanyId(starryNetDevice.getCompanyId());
        starryNetDevice2.setCompanyName(starryNetDevice.getCompanyName());
        starryNetDevice2.setModelId(starryNetDevice.getModelId());
        starryNetDevice2.setModelName(starryNetDevice.getModelName());
        starryNetDevice2.setBrEdrMac(starryNetDevice.getBrEdrMac());
        starryNetDevice2.setBleMac(starryNetDevice.getBleMac());
        starryNetDevice2.setWifiMac(starryNetDevice.getWifiMac());
        starryNetDevice2.setTerminalType(starryNetDevice.getTerminalType());
        starryNetDevice2.setStatus(starryNetDevice.getStatus());
        starryNetDevice2.setRegion(starryNetDevice.getRegion());
        ILog.w(str, "old value = " + starryNetDevice + ",new value = " + starryNetDevice2);
        return starryNetDevice2;
    }

    @NotNull
    public static final String getDataBinderDeviceId(@Nullable String str) {
        if (isSelfDevice(str)) {
            return "";
        }
        Intrinsics.checkNotNull(str);
        return str;
    }

    public static final boolean isSelfDevice(@Nullable String str) {
        if (str != null) {
            StarryNetDevice selfDevice = InterconnectManager.getInstance().getStarryNetDeviceManager().getSelfDevice();
            return Intrinsics.areEqual((Object) str, (Object) selfDevice != null ? selfDevice.getDeviceId() : null);
        }
    }

    @Nullable
    public static final String sanitize(@Nullable StarryDevice starryDevice, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "logTag");
        if (starryDevice == null) {
            ILog.w(str, "Connect state change listener received null device!");
            return null;
        }
        String id = starryDevice.getId();
        if (id == null) {
            ILog.w(str, "Dropping illegal device with null ID!");
        }
        return id;
    }
}
