package com.upuphone.xr.sapp.contract;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Consumer;
import com.honey.account.e8.d;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.contract.RegionsEntry;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ \u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H@¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u0003J3\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u001c\b\u0002\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0016¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0012¢\u0006\u0004\b#\u0010 J\r\u0010$\u001a\u00020\u0012¢\u0006\u0004\b$\u0010 J\r\u0010%\u001a\u00020\u0012¢\u0006\u0004\b%\u0010 J\r\u0010&\u001a\u00020\u0016¢\u0006\u0004\b&\u0010\"J\r\u0010'\u001a\u00020\u000b¢\u0006\u0004\b'\u0010\u0003J\r\u0010(\u001a\u00020\u000b¢\u0006\u0004\b(\u0010\u0003J\r\u0010)\u001a\u00020\u0016¢\u0006\u0004\b)\u0010\"J\r\u0010*\u001a\u00020\u0012¢\u0006\u0004\b*\u0010 J\r\u0010+\u001a\u00020\u0012¢\u0006\u0004\b+\u0010 J\r\u0010,\u001a\u00020\u0016¢\u0006\u0004\b,\u0010\"J\r\u0010-\u001a\u00020\u0012¢\u0006\u0004\b-\u0010 J\u000f\u0010.\u001a\u00020\u0016H\u0002¢\u0006\u0004\b.\u0010\"J\u000f\u0010/\u001a\u00020\u0016H\u0002¢\u0006\u0004\b/\u0010\"R\u0014\u00102\u001a\u00020\u00128\u0002XD¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u00104¨\u00066"}, d2 = {"Lcom/upuphone/xr/sapp/contract/ContractEntry;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "", "category", "Landroidx/core/util/Consumer;", "Lcom/upuphone/xr/sapp/contract/UserGuideAuthResult;", "consumer", "", "x", "(Landroid/app/Activity;ILandroidx/core/util/Consumer;)V", "z", "(Landroid/app/Activity;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/contract/ProtocolType;", "protocolType", "", "title", "v", "(Landroid/app/Activity;Lcom/upuphone/xr/sapp/contract/ProtocolType;Ljava/lang/String;)V", "", "isOver18Years", "s", "(Landroid/app/Activity;Lcom/upuphone/xr/sapp/contract/ProtocolType;Ljava/lang/String;Z)V", "p", "Lkotlin/Function2;", "callback", "c", "(Lcom/upuphone/xr/sapp/contract/ProtocolType;Lkotlin/jvm/functions/Function2;)V", "i", "()Ljava/lang/String;", "n", "()Z", "j", "e", "d", "u", "q", "r", "o", "g", "f", "m", "h", "l", "k", "b", "Ljava/lang/String;", "TAG", "Lcom/upuphone/xr/sapp/contract/ProtocolManager;", "Lcom/upuphone/xr/sapp/contract/ProtocolManager;", "mProtocolManager", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nContractEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContractEntry.kt\ncom/upuphone/xr/sapp/contract/ContractEntry\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,397:1\n314#2,11:398\n1#3:409\n*S KotlinDebug\n*F\n+ 1 ContractEntry.kt\ncom/upuphone/xr/sapp/contract/ContractEntry\n*L\n84#1:398,11\n*E\n"})
public final class ContractEntry {

    /* renamed from: a  reason: collision with root package name */
    public static final ContractEntry f6691a = new ContractEntry();
    public static final String b = "ContractEntry";
    public static final ProtocolManager c = new ProtocolManager();

    public static /* synthetic */ void t(ContractEntry contractEntry, Activity activity, ProtocolType protocolType, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        contractEntry.s(activity, protocolType, str, z);
    }

    public static /* synthetic */ void w(ContractEntry contractEntry, Activity activity, ProtocolType protocolType, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        contractEntry.v(activity, protocolType, str);
    }

    public static final void y(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$func");
        function0.invoke();
    }

    public final void c(ProtocolType protocolType, Function2 function2) {
        Intrinsics.checkNotNullParameter(protocolType, "protocolType");
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (!bool.booleanValue()) {
            c.a(protocolType, new ContractEntry$checkPolicyUpgrade$1(function2));
        } else if (function2 != null) {
            function2.invoke(Boolean.FALSE, "if current is intl upgrade not show.");
        }
    }

    public final String d() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (!bool.booleanValue()) {
            return GlobalExtKt.h(R.string.about_cancel_agree_content);
        }
        String i = i();
        boolean z = true;
        if (!(Intrinsics.areEqual((Object) i, (Object) RegionsEntry.RegionsSA.TH_TH.getRegion()) ? true : Intrinsics.areEqual((Object) i, (Object) RegionsEntry.RegionsSA.ID_ID.getRegion()))) {
            z = Intrinsics.areEqual((Object) i, (Object) RegionsEntry.RegionsSA.FIL_PH.getRegion());
        }
        return z ? GlobalExtKt.h(R.string.myvu_cancel_region_agree_privacy_normal) : GlobalExtKt.h(R.string.about_cancel_agree_content);
    }

    public final String e() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (!bool.booleanValue()) {
            return GlobalExtKt.h(R.string.agree);
        }
        String i = i();
        boolean z = true;
        if (!(Intrinsics.areEqual((Object) i, (Object) RegionsEntry.RegionsSA.TH_TH.getRegion()) ? true : Intrinsics.areEqual((Object) i, (Object) RegionsEntry.RegionsSA.ID_ID.getRegion()))) {
            z = Intrinsics.areEqual((Object) i, (Object) RegionsEntry.RegionsSA.FIL_PH.getRegion());
        }
        return z ? GlobalExtKt.h(R.string.touchpad_gesture_confirm) : GlobalExtKt.h(R.string.agree);
    }

    public final String f() {
        String language = Locale.getDefault().getLanguage();
        Iterator<E> it = EnumSet.allOf(RegionsEntry.RegionsEA.class).iterator();
        while (it.hasNext()) {
            RegionsEntry.RegionsEA regionsEA = (RegionsEntry.RegionsEA) it.next();
            if (StringsKt.equals(regionsEA.getRegion(), language, true)) {
                return regionsEA.value();
            }
        }
        return RegionsEntry.RegionsEA.EN_US.value();
    }

    public final String g() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        Iterator<E> it = EnumSet.allOf(RegionsEntry.RegionsEU.class).iterator();
        while (it.hasNext()) {
            RegionsEntry.RegionsEU regionsEU = (RegionsEntry.RegionsEU) it.next();
            if (StringsKt.equals(regionsEU.getLanguage(), language, true) && StringsKt.equals(regionsEU.getRegion(), country, true)) {
                return regionsEU.value();
            }
            if (StringsKt.equals(regionsEU.getLanguage(), language, true)) {
                RegionsEntry.RegionsEU regionsEU2 = RegionsEntry.RegionsEU.DE_DE;
                if (Intrinsics.areEqual((Object) language, (Object) regionsEU2.getLanguage())) {
                    return regionsEU2.value();
                }
                RegionsEntry.RegionsEU regionsEU3 = RegionsEntry.RegionsEU.FR_FR;
                if (Intrinsics.areEqual((Object) language, (Object) regionsEU3.getLanguage())) {
                    return regionsEU3.value();
                }
                RegionsEntry.RegionsEU regionsEU4 = RegionsEntry.RegionsEU.EL_GR;
                if (Intrinsics.areEqual((Object) language, (Object) regionsEU4.getLanguage())) {
                    return regionsEU4.value();
                }
                RegionsEntry.RegionsEU regionsEU5 = RegionsEntry.RegionsEU.EN_IE;
                return Intrinsics.areEqual((Object) language, (Object) regionsEU5.getLanguage()) ? regionsEU5.value() : regionsEU.value();
            }
        }
        return RegionsEntry.RegionsEA.EN_US.value();
    }

    public final String h() {
        return l() ? g() : k() ? f() : RegionsEntry.RegionsEA.EN_US.value();
    }

    public final String i() {
        return c.B();
    }

    public final String j() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (!bool.booleanValue()) {
            return GlobalExtKt.h(R.string.permission_tips_content_third);
        }
        String i = i();
        boolean z = true;
        if (!(Intrinsics.areEqual((Object) i, (Object) RegionsEntry.RegionsSA.TH_TH.getRegion()) ? true : Intrinsics.areEqual((Object) i, (Object) RegionsEntry.RegionsSA.ID_ID.getRegion()))) {
            z = Intrinsics.areEqual((Object) i, (Object) RegionsEntry.RegionsSA.FIL_PH.getRegion());
        }
        return z ? GlobalExtKt.h(R.string.myvu_region_privacy_normal) : GlobalExtKt.h(R.string.permission_tips_content_third_oversea);
    }

    public final boolean k() {
        String language = Locale.getDefault().getLanguage();
        Iterator<E> it = EnumSet.allOf(RegionsEntry.RegionsEA.class).iterator();
        while (it.hasNext()) {
            if (StringsKt.equals(((RegionsEntry.RegionsEA) it.next()).getRegion(), language, true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean l() {
        String language = Locale.getDefault().getLanguage();
        Iterator<E> it = EnumSet.allOf(RegionsEntry.RegionsEU.class).iterator();
        while (it.hasNext()) {
            if (StringsKt.equals(((RegionsEntry.RegionsEU) it.next()).getLanguage(), language, true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean m() {
        if (!BuildConfig.f6575a.booleanValue()) {
            return false;
        }
        return l() || k();
    }

    public final boolean n() {
        return c.J();
    }

    public final boolean o() {
        if (!BuildConfig.f6575a.booleanValue()) {
            return false;
        }
        return Intrinsics.areEqual((Object) i(), (Object) RegionsEntry.RegionsOS.MS_MY.getRegion());
    }

    public final void p() {
        c.H();
    }

    public final void q() {
        boolean z = !u();
        ULog.f6446a.a("ContractEntry", "[resetAgreeStatus] status->" + z);
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        companion.a().o("privacy_argreement_key_ai_asst", Boolean.valueOf(z));
        companion.a().o("privacy_argreement_key_ar_navi", Boolean.valueOf(z));
        companion.a().o("privacy_argreement_key_ar_tran", Boolean.valueOf(z));
        companion.a().o("privacy_argreement_key_ar_tici", Boolean.valueOf(z));
        SuperMessageManger.m.a().m0();
    }

    public final void r() {
        if (!n()) {
            boolean z = !u();
            ULog.f6446a.a("ContractEntry", "[resetAgreeStatus] status->" + z);
            DataStoreUtils.Companion companion = DataStoreUtils.e;
            companion.a().o("privacy_argreement_key_ai_asst", Boolean.valueOf(z));
            companion.a().o("privacy_argreement_key_ar_navi", Boolean.valueOf(z));
            companion.a().o("privacy_argreement_key_ar_tran", Boolean.valueOf(z));
            companion.a().o("privacy_argreement_key_ar_tici", Boolean.valueOf(z));
        } else {
            ULog.f6446a.a("ContractEntry", "[resetAgreeStatus] do nothing");
        }
        DataStoreUtils.e.a().o("privacy_argreement_latest_region_key", i());
        SuperMessageManger.m.a().m0();
    }

    public final void s(Activity activity, ProtocolType protocolType, String str, boolean z) {
        String str2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(protocolType, "protocolType");
        Intrinsics.checkNotNullParameter(str, "title");
        Intent intent = new Intent(activity, ProtocolActivity.class);
        String I = c.I(protocolType);
        if (z) {
            str2 = I + "#10. 미성년자 보호";
        } else {
            str2 = I + "#5. 개인정보 국외 이전에 관한 사항";
        }
        ULog.f6446a.a(b, "showProtocol url is: " + str2);
        Bundle bundle = new Bundle();
        if (str.length() == 0) {
            str = GlobalExtKt.h(protocolType.getTitleRes());
        }
        bundle.putString("title", str);
        bundle.putString("url", str2);
        intent.putExtra("data", bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.next_open_enter, R.anim.next_open_exit);
    }

    public final boolean u() {
        if (!BuildConfig.f6575a.booleanValue()) {
            return false;
        }
        ULog.Delegate delegate = ULog.f6446a;
        String i = i();
        delegate.a("ContractEntry", " showModeAgree region is:" + i);
        String i2 = i();
        if (Intrinsics.areEqual((Object) i2, (Object) RegionsEntry.RegionsSA.TH_TH.getRegion()) ? true : Intrinsics.areEqual((Object) i2, (Object) RegionsEntry.RegionsSA.ID_ID.getRegion())) {
            return true;
        }
        return Intrinsics.areEqual((Object) i2, (Object) RegionsEntry.RegionsSA.FIL_PH.getRegion());
    }

    public final void v(Activity activity, ProtocolType protocolType, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(protocolType, "protocolType");
        Intrinsics.checkNotNullParameter(str, "title");
        Intent intent = new Intent(activity, ProtocolActivity.class);
        String I = c.I(protocolType);
        ULog.Delegate delegate = ULog.f6446a;
        String str2 = b;
        delegate.a(str2, "showProtocol url is: " + I);
        Bundle bundle = new Bundle();
        if (str.length() == 0) {
            str = GlobalExtKt.h(protocolType.getTitleRes());
        }
        bundle.putString("title", str);
        bundle.putString("url", I);
        intent.putExtra("data", bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.next_open_enter, R.anim.next_open_exit);
    }

    public final void x(Activity activity, int i, Consumer consumer) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ContractEntry$showUserGuide$func$1 contractEntry$showUserGuide$func$1 = new ContractEntry$showUserGuide$func$1(i, activity, consumer);
        if (Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
            contractEntry$showUserGuide$func$1.invoke();
        } else {
            new Handler(Looper.getMainLooper()).post(new d(contractEntry$showUserGuide$func$1));
        }
    }

    public final Object z(Activity activity, int i, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        f6691a.x(activity, i, new ContractEntry$waitUserGuideResult$2$1(cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }
}
