package com.honey.account.z7;

import com.upuphone.xr.interconnect.InterconnectManager;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements Function1 {
    public final Object invoke(Object obj) {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().tryReleaseP2p((String) obj);
    }
}
