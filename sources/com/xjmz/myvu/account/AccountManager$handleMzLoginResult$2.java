package com.xjmz.myvu.account;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.account.AccountManager", f = "AccountManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {241, 250}, m = "handleMzLoginResult", n = {"this", "callback", "loginSuccess", "mzActivityLoginSuccess", "this", "callback", "loginSuccess", "mzToken", "mzActivityLoginSuccess"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"})
public final class AccountManager$handleMzLoginResult$2 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AccountManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountManager$handleMzLoginResult$2(AccountManager accountManager, Continuation<? super AccountManager$handleMzLoginResult$2> continuation) {
        super(continuation);
        this.this$0 = accountManager;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.p(0, (Function1) null, this);
    }
}
