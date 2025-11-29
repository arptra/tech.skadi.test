package com.geetest.sdk.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okio.BufferedSink;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2968a = "n";
    public static String b = "";
    public static ConcurrentHashMap c = new ConcurrentHashMap();
    public static String d = "";
    public static String e = "";
    public static final MediaType f = MediaType.parse("application/octet-stream");

    public class a extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f2969a;

        public a(byte[] bArr) {
            this.f2969a = bArr;
        }

        public MediaType contentType() {
            return n.f;
        }

        public void writeTo(BufferedSink bufferedSink) {
            bufferedSink.outputStream().write(this.f2969a);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static OkHttpClient f2970a;

        public class a implements CookieJar {
            public List loadForRequest(HttpUrl httpUrl) {
                List list = (List) n.c.get(httpUrl.host());
                return list != null ? list : new ArrayList();
            }

            public void saveFromResponse(HttpUrl httpUrl, List list) {
                n.c.put(httpUrl.host(), list);
            }
        }

        static {
            OkHttpClient.Builder addInterceptor = new OkHttpClient().newBuilder().addInterceptor(new t(d.b));
            TimeUnit timeUnit = TimeUnit.SECONDS;
            f2970a = addInterceptor.connectTimeout(10, timeUnit).readTimeout(5, timeUnit).writeTimeout(5, timeUnit).cookieJar(new a()).build();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009d A[LOOP:1: B:31:0x0097->B:33:0x009d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e3 A[SYNTHETIC, Splitter:B:38:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ec A[Catch:{ Exception -> 0x00ea }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0119 A[Catch:{ Exception -> 0x00ea }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0122 A[Catch:{ Exception -> 0x00ea }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r6, boolean r7, java.util.Map r8, byte[] r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "GT3_Error_Info: request error:"
            java.lang.String r1 = " responseCode"
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder
            r2.<init>()
            if (r8 == 0) goto L_0x0035
            int r3 = r8.size()
            if (r3 <= 0) goto L_0x0035
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0019:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x0035
            java.lang.Object r3 = r8.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            r2.header(r4, r3)
            goto L_0x0019
        L_0x0035:
            java.lang.String r8 = "Ajax"
            boolean r8 = android.text.TextUtils.equals(r10, r8)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = ";"
            java.lang.String r4 = "Cookie"
            r5 = 0
            if (r8 != 0) goto L_0x006c
            java.lang.String r8 = "GetCoder"
            boolean r8 = android.text.TextUtils.equals(r10, r8)     // Catch:{ Exception -> 0x0069 }
            if (r8 == 0) goto L_0x004b
            goto L_0x006c
        L_0x004b:
            java.lang.String r8 = "API2Coder"
            boolean r8 = android.text.TextUtils.equals(r10, r8)     // Catch:{ Exception -> 0x0069 }
            if (r8 == 0) goto L_0x0081
            java.lang.String r8 = d     // Catch:{ Exception -> 0x0069 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0069 }
            if (r8 != 0) goto L_0x0081
            java.lang.String r8 = d     // Catch:{ Exception -> 0x0069 }
            int r3 = r8.indexOf(r3)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r8 = r8.substring(r5, r3)     // Catch:{ Exception -> 0x0069 }
            r2.addHeader(r4, r8)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0081
        L_0x0069:
            r6 = move-exception
            goto L_0x0182
        L_0x006c:
            java.lang.String r8 = e     // Catch:{ Exception -> 0x0069 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0069 }
            if (r8 != 0) goto L_0x0081
            java.lang.String r8 = e     // Catch:{ Exception -> 0x0069 }
            int r3 = r8.indexOf(r3)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r8 = r8.substring(r5, r3)     // Catch:{ Exception -> 0x0069 }
            r2.addHeader(r4, r8)     // Catch:{ Exception -> 0x0069 }
        L_0x0081:
            if (r7 == 0) goto L_0x008b
            com.geetest.sdk.utils.n$a r7 = new com.geetest.sdk.utils.n$a
            r7.<init>(r9)
            r2.post(r7)
        L_0x008b:
            okhttp3.Request$Builder r7 = r2.url((java.lang.String) r6)
            okhttp3.Request r7 = r7.build()
            okhttp3.Headers r8 = r7.headers()
        L_0x0097:
            int r9 = r8.size()
            if (r5 >= r9) goto L_0x00c9
            java.lang.String r9 = f2968a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            java.lang.String r3 = " Header key: "
            r2.append(r3)
            java.lang.String r3 = r8.name(r5)
            r2.append(r3)
            java.lang.String r3 = " value: "
            r2.append(r3)
            java.lang.String r3 = r8.value(r5)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.geetest.sdk.utils.l.c(r9, r2)
            int r5 = r5 + 1
            goto L_0x0097
        L_0x00c9:
            okhttp3.OkHttpClient r8 = c()     // Catch:{ Exception -> 0x00ea }
            okhttp3.Call r7 = r8.newCall(r7)     // Catch:{ Exception -> 0x00ea }
            okhttp3.Response r7 = r7.execute()     // Catch:{ Exception -> 0x00ea }
            int r8 = r7.code()     // Catch:{ Exception -> 0x00ea }
            java.lang.String r9 = "API1"
            boolean r9 = android.text.TextUtils.equals(r10, r9)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = "Set-Cookie"
            if (r9 == 0) goto L_0x00ec
            java.lang.String r9 = r7.header(r2)     // Catch:{ Exception -> 0x00ea }
            d = r9     // Catch:{ Exception -> 0x00ea }
            goto L_0x00fa
        L_0x00ea:
            r6 = move-exception
            goto L_0x0154
        L_0x00ec:
            java.lang.String r9 = "Gettype"
            boolean r9 = android.text.TextUtils.equals(r10, r9)     // Catch:{ Exception -> 0x00ea }
            if (r9 == 0) goto L_0x00fa
            java.lang.String r9 = r7.header(r2)     // Catch:{ Exception -> 0x00ea }
            e = r9     // Catch:{ Exception -> 0x00ea }
        L_0x00fa:
            b = r6     // Catch:{ Exception -> 0x00ea }
            java.lang.String r9 = f2968a     // Catch:{ Exception -> 0x00ea }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ea }
            r2.<init>()     // Catch:{ Exception -> 0x00ea }
            r2.append(r10)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r10 = " responseCode:"
            r2.append(r10)     // Catch:{ Exception -> 0x00ea }
            r2.append(r8)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r10 = r2.toString()     // Catch:{ Exception -> 0x00ea }
            com.geetest.sdk.utils.l.c(r9, r10)     // Catch:{ Exception -> 0x00ea }
            r10 = 200(0xc8, float:2.8E-43)
            if (r8 != r10) goto L_0x0122
            okhttp3.ResponseBody r6 = r7.body()     // Catch:{ Exception -> 0x00ea }
            java.lang.String r6 = r6.string()     // Catch:{ Exception -> 0x00ea }
            return r6
        L_0x0122:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ea }
            r7.<init>()     // Catch:{ Exception -> 0x00ea }
            java.lang.String r10 = "url: "
            r7.append(r10)     // Catch:{ Exception -> 0x00ea }
            r7.append(r6)     // Catch:{ Exception -> 0x00ea }
            r7.append(r1)     // Catch:{ Exception -> 0x00ea }
            r7.append(r8)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00ea }
            com.geetest.sdk.utils.l.c(r9, r7)     // Catch:{ Exception -> 0x00ea }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ea }
            r7.<init>()     // Catch:{ Exception -> 0x00ea }
            java.lang.String r9 = "GT3_Error_Info: url: "
            r7.append(r9)     // Catch:{ Exception -> 0x00ea }
            r7.append(r6)     // Catch:{ Exception -> 0x00ea }
            r7.append(r1)     // Catch:{ Exception -> 0x00ea }
            r7.append(r8)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r6 = r7.toString()     // Catch:{ Exception -> 0x00ea }
            return r6
        L_0x0154:
            java.lang.String r7 = f2968a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "request error:"
            r8.append(r9)
            java.lang.String r9 = r6.toString()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.geetest.sdk.utils.l.c(r7, r8)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            java.lang.String r6 = r6.toString()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            return r6
        L_0x0182:
            java.lang.String r7 = f2968a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "request error, cookie was changed:"
            r8.append(r9)
            java.lang.String r9 = r6.toString()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.geetest.sdk.utils.l.c(r7, r8)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            java.lang.String r6 = r6.toString()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.utils.n.a(java.lang.String, boolean, java.util.Map, byte[], java.lang.String):java.lang.String");
    }

    public static OkHttpClient c() {
        return b.f2970a;
    }
}
