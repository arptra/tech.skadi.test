package com.honey.account.view.login.repository;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.login.repository.LoginRepository", f = "LoginRepository.kt", i = {}, l = {107}, m = "loginByEmail-0E7RQCE", n = {}, s = {})
public final class LoginRepository$loginByEmail$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginRepository$loginByEmail$1(LoginRepository loginRepository, Continuation<? super LoginRepository$loginByEmail$1> continuation) {
        super(continuation);
        this.this$0 = loginRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r1 = this.this$0.m1731loginByEmail0E7RQCE((String) null, (String) null, this);
        return r1 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r1 : Result.m19boximpl(r1);
    }
}
