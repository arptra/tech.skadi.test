package com.geetest.sdk.utils;

import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;

public class w {
    public static boolean a() {
        try {
            throw new Exception("Deteck hook");
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                if ("com.android.internal.os.ZygoteInit".equals(stackTraceElement.getClassName()) && (i2 = i2 + 1) == 2) {
                    l.e("Geetest", "Substrate is active on the device.");
                    return true;
                } else if ("com.saurik.substrate.MS$2".equals(stackTraceElement.getClassName()) && "invoke".equals(stackTraceElement.getMethodName())) {
                    l.e("Geetest", "A method on the stack trace has been hooked using Substrate.");
                    return true;
                } else if ("de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName()) && FastRecordMainViewModel.RECORD_TYPE_ALL.equals(stackTraceElement.getMethodName())) {
                    l.e("Geetest", "Xposed is active on the device.");
                    return true;
                } else if (!"de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName()) || !"handleHookedMethod".equals(stackTraceElement.getMethodName())) {
                    i++;
                } else {
                    l.e("Geetest", "A method on the stack trace has been hooked using Xposed.");
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0064, code lost:
        if (r0.hasNext() == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
        r1 = (java.lang.String) r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0074, code lost:
        if (r1.contains("com.saurik.substrate") == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        com.geetest.sdk.utils.l.e("Geetest", "Substrate shared object found: " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        if (r1.contains("XposedBridge.jar") != false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
        if (r1.contains("edxp.jar") == false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009b, code lost:
        com.geetest.sdk.utils.l.e("Geetest", "Xposed JAR found: " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00af, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b0, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b() {
        /*
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "/proc/"
            r1.append(r2)
            int r2 = android.os.Process.myPid()
            r1.append(r2)
            java.lang.String r2 = "/maps"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b3 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x00b3 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00b3 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00b3 }
        L_0x0029:
            java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x00b3 }
            r3 = 1
            if (r1 == 0) goto L_0x005c
            java.lang.String r4 = r1.toLowerCase()     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r5 = "frida"
            boolean r4 = r4.contains(r5)     // Catch:{ Exception -> 0x00b3 }
            if (r4 == 0) goto L_0x003d
            return r3
        L_0x003d:
            java.lang.String r4 = ".so"
            boolean r4 = r1.endsWith(r4)     // Catch:{ Exception -> 0x00b3 }
            if (r4 != 0) goto L_0x004d
            java.lang.String r4 = ".jar"
            boolean r4 = r1.endsWith(r4)     // Catch:{ Exception -> 0x00b3 }
            if (r4 == 0) goto L_0x0029
        L_0x004d:
            java.lang.String r4 = " "
            int r4 = r1.lastIndexOf(r4)     // Catch:{ Exception -> 0x00b3 }
            int r4 = r4 + r3
            java.lang.String r1 = r1.substring(r4)     // Catch:{ Exception -> 0x00b3 }
            r0.add(r1)     // Catch:{ Exception -> 0x00b3 }
            goto L_0x0029
        L_0x005c:
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x00b3 }
        L_0x0060:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x00b3 }
            if (r1 == 0) goto L_0x00b0
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r4 = "com.saurik.substrate"
            boolean r4 = r1.contains(r4)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r5 = "Geetest"
            if (r4 == 0) goto L_0x008b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b3 }
            r0.<init>()     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r2 = "Substrate shared object found: "
            r0.append(r2)     // Catch:{ Exception -> 0x00b3 }
            r0.append(r1)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b3 }
            com.geetest.sdk.utils.l.e(r5, r0)     // Catch:{ Exception -> 0x00b3 }
            return r3
        L_0x008b:
            java.lang.String r4 = "XposedBridge.jar"
            boolean r4 = r1.contains(r4)     // Catch:{ Exception -> 0x00b3 }
            if (r4 != 0) goto L_0x009b
            java.lang.String r4 = "edxp.jar"
            boolean r4 = r1.contains(r4)     // Catch:{ Exception -> 0x00b3 }
            if (r4 == 0) goto L_0x0060
        L_0x009b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b3 }
            r0.<init>()     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r2 = "Xposed JAR found: "
            r0.append(r2)     // Catch:{ Exception -> 0x00b3 }
            r0.append(r1)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b3 }
            com.geetest.sdk.utils.l.e(r5, r0)     // Catch:{ Exception -> 0x00b3 }
            return r3
        L_0x00b0:
            r2.close()     // Catch:{ Exception -> 0x00b3 }
        L_0x00b3:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.utils.w.b():boolean");
    }

    public static int c() {
        try {
            return (a() || b()) ? 1 : 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}
