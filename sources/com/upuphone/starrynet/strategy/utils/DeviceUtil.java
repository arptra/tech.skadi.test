package com.upuphone.starrynet.strategy.utils;

import android.os.Build;
import com.ucar.vehiclesdk.MDevice;

public class DeviceUtil {
    public static boolean isHarmonyOs() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "Harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", (Class[]) null).invoke(cls, (Object[]) null).toString());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isInfinixPhone() {
        return Build.MANUFACTURER.trim().toLowerCase().indexOf("infinix") != -1;
    }

    public static boolean isMotoPhone() {
        return Build.MANUFACTURER.trim().toLowerCase().indexOf("motorola") != -1;
    }

    public static boolean isOppoPhone() {
        return Build.MANUFACTURER.trim().toLowerCase().indexOf(MDevice.MANUFACTURERS_OPPO) != -1;
    }

    public static boolean isSamSungPhone() {
        return Build.MANUFACTURER.trim().toLowerCase().indexOf("samsung") != -1;
    }

    public static boolean isVIVOPhone() {
        return Build.MANUFACTURER.trim().toLowerCase().indexOf(MDevice.MANUFACTURERS_VIVO) != -1;
    }

    public static boolean isXiaomiPhone() {
        return Build.MANUFACTURER.trim().toLowerCase().indexOf(MDevice.MANUFACTURERS_XIAOMI) != -1;
    }
}
