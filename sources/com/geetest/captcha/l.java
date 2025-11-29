package com.geetest.captcha;

import java.io.FileWriter;
import java.io.IOException;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f2867a = {"/sdcard/.system_log.trace", "/sdcard/tencent/.DrvZPZQ", "/sdcard/alipay/.Wg83DS3"};

    /* JADX WARNING: Can't wrap try/catch for region: R(3:20|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r9 = f2867a;
        r4 = com.geetest.captcha.n.a(new java.io.FileReader(r9[2]));
        r11 = new org.json.JSONObject(new java.lang.String(com.geetest.captcha.i.f(android.util.Base64.decode(r4, 2), "VedaT=ZbPq0Zv7Do")));
        com.geetest.captcha.i.c(r13, "gt_di", r4);
        b(r4, r9[0]);
        b(r4, r9[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c8, code lost:
        return new android.util.Pair(r11.getString("gee_id"), r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r4 = java.util.UUID.randomUUID().toString();
        r9 = new org.json.JSONObject();
        r9.put("gee_id", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r9.put("ts", java.lang.System.currentTimeMillis());
        r9.put("ver", "1.0.0");
        r5 = com.geetest.captcha.n.b(android.util.Base64.encode(com.geetest.captcha.i.e(r9.toString(), "VedaT=ZbPq0Zv7Do"), 2), "utf-8");
        com.geetest.captcha.i.c(r13, "gt_di", r5);
        r13 = f2867a;
        b(r5, r13[0]);
        b(r5, r13[1]);
        b(r5, r13[2]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0112, code lost:
        return new android.util.Pair(r4, r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0093 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00c9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair a(android.content.Context r13) {
        /*
            java.lang.String r0 = "gt_di"
            r1 = 0
            r2 = 0
            java.lang.String r3 = "gt_fp"
            android.content.SharedPreferences r3 = r13.getSharedPreferences(r3, r2)     // Catch:{ Exception -> 0x000f }
            java.lang.String r3 = r3.getString(r0, r1)     // Catch:{ Exception -> 0x000f }
            goto L_0x0011
        L_0x000f:
            java.lang.String r3 = "$unknown"
        L_0x0011:
            boolean r4 = com.geetest.captcha.i.g(r3)
            java.lang.String r5 = "utf-8"
            java.lang.String r6 = "gee_id"
            java.lang.String r7 = "VedaT=ZbPq0Zv7Do"
            r8 = 2
            if (r4 == 0) goto L_0x0114
            int r3 = android.os.Process.myPid()
            int r4 = android.os.Process.myUid()
            java.lang.String r9 = "android.permission.WRITE_EXTERNAL_STORAGE"
            int r3 = r13.checkPermission(r9, r3, r4)
            if (r3 != 0) goto L_0x0113
            boolean r3 = android.os.Environment.isExternalStorageLegacy()
            if (r3 != 0) goto L_0x0035
            return r1
        L_0x0035:
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0061 }
            java.lang.String[] r4 = f2867a     // Catch:{ Exception -> 0x0061 }
            r4 = r4[r2]     // Catch:{ Exception -> 0x0061 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r3 = com.geetest.captcha.n.a(r3)     // Catch:{ Exception -> 0x0061 }
            byte[] r4 = android.util.Base64.decode(r3, r8)     // Catch:{ Exception -> 0x0061 }
            byte[] r4 = com.geetest.captcha.i.f(r4, r7)     // Catch:{ Exception -> 0x0061 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0061 }
            java.lang.String r10 = new java.lang.String     // Catch:{ Exception -> 0x0061 }
            r10.<init>(r4)     // Catch:{ Exception -> 0x0061 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x0061 }
            com.geetest.captcha.i.c(r13, r0, r3)     // Catch:{ Exception -> 0x0061 }
            android.util.Pair r4 = new android.util.Pair     // Catch:{ Exception -> 0x0061 }
            java.lang.String r9 = r9.getString(r6)     // Catch:{ Exception -> 0x0061 }
            r4.<init>(r9, r3)     // Catch:{ Exception -> 0x0061 }
            return r4
        L_0x0061:
            r3 = 1
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x0093 }
            java.lang.String[] r9 = f2867a     // Catch:{ Exception -> 0x0093 }
            r10 = r9[r3]     // Catch:{ Exception -> 0x0093 }
            r4.<init>(r10)     // Catch:{ Exception -> 0x0093 }
            java.lang.String r4 = com.geetest.captcha.n.a(r4)     // Catch:{ Exception -> 0x0093 }
            byte[] r10 = android.util.Base64.decode(r4, r8)     // Catch:{ Exception -> 0x0093 }
            byte[] r10 = com.geetest.captcha.i.f(r10, r7)     // Catch:{ Exception -> 0x0093 }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x0093 }
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x0093 }
            r12.<init>(r10)     // Catch:{ Exception -> 0x0093 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x0093 }
            com.geetest.captcha.i.c(r13, r0, r4)     // Catch:{ Exception -> 0x0093 }
            r9 = r9[r2]     // Catch:{ Exception -> 0x0093 }
            b(r4, r9)     // Catch:{ Exception -> 0x0093 }
            android.util.Pair r9 = new android.util.Pair     // Catch:{ Exception -> 0x0093 }
            java.lang.String r10 = r11.getString(r6)     // Catch:{ Exception -> 0x0093 }
            r9.<init>(r10, r4)     // Catch:{ Exception -> 0x0093 }
            return r9
        L_0x0093:
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x00c9 }
            java.lang.String[] r9 = f2867a     // Catch:{ Exception -> 0x00c9 }
            r10 = r9[r8]     // Catch:{ Exception -> 0x00c9 }
            r4.<init>(r10)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r4 = com.geetest.captcha.n.a(r4)     // Catch:{ Exception -> 0x00c9 }
            byte[] r10 = android.util.Base64.decode(r4, r8)     // Catch:{ Exception -> 0x00c9 }
            byte[] r10 = com.geetest.captcha.i.f(r10, r7)     // Catch:{ Exception -> 0x00c9 }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x00c9 }
            r12.<init>(r10)     // Catch:{ Exception -> 0x00c9 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x00c9 }
            com.geetest.captcha.i.c(r13, r0, r4)     // Catch:{ Exception -> 0x00c9 }
            r10 = r9[r2]     // Catch:{ Exception -> 0x00c9 }
            b(r4, r10)     // Catch:{ Exception -> 0x00c9 }
            r9 = r9[r3]     // Catch:{ Exception -> 0x00c9 }
            b(r4, r9)     // Catch:{ Exception -> 0x00c9 }
            android.util.Pair r9 = new android.util.Pair     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r10 = r11.getString(r6)     // Catch:{ Exception -> 0x00c9 }
            r9.<init>(r10, r4)     // Catch:{ Exception -> 0x00c9 }
            return r9
        L_0x00c9:
            java.util.UUID r4 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x0113 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0113 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0113 }
            r9.<init>()     // Catch:{ Exception -> 0x0113 }
            r9.put(r6, r4)     // Catch:{ Exception -> 0x0113 }
            java.lang.String r6 = "ts"
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0113 }
            r9.put(r6, r10)     // Catch:{ Exception -> 0x0113 }
            java.lang.String r6 = "ver"
            java.lang.String r10 = "1.0.0"
            r9.put(r6, r10)     // Catch:{ Exception -> 0x0113 }
            java.lang.String r6 = r9.toString()     // Catch:{ Exception -> 0x0113 }
            byte[] r6 = com.geetest.captcha.i.e(r6, r7)     // Catch:{ Exception -> 0x0113 }
            byte[] r6 = android.util.Base64.encode(r6, r8)     // Catch:{ Exception -> 0x0113 }
            java.lang.String r5 = com.geetest.captcha.n.b(r6, r5)     // Catch:{ Exception -> 0x0113 }
            com.geetest.captcha.i.c(r13, r0, r5)     // Catch:{ Exception -> 0x0113 }
            java.lang.String[] r13 = f2867a     // Catch:{ Exception -> 0x0113 }
            r0 = r13[r2]     // Catch:{ Exception -> 0x0113 }
            b(r5, r0)     // Catch:{ Exception -> 0x0113 }
            r0 = r13[r3]     // Catch:{ Exception -> 0x0113 }
            b(r5, r0)     // Catch:{ Exception -> 0x0113 }
            r13 = r13[r8]     // Catch:{ Exception -> 0x0113 }
            b(r5, r13)     // Catch:{ Exception -> 0x0113 }
            android.util.Pair r13 = new android.util.Pair     // Catch:{ Exception -> 0x0113 }
            r13.<init>(r4, r5)     // Catch:{ Exception -> 0x0113 }
            return r13
        L_0x0113:
            return r1
        L_0x0114:
            byte[] r13 = android.util.Base64.decode(r3, r8)     // Catch:{ Exception -> 0x012f }
            byte[] r13 = com.geetest.captcha.i.f(r13, r7)     // Catch:{ Exception -> 0x012f }
            java.lang.String r13 = com.geetest.captcha.n.b(r13, r5)     // Catch:{ Exception -> 0x012f }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x012f }
            r0.<init>(r13)     // Catch:{ Exception -> 0x012f }
            android.util.Pair r13 = new android.util.Pair     // Catch:{ Exception -> 0x012f }
            java.lang.String r0 = r0.getString(r6)     // Catch:{ Exception -> 0x012f }
            r13.<init>(r0, r3)     // Catch:{ Exception -> 0x012f }
            return r13
        L_0x012f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.captcha.l.a(android.content.Context):android.util.Pair");
    }

    public static void b(String str, String str2) {
        try {
            FileWriter fileWriter = new FileWriter(str2);
            n.c(str, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException unused) {
        }
    }
}
