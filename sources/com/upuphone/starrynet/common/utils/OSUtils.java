package com.upuphone.starrynet.common.utils;

import android.text.TextUtils;

public class OSUtils {
    private static final String KEY_COLOROS_VERSION_NAME = "ro.build.version.opporom";
    private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    private static final String KEY_FLYME_VERSION_NAME = "ro.build.display.id";
    private static final String KEY_HARMONYOS_VERSION_NAME = "hw_sc.build.platform.version";
    private static final String KEY_MAGICUI_VERSION = "ro.build.version.magic";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_NUBIA_VERSION_CODE = "ro.build.nubia.rom.code";
    private static final String KEY_NUBIA_VERSION_NAME = "ro.build.nubia.rom.name";
    private static final String KEY_ONEPLUS_VERSION_NAME = "ro.rom.version";
    private static final String KEY_VIVO_VERSION = "ro.vivo.os.version";
    private static final String KEY_VIVO_VERSION_NAME = "ro.vivo.os.name";
    private static String customOS = "";
    private static String customOSVersion = "";

    public static String deleteSpaceAndToUpperCase(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll(" ", "").toUpperCase();
    }

    public static String getCustomOS(String str) {
        if (TextUtils.isEmpty(customOS)) {
            setCustomOSInfo(str);
        }
        return customOS;
    }

    public static String getCustomOSVersion(String str) {
        if (TextUtils.isEmpty(customOS)) {
            setCustomOSInfo(str);
        }
        return customOSVersion;
    }

    public static String getCustomOSVersionSimple(String str) {
        String str2 = customOSVersion;
        if (TextUtils.isEmpty(customOS)) {
            getCustomOSVersion(str);
        }
        if (!customOSVersion.contains(".")) {
            return str2;
        }
        return customOSVersion.substring(0, customOSVersion.indexOf("."));
    }

    private static String getHarmonySystemPropertyValue() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", (Class[]) null).invoke(cls, (Object[]) null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getPhoneSystem(String str) {
        if (TextUtils.isEmpty(customOS)) {
            setCustomOSInfo(str);
        }
        return customOS + customOSVersion;
    }

    private static String getSystemPropertyValue(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean isHarmonyOS() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", (Class[]) null).invoke(cls, (Object[]) null));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isMagicUI() {
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void setCustomOSInfo(java.lang.String r5) {
        /*
            java.lang.String r0 = "ro.build.version.magic"
            java.lang.String r5 = deleteSpaceAndToUpperCase(r5)     // Catch:{ Exception -> 0x0019 }
            int r1 = r5.hashCode()     // Catch:{ Exception -> 0x0019 }
            switch(r1) {
                case -1881642058: goto L_0x006e;
                case -1706170181: goto L_0x0064;
                case -602397472: goto L_0x005a;
                case 2432928: goto L_0x0050;
                case 2634924: goto L_0x0046;
                case 68924490: goto L_0x003c;
                case 73239724: goto L_0x0031;
                case 74632627: goto L_0x0026;
                case 77852109: goto L_0x001c;
                case 2141820391: goto L_0x000f;
                default: goto L_0x000d;
            }     // Catch:{ Exception -> 0x0019 }
        L_0x000d:
            goto L_0x0078
        L_0x000f:
            java.lang.String r1 = "HUAWEI"
            boolean r5 = r5.equals(r1)     // Catch:{ Exception -> 0x0019 }
            if (r5 == 0) goto L_0x0078
            r5 = 0
            goto L_0x0079
        L_0x0019:
            r5 = move-exception
            goto L_0x0138
        L_0x001c:
            java.lang.String r1 = "REDMI"
            boolean r5 = r5.equals(r1)     // Catch:{ Exception -> 0x0019 }
            if (r5 == 0) goto L_0x0078
            r5 = 3
            goto L_0x0079
        L_0x0026:
            java.lang.String r1 = "NUBIA"
            boolean r5 = r5.equals(r1)     // Catch:{ Exception -> 0x0019 }
            if (r5 == 0) goto L_0x0078
            r5 = 9
            goto L_0x0079
        L_0x0031:
            java.lang.String r1 = "MEIZU"
            boolean r5 = r5.equals(r1)     // Catch:{ Exception -> 0x0019 }
            if (r5 == 0) goto L_0x0078
            r5 = 8
            goto L_0x0079
        L_0x003c:
            java.lang.String r1 = "HONOR"
            boolean r5 = r5.equals(r1)     // Catch:{ Exception -> 0x0019 }
            if (r5 == 0) goto L_0x0078
            r5 = 1
            goto L_0x0079
        L_0x0046:
            java.lang.String r1 = "VIVO"
            boolean r5 = r5.equals(r1)     // Catch:{ Exception -> 0x0019 }
            if (r5 == 0) goto L_0x0078
            r5 = 6
            goto L_0x0079
        L_0x0050:
            java.lang.String r1 = "OPPO"
            boolean r5 = r5.equals(r1)     // Catch:{ Exception -> 0x0019 }
            if (r5 == 0) goto L_0x0078
            r5 = 5
            goto L_0x0079
        L_0x005a:
            java.lang.String r1 = "ONEPLUS"
            boolean r5 = r5.equals(r1)     // Catch:{ Exception -> 0x0019 }
            if (r5 == 0) goto L_0x0078
            r5 = 7
            goto L_0x0079
        L_0x0064:
            java.lang.String r1 = "XIAOMI"
            boolean r5 = r5.equals(r1)     // Catch:{ Exception -> 0x0019 }
            if (r5 == 0) goto L_0x0078
            r5 = 2
            goto L_0x0079
        L_0x006e:
            java.lang.String r1 = "REALME"
            boolean r5 = r5.equals(r1)     // Catch:{ Exception -> 0x0019 }
            if (r5 == 0) goto L_0x0078
            r5 = 4
            goto L_0x0079
        L_0x0078:
            r5 = -1
        L_0x0079:
            java.lang.String r1 = "ro.build.version.emui"
            java.lang.String r2 = "EMUI"
            java.lang.String r3 = "HarmonyOS"
            java.lang.String r4 = "hw_sc.build.platform.version"
            switch(r5) {
                case 0: goto L_0x0120;
                case 1: goto L_0x00e4;
                case 2: goto L_0x00d7;
                case 3: goto L_0x00d7;
                case 4: goto L_0x00ca;
                case 5: goto L_0x00ca;
                case 6: goto L_0x00bc;
                case 7: goto L_0x00ae;
                case 8: goto L_0x00a0;
                case 9: goto L_0x008e;
                default: goto L_0x0084;
            }
        L_0x0084:
            java.lang.String r5 = "Android"
            customOS = r5     // Catch:{ Exception -> 0x0019 }
            java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x0019 }
            customOSVersion = r5     // Catch:{ Exception -> 0x0019 }
            goto L_0x013b
        L_0x008e:
            java.lang.String r5 = "ro.build.nubia.rom.name"
            java.lang.String r5 = getSystemPropertyValue(r5)     // Catch:{ Exception -> 0x0019 }
            customOS = r5     // Catch:{ Exception -> 0x0019 }
            java.lang.String r5 = "ro.build.nubia.rom.code"
            java.lang.String r5 = getSystemPropertyValue(r5)     // Catch:{ Exception -> 0x0019 }
            customOSVersion = r5     // Catch:{ Exception -> 0x0019 }
            goto L_0x013b
        L_0x00a0:
            java.lang.String r5 = "Flyme"
            customOS = r5     // Catch:{ Exception -> 0x0019 }
            java.lang.String r5 = "ro.build.display.id"
            java.lang.String r5 = getSystemPropertyValue(r5)     // Catch:{ Exception -> 0x0019 }
            customOSVersion = r5     // Catch:{ Exception -> 0x0019 }
            goto L_0x013b
        L_0x00ae:
            java.lang.String r5 = "HydrogenOS"
            customOS = r5     // Catch:{ Exception -> 0x0019 }
            java.lang.String r5 = "ro.rom.version"
            java.lang.String r5 = getSystemPropertyValue(r5)     // Catch:{ Exception -> 0x0019 }
            customOSVersion = r5     // Catch:{ Exception -> 0x0019 }
            goto L_0x013b
        L_0x00bc:
            java.lang.String r5 = "Funtouch"
            customOS = r5     // Catch:{ Exception -> 0x0019 }
            java.lang.String r5 = "ro.vivo.os.version"
            java.lang.String r5 = getSystemPropertyValue(r5)     // Catch:{ Exception -> 0x0019 }
            customOSVersion = r5     // Catch:{ Exception -> 0x0019 }
            goto L_0x013b
        L_0x00ca:
            java.lang.String r5 = "ColorOS"
            customOS = r5     // Catch:{ Exception -> 0x0019 }
            java.lang.String r5 = "ro.build.version.opporom"
            java.lang.String r5 = getSystemPropertyValue(r5)     // Catch:{ Exception -> 0x0019 }
            customOSVersion = r5     // Catch:{ Exception -> 0x0019 }
            goto L_0x013b
        L_0x00d7:
            java.lang.String r5 = "MIUI"
            customOS = r5     // Catch:{ Exception -> 0x0019 }
            java.lang.String r5 = "ro.miui.ui.version.name"
            java.lang.String r5 = getSystemPropertyValue(r5)     // Catch:{ Exception -> 0x0019 }
            customOSVersion = r5     // Catch:{ Exception -> 0x0019 }
            goto L_0x013b
        L_0x00e4:
            boolean r5 = isHarmonyOS()     // Catch:{ Exception -> 0x0019 }
            if (r5 == 0) goto L_0x0102
            customOS = r3     // Catch:{ Exception -> 0x0019 }
            java.lang.String r5 = getSystemPropertyValue(r4)     // Catch:{ Exception -> 0x0019 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0019 }
            if (r5 != 0) goto L_0x00fd
            java.lang.String r5 = getSystemPropertyValue(r4)     // Catch:{ Exception -> 0x0019 }
            customOSVersion = r5     // Catch:{ Exception -> 0x0019 }
            goto L_0x013b
        L_0x00fd:
            java.lang.String r5 = ""
            customOSVersion = r5     // Catch:{ Exception -> 0x0019 }
            goto L_0x013b
        L_0x0102:
            java.lang.String r5 = getSystemPropertyValue(r0)     // Catch:{ Exception -> 0x0019 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0019 }
            if (r5 != 0) goto L_0x0117
            java.lang.String r5 = "MagicUI"
            customOS = r5     // Catch:{ Exception -> 0x0019 }
            java.lang.String r5 = getSystemPropertyValue(r0)     // Catch:{ Exception -> 0x0019 }
            customOSVersion = r5     // Catch:{ Exception -> 0x0019 }
            goto L_0x013b
        L_0x0117:
            customOS = r2     // Catch:{ Exception -> 0x0019 }
            java.lang.String r5 = getSystemPropertyValue(r1)     // Catch:{ Exception -> 0x0019 }
            customOSVersion = r5     // Catch:{ Exception -> 0x0019 }
            goto L_0x013b
        L_0x0120:
            boolean r5 = isHarmonyOS()     // Catch:{ Exception -> 0x0019 }
            if (r5 == 0) goto L_0x012f
            java.lang.String r5 = getSystemPropertyValue(r4)     // Catch:{ Exception -> 0x0019 }
            customOSVersion = r5     // Catch:{ Exception -> 0x0019 }
            customOS = r3     // Catch:{ Exception -> 0x0019 }
            goto L_0x013b
        L_0x012f:
            customOS = r2     // Catch:{ Exception -> 0x0019 }
            java.lang.String r5 = getSystemPropertyValue(r1)     // Catch:{ Exception -> 0x0019 }
            customOSVersion = r5     // Catch:{ Exception -> 0x0019 }
            goto L_0x013b
        L_0x0138:
            r5.printStackTrace()
        L_0x013b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.common.utils.OSUtils.setCustomOSInfo(java.lang.String):void");
    }
}
