package com.honey.account.c0;

import androidx.room.QueryInterceptorDatabase;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f3036a;
    public final /* synthetic */ String b;

    public /* synthetic */ o(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        this.f3036a = queryInterceptorDatabase;
        this.b = str;
    }

    public final void run() {
        QueryInterceptorDatabase.z(this.f3036a, this.b);
    }
}
