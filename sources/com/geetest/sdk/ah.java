package com.geetest.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.android.dingtalk.openauth.web.AuthWebviewActivity;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.utils.d;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.q;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.xr.sapp.common.PermissionType;
import io.netty.handler.codec.http.HttpHeaders;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ah extends ac<JSONObject> {
    public b j;

    public ah(String str, Context context) {
        super(str, context);
    }

    public static ah u(Context context, b bVar) {
        ah ahVar = new ah(d.f2960a + bVar.D().a() + "/ajax.php?gt=" + bVar.H() + "&challenge=" + bVar.p() + "&client_type=android&lang=" + bVar.J(), context);
        ahVar.d(0);
        ahVar.j = bVar;
        ahVar.o("Ajax");
        ahVar.h(true);
        return ahVar;
    }

    public boolean i(int i, af afVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("user_error");
        if (!TextUtils.isEmpty(optString)) {
            try {
                optString = URLDecoder.decode(optString, "utf-8");
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    afVar.f2905a = jSONObject.toString() + ": " + e2.toString();
                    return false;
                }
            }
            String optString2 = jSONObject.optString(MzContactsContract.MzNetContacts.ERROR_CODE_KEY);
            if (optString2 != null) {
                optString2 = optString2.replaceAll("[a-zA-Z]", "");
            }
            afVar.f2905a = optString;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MzContactsContract.MzNetContacts.ERROR_CODE_KEY, optString2);
            afVar.b = jSONObject2;
            return true;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            afVar.f2905a = jSONObject.toString() + ":  " + b("data");
            return false;
        }
        String optString3 = optJSONObject.optString("result");
        if (TextUtils.isEmpty(optString3)) {
            afVar.f2905a = jSONObject.toString() + ":  " + b("result");
            return false;
        }
        this.j.C(optString3);
        if (this.j.F() == null) {
            afVar.f2905a = "GetTypeBean is null";
            return false;
        } else if (this.j.F().f() == null) {
            afVar.f2905a = "GetTypeBean JsonObject is null";
            return false;
        } else {
            if (this.j.F().f().has(optString3)) {
                b bVar = this.j;
                bVar.E(bVar.F().f().optString(optString3));
            } else {
                this.j.E((String) null);
            }
            if (optJSONObject.has("validate")) {
                this.j.G(optJSONObject.optString("validate"));
            }
            afVar.f2905a = PermissionType.OK;
            afVar.b = jSONObject;
            return true;
        }
    }

    public Map n() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHeaders.Values.APPLICATION_X_WWW_FORM_URLENCODED);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("Content-Encoding", "gzip");
        b bVar = this.j;
        if (bVar != null) {
            hashMap.put("Host", bVar.D().e());
        }
        byte[] bArr = this.f;
        hashMap.put("Content-Length", String.valueOf(bArr == null ? 0 : bArr.length));
        return hashMap;
    }

    public boolean q() {
        return super.q();
    }

    public JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            String a2 = y.a(this.b);
            JSONObject jSONObject2 = new JSONObject();
            if (a2 != null) {
                jSONObject2.put("mi", a2.replaceAll(" ", ""));
            }
            jSONObject2.put("light", "");
            jSONObject2.put("gid", k.a().b(this.b.getApplicationContext()));
            jSONObject.put("gt", this.j.H());
            jSONObject.put("challenge", this.j.p());
            jSONObject.put(AuthWebviewActivity.p, "android");
            jSONObject.put("pt", "20");
            l.e("AjaxCoder", "ajax add info: " + jSONObject2.toString());
            jSONObject.put(w.f, ak.c(jSONObject2.toString().getBytes(), this.j.h(), q.a()));
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            l.c("AjaxCoder", e.toString());
            return null;
        }
    }
}
