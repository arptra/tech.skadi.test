package com.honey.account.c0;

import androidx.room.QueryInterceptorStatement;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorStatement f3038a;

    public /* synthetic */ q(QueryInterceptorStatement queryInterceptorStatement) {
        this.f3038a = queryInterceptorStatement;
    }

    public final void run() {
        QueryInterceptorStatement.j(this.f3038a);
    }
}
