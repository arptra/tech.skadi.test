package com.upuphone.runasone.lifecycle.bean;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.util.Log;
import com.upuphone.runasone.lifecycle.manager.LifecycleManager;

public abstract class LifecycleServiceConnection implements ServiceConnection {
    private static final String TAG = "LifecycleServiceConnect";
    private long mPervDisconnectedTime = 0;
    private boolean needReBind = true;

    public boolean getNeedReBind() {
        return this.needReBind;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mPervDisconnectedTime >= 5000) {
            Log.d(TAG, "onServiceDisconnected: in " + ((currentTimeMillis - this.mPervDisconnectedTime) / 1000) + "s disconnected, is allowed.");
            this.mPervDisconnectedTime = currentTimeMillis;
            return;
        }
        Log.d(TAG, "onServiceDisconnected: Disconnected twice in five seconds, stopped pulling up.");
        this.needReBind = false;
        LifecycleManager.getInstance().onAppUnregistered(componentName.getPackageName());
    }
}
