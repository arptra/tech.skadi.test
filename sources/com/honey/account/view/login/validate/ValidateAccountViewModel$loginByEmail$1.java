package com.honey.account.view.login.validate;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nValidateAccountViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValidateAccountViewModel.kt\ncom/honey/account/view/login/validate/ValidateAccountViewModel$loginByEmail$1\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,158:1\n230#2,5:159\n230#2,5:164\n230#2,5:169\n*S KotlinDebug\n*F\n+ 1 ValidateAccountViewModel.kt\ncom/honey/account/view/login/validate/ValidateAccountViewModel$loginByEmail$1\n*L\n103#1:159,5\n114#1:164,5\n122#1:169,5\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.login.validate.ValidateAccountViewModel$loginByEmail$1", f = "ValidateAccountViewModel.kt", i = {}, l = {100, 111}, m = "invokeSuspend", n = {}, s = {})
public final class ValidateAccountViewModel$loginByEmail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $account;
    final /* synthetic */ String $vCode;
    Object L$0;
    int label;
    final /* synthetic */ ValidateAccountViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValidateAccountViewModel$loginByEmail$1(ValidateAccountViewModel validateAccountViewModel, String str, String str2, Continuation<? super ValidateAccountViewModel$loginByEmail$1> continuation) {
        super(2, continuation);
        this.this$0 = validateAccountViewModel;
        this.$account = str;
        this.$vCode = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ValidateAccountViewModel$loginByEmail$1(this.this$0, this.$account, this.$vCode, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c3  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0030
            if (r1 == r3) goto L_0x0026
            if (r1 != r2) goto L_0x001e
            java.lang.Object r6 = r6.L$0
            com.honey.account.view.login.validate.ValidateAccountViewModel r6 = (com.honey.account.view.login.validate.ValidateAccountViewModel) r6
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r7 = r7.m29unboximpl()
            goto L_0x0096
        L_0x001e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r7 = r7.m29unboximpl()
            goto L_0x0046
        L_0x0030:
            kotlin.ResultKt.throwOnFailure(r7)
            com.honey.account.view.login.validate.ValidateAccountViewModel r7 = r6.this$0
            com.honey.account.view.login.repository.LoginRepository r7 = r7.loginRepository
            java.lang.String r1 = r6.$account
            java.lang.String r5 = r6.$vCode
            r6.label = r3
            java.lang.Object r7 = r7.m1731loginByEmail0E7RQCE(r1, r5, r6)
            if (r7 != r0) goto L_0x0046
            return r0
        L_0x0046:
            boolean r1 = kotlin.Result.m26isFailureimpl(r7)
            if (r1 == 0) goto L_0x0075
            java.lang.Throwable r1 = kotlin.Result.m23exceptionOrNullimpl(r7)
            com.honey.account.view.login.validate.ValidateAccountViewModel r6 = r6.this$0
            kotlinx.coroutines.flow.MutableStateFlow r3 = r6._loginUiState
        L_0x0056:
            java.lang.Object r6 = r3.getValue()
            r7 = r6
            com.honey.account.common.ResultUiState r7 = (com.honey.account.common.ResultUiState) r7
            com.honey.account.common.ResultUiState$Error r7 = new com.honey.account.common.ResultUiState$Error
            if (r1 == 0) goto L_0x0067
            java.lang.String r0 = r1.getMessage()
            if (r0 != 0) goto L_0x0069
        L_0x0067:
            java.lang.String r0 = "未知错误"
        L_0x0069:
            r7.<init>(r0)
            boolean r6 = r3.compareAndSet(r6, r7)
            if (r6 == 0) goto L_0x0056
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0075:
            boolean r1 = kotlin.Result.m26isFailureimpl(r7)
            if (r1 == 0) goto L_0x007c
            r7 = r4
        L_0x007c:
            com.honey.account.view.login.data.LoggedData r7 = (com.honey.account.view.login.data.LoggedData) r7
            if (r7 == 0) goto L_0x0137
            com.honey.account.view.login.validate.ValidateAccountViewModel r1 = r6.this$0
            com.honey.account.view.oauth.TokenRepository r3 = r1.tokenRepository
            java.lang.String r7 = r7.getRememberMe()
            r6.L$0 = r1
            r6.label = r2
            java.lang.Object r7 = r3.m1732getTokengIAlus(r7, r6)
            if (r7 != r0) goto L_0x0095
            return r0
        L_0x0095:
            r6 = r1
        L_0x0096:
            boolean r0 = kotlin.Result.m26isFailureimpl(r7)
            if (r0 == 0) goto L_0x00c3
            java.lang.Throwable r0 = kotlin.Result.m23exceptionOrNullimpl(r7)
            kotlinx.coroutines.flow.MutableStateFlow r1 = r6._loginUiState
        L_0x00a4:
            java.lang.Object r6 = r1.getValue()
            r7 = r6
            com.honey.account.common.ResultUiState r7 = (com.honey.account.common.ResultUiState) r7
            com.honey.account.common.ResultUiState$Error r7 = new com.honey.account.common.ResultUiState$Error
            if (r0 == 0) goto L_0x00b5
            java.lang.String r2 = r0.getMessage()
            if (r2 != 0) goto L_0x00b7
        L_0x00b5:
            java.lang.String r2 = ""
        L_0x00b7:
            r7.<init>(r2)
            boolean r6 = r1.compareAndSet(r6, r7)
            if (r6 == 0) goto L_0x00a4
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x00c3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "loginByEmail, getToken: "
            r0.append(r1)
            boolean r1 = kotlin.Result.m26isFailureimpl(r7)
            if (r1 == 0) goto L_0x00d5
            r1 = r4
            goto L_0x00d6
        L_0x00d5:
            r1 = r7
        L_0x00d6:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ValidateAccountViewModel"
            android.util.Log.e(r1, r0)
            boolean r0 = kotlin.Result.m26isFailureimpl(r7)
            if (r0 == 0) goto L_0x00e9
            goto L_0x00ea
        L_0x00e9:
            r4 = r7
        L_0x00ea:
            com.honey.account.view.oauth.data.TokenData r4 = (com.honey.account.view.oauth.data.TokenData) r4
            if (r4 == 0) goto L_0x0137
            kotlinx.coroutines.flow.MutableStateFlow r6 = r6._loginUiState
        L_0x00f2:
            java.lang.Object r7 = r6.getValue()
            r0 = r7
            com.honey.account.common.ResultUiState r0 = (com.honey.account.common.ResultUiState) r0
            boolean r0 = r4 instanceof com.honey.account.view.oauth.data.OAuthTokenData
            if (r0 == 0) goto L_0x010a
            com.honey.account.common.ResultUiState$Success r0 = new com.honey.account.common.ResultUiState$Success
            r1 = r4
            com.honey.account.view.oauth.data.OAuthTokenData r1 = (com.honey.account.view.oauth.data.OAuthTokenData) r1
            java.lang.String r1 = r1.getAccessToken()
            r0.<init>(r1)
            goto L_0x0131
        L_0x010a:
            boolean r0 = r4 instanceof com.honey.account.view.oauth.data.ErrorTokenData
            if (r0 == 0) goto L_0x011b
            com.honey.account.common.ResultUiState$Error r0 = new com.honey.account.common.ResultUiState$Error
            r1 = r4
            com.honey.account.view.oauth.data.ErrorTokenData r1 = (com.honey.account.view.oauth.data.ErrorTokenData) r1
            java.lang.String r1 = r1.getError()
            r0.<init>(r1)
            goto L_0x0131
        L_0x011b:
            com.honey.account.common.ResultUiState$Error r0 = new com.honey.account.common.ResultUiState$Error
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "tokenData. "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
        L_0x0131:
            boolean r7 = r6.compareAndSet(r7, r0)
            if (r7 == 0) goto L_0x00f2
        L_0x0137:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.view.login.validate.ValidateAccountViewModel$loginByEmail$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ValidateAccountViewModel$loginByEmail$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
