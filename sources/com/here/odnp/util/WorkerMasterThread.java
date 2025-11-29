package com.here.odnp.util;

import android.os.HandlerThread;
import android.os.Looper;
import com.meizu.common.widget.MzContactsContract;

final class WorkerMasterThread extends MasterThread {
    private static final String TAG = "WorkerMasterThread";
    private HandlerThread mHandlerThread;

    public static class TraceHandlerThread extends HandlerThread {
        public TraceHandlerThread(String str) {
            super(str);
        }

        public void onLooperPrepared() {
        }

        public TraceHandlerThread(String str, int i) {
            super(str, i);
        }
    }

    public WorkerMasterThread() {
        Log.v(TAG, TAG, new Object[0]);
    }

    public synchronized Looper getLooper() {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread == null) {
            throw new IllegalStateException("WorkerMasterThread not initialized");
        } else if (handlerThread.isAlive()) {
        } else {
            throw new IllegalStateException("WorkerMasterThread not alive");
        }
        return this.mHandlerThread.getLooper();
    }

    public synchronized void start() {
        if (this.mHandlerThread == null) {
            Log.v(TAG, MzContactsContract.START_PARAM_KEY, new Object[0]);
            TraceHandlerThread traceHandlerThread = new TraceHandlerThread("MasterThread");
            this.mHandlerThread = traceHandlerThread;
            traceHandlerThread.start();
        }
    }

    public synchronized void stop() {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mHandlerThread = null;
        }
    }
}
