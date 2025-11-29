package com.here.odnp.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public class Timer {
    /* access modifiers changed from: private */
    public Handler mHandler;
    private final Object mToken = new Object();

    public abstract class Task implements Runnable {
        public Task() {
        }

        public void beforeSchedule() {
        }

        public void cancel() {
            if (Timer.this.mHandler != null) {
                Timer.this.mHandler.removeCallbacks(this);
                return;
            }
            throw new IllegalStateException("Timer start not called");
        }
    }

    public void cancel() {
        this.mHandler.removeCallbacksAndMessages(this.mToken);
    }

    public boolean schedule(Task task, long j) {
        task.beforeSchedule();
        return this.mHandler.postAtTime(task, this.mToken, SystemClock.uptimeMillis() + j);
    }

    public synchronized void start() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(MasterThread.getInstance().getLooper());
        }
    }

    public synchronized void stop() {
        cancel();
        this.mHandler = null;
    }

    public synchronized void start(Looper looper) {
        if (this.mHandler == null) {
            this.mHandler = new Handler(looper);
        }
    }
}
