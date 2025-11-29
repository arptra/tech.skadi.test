package com.geetest.sdk;

public class y {
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012b A[Catch:{ Exception -> 0x0129 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r17) {
        /*
            java.lang.String r1 = "uuid"
            java.lang.String r2 = "4.4.2.1"
            java.lang.String r3 = ""
            android.content.pm.PackageManager r0 = r17.getPackageManager()
            java.lang.String r4 = "unknown"
            java.lang.String r5 = "null"
            java.lang.String r6 = r17.getPackageName()     // Catch:{ Exception -> 0x0022 }
            android.content.pm.ApplicationInfo r7 = r17.getApplicationInfo()     // Catch:{ Exception -> 0x001f }
            java.lang.CharSequence r0 = r0.getApplicationLabel(r7)     // Catch:{ Exception -> 0x001f }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x001f }
            r5 = r0
            r7 = r2
            goto L_0x0028
        L_0x001f:
            r0 = move-exception
            r7 = r2
            goto L_0x0025
        L_0x0022:
            r0 = move-exception
            r7 = r4
            r6 = r5
        L_0x0025:
            r0.printStackTrace()
        L_0x0028:
            java.lang.String r0 = android.os.Build.BRAND
            if (r0 != 0) goto L_0x002d
            r0 = r4
        L_0x002d:
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r8 = r8.getLanguage()
            if (r8 != 0) goto L_0x0039
            r8 = r4
            goto L_0x0041
        L_0x0039:
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r8 = r8.getLanguage()
        L_0x0041:
            java.lang.String r9 = android.os.Build.VERSION.RELEASE
            if (r9 != 0) goto L_0x0046
            r9 = r4
        L_0x0046:
            java.util.Locale r10 = java.util.Locale.getDefault()
            java.lang.String r10 = r10.getCountry()
            if (r10 != 0) goto L_0x0052
            r10 = r4
            goto L_0x005a
        L_0x0052:
            java.util.Locale r10 = java.util.Locale.getDefault()
            java.lang.String r10 = r10.getCountry()
        L_0x005a:
            android.content.Context r11 = r17.getApplicationContext()
            android.content.res.Resources r11 = r11.getResources()
            android.util.DisplayMetrics r11 = r11.getDisplayMetrics()
            int r12 = r11.widthPixels
            int r11 = r11.heightPixels
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            java.lang.String r14 = "build"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0129 }
            r15.<init>()     // Catch:{ Exception -> 0x0129 }
            r16 = r1
            r1 = 4040100(0x3da5a4, float:5.661386E-39)
            r15.append(r1)     // Catch:{ Exception -> 0x0129 }
            r15.append(r3)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r1 = r15.toString()     // Catch:{ Exception -> 0x0129 }
            r13.put(r14, r1)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r1 = "release"
            r13.put(r1, r7)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r1 = "br"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0129 }
            r7.<init>()     // Catch:{ Exception -> 0x0129 }
            float r14 = com.geetest.sdk.utils.j.a(r17)     // Catch:{ Exception -> 0x0129 }
            r7.append(r14)     // Catch:{ Exception -> 0x0129 }
            r7.append(r3)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0129 }
            r13.put(r1, r7)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r1 = "bs"
            org.json.JSONObject r7 = com.geetest.sdk.utils.j.d(r17)     // Catch:{ Exception -> 0x0129 }
            r13.put(r1, r7)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r1 = "cell"
            java.lang.String r7 = com.geetest.sdk.utils.p.b(r17)     // Catch:{ Exception -> 0x0129 }
            r13.put(r1, r7)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r1 = "coun"
            r13.put(r1, r10)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r1 = "dh"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0129 }
            r7.<init>()     // Catch:{ Exception -> 0x0129 }
            r7.append(r11)     // Catch:{ Exception -> 0x0129 }
            r7.append(r3)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0129 }
            r13.put(r1, r7)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r1 = "dm"
            r13.put(r1, r0)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "dns"
            java.lang.String r1 = com.geetest.sdk.utils.j.c()     // Catch:{ Exception -> 0x0129 }
            r13.put(r0, r1)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "dw"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0129 }
            r1.<init>()     // Catch:{ Exception -> 0x0129 }
            r1.append(r12)     // Catch:{ Exception -> 0x0129 }
            r1.append(r3)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0129 }
            r13.put(r0, r1)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "lang"
            r13.put(r0, r8)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "mems"
            java.lang.String r1 = com.geetest.sdk.utils.j.b()     // Catch:{ Exception -> 0x0129 }
            r13.put(r0, r1)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "ostype"
            java.lang.String r1 = "android"
            r13.put(r0, r1)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "osver"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0129 }
            r1.<init>()     // Catch:{ Exception -> 0x0129 }
            r1.append(r9)     // Catch:{ Exception -> 0x0129 }
            r1.append(r3)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0129 }
            r13.put(r0, r1)     // Catch:{ Exception -> 0x0129 }
            boolean r0 = com.geetest.sdk.utils.j.e(r17)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r1 = "py"
            if (r0 == 0) goto L_0x012b
            java.lang.String r0 = "1"
            r13.put(r1, r0)     // Catch:{ Exception -> 0x0129 }
            goto L_0x0130
        L_0x0129:
            r0 = move-exception
            goto L_0x0194
        L_0x012b:
            java.lang.String r0 = "0"
            r13.put(r1, r0)     // Catch:{ Exception -> 0x0129 }
        L_0x0130:
            java.lang.String r0 = "ts"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0129 }
            r1.<init>()     // Catch:{ Exception -> 0x0129 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0129 }
            r1.append(r7)     // Catch:{ Exception -> 0x0129 }
            r1.append(r3)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0129 }
            r13.put(r0, r1)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "vendor"
            r13.put(r0, r6)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "app"
            java.lang.String r1 = "UTF-8"
            java.lang.String r1 = java.net.URLEncoder.encode(r5, r1)     // Catch:{ Exception -> 0x0129 }
            r13.put(r0, r1)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "gt3"
            r13.put(r0, r2)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "mydata"
            r1 = 0
            r2 = r17
            android.content.SharedPreferences r0 = r2.getSharedPreferences(r0, r1)     // Catch:{ Exception -> 0x0129 }
            r1 = r16
            java.lang.String r0 = r0.getString(r1, r4)     // Catch:{ Exception -> 0x0129 }
            r13.put(r1, r0)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "jbd"
            int r1 = com.geetest.sdk.utils.b.b()     // Catch:{ Exception -> 0x0129 }
            r13.put(r0, r1)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "sim"
            int r1 = com.geetest.sdk.utils.a.a(r17)     // Catch:{ Exception -> 0x0129 }
            r13.put(r0, r1)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "deb"
            int r1 = com.geetest.sdk.utils.e.c(r17)     // Catch:{ Exception -> 0x0129 }
            r13.put(r0, r1)     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = "tam"
            int r1 = com.geetest.sdk.utils.w.c()     // Catch:{ Exception -> 0x0129 }
            r13.put(r0, r1)     // Catch:{ Exception -> 0x0129 }
            goto L_0x0197
        L_0x0194:
            r0.printStackTrace()
        L_0x0197:
            java.lang.String r0 = r13.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.y.a(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        if (r2.toString() == null) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r4, org.json.JSONObject r5) {
        /*
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "os"
            java.lang.String r1 = "android"
            r5.put(r0, r1)
            java.lang.String r0 = android.os.Build.BRAND
            java.lang.String r1 = "null"
            if (r0 != 0) goto L_0x0011
            goto L_0x0024
        L_0x0011:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = android.os.Build.MODEL
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            if (r2 != 0) goto L_0x0025
        L_0x0024:
            r0 = r1
        L_0x0025:
            java.lang.String r2 = "mo"
            r5.put(r2, r0)
            java.lang.String r0 = android.os.Build.VERSION.RELEASE
            if (r0 != 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r1 = r0
        L_0x0030:
            java.lang.String r0 = "ver"
            r5.put(r0, r1)
            java.lang.String r0 = com.geetest.sdk.utils.p.b(r4)
            java.lang.String r1 = "net"
            r5.put(r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.geetest.sdk.utils.f.b(r4)
            r0.append(r1)
            java.lang.String r1 = ""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "build"
            r5.put(r2, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = com.geetest.sdk.utils.f.b(r4)
            r0.append(r2)
            java.lang.String r2 = ".0"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "release"
            r5.put(r2, r0)
            java.lang.String r4 = com.geetest.sdk.utils.f.a(r4)
            java.lang.String r0 = "vendor"
            r5.put(r0, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            long r2 = java.lang.System.currentTimeMillis()
            r4.append(r2)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String r0 = "time"
            r5.put(r0, r4)
            java.lang.String r4 = "gt3"
            java.lang.String r0 = "4.4.2.1"
            r5.put(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.y.b(android.content.Context, org.json.JSONObject):void");
    }
}
