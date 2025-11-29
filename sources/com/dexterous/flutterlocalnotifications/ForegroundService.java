package com.dexterous.flutterlocalnotifications;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import java.util.ArrayList;

public class ForegroundService extends Service {
    public static int a(ArrayList arrayList) {
        int intValue = ((Integer) arrayList.get(0)).intValue();
        for (int i = 1; i < arrayList.size(); i++) {
            intValue |= ((Integer) arrayList.get(i)).intValue();
        }
        return intValue;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        ForegroundServiceStartParameter foregroundServiceStartParameter = Build.VERSION.SDK_INT >= 33 ? (ForegroundServiceStartParameter) intent.getSerializableExtra(ForegroundServiceStartParameter.EXTRA, ForegroundServiceStartParameter.class) : (ForegroundServiceStartParameter) intent.getSerializableExtra(ForegroundServiceStartParameter.EXTRA);
        Notification createNotification = FlutterLocalNotificationsPlugin.createNotification(this, foregroundServiceStartParameter.notificationData);
        if (foregroundServiceStartParameter.foregroundServiceTypes != null) {
            startForeground(foregroundServiceStartParameter.notificationData.id.intValue(), createNotification, a(foregroundServiceStartParameter.foregroundServiceTypes));
        } else {
            startForeground(foregroundServiceStartParameter.notificationData.id.intValue(), createNotification);
        }
        return foregroundServiceStartParameter.startMode;
    }
}
