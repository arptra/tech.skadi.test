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
import com.honey.account.h8.t2;
import com.honey.account.h8.u2;
import com.honey.account.h8.v2;
import com.meizu.common.app.LoadingDialog;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentFontSizeBinding;
import com.upuphone.xr.sapp.entity.GlassFontSize;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
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

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 62\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/FontSizeFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "N0", "initView", "", "connect", "H0", "(Z)V", "showLoading", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onDestroyView", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "J0", "Lcom/upuphone/xr/sapp/entity/GlassFontSize;", "selectFont", "O0", "(Lcom/upuphone/xr/sapp/entity/GlassFontSize;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentFontSizeBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentFontSizeBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "k", "Lkotlin/Lazy;", "n0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "l", "I0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "Lcom/meizu/common/app/LoadingDialog;", "m", "Lcom/meizu/common/app/LoadingDialog;", "loading", "n", "Z", "isConnect", "o", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFontSizeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontSizeFragment.kt\ncom/upuphone/xr/sapp/fragment/FontSizeFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n*L\n1#1,182:1\n32#2,12:183\n32#2,12:195\n*S KotlinDebug\n*F\n+ 1 FontSizeFragment.kt\ncom/upuphone/xr/sapp/fragment/FontSizeFragment\n*L\n37#1:183,12\n38#1:195,12\n*E\n"})
public final class FontSizeFragment extends BaseFragment {
    public static final Companion o = new Companion((DefaultConstructorMarker) null);
    public FragmentFontSizeBinding j;
    public final Lazy k;
    public final Lazy l;
    public LoadingDialog m;
    public boolean n = true;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/FontSizeFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public FontSizeFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.k = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.l = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    /* access modifiers changed from: private */
    public final void H0(boolean z) {
        this.n = z;
        FragmentFontSizeBinding fragmentFontSizeBinding = null;
        if (z) {
            FragmentFontSizeBinding fragmentFontSizeBinding2 = this.j;
            if (fragmentFontSizeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentFontSizeBinding = fragmentFontSizeBinding2;
            }
            fragmentFontSizeBinding.f.setAlpha(1.0f);
            return;
        }
        FragmentFontSizeBinding fragmentFontSizeBinding3 = this.j;
        if (fragmentFontSizeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentFontSizeBinding = fragmentFontSizeBinding3;
        }
        fragmentFontSizeBinding.f.setAlpha(0.5f);
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

    private final DeviceControlModel I0() {
        return (DeviceControlModel) this.l.getValue();
    }

    public static final void K0(FontSizeFragment fontSizeFragment, View view) {
        Intrinsics.checkNotNullParameter(fontSizeFragment, "this$0");
        StaticMethodUtilsKt.q(fontSizeFragment);
    }

    public static final void L0(FontSizeFragment fontSizeFragment, View view) {
        Intrinsics.checkNotNullParameter(fontSizeFragment, "this$0");
        fontSizeFragment.O0(GlassFontSize.BIG);
    }

    public static final void M0(FontSizeFragment fontSizeFragment, View view) {
        Intrinsics.checkNotNullParameter(fontSizeFragment, "this$0");
        fontSizeFragment.O0(GlassFontSize.NORMAL);
    }

    private final void N0() {
        n0().O().removeObservers(getViewLifecycleOwner());
        I0().L().removeObservers(getViewLifecycleOwner());
    }

    private final void initView() {
        n0().D().observe(getViewLifecycleOwner(), new FontSizeFragment$sam$androidx_lifecycle_Observer$0(new FontSizeFragment$initView$1(this)));
        FragmentFontSizeBinding fragmentFontSizeBinding = this.j;
        FragmentFontSizeBinding fragmentFontSizeBinding2 = null;
        if (fragmentFontSizeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFontSizeBinding = null;
        }
        fragmentFontSizeBinding.b.setOnClickListener(new t2(this));
        FragmentFontSizeBinding fragmentFontSizeBinding3 = this.j;
        if (fragmentFontSizeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentFontSizeBinding3 = null;
        }
        fragmentFontSizeBinding3.c.setOnClickListener(new u2(this));
        FragmentFontSizeBinding fragmentFontSizeBinding4 = this.j;
        if (fragmentFontSizeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentFontSizeBinding2 = fragmentFontSizeBinding4;
        }
        fragmentFontSizeBinding2.d.setOnClickListener(new v2(this));
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

    public final void J0() {
        n0().D().observe(getViewLifecycleOwner(), new FontSizeFragment$sam$androidx_lifecycle_Observer$0(new FontSizeFragment$initObserve$1(this)));
        I0().L().observe(getViewLifecycleOwner(), new FontSizeFragment$sam$androidx_lifecycle_Observer$0(new FontSizeFragment$initObserve$2(this)));
    }

    public final void O0(GlassFontSize glassFontSize) {
        if (n0().D().getValue() == glassFontSize) {
            ULog.f6446a.a("FountSizeFragment", "showToggleHint same return");
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new FontSizeFragment$showToggleHint$1(this, glassFontSize, (Continuation<? super FontSizeFragment$showToggleHint$1>) null), 3, (Object) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentFontSizeBinding c = FragmentFontSizeBinding.c(layoutInflater, viewGroup, false);
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
