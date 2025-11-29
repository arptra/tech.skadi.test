package com.here.odnp.util;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;

public class OdnpPreferences {
    public static final String KEY_LAST_USE_BOOT_COUNT = "wifiScanBootCount";
    public static final String KEY_UPLOAD_REQUIRES_CHARGING = "uploadCharging";
    public static final String KEY_UPLOAD_REQUIRES_IDLE = "uploadIdle";
    public static final String KEY_WIFI_SCAN_TIME = "wifiScanTime";
    public static final long NOT_SET = Long.MIN_VALUE;
    private static final String PREFERENCES_NAME = "odnp_prefs";
    private final SharedPreferences mSharedPrefs;

    public OdnpPreferences(@NonNull Context context) {
        this.mSharedPrefs = context.getSharedPreferences(PREFERENCES_NAME, 0);
    }

    public boolean getBoolean(String str) {
        return this.mSharedPrefs.getBoolean(str, false);
    }

    public long getLong(String str) {
        return this.mSharedPrefs.getLong(str, Long.MIN_VALUE);
    }

    public boolean put(String str, long j) {
        SharedPreferences.Editor edit = this.mSharedPrefs.edit();
        edit.putLong(str, j);
        return edit.commit();
    }

    public boolean reset(String str) {
        SharedPreferences.Editor edit = this.mSharedPrefs.edit();
        edit.remove(str);
        return edit.commit();
    }

    public boolean put(String str, boolean z) {
        SharedPreferences.Editor edit = this.mSharedPrefs.edit();
        edit.putBoolean(str, z);
        return edit.commit();
    }
}
