package com.here.services.test.location;

import com.here.posclient.ClientConfiguration;
import com.here.posclient.PositioningFeature;
import com.here.services.HereLocationApiClient;

public interface LocationTestApi {
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

    int availableFeatures(HereLocationApiClient hereLocationApiClient);

    void clearData(HereLocationApiClient hereLocationApiClient, int i);

    void dumpCachedData(HereLocationApiClient hereLocationApiClient);

    void dumpData(HereLocationApiClient hereLocationApiClient);

    void dumpHeapData(HereLocationApiClient hereLocationApiClient);

    void dumpRemoteConfiguration(HereLocationApiClient hereLocationApiClient);

    int enabledFeatures(HereLocationApiClient hereLocationApiClient);

    int enabledTechnologies(HereLocationApiClient hereLocationApiClient);

    ClientConfiguration getClientConfiguration(HereLocationApiClient hereLocationApiClient);

    void logLta(HereLocationApiClient hereLocationApiClient, String str);

    void refreshRemoteConfiguration(HereLocationApiClient hereLocationApiClient);

    void toggleFeature(HereLocationApiClient hereLocationApiClient, PositioningFeature positioningFeature, boolean z);

    void toggleTechnology(HereLocationApiClient hereLocationApiClient, int i, boolean z);
}
