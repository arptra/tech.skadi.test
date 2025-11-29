package com.geetest.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.model.beans.h;
import com.geetest.sdk.utils.d;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.xr.sapp.common.PermissionType;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class aj extends ac<JSONObject> {
    public b j;

    public aj(String str, Context context) {
        super(str, context);
    }

    public static aj u(Context context, b bVar) {
        aj ajVar = new aj(d.f2960a + bVar.i() + "/gettype.php?gt=" + bVar.H() + "&t=" + System.currentTimeMillis(), context);
        ajVar.d(0);
        ajVar.o("Gettype");
        ajVar.j = bVar;
        return ajVar;
    }

    public boolean i(int i, af afVar, JSONObject jSONObject) {
        af afVar2 = afVar;
        JSONObject jSONObject2 = jSONObject;
        String optString = jSONObject2.optString("user_error");
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
                optString2 = optString2.replaceAll("[a-zA-Z]", "");
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
        String optString3 = optJSONObject.optString("type");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("aspect_radio");
        if (optJSONObject2 == null) {
            afVar2.f2905a = jSONObject.toString() + ":  " + b("aspect_radio");
            return false;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = optJSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, Integer.valueOf(optJSONObject2.optInt(next)));
        }
        String optString4 = optJSONObject.optString("fullpage");
        String optString5 = optJSONObject.optString("click");
        String optString6 = optJSONObject.optString("voice");
        String optString7 = optJSONObject.optString("slide");
        String optString8 = optJSONObject.optString("geetest");
        JSONArray optJSONArray = optJSONObject.optJSONArray("static_servers");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i2 = 0; optJSONArray.length() > i2; i2++) {
                String optString9 = optJSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString9)) {
                    arrayList.add(optString9);
                }
            }
        }
        h hVar = new h();
        hVar.d(hashMap);
        hVar.b(optString5);
        hVar.g(optString8);
        hVar.h(optString7);
        hVar.i(optString3);
        hVar.j(optString4);
        hVar.k(optString6);
        hVar.c(arrayList);
        hVar.e(optJSONObject);
        this.j.c(hVar);
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
