package com.upuphone.xr.sapp.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.honey.account.h8.a0;
import com.honey.account.h8.b0;
import com.honey.account.h8.c0;
import com.honey.account.h8.o;
import com.honey.account.h8.p;
import com.honey.account.h8.q;
import com.honey.account.h8.r;
import com.honey.account.h8.s;
import com.honey.account.h8.t;
import com.honey.account.h8.u;
import com.honey.account.h8.v;
import com.honey.account.h8.w;
import com.honey.account.h8.x;
import com.honey.account.h8.y;
import com.honey.account.h8.z;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.httplib.HttpResult;
import com.upuphone.star.httplib.HttpResultKt;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.ProtocolActivity;
import com.upuphone.xr.sapp.contract.ProtocolType;
import com.upuphone.xr.sapp.databinding.DialogCancelAgreementBinding;
import com.upuphone.xr.sapp.databinding.FragmentAboutSuperappBinding;
import com.upuphone.xr.sapp.datatrack.DataTrackRuleHelper;
import com.upuphone.xr.sapp.entity.AppUpdateInfo;
import com.upuphone.xr.sapp.entity.BasicResponse;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.ClickSpanHelper;
import com.upuphone.xr.sapp.utils.ContextExtKt;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.HttpRequestUtil;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.VersionCheckUtil;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import com.upuphone.xr.sapp.view.CardItemView;
import com.upuphone.xr.sapp.view.LinearGradientForegroundSpan;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001f\u001a\u00020\u00042\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001bH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/AboutSuperAppFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "P0", "initView", "showLoading", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "d1", "R0", "", "text", "Landroid/text/SpannableString;", "e1", "(Ljava/lang/String;)Landroid/text/SpannableString;", "Lcom/upuphone/star/httplib/HttpResult;", "Lcom/upuphone/xr/sapp/entity/BasicResponse;", "Lcom/upuphone/xr/sapp/entity/AppUpdateInfo;", "httpResult", "Q0", "(Lcom/upuphone/star/httplib/HttpResult;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentAboutSuperappBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentAboutSuperappBinding;", "binding", "Landroid/animation/Animator;", "k", "Landroid/animation/Animator;", "loadingAnimator", "l", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAboutSuperAppFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AboutSuperAppFragment.kt\ncom/upuphone/xr/sapp/fragment/AboutSuperAppFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,455:1\n256#2,2:456\n256#2,2:458\n256#2,2:460\n256#2,2:462\n256#2,2:464\n256#2,2:466\n254#2:468\n254#2:469\n*S KotlinDebug\n*F\n+ 1 AboutSuperAppFragment.kt\ncom/upuphone/xr/sapp/fragment/AboutSuperAppFragment\n*L\n252#1:456,2\n265#1:458,2\n278#1:460,2\n322#1:462,2\n360#1:464,2\n361#1:466,2\n376#1:468\n439#1:469\n*E\n"})
public final class AboutSuperAppFragment extends BaseFragment {
    public static final Companion l = new Companion((DefaultConstructorMarker) null);
    public static int m = -1;
    public FragmentAboutSuperappBinding j;
    public Animator k;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/AboutSuperAppFragment$Companion;", "", "<init>", "()V", "Landroid/app/Activity;", "context", "Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "", "k", "(Landroid/app/Activity;Landroidx/lifecycle/LifecycleCoroutineScope;)V", "Landroid/content/Context;", "h", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleCoroutineScope;)V", "i", "p", "", "j", "()Z", "", "checkState", "g", "(ILandroid/content/Context;)V", "", "TAG", "Ljava/lang/String;", "I", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void l(Activity activity, LifecycleCoroutineScope lifecycleCoroutineScope, DialogInterface dialogInterface, int i) {
            Intrinsics.checkNotNullParameter(activity, "$context");
            Intrinsics.checkNotNullParameter(lifecycleCoroutineScope, "$lifecycleScope");
            ULog.f6446a.a("AboutSuperAppFragment", "点击撤回 about_cancel_agree_confirm");
            AboutSuperAppFragment.l.h(activity, lifecycleCoroutineScope);
        }

        public static final void m(DialogInterface dialogInterface, int i) {
        }

        public static final void n(CompoundButton compoundButton, boolean z) {
            Companion companion = AboutSuperAppFragment.l;
            AboutSuperAppFragment.m = z ? 2 : 1;
        }

        public static final void o(DialogInterface dialogInterface) {
            AboutSuperAppFragment.m = -1;
        }

        public final void g(int i, Context context) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("AboutSuperAppFragment", "clearAppUserData checkState" + i);
            if (!NetworkUtils.f7898a.g() || i != 2) {
                AppUtils.f7842a.b(context);
                return;
            }
            HttpRequestUtil.f7890a.a(ProtocolType.CATEGORY_PP.getBindKey(), context.getResources().getConfiguration().locale.getCountry(), System.currentTimeMillis(), new AboutSuperAppFragment$Companion$clearAppUserData$1(context));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x004f, code lost:
            if (r1.booleanValue() != false) goto L_0x0051;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void h(android.content.Context r7, androidx.lifecycle.LifecycleCoroutineScope r8) {
            /*
                r6 = this;
                com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r0 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
                com.upuphone.xr.sapp.utils.DataStoreUtils r1 = r0.a()
                java.lang.String r2 = "privacy_argreement_region_key"
                java.lang.String r3 = ""
                r1.o(r2, r3)
                com.upuphone.xr.sapp.utils.DataStoreUtils r1 = r0.a()
                java.lang.String r2 = "privacy_argreement_latest_region_key"
                r1.o(r2, r3)
                com.upuphone.xr.sapp.utils.DataStoreUtils r0 = r0.a()
                java.lang.Boolean r1 = java.lang.Boolean.FALSE
                java.lang.String r2 = "sp_user_agreement_state"
                r0.o(r2, r1)
                r6.i()
                com.upuphone.xr.sapp.utils.BuglyManager r0 = com.upuphone.xr.sapp.utils.BuglyManager.f7849a
                r0.n()
                com.upuphone.xr.sapp.utils.HttpRequestUtil r0 = com.upuphone.xr.sapp.utils.HttpRequestUtil.f7890a
                r0.c()
                com.upuphone.xr.sapp.common.MzAccountManager$Companion r0 = com.upuphone.xr.sapp.common.MzAccountManager.c
                com.upuphone.xr.sapp.common.MzAccountManager r1 = r0.b()
                r1.c()
                java.lang.Boolean r1 = com.upuphone.xr.sapp.BuildConfig.b
                java.lang.String r2 = "THIRD_PLATFOM"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                boolean r1 = r1.booleanValue()
                if (r1 != 0) goto L_0x0051
                java.lang.Boolean r1 = com.upuphone.xr.sapp.BuildConfig.f6575a
                java.lang.String r2 = "COUNTRY_INTL"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x0058
            L_0x0051:
                com.upuphone.xr.sapp.common.MzAccountManager r0 = r0.b()
                r0.f()
            L_0x0058:
                r6.p()
                com.upuphone.ar.tici.phone.TiciApp r6 = com.upuphone.ar.tici.phone.TiciApp.b
                r6.p()
                kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.b()
                com.upuphone.xr.sapp.fragment.AboutSuperAppFragment$Companion$confirmCancelAgree$1 r3 = new com.upuphone.xr.sapp.fragment.AboutSuperAppFragment$Companion$confirmCancelAgree$1
                r6 = 0
                r3.<init>(r7, r6)
                r4 = 2
                r5 = 0
                r2 = 0
                r0 = r8
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.d(r0, r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.AboutSuperAppFragment.Companion.h(android.content.Context, androidx.lifecycle.LifecycleCoroutineScope):void");
        }

        public final void i() {
            DataStoreUtils.Companion companion = DataStoreUtils.e;
            DataStoreUtils a2 = companion.a();
            Boolean bool = Boolean.FALSE;
            a2.o("privacy_argreement_key_ai_asst", bool);
            companion.a().o("privacy_argreement_key_ar_navi", bool);
            companion.a().o("privacy_argreement_key_ar_tran", bool);
            companion.a().o("privacy_argreement_key_ar_tici", bool);
            SuperMessageManger.m.a().m0();
        }

        public final boolean j() {
            if (!BuildConfig.f6575a.booleanValue()) {
                return true;
            }
            return ContractEntry.f6691a.o();
        }

        public final void k(Activity activity, LifecycleCoroutineScope lifecycleCoroutineScope) {
            Intrinsics.checkNotNullParameter(activity, "context");
            Intrinsics.checkNotNullParameter(lifecycleCoroutineScope, "lifecycleScope");
            AlertDialog create = new AlertDialog.Builder(activity).setTitle(R.string.about_cancel_agree_confirm).setPositiveButton(R.string.about_cancel_agree_confirm, (DialogInterface.OnClickListener) new z(activity, lifecycleCoroutineScope)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new a0()).create();
            DialogCancelAgreementBinding c = DialogCancelAgreementBinding.c(create.getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
            String str = ContractEntry.f6691a.d() + " \n " + activity.getString(R.string.cancel_agree_notify);
            ClickSpanHelper clickSpanHelper = ClickSpanHelper.f7853a;
            String string = activity.getString(R.string.superapp_privacy_policy);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            SpannableString a2 = clickSpanHelper.a(str, CollectionsKt.arrayListOf(string), new AboutSuperAppFragment$Companion$showCancelAgreeDialog$1$buildAgreementClickSpan$1(activity));
            c.b.setMovementMethod(LinkMovementMethod.getInstance());
            c.b.setHighlightColor(0);
            c.b.setText(a2);
            c.c.setChecked(false);
            c.c.setOnCheckedChangeListener(new b0());
            c.e.setText(R.string.cancel_agree_check_notify);
            create.setView(c.getRoot(), 0, 0, 0, 0);
            create.setOnDismissListener(new c0());
            create.show();
        }

        public final void p() {
            String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_device_connect_history", "null", (Context) null, 4, (Object) null);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("AboutSuperAppFragment", "unbound device is: " + str);
            StaticMethodUtilsKt.X(str);
        }

        public Companion() {
        }
    }

    private final void P0() {
        AppUpdateHelper.f7841a.B().observe(getViewLifecycleOwner(), new AboutSuperAppFragment$sam$androidx_lifecycle_Observer$0(new AboutSuperAppFragment$addObserve$1(this)));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new AboutSuperAppFragment$addObserve$2(this, (Continuation<? super AboutSuperAppFragment$addObserve$2>) null), 3, (Object) null);
    }

    public static final void S0(AboutSuperAppFragment aboutSuperAppFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutSuperAppFragment, "this$0");
        StaticMethodUtilsKt.q(aboutSuperAppFragment);
    }

    public static final void T0(AboutSuperAppFragment aboutSuperAppFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutSuperAppFragment, "this$0");
        boolean g = StarryMessageHelper.f7799a.g();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AboutSuperAppFragment", " cancelAgree  isConnect=" + g);
        if (!ContractEntry.f6691a.u() || !g || !ModelIdExtKt.c(DynamicAdapterUtils.f7879a.a())) {
            Companion companion = l;
            FragmentActivity requireActivity = aboutSuperAppFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            LifecycleOwner viewLifecycleOwner = aboutSuperAppFragment.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            companion.k(requireActivity, LifecycleOwnerKt.a(viewLifecycleOwner));
            return;
        }
        StaticMethodUtilsKt.t(aboutSuperAppFragment, R.id.modulePoliceFragment);
    }

    public static final void U0(AboutSuperAppFragment aboutSuperAppFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutSuperAppFragment, "this$0");
    }

    public static final void V0(CompoundButton compoundButton, boolean z) {
        ULog.f6446a.a("AboutSuperAppFragment", "onCheckedChanged");
        DataStoreUtils.e.a().o("sp_user_experience", Boolean.valueOf(z));
        DataTrackRuleHelper.b.m();
    }

    public static final void W0(AboutSuperAppFragment aboutSuperAppFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutSuperAppFragment, "this$0");
        if (SdkContext.f6675a.c().e()) {
            ULog.f6446a.a("AboutSuperAppFragment", "versionUpdate clicked, isIntlVersion=true");
            if (VersionCheckUtil.f7929a.c("com.upuphone.star.launcher.intl")) {
                AppUpdateHelper.f7841a.D();
                return;
            }
            return;
        }
        AppUpdateHelper appUpdateHelper = AppUpdateHelper.f7841a;
        Boolean bool = (Boolean) appUpdateHelper.B().getValue();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AboutSuperAppFragment", "versionUpdate clicked, showUpdateBadge: " + bool);
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            aboutSuperAppFragment.d1();
            return;
        }
        aboutSuperAppFragment.showLoading();
        appUpdateHelper.E();
    }

    public static final void X0(AboutSuperAppFragment aboutSuperAppFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutSuperAppFragment, "this$0");
        FragmentActivity activity = aboutSuperAppFragment.getActivity();
        if (activity != null) {
            ContractEntry.w(ContractEntry.f6691a, activity, ProtocolType.CATEGORY_AIUP, (String) null, 4, (Object) null);
        }
    }

    public static final void Y0(AboutSuperAppFragment aboutSuperAppFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutSuperAppFragment, "this$0");
        FragmentActivity activity = aboutSuperAppFragment.getActivity();
        if (activity != null) {
            ContractEntry.w(ContractEntry.f6691a, activity, ProtocolType.CATEGORY_AIPP, (String) null, 4, (Object) null);
        }
    }

    public static final void Z0(AboutSuperAppFragment aboutSuperAppFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutSuperAppFragment, "this$0");
        FragmentActivity activity = aboutSuperAppFragment.getActivity();
        if (activity != null) {
            ContractEntry.w(ContractEntry.f6691a, activity, ProtocolType.CATEGORY_UP, (String) null, 4, (Object) null);
        }
    }

    public static final void a1(AboutSuperAppFragment aboutSuperAppFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutSuperAppFragment, "this$0");
        FragmentActivity activity = aboutSuperAppFragment.getActivity();
        if (activity != null) {
            ContractEntry.w(ContractEntry.f6691a, activity, ProtocolType.CATEGORY_AIGCIN, (String) null, 4, (Object) null);
        }
    }

    public static final void b1(AboutSuperAppFragment aboutSuperAppFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutSuperAppFragment, "this$0");
        FragmentActivity activity = aboutSuperAppFragment.getActivity();
        if (activity != null) {
            ContractEntry.w(ContractEntry.f6691a, activity, ProtocolType.CATEGORY_PCPI, (String) null, 4, (Object) null);
        }
    }

    public static final void c1(AboutSuperAppFragment aboutSuperAppFragment, View view) {
        Intrinsics.checkNotNullParameter(aboutSuperAppFragment, "this$0");
        Intent intent = new Intent(aboutSuperAppFragment.getActivity(), ProtocolActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("title", aboutSuperAppFragment.getString(R.string.about_reporting_of_violations));
        bundle.putString("url", "https://jubao.py.cnhubei.com/hbjb.html");
        intent.putExtra("data", bundle);
        FragmentActivity activity = aboutSuperAppFragment.getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
        aboutSuperAppFragment.requireActivity().overridePendingTransition(R.anim.next_open_enter, R.anim.next_open_exit);
    }

    private final void initView() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AboutSuperAppFragment", "initView");
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding = null;
        if (bool.booleanValue()) {
            FragmentAboutSuperappBinding fragmentAboutSuperappBinding2 = this.j;
            if (fragmentAboutSuperappBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAboutSuperappBinding2 = null;
            }
            fragmentAboutSuperappBinding2.n.setText(getString(R.string.superapp_name_oversea));
            FragmentAboutSuperappBinding fragmentAboutSuperappBinding3 = this.j;
            if (fragmentAboutSuperappBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAboutSuperappBinding3 = null;
            }
            fragmentAboutSuperappBinding3.d.setText(getString(R.string.about_superapp_oversea));
        }
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding4 = this.j;
        if (fragmentAboutSuperappBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding4 = null;
        }
        TextView textView = fragmentAboutSuperappBinding4.j;
        Intrinsics.checkNotNullExpressionValue(textView, "childrenInfo");
        int i = 8;
        textView.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding5 = this.j;
        if (fragmentAboutSuperappBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding5 = null;
        }
        fragmentAboutSuperappBinding5.d.setOnClickListener(new o(this));
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding6 = this.j;
        if (fragmentAboutSuperappBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding6 = null;
        }
        TextView textView2 = fragmentAboutSuperappBinding6.p;
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding7 = this.j;
        if (fragmentAboutSuperappBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding7 = null;
        }
        textView2.setText(fragmentAboutSuperappBinding7.p.getText() + "2.40.51");
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding8 = this.j;
        if (fragmentAboutSuperappBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding8 = null;
        }
        delegate.g("AboutSuperAppFragment", String.valueOf(fragmentAboutSuperappBinding8.p.getText()));
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding9 = this.j;
        if (fragmentAboutSuperappBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding9 = null;
        }
        fragmentAboutSuperappBinding9.o.setOnClickListener(new r(this));
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding10 = this.j;
        if (fragmentAboutSuperappBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding10 = null;
        }
        TextView textView3 = fragmentAboutSuperappBinding10.e;
        Intrinsics.checkNotNullExpressionValue(textView3, "algorithmPrinciples");
        textView3.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding11 = this.j;
        if (fragmentAboutSuperappBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding11 = null;
        }
        fragmentAboutSuperappBinding11.e.setOnClickListener(new s(this));
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding12 = this.j;
        if (fragmentAboutSuperappBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding12 = null;
        }
        fragmentAboutSuperappBinding12.j.setOnClickListener(new t(this));
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding13 = this.j;
        if (fragmentAboutSuperappBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding13 = null;
        }
        TextView textView4 = fragmentAboutSuperappBinding13.b;
        Intrinsics.checkNotNullExpressionValue(textView4, "aboutReportingOfViolations");
        textView4.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding14 = this.j;
        if (fragmentAboutSuperappBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding14 = null;
        }
        fragmentAboutSuperappBinding14.b.setOnClickListener(new u(this));
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding15 = this.j;
        if (fragmentAboutSuperappBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding15 = null;
        }
        fragmentAboutSuperappBinding15.i.setOnClickListener(new v(this));
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding16 = this.j;
        if (fragmentAboutSuperappBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding16 = null;
        }
        fragmentAboutSuperappBinding16.c.setOnClickListener(new w(this));
        if (!bool.booleanValue()) {
            boolean booleanValue = ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_user_experience", Boolean.TRUE, (Context) null, 4, (Object) null)).booleanValue();
            FragmentAboutSuperappBinding fragmentAboutSuperappBinding17 = this.j;
            if (fragmentAboutSuperappBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAboutSuperappBinding17 = null;
            }
            fragmentAboutSuperappBinding17.q.getBinding().i.setChecked(booleanValue);
            FragmentAboutSuperappBinding fragmentAboutSuperappBinding18 = this.j;
            if (fragmentAboutSuperappBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAboutSuperappBinding18 = null;
            }
            CardItemView cardItemView = fragmentAboutSuperappBinding18.q;
            Intrinsics.checkNotNullExpressionValue(cardItemView, "userShare");
            cardItemView.setVisibility(0);
            FragmentAboutSuperappBinding fragmentAboutSuperappBinding19 = this.j;
            if (fragmentAboutSuperappBinding19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAboutSuperappBinding19 = null;
            }
            fragmentAboutSuperappBinding19.q.b();
            FragmentAboutSuperappBinding fragmentAboutSuperappBinding20 = this.j;
            if (fragmentAboutSuperappBinding20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAboutSuperappBinding20 = null;
            }
            CardItemView cardItemView2 = fragmentAboutSuperappBinding20.q;
            String string = getString(R.string.user_share_content);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            cardItemView2.setCardSubTitle(e1(string));
            FragmentAboutSuperappBinding fragmentAboutSuperappBinding21 = this.j;
            if (fragmentAboutSuperappBinding21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAboutSuperappBinding21 = null;
            }
            fragmentAboutSuperappBinding21.q.setSwitchListener(new x());
        }
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding22 = this.j;
        if (fragmentAboutSuperappBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding22 = null;
        }
        TextView textView5 = fragmentAboutSuperappBinding22.s;
        Intrinsics.checkNotNullExpressionValue(textView5, "versionUpdate");
        ViewExtKt.b(textView5, new y(this));
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding23 = this.j;
        if (fragmentAboutSuperappBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding23 = null;
        }
        TextView textView6 = fragmentAboutSuperappBinding23.g;
        Intrinsics.checkNotNullExpressionValue(textView6, "assistantServiceAgreement");
        ViewExtKt.b(textView6, new p(this));
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding24 = this.j;
        if (fragmentAboutSuperappBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding24 = null;
        }
        TextView textView7 = fragmentAboutSuperappBinding24.f;
        Intrinsics.checkNotNullExpressionValue(textView7, "assistantPrivacyPolicy");
        ViewExtKt.b(textView7, new q(this));
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding25 = this.j;
        if (fragmentAboutSuperappBinding25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding25 = null;
        }
        TextView textView8 = fragmentAboutSuperappBinding25.g;
        Intrinsics.checkNotNullExpressionValue(textView8, "assistantServiceAgreement");
        textView8.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding26 = this.j;
        if (fragmentAboutSuperappBinding26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentAboutSuperappBinding = fragmentAboutSuperappBinding26;
        }
        TextView textView9 = fragmentAboutSuperappBinding.f;
        Intrinsics.checkNotNullExpressionValue(textView9, "assistantPrivacyPolicy");
        if (!bool.booleanValue()) {
            i = 0;
        }
        textView9.setVisibility(i);
    }

    private final void showLoading() {
        ULog.f6446a.g("AboutSuperAppFragment", "showLoading");
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding = this.j;
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding2 = null;
        if (fragmentAboutSuperappBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding = null;
        }
        ImageView imageView = fragmentAboutSuperappBinding.l;
        Intrinsics.checkNotNullExpressionValue(imageView, "loading");
        if (imageView.getVisibility() != 0) {
            FragmentAboutSuperappBinding fragmentAboutSuperappBinding3 = this.j;
            if (fragmentAboutSuperappBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAboutSuperappBinding3 = null;
            }
            fragmentAboutSuperappBinding3.l.setVisibility(0);
            FragmentAboutSuperappBinding fragmentAboutSuperappBinding4 = this.j;
            if (fragmentAboutSuperappBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentAboutSuperappBinding2 = fragmentAboutSuperappBinding4;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(fragmentAboutSuperappBinding2.l, "rotation", new float[]{0.0f, 359.0f});
            ofFloat.setDuration(AssistantConstants.TIMEOUT_VAD_MUTE);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            this.k = ofFloat;
            ofFloat.start();
        }
    }

    public final void Q0(HttpResult httpResult) {
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding = this.j;
        if (fragmentAboutSuperappBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding = null;
        }
        ImageView imageView = fragmentAboutSuperappBinding.l;
        Intrinsics.checkNotNullExpressionValue(imageView, "loading");
        boolean z = imageView.getVisibility() == 0;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AboutSuperAppFragment", "handleAppUpdateInfoEvent, isLoading: " + z);
        if (z) {
            R0();
            BasicResponse basicResponse = (BasicResponse) HttpResultKt.a(httpResult);
            AppUpdateInfo appUpdateInfo = basicResponse != null ? (AppUpdateInfo) basicResponse.getData() : null;
            delegate.a("AboutSuperAppFragment", "handleAppUpdateInfoEvent, appUpdateInfo: " + appUpdateInfo);
            if (appUpdateInfo == null) {
                ContextExtKt.e(R.string.version_check_failed, 0, 2, (Object) null);
            } else if (appUpdateInfo.getExistsUpdate()) {
                d1();
            } else {
                ContextExtKt.e(R.string.latest_version, 0, 2, (Object) null);
            }
        }
    }

    public final void R0() {
        ULog.f6446a.g("AboutSuperAppFragment", "hideLoading");
        FragmentAboutSuperappBinding fragmentAboutSuperappBinding = this.j;
        if (fragmentAboutSuperappBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAboutSuperappBinding = null;
        }
        fragmentAboutSuperappBinding.l.setVisibility(8);
        Animator animator = this.k;
        if (animator != null) {
            animator.end();
        }
    }

    public final void d1() {
        if (VersionCheckUtil.f7929a.d("com.upuphone.star.launcher.intl")) {
            AppUpdateHelper.f7841a.D();
        }
    }

    public final SpannableString e1(String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AboutSuperAppFragment", "text is: " + str);
        if (str.length() == 0 || !StringsKt.contains$default((CharSequence) str, (CharSequence) "《", false, 2, (Object) null)) {
            return new SpannableString("invalid data");
        }
        try {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AboutSuperAppFragment$setClickSpan$1(this), StringsKt.indexOf$default((CharSequence) str, "《", 0, false, 6, (Object) null), StringsKt.indexOf$default((CharSequence) str, "》", 0, false, 6, (Object) null) + 1, 34);
            spannableString.setSpan(new LinearGradientForegroundSpan(new int[]{getResources().getColor(R.color.color_gradient_star), getResources().getColor(R.color.color_gradient_end)}), StringsKt.indexOf$default((CharSequence) str, "《", 0, false, 6, (Object) null), StringsKt.indexOf$default((CharSequence) str, "》", 0, false, 6, (Object) null) + 1, 18);
            return spannableString;
        } catch (Exception e) {
            ULog.Delegate delegate2 = ULog.f6446a;
            String message = e.getMessage();
            delegate2.c("setClickSpan", "e : " + message);
            return new SpannableString("invalid data");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentAboutSuperappBinding c = FragmentAboutSuperappBinding.c(layoutInflater, viewGroup, false);
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
        P0();
    }
}
