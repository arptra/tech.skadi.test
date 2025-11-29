package com.here.services.playback.internal.wifi;

import android.util.Pair;
import com.here.odnp.util.Log;
import com.here.odnp.wifi.IWifiManager;
import com.here.posclient.WifiMeasurement;
import com.here.services.playback.internal.util.PlaybackReader;
import java.util.List;

public class PlaybackWifiManager implements IWifiManager {
    private static final String TAG = "services.playback.internal.wifi.PlaybackWifiManager";
    private final PlaybackReader mPlaybackReader;
    private IWifiManager.IWifiListener mWifiListener;

    public PlaybackWifiManager(PlaybackReader playbackReader) {
        this.mPlaybackReader = playbackReader;
    }

    public void cancelWifiScan() {
        Log.v(TAG, "cancelWifiScan", new Object[0]);
        this.mPlaybackReader.cancelWifiScan();
    }

    public void close() {
        Log.v(TAG, "close: listener: %s", this.mWifiListener);
        this.mPlaybackReader.removeWifiListener(this.mWifiListener);
        this.mWifiListener = null;
    }

    public Pair<Long, List<WifiMeasurement>> getLastScanResult() {
        Log.v(TAG, "getLastScanResult", new Object[0]);
        return this.mPlaybackReader.getLastWifiScanResult();
    }

    public boolean isWifiSupported() {
        return true;
    }

    public boolean isWifiThrottled() {
        return false;
    }

    public void open(IWifiManager.IWifiListener iWifiListener) {
        Log.v(TAG, "open: listener: %s", iWifiListener);
        this.mWifiListener = iWifiListener;
        this.mPlaybackReader.addWifiListener(iWifiListener);
    }

    public boolean startWifiScan() {
        Log.v(TAG, "startWifiScan", new Object[0]);
        return this.mPlaybackReader.startWifiScan();
    }
}
