package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.api.StarryNetDeviceStateChangeListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceStateChangeListener;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionListenerManager$registerDeviceStateChangeListener$1$1$1 extends Lambda implements Function1<StarryNetDeviceStateChangeListener, Unit> {
    final /* synthetic */ StarryNetDevice $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager$registerDeviceStateChangeListener$1$1$1(StarryNetDevice starryNetDevice) {
        super(1);
        this.$it = starryNetDevice;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StarryNetDeviceStateChangeListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener) {
        Intrinsics.checkNotNullParameter(starryNetDeviceStateChangeListener, "$this$safeCallRemoteListener");
        starryNetDeviceStateChangeListener.onBondStateChanged(this.$it, 2);
    }
}
