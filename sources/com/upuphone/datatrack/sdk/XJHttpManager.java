package com.upuphone.datatrack.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.m5.b;
import com.honey.account.m5.c;
import com.upuphone.datatrack.base.db.ReportType;
import com.upuphone.datatrack.base.db.XJDataBaseManager;
import com.upuphone.datatrack.base.model.XJTrackData;
import com.upuphone.datatrack.base.utils.LogUtil;
import com.upuphone.datatrack.base.utils.gson.JsonUtil;
import com.upuphone.datatrack.sdk.bean.ConfigBean;
import com.upuphone.datatrack.sdk.bean.EventBean;
import com.upuphone.datatrack.sdk.util.AESUtil;
import com.upuphone.runasone.relay.api.IntentKey;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Marker;

public final class XJHttpManager {
    public static volatile XJHttpManager c;

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f6414a;
    public final Context b;

    public class TrustAllCerts implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public class TrustAllHostnameVerifier implements HostnameVerifier {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public interface UploadCallback {
        void a(int i, String str);

        void onSuccess();
    }

    public XJHttpManager(Context context) {
        this.b = context;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f6414a = builder.writeTimeout(10, timeUnit).readTimeout(10, timeUnit).build();
    }

    public static String d(Map map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringJoiner stringJoiner = new StringJoiner("&");
        arrayList.forEach(new b(stringJoiner, map));
        return stringJoiner.toString().replace(Marker.ANY_NON_NULL_MARKER, "%20");
    }

    public static String e(List list) {
        StringBuilder sb = new StringBuilder();
        sb.append("030");
        list.forEach(new c(sb));
        return sb.toString();
    }

    public static XJHttpManager g(Context context) {
        if (c == null) {
            synchronized (XJHttpManager.class) {
                try {
                    if (c == null) {
                        c = new XJHttpManager(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public static /* synthetic */ void i(StringJoiner stringJoiner, Map map, String str) {
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            stringJoiner.add(encode + "=" + URLEncoder.encode((String) map.get(encode), "UTF-8"));
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void j(StringBuilder sb, XJTrackData xJTrackData) {
        LogUtil.a("XJHttpManager", "数据：" + xJTrackData);
        sb.append(StringUtils.LF);
        StringBuilder sb2 = new StringBuilder("0");
        try {
            JSONObject jSONObject = new JSONObject(xJTrackData.getMsg());
            sb2.append(jSONObject.optString("_brand_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_manufacturer_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_device_model_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_product_model_"));
            sb2.append(1);
            sb2.append(jSONObject.optInt("_ter_type_"));
            sb2.append(1);
            sb2.append(xJTrackData.getIotDeviceId());
            sb2.append(1);
            sb2.append(jSONObject.optString("_iot_device_model_"));
            sb2.append(1);
            sb2.append(jSONObject.optInt("_iot_device_type_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_os_type_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_os_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_os_version_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_build_mask_"));
            sb2.append(1);
            sb2.append(jSONObject.optInt("_screen_height_"));
            sb2.append(1);
            sb2.append(jSONObject.optInt("_screen_width_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_sn_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_mac_address_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_country_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_lang_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_device_id_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_user_id_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_android_id_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_oaid_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_imei1_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_imei2_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_imsi1_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_imsi2_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_app_key_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_app_name_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_app_pkg_name_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_app_ver_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_app_model_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_app_ver_code_"));
            sb2.append(1);
            sb2.append(jSONObject.optInt("_sdk_type_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_sdk_version_"));
            sb2.append(1);
            int i = 0;
            sb2.append(jSONObject.optBoolean("_debug_") ? 1 : 0);
            sb2.append(1);
            sb2.append(jSONObject.optString("_event_type_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_event_name_"));
            sb2.append(1);
            sb2.append(xJTrackData.getId());
            sb2.append(1);
            sb2.append(jSONObject.optString("_network_type_"));
            sb2.append(1);
            sb2.append(jSONObject.optBoolean("_wifi_") ? 1 : 0);
            sb2.append(1);
            sb2.append(jSONObject.optString("_operator_"));
            sb2.append(1);
            sb2.append(jSONObject.optDouble("_longitude_"));
            sb2.append(1);
            sb2.append(jSONObject.optDouble("_latitude_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_page_"));
            sb2.append(1);
            sb2.append(jSONObject.optString("_referrer_page_"));
            sb2.append(1);
            String optString = jSONObject.optString("_event_attr_value_");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (!jSONObject2.has("iot_device_rom")) {
                    jSONObject2.put("iot_device_rom", xJTrackData.getIotDeviceRom());
                }
                JSONArray names = jSONObject2.names();
                while (true) {
                    Objects.requireNonNull(names);
                    if (i >= names.length()) {
                        break;
                    }
                    if (i != 0) {
                        sb2.append(2);
                    }
                    String str = (String) names.get(i);
                    String optString2 = jSONObject2.optString(str);
                    sb2.append(str);
                    sb2.append(3);
                    sb2.append(optString2);
                    i++;
                }
            }
            sb2.append(1);
            sb2.append(jSONObject.optLong("_event_time_"));
            sb2.append(1);
            sb2.append(jSONObject.optInt("_timezone_offset_"));
        } catch (Exception e) {
            LogUtil.d("XJHttpManager", "generateUxIpData", e);
        }
        sb.append(sb2);
    }

    public static void k(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            EventBean eventBean = (EventBean) it.next();
            arrayList.add(ReportType.newInstance(eventBean.getName(), !eventBean.getActive() ? 0 : eventBean.getRealtime() ? 2 : eventBean.getNeartime() ? 3 : 1));
        }
        XJDataBaseManager.d(XJDataTrack.h().g()).i(arrayList);
    }

    public void f() {
        if (!XJDataTrackConfig.a()) {
            LogUtil.c("XJHttpManager", "getConfig, isFeatureEnable=false");
            return;
        }
        this.f6414a.newCall(new Request.Builder().url("https://uxip-res.meizu.com/resource/v3/config/67956346876553894800").get().build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                LogUtil.d("XJHttpManager", "getConfig, onFailure: ", iOException);
            }

            public void onResponse(Call call, Response response) {
                ResponseBody body = response.body();
                if (body != null) {
                    try {
                        String b = AESUtil.b(body.bytes());
                        LogUtil.a("XJHttpManager", "getConfig, onResponse: " + b);
                        ConfigBean configBean = (ConfigBean) JsonUtil.a(b, ConfigBean.class);
                        if (configBean != null) {
                            if (configBean.getEvents() != null) {
                                XJHttpManager.k(configBean.getEvents());
                                return;
                            }
                        }
                        LogUtil.f("XJHttpManager", "getConfig, event list is empty");
                    } catch (Exception e) {
                        LogUtil.d("XJHttpManager", "getConfig, onResponse-error: ", e);
                    }
                }
            }
        });
    }

    public final byte[] h(String str) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            gZIPOutputStream.flush();
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
        } catch (Exception e) {
            LogUtil.c("XJHttpManager", "gzipData, error: " + e);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        return byteArrayOutputStream.toByteArray();
        throw th;
    }

    public final void l(String str, final UploadCallback uploadCallback) {
        if (!XJDataTrackConfig.a()) {
            LogUtil.c("XJHttpManager", "uploadTrack, isFeatureEnable=false");
            return;
        }
        String str2 = System.currentTimeMillis() + "";
        String str3 = new String(Hex.encodeHex(DigestUtils.md5(str)));
        HashMap hashMap = new HashMap();
        hashMap.put(IntentKey.ACTIVITY.ACTION_KEY, "OjUiuYe80AUYnbgBNT6");
        hashMap.put("md5", str3);
        hashMap.put("ts", str2);
        hashMap.put("nonce", str2);
        hashMap.put(AccountConstantKt.REQUEST_HEADER_SIGN, new String(Hex.encodeHex(DigestUtils.md5("POST\n/api/v3/event/iot/67956346876553894800/realtime\n" + d(hashMap)))));
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://uxip.meizu.com/api/v3/event/iot/67956346876553894800/realtime").newBuilder();
        hashMap.remove(IntentKey.ACTIVITY.ACTION_KEY);
        for (Map.Entry entry : hashMap.entrySet()) {
            newBuilder.addQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        this.f6414a.newCall(new Request.Builder().url(newBuilder.build()).method("POST", new MultipartBody.Builder().addFormDataPart("data", "data", RequestBody.create(h(str), MediaType.parse("application/octet-stream"))).build()).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                LogUtil.d("XJHttpManager", "uploadTrack, onFailure: ", iOException);
                uploadCallback.a(0, iOException.getMessage());
            }

            public void onResponse(Call call, Response response) {
                int code = response.code();
                String message = response.message();
                String string = response.body() != null ? response.body().string() : null;
                LogUtil.e("XJHttpManager", "uploadTrack, onResponse: " + string);
                if (response.isSuccessful()) {
                    uploadCallback.onSuccess();
                } else {
                    uploadCallback.a(code, message);
                }
            }
        });
    }

    public void m(List list, UploadCallback uploadCallback) {
        if (!XJDataTrackConfig.a()) {
            LogUtil.c("XJHttpManager", "uploadTrack, isFeatureEnable=false");
        } else {
            l(e(list), uploadCallback);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v23 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x012d A[SYNTHETIC, Splitter:B:27:0x012d] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0133 A[SYNTHETIC, Splitter:B:31:0x0133] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(java.lang.String r7, com.upuphone.datatrack.sdk.XJHttpManager.UploadCallback r8) {
        /*
            r6 = this;
            java.lang.String r0 = "XJHttpManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r2 = ""
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = new java.lang.String
            byte[] r3 = org.apache.commons.codec.digest.DigestUtils.md5((java.lang.String) r7)
            char[] r3 = org.apache.commons.codec.binary.Hex.encodeHex((byte[]) r3)
            r2.<init>(r3)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r4 = "OjUiuYe80AUYnbgBNT6"
            java.lang.String r5 = "key"
            r3.put(r5, r4)
            java.lang.String r4 = "md5"
            r3.put(r4, r2)
            java.lang.String r2 = "ts"
            r3.put(r2, r1)
            java.lang.String r2 = "nonce"
            r3.put(r2, r1)
            java.lang.String r1 = d(r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "POST\n/api/v3/event/iot/67956346876553894800/realtime\n"
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = new java.lang.String
            byte[] r1 = org.apache.commons.codec.digest.DigestUtils.md5((java.lang.String) r1)
            char[] r1 = org.apache.commons.codec.binary.Hex.encodeHex((byte[]) r1)
            r2.<init>(r1)
            java.lang.String r1 = "sign"
            r3.put(r1, r2)
            java.lang.String r1 = "https://uxip.meizu.com/api/v3/event/iot/67956346876553894800/realtime"
            okhttp3.HttpUrl r1 = okhttp3.HttpUrl.parse(r1)
            okhttp3.HttpUrl$Builder r1 = r1.newBuilder()
            r3.remove(r5)
            java.util.Set r2 = r3.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x007c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0098
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            r1.addQueryParameter(r4, r3)
            goto L_0x007c
        L_0x0098:
            byte[] r7 = r6.h(r7)
            java.lang.String r2 = "application/octet-stream"
            okhttp3.MediaType r2 = okhttp3.MediaType.parse(r2)
            okhttp3.RequestBody r7 = okhttp3.RequestBody.create((byte[]) r7, (okhttp3.MediaType) r2)
            okhttp3.MultipartBody$Builder r2 = new okhttp3.MultipartBody$Builder
            r2.<init>()
            java.lang.String r3 = "data"
            okhttp3.MultipartBody$Builder r7 = r2.addFormDataPart(r3, r3, r7)
            okhttp3.MultipartBody r7 = r7.build()
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder
            r2.<init>()
            okhttp3.HttpUrl r1 = r1.build()
            okhttp3.Request$Builder r1 = r2.url((okhttp3.HttpUrl) r1)
            java.lang.String r2 = "POST"
            okhttp3.Request$Builder r7 = r1.method(r2, r7)
            okhttp3.Request r7 = r7.build()
            r1 = 0
            okhttp3.OkHttpClient r6 = r6.f6414a     // Catch:{ Exception -> 0x011c }
            okhttp3.Call r6 = r6.newCall(r7)     // Catch:{ Exception -> 0x011c }
            okhttp3.Response r6 = r6.execute()     // Catch:{ Exception -> 0x011c }
            int r7 = r6.code()     // Catch:{ Exception -> 0x00f1, all -> 0x00ee }
            java.lang.String r2 = r6.message()     // Catch:{ Exception -> 0x00f1, all -> 0x00ee }
            okhttp3.ResponseBody r3 = r6.body()     // Catch:{ Exception -> 0x00f1, all -> 0x00ee }
            if (r3 == 0) goto L_0x00f4
            okhttp3.ResponseBody r1 = r6.body()     // Catch:{ Exception -> 0x00f1, all -> 0x00ee }
            java.lang.String r1 = r1.string()     // Catch:{ Exception -> 0x00f1, all -> 0x00ee }
            goto L_0x00f4
        L_0x00ee:
            r7 = move-exception
            r1 = r6
            goto L_0x0131
        L_0x00f1:
            r7 = move-exception
            r1 = r6
            goto L_0x011d
        L_0x00f4:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f1, all -> 0x00ee }
            r3.<init>()     // Catch:{ Exception -> 0x00f1, all -> 0x00ee }
            java.lang.String r4 = "uploadTrackSync, onResponse: "
            r3.append(r4)     // Catch:{ Exception -> 0x00f1, all -> 0x00ee }
            r3.append(r1)     // Catch:{ Exception -> 0x00f1, all -> 0x00ee }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x00f1, all -> 0x00ee }
            com.upuphone.datatrack.base.utils.LogUtil.e(r0, r1)     // Catch:{ Exception -> 0x00f1, all -> 0x00ee }
            boolean r1 = r6.isSuccessful()     // Catch:{ Exception -> 0x00f1, all -> 0x00ee }
            if (r1 == 0) goto L_0x0113
            r8.onSuccess()     // Catch:{ Exception -> 0x00f1, all -> 0x00ee }
            goto L_0x0116
        L_0x0113:
            r8.a(r7, r2)     // Catch:{ Exception -> 0x00f1, all -> 0x00ee }
        L_0x0116:
            r6.close()     // Catch:{ Exception -> 0x0130 }
            goto L_0x0130
        L_0x011a:
            r7 = move-exception
            goto L_0x0131
        L_0x011c:
            r7 = move-exception
        L_0x011d:
            java.lang.String r6 = "uploadTrackSync, error: "
            com.upuphone.datatrack.base.utils.LogUtil.d(r0, r6, r7)     // Catch:{ all -> 0x011a }
            java.lang.String r6 = r7.getMessage()     // Catch:{ all -> 0x011a }
            r7 = -1
            r8.a(r7, r6)     // Catch:{ all -> 0x011a }
            if (r1 == 0) goto L_0x0130
            r1.close()     // Catch:{ Exception -> 0x0130 }
        L_0x0130:
            return
        L_0x0131:
            if (r1 == 0) goto L_0x0136
            r1.close()     // Catch:{ Exception -> 0x0136 }
        L_0x0136:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.datatrack.sdk.XJHttpManager.n(java.lang.String, com.upuphone.datatrack.sdk.XJHttpManager$UploadCallback):void");
    }

    public void o(List list, UploadCallback uploadCallback) {
        if (!XJDataTrackConfig.a()) {
            LogUtil.c("XJHttpManager", "uploadTrackSync, isFeatureEnable=false");
        } else {
            n(e(list), uploadCallback);
        }
    }
}
