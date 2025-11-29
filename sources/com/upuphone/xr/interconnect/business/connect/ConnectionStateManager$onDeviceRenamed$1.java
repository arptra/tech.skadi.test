package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.xr.interconnect.business.connect.behavior.DeviceTraitsKt;
import com.upuphone.xr.interconnect.entity.DeviceWrapper;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectionStateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionStateManager$onDeviceRenamed$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,312:1\n288#2,2:313\n*S KotlinDebug\n*F\n+ 1 ConnectionStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionStateManager$onDeviceRenamed$1\n*L\n134#1:313,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionStateManager$onDeviceRenamed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $newName;
    final /* synthetic */ ConnectionStateManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionStateManager$onDeviceRenamed$1(ConnectionStateManager connectionStateManager, String str, String str2) {
        super(0);
        this.this$0 = connectionStateManager;
        this.$deviceId = str;
        this.$newName = str2;
    }

    public final void invoke() {
        T t;
        String access$getTag = this.this$0.getTag();
        String str = this.$deviceId;
        String str2 = this.$newName;
        ILog.d(access$getTag, "Renaming device " + str + " to " + str2 + ".");
        Set<DeviceWrapper> connectedPrimaryDevices = this.this$0.getConnectedPrimaryDevices();
        String str3 = this.$deviceId;
        Iterator<T> it = connectedPrimaryDevices.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual((Object) ((DeviceWrapper) t).getId(), (Object) str3)) {
                break;
            }
        }
        DeviceWrapper deviceWrapper = (DeviceWrapper) t;
        if (deviceWrapper != null) {
            String str4 = this.$newName;
            ConnectionStateManager connectionStateManager = this.this$0;
            String str5 = this.$deviceId;
            StarryDevice originDevice = deviceWrapper.getOriginDevice();
            StarryNetDevice device = deviceWrapper.getDevice();
            if (originDevice != null && device != null) {
                StDevice starryDevice = originDevice.getStarryDevice();
                if (starryDevice != null) {
                    starryDevice.setDeviceName(str4);
                }
                device.setDeviceName(str4);
                if (DeviceTraitsKt.isPrimary(originDevice)) {
                    connectionStateManager.onGlassBleConnectedDeviceUpdate(str5, originDevice, true);
                }
            }
        }
    }
}
