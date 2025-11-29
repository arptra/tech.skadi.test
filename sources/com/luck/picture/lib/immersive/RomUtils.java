package com.luck.picture.lib.immersive;

import android.os.Build;
import android.text.TextUtils;
import com.luck.picture.lib.utils.ValueOf;
import com.upuphone.starrynet.common.StarryNetConstant;
import java.util.regex.Pattern;

public class RomUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f9422a = {"samsung"};
    public static Integer b;

    public static class AvailableRomType {
    }

    public static String a() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : StarryNetConstant.DEVICE_NAME_UNKNOWN;
        } catch (Throwable unused) {
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        }
    }

    public static int b() {
        String str = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || !str.contains("Flyme")) {
            return 0;
        }
        return l(str.replaceAll("Flyme", "").replaceAll("OS", "").replaceAll(" ", "").substring(0, 1));
    }

    public static int c() {
        Integer num = b;
        if (num != null) {
            return num.intValue();
        }
        if (i()) {
            Integer num2 = 1;
            b = num2;
            return num2.intValue();
        } else if (h()) {
            Integer num3 = 2;
            b = num3;
            return num3.intValue();
        } else if (g()) {
            Integer num4 = 3;
            b = num4;
            return num4.intValue();
        } else {
            Integer num5 = 4;
            b = num5;
            return num5.intValue();
        }
    }

    public static int d() {
        String f = f();
        if (TextUtils.isEmpty(f)) {
            return 0;
        }
        try {
            return ValueOf.c(f);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String e() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : StarryNetConstant.DEVICE_NAME_UNKNOWN;
        } catch (Throwable unused) {
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035 A[SYNTHETIC, Splitter:B:16:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040 A[SYNTHETIC, Splitter:B:23:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String f() {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0031, all -> 0x002d }
            java.lang.String r2 = "getprop ro.miui.ui.version.code"
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ IOException -> 0x0031, all -> 0x002d }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0031, all -> 0x002d }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0031, all -> 0x002d }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x0031, all -> 0x002d }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0031, all -> 0x002d }
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r1)     // Catch:{ IOException -> 0x0031, all -> 0x002d }
            java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x003e, all -> 0x002b }
            r2.close()     // Catch:{ IOException -> 0x003e, all -> 0x002b }
            r2.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002a:
            return r1
        L_0x002b:
            r0 = move-exception
            goto L_0x0033
        L_0x002d:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x0033
        L_0x0031:
            r2 = r0
            goto L_0x003e
        L_0x0033:
            if (r2 == 0) goto L_0x003d
            r2.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r1 = move-exception
            r1.printStackTrace()
        L_0x003d:
            throw r0
        L_0x003e:
            if (r2 == 0) goto L_0x0048
            r2.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.immersive.RomUtils.f():java.lang.String");
    }

    public static boolean g() {
        return true;
    }

    public static boolean h() {
        return b() >= 4;
    }

    public static boolean i() {
        String f = f();
        if (TextUtils.isEmpty(f)) {
            return false;
        }
        try {
            return ValueOf.c(f) >= 4;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean j(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean k() {
        return j(a(), e(), f9422a);
    }

    public static int l(String str) {
        if (Pattern.compile("^[-\\+]?[\\d]+$").matcher(str).matches()) {
            return ValueOf.c(str);
        }
        return 0;
    }
}
