package com.tencent.bugly.proguard;

import android.util.Pair;
import com.upuphone.runasone.api.ApiConstant;
import java.io.Closeable;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ad {
    public static Pair<Integer, String> a(List<String> list) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Atta-Type", "batch-report");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("attaid", "0d000062340").put(ApiConstant.KEY_TOKEN, "2273782735").put("type", "batch").put("version", "v1.0.0");
            JSONArray jSONArray = new JSONArray();
            for (String put : list) {
                jSONArray.put(put);
            }
            jSONObject.put("datas", jSONArray);
            return a("https://h.trace.qq.com/kv", jSONObject.toString(), hashMap);
        } catch (Throwable th) {
            al.b(th);
            return new Pair<>(-1, th.getMessage());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ad A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<java.lang.Integer, java.lang.String> a(java.lang.String r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            java.lang.String r0 = "UTF-8"
            r1 = 0
            r2 = -1
            java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x009b }
            r3.<init>(r6)     // Catch:{ all -> 0x009b }
            java.net.URLConnection r6 = r3.openConnection()     // Catch:{ all -> 0x009b }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ all -> 0x009b }
            java.lang.String r3 = "POST"
            r6.setRequestMethod(r3)     // Catch:{ all -> 0x0057 }
            r3 = 1
            r6.setDoOutput(r3)     // Catch:{ all -> 0x0057 }
            r6.setDoInput(r3)     // Catch:{ all -> 0x0057 }
            r3 = 0
            r6.setUseCaches(r3)     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/x-www-form-urlencoded"
            r6.setRequestProperty(r3, r4)     // Catch:{ all -> 0x0057 }
            a(r6, r8)     // Catch:{ all -> 0x0057 }
            r8 = 5000(0x1388, float:7.006E-42)
            r6.setConnectTimeout(r8)     // Catch:{ all -> 0x0057 }
            r6.setReadTimeout(r8)     // Catch:{ all -> 0x0057 }
            r6.connect()     // Catch:{ all -> 0x0057 }
            byte[] r7 = r7.getBytes(r0)     // Catch:{ all -> 0x0057 }
            java.io.DataOutputStream r8 = new java.io.DataOutputStream     // Catch:{ all -> 0x0057 }
            java.io.OutputStream r3 = r6.getOutputStream()     // Catch:{ all -> 0x0057 }
            r8.<init>(r3)     // Catch:{ all -> 0x0057 }
            r8.write(r7)     // Catch:{ all -> 0x0096 }
            r8.flush()     // Catch:{ all -> 0x0096 }
            r8.close()     // Catch:{ all -> 0x0096 }
            int r2 = r6.getResponseCode()     // Catch:{ all -> 0x0057 }
            r7 = 400(0x190, float:5.6E-43)
            if (r2 < r7) goto L_0x005c
            java.io.InputStream r7 = r6.getErrorStream()     // Catch:{ all -> 0x0057 }
            goto L_0x0060
        L_0x0057:
            r7 = move-exception
            r8 = r1
            r1 = r6
            r6 = r8
            goto L_0x009e
        L_0x005c:
            java.io.InputStream r7 = r6.getInputStream()     // Catch:{ all -> 0x0057 }
        L_0x0060:
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ all -> 0x007e }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x007e }
            r3.<init>(r7, r0)     // Catch:{ all -> 0x007e }
            r8.<init>(r3)     // Catch:{ all -> 0x007e }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r0.<init>()     // Catch:{ all -> 0x007e }
        L_0x006f:
            java.lang.String r3 = r8.readLine()     // Catch:{ all -> 0x007e }
            if (r3 == 0) goto L_0x0085
            r0.append(r3)     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "\r\n"
            r0.append(r3)     // Catch:{ all -> 0x007e }
            goto L_0x006f
        L_0x007e:
            r8 = move-exception
            r5 = r1
            r1 = r6
            r6 = r7
            r7 = r8
            r8 = r5
            goto L_0x009e
        L_0x0085:
            r8.close()     // Catch:{ all -> 0x007e }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x007e }
            a((java.io.Closeable) r1)
            a((java.io.Closeable) r7)
            r6.disconnect()
            goto L_0x00b1
        L_0x0096:
            r7 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
            goto L_0x009e
        L_0x009b:
            r7 = move-exception
            r6 = r1
            r8 = r6
        L_0x009e:
            com.tencent.bugly.proguard.al.b(r7)     // Catch:{ all -> 0x00bb }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x00bb }
            a((java.io.Closeable) r8)
            a((java.io.Closeable) r6)
            if (r1 == 0) goto L_0x00b0
            r1.disconnect()
        L_0x00b0:
            r8 = r7
        L_0x00b1:
            android.util.Pair r6 = new android.util.Pair
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            r6.<init>(r7, r8)
            return r6
        L_0x00bb:
            r7 = move-exception
            a((java.io.Closeable) r8)
            a((java.io.Closeable) r6)
            if (r1 == 0) goto L_0x00c7
            r1.disconnect()
        L_0x00c7:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ad.a(java.lang.String, java.lang.String, java.util.Map):android.util.Pair");
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (httpURLConnection != null && map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                al.b(e);
            }
        }
    }
}
