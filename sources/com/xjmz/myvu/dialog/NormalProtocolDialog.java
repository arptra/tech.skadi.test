package com.xjmz.myvu.dialog;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.honey.account.p9.d;
import com.honey.account.p9.e;
import com.meizu.flyme.policy.sdk.config.PolicySdkConstants;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.ProtocolType;
import com.upuphone.xr.sapp.databinding.NormalProtocolDialogBinding;
import com.upuphone.xr.sapp.view.LinearGradientForegroundSpan;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0002IJBw\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b\"\u0010!J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b0\u0010.R\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u0010.R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b3\u0010,\u001a\u0004\b4\u0010.R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u001eR\u001f\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R%\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020D8\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006K"}, d2 = {"Lcom/xjmz/myvu/dialog/NormalProtocolDialog;", "Lcom/xjmz/myvu/dialog/GlobalDialogFragment;", "Landroidx/fragment/app/FragmentActivity;", "rootActivity", "Landroid/view/View;", "dialogView", "", "title", "content", "cancelText", "confirmText", "", "mExtras", "", "touchOutSideClose", "Lkotlin/Function0;", "", "refuseCallback", "Lkotlin/Function1;", "confirmCallback", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "initView", "()V", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "v0", "()Z", "", "o0", "()I", "m0", "text", "Landroid/text/SpannableString;", "l0", "(Ljava/lang/String;)Landroid/text/SpannableString;", "c", "Landroidx/fragment/app/FragmentActivity;", "n0", "()Landroidx/fragment/app/FragmentActivity;", "d", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "e", "getContent", "f", "getCancelText", "g", "getConfirmText", "h", "Ljava/lang/Object;", "getMExtras", "()Ljava/lang/Object;", "i", "Z", "getTouchOutSideClose", "j", "Lkotlin/jvm/functions/Function0;", "getRefuseCallback", "()Lkotlin/jvm/functions/Function0;", "k", "Lkotlin/jvm/functions/Function1;", "getConfirmCallback", "()Lkotlin/jvm/functions/Function1;", "Lcom/upuphone/xr/sapp/databinding/NormalProtocolDialogBinding;", "l", "Lcom/upuphone/xr/sapp/databinding/NormalProtocolDialogBinding;", "binding", "m", "Companion", "SpanClickable", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NormalProtocolDialog extends GlobalDialogFragment {
    public static final Companion m = new Companion((DefaultConstructorMarker) null);
    public final FragmentActivity c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Object h;
    public final boolean i;
    public final Function0 j;
    public final Function1 k;
    public final NormalProtocolDialogBinding l;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ju\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\r\u001a\u00020\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/xjmz/myvu/dialog/NormalProtocolDialog$Companion;", "", "<init>", "()V", "Landroidx/fragment/app/FragmentActivity;", "rootActivity", "", "title", "content", "cancelText", "confirmText", "mExtras", "", "touchOutSideClose", "Lkotlin/Function0;", "", "refuseCallback", "Lkotlin/Function1;", "confirmCallback", "Lcom/xjmz/myvu/dialog/NormalProtocolDialog;", "a", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lcom/xjmz/myvu/dialog/NormalProtocolDialog;", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NormalProtocolDialog b(Companion companion, FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, Object obj, boolean z, Function0 function0, Function1 function1, int i, Object obj2) {
            int i2 = i;
            return companion.a(fragmentActivity, str, str2, str3, str4, (i2 & 32) != 0 ? null : obj, (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? null : function0, (i2 & 256) != 0 ? null : function1);
        }

        public final NormalProtocolDialog a(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, Object obj, boolean z, Function0 function0, Function1 function1) {
            FragmentActivity fragmentActivity2 = fragmentActivity;
            Intrinsics.checkNotNullParameter(fragmentActivity, "rootActivity");
            String str5 = str;
            Intrinsics.checkNotNullParameter(str5, "title");
            String str6 = str2;
            Intrinsics.checkNotNullParameter(str6, "content");
            String str7 = str3;
            Intrinsics.checkNotNullParameter(str7, "cancelText");
            String str8 = str4;
            Intrinsics.checkNotNullParameter(str8, "confirmText");
            View inflate = fragmentActivity.getLayoutInflater().inflate(R.layout.normal_protocol_dialog, (ViewGroup) null, false);
            Intrinsics.checkNotNull(inflate);
            NormalProtocolDialog normalProtocolDialog = new NormalProtocolDialog(fragmentActivity, inflate, str5, str6, str7, str8, obj, z, function0, function1);
            normalProtocolDialog.show(fragmentActivity.getSupportFragmentManager(), (String) null);
            return normalProtocolDialog;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/xjmz/myvu/dialog/NormalProtocolDialog$SpanClickable;", "Landroid/text/style/ClickableSpan;", "", "policy", "<init>", "(Lcom/xjmz/myvu/dialog/NormalProtocolDialog;Ljava/lang/String;)V", "Landroid/view/View;", "widget", "", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", "ds", "updateDrawState", "(Landroid/text/TextPaint;)V", "a", "Ljava/lang/String;", "getPolicy", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class SpanClickable extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public final String f8236a;
        public final /* synthetic */ NormalProtocolDialog b;

        public SpanClickable(NormalProtocolDialog normalProtocolDialog, String str) {
            Intrinsics.checkNotNullParameter(str, PolicySdkConstants.policyFileDir);
            this.b = normalProtocolDialog;
            this.f8236a = str;
        }

        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "widget");
            String string = this.b.getResources().getString(R.string.superapp_privacy_policy);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (StringsKt.contains$default((CharSequence) this.f8236a, (CharSequence) string, false, 2, (Object) null)) {
                ContractEntry.w(ContractEntry.f6691a, this.b.n0(), ProtocolType.CATEGORY_PP, (String) null, 4, (Object) null);
            } else {
                ContractEntry.w(ContractEntry.f6691a, this.b.n0(), ProtocolType.CATEGORY_UP, (String) null, 4, (Object) null);
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NormalProtocolDialog(FragmentActivity fragmentActivity, View view, String str, String str2, String str3, String str4, Object obj, boolean z, Function0 function0, Function1 function1) {
        super(view, z);
        Intrinsics.checkNotNullParameter(fragmentActivity, "rootActivity");
        Intrinsics.checkNotNullParameter(view, "dialogView");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "cancelText");
        Intrinsics.checkNotNullParameter(str4, "confirmText");
        this.c = fragmentActivity;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = obj;
        this.i = z;
        this.j = function0;
        this.k = function1;
        NormalProtocolDialogBinding a2 = NormalProtocolDialogBinding.a(view);
        Intrinsics.checkNotNullExpressionValue(a2, "bind(...)");
        this.l = a2;
    }

    private final void initView() {
        int i2 = 8;
        this.l.d.setVisibility(v0() ? 8 : 0);
        this.l.p.setText(this.d);
        if (this.d.length() == 0) {
            this.l.p.setVisibility(8);
        }
        this.l.h.setMovementMethod(LinkMovementMethod.getInstance());
        this.l.h.setHighlightColor(0);
        this.l.n.setMovementMethod(LinkMovementMethod.getInstance());
        this.l.n.setHighlightColor(0);
        this.l.h.setVisibility(this.e.length() == 0 ? 8 : 0);
        LinearLayout linearLayout = this.l.i;
        if (this.e.length() == 0) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.e.length() == 0) {
            TextView textView = this.l.n;
            String string = getResources().getString(R.string.permission_tips_subject);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textView.setText(l0(string));
        } else {
            this.l.h.setText(l0(this.e));
        }
        this.l.o.setText(this.f);
        this.l.g.setText(this.g);
        this.l.o.setOnClickListener(new d(this));
        this.l.g.setOnClickListener(new e(this));
    }

    public static final void s0(NormalProtocolDialog normalProtocolDialog, View view) {
        Intrinsics.checkNotNullParameter(normalProtocolDialog, "this$0");
        Function0 function0 = normalProtocolDialog.j;
        if (function0 != null) {
            function0.invoke();
        }
        normalProtocolDialog.dismiss();
    }

    public static final void u0(NormalProtocolDialog normalProtocolDialog, View view) {
        Intrinsics.checkNotNullParameter(normalProtocolDialog, "this$0");
        ULog.Delegate delegate = ULog.f6446a;
        Object obj = normalProtocolDialog.h;
        delegate.a("NormalProtocolDialog", "confirm() mExtras:" + obj);
        Object obj2 = normalProtocolDialog.h;
        if (obj2 != null) {
            Function1 function1 = normalProtocolDialog.k;
            if (function1 != null) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                function1.invoke((String) obj2);
            }
        } else {
            Function1 function12 = normalProtocolDialog.k;
            if (function12 != null) {
                function12.invoke("no data");
            }
        }
        normalProtocolDialog.dismiss();
    }

    public final SpannableString l0(String str) {
        String string = getResources().getString(R.string.superapp_privacy_policy);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getResources().getString(R.string.service_protocol_anchor);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        int[] iArr = {getResources().getColor(R.color.color_gradient_star), getResources().getColor(R.color.color_gradient_end)};
        SpannableString spannableString = new SpannableString(str);
        Locale locale = getResources().getConfiguration().locale;
        boolean areEqual = Intrinsics.areEqual((Object) locale.getLanguage(), (Object) "ja");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("NormalProtocolDialog", "buildSpan() 当前语言->" + locale + "，是否适配日本->" + areEqual);
        Pattern compile = Pattern.compile(areEqual ? "「[^」]+」|「」" : "《[^》]+》|《》");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        Matcher matcher = compile.matcher(str);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.a("NormalProtocolDialog", "命中->" + matcher + "，group->" + group);
            Intrinsics.checkNotNull(group);
            if (StringsKt.contains$default((CharSequence) group, (CharSequence) string, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) group, (CharSequence) string2, false, 2, (Object) null)) {
                spannableString.setSpan(new SpanClickable(this, group), start, end, 34);
                spannableString.setSpan(new LinearGradientForegroundSpan(iArr), start, end, 18);
            }
        }
        return spannableString;
    }

    public final int m0() {
        int identifier = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final FragmentActivity n0() {
        return this.c;
    }

    public final int o0() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }

    public final boolean v0() {
        return m0() > o0();
    }
}
