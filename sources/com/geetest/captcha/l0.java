package com.geetest.captcha;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.geetest.captcha.views.GTC4WebView;
import com.geetest.captcha.w;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0000H\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/geetest/captcha/views/WebViewBuilder;", "", "builder", "Lcom/geetest/captcha/views/WebViewBuilder$Builder;", "(Lcom/geetest/captcha/views/WebViewBuilder$Builder;)V", "jsInterface", "Lcom/geetest/captcha/views/WebViewBuilder$JSInterface;", "observable", "Lcom/geetest/captcha/observer/WebViewObservable;", "url", "", "webView", "Lcom/geetest/captcha/views/GTC4WebView;", "getWebView", "()Lcom/geetest/captcha/views/GTC4WebView;", "loadUrl", "setObservable", "", "Builder", "JSInterface", "captcha_release"}, k = 1, mv = {1, 4, 1})
public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2868a;
    public y b;
    public final GTC4WebView c;
    public b d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f2869a;
        public y b;
        public GTC4WebView c;

        public final y a() {
            y yVar = this.b;
            if (yVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("observable");
            }
            return yVar;
        }

        public final String b() {
            String str = this.f2869a;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("url");
            }
            return str;
        }

        public final GTC4WebView c() {
            GTC4WebView gTC4WebView = this.c;
            if (gTC4WebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            return gTC4WebView;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0007J\u001e\u0010\f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/geetest/captcha/views/WebViewBuilder$JSInterface;", "", "url", "", "webView", "Lcom/geetest/captcha/views/GTC4WebView;", "observable", "Lcom/geetest/captcha/observer/WebViewObservable;", "(Ljava/lang/String;Lcom/geetest/captcha/views/GTC4WebView;Lcom/geetest/captcha/observer/WebViewObservable;)V", "gt4Notify", "", "response", "setObservable", "captcha_release"}, k = 1, mv = {1, 4, 1})
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f2870a;
        public GTC4WebView b;
        public y c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 1})
        public static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f2871a;
            public final /* synthetic */ String b;

            /* renamed from: com.geetest.captcha.l0$b$a$a  reason: collision with other inner class name */
            public static final class C0010a<T> implements ValueCallback<String> {

                /* renamed from: a  reason: collision with root package name */
                public static final C0010a f2872a = new C0010a();

                public void onReceiveValue(Object obj) {
                    h0 h0Var = h0.d;
                    h0Var.a("WebViewBuilder javascript:jsBridge.callback('postNativeMessage') return: " + ((String) obj));
                }
            }

            public a(b bVar, String str) {
                this.f2871a = bVar;
                this.b = str;
            }

            public final void run() {
                GTC4WebView gTC4WebView = this.f2871a.b;
                gTC4WebView.evaluateJavascript("javascript:jsBridge.callback('postNativeMessage', '" + this.b + "')", C0010a.f2872a);
            }
        }

        public b(String str, GTC4WebView gTC4WebView, y yVar) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(gTC4WebView, "webView");
            Intrinsics.checkNotNullParameter(yVar, "observable");
            this.f2870a = str;
            this.b = gTC4WebView;
            this.c = yVar;
        }

        @JavascriptInterface
        public final void gt4Notify(@Nullable String str) {
            String b2;
            h0.d.e("JSInterface.gt4Notify: " + str + ", main: " + Intrinsics.areEqual((Object) Looper.getMainLooper(), (Object) Looper.myLooper()));
            if (str == null || StringsKt.isBlank(str)) {
                String str2 = e0.f2852a;
                w.a aVar = w.d;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("description", "The Web callback data is empty");
                Unit unit = Unit.INSTANCE;
                this.c.b(d0.WEB_CALLBACK_ERROR.getType() + "80", str2, jSONObject);
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                String string = jSONObject2.getString("type");
                if (string != null) {
                    switch (string.hashCode()) {
                        case -934426595:
                            if (string.equals("result")) {
                                String jSONObject3 = jSONObject2.getJSONObject("data").toString();
                                Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonObject.getJSONObject(\"data\").toString()");
                                this.c.c(true, jSONObject3);
                                return;
                            }
                            break;
                        case 102230:
                            if (string.equals("get")) {
                                try {
                                    if ((!Intrinsics.areEqual((Object) Looper.getMainLooper(), (Object) Looper.myLooper())) && (this.b.getContext() instanceof Activity) && (b2 = a0.b.b(this.b.getContext(), this.f2870a)) != null) {
                                        if (!StringsKt.isBlank(b2)) {
                                            Context context = this.b.getContext();
                                            if (context != null) {
                                                ((Activity) context).runOnUiThread(new a(this, b2));
                                                return;
                                            }
                                            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                                        }
                                        return;
                                    }
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            break;
                        case 3135262:
                            if (string.equals("fail")) {
                                String jSONObject4 = jSONObject2.getJSONObject("data").toString();
                                Intrinsics.checkNotNullExpressionValue(jSONObject4, "jsonObject.getJSONObject(\"data\").toString()");
                                this.c.c(false, jSONObject4);
                                return;
                            }
                            break;
                        case 94756344:
                            if (string.equals("close")) {
                                Iterator it = this.c.f2888a.iterator();
                                while (it.hasNext()) {
                                    ((z) it.next()).b();
                                }
                                return;
                            }
                            break;
                        case 96784904:
                            if (string.equals("error")) {
                                String jSONObject5 = jSONObject2.getJSONObject("data").toString();
                                Intrinsics.checkNotNullExpressionValue(jSONObject5, "jsonObject.getJSONObject(\"data\").toString()");
                                y yVar = this.c;
                                yVar.getClass();
                                Intrinsics.checkNotNullParameter(jSONObject5, "error");
                                Iterator it2 = yVar.f2888a.iterator();
                                while (it2.hasNext()) {
                                    ((z) it2.next()).a(jSONObject5);
                                }
                                return;
                            }
                            break;
                        case 108386723:
                            if (string.equals("ready")) {
                                Iterator it3 = this.c.f2888a.iterator();
                                while (it3.hasNext()) {
                                    ((z) it3.next()).a();
                                }
                                return;
                            }
                            break;
                    }
                }
                String str3 = e0.f2852a;
                w.a aVar2 = w.d;
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("description", jSONObject2);
                Unit unit2 = Unit.INSTANCE;
                this.c.b(d0.WEB_CALLBACK_ERROR.getType() + "82", str3, jSONObject6);
            } catch (Exception e2) {
                e2.printStackTrace();
                String str4 = e0.f2852a;
                w.a aVar3 = w.d;
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("exception", e2.getMessage());
                jSONObject7.put("description", str);
                Unit unit3 = Unit.INSTANCE;
                this.c.b(d0.WEB_CALLBACK_ERROR.getType() + "81", str4, jSONObject7);
            }
        }
    }

    public l0(a aVar) {
        this.f2868a = aVar.b();
        this.b = aVar.a();
        this.c = aVar.c();
    }

    public final l0 a() {
        b bVar = new b(this.f2868a, this.c, this.b);
        this.d = bVar;
        this.c.addJavascriptInterface(bVar, "JSInterface");
        this.c.buildLayer();
        this.c.loadUrl(this.f2868a);
        this.c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return this;
    }
}
