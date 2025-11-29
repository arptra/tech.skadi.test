package com.here.odnp.wifi;

import android.os.SystemClock;
import com.here.odnp.util.Log;
import com.here.odnp.wifi.WifiFilterBase;
import com.here.posclient.WifiMeasurement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WifiFilterTimestamp extends WifiFilterBase {
    private static final String TAG = "odnp.wifi.WifiFilterTimestamp";

    public static class CacheItemTimestamp extends WifiFilterBase.CacheItem {
        public CacheItemTimestamp(WifiMeasurement wifiMeasurement, boolean z) {
            super(wifiMeasurement, z);
        }

        public boolean onUpdate(WifiMeasurement wifiMeasurement) {
            long j = wifiMeasurement.tsf;
            WifiMeasurement wifiMeasurement2 = this.mWifiMeasurement;
            if (j == wifiMeasurement2.tsf) {
                return false;
            }
            wifiMeasurement2.tsf = j;
            return true;
        }
    }

    public WifiFilterTimestamp() {
        Log.v(TAG, "WifiFilterTimestamp", new Object[0]);
    }

    public static boolean updateTimestamps(List<WifiMeasurement> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (WifiMeasurement next : list) {
            long millis = TimeUnit.MICROSECONDS.toMillis(next.tsf);
            if (millis < 0 || millis > elapsedRealtime) {
                Log.w(TAG, "updateTimestamps: Invalid timestamp detected: %d", Long.valueOf(millis));
                return false;
            }
            next.elapsedRealtimeTimeStamp = millis;
            next.timeStamp = ((System.currentTimeMillis() - elapsedRealtime) + millis) / 1000;
        }
        return true;
    }

    public WifiFilterBase.CacheItem createCacheItem(WifiMeasurement wifiMeasurement, boolean z) {
        return new CacheItemTimestamp(wifiMeasurement, z);
    }

    public /* bridge */ /* synthetic */ WifiMeasurement[] getFilteredMeasurements() {
        return super.getFilteredMeasurements();
    }

    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    public /* bridge */ /* synthetic */ void setInitialMeasurements(List list) {
        super.setInitialMeasurements(list);
    }

    public /* bridge */ /* synthetic */ void updateMeasurements(List list) {
        super.updateMeasurements(list);
    }
}
