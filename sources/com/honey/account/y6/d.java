package com.honey.account.y6;

import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager;
import com.upuphone.starrynet.core.p2p.WiFiP2pGCManager;

public final /* synthetic */ class d implements WifiP2pManager.GroupInfoListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WiFiP2pGCManager f5332a;

    public /* synthetic */ d(WiFiP2pGCManager wiFiP2pGCManager) {
        this.f5332a = wiFiP2pGCManager;
    }

    public final void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
        this.f5332a.lambda$checkStarryP2pConnected$0(wifiP2pGroup);
    }
}
