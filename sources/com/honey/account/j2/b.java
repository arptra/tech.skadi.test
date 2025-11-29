package com.honey.account.j2;

import com.honey.account.utils.thread.ScheduledExecutor;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f9206a;

    public /* synthetic */ b(Function0 function0) {
        this.f9206a = function0;
    }

    public final void run() {
        ScheduledExecutor.schedule$lambda$0(this.f9206a);
    }
}
