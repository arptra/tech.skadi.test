package com.geetest.captcha;

import com.geetest.captcha.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/geetest/captcha/handlers/PreLoadHandler;", "Lcom/geetest/captcha/handlers/base/HandlerImpl;", "<init>", "()V", "Lcom/geetest/captcha/handlers/Request;", "request", "", "handler", "(Lcom/geetest/captcha/handlers/Request;)V", "", "getHandlerLevel", "()I", "handlerLevel", "Companion", "HandlerObserver", "captcha_release"}, k = 1, mv = {1, 4, 1})
public final class o extends u {
    public int a() {
        return 1;
    }

    public void a(p pVar) {
        Intrinsics.checkNotNullParameter(pVar, "request");
        if (!pVar.e()) {
            h0.d.e("Step: PreLoadHandler.handler");
            pVar.b(x.a.FLOWING);
            pVar.a(pVar.g, pVar.h, new a(pVar, this));
        }
    }

    public static final class a implements z {

        /* renamed from: a  reason: collision with root package name */
        public final p f2874a;
        public final u b;

        public a(p pVar, u uVar) {
            Intrinsics.checkNotNullParameter(pVar, "request");
            Intrinsics.checkNotNullParameter(uVar, "handler");
            this.f2874a = pVar;
            this.b = uVar;
        }

        public void a() {
            u uVar;
            if (!this.f2874a.e()) {
                h0.d.d("PreLoadHandler", "HandlerObserver.onCallReady");
                this.f2874a.b(x.a.SUCCESS);
                p pVar = this.f2874a;
                x xVar = pVar.b;
                if (xVar != x.NONE && xVar == x.FLOWING && (uVar = this.b.f2881a) != null) {
                    uVar.d(pVar);
                }
            }
        }

        public void b() {
            if (!this.f2874a.e()) {
                h0.d.d("PreLoadHandler", "PreLoadHandler.HandlerObserver.onClose");
            }
        }

        public void a(String str) {
            u uVar;
            Intrinsics.checkNotNullParameter(str, "error");
            if (!this.f2874a.e()) {
                h0 h0Var = h0.d;
                h0Var.d("PreLoadHandler", "PreLoadHandler.HandlerObserver.onWebError: " + str);
                this.f2874a.b(x.a.FAIL);
                h0Var.e(str);
                p pVar = this.f2874a;
                x xVar = pVar.b;
                if (xVar != x.NONE && xVar == x.FLOWING && (uVar = this.b.f2881a) != null) {
                    uVar.d(pVar);
                }
            }
        }

        public void a(String str, String str2, JSONObject jSONObject) {
            u uVar;
            Intrinsics.checkNotNullParameter(str, "errorCode");
            Intrinsics.checkNotNullParameter(str2, "errorMsg");
            Intrinsics.checkNotNullParameter(jSONObject, "errorDesc");
            if (!this.f2874a.e()) {
                this.f2874a.b(x.a.FAIL);
                String type = this.f2874a.f2875a.getType();
                Intrinsics.checkNotNullParameter(str, "code");
                String a2 = w.d.a(Intrinsics.stringPlus(type, str), str2, jSONObject).a();
                h0 h0Var = h0.d;
                h0Var.d("PreLoadHandler", "PreLoadHandler.HandlerObserver.onError: " + a2);
                p pVar = this.f2874a;
                x xVar = pVar.b;
                if (xVar != x.NONE && xVar == x.FLOWING && (uVar = this.b.f2881a) != null) {
                    uVar.d(pVar);
                }
            }
        }

        public void a(boolean z, String str) {
            Intrinsics.checkNotNullParameter(str, "result");
            if (!this.f2874a.e()) {
                h0 h0Var = h0.d;
                h0Var.d("PreLoadHandler", "PreLoadHandler.HandlerObserver.onResult: " + str);
                this.f2874a.b(x.a.FAIL);
            }
        }
    }
}
