package com.honey.account;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.data.AccountData;
import com.honey.account.module.BuildConfigProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationUtil;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/honey/account/HoneyAccountManager;", "", "()V", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HoneyAccountManager {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static BuildConfigProvider buildConfigProvider;

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u000b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u000b\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0007JW\u0010\u0012\u001a\u00020\r2M\u0010\u0013\u001aI\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\r0\u0014H\u0007J\b\u0010\u001b\u001a\u00020\nH\u0007J\b\u0010\u001c\u001a\u00020\nH\u0007J\b\u0010\u001d\u001a\u00020\nH\u0007JD\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007J+\u0010&\u001a\u00020\r2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\r0'H\u0007J\b\u0010)\u001a\u00020\u0011H\u0007J\b\u0010*\u001a\u00020\rH\u0007J\u0010\u0010+\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020,H\u0007J\u0010\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u0011H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006/"}, d2 = {"Lcom/honey/account/HoneyAccountManager$Companion;", "", "()V", "buildConfigProvider", "Lcom/honey/account/module/BuildConfigProvider;", "getBuildConfigProvider", "()Lcom/honey/account/module/BuildConfigProvider;", "setBuildConfigProvider", "(Lcom/honey/account/module/BuildConfigProvider;)V", "getAccountHomePageIntent", "Landroid/content/Intent;", "getAuthToken", "", "", "listener", "Lcom/honey/account/OnAuthListener;", "invalidateToken", "", "getDetail", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "status", "message", "Lcom/honey/account/data/AccountData;", "accountData", "getPasswordLoginIntent", "getSetPasswordIntent", "getVerificationCodeLoginIntent", "init", "context", "Landroid/content/Context;", "belong", "appId", "secret", "clientId", "clientSecret", "isSelfModifyPassword", "Lkotlin/Function1;", "isSelfSetPassword", "isShowPasswordLogin", "logout", "setLogoutListener", "Lcom/honey/account/OnLogoutListener;", "setShowPasswordLogin", "showPasswordLogin", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void init$default(Companion companion, Context context, String str, String str2, String str3, String str4, String str5, BuildConfigProvider buildConfigProvider, int i, Object obj) {
            companion.init(context, str, str2, str3, str4, str5, (i & 64) != 0 ? null : buildConfigProvider);
        }

        @JvmStatic
        @NotNull
        public final Intent getAccountHomePageIntent() {
            return AccountHelper.INSTANCE.getAccountHomePageIntent();
        }

        @JvmStatic
        @Nullable
        public final String getAuthToken() {
            return AccountHelper.INSTANCE.getAuthToken();
        }

        @Nullable
        public final BuildConfigProvider getBuildConfigProvider() {
            return HoneyAccountManager.buildConfigProvider;
        }

        @JvmStatic
        public final void getDetail(@NotNull Function3<? super Boolean, ? super String, ? super AccountData, Unit> function3) {
            Intrinsics.checkNotNullParameter(function3, "callback");
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new HoneyAccountManager$Companion$getDetail$1(function3, (Continuation<? super HoneyAccountManager$Companion$getDetail$1>) null), 3, (Object) null);
        }

        @JvmStatic
        @NotNull
        public final Intent getPasswordLoginIntent() {
            return AccountHelper.INSTANCE.getPasswordLoginIntent();
        }

        @JvmStatic
        @NotNull
        public final Intent getSetPasswordIntent() {
            return AccountHelper.INSTANCE.getSetPasswordIntent();
        }

        @JvmStatic
        @NotNull
        public final Intent getVerificationCodeLoginIntent() {
            return AccountHelper.INSTANCE.getVerificationCodeLoginIntent();
        }

        @JvmStatic
        @JvmOverloads
        public final void init(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "belong");
            Intrinsics.checkNotNullParameter(str2, "appId");
            Intrinsics.checkNotNullParameter(str3, "secret");
            String str6 = str4;
            Intrinsics.checkNotNullParameter(str6, "clientId");
            String str7 = str5;
            Intrinsics.checkNotNullParameter(str7, "clientSecret");
            init$default(this, context, str, str2, str3, str6, str7, (BuildConfigProvider) null, 64, (Object) null);
        }

        @JvmStatic
        public final void isSelfModifyPassword(@NotNull Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "callback");
            getDetail(new HoneyAccountManager$Companion$isSelfModifyPassword$1(function1));
        }

        @JvmStatic
        public final boolean isShowPasswordLogin() {
            return AccountHelper.INSTANCE.isShowPasswordLogin();
        }

        @JvmStatic
        public final void logout() {
            AccountHelper.INSTANCE.logout();
        }

        public final void setBuildConfigProvider(@Nullable BuildConfigProvider buildConfigProvider) {
            HoneyAccountManager.buildConfigProvider = buildConfigProvider;
        }

        @JvmStatic
        public final void setLogoutListener(@NotNull OnLogoutListener onLogoutListener) {
            Intrinsics.checkNotNullParameter(onLogoutListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            AccountHelper.INSTANCE.setLogoutListener(onLogoutListener);
        }

        @JvmStatic
        public final void setShowPasswordLogin(boolean z) {
            AccountHelper.INSTANCE.setShowPasswordLogin(z);
        }

        private Companion() {
        }

        @JvmStatic
        public final void getAuthToken(@NotNull OnAuthListener onAuthListener) {
            Intrinsics.checkNotNullParameter(onAuthListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            AccountHelper.INSTANCE.getAuthToken(onAuthListener);
        }

        @JvmStatic
        @JvmOverloads
        public final void init(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable BuildConfigProvider buildConfigProvider) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "belong");
            Intrinsics.checkNotNullParameter(str2, "appId");
            Intrinsics.checkNotNullParameter(str3, "secret");
            Intrinsics.checkNotNullParameter(str4, "clientId");
            Intrinsics.checkNotNullParameter(str5, "clientSecret");
            setBuildConfigProvider(buildConfigProvider);
            FactorAuthenticationUtil.INSTANCE.setBuildConfigProvider(new HoneyAccountManager$Companion$init$1(buildConfigProvider));
            AccountHelper.INSTANCE.init(context, str, str2, str3, str4, str5);
        }

        @JvmStatic
        public final void getAuthToken(boolean z, @NotNull OnAuthListener onAuthListener) {
            Intrinsics.checkNotNullParameter(onAuthListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            AccountHelper.INSTANCE.getAuthToken(z, onAuthListener);
        }
    }

    @JvmStatic
    @NotNull
    public static final Intent getAccountHomePageIntent() {
        return Companion.getAccountHomePageIntent();
    }

    @JvmStatic
    @Nullable
    public static final String getAuthToken() {
        return Companion.getAuthToken();
    }

    @JvmStatic
    public static final void getDetail(@NotNull Function3<? super Boolean, ? super String, ? super AccountData, Unit> function3) {
        Companion.getDetail(function3);
    }

    @JvmStatic
    @NotNull
    public static final Intent getPasswordLoginIntent() {
        return Companion.getPasswordLoginIntent();
    }

    @JvmStatic
    @NotNull
    public static final Intent getSetPasswordIntent() {
        return Companion.getSetPasswordIntent();
    }

    @JvmStatic
    @NotNull
    public static final Intent getVerificationCodeLoginIntent() {
        return Companion.getVerificationCodeLoginIntent();
    }

    @JvmStatic
    @JvmOverloads
    public static final void init(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Companion.init(context, str, str2, str3, str4, str5);
    }

    @JvmStatic
    public static final void isSelfModifyPassword(@NotNull Function1<? super Boolean, Unit> function1) {
        Companion.isSelfModifyPassword(function1);
    }

    @JvmStatic
    public static final boolean isShowPasswordLogin() {
        return Companion.isShowPasswordLogin();
    }

    @JvmStatic
    public static final void logout() {
        Companion.logout();
    }

    @JvmStatic
    public static final void setLogoutListener(@NotNull OnLogoutListener onLogoutListener) {
        Companion.setLogoutListener(onLogoutListener);
    }

    @JvmStatic
    public static final void setShowPasswordLogin(boolean z) {
        Companion.setShowPasswordLogin(z);
    }

    @JvmStatic
    public static final void getAuthToken(@NotNull OnAuthListener onAuthListener) {
        Companion.getAuthToken(onAuthListener);
    }

    @JvmStatic
    @JvmOverloads
    public static final void init(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable BuildConfigProvider buildConfigProvider2) {
        Companion.init(context, str, str2, str3, str4, str5, buildConfigProvider2);
    }

    @JvmStatic
    public static final void getAuthToken(boolean z, @NotNull OnAuthListener onAuthListener) {
        Companion.getAuthToken(z, onAuthListener);
    }
}
