package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.business.connect.behavior.DeviceTraitsKt;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nPeerDeviceStatusManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PeerDeviceStatusManager.kt\ncom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager$onPrimaryConnectionConnected$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,441:1\n1855#2,2:442\n*S KotlinDebug\n*F\n+ 1 PeerDeviceStatusManager.kt\ncom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager$onPrimaryConnectionConnected$1\n*L\n404#1:442,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PeerDeviceStatusManager$onPrimaryConnectionConnected$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryNetDevice $device;
    final /* synthetic */ PeerDeviceStatusManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeerDeviceStatusManager$onPrimaryConnectionConnected$1(PeerDeviceStatusManager peerDeviceStatusManager, StarryNetDevice starryNetDevice) {
        super(0);
        this.this$0 = peerDeviceStatusManager;
        this.$device = starryNetDevice;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String deviceId = this.$device.getDeviceId();
        ILog.d(access$getTag, "Checking relay device change on " + deviceId + ".");
        String deviceId2 = this.$device.getDeviceId();
        if (deviceId2 == null) {
            ILog.w(this.this$0.getTag(), "Dropping null device ID!");
        } else if (DeviceTraitsKt.getTraits(this.$device).isHostAlwaysRunning()) {
            this.this$0.changeStateUp(deviceId2, PeerState.AVAILABLE);
            this.this$0.initiateVersionSending(deviceId2);
        } else if (!this.this$0.stateMap.containsKey(deviceId2)) {
            for (PeerStateListener onPeerUnavailable : this.this$0.getListeners()) {
                onPeerUnavailable.onPeerUnavailable(deviceId2);
            }
        }
    }
}
