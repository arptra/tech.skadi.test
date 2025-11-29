package com.upuphone.xr.sapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import com.honey.account.h8.a4;
import com.honey.account.h8.b4;
import com.honey.account.h8.c4;
import com.honey.account.h8.x3;
import com.honey.account.h8.y3;
import com.honey.account.h8.z3;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.ProtocolType;
import com.upuphone.xr.sapp.databinding.FragmentGlassPolicyBinding;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassPolicyFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentGlassPolicyBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentGlassPolicyBinding;", "binding", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassPolicyFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassPolicyFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassPolicyFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,156:1\n256#2,2:157\n256#2,2:159\n256#2,2:161\n*S KotlinDebug\n*F\n+ 1 GlassPolicyFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassPolicyFragment\n*L\n46#1:157,2\n47#1:159,2\n48#1:161,2\n*E\n"})
public final class GlassPolicyFragment extends BaseFragment {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public FragmentGlassPolicyBinding j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/GlassPolicyFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void G0(GlassPolicyFragment glassPolicyFragment, View view) {
        Intrinsics.checkNotNullParameter(glassPolicyFragment, "this$0");
        StaticMethodUtilsKt.q(glassPolicyFragment);
    }

    public static final void H0(GlassPolicyFragment glassPolicyFragment, View view) {
        Intrinsics.checkNotNullParameter(glassPolicyFragment, "this$0");
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            ContractEntry contractEntry = ContractEntry.f6691a;
            FragmentActivity requireActivity = glassPolicyFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            ContractEntry.w(contractEntry, requireActivity, ProtocolType.GLASS_AIR_UP, (String) null, 4, (Object) null);
            return;
        }
        ContractEntry contractEntry2 = ContractEntry.f6691a;
        FragmentActivity requireActivity2 = glassPolicyFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        ContractEntry.w(contractEntry2, requireActivity2, ProtocolType.GLASS_STAR_UP, (String) null, 4, (Object) null);
    }

    public static final void I0(GlassPolicyFragment glassPolicyFragment, View view) {
        Intrinsics.checkNotNullParameter(glassPolicyFragment, "this$0");
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            ContractEntry contractEntry = ContractEntry.f6691a;
            FragmentActivity requireActivity = glassPolicyFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            ContractEntry.w(contractEntry, requireActivity, ProtocolType.GLASS_AIR_PP, (String) null, 4, (Object) null);
            return;
        }
        ContractEntry contractEntry2 = ContractEntry.f6691a;
        FragmentActivity requireActivity2 = glassPolicyFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        ContractEntry.w(contractEntry2, requireActivity2, ProtocolType.GLASS_STAR_PP, (String) null, 4, (Object) null);
    }

    public static final void J0(GlassPolicyFragment glassPolicyFragment, View view) {
        Intrinsics.checkNotNullParameter(glassPolicyFragment, "this$0");
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            ContractEntry contractEntry = ContractEntry.f6691a;
            FragmentActivity requireActivity = glassPolicyFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            ContractEntry.w(contractEntry, requireActivity, ProtocolType.GLASS_AIR_PICL, (String) null, 4, (Object) null);
            return;
        }
        ContractEntry contractEntry2 = ContractEntry.f6691a;
        FragmentActivity requireActivity2 = glassPolicyFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        ContractEntry.w(contractEntry2, requireActivity2, ProtocolType.GLASS_STAR_PICL, (String) null, 4, (Object) null);
    }

    public static final void K0(GlassPolicyFragment glassPolicyFragment, View view) {
        Intrinsics.checkNotNullParameter(glassPolicyFragment, "this$0");
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            ContractEntry contractEntry = ContractEntry.f6691a;
            FragmentActivity requireActivity = glassPolicyFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            ContractEntry.w(contractEntry, requireActivity, ProtocolType.GLASS_AIR_TISL, (String) null, 4, (Object) null);
            return;
        }
        ContractEntry contractEntry2 = ContractEntry.f6691a;
        FragmentActivity requireActivity2 = glassPolicyFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        ContractEntry.w(contractEntry2, requireActivity2, ProtocolType.GLASS_STAR_TISL, (String) null, 4, (Object) null);
    }

    public static final void L0(GlassPolicyFragment glassPolicyFragment, View view) {
        Intrinsics.checkNotNullParameter(glassPolicyFragment, "this$0");
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            ContractEntry contractEntry = ContractEntry.f6691a;
            FragmentActivity requireActivity = glassPolicyFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            ContractEntry.w(contractEntry, requireActivity, ProtocolType.GLASS_AIR_PCPI, (String) null, 4, (Object) null);
            return;
        }
        ContractEntry contractEntry2 = ContractEntry.f6691a;
        FragmentActivity requireActivity2 = glassPolicyFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        ContractEntry.w(contractEntry2, requireActivity2, ProtocolType.GLASS_STAR_PCPI, (String) null, 4, (Object) null);
    }

    private final void initView() {
        ULog.f6446a.a("GlassPolicyFragment", "initView");
        FragmentGlassPolicyBinding fragmentGlassPolicyBinding = this.j;
        FragmentGlassPolicyBinding fragmentGlassPolicyBinding2 = null;
        if (fragmentGlassPolicyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPolicyBinding = null;
        }
        TextView textView = fragmentGlassPolicyBinding.c;
        Intrinsics.checkNotNullExpressionValue(textView, "accountPersonalInfoList");
        Boolean bool = BuildConfig.f6575a;
        int i = 8;
        textView.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        FragmentGlassPolicyBinding fragmentGlassPolicyBinding3 = this.j;
        if (fragmentGlassPolicyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPolicyBinding3 = null;
        }
        TextView textView2 = fragmentGlassPolicyBinding3.d;
        Intrinsics.checkNotNullExpressionValue(textView2, "accountThirdShareList");
        textView2.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        FragmentGlassPolicyBinding fragmentGlassPolicyBinding4 = this.j;
        if (fragmentGlassPolicyBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPolicyBinding4 = null;
        }
        TextView textView3 = fragmentGlassPolicyBinding4.b;
        Intrinsics.checkNotNullExpressionValue(textView3, "aboutChildrenInfoProtect");
        if (!bool.booleanValue()) {
            i = 0;
        }
        textView3.setVisibility(i);
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            FragmentGlassPolicyBinding fragmentGlassPolicyBinding5 = this.j;
            if (fragmentGlassPolicyBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentGlassPolicyBinding5 = null;
            }
            fragmentGlassPolicyBinding5.h.setBackground(AppCompatResources.b(requireContext(), R.drawable.common_single_item_bg_bottom));
        }
        FragmentGlassPolicyBinding fragmentGlassPolicyBinding6 = this.j;
        if (fragmentGlassPolicyBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPolicyBinding6 = null;
        }
        fragmentGlassPolicyBinding6.e.setOnClickListener(new x3(this));
        FragmentGlassPolicyBinding fragmentGlassPolicyBinding7 = this.j;
        if (fragmentGlassPolicyBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPolicyBinding7 = null;
        }
        fragmentGlassPolicyBinding7.g.setOnClickListener(new y3(this));
        FragmentGlassPolicyBinding fragmentGlassPolicyBinding8 = this.j;
        if (fragmentGlassPolicyBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPolicyBinding8 = null;
        }
        fragmentGlassPolicyBinding8.h.setOnClickListener(new z3(this));
        FragmentGlassPolicyBinding fragmentGlassPolicyBinding9 = this.j;
        if (fragmentGlassPolicyBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPolicyBinding9 = null;
        }
        fragmentGlassPolicyBinding9.c.setOnClickListener(new a4(this));
        FragmentGlassPolicyBinding fragmentGlassPolicyBinding10 = this.j;
        if (fragmentGlassPolicyBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentGlassPolicyBinding10 = null;
        }
        fragmentGlassPolicyBinding10.d.setOnClickListener(new b4(this));
        FragmentGlassPolicyBinding fragmentGlassPolicyBinding11 = this.j;
        if (fragmentGlassPolicyBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentGlassPolicyBinding2 = fragmentGlassPolicyBinding11;
        }
        fragmentGlassPolicyBinding2.b.setOnClickListener(new c4(this));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentGlassPolicyBinding c = FragmentGlassPolicyBinding.c(layoutInflater, viewGroup, false);
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
