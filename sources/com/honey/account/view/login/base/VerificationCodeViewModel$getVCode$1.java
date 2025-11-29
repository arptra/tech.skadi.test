package com.honey.account.view.login.base;

import com.honey.account.common.ResultUiState;
import com.honey.account.data.GeetestData;
import com.honey.account.view.login.data.VCodeMethod;
import com.honey.account.view.login.data.VCodeMode;
import com.honey.account.view.login.repository.LoginRepository;
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

@SourceDebugExtension({"SMAP\nVerificationCodeViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerificationCodeViewModel.kt\ncom/honey/account/view/login/base/VerificationCodeViewModel$getVCode$1\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,183:1\n230#2,5:184\n230#2,5:189\n230#2,5:194\n*S KotlinDebug\n*F\n+ 1 VerificationCodeViewModel.kt\ncom/honey/account/view/login/base/VerificationCodeViewModel$getVCode$1\n*L\n45#1:184,5\n50#1:189,5\n60#1:194,5\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.login.base.VerificationCodeViewModel$getVCode$1", f = "VerificationCodeViewModel.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
public final class VerificationCodeViewModel$getVCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $account;
    final /* synthetic */ GeetestData $data;
    int label;
    final /* synthetic */ VerificationCodeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerificationCodeViewModel$getVCode$1(VerificationCodeViewModel verificationCodeViewModel, String str, GeetestData geetestData, Continuation<? super VerificationCodeViewModel$getVCode$1> continuation) {
        super(2, continuation);
        this.this$0 = verificationCodeViewModel;
        this.$account = str;
        this.$data = geetestData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VerificationCodeViewModel$getVCode$1(this.this$0, this.$account, this.$data, continuation);
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
            MutableStateFlow access$get_smsCodeUiState$p = this.this$0._smsCodeUiState;
            do {
                value3 = access$get_smsCodeUiState$p.getValue();
                ResultUiState resultUiState = (ResultUiState) value3;
            } while (!access$get_smsCodeUiState$p.compareAndSet(value3, ResultUiState.Loading.INSTANCE));
            LoginRepository access$getLoginRepository$p = this.this$0.loginRepository;
            String str2 = this.$account;
            VCodeMode access$vCodeMode = this.this$0.vCodeMode(str2);
            VCodeMethod access$vCodeMethod = this.this$0.vCodeMethod(this.$account);
            GeetestData geetestData = this.$data;
            this.label = 1;
            obj2 = access$getLoginRepository$p.m1730getVCodeyxL6bBk(str2, access$vCodeMode, access$vCodeMethod, geetestData, this);
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
            MutableStateFlow access$get_smsCodeUiState$p2 = this.this$0._smsCodeUiState;
            do {
                value2 = access$get_smsCodeUiState$p2.getValue();
                ResultUiState resultUiState2 = (ResultUiState) value2;
                if (r0 == null || (str = r0.getMessage()) == null) {
                    str = "未知异常错误";
                }
            } while (!access$get_smsCodeUiState$p2.compareAndSet(value2, new ResultUiState.Error(str)));
            return Unit.INSTANCE;
        }
        if (Result.m26isFailureimpl(obj2)) {
            obj2 = null;
        }
        if (((Boolean) obj2) != null) {
            MutableStateFlow access$get_smsCodeUiState$p3 = this.this$0._smsCodeUiState;
            do {
                value = access$get_smsCodeUiState$p3.getValue();
                ResultUiState resultUiState3 = (ResultUiState) value;
            } while (!access$get_smsCodeUiState$p3.compareAndSet(value, new ResultUiState.Success(Boxing.boxBoolean(true))));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VerificationCodeViewModel$getVCode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
