package com.here.services.test.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.here.odnp.debug.DebugFile;
import com.here.odnp.debug.DebugInfo;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.posclient.test.IPosClientTesterSession;
import com.here.odnp.util.Log;
import com.here.posclient.ClientConfiguration;
import com.here.posclient.FingerprintStats;
import com.here.posclient.PositioningFeature;
import com.here.posclient.Status;
import java.util.HashMap;
import java.util.Map;

public class PosClientTestManager implements IPosClientTestManager {
    private static final String TAG = "services.test.internal.PosClientTestManager";
    private final Context mContext;
    private final Map<IBinder, IPosClientTesterSession.HDWifiStateListener> mListeners = new HashMap();
    private final IPosClientManager mPosClientManager;
    private final IPosClientTesterSession mPosClientTesterSession;

    private PosClientTestManager(IPosClientManager iPosClientManager) {
        Log.v(TAG, "PosClientTestManager", new Object[0]);
        this.mPosClientManager = iPosClientManager;
        this.mContext = iPosClientManager.getContext();
        this.mPosClientTesterSession = iPosClientManager.createTesterSession();
    }

    public static IPosClientTestManager create(IPosClientManager iPosClientManager) {
        return new PosClientTestManager(iPosClientManager);
    }

    public int availableFeatures() {
        if (this.mPosClientTesterSession.open()) {
            return this.mPosClientTesterSession.availableFeatures();
        }
        Log.w(TAG, "availableFeatures: PosClientTesterSession.open failed", new Object[0]);
        return 0;
    }

    public void clearData(int i) {
        if (!this.mPosClientTesterSession.open()) {
            Log.w(TAG, "clearData: PosClientTesterSession.open failed", new Object[0]);
        } else {
            this.mPosClientTesterSession.clearData(i);
        }
    }

    public void close() {
        Log.v(TAG, "close", new Object[0]);
        IPosClientTesterSession iPosClientTesterSession = this.mPosClientTesterSession;
        if (iPosClientTesterSession != null) {
            iPosClientTesterSession.close();
        }
    }

    public void dumpCachedData() {
        if (!this.mPosClientTesterSession.open()) {
            Log.w(TAG, "dumpCachedData: PosClientTesterSession.open failed", new Object[0]);
        } else {
            this.mPosClientTesterSession.dumpCachedData();
        }
    }

    public void dumpData() {
        if (!this.mPosClientTesterSession.open()) {
            Log.w(TAG, "dumpData: PosClientTesterSession.open failed", new Object[0]);
        } else {
            DebugFile.dumpData(this.mContext);
        }
    }

    public void dumpFingerprints() {
        if (!this.mPosClientTesterSession.open()) {
            Log.w(TAG, "dumpFingerprints: PosClientTesterSession.open failed", new Object[0]);
        } else {
            this.mPosClientTesterSession.dumpFingerprints();
        }
    }

    public void dumpHeapData() {
        if (!this.mPosClientTesterSession.open()) {
            Log.w(TAG, "dumpHeapData: PosClientTesterSession.open failed", new Object[0]);
        } else {
            DebugInfo.dumpHprofData(this.mContext);
        }
    }

    public void dumpRemoteConfiguration() {
        IPosClientTesterSession iPosClientTesterSession = this.mPosClientTesterSession;
        if (iPosClientTesterSession != null) {
            iPosClientTesterSession.dumpRemoteConfiguration();
        }
    }

    public int enabledFeatures() {
        if (this.mPosClientTesterSession.open()) {
            return this.mPosClientTesterSession.enabledFeatures();
        }
        Log.w(TAG, "enabledFeatures: PosClientTesterSession.open failed", new Object[0]);
        return 0;
    }

    public boolean getActiveCollection() {
        if (this.mPosClientTesterSession.open()) {
            return this.mPosClientTesterSession.getActiveCollection();
        }
        Log.w(TAG, "getActiveCollection: PosClientTesterSession.open failed", new Object[0]);
        return false;
    }

    public boolean getAutoUpload() {
        if (this.mPosClientTesterSession.open()) {
            return this.mPosClientTesterSession.getAutoUpload();
        }
        Log.w(TAG, "getAutoUpload: PosClientTesterSession.open failed", new Object[0]);
        return false;
    }

    public ClientConfiguration getClientConfiguration() {
        Log.v(TAG, "close", new Object[0]);
        IPosClientTesterSession iPosClientTesterSession = this.mPosClientTesterSession;
        if (iPosClientTesterSession == null) {
            return null;
        }
        return iPosClientTesterSession.getClientConfiguration();
    }

    public int getCollectionStats(final FingerprintStatsListener fingerprintStatsListener) {
        if (this.mPosClientTesterSession.open()) {
            return this.mPosClientTesterSession.getCollectionStats(new IPosClientTesterSession.FingerprintStatsListener() {
                public void onGetStatsCompleted(Status status, FingerprintStats fingerprintStats) {
                    try {
                        fingerprintStatsListener.onGetStatsCompleted(status.toInt(), fingerprintStats.asBundle());
                    } catch (RemoteException unused) {
                        Log.e(PosClientTestManager.TAG, "getCollectionStats: onGetStatsCompleted call failed", new Object[0]);
                    }
                }
            }).toInt();
        }
        Log.w(TAG, "getCollectionStats: PosClientTesterSession.open failed", new Object[0]);
        return Status.InternalError.toInt();
    }

    public boolean getCollectionStatus() {
        if (this.mPosClientTesterSession.open()) {
            return this.mPosClientTesterSession.getCollectionStatus();
        }
        Log.w(TAG, "getCollectionStatus: PosClientTesterSession.open failed", new Object[0]);
        return false;
    }

    public long getGnssFingerprintCount() {
        if (this.mPosClientTesterSession.open()) {
            return this.mPosClientTesterSession.getGnssFingerprintCount();
        }
        Log.w(TAG, "getGnssFingerprintCount: PosClientTesterSession.open failed", new Object[0]);
        return 0;
    }

    public long getNonGnssFingerprintCount() {
        if (this.mPosClientTesterSession.open()) {
            return this.mPosClientTesterSession.getNonGnssFingerprintCount();
        }
        Log.w(TAG, "getNonGnssFingerprintCount: PosClientTesterSession.open failed", new Object[0]);
        return 0;
    }

    public void logLta(String str) {
        IPosClientTesterSession iPosClientTesterSession = this.mPosClientTesterSession;
        if (iPosClientTesterSession != null) {
            iPosClientTesterSession.logLta(str);
        }
    }

    public void overrideConfiguration(String str) {
        if (!this.mPosClientTesterSession.open()) {
            Log.w(TAG, "overrideConfiguration: PosClientTesterSession.open failed", new Object[0]);
        } else {
            this.mPosClientTesterSession.overrideConfiguration(str);
        }
    }

    public void refreshRemoteConfiguration() {
        IPosClientTesterSession iPosClientTesterSession = this.mPosClientTesterSession;
        if (iPosClientTesterSession != null) {
            iPosClientTesterSession.refreshRemoteConfiguration();
        }
    }

    public boolean registerHDWifiStateListener(final HdWifiStateListener hdWifiStateListener) {
        if (this.mListeners.containsKey(hdWifiStateListener.asBinder())) {
            Log.w(TAG, "registerHDWifiStateListener: already registered", new Object[0]);
            return true;
        }
        AnonymousClass2 r0 = new IPosClientTesterSession.HDWifiStateListener() {
            public void onStateUpdate(String str) {
                try {
                    hdWifiStateListener.onStateUpdate(str);
                } catch (RemoteException unused) {
                    Log.e(PosClientTestManager.TAG, "registerHDWifiStateListener: onStateUpdate call failed", new Object[0]);
                }
            }
        };
        this.mListeners.put(hdWifiStateListener.asBinder(), r0);
        return this.mPosClientTesterSession.registerHDWifiStateListener(r0);
    }

    public void sendFingerprints() {
        if (!this.mPosClientTesterSession.open()) {
            Log.w(TAG, "sendFingerprints: PosClientTesterSession.open failed", new Object[0]);
        } else {
            this.mPosClientTesterSession.sendFingerprints();
        }
    }

    public boolean setActiveCollection(boolean z) {
        if (this.mPosClientTesterSession.open()) {
            return this.mPosClientTesterSession.setActiveCollection(z);
        }
        Log.w(TAG, "setActiveCollection: PosClientTesterSession.open failed", new Object[0]);
        return false;
    }

    public boolean setAutoUpload(boolean z) {
        if (this.mPosClientTesterSession.open()) {
            return this.mPosClientTesterSession.setAutoUpload(z);
        }
        Log.w(TAG, "setAutoUpload: PosClientTesterSession.open failed", new Object[0]);
        return false;
    }

    public void setRadioMapDownloadPath(String str) {
        this.mPosClientTesterSession.setRadioMapDownloadPath(str);
    }

    public void setUsername(String str) {
        if (!this.mPosClientTesterSession.open()) {
            Log.w(TAG, "setUsername: PosClientTesterSession.open failed", new Object[0]);
        } else {
            this.mPosClientTesterSession.setUsername(str);
        }
    }

    public boolean startNetworkMeasurementPlayback(Bundle bundle) {
        return false;
    }

    public void stopNetworkMeasurementPlayback() {
    }

    public void toggleFeature(String str, boolean z) {
        if (!this.mPosClientTesterSession.open()) {
            Log.w(TAG, "toggleFeature: PosClientTesterSession.open failed", new Object[0]);
            return;
        }
        try {
            this.mPosClientTesterSession.toggleFeature(PositioningFeature.valueOf(str), z);
        } catch (Exception unused) {
            Log.e(TAG, "toggleFeature: unknown feature: '%s' -> ignored", str);
        }
    }

    public void unregisterHDWifiStateListener(HdWifiStateListener hdWifiStateListener) {
        if (!this.mListeners.containsKey(hdWifiStateListener.asBinder())) {
            Log.w(TAG, "unregisterHDWifiStateListener: not registered", new Object[0]);
        } else {
            this.mPosClientTesterSession.unregisterHDWifiStateListener(this.mListeners.remove(hdWifiStateListener.asBinder()));
        }
    }
}
