package com.upuphone.xr.sapp.utils;

import android.content.Intent;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.meizu.net.pedometerprovider.util.Constants;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.contract.ProtocolActivity;
import com.upuphone.xr.sapp.monitor.net.TokenInterceptor;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.json.JSONObject;

public class NpsUtils {
    public static NpsUtils g;

    /* renamed from: a  reason: collision with root package name */
    public final String f7901a = "NpsUtils";
    public final String b = "/survey/v3/exist";
    public final String c = "76164384446510845940";
    public final String d = "android";
    public final String e = "mobile";
    public String f = "nps_key_";

    public static class NpsInfo {

        /* renamed from: a  reason: collision with root package name */
        public String f7903a;
        public String b;

        public static NpsInfo a(String str) {
            if (str != null && !str.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("uuid");
                    String string = jSONObject.getString("generateTime");
                    NpsInfo npsInfo = new NpsInfo();
                    npsInfo.f7903a = optString;
                    npsInfo.b = string;
                    return npsInfo;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("uuid", this.f7903a);
                jSONObject.put("generateTime", this.b);
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }

        public NpsInfo() {
        }
    }

    public static synchronized NpsUtils b() {
        NpsUtils npsUtils;
        synchronized (NpsUtils.class) {
            try {
                if (g == null) {
                    g = new NpsUtils();
                }
                npsUtils = g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return npsUtils;
    }

    public final String c() {
        return NetConfig.t("sNbsSurvey") + "/survey/v3/exist";
    }

    public final NpsInfo d(String str) {
        String str2 = (String) DataStoreUtils.e.a().f(e(str), "");
        if (str2.isEmpty()) {
            return null;
        }
        return NpsInfo.a(str2);
    }

    public final String e(String str) {
        return this.f + str;
    }

    public final String f() {
        return NetConfig.u() + "/#/?";
    }

    public void g(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            NpsInfo d2 = d(str2);
            ULog.d("NpsUtils", "init nps: " + d2);
            if (d2 == null) {
                String uuid = UUID.randomUUID().toString();
                NpsInfo npsInfo = new NpsInfo();
                npsInfo.f7903a = uuid;
                npsInfo.b = str;
                DataStoreUtils.e.a().o(e(str2), npsInfo.toString());
            }
        }
    }

    public void h(String str, String str2) {
        final NpsInfo d2 = d(str);
        ULog.d("NpsUtils", "requestNpsExist: " + d2);
        if (d2 != null) {
            final String country = !BuildConfig.f6575a.booleanValue() ? Constants.CHINA_COUNTRY : Locale.getDefault().getCountry();
            final String language = Locale.getDefault().getLanguage();
            final String q = HttpRequestUtil.f7890a.q(str2);
            FormBody.Builder builder = new FormBody.Builder();
            builder.add("channel", "android");
            builder.add("platform", "mobile");
            builder.add("generateTime", d2.b);
            builder.add("model", str);
            builder.add(com.upuphone.runasone.constant.Constants.DEVICE_ID, q);
            builder.add("country", country);
            builder.add("language", language);
            FormBody build = builder.build();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < build.size(); i++) {
                stringBuffer.append(build.name(i) + "=[" + build.value(i) + "]\n");
            }
            ULog.d("NpsUtils", "NpsExist() formBody:" + stringBuffer.toString());
            String c2 = c();
            ULog.d("NpsUtils", "url: " + c2);
            final String str3 = str;
            new OkHttpClient.Builder().addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)).addInterceptor(new TokenInterceptor()).build().newCall(new Request.Builder().url(c2).addHeader("appId", "76164384446510845940").addHeader(Oauth2AccessToken.KEY_UID, d2.f7903a).post(build).build()).enqueue(new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    ULog.d("NpsUtils", "NpsExist() onFailure" + iOException);
                }

                public void onResponse(Call call, Response response) {
                    ULog.d("NpsUtils", "NpsExist() onResponse" + response.code() + "=" + response.isSuccessful());
                    if (response.isSuccessful()) {
                        try {
                            JsonObject jsonObject = (JsonObject) new Gson().fromJson(response.body().string(), JsonObject.class);
                            int asInt = jsonObject.get("code").getAsInt();
                            String asString = jsonObject.get(PayloadConstant.PARAMS_KEY_CALLBACK_MSG).getAsString();
                            ULog.d("NpsUtils", "jsonObject: " + jsonObject);
                            if (asInt == 0) {
                                JsonObject asJsonObject = jsonObject.getAsJsonObject("data");
                                if (asJsonObject != null) {
                                    boolean asBoolean = asJsonObject.get("existSurvey").getAsBoolean();
                                    int asInt2 = asJsonObject.get("surveyId").getAsInt();
                                    ULog.d("NpsUtils", "NpsExist() onResponse existSurvey" + asBoolean + "=surveyId=" + asInt2);
                                    if (asBoolean) {
                                        Bundle bundle = new Bundle();
                                        bundle.putBoolean("enable_refresh", false);
                                        bundle.putString("title", MainApplication.l.getString(R.string.questionnaire_investigation));
                                        bundle.putString("url", NpsUtils.this.i(asInt2, str3, q, country, language, d2));
                                        Intent intent = new Intent(MainApplication.l, ProtocolActivity.class);
                                        intent.putExtra("data", bundle);
                                        intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                                        MainApplication.l.startActivity(intent);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            ULog.d("NpsUtils", "NpsExist() onResponse NPS exist" + asString);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public final String i(int i, String str, String str2, String str3, String str4, NpsInfo npsInfo) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f());
        stringBuffer.append("appId=");
        stringBuffer.append("76164384446510845940");
        stringBuffer.append("&platform=");
        stringBuffer.append("mobile");
        stringBuffer.append("&uuid=");
        stringBuffer.append(npsInfo.f7903a);
        stringBuffer.append("&generateTime=");
        stringBuffer.append(npsInfo.b);
        stringBuffer.append("&model=");
        stringBuffer.append(str);
        stringBuffer.append("&deviceId=");
        stringBuffer.append(str2);
        stringBuffer.append("&country=");
        stringBuffer.append(str3);
        stringBuffer.append("&language=");
        stringBuffer.append(str4);
        stringBuffer.append("&surveyId=");
        stringBuffer.append(i);
        ULog.d("NpsUtils", "requestNpsHtmlUrl  " + stringBuffer.toString());
        return stringBuffer.toString();
    }
}
