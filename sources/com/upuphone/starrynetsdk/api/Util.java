package com.upuphone.starrynetsdk.api;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class Util {
    private static final Handler UI_THREAD_HANDLER = new Handler(Looper.getMainLooper());

    public static String getAppUniteCode(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                String string = bundle.getString("app_unite_code");
                if (string != null && !string.isEmpty()) {
                    return string;
                }
                throw new RuntimeException("app_unite_code not config");
            }
            throw new RuntimeException("app_unite_code not config");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Handler getUiThreadHandler() {
        return UI_THREAD_HANDLER;
    }

    public static void postOnUiThread(Runnable runnable) {
        UI_THREAD_HANDLER.post(runnable);
    }
}
