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
import com.honey.account.h8.g4;
import com.honey.account.h8.h4;
import com.honey.account.h8.i4;
import com.honey.account.h8.j4;
import com.meizu.common.app.LoadingDialog;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentGlassPowerActionBinding;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 62\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0003J\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassPowerActionFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "L0", "Q0", "", "connect", "J0", "(Z)V", "showLoading", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "onResume", "onPause", "", "appPackage", "I0", "(Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentGlassPowerActionBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentGlassPowerActionBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "k", "Lkotlin/Lazy;", "n0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "l", "K0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "Lcom/meizu/common/app/LoadingDialog;", "m", "Lcom/meizu/common/app/LoadingDialog;", "loading", "n", "Z", "isConnect", "o", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassPowerActionFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassPowerActionFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassPowerActionFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n*L\n1#1,182:1\n32#2,12:183\n32#2,12:195\n*S KotlinDebug\n*F\n+ 1 GlassPowerActionFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassPowerActionFragment\n*L\n36#1:183,12\n37#1:195,12\n*E\n"})
public final class GlassPowerActionFragment extends BaseFragment {
    public static final Companion o = new Companion((DefaultConstructorMarker) null);
    public FragmentGlassPowerActionBinding j;
    public final Lazy k;
    public final Lazy l;
    public LoadingDialog m;
    public boolean n = true;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassPowerActionFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public GlassPowerActionFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.k = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.l = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    /* access modifiers changed from: private */
    public final void J0(boolean z) {
        this.n = z;
        FragmentGlassPowerActionBinding fragmentGlassPowerActionBinding = null;
        if (z) {
            FragmentGlassPowerActionBinding fragmentGlassPowerActionBinding2 = this.j;
            if (fragmentGlassPowerActionBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentGlassPowerActionBinding = fragmentGlassPowerActionBinding2;
            }
            fragmentGlassPowerActionBinding.g.setAlpha(1.0f);
            return;
        }
        FragmentGlassPowerActionBinding fragmentGlassPowerActionBinding3 = this.j;
        if (fragmentGlassPowerActionBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentGlassPowerActionBinding = fragmentGlassPowerActionBinding3;
        }
        fragmentGlassPowerActionBinding.g.setAlpha(0.5f);
        LoadingDialog loadingDialog = this.m;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string = getString(R.string.switch_language_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(requireContext, string);
    }

    private final DeviceControlModel K0() {
        return (DeviceControlModel) this.l.getValue();
    }

    private final void L0() {
        n0().B().observe(getViewLifecycleOwner(), new GlassPowerActionFragment$sam$androidx_lifecycle_Observer$0(new GlassPowerActionFragment$initObserve$1(this)));
        K0().L().observe(getViewLifecycleOwner(), new GlassPowerActionFragment$sam$androidx_lifecycle_Observer$0(new GlassPowerActionFragment$initObserve$2(this)));
    }

    public static final void M0(GlassPowerActionFragment glassPowerActionFragment, View view) {
        Intrinsics.checkNotNullParameter(glassPowerActionFragment, "this$0");
        StaticMethodUtilsKt.q(glassPowerActionFragment);
    }

    public static final void N0(GlassPowerActionFragment glassPowerActionFragment, View view) {
        Intrinsics.checkNotNullParameter(glassPowerActionFragment, "this$0");
        if (!glassPowerActionFragment.n) {
            UToast.Companion companion = UToast.f6444a;
            Context requireContext = glassPowerActionFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            String string = glassPowerActionFragment.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(requireContext, string);
            return;
        }
        glassPowerActionFragment.I0("com.upuphone.ar.recorder");
    }

    public static final void O0(GlassPowerActionFragment glassPowerActionFragment, View view) {
        Intrinsics.checkNotNullParameter(glassPowerActionFragment, "this$0");
        if (!glassPowerActionFragment.n) {
            UToast.Companion companion = UToast.f6444a;
            Context requireContext = glassPowerActionFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            String string = glassPowerActionFragment.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(requireContext, string);
            return;
        }
        glassPowerActionFragment.I0(AssistantConstants.PKG_NAME_TRANSLATION);
    }

    public static final void P0(GlassPowerActionFragment glassPowerActionFragment, View view) {
        Intrinsics.checkNotNullParameter(glassPowerActionFragment, "this$0");
        if (!glassPowerActionFragment.n) {
            UToast.Companion companion = UToast.f6444a;
            Context requireContext = glassPowerActionFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            String string = glassPowerActionFragment.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(requireContext, string);
            return;
        }
        glassPowerActionFragment.I0("com.upuphone.ar.transcribe.glasses");
    }

    private final void Q0() {
        n0().B().removeObservers(getViewLifecycleOwner());
        K0().L().removeObservers(getViewLifecycleOwner());
    }

    private final void initView() {
        FragmentGlassPowerActionBinding fragmentGlassPowerActionBinding = this.j;
        FragmentGlassPowerActionBinding fragmentGlassPowerActionBinding2 = null;
        if (fragmentGlassPowerActionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPowerActionBinding = null;
        }
        fragmentGlassPowerActionBinding.b.setOnClickListener(new g4(this));
        FragmentGlassPowerActionBinding fragmentGlassPowerActionBinding3 = this.j;
        if (fragmentGlassPowerActionBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPowerActionBinding3 = null;
        }
        fragmentGlassPowerActionBinding3.c.setOnClickListener(new h4(this));
        FragmentGlassPowerActionBinding fragmentGlassPowerActionBinding4 = this.j;
        if (fragmentGlassPowerActionBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPowerActionBinding4 = null;
        }
        fragmentGlassPowerActionBinding4.e.setOnClickListener(new i4(this));
        FragmentGlassPowerActionBinding fragmentGlassPowerActionBinding5 = this.j;
        if (fragmentGlassPowerActionBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentGlassPowerActionBinding2 = fragmentGlassPowerActionBinding5;
        }
        fragmentGlassPowerActionBinding2.f.setOnClickListener(new j4(this));
    }

    private final SuperViewModel n0() {
        return (SuperViewModel) this.k.getValue();
    }

    /* access modifiers changed from: private */
    public final void showLoading() {
        if (this.m == null) {
            LoadingDialog loadingDialog = new LoadingDialog(requireContext());
            this.m = loadingDialog;
            loadingDialog.setMessage((CharSequence) getString(R.string.font_size_loading));
            LoadingDialog loadingDialog2 = this.m;
            if (loadingDialog2 != null) {
                loadingDialog2.setCancelable(false);
            }
        }
        LoadingDialog loadingDialog3 = this.m;
        if (loadingDialog3 != null) {
            loadingDialog3.show();
        }
    }

    public final void I0(String str) {
        if (Intrinsics.areEqual(n0().B().getValue(), (Object) str)) {
            ULog.f6446a.a("GlassPowerActionFragment", "appPackage same return");
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new GlassPowerActionFragment$changePowerAction$1(this, str, (Continuation<? super GlassPowerActionFragment$changePowerAction$1>) null), 3, (Object) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentGlassPowerActionBinding c = FragmentGlassPowerActionBinding.c(layoutInflater, viewGroup, false);
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
        LoadingDialog loadingDialog = this.m;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

    public void onPause() {
        super.onPause();
        Q0();
    }

    public void onResume() {
        super.onResume();
        L0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }
}
