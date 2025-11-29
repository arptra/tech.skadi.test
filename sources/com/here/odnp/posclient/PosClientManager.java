package com.here.odnp.posclient;

import android.content.Context;
import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.Location;
import android.os.Bundle;
import android.os.HandlerThread;
import com.here.odnp.adaptations.BatteryManager;
import com.here.odnp.adaptations.IMeasurementResultHandler;
import com.here.odnp.adaptations.MeasurementProvider;
import com.here.odnp.adaptations.NetworkManager;
import com.here.odnp.adaptations.ScreenManager;
import com.here.odnp.cell.ICellManager;
import com.here.odnp.cell.PlatformCellManager;
import com.here.odnp.config.OdnpConfigStatic;
import com.here.odnp.gnss.GnssObservationConverter;
import com.here.odnp.gnss.IGnssManager;
import com.here.odnp.gnss.PlatformGnssManager;
import com.here.odnp.net.IConnectivityManager;
import com.here.odnp.net.PlatformConnectivityManager;
import com.here.odnp.posclient.analytics.IUsageTrackingSession;
import com.here.odnp.posclient.analytics.UsageTrackingSession;
import com.here.odnp.posclient.auth.AuthSession;
import com.here.odnp.posclient.auth.IAuthSession;
import com.here.odnp.posclient.consent.ConsentSession;
import com.here.odnp.posclient.consent.IConsentSession;
import com.here.odnp.posclient.crowdsource.hd.HdCrowdsourceSession;
import com.here.odnp.posclient.hd.IHdCrowdsourceSession;
import com.here.odnp.posclient.pos.IPositioningSession;
import com.here.odnp.posclient.pos.PositioningSession;
import com.here.odnp.posclient.rmm.IRmDownloadSession;
import com.here.odnp.posclient.rmm.RmDownloadSession;
import com.here.odnp.posclient.simulation.ISimulationSession;
import com.here.odnp.posclient.simulation.SimulationSession;
import com.here.odnp.posclient.test.IPosClientTesterSession;
import com.here.odnp.posclient.test.PosClientTesterSession;
import com.here.odnp.posclient.upload.IUploadSession;
import com.here.odnp.posclient.upload.UploadProxy;
import com.here.odnp.posclient.upload.UploadSession;
import com.here.odnp.sensors.InjectionSensorManager;
import com.here.odnp.util.DeviceMonitor;
import com.here.odnp.util.Log;
import com.here.odnp.util.OdnpFileManager;
import com.here.odnp.util.SafeHandler;
import com.here.odnp.util.SyncHandlerTask;
import com.here.odnp.util.TrafficMonitor;
import com.here.odnp.util.WakeLock;
import com.here.odnp.wifi.IWifiManager;
import com.here.odnp.wifi.PlatformWifiManager;
import com.here.odnp.wifi.WifiFilter;
import com.here.posclient.CellMeasurement;
import com.here.posclient.CellularStatus;
import com.here.posclient.ClientConfiguration;
import com.here.posclient.ConsentState;
import com.here.posclient.INetworkManager;
import com.here.posclient.IPosClientObserver;
import com.here.posclient.InitOptions;
import com.here.posclient.MeasurementType;
import com.here.posclient.PosApplicationInfo;
import com.here.posclient.PosClientLib;
import com.here.posclient.PositionEstimate;
import com.here.posclient.PositioningFeature;
import com.here.posclient.RadioMapManager;
import com.here.posclient.Status;
import com.here.posclient.StatusCallback;
import com.here.posclient.UpdateOptions;
import com.here.posclient.WifiMeasurement;
import com.here.posclient.WifiStatus;
import com.here.posclient.analytics.Tracker;
import com.here.posclient.analytics.UsageTrackingListener;
import com.here.posclient.auth.AuthData;
import com.here.posclient.auth.AuthListener;
import com.here.posclient.auth.AuthUtils;
import com.here.posclient.crowdsource.hd.ControlEvent;
import com.here.posclient.crowdsource.hd.IActivityEventDispatcher;
import com.here.posclient.ext.Auth;
import com.here.posclient.ext.Consent;
import com.here.posclient.ext.HdWifiControl;
import com.here.posclient.ext.PositioningControl;
import com.here.posclient.ext.RndExtension;
import com.here.posclient.ext.TestTrackSimulation;
import com.here.posclient.ext.Upload;
import com.here.posclient.ext.UsageTracking;
import com.here.posclient.sensors.ActivityResult;
import com.here.posclient.sensors.GeneralActivityResult;
import com.here.posclient.sensors.ISensorManager;
import com.here.posclient.upload.UploadListener;
import com.here.posclient.upload.UploadOptions;
import com.here.services.common.PositioningError;
import com.here.services.common.Types;
import com.here.services.radiomap.common.GeoArea;
import com.here.services.util.HereServicesUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class PosClientManager implements IPosClientObserver, IPosClientManager, BatteryManager.IListener, DeviceMonitor.Listener, IMeasurementResultHandler, IConnectivityManager.IConnectivityListener, ISensorManager.Listener, ScreenManager.IListener {
    private static final int DEFAULT_CLEAR_DATA_FLAGS = 6153;
    private static final String METADATA_TEST_LIBRARY = "com.here.sdk.use_testing_library";
    private static final String TAG = "odnp.posclient.PosClientManager";
    /* access modifiers changed from: private */
    public String mAndroidAppId;
    /* access modifiers changed from: private */
    public AuthData mAuthData;
    private final Set<AuthSession> mAuths = new HashSet();
    /* access modifiers changed from: private */
    public final BatteryManager mBatteryManager;
    /* access modifiers changed from: private */
    public Long mCellularLimit;
    /* access modifiers changed from: private */
    public boolean mCleanBeforeStart;
    /* access modifiers changed from: private */
    public ClientConfiguration mClientConfiguration;
    private final Set<ConsentSession> mConsents = new HashSet();
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public String mDataDir;
    private final DeviceMonitor mDeviceMonitor;
    /* access modifiers changed from: private */
    public boolean mDontStartEngines;
    /* access modifiers changed from: private */
    public boolean mEnableDirectBootMode;
    /* access modifiers changed from: private */
    public boolean mEnableInstantCrowdsourcing;
    /* access modifiers changed from: private */
    public boolean mEnableSubprocessorEndpoint;
    /* access modifiers changed from: private */
    public final AtomicBoolean mEnginesStopped = new AtomicBoolean();
    /* access modifiers changed from: private */
    public Long mFeatures;
    /* access modifiers changed from: private */
    public final SafeHandler mHandler;
    /* access modifiers changed from: private */
    public final HandlerThread mHandlerThread;
    private final Set<HdCrowdsourceSession> mHdCrowdsourceSessions = new HashSet();
    /* access modifiers changed from: private */
    public long mHttpAdaptationPointer;
    /* access modifiers changed from: private */
    public boolean mIsBlacklistedMcc;
    /* access modifiers changed from: private */
    public boolean mKeepCollectorFiles;
    /* access modifiers changed from: private */
    public boolean mKeepHdWifiCollectorFiles;
    private final Object mLogCapture;
    /* access modifiers changed from: private */
    public String mLogDir;
    /* access modifiers changed from: private */
    public final MeasurementProvider mMeasurementProvider;
    /* access modifiers changed from: private */
    public final NetworkManager mNetworkManager;
    /* access modifiers changed from: private */
    public boolean mOfflineMode;
    /* access modifiers changed from: private */
    public final AtomicBoolean mPosClientInitialized = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final Set<PositioningSession> mPositioners = new HashSet();
    /* access modifiers changed from: private */
    public String mRadioMapDir;
    /* access modifiers changed from: private */
    public String mRadioMapDirType;
    private final AtomicInteger mRequestId = new AtomicInteger();
    /* access modifiers changed from: private */
    public final Set<RmDownloadSession> mRmDownloaders = new HashSet();
    /* access modifiers changed from: private */
    public final ScreenManager mScreenManager;
    /* access modifiers changed from: private */
    public final InjectionSensorManager mSensorManager;
    private final Set<SimulationSession> mSimulators = new HashSet();
    /* access modifiers changed from: private */
    public final Set<PosClientTesterSession> mTesters = new HashSet();
    private TrafficMonitor mTrafficMonitor;
    /* access modifiers changed from: private */
    public UpdateOptions mUpdateOptions = new UpdateOptions().setDisabledPowerOptions();
    /* access modifiers changed from: private */
    public final UploadProxy mUploadProxy;
    private final Set<UploadSession> mUploadSessions = new HashSet();
    private final Set<UsageTrackingSession> mUsageTrackers = new HashSet();
    private final IWakeLock mWakeLock;
    /* access modifiers changed from: private */
    public final PlatformWifiManager.WifiThrottleStatusObserver mWifiThrottleObserver = new PlatformWifiManager.WifiThrottleStatusObserver() {
        public void onThrottleStatusChanged(final boolean z) {
            if (PosClientManager.this.isPosclientInitialized()) {
                PosClientManager.this.mHandler.post(new Runnable() {
                    public void run() {
                        PositioningControl.setWifiThrottleEnabled(z);
                    }
                });
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean mWithoutConsent;
    /* access modifiers changed from: private */
    public String mWorkingDir;

    public interface IWakeLock {
        void acquire();

        void release();
    }

    private PosClientManager(Context context, Bundle bundle) {
        HandlerThread handlerThread = new HandlerThread("PosClientManager.Handler");
        this.mHandlerThread = handlerThread;
        Log.v(TAG, "PosClientManager: version: %s", OdnpConfigStatic.SW_VERSION);
        loadNativeLibraries(context);
        this.mLogCapture = null;
        this.mContext = context;
        this.mWakeLock = createWakeLock(context);
        this.mMeasurementProvider = new MeasurementProvider(this);
        this.mNetworkManager = new NetworkManager(this);
        this.mSensorManager = new InjectionSensorManager(this);
        this.mBatteryManager = new BatteryManager(context, this);
        this.mUploadProxy = new UploadProxy(context, this);
        this.mScreenManager = new ScreenManager(context, this);
        fetchArguments(context, bundle);
        handlerThread.start();
        this.mHandler = new SafeHandler(handlerThread.getLooper());
        DeviceMonitor.Builder builder = new DeviceMonitor.Builder(context, this);
        builder.setMonitorCountryCode(true, OdnpConfigStatic.MCC_BLACKLIST);
        DeviceMonitor build = builder.build();
        this.mDeviceMonitor = build;
        build.startMonitoring();
    }

    private static boolean appendExternalFilesDir(Context context, StringBuilder sb) {
        File externalFilesDir;
        if (!HereServicesUtil.hasExternalWritableStorage() || (externalFilesDir = context.getExternalFilesDir((String) null)) == null) {
            return false;
        }
        sb.append(externalFilesDir.getAbsolutePath());
        return true;
    }

    private void cancelLocationRequest() {
        Log.v(TAG, "cancelLocationRequest: ignored", new Object[0]);
    }

    private static boolean checkPermission(Context context, String str) {
        boolean z = context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        Log.v(TAG, String.format("checkPermissions: %s: %b", new Object[]{str, Boolean.valueOf(z)}), new Object[0]);
        return z;
    }

    /* access modifiers changed from: private */
    public Location convertToAndroidLocation(PositionEstimate positionEstimate) {
        Location androidLocation = PositionEstimate.toAndroidLocation(positionEstimate);
        if (androidLocation == null) {
            Log.w(TAG, "convertToAndroidLocation: location is null -> rejected", new Object[0]);
            return null;
        }
        Log.d(TAG, "", new Object[0]);
        Log.d(TAG, "", new Object[0]);
        Log.d(TAG, "", new Object[0]);
        return androidLocation;
    }

    private static IWakeLock createWakeLock(Context context) {
        if (checkPermission(context, "android.permission.WAKE_LOCK")) {
            return new IWakeLock(context) {
                final WakeLock mWakeLock;
                final /* synthetic */ Context val$context;

                {
                    this.val$context = r2;
                    this.mWakeLock = new WakeLock(r2);
                }

                public void acquire() {
                    this.mWakeLock.acquire();
                }

                public void release() {
                    this.mWakeLock.release();
                }
            };
        }
        Log.w(TAG, "No WAKE_LOCK permission, wake locks disabled.", new Object[0]);
        return new IWakeLock() {
            public void acquire() {
            }

            public void release() {
            }
        };
    }

    private void fetchArguments(Context context, Bundle bundle) {
        if (bundle != null) {
            this.mRadioMapDirType = bundle.getString(InitOptions.KEY_OPTION_RADIO_MAP_STORAGE);
            this.mOfflineMode = bundle.getBoolean(InitOptions.KEY_OPTION_OFFLINE_MODE, false);
            this.mFeatures = Long.valueOf(bundle.containsKey(InitOptions.KEY_OPTION_FEATURES) ? bundle.getLong(InitOptions.KEY_OPTION_FEATURES) : PositioningFeature.All.value);
            this.mLogDir = bundle.getString(InitOptions.KEY_OPTION_LOG_PATH);
            this.mCellularLimit = bundle.containsKey(InitOptions.KEY_OPTION_CELLULAR_LIMIT) ? Long.valueOf(bundle.getLong(InitOptions.KEY_OPTION_CELLULAR_LIMIT)) : null;
            this.mAndroidAppId = PosApplicationInfo.getPackageName(context);
            this.mDontStartEngines = bundle.getBoolean(InitOptions.KEY_OPTION_STOPPED, false);
            this.mWithoutConsent = bundle.getBoolean(InitOptions.KEY_OPTION_WITHOUT_CONSENT, false);
            this.mCleanBeforeStart = bundle.getBoolean(InitOptions.KEY_OPTION_CLEAN, false);
            this.mEnableInstantCrowdsourcing = bundle.getBoolean(InitOptions.KEY_OPTION_INSTANT_CROWDSOURCING, false);
            if (bundle.getBoolean(InitOptions.KEY_OPTION_NO_OFFLINE_POSITIONING, false)) {
                long longValue = this.mFeatures.longValue() & (~PositioningFeature.RadioMapDownload.value);
                this.mFeatures = Long.valueOf(longValue);
                this.mFeatures = Long.valueOf(longValue & (~PositioningFeature.Offline.value));
            }
            this.mKeepCollectorFiles = bundle.getBoolean(InitOptions.KEY_OPTION_KEEP_COLLECTOR_FILES, false);
            this.mKeepHdWifiCollectorFiles = bundle.getBoolean(InitOptions.KEY_OPTION_KEEP_HDWIFI_COLLECTOR_FILES, false);
            this.mEnableDirectBootMode = bundle.getBoolean(InitOptions.KEY_OPTION_DIRECT_BOOT, false);
            this.mEnableSubprocessorEndpoint = bundle.getBoolean(InitOptions.KEY_OPTION_SUBPROCESSOR_ENDPOINT, true);
            this.mHttpAdaptationPointer = bundle.getLong(InitOptions.KEY_OPTION_HTTP_ADAPTATION_PTR, 0);
            this.mAuthData = AuthUtils.authDataFromBundle(bundle);
        }
    }

    private static String getPosLibraryName(Context context) {
        return "";
    }

    /* access modifiers changed from: private */
    public static String getRadioMapStorageDir(Context context, String str) {
        return storageTypeToDirectoryName(context, str);
    }

    private boolean initialize() {
        Log.v(TAG, "initialize: begin", new Object[0]);
        this.mRequestId.set(0);
        AnonymousClass22 r1 = new SyncHandlerTask<Boolean>() {
            public void onError(Error error) {
                setResult(Boolean.FALSE);
            }

            public void onException(Exception exc) {
                setResult(Boolean.FALSE);
            }

            public Boolean onRun() {
                Log.v(PosClientManager.TAG, "initialize: onRun", new Object[0]);
                if (PosClientManager.this.mWorkingDir == null) {
                    PosClientManager posClientManager = PosClientManager.this;
                    String unused = posClientManager.mWorkingDir = OdnpFileManager.getPrivateDir(posClientManager.mContext).getAbsolutePath();
                    Log.v(PosClientManager.TAG, "Using private directory: '%s'", PosClientManager.this.mWorkingDir);
                }
                if (PosClientManager.this.mDataDir == null) {
                    PosClientManager posClientManager2 = PosClientManager.this;
                    String unused2 = posClientManager2.mDataDir = OdnpFileManager.getDataDir(posClientManager2.mContext).getAbsolutePath();
                    Log.v(PosClientManager.TAG, "Using data directory: '%s'", PosClientManager.this.mDataDir);
                }
                if (PosClientManager.this.mRadioMapDir == null) {
                    PosClientManager posClientManager3 = PosClientManager.this;
                    String unused3 = posClientManager3.mRadioMapDir = PosClientManager.getRadioMapStorageDir(posClientManager3.mContext, PosClientManager.this.mRadioMapDirType);
                    Log.v(PosClientManager.TAG, "Using rm dir: '%s'", PosClientManager.this.mRadioMapDir);
                }
                if (PosClientManager.this.mLogDir == null) {
                    PosClientManager posClientManager4 = PosClientManager.this;
                    String unused4 = posClientManager4.mLogDir = OdnpFileManager.getLogDir(posClientManager4.mContext).getAbsolutePath();
                    Log.v(PosClientManager.TAG, "Using log dir: '%s'", PosClientManager.this.mLogDir);
                }
                PosClientManager.this.mUploadProxy.open();
                PosClientManager.this.mMeasurementProvider.setWifiFilter(WifiFilter.create()).setWifiManager(new PlatformWifiManager(PosClientManager.this.mContext, PosClientManager.this.mHandler, PosClientManager.this.mWifiThrottleObserver)).setGnssManager(new PlatformGnssManager(PosClientManager.this.mContext, PosClientManager.this.mHandler)).setCellManager(PlatformCellManager.create(PosClientManager.this.mContext));
                PosClientManager.this.mNetworkManager.setConnectivityManager(new PlatformConnectivityManager(PosClientManager.this.mContext)).open();
                PosClientManager.this.mSensorManager.open();
                PosClientManager.this.mBatteryManager.start();
                PosClientManager.this.mScreenManager.start();
                InitOptions wifiThrottleEnabled = new InitOptions().setPosClientObserver(PosClientManager.this).setMeasurementProvider(PosClientManager.this.mMeasurementProvider).setNetworkManager(PosClientManager.this.mNetworkManager).setSensorManager(PosClientManager.this.mSensorManager).setWorkingDir(PosClientManager.this.mWorkingDir).setDataDir(PosClientManager.this.mDataDir).setRadioMapDir(PosClientManager.this.mRadioMapDir).setLogDir(PosClientManager.this.mLogDir).setAndroidAppId(PosClientManager.this.mAndroidAppId).setContext(PosClientManager.this.mContext).setAuthData(PosClientManager.this.mAuthData).setBatteryLevel(PosClientManager.this.mBatteryManager.getLevel()).setScreenOnState(PosClientManager.this.mScreenManager.getScreenOnState()).setWifiThrottleEnabled(PosClientManager.this.mMeasurementProvider.getWifiManager().isWifiThrottled());
                if (PosClientManager.this.mFeatures != null) {
                    wifiThrottleEnabled.setFeatures(PosClientManager.this.mFeatures.longValue());
                }
                if (PosClientManager.this.mIsBlacklistedMcc) {
                    Log.v(PosClientManager.TAG, "blacklisted MCC detected -> all features disabled", new Object[0]);
                    wifiThrottleEnabled.setFeatures(PositioningFeature.None.value);
                }
                if (PosClientManager.this.mEnableInstantCrowdsourcing) {
                    Log.v(PosClientManager.TAG, "Enabling instant crowdsourcing", new Object[0]);
                    wifiThrottleEnabled.setUseInstantCrowdsourcing();
                }
                if (PosClientManager.this.mKeepCollectorFiles) {
                    Log.v(PosClientManager.TAG, "Enabling keep collector files", new Object[0]);
                    wifiThrottleEnabled.setKeepCollectorFiles();
                }
                if (PosClientManager.this.mKeepHdWifiCollectorFiles) {
                    Log.v(PosClientManager.TAG, "Enabling keep HD collector files", new Object[0]);
                    wifiThrottleEnabled.setKeepHdWiFiCollectorFiles();
                }
                if (PosClientManager.this.mEnableDirectBootMode) {
                    wifiThrottleEnabled.setFeatures(wifiThrottleEnabled.getFeatures() & (~PositioningFeature.Cache.value));
                    wifiThrottleEnabled.setFeatures(wifiThrottleEnabled.getFeatures() & (~PositioningFeature.ActiveStorage.value));
                    wifiThrottleEnabled.setDontStoreLastKnownPosition();
                    Log.w(PosClientManager.TAG, "PosClientLib.init: direct boot enabled", new Object[0]);
                }
                if (PosClientManager.this.mOfflineMode) {
                    Log.v(PosClientManager.TAG, "Enabling offline mode", new Object[0]);
                    wifiThrottleEnabled.setDontUserNetwork();
                }
                if (PosClientManager.this.mEnableSubprocessorEndpoint) {
                    Log.v(PosClientManager.TAG, "Enabling subprocessor end-point support", new Object[0]);
                    wifiThrottleEnabled.setUseSubprocessorEndpoint();
                }
                if (PosClientManager.this.mHttpAdaptationPointer != 0) {
                    Log.v(PosClientManager.TAG, "Setting C++ HTTP adaptation raw pointer", new Object[0]);
                    wifiThrottleEnabled.setHttpAdaptation(PosClientManager.this.mHttpAdaptationPointer);
                }
                if (PosClientManager.this.mCellularLimit != null) {
                    Log.v(PosClientManager.TAG, "Setting cellular limit: %d", PosClientManager.this.mCellularLimit);
                    wifiThrottleEnabled.setCellularLimit(PosClientManager.this.mCellularLimit.longValue());
                }
                if (PosClientManager.this.mDontStartEngines || PosClientManager.this.mWithoutConsent) {
                    PosClientManager.this.mEnginesStopped.set(true);
                    wifiThrottleEnabled.setDontStartEngines();
                }
                if (PosClientManager.this.mCleanBeforeStart) {
                    Log.v(PosClientManager.TAG, "Removing persistent data before start", new Object[0]);
                    wifiThrottleEnabled.setRemovePersistentData();
                }
                PosClientManager.this.mPosClientInitialized.set(true);
                PosClientManager.this.mPosClientInitialized.set(PosClientLib.init(wifiThrottleEnabled));
                if (!PosClientManager.this.mPosClientInitialized.get()) {
                    Log.w(PosClientManager.TAG, "PosClientLib.init failed -> closing adaptations.", new Object[0]);
                    PosClientManager.this.mScreenManager.stop();
                    PosClientManager.this.mBatteryManager.stop();
                    PosClientManager.this.mMeasurementProvider.close();
                    PosClientManager.this.mNetworkManager.close();
                    PosClientManager.this.mSensorManager.close();
                } else {
                    Log.v(PosClientManager.TAG, "PosClientLib.init succeeded.", new Object[0]);
                    ClientConfiguration unused5 = PosClientManager.this.mClientConfiguration = PosClientLib.getClientConfiguration();
                    if (PosClientManager.this.mClientConfiguration == null) {
                        Log.e(PosClientManager.TAG, "Could not fetch client configuration", new Object[0]);
                    } else {
                        Log.i(PosClientManager.TAG, "Active configuration: %s", PosClientManager.this.mClientConfiguration);
                    }
                    if (Status.fromInt(Upload.subscribe(PosClientManager.this.mUploadProxy)) != Status.Ok) {
                        Log.e(PosClientManager.TAG, "Could not register upload listener", new Object[0]);
                    }
                }
                return Boolean.valueOf(PosClientManager.this.mPosClientInitialized.get());
            }
        };
        if (this.mHandler.post(r1)) {
            this.mPosClientInitialized.set(((Boolean) r1.getResult()).booleanValue());
        } else {
            Log.e(TAG, "initialize: Handler.post failed -> false", new Object[0]);
            this.mPosClientInitialized.set(false);
        }
        Log.v(TAG, "initialize: end, result: %s", this.mPosClientInitialized);
        return isPosclientInitialized();
    }

    /* access modifiers changed from: private */
    public boolean isPosclientInitialized() {
        return this.mPosClientInitialized.get();
    }

    private static void loadNativeLibraries(Context context) {
        String posLibraryName = getPosLibraryName(context);
        if (!posLibraryName.isEmpty()) {
            Log.v(TAG, "loadNativeLibraries: Loading %s", posLibraryName);
            System.loadLibrary(posLibraryName);
        }
    }

    private int onUpdateOptions(final UpdateOptions updateOptions, final IPositioningSession.StatusListener statusListener) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onUpdateOptions: posclient not initialized -> ignored", new Object[0]);
            return Integer.MIN_VALUE;
        }
        Log.v(TAG, "onUpdateOptions", new Object[0]);
        final int incrementAndGet = this.mRequestId.incrementAndGet();
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                Status fromInt = Status.fromInt(PosClientLib.setUpdateOptions(updateOptions));
                if (Status.Ok != fromInt) {
                    Log.w(PosClientManager.TAG, "onUpdateOptions: error: %s", fromInt);
                }
                IPositioningSession.StatusListener statusListener = statusListener;
                if (statusListener != null) {
                    statusListener.onRequestCompleted(incrementAndGet, fromInt);
                }
            }
        })) {
            return Integer.MIN_VALUE;
        }
        return incrementAndGet;
    }

    public static IPosClientManager open(Context context, Bundle bundle) {
        PosClientManager posClientManager = new PosClientManager(context, bundle);
        if (posClientManager.initialize()) {
            return posClientManager;
        }
        posClientManager.close();
        return null;
    }

    private void pushScreenState(final boolean z) {
        if (isPosclientInitialized()) {
            Log.v(TAG, "pushScreenState: %s", Boolean.valueOf(z));
            if (!this.mHandler.post(new Runnable() {
                public void run() {
                    PosClientLib.setScreenState(z);
                }
            })) {
                Log.e(TAG, "pushScreenState: error posting task", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setAllPositioningFeatures(Long l, boolean z) {
        for (PositioningFeature positioningFeature : PositioningFeature.values()) {
            if (!(positioningFeature == PositioningFeature.None || positioningFeature == PositioningFeature.All || !PositioningFeature.isFeatureSet(l.longValue(), positioningFeature))) {
                PositioningControl.toggleFeature(positioningFeature.value, z);
            }
        }
    }

    private void shutdown() {
        Log.v(TAG, "shutdown", new Object[0]);
        AnonymousClass71 r1 = new Runnable() {
            public void run() {
                synchronized (PosClientManager.this) {
                    try {
                        Log.i(PosClientManager.TAG, "shutdown: begin", new Object[0]);
                        Iterator it = new ArrayList(PosClientManager.this.mTesters).iterator();
                        while (it.hasNext()) {
                            ((PosClientTesterSession) it.next()).close();
                        }
                        Iterator it2 = new ArrayList(PosClientManager.this.mRmDownloaders).iterator();
                        while (it2.hasNext()) {
                            ((RmDownloadSession) it2.next()).close();
                        }
                        Iterator it3 = new ArrayList(PosClientManager.this.mPositioners).iterator();
                        while (it3.hasNext()) {
                            ((PositioningSession) it3.next()).close();
                        }
                        Log.i(PosClientManager.TAG, "shutdown: end", new Object[0]);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        this.mHandler.removeCallbacks();
        if (!this.mHandler.post(r1)) {
            Log.e(TAG, "shutdown: error posting task", new Object[0]);
        }
    }

    private void startEngines() {
        Log.v(TAG, "startEngines", new Object[0]);
        if (this.mEnginesStopped.get()) {
            onHandleGlobalLocationSettingChanged(true);
        }
    }

    private static String storageTypeToDirectoryName(Context context, String str) {
        Types.Storage storage = Types.Storage.Internal;
        try {
            storage = Types.Storage.valueOf(str);
        } catch (Exception unused) {
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (storage == Types.Storage.External) {
                appendExternalFilesDir(context, sb);
            } else if (storage == Types.Storage.SecondaryExternal) {
                Log.v(TAG, "storageTypeToDirectoryName: using radio map directory fallback RemovableExternal => External.", new Object[0]);
                appendExternalFilesDir(context, sb);
            }
        } catch (Exception unused2) {
        }
        if (sb.length() == 0) {
            sb.append(OdnpFileManager.getPrivateDir(context).getAbsolutePath());
        }
        sb.append(File.separator);
        sb.append(OdnpConfigStatic.RADIO_MAP_DOWNLOAD_ROOT);
        return sb.toString();
    }

    private void uninitialize() {
        Log.v(TAG, "uninitialize: begin", new Object[0]);
        try {
            AnonymousClass23 r1 = new SyncHandlerTask<Void>() {
                public Void onRun() {
                    Log.v(PosClientManager.TAG, "uninitialize: onRun", new Object[0]);
                    if (!PosClientManager.this.mPosClientInitialized.get()) {
                        return null;
                    }
                    PosClientLib.uninit();
                    PosClientManager.this.mNetworkManager.close();
                    PosClientManager.this.mMeasurementProvider.close();
                    PosClientManager.this.mBatteryManager.stop();
                    PosClientManager.this.mSensorManager.close();
                    PosClientManager.this.mScreenManager.stop();
                    Upload.unsubscribe();
                    return null;
                }
            };
            this.mHandler.removeCallbacksAndMessages((Object) null);
            if (this.mHandler.post(r1)) {
                r1.getResult();
            } else {
                Log.e(TAG, "uninitialize: Handler.post failed", new Object[0]);
                this.mNetworkManager.close();
                this.mMeasurementProvider.close();
                this.mBatteryManager.stop();
                this.mScreenManager.stop();
                this.mSensorManager.close();
                Upload.unsubscribe();
            }
            this.mUploadProxy.close();
            this.mDeviceMonitor.stopMonitoring();
            this.mWakeLock.release();
            this.mHandler.post(new Runnable() {
                public void run() {
                    PosClientManager.this.mHandlerThread.quit();
                }
            });
            this.mPosClientInitialized.set(false);
            Log.v(TAG, "uninitialize: end", new Object[0]);
        } catch (Throwable th) {
            this.mDeviceMonitor.stopMonitoring();
            this.mWakeLock.release();
            this.mHandler.post(new Runnable() {
                public void run() {
                    PosClientManager.this.mHandlerThread.quit();
                }
            });
            this.mPosClientInitialized.set(false);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public boolean validatePositionEstimate(PositionEstimate positionEstimate, UpdateOptions updateOptions) {
        if (positionEstimate == null) {
            Log.w(TAG, "validatePositionEstimate: estimate is null -> ignored", new Object[0]);
            return false;
        }
        long j = positionEstimate.source;
        if ((updateOptions.allowedSources & j) == 0) {
            Log.v(TAG, "validatePositionEstimate: estimate source not allowed (%d&%d = %d) -> ignored", Long.valueOf(j), Long.valueOf(updateOptions.allowedSources), Long.valueOf(updateOptions.allowedSources & positionEstimate.source));
            return false;
        } else if (HereServicesUtil.isNetworkLocationEnabled(this.mContext) || HereServicesUtil.isGpsLocationEnabled(this.mContext)) {
            return true;
        } else {
            Log.v(TAG, "validatePositionEstimate: Location providers disabled -> ignored", new Object[0]);
            return false;
        }
    }

    public synchronized void addAuthSession(AuthSession authSession) {
        Log.v(TAG, "addAuthSession: " + authSession, new Object[0]);
        this.mAuths.add(authSession);
        startEngines();
    }

    public synchronized void addConsentSession(ConsentSession consentSession) {
        Log.v(TAG, "addConsentSession: " + consentSession, new Object[0]);
        this.mConsents.add(consentSession);
        startEngines();
    }

    public synchronized void addHdCrowdsourceSession(HdCrowdsourceSession hdCrowdsourceSession) {
        Log.v(TAG, "addHdCrowdsourceSession: %s", hdCrowdsourceSession);
        this.mHdCrowdsourceSessions.add(hdCrowdsourceSession);
        startEngines();
    }

    public synchronized void addPositioner(PositioningSession positioningSession) {
        Log.v(TAG, "addPositioner: %s", positioningSession);
        this.mPositioners.add(positioningSession);
        startEngines();
    }

    public synchronized void addRmDownloader(RmDownloadSession rmDownloadSession) {
        Log.v(TAG, "addRmDownloader: %s", rmDownloadSession);
        this.mRmDownloaders.add(rmDownloadSession);
        startEngines();
    }

    public synchronized void addSimulationSession(SimulationSession simulationSession) {
        Log.v(TAG, "addSimulationSession: %s", simulationSession);
        this.mSimulators.add(simulationSession);
        startEngines();
    }

    public synchronized void addTesterSession(PosClientTesterSession posClientTesterSession) {
        Log.v(TAG, "addTesterSession: %s", posClientTesterSession);
        this.mTesters.add(posClientTesterSession);
        startEngines();
    }

    public synchronized void addUploadSession(UploadSession uploadSession) {
        Log.v(TAG, "addUploadSession: %s", uploadSession);
        this.mUploadSessions.add(uploadSession);
        startEngines();
    }

    public synchronized void addUsageTrackingSession(UsageTrackingSession usageTrackingSession) {
        Log.v(TAG, "addUsageTrackingSession: " + usageTrackingSession, new Object[0]);
        this.mUsageTrackers.add(usageTrackingSession);
        startEngines();
    }

    public int availableFeatures() {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "availableFeatures: posclient not initialized -> ignored", new Object[0]);
            return 0;
        }
        AnonymousClass67 r0 = new SyncHandlerTask<Long>() {
            public void onException(Exception exc) {
                setResult(0L);
            }

            public Long onRun() {
                return Long.valueOf(PositioningControl.availableFeatures());
            }
        };
        if (this.mHandler.post(r0)) {
            return ((Long) r0.getResult()).intValue();
        }
        Log.w(TAG, "availableFeatures: Handler.post failed", new Object[0]);
        return 0;
    }

    public void clearData(final int i) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "clearData: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                PosClientLib.clearData(i);
            }
        })) {
            Log.w(TAG, "clearData: Handler.post failed", new Object[0]);
        }
    }

    public void close() {
        uninitialize();
    }

    public boolean continueSimulation(final Object[] objArr, final StatusCallback statusCallback) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "continueSimulation: posclient not initialized -> ignored", new Object[0]);
            return false;
        } else if (objArr == null || objArr.length < 1) {
            Log.w(TAG, "continueSimulation: no measurements -> ignored", new Object[0]);
            return false;
        } else {
            Log.v(TAG, "continueSimulation: %d measurements", Integer.valueOf(objArr.length));
            return this.mHandler.post(new Runnable() {
                public void run() {
                    statusCallback.onStatus(Status.fromInt(TestTrackSimulation.continueSimulation(objArr)));
                }
            });
        }
    }

    public IAuthSession createAuthSession() {
        return new AuthSession(this) {
            public Status setAuthData(final AuthData authData) {
                if (!PosClientManager.this.mPosClientInitialized.get()) {
                    Log.w(PosClientManager.TAG, "setAuthData: posclient not initialized -> ignored", new Object[0]);
                    return Status.GeneralError;
                }
                return !PosClientManager.this.mHandler.post(new Runnable() {
                    public void run() {
                        Log.i(PosClientManager.TAG, "setAuthData: onRun", new Object[0]);
                        Auth.setAuthData(authData);
                    }
                }) ? Status.InternalError : Status.Ok;
            }

            public Status subscribe(final AuthListener authListener) {
                if (!PosClientManager.this.mPosClientInitialized.get()) {
                    Log.w(PosClientManager.TAG, "subscribe: posclient not initialized -> ignored", new Object[0]);
                    return Status.GeneralError;
                }
                AnonymousClass2 r0 = new SyncHandlerTask<Status>() {
                    public void onException(Exception exc) {
                        Log.e(PosClientManager.TAG, "subscribe: onException", new Object[0]);
                        setResult(Status.InternalError);
                    }

                    public Status onRun() {
                        Log.i(PosClientManager.TAG, "subscribe: onRun", new Object[0]);
                        return Status.fromInt(Auth.subscribe(authListener));
                    }
                };
                return PosClientManager.this.mHandler.post(r0) ? (Status) r0.getResult() : Status.InternalError;
            }

            public Status unsubscribe() {
                if (!PosClientManager.this.mPosClientInitialized.get()) {
                    Log.w(PosClientManager.TAG, "unsubscribe: posclient not initialized -> ignored", new Object[0]);
                    return Status.GeneralError;
                }
                return PosClientManager.this.mHandler.post(new Runnable() {
                    public void run() {
                        Auth.unsubscribe();
                    }
                }) ? Status.Ok : Status.InternalError;
            }
        };
    }

    public IConsentSession createConsentSession() {
        return new ConsentSession(this) {
            public void onConsentUpdated(ConsentState consentState) {
                if (!PosClientManager.this.mPosClientInitialized.get()) {
                    Log.w(PosClientManager.TAG, "IConsentSession.onConsentUpdated: posclient not initialized -> ignored", new Object[0]);
                }
                Log.v(PosClientManager.TAG, "IConsentSession.onConsentUpdated: %s", consentState.name());
                Consent.onConsentUpdated(consentState.stateCode);
            }
        };
    }

    public IHdCrowdsourceSession createHdCrowdsourceSession() {
        return new HdCrowdsourceSession(this) {
            public boolean sendEvent(ControlEvent controlEvent) {
                if (!PosClientManager.this.mPosClientInitialized.get()) {
                    Log.w(PosClientManager.TAG, "IHdCrowdsourceSession.sendEvent: posclient not initialized -> ignored", new Object[0]);
                    return false;
                }
                Log.v(PosClientManager.TAG, "IHdCrowdsourceSession.sendEvent: %s (%d)", controlEvent.name(), Integer.valueOf(controlEvent.code));
                return Status.fromInt(HdWifiControl.sendEvent(controlEvent.code)) == Status.Ok;
            }

            public boolean setWifiIntervals(int i, int i2) {
                if (!PosClientManager.this.mPosClientInitialized.get()) {
                    Log.w(PosClientManager.TAG, "IHdCrowdsourceSession.setWifiIntervals: posclient not initialized -> ignored", new Object[0]);
                    return false;
                }
                Log.v(PosClientManager.TAG, "IHdCrowdsourceSession.setWifiIntervals: normal: %ds, gnssShadow: %ds", Integer.valueOf(i), Integer.valueOf(i2));
                return Status.fromInt(HdWifiControl.setWifiIntervals(i, i2)) == Status.Ok;
            }

            public boolean startActivityEventListening(IActivityEventDispatcher iActivityEventDispatcher) {
                if (!PosClientManager.this.mPosClientInitialized.get()) {
                    Log.w(PosClientManager.TAG, "IHdCrowdsourceSession.startActivityEventListening: posclient not initialized -> ignored", new Object[0]);
                    return false;
                }
                Log.v(PosClientManager.TAG, "IHdCrowdsourceSession.startActivityEventListening", new Object[0]);
                return Status.fromInt(HdWifiControl.startActivityEventListening(iActivityEventDispatcher)) == Status.Ok;
            }

            public void stopActivityEventListening(IActivityEventDispatcher iActivityEventDispatcher) {
                if (!PosClientManager.this.mPosClientInitialized.get()) {
                    Log.w(PosClientManager.TAG, "IHdCrowdsourceSession.stopActivityEventListening: posclient not initialized -> ignored", new Object[0]);
                    return;
                }
                Log.v(PosClientManager.TAG, "IHdCrowdsourceSession.stopActivityEventListening", new Object[0]);
                HdWifiControl.stopActivityEventListening(iActivityEventDispatcher);
            }
        };
    }

    public IPositioningSession createPositionerSession(IPositioningSession.ILocationListener iLocationListener) {
        return new PositioningSession(this, iLocationListener);
    }

    public IRmDownloadSession createRmDownloaderSession(RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener) {
        return new RmDownloadSession(this, iRadioMapStorageActionListener);
    }

    public ISimulationSession createSimulationSession() {
        return new SimulationSession(this);
    }

    public IPosClientTesterSession createTesterSession() {
        return new PosClientTesterSession(this);
    }

    public IUploadSession createUploadSession() {
        return new UploadSession(this) {
            public void cancelUpload() {
                if (!PosClientManager.this.mPosClientInitialized.get()) {
                    Log.w(PosClientManager.TAG, "cancelUpload: posclient not initialized -> ignored", new Object[0]);
                }
                PosClientManager.this.mHandler.post(new Runnable() {
                    public void run() {
                        Upload.cancelUpload();
                    }
                });
            }

            public Status subscribe(UploadListener uploadListener) {
                PosClientManager.this.mUploadProxy.subscribe(uploadListener);
                return Status.Ok;
            }

            public Status unsubscribe(UploadListener uploadListener) {
                PosClientManager.this.mUploadProxy.unsubscribe(uploadListener);
                return Status.Ok;
            }

            public Status upload(final UploadOptions uploadOptions) {
                if (!PosClientManager.this.mPosClientInitialized.get()) {
                    Log.w(PosClientManager.TAG, "upload: posclient not initialized -> ignored", new Object[0]);
                    return Status.GeneralError;
                }
                AnonymousClass1 r0 = new SyncHandlerTask<Status>() {
                    public void onException(Exception exc) {
                        Log.e(PosClientManager.TAG, "upload: onException", new Object[0]);
                        setResult(Status.InternalError);
                    }

                    public Status onRun() {
                        Log.i(PosClientManager.TAG, "upload: onRun", new Object[0]);
                        return Status.fromInt(Upload.upload(uploadOptions));
                    }
                };
                return PosClientManager.this.mHandler.post(r0) ? (Status) r0.getResult() : Status.InternalError;
            }
        };
    }

    public IUsageTrackingSession createUsageTrackingSession() {
        return new UsageTrackingSession(this) {
            public EnumSet<Tracker> getSupportedTrackers() {
                Class<Tracker> cls = Tracker.class;
                if (!PosClientManager.this.mPosClientInitialized.get()) {
                    Log.w(PosClientManager.TAG, "getSupportedTrackers: posclient not initialized -> ignored", new Object[0]);
                    return EnumSet.noneOf(cls);
                }
                AnonymousClass3 r0 = new SyncHandlerTask<EnumSet<Tracker>>() {
                    public void onException(Exception exc) {
                        Log.e(PosClientManager.TAG, "getSupportedTrackers: onException", new Object[0]);
                        setResult(EnumSet.noneOf(Tracker.class));
                    }

                    public EnumSet<Tracker> onRun() {
                        Log.i(PosClientManager.TAG, "getSupportedTrackers: onRun", new Object[0]);
                        return UsageTracking.getSupportedTrackers();
                    }
                };
                return PosClientManager.this.mHandler.post(r0) ? (EnumSet) r0.getResult() : EnumSet.noneOf(cls);
            }

            public Status subscribe(final UsageTrackingListener usageTrackingListener, final Tracker... trackerArr) {
                if (!PosClientManager.this.mPosClientInitialized.get()) {
                    Log.w(PosClientManager.TAG, "subscribe: posclient not initialized -> ignored", new Object[0]);
                    return Status.GeneralError;
                }
                AnonymousClass2 r0 = new SyncHandlerTask<Status>() {
                    public void onException(Exception exc) {
                        Log.e(PosClientManager.TAG, "subscribe: onException", new Object[0]);
                        setResult(Status.InternalError);
                    }

                    public Status onRun() {
                        Log.i(PosClientManager.TAG, "subscribe: onRun", new Object[0]);
                        return UsageTracking.subscribe(usageTrackingListener, trackerArr);
                    }
                };
                return PosClientManager.this.mHandler.post(r0) ? (Status) r0.getResult() : Status.InternalError;
            }

            public Status unsubscribe() {
                if (!PosClientManager.this.mPosClientInitialized.get()) {
                    Log.w(PosClientManager.TAG, "unsubscribe: posclient not initialized -> ignored", new Object[0]);
                    return Status.GeneralError;
                }
                return PosClientManager.this.mHandler.post(new Runnable() {
                    public void run() {
                        UsageTracking.unsubscribe();
                    }
                }) ? Status.Ok : Status.InternalError;
            }
        };
    }

    public void dumpCachedData() {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "dumpCachedData: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "dumpCachedData", new Object[0]);
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                PositioningControl.dumpCachedData();
            }
        })) {
            Log.w(TAG, "dumpCachedData: Handler.post failed", new Object[0]);
        }
    }

    public void dumpFingerprints() {
    }

    public void dumpRemoteConfiguration() {
        if (isPosclientInitialized()) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    RndExtension.dumpRemoteConfiguration();
                }
            });
        }
    }

    public int enabledFeatures() {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "enabledFeatures: posclient not initialized -> ignored", new Object[0]);
            return 0;
        }
        AnonymousClass68 r0 = new SyncHandlerTask<Long>() {
            public void onException(Exception exc) {
                setResult(0L);
            }

            public Long onRun() {
                return Long.valueOf(PositioningControl.enabledFeatures());
            }
        };
        if (this.mHandler.post(r0)) {
            return ((Long) r0.getResult()).intValue();
        }
        Log.w(TAG, "enabledFeatures: Handler.post failed", new Object[0]);
        return 0;
    }

    public boolean getActiveCollection() {
        Log.v(TAG, "getActiveCollection: %b", Boolean.FALSE);
        return false;
    }

    public boolean getAutoUpload() {
        Log.v(TAG, "getAutoUpload: %b", Boolean.FALSE);
        return false;
    }

    public ICellManager getCellManager() {
        return this.mMeasurementProvider.getCellManager();
    }

    public ClientConfiguration getClientConfiguration() {
        return this.mClientConfiguration;
    }

    public Status getCollectionStats(IPosClientTesterSession.FingerprintStatsListener fingerprintStatsListener) {
        return Status.NotSupportedError;
    }

    public boolean getCollectionStatus() {
        Log.v(TAG, "getCollectionStatus: %b", Boolean.FALSE);
        return false;
    }

    public Context getContext() {
        return this.mContext;
    }

    public long getGnssFingerprintCount() {
        Log.v(TAG, "getGnssFingerprintCount: count: %d", 0L);
        return 0;
    }

    public IGnssManager getGnssManager() {
        return this.mMeasurementProvider.getGnssManager();
    }

    public long getNonGnssFingerprintCount() {
        Log.v(TAG, "getNonGnssFingerprintCount: count: %d", 0L);
        return 0;
    }

    public IWifiManager getWifiManager() {
        return this.mMeasurementProvider.getWifiManager();
    }

    public void handleAndroidGnssStatus(final long j, final Object obj) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "handleAndroidGnssStatus: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "handleAndroidGnssStatus: %s", obj);
        this.mHandler.post(new Runnable() {
            public void run() {
                PosClientLib.handleAndroidGnssStatusChanged(j, (GnssStatus) obj);
            }
        });
    }

    public void handleCellularScanResult(final CellMeasurement cellMeasurement, final boolean z) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "handleCellularScanResult: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "handleCellularScanResult", new Object[0]);
        this.mHandler.post(new Runnable() {
            public void run() {
                PosClientLib.handleCellularScanResult(cellMeasurement, z);
            }
        });
    }

    public void handleCellularStatusChange(final CellularStatus cellularStatus) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "handleCellularStatusChange: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "handleCellularStatusChange", new Object[0]);
        this.mHandler.post(new Runnable() {
            public void run() {
                PosClientLib.handleCellularStatusChanged(cellularStatus);
            }
        });
    }

    public void handleGlobalLocationSettingChanged(final boolean z) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "handleGlobalLocationSettingChanged: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "handleGlobalLocationSettingChanged enabled: %b", Boolean.valueOf(z));
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                PositioningControl.handleGlobalLocationSettingChanged(z);
            }
        })) {
            Log.w(TAG, "handleGlobalLocationSettingChanged: Handler.post failed", new Object[0]);
        }
    }

    public void handleGnssLocationUpdate(final PositionEstimate positionEstimate, final boolean z) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "handleGnssLocationUpdate: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "handleGnssLocationUpdate", new Object[0]);
        this.mHandler.post(new Runnable() {
            public void run() {
                PosClientLib.handleGnssLocationUpdate(positionEstimate, z);
            }
        });
    }

    public void handleGnssMeasurements(final Object obj) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "handleGnssMeasurements: posclient not initialized -> ignored", new Object[0]);
        } else {
            this.mHandler.post(new Runnable() {
                public void run() {
                    GnssObservationConverter.resetCapabilitiesChecks();
                    PosClientLib.handleGnssMeasurements(GnssObservationConverter.createObservationHeader((GnssMeasurementsEvent) obj), GnssObservationConverter.createObservationDataArray((GnssMeasurementsEvent) obj));
                }
            });
        }
    }

    public void handleGnssStatus(final com.here.posclient.GnssStatus gnssStatus) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "handleGnssStatus: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "handleGnssStatus: %s", gnssStatus);
        this.mHandler.post(new Runnable() {
            public void run() {
                PosClientLib.handleGnssStatusChanged(gnssStatus.toInt());
            }
        });
    }

    public void handleRequestError(final MeasurementType measurementType, final Status status) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "handleRequestError: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "handleRequestError", new Object[0]);
        this.mHandler.post(new Runnable() {
            public void run() {
                PosClientLib.handleRequestError(measurementType.value, status.toInt());
            }
        });
    }

    public void handleWifiScanResult(long j, WifiMeasurement[] wifiMeasurementArr, boolean z, boolean z2) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "handleWifiScanResult: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "handleWifiScanResult", new Object[0]);
        final long j2 = j;
        final WifiMeasurement[] wifiMeasurementArr2 = wifiMeasurementArr;
        final boolean z3 = z;
        final boolean z4 = z2;
        this.mHandler.post(new Runnable() {
            public void run() {
                PosClientLib.handleWifiScanResult(j2, wifiMeasurementArr2, z3, z4);
            }
        });
    }

    public void handleWifiStateChanged(final WifiStatus wifiStatus) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "handleWifiStateChanged: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "handleWifiStateChanged", new Object[0]);
        this.mHandler.post(new Runnable() {
            public void run() {
                PosClientLib.handleWifiStatusChanged(wifiStatus.value);
            }
        });
    }

    public boolean isOfflineModeSet() {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "isOfflineModeSet: posclient not initialized -> ignored", new Object[0]);
            return false;
        }
        AnonymousClass31 r0 = new SyncHandlerTask<Boolean>() {
            public void onException(Exception exc) {
                setResult(Boolean.FALSE);
            }

            public Boolean onRun() {
                return Boolean.valueOf(!PositioningControl.isNetworkingEnabled());
            }
        };
        if (this.mHandler.post(r0)) {
            return ((Boolean) r0.getResult()).booleanValue();
        }
        Log.e(TAG, "isOfflineModeSet: Handler.post() failed", new Object[0]);
        return false;
    }

    public void logLta(final String str) {
        if (isPosclientInitialized()) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    PosClientLib.logLta(str);
                }
            });
        }
    }

    public void onBatteryLevelChanged(final int i) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onBatteryLevelChanged: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "onBatteryLevelChanged: level: %d%%", Integer.valueOf(i));
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                PosClientLib.setBatteryLevel(i);
            }
        })) {
            Log.e(TAG, "onBatteryLevelChanged: error posting task", new Object[0]);
        }
    }

    public void onConnectionStateChanged(final PosClientLib.ConnectionChangeAction connectionChangeAction, final INetworkManager.Connection connection) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onConnectionStateChanged: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "onConnectionStateChanged action: %s", connectionChangeAction.name());
        this.mHandler.post(new Runnable() {
            public void run() {
                PosClientLib.handleConnectionChange(connectionChangeAction, connection);
            }
        });
    }

    public Location onGetLastLocation() {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onGetLastLocation: posclient not initialized -> ignored", new Object[0]);
            return null;
        }
        this.mWakeLock.acquire();
        try {
            AnonymousClass33 r0 = new SyncHandlerTask<Location>() {
                public Location onRun() {
                    return PositionEstimate.toAndroidLocation(PosClientLib.getLastPosition());
                }
            };
            if (!this.mHandler.post(r0)) {
                Log.e(TAG, "onGetLastPosition: Handler.post() failed", new Object[0]);
                return null;
            }
            Location location = (Location) r0.getResult();
            this.mWakeLock.release();
            return location;
        } finally {
            this.mWakeLock.release();
        }
    }

    public UpdateOptions onGetUpdateOptions() {
        return this.mUpdateOptions;
    }

    public void onHandleActivityResult(final ActivityResult activityResult) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onHandleActivityResult: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "onHandleActivityResult: %s", activityResult.toString());
        this.mHandler.post(new Runnable() {
            public void run() {
                PosClientLib.handleActivityResult(activityResult);
            }
        });
    }

    public void onHandleGlobalLocationSettingChanged(final boolean z) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onHandleGlobalLocationSettingChanged: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "onHandleGlobalLocationSettingChanged enabled: %b", Boolean.valueOf(z));
        this.mHandler.post(new Runnable() {
            public void run() {
                if (!z) {
                    PosClientLib.clearData(PosClientManager.DEFAULT_CLEAR_DATA_FLAGS);
                }
                PositioningControl.handleGlobalLocationSettingChanged(z);
                PosClientManager.this.mEnginesStopped.set(!z);
            }
        });
    }

    public boolean onInjectActivity(final GeneralActivityResult generalActivityResult) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onInjectActivity: posclient not initialized -> ignored", new Object[0]);
            return false;
        } else if (this.mSensorManager == null) {
            Log.w(TAG, "onInjectActivity: sensor manager not initialized -> ignored", new Object[0]);
            return false;
        } else {
            Log.v(TAG, "onInjectActivity", new Object[0]);
            this.mHandler.post(new Runnable() {
                public void run() {
                    PosClientManager.this.mSensorManager.onHandleActivityResult(generalActivityResult);
                }
            });
            return true;
        }
    }

    public boolean onInjectLocation(final Location location) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onInjectLocation: posclient not initialized -> ignored", new Object[0]);
            return false;
        }
        Log.v(TAG, "onInjectLocation", new Object[0]);
        AnonymousClass38 r0 = new SyncHandlerTask<Boolean>() {
            public Boolean onRun() {
                Status fromInt = Status.fromInt(PosClientLib.injectLocation(PositionEstimate.fromAndroidLocation(location)));
                Log.v(PosClientManager.TAG, "onInjectLocation: %s", fromInt.name());
                return Boolean.valueOf(Status.Ok.equals(fromInt));
            }
        };
        if (this.mHandler.post(r0)) {
            return ((Boolean) r0.getResult()).booleanValue();
        }
        Log.e(TAG, "onInjectLocation: Handler.post() failed -> GeneralError", new Object[0]);
        return false;
    }

    public void onMonitorStateChanged(DeviceMonitor.Listener.MonitorType monitorType, boolean z) {
        this.mIsBlacklistedMcc = z;
        Log.v(TAG, "onMonitorStateChanged: blacklisted MCC change detected, state: " + Boolean.toString(z), new Object[0]);
        this.mHandler.post(new Runnable() {
            public void run() {
                if (PosClientManager.this.mIsBlacklistedMcc) {
                    PosClientManager.this.setAllPositioningFeatures(Long.valueOf(PositioningFeature.All.value), false);
                    return;
                }
                PosClientManager posClientManager = PosClientManager.this;
                posClientManager.setAllPositioningFeatures(posClientManager.mFeatures, true);
            }
        });
    }

    public void onMonitoringStarted(DeviceMonitor.Listener.MonitorType monitorType, boolean z) {
        this.mIsBlacklistedMcc = z;
    }

    public void onMonitoringStopped(DeviceMonitor.Listener.MonitorType monitorType) {
        this.mIsBlacklistedMcc = false;
    }

    public void onNetworkLocationDisabled(final boolean z) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onNetworkLocationDisabled: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "onNetworkLocationDisabled: userChanged: %b", Boolean.valueOf(z));
        this.mHandler.post(new Runnable() {
            public void run() {
                int i = !z ? PosClientManager.DEFAULT_CLEAR_DATA_FLAGS : 9;
                PositioningControl.handleGlobalLocationSettingChanged(false);
                PosClientLib.clearData(i);
                PosClientManager.this.mEnginesStopped.set(true);
            }
        });
    }

    public void onNetworkLocationEnabled() {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onNetworkLocationEnabled: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "onNetworkLocationEnabled", new Object[0]);
        this.mHandler.post(new Runnable() {
            public void run() {
                PositioningControl.handleGlobalLocationSettingChanged(true);
                PosClientManager.this.mEnginesStopped.set(false);
            }
        });
    }

    public void onRefreshRemoteConfiguration() {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onRefreshRemoteConfiguration: posclient not initialized -> ignored", new Object[0]);
        } else {
            this.mHandler.post(new Runnable() {
                public void run() {
                    RndExtension.refreshRemoteConfiguration();
                }
            });
        }
    }

    public void onRequestLastPosition() {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onRequestLastPosition: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                PosClientManager.this.positionUpdate(PosClientLib.getLastPosition());
            }
        })) {
            Log.e(TAG, "onRequestLastPosition: Handler.post() failed", new Object[0]);
        } else {
            this.mWakeLock.acquire();
        }
    }

    public void onRequestPosition() {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onRequestPosition: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "onRequestPosition", new Object[0]);
        this.mHandler.post(new Runnable() {
            public void run() {
                UpdateOptions updateOptions = new UpdateOptions(PosClientManager.this.mUpdateOptions);
                updateOptions.setSmallestUpdateInterval(0);
                if (PosClientLib.requestPosition(updateOptions) != Status.Ok.toInt()) {
                    Log.e(PosClientManager.TAG, "onRequestPosition: failed to request position!", new Object[0]);
                }
            }
        });
    }

    public Status onRequestSingleUpdate(final UpdateOptions updateOptions, final IPositioningSession.ILocationListener iLocationListener) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onRequestSingleUpdate: posclient not initialized -> ignored", new Object[0]);
            return Status.UsageError;
        }
        Log.v(TAG, "onRequestSingleUpdate", new Object[0]);
        AnonymousClass35 r0 = new SyncHandlerTask<Status>() {
            public Status onRun() {
                Status fromInt = Status.fromInt(PosClientLib.requestSinglePosition(updateOptions, new IPosClientObserver() {
                    public void positionUpdate(PositionEstimate positionEstimate) {
                        Log.v(PosClientManager.TAG, "onRequestSingleUpdate.positionUpdate: " + positionEstimate, new Object[0]);
                        AnonymousClass35 r0 = AnonymousClass35.this;
                        if (!PosClientManager.this.validatePositionEstimate(positionEstimate, updateOptions)) {
                            positioningError(Status.GeneralError.toInt(), 0);
                            return;
                        }
                        Location access$3700 = PosClientManager.this.convertToAndroidLocation(positionEstimate);
                        if (access$3700 == null) {
                            positioningError(Status.ConversionError.toInt(), 0);
                        } else {
                            iLocationListener.onLocationChanged(access$3700);
                        }
                    }

                    public void positioningError(int i, int i2) {
                        iLocationListener.onLocationResolvingFailed(new PositioningError(i, i2));
                    }

                    public void positioningInfo(int i) {
                        iLocationListener.onLocationInfoChanged(new PositioningError(0, i));
                    }
                }));
                Log.v(PosClientManager.TAG, "onRequestSingleUpdate: %s", fromInt.name());
                return fromInt;
            }
        };
        if (this.mHandler.post(r0)) {
            return (Status) r0.getResult();
        }
        Log.e(TAG, "onRequestSingleUpdate: Handler.post() failed -> GeneralError", new Object[0]);
        return Status.GeneralError;
    }

    public void onResetMeasurements() {
        MeasurementProvider measurementProvider = this.mMeasurementProvider;
        if (measurementProvider != null) {
            measurementProvider.reset();
        }
    }

    public void onScreenOff() {
        pushScreenState(false);
    }

    public void onScreenOn() {
        pushScreenState(true);
    }

    public void onSetRadioMapPath(final String str) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onSetRadioMapPath: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "onSetRadioMapPath path: '%s'", str);
        this.mHandler.post(new Runnable() {
            public void run() {
                PositioningControl.setWorkingRadioMapPath(str);
            }
        });
    }

    public int onSetUpdateOptions(UpdateOptions updateOptions, IPositioningSession.StatusListener statusListener) {
        Log.v(TAG, "onSetUpdateOptions: %s was: %s", updateOptions, this.mUpdateOptions);
        this.mUpdateOptions = updateOptions;
        return onUpdateOptions(updateOptions, statusListener);
    }

    public Status onStartInjectionUpdates() {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onStartInjectionUpdates: posclient not initialized -> ignored", new Object[0]);
            return Status.UsageError;
        }
        Log.v(TAG, "onStartInjectionUpdates", new Object[0]);
        AnonymousClass37 r0 = new SyncHandlerTask<Status>() {
            public Status onRun() {
                Status fromInt = Status.fromInt(PosClientLib.startInjectionUpdates());
                Log.v(PosClientManager.TAG, "onStartInjectionUpdates: %s", fromInt.name());
                if (Status.Ok.equals(fromInt)) {
                    UpdateOptions unused = PosClientManager.this.mUpdateOptions = new UpdateOptions();
                    PosClientManager.this.mUpdateOptions.setAllowedSources(UpdateOptions.SOURCE_ANY);
                }
                return fromInt;
            }
        };
        if (this.mHandler.post(r0)) {
            return (Status) r0.getResult();
        }
        Log.e(TAG, "onStartInjectionUpdates: Handler.post() failed -> GeneralError", new Object[0]);
        return Status.GeneralError;
    }

    public Status onStartPositionUpdates() {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onStartPositionUpdates: posclient not initialized -> ignored", new Object[0]);
            return Status.UsageError;
        }
        Log.v(TAG, "onStartPositionUpdates", new Object[0]);
        AnonymousClass36 r0 = new SyncHandlerTask<Status>() {
            public Status onRun() {
                Status fromInt = Status.fromInt(PosClientLib.startPositionUpdates());
                Log.v(PosClientManager.TAG, "startPositionUpdates: %s", fromInt.name());
                return fromInt;
            }
        };
        if (this.mHandler.post(r0)) {
            return (Status) r0.getResult();
        }
        Log.e(TAG, "onStartPositionUpdates: Handler.post() failed -> GeneralError", new Object[0]);
        return Status.GeneralError;
    }

    public boolean onStartRadioMapQuery(RadioMapManager.RadioMapQueryAction radioMapQueryAction, long j, GeoArea[] geoAreaArr, int i, RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener) {
        boolean z = false;
        Log.v(TAG, "onStartRadioMapQuery", new Object[0]);
        if (geoAreaArr == null) {
            throw new IllegalArgumentException("areas is null");
        } else if (iRadioMapStorageActionListener != null) {
            final long j2 = j;
            final int i2 = i;
            final GeoArea[] geoAreaArr2 = geoAreaArr;
            final RadioMapManager.RadioMapQueryAction radioMapQueryAction2 = radioMapQueryAction;
            final RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener2 = iRadioMapStorageActionListener;
            AnonymousClass42 r4 = new SyncHandlerTask<Boolean>() {
                public void onException(Exception exc) {
                    setResult(Boolean.FALSE);
                }

                public Boolean onRun() {
                    return Boolean.valueOf(RadioMapManager.startRadioMapQuery(geoAreaArr2, radioMapQueryAction2, new RadioMapManager.Options(j2, i2), iRadioMapStorageActionListener2));
                }
            };
            if (this.mHandler.post(r4)) {
                z = ((Boolean) r4.getResult()).booleanValue();
            } else {
                Log.e(TAG, "onStartRadioMapQuery: Handler.post failed", new Object[0]);
            }
            Log.v(TAG, "onStartRadioMapQuery: result: %b", Boolean.valueOf(z));
            return z;
        } else {
            throw new IllegalArgumentException("listener is null");
        }
    }

    public void onStopPositionUpdates() {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "onStopPositionUpdates: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "onStopPositionUpdates", new Object[0]);
        cancelLocationRequest();
        this.mHandler.post(new Runnable() {
            public void run() {
                PosClientLib.stopPositionUpdates();
            }
        });
    }

    public void onStopRadioMapUpdate(final RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener) {
        Log.v(TAG, "onStopRadioMapUpdate", new Object[0]);
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                RadioMapManager.stopRadioMapAction(iRadioMapStorageActionListener);
            }
        })) {
            Log.e(TAG, "onStopRadioMapUpdate: Handler.post failed", new Object[0]);
        }
    }

    public boolean onUpdateRadioMapCoverage(RadioMapManager.RadioMapStorageAction radioMapStorageAction, long j, GeoArea[] geoAreaArr, int i, long j2, RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener) {
        boolean z = false;
        Log.v(TAG, "onUpdateRadioMapCoverage", new Object[0]);
        if (geoAreaArr == null) {
            throw new IllegalArgumentException("areas is null");
        } else if (iRadioMapStorageActionListener != null) {
            final long j3 = j;
            final int i2 = i;
            final long j4 = j2;
            final GeoArea[] geoAreaArr2 = geoAreaArr;
            final RadioMapManager.RadioMapStorageAction radioMapStorageAction2 = radioMapStorageAction;
            final RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener2 = iRadioMapStorageActionListener;
            AnonymousClass41 r4 = new SyncHandlerTask<Boolean>() {
                public void onException(Exception exc) {
                    setResult(Boolean.FALSE);
                }

                public Boolean onRun() {
                    return Boolean.valueOf(RadioMapManager.updateRadioMapCoverage(geoAreaArr2, radioMapStorageAction2, new RadioMapManager.Options(j3, i2, j4), iRadioMapStorageActionListener2));
                }
            };
            if (this.mHandler.post(r4)) {
                z = ((Boolean) r4.getResult()).booleanValue();
            } else {
                Log.e(TAG, "onUpdateRadioMapCoverage: Handler.post failed", new Object[0]);
            }
            Log.v(TAG, "onUpdateRadioMapCoverage: result: %b", Boolean.valueOf(z));
            return z;
        } else {
            throw new IllegalArgumentException("listener is null");
        }
    }

    public void overrideConfiguration(String str) {
    }

    public synchronized void positionUpdate(PositionEstimate positionEstimate) {
        try {
            Log.v(TAG, "positionUpdate: " + positionEstimate, new Object[0]);
            if (this.mPositioners.isEmpty()) {
                Log.w(TAG, "positionUpdate: no positioners -> ignored", new Object[0]);
                this.mWakeLock.release();
            } else if (!validatePositionEstimate(positionEstimate, this.mUpdateOptions)) {
                this.mWakeLock.release();
            } else {
                Location convertToAndroidLocation = convertToAndroidLocation(positionEstimate);
                if (convertToAndroidLocation == null) {
                    this.mWakeLock.release();
                    return;
                }
                for (PositioningSession locationChanged : this.mPositioners) {
                    locationChanged.locationChanged(convertToAndroidLocation);
                }
                this.mWakeLock.release();
            }
        } catch (Throwable th) {
            this.mWakeLock.release();
            throw th;
        }
    }

    public void positioningConsentRevoked() {
        Log.v(TAG, "positioningConsentRevoked", new Object[0]);
        clearData(Integer.MAX_VALUE);
        this.mEnginesStopped.set(true);
        shutdown();
    }

    public synchronized void positioningError(int i, int i2) {
        PositioningError positioningError = new PositioningError(i, i2);
        Log.v(TAG, "positioningError: %s", positioningError);
        try {
            for (PositioningSession locationCalculationFailed : this.mPositioners) {
                locationCalculationFailed.locationCalculationFailed(positioningError);
            }
        } finally {
            this.mWakeLock.release();
        }
    }

    public synchronized void positioningInfo(int i) {
        PositioningError positioningError = new PositioningError(0, i);
        Log.v(TAG, "positioninginfo: %s", Integer.valueOf(i));
        try {
            for (PositioningSession locationInfoChanged : this.mPositioners) {
                locationInfoChanged.locationInfoChanged(positioningError);
            }
        } finally {
            this.mWakeLock.release();
        }
    }

    public void refreshRemoteConfiguration() {
        if (isPosclientInitialized()) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    RndExtension.refreshRemoteConfiguration();
                }
            });
        }
    }

    public synchronized boolean removeAuthSession(AuthSession authSession) {
        return this.mAuths.remove(authSession);
    }

    public synchronized boolean removeConsentSession(ConsentSession consentSession) {
        return this.mConsents.remove(consentSession);
    }

    public synchronized boolean removeHdCrowdsourceSession(HdCrowdsourceSession hdCrowdsourceSession) {
        return this.mHdCrowdsourceSessions.remove(hdCrowdsourceSession);
    }

    public synchronized boolean removePositioner(PositioningSession positioningSession) {
        return this.mPositioners.remove(positioningSession);
    }

    public synchronized boolean removeRmDownloader(RmDownloadSession rmDownloadSession) {
        return this.mRmDownloaders.remove(rmDownloadSession);
    }

    public synchronized boolean removeSimulationSession(SimulationSession simulationSession) {
        return this.mSimulators.remove(simulationSession);
    }

    public synchronized boolean removeTesterSession(PosClientTesterSession posClientTesterSession) {
        return this.mTesters.remove(posClientTesterSession);
    }

    public synchronized boolean removeUploadSession(UploadSession uploadSession) {
        return this.mUploadSessions.remove(uploadSession);
    }

    public synchronized boolean removeUsageTrackingSession(UsageTrackingSession usageTrackingSession) {
        return this.mUsageTrackers.remove(usageTrackingSession);
    }

    public void resetPositioningFilter() {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "resetPositioningFilter: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        AnonymousClass46 r0 = new SyncHandlerTask<Void>() {
            public Void onRun() {
                PosClientLib.clearData(265);
                return null;
            }
        };
        if (this.mHandler.post(r0)) {
            r0.getResult();
        } else {
            Log.e(TAG, "resetPositioningFilter: Handler.post failed", new Object[0]);
        }
    }

    public void sendFingerprints() {
    }

    public boolean setActiveCollection(boolean z) {
        Log.v(TAG, "setActiveCollection: result: %b", Boolean.FALSE);
        return false;
    }

    public boolean setAutoUpload(boolean z) {
        Log.v(TAG, "setAutoUpload: result: %b", Boolean.FALSE);
        return false;
    }

    public boolean setCellManager(final ICellManager iCellManager) {
        if (iCellManager == null) {
            throw new IllegalArgumentException("cellManager is null");
        } else if (!isPosclientInitialized()) {
            return false;
        } else {
            AnonymousClass61 r0 = new SyncHandlerTask<Boolean>() {
                public void onException(Exception exc) {
                    setResult(Boolean.FALSE);
                }

                public Boolean onRun() {
                    PosClientManager.this.mMeasurementProvider.setCellManager(iCellManager, true);
                    return Boolean.TRUE;
                }
            };
            if (!this.mHandler.post(r0)) {
                return false;
            }
            return ((Boolean) r0.getResult()).booleanValue();
        }
    }

    public boolean setGnssManager(final IGnssManager iGnssManager) {
        if (iGnssManager == null) {
            throw new IllegalArgumentException("gnssManager is null");
        } else if (!isPosclientInitialized()) {
            return false;
        } else {
            AnonymousClass62 r0 = new SyncHandlerTask<Boolean>() {
                public void onException(Exception exc) {
                    setResult(Boolean.FALSE);
                }

                public Boolean onRun() {
                    PosClientManager.this.mMeasurementProvider.setGnssManager(iGnssManager, true);
                    return Boolean.TRUE;
                }
            };
            if (!this.mHandler.post(r0)) {
                return false;
            }
            return ((Boolean) r0.getResult()).booleanValue();
        }
    }

    public void setOfflineMode(final boolean z) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "setOfflineMode: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                PositioningControl.setNetworkingEnabled(!z);
            }
        })) {
            Log.e(TAG, "setOfflineMode: Handler.post() failed", new Object[0]);
        }
    }

    public void setRadioMapPath(String str) {
        onSetRadioMapPath(str);
    }

    public void setSubprocessorEndpointEnabled(final boolean z) {
        Log.v(TAG, "setSubprocessorEndpointEnabled: enabled: " + z, new Object[0]);
        if (!isPosclientInitialized()) {
            Log.w(TAG, "setSubprocessorEndpointEnabled: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                PositioningControl.setSubprocessorEndpointEnabled(z);
            }
        })) {
            Log.e(TAG, "setSubprocessorEndpointEnabled: Handler.post() failed", new Object[0]);
        }
    }

    public void setUsername(String str) {
    }

    public boolean setWifiManager(final IWifiManager iWifiManager) {
        if (iWifiManager == null) {
            throw new IllegalArgumentException("wifiManager is null");
        } else if (!isPosclientInitialized()) {
            return false;
        } else {
            AnonymousClass60 r0 = new SyncHandlerTask<Boolean>() {
                public void onException(Exception exc) {
                    setResult(Boolean.FALSE);
                }

                public Boolean onRun() {
                    PosClientManager.this.mMeasurementProvider.setWifiManager(iWifiManager, true);
                    return Boolean.TRUE;
                }
            };
            if (!this.mHandler.post(r0)) {
                return false;
            }
            return ((Boolean) r0.getResult()).booleanValue();
        }
    }

    public boolean startHDWifiStateMonitoring(IPosClientTesterSession.HDWifiStateListener hDWifiStateListener) {
        Log.v(TAG, "startHDWifiStateMonitoring: %b", Boolean.FALSE);
        return false;
    }

    public boolean startSimulation(ISimulationSession.Listener listener, PositionEstimate positionEstimate, Object[] objArr, UpdateOptions updateOptions) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "startSimulation: posclient not initialized -> ignored", new Object[0]);
            return false;
        } else if (objArr == null || objArr.length < 1) {
            Log.w(TAG, "startSimulation: no measurements -> ignored", new Object[0]);
            return false;
        } else {
            Log.v(TAG, "startSimulation: %d measurements", Integer.valueOf(objArr.length));
            final ISimulationSession.Listener listener2 = listener;
            final PositionEstimate positionEstimate2 = positionEstimate;
            final Object[] objArr2 = objArr;
            final UpdateOptions updateOptions2 = updateOptions;
            AnonymousClass57 r4 = new SyncHandlerTask<Boolean>() {
                public void onException(Exception exc) {
                    setResult(Boolean.FALSE);
                }

                public Boolean onRun() {
                    return Boolean.valueOf(Status.Ok.toInt() == TestTrackSimulation.startSimulation(listener2, positionEstimate2, objArr2, updateOptions2));
                }
            };
            if (this.mHandler.post(r4)) {
                return ((Boolean) r4.getResult()).booleanValue();
            }
            Log.e(TAG, "startSimulation: Handler.post failed", new Object[0]);
            return false;
        }
    }

    public void stopHDWifiStateMonitoring(IPosClientTesterSession.HDWifiStateListener hDWifiStateListener) {
    }

    public void stopSimulation() {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "stopSimulation: posclient not initialized -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "stopSimulation", new Object[0]);
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                TestTrackSimulation.stopSimulation();
            }
        })) {
            Log.e(TAG, "stopSimulation: Handler.post failed", new Object[0]);
        }
    }

    public Status toggleFeature(final PositioningFeature positioningFeature, final boolean z) {
        if (!isPosclientInitialized()) {
            Log.w(TAG, "toggleFeature: posclient not initialized -> ignored", new Object[0]);
            return Status.GeneralError;
        }
        Log.v(TAG, "toggleFeature feature: %s enabled: %b", positioningFeature, Boolean.valueOf(z));
        if (!z || !this.mIsBlacklistedMcc) {
            AnonymousClass66 r0 = new SyncHandlerTask<Status>() {
                public void onException(Exception exc) {
                    setResult(Status.GeneralError);
                }

                public Status onRun() {
                    Status fromInt = Status.fromInt(PositioningControl.toggleFeature(positioningFeature.value, z));
                    if (fromInt == Status.Ok) {
                        if (z) {
                            PosClientManager posClientManager = PosClientManager.this;
                            Long unused = posClientManager.mFeatures = Long.valueOf(posClientManager.mFeatures.longValue() | positioningFeature.value);
                        } else {
                            PosClientManager posClientManager2 = PosClientManager.this;
                            Long unused2 = posClientManager2.mFeatures = Long.valueOf(posClientManager2.mFeatures.longValue() & (~positioningFeature.value));
                        }
                    }
                    return fromInt;
                }
            };
            if (this.mHandler.post(r0)) {
                return (Status) r0.getResult();
            }
            Log.w(TAG, "toggleFeature: Handler.post failed", new Object[0]);
            return Status.GeneralError;
        }
        Log.v(TAG, "toggleFeature: %s enable denied due to blacklisted MCC", positioningFeature);
        return Status.TemporarilyNotAllowedError;
    }

    public boolean updateOptions(Bundle bundle) {
        if (bundle.containsKey(InitOptions.KEY_OPTION_OFFLINE_MODE)) {
            setOfflineMode(bundle.getBoolean(InitOptions.KEY_OPTION_OFFLINE_MODE, false));
            bundle.remove(InitOptions.KEY_OPTION_OFFLINE_MODE);
        }
        if (bundle.containsKey(InitOptions.KEY_OPTION_NO_OFFLINE_POSITIONING)) {
            boolean z = !bundle.getBoolean(InitOptions.KEY_OPTION_NO_OFFLINE_POSITIONING, false);
            toggleFeature(PositioningFeature.Offline, z);
            toggleFeature(PositioningFeature.RadioMapDownload, z);
            bundle.remove(InitOptions.KEY_OPTION_NO_OFFLINE_POSITIONING);
        }
        Log.v(TAG, "updateOptions: options now: " + bundle, new Object[0]);
        if (bundle.containsKey(InitOptions.KEY_OPTION_SUBPROCESSOR_ENDPOINT)) {
            setSubprocessorEndpointEnabled(bundle.getBoolean(InitOptions.KEY_OPTION_SUBPROCESSOR_ENDPOINT, false));
            bundle.remove(InitOptions.KEY_OPTION_SUBPROCESSOR_ENDPOINT);
        }
        if (!bundle.isEmpty()) {
            Log.v(TAG, "updateOptions: these option can't be updated on the fly: " + bundle, new Object[0]);
        }
        return true;
    }
}
