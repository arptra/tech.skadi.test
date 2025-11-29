package sdk.meizu.account.factor.authentication.sdk.fragment.answer;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
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
import sdk.meizu.account.factor.authentication.sdk.data.AnswerType;
import sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData;
import sdk.meizu.account.factor.authentication.sdk.fragment.answer.adapter.AnswerListAdapter;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "uiState", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", "Lsdk/meizu/account/factor/authentication/sdk/data/ResponseValidateData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.fragment.answer.AnswerFragment$onViewCreated$4", f = "AnswerFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AnswerFragment$onViewCreated$4 extends SuspendLambda implements Function2<ResultUiState<? extends ResponseValidateData>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AnswerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnswerFragment$onViewCreated$4(AnswerFragment answerFragment, Continuation<? super AnswerFragment$onViewCreated$4> continuation) {
        super(2, continuation);
        this.this$0 = answerFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AnswerFragment$onViewCreated$4 answerFragment$onViewCreated$4 = new AnswerFragment$onViewCreated$4(this.this$0, continuation);
        answerFragment$onViewCreated$4.L$0 = obj;
        return answerFragment$onViewCreated$4;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List<AnswerType> userAnswerValidate;
        RecyclerView access$getRecyclerView$p;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ResultUiState resultUiState = (ResultUiState) this.L$0;
            if (!(!(resultUiState instanceof ResultUiState.Success) || (userAnswerValidate = ((ResponseValidateData) ((ResultUiState.Success) resultUiState).getData()).getUserAnswerValidate()) == null || (access$getRecyclerView$p = this.this$0.recyclerView) == null)) {
                access$getRecyclerView$p.setAdapter(new AnswerListAdapter(userAnswerValidate));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull ResultUiState<ResponseValidateData> resultUiState, @Nullable Continuation<? super Unit> continuation) {
        return ((AnswerFragment$onViewCreated$4) create(resultUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
