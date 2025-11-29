package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

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
import sdk.meizu.account.factor.authentication.sdk.common.ResultUiState;
import sdk.meizu.account.factor.authentication.sdk.view.VCodeEditLayout;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "uiState", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeFragment$onViewCreated$3", f = "VerificationCodeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VerificationCodeFragment$onViewCreated$3 extends SuspendLambda implements Function2<ResultUiState<? extends String>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VerificationCodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerificationCodeFragment$onViewCreated$3(VerificationCodeFragment verificationCodeFragment, Continuation<? super VerificationCodeFragment$onViewCreated$3> continuation) {
        super(2, continuation);
        this.this$0 = verificationCodeFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        VerificationCodeFragment$onViewCreated$3 verificationCodeFragment$onViewCreated$3 = new VerificationCodeFragment$onViewCreated$3(this.this$0, continuation);
        verificationCodeFragment$onViewCreated$3.L$0 = obj;
        return verificationCodeFragment$onViewCreated$3;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ResultUiState resultUiState = (ResultUiState) this.L$0;
            if (!(resultUiState instanceof ResultUiState.Default)) {
                if (resultUiState instanceof ResultUiState.Loading) {
                    this.this$0.getVCodeModel().downFlow();
                } else if (resultUiState instanceof ResultUiState.Error) {
                    VCodeEditLayout access$getEditLayout$p = this.this$0.editLayout;
                    if (access$getEditLayout$p != null) {
                        access$getEditLayout$p.showError(((ResultUiState.Error) resultUiState).getMessage());
                    }
                } else {
                    boolean z = resultUiState instanceof ResultUiState.Success;
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull ResultUiState<String> resultUiState, @Nullable Continuation<? super Unit> continuation) {
        return ((VerificationCodeFragment$onViewCreated$3) create(resultUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
