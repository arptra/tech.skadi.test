package com.honey.account.j2;

import com.honey.account.utils.thread.ScheduledExecutor;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f9205a;

    public /* synthetic */ a(Function0 function0) {
        this.f9205a = function0;
    }

    public final void run() {
        ScheduledExecutor.scheduleAtFixedRate$lambda$1(this.f9205a);
    }
}
