package com.upuphone.starrynet.common.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.upuphone.starrynet.common.StLog;
import java.lang.reflect.InvocationTargetException;

public class WifiUtil {
    private static final String TAG = "WifiUtil";

    private WifiUtil() {
    }

    public static void allowAutoJoinGlobal(Context context, boolean z) {
        WifiManager wifiManager;
        if (context != null && (wifiManager = (WifiManager) context.getSystemService("wifi")) != null) {
            try {
                wifiManager.getClass().getDeclaredMethod("allowAutojoinGlobal", new Class[]{Boolean.TYPE}).invoke(wifiManager, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                StLog.e(TAG, "closeAp", e);
            }
        }
    }

    public static void disconnectWifi(Context context) {
        WifiManager wifiManager;
        if (context != null && (wifiManager = (WifiManager) context.getSystemService("wifi")) != null && wifiManager.getConnectionInfo() != null) {
            wifiManager.disconnect();
        }
    }

    public static boolean is24G(int i) {
        return i > 2400 && i < 2500;
    }

    public static boolean is5G(int i) {
        return i > 4900 && i < 5900;
    }
}
