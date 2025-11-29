package com.upuphone.xr.sapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.honey.account.h8.f2;
import com.honey.account.h8.g2;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.annotation.ConnectCheck;
import com.upuphone.xr.annotation.FastClickCheck;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.aspect.AspectHelper;
import com.upuphone.xr.sapp.aspect.ConnectCheckAspect;
import com.upuphone.xr.sapp.aspect.FastClickAspect;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentFactoryResetBinding;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.runtime.reflect.Factory;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\f\u0010\u0003J-\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\u001f\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u0003R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/FactoryResetFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseConnectCheckFragment;", "<init>", "()V", "", "A0", "D0", "", "connect", "I0", "(Z)V", "initView", "onClickFactoryResetItem", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "", "windowType", "actionType", "a", "(II)V", "B0", "Lcom/upuphone/xr/sapp/databinding/FragmentFactoryResetBinding;", "k", "Lcom/upuphone/xr/sapp/databinding/FragmentFactoryResetBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "l", "Lkotlin/Lazy;", "C0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "m", "Z", "isConnect", "n", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFactoryResetFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FactoryResetFragment.kt\ncom/upuphone/xr/sapp/fragment/FactoryResetFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n*L\n1#1,154:1\n32#2,12:155\n*S KotlinDebug\n*F\n+ 1 FactoryResetFragment.kt\ncom/upuphone/xr/sapp/fragment/FactoryResetFragment\n*L\n43#1:155,12\n*E\n"})
public final class FactoryResetFragment extends BaseConnectCheckFragment {
    public static final Companion n = new Companion((DefaultConstructorMarker) null);
    public static /* synthetic */ JoinPoint.StaticPart o;
    public FragmentFactoryResetBinding k;
    public final Lazy l;
    public boolean m = true;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/FactoryResetFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public FactoryResetFragment() {
        Class<DeviceControlModel> cls = DeviceControlModel.class;
        this.l = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    private final void A0() {
        C0().L().observe(getViewLifecycleOwner(), new FactoryResetFragment$sam$androidx_lifecycle_Observer$0(new FactoryResetFragment$addObserve$1(this)));
    }

    private final DeviceControlModel C0() {
        return (DeviceControlModel) this.l.getValue();
    }

    private final void D0() {
        C0().L().removeObservers(getViewLifecycleOwner());
    }

    private static /* synthetic */ void H0() {
        Factory factory = new Factory("FactoryResetFragment.kt", FactoryResetFragment.class);
        o = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickFactoryResetItem", "com.upuphone.xr.sapp.fragment.FactoryResetFragment", "", "", "", "void"), 101);
    }

    /* access modifiers changed from: private */
    public final void I0(boolean z) {
        this.m = z;
        FragmentFactoryResetBinding fragmentFactoryResetBinding = null;
        if (z) {
            FragmentFactoryResetBinding fragmentFactoryResetBinding2 = this.k;
            if (fragmentFactoryResetBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentFactoryResetBinding = fragmentFactoryResetBinding2;
            }
            fragmentFactoryResetBinding.f.setAlpha(1.0f);
            return;
        }
        FragmentFactoryResetBinding fragmentFactoryResetBinding3 = this.k;
        if (fragmentFactoryResetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentFactoryResetBinding = fragmentFactoryResetBinding3;
        }
        fragmentFactoryResetBinding.f.setAlpha(0.5f);
    }

    public static final void J0(FactoryResetFragment factoryResetFragment, View view) {
        Intrinsics.checkNotNullParameter(factoryResetFragment, "this$0");
        StaticMethodUtilsKt.q(factoryResetFragment);
    }

    public static final void K0(FactoryResetFragment factoryResetFragment, View view) {
        Intrinsics.checkNotNullParameter(factoryResetFragment, "this$0");
        factoryResetFragment.onClickFactoryResetItem();
    }

    public static final /* synthetic */ void L0(FactoryResetFragment factoryResetFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(factoryResetFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            StaticMethodUtilsKt.C(factoryResetFragment, CollectionsKt.arrayListOf(113), false, true);
        }
    }

    public static final /* synthetic */ void M0(FactoryResetFragment factoryResetFragment, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            L0(factoryResetFragment, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    public static final /* synthetic */ void O0(FactoryResetFragment factoryResetFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            M0(factoryResetFragment, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    private final void initView() {
        ULog.f6446a.a("FactoryResetFragment", "initView");
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        FragmentFactoryResetBinding fragmentFactoryResetBinding = null;
        if (bool.booleanValue()) {
            FragmentFactoryResetBinding fragmentFactoryResetBinding2 = this.k;
            if (fragmentFactoryResetBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentFactoryResetBinding2 = null;
            }
            fragmentFactoryResetBinding2.d.setText(getString(R.string.factory_reset_oversea_sub_title));
        }
        FragmentFactoryResetBinding fragmentFactoryResetBinding3 = this.k;
        if (fragmentFactoryResetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFactoryResetBinding3 = null;
        }
        fragmentFactoryResetBinding3.b.setOnClickListener(new f2(this));
        FragmentFactoryResetBinding fragmentFactoryResetBinding4 = this.k;
        if (fragmentFactoryResetBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentFactoryResetBinding = fragmentFactoryResetBinding4;
        }
        fragmentFactoryResetBinding.c.setOnClickListener(new g2(this));
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickFactoryResetItem() {
        JoinPoint makeJP = Factory.makeJP(o, this, this);
        O0(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    public void B0() {
        GenericWindowManger.c.a().j(113);
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        if (i == 113) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("FactoryResetFragment", "remove device result, actionType: " + i2);
            if (i2 == 1101) {
                ControlUtils controlUtils = ControlUtils.f7858a;
                String packageName = requireContext().getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                controlUtils.b(packageName, new FactoryResetFragment$buttonAction$1(this));
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentFactoryResetBinding c = FragmentFactoryResetBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.k = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        return c.getRoot();
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
