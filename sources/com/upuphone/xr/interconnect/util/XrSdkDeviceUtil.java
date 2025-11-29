package com.upuphone.xr.interconnect.util;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothManager;
import android.net.wifi.WifiManager;
import androidx.core.content.ContextCompat;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.util.log.ILog;

public class XrSdkDeviceUtil {
    private static final String TAG = "XrSdkDeviceUtil";
    static boolean isIntl = false;
    static boolean isThirdPhone = false;

    private XrSdkDeviceUtil() {
    }

    @SuppressLint({"HardwareIds"})
    public static String getBluetoothAddress() {
        if (ContextCompat.checkSelfPermission(InterconnectManager.getInstance().getContext(), "android.permission.BLUETOOTH_CONNECT") != 0) {
            return null;
        }
        return ((BluetoothManager) InterconnectManager.getInstance().getContext().getSystemService("bluetooth")).getAdapter().getAddress();
    }

    public static String getDeviceIpv4() {
        WifiManager wifiManager = (WifiManager) InterconnectManager.getInstance().getContext().getSystemService("wifi");
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
        return intToIp(wifiManager.getConnectionInfo().getIpAddress());
    }

    public static String getMacAddress() {
        WifiManager wifiManager = (WifiManager) InterconnectManager.getInstance().getContext().getApplicationContext().getSystemService("wifi");
        String str = null;
        try {
            String[] strArr = (String[]) WifiManager.class.getDeclaredMethod("getFactoryMacAddresses", (Class[]) null).invoke(wifiManager, (Object[]) null);
            if (strArr != null && strArr.length > 0) {
                str = strArr[0];
            }
        } catch (Exception e) {
            ILog.w(TAG, "Mac getting threw: " + e.getLocalizedMessage() + "!");
        }
        return str == null ? wifiManager.getConnectionInfo().getMacAddress() : str;
    }

    private static String intToIp(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public static boolean isIsIntl() {
        return isIntl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0090 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isSystemApplication(@org.jetbrains.annotations.NotNull android.content.Context r8) {
        /*
            java.lang.String r0 = "XrSdkDeviceUtil"
            android.content.pm.PackageManager r1 = r8.getPackageManager()
            r2 = 1000(0x3e8, float:1.401E-42)
            int r3 = android.os.Process.myUid()
            int r2 = r1.checkSignatures(r3, r2)
            r3 = 1
            r4 = 0
            if (r2 < 0) goto L_0x0016
            r2 = r3
            goto L_0x0017
        L_0x0016:
            r2 = r4
        L_0x0017:
            java.lang.String r5 = r8.getPackageName()     // Catch:{ NameNotFoundException -> 0x0036 }
            r6 = 16384(0x4000, float:2.2959E-41)
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r5, r6)     // Catch:{ NameNotFoundException -> 0x0036 }
            java.lang.String r5 = "android.uid.system"
            if (r1 == 0) goto L_0x0039
            java.lang.String r6 = r1.sharedUserId     // Catch:{ NameNotFoundException -> 0x0036 }
            boolean r5 = r5.equals(r6)     // Catch:{ NameNotFoundException -> 0x0036 }
            android.content.pm.ApplicationInfo r1 = r1.applicationInfo     // Catch:{ NameNotFoundException -> 0x0034 }
            int r1 = r1.flags     // Catch:{ NameNotFoundException -> 0x0034 }
            r1 = r1 & r3
            if (r1 != r3) goto L_0x0059
            r1 = r3
            goto L_0x005a
        L_0x0034:
            r1 = move-exception
            goto L_0x003c
        L_0x0036:
            r1 = move-exception
            r5 = r4
            goto L_0x003c
        L_0x0039:
            r1 = r4
            r5 = r1
            goto L_0x005a
        L_0x003c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Package lookup threw: "
            r6.append(r7)
            java.lang.String r1 = r1.getLocalizedMessage()
            r6.append(r1)
            java.lang.String r1 = "!"
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            com.upuphone.xr.interconnect.util.log.ILog.w(r0, r1)
        L_0x0059:
            r1 = r4
        L_0x005a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "检查--"
            r6.append(r7)
            java.lang.String r8 = r8.getPackageName()
            r6.append(r8)
            java.lang.String r8 = "是否是系统App，有系统签名--"
            r6.append(r8)
            r6.append(r2)
            java.lang.String r8 = "，sharedUserId是android.uid.system--"
            r6.append(r8)
            r6.append(r5)
            java.lang.String r8 = "，ApplicationInfo flags有FLAG_SYSTEM--"
            r6.append(r8)
            r6.append(r1)
            java.lang.String r8 = r6.toString()
            com.upuphone.xr.interconnect.util.log.ILog.d(r0, r8)
            if (r2 == 0) goto L_0x0093
            if (r5 == 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r3 = r4
        L_0x0094:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.util.XrSdkDeviceUtil.isSystemApplication(android.content.Context):boolean");
    }

    public static boolean isThirdPhone() {
        return isThirdPhone;
    }

    public static void setIsIntl(boolean z) {
        isIntl = z;
    }

    public static void setThirdPhone(boolean z) {
        ULog.m(TAG, "setThirdPhone = " + z);
        isThirdPhone = z;
    }
}
