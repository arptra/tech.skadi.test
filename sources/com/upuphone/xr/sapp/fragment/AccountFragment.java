package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.fragment.FragmentKt;
import com.honey.account.h8.d0;
import com.honey.account.h8.e0;
import com.honey.account.h8.f0;
import com.honey.account.h8.g0;
import com.honey.account.h8.h0;
import com.honey.account.h8.i0;
import com.honey.account.h8.j0;
import com.honey.account.h8.k0;
import com.honey.account.h8.l0;
import com.honey.account.h8.m0;
import com.honey.account.h8.n0;
import com.honey.account.h8.o0;
import com.honey.account.h8.p0;
import com.honey.account.h8.q0;
import com.honey.account.h8.r0;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.common.R;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.ProtocolType;
import com.upuphone.xr.sapp.databinding.FragmentAccountBinding;
import com.upuphone.xr.sapp.entity.AccountInfo;
import com.upuphone.xr.sapp.utils.AccountExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/upuphone/xr/sapp/fragment/AccountFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "P0", "Lcom/upuphone/xr/sapp/entity/AccountInfo;", "accountInfo", "c1", "(Lcom/upuphone/xr/sapp/entity/AccountInfo;)V", "", "phone", "b1", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/upuphone/xr/sapp/databinding/FragmentAccountBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentAccountBinding;", "binding", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAccountFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccountFragment.kt\ncom/upuphone/xr/sapp/fragment/AccountFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,185:1\n256#2,2:186\n256#2,2:188\n256#2,2:190\n256#2,2:192\n256#2,2:194\n256#2,2:196\n256#2,2:198\n256#2,2:200\n256#2,2:202\n256#2,2:204\n256#2,2:206\n256#2,2:208\n256#2,2:210\n256#2,2:212\n256#2,2:214\n256#2,2:216\n254#2:218\n256#2,2:219\n*S KotlinDebug\n*F\n+ 1 AccountFragment.kt\ncom/upuphone/xr/sapp/fragment/AccountFragment\n*L\n72#1:186,2\n86#1:188,2\n87#1:190,2\n88#1:192,2\n89#1:194,2\n90#1:196,2\n91#1:198,2\n92#1:200,2\n99#1:202,2\n100#1:204,2\n101#1:206,2\n102#1:208,2\n106#1:210,2\n147#1:212,2\n157#1:214,2\n162#1:216,2\n163#1:218\n80#1:219,2\n*E\n"})
public final class AccountFragment extends BaseFragment {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public FragmentAccountBinding j;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/AccountFragment$Companion;", "", "()V", "REAL_NAME_ACTION", "", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void Q0(AccountFragment accountFragment) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        accountFragment.c1(MzAccountManager.c.a());
    }

    public static final void R0(AccountFragment accountFragment, View view) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        ContractEntry contractEntry = ContractEntry.f6691a;
        FragmentActivity requireActivity = accountFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ContractEntry.w(contractEntry, requireActivity, ProtocolType.ACCOUNT_AUP, (String) null, 4, (Object) null);
    }

    public static final void S0(AccountFragment accountFragment, View view) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        ContractEntry contractEntry = ContractEntry.f6691a;
        FragmentActivity requireActivity = accountFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ContractEntry.w(contractEntry, requireActivity, ProtocolType.ACCOUNT_PP, (String) null, 4, (Object) null);
    }

    public static final void T0(AccountFragment accountFragment, View view) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        ContractEntry contractEntry = ContractEntry.f6691a;
        FragmentActivity requireActivity = accountFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ContractEntry.w(contractEntry, requireActivity, ProtocolType.ACCOUNT_PICL, (String) null, 4, (Object) null);
    }

    public static final void U0(AccountFragment accountFragment, View view) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        ContractEntry contractEntry = ContractEntry.f6691a;
        FragmentActivity requireActivity = accountFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ContractEntry.w(contractEntry, requireActivity, ProtocolType.ACCOUNT_TISL, (String) null, 4, (Object) null);
    }

    public static final void V0(AccountFragment accountFragment, View view) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        ContractEntry contractEntry = ContractEntry.f6691a;
        FragmentActivity requireActivity = accountFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ContractEntry.w(contractEntry, requireActivity, ProtocolType.ACCOUNT_PCPI, (String) null, 4, (Object) null);
    }

    public static final void W0(AccountFragment accountFragment, View view) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        try {
            AccountExt accountExt = AccountExt.f7838a;
            FragmentActivity requireActivity = accountFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            accountExt.c(requireActivity);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("AccountFragment", "real name error: e: " + message);
        }
    }

    public static final void X0(AccountFragment accountFragment, View view) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        ContractEntry contractEntry = ContractEntry.f6691a;
        FragmentActivity requireActivity = accountFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ContractEntry.w(contractEntry, requireActivity, ProtocolType.CATEGORY_AIUP, (String) null, 4, (Object) null);
    }

    public static final void Y0(AccountFragment accountFragment, View view) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        ULog.f6446a.a("AccountFragment", "url WINDOW_TYPE_AI_PP_MODEL");
        ContractEntry contractEntry = ContractEntry.f6691a;
        FragmentActivity requireActivity = accountFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ContractEntry.w(contractEntry, requireActivity, ProtocolType.CATEGORY_AIPP, (String) null, 4, (Object) null);
    }

    public static final void Z0(AccountFragment accountFragment, View view) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        FragmentKt.a(accountFragment).T();
    }

    public static final void a1(AccountFragment accountFragment, View view) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        try {
            Boolean bool = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
            if (bool.booleanValue()) {
                String v = NetConfig.f6666a.v("cloudCancelService");
                ULog.Delegate delegate = ULog.f6446a;
                delegate.c("AccountFragment", "accountLogout url=" + v);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(v));
                Context context = accountFragment.getContext();
                if (context != null) {
                    context.startActivity(intent);
                    return;
                }
                return;
            }
            MzAccountManager.c.b().f();
        } catch (Exception e) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("AccountFragment", "e: " + e);
        }
    }

    public static final void d1(AccountFragment accountFragment, AccountInfo accountInfo) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        FragmentAccountBinding fragmentAccountBinding = null;
        String b1 = accountFragment.b1(accountInfo != null ? accountInfo.getPhone() : null);
        FragmentAccountBinding fragmentAccountBinding2 = accountFragment.j;
        if (fragmentAccountBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentAccountBinding = fragmentAccountBinding2;
        }
        fragmentAccountBinding.d.setText(b1);
    }

    public static final void e1(AccountFragment accountFragment) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        FragmentAccountBinding fragmentAccountBinding = accountFragment.j;
        if (fragmentAccountBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding = null;
        }
        fragmentAccountBinding.d.setText("");
    }

    public static final void f1(AccountFragment accountFragment) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        FragmentAccountBinding fragmentAccountBinding = accountFragment.j;
        if (fragmentAccountBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding = null;
        }
        fragmentAccountBinding.g.setText("");
    }

    public static final void g1(AccountFragment accountFragment) {
        Intrinsics.checkNotNullParameter(accountFragment, "this$0");
        FragmentAccountBinding fragmentAccountBinding = accountFragment.j;
        if (fragmentAccountBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding = null;
        }
        TextView textView = fragmentAccountBinding.c;
        Intrinsics.checkNotNullExpressionValue(textView, "accountLogout");
        textView.setVisibility(8);
    }

    private final void initView() {
        Unit unit;
        FragmentAccountBinding fragmentAccountBinding = this.j;
        FragmentAccountBinding fragmentAccountBinding2 = null;
        if (fragmentAccountBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding = null;
        }
        ConstraintLayout constraintLayout = fragmentAccountBinding.k;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "centerItem");
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        int i = 0;
        constraintLayout.setVisibility(bool.booleanValue() ? 0 : 8);
        FragmentAccountBinding fragmentAccountBinding3 = this.j;
        if (fragmentAccountBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding3 = null;
        }
        TextView textView = fragmentAccountBinding3.m;
        Intrinsics.checkNotNullExpressionValue(textView, "flymePrivacyText");
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        textView.setVisibility(bool.booleanValue() ? 0 : 8);
        FragmentAccountBinding fragmentAccountBinding4 = this.j;
        if (fragmentAccountBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding4 = null;
        }
        TextView textView2 = fragmentAccountBinding4.l;
        Intrinsics.checkNotNullExpressionValue(textView2, "childrenInfo");
        textView2.setVisibility(8);
        FragmentAccountBinding fragmentAccountBinding5 = this.j;
        if (fragmentAccountBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding5 = null;
        }
        TextView textView3 = fragmentAccountBinding5.n;
        Intrinsics.checkNotNullExpressionValue(textView3, "personalInfo");
        textView3.setVisibility(8);
        FragmentAccountBinding fragmentAccountBinding6 = this.j;
        if (fragmentAccountBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding6 = null;
        }
        TextView textView4 = fragmentAccountBinding6.q;
        Intrinsics.checkNotNullExpressionValue(textView4, "thirdShare");
        textView4.setVisibility(8);
        FragmentAccountBinding fragmentAccountBinding7 = this.j;
        if (fragmentAccountBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding7 = null;
        }
        TextView textView5 = fragmentAccountBinding7.o;
        Intrinsics.checkNotNullExpressionValue(textView5, "privacyPolicy");
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        textView5.setVisibility(bool.booleanValue() ? 0 : 8);
        FragmentAccountBinding fragmentAccountBinding8 = this.j;
        if (fragmentAccountBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding8 = null;
        }
        TextView textView6 = fragmentAccountBinding8.h;
        Intrinsics.checkNotNullExpressionValue(textView6, "accountTitle");
        textView6.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            FragmentAccountBinding fragmentAccountBinding9 = this.j;
            if (fragmentAccountBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAccountBinding9 = null;
            }
            fragmentAccountBinding9.f.setBackgroundResource(R.drawable.card_item_full_round_selector);
            FragmentAccountBinding fragmentAccountBinding10 = this.j;
            if (fragmentAccountBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAccountBinding10 = null;
            }
            fragmentAccountBinding10.o.setBackgroundResource(R.drawable.card_item_bottom_round_selector);
        }
        AccountInfo a2 = MzAccountManager.c.a();
        if (a2 != null) {
            FragmentAccountBinding fragmentAccountBinding11 = this.j;
            if (fragmentAccountBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAccountBinding11 = null;
            }
            ConstraintLayout constraintLayout2 = fragmentAccountBinding11.e;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "accountNameLayout");
            constraintLayout2.setVisibility(0);
            FragmentAccountBinding fragmentAccountBinding12 = this.j;
            if (fragmentAccountBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAccountBinding12 = null;
            }
            TextView textView7 = fragmentAccountBinding12.d;
            Intrinsics.checkNotNullExpressionValue(textView7, "accountName");
            textView7.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
            FragmentAccountBinding fragmentAccountBinding13 = this.j;
            if (fragmentAccountBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAccountBinding13 = null;
            }
            TextView textView8 = fragmentAccountBinding13.g;
            Intrinsics.checkNotNullExpressionValue(textView8, "accountNicknameValue");
            textView8.setVisibility(0);
            FragmentAccountBinding fragmentAccountBinding14 = this.j;
            if (fragmentAccountBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAccountBinding14 = null;
            }
            TextView textView9 = fragmentAccountBinding14.c;
            Intrinsics.checkNotNullExpressionValue(textView9, "accountLogout");
            textView9.setVisibility(0);
            FragmentAccountBinding fragmentAccountBinding15 = this.j;
            if (fragmentAccountBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAccountBinding15 = null;
            }
            fragmentAccountBinding15.d.setText(a2.getPhoneWithoutSensitivities());
            FragmentAccountBinding fragmentAccountBinding16 = this.j;
            if (fragmentAccountBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAccountBinding16 = null;
            }
            fragmentAccountBinding16.g.setText(a2.getNickname());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            FragmentAccountBinding fragmentAccountBinding17 = this.j;
            if (fragmentAccountBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAccountBinding17 = null;
            }
            ConstraintLayout constraintLayout3 = fragmentAccountBinding17.e;
            Intrinsics.checkNotNullExpressionValue(constraintLayout3, "accountNameLayout");
            constraintLayout3.setVisibility(8);
        }
        FragmentAccountBinding fragmentAccountBinding18 = this.j;
        if (fragmentAccountBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding18 = null;
        }
        fragmentAccountBinding18.b.setOnClickListener(new d0(this));
        FragmentAccountBinding fragmentAccountBinding19 = this.j;
        if (fragmentAccountBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding19 = null;
        }
        fragmentAccountBinding19.c.setOnClickListener(new j0(this));
        FragmentAccountBinding fragmentAccountBinding20 = this.j;
        if (fragmentAccountBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding20 = null;
        }
        fragmentAccountBinding20.m.setOnClickListener(new k0(this));
        FragmentAccountBinding fragmentAccountBinding21 = this.j;
        if (fragmentAccountBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding21 = null;
        }
        fragmentAccountBinding21.o.setOnClickListener(new l0(this));
        FragmentAccountBinding fragmentAccountBinding22 = this.j;
        if (fragmentAccountBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding22 = null;
        }
        fragmentAccountBinding22.n.setOnClickListener(new m0(this));
        FragmentAccountBinding fragmentAccountBinding23 = this.j;
        if (fragmentAccountBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding23 = null;
        }
        fragmentAccountBinding23.q.setOnClickListener(new n0(this));
        FragmentAccountBinding fragmentAccountBinding24 = this.j;
        if (fragmentAccountBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding24 = null;
        }
        fragmentAccountBinding24.l.setOnClickListener(new o0(this));
        FragmentAccountBinding fragmentAccountBinding25 = this.j;
        if (fragmentAccountBinding25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding25 = null;
        }
        TextView textView10 = fragmentAccountBinding25.p;
        Intrinsics.checkNotNullExpressionValue(textView10, "realNameAuth");
        textView10.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        FragmentAccountBinding fragmentAccountBinding26 = this.j;
        if (fragmentAccountBinding26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding26 = null;
        }
        fragmentAccountBinding26.p.setOnClickListener(new p0(this));
        FragmentAccountBinding fragmentAccountBinding27 = this.j;
        if (fragmentAccountBinding27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding27 = null;
        }
        TextView textView11 = fragmentAccountBinding27.i;
        Intrinsics.checkNotNullExpressionValue(textView11, "aiModel");
        textView11.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        FragmentAccountBinding fragmentAccountBinding28 = this.j;
        if (fragmentAccountBinding28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding28 = null;
        }
        fragmentAccountBinding28.i.setOnClickListener(new q0(this));
        FragmentAccountBinding fragmentAccountBinding29 = this.j;
        if (fragmentAccountBinding29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding29 = null;
        }
        TextView textView12 = fragmentAccountBinding29.j;
        Intrinsics.checkNotNullExpressionValue(textView12, "aiPpModel");
        if (!(!bool.booleanValue())) {
            i = 8;
        }
        textView12.setVisibility(i);
        FragmentAccountBinding fragmentAccountBinding30 = this.j;
        if (fragmentAccountBinding30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding30 = null;
        }
        TextView textView13 = fragmentAccountBinding30.j;
        Intrinsics.checkNotNullExpressionValue(textView13, "aiPpModel");
        if (textView13.getVisibility() == 0) {
            FragmentAccountBinding fragmentAccountBinding31 = this.j;
            if (fragmentAccountBinding31 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAccountBinding31 = null;
            }
            fragmentAccountBinding31.q.setBackgroundResource(R.drawable.card_item_middle_rectangle_selector);
        } else {
            FragmentAccountBinding fragmentAccountBinding32 = this.j;
            if (fragmentAccountBinding32 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAccountBinding32 = null;
            }
            fragmentAccountBinding32.q.setBackgroundResource(R.drawable.card_item_bottom_round_selector);
        }
        FragmentAccountBinding fragmentAccountBinding33 = this.j;
        if (fragmentAccountBinding33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentAccountBinding2 = fragmentAccountBinding33;
        }
        fragmentAccountBinding2.j.setOnClickListener(new r0(this));
    }

    public final void P0() {
        FragmentAccountBinding fragmentAccountBinding = this.j;
        if (fragmentAccountBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding = null;
        }
        fragmentAccountBinding.getRoot().postDelayed(new e0(this), 1000);
    }

    public final String b1(String str) {
        if (str == null) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String substring = str.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String substring2 = str.substring(7, str.length());
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return substring + "****" + substring2;
    }

    public final void c1(AccountInfo accountInfo) {
        ULog.f6446a.g("AccountFragment", "updateLoginState() called with: accountInfo = " + accountInfo);
        FragmentAccountBinding fragmentAccountBinding = this.j;
        FragmentAccountBinding fragmentAccountBinding2 = null;
        if (fragmentAccountBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAccountBinding = null;
        }
        fragmentAccountBinding.d.post(new f0(this, accountInfo));
        if (accountInfo == null) {
            FragmentAccountBinding fragmentAccountBinding3 = this.j;
            if (fragmentAccountBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAccountBinding3 = null;
            }
            ConstraintLayout constraintLayout = fragmentAccountBinding3.e;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "accountNameLayout");
            constraintLayout.setVisibility(8);
            FragmentAccountBinding fragmentAccountBinding4 = this.j;
            if (fragmentAccountBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAccountBinding4 = null;
            }
            fragmentAccountBinding4.d.post(new g0(this));
            FragmentAccountBinding fragmentAccountBinding5 = this.j;
            if (fragmentAccountBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAccountBinding5 = null;
            }
            fragmentAccountBinding5.g.post(new h0(this));
            FragmentAccountBinding fragmentAccountBinding6 = this.j;
            if (fragmentAccountBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentAccountBinding2 = fragmentAccountBinding6;
            }
            fragmentAccountBinding2.c.post(new i0(this));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentAccountBinding c = FragmentAccountBinding.c(layoutInflater, viewGroup, false);
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

    public void onResume() {
        super.onResume();
        P0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }
}
