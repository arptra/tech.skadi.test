package com.here.odnp.debug;

import android.content.Context;
import com.here.odnp.util.TrafficMonitor;

public class DebugInfo {
    private static final String TAG = "odnp.debug.DebugInfo";

    public static void dumpHprofData(Context context) {
    }

    public static void dumpJniInfo() {
    }

    public static String getManagedHeapStatus() {
        return null;
    }

    public static String getNativeHeapStatus() {
        return null;
    }

    public static String getTrafficStatus(TrafficMonitor trafficMonitor) {
        return null;
    }
}
