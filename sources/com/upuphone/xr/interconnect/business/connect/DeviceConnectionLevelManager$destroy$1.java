package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DeviceConnectionLevelManager$destroy$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DeviceConnectionLevelManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceConnectionLevelManager$destroy$1(DeviceConnectionLevelManager deviceConnectionLevelManager) {
        super(0);
        this.this$0 = deviceConnectionLevelManager;
    }

    public final void invoke() {
        ILog.d(this.this$0.getTag(), "Destroyed.");
        DeviceConnectionLevelManager deviceConnectionLevelManager = this.this$0;
        deviceConnectionLevelManager.informFail(deviceConnectionLevelManager.mediumRequestCallbacks, 3, (String) null);
        DeviceConnectionLevelManager deviceConnectionLevelManager2 = this.this$0;
        deviceConnectionLevelManager2.informFail(deviceConnectionLevelManager2.highRequestCallbacks, 3, (String) null);
        this.this$0.getInfoSlice().unset("device", this.this$0.deviceId, "connectionLevel");
    }
}
