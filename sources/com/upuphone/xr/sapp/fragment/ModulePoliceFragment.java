package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.honey.account.h8.f7;
import com.honey.account.h8.g7;
import com.honey.account.h8.h7;
import com.honey.account.h8.i7;
import com.honey.account.h8.j7;
import com.honey.account.h8.k7;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.ModulePrivacyManagerKt;
import com.upuphone.xr.sapp.databinding.FragmentModulePoliceBinding;
import com.upuphone.xr.sapp.fragment.AboutSuperAppFragment;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/ModulePoliceFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "key", "O0", "(Landroid/view/View;Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentModulePoliceBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentModulePoliceBinding;", "binding", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nModulePoliceFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModulePoliceFragment.kt\ncom/upuphone/xr/sapp/fragment/ModulePoliceFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,118:1\n256#2,2:119\n256#2,2:121\n256#2,2:123\n256#2,2:125\n*S KotlinDebug\n*F\n+ 1 ModulePoliceFragment.kt\ncom/upuphone/xr/sapp/fragment/ModulePoliceFragment\n*L\n56#1:119,2\n57#1:121,2\n58#1:123,2\n59#1:125,2\n*E\n"})
public final class ModulePoliceFragment extends BaseFragment {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public FragmentModulePoliceBinding j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/ModulePoliceFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void I0(ModulePoliceFragment modulePoliceFragment, View view) {
        Intrinsics.checkNotNullParameter(modulePoliceFragment, "this$0");
        StaticMethodUtilsKt.q(modulePoliceFragment);
    }

    public static final void J0(ModulePoliceFragment modulePoliceFragment, View view) {
        Intrinsics.checkNotNullParameter(modulePoliceFragment, "this$0");
        AboutSuperAppFragment.Companion companion = AboutSuperAppFragment.l;
        FragmentActivity requireActivity = modulePoliceFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        LifecycleOwner viewLifecycleOwner = modulePoliceFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        companion.k(requireActivity, LifecycleOwnerKt.a(viewLifecycleOwner));
    }

    public static final void K0(ModulePoliceFragment modulePoliceFragment, View view) {
        Intrinsics.checkNotNullParameter(modulePoliceFragment, "this$0");
        FragmentActivity requireActivity = modulePoliceFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ModulePrivacyManagerKt.g(requireActivity, 4, new ModulePoliceFragment$initView$3$1(modulePoliceFragment));
    }

    public static final void L0(ModulePoliceFragment modulePoliceFragment, View view) {
        Intrinsics.checkNotNullParameter(modulePoliceFragment, "this$0");
        FragmentActivity requireActivity = modulePoliceFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ModulePrivacyManagerKt.g(requireActivity, 1, new ModulePoliceFragment$initView$4$1(modulePoliceFragment));
    }

    public static final void M0(ModulePoliceFragment modulePoliceFragment, View view) {
        Intrinsics.checkNotNullParameter(modulePoliceFragment, "this$0");
        FragmentActivity requireActivity = modulePoliceFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ModulePrivacyManagerKt.g(requireActivity, 2, new ModulePoliceFragment$initView$5$1(modulePoliceFragment));
    }

    public static final void N0(ModulePoliceFragment modulePoliceFragment, View view) {
        Intrinsics.checkNotNullParameter(modulePoliceFragment, "this$0");
        FragmentActivity requireActivity = modulePoliceFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ModulePrivacyManagerKt.g(requireActivity, 3, new ModulePoliceFragment$initView$6$1(modulePoliceFragment));
    }

    private final void initView() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ModulePoliceFragment", "initView");
        FragmentModulePoliceBinding fragmentModulePoliceBinding = this.j;
        FragmentModulePoliceBinding fragmentModulePoliceBinding2 = null;
        if (fragmentModulePoliceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding = null;
        }
        fragmentModulePoliceBinding.j.setOnClickListener(new f7(this));
        FragmentModulePoliceBinding fragmentModulePoliceBinding3 = this.j;
        if (fragmentModulePoliceBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding3 = null;
        }
        fragmentModulePoliceBinding3.b.setOnClickListener(new g7(this));
        boolean u = ContractEntry.f6691a.u();
        delegate.a("ModulePoliceFragment", "setModulesAgree needShow is:" + u);
        FragmentModulePoliceBinding fragmentModulePoliceBinding4 = this.j;
        if (fragmentModulePoliceBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding4 = null;
        }
        TextView textView = fragmentModulePoliceBinding4.e;
        Intrinsics.checkNotNullExpressionValue(textView, "cancelAiAssistanAgree");
        int i = 8;
        textView.setVisibility(u ? 0 : 8);
        FragmentModulePoliceBinding fragmentModulePoliceBinding5 = this.j;
        if (fragmentModulePoliceBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding5 = null;
        }
        TextView textView2 = fragmentModulePoliceBinding5.f;
        Intrinsics.checkNotNullExpressionValue(textView2, "cancelNaviAgree");
        textView2.setVisibility(u ? 0 : 8);
        FragmentModulePoliceBinding fragmentModulePoliceBinding6 = this.j;
        if (fragmentModulePoliceBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding6 = null;
        }
        TextView textView3 = fragmentModulePoliceBinding6.h;
        Intrinsics.checkNotNullExpressionValue(textView3, "cancelTranslatorAgree");
        textView3.setVisibility(u ? 0 : 8);
        FragmentModulePoliceBinding fragmentModulePoliceBinding7 = this.j;
        if (fragmentModulePoliceBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding7 = null;
        }
        TextView textView4 = fragmentModulePoliceBinding7.g;
        Intrinsics.checkNotNullExpressionValue(textView4, "cancelTiciAgree");
        if (u) {
            i = 0;
        }
        textView4.setVisibility(i);
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        DataStoreUtils a2 = companion.a();
        Boolean bool = Boolean.FALSE;
        boolean booleanValue = ((Boolean) DataStoreUtils.i(a2, "privacy_argreement_key_ai_asst", bool, (Context) null, 4, (Object) null)).booleanValue();
        FragmentModulePoliceBinding fragmentModulePoliceBinding8 = this.j;
        if (fragmentModulePoliceBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding8 = null;
        }
        fragmentModulePoliceBinding8.e.setText(getString(R.string.myvu_cancel_modules_agree_privacy, getString(R.string.voice_assistant)));
        FragmentModulePoliceBinding fragmentModulePoliceBinding9 = this.j;
        if (fragmentModulePoliceBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding9 = null;
        }
        fragmentModulePoliceBinding9.e.setEnabled(booleanValue);
        FragmentModulePoliceBinding fragmentModulePoliceBinding10 = this.j;
        if (fragmentModulePoliceBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding10 = null;
        }
        float f = 0.25f;
        fragmentModulePoliceBinding10.e.setAlpha(booleanValue ? 1.0f : 0.25f);
        FragmentModulePoliceBinding fragmentModulePoliceBinding11 = this.j;
        if (fragmentModulePoliceBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding11 = null;
        }
        fragmentModulePoliceBinding11.e.setOnClickListener(new h7(this));
        boolean booleanValue2 = ((Boolean) DataStoreUtils.i(companion.a(), "privacy_argreement_key_ar_navi", bool, (Context) null, 4, (Object) null)).booleanValue();
        FragmentModulePoliceBinding fragmentModulePoliceBinding12 = this.j;
        if (fragmentModulePoliceBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding12 = null;
        }
        fragmentModulePoliceBinding12.f.setText(getString(R.string.myvu_cancel_modules_agree_privacy, getString(R.string.ar_application_guide)));
        FragmentModulePoliceBinding fragmentModulePoliceBinding13 = this.j;
        if (fragmentModulePoliceBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding13 = null;
        }
        fragmentModulePoliceBinding13.f.setEnabled(booleanValue2);
        FragmentModulePoliceBinding fragmentModulePoliceBinding14 = this.j;
        if (fragmentModulePoliceBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding14 = null;
        }
        fragmentModulePoliceBinding14.f.setAlpha(booleanValue2 ? 1.0f : 0.25f);
        FragmentModulePoliceBinding fragmentModulePoliceBinding15 = this.j;
        if (fragmentModulePoliceBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding15 = null;
        }
        fragmentModulePoliceBinding15.f.setOnClickListener(new i7(this));
        boolean booleanValue3 = ((Boolean) DataStoreUtils.i(companion.a(), "privacy_argreement_key_ar_tran", bool, (Context) null, 4, (Object) null)).booleanValue();
        FragmentModulePoliceBinding fragmentModulePoliceBinding16 = this.j;
        if (fragmentModulePoliceBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding16 = null;
        }
        fragmentModulePoliceBinding16.h.setText(getString(R.string.myvu_cancel_modules_agree_privacy, getString(R.string.translator)));
        FragmentModulePoliceBinding fragmentModulePoliceBinding17 = this.j;
        if (fragmentModulePoliceBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding17 = null;
        }
        fragmentModulePoliceBinding17.h.setEnabled(booleanValue3);
        FragmentModulePoliceBinding fragmentModulePoliceBinding18 = this.j;
        if (fragmentModulePoliceBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding18 = null;
        }
        fragmentModulePoliceBinding18.h.setAlpha(booleanValue3 ? 1.0f : 0.25f);
        FragmentModulePoliceBinding fragmentModulePoliceBinding19 = this.j;
        if (fragmentModulePoliceBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding19 = null;
        }
        fragmentModulePoliceBinding19.h.setOnClickListener(new j7(this));
        boolean booleanValue4 = ((Boolean) DataStoreUtils.i(companion.a(), "privacy_argreement_key_ar_tici", bool, (Context) null, 4, (Object) null)).booleanValue();
        FragmentModulePoliceBinding fragmentModulePoliceBinding20 = this.j;
        if (fragmentModulePoliceBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding20 = null;
        }
        fragmentModulePoliceBinding20.g.setText(getString(R.string.myvu_cancel_modules_agree_privacy, getString(com.upuphone.ar.tici.R.string.tici_app_name)));
        FragmentModulePoliceBinding fragmentModulePoliceBinding21 = this.j;
        if (fragmentModulePoliceBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding21 = null;
        }
        fragmentModulePoliceBinding21.g.setEnabled(booleanValue4);
        FragmentModulePoliceBinding fragmentModulePoliceBinding22 = this.j;
        if (fragmentModulePoliceBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentModulePoliceBinding22 = null;
        }
        TextView textView5 = fragmentModulePoliceBinding22.g;
        if (booleanValue4) {
            f = 1.0f;
        }
        textView5.setAlpha(f);
        FragmentModulePoliceBinding fragmentModulePoliceBinding23 = this.j;
        if (fragmentModulePoliceBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentModulePoliceBinding2 = fragmentModulePoliceBinding23;
        }
        fragmentModulePoliceBinding2.g.setOnClickListener(new k7(this));
    }

    public final void O0(View view, String str) {
        DataStoreUtils.e.a().o(str, Boolean.FALSE);
        view.setEnabled(false);
        view.setAlpha(0.25f);
        SuperMessageManger.m.a().m0();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentModulePoliceBinding c = FragmentModulePoliceBinding.c(layoutInflater, viewGroup, false);
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
