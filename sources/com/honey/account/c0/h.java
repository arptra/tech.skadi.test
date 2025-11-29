package com.honey.account.c0;

import androidx.room.QueryInterceptorDatabase;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f3029a;
    public final /* synthetic */ String b;

    public /* synthetic */ h(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        this.f3029a = queryInterceptorDatabase;
        this.b = str;
    }

    public final void run() {
        QueryInterceptorDatabase.v(this.f3029a, this.b);
    }
}
