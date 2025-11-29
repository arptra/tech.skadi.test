package com.honey.account.view.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.honey.account.R;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.AccountAboutActivity;
import com.honey.account.view.PersonalInfoActivity;
import com.honey.account.view.home.AccountHomepageActivity;
import com.honey.account.view.login.pwd.PasswordLoginActivity;
import com.honey.account.view.login.vcode.VCodeLoginActivity;
import com.honey.account.view.web.WebActivity;
import com.upuphone.runasone.uupcast.CaptureType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u001a\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\"\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u001a\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u0016\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0016\u001a\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u0016\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"REQ_CODE_BIND_EMAIL", "", "REQ_CODE_BIND_PHONE", "REQ_CODE_CHANGE_PASSWORD", "REQ_CODE_COUNTRY", "REQ_CODE_FORGET_PASSWORD", "REQ_CODE_PASSWORD_LOGIN", "REQ_CODE_PERSONAL", "REQ_CODE_VERIFICATION_CODE_LOGIN", "getAccountHomePageIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "getPasswordLoginIntent", "getVerificationCodeLoginIntent", "startAccountAboutActivity", "", "activity", "Landroid/app/Activity;", "startAccountCancellationActivity", "startAppByScheme", "pkgName", "", "scheme", "startChangeBindEmailActivityAfterLogin", "startChangeBindPhoneActivityAfterLogin", "startForgetPasswordActivity", "startPasswordLoginActivityForResult", "phone", "startPersonalInfoActivity", "startVerificationCodeLoginActivityForResult", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ActivityGotoHelperKt {
    public static final int REQ_CODE_BIND_EMAIL = 10;
    public static final int REQ_CODE_BIND_PHONE = 4;
    public static final int REQ_CODE_CHANGE_PASSWORD = 7;
    public static final int REQ_CODE_COUNTRY = 9;
    public static final int REQ_CODE_FORGET_PASSWORD = 3;
    public static final int REQ_CODE_PASSWORD_LOGIN = 1;
    public static final int REQ_CODE_PERSONAL = 5;
    public static final int REQ_CODE_VERIFICATION_CODE_LOGIN = 0;

    @NotNull
    public static final Intent getAccountHomePageIntent(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, AccountHomepageActivity.class);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    @NotNull
    public static final Intent getPasswordLoginIntent(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, PasswordLoginActivity.class);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    @NotNull
    public static final Intent getVerificationCodeLoginIntent(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, VCodeLoginActivity.class);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static final void startAccountAboutActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.startActivityForResult(new Intent(activity, AccountAboutActivity.class), 5);
    }

    public static final void startAccountCancellationActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.startActivity(WebActivity.Companion.openPage(AccountConstantKt.URL_ACCOUNT_UNREGISTER, ""));
    }

    public static final void startAppByScheme(@NotNull Context context, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!TextUtils.isEmpty(str2)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (!TextUtils.isEmpty(str)) {
                    intent.setPackage(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    intent.setData(Uri.parse(str2));
                }
                intent.setFlags(536870912);
                context.startActivity(intent);
            } catch (Exception e) {
                Log.w("ActivityGotoHelper", "startAppByPackageName throw Exception" + e.getMessage());
            }
        }
    }

    public static final void startChangeBindEmailActivityAfterLogin(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        WebActivity.Companion companion = WebActivity.Companion;
        String string = activity.getResources().getString(R.string.update_email);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        activity.startActivityForResult(companion.openPage(AccountConstantKt.URL_CHANGE_BIND_EMAIL, string), 10);
    }

    public static final void startChangeBindPhoneActivityAfterLogin(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        WebActivity.Companion companion = WebActivity.Companion;
        String string = activity.getResources().getString(R.string.change_bind_phone);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        activity.startActivityForResult(companion.openPage(AccountConstantKt.URL_CHANGE_BIND_PHONE, string), 4);
    }

    public static final void startForgetPasswordActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.startActivity(WebActivity.Companion.openPage(AccountConstantKt.URL_FORGET_PWD, ""));
    }

    public static final void startPasswordLoginActivityForResult(@NotNull Activity activity, @NotNull String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "phone");
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        Intent passwordLoginIntent = getPasswordLoginIntent(applicationContext);
        passwordLoginIntent.putExtra("phone", str);
        passwordLoginIntent.addFlags(CaptureType.CAPTURE_TYPE_ICCOA);
        activity.startActivityForResult(passwordLoginIntent, 1);
    }

    public static final void startPersonalInfoActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.startActivityForResult(new Intent(activity, PersonalInfoActivity.class), 5);
    }

    public static final void startVerificationCodeLoginActivityForResult(@NotNull Activity activity, @NotNull String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "phone");
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        Intent verificationCodeLoginIntent = getVerificationCodeLoginIntent(applicationContext);
        verificationCodeLoginIntent.putExtra("phone", str);
        verificationCodeLoginIntent.addFlags(CaptureType.CAPTURE_TYPE_ICCOA);
        activity.startActivityForResult(verificationCodeLoginIntent, 0);
    }
}
