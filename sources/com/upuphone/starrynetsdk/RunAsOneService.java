package com.upuphone.starrynetsdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class RunAsOneService extends Service {
    public IBinder onBind(Intent intent) {
        SLog.d(this + " onBind");
        return RunasoneHub.getInstance();
    }
}
