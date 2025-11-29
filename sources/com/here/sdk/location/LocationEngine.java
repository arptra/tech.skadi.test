package com.here.sdk.location;

import android.location.Location;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.posclient.auth.AuthData;
import com.here.sdk.consent.ConsentInternal;
import com.here.sdk.consent.ConsentState;
import com.here.sdk.core.Authentication;
import com.here.sdk.core.AuthenticationData;
import com.here.sdk.core.AuthenticationError;
import com.here.sdk.core.AuthenticationException;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.LocationListener;
import com.here.sdk.core.LocationTechnology;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorCode;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.core.threading.Threading;
import com.here.sdk.core.utilities.Preconditions;
import com.here.sdk.location.FeatureChecker;
import com.here.sdk.location.PositioningClientListener;
import com.here.services.common.Types;
import com.here.services.location.util.LocationHelper;
import com.here.time.Duration;
import com.honey.account.a2.a;
import com.honey.account.a2.b;
import com.honey.account.a2.c;
import com.honey.account.a2.d;
import com.honey.account.constant.AccountConstantKt;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LocationEngine implements LocationEngineBase {
    private static final int AUTHENTICATION_FAILED = 3;
    /* access modifiers changed from: private */
    public static final String LOG_TAG = "LocationEngine";
    private static final int NETWORK_ERROR = 2;
    private static final double WIFI_MIN_ACCURACY = 300.0d;
    /* access modifiers changed from: private */
    public final Set<LocationIssueType> mAddedLocationIssues;
    /* access modifiers changed from: private */
    public boolean mCallListenerFromMainThreadEnabled;
    private final ConsentInternal mConsentInternal;
    /* access modifiers changed from: private */
    public PositioningClient mHerePositioningClient;
    /* access modifiers changed from: private */
    public final Object mInstanceLock;
    private boolean mIsRestarted;
    /* access modifiers changed from: private */
    public boolean mIsStarted;
    /* access modifiers changed from: private */
    public final ArrayList<LocationIssueListener> mIssueListeners;
    /* access modifiers changed from: private */
    public final ArrayList<LocationListener> mLocationListeners;
    /* access modifiers changed from: private */
    public final ArrayList<LocationFeature> mLocationNonAvailableFeatures;
    /* access modifiers changed from: private */
    public List<LocationIssueType> mNativeLocationIssues;
    /* access modifiers changed from: private */
    public final PositioningClientListener mPositioningClientListener;
    /* access modifiers changed from: private */
    public final SatellitePositioningOptions mRequestedSatelliteOptions;
    /* access modifiers changed from: private */
    public final SDKNativeEngine mSDKEngine;
    /* access modifiers changed from: private */
    public final ArrayList<LocationStatusListener> mStatusListeners;

    /* renamed from: com.here.sdk.location.LocationEngine$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$here$sdk$core$AuthenticationError;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.here.sdk.core.AuthenticationError[] r0 = com.here.sdk.core.AuthenticationError.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$sdk$core$AuthenticationError = r0
                com.here.sdk.core.AuthenticationError r1 = com.here.sdk.core.AuthenticationError.INVALID_PARAMETER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$here$sdk$core$AuthenticationError     // Catch:{ NoSuchFieldError -> 0x001d }
                com.here.sdk.core.AuthenticationError r1 = com.here.sdk.core.AuthenticationError.AUTHENTICATION_FAILED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$here$sdk$core$AuthenticationError     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.here.sdk.core.AuthenticationError r1 = com.here.sdk.core.AuthenticationError.NO_CONNECTION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.sdk.location.LocationEngine.AnonymousClass1.<clinit>():void");
        }
    }

    public LocationEngine() throws InstantiationErrorException {
        this(sharedSdkEngineOrException());
    }

    private void addLocationIssue(LocationIssueType locationIssueType) {
        String str = LOG_TAG;
        Log.d(str, "addLocationIssue: " + locationIssueType.toString());
        ArrayList arrayList = new ArrayList();
        synchronized (this.mInstanceLock) {
            arrayList.addAll(this.mIssueListeners);
            this.mAddedLocationIssues.add(locationIssueType);
        }
        if (this.mCallListenerFromMainThreadEnabled) {
            Threading.getPlatformThreading().runOnMainThread(new c(this, arrayList));
        } else {
            lambda$addLocationIssue$2(arrayList);
        }
    }

    private boolean ensureConsentHandled() {
        if (this.mConsentInternal.getConsentState() != ConsentState.UNKNOWN) {
            return true;
        }
        Log.d(LOG_TAG, "ensureConsentHandled: user consent not handled");
        updateStatus(LocationEngineStatus.USER_CONSENT_NOT_HANDLED, false);
        return false;
    }

    private static LocationTechnology getTechnology(Location location) {
        if (location == null) {
            return null;
        }
        EnumSet<Types.Source> sources = LocationHelper.getSources(location);
        EnumSet<Types.Technology> technologies = LocationHelper.getTechnologies(location);
        boolean z = technologies.contains(Types.Technology.Cell) || technologies.contains(Types.Technology.Cellular) || technologies.contains(Types.Technology.ECell) || technologies.contains(Types.Technology.Country) || technologies.contains(Types.Technology.System) || technologies.contains(Types.Technology.Network) || technologies.contains(Types.Technology.LocationArea) || technologies.contains(Types.Technology.Rnc) || technologies.contains(Types.Technology.ENodeB) || technologies.contains(Types.Technology.TrackingArea);
        if (sources.contains(Types.Source.HDGnss)) {
            return LocationTechnology.HD_GNSS;
        }
        if (sources.contains(Types.Source.Hardware)) {
            return LocationTechnology.GNSS;
        }
        Types.Technology technology = Types.Technology.Wlan;
        if (technologies.contains(technology) && !z) {
            return LocationTechnology.WIFI;
        }
        if (technologies.contains(technology) && location.hasAccuracy() && ((double) location.getAccuracy()) < WIFI_MIN_ACCURACY) {
            return LocationTechnology.WIFI;
        }
        if (z) {
            return LocationTechnology.CELLULAR;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$makeAuthorizationListener$3(boolean z, LocationFeature locationFeature, boolean z2, int i) {
        String str = LOG_TAG;
        Log.d(str, "Authorization for feature " + locationFeature + AccountConstantKt.CODE_SEPARTOR + z2 + ", restart:" + z);
        LocationFeature locationFeature2 = LocationFeature.HD_GNSS_POSITIONING;
        if (locationFeature != locationFeature2) {
            return;
        }
        if (z2) {
            startClient(z);
            updateFeatureStatus(locationFeature2, false);
            return;
        }
        synchronized (this.mInstanceLock) {
            try {
                LocationOptions desiredLocationOptions = this.mPositioningClientListener.getDesiredLocationOptions();
                if (desiredLocationOptions != null) {
                    updateFeatureStatus(locationFeature2, true);
                    desiredLocationOptions.satellitePositioningOptions.hdEnabled = false;
                    this.mPositioningClientListener.setDesiredLocationOptions(desiredLocationOptions);
                    startClient(z);
                    if (i != 2) {
                        if (i != 3) {
                            addLocationIssue(LocationIssueType.FEATURE_NOT_LICENSED);
                        }
                    }
                    addLocationIssue(LocationIssueType.HDGNSS_CONNECTION_NOT_AVAILABLE);
                } else {
                    Log.e(str, "Failed to retrieve desired location options");
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateFeatureStatus$1(ArrayList arrayList) {
        updateFeatureNotAvailableStatus(this.mLocationNonAvailableFeatures, arrayList);
    }

    public static com.here.sdk.core.Location locationFromAndroidLocation(Location location) {
        GeoCoordinates geoCoordinates = location.hasAltitude() ? new GeoCoordinates(location.getLatitude(), location.getLongitude(), location.getAltitude()) : new GeoCoordinates(location.getLatitude(), location.getLongitude());
        Duration ofMillis = Duration.ofMillis(TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos()));
        com.here.sdk.core.Location location2 = new com.here.sdk.core.Location(geoCoordinates);
        location2.time = new Date(location.getTime());
        location2.timestampSinceBoot = ofMillis;
        if (location.hasBearing()) {
            location2.bearingInDegrees = Double.valueOf((double) location.getBearing());
        }
        if (location.hasSpeed()) {
            location2.speedInMetersPerSecond = Double.valueOf((double) location.getSpeed());
        }
        if (location.hasAccuracy()) {
            location2.horizontalAccuracyInMeters = Double.valueOf((double) location.getAccuracy());
        }
        if (location.hasVerticalAccuracy()) {
            location2.verticalAccuracyInMeters = Double.valueOf((double) location.getVerticalAccuracyMeters());
        }
        if (location.hasBearingAccuracy()) {
            location2.bearingAccuracyInDegrees = Double.valueOf((double) location.getBearingAccuracyDegrees());
        }
        if (location.hasSpeedAccuracy()) {
            location2.speedAccuracyInMetersPerSecond = Double.valueOf((double) location.getSpeedAccuracyMetersPerSecond());
        }
        LocationTechnology technology = getTechnology(location);
        if (technology != null) {
            location2.locationTechnology = technology;
        }
        Long gnssTime = LocationHelper.getGnssTime(location);
        if (gnssTime != null) {
            location2.gnssTime = Duration.ofMillis(gnssTime.longValue());
        }
        return location2;
    }

    /* access modifiers changed from: private */
    @NonNull
    public FeatureChecker.AuthorizationCallback makeAuthorizationListener(boolean z) {
        return new d(this, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0052, code lost:
        if (r5 == com.here.sdk.location.LocationAccuracy.SUB_METER_NAVIGATION) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        if (r4.satellitePositioningOptions.hdEnabled == false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005b, code lost:
        r3.mHerePositioningClient.restart();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0065, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 31) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
        addLocationIssue(com.here.sdk.location.LocationIssueType.HDGNSS_OS_VERSION_NOT_SUPPORTED);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
        r3.mHerePositioningClient.getFeatureChecker().checkFeatureAuthorization(com.here.sdk.location.LocationFeature.HD_GNSS_POSITIONING, makeAuthorizationListener(true));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007b, code lost:
        r4 = com.here.sdk.location.LocationEngineStatus.OK;
        updateStatus(r4, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0080, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.here.sdk.location.LocationEngineStatus restartPositioning(@androidx.annotation.NonNull com.here.sdk.location.LocationOptions r4, @androidx.annotation.Nullable com.here.sdk.location.LocationAccuracy r5) {
        /*
            r3 = this;
            boolean r0 = r3.ensureConsentHandled()
            if (r0 != 0) goto L_0x0009
            com.here.sdk.location.LocationEngineStatus r3 = com.here.sdk.location.LocationEngineStatus.USER_CONSENT_NOT_HANDLED
            return r3
        L_0x0009:
            java.lang.Object r0 = r3.mInstanceLock
            monitor-enter(r0)
            java.util.Set<com.here.sdk.location.LocationIssueType> r1 = r3.mAddedLocationIssues     // Catch:{ all -> 0x002c }
            r1.clear()     // Catch:{ all -> 0x002c }
            com.here.sdk.location.SatellitePositioningOptions r1 = r3.mRequestedSatelliteOptions     // Catch:{ all -> 0x002c }
            com.here.sdk.location.SatellitePositioningOptions r2 = r4.satellitePositioningOptions     // Catch:{ all -> 0x002c }
            boolean r2 = r2.hdEnabled     // Catch:{ all -> 0x002c }
            r1.hdEnabled = r2     // Catch:{ all -> 0x002c }
            boolean r1 = r3.mIsStarted     // Catch:{ all -> 0x002c }
            r2 = 0
            if (r1 != 0) goto L_0x002e
            java.lang.String r4 = LOG_TAG     // Catch:{ all -> 0x002c }
            java.lang.String r5 = "restartPositioning: not ready, engine not started"
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x002c }
            com.here.sdk.location.LocationEngineStatus r4 = com.here.sdk.location.LocationEngineStatus.NOT_READY     // Catch:{ all -> 0x002c }
            r3.updateStatus(r4, r2)     // Catch:{ all -> 0x002c }
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return r4
        L_0x002c:
            r3 = move-exception
            goto L_0x0081
        L_0x002e:
            com.here.sdk.location.PositioningClient r1 = r3.mHerePositioningClient     // Catch:{ all -> 0x002c }
            boolean r1 = r1.isReady()     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x0044
            java.lang.String r4 = LOG_TAG     // Catch:{ all -> 0x002c }
            java.lang.String r5 = "restartPositioning: here positioning client still fetching last known location"
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x002c }
            com.here.sdk.location.LocationEngineStatus r4 = com.here.sdk.location.LocationEngineStatus.START_FAILED     // Catch:{ all -> 0x002c }
            r3.updateStatus(r4, r2)     // Catch:{ all -> 0x002c }
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return r4
        L_0x0044:
            com.here.sdk.location.PositioningClientListener r1 = r3.mPositioningClientListener     // Catch:{ all -> 0x002c }
            r1.setDesiredLocationAccuracy(r5)     // Catch:{ all -> 0x002c }
            com.here.sdk.location.PositioningClientListener r1 = r3.mPositioningClientListener     // Catch:{ all -> 0x002c }
            r1.setDesiredLocationOptions(r4)     // Catch:{ all -> 0x002c }
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            com.here.sdk.location.LocationAccuracy r0 = com.here.sdk.location.LocationAccuracy.SUB_METER_NAVIGATION
            r1 = 1
            if (r5 == r0) goto L_0x0061
            com.here.sdk.location.SatellitePositioningOptions r4 = r4.satellitePositioningOptions
            boolean r4 = r4.hdEnabled
            if (r4 == 0) goto L_0x005b
            goto L_0x0061
        L_0x005b:
            com.here.sdk.location.PositioningClient r4 = r3.mHerePositioningClient
            r4.restart()
            goto L_0x007b
        L_0x0061:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 31
            if (r4 >= r5) goto L_0x006c
            com.here.sdk.location.LocationIssueType r4 = com.here.sdk.location.LocationIssueType.HDGNSS_OS_VERSION_NOT_SUPPORTED
            r3.addLocationIssue(r4)
        L_0x006c:
            com.here.sdk.location.PositioningClient r4 = r3.mHerePositioningClient
            com.here.sdk.location.FeatureChecker r4 = r4.getFeatureChecker()
            com.here.sdk.location.LocationFeature r5 = com.here.sdk.location.LocationFeature.HD_GNSS_POSITIONING
            com.here.sdk.location.FeatureChecker$AuthorizationCallback r0 = r3.makeAuthorizationListener(r1)
            r4.checkFeatureAuthorization(r5, r0)
        L_0x007b:
            com.here.sdk.location.LocationEngineStatus r4 = com.here.sdk.location.LocationEngineStatus.OK
            r3.updateStatus(r4, r1)
            return r4
        L_0x0081:
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.sdk.location.LocationEngine.restartPositioning(com.here.sdk.location.LocationOptions, com.here.sdk.location.LocationAccuracy):com.here.sdk.location.LocationEngineStatus");
    }

    @NonNull
    private static SDKNativeEngine sharedSdkEngineOrException() throws InstantiationErrorException {
        SDKNativeEngine sharedInstance = SDKNativeEngine.getSharedInstance();
        if (sharedInstance != null) {
            return sharedInstance;
        }
        throw new InstantiationErrorException(InstantiationErrorCode.SHARED_SDK_ENGINE_NOT_INSTANTIATED);
    }

    private synchronized LocationEngineStatus startClient(boolean z) {
        if (z) {
            if (!this.mIsStarted) {
                Log.d(LOG_TAG, "restart: not ready, engine not started");
                LocationEngineStatus locationEngineStatus = LocationEngineStatus.NOT_READY;
                updateStatus(locationEngineStatus, false);
                return locationEngineStatus;
            } else if (!this.mHerePositioningClient.isReady()) {
                Log.d(LOG_TAG, "restart: here positioning client still fetching last known location");
                LocationEngineStatus locationEngineStatus2 = LocationEngineStatus.START_FAILED;
                updateStatus(locationEngineStatus2, false);
                return locationEngineStatus2;
            } else {
                this.mHerePositioningClient.restart();
                return LocationEngineStatus.OK;
            }
        } else if (this.mIsStarted) {
            Log.d(LOG_TAG, "start: engine is already started");
            LocationEngineStatus locationEngineStatus3 = LocationEngineStatus.ALREADY_STARTED;
            updateStatus(locationEngineStatus3, true);
            return locationEngineStatus3;
        } else {
            boolean start = this.mHerePositioningClient.start(this.mPositioningClientListener);
            this.mIsStarted = start;
            if (!start) {
                return LocationEngineStatus.START_FAILED;
            }
            return LocationEngineStatus.OK;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5 == com.here.sdk.location.LocationAccuracy.SUB_METER_NAVIGATION) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (r4.satellitePositioningOptions.hdEnabled == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        return startClient(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 31) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        addLocationIssue(com.here.sdk.location.LocationIssueType.HDGNSS_OS_VERSION_NOT_SUPPORTED);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0066, code lost:
        r3.mHerePositioningClient.getFeatureChecker().checkFeatureAuthorization(com.here.sdk.location.LocationFeature.HD_GNSS_POSITIONING, makeAuthorizationListener(false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
        return com.here.sdk.location.LocationEngineStatus.ENGINE_STARTED;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.here.sdk.location.LocationEngineStatus startPositioning(@androidx.annotation.NonNull com.here.sdk.location.LocationOptions r4, @androidx.annotation.Nullable com.here.sdk.location.LocationAccuracy r5) {
        /*
            r3 = this;
            boolean r0 = r3.ensureConsentHandled()
            if (r0 != 0) goto L_0x0009
            com.here.sdk.location.LocationEngineStatus r3 = com.here.sdk.location.LocationEngineStatus.USER_CONSENT_NOT_HANDLED
            return r3
        L_0x0009:
            java.lang.Object r0 = r3.mInstanceLock
            monitor-enter(r0)
            com.here.sdk.location.SatellitePositioningOptions r1 = r3.mRequestedSatelliteOptions     // Catch:{ all -> 0x0027 }
            com.here.sdk.location.SatellitePositioningOptions r2 = r4.satellitePositioningOptions     // Catch:{ all -> 0x0027 }
            boolean r2 = r2.hdEnabled     // Catch:{ all -> 0x0027 }
            r1.hdEnabled = r2     // Catch:{ all -> 0x0027 }
            boolean r1 = r3.mIsStarted     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0029
            java.lang.String r4 = LOG_TAG     // Catch:{ all -> 0x0027 }
            java.lang.String r5 = "start: engine is already started"
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x0027 }
            com.here.sdk.location.LocationEngineStatus r4 = com.here.sdk.location.LocationEngineStatus.ALREADY_STARTED     // Catch:{ all -> 0x0027 }
            r5 = 1
            r3.updateStatus(r4, r5)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return r4
        L_0x0027:
            r3 = move-exception
            goto L_0x0078
        L_0x0029:
            com.here.sdk.location.PositioningClient r1 = r3.mHerePositioningClient     // Catch:{ all -> 0x0027 }
            boolean r1 = r1.isReady()     // Catch:{ all -> 0x0027 }
            r2 = 0
            if (r1 != 0) goto L_0x0040
            java.lang.String r4 = LOG_TAG     // Catch:{ all -> 0x0027 }
            java.lang.String r5 = "start: here positioning client still fetching last known location"
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x0027 }
            com.here.sdk.location.LocationEngineStatus r4 = com.here.sdk.location.LocationEngineStatus.START_FAILED     // Catch:{ all -> 0x0027 }
            r3.updateStatus(r4, r2)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return r4
        L_0x0040:
            com.here.sdk.location.PositioningClientListener r1 = r3.mPositioningClientListener     // Catch:{ all -> 0x0027 }
            r1.setDesiredLocationAccuracy(r5)     // Catch:{ all -> 0x0027 }
            com.here.sdk.location.PositioningClientListener r1 = r3.mPositioningClientListener     // Catch:{ all -> 0x0027 }
            r1.setDesiredLocationOptions(r4)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            com.here.sdk.location.LocationAccuracy r0 = com.here.sdk.location.LocationAccuracy.SUB_METER_NAVIGATION
            if (r5 == r0) goto L_0x005b
            com.here.sdk.location.SatellitePositioningOptions r4 = r4.satellitePositioningOptions
            boolean r4 = r4.hdEnabled
            if (r4 == 0) goto L_0x0056
            goto L_0x005b
        L_0x0056:
            com.here.sdk.location.LocationEngineStatus r3 = r3.startClient(r2)
            return r3
        L_0x005b:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 31
            if (r4 >= r5) goto L_0x0066
            com.here.sdk.location.LocationIssueType r4 = com.here.sdk.location.LocationIssueType.HDGNSS_OS_VERSION_NOT_SUPPORTED
            r3.addLocationIssue(r4)
        L_0x0066:
            com.here.sdk.location.PositioningClient r4 = r3.mHerePositioningClient
            com.here.sdk.location.FeatureChecker r4 = r4.getFeatureChecker()
            com.here.sdk.location.LocationFeature r5 = com.here.sdk.location.LocationFeature.HD_GNSS_POSITIONING
            com.here.sdk.location.FeatureChecker$AuthorizationCallback r3 = r3.makeAuthorizationListener(r2)
            r4.checkFeatureAuthorization(r5, r3)
            com.here.sdk.location.LocationEngineStatus r3 = com.here.sdk.location.LocationEngineStatus.ENGINE_STARTED
            return r3
        L_0x0078:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.sdk.location.LocationEngine.startPositioning(com.here.sdk.location.LocationOptions, com.here.sdk.location.LocationAccuracy):com.here.sdk.location.LocationEngineStatus");
    }

    /* access modifiers changed from: private */
    public void updateFeatureNotAvailableStatus(@NonNull List<LocationFeature> list, ArrayList<LocationStatusListener> arrayList) {
        Iterator<LocationStatusListener> it = arrayList.iterator();
        while (it.hasNext()) {
            Log.d(LOG_TAG, "updateFeatureNotAvailableStatus");
            it.next().onFeaturesNotAvailable(list);
        }
    }

    private void updateFeatureStatus(LocationFeature locationFeature, boolean z) {
        String str = LOG_TAG;
        Log.d(str, "updateFeatureStatus: " + locationFeature.toString());
        ArrayList arrayList = new ArrayList();
        new ArrayList().add(locationFeature);
        synchronized (this.mInstanceLock) {
            if (z) {
                try {
                    this.mLocationNonAvailableFeatures.add(locationFeature);
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            } else if (this.mLocationNonAvailableFeatures.contains(locationFeature)) {
                this.mLocationNonAvailableFeatures.remove(locationFeature);
            }
            arrayList.addAll(this.mStatusListeners);
        }
        if (this.mCallListenerFromMainThreadEnabled) {
            Threading.getPlatformThreading().runOnMainThread(new a(this, arrayList));
        } else {
            updateFeatureNotAvailableStatus(this.mLocationNonAvailableFeatures, arrayList);
        }
    }

    /* access modifiers changed from: private */
    public void updateLocation(@NonNull com.here.sdk.core.Location location, ArrayList<LocationListener> arrayList) {
        Iterator<LocationListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onLocationUpdated(location);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateLocationEngineStatus */
    public void lambda$updateStatus$0(@NonNull LocationEngineStatus locationEngineStatus, ArrayList<LocationStatusListener> arrayList) {
        Iterator<LocationStatusListener> it = arrayList.iterator();
        while (it.hasNext()) {
            String str = LOG_TAG;
            Log.d(str, "updateLocationEngineStatus: " + locationEngineStatus);
            it.next().onStatusChanged(locationEngineStatus);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateLocationIssues */
    public void lambda$addLocationIssue$2(ArrayList<LocationIssueListener> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        synchronized (this.mInstanceLock) {
            try {
                arrayList2.addAll(this.mNativeLocationIssues);
                for (LocationIssueType next : this.mAddedLocationIssues) {
                    if (!arrayList2.contains(next)) {
                        arrayList2.add(next);
                    }
                }
            } finally {
                while (true) {
                }
            }
        }
        Iterator<LocationIssueListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onLocationIssueChanged(arrayList2);
        }
    }

    /* access modifiers changed from: private */
    public void updateStatus(LocationEngineStatus locationEngineStatus, boolean z) {
        String str = LOG_TAG;
        Log.d(str, "updateStatus: " + locationEngineStatus.toString() + " isStarted: " + z);
        ArrayList arrayList = new ArrayList();
        synchronized (this.mInstanceLock) {
            this.mIsStarted = z;
            arrayList.addAll(this.mStatusListeners);
        }
        if (this.mCallListenerFromMainThreadEnabled) {
            Threading.getPlatformThreading().runOnMainThread(new b(this, locationEngineStatus, arrayList));
        } else {
            lambda$updateStatus$0(locationEngineStatus, arrayList);
        }
    }

    public void addLocationIssueListener(@NonNull LocationIssueListener locationIssueListener) {
        Preconditions.checkArgumentNotNull(locationIssueListener, "listener cannot be null");
        synchronized (this.mInstanceLock) {
            try {
                if (!this.mIssueListeners.contains(locationIssueListener)) {
                    this.mIssueListeners.add(locationIssueListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addLocationListener(@NonNull LocationListener locationListener) {
        Preconditions.checkArgumentNotNull(locationListener, "listener cannot be null");
        synchronized (this.mInstanceLock) {
            try {
                if (!this.mLocationListeners.contains(locationListener)) {
                    this.mLocationListeners.add(locationListener);
                    String str = LOG_TAG;
                    Log.v(str, "addLocationListener: listener added, total: " + this.mLocationListeners.size());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addLocationStatusListener(@NonNull LocationStatusListener locationStatusListener) {
        Preconditions.checkArgumentNotNull(locationStatusListener, "listener cannot be null");
        synchronized (this.mInstanceLock) {
            try {
                if (!this.mStatusListeners.contains(locationStatusListener)) {
                    this.mStatusListeners.add(locationStatusListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public com.here.sdk.core.Location getLastKnownLocation() {
        Location lastKnownLocation = this.mHerePositioningClient.getLastKnownLocation();
        if (lastKnownLocation != null) {
            return locationFromAndroidLocation(lastKnownLocation);
        }
        return null;
    }

    public boolean isStarted() {
        return this.mIsStarted;
    }

    public void removeLocationIssueListener(@NonNull LocationIssueListener locationIssueListener) {
        Preconditions.checkArgumentNotNull(locationIssueListener, "listener cannot be null");
        synchronized (this.mInstanceLock) {
            this.mIssueListeners.remove(locationIssueListener);
        }
    }

    public void removeLocationListener(@NonNull LocationListener locationListener) {
        Preconditions.checkArgumentNotNull(locationListener, "listener cannot be null");
        synchronized (this.mInstanceLock) {
            this.mLocationListeners.remove(locationListener);
            String str = LOG_TAG;
            Log.v(str, "removeLocationListener: listener removed, total: " + this.mLocationListeners.size());
        }
    }

    public void removeLocationStatusListener(@NonNull LocationStatusListener locationStatusListener) {
        Preconditions.checkArgumentNotNull(locationStatusListener, "listener cannot be null");
        synchronized (this.mInstanceLock) {
            this.mStatusListeners.remove(locationStatusListener);
        }
    }

    public void setCallListenerFromMainThreadEnabled(boolean z) {
        String str = LOG_TAG;
        Log.d(str, "setCallListenerFromMainThreadEnabled: " + z);
        this.mCallListenerFromMainThreadEnabled = z;
        PositioningClient positioningClient = this.mHerePositioningClient;
        if (positioningClient != null) {
            positioningClient.setCallListenerFromMainThreadEnabled(z);
        }
    }

    public synchronized void setHerePositioningClient(@NonNull PositioningClient positioningClient) {
        Preconditions.checkArgumentNotNull(positioningClient, "Specified client cannot be null");
        this.mHerePositioningClient = positioningClient;
    }

    @NonNull
    public LocationEngineStatus start(@NonNull LocationAccuracy locationAccuracy) {
        Preconditions.checkArgumentNotNull(locationAccuracy, "locationAccuracy cannot be null");
        String str = LOG_TAG;
        Log.d(str, "start, locationAccuracy is: " + locationAccuracy);
        return startPositioning(new LocationOptions(locationAccuracy), locationAccuracy);
    }

    public void stop() {
        String str = LOG_TAG;
        Log.d(str, "stop");
        synchronized (this.mInstanceLock) {
            try {
                if (!this.mIsStarted) {
                    Log.d(str, "stop: Stop called, but engine was not started");
                    return;
                }
                this.mIsStarted = false;
                this.mNativeLocationIssues.clear();
                this.mAddedLocationIssues.clear();
                this.mLocationNonAvailableFeatures.clear();
                this.mHerePositioningClient.stop();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    @NonNull
    public LocationEngineStatus updateLocationAccuracy(@NonNull LocationAccuracy locationAccuracy) {
        Preconditions.checkArgumentNotNull(locationAccuracy, "locationAccuracy cannot be null");
        String str = LOG_TAG;
        Log.d(str, "updateLocationAccuracy: locationAccuracy is: " + locationAccuracy);
        return restartPositioning(new LocationOptions(locationAccuracy), locationAccuracy);
    }

    @NonNull
    public LocationEngineStatus updateLocationOptions(@NonNull LocationOptions locationOptions) {
        Preconditions.checkArgumentNotNull(locationOptions, "locationAccuracy cannot be null");
        String str = LOG_TAG;
        Log.d(str, "updateLocationOptions: locationOptions is: " + locationOptions);
        return restartPositioning(locationOptions, (LocationAccuracy) null);
    }

    public LocationEngine(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        this.mLocationListeners = new ArrayList<>();
        this.mStatusListeners = new ArrayList<>();
        this.mIssueListeners = new ArrayList<>();
        this.mNativeLocationIssues = new ArrayList();
        this.mAddedLocationIssues = new HashSet();
        this.mLocationNonAvailableFeatures = new ArrayList<>();
        this.mPositioningClientListener = new HerePositioningClientCallbacks(this, (AnonymousClass1) null);
        this.mInstanceLock = new Object();
        this.mIsStarted = false;
        this.mIsRestarted = false;
        this.mCallListenerFromMainThreadEnabled = true;
        this.mRequestedSatelliteOptions = new SatellitePositioningOptions();
        this.mConsentInternal = ConsentInternal.fromSdkNativeEngine(sDKNativeEngine);
        this.mHerePositioningClient = HerePositioningClient.fromSdkNativeEngine(sDKNativeEngine);
        this.mSDKEngine = sDKNativeEngine;
    }

    public class HerePositioningClientCallbacks implements PositioningClientListener {
        private LocationAccuracy mDesiredLocationAccuracy;
        private LocationOptions mDesiredLocationOptions;

        private HerePositioningClientCallbacks() {
            this.mDesiredLocationAccuracy = null;
            this.mDesiredLocationOptions = null;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onFeaturesNotAvailable$3(ArrayList arrayList) {
            LocationEngine locationEngine = LocationEngine.this;
            locationEngine.updateFeatureNotAvailableStatus(locationEngine.mLocationNonAvailableFeatures, arrayList);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onLocationChanged$0(com.here.sdk.core.Location location, ArrayList arrayList) {
            LocationEngine.this.updateLocation(location, arrayList);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onLocationIssueChanged$4(ArrayList arrayList) {
            LocationEngine.this.lambda$addLocationIssue$2(arrayList);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onOptionsChanged$1(ArrayList arrayList) {
            LocationEngine.this.lambda$addLocationIssue$2(arrayList);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$updateAuthentication$2(PositioningClientListener.OnAuthDataReceivedListener onAuthDataReceivedListener, AuthenticationError authenticationError, AuthenticationData authenticationData) {
            if (authenticationError == null) {
                Preconditions.checkArgumentNotNull(authenticationData, "Failed to retrieve authentication data");
                if (authenticationData.token.isEmpty()) {
                    onAuthDataReceivedListener.onAuthDataReceived(new AuthData());
                    LocationEngine.this.stop();
                    LocationEngine.this.updateStatus(LocationEngineStatus.AUTHENTICATION_FAILED, false);
                    return;
                }
                AuthData authData = new AuthData();
                authData.setAccessToken(authenticationData.token);
                authData.setExpiryTime(authenticationData.expiryTime.getSeconds());
                String access$100 = LocationEngine.LOG_TAG;
                Log.v(access$100, "updateAuthentication: No error! Next token valid for: " + authenticationData.expiryTime.getSeconds());
                onAuthDataReceivedListener.onAuthDataReceived(authData);
                return;
            }
            onAuthDataReceivedListener.onAuthDataReceived(new AuthData());
            int i = AnonymousClass1.$SwitchMap$com$here$sdk$core$AuthenticationError[authenticationError.ordinal()];
            if (i == 1) {
                Log.v(LocationEngine.LOG_TAG, "updateAuthentication: INVALID_PARAMETER");
            } else if (i != 2) {
                if (i != 3) {
                    String access$1002 = LocationEngine.LOG_TAG;
                    Log.v(access$1002, "updateAuthentication: unknown error code: " + authenticationError.toString());
                    return;
                }
                Log.v(LocationEngine.LOG_TAG, "updateAuthentication: NO_CONNECTION");
                return;
            }
            Log.v(LocationEngine.LOG_TAG, "updateAuthentication: AUTHENTICATION_FAILED");
            LocationEngine.this.stop();
            LocationEngine.this.updateStatus(LocationEngineStatus.AUTHENTICATION_FAILED, false);
        }

        public AuthData getAuthenticationData() throws AuthenticationException {
            Log.v(LocationEngine.LOG_TAG, "getAuthenticationData");
            AuthenticationData authenticate = Authentication.authenticate(LocationEngine.this.mSDKEngine);
            if (!authenticate.token.isEmpty()) {
                return new AuthData(authenticate.token, authenticate.expiryTime.getSeconds());
            }
            throw new AuthenticationException(AuthenticationError.AUTHENTICATION_FAILED);
        }

        @Nullable
        public LocationAccuracy getDesiredLocationAccuracy() {
            return this.mDesiredLocationAccuracy;
        }

        @Nullable
        public LocationOptions getDesiredLocationOptions() {
            return this.mDesiredLocationOptions;
        }

        public void onClientDisconnected() {
            Log.d(LocationEngine.LOG_TAG, "onClientDisconnected");
            LocationEngine.this.updateStatus(LocationEngineStatus.ENGINE_STOPPED, false);
        }

        public void onClientFailedToStart(@NonNull LocationEngineStatus locationEngineStatus) {
            String access$100 = LocationEngine.LOG_TAG;
            Log.d(access$100, "onClientFailedToStart (" + locationEngineStatus + "): setting back to not started");
            LocationEngine.this.updateStatus(locationEngineStatus, false);
        }

        public void onClientSuccessfullyStarted() {
            Log.d(LocationEngine.LOG_TAG, "onClientSuccessfullyStarted");
            LocationEngine.this.updateStatus(LocationEngineStatus.ENGINE_STARTED, true);
        }

        public void onFeaturesNotAvailable(@NonNull List<LocationFeature> list) {
            ArrayList arrayList;
            String access$100 = LocationEngine.LOG_TAG;
            Log.d(access$100, "onFeaturesNotAvailable: " + list);
            synchronized (LocationEngine.this.mInstanceLock) {
                try {
                    arrayList = new ArrayList(LocationEngine.this.mStatusListeners);
                    for (LocationFeature next : list) {
                        if (!LocationEngine.this.mLocationNonAvailableFeatures.contains(next)) {
                            LocationEngine.this.mLocationNonAvailableFeatures.add(next);
                        }
                    }
                } finally {
                    while (true) {
                    }
                }
            }
            if (LocationEngine.this.mCallListenerFromMainThreadEnabled) {
                Threading.getPlatformThreading().runOnMainThread(new f(this, arrayList));
                return;
            }
            LocationEngine locationEngine = LocationEngine.this;
            locationEngine.updateFeatureNotAvailableStatus(locationEngine.mLocationNonAvailableFeatures, arrayList);
        }

        public void onLocationChanged(@NonNull Location location) {
            ArrayList arrayList;
            com.here.sdk.core.Location locationFromAndroidLocation = LocationEngine.locationFromAndroidLocation(location);
            synchronized (LocationEngine.this.mInstanceLock) {
                arrayList = new ArrayList(LocationEngine.this.mLocationListeners);
            }
            if (LocationEngine.this.mCallListenerFromMainThreadEnabled) {
                Threading.getPlatformThreading().runOnMainThread(new h(this, locationFromAndroidLocation, arrayList));
            } else {
                LocationEngine.this.updateLocation(locationFromAndroidLocation, arrayList);
            }
        }

        public void onLocationIssueChanged(@NonNull List<LocationIssueType> list) {
            ArrayList arrayList;
            String access$100 = LocationEngine.LOG_TAG;
            Log.d(access$100, "onLocationIssueChanged: " + list);
            synchronized (LocationEngine.this.mInstanceLock) {
                List unused = LocationEngine.this.mNativeLocationIssues = list;
                arrayList = new ArrayList(LocationEngine.this.mIssueListeners);
            }
            if (LocationEngine.this.mCallListenerFromMainThreadEnabled) {
                Threading.getPlatformThreading().runOnMainThread(new e(this, arrayList));
            } else {
                LocationEngine.this.lambda$addLocationIssue$2(arrayList);
            }
        }

        public void onLocationRequestFailed() {
            Log.d(LocationEngine.LOG_TAG, "onLocationRequestFailed: one-time failure on the location request");
        }

        public void onLocationServicesStateChanged(boolean z) {
            if (z) {
                LocationEngine locationEngine = LocationEngine.this;
                locationEngine.updateStatus(LocationEngineStatus.ENGINE_STARTED, locationEngine.mIsStarted);
                return;
            }
            LocationEngine locationEngine2 = LocationEngine.this;
            locationEngine2.updateStatus(LocationEngineStatus.LOCATION_SERVICES_DISABLED, locationEngine2.mIsStarted);
        }

        public void onOptionsChanged(PositioningClientListener.deviceSetting devicesetting, boolean z) {
            LocationOptions desiredLocationOptions;
            if (devicesetting == PositioningClientListener.deviceSetting.DATACONNECTION && z) {
                Set access$700 = LocationEngine.this.mAddedLocationIssues;
                LocationIssueType locationIssueType = LocationIssueType.HDGNSS_CONNECTION_NOT_AVAILABLE;
                if (access$700.contains(locationIssueType)) {
                    if (LocationEngine.this.mRequestedSatelliteOptions != null && LocationEngine.this.mRequestedSatelliteOptions.hdEnabled) {
                        synchronized (LocationEngine.this.mInstanceLock) {
                            desiredLocationOptions = LocationEngine.this.mPositioningClientListener.getDesiredLocationOptions();
                        }
                        if (desiredLocationOptions == null) {
                            Log.e(LocationEngine.LOG_TAG, "Failed to retrieve desired location options");
                            return;
                        }
                        SatellitePositioningOptions satellitePositioningOptions = desiredLocationOptions.satellitePositioningOptions;
                        if (!satellitePositioningOptions.hdEnabled) {
                            satellitePositioningOptions.hdEnabled = true;
                            synchronized (LocationEngine.this.mInstanceLock) {
                                LocationEngine.this.mPositioningClientListener.setDesiredLocationOptions(desiredLocationOptions);
                            }
                            LocationEngine.this.mHerePositioningClient.getFeatureChecker().checkFeatureAuthorization(LocationFeature.HD_GNSS_POSITIONING, LocationEngine.this.makeAuthorizationListener(true));
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    synchronized (LocationEngine.this.mInstanceLock) {
                        arrayList.addAll(LocationEngine.this.mIssueListeners);
                        LocationEngine.this.mAddedLocationIssues.remove(locationIssueType);
                    }
                    if (LocationEngine.this.mCallListenerFromMainThreadEnabled) {
                        Threading.getPlatformThreading().runOnMainThread(new i(this, arrayList));
                    } else {
                        LocationEngine.this.lambda$addLocationIssue$2(arrayList);
                    }
                }
            }
        }

        public void setDesiredLocationAccuracy(@Nullable LocationAccuracy locationAccuracy) {
            this.mDesiredLocationAccuracy = locationAccuracy;
        }

        public void setDesiredLocationOptions(@Nullable LocationOptions locationOptions) {
            this.mDesiredLocationOptions = locationOptions;
        }

        public void updateAuthentication(PositioningClientListener.OnAuthDataReceivedListener onAuthDataReceivedListener) {
            Authentication.authenticate(LocationEngine.this.mSDKEngine, new g(this, onAuthDataReceivedListener));
        }

        public /* synthetic */ HerePositioningClientCallbacks(LocationEngine locationEngine, AnonymousClass1 r2) {
            this();
        }
    }

    @NonNull
    public LocationEngineStatus start(@NonNull LocationOptions locationOptions) {
        Preconditions.checkArgumentNotNull(locationOptions, "locationOptions cannot be null");
        String str = LOG_TAG;
        Log.d(str, "start, locationOptions is: " + locationOptions);
        return startPositioning(locationOptions, (LocationAccuracy) null);
    }
}
