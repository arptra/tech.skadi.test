package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectManager$manageDeviceConnectionLevel$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ Function1<DeviceConnectionLevelManager, Unit> $manageAction;
    final /* synthetic */ Function0<Unit> $onDeviceNotConnected;
    final /* synthetic */ ConnectManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectManager$manageDeviceConnectionLevel$2(ConnectManager connectManager, Function1<? super DeviceConnectionLevelManager, Unit> function1, String str, Function0<Unit> function0) {
        super(0);
        this.this$0 = connectManager;
        this.$manageAction = function1;
        this.$deviceId = str;
        this.$onDeviceNotConnected = function0;
    }

    public final void invoke() {
        Unit unit;
        String access$getTag = this.this$0.getTag();
        Function1<DeviceConnectionLevelManager, Unit> function1 = this.$manageAction;
        String str = this.$deviceId;
        ILog.d(access$getTag, "Trying to perform manage action " + function1 + " on #" + str + ".");
        DeviceConnectionLevelManager deviceConnectionLevelManager = (DeviceConnectionLevelManager) this.this$0.deviceConnectionLevelManagers.get(this.$deviceId);
        if (deviceConnectionLevelManager != null) {
            this.$manageAction.invoke(deviceConnectionLevelManager);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.$onDeviceNotConnected.invoke();
        }
    }
}
