package com.geetest.sdk;

import com.geetest.sdk.an;
import com.geetest.sdk.b;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.v;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.xr.sapp.common.PermissionType;
import org.json.JSONObject;

public class s extends u {
    public static final String f = "s";

    public class a implements ae<JSONObject> {
        public a() {
        }

        /* renamed from: b */
        public void a(int i, String str, JSONObject jSONObject) {
            s.this.g(i, str, jSONObject);
        }
    }

    /* access modifiers changed from: private */
    public void g(int i, String str, JSONObject jSONObject) {
        b.C0012b a2;
        if (this.b.p() == 2 && (a2 = this.b.a()) != null) {
            a2.h();
        }
        if (v.a(i)) {
            this.b.r().b("0");
            i("208", "ajax接口返回错误，错误码为：208-->" + str, str);
        } else if (!PermissionType.OK.equals(str)) {
            this.b.r().b("0");
            i(jSONObject.optString(MzContactsContract.MzNetContacts.ERROR_CODE_KEY), "ajax接口返回错误，错误码为：208-->" + str, str);
        } else {
            com.geetest.sdk.model.beans.b m = this.b.m();
            String K = m.K();
            this.b.r().l(K);
            if ("success".equals(K)) {
                l.c(f, "进入一键通过模式！！！");
                this.b.r().b("1");
                f(this.b);
                this.b.k = an.a.ONEPASS;
                m.r(m.p());
                m.w(m.M());
                m.u(m.M() + "|jordan");
                this.b.k(22);
                this.f2954a.d(this.b);
            } else if ("forbidden".equals(K)) {
                this.b.r().b("0");
                i("200", "ajax接口被forbidden，错误码为：200-->" + str, jSONObject.toString());
            } else if (m.F().f().has(K)) {
                int intValue = ((Integer) m.F().a().get(K)).intValue();
                if (intValue == 0) {
                    this.b.r().b("0");
                    i("208", "ajax接口返回错误，dialogHeight为0，错误码为：208-->" + m.F().toString(), str);
                    return;
                }
                this.b.r().b("1");
                m.n(intValue);
                this.f2954a.d(this.b);
            } else {
                this.b.r().b("0");
                i("208", "ajax接口返回错误，错误码为：208-->" + jSONObject.toString(), "data type error-->" + jSONObject.toString());
            }
        }
    }

    public int a() {
        return 15;
    }

    public final void i(String str, String str2, String str3) {
        l.c(f, str2);
        com.geetest.sdk.model.beans.a aVar = new com.geetest.sdk.model.beans.a();
        aVar.g(str3);
        aVar.f(str);
        aVar.b(System.currentTimeMillis() - this.b.s());
        aVar.c(this.b.m().p());
        this.b.g(aVar);
        f(this.b);
        c(this.b);
    }

    public void a(an anVar) {
        d.a(anVar.l(), anVar.m(), new a());
    }
}
