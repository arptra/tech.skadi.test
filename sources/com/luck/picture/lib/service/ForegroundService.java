package com.luck.picture.lib.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.utils.SdkVersionUtils;

public class ForegroundService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9452a = ("com.luck.picture.lib." + ForegroundService.class.getName());
    public static boolean b = false;

    public static void c(Context context, boolean z) {
        try {
            if (!b && z) {
                Intent intent = new Intent(context, ForegroundService.class);
                if (SdkVersionUtils.d()) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(Context context) {
        try {
            if (b) {
                context.stopService(new Intent(context, ForegroundService.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Notification a() {
        int i = SdkVersionUtils.a() ? 4 : 0;
        if (SdkVersionUtils.d()) {
            NotificationChannel notificationChannel = new NotificationChannel(f9452a, "com.luck.picture.lib", i);
            notificationChannel.setLightColor(-16776961);
            notificationChannel.canBypassDnd();
            notificationChannel.setBypassDnd(true);
            notificationChannel.setLockscreenVisibility(0);
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
        }
        return new NotificationCompat.Builder(this, f9452a).H(R.drawable.ps_ic_trans_1px).n(b()).m(getString(SelectorProviders.c().d().f9404a == SelectMimeType.b() ? R.string.ps_use_sound : R.string.ps_use_camera)).A(true).c();
    }

    public final String b() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).applicationInfo.loadLabel(getPackageManager()).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        startForeground(1, a());
    }

    public void onDestroy() {
        b = false;
        stopForeground(true);
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        b = true;
        return super.onStartCommand(intent, i, i2);
    }
}
