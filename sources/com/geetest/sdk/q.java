package com.geetest.sdk;

import android.text.TextUtils;
import com.geetest.sdk.an;
import com.geetest.sdk.b;
import com.geetest.sdk.model.beans.a;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.v;
import com.upuphone.xr.sapp.common.PermissionType;
import org.apache.commons.lang3.BooleanUtils;
import org.json.JSONObject;

public class q extends u {
    public static final String f = "q";

    public int a() {
        return 1;
    }

    public final void g(int i, String str, JSONObject jSONObject) {
        b.C0012b a2;
        String str2 = f;
        StringBuilder sb = new StringBuilder();
        sb.append("API1 result-->");
        sb.append(jSONObject == null ? " null" : jSONObject.toString());
        l.c(str2, sb.toString());
        if (!v.a(i)) {
            this.b.r().j("1");
            this.b.r().h(this.b.m().H());
            this.b.r().d(this.b.m().p());
            if (this.b.m().P()) {
                this.b.r().p(BooleanUtils.TRUE);
                this.f2954a.d(this.b);
                return;
            }
            l.c(str2, "进入宕机模式！！！");
            if (this.b.p() == 2 && (a2 = this.b.a()) != null) {
                a2.f();
            }
            this.b.r().p(BooleanUtils.FALSE);
            an anVar = this.b;
            anVar.k = an.a.SHUTDOWN;
            String a3 = al.a(anVar.m().p());
            this.b.m().r(this.b.m().p());
            com.geetest.sdk.model.beans.b m = this.b.m();
            m.u(a3 + "|jordan");
            this.b.m().w(a3);
            this.b.k(22);
            this.f2954a.d(this.b);
            f(this.b);
            return;
        }
        this.b.r().j("0");
        l.c(str2, "api1接口错误，错误码为：205-->" + str);
        a aVar = new a();
        aVar.g(str + "  {1.检查网络是否异常; 2.检查api1是否有数据返回，如果有数据返回是否符合规则; 3.检查是否和服务正常通信 }");
        aVar.f("205");
        aVar.b(System.currentTimeMillis() - this.b.s());
        aVar.c((String) null);
        this.b.g(aVar);
        f(this.b);
        c(this.b);
    }

    public void h(com.geetest.sdk.model.beans.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            g(-1, "api1 result is null !", (JSONObject) null);
        } else if (jSONObject.has("data")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                g(-1, jSONObject.toString() + "-->absent data", jSONObject);
                return;
            }
            int optInt = optJSONObject.optInt("success");
            String optString = optJSONObject.optString("challenge");
            if (TextUtils.isEmpty(optString)) {
                g(-1, jSONObject.toString() + "-->absent challenge", jSONObject);
                return;
            }
            String optString2 = optJSONObject.optString("gt");
            if (TextUtils.isEmpty(optString2)) {
                g(-1, jSONObject.toString() + "-->absent gt", jSONObject);
                return;
            }
            bVar.o(optString);
            bVar.y(optString2);
            bVar.j(optInt);
            g(0, PermissionType.OK, jSONObject);
        } else {
            int optInt2 = jSONObject.optInt("success");
            String optString3 = jSONObject.optString("challenge");
            if (TextUtils.isEmpty(optString3)) {
                g(-1, jSONObject.toString() + "-->absent challenge", jSONObject);
                return;
            }
            String optString4 = jSONObject.optString("gt");
            if (TextUtils.isEmpty(optString4)) {
                g(-1, jSONObject.toString() + "-->absent gt", jSONObject);
                return;
            }
            bVar.o(optString3);
            bVar.y(optString4);
            bVar.j(optInt2);
            g(0, PermissionType.OK, jSONObject);
        }
    }

    public void a(an anVar) {
        h(anVar.m(), this.d.a());
    }
}
