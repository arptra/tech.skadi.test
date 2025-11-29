package com.geetest.sdk;

import android.app.Activity;
import android.text.TextUtils;
import com.geetest.sdk.b;
import com.geetest.sdk.h;
import com.geetest.sdk.model.beans.Gt3GeetestText;
import com.geetest.sdk.utils.l;
import com.honey.account.constant.AccountConstantKt;
import org.json.JSONObject;
import sdk.meizu.account.factor.authentication.sdk.constant.NetworkParamsKt;

public class x extends u {
    public static final String f = "x";

    public class b extends ab {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2998a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                b.C0012b a2;
                x.this.b.n().i();
                if (x.this.b.p() == 2 && (a2 = x.this.b.a()) != null) {
                    a2.e(Gt3GeetestText.b(), "");
                }
                x.this.b.n().e(h.i.NUMBER_ONE_CLOSE);
                x.this.d.h().onClosed(1);
            }
        }

        public b() {
            this.f2998a = false;
        }

        public void a() {
            b.C0012b a2;
            if (!this.f2998a) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "Sensebot");
                    jSONObject.put("sdkVersion", "4.4.2.1");
                    jSONObject.put("challenge", x.this.b.m().p());
                    jSONObject.put("duration", System.currentTimeMillis() - x.this.b.s());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                x.this.b.j().h().onDialogReady(jSONObject.toString());
                x.this.b.n().t();
                if (x.this.b.p() == 2 && (a2 = x.this.b.a()) != null) {
                    a2.c();
                }
                x.this.b.r().n("1");
                x xVar = x.this;
                xVar.f(xVar.b);
            }
        }

        public void b(String str, String str2) {
            this.f2998a = true;
            x xVar = x.this;
            xVar.h(str, "webview 回调错误-->" + str + "-->" + str2, str2, str.startsWith(AccountConstantKt.DEFAULT_SEGMENT));
            if (!TextUtils.isEmpty(str) && !str.startsWith(AccountConstantKt.DEFAULT_SEGMENT)) {
                x.this.b.r().n("0");
                x xVar2 = x.this;
                xVar2.f(xVar2.b);
            }
        }

        public void c(boolean z, String str) {
            if (z) {
                try {
                    com.geetest.sdk.model.beans.b m = x.this.b.m();
                    JSONObject jSONObject = new JSONObject(str);
                    m.r(jSONObject.getString(NetworkParamsKt.REQUEST_PARAM_GEETEST_CHALLENGE));
                    m.w(jSONObject.getString(NetworkParamsKt.REQUEST_PARAM_GEETEST_VALIDATE));
                    m.u(jSONObject.getString(NetworkParamsKt.REQUEST_PARAM_GEETEST_SECCODE));
                    x xVar = x.this;
                    xVar.f2954a.d(xVar.b);
                } catch (Exception e) {
                    e.printStackTrace();
                    x.this.h("202", "webview 解析json错误，错误码，202--->" + str + "  Exception: " + e.toString(), "webview parse json error-->" + str + "-->" + e.toString(), false);
                }
            } else {
                x.this.h("202", "webview 验证错误，错误码，202--->" + str, "webview parse json error-->" + str, false);
            }
        }

        public void d() {
            ((Activity) x.this.c).runOnUiThread(new a());
        }
    }

    public int a() {
        return 20;
    }

    public final void h(String str, String str2, String str3, boolean z) {
        l.c(f, str2);
        com.geetest.sdk.model.beans.a aVar = new com.geetest.sdk.model.beans.a();
        aVar.g(str3);
        aVar.f(str);
        aVar.b(System.currentTimeMillis() - this.b.s());
        aVar.c(this.b.m().p());
        aVar.d(z);
        this.b.g(aVar);
        c(this.b);
    }

    public void a(an anVar) {
        anVar.n().f(anVar.m(), new b());
    }
}
