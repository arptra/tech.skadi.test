package com.here.services.test.internal;

import com.here.posclient.ClientConfiguration;
import com.here.posclient.PositioningFeature;
import com.here.posclient.Status;
import com.here.services.internal.Manager;
import com.here.services.test.fingerprint.FingerprintCollectionTestApi;
import com.here.services.test.fingerprint.HdWifiCollectionTestApi;

public interface ILocationTest extends Manager {
    public static final int POSFEAT_ACTIVE_CACHE = 512;
    public static final int POSFEAT_CACHE = 4;
    public static final int POSFEAT_COLLECTOR = 256;
    public static final int POSFEAT_LEARNING = 16;
    public static final int POSFEAT_OFFLINE = 1;
    public static final int POSFEAT_ONLINE = 2;
    public static final int POSFEAT_RM_DOWNLOAD = 1024;
    public static final int TECHNOLOGY_CELL = 4;
    public static final int TECHNOLOGY_COUNTRY = 64;
    public static final int TECHNOLOGY_ECELL = 8;
    public static final int TECHNOLOGY_ENODEB = 4096;
    public static final int TECHNOLOGY_GNSS = 1;
    public static final int TECHNOLOGY_IP = 128;
    public static final int TECHNOLOGY_LOCATION_AREA = 16;
    public static final int TECHNOLOGY_MAP = 512;
    public static final int TECHNOLOGY_NETWORK = 32;
    public static final int TECHNOLOGY_RNC = 2048;
    public static final int TECHNOLOGY_SENSORS = 256;
    public static final int TECHNOLOGY_SYSTEM = 8192;
    public static final int TECHNOLOGY_TRACKING_AREA = 1024;
    public static final int TECHNOLOGY_UNSPECIFIED = 0;
    public static final int TECHNOLOGY_WLAN = 2;

    public interface DataItem {
        public static final int ACTIVE_STORAGE = 128;
        public static final int ALL = 1073741823;
        public static final int CALIBRATION = 256;
        public static final int CELL_CACHE = 4;
        public static final int CROWDSOURCING_FILES = 6144;
        public static final int CURRENT_POSITION = 8;
        public static final int HD_CROWDSOURCING_FILES = 4096;
        public static final int LEARNING_CACHE = 16;
        public static final int ONLINE_LATEST_KNOWN_POSITION = 1;
        public static final int RADIO_MAP_FILES = 32;
        public static final int REMOTE_CONFIGURATION = 1024;
        public static final int SD_CROWDSOURCING_FILES = 2048;
        public static final int TRANSFER_COUNTERS = 512;
        public static final int WLAN_CACHE = 2;
    }

    int availableFeatures();

    void clearData(int i);

    void dumpCachedData();

    void dumpData();

    void dumpFingerprints();

    void dumpHeapData();

    void dumpRemoteConfiguration();

    int enabledFeatures();

    int enabledTechnologies();

    boolean getActiveCollection();

    boolean getAutoUpload();

    ClientConfiguration getClientConfiguration();

    Status getCollectionStats(FingerprintCollectionTestApi.StatsListener statsListener);

    boolean getCollectionStatus();

    long getGnssFingerprintCount();

    long getNonGnssFingerprintCount();

    void logLta(String str);

    void overrideConfiguration(String str);

    void refreshRemoteConfiguration();

    boolean registerHdWifiStateListener(HdWifiCollectionTestApi.StateListener stateListener);

    void sendFingerprints();

    boolean setActiveCollection(boolean z);

    boolean setAutoUpload(boolean z);

    void setUsername(String str);

    void toggleFeature(PositioningFeature positioningFeature, boolean z);

    void toggleTechnology(int i, boolean z);

    void unregisterHdWifiStateListener(HdWifiCollectionTestApi.StateListener stateListener);
}
