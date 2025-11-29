package com.here.posclient;

import android.location.GnssStatus;
import com.here.odnp.gnss.GnssObservationData;
import com.here.odnp.gnss.GnssObservationHeader;
import com.here.posclient.INetworkManager;
import com.here.posclient.sensors.ActivityResult;

public class PosClientLib {

    public interface ClearItem {
        public static final int ACTIVE_STORAGE = 128;
        public static final int ALL = 1073741823;
        public static final int CALIBRATION = 256;
        public static final int CELL_CACHE = 4;
        public static final int CROWDSOURCING_FILES = 6144;
        public static final int CURRENT_POSITION = 8;
        public static final int DONT_RESTART_ENGINES = 1073741824;
        public static final int HD_CROWDSOURCING_FILES = 4096;
        public static final int LEARNING_CACHE = 16;
        public static final int ONLINE_LATEST_KNOWN_POSITION = 1;
        public static final int RADIO_MAP_FILES = 32;
        public static final int REMOTE_CONFIGURATION = 1024;
        public static final int SD_CROWDSOURCING_FILES = 2048;
        public static final int TRANSFER_COUNTERS = 512;
        public static final int WLAN_CACHE = 2;
    }

    public enum ConnectionChangeAction {
        CONNECTION_CONNECTED,
        CONNECTION_DISCONNECTED,
        CONNECTION_CHANGED
    }

    public static native boolean clearData(int i);

    public static ClientConfiguration getClientConfiguration() {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        if (getClientConfiguration(clientConfiguration)) {
            return clientConfiguration;
        }
        return null;
    }

    private static native boolean getClientConfiguration(ClientConfiguration clientConfiguration);

    public static native PositionEstimate getLastPosition();

    public static native void handleActivityResult(ActivityResult activityResult);

    public static native void handleAndroidGnssStatusChanged(long j, GnssStatus gnssStatus);

    public static native void handleCellularScanResult(CellMeasurement cellMeasurement, boolean z);

    public static native void handleCellularStatusChanged(CellularStatus cellularStatus);

    public static native void handleConnectionChange(ConnectionChangeAction connectionChangeAction, INetworkManager.Connection connection);

    public static native void handleGnssLocationUpdate(PositionEstimate positionEstimate, boolean z);

    public static native void handleGnssMeasurements(GnssObservationHeader gnssObservationHeader, GnssObservationData[] gnssObservationDataArr);

    public static native void handleGnssStatusChanged(int i);

    public static native void handleRequestError(int i, int i2);

    public static native void handleWifiScanResult(long j, WifiMeasurement[] wifiMeasurementArr, boolean z, boolean z2);

    public static native void handleWifiStatusChanged(int i);

    public static native boolean init(InitOptions initOptions);

    public static native int injectLocation(PositionEstimate positionEstimate);

    public static native void logLta(String str);

    public static native int requestPosition(UpdateOptions updateOptions);

    public static native int requestSinglePosition(UpdateOptions updateOptions, IPosClientObserver iPosClientObserver);

    public static native void setBatteryLevel(int i);

    public static native void setScreenState(boolean z);

    public static native int setUpdateOptions(UpdateOptions updateOptions);

    public static native int startInjectionUpdates();

    public static native int startPositionUpdates();

    public static native void stopPositionUpdates();

    public static native void uninit();
}
