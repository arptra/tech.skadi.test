package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.starrynetsdk.ability.relay.RelayListener;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0011\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/PeerAppRelayListener;", "Lcom/upuphone/starrynetsdk/ability/relay/RelayListener;", "()V", "tag", "", "getTag$SharedImpl_intlRelease", "()Ljava/lang/String;", "onRelay", "", "deviceId", "uniteCode", "data", "", "onRemoteError", "code", "", "onRemoteStarted", "onRemoteStopped", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PeerAppRelayListener implements RelayListener {
    @NotNull
    private final String tag = PrettyPrintExtKt.stringify(this);

    @NotNull
    public final String getTag$SharedImpl_intlRelease() {
        return this.tag;
    }

    public void onRelay(@Nullable String str, @Nullable String str2, @Nullable byte[] bArr) {
    }

    public void onRemoteError(@Nullable String str, @Nullable String str2, int i) {
        String str3 = this.tag;
        ILog.d(str3, str2 + " reported error " + i + " on " + str + ".");
        if (str != null && str2 != null && i == 203002) {
            String str4 = this.tag;
            ILog.d(str4, str2 + " confirmed to be died.");
            StarryNetMessage starryNetMessage = new StarryNetMessage();
            starryNetMessage.setSenderPkg("System");
            starryNetMessage.setMessage("XR-SDK宿主App Died");
            InterconnectManager.getInstance().getMainDispatcher().notifyDiedEvent(starryNetMessage);
            InterconnectManager.getInstance().getDataBinderManager().onRemoteServiceDied(str);
        }
    }

    public void onRemoteStarted(@Nullable String str, @Nullable String str2) {
        String str3 = this.tag;
        ILog.d(str3, str2 + " started on " + str + ".");
        if (str != null && str2 != null) {
            InterconnectManager.getInstance().getDataBinderManager().onRemoteServiceStarted(str);
        }
    }

    public void onRemoteStopped(@Nullable String str, @Nullable String str2) {
        String str3 = this.tag;
        ILog.d(str3, str2 + " stopped on " + str + ".");
    }
}
