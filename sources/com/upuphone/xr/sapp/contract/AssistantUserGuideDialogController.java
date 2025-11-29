package com.upuphone.xr.sapp.contract;

import android.app.Activity;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.util.Consumer;
import com.meizu.flyme.policy.sdk.config.PolicySdkConstants;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate;
import com.upuphone.xr.sapp.entity.AIModelResult;
import flyme.support.v7.app.AlertDialog;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001a2\u00020\u0001:\u0002-.B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010,\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(¨\u0006/"}, d2 = {"Lcom/upuphone/xr/sapp/contract/AssistantUserGuideDialogController;", "", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Landroidx/core/util/Consumer;", "Lcom/upuphone/xr/sapp/contract/UserGuideAuthResult;", "consumer", "", "k", "(Landroidx/core/util/Consumer;)V", "", "action", "l", "(I)V", "", "isServerError", "j", "(Z)V", "", "text", "Landroid/text/SpannableString;", "g", "(Ljava/lang/String;)Landroid/text/SpannableString;", "Ljava/util/regex/Pattern;", "f", "()Ljava/util/regex/Pattern;", "a", "Landroid/app/Activity;", "b", "Lcom/upuphone/xr/sapp/contract/UserGuideAuthResult;", "mAuthResult", "c", "Landroidx/core/util/Consumer;", "mConsumer", "Lflyme/support/v7/app/AlertDialog;", "d", "Lkotlin/Lazy;", "h", "()Lflyme/support/v7/app/AlertDialog;", "assistantUserGuideDialog", "e", "i", "mErrorDialog", "Companion", "PolicyClickableSpan", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AssistantUserGuideDialogController {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Activity f6688a;
    public UserGuideAuthResult b;
    public Consumer c;
    public final Lazy d = LazyKt.lazy(new AssistantUserGuideDialogController$assistantUserGuideDialog$2(this));
    public final Lazy e = LazyKt.lazy(new AssistantUserGuideDialogController$mErrorDialog$2(this));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/contract/AssistantUserGuideDialogController$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/contract/AssistantUserGuideDialogController$PolicyClickableSpan;", "Landroid/text/style/ClickableSpan;", "", "policy", "<init>", "(Lcom/upuphone/xr/sapp/contract/AssistantUserGuideDialogController;Ljava/lang/String;)V", "Landroid/view/View;", "widget", "", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", "ds", "updateDrawState", "(Landroid/text/TextPaint;)V", "a", "Ljava/lang/String;", "getPolicy", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class PolicyClickableSpan extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public final String f6689a;
        public final /* synthetic */ AssistantUserGuideDialogController b;

        public PolicyClickableSpan(AssistantUserGuideDialogController assistantUserGuideDialogController, String str) {
            Intrinsics.checkNotNullParameter(str, PolicySdkConstants.policyFileDir);
            this.b = assistantUserGuideDialogController;
            this.f6689a = str;
        }

        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "widget");
            String str = this.f6689a;
            Activity b2 = this.b.f6688a;
            ProtocolType protocolType = ProtocolType.CATEGORY_AIPP;
            String string = b2.getString(protocolType.getTitleRes());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) string, false, 2, (Object) null)) {
                ContractEntry.w(ContractEntry.f6691a, this.b.f6688a, protocolType, (String) null, 4, (Object) null);
                return;
            }
            String str2 = this.f6689a;
            Activity b3 = this.b.f6688a;
            ProtocolType protocolType2 = ProtocolType.CATEGORY_AIUP;
            String string2 = b3.getString(protocolType2.getTitleRes());
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            if (StringsKt.contains$default((CharSequence) str2, (CharSequence) string2, false, 2, (Object) null)) {
                ContractEntry.w(ContractEntry.f6691a, this.b.f6688a, protocolType2, (String) null, 4, (Object) null);
                return;
            }
            String str3 = this.f6689a;
            String string3 = this.b.f6688a.getString(R.string.assistant_privacy_policy_pro);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            if (StringsKt.contains$default((CharSequence) str3, (CharSequence) string3, false, 2, (Object) null)) {
                ContractEntry.w(ContractEntry.f6691a, this.b.f6688a, ProtocolType.CATEGORY_PP, (String) null, 4, (Object) null);
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    public AssistantUserGuideDialogController(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f6688a = activity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
        if (r4.equals("zh") == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0092, code lost:
        if (r4.equals("ar") == false) goto L_0x0094;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.regex.Pattern f() {
        /*
            r4 = this;
            android.app.Activity r4 = r4.f6688a
            android.content.res.Resources r4 = r4.getResources()
            android.content.res.Configuration r4 = r4.getConfiguration()
            android.os.LocaleList r4 = r4.getLocales()
            r0 = 0
            java.util.Locale r4 = r4.get(r0)
            java.lang.String r4 = r4.getLanguage()
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "当前系统语言->"
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "AssistantUserGuideDialogController"
            r0.a(r2, r1)
            java.lang.Boolean r0 = com.upuphone.xr.sapp.BuildConfig.f6575a
            java.lang.String r1 = "COUNTRY_INTL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r0 = r0.booleanValue()
            java.lang.String r1 = "《[^》]+》"
            java.lang.String r2 = "zh"
            if (r0 == 0) goto L_0x0098
            if (r4 == 0) goto L_0x0094
            int r0 = r4.hashCode()
            r3 = 3121(0xc31, float:4.373E-42)
            if (r0 == r3) goto L_0x008c
            r3 = 3201(0xc81, float:4.486E-42)
            if (r0 == r3) goto L_0x007f
            r3 = 3276(0xccc, float:4.59E-42)
            if (r0 == r3) goto L_0x0072
            r3 = 3383(0xd37, float:4.74E-42)
            if (r0 == r3) goto L_0x0065
            r3 = 3886(0xf2e, float:5.445E-42)
            if (r0 == r3) goto L_0x005e
            goto L_0x0094
        L_0x005e:
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x0094
            goto L_0x00a1
        L_0x0065:
            java.lang.String r0 = "ja"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x006e
            goto L_0x0094
        L_0x006e:
            java.lang.String r1 = "「[^」]+」|「」"
            goto L_0x00a1
        L_0x0072:
            java.lang.String r0 = "fr"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x007b
            goto L_0x0094
        L_0x007b:
            java.lang.String r1 = "«[^»]+»"
            goto L_0x00a1
        L_0x007f:
            java.lang.String r0 = "de"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0088
            goto L_0x0094
        L_0x0088:
            java.lang.String r1 = "„[^“]+“"
            goto L_0x00a1
        L_0x008c:
            java.lang.String r0 = "ar"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x00a1
        L_0x0094:
            java.lang.String r1 = "《[^》]+》|《》|<[^>]+>|<>|«[^»]+»|«»|\".*?\""
            goto L_0x00a1
        L_0x0098:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r2)
            if (r4 == 0) goto L_0x009f
            goto L_0x00a1
        L_0x009f:
            java.lang.String r1 = "\"[^\"]+\""
        L_0x00a1:
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r1)
            java.lang.String r0 = "compile(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.contract.AssistantUserGuideDialogController.f():java.util.regex.Pattern");
    }

    public final SpannableString g(String str) {
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = f().matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("AssistantUserGuideDialogController", "命中->" + matcher);
            Intrinsics.checkNotNull(group);
            spannableString.setSpan(new PolicyClickableSpan(this, group), start, end, 34);
            spannableString.setSpan(new ForegroundColorSpan(this.f6688a.getColor(R.color.color_gradient_star)), start, end, 34);
        }
        return spannableString;
    }

    public final AlertDialog h() {
        Object value = this.d.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (AlertDialog) value;
    }

    public final AlertDialog i() {
        Object value = this.e.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (AlertDialog) value;
    }

    public final void j(boolean z) {
        if (!i().isShowing()) {
            i().show();
        }
        View findViewById = i().findViewById(R.id.tv_content);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        if (z) {
            textView.setText(this.f6688a.getString(R.string.service_error_pls_retry_later));
        } else {
            textView.setText(this.f6688a.getString(R.string.network_error_pls_retry_later));
        }
    }

    public final void k(Consumer consumer) {
        this.c = consumer;
        if (!h().isShowing()) {
            h().show();
        }
    }

    public final void l(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AssistantUserGuideDialogController", "submitAiState: 提交授权状态->" + i);
        View findViewById = h().findViewById(R.id.exit);
        if (findViewById != null) {
            findViewById.setEnabled(false);
        }
        View findViewById2 = h().findViewById(R.id.sure);
        if (findViewById2 != null) {
            findViewById2.setEnabled(false);
        }
        AIModelResult r = new LlmProtocolStateDelegate().r(i);
        boolean requestResult = r.getRequestResult();
        delegate.a("AssistantUserGuideDialogController", "提交大模型协议授权状态返回->" + requestResult);
        h().dismiss();
        this.b = new UserGuideAuthResult(i, r.getRequestResult());
        int state = r.getState();
        if (state == -2) {
            delegate.a("AssistantUserGuideDialogController", "提交大模型协议状态出错");
            j(true);
        } else if (state != -1) {
            Consumer consumer = this.c;
            if (consumer != null) {
                UserGuideAuthResult userGuideAuthResult = this.b;
                Intrinsics.checkNotNull(userGuideAuthResult);
                consumer.accept(userGuideAuthResult);
            }
        } else {
            delegate.a("AssistantUserGuideDialogController", "提交大模型协议状态超时");
            j(false);
        }
    }
}
