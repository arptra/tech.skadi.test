package com.honey.account.view.home;

import android.content.Context;
import com.honey.account.controller.LoginController;
import com.honey.account.data.AuthTokenData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.home.AccountHomepageActivity$onActivityResult$2", f = "AccountHomepageActivity.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {})
public final class AccountHomepageActivity$onActivityResult$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $rememberMe;
    int label;
    final /* synthetic */ AccountHomepageActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountHomepageActivity$onActivityResult$2(AccountHomepageActivity accountHomepageActivity, String str, Continuation<? super AccountHomepageActivity$onActivityResult$2> continuation) {
        super(1, continuation);
        this.this$0 = accountHomepageActivity;
        this.$rememberMe = str;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new AccountHomepageActivity$onActivityResult$2(this.this$0, this.$rememberMe, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LoginController loginController = LoginController.INSTANCE;
            Context applicationContext = this.this$0.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            String str = this.$rememberMe;
            this.label = 1;
            obj = loginController.getAuthToken(applicationContext, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (200 == ((AuthTokenData) obj).getCode()) {
            this.this$0.getViewModel().getDetail();
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((AccountHomepageActivity$onActivityResult$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
