package com.upuphone.xr.interconnect.util;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.upuphone.xr.interconnect.InterconnectManager;

public class WifiUtil {
    public static boolean connectWifi(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Context context = InterconnectManager.getInstance().getContext();
        if (str2 != null) {
            str2 = "\"" + str2 + "\"";
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = str;
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        if (i == 0) {
            wifiConfiguration.wepKeys[0] = str2;
            wifiConfiguration.wepTxKeyIndex = 0;
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.allowedGroupCiphers.set(0);
        } else if (i == 1) {
            wifiConfiguration.preSharedKey = str2;
        } else {
            wifiConfiguration.allowedKeyManagement.set(0);
        }
        return wifiManager.enableNetwork(wifiManager.addNetwork(wifiConfiguration), true);
    }

    public static String getConnectedSSID() {
        WifiInfo connectionInfo = ((WifiManager) InterconnectManager.getInstance().getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo != null) {
            return connectionInfo.getSSID();
        }
        return null;
    }

    public static boolean isEnabled() {
        return ((WifiManager) InterconnectManager.getInstance().getContext().getApplicationContext().getSystemService("wifi")).isWifiEnabled();
    }
}
