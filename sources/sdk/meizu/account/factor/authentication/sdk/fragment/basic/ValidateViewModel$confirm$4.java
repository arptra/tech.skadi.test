package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivityKt;
import sdk.meizu.account.factor.authentication.sdk.common.ResultUiState;
import sdk.meizu.account.factor.authentication.sdk.data.AnswerType;
import sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository;

@SourceDebugExtension({"SMAP\nValidateViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValidateViewModel.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateViewModel$confirm$4\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,98:1\n230#2,5:99\n230#2,5:104\n*S KotlinDebug\n*F\n+ 1 ValidateViewModel.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateViewModel$confirm$4\n*L\n84#1:99,5\n93#1:104,5\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateViewModel$confirm$4", f = "ValidateViewModel.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
public final class ValidateViewModel$confirm$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<AnswerType> $answerData;
    int label;
    final /* synthetic */ ValidateViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValidateViewModel$confirm$4(ValidateViewModel validateViewModel, List<AnswerType> list, Continuation<? super ValidateViewModel$confirm$4> continuation) {
        super(2, continuation);
        this.this$0 = validateViewModel;
        this.$answerData = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ValidateViewModel$confirm$4(this.this$0, this.$answerData, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object value;
        Object value2;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FactorAuthenticationRepository access$getRepository$p = this.this$0.repository;
            String paramToken = FactorAuthenticationActivityKt.getParamToken();
            String paramAccount = FactorAuthenticationActivityKt.getParamAccount();
            List<AnswerType> list = this.$answerData;
            this.label = 1;
            obj2 = access$getRepository$p.m13confirmAnswerBWLJW6A(paramToken, paramAccount, list, this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = ((Result) obj).m29unboximpl();
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (Result.m26isFailureimpl(obj2)) {
            Throwable r0 = Result.m23exceptionOrNullimpl(obj2);
            MutableStateFlow access$get_confirmAnswerUiState$p = this.this$0._confirmAnswerUiState;
            do {
                value2 = access$get_confirmAnswerUiState$p.getValue();
                ResultUiState resultUiState = (ResultUiState) value2;
                if (r0 == null || (str = r0.getMessage()) == null) {
                    str = "未知异常错误";
                }
            } while (!access$get_confirmAnswerUiState$p.compareAndSet(value2, new ResultUiState.Error(str)));
            return Unit.INSTANCE;
        }
        if (Result.m26isFailureimpl(obj2)) {
            obj2 = null;
        }
        Boolean bool = (Boolean) obj2;
        if (bool != null) {
            ValidateViewModel validateViewModel = this.this$0;
            boolean booleanValue = bool.booleanValue();
            MutableStateFlow access$get_confirmAnswerUiState$p2 = validateViewModel._confirmAnswerUiState;
            do {
                value = access$get_confirmAnswerUiState$p2.getValue();
                ResultUiState resultUiState2 = (ResultUiState) value;
            } while (!access$get_confirmAnswerUiState$p2.compareAndSet(value, new ResultUiState.Success(Boxing.boxBoolean(booleanValue))));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ValidateViewModel$confirm$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
