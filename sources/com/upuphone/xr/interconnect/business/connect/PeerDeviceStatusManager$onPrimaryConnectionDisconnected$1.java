package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PeerDeviceStatusManager$onPrimaryConnectionDisconnected$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryNetDevice $device;
    final /* synthetic */ PeerDeviceStatusManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeerDeviceStatusManager$onPrimaryConnectionDisconnected$1(PeerDeviceStatusManager peerDeviceStatusManager, StarryNetDevice starryNetDevice) {
        super(0);
        this.this$0 = peerDeviceStatusManager;
        this.$device = starryNetDevice;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String deviceId = this.$device.getDeviceId();
        ILog.d(access$getTag, "Cleaning up info  all version for disconnected #" + deviceId + ".");
        String deviceId2 = this.$device.getDeviceId();
        if (deviceId2 == null) {
            ILog.w(this.this$0.getTag(), "Dropping null device ID!  all version");
            return;
        }
        this.this$0.changeStateDown(deviceId2, PeerState.MISSING);
        this.this$0.resetDeviceStatus(deviceId2);
    }
}
