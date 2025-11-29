package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.listener.P2pStateListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/interconnect/outer/DeviceOperatorImpl$coreP2pStateListener$1$createParentListener$1", "Lcom/upuphone/xr/interconnect/listener/P2pStateListener;", "onP2pStateChanged", "", "newState", "", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeviceOperatorImpl$coreP2pStateListener$1$createParentListener$1 extends P2pStateListener {
    final /* synthetic */ DeviceOperatorImpl$coreP2pStateListener$1 this$0;

    public DeviceOperatorImpl$coreP2pStateListener$1$createParentListener$1(DeviceOperatorImpl$coreP2pStateListener$1 deviceOperatorImpl$coreP2pStateListener$1) {
        this.this$0 = deviceOperatorImpl$coreP2pStateListener$1;
    }

    public void onP2pStateChanged(int i) {
        DeviceOperatorImpl$coreP2pStateListener$1 deviceOperatorImpl$coreP2pStateListener$1 = this.this$0;
        deviceOperatorImpl$coreP2pStateListener$1.callEachListener("new p2p state " + i, new DeviceOperatorImpl$coreP2pStateListener$1$createParentListener$1$onP2pStateChanged$1(i));
    }
}
