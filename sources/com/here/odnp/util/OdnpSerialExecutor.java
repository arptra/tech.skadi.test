package com.here.odnp.util;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;

public class OdnpSerialExecutor {
    private static final String TAG = "odnp.util.OdnpSerialExecutor";
    private final Handler mHandler;

    public interface Task {
        boolean run();
    }

    public OdnpSerialExecutor(Looper looper) {
        this.mHandler = new Handler(looper);
    }

    public boolean post(Runnable runnable) {
        Log.v(TAG, "post: %s", runnable);
        return this.mHandler.post(runnable);
    }

    public boolean postAtFrontOfQueue(Runnable runnable) {
        Log.v(TAG, "postAtFrontOfQueue: %s", runnable);
        return this.mHandler.postAtFrontOfQueue(runnable);
    }

    public void removeCallbacksAndMessages(Object obj) {
        Log.i(TAG, "removeCallbacksAndMessages: %s", obj);
        this.mHandler.removeCallbacksAndMessages(obj);
    }

    public boolean runBlockingTask(final Task task) {
        final ObjectHolder objectHolder = new ObjectHolder(Boolean.FALSE);
        if (Thread.currentThread() == this.mHandler.getLooper().getThread()) {
            Log.i(TAG, "runBlockingTask: Called in same thread as Handler, not using ConditionVariable to block", new Object[0]);
            objectHolder.set(Boolean.valueOf(task.run()));
        } else {
            final ConditionVariable conditionVariable = new ConditionVariable();
            if (this.mHandler.post(new Runnable() {
                public void run() {
                    objectHolder.set(Boolean.valueOf(task.run()));
                    conditionVariable.open();
                }
            })) {
                Log.i(TAG, "runBlockingTask: Posting to main thread succeeded, using ConditionVariable to block...", new Object[0]);
                conditionVariable.block();
                Log.i(TAG, "runBlockingTask: ...continuing after ConditionVariable block", new Object[0]);
            } else {
                Log.w(TAG, "runBlockingTask: Posting to main thread failed, not using ConditionVariable to block", new Object[0]);
            }
        }
        return ((Boolean) objectHolder.get()).booleanValue();
    }
}
