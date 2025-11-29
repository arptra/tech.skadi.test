package com.here.odnp.wifi;

import com.here.odnp.util.Log;
import com.here.odnp.util.TimeManager;
import com.here.posclient.WifiMeasurement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

abstract class WifiFilterBase implements IWifiFilter {
    private static final String TAG = "odnp.wifi.WifiFilterBase";
    private final Map<String, CacheItem> mCache = new HashMap();
    private WifiMeasurement[] mFilteredMeasurements = new WifiMeasurement[0];

    public static abstract class CacheItem {
        public final WifiMeasurement mWifiMeasurement;

        public CacheItem(WifiMeasurement wifiMeasurement, boolean z) {
            this.mWifiMeasurement = wifiMeasurement;
            if (z) {
                wifiMeasurement.timeStamp = 0;
                wifiMeasurement.elapsedRealtimeTimeStamp = 0;
                return;
            }
            updateRealtimeAge();
            updateTimestamp();
        }

        private void updateRealtimeAge() {
            this.mWifiMeasurement.elapsedRealtimeTimeStamp = TimeManager.timeSinceBoot();
        }

        private void updateTimestamp() {
            long max = Math.max(0, TimeManager.timeSinceBoot() - this.mWifiMeasurement.elapsedRealtimeTimeStamp);
            this.mWifiMeasurement.timeStamp = TimeUnit.MILLISECONDS.toSeconds(Math.max(0, TimeManager.currentTimeMillis() - max));
        }

        public abstract boolean onUpdate(WifiMeasurement wifiMeasurement);

        public boolean update(WifiMeasurement wifiMeasurement) {
            boolean onUpdate = onUpdate(wifiMeasurement);
            if (onUpdate) {
                updateRealtimeAge();
            }
            updateTimestamp();
            this.mWifiMeasurement.rxLevel = wifiMeasurement.rxLevel;
            return onUpdate;
        }
    }

    public static void filterDuplicates(List<WifiMeasurement> list) {
        if (list == null) {
            Log.w(TAG, "filterDuplicates: null measurements -> ignored.", new Object[0]);
            return;
        }
        int size = list.size();
        HashMap hashMap = new HashMap(list.size());
        for (WifiMeasurement next : list) {
            String str = next.bssid;
            if (str != null) {
                hashMap.put(str, next);
            }
        }
        if (size != hashMap.size()) {
            list.clear();
            list.addAll(hashMap.values());
        }
    }

    private synchronized void updateFilteredMeasurements() {
        this.mFilteredMeasurements = new WifiMeasurement[this.mCache.size()];
        int i = 0;
        for (CacheItem cacheItem : this.mCache.values()) {
            int i2 = i + 1;
            this.mFilteredMeasurements[i] = cacheItem.mWifiMeasurement;
            i = i2;
        }
    }

    public abstract CacheItem createCacheItem(WifiMeasurement wifiMeasurement, boolean z);

    public synchronized WifiMeasurement[] getFilteredMeasurements() {
        return this.mFilteredMeasurements;
    }

    public synchronized void reset() {
        this.mCache.clear();
        this.mFilteredMeasurements = new WifiMeasurement[0];
    }

    public synchronized void setInitialMeasurements(List<WifiMeasurement> list) {
        reset();
        if (list == null) {
            Log.w(TAG, "setInitialMeasurements: null measurements, ignored.", new Object[0]);
            return;
        }
        filterDuplicates(list);
        for (WifiMeasurement next : list) {
            this.mCache.put(next.bssid, createCacheItem(next, true));
        }
        updateFilteredMeasurements();
    }

    public synchronized void updateMeasurements(List<WifiMeasurement> list) {
        int i = 0;
        if (list == null) {
            Log.w(TAG, "updateMeasurements: null measurements, ignored.", new Object[0]);
            return;
        }
        filterDuplicates(list);
        HashSet<String> hashSet = new HashSet<>(this.mCache.keySet());
        int i2 = 0;
        int i3 = 0;
        for (WifiMeasurement next : list) {
            CacheItem cacheItem = this.mCache.get(next.bssid);
            hashSet.remove(next.bssid);
            if (cacheItem == null) {
                this.mCache.put(next.bssid, createCacheItem(next, false));
                i2++;
            } else if (cacheItem.update(next)) {
                i3++;
            }
        }
        if (!hashSet.isEmpty()) {
            i = hashSet.size();
            for (String remove : hashSet) {
                this.mCache.remove(remove);
            }
        }
        if (i2 > 0 || i > 0) {
            updateFilteredMeasurements();
        }
        Log.v(TAG, "addScanResult: total: %d new: %d updated: %d removed: %d", Integer.valueOf(this.mFilteredMeasurements.length), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
    }
}
