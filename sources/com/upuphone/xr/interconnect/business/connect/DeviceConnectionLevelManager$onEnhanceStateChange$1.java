package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.api.connection.ConnectionLevel;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DeviceConnectionLevelManager$onEnhanceStateChange$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $connected;
    final /* synthetic */ DeviceConnectionLevelManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceConnectionLevelManager$onEnhanceStateChange$1(DeviceConnectionLevelManager deviceConnectionLevelManager, boolean z) {
        super(0);
        this.this$0 = deviceConnectionLevelManager;
        this.$connected = z;
    }

    public final void invoke() {
        Job access$getTimeoutJob$p;
        String access$getTag = this.this$0.getTag();
        boolean z = this.$connected;
        ILog.d(access$getTag, "Got enhance connection state: " + z + ".");
        this.this$0.isEnhanceConnected = this.$connected;
        if (this.$connected) {
            DeviceConnectionLevelManager deviceConnectionLevelManager = this.this$0;
            ConnectionLevel connectionLevel = ConnectionLevel.ENHANCE;
            deviceConnectionLevelManager.mutateCurrentLevel(connectionLevel);
            DeviceConnectionLevelManager deviceConnectionLevelManager2 = this.this$0;
            deviceConnectionLevelManager2.informSuccess(deviceConnectionLevelManager2.highRequestCallbacks);
            DeviceConnectionLevelManager deviceConnectionLevelManager3 = this.this$0;
            deviceConnectionLevelManager3.informSuccess(deviceConnectionLevelManager3.mediumRequestCallbacks);
            if (this.this$0.requestingLevel == connectionLevel && (access$getTimeoutJob$p = this.this$0.timeoutJob) != null) {
                Job.DefaultImpls.a(access$getTimeoutJob$p, (CancellationException) null, 1, (Object) null);
                return;
            }
            return;
        }
        DeviceConnectionLevelManager deviceConnectionLevelManager4 = this.this$0;
        deviceConnectionLevelManager4.mutateCurrentLevel(deviceConnectionLevelManager4.isBalanceConnected ? ConnectionLevel.BALANCE : ConnectionLevel.BASIC);
    }
}
