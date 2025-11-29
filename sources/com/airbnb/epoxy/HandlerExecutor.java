package com.airbnb.epoxy;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

class HandlerExecutor implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f2305a;

    public HandlerExecutor(Handler handler) {
        this.f2305a = handler;
    }

    public void execute(Runnable runnable) {
        if (Looper.myLooper() == this.f2305a.getLooper()) {
            runnable.run();
        } else {
            this.f2305a.post(runnable);
        }
    }
}
