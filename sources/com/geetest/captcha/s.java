package com.geetest.captcha;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.geetest.captcha.w;
import com.geetest.captcha.x;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/geetest/captcha/handlers/WebViewHandler;", "Lcom/geetest/captcha/handlers/base/HandlerImpl;", "<init>", "()V", "Lcom/geetest/captcha/handlers/Request;", "request", "", "handler", "(Lcom/geetest/captcha/handlers/Request;)V", "", "getHandlerLevel", "()I", "handlerLevel", "Companion", "HandlerObserver", "captcha_release"}, k = 1, mv = {1, 4, 1})
public final class s extends u {
    public int a() {
        return 5;
    }

    public void a(p pVar) {
        Intrinsics.checkNotNullParameter(pVar, "request");
        if (!pVar.e()) {
            h0 h0Var = h0.d;
            h0Var.e("Step: WebViewHandler.handler");
            a aVar = new a(pVar, this);
            pVar.c(x.FLOWING);
            h0Var.b("Request", "currentStatus preLoadStatus: " + pVar.f2875a.name() + ", status: " + pVar.b.name());
            x.a aVar2 = pVar.f2875a;
            if (aVar2 == x.a.FLOWING) {
                pVar.g(pVar.g, pVar.h, aVar);
            } else if (aVar2 == x.a.SUCCESS) {
                pVar.h();
                pVar.g(pVar.g, pVar.h, aVar);
            } else if (aVar2 == x.a.FAIL) {
                pVar.a(pVar.g, pVar.h, aVar);
                if (pVar.b != x.FAIL) {
                    pVar.g(pVar.g, pVar.h, aVar);
                }
            } else if (aVar2 == x.a.NONE) {
                pVar.a(pVar.g, pVar.h, aVar);
                if (pVar.b != x.FAIL) {
                    pVar.g(pVar.g, pVar.h, aVar);
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/geetest/captcha/handlers/WebViewHandler$HandlerObserver;", "Lcom/geetest/captcha/observer/WebViewObserver;", "request", "Lcom/geetest/captcha/handlers/Request;", "handler", "Lcom/geetest/captcha/handlers/base/HandlerImpl;", "(Lcom/geetest/captcha/handlers/Request;Lcom/geetest/captcha/handlers/base/HandlerImpl;)V", "onCallReady", "", "onClose", "onError", "errorCode", "", "errorMsg", "errorDesc", "Lorg/json/JSONObject;", "onResult", "status", "", "result", "onWebError", "error", "onWebFailure", "fail", "captcha_release"}, k = 1, mv = {1, 4, 1})
    public static final class a implements z {

        /* renamed from: a  reason: collision with root package name */
        public final p f2879a;
        public final u b;

        /* renamed from: com.geetest.captcha.s$a$a  reason: collision with other inner class name */
        public static final class C0011a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f2880a;

            public C0011a(a aVar) {
                this.f2880a = aVar;
            }

            public final void run() {
                this.f2880a.f2879a.h();
            }
        }

        public a(p pVar, u uVar) {
            Intrinsics.checkNotNullParameter(pVar, "request");
            Intrinsics.checkNotNullParameter(uVar, "handler");
            this.f2879a = pVar;
            this.b = uVar;
        }

        public void a() {
            if (!this.f2879a.e()) {
                h0.d.b("WebViewHandler", "WebViewHandler.HandlerObserver.onCallReady");
                this.f2879a.c(x.SUCCESS);
                if (Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
                    this.f2879a.h();
                    return;
                }
                Context context = this.f2879a.g;
                if (context != null) {
                    ((Activity) context).runOnUiThread(new C0011a(this));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        }

        public void b() {
            if (!this.f2879a.e()) {
                h0 h0Var = h0.d;
                h0Var.b("WebViewHandler", "WebViewHandler.HandlerObserver.onClose");
                this.f2879a.c(x.FAIL);
                String type = x.CANCEL.getType();
                String str = d0.USER_ERROR.getType() + "60";
                Intrinsics.checkNotNullParameter(str, "code");
                String stringPlus = Intrinsics.stringPlus(type, str);
                w.a aVar = w.d;
                String str2 = e0.d;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("description", "User cancelled 'Captcha'");
                Unit unit = Unit.INSTANCE;
                String a2 = aVar.a(stringPlus, str2, jSONObject).a();
                h0Var.e("WebViewHandler: " + a2);
                this.f2879a.f();
                this.f2879a.d(a2);
            }
        }

        public void a(String str) {
            Intrinsics.checkNotNullParameter(str, "error");
            if (!this.f2879a.e()) {
                h0 h0Var = h0.d;
                h0Var.d("WebViewHandler", "WebViewHandler.HandlerObserver.onWebError: " + str);
                this.f2879a.c(x.FAIL);
                this.b.b(this.f2879a, str);
            }
        }

        public void a(String str, String str2, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(str, "errorCode");
            Intrinsics.checkNotNullParameter(str2, "errorMsg");
            Intrinsics.checkNotNullParameter(jSONObject, "errorDesc");
            if (!this.f2879a.e()) {
                this.f2879a.c(x.FAIL);
                String type = this.f2879a.b.getType();
                Intrinsics.checkNotNullParameter(str, "code");
                String a2 = w.d.a(Intrinsics.stringPlus(type, str), str2, jSONObject).a();
                h0 h0Var = h0.d;
                h0Var.d("WebViewHandler", "WebViewHandler.HandlerObserver.onError: " + a2);
                this.b.b(this.f2879a, a2);
            }
        }

        public void a(boolean z, String str) {
            Intrinsics.checkNotNullParameter(str, "result");
            if (!this.f2879a.e()) {
                h0 h0Var = h0.d;
                h0Var.d("WebViewHandler", "HandlerObserver.onResult: " + str);
                if (z) {
                    this.f2879a.c(x.END);
                    this.b.c(this.f2879a, true, str);
                    return;
                }
                this.f2879a.c(x.FLOWING);
                this.b.c(this.f2879a, false, str);
            }
        }
    }
}
