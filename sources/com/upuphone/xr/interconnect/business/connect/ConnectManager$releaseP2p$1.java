package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.api.connection.ConnectionLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/business/connect/DeviceConnectionLevelManager;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectManager$releaseP2p$1 extends Lambda implements Function1<DeviceConnectionLevelManager, Unit> {
    final /* synthetic */ String $identifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectManager$releaseP2p$1(String str) {
        super(1);
        this.$identifier = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeviceConnectionLevelManager) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DeviceConnectionLevelManager deviceConnectionLevelManager) {
        Intrinsics.checkNotNullParameter(deviceConnectionLevelManager, "$this$manageDeviceConnectionLevel");
        deviceConnectionLevelManager.abandon(this.$identifier, ConnectionLevel.ENHANCE);
    }
}
