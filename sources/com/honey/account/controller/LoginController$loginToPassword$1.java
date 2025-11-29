package com.honey.account.controller;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.controller.LoginController", f = "LoginController.kt", i = {0, 0}, l = {117, 122}, m = "loginToPassword", n = {"this", "context"}, s = {"L$0", "L$1"})
public final class LoginController$loginToPassword$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginController$loginToPassword$1(LoginController loginController, Continuation<? super LoginController$loginToPassword$1> continuation) {
        super(continuation);
        this.this$0 = loginController;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loginToPassword((Context) null, (String) null, (String) null, (String) null, this);
    }
}
