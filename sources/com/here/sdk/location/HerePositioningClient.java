package com.here.sdk.location;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.posclient.ConsentState;
import com.here.posclient.PositionEstimate;
import com.here.posclient.auth.AuthData;
import com.here.sdk.consent.ConsentFeature;
import com.here.sdk.consent.ConsentInternal;
import com.here.sdk.consent.ConsentListener;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.core.utilities.Preconditions;
import com.here.sdk.location.PositioningClientListener;
import com.here.services.Api;
import com.here.services.HereLocationApiClient;
import com.here.services.common.PositioningError;
import com.here.services.location.LocationListener;
import com.here.services.location.LocationServices;
import com.here.services.location.OptionsChangedEvent;
import com.here.services.location.hybrid.HybridLocationApi;
import com.here.services.location.util.LocationHelper;
import com.here.services.location.util.OptionsChangeHelper;
import com.here.services.positioning.auth.AuthServices;
import com.here.services.positioning.consent.ConsentApi;
import com.here.services.positioning.consent.ConsentServices;
import com.here.services.util.HereServicesUtil;
import com.meizu.common.widget.MzContactsContract;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class HerePositioningClient implements PositioningClient, ConsentListener {
    /* access modifiers changed from: private */
    public static final String LOG_TAG = "HerePositioningClient";
    /* access modifiers changed from: private */
    public final Context mApplicationContext;
    /* access modifiers changed from: private */
    public boolean mCallListenerFromMainThreadEnabled = true;
    /* access modifiers changed from: private */
    public HandlerThread mCallbackThread;
    private final HereLocationApiClient.ConnectionCallbacks mConnectionCallbacksListener = new ConnectionCallbacksListener();
    /* access modifiers changed from: private */
    public final ConsentInternal mConsentInternal;
    private ConsentState mConsentState = ConsentState.Unknown;
    /* access modifiers changed from: private */
    public LocationAccuracy mCurrentLocationAccuracy;
    /* access modifiers changed from: private */
    public LocationOptions mCurrentLocationOptions;
    private FeatureChecker mFeatureChecker;
    private final HereLocationApiClient.Options mGlobalOptions = new HereLocationApiClient.Options();
    /* access modifiers changed from: private */
    public boolean mHasLastKnownLocationBeenInit;
    /* access modifiers changed from: private */
    public HereLocationApiClient mHereLocationApiClient;
    /* access modifiers changed from: private */
    public final HybridLocationApi.Options mHybridPositioningOptions = new HybridLocationApi.Options();
    /* access modifiers changed from: private */
    public boolean mIsConnecting;
    /* access modifiers changed from: private */
    public boolean mIsStopRequested;
    /* access modifiers changed from: private */
    public String mLastKnowLocationFilePath;
    /* access modifiers changed from: private */
    public Location mLastKnownLocation;
    /* access modifiers changed from: private */
    public Handler mLastKnownLocationSaveHandler;
    /* access modifiers changed from: private */
    public HandlerThread mLastKnownLocationSaveThread;
    /* access modifiers changed from: private */
    public final LocationListener mLocationListener = new LocationListenerImpl();
    /* access modifiers changed from: private */
    public LocationProvider mLocationProvider = new LocationProvider() {
        public HybridLocationApi getHybridLocationProvider() {
            return LocationServices.HybridLocationProvider;
        }

        public Location getLastKnownLocation() {
            return getHybridLocationProvider().getLastLocation(HerePositioningClient.this.mHereLocationApiClient);
        }

        public boolean startLocationUpdates(@NonNull LocationOptions locationOptions) {
            HerePositioningClient.sdkCheckThat(HerePositioningClient.this.isConnected(), "Client must be non-null and connected");
            if (!HerePositioningClient.this.mCallListenerFromMainThreadEnabled && HerePositioningClient.this.mCallbackThread == null) {
                HandlerThread unused = HerePositioningClient.this.mCallbackThread = new HandlerThread("HerePositioningCallbackHandler");
                HerePositioningClient.this.mCallbackThread.start();
            }
            if (HerePositioningClient.this.mLastKnownLocationSaveThread == null) {
                HandlerThread unused2 = HerePositioningClient.this.mLastKnownLocationSaveThread = new HandlerThread("HerePositioningLastKnownLocationSaveHandler");
                HerePositioningClient.this.mLastKnownLocationSaveThread.start();
                Handler unused3 = HerePositioningClient.this.mLastKnownLocationSaveHandler = new Handler(HerePositioningClient.this.mLastKnownLocationSaveThread.getLooper());
            }
            HerePositioningClient.this.initPositioningOptions(locationOptions);
            boolean startLocationUpdates = getHybridLocationProvider().startLocationUpdates(HerePositioningClient.this.mHereLocationApiClient, HerePositioningClient.this.mHybridPositioningOptions, HerePositioningClient.this.mLocationListener, HerePositioningClient.this.mCallbackThread != null ? HerePositioningClient.this.mCallbackThread.getLooper() : null);
            String access$1100 = HerePositioningClient.LOG_TAG;
            Log.d(access$1100, "startLocationUpdates: successfully started: " + startLocationUpdates);
            return startLocationUpdates;
        }

        public void stopLocationUpdates() {
            getHybridLocationProvider().stopLocationUpdates(HerePositioningClient.this.mHereLocationApiClient, HerePositioningClient.this.mLocationListener);
            if (HerePositioningClient.this.mCallbackThread != null) {
                if (HerePositioningClient.this.mLastKnownLocationSaveHandler != null) {
                    HerePositioningClient.this.mLastKnownLocationSaveHandler.removeCallbacksAndMessages((Object) null);
                    Handler unused = HerePositioningClient.this.mLastKnownLocationSaveHandler = null;
                }
                HerePositioningClient.this.mCallbackThread.quit();
                HandlerThread unused2 = HerePositioningClient.this.mCallbackThread = null;
            }
            if (HerePositioningClient.this.mLastKnownLocationSaveThread != null) {
                HerePositioningClient.this.mLastKnownLocationSaveThread.quit();
                HandlerThread unused3 = HerePositioningClient.this.mLastKnownLocationSaveThread = null;
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean mLocationServicesEnabled;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private NetworkHolder mNetworkHolder;
    /* access modifiers changed from: private */
    public boolean mOfflineMode;
    /* access modifiers changed from: private */
    public PositioningClientListener mPositioningClientListener;

    /* renamed from: com.here.sdk.location.HerePositioningClient$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$here$services$HereLocationApiClient$Reason;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.here.services.HereLocationApiClient$Reason[] r0 = com.here.services.HereLocationApiClient.Reason.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$services$HereLocationApiClient$Reason = r0
                com.here.services.HereLocationApiClient$Reason r1 = com.here.services.HereLocationApiClient.Reason.MissingPermissions     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$here$services$HereLocationApiClient$Reason     // Catch:{ NoSuchFieldError -> 0x001d }
                com.here.services.HereLocationApiClient$Reason r1 = com.here.services.HereLocationApiClient.Reason.UserConsentNotGranted     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$here$services$HereLocationApiClient$Reason     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.here.services.HereLocationApiClient$Reason r1 = com.here.services.HereLocationApiClient.Reason.ServiceUsageForbidden     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.sdk.location.HerePositioningClient.AnonymousClass3.<clinit>():void");
        }
    }

    public final class ConnectionCallbacksListener implements HereLocationApiClient.ConnectionCallbacks {
        private ConnectionCallbacksListener() {
        }

        private void cleanup() {
            PositioningClientListener unused = HerePositioningClient.this.mPositioningClientListener = null;
            boolean unused2 = HerePositioningClient.this.mIsConnecting = false;
            HerePositioningClient.this.disconnect();
        }

        public void onConnected() {
            String access$1100 = HerePositioningClient.LOG_TAG;
            Log.d(access$1100, "onConnected - service version: " + HerePositioningClient.this.mHereLocationApiClient.getServiceVersion());
            boolean unused = HerePositioningClient.this.mIsConnecting = false;
            PositioningClientListener access$1400 = HerePositioningClient.this.mPositioningClientListener;
            if (HerePositioningClient.this.mIsStopRequested || access$1400 == null) {
                if (access$1400 == null) {
                    Log.d(HerePositioningClient.LOG_TAG, "onConnected - PositioningClientListener is null, disconnecting");
                } else {
                    boolean unused2 = HerePositioningClient.this.mIsStopRequested = false;
                    Log.d(HerePositioningClient.LOG_TAG, "onConnected - mIsStopRequested is true!");
                }
                HerePositioningClient.this.disconnect();
            } else if (!HerePositioningClient.this.mLocationProvider.startLocationUpdates((LocationOptions) Preconditions.checkNotNull(access$1400.getDesiredLocationOptions()))) {
                access$1400.onClientFailedToStart(LocationEngineStatus.START_FAILED);
                HerePositioningClient.this.disconnect();
            } else {
                LocationAccuracy unused3 = HerePositioningClient.this.mCurrentLocationAccuracy = access$1400.getDesiredLocationAccuracy();
                LocationOptions unused4 = HerePositioningClient.this.mCurrentLocationOptions = access$1400.getDesiredLocationOptions();
                if (HerePositioningClient.this.mOfflineMode) {
                    HerePositioningClient.this.handleSetOfflineModeConnected(true);
                }
                HerePositioningClient.this.subscribeForAuthenticationRequests();
                access$1400.onClientSuccessfullyStarted();
            }
            if (HerePositioningClient.this.mConsentInternal != null) {
                Log.d(HerePositioningClient.LOG_TAG, "starting listening for consent updates");
                HerePositioningClient.this.mConsentInternal.addListener(ConsentFeature.POSITIONING_CONTRIBUTE, HerePositioningClient.this);
                return;
            }
            Log.d(HerePositioningClient.LOG_TAG, "consent internal is null");
        }

        public void onConnectionFailed(HereLocationApiClient.Reason reason) {
            String access$1100 = HerePositioningClient.LOG_TAG;
            Log.d(access$1100, "onConnectionFailed - " + reason.toString());
            int i = AnonymousClass3.$SwitchMap$com$here$services$HereLocationApiClient$Reason[reason.ordinal()];
            LocationEngineStatus locationEngineStatus = i != 1 ? i != 2 ? i != 3 ? LocationEngineStatus.START_FAILED : LocationEngineStatus.NOT_ALLOWED : LocationEngineStatus.USER_CONSENT_NOT_HANDLED : LocationEngineStatus.MISSING_PERMISSIONS;
            PositioningClientListener access$1400 = HerePositioningClient.this.mPositioningClientListener;
            if (access$1400 != null) {
                access$1400.onClientFailedToStart(locationEngineStatus);
            }
            cleanup();
        }

        public void onDisconnected() {
            Log.d(HerePositioningClient.LOG_TAG, "onDisconnected");
            if (HerePositioningClient.this.mConsentInternal != null) {
                Log.d(HerePositioningClient.LOG_TAG, "stopping listening for consent updates");
                HerePositioningClient.this.mConsentInternal.removeListener(ConsentFeature.POSITIONING_CONTRIBUTE);
            } else {
                Log.d(HerePositioningClient.LOG_TAG, "consent internal is null");
            }
            PositioningClientListener access$1400 = HerePositioningClient.this.mPositioningClientListener;
            if (access$1400 != null) {
                access$1400.onClientDisconnected();
            }
            cleanup();
        }

        public void onInitializationFailed(Api<? extends Api.Options> api) {
            String access$1100 = HerePositioningClient.LOG_TAG;
            Log.d(access$1100, "onInitializationFailed. API token that failed: " + api.toString());
            PositioningClientListener access$1400 = HerePositioningClient.this.mPositioningClientListener;
            if (access$1400 != null) {
                access$1400.onClientFailedToStart(LocationEngineStatus.START_FAILED);
            }
            cleanup();
        }
    }

    public final class LocationListenerImpl implements LocationListener {
        private LocationListenerImpl() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onLocationChanged$0(Location location) {
            HerePositioningClient herePositioningClient = HerePositioningClient.this;
            herePositioningClient.saveLastKnownLocation(herePositioningClient.mLastKnowLocationFilePath, location);
        }

        public void onLocationChanged(@NonNull Location location) {
            long millis = TimeUnit.SECONDS.toMillis(1);
            if ((HerePositioningClient.this.mLastKnownLocation == null || location.getTime() > HerePositioningClient.this.mLastKnownLocation.getTime() + millis) && HerePositioningClient.this.mLastKnownLocationSaveHandler != null) {
                HerePositioningClient.this.mLastKnownLocationSaveHandler.postDelayed(new d(this, location), TimeUnit.MILLISECONDS.toMillis(1));
            }
            boolean unused = HerePositioningClient.this.mHasLastKnownLocationBeenInit = true;
            Location unused2 = HerePositioningClient.this.mLastKnownLocation = location;
            PositioningClientListener access$1400 = HerePositioningClient.this.mPositioningClientListener;
            if (access$1400 != null) {
                access$1400.onLocationChanged(location);
            }
        }

        public void onLocationInfoChanged(@NonNull PositioningError positioningError) {
            PositioningClientListener access$1400 = HerePositioningClient.this.mPositioningClientListener;
            if (access$1400 != null) {
                ArrayList arrayList = new ArrayList();
                if ((positioningError.errorDetails & 512) != 0) {
                    arrayList.add(LocationIssueType.HDGNSS_DEVICE_NOT_SUPPORTED);
                }
                if ((positioningError.errorDetails & 1024) != 0) {
                    arrayList.add(LocationIssueType.HDGNSS_OS_VERSION_NOT_SUPPORTED);
                }
                if ((positioningError.errorDetails & 2048) != 0) {
                    arrayList.add(LocationIssueType.HDGNSS_CONNECTION_NOT_AVAILABLE);
                }
                if ((positioningError.errorDetails & 4096) != 0) {
                    arrayList.add(LocationIssueType.HDGNSS_DEGRADED_MEASUREMENT_QUALITY);
                }
                if ((positioningError.errorDetails & 32768) != 0) {
                    arrayList.add(LocationIssueType.HDGNSS_INSUFFICIENT_MEASUREMENT_QUALITY);
                }
                access$1400.onLocationIssueChanged(arrayList);
            }
        }

        public void onLocationRequestFailed(@NonNull PositioningError positioningError) {
            String access$1100 = HerePositioningClient.LOG_TAG;
            Log.d(access$1100, "onLocationRequestFailed: " + positioningError);
            PositioningClientListener access$1400 = HerePositioningClient.this.mPositioningClientListener;
            if (access$1400 != null) {
                access$1400.onLocationRequestFailed();
            }
        }

        public void onOptionsChanged(@NonNull OptionsChangedEvent optionsChangedEvent) {
            String access$1100 = HerePositioningClient.LOG_TAG;
            Log.d(access$1100, "onOptionsChanged, requestedSources: " + optionsChangedEvent.getRequestedSources());
            String access$11002 = HerePositioningClient.LOG_TAG;
            Log.d(access$11002, "onOptionsChanged, disabledSources: " + optionsChangedEvent.getDisabledSources());
            String access$11003 = HerePositioningClient.LOG_TAG;
            Log.d(access$11003, "onOptionsChanged, requestedTechnologies: " + optionsChangedEvent.getRequestedTechnologies());
            String access$11004 = HerePositioningClient.LOG_TAG;
            Log.d(access$11004, "onOptionsChanged, disabledTechnologies: " + optionsChangedEvent.getDisabledTechnologies());
            boolean access$1500 = HerePositioningClient.this.mLocationServicesEnabled;
            HerePositioningClient herePositioningClient = HerePositioningClient.this;
            boolean unused = herePositioningClient.mLocationServicesEnabled = herePositioningClient.isLocationServicesEnabled();
            String access$11005 = HerePositioningClient.LOG_TAG;
            Log.d(access$11005, "onOptionsChanged, location services enabled: " + HerePositioningClient.this.mLocationServicesEnabled + " (was: " + access$1500 + ")");
            final PositioningClientListener access$1400 = HerePositioningClient.this.mPositioningClientListener;
            OptionsChangeHelper.onOptionsChanged(HerePositioningClient.this.mApplicationContext, new OptionsChangeHelper.Callbacks() {
                public void onAirplaneModeEnabled() {
                    Log.d(HerePositioningClient.LOG_TAG, "onAirplaneModeEnabled");
                    PositioningClientListener positioningClientListener = access$1400;
                    if (positioningClientListener != null) {
                        positioningClientListener.onOptionsChanged(PositioningClientListener.deviceSetting.AIRPLANEMODE, true);
                    }
                }

                public void onBluetoothLEDisabled() {
                    Log.d(HerePositioningClient.LOG_TAG, "onBluetoothLEDisabled");
                }

                public void onCellDisabled() {
                    Log.d(HerePositioningClient.LOG_TAG, "onCellDisabled");
                    PositioningClientListener positioningClientListener = access$1400;
                    if (positioningClientListener != null) {
                        positioningClientListener.onOptionsChanged(PositioningClientListener.deviceSetting.CELL, false);
                    }
                }

                public void onGnssLocationDisabled() {
                    Log.d(HerePositioningClient.LOG_TAG, "onGnssLocationDisabled");
                    PositioningClientListener positioningClientListener = access$1400;
                    if (positioningClientListener != null) {
                        positioningClientListener.onOptionsChanged(PositioningClientListener.deviceSetting.GNSS, false);
                    }
                }

                public void onNetworkLocationDisabled() {
                    Log.d(HerePositioningClient.LOG_TAG, "onNetworkLocationDisabled");
                    PositioningClientListener positioningClientListener = access$1400;
                    if (positioningClientListener != null) {
                        positioningClientListener.onOptionsChanged(PositioningClientListener.deviceSetting.NWLOCATION, false);
                    }
                }

                public void onWifiScansDisabled() {
                    Log.d(HerePositioningClient.LOG_TAG, "onWifiScansDisabled");
                    PositioningClientListener positioningClientListener = access$1400;
                    if (positioningClientListener != null) {
                        positioningClientListener.onOptionsChanged(PositioningClientListener.deviceSetting.WIFI, false);
                    }
                }
            }, optionsChangedEvent);
            if (access$1500 != HerePositioningClient.this.mLocationServicesEnabled && access$1400 != null) {
                access$1400.onLocationServicesStateChanged(HerePositioningClient.this.mLocationServicesEnabled);
            }
        }

        public void onOptionsRestored() {
            boolean access$1500 = HerePositioningClient.this.mLocationServicesEnabled;
            HerePositioningClient herePositioningClient = HerePositioningClient.this;
            boolean unused = herePositioningClient.mLocationServicesEnabled = herePositioningClient.isLocationServicesEnabled();
            String access$1100 = HerePositioningClient.LOG_TAG;
            Log.d(access$1100, "onOptionsRestored, location services enabled: " + HerePositioningClient.this.mLocationServicesEnabled + " (was: " + access$1500 + ")");
            PositioningClientListener access$1400 = HerePositioningClient.this.mPositioningClientListener;
            if (access$1500 != HerePositioningClient.this.mLocationServicesEnabled && access$1400 != null) {
                access$1400.onLocationServicesStateChanged(HerePositioningClient.this.mLocationServicesEnabled);
            }
        }
    }

    private HerePositioningClient(Context context, ConsentInternal consentInternal, FeatureChecker featureChecker, NetworkHolder networkHolder, String str) {
        this.mApplicationContext = context;
        this.mConsentInternal = consentInternal;
        this.mFeatureChecker = featureChecker;
        this.mNetworkHolder = networkHolder;
        this.mLastKnowLocationFilePath = str + "/lkl.enc";
    }

    private void connect() {
        Log.v(LOG_TAG, "connect");
        sdkCheckThat(!isConnected() && !isConnecting(), "connect error, already connecting");
        this.mConsentState = ConsentState.Unknown;
        this.mIsConnecting = true;
        this.mCurrentLocationAccuracy = null;
        this.mCurrentLocationOptions = null;
        this.mHereLocationApiClient.connect();
    }

    /* access modifiers changed from: private */
    public void disconnect() {
        String str = LOG_TAG;
        Log.v(str, "disconnect");
        if (isConnected()) {
            Log.v(str, "disconnect: isConnected true");
            this.mHereLocationApiClient.disconnect();
        }
        this.mIsConnecting = false;
        this.mCurrentLocationAccuracy = null;
        this.mCurrentLocationOptions = null;
        this.mHereLocationApiClient = null;
    }

    @NonNull
    public static HerePositioningClient fromSdkNativeEngine(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        return (HerePositioningClient) PositioningClientAndroid.fromSdkNativeEngine(sDKNativeEngine, new c(ConsentInternal.fromSdkNativeEngine(sDKNativeEngine)));
    }

    private void handleConsentStateUpdated() {
        if (isConnected()) {
            ConsentApi consentApi = ConsentServices.ConsentProvider;
            if (consentApi == null) {
                Log.e(LOG_TAG, "handleConsentStateUpdated: consent API not available?");
            } else {
                consentApi.onConsentUpdated(this.mHereLocationApiClient, this.mConsentState);
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleSetOfflineModeConnected(boolean z) {
        String str = LOG_TAG;
        Log.v(str, "handleSetOfflineModeConnected: " + z);
        this.mHereLocationApiClient.changeOptions(this.mGlobalOptions.setOfflineMode(z));
    }

    /* access modifiers changed from: private */
    public void initPositioningOptions(LocationOptions locationOptions) {
        this.mHybridPositioningOptions.setSmallestInterval(locationOptions.notificationOptions.smallestIntervalMilliseconds);
        this.mHybridPositioningOptions.setDesiredInterval(locationOptions.notificationOptions.desiredIntervalMilliseconds);
        this.mHybridPositioningOptions.setIgnoreAllDisabledFreeTechnologies(true);
        HybridLocationApi.GnssOptions gnssOptions = new HybridLocationApi.GnssOptions();
        HybridLocationApi.NetworkLocationOptions networkLocationOptions = new HybridLocationApi.NetworkLocationOptions();
        HybridLocationApi.SensorOptions sensorOptions = new HybridLocationApi.SensorOptions();
        gnssOptions.setEnabled(locationOptions.satellitePositioningOptions.enabled);
        gnssOptions.setHDGnssEnabled(locationOptions.satellitePositioningOptions.hdEnabled);
        networkLocationOptions.setWifiEnabled(locationOptions.wifiPositioningOptions.enabled);
        networkLocationOptions.setCellEnabled(locationOptions.cellularPositioningOptions.enabled);
        sensorOptions.setEnabled(locationOptions.sensorOptions.enabled);
        this.mHybridPositioningOptions.setNetworkLocationOptions(networkLocationOptions);
        this.mHybridPositioningOptions.setGnnsOptions(gnssOptions);
        this.mHybridPositioningOptions.setSensorOptions(sensorOptions);
    }

    private void initializeClient(@NonNull AuthData authData) {
        Log.i(LOG_TAG, "initializeClient");
        this.mGlobalOptions.setOfflineMode(this.mOfflineMode);
        this.mHereLocationApiClient = new HereLocationApiClient.Builder(this.mApplicationContext, this.mConnectionCallbacksListener).setOptions(this.mGlobalOptions).setSdkOptions(this.mNetworkHolder == null ? null : new HereLocationApiClient.SdkOptions().setHttpAdaptation(this.mNetworkHolder.getNetwork())).addApi(LocationServices.API).addApi(AuthServices.API).addApi(ConsentServices.API).setAuthData(authData).build();
    }

    /* access modifiers changed from: private */
    public boolean isConnected() {
        HereLocationApiClient hereLocationApiClient = this.mHereLocationApiClient;
        if (hereLocationApiClient != null) {
            return hereLocationApiClient.isConnected();
        }
        return false;
    }

    private boolean isConnecting() {
        return this.mIsConnecting;
    }

    /* access modifiers changed from: private */
    public boolean isLocationServicesEnabled() {
        return HereServicesUtil.isGpsLocationEnabled(this.mApplicationContext) || HereServicesUtil.isNetworkLocationEnabled(this.mApplicationContext);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ PositioningClientAndroid lambda$fromSdkNativeEngine$0(ConsentInternal consentInternal, Context context, FeatureChecker featureChecker, NetworkHolder networkHolder, String str) {
        return new HerePositioningClient(context, consentInternal, featureChecker, networkHolder, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshAuthenticationData$2(AtomicBoolean atomicBoolean, AuthData authData) {
        Log.i(LOG_TAG, "refreshAuthenticationData: refreshed");
        atomicBoolean.set(true);
        AuthServices.AuthProvider.setAuthData(this.mHereLocationApiClient, authData);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$subscribeForAuthenticationRequests$1() {
        Log.i(LOG_TAG, "subscribeForAuthenticationRequests: onAuthDataRequested listener. Calling refresh...");
        refreshAuthenticationData();
    }

    private Location readLastKnownLocation() {
        String str = this.mLastKnowLocationFilePath;
        Location location = null;
        String readLocation = str != null ? LocationEncryptFile.readLocation(str) : null;
        if (readLocation == null) {
            return null;
        }
        LocationSerializer locationSerializer = new LocationSerializer(readLocation);
        try {
            if (!locationSerializer.formatVersionIsSupported()) {
                return null;
            }
            Location location2 = new Location("network");
            try {
                location2.setLatitude(locationSerializer.getNextValueAsDouble());
                location2.setLongitude(locationSerializer.getNextValueAsDouble());
                location2.setTime(locationSerializer.getNextValueAsLong());
                if (locationSerializer.getNextValueAsBoolean()) {
                    location2.setAltitude(locationSerializer.getNextValueAsDouble());
                }
                if (locationSerializer.getNextValueAsBoolean()) {
                    location2.setBearing((float) locationSerializer.getNextValueAsDouble());
                }
                if (locationSerializer.getNextValueAsBoolean()) {
                    location2.setSpeed((float) locationSerializer.getNextValueAsDouble());
                }
                if (locationSerializer.getNextValueAsBoolean()) {
                    location2.setAccuracy((float) locationSerializer.getNextValueAsDouble());
                }
                if (locationSerializer.getNextValueAsBoolean()) {
                    location2.setVerticalAccuracyMeters((float) locationSerializer.getNextValueAsDouble());
                }
                if (locationSerializer.getNextValueAsBoolean()) {
                    location2.setBearingAccuracyDegrees((float) locationSerializer.getNextValueAsDouble());
                }
                if (locationSerializer.getNextValueAsBoolean()) {
                    location2.setSpeedAccuracyMetersPerSecond((float) locationSerializer.getNextValueAsDouble());
                }
                Bundle bundle = new Bundle();
                bundle.putLong(PositionEstimate.KEY_SOURCE, locationSerializer.getNextValueAsLong());
                bundle.putLong(PositionEstimate.KEY_TECHNOLOGY, locationSerializer.getNextValueAsLong());
                if (locationSerializer.getNextValueAsBoolean()) {
                    bundle.putLong(PositionEstimate.KEY_GNSS_TIME, locationSerializer.getNextValueAsLong());
                }
                location2.setExtras(bundle);
                return location2;
            } catch (NoSuchElementException unused) {
                location = location2;
                Log.d(LOG_TAG, "Failed to find LocationSerializeString value");
                return location;
            }
        } catch (NoSuchElementException unused2) {
            Log.d(LOG_TAG, "Failed to find LocationSerializeString value");
            return location;
        }
    }

    private void refreshAuthenticationData() {
        String str = LOG_TAG;
        Log.i(str, "refreshAuthenticationData");
        PositioningClientListener positioningClientListener = this.mPositioningClientListener;
        if (positioningClientListener == null) {
            Log.i(str, "refreshAuthenticationData: PositioningClientListener is null, ignored");
        } else {
            positioningClientListener.updateAuthentication(new a(this, new AtomicBoolean(false)));
        }
    }

    /* access modifiers changed from: private */
    public void saveLastKnownLocation(String str, Location location) {
        long j;
        long j2;
        if (location != null && str != null) {
            LocationSerializer addValue = new LocationSerializer().addValue(location.getLatitude()).addValue(location.getLongitude()).addValue(location.getTime());
            addValue.addValue(location.hasAltitude());
            if (location.hasAltitude()) {
                addValue.addValue(location.getAltitude());
            }
            addValue.addValue(location.hasBearing());
            if (location.hasBearing()) {
                addValue.addValue((double) location.getBearing());
            }
            addValue.addValue(location.hasSpeed());
            if (location.hasSpeed()) {
                addValue.addValue((double) location.getSpeed());
            }
            addValue.addValue(location.hasAccuracy());
            if (location.hasAccuracy()) {
                addValue.addValue((double) location.getAccuracy());
            }
            addValue.addValue(location.hasVerticalAccuracy());
            if (location.hasVerticalAccuracy()) {
                addValue.addValue((double) location.getVerticalAccuracyMeters());
            }
            addValue.addValue(location.hasBearingAccuracy());
            if (location.hasBearingAccuracy()) {
                addValue.addValue((double) location.getBearingAccuracyDegrees());
            }
            addValue.addValue(location.hasSpeedAccuracy());
            if (location.hasSpeedAccuracy()) {
                addValue.addValue((double) location.getSpeedAccuracyMetersPerSecond());
            }
            Bundle extras = location.getExtras();
            if (extras != null) {
                j2 = extras.getLong(PositionEstimate.KEY_SOURCE);
                j = extras.getLong(PositionEstimate.KEY_TECHNOLOGY);
            } else {
                j2 = 0;
                j = 0;
            }
            addValue.addValue(j2);
            addValue.addValue(j);
            Long gnssTime = LocationHelper.getGnssTime(location);
            if (gnssTime != null) {
                addValue.addValue(true);
                addValue.addValue(gnssTime.longValue());
            } else {
                addValue.addValue(false);
            }
            LocationEncryptFile.writeLocation(str, addValue.getString());
        }
    }

    public static void sdkCheckThat(boolean z, String str) {
        if (!z) {
            throw new RuntimeException(str);
        }
    }

    private void stopLocationUpdates() {
        sdkCheckThat(isConnected(), "Client must be non-null and connected");
        this.mLocationProvider.stopLocationUpdates();
        this.mCurrentLocationAccuracy = null;
        this.mCurrentLocationOptions = null;
    }

    /* access modifiers changed from: private */
    public void subscribeForAuthenticationRequests() {
        if (AuthServices.AuthProvider != null) {
            Log.i(LOG_TAG, "subscribeForAuthenticationRequests");
            AuthServices.AuthProvider.subscribe(this.mHereLocationApiClient, new b(this));
        }
    }

    public HereLocationApiClient.ConnectionCallbacks getConnectionCallbacksListener() {
        return this.mConnectionCallbacksListener;
    }

    @NonNull
    public FeatureChecker getFeatureChecker() {
        return (FeatureChecker) Preconditions.checkNotNull(this.mFeatureChecker);
    }

    @Nullable
    public Location getLastKnownLocation() {
        if (!this.mHasLastKnownLocationBeenInit) {
            this.mHasLastKnownLocationBeenInit = true;
            this.mLastKnownLocation = readLastKnownLocation();
        }
        return this.mLastKnownLocation;
    }

    @Nullable
    public LocationAccuracy getLocationAccuracy() {
        return this.mCurrentLocationAccuracy;
    }

    public LocationListener getLocationListener() {
        return this.mLocationListener;
    }

    @Nullable
    public LocationOptions getLocationOptions() {
        return this.mCurrentLocationOptions;
    }

    public boolean isReady() {
        return true;
    }

    public void onConsentUpdated(@NonNull ConsentFeature consentFeature, @NonNull com.here.sdk.consent.ConsentState consentState) {
        String str = LOG_TAG;
        Log.d(str, "onConsentUpdated: feature: " + consentFeature + ", state: " + consentState);
        if (consentFeature == ConsentFeature.POSITIONING_CONTRIBUTE) {
            ConsentState consentState2 = this.mConsentState;
            if (consentState == com.here.sdk.consent.ConsentState.GRANTED) {
                this.mConsentState = ConsentState.Granted;
            } else {
                this.mConsentState = ConsentState.Denied;
            }
            if (consentState2 != this.mConsentState) {
                handleConsentStateUpdated();
            }
        }
    }

    public synchronized void restart() {
        String str = LOG_TAG;
        Log.v(str, "restart");
        PositioningClientListener positioningClientListener = this.mPositioningClientListener;
        if (positioningClientListener == null) {
            Log.v(str, "restart: PositioningClientListener is null");
        } else if (isConnecting()) {
            Log.v(str, "Already connecting, options will be taken in use when connection completes");
        } else if (!isConnected()) {
            Log.v(str, "Not connected, restart() ignored.");
        } else {
            this.mLocationProvider.startLocationUpdates((LocationOptions) Preconditions.checkNotNull(positioningClientListener.getDesiredLocationOptions()));
        }
    }

    public void setCallListenerFromMainThreadEnabled(boolean z) {
        String str = LOG_TAG;
        Log.d(str, "setCallListenerFromMainThreadEnabled: " + z);
        this.mCallListenerFromMainThreadEnabled = z;
    }

    public void setHereLocationApiClient(HereLocationApiClient hereLocationApiClient) {
        this.mHereLocationApiClient = hereLocationApiClient;
    }

    public void setLocationProvider(LocationProvider locationProvider) {
        this.mLocationProvider = locationProvider;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setOfflineMode(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = LOG_TAG     // Catch:{ all -> 0x0022 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0022 }
            r1.<init>()     // Catch:{ all -> 0x0022 }
            java.lang.String r2 = "setOfflineMode: "
            r1.append(r2)     // Catch:{ all -> 0x0022 }
            r1.append(r4)     // Catch:{ all -> 0x0022 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0022 }
            android.util.Log.v(r0, r1)     // Catch:{ all -> 0x0022 }
            boolean r1 = r3.mOfflineMode     // Catch:{ all -> 0x0022 }
            if (r4 != r1) goto L_0x0024
            java.lang.String r4 = "setOfflineMode: requested mode already set, ignored"
            android.util.Log.v(r0, r4)     // Catch:{ all -> 0x0022 }
            monitor-exit(r3)
            return
        L_0x0022:
            r4 = move-exception
            goto L_0x0033
        L_0x0024:
            r3.mOfflineMode = r4     // Catch:{ all -> 0x0022 }
            boolean r4 = r3.isConnected()     // Catch:{ all -> 0x0022 }
            if (r4 == 0) goto L_0x0031
            boolean r4 = r3.mOfflineMode     // Catch:{ all -> 0x0022 }
            r3.handleSetOfflineModeConnected(r4)     // Catch:{ all -> 0x0022 }
        L_0x0031:
            monitor-exit(r3)
            return
        L_0x0033:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.sdk.location.HerePositioningClient.setOfflineMode(boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean start(@androidx.annotation.NonNull com.here.sdk.location.PositioningClientListener r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = LOG_TAG     // Catch:{ all -> 0x0018 }
            java.lang.String r1 = "start"
            android.util.Log.v(r0, r1)     // Catch:{ all -> 0x0018 }
            boolean r1 = r4.isLocationServicesEnabled()     // Catch:{ all -> 0x0018 }
            r4.mLocationServicesEnabled = r1     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x001a
            com.here.sdk.location.LocationEngineStatus r0 = com.here.sdk.location.LocationEngineStatus.LOCATION_SERVICES_DISABLED     // Catch:{ all -> 0x0018 }
            r5.onClientFailedToStart(r0)     // Catch:{ all -> 0x0018 }
            monitor-exit(r4)
            r4 = 0
            return r4
        L_0x0018:
            r5 = move-exception
            goto L_0x0077
        L_0x001a:
            boolean r1 = r4.isConnected()     // Catch:{ all -> 0x0018 }
            r2 = 1
            if (r1 != 0) goto L_0x005f
            boolean r3 = r4.isConnecting()     // Catch:{ all -> 0x0018 }
            if (r3 == 0) goto L_0x0028
            goto L_0x005f
        L_0x0028:
            r4.mPositioningClientListener = r5     // Catch:{ all -> 0x0018 }
            com.here.services.HereLocationApiClient r5 = r4.mHereLocationApiClient     // Catch:{ all -> 0x0018 }
            if (r5 != 0) goto L_0x003b
            java.lang.String r5 = "start: mHereLocationApiClient is null, initializing client"
            android.util.Log.v(r0, r5)     // Catch:{ all -> 0x0018 }
            com.here.posclient.auth.AuthData r5 = new com.here.posclient.auth.AuthData     // Catch:{ all -> 0x0018 }
            r5.<init>()     // Catch:{ all -> 0x0018 }
            r4.initializeClient(r5)     // Catch:{ all -> 0x0018 }
        L_0x003b:
            com.here.sdk.location.HerePositioningClient$2 r5 = new com.here.sdk.location.HerePositioningClient$2     // Catch:{ all -> 0x0018 }
            r5.<init>()     // Catch:{ all -> 0x0018 }
            r4.mNetworkCallback = r5     // Catch:{ all -> 0x0018 }
            android.content.Context r5 = r4.mApplicationContext     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = "connectivity"
            java.lang.Object r5 = r5.getSystemService(r0)     // Catch:{ all -> 0x0018 }
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch:{ all -> 0x0018 }
            android.net.NetworkRequest$Builder r0 = new android.net.NetworkRequest$Builder     // Catch:{ all -> 0x0018 }
            r0.<init>()     // Catch:{ all -> 0x0018 }
            android.net.NetworkRequest r0 = r0.build()     // Catch:{ all -> 0x0018 }
            android.net.ConnectivityManager$NetworkCallback r1 = r4.mNetworkCallback     // Catch:{ all -> 0x0018 }
            r5.registerNetworkCallback(r0, r1)     // Catch:{ all -> 0x0018 }
            r4.connect()     // Catch:{ all -> 0x0018 }
            monitor-exit(r4)
            return r2
        L_0x005f:
            if (r1 == 0) goto L_0x0070
            com.here.sdk.location.PositioningClientListener r1 = r4.mPositioningClientListener     // Catch:{ all -> 0x0018 }
            if (r5 == r1) goto L_0x0070
            java.lang.String r1 = "start: stale client, reconfiguring"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0018 }
            r4.mPositioningClientListener = r5     // Catch:{ all -> 0x0018 }
            r4.restart()     // Catch:{ all -> 0x0018 }
            goto L_0x0075
        L_0x0070:
            com.here.sdk.location.LocationEngineStatus r0 = com.here.sdk.location.LocationEngineStatus.ALREADY_STARTED     // Catch:{ all -> 0x0018 }
            r5.onClientFailedToStart(r0)     // Catch:{ all -> 0x0018 }
        L_0x0075:
            monitor-exit(r4)
            return r2
        L_0x0077:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.sdk.location.HerePositioningClient.start(com.here.sdk.location.PositioningClientListener):boolean");
    }

    public synchronized void stop() {
        try {
            if (this.mIsConnecting) {
                this.mIsStopRequested = true;
            } else {
                if (isConnected()) {
                    stopLocationUpdates();
                }
                disconnect();
            }
            if (this.mNetworkCallback != null) {
                ((ConnectivityManager) this.mApplicationContext.getSystemService("connectivity")).unregisterNetworkCallback(this.mNetworkCallback);
                this.mNetworkCallback = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static class LocationSerializer {
        private final String FORMAT_VALUE_SEPARATOR;
        private final String FORMAT_VERSION;
        private String mSerializeString;
        StringTokenizer mTokenizer;

        public LocationSerializer() {
            this.FORMAT_VERSION = "1";
            this.FORMAT_VALUE_SEPARATOR = MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA;
            this.mSerializeString = "1";
            addValueSeparator();
        }

        private void addValueSeparator() {
            this.mSerializeString += MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA;
        }

        public LocationSerializer addValue(double d) {
            this.mSerializeString += d;
            addValueSeparator();
            return this;
        }

        public boolean formatVersionIsSupported() throws NoSuchElementException {
            return this.mTokenizer.nextToken().equals("1");
        }

        public boolean getNextValueAsBoolean() throws NoSuchElementException {
            return Boolean.parseBoolean(this.mTokenizer.nextToken());
        }

        public double getNextValueAsDouble() throws NoSuchElementException {
            return Double.parseDouble(this.mTokenizer.nextToken());
        }

        public long getNextValueAsLong() throws NoSuchElementException {
            return Long.parseLong(this.mTokenizer.nextToken());
        }

        public String getString() {
            return this.mSerializeString;
        }

        public LocationSerializer addValue(long j) {
            this.mSerializeString += j;
            addValueSeparator();
            return this;
        }

        public LocationSerializer addValue(boolean z) {
            this.mSerializeString += z;
            addValueSeparator();
            return this;
        }

        public LocationSerializer(String str) {
            this.FORMAT_VERSION = "1";
            this.FORMAT_VALUE_SEPARATOR = MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA;
            this.mSerializeString = str;
            this.mTokenizer = new StringTokenizer(this.mSerializeString, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        }
    }

    public HerePositioningClient(Context context, ConsentInternal consentInternal) {
        this.mConsentInternal = consentInternal;
        this.mApplicationContext = context;
    }
}
