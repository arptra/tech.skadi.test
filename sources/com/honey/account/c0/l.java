package com.honey.account.c0;

import androidx.room.QueryInterceptorDatabase;
import java.util.List;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f3033a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;

    public /* synthetic */ l(QueryInterceptorDatabase queryInterceptorDatabase, String str, List list) {
        this.f3033a = queryInterceptorDatabase;
        this.b = str;
        this.c = list;
    }

    public final void run() {
        QueryInterceptorDatabase.w(this.f3033a, this.b, this.c);
    }
}
