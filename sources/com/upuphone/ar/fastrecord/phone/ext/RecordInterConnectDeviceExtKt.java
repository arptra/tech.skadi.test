package com.upuphone.ar.fastrecord.phone.ext;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"TERMINAL_TYPE_IOS", "", "TERMINAL_TYPE_PHONE", "TERMINAL_TYPE_THIRD", "TERMINAL_TYPE_XR", "isPhoneDevice", "", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "isThirdPhone", "isXRDevice", "ar-fastrecord_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RecordInterConnectDeviceExtKt {
    public static final byte TERMINAL_TYPE_IOS = 6;
    public static final byte TERMINAL_TYPE_PHONE = 1;
    public static final byte TERMINAL_TYPE_THIRD = 4;
    public static final byte TERMINAL_TYPE_XR = 2;

    public static final boolean isPhoneDevice(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "<this>");
        return starryNetDevice.getTerminalType() == 1 || starryNetDevice.getTerminalType() == 4 || starryNetDevice.getTerminalType() == 6;
    }

    public static final boolean isThirdPhone(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "<this>");
        return starryNetDevice.getTerminalType() == 4;
    }

    public static final boolean isXRDevice(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "<this>");
        return starryNetDevice.getTerminalType() == 2;
    }
}
