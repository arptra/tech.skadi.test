package com.upuphone.xr.sapp.vu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.honey.account.c9.m;
import com.honey.account.c9.n;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.ProtocolType;
import com.upuphone.xr.sapp.databinding.FragmentVuGlassPolicyBinding;
import com.upuphone.xr.sapp.fragment.BaseFragment;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/vu/fragment/VuGlassPolicyFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentVuGlassPolicyBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentVuGlassPolicyBinding;", "binding", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuGlassPolicyFragment extends BaseFragment {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public FragmentVuGlassPolicyBinding j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/vu/fragment/VuGlassPolicyFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void C0(VuGlassPolicyFragment vuGlassPolicyFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassPolicyFragment, "this$0");
        StaticMethodUtilsKt.q(vuGlassPolicyFragment);
    }

    public static final void D0(VuGlassPolicyFragment vuGlassPolicyFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassPolicyFragment, "this$0");
        ContractEntry contractEntry = ContractEntry.f6691a;
        FragmentActivity requireActivity = vuGlassPolicyFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ContractEntry.w(contractEntry, requireActivity, ProtocolType.GLASS_VIEW_UP, (String) null, 4, (Object) null);
    }

    private final void initView() {
        ULog.f6446a.a("GlassPolicyFragment", "initView");
        FragmentVuGlassPolicyBinding fragmentVuGlassPolicyBinding = this.j;
        FragmentVuGlassPolicyBinding fragmentVuGlassPolicyBinding2 = null;
        if (fragmentVuGlassPolicyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassPolicyBinding = null;
        }
        fragmentVuGlassPolicyBinding.b.setOnClickListener(new m(this));
        FragmentVuGlassPolicyBinding fragmentVuGlassPolicyBinding3 = this.j;
        if (fragmentVuGlassPolicyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuGlassPolicyBinding2 = fragmentVuGlassPolicyBinding3;
        }
        fragmentVuGlassPolicyBinding2.d.setOnClickListener(new n(this));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentVuGlassPolicyBinding c = FragmentVuGlassPolicyBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        return c.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }
}
