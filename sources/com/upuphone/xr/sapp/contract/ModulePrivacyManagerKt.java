package com.upuphone.xr.sapp.contract;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.tips.TipsKey;
import com.upuphone.xr.sapp.tips.TipsKeyKt;
import com.upuphone.xr.sapp.tips.TipsManager;
import com.upuphone.xr.sapp.tips.TipsManagerKt;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import com.xjmz.myvu.dialog.NormalProtocolDialog;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.apache.commons.lang3.BooleanUtils;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a/\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\t\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\b\u001a1\u0010\r\u001a\u00020\f2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000e\u001a1\u0010\u000f\u001a\u00020\f2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010\u001a1\u0010\u0011\u001a\u00020\f2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0010\u001a\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0013\u001a\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001d\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001d\"\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 \"\u0018\u0010\"\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010 ¨\u0006#"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "rootActivity", "", "modlueId", "Lkotlin/Function0;", "", "callback", "h", "(Landroidx/fragment/app/FragmentActivity;ILkotlin/jvm/functions/Function0;)V", "g", "", "name", "", "k", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Z", "i", "(Landroidx/fragment/app/FragmentActivity;ILkotlin/jvm/functions/Function0;)Z", "m", "b", "(I)Ljava/lang/String;", "c", "d", "(Ljava/lang/String;)I", "e", "(I)Z", "module", "f", "(I)V", "n", "(Landroidx/fragment/app/FragmentActivity;I)V", "Lcom/xjmz/myvu/dialog/NormalProtocolDialog;", "a", "Lcom/xjmz/myvu/dialog/NormalProtocolDialog;", "agreeDialog", "cancelAgreeDialog", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class ModulePrivacyManagerKt {

    /* renamed from: a  reason: collision with root package name */
    public static NormalProtocolDialog f6694a;
    public static NormalProtocolDialog b;

    public static final String b(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? GlobalExtKt.h(R.string.myvu_region_privacy_normal) : GlobalExtKt.h(R.string.myvu_region_privacy_asst) : GlobalExtKt.h(R.string.myvu_region_privacy_tici) : GlobalExtKt.h(R.string.myvu_region_privacy_tran) : GlobalExtKt.h(R.string.myvu_region_privacy_navi);
    }

    public static final String c(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : GlobalExtKt.h(R.string.myvu_cancel_agree_privacy_asst) : GlobalExtKt.h(R.string.myvu_cancel_agree_privacy_tici) : GlobalExtKt.h(R.string.myvu_cancel_agree_privacy_tran) : GlobalExtKt.h(R.string.myvu_cancel_agree_privacy_navi);
    }

    public static final int d(String str) {
        switch (str.hashCode()) {
            case -1721943526:
                return !str.equals("translator") ? -1 : 2;
            case 3559835:
                return !str.equals("tici") ? -1 : 3;
            case 1375005013:
                return !str.equals("assistants") ? -1 : 4;
            case 1862666772:
                return !str.equals(VuiModelType.NAVIGATION) ? -1 : 1;
            default:
                return -1;
        }
    }

    public static final boolean e(int i) {
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        DataStoreUtils a2 = companion.a();
        Boolean bool = Boolean.FALSE;
        boolean booleanValue = ((Boolean) DataStoreUtils.i(a2, "privacy_argreement_key_ai_asst", bool, (Context) null, 4, (Object) null)).booleanValue();
        Boolean bool2 = bool;
        boolean booleanValue2 = ((Boolean) DataStoreUtils.i(companion.a(), "privacy_argreement_key_ar_navi", bool2, (Context) null, 4, (Object) null)).booleanValue();
        boolean booleanValue3 = ((Boolean) DataStoreUtils.i(companion.a(), "privacy_argreement_key_ar_tran", bool2, (Context) null, 4, (Object) null)).booleanValue();
        boolean booleanValue4 = ((Boolean) DataStoreUtils.i(companion.a(), "privacy_argreement_key_ar_tici", bool2, (Context) null, 4, (Object) null)).booleanValue();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ModulePrivacyManager", "isModuleAgree, modlueId：" + i + "  aiAsst:" + booleanValue + " AR_NAVI:" + booleanValue2 + " AR_TRAN:" + booleanValue3 + " AR_TICI:" + booleanValue4);
        if (i == 1) {
            return ((Boolean) DataStoreUtils.i(companion.a(), "privacy_argreement_key_ar_navi", bool, (Context) null, 4, (Object) null)).booleanValue();
        }
        if (i == 2) {
            return ((Boolean) DataStoreUtils.i(companion.a(), "privacy_argreement_key_ar_tran", bool, (Context) null, 4, (Object) null)).booleanValue();
        }
        if (i == 3) {
            return ((Boolean) DataStoreUtils.i(companion.a(), "privacy_argreement_key_ar_tici", bool, (Context) null, 4, (Object) null)).booleanValue();
        }
        if (i != 4) {
            return true;
        }
        return ((Boolean) DataStoreUtils.i(companion.a(), "privacy_argreement_key_ai_asst", bool, (Context) null, 4, (Object) null)).booleanValue();
    }

    public static final void f(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ModulePrivacyManager", "setModulePrivacyStatus,  module is:" + i);
        if (i == 1) {
            DataStoreUtils.e.a().o("privacy_argreement_key_ar_navi", Boolean.TRUE);
        } else if (i == 2) {
            DataStoreUtils.e.a().o("privacy_argreement_key_ar_tran", Boolean.TRUE);
        } else if (i == 3) {
            DataStoreUtils.e.a().o("privacy_argreement_key_ar_tici", Boolean.TRUE);
        } else if (i == 4) {
            DataStoreUtils.e.a().o("privacy_argreement_key_ai_asst", Boolean.TRUE);
        }
        SuperMessageManger.m.a().m0();
    }

    public static final void g(FragmentActivity fragmentActivity, int i, Function0 function0) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "rootActivity");
        NormalProtocolDialog normalProtocolDialog = b;
        if (normalProtocolDialog != null) {
            normalProtocolDialog.dismiss();
        }
        NormalProtocolDialog.Companion companion = NormalProtocolDialog.m;
        String string = fragmentActivity.getString(R.string.about_cancel_agree_confirm);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String c = c(i);
        String string2 = fragmentActivity.getString(R.string.permission_refuse);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = fragmentActivity.getString(R.string.about_cancel_agree_confirm);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        b = NormalProtocolDialog.Companion.b(companion, fragmentActivity, string, c, string2, string3, fragmentActivity.getString(R.string.about_cancel_agree_confirm), false, (Function0) null, new ModulePrivacyManagerKt$showModuleCancelPrivacyDialog$1(function0), 192, (Object) null);
    }

    public static final void h(FragmentActivity fragmentActivity, int i, Function0 function0) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "rootActivity");
        NormalProtocolDialog normalProtocolDialog = f6694a;
        if (normalProtocolDialog != null) {
            normalProtocolDialog.dismiss();
        }
        NormalProtocolDialog.Companion companion = NormalProtocolDialog.m;
        String string = fragmentActivity.getString(R.string.myvu_modules_privacy_common_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String b2 = b(i);
        String string2 = fragmentActivity.getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = fragmentActivity.getString(R.string.agree);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        f6694a = NormalProtocolDialog.Companion.b(companion, fragmentActivity, string, b2, string2, string3, fragmentActivity.getString(R.string.myvu_modules_privacy_common_title), false, (Function0) null, new ModulePrivacyManagerKt$showModulePrivacyDialog$1(i, function0, fragmentActivity), 192, (Object) null);
    }

    public static final boolean i(FragmentActivity fragmentActivity, int i, Function0 function0) {
        if (!ContractEntry.f6691a.u()) {
            ULog.f6446a.a("ModulePrivacyManager", "showPrivacyModuleById, no need to check privacy.");
            return false;
        } else if (InterconnectManager.getInstance().getStarryNetDeviceManager().isIntlAir() || InterconnectManager.getInstance().getStarryNetDeviceManager().isIntlAirPro()) {
            return m(fragmentActivity, i, function0);
        } else {
            return false;
        }
    }

    public static /* synthetic */ boolean j(FragmentActivity fragmentActivity, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function0 = null;
        }
        return i(fragmentActivity, i, function0);
    }

    public static final boolean k(FragmentActivity fragmentActivity, String str, Function0 function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (!ContractEntry.f6691a.u()) {
            ULog.f6446a.a("ModulePrivacyManager", "showPrivacyModuleByName, no need to check privacy.");
            return false;
        } else if (InterconnectManager.getInstance().getStarryNetDeviceManager().isIntlAir() || InterconnectManager.getInstance().getStarryNetDeviceManager().isIntlAirPro()) {
            return m(fragmentActivity, d(str), function0);
        } else {
            return false;
        }
    }

    public static /* synthetic */ boolean l(FragmentActivity fragmentActivity, String str, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        return k(fragmentActivity, str, function0);
    }

    public static final boolean m(FragmentActivity fragmentActivity, int i, Function0 function0) {
        if (e(i)) {
            return false;
        }
        if (!InterconnectManager.getInstance().getStarryNetDeviceManager().isIntlAir() && !InterconnectManager.getInstance().getStarryNetDeviceManager().isIntlAirPro()) {
            return false;
        }
        if (fragmentActivity == null) {
            return true;
        }
        h(fragmentActivity, i, function0);
        return true;
    }

    public static final void n(FragmentActivity fragmentActivity, int i) {
        String str;
        Intrinsics.checkNotNullParameter(fragmentActivity, "rootActivity");
        if (!ContractEntry.f6691a.u()) {
            ULog.f6446a.a("ModulePrivacyManager", "showPrivacyNotify, no need to check privacy.");
        } else if (!ModelIdExtKt.c(DynamicAdapterUtils.f7879a.a())) {
            ULog.f6446a.a("ModulePrivacyManager", "showPrivacyNotify, no need to check privacy  is not ari intl. ");
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            str = "";
                        } else if (!((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "privacy_argreement_key_ai_asst", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue()) {
                            objectRef.element = TipsKey.TIPS_PRIVACY_ASST;
                            str = GlobalExtKt.h(R.string.myvu_privacy_agree_ok_asst);
                        } else {
                            return;
                        }
                    } else if (!((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "privacy_argreement_key_ar_tici", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue()) {
                        objectRef.element = TipsKey.TIPS_PRIVACY_TICI;
                        str = GlobalExtKt.h(R.string.myvu_privacy_agree_ok_tici);
                    } else {
                        return;
                    }
                } else if (!((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "privacy_argreement_key_ar_tran", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue()) {
                    objectRef.element = TipsKey.TIPS_PRIVACY_TRANSLATOR;
                    str = GlobalExtKt.h(R.string.myvu_privacy_agree_ok_tran);
                } else {
                    return;
                }
            } else if (!((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "privacy_argreement_key_ar_navi", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue()) {
                objectRef.element = TipsKey.TIPS_PRIVACY_NAVI;
                str = GlobalExtKt.h(R.string.myvu_privacy_agree_ok_navi);
            } else {
                return;
            }
            ULog.Delegate delegate = ULog.f6446a;
            T t = objectRef.element;
            delegate.a("ModulePrivacyManager", "showPrivacyNotify, tipsKey=" + t + " module=" + i);
            T t2 = objectRef.element;
            if (t2 != null) {
                TipsManager.f7827a.d((TipsKey) t2);
                AndroidAppApi.HomeTips a2 = TipsKeyKt.a((TipsKey) objectRef.element).d(MapsKt.mapOf(TuplesKt.to("title", str), TuplesKt.to("content", ""), TuplesKt.to("showBtn", BooleanUtils.TRUE), TuplesKt.to("btnContent", GlobalExtKt.h(R.string.check_screen)), TuplesKt.to("showDel", BooleanUtils.TRUE))).a();
                Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
                TipsManagerKt.a(a2, new ModulePrivacyManagerKt$showPrivacyNotify$1(fragmentActivity, i, objectRef));
            }
        }
    }
}
