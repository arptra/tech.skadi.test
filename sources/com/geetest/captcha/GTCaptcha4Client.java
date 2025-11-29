package com.geetest.captcha;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import com.geetest.captcha.v;
import com.geetest.captcha.x;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class GTCaptcha4Client implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public final a f2840a;

    public interface OnDialogShowListener extends NoProguard {
        void a(Dialog dialog);

        void b(Dialog dialog);

        void d(Dialog dialog, boolean z);
    }

    public interface OnFailureListener extends NoProguard {
        void onFailure(String str);
    }

    public interface OnSuccessListener extends NoProguard {
        void e(boolean z, String str);
    }

    public interface OnWebViewShowListener extends NoProguard {
        void c();
    }

    public GTCaptcha4Client(Context context) {
        this.f2840a = new a(context);
    }

    public static GTCaptcha4Client h(Context context) {
        return new GTCaptcha4Client(context);
    }

    public GTCaptcha4Client f(OnFailureListener onFailureListener) {
        a aVar = this.f2840a;
        aVar.getClass();
        Intrinsics.checkNotNullParameter(onFailureListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        aVar.c = onFailureListener;
        return this;
    }

    public GTCaptcha4Client g(OnSuccessListener onSuccessListener) {
        a aVar = this.f2840a;
        aVar.getClass();
        Intrinsics.checkNotNullParameter(onSuccessListener, "response");
        aVar.b = onSuccessListener;
        return this;
    }

    public GTCaptcha4Client i(String str, GTCaptcha4Config gTCaptcha4Config) {
        this.f2840a.a(str, gTCaptcha4Config);
        return this;
    }

    public void j(boolean z) {
        this.f2840a.getClass();
        h0.c = z;
        h0.f2858a = z ? 1 : 9999;
    }

    public GTCaptcha4Client k() {
        a aVar = this.f2840a;
        aVar.getClass();
        if (System.currentTimeMillis() - a.e < ((long) 1000)) {
            h0.d.e("The interval between the two captcha is at least 1 second.");
        } else {
            a.e = System.currentTimeMillis();
            b bVar = aVar.f2843a;
            OnSuccessListener onSuccessListener = aVar.b;
            bVar.b = onSuccessListener;
            OnFailureListener onFailureListener = aVar.c;
            bVar.c = onFailureListener;
            bVar.d = aVar.d;
            Context context = bVar.i;
            if (onFailureListener == null) {
                throw new IllegalArgumentException("The OnFailureListener object cannot be null.".toString());
            } else if (onSuccessListener == null) {
                String str = e0.c;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("description", "The GTC4SessionResponse object cannot be null");
                Unit unit = Unit.INSTANCE;
                String a2 = w.d.a(x.FLOWING.getType() + d0.PARAM.getType() + "70", str, jSONObject).a();
                h0.d.e(a2);
                OnFailureListener onFailureListener2 = bVar.c;
                if (onFailureListener2 != null) {
                    onFailureListener2.onFailure(a2);
                }
            } else if (context == null) {
                String str2 = e0.c;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("description", "The context parameter should not be null");
                Unit unit2 = Unit.INSTANCE;
                String a3 = w.d.a(x.FLOWING.getType() + d0.PARAM.getType() + "71", str2, jSONObject2).a();
                h0.d.e(a3);
                OnFailureListener onFailureListener3 = bVar.c;
                if (onFailureListener3 != null) {
                    onFailureListener3.onFailure(a3);
                }
            } else if (!(context instanceof Activity)) {
                String str3 = e0.c;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("description", "The context must be an 'Activity' object");
                Unit unit3 = Unit.INSTANCE;
                String a4 = w.d.a(x.FLOWING.getType() + d0.PARAM.getType() + "72", str3, jSONObject3).a();
                h0.d.e(a4);
                OnFailureListener onFailureListener4 = bVar.c;
                if (onFailureListener4 != null) {
                    onFailureListener4.onFailure(a4);
                }
            } else {
                String str4 = bVar.f2845a;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appId");
                }
                if (TextUtils.isEmpty(str4)) {
                    String str5 = e0.c;
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("description", "The 'AppId' parameter should not be null");
                    Unit unit4 = Unit.INSTANCE;
                    String a5 = w.d.a(x.FLOWING.getType() + d0.PARAM.getType() + "74", str5, jSONObject4).a();
                    h0.d.e(a5);
                    OnFailureListener onFailureListener5 = bVar.c;
                    if (onFailureListener5 != null) {
                        onFailureListener5.onFailure(a5);
                    }
                } else {
                    p pVar = bVar.f;
                    if (pVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("request");
                    }
                    x.a aVar2 = pVar.f2875a;
                    x.a aVar3 = x.a.NONE;
                    if (aVar2 != aVar3) {
                        p pVar2 = bVar.f;
                        if (pVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("request");
                        }
                        if (pVar2.b == x.NONE) {
                            p pVar3 = bVar.f;
                            if (pVar3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("request");
                            }
                            pVar3.c(x.FLOWING);
                            p pVar4 = bVar.f;
                            if (pVar4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("request");
                            }
                            pVar4.d = bVar.b;
                            p pVar5 = bVar.f;
                            if (pVar5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("request");
                            }
                            pVar5.e = bVar.c;
                            p pVar6 = bVar.f;
                            if (pVar6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("request");
                            }
                            pVar6.f = bVar.d;
                            s sVar = bVar.h;
                            if (sVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("webViewHandler");
                            }
                            p pVar7 = bVar.f;
                            if (pVar7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("request");
                            }
                            sVar.d(pVar7);
                        }
                    }
                    bVar.h = new s();
                    Context context2 = bVar.i;
                    v.a aVar4 = v.l;
                    String str6 = bVar.f2845a;
                    if (str6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("appId");
                    }
                    p pVar8 = new p(context2, aVar4.a(str6, bVar.e));
                    bVar.f = pVar8;
                    pVar8.b(aVar3);
                    p pVar9 = bVar.f;
                    if (pVar9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("request");
                    }
                    pVar9.c(x.FLOWING);
                    p pVar10 = bVar.f;
                    if (pVar10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("request");
                    }
                    GTCaptcha4Config gTCaptcha4Config = bVar.e;
                    pVar10.c = new g(gTCaptcha4Config != null ? gTCaptcha4Config.h() : null);
                    p pVar11 = bVar.f;
                    if (pVar11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("request");
                    }
                    pVar11.d = bVar.b;
                    p pVar12 = bVar.f;
                    if (pVar12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("request");
                    }
                    pVar12.e = bVar.c;
                    p pVar13 = bVar.f;
                    if (pVar13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("request");
                    }
                    pVar13.f = bVar.d;
                    s sVar2 = bVar.h;
                    if (sVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("webViewHandler");
                    }
                    p pVar14 = bVar.f;
                    if (pVar14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("request");
                    }
                    sVar2.d(pVar14);
                }
            }
        }
        return this;
    }
}
