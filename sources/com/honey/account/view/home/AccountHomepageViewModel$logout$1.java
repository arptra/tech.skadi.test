package com.honey.account.view.home;

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

@SourceDebugExtension({"SMAP\nAccountHomepageViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccountHomepageViewModel.kt\ncom/honey/account/view/home/AccountHomepageViewModel$logout$1\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,72:1\n230#2,5:73\n230#2,5:78\n230#2,5:83\n*S KotlinDebug\n*F\n+ 1 AccountHomepageViewModel.kt\ncom/honey/account/view/home/AccountHomepageViewModel$logout$1\n*L\n31#1:73,5\n35#1:78,5\n41#1:83,5\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.home.AccountHomepageViewModel$logout$1", f = "AccountHomepageViewModel.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
public final class AccountHomepageViewModel$logout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $code;
    int label;
    final /* synthetic */ AccountHomepageViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountHomepageViewModel$logout$1(AccountHomepageViewModel accountHomepageViewModel, String str, Continuation<? super AccountHomepageViewModel$logout$1> continuation) {
        super(2, continuation);
        this.this$0 = accountHomepageViewModel;
        this.$code = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AccountHomepageViewModel$logout$1(this.this$0, this.$code, continuation);
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
            MutableStateFlow access$get_logoutState$p = this.this$0._logoutState;
            do {
                value3 = access$get_logoutState$p.getValue();
                ResultUiState resultUiState = (ResultUiState) value3;
            } while (!access$get_logoutState$p.compareAndSet(value3, ResultUiState.Loading.INSTANCE));
            AccountRepository access$getAccountRepository$p = this.this$0.accountRepository;
            String str2 = this.$code;
            this.label = 1;
            obj2 = access$getAccountRepository$p.m1729logoutgIAlus(str2, this);
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
            MutableStateFlow access$get_logoutState$p2 = this.this$0._logoutState;
            do {
                value2 = access$get_logoutState$p2.getValue();
                ResultUiState resultUiState2 = (ResultUiState) value2;
                if (r0 == null || (str = r0.getMessage()) == null) {
                    str = "xx";
                }
            } while (!access$get_logoutState$p2.compareAndSet(value2, new ResultUiState.Error(str)));
            return Unit.INSTANCE;
        }
        if (Result.m26isFailureimpl(obj2)) {
            obj2 = null;
        }
        String str3 = (String) obj2;
        if (str3 != null) {
            MutableStateFlow access$get_logoutState$p3 = this.this$0._logoutState;
            do {
                value = access$get_logoutState$p3.getValue();
                ResultUiState resultUiState3 = (ResultUiState) value;
            } while (!access$get_logoutState$p3.compareAndSet(value, new ResultUiState.Success(str3)));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AccountHomepageViewModel$logout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
