package com.geetest.captcha;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R4\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058\u0006@BX.¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R$\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00188\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR$\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00188\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001c\u0010\u001bR(\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013RD\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001f2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001f8\u0006@BX\u000e¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R4\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@BX\u000e¢\u0006\f\n\u0004\b$\u0010\b\u001a\u0004\b%\u0010\nR$\u0010&\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010\u000f¨\u0006)"}, d2 = {"Lcom/geetest/captcha/model/DataBean;", "", "<init>", "()V", "", "", "<set-?>", "apiServers", "[Ljava/lang/String;", "getApiServers", "()[Ljava/lang/String;", "", "backgroundColor", "I", "getBackgroundColor", "()I", "captchaId", "Ljava/lang/String;", "getCaptchaId", "()Ljava/lang/String;", "dialogStyle", "getDialogStyle", "html", "getHtml", "", "isCanceledOnTouchOutside", "Z", "()Z", "isDebug", "language", "getLanguage", "", "params", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "staticServers", "getStaticServers", "timeOut", "getTimeOut", "Companion", "captcha_release"}, k = 1, mv = {1, 4, 1})
public final class v {
    public static final a l = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f2882a;
    public String b = "file:///android_asset/gt4-index.html";
    public boolean c;
    public String d;
    public String[] e;
    public String[] f;
    public Map g;
    public boolean h = true;
    public int i = 10000;
    public int j;
    public String k;

    public static final class a {
        public final v a(String str, GTCaptcha4Config gTCaptcha4Config) {
            Intrinsics.checkNotNullParameter(str, "captchaId");
            v vVar = new v();
            vVar.f2882a = str;
            if (gTCaptcha4Config != null) {
                vVar.c = gTCaptcha4Config.p();
                String j = gTCaptcha4Config.j();
                Intrinsics.checkNotNullExpressionValue(j, "it.html");
                vVar.b = j;
                vVar.d = gTCaptcha4Config.k();
                vVar.e = gTCaptcha4Config.f();
                vVar.f = gTCaptcha4Config.m();
                vVar.h = gTCaptcha4Config.o();
                vVar.g = gTCaptcha4Config.l();
                vVar.i = gTCaptcha4Config.n();
                vVar.j = gTCaptcha4Config.g();
                vVar.k = gTCaptcha4Config.i();
            }
            if (StringsKt.isBlank(vVar.b)) {
                vVar.b = "file:///android_asset/gt4-index.html";
            }
            return vVar;
        }
    }
}
