package com.honey.account.y6;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import com.upuphone.starrynet.core.p2p.WiFiP2pBaseManager;
import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class b implements WifiP2pManager.DeviceInfoListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WiFiP2pBaseManager f5330a;
    public final /* synthetic */ CountDownLatch b;

    public /* synthetic */ b(WiFiP2pBaseManager wiFiP2pBaseManager, CountDownLatch countDownLatch) {
        this.f5330a = wiFiP2pBaseManager;
        this.b = countDownLatch;
    }

    public final void onDeviceInfoAvailable(WifiP2pDevice wifiP2pDevice) {
        this.f5330a.lambda$getP2pMacAddress$1(this.b, wifiP2pDevice);
    }
}
