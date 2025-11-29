package com.upuphone.datatrack.base.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.core.content.ContextCompat;
import org.eclipse.jetty.util.security.Constraint;

public class NetWorkUtil {
    public static String a(Context context) {
        return "";
    }

    public static String b(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            Log.d("NetWorkUtil", "缺少读取网络状态权限");
            return "UNKNOWN";
        } else if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0) {
            Log.d("NetWorkUtil", "缺少读取手机状态权限");
            return "UNKNOWN";
        } else {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return Constraint.NONE;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (networkCapabilities == null) {
                if (d(context)) {
                    return "AIRPLANE_MODE";
                }
                int simState = telephonyManager.getSimState();
                return (simState == 1 || simState == 0) ? "NO_SIM_CARD" : Constraint.NONE;
            } else if (networkCapabilities.hasTransport(1)) {
                return "WIFI";
            } else {
                try {
                    switch (telephonyManager.getDataNetworkType()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            return "3G";
                        case 13:
                            return "4G";
                        case 18:
                            return "WIFI";
                        case 20:
                            return "5G";
                        default:
                            return "UNKNOWN";
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return "UNKNOWN";
                }
            }
        }
    }

    public static String c(Context context) {
        return "";
    }

    public static boolean d(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public static boolean e(Context context) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(12);
    }

    public static boolean f(Context context) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1);
    }
}
