package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.entity.StarryDeviceExt;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class BondStateManagerImpl$onGlassBleUnbound$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryDevice $device;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ boolean $isBrBound;
    final /* synthetic */ BondStateManagerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BondStateManagerImpl$onGlassBleUnbound$1(BondStateManagerImpl bondStateManagerImpl, String str, boolean z, StarryDevice starryDevice) {
        super(0);
        this.this$0 = bondStateManagerImpl;
        this.$deviceId = str;
        this.$isBrBound = z;
        this.$device = starryDevice;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String str = this.$deviceId;
        ILog.d(access$getTag, "#" + str + " overseas is been unbound via BLE.");
        if (!this.$isBrBound) {
            this.this$0.removeDevice(this.$deviceId, StarryDeviceExt.wrapForConnection(this.$device));
        }
    }
}
