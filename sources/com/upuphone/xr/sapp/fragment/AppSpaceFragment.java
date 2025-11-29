package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import com.honey.account.h8.a1;
import com.honey.account.h8.u0;
import com.honey.account.h8.v0;
import com.honey.account.h8.w0;
import com.honey.account.h8.x0;
import com.honey.account.h8.y0;
import com.honey.account.h8.z0;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.annotation.FastClickCheck;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.aspect.FastClickAspect;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.databinding.FragmentAppSpaceBinding;
import com.upuphone.xr.sapp.datatrack.ReminderDataTrackEvent;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.SuperFunctionUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.runtime.reflect.Factory;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\t\u0010\u0003J-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/AppSpaceFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "onClickTranslator", "onClickVoiceManager", "onClickUnboundedScreen", "onClickNotifyCard", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "windowType", "", "c", "(ILjava/lang/Object;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentAppSpaceBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentAppSpaceBinding;", "binding", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AppSpaceFragment extends BaseFragment {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public static /* synthetic */ JoinPoint.StaticPart l;
    public static /* synthetic */ JoinPoint.StaticPart m;
    public static /* synthetic */ JoinPoint.StaticPart n;
    public static /* synthetic */ JoinPoint.StaticPart o;
    public FragmentAppSpaceBinding j;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/AppSpaceFragment$Companion;", "", "()V", "PERMISSION_NOTIFICATION_REQUEST_CODE", "", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        H0();
    }

    public static /* synthetic */ void H0() {
        Factory factory = new Factory("AppSpaceFragment.kt", AppSpaceFragment.class);
        l = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickTranslator", "com.upuphone.xr.sapp.fragment.AppSpaceFragment", "", "", "", "void"), 97);
        m = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickVoiceManager", "com.upuphone.xr.sapp.fragment.AppSpaceFragment", "", "", "", "void"), 115);
        n = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickUnboundedScreen", "com.upuphone.xr.sapp.fragment.AppSpaceFragment", "", "", "", "void"), 129);
        o = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickNotifyCard", "com.upuphone.xr.sapp.fragment.AppSpaceFragment", "", "", "", "void"), 143);
    }

    public static final void I0(AppSpaceFragment appSpaceFragment, View view) {
        Intrinsics.checkNotNullParameter(appSpaceFragment, "this$0");
        StaticMethodUtilsKt.q(appSpaceFragment);
    }

    public static final void J0(AppSpaceFragment appSpaceFragment, View view) {
        Intrinsics.checkNotNullParameter(appSpaceFragment, "this$0");
        appSpaceFragment.onClickVoiceManager();
    }

    public static final void K0(AppSpaceFragment appSpaceFragment, View view) {
        Intrinsics.checkNotNullParameter(appSpaceFragment, "this$0");
        appSpaceFragment.onClickTranslator();
    }

    public static final void L0(AppSpaceFragment appSpaceFragment, View view) {
        Intrinsics.checkNotNullParameter(appSpaceFragment, "this$0");
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(appSpaceFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            MainApplication.Companion companion = MainApplication.k;
            NaviManager.getInstance(companion.f()).startMap(companion.f());
        }
    }

    public static final void M0(AppSpaceFragment appSpaceFragment, View view) {
        Intrinsics.checkNotNullParameter(appSpaceFragment, "this$0");
        appSpaceFragment.onClickNotifyCard();
    }

    public static final void N0(AppSpaceFragment appSpaceFragment, View view) {
        Intrinsics.checkNotNullParameter(appSpaceFragment, "this$0");
        appSpaceFragment.onClickUnboundedScreen();
    }

    public static final void O0(AppSpaceFragment appSpaceFragment, View view) {
        Intrinsics.checkNotNullParameter(appSpaceFragment, "this$0");
        StaticMethodUtilsKt.t(appSpaceFragment, R.id.miniDesktopFragment);
    }

    public static final /* synthetic */ void P0(AppSpaceFragment appSpaceFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(appSpaceFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            StaticMethodUtilsKt.t(appSpaceFragment, R.id.notifyFragment);
        }
    }

    public static final /* synthetic */ void Q0(AppSpaceFragment appSpaceFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            P0(appSpaceFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void R0(AppSpaceFragment appSpaceFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(appSpaceFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            if (NaviManager.getInstance(MainApplication.k.f()).isNaving()) {
                SuperFunctionUtils.b.a().c();
            }
            Context requireContext = appSpaceFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            TranslationApp.startMainActivity(requireContext);
        }
    }

    public static final /* synthetic */ void S0(AppSpaceFragment appSpaceFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            R0(appSpaceFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void T0(AppSpaceFragment appSpaceFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(appSpaceFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            StaticMethodUtilsKt.t(appSpaceFragment, R.id.dlnaPhoneFragment);
        }
    }

    public static final /* synthetic */ void U0(AppSpaceFragment appSpaceFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            T0(appSpaceFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void V0(AppSpaceFragment appSpaceFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(appSpaceFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            StaticMethodUtilsKt.t(appSpaceFragment, R.id.voiceAssistantsFragment);
        }
    }

    public static final /* synthetic */ void W0(AppSpaceFragment appSpaceFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            V0(appSpaceFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    private final void initView() {
        FragmentAppSpaceBinding fragmentAppSpaceBinding = this.j;
        FragmentAppSpaceBinding fragmentAppSpaceBinding2 = null;
        if (fragmentAppSpaceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAppSpaceBinding = null;
        }
        fragmentAppSpaceBinding.h.setOnClickListener(new u0(this));
        FragmentAppSpaceBinding fragmentAppSpaceBinding3 = this.j;
        if (fragmentAppSpaceBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAppSpaceBinding3 = null;
        }
        fragmentAppSpaceBinding3.n.setOnClickListener(new v0(this));
        FragmentAppSpaceBinding fragmentAppSpaceBinding4 = this.j;
        if (fragmentAppSpaceBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAppSpaceBinding4 = null;
        }
        fragmentAppSpaceBinding4.e.setOnClickListener(new w0(this));
        FragmentAppSpaceBinding fragmentAppSpaceBinding5 = this.j;
        if (fragmentAppSpaceBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAppSpaceBinding5 = null;
        }
        fragmentAppSpaceBinding5.c.setOnClickListener(new x0(this));
        FragmentAppSpaceBinding fragmentAppSpaceBinding6 = this.j;
        if (fragmentAppSpaceBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAppSpaceBinding6 = null;
        }
        fragmentAppSpaceBinding6.g.setOnClickListener(new y0(this));
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            FragmentAppSpaceBinding fragmentAppSpaceBinding7 = this.j;
            if (fragmentAppSpaceBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAppSpaceBinding7 = null;
            }
            fragmentAppSpaceBinding7.o.setVisibility(8);
            FragmentAppSpaceBinding fragmentAppSpaceBinding8 = this.j;
            if (fragmentAppSpaceBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAppSpaceBinding8 = null;
            }
            fragmentAppSpaceBinding8.f.setVisibility(8);
            FragmentAppSpaceBinding fragmentAppSpaceBinding9 = this.j;
            if (fragmentAppSpaceBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentAppSpaceBinding2 = fragmentAppSpaceBinding9;
            }
            fragmentAppSpaceBinding2.k.setVisibility(8);
            return;
        }
        FragmentAppSpaceBinding fragmentAppSpaceBinding10 = this.j;
        if (fragmentAppSpaceBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAppSpaceBinding10 = null;
        }
        fragmentAppSpaceBinding10.f.setOnClickListener(new z0(this));
        FragmentAppSpaceBinding fragmentAppSpaceBinding11 = this.j;
        if (fragmentAppSpaceBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentAppSpaceBinding2 = fragmentAppSpaceBinding11;
        }
        fragmentAppSpaceBinding2.l.setOnClickListener(new a1(this));
    }

    @Keep
    @FastClickCheck
    private final void onClickNotifyCard() {
        JoinPoint makeJP = Factory.makeJP(o, this, this);
        Q0(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickTranslator() {
        JoinPoint makeJP = Factory.makeJP(l, this, this);
        S0(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickUnboundedScreen() {
        JoinPoint makeJP = Factory.makeJP(n, this, this);
        U0(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickVoiceManager() {
        JoinPoint makeJP = Factory.makeJP(m, this, this);
        W0(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    public void c(int i, Object obj) {
        if (i == 107) {
            startActivityForResult(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"), 300);
            SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_CLICK_REMIND_POP, new HashMap());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AppSpaceFragment", "onActivityResult::requestCode is: " + i + " and resultCode is: " + i2);
        if (i == 300) {
            PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (permissionAndStateCheckUtils.g(requireContext)) {
                StaticMethodUtilsKt.t(this, R.id.notifyFragment);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentAppSpaceBinding c = FragmentAppSpaceBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        return c.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }
}
