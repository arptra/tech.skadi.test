package com.geetest.captcha;

import android.content.Context;
import android.util.Pair;
import com.android.dingtalk.openauth.web.AuthWebviewActivity;
import com.geetest.captcha.k;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public final class j {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final j f2863a = new j();
    }

    public String a(Context context) {
        String str;
        long j;
        k kVar = k.a.f2864a;
        JSONObject jSONObject = new JSONObject();
        if (context == null) {
            return jSONObject.toString();
        }
        try {
            str = context.getSharedPreferences("gt_fp", 0).getString("gt_fp", (String) null);
        } catch (Exception unused) {
            str = "$unknown";
        }
        try {
            j = context.getSharedPreferences("gt_fp", 0).getLong("gt_ts", 0);
        } catch (Exception unused2) {
            j = 0;
        }
        if (j == 0) {
            j = System.currentTimeMillis();
            try {
                context.getSharedPreferences("gt_fp", 0).edit().putLong("gt_ts", j).apply();
            } catch (Exception unused3) {
            }
        }
        try {
            jSONObject.put("bd", "$unknown");
            Pair a2 = l.a(context);
            if (a2 != null) {
                jSONObject.put("d", a2.first);
                jSONObject.put("e", a2.second);
                if (i.g(str) && !i.g((String) a2.first)) {
                    str = i.a(context, (String) a2.first);
                }
            } else {
                jSONObject.put("d", "$unknown");
                jSONObject.put("e", "$unknown");
            }
            if (i.g(str)) {
                str = i.a(context, UUID.randomUUID().toString());
            }
            jSONObject.put("fp", str);
            jSONObject.put("ts", j + "");
            jSONObject.put("ver", "1.0.0");
            jSONObject.put(AuthWebviewActivity.p, "android");
        } catch (JSONException unused4) {
        }
        return jSONObject.toString();
    }
}
