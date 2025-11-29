package com.upuphone.xr.interconnect.business.connect.primary;

import com.upuphone.xr.interconnect.business.connect.primary.VersionSendManager;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VersionSendManager$VersionSendCallback$onFailure$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VersionSendManager this$0;
    final /* synthetic */ VersionSendManager.VersionSendCallback this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VersionSendManager$VersionSendCallback$onFailure$1(VersionSendManager versionSendManager, VersionSendManager.VersionSendCallback versionSendCallback) {
        super(0);
        this.this$0 = versionSendManager;
        this.this$1 = versionSendCallback;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        int access$getVersion$p = this.this$1.version;
        String access$getDeviceId$p = this.this$1.deviceId;
        ILog.d(access$getTag, "Version " + access$getVersion$p + " failed to send to #" + access$getDeviceId$p + ".");
        if (!this.this$1.isDestroyed()) {
            this.this$0.retryVersionSend(this.this$1.deviceId, this.this$1.version, this.this$1);
        }
    }
}
