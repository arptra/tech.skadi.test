package com.upuphone.xr.sapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.honey.account.h8.d4;
import com.honey.account.h8.e4;
import com.honey.account.h8.f4;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.aspect.AspectHelper;
import com.upuphone.xr.sapp.aspect.ConnectCheckAspect;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentGlassPositionBinding;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import com.xjsd.ai.assistant.protocol.CmdCode;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001bH\u0003¢\u0006\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassPositionFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseConnectCheckFragment;", "<init>", "()V", "", "A0", "", "connect", "K0", "(Z)V", "initView", "D0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroyView", "", "it", "R0", "(Ljava/lang/Integer;)V", "type", "O0", "(I)V", "k", "Z", "isConnect", "Lcom/upuphone/xr/sapp/databinding/FragmentGlassPositionBinding;", "l", "Lcom/upuphone/xr/sapp/databinding/FragmentGlassPositionBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "m", "Lkotlin/Lazy;", "n0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "n", "C0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "o", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassPositionFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassPositionFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassPositionFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n*L\n1#1,132:1\n32#2,12:133\n32#2,12:145\n*S KotlinDebug\n*F\n+ 1 GlassPositionFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassPositionFragment\n*L\n29#1:133,12\n30#1:145,12\n*E\n"})
public final class GlassPositionFragment extends BaseConnectCheckFragment {
    public static final Companion o = new Companion((DefaultConstructorMarker) null);
    public static /* synthetic */ JoinPoint.StaticPart p;
    public boolean k = true;
    public FragmentGlassPositionBinding l;
    public final Lazy m;
    public final Lazy n;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassPositionFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public GlassPositionFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.m = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.n = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    private final void A0() {
        n0().E().observe(getViewLifecycleOwner(), new GlassPositionFragment$sam$androidx_lifecycle_Observer$0(new GlassPositionFragment$addObserve$1(this)));
        C0().L().observe(getViewLifecycleOwner(), new GlassPositionFragment$sam$androidx_lifecycle_Observer$0(new GlassPositionFragment$addObserve$2(this)));
    }

    private final DeviceControlModel C0() {
        return (DeviceControlModel) this.n.getValue();
    }

    private final void D0() {
        n0().F().removeObservers(getViewLifecycleOwner());
        C0().L().removeObservers(getViewLifecycleOwner());
    }

    private static /* synthetic */ void J0() {
        Factory factory = new Factory("GlassPositionFragment.kt", GlassPositionFragment.class);
        p = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onChangeToPosition", "com.upuphone.xr.sapp.fragment.GlassPositionFragment", "int", "type", "", "void"), (int) CmdCode.CODE_RESET_VAD_STATUS);
    }

    /* access modifiers changed from: private */
    public final void K0(boolean z) {
        this.k = z;
        FragmentGlassPositionBinding fragmentGlassPositionBinding = null;
        if (z) {
            FragmentGlassPositionBinding fragmentGlassPositionBinding2 = this.l;
            if (fragmentGlassPositionBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentGlassPositionBinding = fragmentGlassPositionBinding2;
            }
            fragmentGlassPositionBinding.i.setAlpha(1.0f);
            return;
        }
        FragmentGlassPositionBinding fragmentGlassPositionBinding3 = this.l;
        if (fragmentGlassPositionBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentGlassPositionBinding = fragmentGlassPositionBinding3;
        }
        fragmentGlassPositionBinding.i.setAlpha(0.5f);
    }

    public static final void L0(GlassPositionFragment glassPositionFragment, View view) {
        Intrinsics.checkNotNullParameter(glassPositionFragment, "this$0");
        FragmentKt.a(glassPositionFragment).T();
    }

    public static final void M0(GlassPositionFragment glassPositionFragment, View view) {
        Intrinsics.checkNotNullParameter(glassPositionFragment, "this$0");
        glassPositionFragment.O0(1);
    }

    public static final void N0(GlassPositionFragment glassPositionFragment, View view) {
        Intrinsics.checkNotNullParameter(glassPositionFragment, "this$0");
        glassPositionFragment.O0(0);
    }

    public static final /* synthetic */ void P0(GlassPositionFragment glassPositionFragment, int i, JoinPoint joinPoint) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassPositionFragment", "onChangeToPosition glassFovPosition = " + i);
        glassPositionFragment.R0(Integer.valueOf(i));
        SuperMessageManger.m.a().u0(i);
    }

    public static final /* synthetic */ void Q0(GlassPositionFragment glassPositionFragment, int i, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            P0(glassPositionFragment, i, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    private final void initView() {
        FragmentGlassPositionBinding fragmentGlassPositionBinding = this.l;
        FragmentGlassPositionBinding fragmentGlassPositionBinding2 = null;
        if (fragmentGlassPositionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPositionBinding = null;
        }
        fragmentGlassPositionBinding.b.setOnClickListener(new d4(this));
        FragmentGlassPositionBinding fragmentGlassPositionBinding3 = this.l;
        if (fragmentGlassPositionBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPositionBinding3 = null;
        }
        fragmentGlassPositionBinding3.c.setOnClickListener(new e4(this));
        FragmentGlassPositionBinding fragmentGlassPositionBinding4 = this.l;
        if (fragmentGlassPositionBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentGlassPositionBinding2 = fragmentGlassPositionBinding4;
        }
        fragmentGlassPositionBinding2.e.setOnClickListener(new f4(this));
    }

    public final void O0(int i) {
        JoinPoint makeJP = Factory.makeJP(p, (Object) this, (Object) this, Conversions.intObject(i));
        Q0(this, i, makeJP, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    public final void R0(Integer num) {
        FragmentGlassPositionBinding fragmentGlassPositionBinding = null;
        if (num != null && num.intValue() == 0) {
            FragmentGlassPositionBinding fragmentGlassPositionBinding2 = this.l;
            if (fragmentGlassPositionBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassPositionBinding2 = null;
            }
            fragmentGlassPositionBinding2.c.setBackground(requireContext().getDrawable(R.drawable.glass_position_bg_normal));
            FragmentGlassPositionBinding fragmentGlassPositionBinding3 = this.l;
            if (fragmentGlassPositionBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassPositionBinding3 = null;
            }
            fragmentGlassPositionBinding3.d.setTextColor(requireContext().getColor(R.color.secondary_text_color));
            FragmentGlassPositionBinding fragmentGlassPositionBinding4 = this.l;
            if (fragmentGlassPositionBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassPositionBinding4 = null;
            }
            fragmentGlassPositionBinding4.e.setBackground(requireContext().getDrawable(R.drawable.glass_position_bg_select));
            FragmentGlassPositionBinding fragmentGlassPositionBinding5 = this.l;
            if (fragmentGlassPositionBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentGlassPositionBinding = fragmentGlassPositionBinding5;
            }
            fragmentGlassPositionBinding.f.setTextColor(requireContext().getColor(R.color.primary_text_color));
            return;
        }
        FragmentGlassPositionBinding fragmentGlassPositionBinding6 = this.l;
        if (fragmentGlassPositionBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPositionBinding6 = null;
        }
        fragmentGlassPositionBinding6.e.setBackground(requireContext().getDrawable(R.drawable.glass_position_bg_normal));
        FragmentGlassPositionBinding fragmentGlassPositionBinding7 = this.l;
        if (fragmentGlassPositionBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPositionBinding7 = null;
        }
        fragmentGlassPositionBinding7.f.setTextColor(requireContext().getColor(R.color.secondary_text_color));
        FragmentGlassPositionBinding fragmentGlassPositionBinding8 = this.l;
        if (fragmentGlassPositionBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPositionBinding8 = null;
        }
        fragmentGlassPositionBinding8.c.setBackground(requireContext().getDrawable(R.drawable.glass_position_bg_select));
        FragmentGlassPositionBinding fragmentGlassPositionBinding9 = this.l;
        if (fragmentGlassPositionBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentGlassPositionBinding = fragmentGlassPositionBinding9;
        }
        fragmentGlassPositionBinding.d.setTextColor(requireContext().getColor(R.color.primary_text_color));
    }

    public final SuperViewModel n0() {
        return (SuperViewModel) this.m.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentGlassPositionBinding c = FragmentGlassPositionBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.l = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroyView() {
        super.onDestroyView();
        SuperMessageManger.m.a().n();
        ULog.f6446a.a("GlassPositionFragment", "onDestroyView");
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
        SuperMessageManger.m.a().n();
        ULog.f6446a.a("GlassPositionFragment", "onViewCreated");
    }
}
