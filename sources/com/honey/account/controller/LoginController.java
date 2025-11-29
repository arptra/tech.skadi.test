package com.honey.account.controller;

import android.content.Context;
import com.honey.account.data.AuthTokenData;
import com.honey.account.data.RememberMeToPasswordData;
import com.honey.account.data.RememberMeToVerificationCodeData;
import com.honey.account.utils.coroutine.CoroutineUtilsKt;
import com.honey.account.utils.sharedpreferences.SharedPreferencesUtilsKt;
import com.upuphone.runasone.api.ApiConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ!\u0010\r\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ1\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J)\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ-\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J?\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J5\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0016\u0010#\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0004J\u0016\u0010&\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/honey/account/controller/LoginController;", "", "()V", "CLIENT_AUTH_OTHER_DEVICE", "", "GRANT_TYPE_VALUE", "TRUST_SCOPE", "mShowPasswordLogin", "", "getMShowPasswordLogin", "()Z", "setMShowPasswordLogin", "(Z)V", "getAuthToken", "context", "Landroid/content/Context;", "Lcom/honey/account/data/AuthTokenData;", "rememberMe", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRememberMe", "getRememberMeToPassword", "Lcom/honey/account/data/RememberMeToPasswordData;", "phone", "password", "vCode", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRememberMeToVerificationCode", "Lcom/honey/account/data/RememberMeToVerificationCodeData;", "verificationCode", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lkotlin/Pair;", "", "loginToPassword", "loginToVerificationCode", "setAuthToken", "", "token", "setRememberMe", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LoginController {
    @NotNull
    private static final String CLIENT_AUTH_OTHER_DEVICE = "other_device_auth";
    @NotNull
    private static final String GRANT_TYPE_VALUE = "remember_me";
    @NotNull
    public static final LoginController INSTANCE = new LoginController();
    @NotNull
    private static final String TRUST_SCOPE = "trust";
    private static boolean mShowPasswordLogin = true;

    private LoginController() {
    }

    /* access modifiers changed from: private */
    public final Object getRememberMeToPassword(Context context, String str, String str2, String str3, Continuation<? super RememberMeToPasswordData> continuation) {
        return CoroutineUtilsKt.launchIO(new LoginController$getRememberMeToPassword$2(context, str, str2, str3), continuation);
    }

    /* access modifiers changed from: private */
    public final Object getRememberMeToVerificationCode(Context context, String str, String str2, Continuation<? super RememberMeToVerificationCodeData> continuation) {
        return CoroutineUtilsKt.launchIO(new LoginController$getRememberMeToVerificationCode$2(context, str, str2), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object login(android.content.Context r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Integer, java.lang.String>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.honey.account.controller.LoginController$login$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.honey.account.controller.LoginController$login$1 r0 = (com.honey.account.controller.LoginController$login$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.honey.account.controller.LoginController$login$1 r0 = new com.honey.account.controller.LoginController$login$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.label = r3
            java.lang.Object r7 = r4.getAuthToken(r5, r6, r0)
            if (r7 != r1) goto L_0x003d
            return r1
        L_0x003d:
            com.honey.account.data.AuthTokenData r7 = (com.honey.account.data.AuthTokenData) r7
            int r4 = r7.getCode()
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 != r5) goto L_0x0064
            java.lang.String r4 = r7.getAccessToken()
            if (r4 == 0) goto L_0x0064
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0054
            goto L_0x0064
        L_0x0054:
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            java.lang.String r5 = r7.getAccessToken()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
            goto L_0x0074
        L_0x0064:
            int r4 = r7.getCode()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.String r5 = r7.getMessage()
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
        L_0x0074:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.controller.LoginController.login(android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object loginToPassword$default(LoginController loginController, Context context, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = "";
        }
        return loginController.loginToPassword(context, str, str2, str3, continuation);
    }

    @Nullable
    public final String getAuthToken(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SharedPreferencesUtilsKt.getConfig(context, "access_token");
    }

    public final boolean getMShowPasswordLogin() {
        return mShowPasswordLogin;
    }

    @Nullable
    public final String getRememberMe(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SharedPreferencesUtilsKt.getConfig(context, "remember_me");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: android.content.Context} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loginToPassword(@org.jetbrains.annotations.NotNull android.content.Context r10, @org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull java.lang.String r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Integer, java.lang.String>> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof com.honey.account.controller.LoginController$loginToPassword$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.honey.account.controller.LoginController$loginToPassword$1 r0 = (com.honey.account.controller.LoginController$loginToPassword$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.honey.account.controller.LoginController$loginToPassword$1 r0 = new com.honey.account.controller.LoginController$loginToPassword$1
            r0.<init>(r9, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L_0x0041
            if (r1 == r2) goto L_0x0034
            if (r1 != r8) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0083
        L_0x002c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0034:
            java.lang.Object r9 = r0.L$1
            r10 = r9
            android.content.Context r10 = (android.content.Context) r10
            java.lang.Object r9 = r0.L$0
            com.honey.account.controller.LoginController r9 = (com.honey.account.controller.LoginController) r9
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0057
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r14)
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r2
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r0
            java.lang.Object r14 = r1.getRememberMeToPassword(r2, r3, r4, r5, r6)
            if (r14 != r7) goto L_0x0057
            return r7
        L_0x0057:
            com.honey.account.data.RememberMeToPasswordData r14 = (com.honey.account.data.RememberMeToPasswordData) r14
            int r11 = r14.getCode()
            r12 = 200(0xc8, float:2.8E-43)
            if (r11 != r12) goto L_0x0084
            java.lang.String r11 = r14.getRememberMe()
            if (r11 == 0) goto L_0x0084
            int r11 = r11.length()
            if (r11 != 0) goto L_0x006e
            goto L_0x0084
        L_0x006e:
            java.lang.String r11 = r14.getRememberMe()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r12 = 0
            r0.L$0 = r12
            r0.L$1 = r12
            r0.label = r8
            java.lang.Object r14 = r9.login(r10, r11, r0)
            if (r14 != r7) goto L_0x0083
            return r7
        L_0x0083:
            return r14
        L_0x0084:
            int r9 = r14.getCode()
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            java.lang.String r10 = r14.getMessage()
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.controller.LoginController.loginToPassword(android.content.Context, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: android.content.Context} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loginToVerificationCode(@org.jetbrains.annotations.NotNull android.content.Context r6, @org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Integer, java.lang.String>> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.honey.account.controller.LoginController$loginToVerificationCode$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.honey.account.controller.LoginController$loginToVerificationCode$1 r0 = (com.honey.account.controller.LoginController$loginToVerificationCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.honey.account.controller.LoginController$loginToVerificationCode$1 r0 = new com.honey.account.controller.LoginController$loginToVerificationCode$1
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x007d
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            android.content.Context r6 = (android.content.Context) r6
            java.lang.Object r5 = r0.L$0
            com.honey.account.controller.LoginController r5 = (com.honey.account.controller.LoginController) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0051
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r9 = r5.getRememberMeToVerificationCode(r6, r7, r8, r0)
            if (r9 != r1) goto L_0x0051
            return r1
        L_0x0051:
            com.honey.account.data.RememberMeToVerificationCodeData r9 = (com.honey.account.data.RememberMeToVerificationCodeData) r9
            int r7 = r9.getCode()
            r8 = 200(0xc8, float:2.8E-43)
            if (r7 != r8) goto L_0x007e
            java.lang.String r7 = r9.getRememberMe()
            if (r7 == 0) goto L_0x007e
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0068
            goto L_0x007e
        L_0x0068:
            java.lang.String r7 = r9.getRememberMe()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r5.login(r6, r7, r0)
            if (r9 != r1) goto L_0x007d
            return r1
        L_0x007d:
            return r9
        L_0x007e:
            int r5 = r9.getCode()
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            java.lang.String r6 = r9.getMessage()
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.controller.LoginController.loginToVerificationCode(android.content.Context, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setAuthToken(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, ApiConstant.KEY_TOKEN);
        SharedPreferencesUtilsKt.applyConfig(context, "access_token", str);
    }

    public final void setMShowPasswordLogin(boolean z) {
        mShowPasswordLogin = z;
    }

    public final void setRememberMe(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "rememberMe");
        SharedPreferencesUtilsKt.applyConfig(context, "remember_me", str);
    }

    @Nullable
    public final Object getAuthToken(@NotNull Context context, @NotNull String str, @NotNull Continuation<? super AuthTokenData> continuation) {
        return CoroutineUtilsKt.launchIO(new LoginController$getAuthToken$2(context, str), continuation);
    }
}
