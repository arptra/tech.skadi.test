package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.honey.account.h8.q7;
import com.honey.account.h8.r7;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentPageAdjustBinding;
import com.upuphone.xr.sapp.entity.AdjustmentMode;
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

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0003R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010(\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/PageAdjustFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "K0", "N0", "initView", "", "connect", "I0", "(Z)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroy", "P0", "O0", "Lcom/upuphone/xr/sapp/databinding/FragmentPageAdjustBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentPageAdjustBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "k", "Lkotlin/Lazy;", "n0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "l", "J0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "m", "Z", "isConnect", "Lcom/upuphone/xr/sapp/entity/AdjustmentMode;", "n", "Lcom/upuphone/xr/sapp/entity/AdjustmentMode;", "mAdjustmentMode", "o", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPageAdjustFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PageAdjustFragment.kt\ncom/upuphone/xr/sapp/fragment/PageAdjustFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,230:1\n32#2,12:231\n32#2,12:243\n256#3,2:255\n*S KotlinDebug\n*F\n+ 1 PageAdjustFragment.kt\ncom/upuphone/xr/sapp/fragment/PageAdjustFragment\n*L\n36#1:231,12\n37#1:243,12\n213#1:255,2\n*E\n"})
public final class PageAdjustFragment extends BaseFragment {
    public static final Companion o = new Companion((DefaultConstructorMarker) null);
    public FragmentPageAdjustBinding j;
    public final Lazy k;
    public final Lazy l;
    public boolean m = true;
    public AdjustmentMode n = new AdjustmentMode(0.0d, 0.0d, 0.0d, 7, (DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/PageAdjustFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public PageAdjustFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.k = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.l = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    /* access modifiers changed from: private */
    public final void I0(boolean z) {
        this.m = z;
        FragmentPageAdjustBinding fragmentPageAdjustBinding = null;
        if (z) {
            FragmentPageAdjustBinding fragmentPageAdjustBinding2 = this.j;
            if (fragmentPageAdjustBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentPageAdjustBinding = fragmentPageAdjustBinding2;
            }
            fragmentPageAdjustBinding.l.setAlpha(1.0f);
            return;
        }
        FragmentPageAdjustBinding fragmentPageAdjustBinding3 = this.j;
        if (fragmentPageAdjustBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentPageAdjustBinding = fragmentPageAdjustBinding3;
        }
        fragmentPageAdjustBinding.l.setAlpha(0.5f);
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string = getString(R.string.switch_language_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(requireContext, string);
    }

    private final DeviceControlModel J0() {
        return (DeviceControlModel) this.l.getValue();
    }

    private final void K0() {
        n0().N().observe(getViewLifecycleOwner(), new PageAdjustFragment$sam$androidx_lifecycle_Observer$0(new PageAdjustFragment$initObserve$1(this)));
        J0().L().observe(getViewLifecycleOwner(), new PageAdjustFragment$sam$androidx_lifecycle_Observer$0(new PageAdjustFragment$initObserve$2(this)));
    }

    public static final void L0(PageAdjustFragment pageAdjustFragment, View view) {
        Intrinsics.checkNotNullParameter(pageAdjustFragment, "this$0");
        if (!pageAdjustFragment.m) {
            UToast.Companion companion = UToast.f6444a;
            Context requireContext = pageAdjustFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            String string = pageAdjustFragment.getString(R.string.device_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(requireContext, string);
            return;
        }
        AdjustmentMode adjustmentMode = pageAdjustFragment.n;
        adjustmentMode.setHor_bias(0.0d);
        adjustmentMode.setRotate(0.0d);
        adjustmentMode.setVer_bias(0.0d);
        pageAdjustFragment.P0();
        pageAdjustFragment.O0();
    }

    public static final void M0(PageAdjustFragment pageAdjustFragment, View view) {
        Intrinsics.checkNotNullParameter(pageAdjustFragment, "this$0");
        StaticMethodUtilsKt.q(pageAdjustFragment);
    }

    private final void N0() {
        n0().N().removeObservers(getViewLifecycleOwner());
        J0().L().removeObservers(getViewLifecycleOwner());
    }

    private final void initView() {
        FragmentPageAdjustBinding fragmentPageAdjustBinding = this.j;
        FragmentPageAdjustBinding fragmentPageAdjustBinding2 = null;
        if (fragmentPageAdjustBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding = null;
        }
        fragmentPageAdjustBinding.i.setOnClickListener(new q7(this));
        FragmentPageAdjustBinding fragmentPageAdjustBinding3 = this.j;
        if (fragmentPageAdjustBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding3 = null;
        }
        fragmentPageAdjustBinding3.d.setOnClickListener(new r7(this));
        FragmentPageAdjustBinding fragmentPageAdjustBinding4 = this.j;
        if (fragmentPageAdjustBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding4 = null;
        }
        fragmentPageAdjustBinding4.j.setEnableEngine(false);
        FragmentPageAdjustBinding fragmentPageAdjustBinding5 = this.j;
        if (fragmentPageAdjustBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding5 = null;
        }
        fragmentPageAdjustBinding5.j.setOnStepSeekBarChangeListener(new PageAdjustFragment$initView$3(this));
        FragmentPageAdjustBinding fragmentPageAdjustBinding6 = this.j;
        if (fragmentPageAdjustBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding6 = null;
        }
        fragmentPageAdjustBinding6.g.setEnableEngine(false);
        FragmentPageAdjustBinding fragmentPageAdjustBinding7 = this.j;
        if (fragmentPageAdjustBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding7 = null;
        }
        fragmentPageAdjustBinding7.g.setOnStepSeekBarChangeListener(new PageAdjustFragment$initView$4(this));
        FragmentPageAdjustBinding fragmentPageAdjustBinding8 = this.j;
        if (fragmentPageAdjustBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding8 = null;
        }
        fragmentPageAdjustBinding8.b.setEnableEngine(false);
        FragmentPageAdjustBinding fragmentPageAdjustBinding9 = this.j;
        if (fragmentPageAdjustBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentPageAdjustBinding2 = fragmentPageAdjustBinding9;
        }
        fragmentPageAdjustBinding2.b.setOnStepSeekBarChangeListener(new PageAdjustFragment$initView$5(this));
    }

    private final SuperViewModel n0() {
        return (SuperViewModel) this.k.getValue();
    }

    public final void O0() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new PageAdjustFragment$syncToGlass$1(this, (Continuation<? super PageAdjustFragment$syncToGlass$1>) null), 3, (Object) null);
    }

    public final void P0() {
        String str = getString(R.string.page_adjust_up_down) + " " + this.n.getVer_bias();
        FragmentPageAdjustBinding fragmentPageAdjustBinding = this.j;
        FragmentPageAdjustBinding fragmentPageAdjustBinding2 = null;
        if (fragmentPageAdjustBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding = null;
        }
        fragmentPageAdjustBinding.k.setText(str);
        FragmentPageAdjustBinding fragmentPageAdjustBinding3 = this.j;
        if (fragmentPageAdjustBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding3 = null;
        }
        fragmentPageAdjustBinding3.j.setProgress(((int) (this.n.getVer_bias() / 0.1d)) + 30);
        String str2 = getString(R.string.page_adjust_left_right) + " " + this.n.getHor_bias();
        FragmentPageAdjustBinding fragmentPageAdjustBinding4 = this.j;
        if (fragmentPageAdjustBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding4 = null;
        }
        fragmentPageAdjustBinding4.h.setText(str2);
        FragmentPageAdjustBinding fragmentPageAdjustBinding5 = this.j;
        if (fragmentPageAdjustBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding5 = null;
        }
        fragmentPageAdjustBinding5.g.setProgress(((int) (this.n.getHor_bias() / 0.1d)) + 30);
        String str3 = getString(R.string.page_adjust_angle) + " " + this.n.getRotate();
        FragmentPageAdjustBinding fragmentPageAdjustBinding6 = this.j;
        if (fragmentPageAdjustBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding6 = null;
        }
        fragmentPageAdjustBinding6.c.setText(str3);
        FragmentPageAdjustBinding fragmentPageAdjustBinding7 = this.j;
        if (fragmentPageAdjustBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding7 = null;
        }
        fragmentPageAdjustBinding7.b.setProgress(((int) (this.n.getRotate() / 0.1d)) + 30);
        FragmentPageAdjustBinding fragmentPageAdjustBinding8 = this.j;
        if (fragmentPageAdjustBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding8 = null;
        }
        fragmentPageAdjustBinding8.f.setRotation((float) this.n.getRotate());
        FragmentPageAdjustBinding fragmentPageAdjustBinding9 = this.j;
        if (fragmentPageAdjustBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding9 = null;
        }
        double d = (double) 2;
        fragmentPageAdjustBinding9.f.setTranslationX(((float) ((int) (this.n.getHor_bias() * d))) * 3.6f);
        FragmentPageAdjustBinding fragmentPageAdjustBinding10 = this.j;
        if (fragmentPageAdjustBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPageAdjustBinding10 = null;
        }
        fragmentPageAdjustBinding10.f.setTranslationY(((float) ((int) (this.n.getVer_bias() * d))) * 3.6f);
        FragmentPageAdjustBinding fragmentPageAdjustBinding11 = this.j;
        if (fragmentPageAdjustBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentPageAdjustBinding2 = fragmentPageAdjustBinding11;
        }
        AppCompatTextView appCompatTextView = fragmentPageAdjustBinding2.i;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "pageAdjustReset");
        int i = 0;
        if (!((this.n.getRotate() == 0.0d && this.n.getHor_bias() == 0.0d && this.n.getVer_bias() == 0.0d) ? false : true)) {
            i = 8;
        }
        appCompatTextView.setVisibility(i);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentPageAdjustBinding c = FragmentPageAdjustBinding.c(layoutInflater, viewGroup, false);
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

    public void onDestroy() {
        super.onDestroy();
        n0().a0().setValue(this.n);
    }

    public void onPause() {
        super.onPause();
        N0();
    }

    public void onResume() {
        super.onResume();
        K0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }
}
