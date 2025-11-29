package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.business.connect.behavior.DeviceTraitsKt;
import com.upuphone.xr.interconnect.entity.StarryDeviceExt;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionStateManagerImpl$onGlassBleConnected$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryDevice $device;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ boolean $isBrConnected;
    final /* synthetic */ ConnectionStateManagerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionStateManagerImpl$onGlassBleConnected$1(StarryDevice starryDevice, ConnectionStateManagerImpl connectionStateManagerImpl, String str, boolean z) {
        super(0);
        this.$device = starryDevice;
        this.this$0 = connectionStateManagerImpl;
        this.$deviceId = str;
        this.$isBrConnected = z;
    }

    public final void invoke() {
        byte terminalType = this.$device.getTerminalType();
        String access$getTag = this.this$0.getTag();
        String str = this.$deviceId;
        ILog.d(access$getTag, "#" + str + " overseas of type " + terminalType + " has connected via ble.");
        if (terminalType == 1 || terminalType == 2) {
            if (this.$isBrConnected) {
                ConnectionStateManagerImpl connectionStateManagerImpl = this.this$0;
                StarryDevice starryDevice = this.$device;
                connectionStateManagerImpl.addPrimaryGlassDevice(starryDevice, StarryDeviceExt.wrapForConnection(starryDevice));
            }
        } else if (terminalType != 4 && terminalType != 6) {
            if (this.$isBrConnected || !DeviceTraitsKt.getTraits(this.$device).getBrEnabled()) {
                this.this$0.addSecondaryGlassDevice(terminalType, this.$deviceId, this.$device);
            }
        }
    }
}
