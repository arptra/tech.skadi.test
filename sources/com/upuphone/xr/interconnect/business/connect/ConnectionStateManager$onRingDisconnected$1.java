package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.DeviceWrapper;
import com.upuphone.xr.interconnect.entity.StarryDeviceExt;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectionStateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionStateManager$onRingDisconnected$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,312:1\n1855#2,2:313\n1855#2,2:315\n*S KotlinDebug\n*F\n+ 1 ConnectionStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionStateManager$onRingDisconnected$1\n*L\n286#1:313,2\n289#1:315,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionStateManager$onRingDisconnected$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryDevice $device;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ ConnectionStateManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionStateManager$onRingDisconnected$1(String str, StarryDevice starryDevice, ConnectionStateManager connectionStateManager) {
        super(0);
        this.$deviceId = str;
        this.$device = starryDevice;
        this.this$0 = connectionStateManager;
    }

    public final void invoke() {
        String str = this.$deviceId;
        ILog.e("PetaStepSerializer", "onRingDisconnected deviceId = " + str);
        if (XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsRing(this.$device.getTerminalType())) {
            ULog.f6446a.c("PetaStepSerializer", "onRingDisconnected checkDeviceTypeIsRing is true");
            StarryDevice starryDevice = this.$device;
            DeviceWrapper deviceWrapper = new DeviceWrapper(starryDevice, StarryDeviceExt.wrapForConnection(starryDevice));
            for (ConnectionStateListener onPrimaryConnectionDisconnected : this.this$0.getListeners()) {
                StarryNetDevice device = deviceWrapper.getDevice();
                Intrinsics.checkNotNullExpressionValue(device, "getDevice(...)");
                onPrimaryConnectionDisconnected.onPrimaryConnectionDisconnected(device);
            }
            for (BlePrimaryDeviceConnectionListener onBlePrimaryDeviceDisconnected : this.this$0.getPrimaryDeviceConnectionListeners()) {
                StarryNetDevice device2 = deviceWrapper.getDevice();
                Intrinsics.checkNotNullExpressionValue(device2, "getDevice(...)");
                onBlePrimaryDeviceDisconnected.onBlePrimaryDeviceDisconnected(device2);
            }
            this.this$0.connectedRingDevice = null;
        }
    }
}
