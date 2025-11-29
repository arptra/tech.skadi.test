package com.geetest.sdk;

import android.content.Context;
import android.util.Pair;
import com.android.dingtalk.openauth.web.AuthWebviewActivity;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

final class l {

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final l f2941a = new l();
    }

    public static l a() {
        return b.f2941a;
    }

    public String b(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context == null) {
            return jSONObject.toString();
        }
        String e = j.e(context, "gt_fp");
        long a2 = j.a(context, "gt_ts");
        if (a2 == 0) {
            a2 = System.currentTimeMillis();
            j.b(context, "gt_ts", a2);
        }
        try {
            Pair a3 = m.a(context);
            if (a3 != null) {
                jSONObject.put("d", a3.first);
                jSONObject.put("e", a3.second);
                if (j.d(e) && !j.d((String) a3.first)) {
                    e = j.f(context, (String) a3.first);
                }
            } else {
                jSONObject.put("d", "$unknown");
                jSONObject.put("e", "$unknown");
            }
            if (j.d(e)) {
                e = j.f(context, UUID.randomUUID().toString());
            }
            jSONObject.put("fp", e);
            jSONObject.put("ts", a2 + "");
            jSONObject.put("ver", "1.0.0");
            jSONObject.put(AuthWebviewActivity.p, "android");
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public l() {
    }
}
