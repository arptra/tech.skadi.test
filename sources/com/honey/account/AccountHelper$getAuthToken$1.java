package com.honey.account;

import android.content.Context;
import com.honey.account.controller.LoginController;
import com.honey.account.data.AuthTokenData;
import com.honey.account.utils.log.LogUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.AccountHelper$getAuthToken$1", f = "AccountHelper.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
public final class AccountHelper$getAuthToken$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ OnAuthListener $listener;
    final /* synthetic */ String $rememberMe;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountHelper$getAuthToken$1(String str, OnAuthListener onAuthListener, Continuation<? super AccountHelper$getAuthToken$1> continuation) {
        super(1, continuation);
        this.$rememberMe = str;
        this.$listener = onAuthListener;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new AccountHelper$getAuthToken$1(this.$rememberMe, this.$listener, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LoginController loginController = LoginController.INSTANCE;
            Context mApplicationContext = AccountHelper.INSTANCE.getMApplicationContext();
            String str = this.$rememberMe;
            this.label = 1;
            obj = loginController.getAuthToken(mApplicationContext, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AuthTokenData authTokenData = (AuthTokenData) obj;
        LogUtils logUtils = LogUtils.INSTANCE;
        logUtils.i("AccountHelper", "getAuthToken success, AuthTokenData: " + authTokenData);
        int code = authTokenData.getCode();
        if (code == 200) {
            this.$listener.onSuccess(authTokenData.getAccessToken());
        } else if (code != 990001) {
            this.$listener.onError(authTokenData.getCode(), authTokenData.getMessage());
        } else {
            this.$listener.onHandleIntent(AccountHelper.INSTANCE.getVerificationCodeLoginIntent());
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((AccountHelper$getAuthToken$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
