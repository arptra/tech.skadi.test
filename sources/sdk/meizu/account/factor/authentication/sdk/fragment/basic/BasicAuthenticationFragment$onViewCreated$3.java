package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import androidx.fragment.app.FragmentActivity;
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
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity;
import sdk.meizu.account.factor.authentication.sdk.common.ResultUiState;
import sdk.meizu.account.factor.authentication.sdk.data.ConfirmValue;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "uiState", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", "Lsdk/meizu/account/factor/authentication/sdk/data/ConfirmValue;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.fragment.basic.BasicAuthenticationFragment$onViewCreated$3", f = "BasicAuthenticationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BasicAuthenticationFragment$onViewCreated$3 extends SuspendLambda implements Function2<ResultUiState<? extends ConfirmValue>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BasicAuthenticationFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasicAuthenticationFragment$onViewCreated$3(BasicAuthenticationFragment basicAuthenticationFragment, Continuation<? super BasicAuthenticationFragment$onViewCreated$3> continuation) {
        super(2, continuation);
        this.this$0 = basicAuthenticationFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BasicAuthenticationFragment$onViewCreated$3 basicAuthenticationFragment$onViewCreated$3 = new BasicAuthenticationFragment$onViewCreated$3(this.this$0, continuation);
        basicAuthenticationFragment$onViewCreated$3.L$0 = obj;
        return basicAuthenticationFragment$onViewCreated$3;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ResultUiState resultUiState = (ResultUiState) this.L$0;
            if (resultUiState instanceof ResultUiState.Default ? true : Intrinsics.areEqual((Object) resultUiState, (Object) ResultUiState.Loading.INSTANCE)) {
                this.this$0.showError((String) null);
            } else if (resultUiState instanceof ResultUiState.Error) {
                this.this$0.showError(((ResultUiState.Error) resultUiState).getMessage());
            } else if (resultUiState instanceof ResultUiState.Success) {
                FragmentActivity activity = this.this$0.getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity");
                ((FactorAuthenticationActivity) activity).validateSuccess(((ConfirmValue) ((ResultUiState.Success) resultUiState).getData()).getValidateCode());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull ResultUiState<ConfirmValue> resultUiState, @Nullable Continuation<? super Unit> continuation) {
        return ((BasicAuthenticationFragment$onViewCreated$3) create(resultUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
