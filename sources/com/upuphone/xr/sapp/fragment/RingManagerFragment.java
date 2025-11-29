package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Keep;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.honey.account.h8.r8;
import com.honey.account.h8.s8;
import com.meizu.common.widget.MzContactsContract;
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
import com.upuphone.xr.sapp.databinding.FragmentRingManagerBinding;
import com.upuphone.xr.sapp.entity.UnicronBatteryInfo;
import com.upuphone.xr.sapp.entity.UnicronInfo;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;
import com.upuphone.xr.sapp.unicron.UnicronUpdateHelper;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
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

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 62\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J-\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0003J\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\u0003R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010+\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u00100\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00102¨\u00068"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/RingManagerFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "U0", "I0", "", "connect", "K0", "(Z)V", "onClickRingName", "M0", "T0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "windowType", "actionType", "a", "(II)V", "onDestroyView", "Lcom/upuphone/xr/sapp/databinding/FragmentRingManagerBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentRingManagerBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "k", "Lkotlin/Lazy;", "n0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "l", "L0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "m", "Z", "isGlassCconnect", "n", "isRingCconnect", "o", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nRingManagerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RingManagerFragment.kt\ncom/upuphone/xr/sapp/fragment/RingManagerFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n*L\n1#1,209:1\n32#2,12:210\n32#2,12:222\n*S KotlinDebug\n*F\n+ 1 RingManagerFragment.kt\ncom/upuphone/xr/sapp/fragment/RingManagerFragment\n*L\n39#1:210,12\n40#1:222,12\n*E\n"})
public final class RingManagerFragment extends BaseFragment {
    public static final Companion o = new Companion((DefaultConstructorMarker) null);
    public static /* synthetic */ JoinPoint.StaticPart p;
    public FragmentRingManagerBinding j;
    public final Lazy k;
    public final Lazy l;
    public boolean m = true;
    public boolean n = true;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/RingManagerFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        J0();
    }

    public RingManagerFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.k = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.l = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    private final void I0() {
        L0().L().observe(getViewLifecycleOwner(), new RingManagerFragment$sam$androidx_lifecycle_Observer$0(new RingManagerFragment$addObserve$1(this)));
        n0().K0().observe(getViewLifecycleOwner(), new RingManagerFragment$sam$androidx_lifecycle_Observer$0(new RingManagerFragment$addObserve$2(this)));
        n0().L0().observe(getViewLifecycleOwner(), new RingManagerFragment$sam$androidx_lifecycle_Observer$0(new RingManagerFragment$addObserve$3(this)));
    }

    private static /* synthetic */ void J0() {
        Factory factory = new Factory("RingManagerFragment.kt", RingManagerFragment.class);
        p = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickRingName", "com.upuphone.xr.sapp.fragment.RingManagerFragment", "", "", "", "void"), 147);
    }

    /* access modifiers changed from: private */
    public final void K0(boolean z) {
        if (!z) {
            GenericWindowManger.c.a().j(MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_TOKENS);
        }
    }

    private final DeviceControlModel L0() {
        return (DeviceControlModel) this.l.getValue();
    }

    private final void M0() {
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView(...)");
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(requireView.getWindowToken(), 2);
    }

    public static final void N0(RingManagerFragment ringManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(ringManagerFragment, "this$0");
        StaticMethodUtilsKt.q(ringManagerFragment);
    }

    public static final void O0(RingManagerFragment ringManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(ringManagerFragment, "this$0");
        ringManagerFragment.onClickRingName();
    }

    public static final /* synthetic */ void P0(RingManagerFragment ringManagerFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(ringManagerFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            if (!ringManagerFragment.m) {
                UToast.Companion companion = UToast.f6444a;
                Context requireContext = ringManagerFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                String string = ringManagerFragment.getString(R.string.device_disconnect);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                companion.d(requireContext, string);
            } else if (!ringManagerFragment.n) {
                UToast.Companion companion2 = UToast.f6444a;
                Context requireContext2 = ringManagerFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                String string2 = ringManagerFragment.getString(R.string.ring_disconnect);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                companion2.d(requireContext2, string2);
            } else {
                Bundle bundle = new Bundle();
                bundle.putInt("gravity", 17);
                StaticMethodUtilsKt.D(ringManagerFragment, CollectionsKt.arrayListOf(Integer.valueOf(MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_TOKENS)), false, false, bundle);
            }
        }
    }

    public static final /* synthetic */ void Q0(RingManagerFragment ringManagerFragment, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            P0(ringManagerFragment, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    public static final /* synthetic */ void S0(RingManagerFragment ringManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            Q0(ringManagerFragment, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    private final void T0() {
        L0().L().removeObservers(getViewLifecycleOwner());
        n0().K0().removeObservers(getViewLifecycleOwner());
        n0().L0().removeObservers(getViewLifecycleOwner());
    }

    private final void U0() {
        ControlUtils controlUtils = ControlUtils.f7858a;
        UnicronBatteryInfo m2 = controlUtils.m();
        UnicronInfo n2 = controlUtils.n();
        ULog.f6446a.a("RingManagerFragment", "updateUI() batteryInfo=" + m2 + ", info=" + n2);
        FragmentRingManagerBinding fragmentRingManagerBinding = this.j;
        FragmentRingManagerBinding fragmentRingManagerBinding2 = null;
        if (fragmentRingManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentRingManagerBinding = null;
        }
        fragmentRingManagerBinding.m.setText(m2.getDevName());
        FragmentRingManagerBinding fragmentRingManagerBinding3 = this.j;
        if (fragmentRingManagerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentRingManagerBinding3 = null;
        }
        fragmentRingManagerBinding3.f.setText(m2.getBluetooth());
        FragmentRingManagerBinding fragmentRingManagerBinding4 = this.j;
        if (fragmentRingManagerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentRingManagerBinding4 = null;
        }
        fragmentRingManagerBinding4.d.setChecked(m2.getMouseState());
        FragmentRingManagerBinding fragmentRingManagerBinding5 = this.j;
        if (fragmentRingManagerBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentRingManagerBinding5 = null;
        }
        fragmentRingManagerBinding5.i.setText(n2.getModel());
        FragmentRingManagerBinding fragmentRingManagerBinding6 = this.j;
        if (fragmentRingManagerBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentRingManagerBinding6 = null;
        }
        fragmentRingManagerBinding6.p.setText(n2.getVersion());
        FragmentRingManagerBinding fragmentRingManagerBinding7 = this.j;
        if (fragmentRingManagerBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentRingManagerBinding2 = fragmentRingManagerBinding7;
        }
        fragmentRingManagerBinding2.n.setText(n2.getSn());
    }

    private final void initView() {
        FragmentRingManagerBinding fragmentRingManagerBinding = this.j;
        FragmentRingManagerBinding fragmentRingManagerBinding2 = null;
        if (fragmentRingManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentRingManagerBinding = null;
        }
        fragmentRingManagerBinding.g.setOnClickListener(new r8(this));
        FragmentRingManagerBinding fragmentRingManagerBinding3 = this.j;
        if (fragmentRingManagerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentRingManagerBinding2 = fragmentRingManagerBinding3;
        }
        fragmentRingManagerBinding2.l.setOnClickListener(new s8(this));
        U0();
    }

    private final SuperViewModel n0() {
        return (SuperViewModel) this.k.getValue();
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickRingName() {
        JoinPoint makeJP = Factory.makeJP(p, this, this);
        S0(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        if (i == 10001) {
            M0();
            if (i2 == 1101) {
                ControlUtils controlUtils = ControlUtils.f7858a;
                String packageName = requireContext().getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                controlUtils.b0(packageName);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentRingManagerBinding c = FragmentRingManagerBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        return c.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        T0();
    }

    public void onResume() {
        super.onResume();
        ControlUtils controlUtils = ControlUtils.f7858a;
        String packageName = requireContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        controlUtils.z(packageName);
        UnicronUpdateHelper.b.I();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        boolean z = false;
        this.n = arguments != null ? arguments.getBoolean("ring_connect_state") : false;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            z = arguments2.getBoolean("glass_connect_state");
        }
        this.m = z;
        initView();
        I0();
    }
}
