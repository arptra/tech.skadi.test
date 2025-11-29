package com.upuphone.starrynetsdk.ability.lifecycle.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class LifecycleService extends Service {
    private static final String TAG = "LifecycleService";

    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: " + intent);
        return new Binder();
    }

    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, i, i2);
    }
}
