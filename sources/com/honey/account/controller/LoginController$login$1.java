package com.honey.account.controller;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.controller.LoginController", f = "LoginController.kt", i = {}, l = {130}, m = "login", n = {}, s = {})
public final class LoginController$login$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginController$login$1(LoginController loginController, Continuation<? super LoginController$login$1> continuation) {
        super(continuation);
        this.this$0 = loginController;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.login((Context) null, (String) null, this);
    }
}
