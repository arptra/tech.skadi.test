package com.upuphone.ar.transcribe.phone.helper;

import android.content.Context;
import com.upuphone.ar.transcribe.TranscribeApp;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.interconnect.entity.StartTrans;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import com.upuphone.ar.transcribe.phone.listener.SwitchLangCallback;
import com.upuphone.ar.transcribe.statemachine.handler.XunFeiChannelHandler;
import com.upuphone.ar.transcribe.utils.LanguageUtils;
import com.upuphone.ar.transcribe.utils.PreferencesUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010!\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\u0003J#\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\u001bJ/\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010\u0017J/\u0010#\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002¢\u0006\u0004\b#\u0010\u0017J'\u0010$\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002¢\u0006\u0004\b$\u0010%J/\u0010'\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0011H\u0002¢\u0006\u0004\b'\u0010(J'\u0010)\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002¢\u0006\u0004\b)\u0010%J;\u0010+\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010*\u001a\u00020\u0011H\u0002¢\u0006\u0004\b+\u0010,J'\u0010-\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002¢\u0006\u0004\b-\u0010\u001dJ\u001f\u0010.\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002¢\u0006\u0004\b0\u0010/J\u001f\u00101\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002¢\u0006\u0004\b1\u0010/J)\u00104\u001a\b\u0012\u0004\u0012\u00020\u0013032\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u00102\u001a\u00020\u0011H\u0002¢\u0006\u0004\b4\u00105J\u0015\u00106\u001a\b\u0012\u0004\u0012\u00020\u001303H\u0002¢\u0006\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00108R\"\u0010@\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010A¨\u0006C"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/SwitchLangHelper;", "", "<init>", "()V", "Lcom/upuphone/ar/transcribe/phone/listener/SwitchLangCallback;", "callback", "", "k", "(Lcom/upuphone/ar/transcribe/phone/listener/SwitchLangCallback;)V", "z", "Landroid/content/Context;", "context", "Lcom/upuphone/ar/transcribe/utils/LanguageUtils$StoredLanguage;", "oldLanguage", "", "n", "(Landroid/content/Context;Lcom/upuphone/ar/transcribe/utils/LanguageUtils$StoredLanguage;)I", "", "isAir", "", "src", "dst", "s", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)I", "p", "()I", "e", "(Landroid/content/Context;)I", "h", "(ZLjava/lang/String;Ljava/lang/String;)Z", "transType", "m", "(Landroid/content/Context;ILcom/upuphone/ar/transcribe/utils/LanguageUtils$StoredLanguage;)I", "y", "t", "u", "q", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I", "isOldVersion", "r", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)I", "x", "isIntl", "v", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZ)I", "j", "i", "(Ljava/lang/String;Ljava/lang/String;)Z", "g", "f", "isNoCn", "", "b", "(ZZ)Ljava/util/List;", "a", "()Ljava/util/List;", "Lcom/upuphone/ar/transcribe/phone/listener/SwitchLangCallback;", "mSwitchLangCallback", "c", "Z", "d", "()Z", "l", "(Z)V", "mOppositeStartTrans", "I", "mOppositeTransType", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SwitchLangHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final SwitchLangHelper f6106a = new SwitchLangHelper();
    public static SwitchLangCallback b;
    public static boolean c;
    public static int d;

    public static /* synthetic */ List c(SwitchLangHelper switchLangHelper, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return switchLangHelper.b(z, z2);
    }

    public static final int e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!TranscribeApp.isServiceOn()) {
            LogExt.g("getTransCurrentState service not started", "SwitchLangHelper");
            return 0;
        } else if (!TranscribeManager.j.a().h().i()) {
            return 2;
        } else {
            LogExt.g("getTransCurrentState translation not started", "SwitchLangHelper");
            return 0;
        }
    }

    public static final boolean h(boolean z, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        LogExt.g("isSupportLanguage isAir=" + z + ", src=" + str + ", dst=" + str2, "SwitchLangHelper");
        return TranscribeConstants.f6027a.m() ? f6106a.i(str, str2) : f6106a.j(z, str, str2);
    }

    public static final void k(SwitchLangCallback switchLangCallback) {
        Intrinsics.checkNotNullParameter(switchLangCallback, "callback");
        b = switchLangCallback;
    }

    public static final int n(Context context, LanguageUtils.StoredLanguage storedLanguage) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!TranscribeApp.isServiceOn()) {
            LogExt.d("startTranslation 启动翻译服务以及眼镜端翻译", "SwitchLangHelper");
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            TranscribeApp.startService(applicationContext);
            return 1;
        }
        TranscribeManager.Companion companion = TranscribeManager.j;
        if (companion.a().h().k()) {
            LogExt.d("startTranslation 当前状态处于准备态无法打断", "SwitchLangHelper");
            return 0;
        } else if (!companion.a().h().i()) {
            LogExt.d("startTranslation oldLanguage=" + storedLanguage, "SwitchLangHelper");
            if (storedLanguage == null) {
                return 0;
            }
            return f6106a.m(context, 1, storedLanguage);
        } else {
            LogExt.d("startTranslation 转写未启动，启动转写", "SwitchLangHelper");
            return f6106a.y(context);
        }
    }

    public static /* synthetic */ int o(Context context, LanguageUtils.StoredLanguage storedLanguage, int i, Object obj) {
        if ((i & 2) != 0) {
            storedLanguage = null;
        }
        return n(context, storedLanguage);
    }

    public static final int p() {
        if (TranscribeApp.isServiceOn()) {
            TranscribeManager.Companion companion = TranscribeManager.j;
            if (!companion.a().h().i()) {
                companion.a().h().E();
                return 1;
            }
        }
        return -2;
    }

    public static final int s(Context context, boolean z, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        LogExt.g("Switch lang isAir:" + z + "， transType:TRANSCRIBE, src:" + str + ", dst:" + str2, "SwitchLangHelper");
        if (!StringsKt.equals(str, "none", true) && !StringsKt.equals(str2, "none", true)) {
            return TranscribeConstants.f6027a.m() ? f6106a.t(context, z, str, str2) : f6106a.u(context, z, str, str2);
        }
        LogExt.g("Switch lang no support language", "SwitchLangHelper");
        return z ? -6 : -5;
    }

    public static /* synthetic */ int w(SwitchLangHelper switchLangHelper, Context context, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        return switchLangHelper.v(context, str, str2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
    }

    public static final void z() {
        b = null;
    }

    public final List a() {
        return CollectionsKt.arrayListOf("cn", "cnen", "ms", "ja", "ru", "fr", "es", "vi", "th", "id");
    }

    public final List b(boolean z, boolean z2) {
        return z ? z2 ? CollectionsKt.arrayListOf("cnen", "ja", "fr", "ru", "es", "vi") : CollectionsKt.arrayListOf("cn", "cnen", "ja", "fr", "ru", "es", "vi") : z2 ? CollectionsKt.arrayListOf("cnen", "ja", "fr", "ko", "ru", "es", "vi") : CollectionsKt.arrayListOf("cn", "cnen", "ja", "fr", "ko", "ru", "es", "vi");
    }

    public final boolean d() {
        return c;
    }

    public final boolean f(String str, String str2) {
        if (!c(this, true, false, 2, (Object) null).contains(str) || !c(this, true, false, 2, (Object) null).contains(str2)) {
            LogExt.g("isAirSupportLanguage no support language", "SwitchLangHelper");
            return false;
        }
        boolean i = TranscribeConstants.f6027a.i();
        LogExt.g("isAirSupportLanguage isOldVersion=" + i, "SwitchLangHelper");
        if (i) {
            if ((Intrinsics.areEqual((Object) str, (Object) "cn") || Intrinsics.areEqual((Object) str, (Object) "cnen")) && Intrinsics.areEqual((Object) str, (Object) str2)) {
                return true;
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) str2) && !Intrinsics.areEqual((Object) str, (Object) "ko")) {
            return true;
        }
        return false;
    }

    public final boolean g(String str, String str2) {
        if (c(this, false, false, 3, (Object) null).contains(str) && c(this, false, false, 3, (Object) null).contains(str2)) {
            return Intrinsics.areEqual((Object) str, (Object) str2);
        }
        LogExt.g("isStarSupportLanguage no support language", "SwitchLangHelper");
        return false;
    }

    public final boolean i(String str, String str2) {
        if (a().contains(str) && a().contains(str2)) {
            return Intrinsics.areEqual((Object) str, (Object) str2);
        }
        LogExt.g("isSupportLanguage no support language", "SwitchLangHelper");
        return false;
    }

    public final boolean j(boolean z, String str, String str2) {
        return z ? f(str, str2) : g(str, str2);
    }

    public final void l(boolean z) {
        c = z;
    }

    public final int m(Context context, int i, LanguageUtils.StoredLanguage storedLanguage) {
        LanguageUtils.StoredLanguage c2 = LanguageUtils.c(context, false, false, 6, (Object) null);
        String a2 = storedLanguage.a();
        String a3 = c2.a();
        LogExt.d("transcribe oldLang[" + a2 + "],lang[" + a3 + "]", "SwitchLangHelper");
        if (i == 1 && Intrinsics.areEqual((Object) a2, (Object) a3)) {
            return 0;
        }
        LogExt.d("startSameTypeTranslation 暂停当前翻译，启动指定类型的翻译", "SwitchLangHelper");
        TranscribeManager.j.a().h().E();
        c = true;
        d = i;
        return 1;
    }

    public final int q(Context context, String str, String str2) {
        boolean i = TranscribeConstants.f6027a.i();
        LogExt.d("switchAirLang src=" + str + ", dst=" + str2 + ", isOldLanguageVersion=" + i, "SwitchLangHelper");
        return r(context, str, str2, i);
    }

    public final int r(Context context, String str, String str2, boolean z) {
        if (z) {
            if ((Intrinsics.areEqual((Object) str, (Object) "cn") || Intrinsics.areEqual((Object) str, (Object) "cnen")) && Intrinsics.areEqual((Object) str, (Object) str2)) {
                return w(this, context, "cn", "cnen", true, false, 16, (Object) null);
            }
            return -6;
        } else if (!Intrinsics.areEqual((Object) str, (Object) str2) || !c(this, true, false, 2, (Object) null).contains(str)) {
            return -6;
        } else {
            if (Intrinsics.areEqual((Object) str, (Object) "cnen")) {
                str = "en";
            }
            String str3 = str;
            return w(this, context, str3, str3, true, false, 16, (Object) null);
        }
    }

    public final int t(Context context, boolean z, String str, String str2) {
        LogExt.d("switchLangIntl  src=" + str + ", dst=" + str2, "SwitchLangHelper");
        return (!Intrinsics.areEqual((Object) str, (Object) str2) || !a().contains(str)) ? z ? -6 : -5 : v(context, str, str2, false, true);
    }

    public final int u(Context context, boolean z, String str, String str2) {
        return z ? q(context, str, str2) : x(context, str, str2);
    }

    public final int v(Context context, String str, String str2, boolean z, boolean z2) {
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        boolean z3 = z;
        boolean z4 = z2;
        LogExt.g("switchLangPassed TRANSCRIBE, src=" + str3 + ", dst=" + str4 + ", isAir=" + z3 + ", isIntl=" + z4, "SwitchLangHelper");
        LanguageUtils.StoredLanguage b2 = LanguageUtils.b(context2, z3, z4);
        SwitchLangCallback switchLangCallback = b;
        if (switchLangCallback != null) {
            switchLangCallback.a(1, str3, str4);
        }
        PreferencesUtils.n(context2, str3, z3, z4);
        if (TranscribeApp.isServiceOn()) {
            LogExt.g("switchLangPassed service started", "SwitchLangHelper");
            XunFeiChannelHandler d2 = TranscribeManager.j.a().h().d();
            StartTrans startTrans = r1;
            StartTrans startTrans2 = new StartTrans(1, str, str2, false, 0, false, false, 120, (DefaultConstructorMarker) null);
            d2.t(startTrans);
            InterConnectHelper.c.a().A(1, str3, str4);
        }
        return n(context2, b2);
    }

    public final int x(Context context, String str, String str2) {
        LogExt.d("switchStarLang src=" + str + ", dst=" + str2, "SwitchLangHelper");
        if (!Intrinsics.areEqual((Object) str, (Object) str2) || !c(this, false, false, 3, (Object) null).contains(str)) {
            return -5;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "cnen")) {
            str = "en";
        }
        String str3 = str;
        return w(this, context, str3, str3, false, false, 24, (Object) null);
    }

    public final int y(Context context) {
        LogExt.g("toStartTranslation 启动转写", "SwitchLangHelper");
        LanguageUtils.StoredLanguage c2 = LanguageUtils.c(context, false, false, 6, (Object) null);
        String a2 = c2.a();
        String a3 = c2.a();
        if (TranscribeConstants.f6027a.h()) {
            a2 = "cn";
            a3 = "cnen";
        }
        InterConnectHelper.c.a().z(1, a2, a3);
        TranscribeManager.j.a().h().E();
        return 1;
    }
}
