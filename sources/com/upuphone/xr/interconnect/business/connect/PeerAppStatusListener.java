package com.upuphone.xr.interconnect.business.connect;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/PeerAppStatusListener;", "", "onPeerAppInstalled", "", "deviceId", "", "onPeerAppStarted", "onPeerAppStopped", "onPeerAppUninstalled", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface PeerAppStatusListener {
    void onPeerAppInstalled(@NotNull String str);

    void onPeerAppStarted(@NotNull String str);

    void onPeerAppStopped(@NotNull String str);

    void onPeerAppUninstalled(@NotNull String str);
}
