package com.xjmz.myvu.account;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.account.UserLogOutHelper", f = "UserLogOutHelper.kt", i = {0, 0, 0}, l = {94}, m = "queryUserLogout", n = {"this", "url", "queryMap"}, s = {"L$0", "L$1", "L$2"})
public final class UserLogOutHelper$queryUserLogout$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserLogOutHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserLogOutHelper$queryUserLogout$1(UserLogOutHelper userLogOutHelper, Continuation<? super UserLogOutHelper$queryUserLogout$1> continuation) {
        super(continuation);
        this.this$0 = userLogOutHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(this);
    }
}
