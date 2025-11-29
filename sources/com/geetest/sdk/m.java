package com.geetest.sdk;

import java.io.FileWriter;
import java.io.IOException;

final class m {
    /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r9 = com.geetest.sdk.p.c(new java.io.FileReader(r0[2]));
        r11 = new org.json.JSONObject(new java.lang.String(com.geetest.sdk.i.e(android.util.Base64.decode(r9, 2), "VedaT=ZbPq0Zv7Do")));
        com.geetest.sdk.j.c(r13, "gt_di", r9);
        b(r9, r0[0]);
        b(r9, r0[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00e1, code lost:
        return new android.util.Pair(r11.getString("gee_id"), r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r9 = java.util.UUID.randomUUID().toString();
        r10 = new org.json.JSONObject();
        r10.put("gee_id", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r10.put("ts", java.lang.System.currentTimeMillis());
        r10.put("ver", "1.0.0");
        r5 = com.geetest.sdk.p.d(android.util.Base64.encode(com.geetest.sdk.i.c(r10.toString(), "VedaT=ZbPq0Zv7Do"), 2), "utf-8");
        com.geetest.sdk.j.c(r13, "gt_di", r5);
        b(r5, r0[0]);
        b(r5, r0[1]);
        b(r5, r0[2]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0129, code lost:
        return new android.util.Pair(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x012a, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x00ae */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x00e2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair a(android.content.Context r13) {
        /*
            java.io.File r0 = r13.getFilesDir()
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r2 = "/.system_log.trace"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r3 = "/tencent/.DrvZPZQ"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = "/alipay/.Wg83DS3"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String[] r0 = new java.lang.String[]{r1, r2, r0}
            java.lang.String r1 = "gt_di"
            java.lang.String r2 = com.geetest.sdk.j.e(r13, r1)
            boolean r3 = com.geetest.sdk.j.d(r2)
            r4 = 0
            java.lang.String r5 = "utf-8"
            java.lang.String r6 = "gee_id"
            java.lang.String r7 = "VedaT=ZbPq0Zv7Do"
            r8 = 2
            if (r3 == 0) goto L_0x012b
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x007e }
            r9 = r0[r2]     // Catch:{ Exception -> 0x007e }
            r3.<init>(r9)     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = com.geetest.sdk.p.c(r3)     // Catch:{ Exception -> 0x007e }
            byte[] r9 = android.util.Base64.decode(r3, r8)     // Catch:{ Exception -> 0x007e }
            byte[] r9 = com.geetest.sdk.i.e(r9, r7)     // Catch:{ Exception -> 0x007e }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x007e }
            java.lang.String r11 = new java.lang.String     // Catch:{ Exception -> 0x007e }
            r11.<init>(r9)     // Catch:{ Exception -> 0x007e }
            r10.<init>(r11)     // Catch:{ Exception -> 0x007e }
            com.geetest.sdk.j.c(r13, r1, r3)     // Catch:{ Exception -> 0x007e }
            android.util.Pair r9 = new android.util.Pair     // Catch:{ Exception -> 0x007e }
            java.lang.String r10 = r10.getString(r6)     // Catch:{ Exception -> 0x007e }
            r9.<init>(r10, r3)     // Catch:{ Exception -> 0x007e }
            return r9
        L_0x007e:
            r3 = 1
            java.io.FileReader r9 = new java.io.FileReader     // Catch:{ Exception -> 0x00ae }
            r10 = r0[r3]     // Catch:{ Exception -> 0x00ae }
            r9.<init>(r10)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r9 = com.geetest.sdk.p.c(r9)     // Catch:{ Exception -> 0x00ae }
            byte[] r10 = android.util.Base64.decode(r9, r8)     // Catch:{ Exception -> 0x00ae }
            byte[] r10 = com.geetest.sdk.i.e(r10, r7)     // Catch:{ Exception -> 0x00ae }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x00ae }
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x00ae }
            r12.<init>(r10)     // Catch:{ Exception -> 0x00ae }
            r11.<init>(r12)     // Catch:{ Exception -> 0x00ae }
            com.geetest.sdk.j.c(r13, r1, r9)     // Catch:{ Exception -> 0x00ae }
            r10 = r0[r2]     // Catch:{ Exception -> 0x00ae }
            b(r9, r10)     // Catch:{ Exception -> 0x00ae }
            android.util.Pair r10 = new android.util.Pair     // Catch:{ Exception -> 0x00ae }
            java.lang.String r11 = r11.getString(r6)     // Catch:{ Exception -> 0x00ae }
            r10.<init>(r11, r9)     // Catch:{ Exception -> 0x00ae }
            return r10
        L_0x00ae:
            java.io.FileReader r9 = new java.io.FileReader     // Catch:{ Exception -> 0x00e2 }
            r10 = r0[r8]     // Catch:{ Exception -> 0x00e2 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r9 = com.geetest.sdk.p.c(r9)     // Catch:{ Exception -> 0x00e2 }
            byte[] r10 = android.util.Base64.decode(r9, r8)     // Catch:{ Exception -> 0x00e2 }
            byte[] r10 = com.geetest.sdk.i.e(r10, r7)     // Catch:{ Exception -> 0x00e2 }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x00e2 }
            r12.<init>(r10)     // Catch:{ Exception -> 0x00e2 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x00e2 }
            com.geetest.sdk.j.c(r13, r1, r9)     // Catch:{ Exception -> 0x00e2 }
            r10 = r0[r2]     // Catch:{ Exception -> 0x00e2 }
            b(r9, r10)     // Catch:{ Exception -> 0x00e2 }
            r10 = r0[r3]     // Catch:{ Exception -> 0x00e2 }
            b(r9, r10)     // Catch:{ Exception -> 0x00e2 }
            android.util.Pair r10 = new android.util.Pair     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r11 = r11.getString(r6)     // Catch:{ Exception -> 0x00e2 }
            r10.<init>(r11, r9)     // Catch:{ Exception -> 0x00e2 }
            return r10
        L_0x00e2:
            java.util.UUID r9 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x012a }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x012a }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x012a }
            r10.<init>()     // Catch:{ Exception -> 0x012a }
            r10.put(r6, r9)     // Catch:{ Exception -> 0x012a }
            java.lang.String r6 = "ts"
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x012a }
            r10.put(r6, r11)     // Catch:{ Exception -> 0x012a }
            java.lang.String r6 = "ver"
            java.lang.String r11 = "1.0.0"
            r10.put(r6, r11)     // Catch:{ Exception -> 0x012a }
            java.lang.String r6 = r10.toString()     // Catch:{ Exception -> 0x012a }
            byte[] r6 = com.geetest.sdk.i.c(r6, r7)     // Catch:{ Exception -> 0x012a }
            byte[] r6 = android.util.Base64.encode(r6, r8)     // Catch:{ Exception -> 0x012a }
            java.lang.String r5 = com.geetest.sdk.p.d(r6, r5)     // Catch:{ Exception -> 0x012a }
            com.geetest.sdk.j.c(r13, r1, r5)     // Catch:{ Exception -> 0x012a }
            r13 = r0[r2]     // Catch:{ Exception -> 0x012a }
            b(r5, r13)     // Catch:{ Exception -> 0x012a }
            r13 = r0[r3]     // Catch:{ Exception -> 0x012a }
            b(r5, r13)     // Catch:{ Exception -> 0x012a }
            r13 = r0[r8]     // Catch:{ Exception -> 0x012a }
            b(r5, r13)     // Catch:{ Exception -> 0x012a }
            android.util.Pair r13 = new android.util.Pair     // Catch:{ Exception -> 0x012a }
            r13.<init>(r9, r5)     // Catch:{ Exception -> 0x012a }
            return r13
        L_0x012a:
            return r4
        L_0x012b:
            byte[] r13 = android.util.Base64.decode(r2, r8)     // Catch:{ Exception -> 0x0146 }
            byte[] r13 = com.geetest.sdk.i.e(r13, r7)     // Catch:{ Exception -> 0x0146 }
            java.lang.String r13 = com.geetest.sdk.p.d(r13, r5)     // Catch:{ Exception -> 0x0146 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0146 }
            r0.<init>(r13)     // Catch:{ Exception -> 0x0146 }
            android.util.Pair r13 = new android.util.Pair     // Catch:{ Exception -> 0x0146 }
            java.lang.String r0 = r0.getString(r6)     // Catch:{ Exception -> 0x0146 }
            r13.<init>(r0, r2)     // Catch:{ Exception -> 0x0146 }
            return r13
        L_0x0146:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.m.a(android.content.Context):android.util.Pair");
    }

    public static void b(String str, String str2) {
        try {
            FileWriter fileWriter = new FileWriter(str2);
            p.e(str, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException unused) {
        }
    }
}
