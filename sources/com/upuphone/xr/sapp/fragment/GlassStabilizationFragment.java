package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.honey.account.h8.k4;
import com.honey.account.h8.l4;
import com.honey.account.h8.m4;
import com.meizu.common.app.LoadingDialog;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentGlassStabilizationBinding;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0003R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassStabilizationFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "J0", "N0", "initView", "showLoading", "", "connect", "H0", "(Z)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroyView", "O0", "Lcom/upuphone/xr/sapp/databinding/FragmentGlassStabilizationBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentGlassStabilizationBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "k", "Lkotlin/Lazy;", "n0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "l", "I0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "m", "Z", "isConnect", "Lcom/meizu/common/app/LoadingDialog;", "n", "Lcom/meizu/common/app/LoadingDialog;", "loading", "o", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassStabilizationFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassStabilizationFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassStabilizationFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n*L\n1#1,183:1\n32#2,12:184\n32#2,12:196\n*S KotlinDebug\n*F\n+ 1 GlassStabilizationFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassStabilizationFragment\n*L\n38#1:184,12\n39#1:196,12\n*E\n"})
public final class GlassStabilizationFragment extends BaseFragment {
    public static final Companion o = new Companion((DefaultConstructorMarker) null);
    public FragmentGlassStabilizationBinding j;
    public final Lazy k;
    public final Lazy l;
    public boolean m = true;
    public LoadingDialog n;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassStabilizationFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public GlassStabilizationFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.k = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.l = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    /* access modifiers changed from: private */
    public final void H0(boolean z) {
        this.m = z;
        FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding = null;
        if (z) {
            FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding2 = this.j;
            if (fragmentGlassStabilizationBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentGlassStabilizationBinding = fragmentGlassStabilizationBinding2;
            }
            fragmentGlassStabilizationBinding.e.setAlpha(1.0f);
            return;
        }
        FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding3 = this.j;
        if (fragmentGlassStabilizationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentGlassStabilizationBinding = fragmentGlassStabilizationBinding3;
        }
        fragmentGlassStabilizationBinding.e.setAlpha(0.5f);
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string = getString(R.string.switch_language_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(requireContext, string);
    }

    private final DeviceControlModel I0() {
        return (DeviceControlModel) this.l.getValue();
    }

    private final void J0() {
        n0().O().observe(getViewLifecycleOwner(), new GlassStabilizationFragment$sam$androidx_lifecycle_Observer$0(new GlassStabilizationFragment$initObserve$1(this)));
        I0().L().observe(getViewLifecycleOwner(), new GlassStabilizationFragment$sam$androidx_lifecycle_Observer$0(new GlassStabilizationFragment$initObserve$2(this)));
    }

    public static final void K0(GlassStabilizationFragment glassStabilizationFragment, View view) {
        Intrinsics.checkNotNullParameter(glassStabilizationFragment, "this$0");
        StaticMethodUtilsKt.q(glassStabilizationFragment);
    }

    public static final void L0(GlassStabilizationFragment glassStabilizationFragment, View view) {
        Intrinsics.checkNotNullParameter(glassStabilizationFragment, "this$0");
        if (glassStabilizationFragment.m) {
            FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding = glassStabilizationFragment.j;
            FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding2 = null;
            if (fragmentGlassStabilizationBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassStabilizationBinding = null;
            }
            boolean isChecked = fragmentGlassStabilizationBinding.c.getBinding().i.isChecked();
            FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding3 = glassStabilizationFragment.j;
            if (fragmentGlassStabilizationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassStabilizationBinding3 = null;
            }
            fragmentGlassStabilizationBinding3.c.getBinding().i.setChecked(!isChecked);
            if (!isChecked) {
                FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding4 = glassStabilizationFragment.j;
                if (fragmentGlassStabilizationBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentGlassStabilizationBinding4 = null;
                }
                fragmentGlassStabilizationBinding4.d.getBinding().i.setChecked(true);
                FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding5 = glassStabilizationFragment.j;
                if (fragmentGlassStabilizationBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentGlassStabilizationBinding2 = fragmentGlassStabilizationBinding5;
                }
                fragmentGlassStabilizationBinding2.d.getBinding().i.setEnabled(false);
            } else {
                FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding6 = glassStabilizationFragment.j;
                if (fragmentGlassStabilizationBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentGlassStabilizationBinding2 = fragmentGlassStabilizationBinding6;
                }
                fragmentGlassStabilizationBinding2.d.getBinding().i.setEnabled(true);
            }
            DataTrackUtil.f7875a.i("anti_shake", MapsKt.hashMapOf(TuplesKt.to("status", String.valueOf(!isChecked))));
            glassStabilizationFragment.O0();
        }
    }

    public static final void M0(GlassStabilizationFragment glassStabilizationFragment, View view) {
        Intrinsics.checkNotNullParameter(glassStabilizationFragment, "this$0");
        if (glassStabilizationFragment.m) {
            FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding = glassStabilizationFragment.j;
            FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding2 = null;
            if (fragmentGlassStabilizationBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassStabilizationBinding = null;
            }
            if (!fragmentGlassStabilizationBinding.d.getBinding().i.isEnabled()) {
                ULog.f6446a.c("GlassStabilizationFragment", "pageStabilizationNav return");
                return;
            }
            FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding3 = glassStabilizationFragment.j;
            if (fragmentGlassStabilizationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassStabilizationBinding3 = null;
            }
            boolean isChecked = fragmentGlassStabilizationBinding3.d.getBinding().i.isChecked();
            FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding4 = glassStabilizationFragment.j;
            if (fragmentGlassStabilizationBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentGlassStabilizationBinding2 = fragmentGlassStabilizationBinding4;
            }
            fragmentGlassStabilizationBinding2.d.getBinding().i.setChecked(!isChecked);
            glassStabilizationFragment.O0();
        }
    }

    private final void N0() {
        n0().O().removeObservers(getViewLifecycleOwner());
        I0().L().removeObservers(getViewLifecycleOwner());
    }

    private final void initView() {
        FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding = this.j;
        FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding2 = null;
        if (fragmentGlassStabilizationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassStabilizationBinding = null;
        }
        fragmentGlassStabilizationBinding.b.setOnClickListener(new k4(this));
        FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding3 = this.j;
        if (fragmentGlassStabilizationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassStabilizationBinding3 = null;
        }
        fragmentGlassStabilizationBinding3.d.getBinding().i.setClickable(false);
        FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding4 = this.j;
        if (fragmentGlassStabilizationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassStabilizationBinding4 = null;
        }
        fragmentGlassStabilizationBinding4.c.getBinding().i.setClickable(false);
        FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding5 = this.j;
        if (fragmentGlassStabilizationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassStabilizationBinding5 = null;
        }
        fragmentGlassStabilizationBinding5.c.setOnClickListener(new l4(this));
        FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding6 = this.j;
        if (fragmentGlassStabilizationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentGlassStabilizationBinding2 = fragmentGlassStabilizationBinding6;
        }
        fragmentGlassStabilizationBinding2.d.setOnClickListener(new m4(this));
    }

    private final SuperViewModel n0() {
        return (SuperViewModel) this.k.getValue();
    }

    /* access modifiers changed from: private */
    public final void showLoading() {
        if (this.n == null) {
            LoadingDialog loadingDialog = new LoadingDialog(requireContext());
            this.n = loadingDialog;
            loadingDialog.setMessage((CharSequence) getString(R.string.font_size_loading));
            LoadingDialog loadingDialog2 = this.n;
            if (loadingDialog2 != null) {
                loadingDialog2.setCancelable(false);
            }
        }
        LoadingDialog loadingDialog3 = this.n;
        if (loadingDialog3 != null) {
            loadingDialog3.show();
        }
    }

    public final void O0() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new GlassStabilizationFragment$saveConfig$1(this, (Continuation<? super GlassStabilizationFragment$saveConfig$1>) null), 3, (Object) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentGlassStabilizationBinding c = FragmentGlassStabilizationBinding.c(layoutInflater, viewGroup, false);
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

    public void onDestroyView() {
        super.onDestroyView();
        LoadingDialog loadingDialog = this.n;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

    public void onPause() {
        super.onPause();
        N0();
    }

    public void onResume() {
        super.onResume();
        J0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }
}
