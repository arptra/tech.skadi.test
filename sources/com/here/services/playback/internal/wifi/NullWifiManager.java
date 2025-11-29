package com.here.services.playback.internal.wifi;

import android.util.Pair;
import com.here.odnp.util.Log;
import com.here.odnp.wifi.IWifiManager;
import com.here.posclient.WifiMeasurement;
import java.util.ArrayList;
import java.util.List;

public class NullWifiManager implements IWifiManager {
    private static final String TAG = "services.playback.internal.wifi.NullWifiManager";

    public NullWifiManager() {
        Log.v(TAG, "NullWifiManager", new Object[0]);
    }

    public void cancelWifiScan() {
    }

    public void close() {
    }

    public Pair<Long, List<WifiMeasurement>> getLastScanResult() {
        return new Pair<>(0L, new ArrayList());
    }

    public boolean isWifiSupported() {
        return true;
    }

    public boolean isWifiThrottled() {
        return false;
    }

    public void open(IWifiManager.IWifiListener iWifiListener) {
    }

    public boolean startWifiScan() {
        return false;
    }
}
