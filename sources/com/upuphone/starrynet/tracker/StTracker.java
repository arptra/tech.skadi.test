package com.upuphone.starrynet.tracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.starrynet.tracker.reporter.IReporter;
import java.util.Map;

public class StTracker {
    private static final String TAG = "StTracker";
    private boolean isInit;
    private String ownDeviceID;
    private int ownTerminalType;
    private IReporter reporter;

    public static class Holder {
        static final StTracker INSTANCE = new StTracker();

        private Holder() {
        }
    }

    public static StTracker getInstance() {
        return Holder.INSTANCE;
    }

    public String getOwnDeviceID() {
        return this.ownDeviceID;
    }

    public int getOwnTerminalType() {
        return this.ownTerminalType;
    }

    public boolean init(Context context, int i, TrackerConfig trackerConfig) {
        if (this.isInit) {
            Log.d(TAG, "StTracker had init, return!");
            return false;
        }
        Log.d(TAG, "init, StTracker SDK version =2.6.7");
        this.ownTerminalType = i;
        this.ownDeviceID = trackerConfig.getOwnDeviceID();
        this.isInit = this.reporter.init(context, trackerConfig);
        Log.d(TAG, "init result=" + this.isInit);
        return this.isInit;
    }

    public boolean report3rdEvent(@NonNull String str, @Nullable Map<String, Object> map, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            Log.d(TAG, "report3rdEvent eventName is empty!");
            return false;
        } else if (!this.isInit) {
            return false;
        } else {
            return this.reporter.report3rdEvent(str, map, str2, str3, str4);
        }
    }

    public boolean reportEvent(@NonNull String str, @Nullable Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            Log.d(TAG, "reportEventRealtime eventName is empty!");
            return false;
        } else if (!this.isInit) {
            return false;
        } else {
            return this.reporter.reportEvent(str, map);
        }
    }

    public boolean reportEventRealtime(@NonNull String str, @Nullable Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            Log.d(TAG, "reportEventRealtime eventName is empty!");
            return false;
        } else if (!this.isInit) {
            return false;
        } else {
            return this.reporter.reportEventRealtime(str, map);
        }
    }

    private StTracker() {
        this.isInit = false;
        this.reporter = BuildConfig.TRACKER_REPORTER;
    }
}
