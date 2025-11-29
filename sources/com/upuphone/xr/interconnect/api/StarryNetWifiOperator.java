package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.listener.WifiConnectCallback;
import com.upuphone.xr.interconnect.listener.WifiInfoCallback;

public interface StarryNetWifiOperator {
    void connectWifi(String str, String str2, int i, WifiConnectCallback wifiConnectCallback);

    void getConnectedWifiInfo(WifiInfoCallback wifiInfoCallback);
}
