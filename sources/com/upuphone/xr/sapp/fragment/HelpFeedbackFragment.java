package com.upuphone.xr.sapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.asm.Opcodes;
import com.honey.account.h8.i5;
import com.honey.account.h8.j5;
import com.honey.account.h8.k5;
import com.honey.account.h8.l5;
import com.honey.account.h8.m5;
import com.honey.account.h8.n5;
import com.honey.account.h8.o5;
import com.honey.account.h8.p5;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.FeedbackActivity;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentHelpFeedbackBinding;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vu.utils.VuWebViewUtils;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.xjmz.myvu.dialog.LoginFragmentDialog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010\u0003R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/HelpFeedbackFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "windowType", "actionType", "a", "(II)V", "", "result", "", "reason", "permission", "tag", "w0", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "title", "url", "version", "S0", "(Ljava/lang/String;Ljava/lang/String;I)V", "R0", "Lcom/upuphone/xr/sapp/databinding/FragmentHelpFeedbackBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentHelpFeedbackBinding;", "binding", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@Deprecated(message = "帮助与反馈已用 Flutter 重写，此页面已废弃")
public final class HelpFeedbackFragment extends BaseFragment {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public FragmentHelpFeedbackBinding j;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/HelpFeedbackFragment$Companion;", "", "()V", "MAINTENANCE_QUERY_H5_URL", "", "ONLINE_CONSULTATION_H5_URL", "REPAIR_H5_URL", "REQ_CALL_PERMISSION_TAG", "SERVICE_POLICE_H5_URL", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void J0(HelpFeedbackFragment helpFeedbackFragment, View view) {
        Intrinsics.checkNotNullParameter(helpFeedbackFragment, "this$0");
        StaticMethodUtilsKt.q(helpFeedbackFragment);
    }

    public static final void K0(HelpFeedbackFragment helpFeedbackFragment, View view) {
        Intrinsics.checkNotNullParameter(helpFeedbackFragment, "this$0");
        ULog.f6446a.a("HelpFeedbackFragment", "click feedback");
        if (!helpFeedbackFragment.u0()) {
            helpFeedbackFragment.requireActivity().startActivity(new Intent(helpFeedbackFragment.requireActivity(), FeedbackActivity.class));
            helpFeedbackFragment.requireActivity().overridePendingTransition(R.anim.next_open_enter, R.anim.next_open_exit);
            return;
        }
        LoginFragmentDialog.Companion companion = LoginFragmentDialog.d;
        FragmentActivity requireActivity = helpFeedbackFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        companion.a(requireActivity);
    }

    public static final void L0(HelpFeedbackFragment helpFeedbackFragment, View view) {
        Intrinsics.checkNotNullParameter(helpFeedbackFragment, "this$0");
        ULog.f6446a.a("HelpFeedbackFragment", "click query");
        String string = helpFeedbackFragment.getString(R.string.maintenance_query);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        helpFeedbackFragment.S0(string, "https://service.meizu.com/query/repair.html", 1);
    }

    public static final void M0(HelpFeedbackFragment helpFeedbackFragment, View view) {
        Intrinsics.checkNotNullParameter(helpFeedbackFragment, "this$0");
        ULog.f6446a.a("HelpFeedbackFragment", "click servicePolice");
        String string = helpFeedbackFragment.getString(R.string.service_police);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        helpFeedbackFragment.S0(string, "https://service.meizu.com/help/after_ser.html", 1);
    }

    public static final void N0(HelpFeedbackFragment helpFeedbackFragment, View view) {
        Intrinsics.checkNotNullParameter(helpFeedbackFragment, "this$0");
        ULog.f6446a.a("HelpFeedbackFragment", "click phone");
        helpFeedbackFragment.R0();
    }

    public static final void O0(HelpFeedbackFragment helpFeedbackFragment, View view) {
        Intrinsics.checkNotNullParameter(helpFeedbackFragment, "this$0");
        ULog.f6446a.a("HelpFeedbackFragment", "click repair");
        String string = helpFeedbackFragment.getString(R.string.express_delivery_for_repair);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        helpFeedbackFragment.S0(string, "https://service.meizu.com/repair/delivery.html", 1);
    }

    public static final void P0(HelpFeedbackFragment helpFeedbackFragment, View view) {
        Intrinsics.checkNotNullParameter(helpFeedbackFragment, "this$0");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("HelpFeedbackFragment", "click llConsultation");
        if (helpFeedbackFragment.u0()) {
            delegate.a("HelpFeedbackFragment", "jumpTo fail need account");
            LoginFragmentDialog.Companion companion = LoginFragmentDialog.d;
            FragmentActivity requireActivity = helpFeedbackFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            companion.a(requireActivity);
            return;
        }
        String string = helpFeedbackFragment.getString(R.string.online_consultation);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        helpFeedbackFragment.S0(string, "https://crc.meizu.com/FS_WEB_ASS/cloud/meizu/app_websocket.html?vdnId=1&originId=454087571119857664", 1);
    }

    public static final void Q0(HelpFeedbackFragment helpFeedbackFragment, View view) {
        Intrinsics.checkNotNullParameter(helpFeedbackFragment, "this$0");
        ULog.f6446a.a("HelpFeedbackFragment", "click frequentlyAsked");
        String c = VuWebViewUtils.f8107a.c();
        String string = helpFeedbackFragment.getString(R.string.frequently_asked);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Bundle bundle = new Bundle();
        bundle.putString("h5_url", c);
        bundle.putString("h5_title", string);
        StaticMethodUtilsKt.v(helpFeedbackFragment, R.id.commonH5Fragment, bundle);
    }

    private final void initView() {
        ULog.f6446a.a("SettingFragment", "initView");
        FragmentHelpFeedbackBinding fragmentHelpFeedbackBinding = this.j;
        FragmentHelpFeedbackBinding fragmentHelpFeedbackBinding2 = null;
        if (fragmentHelpFeedbackBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHelpFeedbackBinding = null;
        }
        fragmentHelpFeedbackBinding.f.setOnClickListener(new i5(this));
        FragmentHelpFeedbackBinding fragmentHelpFeedbackBinding3 = this.j;
        if (fragmentHelpFeedbackBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHelpFeedbackBinding3 = null;
        }
        fragmentHelpFeedbackBinding3.i.setOnClickListener(new j5(this));
        FragmentHelpFeedbackBinding fragmentHelpFeedbackBinding4 = this.j;
        if (fragmentHelpFeedbackBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHelpFeedbackBinding4 = null;
        }
        fragmentHelpFeedbackBinding4.b.setOnClickListener(new k5(this));
        FragmentHelpFeedbackBinding fragmentHelpFeedbackBinding5 = this.j;
        if (fragmentHelpFeedbackBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHelpFeedbackBinding5 = null;
        }
        fragmentHelpFeedbackBinding5.k.setOnClickListener(new l5(this));
        FragmentHelpFeedbackBinding fragmentHelpFeedbackBinding6 = this.j;
        if (fragmentHelpFeedbackBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHelpFeedbackBinding6 = null;
        }
        fragmentHelpFeedbackBinding6.j.setOnClickListener(new m5(this));
        FragmentHelpFeedbackBinding fragmentHelpFeedbackBinding7 = this.j;
        if (fragmentHelpFeedbackBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHelpFeedbackBinding7 = null;
        }
        fragmentHelpFeedbackBinding7.d.setOnClickListener(new n5(this));
        FragmentHelpFeedbackBinding fragmentHelpFeedbackBinding8 = this.j;
        if (fragmentHelpFeedbackBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHelpFeedbackBinding8 = null;
        }
        fragmentHelpFeedbackBinding8.h.setOnClickListener(new o5(this));
        VuGlassControlModel.f8109a.v().observe(getViewLifecycleOwner(), new HelpFeedbackFragment$sam$androidx_lifecycle_Observer$0(new HelpFeedbackFragment$initView$8(this)));
        FragmentHelpFeedbackBinding fragmentHelpFeedbackBinding9 = this.j;
        if (fragmentHelpFeedbackBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHelpFeedbackBinding2 = fragmentHelpFeedbackBinding9;
        }
        fragmentHelpFeedbackBinding2.c.setOnClickListener(new p5(this));
    }

    public final void R0() {
        ULog.f6446a.a("HelpFeedbackFragment", "requestGenericWindow");
        StaticMethodUtilsKt.I(this, CollectionsKt.arrayListOf(Integer.valueOf(Opcodes.LCMP)), false, false, 6, (Object) null);
    }

    public final void S0(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("policy_show_title", true);
        jSONObject.put("policy_title", str);
        jSONObject.put("policy_url", str2);
        jSONObject.put("policy_version", i);
        bundle.putString("policy_infos", jSONObject.toString());
        StaticMethodUtilsKt.v(this, R.id.helpFeedbackH5Fragment, bundle);
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        if (i == 148 && i2 == 1101) {
            ULog.Delegate delegate = ULog.f6446a;
            String string = getString(R.string.customer_server_number_tel);
            delegate.a("HelpFeedbackFragment", "jump to call tel: " + string);
            String string2 = getString(R.string.customer_server_number_tel);
            startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + string2)));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentHelpFeedbackBinding c = FragmentHelpFeedbackBinding.c(layoutInflater, viewGroup, false);
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

    public void w0(boolean z, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Intrinsics.checkNotNullParameter(str2, "permission");
        Intrinsics.checkNotNullParameter(str3, "tag");
        super.w0(z, str, str2, str3);
        if (z && Intrinsics.areEqual((Object) str3, (Object) "req_call_permission_tag")) {
            R0();
        }
    }
}
