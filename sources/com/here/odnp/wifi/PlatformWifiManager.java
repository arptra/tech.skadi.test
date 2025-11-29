package com.here.odnp.wifi;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Pair;
import com.here.odnp.util.Log;
import com.here.odnp.util.OdnpPreferences;
import com.here.odnp.util.SafeHandler;
import com.here.odnp.wifi.IWifiManager;
import com.here.odnp.wifi.util.WifiScanLock;
import com.here.odnp.wifi.util.WifiUtils;
import com.here.posclient.WifiMeasurement;
import com.here.posclient.WifiStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressLint({"MissingPermission"})
public class PlatformWifiManager implements IWifiManager {
    private static final String ANDROID_PERMISSION_NETWORK_SETTINGS = "android.permission.NETWORK_SETTINGS";
    private static final String KEY_WIFI_WHITE_LISTED = ".wifi_whitelisted";
    private static final long MIN_SCAN_INTERVAL = TimeUnit.SECONDS.toMillis(30);
    private static final String TAG = "odnp.wifi.PlatformWifiManager";
    private static final int VALUE_NO = 0;
    private static final String WIFI_SCAN_THROTTLE_ENABLED = "wifi_scan_throttle_enabled";
    private final Context mContext;
    /* access modifiers changed from: private */
    public final SafeHandler mHandler;
    private volatile IWifiManager.IWifiListener mListener;
    private final PackageManager mPackageManager;
    private final OdnpPreferences mPreferences;
    private final ContentResolver mResolver;
    /* access modifiers changed from: private */
    public final WifiManager mWifiManager;
    private final BroadcastReceiver mWifiReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                PlatformWifiManager.this.handleWifiScanResultsAvailable();
            } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                PlatformWifiManager.this.pushWifiState();
            } else if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                PlatformWifiManager.this.pushWifiState();
            } else if ("android.intent.action.AIRPLANE_MODE".equals(intent.getAction())) {
                PlatformWifiManager.this.pushWifiState();
            }
        }
    };
    private final IWifiScanLock mWifiScanLock;
    private WifiStatus mWifiStatus;
    private final ContentObserver mWifiThrottleObserver = new ContentObserver((Handler) null) {
        public void onChange(boolean z) {
            onChange(z, (Uri) null);
        }

        public void onChange(boolean z, Uri uri) {
            PlatformWifiManager.this.mHandler.post(new Runnable() {
                public void run() {
                    if (PlatformWifiManager.this.mWifiThrottleStatusObserver != null) {
                        PlatformWifiManager platformWifiManager = PlatformWifiManager.this;
                        boolean unused = platformWifiManager.mWifiThrottlingEnabled = platformWifiManager.isWifiThrottled();
                        PlatformWifiManager.this.mWifiThrottleStatusObserver.onThrottleStatusChanged(PlatformWifiManager.this.mWifiThrottlingEnabled);
                    }
                }
            });
        }
    };
    /* access modifiers changed from: private */
    public WifiThrottleStatusObserver mWifiThrottleStatusObserver;
    /* access modifiers changed from: private */
    public boolean mWifiThrottlingEnabled = true;

    public interface IWifiScanLock {
        void acquire();

        void release();
    }

    public interface WifiThrottleStatusObserver {
        void onThrottleStatusChanged(boolean z);
    }

    public PlatformWifiManager(Context context, SafeHandler safeHandler, WifiThrottleStatusObserver wifiThrottleStatusObserver) {
        if (context != null) {
            this.mContext = context;
            this.mHandler = safeHandler;
            this.mResolver = context.getContentResolver();
            this.mWifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            this.mPackageManager = context.getPackageManager();
            this.mWifiScanLock = createWifiScanLock();
            this.mPreferences = new OdnpPreferences(context);
            this.mWifiThrottleStatusObserver = wifiThrottleStatusObserver;
            ensureScanTimeNotInFuture();
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    private void acquireWifiLock() {
        this.mWifiScanLock.acquire();
    }

    private static boolean checkPermission(Context context, String str) {
        boolean z = context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        Log.v(TAG, String.format("checkPermissions: %s: %b", new Object[]{str, Boolean.valueOf(z)}), new Object[0]);
        return z;
    }

    private final IWifiScanLock createWifiScanLock() {
        if (checkPermission(this.mContext, "android.permission.WAKE_LOCK")) {
            Log.v(TAG, "createWifiScanLock: using WifiScanLock", new Object[0]);
            return new IWifiScanLock() {
                private final WifiScanLock mWifiScanLock;

                {
                    this.mWifiScanLock = new WifiScanLock(PlatformWifiManager.this.mWifiManager);
                }

                public void acquire() {
                    this.mWifiScanLock.acquire();
                }

                public void release() {
                    this.mWifiScanLock.release();
                }
            };
        }
        Log.v(TAG, "createWifiScanLock: disabling WifiScanLock", new Object[0]);
        return new IWifiScanLock() {
            public void acquire() {
            }

            public void release() {
            }
        };
    }

    private void ensureScanTimeNotInFuture() {
        long bootCount = getBootCount();
        long j = this.mPreferences.getLong(OdnpPreferences.KEY_LAST_USE_BOOT_COUNT);
        int i = (j > Long.MIN_VALUE ? 1 : (j == Long.MIN_VALUE ? 0 : -1));
        if (i == 0 || bootCount != j) {
            if (i == 0) {
                Log.v(TAG, "ensureScanTimeNotInFuture: setting boot count for the first time", new Object[0]);
            } else {
                Log.v(TAG, "ensureScanTimeNotInFuture: update boot count", new Object[0]);
            }
            this.mPreferences.put(OdnpPreferences.KEY_LAST_USE_BOOT_COUNT, bootCount);
            this.mPreferences.reset(OdnpPreferences.KEY_WIFI_SCAN_TIME);
        }
        long j2 = this.mPreferences.getLong(OdnpPreferences.KEY_WIFI_SCAN_TIME);
        if (j2 != Long.MIN_VALUE && j2 > SystemClock.elapsedRealtime()) {
            Log.v(TAG, "ensureScanTimeNotInFuture: scan time in the future, reset scan time", new Object[0]);
            this.mPreferences.reset(OdnpPreferences.KEY_WIFI_SCAN_TIME);
        }
    }

    private final long getBootCount() {
        try {
            return (long) Settings.Global.getInt(this.mContext.getContentResolver(), "boot_count");
        } catch (Settings.SettingNotFoundException unused) {
            Log.w(TAG, "getBootCount: %s not found", "boot_count");
            return Long.MIN_VALUE;
        }
    }

    private final boolean getSettingBoolean(String str) {
        boolean z = Settings.Secure.getInt(this.mResolver, str, 0) != 0;
        Log.v(TAG, "getSettingBoolean: " + str + ": " + z, new Object[0]);
        return z;
    }

    private final List<ScanResult> getWifiScanResults() {
        return hasAccessWifiStatePermission() ? this.mWifiManager.getScanResults() : new ArrayList();
    }

    /* access modifiers changed from: private */
    public synchronized void handleWifiScanResultsAvailable() {
        Log.v(TAG, "handleWifiScanResultsAvailable", new Object[0]);
        releaseWifiLock();
        if (this.mListener != null) {
            this.mListener.onScanResultsAvailable(new IWifiManager.WifiScanResultContainer(WifiUtils.toWifiMeasurements(getWifiScanResults())));
        }
    }

    private final boolean hasAccessWifiStatePermission() {
        return checkPermission(this.mContext, "android.permission.ACCESS_WIFI_STATE");
    }

    private boolean hasEnoughTimePassed() {
        boolean isWifiThrottled = isWifiThrottled();
        if (this.mWifiThrottlingEnabled != isWifiThrottled) {
            this.mWifiThrottlingEnabled = isWifiThrottled;
            if (Build.VERSION.SDK_INT >= 30) {
                this.mWifiThrottleStatusObserver.onThrottleStatusChanged(isWifiThrottled);
            }
        }
        if (!this.mWifiThrottlingEnabled) {
            return true;
        }
        long j = this.mPreferences.getLong(OdnpPreferences.KEY_WIFI_SCAN_TIME);
        if (j == Long.MIN_VALUE || SystemClock.elapsedRealtime() - j > MIN_SCAN_INTERVAL) {
            return true;
        }
        Log.v(TAG, "hasEnoughTimePassed: false", new Object[0]);
        return false;
    }

    private boolean isFlightModeOn() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    private final boolean isScanAlwaysAvailable() {
        if (hasAccessWifiStatePermission()) {
            return this.mWifiManager.isScanAlwaysAvailable();
        }
        return false;
    }

    private boolean isWhiteListedPackage() {
        return getSettingBoolean(this.mContext.getPackageName() + KEY_WIFI_WHITE_LISTED);
    }

    private final boolean isWifiEnabled() {
        if (hasAccessWifiStatePermission()) {
            return this.mWifiManager.isWifiEnabled();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public synchronized void pushWifiState() {
        WifiStatus wifiStatus;
        try {
            WifiStatus wifiStatus2 = WifiStatus.Unknown;
            if (!isWifiEnabled()) {
                wifiStatus = WifiStatus.Disabled;
                if (isScanAlwaysAvailable() && !isFlightModeOn()) {
                    wifiStatus = WifiStatus.Disconnected;
                }
            } else {
                NetworkInfo networkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getNetworkInfo(1);
                wifiStatus = (networkInfo == null || !networkInfo.isConnected()) ? WifiStatus.Disconnected : WifiStatus.Connected;
            }
            WifiStatus wifiStatus3 = this.mWifiStatus;
            if ((wifiStatus3 == null || wifiStatus3 != wifiStatus) && this.mListener != null) {
                this.mListener.onWifiStateChanged(wifiStatus);
                this.mWifiStatus = wifiStatus;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void registerWifiThrottleObserver() {
        Uri uriFor = Settings.Global.getUriFor("development_settings_enabled");
        Uri uriFor2 = Settings.Global.getUriFor(WIFI_SCAN_THROTTLE_ENABLED);
        if (uriFor != null && uriFor2 != null) {
            this.mContext.getContentResolver().registerContentObserver(uriFor, false, this.mWifiThrottleObserver);
            this.mContext.getContentResolver().registerContentObserver(uriFor2, false, this.mWifiThrottleObserver);
        }
    }

    private void releaseWifiLock() {
        this.mWifiScanLock.release();
    }

    public static void resetLastScanTime(Context context) {
        if (!new OdnpPreferences(context).reset(OdnpPreferences.KEY_WIFI_SCAN_TIME)) {
            Log.w(TAG, "resetLastScanTime: failed", new Object[0]);
        }
    }

    private void scanStarted() {
        if (!this.mPreferences.put(OdnpPreferences.KEY_WIFI_SCAN_TIME, SystemClock.elapsedRealtime())) {
            Log.w(TAG, "scanStarted: failed to put scan start time", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void sendCachedScanResults() {
        Log.v(TAG, "sendCachedScanResult", new Object[0]);
        if (this.mListener != null) {
            this.mListener.onScanResultsAvailable(new IWifiManager.WifiScanResultContainer(WifiUtils.toWifiMeasurements(getWifiScanResults())));
        }
    }

    public void cancelWifiScan() {
        releaseWifiLock();
    }

    public synchronized void close() {
        if (this.mListener != null) {
            try {
                this.mContext.unregisterReceiver(this.mWifiReceiver);
                this.mContext.getContentResolver().unregisterContentObserver(this.mWifiThrottleObserver);
            } finally {
                this.mListener = null;
                releaseWifiLock();
            }
        }
    }

    public Pair<Long, List<WifiMeasurement>> getLastScanResult() {
        return new Pair<>(0L, WifiUtils.toWifiMeasurements(getWifiScanResults()));
    }

    public boolean isWifiSupported() {
        boolean hasSystemFeature = this.mPackageManager.hasSystemFeature("android.hardware.wifi");
        Log.v(TAG, "isWifiSupported: %b", Boolean.valueOf(hasSystemFeature));
        return hasSystemFeature;
    }

    public boolean isWifiThrottled() {
        int i = Build.VERSION.SDK_INT;
        if (checkPermission(this.mContext, ANDROID_PERMISSION_NETWORK_SETTINGS)) {
            Log.v(TAG, "isWifiThrottled: disabled because has NETWORK_SETTINGS permission", new Object[0]);
            return false;
        } else if (isWhiteListedPackage()) {
            Log.v(TAG, "isWifiThrottled: disabled because WiFi scan white listed", new Object[0]);
            return false;
        } else {
            boolean z = true;
            if (i >= 30) {
                if (!hasAccessWifiStatePermission()) {
                    Log.v(TAG, "Missing ACCESS_WIFI_STATE permission", new Object[0]);
                } else {
                    z = this.mWifiManager.isScanThrottleEnabled();
                }
                Log.v(TAG, "isWifiThrottled: enabled: %b", Boolean.valueOf(z));
                return z;
            } else if (Settings.Global.getInt(this.mContext.getContentResolver(), "development_settings_enabled", 0) != 1) {
                Log.v(TAG, "isWifiThrottled: enabled, since developer settings are disabled", new Object[0]);
                return true;
            } else if (Settings.Global.getInt(this.mContext.getContentResolver(), WIFI_SCAN_THROTTLE_ENABLED, 1) == 1) {
                Log.v(TAG, "isWifiThrottled: enabled by global setting", new Object[0]);
                return true;
            } else {
                Log.v(TAG, "isWifiThrottled: disabled", new Object[0]);
                return false;
            }
        }
    }

    public synchronized void open(IWifiManager.IWifiListener iWifiListener) {
        close();
        if (iWifiListener != null) {
            this.mWifiStatus = null;
            this.mListener = iWifiListener;
            registerWifiThrottleObserver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            this.mContext.registerReceiver(this.mWifiReceiver, intentFilter);
            pushWifiState();
        } else {
            throw new IllegalArgumentException("listener is null");
        }
    }

    public boolean startWifiScan() {
        boolean isWifiEnabled = isWifiEnabled();
        boolean isFlightModeOn = isFlightModeOn();
        boolean isScanAlwaysAvailable = isScanAlwaysAvailable();
        Log.v(TAG, "startWifiScan: isWifiEnabled: %b isScanAlwaysAvailable: %b isFlightModeOn: %b", Boolean.valueOf(isWifiEnabled), Boolean.valueOf(isScanAlwaysAvailable), Boolean.valueOf(isFlightModeOn));
        if (isWifiEnabled || (!isFlightModeOn && isScanAlwaysAvailable)) {
            if (!hasEnoughTimePassed()) {
                return this.mHandler.post(new Runnable() {
                    public void run() {
                        PlatformWifiManager.this.sendCachedScanResults();
                    }
                });
            }
            acquireWifiLock();
            if (this.mWifiManager.startScan()) {
                scanStarted();
                return true;
            }
            Log.w(TAG, "startWifiScan: startScan failed", new Object[0]);
            releaseWifiLock();
        }
        return false;
    }
}
