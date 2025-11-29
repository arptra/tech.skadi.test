package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.xr.interconnect.api.connection.ConnectionLevel;
import com.upuphone.xr.interconnect.common.IRequestCallback;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@SourceDebugExtension({"SMAP\nDeviceConnectionLevelManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceConnectionLevelManager.kt\ncom/upuphone/xr/interconnect/business/connect/DeviceConnectionLevelManager$request$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,186:1\n1#2:187\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DeviceConnectionLevelManager$request$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $appId;
    final /* synthetic */ IRequestCallback $callback;
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
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager$request$1.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceConnectionLevelManager$request$1(DeviceConnectionLevelManager deviceConnectionLevelManager, String str, ConnectionLevel connectionLevel, IRequestCallback iRequestCallback) {
        super(0);
        this.this$0 = deviceConnectionLevelManager;
        this.$appId = str;
        this.$level = connectionLevel;
        this.$callback = iRequestCallback;
    }

    public final void invoke() {
        IRequestCallback iRequestCallback;
        String access$getTag = this.this$0.getTag();
        String str = this.$appId;
        ConnectionLevel connectionLevel = this.$level;
        IRequestCallback iRequestCallback2 = this.$callback;
        ILog.d(access$getTag, "Received request from " + str + " for " + connectionLevel + ": " + iRequestCallback2 + ".");
        int i = WhenMappings.$EnumSwitchMapping$0[this.$level.ordinal()];
        if (i == 1) {
            this.this$0.highRequesters.add(this.$appId);
            IRequestCallback iRequestCallback3 = this.$callback;
            if (iRequestCallback3 != null) {
                DeviceConnectionLevelManager deviceConnectionLevelManager = this.this$0;
                String str2 = this.$appId;
                deviceConnectionLevelManager.highRequestCallbacks.add(iRequestCallback3);
                deviceConnectionLevelManager.callbackLut.set(str2, iRequestCallback3);
            }
        } else if (i == 3 && (iRequestCallback = this.$callback) != null) {
            DeviceConnectionLevelManager deviceConnectionLevelManager2 = this.this$0;
            Job unused = BuildersKt__Builders_commonKt.d(deviceConnectionLevelManager2.mainScope, (CoroutineContext) null, (CoroutineStart) null, new DeviceConnectionLevelManager$request$1$2$1(iRequestCallback, deviceConnectionLevelManager2, (Continuation<? super DeviceConnectionLevelManager$request$1$2$1>) null), 3, (Object) null);
        }
        DeviceConnectionLevelManager deviceConnectionLevelManager3 = this.this$0;
        DevicesConnector devicesConnector = StarryNetAbilityManager.getInstance().getDevicesConnector();
        if (devicesConnector != null) {
            deviceConnectionLevelManager3.handleRequests(devicesConnector);
        }
    }
}
