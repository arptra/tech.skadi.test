package com.honey.account.h9;

import com.xingin.xhssharesdk.b.r;
import com.xingin.xhssharesdk.b.s;
import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class c implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f7328a;

    public /* synthetic */ c(r rVar) {
        this.f7328a = rVar;
    }

    public final Thread newThread(Runnable runnable) {
        return s.c(this.f7328a, runnable);
    }
}
