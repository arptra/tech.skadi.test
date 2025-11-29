package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DeviceOperatorImpl$coreDeviceConnectionListener$1$createParentListener$1$onDeviceDisconnected$1 extends Lambda implements Function1<DeviceConnectionListener, Unit> {
    final /* synthetic */ StarryNetDevice $device;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceOperatorImpl$coreDeviceConnectionListener$1$createParentListener$1$onDeviceDisconnected$1(StarryNetDevice starryNetDevice) {
        super(1);
        this.$device = starryNetDevice;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeviceConnectionListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DeviceConnectionListener deviceConnectionListener) {
        Intrinsics.checkNotNullParameter(deviceConnectionListener, "$this$callEachListener");
        deviceConnectionListener.onDeviceDisconnected(this.$device);
    }
}
