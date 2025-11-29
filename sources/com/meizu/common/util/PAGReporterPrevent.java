package com.meizu.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.libpag.PAG;

public class PAGReporterPrevent {
    private static final String PAG_REPORT_TIME_KEY = "pag_report_time";
    private static final String PAG_VERSION_KEY = "last_pag_version";
    private static final String REPORTED = "Reported";
    private static final String TAG = " [PAGReporterPrevent] ";

    private static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM").format(new Date());
    }

    private static String getSdkVersion() {
        try {
            return PAG.SDKVersion();
        } catch (UnsatisfiedLinkError unused) {
            return null;
        }
    }

    public static void init(Context context) {
        log("init");
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("pag_reporter", 0);
            if (sharedPreferences == null) {
                log("prefs null");
            } else if (!isClassExists("org.libpag.PAG")) {
                log("not find org.libpag.PAG class ");
            } else {
                String sdkVersion = getSdkVersion();
                if (TextUtils.isEmpty(sdkVersion)) {
                    log("sdkVersion is null");
                    return;
                }
                String string = sharedPreferences.getString(PAG_VERSION_KEY, "");
                String string2 = sharedPreferences.getString(PAG_REPORT_TIME_KEY, "");
                String currentDate = getCurrentDate();
                if (!sdkVersion.equals(string) || !currentDate.equals(string2)) {
                    writeData(sharedPreferences);
                } else {
                    log("not need update");
                }
            }
        } catch (Exception e) {
            log("init error:" + e);
        }
    }

    public static boolean isClassExists(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static void log(String str) {
        Log.i(TAG, str);
    }

    private static void writeData(SharedPreferences sharedPreferences) {
        log("writeData");
        String sdkVersion = getSdkVersion();
        if (TextUtils.isEmpty(sdkVersion)) {
            log("sdkVersion is null");
            return;
        }
        String currentDate = getCurrentDate();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(PAG_VERSION_KEY, sdkVersion);
        edit.putString(PAG_REPORT_TIME_KEY, currentDate);
        edit.commit();
    }
}
