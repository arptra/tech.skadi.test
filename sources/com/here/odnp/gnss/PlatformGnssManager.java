package com.here.odnp.gnss;

import android.content.Context;
import android.location.GnssMeasurementRequest;
import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import com.here.odnp.gnss.IGnssManager;
import com.here.odnp.util.Log;
import com.here.odnp.util.SafeHandler;
import com.here.odnp.util.Timer;
import com.here.posclient.GnssStatus;
import com.here.posclient.Status;
import com.honey.account.w1.d;
import com.honey.account.w1.e;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PlatformGnssManager implements IGnssManager {
    private static final int INIT_GNSS_LOCATION_REREQUEST_TIMEOUT_SEC = 2;
    private static final double LATITUDE_MAX = 90.0d;
    private static final double LATITUDE_MIN = -90.0d;
    private static final double LONGITUDE_MAX = 180.0d;
    private static final double LONGITUDE_MIN = -180.0d;
    private static final int MAX_GNSS_LOCATION_REREQUEST_TIMEOUT_SEC = 128;
    private static final String TAG = "odnp.gnss.PlatformGnssManager";
    /* access modifiers changed from: private */
    public boolean mActiveGnssStarted = false;
    /* access modifiers changed from: private */
    public LocationListener mActiveLocationListener;
    private final Context mContext;
    /* access modifiers changed from: private */
    public int mGnssLocationReRequestTimeoutInSeconds = 2;
    /* access modifiers changed from: private */
    public Timer mGnssLocationReRequestTimer;
    private final Handler mGnssMeasurementHandler;
    private Object mGnssMeasurementsListener;
    /* access modifiers changed from: private */
    public boolean mGnssMeasurementsStarted = false;
    /* access modifiers changed from: private */
    public final SafeHandler mHandler;
    private IGnssManager.IGnnsListener mListener;
    /* access modifiers changed from: private */
    public final LocationManager mLocationManager;
    private LocationListener mPassiveLocationListener;
    /* access modifiers changed from: private */
    public long mPreviousLocationTime;
    private Object mStatusCallback;
    private final Handler mStatusHandler;

    public class GnssLocationListener implements LocationListener {
        private GnssLocationListener() {
        }

        public void onLocationChanged(Location location) {
            if (PlatformGnssManager.this.mActiveGnssStarted && location != null && "gps".equals(location.getProvider())) {
                Log.v(PlatformGnssManager.TAG, "onLocationChanged: active listener, %s", location);
                PlatformGnssManager.this.onUpdateLocation(location);
                if (PlatformGnssManager.this.mPreviousLocationTime != location.getTime()) {
                    long unused = PlatformGnssManager.this.mPreviousLocationTime = location.getTime();
                    if (PlatformGnssManager.this.mGnssLocationReRequestTimer == null) {
                        Timer unused2 = PlatformGnssManager.this.mGnssLocationReRequestTimer = new Timer();
                        PlatformGnssManager.this.mGnssLocationReRequestTimer.start(PlatformGnssManager.this.mHandler.getLooper());
                    } else {
                        PlatformGnssManager.this.mGnssLocationReRequestTimer.cancel();
                    }
                    if (PlatformGnssManager.this.mGnssLocationReRequestTimeoutInSeconds != 2) {
                        Log.d(PlatformGnssManager.TAG, "GNSS re-request timeout reset to 2 seconds", new Object[0]);
                        int unused3 = PlatformGnssManager.this.mGnssLocationReRequestTimeoutInSeconds = 2;
                    }
                    PlatformGnssManager.this.rescheduleGnssReRequest();
                    return;
                }
                Log.d(PlatformGnssManager.TAG, "GNSS re-request cancelled due to cached location ", new Object[0]);
                if (PlatformGnssManager.this.mGnssLocationReRequestTimer != null) {
                    PlatformGnssManager.this.mGnssLocationReRequestTimer.cancel();
                }
            }
        }

        public void onProviderDisabled(String str) {
            Log.v(PlatformGnssManager.TAG, "onProviderDisabled: active listener, provider: '%s'", str);
            if (PlatformGnssManager.this.mActiveGnssStarted && "gps".equals(str)) {
                PlatformGnssManager.this.onGnssDisabled();
            }
        }

        public void onProviderEnabled(String str) {
            Log.v(PlatformGnssManager.TAG, "onProviderEnabled: active listener, provider: '%s'", str);
            if (PlatformGnssManager.this.mActiveGnssStarted && "gps".equals(str)) {
                PlatformGnssManager.this.onGnssEnabled();
                if (PlatformGnssManager.this.mActiveGnssStarted) {
                    Log.v(PlatformGnssManager.TAG, "onProviderEnabled: restarting active position updates", new Object[0]);
                    PlatformGnssManager.this.stopGnss();
                    PlatformGnssManager.this.startGnss();
                }
            }
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            Log.v(PlatformGnssManager.TAG, "onStatusChanged: active listener, provider: '%s'' status: %d", str, Integer.valueOf(i));
        }
    }

    public class PassiveLocationListener implements LocationListener {
        private PassiveLocationListener() {
        }

        public void onLocationChanged(Location location) {
            if (!PlatformGnssManager.this.mActiveGnssStarted && location != null && "gps".equals(location.getProvider())) {
                Log.v(PlatformGnssManager.TAG, "onLocationChanged: passive listener, %s", location);
                PlatformGnssManager.this.onUpdateLocation(location);
            }
        }

        public void onProviderDisabled(String str) {
            Log.v(PlatformGnssManager.TAG, "onProviderDisabled: passive listener, provider: '%s'", str);
            if (!PlatformGnssManager.this.mActiveGnssStarted && "gps".equals(str)) {
                PlatformGnssManager.this.onGnssDisabled();
            }
        }

        public void onProviderEnabled(String str) {
            Log.v(PlatformGnssManager.TAG, "onProviderEnabled: passive listener, provider: '%s'", str);
            if (!PlatformGnssManager.this.mActiveGnssStarted && "gps".equals(str)) {
                PlatformGnssManager.this.onGnssEnabled();
            }
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            Log.v(PlatformGnssManager.TAG, "onStatusChanged: passive listener, provider: '%s'' status: %d", str, Integer.valueOf(i));
        }
    }

    public PlatformGnssManager(Context context, SafeHandler safeHandler) {
        this.mContext = context;
        this.mHandler = safeHandler;
        this.mStatusHandler = new Handler(safeHandler.getLooper());
        this.mGnssMeasurementHandler = new Handler(safeHandler.getLooper());
        this.mLocationManager = (LocationManager) context.getSystemService("location");
    }

    private static boolean isLocationValid(Location location) {
        double latitude = location.getLatitude();
        if (latitude >= LATITUDE_MIN && latitude <= LATITUDE_MAX) {
            double longitude = location.getLongitude();
            return longitude >= LONGITUDE_MIN && longitude <= LONGITUDE_MAX;
        }
    }

    private boolean isMockingAllowed() {
        return Settings.Secure.getInt(this.mContext.getContentResolver(), "mock_location", 1) != 0;
    }

    private boolean isSimulated(Location location) {
        return location.isFromMockProvider();
    }

    /* access modifiers changed from: private */
    public synchronized void onGnssDisabled() {
        Log.v(TAG, "onGnssDisabled", new Object[0]);
        IGnssManager.IGnnsListener iGnnsListener = this.mListener;
        if (iGnnsListener == null) {
            Log.w(TAG, "onGnssDisabled: listener is null => ignored", new Object[0]);
        } else {
            iGnnsListener.onGnssStatusChanged(GnssStatus.Disabled);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onGnssEnabled() {
        Log.v(TAG, "onGnssEnabled", new Object[0]);
        IGnssManager.IGnnsListener iGnnsListener = this.mListener;
        if (iGnnsListener == null) {
            Log.w(TAG, "onGnssEnabled: listener is null => ignored", new Object[0]);
        } else {
            iGnnsListener.onGnssStatusChanged(GnssStatus.Active);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onUpdateLocation(Location location) {
        Log.v(TAG, "onUpdateLocation: %s", location);
        if (this.mListener == null) {
            Log.w(TAG, "onUpdateLocation: listener is null => ignored", new Object[0]);
        } else if (!isLocationValid(location)) {
            Log.w(TAG, "onUpdateLocation: Invalid GNSS location update detected", new Object[0]);
        } else {
            this.mListener.onGnssLocationChanged(location, isSimulated(location));
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onUpdateMeasurements(GnssMeasurementsEvent gnssMeasurementsEvent) {
        IGnssManager.IGnnsListener iGnnsListener = this.mListener;
        if (iGnnsListener != null) {
            iGnnsListener.onGnssMeasurementsReceived(gnssMeasurementsEvent);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onUpdateStatus(long j, android.location.GnssStatus gnssStatus) {
        IGnssManager.IGnnsListener iGnnsListener = this.mListener;
        if (iGnnsListener != null) {
            iGnnsListener.onGnssStatusReceived(j, gnssStatus);
        }
    }

    /* access modifiers changed from: private */
    public void rescheduleGnssReRequest() {
        Log.d(TAG, "GNSS re-request scheduled after " + this.mGnssLocationReRequestTimeoutInSeconds + " seconds", new Object[0]);
        Timer timer = this.mGnssLocationReRequestTimer;
        Objects.requireNonNull(timer);
        timer.schedule(new Timer.Task(timer) {
            {
                Objects.requireNonNull(r2);
            }

            public void run() {
                boolean z;
                synchronized (PlatformGnssManager.this) {
                    try {
                        Log.d(PlatformGnssManager.TAG, "GNSS re-request starting.", new Object[0]);
                        if (PlatformGnssManager.this.mActiveGnssStarted) {
                            if (PlatformGnssManager.this.mGnssMeasurementsStarted) {
                                PlatformGnssManager.this.stopGnssMeasurements();
                                z = true;
                            } else {
                                z = false;
                            }
                            PlatformGnssManager.this.stopGnssTracing();
                            PlatformGnssManager.this.mLocationManager.removeUpdates(PlatformGnssManager.this.mActiveLocationListener);
                            LocationListener unused = PlatformGnssManager.this.mActiveLocationListener = null;
                            boolean unused2 = PlatformGnssManager.this.mActiveGnssStarted = false;
                            PlatformGnssManager.this.startGnss();
                            if (z && PlatformGnssManager.this.startGnssMeasurements() != Status.Ok) {
                                Log.d(PlatformGnssManager.TAG, "Failed to re-request GNSS measurements", new Object[0]);
                            }
                            Log.d(PlatformGnssManager.TAG, "GNSS re-request done.", new Object[0]);
                            if (PlatformGnssManager.this.mGnssLocationReRequestTimeoutInSeconds < 128) {
                                PlatformGnssManager platformGnssManager = PlatformGnssManager.this;
                                int unused3 = platformGnssManager.mGnssLocationReRequestTimeoutInSeconds = Math.min(platformGnssManager.mGnssLocationReRequestTimeoutInSeconds * 2, 128);
                                PlatformGnssManager.this.rescheduleGnssReRequest();
                            } else {
                                Log.d(PlatformGnssManager.TAG, "GNSS re-request stopped due to reaching maximum timeout.", new Object[0]);
                            }
                        } else {
                            Log.d(PlatformGnssManager.TAG, "GNSS re-request not done.", new Object[0]);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }, TimeUnit.SECONDS.toMillis((long) this.mGnssLocationReRequestTimeoutInSeconds));
    }

    private void startGnssTracing() {
        if (this.mGnssMeasurementsStarted && this.mStatusCallback == null) {
            try {
                AnonymousClass2 r0 = new GnssStatus.Callback() {
                    public void onFirstFix(int i) {
                    }

                    public void onSatelliteStatusChanged(android.location.GnssStatus gnssStatus) {
                        if (PlatformGnssManager.this.mGnssMeasurementsStarted) {
                            PlatformGnssManager.this.onUpdateStatus(SystemClock.elapsedRealtime(), gnssStatus);
                        }
                    }

                    public void onStarted() {
                    }

                    public void onStopped() {
                    }
                };
                this.mStatusCallback = r0;
                if (!this.mLocationManager.registerGnssStatusCallback(r0, this.mStatusHandler)) {
                    Log.w(TAG, "startGnssTracing: registerGnssStatusCallback failed", new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void stopGnssTracing() {
        if (this.mGnssMeasurementsStarted) {
            try {
                Object obj = this.mStatusCallback;
                if (obj != null) {
                    this.mLocationManager.unregisterGnssStatusCallback((GnssStatus.Callback) obj);
                    this.mStatusHandler.removeCallbacks((Runnable) null);
                    this.mStatusCallback = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public Location getLastKnownGnssLocation() {
        return this.mLocationManager.getLastKnownLocation("gps");
    }

    public Location getLastKnownLocation() {
        try {
            return this.mLocationManager.getLastKnownLocation("passive");
        } catch (SecurityException e) {
            Log.e(TAG, "getLastKnownLocation: access denied:" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public boolean isGnssSupported() {
        return this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:20|21|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        return com.here.posclient.Status.GeneralError;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0043 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.here.posclient.Status startGnss() {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r9.isGnssSupported()     // Catch:{ all -> 0x000b }
            if (r0 != 0) goto L_0x000d
            com.here.posclient.Status r0 = com.here.posclient.Status.NotSupportedError     // Catch:{ all -> 0x000b }
            monitor-exit(r9)
            return r0
        L_0x000b:
            r0 = move-exception
            goto L_0x0047
        L_0x000d:
            android.location.LocationListener r0 = r9.mActiveLocationListener     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x0015
            com.here.posclient.Status r0 = com.here.posclient.Status.Ok     // Catch:{ all -> 0x000b }
            monitor-exit(r9)
            return r0
        L_0x0015:
            com.here.odnp.gnss.PlatformGnssManager$GnssLocationListener r0 = new com.here.odnp.gnss.PlatformGnssManager$GnssLocationListener     // Catch:{ all -> 0x000b }
            r1 = 0
            r0.<init>()     // Catch:{ all -> 0x000b }
            r9.mActiveLocationListener = r0     // Catch:{ all -> 0x000b }
            r9.startGnssTracing()     // Catch:{ Exception -> 0x0043 }
            android.location.LocationManager r2 = r9.mLocationManager     // Catch:{ Exception -> 0x0043 }
            java.lang.String r3 = "gps"
            android.location.LocationListener r7 = r9.mActiveLocationListener     // Catch:{ Exception -> 0x0043 }
            com.here.odnp.util.SafeHandler r0 = r9.mHandler     // Catch:{ Exception -> 0x0043 }
            android.os.Looper r8 = r0.getLooper()     // Catch:{ Exception -> 0x0043 }
            r4 = 900(0x384, double:4.447E-321)
            r6 = 0
            r2.requestLocationUpdates(r3, r4, r6, r7, r8)     // Catch:{ Exception -> 0x0043 }
            java.lang.String r0 = "odnp.gnss.PlatformGnssManager"
            java.lang.String r1 = "startGnss - active GPS started"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0043 }
            com.here.odnp.util.Log.v(r0, r1, r2)     // Catch:{ Exception -> 0x0043 }
            r0 = 1
            r9.mActiveGnssStarted = r0     // Catch:{ Exception -> 0x0043 }
            com.here.posclient.Status r0 = com.here.posclient.Status.Ok     // Catch:{ Exception -> 0x0043 }
            monitor-exit(r9)
            return r0
        L_0x0043:
            com.here.posclient.Status r0 = com.here.posclient.Status.GeneralError     // Catch:{ all -> 0x000b }
            monitor-exit(r9)
            return r0
        L_0x0047:
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.odnp.gnss.PlatformGnssManager.startGnss():com.here.posclient.Status");
    }

    public Status startGnssMeasurements() {
        Log.w(TAG, "startGnssMeasurements: start listening to GNSS measurements.", new Object[0]);
        if (!this.mActiveGnssStarted) {
            Log.w(TAG, "startGnssMeasurements: Cannot start measurements without active GNSS.", new Object[0]);
            return Status.GeneralError;
        }
        int i = Build.VERSION.SDK_INT;
        if (this.mGnssMeasurementsListener == null) {
            this.mGnssMeasurementsListener = new GnssMeasurementsEvent.Callback() {
                public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
                    if (gnssMeasurementsEvent != null && PlatformGnssManager.this.mActiveGnssStarted) {
                        Log.v(PlatformGnssManager.TAG, "onGnssMeasurementsReceived: %s", gnssMeasurementsEvent);
                        PlatformGnssManager.this.onUpdateMeasurements(gnssMeasurementsEvent);
                    }
                }
            };
        }
        if (i > 30) {
            try {
                e.a();
                GnssMeasurementRequest.Builder a2 = d.a();
                GnssMeasurementRequest.Builder unused = a2.setFullTracking(true);
                boolean unused2 = this.mLocationManager.registerGnssMeasurementsCallback(a2.build(), this.mContext.getMainExecutor(), (GnssMeasurementsEvent.Callback) this.mGnssMeasurementsListener);
            } catch (Exception unused3) {
                return Status.GeneralError;
            }
        } else {
            this.mLocationManager.registerGnssMeasurementsCallback((GnssMeasurementsEvent.Callback) this.mGnssMeasurementsListener, this.mGnssMeasurementHandler);
        }
        this.mGnssMeasurementsStarted = true;
        startGnssTracing();
        return Status.Ok;
    }

    public synchronized boolean startListening(IGnssManager.IGnnsListener iGnnsListener, long j) {
        if (iGnnsListener == null) {
            throw new IllegalArgumentException("listener is null");
        } else if (!isGnssSupported()) {
            Log.w(TAG, "startListening: GNSS not supported by device", new Object[0]);
            return false;
        } else {
            stopListening();
            this.mListener = iGnnsListener;
            PassiveLocationListener passiveLocationListener = new PassiveLocationListener();
            this.mPassiveLocationListener = passiveLocationListener;
            this.mLocationManager.requestLocationUpdates("passive", j, 0.0f, passiveLocationListener, this.mHandler.getLooper());
            Log.v(TAG, "startListening - passive GPS started", new Object[0]);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void stopGnss() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x002d }
            java.lang.String r2 = "odnp.gnss.PlatformGnssManager"
            java.lang.String r3 = "stopGnss"
            com.here.odnp.util.Log.v(r2, r3, r1)     // Catch:{ all -> 0x002d }
            android.location.LocationListener r1 = r4.mActiveLocationListener     // Catch:{ all -> 0x002d }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r4)
            return
        L_0x0011:
            r4.stopGnssTracing()     // Catch:{ all -> 0x002d }
            r4.stopGnssMeasurements()     // Catch:{ all -> 0x002d }
            android.location.LocationManager r1 = r4.mLocationManager     // Catch:{ all -> 0x002d }
            android.location.LocationListener r2 = r4.mActiveLocationListener     // Catch:{ all -> 0x002d }
            r1.removeUpdates(r2)     // Catch:{ all -> 0x002d }
            r1 = 0
            r4.mActiveLocationListener = r1     // Catch:{ all -> 0x002d }
            r4.mActiveGnssStarted = r0     // Catch:{ all -> 0x002d }
            com.here.odnp.util.Timer r0 = r4.mGnssLocationReRequestTimer     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x002f
            r0.stop()     // Catch:{ all -> 0x002d }
            r4.mGnssLocationReRequestTimer = r1     // Catch:{ all -> 0x002d }
            goto L_0x002f
        L_0x002d:
            r0 = move-exception
            goto L_0x0031
        L_0x002f:
            monitor-exit(r4)
            return
        L_0x0031:
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.odnp.gnss.PlatformGnssManager.stopGnss():void");
    }

    public void stopGnssMeasurements() {
        this.mGnssMeasurementsStarted = false;
        int i = Build.VERSION.SDK_INT;
        try {
            Object obj = this.mGnssMeasurementsListener;
            if (obj != null) {
                this.mLocationManager.unregisterGnssMeasurementsCallback((GnssMeasurementsEvent.Callback) obj);
                if (i <= 30) {
                    this.mGnssMeasurementHandler.removeCallbacks((Runnable) null);
                }
                this.mGnssMeasurementsListener = null;
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void stopListening() {
        try {
            if (this.mListener != null) {
                LocationListener locationListener = this.mPassiveLocationListener;
                if (locationListener != null) {
                    this.mLocationManager.removeUpdates(locationListener);
                    this.mPassiveLocationListener = null;
                }
                this.mListener = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
