package com.upuphone.starrynet.core.ap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

public class WiFiApBaseManager extends BroadcastReceiver {
    protected final WifiManager mWifiManager;

    public WiFiApBaseManager(Context context) {
        this.mWifiManager = (WifiManager) context.getSystemService("wifi");
    }

    public WifiConfiguration getConfig(String str, String str2) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = "\"" + str + "\"";
        if (TextUtils.isEmpty(str2)) {
            wifiConfiguration.allowedKeyManagement.set(0);
        } else {
            wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
        }
        return wifiConfiguration;
    }

    public void onReceive(Context context, Intent intent) {
    }
}
