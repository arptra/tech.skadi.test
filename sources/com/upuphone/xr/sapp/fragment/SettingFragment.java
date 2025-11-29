package com.upuphone.xr.sapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.here.odnp.config.OdnpConfigStatic;
import com.honey.account.h8.a9;
import com.honey.account.h8.b9;
import com.honey.account.h8.c9;
import com.honey.account.h8.d9;
import com.honey.account.h8.e9;
import com.honey.account.h8.f9;
import com.honey.account.h8.g9;
import com.honey.account.h8.w8;
import com.honey.account.h8.x8;
import com.honey.account.h8.y8;
import com.honey.account.h8.z8;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.ProtocolType;
import com.upuphone.xr.sapp.databinding.FragmentSettingBinding;
import com.upuphone.xr.sapp.entity.AccountInfo;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.xjmz.myvu.dialog.NormalTwoBtnDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J-\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/upuphone/xr/sapp/fragment/SettingFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "M0", "N0", "Lcom/upuphone/xr/sapp/entity/AccountInfo;", "accountInfo", "a1", "(Lcom/upuphone/xr/sapp/entity/AccountInfo;)V", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "Z0", "Lcom/upuphone/xr/sapp/databinding/FragmentSettingBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentSettingBinding;", "binding", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSettingFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingFragment.kt\ncom/upuphone/xr/sapp/fragment/SettingFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,178:1\n256#2,2:179\n256#2,2:181\n256#2,2:183\n256#2,2:185\n256#2,2:187\n256#2,2:189\n256#2,2:191\n256#2,2:193\n256#2,2:195\n256#2,2:197\n*S KotlinDebug\n*F\n+ 1 SettingFragment.kt\ncom/upuphone/xr/sapp/fragment/SettingFragment\n*L\n75#1:179,2\n76#1:181,2\n78#1:183,2\n79#1:185,2\n86#1:187,2\n87#1:189,2\n119#1:191,2\n125#1:193,2\n135#1:195,2\n146#1:197,2\n*E\n"})
public final class SettingFragment extends BaseFragment {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public FragmentSettingBinding j;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/SettingFragment$Companion;", "", "()V", "MYVU_CAC_URL", "", "MYVU_ICP_URL", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final void M0() {
        AppUpdateHelper.f7841a.B().observe(getViewLifecycleOwner(), new SettingFragment$sam$androidx_lifecycle_Observer$0(new SettingFragment$addObserver$1(this)));
    }

    private final void N0() {
        FragmentSettingBinding fragmentSettingBinding = this.j;
        if (fragmentSettingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSettingBinding = null;
        }
        fragmentSettingBinding.getRoot().postDelayed(new w8(this), 1000);
    }

    public static final void O0(SettingFragment settingFragment) {
        Intrinsics.checkNotNullParameter(settingFragment, "this$0");
        settingFragment.a1(MzAccountManager.c.a());
    }

    public static final void P0(SettingFragment settingFragment, View view) {
        Intrinsics.checkNotNullParameter(settingFragment, "this$0");
        ContractEntry contractEntry = ContractEntry.f6691a;
        FragmentActivity requireActivity = settingFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ContractEntry.w(contractEntry, requireActivity, ProtocolType.CATEGORY_TISL, (String) null, 4, (Object) null);
    }

    public static final void Q0(SettingFragment settingFragment, View view) {
        Intrinsics.checkNotNullParameter(settingFragment, "this$0");
        ContractEntry contractEntry = ContractEntry.f6691a;
        FragmentActivity requireActivity = settingFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ContractEntry.w(contractEntry, requireActivity, ProtocolType.CATEGORY_PP, (String) null, 4, (Object) null);
    }

    public static final void R0(SettingFragment settingFragment, View view) {
        Intrinsics.checkNotNullParameter(settingFragment, "this$0");
        settingFragment.requireContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://beian.miit.gov.cn/")));
    }

    public static final void S0(SettingFragment settingFragment, View view) {
        Intrinsics.checkNotNullParameter(settingFragment, "this$0");
        settingFragment.requireContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://beian.cac.gov.cn/#/index")));
    }

    public static final void T0(SettingFragment settingFragment, View view) {
        Intrinsics.checkNotNullParameter(settingFragment, "this$0");
        StaticMethodUtilsKt.q(settingFragment);
    }

    public static final void U0(SettingFragment settingFragment, View view) {
        Intrinsics.checkNotNullParameter(settingFragment, "this$0");
        StaticMethodUtilsKt.t(settingFragment, R.id.accountFragment);
    }

    public static final void V0(SettingFragment settingFragment, View view) {
        Intrinsics.checkNotNullParameter(settingFragment, "this$0");
        StaticMethodUtilsKt.t(settingFragment, R.id.aboutSuperappFragment);
    }

    public static final void W0(SettingFragment settingFragment, View view) {
        Intrinsics.checkNotNullParameter(settingFragment, "this$0");
        StaticMethodUtilsKt.t(settingFragment, R.id.permissionManagerFragment);
    }

    public static final void X0(SettingFragment settingFragment, View view) {
        Intrinsics.checkNotNullParameter(settingFragment, "this$0");
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        if (bool.booleanValue()) {
            settingFragment.Z0();
            return;
        }
        try {
            MzAccountManager.c.b().f();
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("SettingFragment", "e: " + e);
        }
    }

    public static final void Y0(SettingFragment settingFragment, View view) {
        Intrinsics.checkNotNullParameter(settingFragment, "this$0");
        ContractEntry contractEntry = ContractEntry.f6691a;
        FragmentActivity requireActivity = settingFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ContractEntry.w(contractEntry, requireActivity, ProtocolType.CATEGORY_PICL, (String) null, 4, (Object) null);
    }

    private final void a1(AccountInfo accountInfo) {
        Unit unit;
        ULog.f6446a.g("SettingFragment", "updateLoginState() called with: accountInfo = " + accountInfo);
        FragmentSettingBinding fragmentSettingBinding = null;
        if (accountInfo != null) {
            FragmentSettingBinding fragmentSettingBinding2 = this.j;
            if (fragmentSettingBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentSettingBinding2 = null;
            }
            ConstraintLayout constraintLayout = fragmentSettingBinding2.d;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "accountCenterLayout");
            constraintLayout.setVisibility(0);
            FragmentSettingBinding fragmentSettingBinding3 = this.j;
            if (fragmentSettingBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentSettingBinding3 = null;
            }
            TextView textView = fragmentSettingBinding3.e;
            Intrinsics.checkNotNullExpressionValue(textView, "accountLogout");
            textView.setVisibility(0);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            FragmentSettingBinding fragmentSettingBinding4 = this.j;
            if (fragmentSettingBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentSettingBinding4 = null;
            }
            ConstraintLayout constraintLayout2 = fragmentSettingBinding4.d;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "accountCenterLayout");
            constraintLayout2.setVisibility(8);
            FragmentSettingBinding fragmentSettingBinding5 = this.j;
            if (fragmentSettingBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentSettingBinding = fragmentSettingBinding5;
            }
            TextView textView2 = fragmentSettingBinding.e;
            Intrinsics.checkNotNullExpressionValue(textView2, "accountLogout");
            textView2.setVisibility(8);
        }
    }

    private final void initView() {
        ULog.f6446a.a("SettingFragment", "initView");
        int i = 0;
        FragmentSettingBinding fragmentSettingBinding = null;
        if (MzAccountManager.c.a() != null) {
            FragmentSettingBinding fragmentSettingBinding2 = this.j;
            if (fragmentSettingBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentSettingBinding2 = null;
            }
            ConstraintLayout constraintLayout = fragmentSettingBinding2.d;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "accountCenterLayout");
            constraintLayout.setVisibility(0);
            FragmentSettingBinding fragmentSettingBinding3 = this.j;
            if (fragmentSettingBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentSettingBinding3 = null;
            }
            TextView textView = fragmentSettingBinding3.e;
            Intrinsics.checkNotNullExpressionValue(textView, "accountLogout");
            textView.setVisibility(0);
        }
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            FragmentSettingBinding fragmentSettingBinding4 = this.j;
            if (fragmentSettingBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentSettingBinding4 = null;
            }
            fragmentSettingBinding4.b.setText(getString(R.string.about_superapp_oversea));
            FragmentSettingBinding fragmentSettingBinding5 = this.j;
            if (fragmentSettingBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentSettingBinding5 = null;
            }
            fragmentSettingBinding5.k.setText(getString(R.string.super_app_personal_info_list_oversea));
            FragmentSettingBinding fragmentSettingBinding6 = this.j;
            if (fragmentSettingBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentSettingBinding6 = null;
            }
            fragmentSettingBinding6.o.setText(getString(R.string.super_app_third_share_list_oversea));
        }
        FragmentSettingBinding fragmentSettingBinding7 = this.j;
        if (fragmentSettingBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSettingBinding7 = null;
        }
        fragmentSettingBinding7.n.setOnClickListener(new y8(this));
        FragmentSettingBinding fragmentSettingBinding8 = this.j;
        if (fragmentSettingBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSettingBinding8 = null;
        }
        fragmentSettingBinding8.c.setOnClickListener(new z8(this));
        FragmentSettingBinding fragmentSettingBinding9 = this.j;
        if (fragmentSettingBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSettingBinding9 = null;
        }
        fragmentSettingBinding9.b.setOnClickListener(new a9(this));
        FragmentSettingBinding fragmentSettingBinding10 = this.j;
        if (fragmentSettingBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSettingBinding10 = null;
        }
        fragmentSettingBinding10.j.setOnClickListener(new b9(this));
        FragmentSettingBinding fragmentSettingBinding11 = this.j;
        if (fragmentSettingBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSettingBinding11 = null;
        }
        fragmentSettingBinding11.e.setOnClickListener(new c9(this));
        FragmentSettingBinding fragmentSettingBinding12 = this.j;
        if (fragmentSettingBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSettingBinding12 = null;
        }
        TextView textView2 = fragmentSettingBinding12.k;
        Intrinsics.checkNotNullExpressionValue(textView2, "personalInfo");
        textView2.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        FragmentSettingBinding fragmentSettingBinding13 = this.j;
        if (fragmentSettingBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSettingBinding13 = null;
        }
        fragmentSettingBinding13.k.setOnClickListener(new d9(this));
        FragmentSettingBinding fragmentSettingBinding14 = this.j;
        if (fragmentSettingBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSettingBinding14 = null;
        }
        TextView textView3 = fragmentSettingBinding14.o;
        Intrinsics.checkNotNullExpressionValue(textView3, "thirdShare");
        textView3.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        FragmentSettingBinding fragmentSettingBinding15 = this.j;
        if (fragmentSettingBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSettingBinding15 = null;
        }
        fragmentSettingBinding15.o.setOnClickListener(new e9(this));
        FragmentSettingBinding fragmentSettingBinding16 = this.j;
        if (fragmentSettingBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSettingBinding16 = null;
        }
        fragmentSettingBinding16.l.setOnClickListener(new f9(this));
        FragmentSettingBinding fragmentSettingBinding17 = this.j;
        if (fragmentSettingBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSettingBinding17 = null;
        }
        TextView textView4 = fragmentSettingBinding17.m;
        Intrinsics.checkNotNullExpressionValue(textView4, "recordation");
        textView4.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        FragmentSettingBinding fragmentSettingBinding18 = this.j;
        if (fragmentSettingBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSettingBinding18 = null;
        }
        fragmentSettingBinding18.m.setOnClickListener(new g9(this));
        FragmentSettingBinding fragmentSettingBinding19 = this.j;
        if (fragmentSettingBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSettingBinding19 = null;
        }
        TextView textView5 = fragmentSettingBinding19.f;
        Intrinsics.checkNotNullExpressionValue(textView5, "cacTv");
        if (!(!bool.booleanValue())) {
            i = 8;
        }
        textView5.setVisibility(i);
        FragmentSettingBinding fragmentSettingBinding20 = this.j;
        if (fragmentSettingBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentSettingBinding = fragmentSettingBinding20;
        }
        fragmentSettingBinding.f.setOnClickListener(new x8(this));
    }

    public final void Z0() {
        NormalTwoBtnDialog.Companion companion = NormalTwoBtnDialog.k;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        String string = getString(R.string.flyme_account_logout_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.exit_login_connect_unbind_tip);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        String string3 = getString(bool.booleanValue() ? R.string.word_exit : R.string.exit_login_btn_confirm);
        Intrinsics.checkNotNull(string3);
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        String string4 = getString(bool.booleanValue() ? R.string.cancel : R.string.exit_login_btn_cancel);
        Intrinsics.checkNotNull(string4);
        NormalTwoBtnDialog.Companion.b(companion, requireActivity, string, string2, string3, string4, new SettingFragment$showLoginOutDialog$1(this), (Function0) null, (Function0) null, false, false, OdnpConfigStatic.UPLOAD_MEDIUM_PRIORITY_DURATION_MINUTES, (Object) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentSettingBinding c = FragmentSettingBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        return c.getRoot();
    }

    public void onResume() {
        super.onResume();
        N0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        M0();
    }
}
