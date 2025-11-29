package com.honey.account.view.login.validate;

import android.content.Context;
import android.util.Log;
import com.honey.account.AccountHelper;
import com.honey.account.common.ResultUiState;
import com.honey.account.controller.LoginController;
import kotlin.Metadata;
import kotlin.Pair;
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

@SourceDebugExtension({"SMAP\nValidateAccountViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValidateAccountViewModel.kt\ncom/honey/account/view/login/validate/ValidateAccountViewModel$loginByPhone$1\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,158:1\n230#2,5:159\n230#2,5:164\n*S KotlinDebug\n*F\n+ 1 ValidateAccountViewModel.kt\ncom/honey/account/view/login/validate/ValidateAccountViewModel$loginByPhone$1\n*L\n151#1:159,5\n155#1:164,5\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.login.validate.ValidateAccountViewModel$loginByPhone$1", f = "ValidateAccountViewModel.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
public final class ValidateAccountViewModel$loginByPhone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $account;
    final /* synthetic */ String $vCode;
    int label;
    final /* synthetic */ ValidateAccountViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValidateAccountViewModel$loginByPhone$1(String str, String str2, ValidateAccountViewModel validateAccountViewModel, Continuation<? super ValidateAccountViewModel$loginByPhone$1> continuation) {
        super(2, continuation);
        this.$account = str;
        this.$vCode = str2;
        this.this$0 = validateAccountViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ValidateAccountViewModel$loginByPhone$1(this.$account, this.$vCode, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object value;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LoginController loginController = LoginController.INSTANCE;
            Context mApplicationContext = AccountHelper.INSTANCE.getMApplicationContext();
            String str = this.$account;
            String str2 = this.$vCode;
            this.label = 1;
            obj = loginController.loginToVerificationCode(mApplicationContext, str, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Pair pair = (Pair) obj;
        Log.d("ValidateAccountViewModel", "loginByPhone. result: " + pair);
        if (200 != ((Number) pair.getFirst()).intValue()) {
            MutableStateFlow access$get_loginUiState$p = this.this$0._loginUiState;
            do {
                value2 = access$get_loginUiState$p.getValue();
                ResultUiState resultUiState = (ResultUiState) value2;
            } while (!access$get_loginUiState$p.compareAndSet(value2, new ResultUiState.Error((String) pair.getSecond())));
            return Unit.INSTANCE;
        }
        MutableStateFlow access$get_loginUiState$p2 = this.this$0._loginUiState;
        do {
            value = access$get_loginUiState$p2.getValue();
            ResultUiState resultUiState2 = (ResultUiState) value;
        } while (!access$get_loginUiState$p2.compareAndSet(value, new ResultUiState.Success(pair.getSecond())));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ValidateAccountViewModel$loginByPhone$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
