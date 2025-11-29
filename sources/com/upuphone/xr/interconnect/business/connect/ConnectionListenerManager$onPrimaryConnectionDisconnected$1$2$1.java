package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.api.ConnectionListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/api/ConnectionListener;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionListenerManager$onPrimaryConnectionDisconnected$1$2$1 extends Lambda implements Function1<ConnectionListener, Unit> {
    final /* synthetic */ StarryNetDevice $device;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager$onPrimaryConnectionDisconnected$1$2$1(StarryNetDevice starryNetDevice) {
        super(1);
        this.$device = starryNetDevice;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConnectionListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ConnectionListener connectionListener) {
        Intrinsics.checkNotNullParameter(connectionListener, "$this$safeCallRemoteListener");
        connectionListener.onConnectionDown(this.$device);
    }
}
