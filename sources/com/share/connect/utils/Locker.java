package com.share.connect.utils;

import android.content.Context;
import android.os.PowerManager;
import com.easy.logger.EasyLog;

public class Locker {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f9918a = new Object();
    public static PowerManager.WakeLock b;

    public static void a(Context context) {
        synchronized (f9918a) {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (b == null) {
                    b = powerManager.newWakeLock(1, "vivoShare::AppWakeLock");
                    EasyLog.e("Locker", "Acquire wake lock.");
                    b.acquire(3600000);
                } else {
                    EasyLog.i("Locker", "Already on lock.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b() {
        synchronized (f9918a) {
            try {
                if (b != null) {
                    EasyLog.e("Locker", "Release wake lock.");
                    b.release();
                    b = null;
                } else {
                    EasyLog.i("Locker", "Lock was release already.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
