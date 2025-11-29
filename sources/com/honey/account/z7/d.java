package com.honey.account.z7;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IP2pAcquireCallback;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IP2pAcquireCallback f5351a;

    public /* synthetic */ d(IP2pAcquireCallback iP2pAcquireCallback) {
        this.f5351a = iP2pAcquireCallback;
    }

    public final Object invoke(Object obj) {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().tryAcquireP2p((String) obj, this.f5351a);
    }
}
