package com.geetest.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.model.beans.f;
import com.geetest.sdk.model.beans.g;
import com.geetest.sdk.utils.d;
import com.geetest.sdk.utils.q;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.xr.sapp.common.PermissionType;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ai extends ac<JSONObject> {
    public b j;

    public ai(String str, Context context) {
        super(str, context);
    }

    public static ai u(Context context, b bVar) {
        ai aiVar = new ai(v(bVar), context);
        aiVar.d(0);
        aiVar.o("GetCoder");
        aiVar.j = bVar;
        return aiVar;
    }

    public static String v(b bVar) {
        byte[] a2 = q.a();
        bVar.g(a2);
        String str = "&w=";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lang", bVar.J() == null ? "" : bVar.J());
            str = str + URLEncoder.encode(ak.c(jSONObject.toString().getBytes(), a2, q.a()), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d.f2960a + bVar.i() + "/get.php?gt=" + bVar.H() + "&challenge=" + bVar.p() + "&client_type=android&lang=" + bVar.J() + "&client_type=android" + "&pt=" + "20" + str;
    }

    public boolean i(int i, af afVar, JSONObject jSONObject) {
        af afVar2 = afVar;
        JSONObject jSONObject2 = jSONObject;
        String optString = jSONObject2.optString("user_error");
        String str = "";
        if (!TextUtils.isEmpty(optString)) {
            try {
                optString = URLDecoder.decode(optString, "utf-8");
            } catch (UnsupportedEncodingException e) {
                try {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    afVar2.f2905a = jSONObject.toString() + ": " + e2.toString();
                    return false;
                }
            }
            String optString2 = jSONObject2.optString(MzContactsContract.MzNetContacts.ERROR_CODE_KEY);
            if (optString2 != null) {
                optString2 = optString2.replaceAll("[a-zA-Z]", str);
            }
            afVar2.f2905a = optString;
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(MzContactsContract.MzNetContacts.ERROR_CODE_KEY, optString2);
            afVar2.b = jSONObject3;
            return true;
        }
        JSONObject optJSONObject = jSONObject2.optJSONObject("data");
        if (optJSONObject == null) {
            afVar2.f2905a = jSONObject.toString() + ":  " + b("data");
            return false;
        }
        String optString3 = optJSONObject.optString(s.f);
        String optString4 = optJSONObject.optString("theme_version");
        String optString5 = optJSONObject.optString("feedback");
        if (!TextUtils.isEmpty(optString5)) {
            str = optString5;
        }
        String optString6 = optJSONObject.optString("api_server");
        if (TextUtils.isEmpty(optString6)) {
            afVar2.f2905a = jSONObject.toString() + ":  " + b("api_server");
            return false;
        }
        String optString7 = optJSONObject.optString("theme");
        if (!optJSONObject.has("logo")) {
            afVar2.f2905a = jSONObject.toString() + ":  " + b("logo");
            return false;
        }
        boolean optBoolean = optJSONObject.optBoolean("logo");
        f.a(optBoolean);
        JSONArray optJSONArray = optJSONObject.optJSONArray("static_servers");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i2 = 0; optJSONArray.length() > i2; i2++) {
                String optString8 = optJSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString8)) {
                    arrayList.add(optString8);
                }
            }
        }
        if (arrayList.size() == 0) {
            afVar2.f2905a = jSONObject.toString() + ":  " + b("static_servers");
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("c");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                arrayList2.add(Integer.valueOf(optJSONArray2.optInt(i3)));
            }
        }
        g gVar = new g();
        gVar.b(optString6);
        int indexOf = optString6.indexOf("/");
        if (indexOf > 0) {
            gVar.f(optString6.substring(0, indexOf));
        } else {
            gVar.f(optString6);
        }
        gVar.c(arrayList2);
        gVar.i(str);
        gVar.d(optBoolean);
        gVar.g(arrayList);
        gVar.k(optString7);
        gVar.l(optString4);
        gVar.j(optString3);
        this.j.b(gVar);
        afVar2.f2905a = PermissionType.OK;
        afVar2.b = jSONObject2;
        return true;
    }

    public Map n() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHeaders.Values.APPLICATION_X_WWW_FORM_URLENCODED);
        b bVar = this.j;
        if (bVar != null) {
            hashMap.put("Host", bVar.m());
        }
        byte[] bArr = this.f;
        hashMap.put("Content-Length", String.valueOf(bArr == null ? 0 : bArr.length));
        return hashMap;
    }

    public boolean q() {
        return false;
    }
}
