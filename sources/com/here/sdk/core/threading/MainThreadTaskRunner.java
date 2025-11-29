package com.here.sdk.core.threading;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

class MainThreadTaskRunner implements TaskHandle {
    private final int CANCELLED = 3;
    private final int DONE = 2;
    private final int PENDING = 0;
    private final int RUNNING = 1;
    private Handler mHandler;
    private final Runnable mRunnable;
    private AtomicInteger mState = new AtomicInteger(0);

    private MainThreadTaskRunner(@NonNull Runnable runnable) {
        this.mRunnable = new a(this, runnable);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Runnable runnable) {
        if (this.mState.compareAndSet(0, 1)) {
            runnable.run();
            this.mState.compareAndSet(1, 2);
        }
    }

    private void post(long j) {
        Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
        if (j != 0) {
            handler.postDelayed(this.mRunnable, j);
        } else {
            handler.post(this.mRunnable);
        }
    }

    public static MainThreadTaskRunner run(@NonNull Runnable runnable) {
        if (!Objects.equals(Looper.myLooper(), Looper.getMainLooper())) {
            return post(runnable, 0);
        }
        MainThreadTaskRunner mainThreadTaskRunner = new MainThreadTaskRunner(runnable);
        mainThreadTaskRunner.runTask();
        return mainThreadTaskRunner;
    }

    private void runTask() {
        this.mRunnable.run();
    }

    public boolean cancel() {
        Handler handler;
        if (this.mState.get() == 3) {
            return false;
        }
        if (this.mState.compareAndSet(0, 3) && (handler = this.mHandler) != null) {
            handler.removeCallbacks(this.mRunnable);
        }
        this.mState.compareAndSet(1, 3);
        return isCancelled();
    }

    public boolean isCancelled() {
        return this.mState.get() == 3;
    }

    public boolean isFinished() {
        return this.mState.get() == 2 || this.mState.get() == 3;
    }

    public static MainThreadTaskRunner post(@NonNull Runnable runnable, long j) {
        MainThreadTaskRunner mainThreadTaskRunner = new MainThreadTaskRunner(runnable);
        mainThreadTaskRunner.post(j);
        return mainThreadTaskRunner;
    }
}
