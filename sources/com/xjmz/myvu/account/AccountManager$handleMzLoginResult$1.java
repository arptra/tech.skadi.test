package com.xjmz.myvu.account;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.account.AccountManager$handleMzLoginResult$1", f = "AccountManager.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
public final class AccountManager$handleMzLoginResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $resultCode;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountManager$handleMzLoginResult$1(int i, Continuation<? super AccountManager$handleMzLoginResult$1> continuation) {
        super(2, continuation);
        this.$resultCode = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AccountManager$handleMzLoginResult$1(this.$resultCode, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AccountManager accountManager = AccountManager.f8217a;
            int i2 = this.$resultCode;
            AnonymousClass1 r3 = AnonymousClass1.INSTANCE;
            this.label = 1;
            if (accountManager.p(i2, r3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AccountManager$handleMzLoginResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
