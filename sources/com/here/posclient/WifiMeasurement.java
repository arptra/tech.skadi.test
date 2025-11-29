package com.here.posclient;

import android.net.wifi.ScanResult;
import com.here.odnp.util.TimeManager;
import com.honey.account.constant.AccountConstantKt;

public class WifiMeasurement {
    private static final String CAPABILITY_ADHOC = "[IBSS]";
    public static final int FREQ_NOT_SET = 0;
    private static final int MAC_48_STRING_LENGTH = 17;
    private static final int MAC_64_STRING_LENGTH = 16;
    public static final byte NETWORK_MODE_ADHOC = 2;
    public static final byte NETWORK_MODE_INFRA = 1;
    public static final byte NETWORK_MODE_UNKNOWN = 0;
    public static final int RSSI_NOT_SET = Integer.MAX_VALUE;
    public String bssid;
    public int distance;
    public int distanceUncertainty;
    public long elapsedRealtimeTimeStamp;
    public int frequency;
    public byte mode;
    public int rssi;
    public int rxLevel;
    public String ssid;
    public long timeStamp;
    public long tsf;
    public int txLevel;

    public WifiMeasurement() {
        this.frequency = 0;
        this.rxLevel = Integer.MAX_VALUE;
        this.txLevel = Integer.MAX_VALUE;
        this.mode = 0;
        this.tsf = TimeManager.currentTimeMillis();
        this.timeStamp = TimeManager.currentTimeMillis() / 1000;
        this.elapsedRealtimeTimeStamp = TimeManager.timeSinceBoot();
    }

    public static String toMac64(String str) {
        if (str != null) {
            if (str.length() == 17) {
                str = str.substring(0, 9) + "FF:FF:" + str.substring(9);
            } else if (str.length() != 16) {
                throw new IllegalArgumentException("incorrect bssid length: '" + str + "'");
            }
            return str.replace(AccountConstantKt.CODE_SEPARTOR, "");
        }
        throw new IllegalArgumentException("bssid is null");
    }

    public void setFrequency(int i) {
        this.frequency = i;
    }

    public WifiMeasurement(WifiMeasurement wifiMeasurement) {
        this.frequency = 0;
        this.rxLevel = Integer.MAX_VALUE;
        this.txLevel = Integer.MAX_VALUE;
        this.mode = 0;
        this.frequency = wifiMeasurement.frequency;
        this.timeStamp = wifiMeasurement.timeStamp;
        this.elapsedRealtimeTimeStamp = wifiMeasurement.elapsedRealtimeTimeStamp;
        this.bssid = wifiMeasurement.bssid;
        this.ssid = wifiMeasurement.ssid;
        this.rxLevel = wifiMeasurement.rxLevel;
        this.txLevel = wifiMeasurement.txLevel;
        this.distance = wifiMeasurement.distance;
        this.distanceUncertainty = wifiMeasurement.distanceUncertainty;
        this.rssi = wifiMeasurement.rssi;
        this.mode = wifiMeasurement.mode;
    }

    public WifiMeasurement(ScanResult scanResult) {
        this.frequency = 0;
        this.rxLevel = Integer.MAX_VALUE;
        this.txLevel = Integer.MAX_VALUE;
        this.mode = 0;
        this.bssid = toMac64(scanResult.BSSID);
        this.ssid = scanResult.SSID;
        this.rxLevel = scanResult.level;
        this.timeStamp = TimeManager.currentTimeMillis() / 1000;
        this.elapsedRealtimeTimeStamp = TimeManager.timeSinceBoot();
        this.tsf = scanResult.timestamp;
        if (scanResult.capabilities.contains(CAPABILITY_ADHOC)) {
            this.mode = 2;
        } else {
            this.mode = 1;
        }
        setFrequency(scanResult.frequency);
    }
}
