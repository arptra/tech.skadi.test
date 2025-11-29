package com.upuphone.xr.interconnect.inner;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetWifiOperator;
import com.upuphone.xr.interconnect.listener.WifiConnectCallback;
import com.upuphone.xr.interconnect.listener.WifiInfoCallback;

public class InnerWifiOperator implements StarryNetWifiOperator {
    public void connectWifi(String str, String str2, int i, WifiConnectCallback wifiConnectCallback) {
        InterconnectManager.getInstance().getStarryNetWifiManager().connectWifi(str, str2, i, wifiConnectCallback);
    }

    public void getConnectedWifiInfo(WifiInfoCallback wifiInfoCallback) {
        InterconnectManager.getInstance().getStarryNetWifiManager().getConnectedWifiInfo(wifiInfoCallback);
    }
}
