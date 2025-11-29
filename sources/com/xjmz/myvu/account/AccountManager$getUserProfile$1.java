package com.xjmz.myvu.account;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.account.AccountManager", f = "AccountManager.kt", i = {}, l = {492}, m = "getUserProfile", n = {}, s = {})
public final class AccountManager$getUserProfile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AccountManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountManager$getUserProfile$1(AccountManager accountManager, Continuation<? super AccountManager$getUserProfile$1> continuation) {
        super(continuation);
        this.this$0 = accountManager;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n(this);
    }
}
