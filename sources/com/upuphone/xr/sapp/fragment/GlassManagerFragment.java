package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.Keep;
import androidx.collection.ArrayMapKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.honey.account.h8.c3;
import com.honey.account.h8.d3;
import com.honey.account.h8.e3;
import com.honey.account.h8.f3;
import com.honey.account.h8.g3;
import com.honey.account.h8.h3;
import com.honey.account.h8.i3;
import com.honey.account.h8.j3;
import com.honey.account.h8.k3;
import com.honey.account.h8.l3;
import com.honey.account.h8.m3;
import com.honey.account.h8.n3;
import com.honey.account.h8.o3;
import com.honey.account.h8.p3;
import com.honey.account.h8.q3;
import com.honey.account.h8.r3;
import com.honey.account.h8.s3;
import com.honey.account.h8.t3;
import com.honey.account.h8.u3;
import com.honey.account.h8.v3;
import com.honey.account.h8.w3;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.annotation.FastClickCheck;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.aspect.FastClickAspect;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.context.IGlassInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.contract.ModulePrivacyManagerKt;
import com.upuphone.xr.sapp.databinding.FragmentGlassManagerBinding;
import com.upuphone.xr.sapp.datatrack.AppDataTrackEvent;
import com.upuphone.xr.sapp.datatrack.ReminderDataTrackEvent;
import com.upuphone.xr.sapp.entity.GlassCheckUpdateState;
import com.upuphone.xr.sapp.entity.LanguageMode;
import com.upuphone.xr.sapp.glass.GlassHelper;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.utils.DeviceCaptifyHelper;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.LanguageHelper;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.VersionMatchHelper;
import com.upuphone.xr.sapp.view.CardItemView;
import com.upuphone.xr.sapp.view.GenericMenuView;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import com.xjsd.ai.assistant.phone.helper.WakeupVoiceStorage;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.runtime.reflect.Factory;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 K2\u00020\u0001:\u0001LB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0013\u0010\u0003J\u0019\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u0003J\u001f\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(H\u0016¢\u0006\u0004\b+\u0010,R\u0016\u00100\u001a\u00020-8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00106\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0002¢\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010=R\u0016\u0010F\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010=R\u0016\u0010H\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010=R\u0014\u0010J\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010=¨\u0006M"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassManagerFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "d1", "X1", "p1", "o1", "f1", "initView", "clickMusicTpControl", "clickStandbyPosition", "onClickFountSize", "onClickDoublePower", "z0", "onClickNetworkSetting", "onClickGlassLanSet", "onClickGlassScreenOff", "onClickAboutGlass", "", "checkGlassUpdateState", "h1", "(Z)Z", "g1", "()Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "", "windowType", "actionType", "a", "(II)V", "Lcom/upuphone/xr/sapp/databinding/FragmentGlassManagerBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentGlassManagerBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "k", "Lkotlin/Lazy;", "n0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "l", "n1", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "m", "Z", "isConnect", "Lcom/upuphone/xr/sapp/view/GenericMenuView;", "n", "Lcom/upuphone/xr/sapp/view/GenericMenuView;", "screenOffView", "o", "isExistScreenOffView", "p", "wearDetection", "q", "autoBri", "r", "isAirPro", "s", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassManagerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassManagerFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassManagerFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,770:1\n32#2,12:771\n32#2,12:783\n288#3,2:795\n256#4,2:797\n256#4,2:799\n256#4,2:801\n256#4,2:803\n256#4,2:806\n256#4,2:808\n256#4,2:810\n256#4,2:812\n256#4,2:814\n256#4,2:816\n256#4,2:818\n1#5:805\n*S KotlinDebug\n*F\n+ 1 GlassManagerFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassManagerFragment\n*L\n76#1:771,12\n77#1:783,12\n241#1:795,2\n298#1:797,2\n299#1:799,2\n300#1:801,2\n301#1:803,2\n351#1:806,2\n361#1:808,2\n392#1:810,2\n420#1:812,2\n425#1:814,2\n495#1:816,2\n516#1:818,2\n*E\n"})
public final class GlassManagerFragment extends BaseFragment {
    public static /* synthetic */ JoinPoint.StaticPart A;
    public static final Companion s = new Companion((DefaultConstructorMarker) null);
    public static /* synthetic */ JoinPoint.StaticPart t;
    public static /* synthetic */ JoinPoint.StaticPart u;
    public static /* synthetic */ JoinPoint.StaticPart v;
    public static /* synthetic */ JoinPoint.StaticPart w;
    public static /* synthetic */ JoinPoint.StaticPart x;
    public static /* synthetic */ JoinPoint.StaticPart y;
    public static /* synthetic */ JoinPoint.StaticPart z;
    public FragmentGlassManagerBinding j;
    public final Lazy k;
    public final Lazy l;
    public boolean m;
    public GenericMenuView n;
    public boolean o;
    public boolean p = true;
    public boolean q;
    public final boolean r = InterconnectManager.getInstance().getStarryNetDeviceManager().isAirPro();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassManagerFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        e1();
    }

    public GlassManagerFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.k = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.l = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    public static final void A1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        Context m0 = glassManagerFragment.m0();
        if (!glassManagerFragment.m) {
            UToast.Companion companion = UToast.f6444a;
            String string = glassManagerFragment.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(m0, string);
        } else if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(glassManagerFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            StaticMethodUtilsKt.t(glassManagerFragment, R.id.pageAdjustFragment);
        }
    }

    public static final void B1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        Context m0 = glassManagerFragment.m0();
        if (!glassManagerFragment.m) {
            UToast.Companion companion = UToast.f6444a;
            String string = glassManagerFragment.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(m0, string);
        } else if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(glassManagerFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            glassManagerFragment.q = !glassManagerFragment.q;
            FragmentGlassManagerBinding fragmentGlassManagerBinding = glassManagerFragment.j;
            if (fragmentGlassManagerBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding = null;
            }
            fragmentGlassManagerBinding.d.setSwitchState(glassManagerFragment.q);
            ControlUtils.f7858a.h0(glassManagerFragment.q);
            glassManagerFragment.z0();
        }
    }

    public static final void C1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        glassManagerFragment.clickStandbyPosition();
    }

    public static final void D1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        glassManagerFragment.clickMusicTpControl();
    }

    public static final void E1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        if (!GlassUpdateHelper.b.c0(glassManagerFragment.requireActivity()) && !ModulePrivacyManagerKt.i(glassManagerFragment.requireActivity(), 4, new GlassManagerFragment$initView$19$showPrivacy$1(glassManagerFragment))) {
            StaticMethodUtilsKt.t(glassManagerFragment, R.id.voiceAssistantsFragment);
            SdkContext.f6675a.d().reportEvent(AppDataTrackEvent.APP_CLICK, MapsKt.hashMapOf(TuplesKt.to("status", "1")));
        }
    }

    public static final void F1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        if (!GlassUpdateHelper.b.c0(glassManagerFragment.requireActivity())) {
            StaticMethodUtilsKt.t(glassManagerFragment, R.id.notifyFragment);
            SdkContext.f6675a.d().reportEvent(AppDataTrackEvent.APP_CLICK, MapsKt.hashMapOf(TuplesKt.to("status", "4")));
        }
    }

    public static final void G1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        StaticMethodUtilsKt.q(glassManagerFragment);
    }

    public static final void H1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        Context m0 = glassManagerFragment.m0();
        if (!glassManagerFragment.m) {
            UToast.Companion companion = UToast.f6444a;
            String string = glassManagerFragment.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(m0, string);
        } else if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(glassManagerFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            StaticMethodUtilsKt.t(glassManagerFragment, R.id.hearingAssistFragment);
        }
    }

    public static final void I1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        FragmentGlassManagerBinding fragmentGlassManagerBinding = glassManagerFragment.j;
        FragmentGlassManagerBinding fragmentGlassManagerBinding2 = null;
        if (fragmentGlassManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding = null;
        }
        boolean isChecked = fragmentGlassManagerBinding.f.getBinding().i.isChecked();
        Context m0 = glassManagerFragment.m0();
        if (!glassManagerFragment.m) {
            UToast.Companion companion = UToast.f6444a;
            String string = glassManagerFragment.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(m0, string);
        } else if (!GlassUpdateHelper.b.c0(glassManagerFragment.requireActivity()) && !AppUpdateHelper.f7841a.u()) {
            FragmentGlassManagerBinding fragmentGlassManagerBinding3 = glassManagerFragment.j;
            if (fragmentGlassManagerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentGlassManagerBinding2 = fragmentGlassManagerBinding3;
            }
            fragmentGlassManagerBinding2.f.getBinding().i.setChecked(!isChecked);
            ControlUtils controlUtils = ControlUtils.f7858a;
            String packageName = m0.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            controlUtils.X(packageName, !isChecked);
        }
    }

    public static final void J1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        if (!GlassUpdateHelper.b.c0(glassManagerFragment.requireActivity())) {
            StaticMethodUtilsKt.t(glassManagerFragment, R.id.wakeupRecordMainFragment);
        }
    }

    public static final void K1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        FragmentGlassManagerBinding fragmentGlassManagerBinding = glassManagerFragment.j;
        FragmentGlassManagerBinding fragmentGlassManagerBinding2 = null;
        if (fragmentGlassManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding = null;
        }
        boolean isChecked = fragmentGlassManagerBinding.e.getBinding().i.isChecked();
        Context m0 = glassManagerFragment.m0();
        if (!glassManagerFragment.m) {
            UToast.Companion companion = UToast.f6444a;
            String string = glassManagerFragment.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(m0, string);
        } else if (!GlassUpdateHelper.b.c0(glassManagerFragment.requireActivity()) && !AppUpdateHelper.f7841a.u()) {
            FragmentGlassManagerBinding fragmentGlassManagerBinding3 = glassManagerFragment.j;
            if (fragmentGlassManagerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentGlassManagerBinding2 = fragmentGlassManagerBinding3;
            }
            fragmentGlassManagerBinding2.e.getBinding().i.setChecked(!isChecked);
            DataTrackUtil.f7875a.i("brightness", MapsKt.hashMapOf(TuplesKt.to("status", String.valueOf(!isChecked))));
            ControlUtils controlUtils = ControlUtils.f7858a;
            String packageName = m0.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            controlUtils.R(packageName, !isChecked);
            glassManagerFragment.n0().Q().postValue(Boolean.valueOf(!isChecked));
        }
    }

    public static final /* synthetic */ void M1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            StaticMethodUtilsKt.t(glassManagerFragment, R.id.aboutGlassFragment);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void N1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint) {
        if (i1(glassManagerFragment, false, 1, (Object) null)) {
            StaticMethodUtilsKt.t(glassManagerFragment, R.id.glassPowerActionFragment);
        }
    }

    public static final /* synthetic */ void O1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            N1(glassManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void P1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint) {
        if (i1(glassManagerFragment, false, 1, (Object) null)) {
            StaticMethodUtilsKt.t(glassManagerFragment, R.id.fontSizeFragment);
        }
    }

    public static final /* synthetic */ void Q1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            P1(glassManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void R1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint) {
        if (i1(glassManagerFragment, false, 1, (Object) null)) {
            StaticMethodUtilsKt.t(glassManagerFragment, R.id.languageFragment);
        }
    }

    public static final /* synthetic */ void S1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            R1(glassManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void T1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint) {
        Context context;
        FragmentActivity activity;
        if (i1(glassManagerFragment, false, 1, (Object) null) && (context = glassManagerFragment.getContext()) != null && (activity = glassManagerFragment.getActivity()) != null) {
            GenericMenuView genericMenuView = new GenericMenuView(context, ControlUtils.f7858a.r(), false, new GlassManagerFragment$onClickGlassScreenOff$1$1$1(glassManagerFragment), glassManagerFragment.getString(R.string.control_auto_screen_off));
            glassManagerFragment.n = genericMenuView;
            Intrinsics.checkNotNull(genericMenuView);
            genericMenuView.setDismissListener(new GlassManagerFragment$onClickGlassScreenOff$1$1$2(glassManagerFragment));
            GenericMenuView genericMenuView2 = glassManagerFragment.n;
            Intrinsics.checkNotNull(genericMenuView2);
            Intrinsics.checkNotNull(activity);
            genericMenuView2.h(activity);
            glassManagerFragment.o = true;
        }
    }

    public static final /* synthetic */ void U1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            T1(glassManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void V1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint) {
        if (i1(glassManagerFragment, false, 1, (Object) null)) {
            StaticMethodUtilsKt.t(glassManagerFragment, R.id.wifiSettingFragment);
        }
    }

    public static final /* synthetic */ void W1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            V1(glassManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    private final void X1() {
        n0().v().removeObservers(getViewLifecycleOwner());
        n0().E0().removeObservers(getViewLifecycleOwner());
        n0().p().removeObservers(getViewLifecycleOwner());
        n0().J0().removeObservers(getViewLifecycleOwner());
        n0().q().removeObservers(getViewLifecycleOwner());
        n0().F().removeObservers(getViewLifecycleOwner());
        n1().L().removeObservers(getViewLifecycleOwner());
        n0().I().removeObservers(getViewLifecycleOwner());
        n0().M0().removeObservers(getViewLifecycleOwner());
        n0().C0().removeObservers(getViewLifecycleOwner());
        n0().B().removeObservers(getViewLifecycleOwner());
    }

    @Keep
    @FastClickCheck
    private final void clickMusicTpControl() {
        JoinPoint makeJP = Factory.makeJP(t, this, this);
        k1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void clickStandbyPosition() {
        JoinPoint makeJP = Factory.makeJP(u, this, this);
        m1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    private final void d1() {
        n0().E0().observe(getViewLifecycleOwner(), new GlassManagerFragment$sam$androidx_lifecycle_Observer$0(new GlassManagerFragment$addObserve$1(this)));
        n0().q().observe(getViewLifecycleOwner(), new GlassManagerFragment$sam$androidx_lifecycle_Observer$0(new GlassManagerFragment$addObserve$2(this)));
        n0().F().observe(getViewLifecycleOwner(), new GlassManagerFragment$sam$androidx_lifecycle_Observer$0(new GlassManagerFragment$addObserve$3(this)));
        n0().D().observe(getViewLifecycleOwner(), new GlassManagerFragment$sam$androidx_lifecycle_Observer$0(new GlassManagerFragment$addObserve$4(this)));
        n0().p().observe(getViewLifecycleOwner(), new GlassManagerFragment$sam$androidx_lifecycle_Observer$0(new GlassManagerFragment$addObserve$5(this)));
        n0().J0().observe(getViewLifecycleOwner(), new GlassManagerFragment$sam$androidx_lifecycle_Observer$0(new GlassManagerFragment$addObserve$6(this)));
        n1().L().observe(getViewLifecycleOwner(), new GlassManagerFragment$sam$androidx_lifecycle_Observer$0(new GlassManagerFragment$addObserve$7(this)));
        n0().B().observe(getViewLifecycleOwner(), new GlassManagerFragment$sam$androidx_lifecycle_Observer$0(new GlassManagerFragment$addObserve$8(this)));
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.i(viewLifecycleOwner, new GlassManagerFragment$addObserve$9(this));
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        n0().I().observe(getViewLifecycleOwner(), new GlassManagerFragment$sam$androidx_lifecycle_Observer$0(new GlassManagerFragment$addObserve$10(booleanRef, this)));
        n0().M0().observe(getViewLifecycleOwner(), new GlassManagerFragment$sam$androidx_lifecycle_Observer$0(new GlassManagerFragment$addObserve$11(this)));
        n0().C0().observe(getViewLifecycleOwner(), new GlassManagerFragment$sam$androidx_lifecycle_Observer$0(new GlassManagerFragment$addObserve$12(this)));
        GlassUpdateHelper.b.C0().observe(getViewLifecycleOwner(), new GlassManagerFragment$sam$androidx_lifecycle_Observer$0(new GlassManagerFragment$addObserve$13(this)));
    }

    private static /* synthetic */ void e1() {
        Factory factory = new Factory("GlassManagerFragment.kt", GlassManagerFragment.class);
        t = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "clickMusicTpControl", "com.upuphone.xr.sapp.fragment.GlassManagerFragment", "", "", "", "void"), 603);
        u = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "clickStandbyPosition", "com.upuphone.xr.sapp.fragment.GlassManagerFragment", "", "", "", "void"), 614);
        v = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickFountSize", "com.upuphone.xr.sapp.fragment.GlassManagerFragment", "", "", "", "void"), 623);
        w = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickDoublePower", "com.upuphone.xr.sapp.fragment.GlassManagerFragment", "", "", "", "void"), 632);
        x = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickNetworkSetting", "com.upuphone.xr.sapp.fragment.GlassManagerFragment", "", "", "", "void"), 661);
        y = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickGlassLanSet", "com.upuphone.xr.sapp.fragment.GlassManagerFragment", "", "", "", "void"), 670);
        z = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickGlassScreenOff", "com.upuphone.xr.sapp.fragment.GlassManagerFragment", "", "", "", "void"), 679);
        A = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickAboutGlass", "com.upuphone.xr.sapp.fragment.GlassManagerFragment", "", "", "", "void"), 712);
    }

    private final boolean h1(boolean z2) {
        Context m0 = m0();
        if (!this.m) {
            UToast.Companion companion = UToast.f6444a;
            String string = getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(m0, string);
            return false;
        } else if (!z2 || !GlassUpdateHelper.b.b1()) {
            return !AppUpdateHelper.f7841a.u();
        } else {
            StaticMethodUtilsKt.O(this);
            return false;
        }
    }

    public static /* synthetic */ boolean i1(GlassManagerFragment glassManagerFragment, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return glassManagerFragment.h1(z2);
    }

    private final void initView() {
        String str;
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        FragmentGlassManagerBinding fragmentGlassManagerBinding = null;
        if (bool.booleanValue()) {
            FragmentGlassManagerBinding fragmentGlassManagerBinding2 = this.j;
            if (fragmentGlassManagerBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding2 = null;
            }
            fragmentGlassManagerBinding2.o.setCardSubTitle(getString(R.string.music_tp_control_tips_oversea));
        }
        if (DeviceCaptifyHelper.f7877a.b()) {
            FragmentGlassManagerBinding fragmentGlassManagerBinding3 = this.j;
            if (fragmentGlassManagerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding3 = null;
            }
            CardItemView cardItemView = fragmentGlassManagerBinding3.o;
            Intrinsics.checkNotNullExpressionValue(cardItemView, "musicTpControl");
            cardItemView.setVisibility(8);
            FragmentGlassManagerBinding fragmentGlassManagerBinding4 = this.j;
            if (fragmentGlassManagerBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding4 = null;
            }
            CardItemView cardItemView2 = fragmentGlassManagerBinding4.u;
            Intrinsics.checkNotNullExpressionValue(cardItemView2, "voiceAssistant");
            cardItemView2.setVisibility(8);
            FragmentGlassManagerBinding fragmentGlassManagerBinding5 = this.j;
            if (fragmentGlassManagerBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding5 = null;
            }
            CardItemView cardItemView3 = fragmentGlassManagerBinding5.t;
            Intrinsics.checkNotNullExpressionValue(cardItemView3, "standbyComponent");
            cardItemView3.setVisibility(8);
            FragmentGlassManagerBinding fragmentGlassManagerBinding6 = this.j;
            if (fragmentGlassManagerBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding6 = null;
            }
            CardItemView cardItemView4 = fragmentGlassManagerBinding6.c;
            Intrinsics.checkNotNullExpressionValue(cardItemView4, "appList");
            cardItemView4.setVisibility(8);
            FragmentGlassManagerBinding fragmentGlassManagerBinding7 = this.j;
            if (fragmentGlassManagerBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding7 = null;
            }
            fragmentGlassManagerBinding7.w.setBackgroundResource(R.drawable.common_single_item_bg_top);
            FragmentGlassManagerBinding fragmentGlassManagerBinding8 = this.j;
            if (fragmentGlassManagerBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding8 = null;
            }
            fragmentGlassManagerBinding8.r.setBackgroundResource(R.drawable.common_single_item_bg_top);
        }
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        boolean booleanValue = ((Boolean) DataStoreUtils.i(companion.a(), "is_wifi_enable", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
        String str2 = (String) DataStoreUtils.i(companion.a(), "ssid", "", (Context) null, 4, (Object) null);
        ULog.f6446a.a("GlassManagerFragment", "wifiState is: " + booleanValue + ", ssid: " + str2);
        boolean z2 = true;
        if (booleanValue) {
            if (str2.length() == 0) {
                str2 = getString(R.string.word_open);
                Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
            }
            str = StringsKt.replace$default(str2, "\"", "", false, 4, (Object) null);
            if (str == null) {
                str = getString(R.string.unknow_network);
                Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
            }
        } else {
            str = getString(R.string.word_close);
            Intrinsics.checkNotNull(str);
        }
        DynamicAdapterUtils dynamicAdapterUtils = DynamicAdapterUtils.f7879a;
        if (ModelIdExtKt.a(dynamicAdapterUtils.a())) {
            FragmentGlassManagerBinding fragmentGlassManagerBinding9 = this.j;
            if (fragmentGlassManagerBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding9 = null;
            }
            fragmentGlassManagerBinding9.l.setVisibility(8);
        } else {
            FragmentGlassManagerBinding fragmentGlassManagerBinding10 = this.j;
            if (fragmentGlassManagerBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding10 = null;
            }
            fragmentGlassManagerBinding10.l.setRightContent(str);
            FragmentGlassManagerBinding fragmentGlassManagerBinding11 = this.j;
            if (fragmentGlassManagerBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding11 = null;
            }
            fragmentGlassManagerBinding11.l.setOnClickListener(new c3(this));
        }
        FragmentGlassManagerBinding fragmentGlassManagerBinding12 = this.j;
        if (fragmentGlassManagerBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding12 = null;
        }
        fragmentGlassManagerBinding12.s.setOnClickListener(new e3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding13 = this.j;
        if (fragmentGlassManagerBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding13 = null;
        }
        fragmentGlassManagerBinding13.f.getBinding().i.setClickable(false);
        FragmentGlassManagerBinding fragmentGlassManagerBinding14 = this.j;
        if (fragmentGlassManagerBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding14 = null;
        }
        fragmentGlassManagerBinding14.f.setOnClickListener(new g3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding15 = this.j;
        if (fragmentGlassManagerBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding15 = null;
        }
        CardItemView cardItemView5 = fragmentGlassManagerBinding15.v;
        Intrinsics.checkNotNullExpressionValue(cardItemView5, "vpVoiceprintInfo");
        if (!this.r || bool.booleanValue()) {
            z2 = false;
        }
        cardItemView5.setVisibility(z2 ? 0 : 8);
        FragmentGlassManagerBinding fragmentGlassManagerBinding16 = this.j;
        if (fragmentGlassManagerBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding16 = null;
        }
        fragmentGlassManagerBinding16.v.setOnClickListener(new h3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding17 = this.j;
        if (fragmentGlassManagerBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding17 = null;
        }
        CardItemView cardItemView6 = fragmentGlassManagerBinding17.e;
        Intrinsics.checkNotNullExpressionValue(cardItemView6, "autoBrightness");
        cardItemView6.setVisibility(this.r ? 0 : 8);
        FragmentGlassManagerBinding fragmentGlassManagerBinding18 = this.j;
        if (fragmentGlassManagerBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding18 = null;
        }
        fragmentGlassManagerBinding18.e.getBinding().i.setClickable(false);
        FragmentGlassManagerBinding fragmentGlassManagerBinding19 = this.j;
        if (fragmentGlassManagerBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding19 = null;
        }
        fragmentGlassManagerBinding19.e.setOnClickListener(new i3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding20 = this.j;
        if (fragmentGlassManagerBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding20 = null;
        }
        CardItemView cardItemView7 = fragmentGlassManagerBinding20.h;
        Intrinsics.checkNotNullExpressionValue(cardItemView7, "controlSoundEffect");
        cardItemView7.setVisibility(g1() ? 0 : 8);
        FragmentGlassManagerBinding fragmentGlassManagerBinding21 = this.j;
        if (fragmentGlassManagerBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding21 = null;
        }
        fragmentGlassManagerBinding21.h.getBinding().i.setClickable(false);
        FragmentGlassManagerBinding fragmentGlassManagerBinding22 = this.j;
        if (fragmentGlassManagerBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding22 = null;
        }
        fragmentGlassManagerBinding22.h.setOnClickListener(new j3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding23 = this.j;
        if (fragmentGlassManagerBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding23 = null;
        }
        fragmentGlassManagerBinding23.k.setOnClickListener(new k3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding24 = this.j;
        if (fragmentGlassManagerBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding24 = null;
        }
        CardItemView cardItemView8 = fragmentGlassManagerBinding24.j;
        Intrinsics.checkNotNullExpressionValue(cardItemView8, "glassFountSize");
        cardItemView8.setVisibility(this.r ? 0 : 8);
        if (!this.r) {
            FragmentGlassManagerBinding fragmentGlassManagerBinding25 = this.j;
            if (fragmentGlassManagerBinding25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding25 = null;
            }
            fragmentGlassManagerBinding25.k.setBackgroundResource(R.drawable.common_single_item_bg_bottom);
        }
        FragmentGlassManagerBinding fragmentGlassManagerBinding26 = this.j;
        if (fragmentGlassManagerBinding26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding26 = null;
        }
        fragmentGlassManagerBinding26.j.setOnClickListener(new l3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding27 = this.j;
        if (fragmentGlassManagerBinding27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding27 = null;
        }
        CardItemView cardItemView9 = fragmentGlassManagerBinding27.i;
        Intrinsics.checkNotNullExpressionValue(cardItemView9, "doublePowerInfo");
        cardItemView9.setVisibility(this.r ? 0 : 8);
        FragmentGlassManagerBinding fragmentGlassManagerBinding28 = this.j;
        if (fragmentGlassManagerBinding28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding28 = null;
        }
        fragmentGlassManagerBinding28.i.setOnClickListener(new m3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding29 = this.j;
        if (fragmentGlassManagerBinding29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding29 = null;
        }
        fragmentGlassManagerBinding29.g.setOnClickListener(new o3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding30 = this.j;
        if (fragmentGlassManagerBinding30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding30 = null;
        }
        fragmentGlassManagerBinding30.b.setOnClickListener(new n3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding31 = this.j;
        if (fragmentGlassManagerBinding31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding31 = null;
        }
        fragmentGlassManagerBinding31.c.setOnClickListener(new p3(this));
        ControlUtils controlUtils = ControlUtils.f7858a;
        this.p = controlUtils.B();
        FragmentGlassManagerBinding fragmentGlassManagerBinding32 = this.j;
        if (fragmentGlassManagerBinding32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding32 = null;
        }
        fragmentGlassManagerBinding32.w.setSwitchState(this.p);
        FragmentGlassManagerBinding fragmentGlassManagerBinding33 = this.j;
        if (fragmentGlassManagerBinding33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding33 = null;
        }
        fragmentGlassManagerBinding33.w.getBinding().i.setClickable(false);
        FragmentGlassManagerBinding fragmentGlassManagerBinding34 = this.j;
        if (fragmentGlassManagerBinding34 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding34 = null;
        }
        fragmentGlassManagerBinding34.w.setOnClickListener(new q3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding35 = this.j;
        if (fragmentGlassManagerBinding35 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding35 = null;
        }
        fragmentGlassManagerBinding35.q.setOnClickListener(new r3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding36 = this.j;
        if (fragmentGlassManagerBinding36 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding36 = null;
        }
        CardItemView cardItemView10 = fragmentGlassManagerBinding36.p;
        Intrinsics.checkNotNullExpressionValue(cardItemView10, "pageAdjustInfo");
        cardItemView10.setVisibility(this.r ? 0 : 8);
        FragmentGlassManagerBinding fragmentGlassManagerBinding37 = this.j;
        if (fragmentGlassManagerBinding37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding37 = null;
        }
        fragmentGlassManagerBinding37.p.setOnClickListener(new s3(this));
        if (ModelIdExtKt.b(dynamicAdapterUtils.a())) {
            FragmentGlassManagerBinding fragmentGlassManagerBinding38 = this.j;
            if (fragmentGlassManagerBinding38 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding38 = null;
            }
            CardItemView cardItemView11 = fragmentGlassManagerBinding38.d;
            Intrinsics.checkNotNullExpressionValue(cardItemView11, "autoBri");
            cardItemView11.setVisibility(0);
            this.q = controlUtils.e();
            FragmentGlassManagerBinding fragmentGlassManagerBinding39 = this.j;
            if (fragmentGlassManagerBinding39 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding39 = null;
            }
            fragmentGlassManagerBinding39.d.setSwitchState(this.q);
            FragmentGlassManagerBinding fragmentGlassManagerBinding40 = this.j;
            if (fragmentGlassManagerBinding40 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding40 = null;
            }
            fragmentGlassManagerBinding40.d.getBinding().i.setClickable(false);
            FragmentGlassManagerBinding fragmentGlassManagerBinding41 = this.j;
            if (fragmentGlassManagerBinding41 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding41 = null;
            }
            fragmentGlassManagerBinding41.d.setOnClickListener(new t3(this));
        }
        FragmentGlassManagerBinding fragmentGlassManagerBinding42 = this.j;
        if (fragmentGlassManagerBinding42 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding42 = null;
        }
        fragmentGlassManagerBinding42.t.setOnClickListener(new u3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding43 = this.j;
        if (fragmentGlassManagerBinding43 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding43 = null;
        }
        fragmentGlassManagerBinding43.o.getBinding().i.setClickable(false);
        FragmentGlassManagerBinding fragmentGlassManagerBinding44 = this.j;
        if (fragmentGlassManagerBinding44 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding44 = null;
        }
        fragmentGlassManagerBinding44.o.setSwitchState(controlUtils.p());
        FragmentGlassManagerBinding fragmentGlassManagerBinding45 = this.j;
        if (fragmentGlassManagerBinding45 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding45 = null;
        }
        fragmentGlassManagerBinding45.o.setOnClickListener(new v3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding46 = this.j;
        if (fragmentGlassManagerBinding46 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding46 = null;
        }
        fragmentGlassManagerBinding46.u.setOnClickListener(new w3(this));
        FragmentGlassManagerBinding fragmentGlassManagerBinding47 = this.j;
        if (fragmentGlassManagerBinding47 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding47 = null;
        }
        fragmentGlassManagerBinding47.r.setOnClickListener(new d3(this));
        if (ModelIdExtKt.d(dynamicAdapterUtils.a())) {
            FragmentGlassManagerBinding fragmentGlassManagerBinding48 = this.j;
            if (fragmentGlassManagerBinding48 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding48 = null;
            }
            fragmentGlassManagerBinding48.m.setVisibility(0);
            FragmentGlassManagerBinding fragmentGlassManagerBinding49 = this.j;
            if (fragmentGlassManagerBinding49 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentGlassManagerBinding = fragmentGlassManagerBinding49;
            }
            fragmentGlassManagerBinding.m.setOnClickListener(new f3(this));
            return;
        }
        FragmentGlassManagerBinding fragmentGlassManagerBinding50 = this.j;
        if (fragmentGlassManagerBinding50 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentGlassManagerBinding = fragmentGlassManagerBinding50;
        }
        fragmentGlassManagerBinding.m.setVisibility(8);
    }

    public static final /* synthetic */ void j1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint) {
        String str = null;
        if (i1(glassManagerFragment, false, 1, (Object) null)) {
            FragmentGlassManagerBinding fragmentGlassManagerBinding = glassManagerFragment.j;
            if (fragmentGlassManagerBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding = null;
            }
            boolean isChecked = fragmentGlassManagerBinding.o.getBinding().i.isChecked();
            FragmentGlassManagerBinding fragmentGlassManagerBinding2 = glassManagerFragment.j;
            if (fragmentGlassManagerBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding2 = null;
            }
            fragmentGlassManagerBinding2.o.getBinding().i.setChecked(!isChecked);
            ControlUtils controlUtils = ControlUtils.f7858a;
            Context m0 = glassManagerFragment.m0();
            if (m0 != null) {
                str = m0.getPackageName();
            }
            controlUtils.a0(str, !isChecked);
        }
    }

    public static final /* synthetic */ void k1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            j1(glassManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void l1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint) {
        if (i1(glassManagerFragment, false, 1, (Object) null)) {
            StaticMethodUtilsKt.t(glassManagerFragment, R.id.standbyPositionFragment);
        }
    }

    public static final /* synthetic */ void m1(GlassManagerFragment glassManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            l1(glassManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    private final SuperViewModel n0() {
        return (SuperViewModel) this.k.getValue();
    }

    private final DeviceControlModel n1() {
        return (DeviceControlModel) this.l.getValue();
    }

    @Keep
    @FastClickCheck
    private final void onClickAboutGlass() {
        JoinPoint makeJP = Factory.makeJP(A, this, this);
        M1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickDoublePower() {
        JoinPoint makeJP = Factory.makeJP(w, this, this);
        O1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickFountSize() {
        JoinPoint makeJP = Factory.makeJP(v, this, this);
        Q1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickGlassLanSet() {
        JoinPoint makeJP = Factory.makeJP(y, this, this);
        S1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickGlassScreenOff() {
        JoinPoint makeJP = Factory.makeJP(z, this, this);
        U1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickNetworkSetting() {
        JoinPoint makeJP = Factory.makeJP(x, this, this);
        W1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    public static final void q1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        FragmentGlassManagerBinding fragmentGlassManagerBinding = glassManagerFragment.j;
        FragmentGlassManagerBinding fragmentGlassManagerBinding2 = null;
        if (fragmentGlassManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding = null;
        }
        boolean isChecked = fragmentGlassManagerBinding.h.getBinding().i.isChecked();
        Context m0 = glassManagerFragment.m0();
        if (!glassManagerFragment.m) {
            UToast.Companion companion = UToast.f6444a;
            String string = glassManagerFragment.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(m0, string);
        } else if (!GlassUpdateHelper.b.c0(glassManagerFragment.requireActivity()) && !AppUpdateHelper.f7841a.u()) {
            FragmentGlassManagerBinding fragmentGlassManagerBinding3 = glassManagerFragment.j;
            if (fragmentGlassManagerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentGlassManagerBinding2 = fragmentGlassManagerBinding3;
            }
            fragmentGlassManagerBinding2.h.getBinding().i.setChecked(!isChecked);
            ControlUtils controlUtils = ControlUtils.f7858a;
            String packageName = m0.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            controlUtils.c0(packageName, !isChecked);
            glassManagerFragment.n0().i0().postValue(Boolean.valueOf(!isChecked));
        }
    }

    public static final void r1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        glassManagerFragment.onClickGlassLanSet();
    }

    public static final void s1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        glassManagerFragment.onClickFountSize();
    }

    public static final void t1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        glassManagerFragment.onClickDoublePower();
    }

    public static final void u1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        glassManagerFragment.onClickGlassScreenOff();
    }

    public static final void v1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        glassManagerFragment.onClickAboutGlass();
        GlassUpdateHelper.r1(GlassUpdateHelper.b, (GlassCheckUpdateState) null, 1, (Object) null);
    }

    public static final void w1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        if (i1(glassManagerFragment, false, 1, (Object) null)) {
            StaticMethodUtilsKt.t(glassManagerFragment, R.id.glassAppListFragment);
            DataStoreUtils.Companion companion = DataStoreUtils.e;
            int intValue = ((Number) DataStoreUtils.i(companion.a(), "applist_times", 1, (Context) null, 4, (Object) null)).intValue();
            DataTrackUtil.f7875a.i(ReminderDataTrackEvent.APP_GLASSES_SETTING, MapsKt.toMap(ArrayMapKt.a(TuplesKt.to("applist_times", String.valueOf(intValue)))));
            companion.a().o("applist_times", Integer.valueOf(intValue + 1));
        }
    }

    public static final void x1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        Context m0 = glassManagerFragment.m0();
        if (!glassManagerFragment.m) {
            UToast.Companion companion = UToast.f6444a;
            String string = glassManagerFragment.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(m0, string);
        } else if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(glassManagerFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            glassManagerFragment.p = !glassManagerFragment.p;
            ControlUtils controlUtils = ControlUtils.f7858a;
            String packageName = MainApplication.k.f().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            controlUtils.Z(packageName, glassManagerFragment.p);
        }
    }

    public static final void y1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        if (!GlassUpdateHelper.b.c0(glassManagerFragment.requireActivity())) {
            glassManagerFragment.onClickNetworkSetting();
        }
    }

    public static final void z1(GlassManagerFragment glassManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(glassManagerFragment, "this$0");
        Context m0 = glassManagerFragment.m0();
        if (!glassManagerFragment.m) {
            UToast.Companion companion = UToast.f6444a;
            String string = glassManagerFragment.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(m0, string);
            return;
        }
        glassManagerFragment.m0();
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(glassManagerFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            StaticMethodUtilsKt.t(glassManagerFragment, R.id.glassStabilizationFragment);
        }
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        if (i == 112) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("GlassManagerFragment", "remove device result, actionType: " + i2);
            if (i2 == 1101) {
                startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
            }
        }
    }

    public final void f1() {
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        int intValue = ((Number) DataStoreUtils.j(companion.a(), "set_screen_off_time", 30, true, (Context) null, 8, (Object) null)).intValue();
        boolean e = VersionMatchHelper.e(VersionMatchHelper.f7930a, false, false, false, (String) null, (String) null, GlassInfoExtKt.c(GlassInfoExtKt.d("1.1.3")), (String) null, 92, (Object) null);
        if (intValue > 120 && !e) {
            ControlUtils.f7858a.Y(m0().getPackageName(), 30);
            companion.a().p("set_screen_off_time", 30, true);
        }
        ControlUtils.f7858a.t(m0().getPackageName());
    }

    public final boolean g1() {
        if (this.r) {
            return true;
        }
        IGlassInfo a2 = SdkContext.f6675a.e().a();
        if (a2 == null) {
            return false;
        }
        return GlassInfoExtKt.j(GlassInfoExtKt.c(GlassInfoExtKt.d(a2.getRomVersion())), GlassInfoExtKt.c(GlassInfoExtKt.d(!SuperNotificationManager.f7749a.B() ? "Flyme AR 1.0.6.3.20240424_Air_FR" : "1.0.3.76"))) > 0;
    }

    public final void o1() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new GlassManagerFragment$getStateFromGlass$1(this, (Continuation<? super GlassManagerFragment$getStateFromGlass$1>) null), 3, (Object) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentGlassManagerBinding c = FragmentGlassManagerBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onPause() {
        super.onPause();
        X1();
    }

    public void onResume() {
        super.onResume();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("GlassManagerFragment", "addObserve");
        d1();
        FragmentGlassManagerBinding fragmentGlassManagerBinding = this.j;
        if (fragmentGlassManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassManagerBinding = null;
        }
        fragmentGlassManagerBinding.v.setRightContent(WakeupVoiceStorage.INSTANCE.has() ? getString(R.string.vp_voiceprint_already_entered) : getString(R.string.vp_voiceprint_not_entered));
        delegate.g("GlassManagerFragment", "addObserve done");
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ULog.f6446a.g("GlassManagerFragment", "onViewCreated");
        Bundle arguments = getArguments();
        this.m = arguments != null ? arguments.getBoolean("glass_connect_state") : false;
        p1();
        o1();
        initView();
    }

    public final void p1() {
        Object obj;
        ControlUtils controlUtils = ControlUtils.f7858a;
        String u2 = controlUtils.u();
        String y2 = controlUtils.y();
        ULog.f6446a.a("GlassManagerFragment", "initLocalData::screenOffTimeStr is: " + u2 + " and storageGlassLanguage is: " + y2);
        if (!GlassHelper.f7049a.E()) {
            FragmentGlassManagerBinding fragmentGlassManagerBinding = this.j;
            FragmentGlassManagerBinding fragmentGlassManagerBinding2 = null;
            if (fragmentGlassManagerBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassManagerBinding = null;
            }
            fragmentGlassManagerBinding.g.setCardSubTitle(u2);
            Iterator it = LanguageHelper.f7894a.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((LanguageMode) obj).getLanguage(), (Object) ControlUtils.f7858a.y())) {
                    break;
                }
            }
            LanguageMode languageMode = (LanguageMode) obj;
            if (languageMode != null) {
                FragmentGlassManagerBinding fragmentGlassManagerBinding3 = this.j;
                if (fragmentGlassManagerBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentGlassManagerBinding2 = fragmentGlassManagerBinding3;
                }
                fragmentGlassManagerBinding2.k.setCardSubTitle(getString(languageMode.getLanguageStrId()));
            }
        }
    }

    public final void z0() {
        long currentTimeMillis = System.currentTimeMillis();
        SuperMessageManger.Companion companion = SuperMessageManger.m;
        Long x2 = companion.a().x();
        Long y2 = companion.a().y();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassManagerFragment", "currentTimeMillis is: " + currentTimeMillis + " and sunrise is: " + x2 + " and sunset is: " + y2);
        if (this.q && x2 != null && y2 != null) {
            if (currentTimeMillis < x2.longValue() || currentTimeMillis >= y2.longValue()) {
                companion.a().s0("sunset");
            } else {
                companion.a().s0("sunrise");
            }
        }
    }
}
