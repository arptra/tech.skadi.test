package com.honey.account.j2;

import com.honey.account.utils.thread.ScheduledExecutor;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f9207a;

    public /* synthetic */ c(Function0 function0) {
        this.f9207a = function0;
    }

    public final void run() {
        ScheduledExecutor.scheduleWithFixedDelay$lambda$2(this.f9207a);
    }
}
