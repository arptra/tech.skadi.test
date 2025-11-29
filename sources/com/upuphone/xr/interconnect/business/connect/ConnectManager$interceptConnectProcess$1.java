package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.starrynetsdk.device.discovery.DevicesDiscoverer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/starrynetsdk/device/discovery/DevicesDiscoverer;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectManager$interceptConnectProcess$1 extends Lambda implements Function1<DevicesDiscoverer, Unit> {
    final /* synthetic */ boolean $intercept;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectManager$interceptConnectProcess$1(boolean z) {
        super(1);
        this.$intercept = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DevicesDiscoverer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DevicesDiscoverer devicesDiscoverer) {
        Intrinsics.checkNotNullParameter(devicesDiscoverer, "$this$useDevicesDiscoverer");
        devicesDiscoverer.interceptConnectProcess(this.$intercept);
    }
}
