package com.here.odnp.wifi;

public class WifiFilter {
    public static IWifiFilter create() {
        return new WifiFilterTimestamp();
    }
}
