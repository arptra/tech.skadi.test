package com.xjmz.myvu.account;

import com.upuphone.xr.sapp.entity.AccountInfo;
import kotlinx.coroutines.CoroutineScope;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountInfo f8230a;
    public final /* synthetic */ CoroutineScope b;
    public final /* synthetic */ DebugLoginActivity c;

    public /* synthetic */ c(AccountInfo accountInfo, CoroutineScope coroutineScope, DebugLoginActivity debugLoginActivity) {
        this.f8230a = accountInfo;
        this.b = coroutineScope;
        this.c = debugLoginActivity;
    }

    public final void run() {
        DebugLoginActivity$onCreate$2$1.invokeSuspend$lambda$2(this.f8230a, this.b, this.c);
    }
}
