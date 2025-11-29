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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivityKt;
import sdk.meizu.account.factor.authentication.sdk.common.ResultUiState;
import sdk.meizu.account.factor.authentication.sdk.common.helper.ExtKt;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;
import sdk.meizu.account.factor.authentication.sdk.constant.Mode;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;
import sdk.meizu.account.factor.authentication.sdk.data.ConfirmValue;
import sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository;

@SourceDebugExtension({"SMAP\nValidateViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValidateViewModel.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateViewModel$confirm$2\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,98:1\n230#2,5:99\n230#2,5:104\n230#2,5:109\n230#2,5:114\n*S KotlinDebug\n*F\n+ 1 ValidateViewModel.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateViewModel$confirm$2\n*L\n48#1:99,5\n56#1:104,5\n58#1:109,5\n61#1:114,5\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateViewModel$confirm$2", f = "ValidateViewModel.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
public final class ValidateViewModel$confirm$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Mode $mode;
    final /* synthetic */ String $token;
    final /* synthetic */ BasicInfoType $type;
    final /* synthetic */ String $validate;
    int label;
    final /* synthetic */ ValidateViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValidateViewModel$confirm$2(ValidateViewModel validateViewModel, String str, BasicInfoType basicInfoType, Mode mode, String str2, Continuation<? super ValidateViewModel$confirm$2> continuation) {
        super(2, continuation);
        this.this$0 = validateViewModel;
        this.$token = str;
        this.$type = basicInfoType;
        this.$mode = mode;
        this.$validate = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ValidateViewModel$confirm$2(this.this$0, this.$token, this.$type, this.$mode, this.$validate, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object value;
        Object value2;
        Object value3;
        Object value4;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FactorAuthenticationRepository access$getRepository$p = this.this$0.repository;
            String str2 = this.$token;
            BasicInfoType basicInfoType = this.$type;
            Mode mode = this.$mode;
            String str3 = this.$validate;
            String paramAccount = FactorAuthenticationActivityKt.getParamAccount();
            this.label = 1;
            obj2 = access$getRepository$p.m12confirmhUnOzRk(str2, basicInfoType, mode, str3, paramAccount, this);
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
            MutableStateFlow access$get_confirmUiState$p = this.this$0._confirmUiState;
            do {
                value4 = access$get_confirmUiState$p.getValue();
                ResultUiState resultUiState = (ResultUiState) value4;
                if (r0 == null || (str = r0.getMessage()) == null) {
                    str = "未知异常错误";
                }
            } while (!access$get_confirmUiState$p.compareAndSet(value4, new ResultUiState.Error(str)));
            return Unit.INSTANCE;
        }
        if (Result.m26isFailureimpl(obj2)) {
            obj2 = null;
        }
        ConfirmValue confirmValue = (ConfirmValue) obj2;
        if (confirmValue != null) {
            String str4 = this.$validate;
            ValidateViewModel validateViewModel = this.this$0;
            if (!Intrinsics.areEqual((Object) confirmValue.getValidateMode(), (Object) ConstantKt.FACTOR_MODE_LOCAL)) {
                MutableStateFlow access$get_confirmUiState$p2 = validateViewModel._confirmUiState;
                do {
                    value = access$get_confirmUiState$p2.getValue();
                    ResultUiState resultUiState2 = (ResultUiState) value;
                } while (!access$get_confirmUiState$p2.compareAndSet(value, new ResultUiState.Success(confirmValue)));
            } else if (Intrinsics.areEqual((Object) ExtKt.toSHA256(str4), (Object) confirmValue.getValidateCode())) {
                MutableStateFlow access$get_confirmUiState$p3 = validateViewModel._confirmUiState;
                do {
                    value3 = access$get_confirmUiState$p3.getValue();
                    ResultUiState resultUiState3 = (ResultUiState) value3;
                } while (!access$get_confirmUiState$p3.compareAndSet(value3, new ResultUiState.Success(confirmValue)));
            } else {
                MutableStateFlow access$get_confirmUiState$p4 = validateViewModel._confirmUiState;
                do {
                    value2 = access$get_confirmUiState$p4.getValue();
                    ResultUiState resultUiState4 = (ResultUiState) value2;
                } while (!access$get_confirmUiState$p4.compareAndSet(value2, new ResultUiState.Error("校验失败错误")));
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ValidateViewModel$confirm$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
