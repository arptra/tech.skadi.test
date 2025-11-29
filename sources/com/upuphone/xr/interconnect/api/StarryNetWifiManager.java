package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.common.IWifiConnectCallback;
import com.upuphone.xr.interconnect.common.IWifiInfoCallback;

public interface StarryNetWifiManager {
    void connectWifi(String str, String str2, int i, IWifiConnectCallback iWifiConnectCallback);

    void getConnectedWifiInfo(IWifiInfoCallback iWifiInfoCallback);
}
