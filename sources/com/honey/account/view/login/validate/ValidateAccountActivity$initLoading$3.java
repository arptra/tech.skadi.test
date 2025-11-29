package com.honey.account.view.login.validate;

import android.content.Intent;
import com.honey.account.common.ResultUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "loginUiState", "Lcom/honey/account/common/ResultUiState;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.login.validate.ValidateAccountActivity$initLoading$3", f = "ValidateAccountActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ValidateAccountActivity$initLoading$3 extends SuspendLambda implements Function2<ResultUiState<? extends String>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ValidateAccountActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValidateAccountActivity$initLoading$3(ValidateAccountActivity validateAccountActivity, Continuation<? super ValidateAccountActivity$initLoading$3> continuation) {
        super(2, continuation);
        this.this$0 = validateAccountActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ValidateAccountActivity$initLoading$3 validateAccountActivity$initLoading$3 = new ValidateAccountActivity$initLoading$3(this.this$0, continuation);
        validateAccountActivity$initLoading$3.L$0 = obj;
        return validateAccountActivity$initLoading$3;
    }

    @Nullable
    public final Object invoke(@NotNull ResultUiState<String> resultUiState, @Nullable Continuation<? super Unit> continuation) {
        return ((ValidateAccountActivity$initLoading$3) create(resultUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ResultUiState resultUiState = (ResultUiState) this.L$0;
            if (!(resultUiState instanceof ResultUiState.Default)) {
                if (resultUiState instanceof ResultUiState.Loading) {
                    this.this$0.onStartLogin();
                } else if (resultUiState instanceof ResultUiState.Error) {
                    this.this$0.onStopLogin();
                    this.this$0.showErrorMsg(((ResultUiState.Error) resultUiState).getMessage());
                } else if (resultUiState instanceof ResultUiState.Success) {
                    this.this$0.onStopLogin();
                    ValidateAccountActivity validateAccountActivity = this.this$0;
                    Intent intent = new Intent();
                    intent.putExtra("access_token", (String) ((ResultUiState.Success) resultUiState).getData());
                    validateAccountActivity.setResultOKAndFinish(intent);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
