package com.honey.account.d3;

import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import com.share.connect.wifip2p.WifiP2pService;

public final /* synthetic */ class e implements WifiP2pManager.PeerListListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiP2pService f9721a;

    public /* synthetic */ e(WifiP2pService wifiP2pService) {
        this.f9721a = wifiP2pService;
    }

    public final void onPeersAvailable(WifiP2pDeviceList wifiP2pDeviceList) {
        this.f9721a.d0(wifiP2pDeviceList);
    }
}
