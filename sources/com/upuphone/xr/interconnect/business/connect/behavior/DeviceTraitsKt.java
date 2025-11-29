package com.upuphone.xr.interconnect.business.connect.behavior;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.business.connect.behavior.DeviceTraits;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\r\u001a\u00020\u000e*\u0004\u0018\u00010\bH\u0000\u001a\f\u0010\u000f\u001a\u00020\u000e*\u00020\u0002H\u0000\"*\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0007\u001a\u00020\u0003*\u00020\b8@X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0018\u0010\u0007\u001a\u00020\u0003*\u00020\u000b8@X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\f¨\u0006\u0010"}, d2 = {"deviceTraitsMap", "Ljava/util/HashMap;", "", "Lcom/upuphone/xr/interconnect/business/connect/behavior/DeviceTraits;", "Lkotlin/collections/HashMap;", "uncategorizedDeviceTraits", "Lcom/upuphone/xr/interconnect/business/connect/behavior/DeviceTraits$Companion;", "traits", "Lcom/upuphone/runasone/device/StarryDevice;", "getTraits", "(Lcom/upuphone/runasone/device/StarryDevice;)Lcom/upuphone/xr/interconnect/business/connect/behavior/DeviceTraits;", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)Lcom/upuphone/xr/interconnect/business/connect/behavior/DeviceTraits;", "isPrimary", "", "isTerminalTypeOfPrimary", "SharedImpl_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DeviceTraitsKt {
    @NotNull
    private static final HashMap<Byte, DeviceTraits> deviceTraitsMap;
    @NotNull
    private static final DeviceTraits.Companion uncategorizedDeviceTraits;

    static {
        Pair pair = TuplesKt.to((byte) 2, new DeviceTraits(true, true, false, 4, (DefaultConstructorMarker) null));
        Pair pair2 = TuplesKt.to((byte) 1, new DeviceTraits(true, false, false, 6, (DefaultConstructorMarker) null));
        Pair pair3 = TuplesKt.to((byte) 6, new DeviceTraits(true, true, false, 4, (DefaultConstructorMarker) null));
        Pair pair4 = TuplesKt.to((byte) 4, new DeviceTraits(true, true, false, 4, (DefaultConstructorMarker) null));
        DeviceTraits.Companion companion = DeviceTraits.Companion;
        deviceTraitsMap = MapsKt.hashMapOf(pair, pair2, pair3, pair4, TuplesKt.to((byte) 3, companion), TuplesKt.to((byte) 5, new DeviceTraits(false, false, false, 3, (DefaultConstructorMarker) null)));
        uncategorizedDeviceTraits = companion;
    }

    @NotNull
    public static final DeviceTraits getTraits(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "<this>");
        DeviceTraits deviceTraits = deviceTraitsMap.get(Byte.valueOf(starryNetDevice.getTerminalType()));
        if (deviceTraits == null) {
            deviceTraits = uncategorizedDeviceTraits;
        }
        Intrinsics.checkNotNull(deviceTraits);
        return deviceTraits;
    }

    public static final boolean isPrimary(@Nullable StarryDevice starryDevice) {
        return starryDevice != null && isTerminalTypeOfPrimary(starryDevice.getTerminalType());
    }

    public static final boolean isTerminalTypeOfPrimary(byte b) {
        DeviceTraits deviceTraits = deviceTraitsMap.get(Byte.valueOf(b));
        if (deviceTraits == null) {
            deviceTraits = uncategorizedDeviceTraits;
        }
        return deviceTraits.getHasHost();
    }

    @NotNull
    public static final DeviceTraits getTraits(@NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(starryDevice, "<this>");
        DeviceTraits deviceTraits = deviceTraitsMap.get(Byte.valueOf(starryDevice.getTerminalType()));
        if (deviceTraits == null) {
            deviceTraits = uncategorizedDeviceTraits;
        }
        Intrinsics.checkNotNull(deviceTraits);
        return deviceTraits;
    }
}
