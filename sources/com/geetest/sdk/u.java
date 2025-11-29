package com.geetest.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.android.dingtalk.openauth.web.AuthWebviewActivity;
import com.geetest.sdk.model.beans.a;
import com.geetest.sdk.model.beans.c;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.n;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.payload.PayloadConstant;
import io.netty.handler.codec.rtsp.RtspHeaders;
import org.apache.commons.lang3.BooleanUtils;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class u implements v {
    public static final String e = "u";

    /* renamed from: a  reason: collision with root package name */
    public u f2954a;
    public an b;
    public Context c;
    public GT3ConfigBean d;

    public void b(u uVar) {
        this.f2954a = uVar;
    }

    public void c(an anVar) {
        GT3ErrorBean gT3ErrorBean;
        if (anVar == null) {
            a aVar = new a();
            aVar.g("UserRequest should not be null.");
            aVar.f("205");
            aVar.b(0);
            aVar.c("");
            gT3ErrorBean = aVar.clone();
        } else if (anVar.o() == null) {
            a aVar2 = new a();
            aVar2.g("ErrorBean should not be null.\nUserRequest: " + anVar);
            aVar2.f("205");
            aVar2.b(0);
            aVar2.c("");
            gT3ErrorBean = aVar2.clone();
        } else {
            gT3ErrorBean = anVar.o().clone();
        }
        h n = anVar.n();
        l.c(e, gT3ErrorBean.toString());
        n.c(gT3ErrorBean);
        if (!TextUtils.isEmpty(n.b)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(RtspHeaders.Values.TIME, am.a(System.currentTimeMillis()));
                jSONObject.put(AccountConstantKt.GEETEST_CAPTCHA_ID, anVar.m().H());
                jSONObject.put(AuthWebviewActivity.p, "android");
                jSONObject.put("challenge", anVar.m().p());
                jSONObject.put("exception_desc", anVar.o().e());
                jSONObject.put(MzContactsContract.MzNetContacts.ERROR_CODE_KEY, anVar.o().a());
                jSONObject.put(PayloadConstant.KEY_DEVICE_TYPE, Build.MODEL);
                jSONObject.put("device_os_version", Build.VERSION.RELEASE);
                jSONObject.put(AuthWebviewActivity.m, "4.4.2.1");
                n.b = "";
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d(an anVar) {
        if (!e(anVar)) {
            c(anVar);
        }
        if (a() >= anVar.q()) {
            a(anVar);
            return;
        }
        u uVar = this.f2954a;
        if (uVar != null) {
            uVar.d(anVar);
        } else {
            c(anVar);
        }
    }

    public boolean e(an anVar) {
        if (anVar == null) {
            return false;
        }
        this.b = anVar;
        Context l = anVar.l();
        this.c = l;
        if (l == null) {
            return false;
        }
        GT3ConfigBean j = anVar.j();
        this.d = j;
        return j != null;
    }

    public void f(an anVar) {
        c r = anVar.r();
        JSONObject jSONObject = new JSONObject();
        try {
            if ("1".equals(r.a())) {
                if ("0".equals(r.q()) && "0".equals(r.e())) {
                    r.f("1");
                    r.r("1");
                }
            }
            if ("success".equals(r.k())) {
                r.n("1");
            }
            if (!"0".equals(r.i())) {
                jSONObject.put("gt", r.g());
                jSONObject.put("challenge", r.c());
                jSONObject.put("success", r.o());
            }
            jSONObject.put("a1", r.i());
            if (!"0".equals(r.i())) {
                if (!BooleanUtils.FALSE.equals(r.o())) {
                    jSONObject.put(t.f, r.q());
                    if (!"0".equals(r.q())) {
                        jSONObject.put("g", r.e());
                        if (!"0".equals(r.e())) {
                            jSONObject.put(org.extra.tools.a.f3359a, r.a());
                            if (!"0".equals(r.a())) {
                                jSONObject.put("r", r.m());
                                if (!"0".equals(r.m())) {
                                    jSONObject.put("re", r.k());
                                }
                            }
                        }
                    }
                }
            }
            if (anVar.o() != null) {
                jSONObject.put("error", anVar.o().a());
            }
            y.b(this.c, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        GT3ConfigBean gT3ConfigBean = this.d;
        if (gT3ConfigBean != null && gT3ConfigBean.h() != null) {
            this.d.h().onStatistics(jSONObject.toString());
        }
    }
}
