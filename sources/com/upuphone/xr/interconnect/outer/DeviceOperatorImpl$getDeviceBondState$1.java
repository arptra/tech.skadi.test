package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IDeviceManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/common/IDeviceManager;", "invoke", "(Lcom/upuphone/xr/interconnect/common/IDeviceManager;)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DeviceOperatorImpl$getDeviceBondState$1 extends Lambda implements Function1<IDeviceManager, Integer> {
    final /* synthetic */ String $deviceId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceOperatorImpl$getDeviceBondState$1(String str) {
        super(1);
        this.$deviceId = str;
    }

    @NotNull
    public final Integer invoke(@NotNull IDeviceManager iDeviceManager) {
        Intrinsics.checkNotNullParameter(iDeviceManager, "$this$fallbackRemoteProxyCall");
        return Integer.valueOf(iDeviceManager.getDeviceBondState(this.$deviceId));
    }
}
