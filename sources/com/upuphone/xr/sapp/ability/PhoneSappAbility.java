package com.upuphone.xr.sapp.ability;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Consumer;
import androidx.lifecycle.LifecycleOwnerKt;
import com.honey.account.b8.a;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.PhoneSappAbilityImpl;
import com.upuphone.xr.interconnect.api.SappAbilityAction;
import com.upuphone.xr.interconnect.api.SappAbilityType;
import com.upuphone.xr.interconnect.common.IAIModelResult;
import com.upuphone.xr.interconnect.common.IPermissonResult;
import com.upuphone.xr.interconnect.entity.PermissionResult;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.entity.AIModelResult;
import com.upuphone.xr.sapp.entity.AccountInfo;
import com.upuphone.xr.sapp.entity.PermissionDesp;
import com.upuphone.xr.sapp.entity.PermissionNote;
import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.upuphone.xr.sapp.tips.TipsKey;
import com.upuphone.xr.sapp.tips.TipsKeyKt;
import com.upuphone.xr.sapp.tips.TipsManagerKt;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.HttpRequestUtil;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.SuperFunctionUtils;
import com.xjmz.myvu.MYVUActivity;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import okhttp3.Callback;
import org.apache.commons.lang3.BooleanUtils;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0002HIB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J'\u0010\u000e\u001a\u00020\r2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0014\u001a\u00020\u00062\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016H\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\"\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$H@¢\u0006\u0004\b%\u0010&J1\u0010)\u001a\u00020\u00062\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00102\u0006\u0010(\u001a\u00020'2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b)\u0010*J%\u0010-\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0+H\u0002¢\u0006\u0004\b-\u0010.J-\u00100\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0+2\u0006\u0010/\u001a\u00020\rH\u0002¢\u0006\u0004\b0\u00101J%\u00102\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0+H\u0002¢\u0006\u0004\b2\u0010.R\u0018\u00105\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0002¢\u0006\f\n\u0004\b\t\u0010?\u001a\u0004\b@\u0010AR\u001b\u0010D\u001a\u00020>8BX\u0002¢\u0006\f\n\u0004\b@\u0010?\u001a\u0004\bC\u0010AR\u0014\u0010G\u001a\u00020E8\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010F¨\u0006J"}, d2 = {"Lcom/upuphone/xr/sapp/ability/PhoneSappAbility;", "Lcom/upuphone/xr/interconnect/api/PhoneSappAbilityImpl$IAbilityClientResponse;", "<init>", "()V", "Lcom/upuphone/xr/sapp/MainApplication;", "mapp", "", "h", "(Lcom/upuphone/xr/sapp/MainApplication;)V", "e", "", "type", "action", "", "doAbilityResponse", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "permissionList", "Lcom/upuphone/xr/interconnect/common/IPermissonResult;", "callback", "requestPermission", "(Ljava/util/List;Lcom/upuphone/xr/interconnect/common/IPermissonResult;)V", "Lcom/upuphone/xr/interconnect/common/IAIModelResult;", "requestAIState", "(Lcom/upuphone/xr/interconnect/common/IAIModelResult;)V", "state", "submitAIState", "(Ljava/lang/String;Lcom/upuphone/xr/interconnect/common/IAIModelResult;)V", "policyId", "cacheSn", "k", "(Ljava/lang/String;Ljava/lang/String;)V", "", "agreeTime", "p", "(Ljava/lang/String;J)V", "Lcom/upuphone/xr/sapp/entity/AIModelResult;", "q", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/xjmz/myvu/MYVUActivity;", "activity", "i", "(Ljava/util/List;Lcom/xjmz/myvu/MYVUActivity;Lcom/upuphone/xr/interconnect/common/IPermissonResult;)V", "", "permissions", "m", "(Lcom/xjmz/myvu/MYVUActivity;[Ljava/lang/String;)V", "result", "j", "(Lcom/xjmz/myvu/MYVUActivity;[Ljava/lang/String;Z)V", "o", "a", "Lcom/upuphone/xr/sapp/MainApplication;", "mApplication", "b", "Lcom/upuphone/xr/interconnect/common/IPermissonResult;", "c", "Ljava/lang/String;", "mPolicyId", "d", "Ljava/lang/Long;", "mAgreeTime", "Lokhttp3/Callback;", "Lkotlin/Lazy;", "f", "()Lokhttp3/Callback;", "requestExpireCallback", "g", "submitExpireCallback", "Lcom/upuphone/xr/sapp/assistant/LlmProtocolStateDelegate;", "Lcom/upuphone/xr/sapp/assistant/LlmProtocolStateDelegate;", "llmProtocolStateDelegate", "Companion", "IAiModelCallback", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPhoneSappAbility.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PhoneSappAbility.kt\ncom/upuphone/xr/sapp/ability/PhoneSappAbility\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,468:1\n37#2,2:469\n37#2,2:473\n13309#3,2:471\n*S KotlinDebug\n*F\n+ 1 PhoneSappAbility.kt\ncom/upuphone/xr/sapp/ability/PhoneSappAbility\n*L\n380#1:469,2\n436#1:473,2\n410#1:471,2\n*E\n"})
public final class PhoneSappAbility implements PhoneSappAbilityImpl.IAbilityClientResponse {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);
    public static final Lazy i = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PhoneSappAbility$Companion$instance$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public MainApplication f6600a;
    public IPermissonResult b;
    public String c;
    public Long d;
    public final Lazy e = LazyKt.lazy(new PhoneSappAbility$requestExpireCallback$2(this));
    public final Lazy f = LazyKt.lazy(PhoneSappAbility$submitExpireCallback$2.INSTANCE);
    public final LlmProtocolStateDelegate g = new LlmProtocolStateDelegate();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/ability/PhoneSappAbility$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/ability/PhoneSappAbility;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/upuphone/xr/sapp/ability/PhoneSappAbility;", "instance", "", "FUNC_PP_EXPIRE_QUERY", "I", "FUNC_PP_EXPIRE_SUBMIT", "", "REJECT_TWICE", "Ljava/lang/String;", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PhoneSappAbility a() {
            return (PhoneSappAbility) PhoneSappAbility.i.getValue();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/upuphone/xr/sapp/ability/PhoneSappAbility$IAiModelCallback;", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface IAiModelCallback {
    }

    public static /* synthetic */ void l(PhoneSappAbility phoneSappAbility, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        phoneSappAbility.k(str, str2);
    }

    public static final void n(List list) {
        PermissionDesp s = PermissionAndStateCheckUtils.f7907a.s(GlobalExtKt.f(), "permission_ai_model");
        AndroidAppApi.HomeTips a2 = TipsKeyKt.a(TipsKey.TIPS_PRIVACY_AI).d(MapsKt.mapOf(TuplesKt.to("title", s.getTitle()), TuplesKt.to("content", s.getContent()), TuplesKt.to("showBtn", BooleanUtils.TRUE), TuplesKt.to("btnContent", GlobalExtKt.f().getString(R.string.flyme_account_auth_sure)), TuplesKt.to("showDel", BooleanUtils.TRUE))).a();
        Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
        TipsManagerKt.a(a2, new PhoneSappAbility$requestPermission$1$1(list));
    }

    public boolean doAbilityResponse(String str, String str2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("PhoneSappAbility", "type is: " + str + " and action is: " + str2);
        if (str == null) {
            return false;
        }
        switch (str.hashCode()) {
            case -2117137325:
                if (!str.equals(SappAbilityType.NOT_DISTURB) || str2 == null) {
                    return false;
                }
                int hashCode = str2.hashCode();
                if (hashCode != 3417674) {
                    if (hashCode != 64218584) {
                        if (hashCode == 79219825 && str2.equals(SappAbilityAction.STATE)) {
                            return ControlUtils.f7858a.D();
                        }
                        return false;
                    } else if (!str2.equals(SappAbilityAction.CLOSE)) {
                        return false;
                    } else {
                        ControlUtils controlUtils = ControlUtils.f7858a;
                        String packageName = GlobalExtKt.f().getPackageName();
                        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                        controlUtils.X(packageName, false);
                        return true;
                    }
                } else if (!str2.equals("open")) {
                    return false;
                } else {
                    ControlUtils controlUtils2 = ControlUtils.f7858a;
                    String packageName2 = GlobalExtKt.f().getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName2, "getPackageName(...)");
                    controlUtils2.X(packageName2, true);
                    return true;
                }
            case -1947208172:
                if (str.equals(SappAbilityType.NAVI) && str2 != null) {
                    int hashCode2 = str2.hashCode();
                    if (hashCode2 != 3417674) {
                        if (hashCode2 != 64218584) {
                            if (hashCode2 == 79219825 && str2.equals(SappAbilityAction.STATE)) {
                                return NaviManager.getInstance(GlobalExtKt.f()).isNaviOpened();
                            }
                        } else if (str2.equals(SappAbilityAction.CLOSE)) {
                            SuperFunctionUtils.b.a().c();
                            return true;
                        }
                    } else if (str2.equals("open")) {
                        SuperFunctionUtils.b.a().g();
                        return true;
                    }
                }
                return false;
            case -1336199776:
                if (str.equals(SappAbilityType.AR_MEDIA)) {
                    if (Intrinsics.areEqual((Object) str2, (Object) "open")) {
                        SuperFunctionUtils.b.a().e(GlobalExtKt.f());
                        break;
                    }
                } else {
                    return false;
                }
                break;
            case -4416930:
                if (str.equals(SappAbilityType.AR_CARD)) {
                    Intrinsics.areEqual((Object) str2, (Object) "open");
                    break;
                } else {
                    return false;
                }
            case -4141494:
                if (str.equals(SappAbilityType.AR_LIFE)) {
                    Intrinsics.areEqual((Object) str2, (Object) "open");
                    break;
                } else {
                    return false;
                }
            case 312313489:
                if (!str.equals(SappAbilityType.TRANSLATION)) {
                    return false;
                }
                if (Intrinsics.areEqual((Object) str2, (Object) "open")) {
                    TranslationApp.startService(GlobalExtKt.f());
                    return true;
                } else if (Intrinsics.areEqual((Object) str2, (Object) SappAbilityAction.STATE)) {
                    return TranslationApp.isServiceOn();
                } else {
                    return false;
                }
            default:
                return false;
        }
        return true;
    }

    public final void e() {
        InterconnectManager.getInstance().getPhoneSappAbility().addAbilityClient(this);
    }

    public final Callback f() {
        return (Callback) this.e.getValue();
    }

    public final Callback g() {
        return (Callback) this.f.getValue();
    }

    public final void h(MainApplication mainApplication) {
        Intrinsics.checkNotNullParameter(mainApplication, "mapp");
        this.f6600a = mainApplication;
    }

    public final void i(List list, MYVUActivity mYVUActivity, IPermissonResult iPermissonResult) {
        if (list != null) {
            this.b = iPermissonResult;
            if (!PermissionHelper.f7819a.m(mYVUActivity, list)) {
                m(mYVUActivity, (String[]) list.toArray(new String[0]));
            } else if (iPermissonResult != null) {
                iPermissonResult.permissonResult(new PermissionResult(true, new ArrayList()));
            }
        }
    }

    public final void j(MYVUActivity mYVUActivity, String[] strArr, boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        String arrays = Arrays.toString(strArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        delegate.a("PhoneSappAbility", "onPermissionResult, permissions: " + arrays + ", result: " + z);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            PermissionHelper permissionHelper = PermissionHelper.f7819a;
            if (!permissionHelper.l(mYVUActivity, str)) {
                arrayList.add(str);
                if (permissionHelper.h(str) >= 2) {
                    arrayList2.add(str);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            IPermissonResult iPermissonResult = this.b;
            if (iPermissonResult != null) {
                iPermissonResult.permissonResult(new PermissionResult(arrayList.isEmpty(), arrayList));
            }
        } else {
            arrayList2.add(0, "reject_twice");
            IPermissonResult iPermissonResult2 = this.b;
            if (iPermissonResult2 != null) {
                iPermissonResult2.permissonResult(new PermissionResult(false, arrayList2));
            }
        }
        o(mYVUActivity, (String[]) arrayList.toArray(new String[0]));
    }

    public final void k(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "policyId");
        this.c = str;
        AccountInfo a2 = MzAccountManager.c.a();
        String a3 = DynamicAdapterUtils.f7879a.a();
        if ((a2 != null ? a2.getId() : null) != null) {
            HttpRequestUtil.f7890a.s(str, a2.getId(), a3, str2, f());
        } else {
            ULog.f6446a.g("PhoneSappAbility", "requestExpiredState-> account为空");
        }
    }

    public final void m(MYVUActivity mYVUActivity, String[] strArr) {
        PermissionHelper.f7819a.r(mYVUActivity, strArr, false, new PhoneSappAbility$requestMultiplePermissions$1(this, mYVUActivity, strArr));
    }

    public final void o(MYVUActivity mYVUActivity, String[] strArr) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("PhoneSappAbility", "showPermissionRejectWindow, permissions: " + strArr);
        if (strArr.length != 0) {
            PermissionNote k = PermissionHelper.f7819a.k(mYVUActivity, strArr);
            if (k == null) {
                delegate.c("PhoneSappAbility", "showPermissionRejectWindow, rejectPermissionNote is null");
            } else {
                Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(mYVUActivity), (CoroutineContext) null, (CoroutineStart) null, new PhoneSappAbility$showPermissionRejectWindow$1(mYVUActivity, k, (Continuation<? super PhoneSappAbility$showPermissionRejectWindow$1>) null), 3, (Object) null);
            }
        }
    }

    public final void p(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "policyId");
        this.c = str;
        this.d = Long.valueOf(j);
        AccountInfo a2 = MzAccountManager.c.a();
        if ((a2 != null ? a2.getId() : null) != null) {
            HttpRequestUtil.f7890a.z(str, a2.getId(), j, g());
        } else {
            ULog.f6446a.g("PhoneSappAbility", "submitExpiredState-> account为空");
        }
    }

    public final Object q(Continuation continuation) {
        return this.g.p(continuation);
    }

    public void requestAIState(IAIModelResult iAIModelResult) {
        AIModelResult aIModelResult = (AIModelResult) BuildersKt__BuildersKt.b((CoroutineContext) null, new PhoneSappAbility$requestAIState$result$1(this, (Continuation<? super PhoneSappAbility$requestAIState$result$1>) null), 1, (Object) null);
        if (iAIModelResult != null) {
            iAIModelResult.aiResult(new com.upuphone.xr.interconnect.entity.AIModelResult(true, aIModelResult.getState()));
        }
    }

    public void requestPermission(List list, IPermissonResult iPermissonResult) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("PhoneSappAbility", "requestPermission, permissionList: " + list);
        MainApplication mainApplication = this.f6600a;
        List q = mainApplication != null ? mainApplication.q() : null;
        Activity activity = (q == null || q.isEmpty()) ? null : (Activity) q.get(0);
        if (Intrinsics.areEqual((Object) list != null ? (String) list.get(0) : null, (Object) "permission_ai_model")) {
            if (activity == null) {
                delegate.c("PhoneSappAbility", "在后台显示Tips");
                new Handler(Looper.getMainLooper()).post(new a(q));
            } else {
                ContractEntry.f6691a.x(activity, 1, (Consumer) null);
            }
        }
        MYVUActivity r = MainApplication.k.f().r();
        if (r != null) {
            i(list, r, iPermissonResult);
        }
    }

    public void submitAIState(String str, IAIModelResult iAIModelResult) {
        ULog.f6446a.c("PhoneSappAbility", "submitAIState::method Deprecated");
    }
}
