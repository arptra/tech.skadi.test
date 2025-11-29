package com.here.odnp.posclient.test;

import com.here.odnp.cell.ICellManager;
import com.here.odnp.gnss.IGnssManager;
import com.here.odnp.posclient.ICloseableSession;
import com.here.odnp.wifi.IWifiManager;
import com.here.posclient.ClientConfiguration;
import com.here.posclient.FingerprintStats;
import com.here.posclient.PositioningFeature;
import com.here.posclient.Status;

public interface IPosClientTesterSession extends ICloseableSession {

    public interface FingerprintStatsListener {
        void onGetStatsCompleted(Status status, FingerprintStats fingerprintStats);
    }

    public interface HDWifiStateListener {
        void onStateUpdate(String str);
    }

    int availableFeatures();

    void clearData(int i);

    void dumpCachedData();

    void dumpFingerprints();

    void dumpRemoteConfiguration();

    int enabledFeatures();

    boolean getActiveCollection();

    boolean getAutoUpload();

    ClientConfiguration getClientConfiguration();

    Status getCollectionStats(FingerprintStatsListener fingerprintStatsListener);

    boolean getCollectionStatus();

    long getGnssFingerprintCount();

    long getNonGnssFingerprintCount();

    void logLta(String str);

    void overrideConfiguration(String str);

    void refreshRemoteConfiguration();

    boolean registerHDWifiStateListener(HDWifiStateListener hDWifiStateListener);

    void resetPositioningFilter();

    boolean restoreMeasurementManagers();

    void sendFingerprints();

    boolean setActiveCollection(boolean z);

    boolean setAutoUpload(boolean z);

    boolean setCellManager(ICellManager iCellManager);

    boolean setGnssManager(IGnssManager iGnssManager);

    void setRadioMapDownloadPath(String str);

    void setUsername(String str);

    boolean setWifiManager(IWifiManager iWifiManager);

    void storeMeasurementManagers();

    void toggleFeature(PositioningFeature positioningFeature, boolean z);

    void unregisterHDWifiStateListener(HDWifiStateListener hDWifiStateListener);
}
