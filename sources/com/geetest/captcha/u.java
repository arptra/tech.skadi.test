package com.geetest.captcha;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.geetest.captcha.GTCaptcha4Client;
import kotlin.jvm.internal.Intrinsics;

public abstract class u implements t {

    /* renamed from: a  reason: collision with root package name */
    public u f2881a;

    public void b(p pVar, String str) {
        Intrinsics.checkNotNullParameter(pVar, "request");
        Intrinsics.checkNotNullParameter(str, "error");
        if (!pVar.e()) {
            h0 h0Var = h0.d;
            h0Var.e("HandlerImpl.onFailure: " + str);
            if (pVar.b == x.FAIL) {
                pVar.f();
                pVar.d(str);
            }
        }
    }

    public void c(p pVar, boolean z, String str) {
        Intrinsics.checkNotNullParameter(pVar, "request");
        Intrinsics.checkNotNullParameter(str, "result");
        if (!pVar.e()) {
            if (z) {
                pVar.f();
            }
            Intrinsics.checkNotNullParameter(str, "result");
            try {
                if (!Intrinsics.areEqual((Object) Looper.getMainLooper(), (Object) Looper.myLooper())) {
                    Context context = pVar.g;
                    if (context != null) {
                        ((Activity) context).runOnUiThread(new q(pVar, z, str));
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                }
                GTCaptcha4Client.OnSuccessListener onSuccessListener = pVar.d;
                if (onSuccessListener != null) {
                    onSuccessListener.e(z, str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void d(p pVar) {
        Intrinsics.checkNotNullParameter(pVar, "request");
        if (!pVar.e()) {
            if (a() >= 0) {
                a(pVar);
                return;
            }
            u uVar = this.f2881a;
            if (uVar != null) {
                uVar.d(pVar);
            }
        }
    }
}
