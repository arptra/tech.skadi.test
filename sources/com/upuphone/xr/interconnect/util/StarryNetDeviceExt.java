package com.upuphone.xr.interconnect.util;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007J\f\u0010\u0006\u001a\u00020\u0004*\u00020\u0005H\u0007J\f\u0010\u0007\u001a\u00020\u0004*\u00020\u0005H\u0007¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/interconnect/util/StarryNetDeviceExt;", "", "()V", "isPhoneDevice", "", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "isRingDevice", "isXrDevice", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StarryNetDeviceExt {
    @NotNull
    public static final StarryNetDeviceExt INSTANCE = new StarryNetDeviceExt();

    private StarryNetDeviceExt() {
    }

    @JvmStatic
    public static final boolean isPhoneDevice(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "<this>");
        return starryNetDevice.getTerminalType() == 1 || starryNetDevice.getTerminalType() == 4 || starryNetDevice.getTerminalType() == 6;
    }

    @JvmStatic
    public static final boolean isRingDevice(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "<this>");
        return starryNetDevice.getTerminalType() == 5;
    }

    @JvmStatic
    public static final boolean isXrDevice(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "<this>");
        return starryNetDevice.getTerminalType() == 2;
    }
}
