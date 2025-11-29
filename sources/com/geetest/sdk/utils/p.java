package com.geetest.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class p {
    public static boolean a(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (!(connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null)) {
                int length = allNetworkInfo.length;
                int i = 0;
                while (i < length && allNetworkInfo[i].getState() != NetworkInfo.State.CONNECTED) {
                    i++;
                }
                return true;
            }
        } catch (Exception unused) {
        }
        return true;
    }

    public static String b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                    return "WIFI";
                }
                if (networkInfo != null) {
                    NetworkInfo.State state = networkInfo.getState();
                    String subtypeName = networkInfo.getSubtypeName();
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (!(state == null || activeNetworkInfo == null)) {
                        switch (activeNetworkInfo.getSubtype()) {
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
                                return "3G";
                            case 13:
                            case 18:
                            case 19:
                                return "4G";
                            case 20:
                                return "5G";
                            default:
                                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? "3G" : "NULL";
                        }
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "NULL";
    }
}
