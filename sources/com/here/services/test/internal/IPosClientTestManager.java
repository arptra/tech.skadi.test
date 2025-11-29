package com.here.services.test.internal;

import android.os.Bundle;
import com.here.posclient.ClientConfiguration;

public interface IPosClientTestManager {
    int availableFeatures();

    void clearData(int i);

    void close();

    void dumpCachedData();

    void dumpData();

    void dumpFingerprints();

    void dumpHeapData();

    void dumpRemoteConfiguration();

    int enabledFeatures();

    boolean getActiveCollection();

    boolean getAutoUpload();

    ClientConfiguration getClientConfiguration();

    int getCollectionStats(FingerprintStatsListener fingerprintStatsListener);

    boolean getCollectionStatus();

    long getGnssFingerprintCount();

    long getNonGnssFingerprintCount();

    void logLta(String str);

    void overrideConfiguration(String str);

    void refreshRemoteConfiguration();

    boolean registerHDWifiStateListener(HdWifiStateListener hdWifiStateListener);

    void sendFingerprints();

    boolean setActiveCollection(boolean z);

    boolean setAutoUpload(boolean z);

    void setRadioMapDownloadPath(String str);

    void setUsername(String str);

    boolean startNetworkMeasurementPlayback(Bundle bundle);

    void stopNetworkMeasurementPlayback();

    void toggleFeature(String str, boolean z);

    void unregisterHDWifiStateListener(HdWifiStateListener hdWifiStateListener);
}
