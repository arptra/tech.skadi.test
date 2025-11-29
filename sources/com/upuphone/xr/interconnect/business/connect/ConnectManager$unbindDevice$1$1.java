package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/starrynetsdk/device/connection/DevicesConnector;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectManager$unbindDevice$1$1 extends Lambda implements Function1<DevicesConnector, Unit> {
    final /* synthetic */ String $it;
    final /* synthetic */ ConnectManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectManager$unbindDevice$1$1(String str, ConnectManager connectManager) {
        super(1);
        this.$it = str;
        this.this$0 = connectManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DevicesConnector) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DevicesConnector devicesConnector) {
        Intrinsics.checkNotNullParameter(devicesConnector, "$this$useDevicesConnector");
        int removeBond = devicesConnector.removeBond(this.$it);
        if (removeBond == 0) {
            ILog.d(this.this$0.getTag(), "Successfully unbound.");
            return;
        }
        String access$getTag = this.this$0.getTag();
        ILog.w(access$getTag, "unbinding failed with code " + removeBond + ".");
    }
}
