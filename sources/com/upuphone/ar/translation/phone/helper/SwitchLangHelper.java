package com.upuphone.ar.translation.phone.helper;

import android.content.Context;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.eventtrack.EventTrackingHelper;
import com.upuphone.ar.translation.eventtrack.event.ClickEvent;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.entity.StartTrans;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.listener.SwitchLangCallback;
import com.upuphone.ar.translation.statemachine.handler.XunFeiChannelHandler;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.upuphone.ar.translation.utils.LanguageUtils;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import com.upuphone.runasone.relay.api.IntentKey;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010%\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010 \u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b \u0010!JC\u0010$\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u001c2\b\b\u0002\u0010#\u001a\u00020\u001cH\u0002¢\u0006\u0004\b$\u0010%J7\u0010&\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001cH\u0002¢\u0006\u0004\b&\u0010'J/\u0010(\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010)J7\u0010+\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001cH\u0002¢\u0006\u0004\b+\u0010'J7\u0010,\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001cH\u0002¢\u0006\u0004\b,\u0010'J/\u0010-\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010)JC\u0010/\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u001c2\b\b\u0002\u0010.\u001a\u00020\u001cH\u0002¢\u0006\u0004\b/\u0010%J\u0019\u00100\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b0\u0010\u001bJ\u000f\u00101\u001a\u00020\u0010H\u0007¢\u0006\u0004\b1\u00102J/\u00104\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b4\u00105J/\u00106\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b6\u00105J1\u00107\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u001cH\u0002¢\u0006\u0004\b7\u00108J'\u00109\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010:J'\u0010;\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b;\u0010:J\u0017\u0010<\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b>\u0010=R\"\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010@R\u0016\u0010C\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010BR\u0016\u0010E\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010D¨\u0006F"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/SwitchLangHelper;", "", "<init>", "()V", "", "a", "", "key", "Lcom/upuphone/ar/translation/phone/listener/SwitchLangCallback;", "callback", "j", "(Ljava/lang/String;Lcom/upuphone/ar/translation/phone/listener/SwitchLangCallback;)V", "A", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "", "transType", "Lcom/upuphone/ar/translation/utils/LanguageUtils$StoredLanguage;", "oldLanguage", "n", "(Landroid/content/Context;ILcom/upuphone/ar/translation/utils/LanguageUtils$StoredLanguage;)I", "m", "(ILcom/upuphone/ar/translation/utils/LanguageUtils$StoredLanguage;)I", "i", "(Landroid/content/Context;)V", "z", "(I)I", "", "isOutSideAir", "src", "dst", "t", "(Landroid/content/Context;ZILjava/lang/String;Ljava/lang/String;)I", "isAir", "isAirPro", "y", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;ZZ)I", "u", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Z)I", "q", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)I", "isOldVersion", "r", "s", "x", "isTwoWay", "v", "p", "b", "()I", "isOutsideAir", "e", "(ZILjava/lang/String;Ljava/lang/String;)Z", "f", "g", "(ILjava/lang/String;Ljava/lang/String;Z)Z", "d", "(ILjava/lang/String;Ljava/lang/String;)Z", "c", "k", "(I)V", "l", "", "Ljava/util/Map;", "mLangCallbackMap", "Z", "mOppositeStartTrans", "I", "mOppositeTransType", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SwitchLangHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final SwitchLangHelper f6304a = new SwitchLangHelper();
    public static Map b = new LinkedHashMap();
    public static boolean c;
    public static int d;

    public static final void A(String str) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        b.remove(str);
    }

    public static final int b() {
        if (!TranslationApp.isServiceOn()) {
            LogExt.j("getTransCurrentState service not started", "SwitchLangHelper");
            return 0;
        }
        TranslateStateManager p = TranslationManager.q.a().p();
        if (p == null || !p.e()) {
            int m = PreferencesUtils.m();
            LogExt.j("getTransCurrentState transType=" + m, "SwitchLangHelper");
            return m == 1 ? 2 : 1;
        }
        LogExt.j("getTransCurrentState translation not started", "SwitchLangHelper");
        return 0;
    }

    public static final boolean e(boolean z, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        boolean isAir = TranslatorConstants.isAir();
        boolean isAirPro = TranslatorConstants.isAirPro();
        LogExt.j("isSupportLanguage glass[isAir=" + isAir + ", isAirPro=" + isAirPro + "]", "SwitchLangHelper");
        LogExt.j("isSupportLanguage transType=" + i + ", src=" + str + ", dst=" + str2, "SwitchLangHelper");
        return TranslatorConstants.isIntlVersion() ? h(f6304a, i, str, str2, false, 8, (Object) null) : isAirPro ? f6304a.g(i, str, str2, true) : f6304a.f(isAir, i, str, str2);
    }

    public static /* synthetic */ boolean h(SwitchLangHelper switchLangHelper, int i, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        return switchLangHelper.g(i, str, str2, z);
    }

    public static final void i(Context context) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!c || (i = d) == 0) {
            c = false;
            d = 0;
            return;
        }
        LogExt.g("notifyTranslationStop 启动指定类型的翻译=" + i, "SwitchLangHelper");
        f6304a.z(d);
        c = false;
        d = 0;
    }

    public static final void j(String str, SwitchLangCallback switchLangCallback) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(switchLangCallback, "callback");
        b.put(str, switchLangCallback);
    }

    public static final int n(Context context, int i, LanguageUtils.StoredLanguage storedLanguage) {
        Intrinsics.checkNotNullParameter(context, "context");
        LogExt.j("startTranslation transType=" + i, "SwitchLangHelper");
        if (i != 1 && i != 2 && i != 3) {
            return -1;
        }
        if (!TranslationApp.isServiceOn()) {
            LogExt.g("startTranslation 启动翻译服务以及眼镜端翻译", "SwitchLangHelper");
            PreferencesUtils.A(i);
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            TranslationApp.startService(applicationContext);
            return 1;
        }
        TranslationManager.Companion companion = TranslationManager.q;
        TranslateStateManager p = companion.a().p();
        if (p == null || !p.g()) {
            TranslateStateManager p2 = companion.a().p();
            if (p2 == null || !p2.e()) {
                int m = PreferencesUtils.m();
                if (i != m) {
                    LogExt.g("startTranslation 暂停当前翻译，启动指定类型的翻译", "SwitchLangHelper");
                    TranslateStateManager p3 = companion.a().p();
                    if (p3 != null) {
                        p3.y();
                    }
                    f6304a.l(m);
                    c = true;
                    d = i;
                    return 1;
                }
                LogExt.g("startTranslation 启动的是同类型的翻译=" + m + ", oldLanguage=" + storedLanguage, "SwitchLangHelper");
                if (storedLanguage == null) {
                    return 0;
                }
                return f6304a.m(i, storedLanguage);
            }
            LogExt.g("startTranslation 翻译未启动，启动指定类型的翻译=" + i, "SwitchLangHelper");
            return f6304a.z(i);
        }
        LogExt.g("startTranslation 当前状态处于准备态无法打断", "SwitchLangHelper");
        return 0;
    }

    public static /* synthetic */ int o(Context context, int i, LanguageUtils.StoredLanguage storedLanguage, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            storedLanguage = null;
        }
        return n(context, i, storedLanguage);
    }

    public static final int p(int i) {
        if (TranslationApp.isServiceOn()) {
            TranslationManager.Companion companion = TranslationManager.q;
            TranslateStateManager p = companion.a().p();
            if (p == null || !p.e()) {
                if (i != PreferencesUtils.m()) {
                    return i == 1 ? -2 : -1;
                }
                TranslateStateManager p2 = companion.a().p();
                if (p2 != null) {
                    p2.y();
                }
                f6304a.l(i);
                return 1;
            }
        }
        return i == 1 ? -2 : -1;
    }

    public static final int t(Context context, boolean z, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        boolean isAir = TranslatorConstants.isAir();
        boolean isAirPro = TranslatorConstants.isAirPro();
        LogExt.j("Switch lang glass isAir=" + isAir + ", isAriPro=" + isAirPro, "SwitchLangHelper");
        LogExt.j("Switch lang transType:" + i + ", src:" + str + ", dst:" + str2, "SwitchLangHelper");
        if (i != 1 && i != 2 && i != 3) {
            return -1;
        }
        if (!StringsKt.equals(str, "none", true) && !StringsKt.equals(str2, "none", true)) {
            return TranslatorConstants.isIntlVersion() ? f6304a.y(context, i, str, str2, isAir, isAirPro) : isAirPro ? f6304a.y(context, i, str, str2, isAir, true) : f6304a.u(context, i, str, str2, isAir);
        }
        LogExt.j("Switch lang no support language", "SwitchLangHelper");
        return i == 1 ? isAir ? -6 : -5 : (isAir || isAirPro) ? -4 : -3;
    }

    public static /* synthetic */ int w(SwitchLangHelper switchLangHelper, Context context, int i, String str, String str2, boolean z, boolean z2, int i2, Object obj) {
        return switchLangHelper.v(context, i, str, str2, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? false : z2);
    }

    public final void a() {
        b.clear();
    }

    public final boolean c(int i, String str, String str2) {
        List d2 = LanguageUtils.f6366a.d();
        if (!d2.contains(str) || !d2.contains(str2)) {
            LogExt.j("isAirSupportLanguage no support language", "SwitchLangHelper");
            return false;
        }
        boolean isAirOldLanguageVersion = TranslatorConstants.isAirOldLanguageVersion();
        LogExt.j("isAirSupportLanguage transType=" + i + ", isOldVersion=" + isAirOldLanguageVersion, "SwitchLangHelper");
        if (i == 1) {
            if (isAirOldLanguageVersion) {
                if ((!Intrinsics.areEqual((Object) str, (Object) "cn") && !Intrinsics.areEqual((Object) str, (Object) "cnen")) || !Intrinsics.areEqual((Object) str, (Object) str2)) {
                    return false;
                }
            } else if (!Intrinsics.areEqual((Object) str, (Object) str2) || Intrinsics.areEqual((Object) str, (Object) "ko")) {
                return false;
            }
        } else if (isAirOldLanguageVersion) {
            if ((!Intrinsics.areEqual((Object) str, (Object) "cn") || !Intrinsics.areEqual((Object) str2, (Object) "cnen")) && (!Intrinsics.areEqual((Object) str, (Object) "cnen") || !Intrinsics.areEqual((Object) str2, (Object) "cn"))) {
                return false;
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) str2)) {
            return false;
        } else {
            if ((!Intrinsics.areEqual((Object) str, (Object) "cn") || !d2.contains(str2)) && (!d2.contains(str) || !Intrinsics.areEqual((Object) str2, (Object) "cn"))) {
                return false;
            }
        }
        return true;
    }

    public final boolean d(int i, String str, String str2) {
        List d2 = LanguageUtils.f6366a.d();
        if (!d2.contains(str) || !d2.contains(str2)) {
            LogExt.j("isStarSupportLanguage no support language", "SwitchLangHelper");
            return false;
        } else if (i == 1) {
            return Intrinsics.areEqual((Object) str, (Object) str2);
        } else {
            if (!Intrinsics.areEqual((Object) str, (Object) str2)) {
                return (Intrinsics.areEqual((Object) str, (Object) "cn") && d2.contains(str2)) || (d2.contains(str) && Intrinsics.areEqual((Object) str2, (Object) "cn"));
            }
            return false;
        }
    }

    public final boolean f(boolean z, int i, String str, String str2) {
        return z ? c(i, str, str2) : d(i, str, str2);
    }

    public final boolean g(int i, String str, String str2, boolean z) {
        if (z && i == 1) {
            return false;
        }
        List d2 = LanguageUtils.f6366a.d();
        if (d2.contains(str) && d2.contains(str2)) {
            return i == 1 ? Intrinsics.areEqual((Object) str, (Object) str2) : !Intrinsics.areEqual((Object) str, (Object) str2);
        }
        LogExt.j("isSupportLanguage no support language", "SwitchLangHelper");
        return false;
    }

    public final void k(int i) {
        if (i == 2) {
            EventTrackingHelper.f6200a.b(new ClickEvent(14, 0, 2, (DefaultConstructorMarker) null));
        }
    }

    public final void l(int i) {
        if (i == 2) {
            EventTrackingHelper.f6200a.b(new ClickEvent(15, 0, 2, (DefaultConstructorMarker) null));
        }
    }

    public final int m(int i, LanguageUtils.StoredLanguage storedLanguage) {
        LanguageUtils.StoredLanguage g = LanguageUtils.g();
        String d2 = storedLanguage.d();
        String c2 = storedLanguage.c();
        String e = storedLanguage.e();
        String d3 = g.d();
        String c3 = g.c();
        String e2 = g.e();
        LogExt.g("startSameTypeTranslation transType=" + i + ", oldLang[" + d2 + ", " + c2 + ", " + e + "] ,lang[" + d3 + ", " + c3 + ", " + e2 + "]", "SwitchLangHelper");
        if (i == 1 && Intrinsics.areEqual((Object) e, (Object) e2)) {
            return 0;
        }
        if (i != 1 && Intrinsics.areEqual((Object) d2, (Object) d3) && Intrinsics.areEqual((Object) c2, (Object) c3)) {
            return 0;
        }
        LogExt.g("startSameTypeTranslation 暂停当前翻译，启动指定类型的翻译", "SwitchLangHelper");
        TranslateStateManager p = TranslationManager.q.a().p();
        if (p != null) {
            p.y();
        }
        l(i);
        c = true;
        d = i;
        return 1;
    }

    public final int q(Context context, int i, String str, String str2) {
        boolean isAirOldLanguageVersion = TranslatorConstants.isAirOldLanguageVersion();
        LogExt.g("switchAirLang transType=" + i + ", src=" + str + ", dst=" + str2 + ", isOldLanguageVersion=" + isAirOldLanguageVersion, "SwitchLangHelper");
        return i == 1 ? r(context, i, str, str2, isAirOldLanguageVersion) : s(context, i, str, str2, isAirOldLanguageVersion);
    }

    public final int r(Context context, int i, String str, String str2, boolean z) {
        if (z) {
            if ((Intrinsics.areEqual((Object) str, (Object) "cn") || Intrinsics.areEqual((Object) str, (Object) "cnen")) && Intrinsics.areEqual((Object) str, (Object) str2)) {
                return w(this, context, i, "cn", "cnen", true, false, 32, (Object) null);
            }
            return -6;
        } else if (!Intrinsics.areEqual((Object) str, (Object) str2) || !LanguageUtils.f6366a.d().contains(str)) {
            return -6;
        } else {
            if (Intrinsics.areEqual((Object) str, (Object) "cnen")) {
                str = "en";
            }
            String str3 = str;
            return w(this, context, i, str3, str3, true, false, 32, (Object) null);
        }
    }

    public final int s(Context context, int i, String str, String str2, boolean z) {
        if (!z) {
            List d2 = LanguageUtils.f6366a.d();
            if (Intrinsics.areEqual((Object) str, (Object) str2)) {
                return -4;
            }
            if ((!Intrinsics.areEqual((Object) str, (Object) "cn") || !d2.contains(str2)) && (!d2.contains(str) || !Intrinsics.areEqual((Object) str2, (Object) "cn"))) {
                return -4;
            }
            return w(this, context, i, str, str2, true, false, 32, (Object) null);
        } else if ((!Intrinsics.areEqual((Object) str, (Object) "cn") || !Intrinsics.areEqual((Object) str2, (Object) "cnen")) && (!Intrinsics.areEqual((Object) str, (Object) "cnen") || !Intrinsics.areEqual((Object) str2, (Object) "cn"))) {
            return -4;
        } else {
            return w(this, context, i, "cn", "cnen", true, false, 32, (Object) null);
        }
    }

    public final int u(Context context, int i, String str, String str2, boolean z) {
        return z ? q(context, i, str, str2) : x(context, i, str, str2);
    }

    public final int v(Context context, int i, String str, String str2, boolean z, boolean z2) {
        LanguageUtils.StoredLanguage g;
        XunFeiChannelHandler a2;
        int i2 = i;
        String str3 = str;
        String str4 = str2;
        boolean z3 = z;
        LogExt.j("switchLangPassed transType=" + i2 + ", src=" + str3 + ", dst=" + str4 + ", isAir=" + z3 + ", isTwoWay=" + z2, "SwitchLangHelper");
        if (!z3 || !TranslatorConstants.isAirOldLanguageVersion()) {
            g = LanguageUtils.g();
            for (Map.Entry entry : b.entrySet()) {
                String str5 = (String) entry.getKey();
                ((SwitchLangCallback) entry.getValue()).a(i2, str3, str4);
            }
            PreferencesUtils.p(i, str, str2);
        } else {
            LogExt.j("switchLangPassed old air glass", "SwitchLangHelper");
            g = null;
        }
        LanguageUtils.StoredLanguage storedLanguage = g;
        if (TranslationApp.isServiceOn()) {
            LogExt.j("switchLangPassed service started", "SwitchLangHelper");
            TranslateStateManager p = TranslationManager.q.a().p();
            if (!(p == null || (a2 = p.a()) == null)) {
                a2.H(new StartTrans(i, str, str2, false, 0, false, 0, 120, (DefaultConstructorMarker) null));
            }
            InterConnectHelper.c.a().B(i2, str3, str4);
        }
        return n(context, i2, storedLanguage);
    }

    public final int x(Context context, int i, String str, String str2) {
        List d2 = LanguageUtils.f6366a.d();
        LogExt.g("switchStarLang transType=" + i + ", src=" + str + ", dst=" + str2, "SwitchLangHelper");
        if (i == 1) {
            if (!Intrinsics.areEqual((Object) str, (Object) str2) || !d2.contains(str)) {
                return -5;
            }
            if (Intrinsics.areEqual((Object) str, (Object) "cnen")) {
                str = "en";
            }
            String str3 = str;
            return w(this, context, i, str3, str3, false, false, 48, (Object) null);
        } else if (Intrinsics.areEqual((Object) str, (Object) str2) || ((!Intrinsics.areEqual((Object) str, (Object) "cn") || !d2.contains(str2)) && (!d2.contains(str) || !Intrinsics.areEqual((Object) str2, (Object) "cn")))) {
            return -3;
        } else {
            return w(this, context, i, str, str2, false, false, 48, (Object) null);
        }
    }

    public final int y(Context context, int i, String str, String str2, boolean z, boolean z2) {
        if (z2 && i == 1) {
            return -1;
        }
        List d2 = LanguageUtils.f6366a.d();
        LogExt.g("switchTwoWayLang transType=" + i + ", src=" + str + ", dst=" + str2, "SwitchLangHelper");
        return i == 1 ? (!Intrinsics.areEqual((Object) str, (Object) str2) || !d2.contains(str)) ? z ? -6 : -5 : v(context, i, str, str2, false, true) : (Intrinsics.areEqual((Object) str, (Object) str2) || !d2.contains(str) || !d2.contains(str2)) ? (z || z2) ? -4 : -3 : v(context, i, str, str2, false, true);
    }

    public final int z(int i) {
        String str;
        String str2;
        String str3 = i == 1 ? "转写" : "翻译";
        LogExt.j("toStartTranslation 启动" + str3, "SwitchLangHelper");
        PreferencesUtils.A(i);
        LanguageUtils.StoredLanguage g = LanguageUtils.g();
        if (i == 1) {
            str = g.e();
            str2 = g.e();
        } else {
            str = g.d();
            str2 = g.c();
        }
        if (TranslatorConstants.isAirOldLanguage()) {
            str = "cn";
            str2 = "cnen";
        }
        InterConnectHelper.c.a().z(i, str, str2);
        TranslateStateManager p = TranslationManager.q.a().p();
        if (p != null) {
            p.y();
        }
        k(i);
        return 1;
    }
}
