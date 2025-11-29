package com.geetest.sdk;

import com.geetest.sdk.model.beans.a;
import com.geetest.sdk.utils.l;
import org.json.JSONObject;
import sdk.meizu.account.factor.authentication.sdk.constant.NetworkParamsKt;

public class t extends u {
    public static final String f = "t";

    public int a() {
        return 25;
    }

    public void a(an anVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NetworkParamsKt.REQUEST_PARAM_GEETEST_CHALLENGE, anVar.m().x());
            jSONObject.put(NetworkParamsKt.REQUEST_PARAM_GEETEST_SECCODE, anVar.m().z());
            jSONObject.put(NetworkParamsKt.REQUEST_PARAM_GEETEST_VALIDATE, anVar.m().B());
            anVar.j().h().onDialogResult(jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
            String str = f;
            l.c(str, "拼接错误，错误码为：202-->" + e.toString());
            a aVar = new a();
            aVar.g("onDialogResult error-->" + e.toString());
            aVar.f("202");
            aVar.b(System.currentTimeMillis() - anVar.s());
            aVar.c(anVar.m().p());
            anVar.g(aVar);
            c(anVar);
        }
    }
}
