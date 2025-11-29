package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.honey.account.h8.a3;
import com.honey.account.h8.b3;
import com.honey.account.h8.y2;
import com.honey.account.h8.z2;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentGlassInfoBinding;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J+\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008BX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassInfoFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "H0", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroyView", "O0", "Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "deviceInfo", "P0", "(Lcom/upuphone/xr/sapp/entity/DeviceInfo;)V", "Lkotlin/Function0;", "func", "M0", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentGlassInfoBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentGlassInfoBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "k", "Lkotlin/Lazy;", "n0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Landroid/os/Handler;", "l", "Landroid/os/Handler;", "handler", "", "m", "I", "clickCount", "", "L0", "()Z", "isAirPro", "n", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassInfoFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassInfoFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassInfoFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n*L\n1#1,179:1\n32#2,12:180\n*S KotlinDebug\n*F\n+ 1 GlassInfoFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassInfoFragment\n*L\n35#1:180,12\n*E\n"})
public final class GlassInfoFragment extends BaseFragment {
    public static final Companion n = new Companion((DefaultConstructorMarker) null);
    public FragmentGlassInfoBinding j;
    public final Lazy k;
    public final Handler l = new Handler(Looper.getMainLooper());
    public int m;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassInfoFragment$Companion;", "", "()V", "MAX_CLICK_COUNT", "", "MAX_DELAY_TIME", "", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public GlassInfoFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.k = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    private final void H0() {
        n0().v().observe(getViewLifecycleOwner(), new GlassInfoFragment$sam$androidx_lifecycle_Observer$0(new GlassInfoFragment$addObserve$1(this)));
    }

    public static final void I0(GlassInfoFragment glassInfoFragment, View view) {
        Intrinsics.checkNotNullParameter(glassInfoFragment, "this$0");
        FragmentKt.a(glassInfoFragment).T();
    }

    public static final void J0(GlassInfoFragment glassInfoFragment, View view) {
        Intrinsics.checkNotNullParameter(glassInfoFragment, "this$0");
        if (glassInfoFragment.L0()) {
            int i = glassInfoFragment.m;
            if (i == 5) {
                ULog.f6446a.g("AboutGlassFragment", "romVersionLayout has max count");
                glassInfoFragment.m = 0;
                glassInfoFragment.l.removeCallbacksAndMessages((Object) null);
                glassInfoFragment.O0();
                return;
            }
            if (i == 0) {
                glassInfoFragment.l.postDelayed(new b3(glassInfoFragment), 5000);
            }
            int i2 = glassInfoFragment.m + 1;
            glassInfoFragment.m = i2;
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("AboutGlassFragment", "romVersionLayout clickCount = " + i2);
        }
    }

    public static final void K0(GlassInfoFragment glassInfoFragment) {
        Intrinsics.checkNotNullParameter(glassInfoFragment, "this$0");
        glassInfoFragment.m = 0;
    }

    public static final void N0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$func");
        function0.invoke();
    }

    private final void initView() {
        Context context;
        String packageName;
        if (!(!L0() || (context = getContext()) == null || (packageName = context.getPackageName()) == null)) {
            ControlUtils.f7858a.I(packageName);
        }
        ULog.f6446a.a("AboutGlassFragment", "initView");
        FragmentGlassInfoBinding fragmentGlassInfoBinding = this.j;
        FragmentGlassInfoBinding fragmentGlassInfoBinding2 = null;
        if (fragmentGlassInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassInfoBinding = null;
        }
        fragmentGlassInfoBinding.d.setOnClickListener(new y2(this));
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            FragmentGlassInfoBinding fragmentGlassInfoBinding3 = this.j;
            if (fragmentGlassInfoBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassInfoBinding3 = null;
            }
            fragmentGlassInfoBinding3.n.setVisibility(8);
            FragmentGlassInfoBinding fragmentGlassInfoBinding4 = this.j;
            if (fragmentGlassInfoBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassInfoBinding4 = null;
            }
            fragmentGlassInfoBinding4.q.setVisibility(8);
            FragmentGlassInfoBinding fragmentGlassInfoBinding5 = this.j;
            if (fragmentGlassInfoBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassInfoBinding5 = null;
            }
            fragmentGlassInfoBinding5.r.setVisibility(8);
        }
        FragmentGlassInfoBinding fragmentGlassInfoBinding6 = this.j;
        if (fragmentGlassInfoBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentGlassInfoBinding2 = fragmentGlassInfoBinding6;
        }
        fragmentGlassInfoBinding2.i.setOnClickListener(new z2(this));
    }

    /* access modifiers changed from: private */
    public final SuperViewModel n0() {
        return (SuperViewModel) this.k.getValue();
    }

    public final boolean L0() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().isAirPro();
    }

    public final void M0(Function0 function0) {
        if (!Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
            new Handler(Looper.getMainLooper()).post(new a3(function0));
        } else {
            function0.invoke();
        }
    }

    public final void O0() {
        String packageName;
        Context context = getContext();
        if (context != null && (packageName = context.getPackageName()) != null) {
            Boolean bool = (Boolean) n0().A().getValue();
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            boolean z = !bool.booleanValue();
            ULog.f6446a.g("AboutGlassFragment", "upDateDemoMode glassDebugMode = " + z);
            ControlUtils.f7858a.S(packageName, z, new GlassInfoFragment$upDateDemoMode$1$1(this, z));
        }
    }

    public final void P0(DeviceInfo deviceInfo) {
        FragmentGlassInfoBinding fragmentGlassInfoBinding = this.j;
        FragmentGlassInfoBinding fragmentGlassInfoBinding2 = null;
        if (fragmentGlassInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassInfoBinding = null;
        }
        fragmentGlassInfoBinding.g.setText(deviceInfo.getModel());
        FragmentGlassInfoBinding fragmentGlassInfoBinding3 = this.j;
        if (fragmentGlassInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassInfoBinding3 = null;
        }
        fragmentGlassInfoBinding3.c.setText(deviceInfo.getBtAddr());
        FragmentGlassInfoBinding fragmentGlassInfoBinding4 = this.j;
        if (fragmentGlassInfoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassInfoBinding4 = null;
        }
        fragmentGlassInfoBinding4.r.setText(deviceInfo.getWifiMac());
        FragmentGlassInfoBinding fragmentGlassInfoBinding5 = this.j;
        if (fragmentGlassInfoBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassInfoBinding5 = null;
        }
        fragmentGlassInfoBinding5.l.setText(deviceInfo.getSerialNo());
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getResources().getString(R.string.storage_used);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{deviceInfo.getUsedStorageTx()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        FragmentGlassInfoBinding fragmentGlassInfoBinding6 = this.j;
        if (fragmentGlassInfoBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassInfoBinding6 = null;
        }
        fragmentGlassInfoBinding6.p.setText(format);
        FragmentGlassInfoBinding fragmentGlassInfoBinding7 = this.j;
        if (fragmentGlassInfoBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassInfoBinding7 = null;
        }
        fragmentGlassInfoBinding7.o.setProgress(deviceInfo.getProgress());
        FragmentGlassInfoBinding fragmentGlassInfoBinding8 = this.j;
        if (fragmentGlassInfoBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentGlassInfoBinding2 = fragmentGlassInfoBinding8;
        }
        fragmentGlassInfoBinding2.j.setText(deviceInfo.getRomVersion());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentGlassInfoBinding c = FragmentGlassInfoBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        LinearLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.l.removeCallbacksAndMessages((Object) null);
    }

    public void onResume() {
        super.onResume();
        ControlUtils controlUtils = ControlUtils.f7858a;
        String packageName = requireContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        controlUtils.h(packageName);
        H0();
        P0(controlUtils.g());
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }
}
