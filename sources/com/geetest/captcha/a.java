package com.geetest.captcha;

import android.content.Context;
import com.geetest.captcha.GTCaptcha4Client;
import com.geetest.captcha.v;
import com.geetest.captcha.x;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u0014J\u001f\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010 \u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b \u0010\u001fJ\u0015\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\b¢\u0006\u0004\b%\u0010\u0014R\u0014\u0010'\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010)R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010*R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010+¨\u0006-"}, d2 = {"Lcom/geetest/captcha/GTCaptcha4Holder;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/geetest/captcha/GTCaptcha4Client$OnFailureListener;", "listener", "", "addOnFailureListener", "(Lcom/geetest/captcha/GTCaptcha4Client$OnFailureListener;)V", "Lcom/geetest/captcha/GTCaptcha4Client$OnSuccessListener;", "response", "addOnSuccessListener", "(Lcom/geetest/captcha/GTCaptcha4Client$OnSuccessListener;)V", "Lcom/geetest/captcha/GTCaptcha4Client$OnWebViewShowListener;", "webViewShowListener", "addOnWebViewShowListener", "(Lcom/geetest/captcha/GTCaptcha4Client$OnWebViewShowListener;)V", "cancel", "()V", "Landroid/content/res/Configuration;", "newConfig", "configurationChanged", "(Landroid/content/res/Configuration;)V", "destroy", "", "appId", "Lcom/geetest/captcha/GTCaptcha4Config;", "config", "init", "(Ljava/lang/String;Lcom/geetest/captcha/GTCaptcha4Config;)V", "preLoadWithCaptcha", "", "enable", "setLogEnable", "(Z)V", "verifyWithCaptcha", "Lcom/geetest/captcha/controller/Controller;", "controller", "Lcom/geetest/captcha/controller/Controller;", "Lcom/geetest/captcha/GTCaptcha4Client$OnFailureListener;", "Lcom/geetest/captcha/GTCaptcha4Client$OnSuccessListener;", "Lcom/geetest/captcha/GTCaptcha4Client$OnWebViewShowListener;", "Companion", "captcha_release"}, k = 1, mv = {1, 4, 1})
public final class a {
    public static long e;
    public static final b f = new b();

    /* renamed from: a  reason: collision with root package name */
    public final b f2843a;
    public GTCaptcha4Client.OnSuccessListener b;
    public GTCaptcha4Client.OnFailureListener c;
    public GTCaptcha4Client.OnWebViewShowListener d;

    /* renamed from: com.geetest.captcha.a$a  reason: collision with other inner class name */
    public static final class C0007a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0007a(Context context) {
            super(0);
            this.$context = context;
        }

        public final void invoke() {
            String str = null;
            File externalFilesDir = this.$context.getApplicationContext().getExternalFilesDir((String) null);
            if (externalFilesDir != null) {
                str = externalFilesDir.getAbsolutePath();
            }
            i0.f2862a = str;
        }
    }

    public static final class b {
    }

    public a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2843a = new b(context);
        try {
            ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new C0007a(context), 31, (Object) null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        e0.f.a(context);
    }

    public final void a(String str, GTCaptcha4Config gTCaptcha4Config) {
        Intrinsics.checkNotNullParameter(str, "appId");
        b bVar = this.f2843a;
        bVar.getClass();
        Intrinsics.checkNotNullParameter(str, "appId");
        bVar.f2845a = str;
        b bVar2 = this.f2843a;
        bVar2.e = gTCaptcha4Config;
        bVar2.g = new o();
        bVar2.h = new s();
        o oVar = bVar2.g;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preLoadHandler");
        }
        s sVar = bVar2.h;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webViewHandler");
        }
        oVar.f2881a = sVar;
        Context context = bVar2.i;
        v.a aVar = v.l;
        String str2 = bVar2.f2845a;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appId");
        }
        p pVar = new p(context, aVar.a(str2, bVar2.e));
        bVar2.f = pVar;
        pVar.b(x.a.FLOWING);
        p pVar2 = bVar2.f;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("request");
        }
        pVar2.c(x.NONE);
        p pVar3 = bVar2.f;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("request");
        }
        GTCaptcha4Config gTCaptcha4Config2 = bVar2.e;
        pVar3.c = new g(gTCaptcha4Config2 != null ? gTCaptcha4Config2.h() : null);
        o oVar2 = bVar2.g;
        if (oVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preLoadHandler");
        }
        p pVar4 = bVar2.f;
        if (pVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("request");
        }
        oVar2.d(pVar4);
    }
}
