package com.here.odnp.wifi.util;

import android.net.wifi.ScanResult;
import com.here.odnp.util.Log;
import com.here.posclient.WifiMeasurement;
import java.util.ArrayList;
import java.util.List;

public class WifiUtils {
    private static final String TAG = "odnp.wifi.util.WifiUtils";

    public static List<WifiMeasurement> toWifiMeasurements(List<ScanResult> list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ScanResult next : list) {
            try {
                arrayList.add(new WifiMeasurement(next));
            } catch (IllegalArgumentException unused) {
                Log.w(TAG, "toWifiMeasurements: Ignoring invalid ScanResult: %s", next);
            }
        }
        return arrayList;
    }
}
