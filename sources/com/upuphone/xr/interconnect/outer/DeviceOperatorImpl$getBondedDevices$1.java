package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IDeviceManager;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "kotlin.jvm.PlatformType", "", "Lcom/upuphone/xr/interconnect/common/IDeviceManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DeviceOperatorImpl$getBondedDevices$1 extends Lambda implements Function1<IDeviceManager, List<StarryNetDevice>> {
    public static final DeviceOperatorImpl$getBondedDevices$1 INSTANCE = new DeviceOperatorImpl$getBondedDevices$1();

    public DeviceOperatorImpl$getBondedDevices$1() {
        super(1);
    }

    public final List<StarryNetDevice> invoke(@NotNull IDeviceManager iDeviceManager) {
        Intrinsics.checkNotNullParameter(iDeviceManager, "$this$safeRemoteProxyCall");
        return iDeviceManager.getBondedDevices();
    }
}
