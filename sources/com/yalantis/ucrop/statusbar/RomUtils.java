package com.yalantis.ucrop.statusbar;

import android.os.Build;
import android.text.TextUtils;
import java.util.regex.Pattern;

public class RomUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f8747a = {"samsung"};
    public static Integer b;

    public static class AvailableRomType {
    }

    public static int a() {
        String str = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || !str.contains("Flyme")) {
            return 0;
        }
        return h(str.replaceAll("Flyme", "").replaceAll("OS", "").replaceAll(" ", "").substring(0, 1));
    }

    public static int b() {
        Integer num = b;
        if (num != null) {
            return num.intValue();
        }
        if (g()) {
            Integer num2 = 1;
            b = num2;
            return num2.intValue();
        } else if (f()) {
            Integer num3 = 2;
            b = num3;
            return num3.intValue();
        } else if (e()) {
            Integer num4 = 3;
            b = num4;
            return num4.intValue();
        } else {
            Integer num5 = 4;
            b = num5;
            return num5.intValue();
        }
    }

    public static int c() {
        String d = d();
        if (TextUtils.isEmpty(d)) {
            return 0;
        }
        try {
            return i(d);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035 A[SYNTHETIC, Splitter:B:16:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040 A[SYNTHETIC, Splitter:B:23:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.statusbar.RomUtils.d():java.lang.String");
    }

    public static boolean e() {
        return true;
    }

    public static boolean f() {
        return a() >= 4;
    }

    public static boolean g() {
        String d = d();
        if (TextUtils.isEmpty(d)) {
            return false;
        }
        try {
            return i(d) >= 4;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int h(String str) {
        if (Pattern.compile("^[-\\+]?[\\d]+$").matcher(str).matches()) {
            return i(str);
        }
        return 0;
    }

    public static int i(Object obj) {
        return j(obj, 0);
    }

    public static int j(Object obj, int i) {
        if (obj == null) {
            return i;
        }
        try {
            String trim = obj.toString().trim();
            return trim.contains(".") ? Integer.parseInt(trim.substring(0, trim.lastIndexOf("."))) : Integer.parseInt(trim);
        } catch (Exception unused) {
            return i;
        }
    }
}
