package com.upuphone.xr.sapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.honey.account.h8.e1;
import com.honey.account.h8.f1;
import com.honey.account.h8.g1;
import com.honey.account.h8.h1;
import com.honey.account.h8.i1;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.annotation.ConnectCheck;
import com.upuphone.xr.annotation.FastClickCheck;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.aspect.AspectHelper;
import com.upuphone.xr.sapp.aspect.ConnectCheckAspect;
import com.upuphone.xr.sapp.aspect.FastClickAspect;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentCommonSettingBinding;
import com.upuphone.xr.sapp.glass.GlassHelper;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;
import com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.ContextExtKt;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.runtime.reflect.Factory;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u000f\u0010\u0003J+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u0003R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/CommonSettingFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseConnectCheckFragment;", "<init>", "()V", "", "A0", "D0", "", "connect", "M0", "(Z)V", "initView", "onClickGlassLanSet", "onClickGlassUpdate", "onClickFactoryReset", "onClickAboutGlass", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "Lcom/upuphone/xr/sapp/databinding/FragmentCommonSettingBinding;", "k", "Lcom/upuphone/xr/sapp/databinding/FragmentCommonSettingBinding;", "binding", "l", "Z", "isConnect", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "m", "Lkotlin/Lazy;", "C0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nCommonSettingFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonSettingFragment.kt\ncom/upuphone/xr/sapp/fragment/CommonSettingFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 ContextExt.kt\ncom/upuphone/xr/sapp/utils/ContextExtKt\n*L\n1#1,155:1\n32#2,12:156\n19#3,9:168\n*S KotlinDebug\n*F\n+ 1 CommonSettingFragment.kt\ncom/upuphone/xr/sapp/fragment/CommonSettingFragment\n*L\n38#1:156,12\n118#1:168,9\n*E\n"})
public final class CommonSettingFragment extends BaseConnectCheckFragment {
    public static /* synthetic */ JoinPoint.StaticPart n;
    public static /* synthetic */ JoinPoint.StaticPart o;
    public static /* synthetic */ JoinPoint.StaticPart p;
    public static /* synthetic */ JoinPoint.StaticPart q;
    public FragmentCommonSettingBinding k;
    public boolean l = true;
    public final Lazy m;

    static {
        L0();
    }

    public CommonSettingFragment() {
        Class<DeviceControlModel> cls = DeviceControlModel.class;
        this.m = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    private final void A0() {
        C0().L().observe(getViewLifecycleOwner(), new CommonSettingFragment$sam$androidx_lifecycle_Observer$0(new CommonSettingFragment$addObserve$1(this)));
    }

    private final DeviceControlModel C0() {
        return (DeviceControlModel) this.m.getValue();
    }

    private final void D0() {
        C0().L().removeObservers(getViewLifecycleOwner());
    }

    private static /* synthetic */ void L0() {
        Factory factory = new Factory("CommonSettingFragment.kt", CommonSettingFragment.class);
        n = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickGlassLanSet", "com.upuphone.xr.sapp.fragment.CommonSettingFragment", "", "", "", "void"), 99);
        o = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickGlassUpdate", "com.upuphone.xr.sapp.fragment.CommonSettingFragment", "", "", "", "void"), 114);
        p = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickFactoryReset", "com.upuphone.xr.sapp.fragment.CommonSettingFragment", "", "", "", "void"), 125);
        q = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickAboutGlass", "com.upuphone.xr.sapp.fragment.CommonSettingFragment", "", "", "", "void"), 140);
    }

    public static final void N0(CommonSettingFragment commonSettingFragment, View view) {
        Intrinsics.checkNotNullParameter(commonSettingFragment, "this$0");
        FragmentKt.a(commonSettingFragment).T();
    }

    public static final void O0(CommonSettingFragment commonSettingFragment, View view) {
        Intrinsics.checkNotNullParameter(commonSettingFragment, "this$0");
        commonSettingFragment.onClickAboutGlass();
    }

    public static final void P0(CommonSettingFragment commonSettingFragment, View view) {
        Intrinsics.checkNotNullParameter(commonSettingFragment, "this$0");
        commonSettingFragment.onClickGlassUpdate();
    }

    public static final void Q0(CommonSettingFragment commonSettingFragment, View view) {
        Intrinsics.checkNotNullParameter(commonSettingFragment, "this$0");
        commonSettingFragment.onClickGlassLanSet();
    }

    public static final void R0(CommonSettingFragment commonSettingFragment, View view) {
        Intrinsics.checkNotNullParameter(commonSettingFragment, "this$0");
        commonSettingFragment.onClickFactoryReset();
    }

    public static final /* synthetic */ void S0(CommonSettingFragment commonSettingFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(commonSettingFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            StaticMethodUtilsKt.t(commonSettingFragment, R.id.aboutGlassFragment);
        }
    }

    public static final /* synthetic */ void T0(CommonSettingFragment commonSettingFragment, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            S0(commonSettingFragment, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    public static final /* synthetic */ void V0(CommonSettingFragment commonSettingFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            T0(commonSettingFragment, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void X0(CommonSettingFragment commonSettingFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            Z0(commonSettingFragment, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void Y0(CommonSettingFragment commonSettingFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(commonSettingFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            StaticMethodUtilsKt.t(commonSettingFragment, R.id.factoryResetFragment);
        }
    }

    public static final /* synthetic */ void Z0(CommonSettingFragment commonSettingFragment, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            Y0(commonSettingFragment, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    public static final /* synthetic */ void a1(CommonSettingFragment commonSettingFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(commonSettingFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            StaticMethodUtilsKt.t(commonSettingFragment, R.id.languageFragment);
        }
    }

    public static final /* synthetic */ void b1(CommonSettingFragment commonSettingFragment, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            a1(commonSettingFragment, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    public static final /* synthetic */ void d1(CommonSettingFragment commonSettingFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            b1(commonSettingFragment, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void e1(CommonSettingFragment commonSettingFragment, JoinPoint joinPoint) {
        if (!GlassHelper.f7049a.E()) {
            ContextExtKt.e(R.string.glass_disconnect_toast, 0, 2, (Object) null);
            return;
        }
        FragmentActivity activity = commonSettingFragment.getActivity();
        if (activity != null) {
            activity.startActivity(new Intent(activity, GlassUpdateInfoActivity.class));
        }
    }

    public static final /* synthetic */ void f1(CommonSettingFragment commonSettingFragment, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            e1(commonSettingFragment, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    public static final /* synthetic */ void h1(CommonSettingFragment commonSettingFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            f1(commonSettingFragment, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    private final void initView() {
        FragmentCommonSettingBinding fragmentCommonSettingBinding = this.k;
        FragmentCommonSettingBinding fragmentCommonSettingBinding2 = null;
        if (fragmentCommonSettingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCommonSettingBinding = null;
        }
        TextView textView = fragmentCommonSettingBinding.f;
        Intrinsics.checkNotNullExpressionValue(textView, "tvBackTitle");
        ViewExtKt.b(textView, new e1(this));
        FragmentCommonSettingBinding fragmentCommonSettingBinding3 = this.k;
        if (fragmentCommonSettingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCommonSettingBinding3 = null;
        }
        fragmentCommonSettingBinding3.e.setOnClickListener(new f1(this));
        FragmentCommonSettingBinding fragmentCommonSettingBinding4 = this.k;
        if (fragmentCommonSettingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCommonSettingBinding4 = null;
        }
        fragmentCommonSettingBinding4.i.setOnClickListener(new g1(this));
        GlassUpdateHelper.b.P0().observe(getViewLifecycleOwner(), new CommonSettingFragment$sam$androidx_lifecycle_Observer$0(new CommonSettingFragment$initView$4(this)));
        FragmentCommonSettingBinding fragmentCommonSettingBinding5 = this.k;
        if (fragmentCommonSettingBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCommonSettingBinding5 = null;
        }
        fragmentCommonSettingBinding5.h.setOnClickListener(new h1(this));
        FragmentCommonSettingBinding fragmentCommonSettingBinding6 = this.k;
        if (fragmentCommonSettingBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentCommonSettingBinding2 = fragmentCommonSettingBinding6;
        }
        fragmentCommonSettingBinding2.g.setOnClickListener(new i1(this));
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickAboutGlass() {
        JoinPoint makeJP = Factory.makeJP(q, this, this);
        V0(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickFactoryReset() {
        JoinPoint makeJP = Factory.makeJP(p, this, this);
        X0(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickGlassLanSet() {
        JoinPoint makeJP = Factory.makeJP(n, this, this);
        d1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickGlassUpdate() {
        JoinPoint makeJP = Factory.makeJP(o, this, this);
        h1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    public final void M0(boolean z) {
        this.l = z;
        FragmentCommonSettingBinding fragmentCommonSettingBinding = null;
        if (z) {
            FragmentCommonSettingBinding fragmentCommonSettingBinding2 = this.k;
            if (fragmentCommonSettingBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentCommonSettingBinding = fragmentCommonSettingBinding2;
            }
            fragmentCommonSettingBinding.d.setAlpha(1.0f);
            return;
        }
        FragmentCommonSettingBinding fragmentCommonSettingBinding3 = this.k;
        if (fragmentCommonSettingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentCommonSettingBinding = fragmentCommonSettingBinding3;
        }
        fragmentCommonSettingBinding.d.setAlpha(0.5f);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentCommonSettingBinding c = FragmentCommonSettingBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.k = c;
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
        D0();
    }

    public void onResume() {
        super.onResume();
        A0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }
}
