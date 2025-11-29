package com.honey.account.c0;

import androidx.room.MultiInstanceInvalidationClient;
import androidx.room.MultiInstanceInvalidationClient$callback$1;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationClient f3027a;
    public final /* synthetic */ String[] b;

    public /* synthetic */ f(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] strArr) {
        this.f3027a = multiInstanceInvalidationClient;
        this.b = strArr;
    }

    public final void run() {
        MultiInstanceInvalidationClient$callback$1.onInvalidation$lambda$0(this.f3027a, this.b);
    }
}
