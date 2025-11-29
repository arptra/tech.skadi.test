package sdk.meizu.account.factor.authentication.sdk;

import android.util.Log;
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
import sdk.meizu.account.factor.authentication.sdk.common.ResultUiState;
import sdk.meizu.account.factor.authentication.sdk.data.GeetestData;
import sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData;
import sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository;

@SourceDebugExtension({"SMAP\nFactorAuthenticationViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FactorAuthenticationViewModel.kt\nsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationViewModel$getValidateTypes$1\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,61:1\n230#2,5:62\n230#2,5:67\n230#2,5:72\n*S KotlinDebug\n*F\n+ 1 FactorAuthenticationViewModel.kt\nsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationViewModel$getValidateTypes$1\n*L\n35#1:62,5\n46#1:67,5\n57#1:72,5\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationViewModel$getValidateTypes$1", f = "FactorAuthenticationViewModel.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
public final class FactorAuthenticationViewModel$getValidateTypes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GeetestData $data;
    final /* synthetic */ String $token;
    int label;
    final /* synthetic */ FactorAuthenticationViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FactorAuthenticationViewModel$getValidateTypes$1(String str, FactorAuthenticationViewModel factorAuthenticationViewModel, GeetestData geetestData, Continuation<? super FactorAuthenticationViewModel$getValidateTypes$1> continuation) {
        super(2, continuation);
        this.$token = str;
        this.this$0 = factorAuthenticationViewModel;
        this.$data = geetestData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FactorAuthenticationViewModel$getValidateTypes$1(this.$token, this.this$0, this.$data, continuation);
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
            Log.d(FactorAuthenticationViewModel.TAG, "getValidateTypes. token: " + this.$token);
            MutableStateFlow access$get_validateUiState$p = this.this$0._validateUiState;
            do {
                value3 = access$get_validateUiState$p.getValue();
                ResultUiState resultUiState = (ResultUiState) value3;
            } while (!access$get_validateUiState$p.compareAndSet(value3, ResultUiState.Loading.INSTANCE));
            FactorAuthenticationRepository access$getRepository$p = this.this$0.repository;
            String str2 = this.$token;
            String paramAccount = FactorAuthenticationActivityKt.getParamAccount();
            String paramProcessName = FactorAuthenticationActivityKt.getParamProcessName();
            GeetestData geetestData = this.$data;
            this.label = 1;
            obj2 = access$getRepository$p.m14getSupportValidateTypeyxL6bBk(str2, paramAccount, paramProcessName, geetestData, this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = ((Result) obj).m29unboximpl();
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Log.d(FactorAuthenticationViewModel.TAG, "getValidateTypes. result, validateType: " + Result.m28toStringimpl(obj2));
        if (Result.m26isFailureimpl(obj2)) {
            Throwable r0 = Result.m23exceptionOrNullimpl(obj2);
            Log.d(FactorAuthenticationViewModel.TAG, "getValidateTypes. result, error, throwable: " + r0);
            MutableStateFlow access$get_validateUiState$p2 = this.this$0._validateUiState;
            do {
                value2 = access$get_validateUiState$p2.getValue();
                ResultUiState resultUiState2 = (ResultUiState) value2;
                if (r0 == null || (str = r0.getMessage()) == null) {
                    str = "-100";
                }
            } while (!access$get_validateUiState$p2.compareAndSet(value2, new ResultUiState.Error(str)));
            return Unit.INSTANCE;
        }
        if (Result.m26isFailureimpl(obj2)) {
            obj2 = null;
        }
        ResponseValidateData responseValidateData = (ResponseValidateData) obj2;
        if (responseValidateData != null) {
            FactorAuthenticationViewModel factorAuthenticationViewModel = this.this$0;
            Log.d(FactorAuthenticationViewModel.TAG, "getValidateTypes. result, success, types: " + responseValidateData);
            MutableStateFlow access$get_validateUiState$p3 = factorAuthenticationViewModel._validateUiState;
            do {
                value = access$get_validateUiState$p3.getValue();
                ResultUiState resultUiState3 = (ResultUiState) value;
            } while (!access$get_validateUiState$p3.compareAndSet(value, new ResultUiState.Success(responseValidateData)));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FactorAuthenticationViewModel$getValidateTypes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
