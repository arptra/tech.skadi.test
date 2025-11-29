package com.honey.account.view.helper;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import com.honey.account.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/honey/account/view/helper/PolicyAgreementStringBuilder;", "", "mContext", "Landroid/content/Context;", "mOnClickListener", "Lcom/honey/account/view/helper/PolicyAgreementStringBuilder$OnClickListener;", "(Landroid/content/Context;Lcom/honey/account/view/helper/PolicyAgreementStringBuilder$OnClickListener;)V", "getMContext", "()Landroid/content/Context;", "getMOnClickListener", "()Lcom/honey/account/view/helper/PolicyAgreementStringBuilder$OnClickListener;", "addBookTitleMarkIfNeed", "", "src", "combinePrivacyPolicyAndUserAgreement", "userAgreement", "privacyPolicy", "create", "Landroid/text/SpannableString;", "id", "", "OnClickListener", "PermissionClickableSpan", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PolicyAgreementStringBuilder {
    @NotNull
    private final Context mContext;
    @NotNull
    private final OnClickListener mOnClickListener;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/honey/account/view/helper/PolicyAgreementStringBuilder$OnClickListener;", "", "onPrivacyPolicyClick", "", "context", "Landroid/content/Context;", "onUserAgreementClick", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnClickListener {
        void onPrivacyPolicyClick(@Nullable Context context);

        void onUserAgreementClick(@Nullable Context context);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/honey/account/view/helper/PolicyAgreementStringBuilder$PermissionClickableSpan;", "Landroid/text/style/ClickableSpan;", "()V", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class PermissionClickableSpan extends ClickableSpan {
        public void onClick(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "widget");
            view.cancelPendingInputEvents();
        }

        public void updateDrawState(@NotNull TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(!PolicyAgreementStringBuilderKt.isZh());
            textPaint.setColor(-14712837);
        }
    }

    public PolicyAgreementStringBuilder(@NotNull Context context, @NotNull OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(onClickListener, "mOnClickListener");
        this.mContext = context;
        this.mOnClickListener = onClickListener;
    }

    private final String addBookTitleMarkIfNeed(String str) {
        if (!PolicyAgreementStringBuilderKt.isZh()) {
            return str;
        }
        return 12298 + str + 12299;
    }

    private final String combinePrivacyPolicyAndUserAgreement(String str, String str2) {
        if (PolicyAgreementStringBuilderKt.isZh()) {
            return str + this.mContext.getResources().getString(R.string.and) + str2;
        }
        return str + ' ' + this.mContext.getResources().getString(R.string.and) + ' ' + str2;
    }

    @Nullable
    public final SpannableString create(int i) {
        String string = this.mContext.getResources().getString(R.string.honey_service_agreement);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String addBookTitleMarkIfNeed = addBookTitleMarkIfNeed(string);
        String string2 = this.mContext.getResources().getString(R.string.honey_privacy_policy);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String addBookTitleMarkIfNeed2 = addBookTitleMarkIfNeed(string2);
        String string3 = this.mContext.getResources().getString(i, new Object[]{addBookTitleMarkIfNeed, addBookTitleMarkIfNeed2});
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        SpannableString spannableString = new SpannableString(string3);
        if (!TextUtils.isEmpty(addBookTitleMarkIfNeed)) {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) string3, addBookTitleMarkIfNeed, 0, false, 6, (Object) null);
            int length = addBookTitleMarkIfNeed.length() + indexOf$default;
            spannableString.setSpan(new StyleSpan(1), indexOf$default, length, 18);
            spannableString.setSpan(new PolicyAgreementStringBuilder$create$1(this), indexOf$default, length, 18);
        }
        if (!TextUtils.isEmpty(addBookTitleMarkIfNeed2)) {
            int indexOf$default2 = StringsKt.indexOf$default((CharSequence) string3, addBookTitleMarkIfNeed2, 0, false, 6, (Object) null);
            int length2 = addBookTitleMarkIfNeed2.length() + indexOf$default2;
            spannableString.setSpan(new StyleSpan(1), indexOf$default2, length2, 18);
            spannableString.setSpan(new PolicyAgreementStringBuilder$create$2(this), indexOf$default2, length2, 18);
        }
        return spannableString;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final OnClickListener getMOnClickListener() {
        return this.mOnClickListener;
    }
}
