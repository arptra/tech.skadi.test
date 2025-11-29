package com.honey.account.view.login.repository;

import com.honey.account.data.GeetestData;
import com.honey.account.view.login.data.VCodeMethod;
import com.honey.account.view.login.data.VCodeMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.login.repository.LoginRepository", f = "LoginRepository.kt", i = {}, l = {75}, m = "getVCode-yxL6bBk", n = {}, s = {})
public final class LoginRepository$getVCode$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginRepository$getVCode$1(LoginRepository loginRepository, Continuation<? super LoginRepository$getVCode$1> continuation) {
        super(continuation);
        this.this$0 = loginRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r6 = this.this$0.m1730getVCodeyxL6bBk((String) null, (VCodeMode) null, (VCodeMethod) null, (GeetestData) null, this);
        return r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r6 : Result.m19boximpl(r6);
    }
}
