package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.api.StarryNetDeviceStateChangeListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceStateChangeListener;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionListenerManager$onPairingKeyReceived$1$1$1 extends Lambda implements Function1<StarryNetDeviceStateChangeListener, Unit> {
    final /* synthetic */ String $deviceName;
    final /* synthetic */ int $pairingKey;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager$onPairingKeyReceived$1$1$1(int i, String str) {
        super(1);
        this.$pairingKey = i;
        this.$deviceName = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StarryNetDeviceStateChangeListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener) {
        Intrinsics.checkNotNullParameter(starryNetDeviceStateChangeListener, "$this$safeCallRemoteListener");
        StarryNetDevice starryNetDevice = new StarryNetDevice();
        starryNetDevice.setDeviceName(this.$deviceName);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "%06d", Arrays.copyOf(new Object[]{Integer.valueOf(this.$pairingKey)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        starryNetDeviceStateChangeListener.onReceivePairingKey(starryNetDevice, format);
    }
}
