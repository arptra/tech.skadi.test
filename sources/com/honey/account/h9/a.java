package com.honey.account.h9;

import com.xingin.xhssharesdk.b.d;
import com.xingin.xhssharesdk.b.r;
import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f7326a;

    public /* synthetic */ a(r rVar) {
        this.f7326a = rVar;
    }

    public final Thread newThread(Runnable runnable) {
        return d.b(this.f7326a, runnable);
    }
}
