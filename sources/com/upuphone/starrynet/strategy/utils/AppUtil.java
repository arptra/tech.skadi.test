package com.upuphone.starrynet.strategy.utils;

import android.content.Context;
import android.provider.Settings;
import com.upuphone.starrynet.common.StLog;

public class AppUtil {
    public static boolean isLocServiceEnable(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException e) {
            try {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                StLog.e("AppUtil", "isLocServiceEnable", (Throwable) e2);
                return false;
            }
        }
    }
}
