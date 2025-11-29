package com.here.posclient;

import android.content.Context;
import android.os.Build;
import com.here.posclient.auth.AuthData;
import com.here.posclient.sensors.ISensorManager;

public class InitOptions {
    public static final String KEY_OPTION_CELLULAR_LIMIT = "com.here.posclient.InitOptions.cellularLimit";
    public static final String KEY_OPTION_CLEAN = "com.here.posclient.InitOptions.clean";
    public static final String KEY_OPTION_DIRECT_BOOT = "com.here.posclient.InitOptions.directBoot";
    public static final String KEY_OPTION_FEATURES = "com.here.posclient.InitOptions.features";
    public static final String KEY_OPTION_HTTP_ADAPTATION_PTR = "com.here.posclient.InitOptions.httpAdaptationPtr";
    public static final String KEY_OPTION_INSTANT_CROWDSOURCING = "com.here.posclient.InitOptions.instantCrowdsourcing";
    public static final String KEY_OPTION_KEEP_COLLECTOR_FILES = "com.here.posclient.InitOptions.keepCollectorFiles";
    public static final String KEY_OPTION_KEEP_HDWIFI_COLLECTOR_FILES = "com.here.posclient.InitOptions.keepHdWifiCollectoFiles";
    public static final String KEY_OPTION_LOG_PATH = "com.here.posclient.InitOptions.logPath";
    public static final String KEY_OPTION_NO_CROWDSOURCING = "com.here.posclient.InitOptions.noCrowdsourcing";
    public static final String KEY_OPTION_NO_OFFLINE_POSITIONING = "com.here.posclient.InitOptions.noOfflinePositioning";
    public static final String KEY_OPTION_OFFLINE_MODE = "com.here.posclient.InitOptions.offlineMode";
    public static final String KEY_OPTION_RADIO_MAP_STORAGE = "com.here.posclient.InitOptions.radioMapStorage";
    public static final String KEY_OPTION_STOPPED = "com.here.posclient.InitOptions.stopped";
    public static final String KEY_OPTION_SUBPROCESSOR_ENDPOINT = "com.here.posclient.InitOptions.subprocessorEndpoint";
    public static final String KEY_OPTION_WITHOUT_CONSENT = "com.here.posclient.InitOptions.withoutConsent";
    private final int mAndroidApiVersion = Build.VERSION.SDK_INT;
    private String mAndroidAppId;
    private AuthData mAuthData;
    private int mBatteryLevel = -1;
    private long mCellularLimit = -1;
    private Context mContext;
    private String mDataDir;
    private long mFeatures = PositioningFeature.All.value;
    private long mFlags = 0;
    private long mHttpAdaptation;
    private String mLogDir;
    private IMeasurementProvider mMeasurementProvider;
    private INetworkManager mNetworkManager;
    private IPosClientObserver mPosClientObserver;
    private String mRadioMapDir;
    private boolean mScreenOn;
    private ISensorManager mSensorManager;
    private boolean mWifiThrottleEnabled;
    private String mWorkingDir;

    public interface Flags {
        public static final int Dont_Start_Engines = 2;
        public static final int Dont_Store_Last_Known_Position = 128;
        public static final int Dont_Use_Network = 4;
        public static final int Keep_Collector_Files = 32;
        public static final int Keep_HD_WiFi_Collector_Files = 64;
        public static final int None = 0;
        public static final int Remove_Persistent_data = 1;
        public static final int Start_Instant_Crowsourcing = 16;
        public static final int Use_Subprocessor_Endpoint = 256;
    }

    public String getAndroidAppId() {
        return this.mAndroidAppId;
    }

    public AuthData getAuthData() {
        return this.mAuthData;
    }

    public int getBatteryLevel() {
        return this.mBatteryLevel;
    }

    public long getCellularLimit() {
        return this.mCellularLimit;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDataDir() {
        return this.mDataDir;
    }

    public long getFeatures() {
        return this.mFeatures;
    }

    public long getFlags() {
        return this.mFlags;
    }

    public long getHttpAdaptation() {
        return this.mHttpAdaptation;
    }

    public String getLogDir() {
        return this.mLogDir;
    }

    public IMeasurementProvider getMeasurementProvider() {
        return this.mMeasurementProvider;
    }

    public INetworkManager getNetworkManager() {
        return this.mNetworkManager;
    }

    public IPosClientObserver getPosClientObserver() {
        return this.mPosClientObserver;
    }

    public String getRadioMapDir() {
        return this.mRadioMapDir;
    }

    public boolean getScreenOnState() {
        return this.mScreenOn;
    }

    public ISensorManager getSensorManager() {
        return this.mSensorManager;
    }

    public boolean getWifiThrottleEnabled() {
        return this.mWifiThrottleEnabled;
    }

    public String getWorkingDir() {
        return this.mWorkingDir;
    }

    public boolean isValid() {
        return (this.mPosClientObserver == null || this.mMeasurementProvider == null || this.mNetworkManager == null || this.mWorkingDir == null) ? false : true;
    }

    public InitOptions setAndroidAppId(String str) {
        this.mAndroidAppId = str;
        return this;
    }

    public InitOptions setAuthData(AuthData authData) {
        this.mAuthData = authData;
        return this;
    }

    public InitOptions setBatteryLevel(int i) {
        this.mBatteryLevel = i;
        return this;
    }

    public InitOptions setCellularLimit(long j) {
        this.mCellularLimit = j;
        return this;
    }

    public InitOptions setContext(Context context) {
        this.mContext = context;
        return this;
    }

    public InitOptions setDataDir(String str) {
        this.mDataDir = str;
        return this;
    }

    public InitOptions setDontStartEngines() {
        this.mFlags |= 2;
        return this;
    }

    public InitOptions setDontStoreLastKnownPosition() {
        this.mFlags |= 128;
        return this;
    }

    public InitOptions setDontUserNetwork() {
        this.mFlags |= 4;
        return this;
    }

    public InitOptions setFeatures(long j) {
        this.mFeatures = j;
        return this;
    }

    public InitOptions setHttpAdaptation(long j) {
        this.mHttpAdaptation = j;
        return this;
    }

    public InitOptions setKeepCollectorFiles() {
        this.mFlags |= 32;
        return this;
    }

    public InitOptions setKeepHdWiFiCollectorFiles() {
        this.mFlags |= 64;
        return this;
    }

    public InitOptions setLogDir(String str) {
        this.mLogDir = str;
        return this;
    }

    public InitOptions setMeasurementProvider(IMeasurementProvider iMeasurementProvider) {
        this.mMeasurementProvider = iMeasurementProvider;
        return this;
    }

    public InitOptions setNetworkManager(INetworkManager iNetworkManager) {
        this.mNetworkManager = iNetworkManager;
        return this;
    }

    public InitOptions setPosClientObserver(IPosClientObserver iPosClientObserver) {
        this.mPosClientObserver = iPosClientObserver;
        return this;
    }

    public InitOptions setRadioMapDir(String str) {
        this.mRadioMapDir = str;
        return this;
    }

    public InitOptions setRemovePersistentData() {
        this.mFlags |= 1;
        return this;
    }

    public InitOptions setScreenOnState(boolean z) {
        this.mScreenOn = z;
        return this;
    }

    public InitOptions setSensorManager(ISensorManager iSensorManager) {
        this.mSensorManager = iSensorManager;
        return this;
    }

    public InitOptions setUseInstantCrowdsourcing() {
        this.mFlags |= 16;
        return this;
    }

    public InitOptions setUseSubprocessorEndpoint() {
        this.mFlags |= 256;
        return this;
    }

    public InitOptions setWifiThrottleEnabled(boolean z) {
        this.mWifiThrottleEnabled = z;
        return this;
    }

    public InitOptions setWorkingDir(String str) {
        this.mWorkingDir = str;
        return this;
    }
}
