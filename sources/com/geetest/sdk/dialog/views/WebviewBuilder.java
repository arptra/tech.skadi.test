package com.geetest.sdk.dialog.views;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.NoProguard;
import com.geetest.sdk.aa;
import com.geetest.sdk.ab;
import com.geetest.sdk.g;
import com.geetest.sdk.utils.d;
import com.geetest.sdk.utils.i;
import com.geetest.sdk.utils.l;
import com.meizu.common.widget.MzContactsContract;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class WebviewBuilder {
    public static final String m = "WebviewBuilder";
    public static int n;
    public static int o;

    /* renamed from: a  reason: collision with root package name */
    public Context f2920a;
    public aa b;
    public com.geetest.sdk.model.beans.b c;
    public GT3ConfigBean d;
    public int e;
    public int f;
    public g g;
    public int h;
    public GtWebView i = null;
    public String j;
    public Runnable k;
    public Handler l = new b();

    public class JSInterface implements NoProguard {

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f2922a;
            public final /* synthetic */ String b;

            public a(int i, String str) {
                this.f2922a = i;
                this.b = str;
            }

            public void run() {
                if (WebviewBuilder.this.d == null || WebviewBuilder.this.d.h() == null) {
                    l.c(WebviewBuilder.m, "configBean is null !");
                } else {
                    WebviewBuilder.this.d.h().onReceiveCaptchaCode(this.f2922a);
                }
                if (WebviewBuilder.this.b == null) {
                    return;
                }
                if (this.f2922a == 1) {
                    WebviewBuilder.this.b.d(true, this.b);
                } else {
                    WebviewBuilder.this.k();
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                if (WebviewBuilder.this.i != null && !WebviewBuilder.this.i.f()) {
                    if (WebviewBuilder.this.l != null) {
                        try {
                            WebviewBuilder.this.l.removeCallbacks(WebviewBuilder.this.k);
                            WebviewBuilder.this.l.removeMessages(1);
                        } catch (Exception unused) {
                        }
                    }
                    if (WebviewBuilder.this.b != null) {
                        WebviewBuilder.this.b.a();
                    }
                }
            }
        }

        public class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f2924a;

            public c(String str) {
                this.f2924a = str;
            }

            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(this.f2924a);
                    WebviewBuilder.this.b.c(jSONObject.getString(MzContactsContract.MzNetContacts.ERROR_CODE_KEY).replaceAll("[a-zA-Z]", ""), jSONObject.getString("user_error"));
                } catch (Exception e) {
                    e.printStackTrace();
                    aa b2 = WebviewBuilder.this.b;
                    b2.c("202", this.f2924a + "-->" + e.toString());
                }
            }
        }

        public class d implements Runnable {
            public d() {
            }

            public void run() {
                WebviewBuilder.this.i.setVoice(true);
                WebviewBuilder.this.c.C("voice");
                int a2 = i.a(WebviewBuilder.this.f2920a);
                int b = i.b(WebviewBuilder.this.f2920a);
                int b2 = com.geetest.sdk.utils.g.b(WebviewBuilder.this.f2920a, 275.0f);
                int b3 = com.geetest.sdk.utils.g.b(WebviewBuilder.this.f2920a, 348.0f);
                int b4 = com.geetest.sdk.utils.g.b(WebviewBuilder.this.f2920a, 300.0f);
                if (WebviewBuilder.this.f2920a.getApplicationContext().getResources().getConfiguration().orientation == 1) {
                    int i = (b * 4) / 5;
                    if (i >= b4) {
                        b4 = i;
                    }
                    if (i <= b3) {
                        b3 = b4;
                    }
                    WebviewBuilder.n = b3;
                    WebviewBuilder.o = (b3 * WebviewBuilder.this.h) / 100;
                } else {
                    int b5 = com.geetest.sdk.utils.g.b(WebviewBuilder.this.f2920a, (float) (com.geetest.sdk.utils.g.d(WebviewBuilder.this.f2920a, (float) a2) - 44));
                    if (b5 >= b2) {
                        b2 = b5;
                    }
                    if (b5 <= b3) {
                        b3 = b2;
                    }
                    WebviewBuilder.o = b3;
                    WebviewBuilder.n = (b3 * 100) / WebviewBuilder.this.h;
                }
                if (!(WebviewBuilder.this.i == null || WebviewBuilder.this.i.getLayoutParams() == null)) {
                    ViewGroup.LayoutParams layoutParams = WebviewBuilder.this.i.getLayoutParams();
                    layoutParams.width = WebviewBuilder.n;
                    layoutParams.height = WebviewBuilder.o;
                    WebviewBuilder.this.i.setLayoutParams(layoutParams);
                }
                if (WebviewBuilder.this.g != null) {
                    com.geetest.sdk.utils.d.c = true;
                    try {
                        WebviewBuilder.this.g.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                com.geetest.sdk.utils.d.c = false;
            }
        }

        public JSInterface() {
        }

        @JavascriptInterface
        public void gt3Error(String str) {
            l.c("JSInterface-->gt3Error", str);
            if (WebviewBuilder.this.l != null) {
                try {
                    WebviewBuilder.this.l.removeCallbacks(WebviewBuilder.this.k);
                    WebviewBuilder.this.l.removeMessages(1);
                } catch (Exception unused) {
                }
            }
            if (WebviewBuilder.this.b != null && WebviewBuilder.this.f2920a != null && (WebviewBuilder.this.f2920a instanceof Activity)) {
                ((Activity) WebviewBuilder.this.f2920a).runOnUiThread(new c(str));
            }
        }

        @JavascriptInterface
        public void gtCallBack(String str, String str2, String str3) {
            String o = WebviewBuilder.m;
            l.c(o, "JSInterface-->gtCallBack-->code: " + str + ", message: " + str3);
            String o2 = WebviewBuilder.m;
            l.e(o2, "JSInterface-->gtCallBack-->code: " + str + ", result: " + str2 + ", message: " + str3);
            try {
                int parseInt = Integer.parseInt(str);
                if (WebviewBuilder.this.f2920a != null && !((Activity) WebviewBuilder.this.f2920a).isFinishing()) {
                    ((Activity) WebviewBuilder.this.f2920a).runOnUiThread(new a(parseInt, str2));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public void gtClose() {
            l.c(WebviewBuilder.m, "JSInterface-->gtClose");
            if (WebviewBuilder.this.b != null) {
                WebviewBuilder.this.b.e();
            }
        }

        @JavascriptInterface
        public void gtNotify(String str) {
            String o = WebviewBuilder.m;
            l.c(o, "JSInterface-->gtNotify-->" + str);
            try {
                int unused = WebviewBuilder.this.h = Integer.parseInt(new JSONObject(str).getString("aspect_radio"));
                if (WebviewBuilder.this.f2920a != null && !((Activity) WebviewBuilder.this.f2920a).isFinishing()) {
                    ((Activity) WebviewBuilder.this.f2920a).runOnUiThread(new d());
                }
            } catch (Exception e) {
                e.printStackTrace();
                aa b2 = WebviewBuilder.this.b;
                b2.c("202", "parse aspect_radio failed-->" + e.toString());
            }
        }

        @JavascriptInterface
        public void gtReady() {
            l.c(WebviewBuilder.m, "JSInterface-->gtReady");
            if (WebviewBuilder.this.f2920a != null && (WebviewBuilder.this.f2920a instanceof Activity)) {
                ((Activity) WebviewBuilder.this.f2920a).runOnUiThread(new b());
            }
        }

        public /* synthetic */ JSInterface(WebviewBuilder webviewBuilder, a aVar) {
            this();
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            WebviewBuilder.this.i.removeJavascriptInterface("JSInterface");
            ViewGroup viewGroup = (ViewGroup) WebviewBuilder.this.i.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(WebviewBuilder.this.i);
            }
            WebviewBuilder.this.i.removeAllViews();
            WebviewBuilder.this.i.destroy();
            GtWebView unused = WebviewBuilder.this.i = null;
        }
    }

    public class b extends Handler {
        public b() {
        }

        public void handleMessage(Message message) {
            if (message.what == 1 && WebviewBuilder.this.b != null) {
                l.c(WebviewBuilder.m, String.format("handleMessage-->timeout %s !", new Object[]{Integer.valueOf(WebviewBuilder.this.c.L())}));
                WebviewBuilder.this.b.c("204", "load static resource timeout !");
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            Message message = new Message();
            message.what = 1;
            WebviewBuilder.this.l.sendMessage(message);
        }
    }

    public WebviewBuilder(Context context, g gVar) {
        this.f2920a = context;
        this.b = new aa();
        this.g = gVar;
    }

    public GtWebView c() {
        String str;
        String str2;
        String str3;
        String str4;
        new HashMap();
        this.h = this.c.I();
        new HashMap();
        Map a2 = this.c.F().a();
        if (a2 == null || a2.size() <= 0) {
            str2 = "";
            str = str2;
        } else {
            str2 = "";
            str = str2;
            for (Map.Entry entry : a2.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    str = str + "&aspect_radio_" + ((String) entry.getKey()) + "=" + entry.getValue();
                    str2 = str2 + "&" + ((String) entry.getKey()) + "=" + this.c.F().f().optString((String) entry.getKey());
                }
            }
        }
        Map v = this.c.v();
        if (v == null || v.size() <= 0) {
            str3 = "";
        } else {
            str3 = "";
            for (Map.Entry entry2 : v.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry2.getKey())) {
                    str3 = str3 + "&" + ((String) entry2.getKey()) + "=" + ((String) entry2.getValue());
                }
            }
        }
        this.j = "?gt=" + this.c.H() + "&challenge=" + this.c.p() + "&lang=" + this.c.J() + "&title=&type=" + this.c.K() + "&api_server=" + this.c.D().a() + "&static_servers=" + this.c.D().h().toString().replace("[", "").replace("]", "") + "&width=100%&timeout=" + this.c.N() + "&debug=" + this.c.O() + str + str2 + str3;
        List h2 = this.c.D().h();
        if (h2 == null || h2.size() <= 0) {
            str4 = d.f2960a + "static.geetest.com/static/appweb/app3-index.html" + this.j;
        } else {
            str4 = d.f2960a + String.format("%s/static/appweb/app3-index.html", new Object[]{h2.get(0)}) + this.j;
        }
        try {
            GtWebView gtWebView = new GtWebView(this.f2920a.getApplicationContext());
            this.i = gtWebView;
            gtWebView.b();
            if (this.l != null) {
                c cVar = new c();
                this.k = cVar;
                this.l.postDelayed(cVar, (long) this.c.L());
            }
            this.i.setObservable(this.b);
            this.i.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.i.setStaticUrl(str4);
            this.i.setDataBean(this.c);
            this.i.setMyHandler(this.l);
            this.i.setRunnable(this.k);
            this.i.loadUrl(str4);
            this.i.buildLayer();
            this.i.addJavascriptInterface(new JSInterface(this, (a) null), "JSInterface");
            this.i.setTimeout(this.c.L());
            m();
        } catch (Exception e2) {
            e2.printStackTrace();
            l.c(m, "默认webview内核丢失，错误码：204_3-->" + e2.toString());
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                l.c(m, stackTraceElement.toString());
            }
            Handler handler = this.l;
            if (handler != null) {
                try {
                    handler.removeCallbacks(this.k);
                    this.l.removeMessages(1);
                } catch (Exception unused) {
                }
            }
            aa aaVar = this.b;
            if (aaVar != null) {
                aaVar.c("204_3", "webview crate error -->" + e2.toString());
            }
        }
        return this.i;
    }

    public void e(GT3ConfigBean gT3ConfigBean) {
        this.d = gT3ConfigBean;
    }

    public void f(ab abVar) {
        this.b.b(abVar);
    }

    public void g(com.geetest.sdk.model.beans.b bVar) {
        this.c = bVar;
    }

    public void i() {
        GtWebView gtWebView = this.i;
        if (gtWebView != null) {
            gtWebView.post(new a());
        }
        try {
            Handler handler = this.l;
            if (handler != null) {
                handler.removeCallbacks(this.k);
                this.l.removeMessages(1);
                this.l = null;
            }
        } catch (Exception unused) {
        }
    }

    public void k() {
        GtWebView gtWebView = this.i;
        if (gtWebView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(gtWebView, "translationX", new float[]{0.0f, 2.0f, 4.0f, 2.0f, 0.0f, -2.0f, -4.0f, -2.0f, 0.0f, 2.0f, 4.0f, 2.0f, 0.0f, -2.0f, -4.0f, -2.0f, 0.0f});
            ofFloat.setDuration(500);
            ofFloat.start();
        }
    }

    public void m() {
        q();
        GtWebView gtWebView = this.i;
        if (gtWebView != null && gtWebView.getLayoutParams() != null) {
            n = this.e;
            o = this.f;
            ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
            layoutParams.width = n;
            layoutParams.height = o;
            this.i.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00a5, code lost:
        if (r2 > r3) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00a8, code lost:
        if (r2 > r4) goto L_0x00af;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int q() {
        /*
            r10 = this;
            android.content.Context r0 = r10.f2920a
            int r0 = com.geetest.sdk.utils.i.a(r0)
            android.content.Context r1 = r10.f2920a
            int r1 = com.geetest.sdk.utils.i.b(r1)
            android.content.Context r2 = r10.f2920a
            r3 = 1133903872(0x43960000, float:300.0)
            int r2 = com.geetest.sdk.utils.g.b(r2, r3)
            android.content.Context r3 = r10.f2920a
            r4 = 1133084672(0x43898000, float:275.0)
            com.geetest.sdk.utils.g.b(r3, r4)
            android.content.Context r3 = r10.f2920a
            r4 = 1137508352(0x43cd0000, float:410.0)
            int r3 = com.geetest.sdk.utils.g.b(r3, r4)
            android.content.Context r4 = r10.f2920a
            r5 = 1135476736(0x43ae0000, float:348.0)
            int r4 = com.geetest.sdk.utils.g.b(r4, r5)
            java.lang.String r5 = m
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "widthScreen: "
            r6.append(r7)
            android.content.Context r7 = r10.f2920a
            float r8 = (float) r1
            int r7 = com.geetest.sdk.utils.g.d(r7, r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.geetest.sdk.utils.l.e(r5, r6)
            if (r0 >= r1) goto L_0x0050
            int r6 = r0 * 4
            int r6 = r6 / 5
            goto L_0x0054
        L_0x0050:
            int r6 = r1 * 4
            int r6 = r6 / 5
        L_0x0054:
            com.geetest.sdk.model.beans.b r7 = r10.c
            java.lang.String r7 = r7.K()
            java.lang.String r8 = "beeline"
            boolean r7 = r8.equals(r7)
            r8 = 100
            if (r7 != 0) goto L_0x00eb
            int r7 = r10.h
            r9 = 60
            if (r7 > r9) goto L_0x006c
            goto L_0x00eb
        L_0x006c:
            if (r7 < r8) goto L_0x00c8
            com.geetest.sdk.model.beans.b r2 = r10.c
            java.lang.String r2 = r2.K()
            java.lang.String r7 = "slide"
            r7.equals(r2)
            if (r0 >= r1) goto L_0x00ad
            android.content.Context r2 = r10.f2920a
            float r6 = (float) r0
            int r6 = com.geetest.sdk.utils.g.d(r2, r6)
            int r6 = r6 + -44
            float r6 = (float) r6
            int r2 = com.geetest.sdk.utils.g.b(r2, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "limitationWidth:  "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.geetest.sdk.utils.l.c(r5, r6)
            android.content.Context r6 = r10.f2920a
            boolean r6 = com.geetest.sdk.utils.h.c(r6)
            if (r6 == 0) goto L_0x00a8
            if (r2 <= r3) goto L_0x00ab
            goto L_0x00b2
        L_0x00a8:
            if (r2 <= r4) goto L_0x00ab
            goto L_0x00af
        L_0x00ab:
            r3 = r2
            goto L_0x00b2
        L_0x00ad:
            if (r6 <= r4) goto L_0x00b1
        L_0x00af:
            r3 = r4
            goto L_0x00b2
        L_0x00b1:
            r3 = r6
        L_0x00b2:
            if (r0 >= r1) goto L_0x00be
            r10.f = r3
            int r0 = r3 * 100
            int r1 = r10.h
            int r0 = r0 / r1
            r10.e = r0
            goto L_0x00c6
        L_0x00be:
            r10.e = r3
            int r0 = r10.h
            int r0 = r0 * r3
            int r0 = r0 / r8
            r10.f = r0
        L_0x00c6:
            r6 = r3
            goto L_0x00f3
        L_0x00c8:
            if (r0 >= r1) goto L_0x00dd
            android.content.Context r1 = r10.f2920a
            float r0 = (float) r0
            int r0 = com.geetest.sdk.utils.g.d(r1, r0)
            int r0 = r0 + -44
            float r0 = (float) r0
            int r0 = com.geetest.sdk.utils.g.b(r1, r0)
            if (r0 <= r4) goto L_0x00db
            goto L_0x00e1
        L_0x00db:
            r4 = r0
            goto L_0x00e1
        L_0x00dd:
            if (r6 <= r4) goto L_0x00e0
            goto L_0x00e1
        L_0x00e0:
            r4 = r6
        L_0x00e1:
            r10.e = r4
            int r0 = r10.h
            int r0 = r0 * r4
            int r0 = r0 / r8
            r10.f = r0
            r6 = r4
            goto L_0x00f3
        L_0x00eb:
            r10.e = r2
            int r0 = r10.h
            int r2 = r2 * r0
            int r2 = r2 / r8
            r10.f = r2
        L_0x00f3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "widthPX: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            com.geetest.sdk.utils.l.e(r5, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "widthDP: "
            r0.append(r1)
            android.content.Context r1 = r10.f2920a
            float r2 = (float) r6
            int r1 = com.geetest.sdk.utils.g.d(r1, r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.geetest.sdk.utils.l.e(r5, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "height:  "
            r0.append(r1)
            int r1 = r10.h
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.geetest.sdk.utils.l.e(r5, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "mWidth:  "
            r0.append(r1)
            int r1 = r10.e
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.geetest.sdk.utils.l.e(r5, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "mHeight:  "
            r0.append(r1)
            int r1 = r10.f
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.geetest.sdk.utils.l.e(r5, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "deviceWidth: "
            r0.append(r1)
            android.content.Context r1 = r10.f2920a
            int r2 = com.geetest.sdk.utils.i.b(r1)
            float r2 = (float) r2
            int r1 = com.geetest.sdk.utils.g.d(r1, r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.geetest.sdk.utils.l.e(r5, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "deviceHeight: "
            r0.append(r1)
            android.content.Context r10 = r10.f2920a
            int r1 = com.geetest.sdk.utils.i.a(r10)
            float r1 = (float) r1
            int r10 = com.geetest.sdk.utils.g.d(r10, r1)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            com.geetest.sdk.utils.l.e(r5, r10)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.dialog.views.WebviewBuilder.q():int");
    }
}
