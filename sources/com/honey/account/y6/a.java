package com.honey.account.y6;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import com.upuphone.starrynet.core.p2p.WiFiP2pBaseManager;

public final /* synthetic */ class a implements WifiP2pManager.DeviceInfoListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WiFiP2pBaseManager f5329a;

    public /* synthetic */ a(WiFiP2pBaseManager wiFiP2pBaseManager) {
        this.f5329a = wiFiP2pBaseManager;
    }

    public final void onDeviceInfoAvailable(WifiP2pDevice wifiP2pDevice) {
        this.f5329a.lambda$requestP2pDevice$0(wifiP2pDevice);
    }
}
