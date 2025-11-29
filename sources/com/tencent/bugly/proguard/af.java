package com.tencent.bugly.proguard;

import android.content.Context;
import com.upuphone.runasone.share.lib.TransferHandler;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class af {

    /* renamed from: a  reason: collision with root package name */
    static af f9517a;
    protected Context b;
    public Map<String, String> c = null;

    public af(Context context) {
        this.b = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003b A[Catch:{ all -> 0x003f, all -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0043 A[SYNTHETIC, Splitter:B:26:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] b(java.net.HttpURLConnection r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0033 }
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ all -> 0x0033 }
            r1.<init>(r5)     // Catch:{ all -> 0x0033 }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0021 }
            r5.<init>()     // Catch:{ all -> 0x0021 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0021 }
        L_0x0016:
            int r3 = r1.read(r2)     // Catch:{ all -> 0x0021 }
            if (r3 <= 0) goto L_0x0023
            r4 = 0
            r5.write(r2, r4, r3)     // Catch:{ all -> 0x0021 }
            goto L_0x0016
        L_0x0021:
            r5 = move-exception
            goto L_0x0035
        L_0x0023:
            r5.flush()     // Catch:{ all -> 0x0021 }
            byte[] r5 = r5.toByteArray()     // Catch:{ all -> 0x0021 }
            r1.close()     // Catch:{ all -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0032:
            return r5
        L_0x0033:
            r5 = move-exception
            r1 = r0
        L_0x0035:
            boolean r2 = com.tencent.bugly.proguard.al.a(r5)     // Catch:{ all -> 0x003f }
            if (r2 != 0) goto L_0x0041
            r5.printStackTrace()     // Catch:{ all -> 0x003f }
            goto L_0x0041
        L_0x003f:
            r5 = move-exception
            goto L_0x004c
        L_0x0041:
            if (r1 == 0) goto L_0x004b
            r1.close()     // Catch:{ all -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004b:
            return r0
        L_0x004c:
            if (r1 == 0) goto L_0x0056
            r1.close()     // Catch:{ all -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0056:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.af.b(java.net.HttpURLConnection):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:74:0x013d, code lost:
        if (com.tencent.bugly.proguard.al.a(r4) != false) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x013f, code lost:
        r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x015e, code lost:
        if (com.tencent.bugly.proguard.al.a(r4) != false) goto L_0x0142;
     */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0151 A[Catch:{ all -> 0x00cd, all -> 0x0165 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a(java.lang.String r20, byte[] r21, com.tencent.bugly.proguard.aj r22, java.util.Map<java.lang.String, java.lang.String> r23) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r21
            r3 = r22
            r4 = 0
            r5 = 0
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = "Failed for no URL."
            java.lang.Object[] r1 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.e(r0, r1)
            return r4
        L_0x0014:
            if (r2 != 0) goto L_0x0019
            r8 = 0
            goto L_0x001b
        L_0x0019:
            int r8 = r2.length
            long r8 = (long) r8
        L_0x001b:
            java.lang.Long r10 = java.lang.Long.valueOf(r8)
            int r11 = android.os.Process.myPid()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            int r12 = android.os.Process.myTid()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.Object[] r10 = new java.lang.Object[]{r0, r10, r11, r12}
            java.lang.String r11 = "request: %s, send: %d (pid=%d | tid=%d)"
            com.tencent.bugly.proguard.al.c(r11, r10)
            r10 = r0
            r0 = r5
            r11 = r0
            r12 = r11
        L_0x003c:
            if (r0 > 0) goto L_0x0183
            if (r11 > 0) goto L_0x0183
            r13 = 1
            if (r12 == 0) goto L_0x0046
            r6 = r0
            r12 = r5
            goto L_0x0071
        L_0x0046:
            int r0 = r0 + 1
            if (r0 <= r13) goto L_0x0070
            java.lang.String r14 = "try time: "
            java.lang.String r15 = java.lang.String.valueOf(r0)
            java.lang.String r14 = r14.concat(r15)
            java.lang.Object[] r15 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.c(r14, r15)
            java.util.Random r14 = new java.util.Random
            long r6 = java.lang.System.currentTimeMillis()
            r14.<init>(r6)
            r6 = 10000(0x2710, float:1.4013E-41)
            int r6 = r14.nextInt(r6)
            long r6 = (long) r6
            r17 = 10000(0x2710, double:4.9407E-320)
            long r6 = r6 + r17
            android.os.SystemClock.sleep(r6)
        L_0x0070:
            r6 = r0
        L_0x0071:
            android.content.Context r0 = r1.b
            java.lang.String r0 = com.tencent.bugly.proguard.ab.c(r0)
            if (r0 != 0) goto L_0x0087
            java.lang.String r0 = "Failed to request for network not avail"
            java.lang.Object[] r7 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.d(r0, r7)
            r7 = r23
            r4 = r5
            r13 = 0
            goto L_0x017e
        L_0x0087:
            r3.a((long) r8)
            r7 = r23
            java.net.HttpURLConnection r14 = a((java.lang.String) r10, (byte[]) r2, (java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.String>) r7)
            if (r14 == 0) goto L_0x0171
            int r0 = r14.getResponseCode()     // Catch:{ IOException -> 0x00d1 }
            java.lang.String r13 = "response code "
            java.lang.String r15 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x00d1 }
            java.lang.String r13 = r13.concat(r15)     // Catch:{ IOException -> 0x00d1 }
            java.lang.Object[] r15 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x00d1 }
            com.tencent.bugly.proguard.al.c(r13, r15)     // Catch:{ IOException -> 0x00d1 }
            r13 = 200(0xc8, float:2.8E-43)
            if (r0 != r13) goto L_0x00d4
            java.util.Map r0 = a(r14)     // Catch:{ IOException -> 0x00d1 }
            r1.c = r0     // Catch:{ IOException -> 0x00d1 }
            byte[] r13 = b(r14)     // Catch:{ IOException -> 0x00d1 }
            if (r13 != 0) goto L_0x00b8
            r4 = 0
            goto L_0x00ba
        L_0x00b8:
            int r0 = r13.length     // Catch:{ IOException -> 0x00d1 }
            long r4 = (long) r0     // Catch:{ IOException -> 0x00d1 }
        L_0x00ba:
            r3.b((long) r4)     // Catch:{ IOException -> 0x00d1 }
            r14.disconnect()     // Catch:{ all -> 0x00c1 }
            goto L_0x00cc
        L_0x00c1:
            r0 = move-exception
            r1 = r0
            boolean r0 = com.tencent.bugly.proguard.al.a(r1)
            if (r0 != 0) goto L_0x00cc
            r1.printStackTrace()
        L_0x00cc:
            return r13
        L_0x00cd:
            r0 = move-exception
            r1 = r0
            goto L_0x0161
        L_0x00d1:
            r0 = move-exception
            goto L_0x014b
        L_0x00d4:
            r4 = 301(0x12d, float:4.22E-43)
            if (r0 == r4) goto L_0x00e4
            r4 = 302(0x12e, float:4.23E-43)
            if (r0 == r4) goto L_0x00e4
            r4 = 303(0x12f, float:4.25E-43)
            if (r0 == r4) goto L_0x00e4
            r4 = 307(0x133, float:4.3E-43)
            if (r0 != r4) goto L_0x0123
        L_0x00e4:
            java.lang.String r4 = "Location"
            java.lang.String r4 = r14.getHeaderField(r4)     // Catch:{ IOException -> 0x010e }
            if (r4 != 0) goto L_0x0111
            java.lang.String r4 = "Failed to redirect: %d"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x010e }
            java.lang.String r0 = r4.concat(r0)     // Catch:{ IOException -> 0x010e }
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x010e }
            com.tencent.bugly.proguard.al.e(r0, r5)     // Catch:{ IOException -> 0x010e }
            r14.disconnect()     // Catch:{ all -> 0x0101 }
        L_0x00ff:
            r1 = 0
            goto L_0x010d
        L_0x0101:
            r0 = move-exception
            r1 = r0
            boolean r0 = com.tencent.bugly.proguard.al.a(r1)
            if (r0 != 0) goto L_0x00ff
            r1.printStackTrace()
            goto L_0x00ff
        L_0x010d:
            return r1
        L_0x010e:
            r0 = move-exception
        L_0x010f:
            r12 = 1
            goto L_0x014b
        L_0x0111:
            int r11 = r11 + 1
            java.lang.String r5 = "redirect code: %d ,to:%s"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x0147 }
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r4}     // Catch:{ IOException -> 0x0147 }
            com.tencent.bugly.proguard.al.c(r5, r0)     // Catch:{ IOException -> 0x0147 }
            r10 = r4
            r6 = 0
            r12 = 1
        L_0x0123:
            int r0 = r14.getContentLength()     // Catch:{ IOException -> 0x00d1 }
            long r4 = (long) r0     // Catch:{ IOException -> 0x00d1 }
            r15 = 0
            int r0 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r0 >= 0) goto L_0x0130
            r4 = 0
        L_0x0130:
            r3.b((long) r4)     // Catch:{ IOException -> 0x00d1 }
            r14.disconnect()     // Catch:{ all -> 0x0137 }
            goto L_0x0142
        L_0x0137:
            r0 = move-exception
            r4 = r0
            boolean r0 = com.tencent.bugly.proguard.al.a(r4)
            if (r0 != 0) goto L_0x0142
        L_0x013f:
            r4.printStackTrace()
        L_0x0142:
            r0 = r6
            r4 = 0
            r5 = 0
            goto L_0x003c
        L_0x0147:
            r0 = move-exception
            r10 = r4
            r6 = 0
            goto L_0x010f
        L_0x014b:
            boolean r4 = com.tencent.bugly.proguard.al.a(r0)     // Catch:{ all -> 0x00cd }
            if (r4 != 0) goto L_0x0154
            r0.printStackTrace()     // Catch:{ all -> 0x00cd }
        L_0x0154:
            r14.disconnect()     // Catch:{ all -> 0x0158 }
            goto L_0x0142
        L_0x0158:
            r0 = move-exception
            r4 = r0
            boolean r0 = com.tencent.bugly.proguard.al.a(r4)
            if (r0 != 0) goto L_0x0142
            goto L_0x013f
        L_0x0161:
            r14.disconnect()     // Catch:{ all -> 0x0165 }
            goto L_0x0170
        L_0x0165:
            r0 = move-exception
            r2 = r0
            boolean r0 = com.tencent.bugly.proguard.al.a(r2)
            if (r0 != 0) goto L_0x0170
            r2.printStackTrace()
        L_0x0170:
            throw r1
        L_0x0171:
            java.lang.String r0 = "Failed to execute post."
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]
            com.tencent.bugly.proguard.al.c(r0, r5)
            r13 = 0
            r3.b((long) r13)
        L_0x017e:
            r5 = r4
            r0 = r6
            r4 = 0
            goto L_0x003c
        L_0x0183:
            r1 = r4
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.af.a(java.lang.String, byte[], com.tencent.bugly.proguard.aj, java.util.Map):byte[]");
    }

    private static Map<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String next : headerFields.keySet()) {
            List list = headerFields.get(next);
            if (list.size() > 0) {
                hashMap.put(next, list.get(0));
            }
        }
        return hashMap;
    }

    private static HttpURLConnection a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            al.e("destUrl is null.", new Object[0]);
            return null;
        }
        HttpURLConnection a2 = a(str2, str);
        if (a2 == null) {
            al.e("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            a2.setRequestProperty("wup_version", "3.0");
            if (map != null) {
                if (map.size() > 0) {
                    for (Map.Entry next : map.entrySet()) {
                        a2.setRequestProperty((String) next.getKey(), URLEncoder.encode((String) next.getValue(), "utf-8"));
                    }
                }
            }
            a2.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            a2.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = a2.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return a2;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            al.e("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    private static HttpURLConnection a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str2);
            Proxy proxy = an.f9531a;
            if (proxy != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
            } else if (str == null || !str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            }
            httpURLConnection.setConnectTimeout(TransferHandler.TIMEOUT);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
