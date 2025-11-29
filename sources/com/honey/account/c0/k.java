package com.honey.account.c0;

import androidx.room.QueryInterceptorDatabase;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f3032a;

    public /* synthetic */ k(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f3032a = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.s(this.f3032a);
    }
}
