package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.common.IP2pStateListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class P2pConnectionManager$unregisterStateListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IP2pStateListener $listener;
    final /* synthetic */ P2pConnectionManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public P2pConnectionManager$unregisterStateListener$1(IP2pStateListener iP2pStateListener, P2pConnectionManager p2pConnectionManager) {
        super(0);
        this.$listener = iP2pStateListener;
        this.this$0 = p2pConnectionManager;
    }

    public final void invoke() {
        IP2pStateListener iP2pStateListener = this.$listener;
        if (iP2pStateListener != null) {
            this.this$0.p2pStateListeners.remove(iP2pStateListener);
        }
    }
}
