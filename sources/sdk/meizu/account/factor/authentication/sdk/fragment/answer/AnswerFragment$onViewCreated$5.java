package sdk.meizu.account.factor.authentication.sdk.fragment.answer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.common.ResultUiState;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "uiState", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.fragment.answer.AnswerFragment$onViewCreated$5", f = "AnswerFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AnswerFragment$onViewCreated$5 extends SuspendLambda implements Function2<ResultUiState<? extends Boolean>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AnswerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnswerFragment$onViewCreated$5(AnswerFragment answerFragment, Continuation<? super AnswerFragment$onViewCreated$5> continuation) {
        super(2, continuation);
        this.this$0 = answerFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AnswerFragment$onViewCreated$5 answerFragment$onViewCreated$5 = new AnswerFragment$onViewCreated$5(this.this$0, continuation);
        answerFragment$onViewCreated$5.L$0 = obj;
        return answerFragment$onViewCreated$5;
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [androidx.fragment.app.FragmentActivity] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r2) {
        /*
            r1 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            if (r0 != 0) goto L_0x0053
            kotlin.ResultKt.throwOnFailure(r2)
            java.lang.Object r2 = r1.L$0
            sdk.meizu.account.factor.authentication.sdk.common.ResultUiState r2 = (sdk.meizu.account.factor.authentication.sdk.common.ResultUiState) r2
            boolean r0 = r2 instanceof sdk.meizu.account.factor.authentication.sdk.common.ResultUiState.Default
            if (r0 != 0) goto L_0x0050
            boolean r0 = r2 instanceof sdk.meizu.account.factor.authentication.sdk.common.ResultUiState.Loading
            if (r0 == 0) goto L_0x0024
            sdk.meizu.account.factor.authentication.sdk.fragment.answer.AnswerFragment r1 = r1.this$0
            sdk.meizu.account.factor.authentication.sdk.common.widget.MzButton r1 = r1.nextBtn
            if (r1 != 0) goto L_0x001f
            goto L_0x0050
        L_0x001f:
            r2 = 0
            r1.setEnabled(r2)
            goto L_0x0050
        L_0x0024:
            boolean r0 = r2 instanceof sdk.meizu.account.factor.authentication.sdk.common.ResultUiState.Error
            if (r0 == 0) goto L_0x0034
            sdk.meizu.account.factor.authentication.sdk.fragment.answer.AnswerFragment r1 = r1.this$0
            sdk.meizu.account.factor.authentication.sdk.common.ResultUiState$Error r2 = (sdk.meizu.account.factor.authentication.sdk.common.ResultUiState.Error) r2
            java.lang.String r2 = r2.getMessage()
            r1.showError(r2)
            goto L_0x0050
        L_0x0034:
            boolean r2 = r2 instanceof sdk.meizu.account.factor.authentication.sdk.common.ResultUiState.Success
            if (r2 == 0) goto L_0x0050
            sdk.meizu.account.factor.authentication.sdk.fragment.answer.AnswerFragment r2 = r1.this$0
            r0 = 0
            r2.showError(r0)
            sdk.meizu.account.factor.authentication.sdk.fragment.answer.AnswerFragment r1 = r1.this$0
            androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
            boolean r2 = r1 instanceof sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity
            if (r2 == 0) goto L_0x004b
            r0 = r1
            sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity r0 = (sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity) r0
        L_0x004b:
            if (r0 == 0) goto L_0x0050
            r0.answerValidateSuccess()
        L_0x0050:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0053:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.fragment.answer.AnswerFragment$onViewCreated$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull ResultUiState<Boolean> resultUiState, @Nullable Continuation<? super Unit> continuation) {
        return ((AnswerFragment$onViewCreated$5) create(resultUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
