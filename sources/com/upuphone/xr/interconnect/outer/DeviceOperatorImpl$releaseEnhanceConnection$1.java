package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IDeviceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/common/IDeviceManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DeviceOperatorImpl$releaseEnhanceConnection$1 extends Lambda implements Function1<IDeviceManager, Unit> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ DeviceOperatorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceOperatorImpl$releaseEnhanceConnection$1(DeviceOperatorImpl deviceOperatorImpl, String str) {
        super(1);
        this.this$0 = deviceOperatorImpl;
        this.$deviceId = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IDeviceManager) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IDeviceManager iDeviceManager) {
        Intrinsics.checkNotNullParameter(iDeviceManager, "$this$fallbackRemoteProxyCall");
        iDeviceManager.abandonConnectionLevel(this.this$0.appId, this.$deviceId, 2);
    }
}
