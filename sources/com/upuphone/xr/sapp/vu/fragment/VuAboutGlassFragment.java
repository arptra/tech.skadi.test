package com.upuphone.xr.sapp.vu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.c9.d;
import com.honey.account.c9.e;
import com.upuphone.xr.sapp.databinding.FragmentVuAboutGlassBinding;
import com.upuphone.xr.sapp.fragment.BaseFragment;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel;
import com.xjmz.myvu.flutter.FlutterExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/vu/fragment/VuAboutGlassFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "D0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onClickCertification", "Lcom/upuphone/xr/sapp/databinding/FragmentVuAboutGlassBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentVuAboutGlassBinding;", "binding", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuAboutGlassFragment extends BaseFragment {
    public FragmentVuAboutGlassBinding j;

    private final void D0() {
        VuGlassControlModel.f8109a.v().observe(getViewLifecycleOwner(), new VuAboutGlassFragment$sam$androidx_lifecycle_Observer$0(new VuAboutGlassFragment$addObserver$1(this)));
        VuGlassesDeviceInfoModel.f8112a.b().observe(getViewLifecycleOwner(), new VuAboutGlassFragment$sam$androidx_lifecycle_Observer$0(new VuAboutGlassFragment$addObserver$2(this)));
    }

    public static final void E0(VuAboutGlassFragment vuAboutGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(vuAboutGlassFragment, "this$0");
        StaticMethodUtilsKt.q(vuAboutGlassFragment);
    }

    public static final void F0(VuAboutGlassFragment vuAboutGlassFragment, View view) {
        Intrinsics.checkNotNullParameter(vuAboutGlassFragment, "this$0");
        vuAboutGlassFragment.onClickCertification();
    }

    private final void initView() {
        FragmentVuAboutGlassBinding fragmentVuAboutGlassBinding = this.j;
        FragmentVuAboutGlassBinding fragmentVuAboutGlassBinding2 = null;
        if (fragmentVuAboutGlassBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuAboutGlassBinding = null;
        }
        fragmentVuAboutGlassBinding.b.setOnClickListener(new d(this));
        FragmentVuAboutGlassBinding fragmentVuAboutGlassBinding3 = this.j;
        if (fragmentVuAboutGlassBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuAboutGlassBinding2 = fragmentVuAboutGlassBinding3;
        }
        fragmentVuAboutGlassBinding2.i.setOnClickListener(new e(this));
    }

    public final void onClickCertification() {
        FlutterExtKt.a(this, "/regulatory_certification_page?deviceType=view");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (this.j == null) {
            FragmentVuAboutGlassBinding c = FragmentVuAboutGlassBinding.c(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
            this.j = c;
        }
        FragmentVuAboutGlassBinding fragmentVuAboutGlassBinding = this.j;
        if (fragmentVuAboutGlassBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuAboutGlassBinding = null;
        }
        ConstraintLayout b = fragmentVuAboutGlassBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        D0();
        initView();
        VuGlassesDeviceInfoModel.f8112a.f();
    }
}
