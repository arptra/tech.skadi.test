package com.upuphone.xr.sapp.vu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.honey.account.c9.i;
import com.honey.account.c9.j;
import com.honey.account.c9.k;
import com.honey.account.c9.l;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentVuDisplayModeBinding;
import com.upuphone.xr.sapp.fragment.BaseFragment;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesPreferenceModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\tJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010\u001dJ\u000f\u0010 \u001a\u00020\u001aH\u0002¢\u0006\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/upuphone/xr/sapp/vu/fragment/VuDisplayModeFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "", "mode", "L0", "(I)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "displayMode", "P0", "", "selected", "N0", "(Z)V", "O0", "M0", "K0", "()Z", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesPreferenceModel;", "j", "Lkotlin/Lazy;", "F0", "()Lcom/upuphone/xr/sapp/vu/vm/VuGlassesPreferenceModel;", "preferenceModel", "Lcom/upuphone/xr/sapp/databinding/FragmentVuDisplayModeBinding;", "k", "Lcom/upuphone/xr/sapp/databinding/FragmentVuDisplayModeBinding;", "binding", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuDisplayModeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuDisplayModeFragment.kt\ncom/upuphone/xr/sapp/vu/fragment/VuDisplayModeFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,126:1\n172#2,9:127\n1#3:136\n256#4,2:137\n256#4,2:139\n256#4,2:141\n*S KotlinDebug\n*F\n+ 1 VuDisplayModeFragment.kt\ncom/upuphone/xr/sapp/vu/fragment/VuDisplayModeFragment\n*L\n22#1:127,9\n86#1:137,2\n94#1:139,2\n102#1:141,2\n*E\n"})
public final class VuDisplayModeFragment extends BaseFragment {
    public final Lazy j = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(VuGlassesPreferenceModel.class), new VuDisplayModeFragment$special$$inlined$activityViewModels$default$1(this), new VuDisplayModeFragment$special$$inlined$activityViewModels$default$2((Function0) null, this), new VuDisplayModeFragment$special$$inlined$activityViewModels$default$3(this));
    public FragmentVuDisplayModeBinding k;

    public static final void G0(VuDisplayModeFragment vuDisplayModeFragment, View view) {
        Intrinsics.checkNotNullParameter(vuDisplayModeFragment, "this$0");
        StaticMethodUtilsKt.q(vuDisplayModeFragment);
    }

    public static final void H0(VuDisplayModeFragment vuDisplayModeFragment, View view) {
        Intrinsics.checkNotNullParameter(vuDisplayModeFragment, "this$0");
        vuDisplayModeFragment.L0(1);
    }

    public static final void I0(VuDisplayModeFragment vuDisplayModeFragment, View view) {
        Intrinsics.checkNotNullParameter(vuDisplayModeFragment, "this$0");
        vuDisplayModeFragment.L0(0);
    }

    public static final void J0(VuDisplayModeFragment vuDisplayModeFragment, View view) {
        Intrinsics.checkNotNullParameter(vuDisplayModeFragment, "this$0");
        vuDisplayModeFragment.L0(2);
    }

    private final void L0(int i) {
        boolean K0 = K0();
        Boolean valueOf = Boolean.valueOf(K0);
        if (!K0) {
            valueOf = null;
        }
        if (valueOf != null) {
            F0().n(i);
        }
    }

    private final void initView() {
        FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding = this.k;
        FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding2 = null;
        if (fragmentVuDisplayModeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuDisplayModeBinding = null;
        }
        fragmentVuDisplayModeBinding.b.setOnClickListener(new i(this));
        F0().g().observe(getViewLifecycleOwner(), new VuDisplayModeFragment$sam$androidx_lifecycle_Observer$0(new VuDisplayModeFragment$initView$2(this)));
        FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding3 = this.k;
        if (fragmentVuDisplayModeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuDisplayModeBinding3 = null;
        }
        fragmentVuDisplayModeBinding3.i.setOnClickListener(new j(this));
        FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding4 = this.k;
        if (fragmentVuDisplayModeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuDisplayModeBinding4 = null;
        }
        fragmentVuDisplayModeBinding4.k.setOnClickListener(new k(this));
        FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding5 = this.k;
        if (fragmentVuDisplayModeBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuDisplayModeBinding2 = fragmentVuDisplayModeBinding5;
        }
        fragmentVuDisplayModeBinding2.e.setOnClickListener(new l(this));
    }

    public final VuGlassesPreferenceModel F0() {
        return (VuGlassesPreferenceModel) this.j.getValue();
    }

    public final boolean K0() {
        if (getContext() != null && !VuGlassControlModel.f8109a.z()) {
            StaticMethodUtilsKt.a0(this);
            return false;
        } else if (VuGlassesOtaModel.f8117a.A()) {
            StaticMethodUtilsKt.O(this);
            return false;
        } else if (VuGlassesHidUtil.f8104a.e() == 1) {
            return true;
        } else {
            VuGlassesHidManager.x(VuGlassesHidManager.f8100a, (VuGlassesHidManager.UsbOpenResultListener) null, false, 3, (Object) null);
            return false;
        }
    }

    public final void M0(boolean z) {
        FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding = this.k;
        FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding2 = null;
        if (fragmentVuDisplayModeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuDisplayModeBinding = null;
        }
        ImageView imageView = fragmentVuDisplayModeBinding.f;
        Intrinsics.checkNotNullExpressionValue(imageView, "eyeCareModeSelect");
        imageView.setVisibility(z ? 0 : 8);
        FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding3 = this.k;
        if (fragmentVuDisplayModeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuDisplayModeBinding3 = null;
        }
        fragmentVuDisplayModeBinding3.d.setSelected(z);
        if (z) {
            FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding4 = this.k;
            if (fragmentVuDisplayModeBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVuDisplayModeBinding2 = fragmentVuDisplayModeBinding4;
            }
            fragmentVuDisplayModeBinding2.c.setImageResource(R.drawable.display_mode_eye_care);
        }
    }

    public final void N0(boolean z) {
        FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding = this.k;
        FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding2 = null;
        if (fragmentVuDisplayModeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuDisplayModeBinding = null;
        }
        ImageView imageView = fragmentVuDisplayModeBinding.h;
        Intrinsics.checkNotNullExpressionValue(imageView, "proModeSelect");
        imageView.setVisibility(z ? 0 : 8);
        FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding3 = this.k;
        if (fragmentVuDisplayModeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuDisplayModeBinding3 = null;
        }
        fragmentVuDisplayModeBinding3.g.setSelected(z);
        if (z) {
            FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding4 = this.k;
            if (fragmentVuDisplayModeBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVuDisplayModeBinding2 = fragmentVuDisplayModeBinding4;
            }
            fragmentVuDisplayModeBinding2.c.setImageResource(R.drawable.display_mode_pro);
        }
    }

    public final void O0(boolean z) {
        FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding = this.k;
        FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding2 = null;
        if (fragmentVuDisplayModeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuDisplayModeBinding = null;
        }
        ImageView imageView = fragmentVuDisplayModeBinding.l;
        Intrinsics.checkNotNullExpressionValue(imageView, "videoModeSelect");
        imageView.setVisibility(z ? 0 : 8);
        FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding3 = this.k;
        if (fragmentVuDisplayModeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuDisplayModeBinding3 = null;
        }
        fragmentVuDisplayModeBinding3.j.setSelected(z);
        if (z) {
            FragmentVuDisplayModeBinding fragmentVuDisplayModeBinding4 = this.k;
            if (fragmentVuDisplayModeBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVuDisplayModeBinding2 = fragmentVuDisplayModeBinding4;
            }
            fragmentVuDisplayModeBinding2.c.setImageResource(R.drawable.display_mode_video);
        }
    }

    public final void P0(int i) {
        if (i == 0) {
            N0(false);
            O0(true);
            M0(false);
        } else if (i == 1) {
            N0(true);
            O0(false);
            M0(false);
        } else if (i != 2) {
            N0(true);
            O0(false);
            M0(false);
        } else {
            N0(false);
            O0(false);
            M0(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentVuDisplayModeBinding c = FragmentVuDisplayModeBinding.c(layoutInflater, viewGroup, false);
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

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }
}
