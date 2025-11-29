package com.upuphone.ai.ttsengine.flavor.service.connect;

import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.xr.interconnect.listener.P2pStateListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ai/ttsengine/flavor/service/connect/Communicator$p2pStateListener$1", "Lcom/upuphone/xr/interconnect/listener/P2pStateListener;", "onP2pStateChanged", "", "newState", "", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Communicator$p2pStateListener$1 extends P2pStateListener {
    final /* synthetic */ Communicator this$0;

    public Communicator$p2pStateListener$1(Communicator communicator) {
        this.this$0 = communicator;
    }

    public void onP2pStateChanged(int i) {
        AILOG c = this.this$0.f5565a;
        c.m("onP2pStateChanged new state: " + i, new Object[0]);
    }
}
