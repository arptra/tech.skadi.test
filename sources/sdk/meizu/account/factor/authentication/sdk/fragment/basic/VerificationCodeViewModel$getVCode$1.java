package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;
import sdk.meizu.account.factor.authentication.sdk.data.GeetestData;
import sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository;

@SourceDebugExtension({"SMAP\nVerificationCodeViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerificationCodeViewModel.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/basic/VerificationCodeViewModel$getVCode$1\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,78:1\n230#2,5:79\n230#2,5:84\n230#2,5:89\n*S KotlinDebug\n*F\n+ 1 VerificationCodeViewModel.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/basic/VerificationCodeViewModel$getVCode$1\n*L\n43#1:79,5\n48#1:84,5\n58#1:89,5\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeViewModel$getVCode$1", f = "VerificationCodeViewModel.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
public final class VerificationCodeViewModel$getVCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GeetestData $data;
    final /* synthetic */ String $token;
    final /* synthetic */ BasicInfoType $type;
    int label;
    final /* synthetic */ VerificationCodeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerificationCodeViewModel$getVCode$1(VerificationCodeViewModel verificationCodeViewModel, String str, BasicInfoType basicInfoType, GeetestData geetestData, Continuation<? super VerificationCodeViewModel$getVCode$1> continuation) {
        super(2, continuation);
        this.this$0 = verificationCodeViewModel;
        this.$token = str;
        this.$type = basicInfoType;
        this.$data = geetestData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VerificationCodeViewModel$getVCode$1(this.this$0, this.$token, this.$type, this.$data, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object value;
        Object value2;
        String str;
        Object value3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow access$get_vCodeUiState$p = this.this$0._vCodeUiState;
            do {
                value3 = access$get_vCodeUiState$p.getValue();
                ResultUiState resultUiState = (ResultUiState) value3;
            } while (!access$get_vCodeUiState$p.compareAndSet(value3, ResultUiState.Loading.INSTANCE));
            FactorAuthenticationRepository access$getRepository$p = this.this$0.repository;
            String str2 = this.$token;
            BasicInfoType basicInfoType = this.$type;
            String paramAccount = FactorAuthenticationActivityKt.getParamAccount();
            GeetestData geetestData = this.$data;
            this.label = 1;
            obj2 = access$getRepository$p.m15getVCodeyxL6bBk(str2, basicInfoType, paramAccount, geetestData, this);
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
            MutableStateFlow access$get_vCodeUiState$p2 = this.this$0._vCodeUiState;
            do {
                value2 = access$get_vCodeUiState$p2.getValue();
                ResultUiState resultUiState2 = (ResultUiState) value2;
                if (r0 == null || (str = r0.getMessage()) == null) {
                    str = "未知异常错误";
                }
            } while (!access$get_vCodeUiState$p2.compareAndSet(value2, new ResultUiState.Error(str)));
            return Unit.INSTANCE;
        }
        if (Result.m26isFailureimpl(obj2)) {
            obj2 = null;
        }
        if (((Boolean) obj2) != null) {
            MutableStateFlow access$get_vCodeUiState$p3 = this.this$0._vCodeUiState;
            do {
                value = access$get_vCodeUiState$p3.getValue();
                ResultUiState resultUiState3 = (ResultUiState) value;
            } while (!access$get_vCodeUiState$p3.compareAndSet(value, new ResultUiState.Success("")));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VerificationCodeViewModel$getVCode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
