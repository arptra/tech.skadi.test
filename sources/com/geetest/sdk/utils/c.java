package com.geetest.sdk.utils;

import java.io.BufferedInputStream;

public class c {

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f2959a = new c();
    }

    public static c a() {
        return b.f2959a;
    }

    public static String b(BufferedInputStream bufferedInputStream) {
        int read;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[512];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception unused) {
            }
        } while (read >= 512);
        return sb.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:5|6|7|8|9|10|11|12|13|15) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0039 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050 A[SYNTHETIC, Splitter:B:28:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0055 A[SYNTHETIC, Splitter:B:32:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0063 A[SYNTHETIC, Splitter:B:44:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0068 A[SYNTHETIC, Splitter:B:48:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String c(java.lang.String r5) {
        /*
            r4 = this;
            r4 = 0
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x005e, all -> 0x004b }
            java.lang.String r1 = "sh"
            java.lang.Process r0 = r0.exec(r1)     // Catch:{ Exception -> 0x005e, all -> 0x004b }
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x005f, all -> 0x0049 }
            java.io.OutputStream r2 = r0.getOutputStream()     // Catch:{ Exception -> 0x005f, all -> 0x0049 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x005f, all -> 0x0049 }
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            java.io.InputStream r3 = r0.getInputStream()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            byte[] r5 = r5.getBytes()     // Catch:{ Exception -> 0x0061, all -> 0x0040 }
            r1.write(r5)     // Catch:{ Exception -> 0x0061, all -> 0x0040 }
            r5 = 10
            r1.write(r5)     // Catch:{ Exception -> 0x0061, all -> 0x0040 }
            r1.flush()     // Catch:{ Exception -> 0x0061, all -> 0x0040 }
            r1.close()     // Catch:{ Exception -> 0x0061, all -> 0x0040 }
            r0.waitFor()     // Catch:{ Exception -> 0x0061, all -> 0x0040 }
            java.lang.String r4 = b(r2)     // Catch:{ Exception -> 0x0061, all -> 0x0040 }
            r1.close()     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            r2.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            r0.destroy()
            return r4
        L_0x0040:
            r4 = move-exception
            r5 = r4
        L_0x0042:
            r4 = r1
            goto L_0x004e
        L_0x0044:
            r5 = move-exception
            r2 = r4
            goto L_0x0042
        L_0x0047:
            r2 = r4
            goto L_0x0061
        L_0x0049:
            r5 = move-exception
            goto L_0x004d
        L_0x004b:
            r5 = move-exception
            r0 = r4
        L_0x004d:
            r2 = r4
        L_0x004e:
            if (r4 == 0) goto L_0x0053
            r4.close()     // Catch:{ IOException -> 0x0053 }
        L_0x0053:
            if (r2 == 0) goto L_0x0058
            r2.close()     // Catch:{ IOException -> 0x0058 }
        L_0x0058:
            if (r0 == 0) goto L_0x005d
            r0.destroy()
        L_0x005d:
            throw r5
        L_0x005e:
            r0 = r4
        L_0x005f:
            r1 = r4
            r2 = r1
        L_0x0061:
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ IOException -> 0x0066 }
        L_0x0066:
            if (r2 == 0) goto L_0x006b
            r2.close()     // Catch:{ IOException -> 0x006b }
        L_0x006b:
            if (r0 == 0) goto L_0x0070
            r0.destroy()
        L_0x0070:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.utils.c.c(java.lang.String):java.lang.String");
    }

    public c() {
    }
}
