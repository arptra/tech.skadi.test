package com.honey.account.view.oauth;

import com.honey.account.AccountHelper;
import com.honey.account.api.TokenApiService;
import com.honey.account.controller.LoginController;
import com.honey.account.view.oauth.data.OAuthTokenData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/honey/account/view/oauth/TokenRepository;", "", "tokenApiService", "Lcom/honey/account/api/TokenApiService;", "(Lcom/honey/account/api/TokenApiService;)V", "addAccount", "Lcom/honey/account/view/oauth/data/OAuthTokenData;", "tokenResult", "getToken", "Lkotlin/Result;", "Lcom/honey/account/view/oauth/data/TokenData;", "rememberMe", "", "getToken-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TokenRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "TokenRepository";
    @NotNull
    private final TokenApiService tokenApiService;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/honey/account/view/oauth/TokenRepository$Companion;", "", "()V", "TAG", "", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Inject
    public TokenRepository(@NotNull TokenApiService tokenApiService2) {
        Intrinsics.checkNotNullParameter(tokenApiService2, "tokenApiService");
        this.tokenApiService = tokenApiService2;
    }

    private final OAuthTokenData addAccount(OAuthTokenData oAuthTokenData) {
        LoginController.INSTANCE.setAuthToken(AccountHelper.INSTANCE.getMApplicationContext(), oAuthTokenData.getAccessToken());
        return oAuthTokenData;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009a A[Catch:{ all -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a2 A[Catch:{ all -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: getToken-gIAlu-s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1732getTokengIAlus(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<? extends com.honey.account.view.oauth.data.TokenData>> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "remember_me"
            boolean r1 = r8 instanceof com.honey.account.view.oauth.TokenRepository$getToken$1
            if (r1 == 0) goto L_0x0015
            r1 = r8
            com.honey.account.view.oauth.TokenRepository$getToken$1 r1 = (com.honey.account.view.oauth.TokenRepository$getToken$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            com.honey.account.view.oauth.TokenRepository$getToken$1 r1 = new com.honey.account.view.oauth.TokenRepository$getToken$1
            r1.<init>(r6, r8)
        L_0x001a:
            java.lang.Object r8 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L_0x003a
            if (r3 != r4) goto L_0x0032
            java.lang.Object r6 = r1.L$0
            com.honey.account.view.oauth.TokenRepository r6 = (com.honey.account.view.oauth.TokenRepository) r6
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x002f }
            goto L_0x0078
        L_0x002f:
            r6 = move-exception
            goto L_0x00b4
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x002f }
            r8.<init>()     // Catch:{ all -> 0x002f }
            r8.put(r0, r7)     // Catch:{ all -> 0x002f }
            java.lang.String r7 = "client_secret"
            com.honey.account.AccountHelper r3 = com.honey.account.AccountHelper.INSTANCE     // Catch:{ all -> 0x002f }
            java.lang.String r5 = r3.getMClientSecret()     // Catch:{ all -> 0x002f }
            r8.put(r7, r5)     // Catch:{ all -> 0x002f }
            java.lang.String r7 = "client_id"
            java.lang.String r5 = r3.getMClientId()     // Catch:{ all -> 0x002f }
            r8.put(r7, r5)     // Catch:{ all -> 0x002f }
            java.lang.String r7 = "grant_type"
            r8.put(r7, r0)     // Catch:{ all -> 0x002f }
            java.lang.String r7 = "pkg"
            android.content.Context r0 = r3.getMApplicationContext()     // Catch:{ all -> 0x002f }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x002f }
            r8.put(r7, r0)     // Catch:{ all -> 0x002f }
            com.honey.account.api.TokenApiService r7 = r6.tokenApiService     // Catch:{ all -> 0x002f }
            r1.L$0 = r6     // Catch:{ all -> 0x002f }
            r1.label = r4     // Catch:{ all -> 0x002f }
            java.lang.Object r8 = r7.getAuthToken(r8, r1)     // Catch:{ all -> 0x002f }
            if (r8 != r2) goto L_0x0078
            return r2
        L_0x0078:
            com.honey.account.view.oauth.data.OAuthTokenData r8 = (com.honey.account.view.oauth.data.OAuthTokenData) r8     // Catch:{ all -> 0x002f }
            java.lang.String r7 = "TokenRepository"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x002f }
            r0.<init>()     // Catch:{ all -> 0x002f }
            java.lang.String r1 = "getToken. value: "
            r0.append(r1)     // Catch:{ all -> 0x002f }
            r0.append(r8)     // Catch:{ all -> 0x002f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x002f }
            android.util.Log.d(r7, r0)     // Catch:{ all -> 0x002f }
            java.lang.String r7 = r8.getAccessToken()     // Catch:{ all -> 0x002f }
            int r7 = r7.length()     // Catch:{ all -> 0x002f }
            if (r7 <= 0) goto L_0x00a2
            r6.addAccount(r8)     // Catch:{ all -> 0x002f }
            java.lang.Object r6 = kotlin.Result.m20constructorimpl(r8)     // Catch:{ all -> 0x002f }
            goto L_0x010e
        L_0x00a2:
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x002f }
            java.lang.RuntimeException r6 = new java.lang.RuntimeException     // Catch:{ all -> 0x002f }
            java.lang.String r7 = "错误"
            r6.<init>(r7)     // Catch:{ all -> 0x002f }
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)     // Catch:{ all -> 0x002f }
            java.lang.Object r6 = kotlin.Result.m20constructorimpl(r6)     // Catch:{ all -> 0x002f }
            goto L_0x010e
        L_0x00b4:
            boolean r7 = r6 instanceof retrofit2.HttpException
            if (r7 == 0) goto L_0x00fb
            r7 = r6
            retrofit2.HttpException r7 = (retrofit2.HttpException) r7
            retrofit2.Response r7 = r7.response()
            if (r7 == 0) goto L_0x00cd
            okhttp3.ResponseBody r7 = r7.errorBody()
            if (r7 == 0) goto L_0x00cd
            java.lang.String r7 = r7.string()
            if (r7 != 0) goto L_0x00cf
        L_0x00cd:
            java.lang.String r7 = ""
        L_0x00cf:
            int r8 = r7.length()
            if (r8 <= 0) goto L_0x00e7
            com.google.gson.Gson r6 = new com.google.gson.Gson
            r6.<init>()
            java.lang.Class<com.honey.account.view.oauth.data.ErrorTokenData> r8 = com.honey.account.view.oauth.data.ErrorTokenData.class
            java.lang.Object r6 = r6.fromJson((java.lang.String) r7, r8)
            com.honey.account.view.oauth.data.ErrorTokenData r6 = (com.honey.account.view.oauth.data.ErrorTokenData) r6
            java.lang.Object r6 = kotlin.Result.m20constructorimpl(r6)
            goto L_0x010e
        L_0x00e7:
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r6 = r6.getMessage()
            r7.<init>(r6)
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r6 = kotlin.Result.m20constructorimpl(r6)
            goto L_0x010e
        L_0x00fb:
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r6 = r6.getMessage()
            r7.<init>(r6)
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r6 = kotlin.Result.m20constructorimpl(r6)
        L_0x010e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.view.oauth.TokenRepository.m1732getTokengIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
