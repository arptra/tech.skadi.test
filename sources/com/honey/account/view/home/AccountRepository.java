package com.honey.account.view.home;

import com.honey.account.api.AccountApiService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\b\u0010\tJ*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\f\u001a\u00020\u000bH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/honey/account/view/home/AccountRepository;", "", "accountApiService", "Lcom/honey/account/api/AccountApiService;", "(Lcom/honey/account/api/AccountApiService;)V", "getDetail", "Lkotlin/Result;", "Lcom/honey/account/data/AccountData;", "getDetail-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "", "code", "logout-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AccountRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "AccountRepository";
    @NotNull
    private final AccountApiService accountApiService;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/honey/account/view/home/AccountRepository$Companion;", "", "()V", "TAG", "", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Inject
    public AccountRepository(@NotNull AccountApiService accountApiService2) {
        Intrinsics.checkNotNullParameter(accountApiService2, "accountApiService");
        this.accountApiService = accountApiService2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072 A[Catch:{ all -> 0x002b }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0095 A[Catch:{ all -> 0x002b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: getDetail-IoAF18A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1728getDetailIoAF18A(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<com.honey.account.data.AccountData>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.honey.account.view.home.AccountRepository$getDetail$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.honey.account.view.home.AccountRepository$getDetail$1 r0 = (com.honey.account.view.home.AccountRepository$getDetail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.honey.account.view.home.AccountRepository$getDetail$1 r0 = new com.honey.account.view.home.AccountRepository$getDetail$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "AccountRepository"
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002b }
            goto L_0x004e
        L_0x002b:
            r5 = move-exception
            goto L_0x00c1
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.honey.account.api.AccountApiService r5 = r5.accountApiService     // Catch:{ all -> 0x002b }
            com.honey.account.AccountHelper r6 = com.honey.account.AccountHelper.INSTANCE     // Catch:{ all -> 0x002b }
            java.lang.String r6 = r6.getAuthToken()     // Catch:{ all -> 0x002b }
            if (r6 != 0) goto L_0x0045
            java.lang.String r6 = ""
        L_0x0045:
            r0.label = r3     // Catch:{ all -> 0x002b }
            java.lang.Object r6 = r5.getDetail(r6, r0)     // Catch:{ all -> 0x002b }
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            com.honey.account.data.ResponseModel r6 = (com.honey.account.data.ResponseModel) r6     // Catch:{ all -> 0x002b }
            java.lang.String r5 = "TAG"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r0.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r1 = "getDetail accountData: "
            r0.append(r1)     // Catch:{ all -> 0x002b }
            r0.append(r6)     // Catch:{ all -> 0x002b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x002b }
            android.util.Log.i(r5, r0)     // Catch:{ all -> 0x002b }
            java.lang.String r5 = r6.getCode()     // Catch:{ all -> 0x002b }
            java.lang.String r0 = "200"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)     // Catch:{ all -> 0x002b }
            if (r5 == 0) goto L_0x0095
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r5.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r0 = "getDetail. value: "
            r5.append(r0)     // Catch:{ all -> 0x002b }
            java.lang.Object r0 = r6.getValue()     // Catch:{ all -> 0x002b }
            r5.append(r0)     // Catch:{ all -> 0x002b }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x002b }
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x002b }
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x002b }
            java.lang.Object r5 = r6.getValue()     // Catch:{ all -> 0x002b }
            java.lang.Object r5 = kotlin.Result.m20constructorimpl(r5)     // Catch:{ all -> 0x002b }
            goto L_0x00e8
        L_0x0095:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r5.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r0 = "getDetail. fail: "
            r5.append(r0)     // Catch:{ all -> 0x002b }
            java.lang.String r0 = r6.getMessage()     // Catch:{ all -> 0x002b }
            r5.append(r0)     // Catch:{ all -> 0x002b }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x002b }
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x002b }
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x002b }
            java.lang.RuntimeException r5 = new java.lang.RuntimeException     // Catch:{ all -> 0x002b }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x002b }
            r5.<init>(r6)     // Catch:{ all -> 0x002b }
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)     // Catch:{ all -> 0x002b }
            java.lang.Object r5 = kotlin.Result.m20constructorimpl(r5)     // Catch:{ all -> 0x002b }
            goto L_0x00e8
        L_0x00c1:
            java.lang.String r6 = "getDetail fail. "
            android.util.Log.e(r4, r6, r5)
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            boolean r0 = r5 instanceof retrofit2.HttpException
            if (r0 == 0) goto L_0x00d9
            retrofit2.HttpException r5 = (retrofit2.HttpException) r5
            int r5 = r5.code()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            goto L_0x00dd
        L_0x00d9:
            java.lang.String r5 = r5.getMessage()
        L_0x00dd:
            r6.<init>(r5)
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r5 = kotlin.Result.m20constructorimpl(r5)
        L_0x00e8:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.view.home.AccountRepository.m1728getDetailIoAF18A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072 A[Catch:{ all -> 0x002b }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009b A[Catch:{ all -> 0x002b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: logout-gIAlu-s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1729logoutgIAlus(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.honey.account.view.home.AccountRepository$logout$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.honey.account.view.home.AccountRepository$logout$1 r0 = (com.honey.account.view.home.AccountRepository$logout$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.honey.account.view.home.AccountRepository$logout$1 r0 = new com.honey.account.view.home.AccountRepository$logout$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "AccountRepository"
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x002b }
            goto L_0x004e
        L_0x002b:
            r5 = move-exception
            goto L_0x00c7
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            com.honey.account.api.AccountApiService r5 = r5.accountApiService     // Catch:{ all -> 0x002b }
            com.honey.account.AccountHelper r7 = com.honey.account.AccountHelper.INSTANCE     // Catch:{ all -> 0x002b }
            java.lang.String r7 = r7.getAuthToken()     // Catch:{ all -> 0x002b }
            if (r7 != 0) goto L_0x0045
            java.lang.String r7 = ""
        L_0x0045:
            r0.label = r3     // Catch:{ all -> 0x002b }
            java.lang.Object r7 = r5.logout(r6, r7, r0)     // Catch:{ all -> 0x002b }
            if (r7 != r1) goto L_0x004e
            return r1
        L_0x004e:
            com.honey.account.data.ResponseModel r7 = (com.honey.account.data.ResponseModel) r7     // Catch:{ all -> 0x002b }
            java.lang.String r5 = "TAG"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r6.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r0 = "logout sign: "
            r6.append(r0)     // Catch:{ all -> 0x002b }
            r6.append(r7)     // Catch:{ all -> 0x002b }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x002b }
            android.util.Log.i(r5, r6)     // Catch:{ all -> 0x002b }
            java.lang.String r5 = r7.getCode()     // Catch:{ all -> 0x002b }
            java.lang.String r6 = "200"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x002b }
            if (r5 == 0) goto L_0x009b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r5.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r6 = "logout. value: "
            r5.append(r6)     // Catch:{ all -> 0x002b }
            java.lang.Object r6 = r7.getValue()     // Catch:{ all -> 0x002b }
            r5.append(r6)     // Catch:{ all -> 0x002b }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x002b }
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x002b }
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x002b }
            java.lang.Object r5 = r7.getValue()     // Catch:{ all -> 0x002b }
            com.honey.account.data.LogoutData r5 = (com.honey.account.data.LogoutData) r5     // Catch:{ all -> 0x002b }
            java.lang.String r5 = r5.getSign()     // Catch:{ all -> 0x002b }
            java.lang.Object r5 = kotlin.Result.m20constructorimpl(r5)     // Catch:{ all -> 0x002b }
            goto L_0x00ee
        L_0x009b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r5.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r6 = "logout. fail: "
            r5.append(r6)     // Catch:{ all -> 0x002b }
            java.lang.String r6 = r7.getMessage()     // Catch:{ all -> 0x002b }
            r5.append(r6)     // Catch:{ all -> 0x002b }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x002b }
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x002b }
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x002b }
            java.lang.RuntimeException r5 = new java.lang.RuntimeException     // Catch:{ all -> 0x002b }
            java.lang.String r6 = r7.getMessage()     // Catch:{ all -> 0x002b }
            r5.<init>(r6)     // Catch:{ all -> 0x002b }
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)     // Catch:{ all -> 0x002b }
            java.lang.Object r5 = kotlin.Result.m20constructorimpl(r5)     // Catch:{ all -> 0x002b }
            goto L_0x00ee
        L_0x00c7:
            java.lang.String r6 = "logout fail. "
            android.util.Log.e(r4, r6, r5)
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            boolean r7 = r5 instanceof retrofit2.HttpException
            if (r7 == 0) goto L_0x00df
            retrofit2.HttpException r5 = (retrofit2.HttpException) r5
            int r5 = r5.code()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            goto L_0x00e3
        L_0x00df:
            java.lang.String r5 = r5.getMessage()
        L_0x00e3:
            r6.<init>(r5)
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r5 = kotlin.Result.m20constructorimpl(r5)
        L_0x00ee:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.view.home.AccountRepository.m1729logoutgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
