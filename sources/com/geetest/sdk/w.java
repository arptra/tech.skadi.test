package com.geetest.sdk;

import android.app.Activity;
import com.geetest.sdk.b;
import com.geetest.sdk.model.beans.f;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.u;
import com.geetest.sdk.utils.v;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.xr.sapp.common.PermissionType;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

public class w extends u {
    public static final String f = "w";

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ an f2993a;

        /* renamed from: com.geetest.sdk.w$a$a  reason: collision with other inner class name */
        public class C0016a implements ae<JSONObject> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean[] f2994a;
            public final /* synthetic */ com.geetest.sdk.model.beans.a[] b;
            public final /* synthetic */ CountDownLatch c;

            public C0016a(boolean[] zArr, com.geetest.sdk.model.beans.a[] aVarArr, CountDownLatch countDownLatch) {
                this.f2994a = zArr;
                this.b = aVarArr;
                this.c = countDownLatch;
            }

            /* renamed from: b */
            public void a(int i, String str, JSONObject jSONObject) {
                af h = w.this.i(i, str, jSONObject);
                this.f2994a[0] = ((Boolean) h.f2905a).booleanValue();
                this.b[0] = (com.geetest.sdk.model.beans.a) h.b;
                this.c.countDown();
            }
        }

        public class b implements ae<JSONObject> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean[] f2995a;
            public final /* synthetic */ com.geetest.sdk.model.beans.a[] b;
            public final /* synthetic */ CountDownLatch c;

            public b(boolean[] zArr, com.geetest.sdk.model.beans.a[] aVarArr, CountDownLatch countDownLatch) {
                this.f2995a = zArr;
                this.b = aVarArr;
                this.c = countDownLatch;
            }

            /* renamed from: b */
            public void a(int i, String str, JSONObject jSONObject) {
                af j = w.this.g(i, str, jSONObject);
                this.f2995a[1] = ((Boolean) j.f2905a).booleanValue();
                this.b[1] = (com.geetest.sdk.model.beans.a) j.b;
                this.c.countDown();
            }
        }

        public class c implements Runnable {
            public c() {
            }

            public void run() {
                a aVar = a.this;
                w.this.f(aVar.f2993a);
                a aVar2 = a.this;
                w.this.c(aVar2.f2993a);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            public void run() {
                a aVar = a.this;
                w.this.f(aVar.f2993a);
                a aVar2 = a.this;
                w.this.c(aVar2.f2993a);
            }
        }

        public a(an anVar) {
            this.f2993a = anVar;
        }

        public void run() {
            CountDownLatch countDownLatch = new CountDownLatch(2);
            boolean[] zArr = {false, false};
            com.geetest.sdk.model.beans.a[] aVarArr = {null, null};
            d.c(this.f2993a.l(), this.f2993a.m(), new C0016a(zArr, aVarArr, countDownLatch));
            d.b(this.f2993a.l(), this.f2993a.m(), new b(zArr, aVarArr, countDownLatch));
            try {
                countDownLatch.await();
                boolean z = zArr[0];
                if (!z || !zArr[1]) {
                    if (!z) {
                        this.f2993a.g(aVarArr[0]);
                    } else {
                        this.f2993a.g(aVarArr[1]);
                    }
                    ((Activity) w.this.c).runOnUiThread(new c());
                    return;
                }
                w.this.f2954a.d(this.f2993a);
            } catch (Exception e) {
                e.printStackTrace();
                this.f2993a.r().r("0");
                String k = w.f;
                l.c(k, "GetTypeAndGetHandler InterruptedException: 206-->" + e.getMessage());
                com.geetest.sdk.model.beans.a aVar = new com.geetest.sdk.model.beans.a();
                aVar.g("GetTypeAndGetHandler InterruptedException: " + e.getMessage());
                aVar.f("206");
                aVar.b(System.currentTimeMillis() - this.f2993a.s());
                aVar.c(this.f2993a.m().p());
                this.f2993a.g(aVar);
                ((Activity) w.this.c).runOnUiThread(new d());
            }
        }
    }

    public int a() {
        return 5;
    }

    public final af g(int i, String str, JSONObject jSONObject) {
        b.C0012b a2;
        if (v.a(i)) {
            this.b.r().f("0");
            String str2 = f;
            l.c(str2, "get接口返回错误，错误码为：207-->" + str);
            com.geetest.sdk.model.beans.a aVar = new com.geetest.sdk.model.beans.a();
            aVar.g(str);
            aVar.f("207");
            aVar.b(System.currentTimeMillis() - this.b.s());
            aVar.c(this.b.m().p());
            return new af(Boolean.FALSE, aVar);
        } else if (!PermissionType.OK.equals(str)) {
            this.b.r().f("0");
            String str3 = f;
            l.c(str3, "get接口返回错误，错误码为：207-->" + str);
            com.geetest.sdk.model.beans.a aVar2 = new com.geetest.sdk.model.beans.a();
            aVar2.g(str);
            aVar2.f(jSONObject.optString(MzContactsContract.MzNetContacts.ERROR_CODE_KEY));
            aVar2.b(System.currentTimeMillis() - this.b.s());
            aVar2.c(this.b.m().p());
            return new af(Boolean.FALSE, aVar2);
        } else {
            this.b.r().f("1");
            if (this.b.p() == 2 && (a2 = this.b.a()) != null) {
                if (f.b()) {
                    a2.b();
                } else {
                    a2.g();
                }
            }
            return new af(Boolean.TRUE, (Object) null);
        }
    }

    public final af i(int i, String str, JSONObject jSONObject) {
        if (v.a(i)) {
            this.b.r().r("0");
            String str2 = f;
            l.c(str2, "gettype接口返回值为null，错误码为：206-->" + str);
            com.geetest.sdk.model.beans.a aVar = new com.geetest.sdk.model.beans.a();
            aVar.g(str);
            aVar.f("206");
            aVar.b(System.currentTimeMillis() - this.b.s());
            aVar.c(this.b.m().p());
            return new af(Boolean.FALSE, aVar);
        } else if (!PermissionType.OK.equals(str)) {
            this.b.r().r("0");
            String str3 = f;
            l.c(str3, "gettype接口返回错误，错误码为：206-->" + str);
            com.geetest.sdk.model.beans.a aVar2 = new com.geetest.sdk.model.beans.a();
            aVar2.g(str);
            aVar2.f(jSONObject.optString(MzContactsContract.MzNetContacts.ERROR_CODE_KEY));
            aVar2.b(System.currentTimeMillis() - this.b.s());
            aVar2.c(this.b.m().p());
            return new af(Boolean.FALSE, aVar2);
        } else {
            this.b.r().r("1");
            return new af(Boolean.TRUE, (Object) null);
        }
    }

    public void a(an anVar) {
        u.a().b(new a(anVar));
    }
}
