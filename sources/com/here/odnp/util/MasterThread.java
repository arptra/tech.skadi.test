package com.here.odnp.util;

import android.os.Looper;
import com.meizu.common.widget.MzContactsContract;

public class MasterThread {
    private static final String TAG = "MasterThread";
    private static final boolean WORKER = true;
    private static MasterThread mInstance;

    public MasterThread() {
        Log.v(TAG, TAG, new Object[0]);
    }

    public static synchronized MasterThread getInstance() {
        MasterThread masterThread;
        synchronized (MasterThread.class) {
            try {
                if (mInstance == null) {
                    mInstance = new WorkerMasterThread();
                }
                masterThread = mInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return masterThread;
    }

    public Looper getLooper() {
        return Looper.getMainLooper();
    }

    public void start() {
        Log.v(TAG, MzContactsContract.START_PARAM_KEY, new Object[0]);
    }

    public void stop() {
        Log.v(TAG, "stop", new Object[0]);
    }
}
