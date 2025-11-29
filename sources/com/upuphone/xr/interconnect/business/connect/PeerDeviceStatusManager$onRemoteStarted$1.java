package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PeerDeviceStatusManager$onRemoteStarted$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ PeerDeviceStatusManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeerDeviceStatusManager$onRemoteStarted$1(PeerDeviceStatusManager peerDeviceStatusManager, String str) {
        super(0);
        this.this$0 = peerDeviceStatusManager;
        this.$deviceId = str;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String str = this.$deviceId;
        ILog.d(access$getTag, "#" + str + " has peer app started.");
        String str2 = this.$deviceId;
        if (str2 != null) {
            this.this$0.changeStateUp(str2, PeerState.STARTED);
            this.this$0.hostStatusManager.cancelHostStartJob(this.$deviceId);
            this.this$0.initiateVersionSending(this.$deviceId);
        }
    }
}
