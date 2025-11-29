package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.xr.interconnect.api.connection.ConnectionLevel;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DeviceConnectionLevelManager$abandon$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $appId;
    final /* synthetic */ ConnectionLevel $level;
    final /* synthetic */ DeviceConnectionLevelManager this$0;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.upuphone.xr.interconnect.api.connection.ConnectionLevel[] r0 = com.upuphone.xr.interconnect.api.connection.ConnectionLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.upuphone.xr.interconnect.api.connection.ConnectionLevel r1 = com.upuphone.xr.interconnect.api.connection.ConnectionLevel.ENHANCE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.upuphone.xr.interconnect.api.connection.ConnectionLevel r1 = com.upuphone.xr.interconnect.api.connection.ConnectionLevel.BALANCE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.upuphone.xr.interconnect.api.connection.ConnectionLevel r1 = com.upuphone.xr.interconnect.api.connection.ConnectionLevel.BASIC     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager$abandon$1.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceConnectionLevelManager$abandon$1(DeviceConnectionLevelManager deviceConnectionLevelManager, String str, ConnectionLevel connectionLevel) {
        super(0);
        this.this$0 = deviceConnectionLevelManager;
        this.$appId = str;
        this.$level = connectionLevel;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String str = this.$appId;
        ConnectionLevel connectionLevel = this.$level;
        ILog.d(access$getTag, str + " has abandoned " + connectionLevel + ".");
        if (WhenMappings.$EnumSwitchMapping$0[this.$level.ordinal()] == 1) {
            this.this$0.highRequesters.remove(this.$appId);
            this.this$0.highRequestCallbacks.removeAll(this.this$0.callbackLut.get(this.$appId));
        }
        DeviceConnectionLevelManager deviceConnectionLevelManager = this.this$0;
        DevicesConnector devicesConnector = StarryNetAbilityManager.getInstance().getDevicesConnector();
        if (devicesConnector != null) {
            deviceConnectionLevelManager.handleRequests(devicesConnector);
        }
    }
}
