package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.common.IP2pAcquireCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectManager$acquireP2p$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IP2pAcquireCallback $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectManager$acquireP2p$2(IP2pAcquireCallback iP2pAcquireCallback) {
        super(0);
        this.$callback = iP2pAcquireCallback;
    }

    public final void invoke() {
        IP2pAcquireCallback iP2pAcquireCallback = this.$callback;
        if (iP2pAcquireCallback != null) {
            iP2pAcquireCallback.onFail(-1);
        }
    }
}
