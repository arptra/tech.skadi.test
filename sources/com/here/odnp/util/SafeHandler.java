package com.here.odnp.util;

import android.os.Handler;
import android.os.Looper;

public class SafeHandler {
    private static final String TAG = "odnp.util.SafeHandler";
    private final Handler mHandler;

    public SafeHandler(Looper looper) {
        if (looper != null) {
            this.mHandler = new Handler(looper);
            return;
        }
        throw new IllegalArgumentException("looper is null");
    }

    private boolean isAlive() {
        Thread thread;
        Looper looper = getLooper();
        if (looper == null || (thread = looper.getThread()) == null) {
            return false;
        }
        return thread.isAlive();
    }

    private boolean isInHandlerThread() {
        return Thread.currentThread().equals(this.mHandler.getLooper().getThread());
    }

    public Looper getLooper() {
        return this.mHandler.getLooper();
    }

    public boolean post(Runnable runnable, boolean z) {
        if (runnable == null) {
            return false;
        }
        if (z && isInHandlerThread()) {
            Log.i(TAG, "post: already in handler thread -> execute now", new Object[0]);
            runnable.run();
            return true;
        } else if (isAlive()) {
            return this.mHandler.post(runnable);
        } else {
            Log.w(TAG, "post: handler thread already dead", new Object[0]);
            return false;
        }
    }

    public boolean postAtTime(Runnable runnable, long j) {
        if (runnable == null) {
            return false;
        }
        if (isAlive()) {
            return this.mHandler.postAtTime(runnable, j);
        }
        Log.w(TAG, "postAtTime: handler thread already dead", new Object[0]);
        return false;
    }

    public boolean postDelayed(Runnable runnable, long j) {
        if (runnable == null) {
            return false;
        }
        if (isAlive()) {
            return this.mHandler.postDelayed(runnable, j);
        }
        Log.w(TAG, "postDelayed: handler thread already dead", new Object[0]);
        return false;
    }

    public void removeCallbacks() {
        removeCallbacks((Runnable) null);
    }

    public void removeCallbacksAndMessages(Object obj) {
        this.mHandler.removeCallbacksAndMessages(obj);
    }

    public void removeCallbacks(Runnable runnable) {
        this.mHandler.removeCallbacks(runnable);
    }

    public boolean postAtTime(Runnable runnable, Object obj, long j) {
        if (runnable == null) {
            return false;
        }
        if (isAlive()) {
            return this.mHandler.postAtTime(runnable, obj, j);
        }
        Log.w(TAG, "postAtTime: handler thread already dead", new Object[0]);
        return false;
    }

    public boolean post(Runnable runnable) {
        return post(runnable, true);
    }
}
