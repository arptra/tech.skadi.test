package com.honey.account.y6;

import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager;
import com.upuphone.starrynet.core.p2p.WiFiP2pGOManager;

public final /* synthetic */ class g implements WifiP2pManager.GroupInfoListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WiFiP2pGOManager f5335a;

    public /* synthetic */ g(WiFiP2pGOManager wiFiP2pGOManager) {
        this.f5335a = wiFiP2pGOManager;
    }

    public final void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
        this.f5335a.lambda$new$0(wifiP2pGroup);
    }
}
