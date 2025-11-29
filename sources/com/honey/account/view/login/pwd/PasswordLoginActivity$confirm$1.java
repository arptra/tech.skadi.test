package com.honey.account.view.login.pwd;

import android.content.Context;
import android.content.Intent;
import com.honey.account.controller.LoginController;
import com.honey.account.utils.log.LogUtils;
import com.honey.account.view.login.validate.ValidateAccountActivity;
import kotlin.Metadata;
import kotlin.Pair;
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
@DebugMetadata(c = "com.honey.account.view.login.pwd.PasswordLoginActivity$confirm$1", f = "PasswordLoginActivity.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
public final class PasswordLoginActivity$confirm$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $password;
    final /* synthetic */ String $phone;
    int label;
    final /* synthetic */ PasswordLoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PasswordLoginActivity$confirm$1(PasswordLoginActivity passwordLoginActivity, String str, String str2, Continuation<? super PasswordLoginActivity$confirm$1> continuation) {
        super(1, continuation);
        this.this$0 = passwordLoginActivity;
        this.$phone = str;
        this.$password = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new PasswordLoginActivity$confirm$1(this.this$0, this.$phone, this.$password, continuation);
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
            String str = this.$phone;
            String str2 = this.$password;
            Intrinsics.checkNotNullExpressionValue(str2, "$password");
            this.label = 1;
            obj = LoginController.loginToPassword$default(loginController, applicationContext, str, str2, (String) null, this, 8, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Pair pair = (Pair) obj;
        this.this$0.onStopLogin();
        if (403007 == ((Number) pair.getFirst()).intValue()) {
            PasswordLoginActivity passwordLoginActivity = this.this$0;
            passwordLoginActivity.startActivityForResult(ValidateAccountActivity.Companion.getValidatePhoneActivity(passwordLoginActivity, this.$phone, (String) pair.getSecond(), this.$password), 100);
        } else if (200 != ((Number) pair.getFirst()).intValue()) {
            LogUtils logUtils = LogUtils.INSTANCE;
            logUtils.e("PasswordLoginActivity", "login error, " + ((String) pair.getSecond()));
            this.this$0.showError((String) pair.getSecond());
            return Unit.INSTANCE;
        }
        Intent intent = new Intent();
        intent.putExtra("access_token", (String) pair.getSecond());
        this.this$0.setResultOKAndFinish(intent);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((PasswordLoginActivity$confirm$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
