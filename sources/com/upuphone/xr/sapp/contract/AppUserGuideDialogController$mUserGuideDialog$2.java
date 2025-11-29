package com.upuphone.xr.sapp.contract;

import android.app.Activity;
import android.os.Build;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.DialogAppUserGuideBinding;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import flyme.support.v7.app.AlertDialog;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nAppUserGuideDialogController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppUserGuideDialogController.kt\ncom/upuphone/xr/sapp/contract/AppUserGuideDialogController$mUserGuideDialog$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,301:1\n256#2,2:302\n256#2,2:304\n256#2,2:306\n256#2,2:308\n256#2,2:310\n256#2,2:312\n256#2,2:314\n256#2,2:316\n256#2,2:318\n256#2,2:320\n256#2,2:322\n256#2,2:324\n256#2,2:326\n256#2,2:328\n*S KotlinDebug\n*F\n+ 1 AppUserGuideDialogController.kt\ncom/upuphone/xr/sapp/contract/AppUserGuideDialogController$mUserGuideDialog$2\n*L\n68#1:302,2\n69#1:304,2\n70#1:306,2\n71#1:308,2\n72#1:310,2\n73#1:312,2\n74#1:314,2\n78#1:316,2\n79#1:318,2\n80#1:320,2\n81#1:322,2\n82#1:324,2\n83#1:326,2\n84#1:328,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lflyme/support/v7/app/AlertDialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AppUserGuideDialogController$mUserGuideDialog$2 extends Lambda implements Function0<AlertDialog> {
    final /* synthetic */ AppUserGuideDialogController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppUserGuideDialogController$mUserGuideDialog$2(AppUserGuideDialogController appUserGuideDialogController) {
        super(0);
        this.this$0 = appUserGuideDialogController;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(AppUserGuideDialogController appUserGuideDialogController, View view) {
        Intrinsics.checkNotNullParameter(appUserGuideDialogController, "this$0");
        appUserGuideDialogController.m();
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1(View view) {
        MainApplication.k.f().p();
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$2(DialogAppUserGuideBinding dialogAppUserGuideBinding, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(dialogAppUserGuideBinding, "$binding");
        dialogAppUserGuideBinding.p.setEnabled(z && dialogAppUserGuideBinding.f.isChecked());
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$3(DialogAppUserGuideBinding dialogAppUserGuideBinding, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(dialogAppUserGuideBinding, "$binding");
        dialogAppUserGuideBinding.p.setEnabled(z && dialogAppUserGuideBinding.g.isChecked());
    }

    public final AlertDialog invoke() {
        String str;
        Activity d;
        int i;
        AlertDialog.Builder maxHeight = new AlertDialog.Builder(this.this$0.f6676a).setMaxHeight((int) (((double) this.this$0.f6676a.getResources().getDisplayMetrics().heightPixels) * 0.95d));
        DialogAppUserGuideBinding c = DialogAppUserGuideBinding.c(LayoutInflater.from(this.this$0.f6676a));
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        if (Build.VERSION.SDK_INT < 31) {
            str = this.this$0.f6676a.getString(R.string.flyme_internal_app_permission_location_text_android_r);
        } else {
            str = this.this$0.f6676a.getString(R.string.flyme_internal_app_permission_location_text);
        }
        Intrinsics.checkNotNull(str);
        c.i.setText(str);
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        Boolean bool = BuildConfig.b;
        if (bool.booleanValue() || BuildConfig.f6575a.booleanValue()) {
            TextView textView = c.e;
            Intrinsics.checkNotNullExpressionValue(textView, "btTipsTitle");
            textView.setVisibility(8);
            TextView textView2 = c.d;
            Intrinsics.checkNotNullExpressionValue(textView2, "btTipsContent");
            textView2.setVisibility(8);
            TextView textView3 = c.j;
            Intrinsics.checkNotNullExpressionValue(textView3, "gpsTipsTitle");
            textView3.setVisibility(8);
            TextView textView4 = c.i;
            Intrinsics.checkNotNullExpressionValue(textView4, "gpsTipsContent");
            textView4.setVisibility(8);
            TextView textView5 = c.c;
            Intrinsics.checkNotNullExpressionValue(textView5, "accountTipsTitle");
            textView5.setVisibility(8);
            TextView textView6 = c.b;
            Intrinsics.checkNotNullExpressionValue(textView6, "accountTipsContent");
            textView6.setVisibility(8);
            TextView textView7 = c.n;
            Intrinsics.checkNotNullExpressionValue(textView7, "permissionTipsSubject");
            textView7.setVisibility(8);
            c.l.setText(ContractEntry.f6691a.j());
            TextView textView8 = c.o;
            Boolean bool2 = BuildConfig.f6575a;
            Intrinsics.checkNotNullExpressionValue(bool2, "COUNTRY_INTL");
            if (bool2.booleanValue()) {
                d = this.this$0.f6676a;
                i = R.string.app_name_oversea;
            } else {
                d = this.this$0.f6676a;
                i = R.string.welcom_myvu;
            }
            textView8.setText(d.getString(i));
        } else {
            TextView textView9 = c.e;
            Intrinsics.checkNotNullExpressionValue(textView9, "btTipsTitle");
            textView9.setVisibility(0);
            TextView textView10 = c.d;
            Intrinsics.checkNotNullExpressionValue(textView10, "btTipsContent");
            textView10.setVisibility(0);
            TextView textView11 = c.j;
            Intrinsics.checkNotNullExpressionValue(textView11, "gpsTipsTitle");
            textView11.setVisibility(0);
            TextView textView12 = c.i;
            Intrinsics.checkNotNullExpressionValue(textView12, "gpsTipsContent");
            textView12.setVisibility(0);
            TextView textView13 = c.c;
            Intrinsics.checkNotNullExpressionValue(textView13, "accountTipsTitle");
            textView13.setVisibility(0);
            TextView textView14 = c.b;
            Intrinsics.checkNotNullExpressionValue(textView14, "accountTipsContent");
            textView14.setVisibility(0);
            TextView textView15 = c.n;
            Intrinsics.checkNotNullExpressionValue(textView15, "permissionTipsSubject");
            textView15.setVisibility(0);
            c.l.setText(this.this$0.f6676a.getString(R.string.permission_tips_content));
        }
        c.p.setText(ContractEntry.f6691a.e());
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AppUserGuideDialogController", "Current locale: " + language);
        if (Intrinsics.areEqual((Object) "ko", (Object) language)) {
            c.p.setEnabled(false);
            c.k.setVisibility(0);
            c.l.setText(GlobalExtKt.h(R.string.permission_tips_content_third_oversea));
            c.p.setText(GlobalExtKt.h(R.string.agree));
            AppUserGuideDialogController appUserGuideDialogController = this.this$0;
            TextView textView16 = c.r;
            Intrinsics.checkNotNullExpressionValue(textView16, "textTransferPersonalData");
            appUserGuideDialogController.h(textView16, false);
            AppUserGuideDialogController appUserGuideDialogController2 = this.this$0;
            TextView textView17 = c.q;
            Intrinsics.checkNotNullExpressionValue(textView17, "textOver18Years");
            appUserGuideDialogController2.h(textView17, true);
        } else {
            c.k.setVisibility(8);
        }
        if (!bool.booleanValue()) {
            TextView textView18 = c.n;
            textView18.setText(this.this$0.i(textView18.getText().toString()));
            c.n.setMovementMethod(LinkMovementMethod.getInstance());
        } else if (Intrinsics.areEqual((Object) language, (Object) "ko")) {
            AppUserGuideDialogController appUserGuideDialogController3 = this.this$0;
            TextView textView19 = c.l;
            Intrinsics.checkNotNullExpressionValue(textView19, "permissionTipsContent");
            appUserGuideDialogController3.g(textView19);
        } else {
            TextView textView20 = c.l;
            textView20.setText(this.this$0.i(textView20.getText().toString()));
            c.l.setMovementMethod(LinkMovementMethod.getInstance());
        }
        c.p.setOnClickListener(new a(this.this$0));
        c.h.setOnClickListener(new b());
        c.g.setOnCheckedChangeListener(new c(c));
        c.f.setOnCheckedChangeListener(new d(c));
        AlertDialog create = maxHeight.setView((View) c.getRoot()).create();
        create.setCancelable(false);
        create.setCanceledOnTouchOutside(false);
        return create;
    }
}
