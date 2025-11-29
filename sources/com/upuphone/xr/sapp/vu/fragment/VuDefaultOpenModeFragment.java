package com.upuphone.xr.sapp.vu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.honey.account.c9.f;
import com.honey.account.c9.g;
import com.honey.account.c9.h;
import com.upuphone.xr.sapp.databinding.FragmentVuDefaultOpenModeBinding;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vu.vm.VuArSpacePreferenceModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/sapp/vu/fragment/VuDefaultOpenModeFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentVuDefaultOpenModeBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/FragmentVuDefaultOpenModeBinding;", "binding", "Lcom/upuphone/xr/sapp/vu/vm/VuArSpacePreferenceModel;", "b", "Lkotlin/Lazy;", "k0", "()Lcom/upuphone/xr/sapp/vu/vm/VuArSpacePreferenceModel;", "arSpacePreferenceModel", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuDefaultOpenModeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuDefaultOpenModeFragment.kt\ncom/upuphone/xr/sapp/vu/fragment/VuDefaultOpenModeFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,52:1\n172#2,9:53\n*S KotlinDebug\n*F\n+ 1 VuDefaultOpenModeFragment.kt\ncom/upuphone/xr/sapp/vu/fragment/VuDefaultOpenModeFragment\n*L\n20#1:53,9\n*E\n"})
public final class VuDefaultOpenModeFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public FragmentVuDefaultOpenModeBinding f8064a;
    public final Lazy b = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(VuArSpacePreferenceModel.class), new VuDefaultOpenModeFragment$special$$inlined$activityViewModels$default$1(this), new VuDefaultOpenModeFragment$special$$inlined$activityViewModels$default$2((Function0) null, this), new VuDefaultOpenModeFragment$special$$inlined$activityViewModels$default$3(this));

    private final void initView() {
        k0().d().observe(getViewLifecycleOwner(), new VuDefaultOpenModeFragment$sam$androidx_lifecycle_Observer$0(new VuDefaultOpenModeFragment$initView$1(this)));
        FragmentVuDefaultOpenModeBinding fragmentVuDefaultOpenModeBinding = this.f8064a;
        FragmentVuDefaultOpenModeBinding fragmentVuDefaultOpenModeBinding2 = null;
        if (fragmentVuDefaultOpenModeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuDefaultOpenModeBinding = null;
        }
        fragmentVuDefaultOpenModeBinding.e.setOnClickListener(new f(this));
        FragmentVuDefaultOpenModeBinding fragmentVuDefaultOpenModeBinding3 = this.f8064a;
        if (fragmentVuDefaultOpenModeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuDefaultOpenModeBinding3 = null;
        }
        fragmentVuDefaultOpenModeBinding3.h.setOnClickListener(new g(this));
        FragmentVuDefaultOpenModeBinding fragmentVuDefaultOpenModeBinding4 = this.f8064a;
        if (fragmentVuDefaultOpenModeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuDefaultOpenModeBinding2 = fragmentVuDefaultOpenModeBinding4;
        }
        fragmentVuDefaultOpenModeBinding2.c.setOnClickListener(new h(this));
    }

    private final VuArSpacePreferenceModel k0() {
        return (VuArSpacePreferenceModel) this.b.getValue();
    }

    public static final void l0(VuDefaultOpenModeFragment vuDefaultOpenModeFragment, View view) {
        Intrinsics.checkNotNullParameter(vuDefaultOpenModeFragment, "this$0");
        StaticMethodUtilsKt.q(vuDefaultOpenModeFragment);
    }

    public static final void m0(VuDefaultOpenModeFragment vuDefaultOpenModeFragment, View view) {
        Intrinsics.checkNotNullParameter(vuDefaultOpenModeFragment, "this$0");
        vuDefaultOpenModeFragment.k0().f(false);
    }

    public static final void n0(VuDefaultOpenModeFragment vuDefaultOpenModeFragment, View view) {
        Intrinsics.checkNotNullParameter(vuDefaultOpenModeFragment, "this$0");
        vuDefaultOpenModeFragment.k0().f(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentVuDefaultOpenModeBinding c = FragmentVuDefaultOpenModeBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.f8064a = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        ConstraintLayout b2 = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        return b2;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }
}
