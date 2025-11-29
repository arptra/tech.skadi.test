package com.honey.account.view.login.vcode;

import com.honey.account.R;
import com.honey.account.common.ResultUiState;
import com.honey.account.view.login.validate.ValidateAccountActivity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "vCodeUiState", "Lcom/honey/account/common/ResultUiState;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.login.vcode.VCodeLoginActivity$onCreate$1", f = "VCodeLoginActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VCodeLoginActivity$onCreate$1 extends SuspendLambda implements Function2<ResultUiState<? extends Boolean>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VCodeLoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VCodeLoginActivity$onCreate$1(VCodeLoginActivity vCodeLoginActivity, Continuation<? super VCodeLoginActivity$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = vCodeLoginActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        VCodeLoginActivity$onCreate$1 vCodeLoginActivity$onCreate$1 = new VCodeLoginActivity$onCreate$1(this.this$0, continuation);
        vCodeLoginActivity$onCreate$1.L$0 = obj;
        return vCodeLoginActivity$onCreate$1;
    }

    @Nullable
    public final Object invoke(@NotNull ResultUiState<Boolean> resultUiState, @Nullable Continuation<? super Unit> continuation) {
        return ((VCodeLoginActivity$onCreate$1) create(resultUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ResultUiState resultUiState = (ResultUiState) this.L$0;
            if (!(resultUiState instanceof ResultUiState.Loading ? true : Intrinsics.areEqual((Object) resultUiState, (Object) ResultUiState.Default.INSTANCE))) {
                if (resultUiState instanceof ResultUiState.Error) {
                    this.this$0.showError(((ResultUiState.Error) resultUiState).getMessage());
                } else if (resultUiState instanceof ResultUiState.Success) {
                    VCodeLoginActivity vCodeLoginActivity = this.this$0;
                    ValidateAccountActivity.Companion companion = ValidateAccountActivity.Companion;
                    String accountInAreaCode = vCodeLoginActivity.getAccountEditLayout().getAccountInAreaCode();
                    String string = this.this$0.getString(R.string.vcode_send_to);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{this.this$0.getViewModel().formatAccount(this.this$0.getAccountEditLayout().getAccount())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    vCodeLoginActivity.startActivityForResult(ValidateAccountActivity.Companion.getValidatePhoneActivity$default(companion, vCodeLoginActivity, accountInAreaCode, format, (String) null, 8, (Object) null), 100);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
