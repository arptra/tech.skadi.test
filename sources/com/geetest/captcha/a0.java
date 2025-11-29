package com.geetest.captcha;

import android.content.Context;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.geetest.gtc4.GeeGuard;
import com.geetest.gtc4.GeeGuardConfiguration;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static Map f2844a;
    public static final a0 b = new a0();

    public final String a(Context context, String str) {
        Class<String> cls = String.class;
        try {
            h0.d.c("isGtc4Available");
            Class<GeeGuard> cls2 = GeeGuard.class;
            Class<GeeGuardConfiguration> cls3 = GeeGuardConfiguration.class;
            Class<GeeGuardConfiguration.Builder> cls4 = GeeGuardConfiguration.Builder.class;
            GeeGuardConfiguration.Builder newInstance = cls4.newInstance();
            Method method = cls4.getMethod("setAppId", new Class[]{cls});
            if (method != null) {
                method.invoke(newInstance, new Object[]{"54847f3301740c85982a1d3d566bd24e"});
            }
            Method method2 = cls4.getMethod("setExtraInfo", new Class[]{HashMap.class});
            if (method2 != null) {
                method2.invoke(newInstance, new Object[]{f2844a});
            }
            Method method3 = cls4.getMethod("setAlInfo", new Class[]{Boolean.TYPE});
            if (method3 != null) {
                method3.invoke(newInstance, new Object[]{Boolean.FALSE});
            }
            Method method4 = cls4.getMethod("setDevInfo", new Class[]{Boolean.TYPE});
            if (method4 != null) {
                method4.invoke(newInstance, new Object[]{Boolean.TRUE});
            }
            Method method5 = cls4.getMethod("setLevel", new Class[]{Integer.TYPE});
            if (method5 != null) {
                method5.invoke(newInstance, new Object[]{1});
            }
            Method method6 = cls4.getMethod("addSignature", new Class[]{cls});
            if (method6 != null) {
                method6.invoke(newInstance, new Object[]{str});
            }
            Method method7 = cls4.getMethod(JsonPOJOBuilder.DEFAULT_BUILD_METHOD, (Class[]) null);
            Object invoke = method7 != null ? method7.invoke(newInstance, (Object[]) null) : null;
            Method method8 = cls2.getMethod("getData", new Class[]{Context.class, cls3});
            Object invoke2 = method8 != null ? method8.invoke((Object) null, new Object[]{context, invoke}) : null;
            if (invoke2 != null) {
                return (String) invoke2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e) {
            h0 h0Var = h0.d;
            h0Var.c("gtc4 date:" + e);
            return null;
        }
    }

    public final String b(Context context, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "url");
        if (context != null) {
            try {
                StringBuilder sb = new StringBuilder();
                f0 a2 = f0.c.a(str);
                if (a2 != null) {
                    String str3 = a2.f2854a;
                    Map map = a2.b;
                    Intrinsics.checkNotNullParameter(str3, "baseUrl");
                    if (map != null) {
                        str2 = (String) map.get("data");
                        JSONObject jSONObject = new JSONObject(URLDecoder.decode(str2, "utf-8"));
                        String string = jSONObject.getString("challenge");
                        sb.append(jSONObject.getString("captchaId"));
                        sb.append(string);
                        sb.append(context.getPackageName());
                        sb.append("1.8.3.1");
                        h0.d.a("Sign content: " + sb);
                        return a(context, sb.toString());
                    }
                }
                str2 = null;
                JSONObject jSONObject2 = new JSONObject(URLDecoder.decode(str2, "utf-8"));
                String string2 = jSONObject2.getString("challenge");
                sb.append(jSONObject2.getString("captchaId"));
                sb.append(string2);
                sb.append(context.getPackageName());
                sb.append("1.8.3.1");
                h0.d.a("Sign content: " + sb);
                return a(context, sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
