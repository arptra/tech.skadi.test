package com.here.odnp.sensors;

import com.here.odnp.util.Log;
import com.here.posclient.Status;
import com.here.posclient.sensors.ActivityResult;
import com.here.posclient.sensors.ISensorManager;

public class InjectionSensorManager implements ISensorManager, ISensorManager.Listener {
    private static final String TAG = "InjectSensorMgr";
    private final ISensorManager.Listener mListener;

    public InjectionSensorManager(ISensorManager.Listener listener) {
        this.mListener = listener;
    }

    public void close() {
        Log.d(TAG, "close", new Object[0]);
    }

    public void onHandleActivityResult(ActivityResult activityResult) {
        ISensorManager.Listener listener = this.mListener;
        if (listener != null) {
            listener.onHandleActivityResult(activityResult);
        }
    }

    public void open() {
        Log.d(TAG, "open", new Object[0]);
    }

    public int requestSensorStatus(long j) {
        Log.d(TAG, "requestSensorStatus", new Object[0]);
        return Status.NotSupportedError.toInt();
    }

    public int subscribe(long j) {
        Log.d(TAG, "subscribe: 0x%x", Long.valueOf(j));
        return j == 1 ? Status.Ok.toInt() : Status.NotSupportedError.toInt();
    }

    public long supportedSensorTypes() {
        Log.d(TAG, "supportedSensorTypes", new Object[0]);
        return 1;
    }

    public void unsubscribe(long j) {
        Log.d(TAG, "unsubscribe: 0x%x", Long.valueOf(j));
    }
}
