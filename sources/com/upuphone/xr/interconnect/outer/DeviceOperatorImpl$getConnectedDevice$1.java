package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IDeviceManager;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "kotlin.jvm.PlatformType", "Lcom/upuphone/xr/interconnect/common/IDeviceManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DeviceOperatorImpl$getConnectedDevice$1 extends Lambda implements Function1<IDeviceManager, StarryNetDevice> {
    public static final DeviceOperatorImpl$getConnectedDevice$1 INSTANCE = new DeviceOperatorImpl$getConnectedDevice$1();

    public DeviceOperatorImpl$getConnectedDevice$1() {
        super(1);
    }

    public final StarryNetDevice invoke(@NotNull IDeviceManager iDeviceManager) {
        Intrinsics.checkNotNullParameter(iDeviceManager, "$this$safeRemoteProxyCall");
        return iDeviceManager.getConnectedDevice();
    }
}
