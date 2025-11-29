package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.CharsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectManager$onConnectStateChange$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryDevice $device;
    final /* synthetic */ int $newState;
    final /* synthetic */ ConnectManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectManager$onConnectStateChange$2(ConnectManager connectManager, StarryDevice starryDevice, int i) {
        super(0);
        this.this$0 = connectManager;
        this.$device = starryDevice;
        this.$newState = i;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String id = this.$device.getId();
        String num = Integer.toString(this.$newState, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        ILog.d(access$getTag, "#" + id + " entered new connect state: " + num + ".");
        ConnectManager connectManager = this.this$0;
        DevicesConnector access$getDevicesConnector$p = connectManager.devicesConnector;
        if (access$getDevicesConnector$p == null) {
            ILog.w(this.this$0.getTag(), "Receiving connect state change listener call when connector is not initialized.");
            return;
        }
        connectManager.handleGlassConnectStateChange(access$getDevicesConnector$p, this.$device, this.$newState);
        this.this$0.revertPeerStatus(this.$device, this.$newState);
    }
}
