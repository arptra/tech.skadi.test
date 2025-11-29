package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PeerDeviceStatusManager$onRemoteError$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $code;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $uniteCode;
    final /* synthetic */ PeerDeviceStatusManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeerDeviceStatusManager$onRemoteError$1(PeerDeviceStatusManager peerDeviceStatusManager, String str, String str2, int i) {
        super(0);
        this.this$0 = peerDeviceStatusManager;
        this.$deviceId = str;
        this.$uniteCode = str2;
        this.$code = i;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String str = this.$deviceId;
        String str2 = this.$uniteCode;
        int i = this.$code;
        ILog.d(access$getTag, "#" + str + "/" + str2 + " reported error " + i + ".");
        if (this.$deviceId != null && Intrinsics.areEqual((Object) this.$uniteCode, (Object) InterconnectManager.getInstance().getPeerPackageName()) && this.$code == 203002) {
            this.this$0.changeStateDown(this.$deviceId, PeerState.AVAILABLE);
            this.this$0.versionMap.remove(this.$deviceId);
            this.this$0.versionSentDevices.remove(this.$deviceId);
            this.this$0.versionSendManager.cancelVersionSendJob(this.$deviceId);
            this.this$0.hostStatusManager.launchHostStartJob(this.$deviceId, this.this$0.getTag());
        }
    }
}
