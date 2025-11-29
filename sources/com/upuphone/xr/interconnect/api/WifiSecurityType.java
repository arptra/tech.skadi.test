package com.upuphone.xr.interconnect.api;

import android.net.wifi.ScanResult;
import androidx.annotation.Keep;

@Keep
public class WifiSecurityType {
    public static final int NONE = 2;
    public static final int WEP = 0;
    public static final int WPA = 1;

    public static int fromScanResult(ScanResult scanResult) {
        if (scanResult == null) {
            return 2;
        }
        return (!scanResult.capabilities.contains("WEB") && !scanResult.capabilities.contains("PSK")) ? 2 : 0;
    }
}
