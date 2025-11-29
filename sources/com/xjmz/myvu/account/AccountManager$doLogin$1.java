package com.xjmz.myvu.account;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.account.AccountManager", f = "AccountManager.kt", i = {0, 0, 0, 1}, l = {182, 201}, m = "doLogin", n = {"this", "fragment", "callback", "this"}, s = {"L$0", "L$1", "L$2", "L$0"})
public final class AccountManager$doLogin$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AccountManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountManager$doLogin$1(AccountManager accountManager, Continuation<? super AccountManager$doLogin$1> continuation) {
        super(continuation);
        this.this$0 = accountManager;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i((Fragment) null, (Function1) null, this);
    }
}
