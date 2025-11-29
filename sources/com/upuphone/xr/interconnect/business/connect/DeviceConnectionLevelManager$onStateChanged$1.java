package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DeviceConnectionLevelManager$onStateChanged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DevicesConnector $connector;
    final /* synthetic */ DeviceConnectionLevelManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceConnectionLevelManager$onStateChanged$1(DeviceConnectionLevelManager deviceConnectionLevelManager, DevicesConnector devicesConnector) {
        super(0);
        this.this$0 = deviceConnectionLevelManager;
        this.$connector = devicesConnector;
    }

    public final void invoke() {
        ILog.d(this.this$0.getTag(), "Ability has been ready.");
        DeviceConnectionLevelManager deviceConnectionLevelManager = this.this$0;
        deviceConnectionLevelManager.isEnhanceConnected = this.$connector.isEnhanceConnection(deviceConnectionLevelManager.deviceId);
        this.this$0.handleRequests(this.$connector);
    }
}
