package com.upuphone.xr.interconnect.util.device;

import com.upuphone.runasone.device.StarryDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"deviceTerminalType", "", "Lcom/upuphone/runasone/device/StarryDevice;", "getDeviceTerminalType", "(Lcom/upuphone/runasone/device/StarryDevice;)B", "SharedImpl_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class AdaptExtKt {
    public static final byte getDeviceTerminalType(@NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(starryDevice, "<this>");
        return starryDevice.getStarryDevice().getTerminalType();
    }
}
