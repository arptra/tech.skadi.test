package com.honey.account;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import com.fm.sdk.deviceid.DeviceId;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.controller.LoginController;
import com.honey.account.controller.LogoutController;
import com.honey.account.country.util.CountryManager;
import com.honey.account.manager.PrivacyManager;
import com.honey.account.utils.coroutine.CoroutineUtilsKt;
import com.honey.account.utils.log.LogUtils;
import com.honey.account.view.helper.ActivityGotoHelperKt;
import com.honey.account.view.web.WebActivity;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u0004\u0018\u00010\u0004J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0016\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020)J\u0006\u0010,\u001a\u00020%J\b\u0010-\u001a\u0004\u0018\u00010\u0004J\u0006\u0010.\u001a\u00020%J\u0006\u0010/\u001a\u00020%J6\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0004J\u0006\u00107\u001a\u00020+J\u0006\u00108\u001a\u00020'J\u000e\u00109\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001cJ\u000e\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020+R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\t¨\u0006<"}, d2 = {"Lcom/honey/account/AccountHelper;", "", "()V", "TAG", "", "mAppId", "getMAppId", "()Ljava/lang/String;", "setMAppId", "(Ljava/lang/String;)V", "mApplicationContext", "Landroid/content/Context;", "getMApplicationContext", "()Landroid/content/Context;", "setMApplicationContext", "(Landroid/content/Context;)V", "mBelong", "getMBelong", "setMBelong", "mClientId", "getMClientId", "setMClientId", "mClientSecret", "getMClientSecret", "setMClientSecret", "mInitialize", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mOnLogoutListener", "Lcom/honey/account/OnLogoutListener;", "getMOnLogoutListener", "()Lcom/honey/account/OnLogoutListener;", "setMOnLogoutListener", "(Lcom/honey/account/OnLogoutListener;)V", "mSecret", "getMSecret", "setMSecret", "getAccountHomePageIntent", "Landroid/content/Intent;", "getAuthToken", "", "listener", "Lcom/honey/account/OnAuthListener;", "invalidateToken", "", "getPasswordLoginIntent", "getRememberMe", "getSetPasswordIntent", "getVerificationCodeLoginIntent", "init", "context", "belong", "appId", "secret", "clientId", "clientSecret", "isShowPasswordLogin", "logout", "setLogoutListener", "setShowPasswordLogin", "showPasswordLogin", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class AccountHelper {
    @NotNull
    public static final AccountHelper INSTANCE = new AccountHelper();
    @NotNull
    private static final String TAG = "AccountHelper";
    public static String mAppId;
    public static Context mApplicationContext;
    public static String mBelong;
    public static String mClientId;
    public static String mClientSecret;
    @NotNull
    private static AtomicBoolean mInitialize = new AtomicBoolean(false);
    @Nullable
    private static OnLogoutListener mOnLogoutListener;
    public static String mSecret;

    private AccountHelper() {
    }

    @NotNull
    public final Intent getAccountHomePageIntent() {
        return ActivityGotoHelperKt.getAccountHomePageIntent(getMApplicationContext());
    }

    @Nullable
    public final String getAuthToken() {
        return LoginController.INSTANCE.getAuthToken(getMApplicationContext());
    }

    @NotNull
    public final String getMAppId() {
        String str = mAppId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAppId");
        return null;
    }

    @NotNull
    public final Context getMApplicationContext() {
        Context context = mApplicationContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mApplicationContext");
        return null;
    }

    @NotNull
    public final String getMBelong() {
        String str = mBelong;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBelong");
        return null;
    }

    @NotNull
    public final String getMClientId() {
        String str = mClientId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mClientId");
        return null;
    }

    @NotNull
    public final String getMClientSecret() {
        String str = mClientSecret;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mClientSecret");
        return null;
    }

    @Nullable
    public final OnLogoutListener getMOnLogoutListener() {
        return mOnLogoutListener;
    }

    @NotNull
    public final String getMSecret() {
        String str = mSecret;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSecret");
        return null;
    }

    @NotNull
    public final Intent getPasswordLoginIntent() {
        return ActivityGotoHelperKt.getPasswordLoginIntent(getMApplicationContext());
    }

    @Nullable
    public final String getRememberMe() {
        return LoginController.INSTANCE.getRememberMe(getMApplicationContext());
    }

    @NotNull
    public final Intent getSetPasswordIntent() {
        WebActivity.Companion companion = WebActivity.Companion;
        String string = getMApplicationContext().getResources().getString(R.string.set_password);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return companion.openPage(AccountConstantKt.URL_SETTING_PWD, string);
    }

    @NotNull
    public final Intent getVerificationCodeLoginIntent() {
        return ActivityGotoHelperKt.getVerificationCodeLoginIntent(getMApplicationContext());
    }

    public final void init(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "belong");
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, "secret");
        Intrinsics.checkNotNullParameter(str4, "clientId");
        Intrinsics.checkNotNullParameter(str5, "clientSecret");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        setMApplicationContext(applicationContext);
        setMBelong(str);
        setMAppId(str2);
        setMSecret(str3);
        setMClientId(str4);
        setMClientSecret(str5);
        if (mInitialize.compareAndSet(false, true)) {
            CountryManager.INSTANCE.init(getMApplicationContext());
            DeviceId.init(getMApplicationContext());
            LogUtils.INSTANCE.init(getMApplicationContext());
            PrivacyManager.INSTANCE.initSDK(getMApplicationContext(), str);
        }
    }

    public final boolean isShowPasswordLogin() {
        return LoginController.INSTANCE.getMShowPasswordLogin();
    }

    public final void logout() {
        LogoutController.INSTANCE.logout(getMApplicationContext());
    }

    public final void setLogoutListener(@NotNull OnLogoutListener onLogoutListener) {
        Intrinsics.checkNotNullParameter(onLogoutListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        mOnLogoutListener = onLogoutListener;
    }

    public final void setMAppId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mAppId = str;
    }

    public final void setMApplicationContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        mApplicationContext = context;
    }

    public final void setMBelong(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mBelong = str;
    }

    public final void setMClientId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mClientId = str;
    }

    public final void setMClientSecret(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mClientSecret = str;
    }

    public final void setMOnLogoutListener(@Nullable OnLogoutListener onLogoutListener) {
        mOnLogoutListener = onLogoutListener;
    }

    public final void setMSecret(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mSecret = str;
    }

    public final void setShowPasswordLogin(boolean z) {
        LoginController.INSTANCE.setMShowPasswordLogin(z);
    }

    public final void getAuthToken(@NotNull OnAuthListener onAuthListener) {
        Intrinsics.checkNotNullParameter(onAuthListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        String rememberMe = LoginController.INSTANCE.getRememberMe(getMApplicationContext());
        if (rememberMe == null || StringsKt.isBlank(rememberMe)) {
            LogUtils.INSTANCE.e(TAG, "getAuthToken rememberMe is null");
            onAuthListener.onHandleIntent(getVerificationCodeLoginIntent());
            return;
        }
        CoroutineUtilsKt.launchMain(new AccountHelper$getAuthToken$1(rememberMe, onAuthListener, (Continuation<? super AccountHelper$getAuthToken$1>) null));
    }

    public final void getAuthToken(boolean z, @NotNull OnAuthListener onAuthListener) {
        Intrinsics.checkNotNullParameter(onAuthListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        String authToken = getAuthToken();
        if (authToken == null || authToken.length() == 0 || z) {
            getAuthToken(onAuthListener);
        } else {
            onAuthListener.onSuccess(authToken);
        }
    }
}
