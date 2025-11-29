package com.upuphone.xr.sapp.contract;

import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import com.meizu.common.util.LunarCalendar;
import com.meizu.flyme.policy.sdk.config.PolicySdkConstants;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.BuglyManager;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.view.LinearGradientForegroundSpan;
import com.xjmz.myvu.MYVUActivity;
import flyme.support.v7.app.AlertDialog;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0002()B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR#\u0010&\u001a\n \"*\u0004\u0018\u00010!0!8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/upuphone/xr/sapp/contract/AppUserGuideDialogController;", "", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "", "n", "()V", "", "text", "Landroid/text/SpannableString;", "i", "(Ljava/lang/String;)Landroid/text/SpannableString;", "Landroid/widget/TextView;", "textView", "", "isOver18Years", "h", "(Landroid/widget/TextView;Z)V", "g", "(Landroid/widget/TextView;)V", "m", "a", "Landroid/app/Activity;", "b", "Lkotlin/Lazy;", "k", "()Ljava/lang/String;", "privacyPolicy", "c", "l", "serviceAgreement", "Lflyme/support/v7/app/AlertDialog;", "kotlin.jvm.PlatformType", "d", "j", "()Lflyme/support/v7/app/AlertDialog;", "mUserGuideDialog", "e", "Companion", "PolicyClickableSpan", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AppUserGuideDialogController {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Activity f6676a;
    public final Lazy b = LazyKt.lazy(new AppUserGuideDialogController$privacyPolicy$2(this));
    public final Lazy c = LazyKt.lazy(new AppUserGuideDialogController$serviceAgreement$2(this));
    public final Lazy d = LazyKt.lazy(new AppUserGuideDialogController$mUserGuideDialog$2(this));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/contract/AppUserGuideDialogController$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/contract/AppUserGuideDialogController$PolicyClickableSpan;", "Landroid/text/style/ClickableSpan;", "", "policy", "<init>", "(Lcom/upuphone/xr/sapp/contract/AppUserGuideDialogController;Ljava/lang/String;)V", "Landroid/view/View;", "widget", "", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", "ds", "updateDrawState", "(Landroid/text/TextPaint;)V", "a", "Ljava/lang/String;", "getPolicy", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class PolicyClickableSpan extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public final String f6677a;
        public final /* synthetic */ AppUserGuideDialogController b;

        public PolicyClickableSpan(AppUserGuideDialogController appUserGuideDialogController, String str) {
            Intrinsics.checkNotNullParameter(str, PolicySdkConstants.policyFileDir);
            this.b = appUserGuideDialogController;
            this.f6677a = str;
        }

        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "widget");
            String str = this.f6677a;
            String e = this.b.k();
            Intrinsics.checkNotNullExpressionValue(e, "access$getPrivacyPolicy(...)");
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) e, false, 2, (Object) null)) {
                ContractEntry.w(ContractEntry.f6691a, this.b.f6676a, ProtocolType.CATEGORY_PP, (String) null, 4, (Object) null);
            } else {
                ContractEntry.w(ContractEntry.f6691a, this.b.f6676a, ProtocolType.CATEGORY_UP, (String) null, 4, (Object) null);
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    public AppUserGuideDialogController(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f6676a = activity;
    }

    public final void g(TextView textView) {
        int[] iArr = {this.f6676a.getColor(R.color.color_gradient_star), this.f6676a.getColor(R.color.color_gradient_end)};
        String obj = textView.getText().toString();
        SpannableString spannableString = new SpannableString(obj);
        String h = GlobalExtKt.h(R.string.superapp_privacy_policy);
        String h2 = GlobalExtKt.h(R.string.service_protocol_anchor);
        int indexOf$default = StringsKt.indexOf$default((CharSequence) obj, h, 0, false, 6, (Object) null);
        int length = indexOf$default + h.length();
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) obj, h2, 0, false, 6, (Object) null);
        int length2 = h2.length() + indexOf$default2;
        if (indexOf$default != -1) {
            spannableString.setSpan(new PolicyClickableSpan(this, h), indexOf$default, length, 34);
            spannableString.setSpan(new LinearGradientForegroundSpan(iArr), indexOf$default, length, 18);
        }
        if (indexOf$default2 != -1) {
            spannableString.setSpan(new PolicyClickableSpan(this, h2), indexOf$default2, length2, 34);
            spannableString.setSpan(new LinearGradientForegroundSpan(iArr), indexOf$default2, length2, 18);
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
    }

    public final void h(TextView textView, boolean z) {
        String obj = textView.getText().toString();
        SpannableString spannableString = new SpannableString(obj);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) obj, LunarCalendar.DATE_SEPARATOR, 0, false, 6, (Object) null) + 1;
        int length = obj.length();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-16711936);
        spannableString.setSpan(underlineSpan, lastIndexOf$default, length, 33);
        spannableString.setSpan(foregroundColorSpan, lastIndexOf$default, length, 33);
        spannableString.setSpan(new AppUserGuideDialogController$buildKoreanSpanStringMoreDetail$clickableSpan$1(z, this), lastIndexOf$default, length, 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
    }

    public final SpannableString i(String str) {
        int[] iArr = {this.f6676a.getColor(R.color.color_gradient_star), this.f6676a.getColor(R.color.color_gradient_end)};
        SpannableString spannableString = new SpannableString(str);
        Locale locale = this.f6676a.getResources().getConfiguration().locale;
        boolean areEqual = Intrinsics.areEqual((Object) locale.getLanguage(), (Object) "ja");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AppUserGuideDialogController", "当前语言->" + locale + "，是否适配日本->" + areEqual);
        Pattern compile = Pattern.compile(areEqual ? "「[^」]+」|「」" : "《[^》]+》|《》");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        Matcher matcher = compile.matcher(str);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.a("AppUserGuideDialogController", "命中->" + matcher + "，group->" + group);
            Intrinsics.checkNotNull(group);
            String k = k();
            Intrinsics.checkNotNullExpressionValue(k, "<get-privacyPolicy>(...)");
            if (!StringsKt.contains$default((CharSequence) group, (CharSequence) k, false, 2, (Object) null)) {
                String l = l();
                Intrinsics.checkNotNullExpressionValue(l, "<get-serviceAgreement>(...)");
                if (!StringsKt.contains$default((CharSequence) group, (CharSequence) l, false, 2, (Object) null)) {
                }
            }
            spannableString.setSpan(new PolicyClickableSpan(this, group), start, end, 34);
            spannableString.setSpan(new LinearGradientForegroundSpan(iArr), start, end, 18);
        }
        return spannableString;
    }

    public final AlertDialog j() {
        return (AlertDialog) this.d.getValue();
    }

    public final String k() {
        return (String) this.b.getValue();
    }

    public final String l() {
        return (String) this.c.getValue();
    }

    public final void m() {
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        companion.a().o("sp_user_agreement_state", Boolean.TRUE);
        MainApplication.k.f().t();
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            DataStoreUtils a2 = companion.a();
            ContractEntry contractEntry = ContractEntry.f6691a;
            a2.o("privacy_argreement_region_key", contractEntry.i());
            contractEntry.q();
        }
        BuglyManager.f7849a.n();
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new AppUserGuideDialogController$handleAgree$1((Continuation<? super AppUserGuideDialogController$handleAgree$1>) null), 3, (Object) null);
        j().dismiss();
        this.f6676a.startActivity(new Intent(this.f6676a, MYVUActivity.class));
        this.f6676a.finish();
    }

    public final void n() {
        if (!j().isShowing()) {
            j().show();
        }
    }
}
