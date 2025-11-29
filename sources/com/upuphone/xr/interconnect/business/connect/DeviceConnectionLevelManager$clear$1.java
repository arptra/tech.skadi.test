package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DeviceConnectionLevelManager$clear$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $appId;
    final /* synthetic */ DeviceConnectionLevelManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceConnectionLevelManager$clear$1(DeviceConnectionLevelManager deviceConnectionLevelManager, String str) {
        super(0);
        this.this$0 = deviceConnectionLevelManager;
        this.$appId = str;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String str = this.$appId;
        ILog.d(access$getTag, "Cleaning up data from dead client " + str + ".");
        this.this$0.highRequesters.remove(this.$appId);
        Set set = this.this$0.callbackLut.get(this.$appId);
        DeviceConnectionLevelManager deviceConnectionLevelManager = this.this$0;
        deviceConnectionLevelManager.highRequestCallbacks.removeAll(set);
        deviceConnectionLevelManager.mediumRequestCallbacks.removeAll(set);
        DeviceConnectionLevelManager deviceConnectionLevelManager2 = this.this$0;
        DevicesConnector devicesConnector = StarryNetAbilityManager.getInstance().getDevicesConnector();
        if (devicesConnector != null) {
            deviceConnectionLevelManager2.handleRequests(devicesConnector);
        }
    }
}
