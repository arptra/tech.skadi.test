package flyme.support.v7.permission;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.common.StarryNetConstant;
import flyme.support.v7.appcompat.R;
import java.util.Locale;
import java.util.Objects;

public class TermsStringBuilder {
    public static final int PERMISSION_NORMAL = 0;
    public static final int PERMISSION_NO_INTERNET = 2;
    public static final int PERMISSION_ONLY_INTERNET = 1;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_UPDATE_BUTTON_DENY = 3;
    public static final int TYPE_UPDATE_BUTTON_EXIT = 2;
    public static final int TYPE_UPDATE_BUTTON_KNOW = 1;
    private int mBuilderType = 0;
    private final Context mContext;
    private String mCustomPrivacyPolicyName = null;
    private String mCustomUserAgreementName = null;
    private boolean mHasPermission = true;
    private int mInternetPermission = 0;
    /* access modifiers changed from: private */
    public OnClickListener mOnClickListener;
    private boolean mPrivacyPolicy = true;
    private boolean mUserAgreement = false;

    public interface OnClickListener {
        void onPrivacyPolicyClick(Context context);

        void onUserAgreementClick(Context context);
    }

    public static class PermissionClickableSpan extends URLSpan {
        private static final int FLYME_COLOR = -15505157;
        private static final int POLE_STAR_COLOR = -35584;

        public PermissionClickableSpan(String str, Context context) {
            super(str);
        }

        @CallSuper
        public void onClick(@NonNull View view) {
            view.cancelPendingInputEvents();
        }

        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            int i = TermsStringBuilder.isPoleStarTheme() ? POLE_STAR_COLOR : FLYME_COLOR;
            textPaint.setUnderlineText(false);
            textPaint.setColor(i);
        }
    }

    public TermsStringBuilder(Context context) {
        this.mContext = context;
    }

    private String addBookTitleMarkIfNeed(String str) {
        if (!isZh()) {
            return "\"" + str + "\"";
        }
        return "《" + str + "》";
    }

    private String combinePrivacyPolicyAndUserAgreement(String str, String str2) {
        if (isZh()) {
            return str + "和" + str2;
        }
        return str + " and " + str2;
    }

    /* access modifiers changed from: private */
    public static boolean isPoleStarTheme() {
        Class<String> cls = String.class;
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{"ro.flyme.build.channel", StarryNetConstant.DEVICE_NAME_UNKNOWN});
            Objects.requireNonNull(invoke);
            return invoke.toString().contains("polestar");
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean isZh() {
        return "zh".equals(Locale.getDefault().getLanguage());
    }

    public SpannableString create() {
        String str;
        String str2;
        if (this.mOnClickListener != null) {
            boolean z = this.mPrivacyPolicy;
            if (z || this.mUserAgreement || this.mHasPermission) {
                String str3 = null;
                if (z) {
                    String str4 = this.mCustomPrivacyPolicyName;
                    if (str4 == null) {
                        str4 = this.mContext.getResources().getString(R.string.mz_privacy_policy);
                    }
                    str = addBookTitleMarkIfNeed(str4);
                } else {
                    str = null;
                }
                if (this.mUserAgreement) {
                    String str5 = this.mCustomUserAgreementName;
                    if (str5 == null) {
                        str5 = this.mContext.getResources().getString(R.string.mz_user_agreement);
                    }
                    str3 = addBookTitleMarkIfNeed(str5);
                }
                boolean z2 = this.mPrivacyPolicy;
                if (!z2 || !this.mUserAgreement) {
                    str2 = z2 ? this.mBuilderType == 0 ? this.mContext.getResources().getString(R.string.mz_permission_policy_description_f9, new Object[]{str}) : this.mContext.getResources().getString(R.string.mz_permission_policy_description_update, new Object[]{str}) : this.mUserAgreement ? this.mBuilderType == 0 ? this.mContext.getResources().getString(R.string.mz_permission_policy_description_f9, new Object[]{str3}) : this.mContext.getResources().getString(R.string.mz_permission_policy_description_update, new Object[]{str3}) : this.mContext.getResources().getString(R.string.mz_permission_policy_description_noly_internet);
                } else {
                    String combinePrivacyPolicyAndUserAgreement = combinePrivacyPolicyAndUserAgreement(str, str3);
                    str2 = this.mBuilderType == 0 ? this.mContext.getResources().getString(R.string.mz_permission_policy_description_f9, new Object[]{combinePrivacyPolicyAndUserAgreement}) : this.mContext.getResources().getString(R.string.mz_permission_policy_description_update, new Object[]{combinePrivacyPolicyAndUserAgreement});
                }
                if (this.mHasPermission) {
                    if (!TextUtils.isEmpty(str2)) {
                        if (isZh()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str2);
                            sb.append((this.mPrivacyPolicy || this.mUserAgreement) ? "。" : "，");
                            str2 = sb.toString();
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str2);
                            sb2.append((this.mPrivacyPolicy || this.mUserAgreement) ? ". " : ", ");
                            str2 = sb2.toString();
                        }
                    }
                    int i = this.mInternetPermission;
                    if (i == 0) {
                        str2 = str2 + this.mContext.getResources().getString(R.string.mz_permission_inform_f9);
                    } else if (i == 1) {
                        str2 = str2 + this.mContext.getResources().getString(R.string.mz_permission_inform_f9_only_internet);
                    } else if (i == 2) {
                        str2 = str2 + this.mContext.getResources().getString(R.string.mz_permission_inform_f9_no_internet);
                    }
                }
                SpannableString spannableString = new SpannableString(str2);
                if (!TextUtils.isEmpty(str)) {
                    int indexOf = str2.indexOf(str);
                    spannableString.setSpan(new PermissionClickableSpan(str, this.mContext) {
                        public void onClick(@NonNull View view) {
                            super.onClick(view);
                            TermsStringBuilder.this.mOnClickListener.onPrivacyPolicyClick(view.getContext());
                        }
                    }, indexOf, str.length() + indexOf, 18);
                }
                if (!TextUtils.isEmpty(str3)) {
                    int indexOf2 = str2.indexOf(str3);
                    spannableString.setSpan(new PermissionClickableSpan(str3, this.mContext) {
                        public void onClick(@NonNull View view) {
                            super.onClick(view);
                            TermsStringBuilder.this.mOnClickListener.onUserAgreementClick(view.getContext());
                        }
                    }, indexOf2, str3.length() + indexOf2, 18);
                }
                return spannableString;
            }
            throw new IllegalStateException("mHasPermission mPrivacyPolicy and mUserAgreement can't be false at the same time");
        }
        throw new IllegalStateException("mOnClickListener can't be null");
    }

    public TermsStringBuilder setBuilderType(int i) {
        this.mBuilderType = i;
        return this;
    }

    public TermsStringBuilder setHasPermission(boolean z) {
        this.mHasPermission = z;
        return this;
    }

    public TermsStringBuilder setInternetPermissionType(int i) {
        this.mInternetPermission = i;
        return this;
    }

    public TermsStringBuilder setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        return this;
    }

    public TermsStringBuilder setPrivacyPolicy(boolean z) {
        this.mPrivacyPolicy = z;
        return this;
    }

    public TermsStringBuilder setPrivacyPolicyName(String str) {
        this.mCustomPrivacyPolicyName = str;
        return this;
    }

    public TermsStringBuilder setUserAgreement(boolean z) {
        this.mUserAgreement = z;
        return this;
    }

    public TermsStringBuilder setUserAgreementName(String str) {
        this.mCustomUserAgreementName = str;
        return this;
    }
}
